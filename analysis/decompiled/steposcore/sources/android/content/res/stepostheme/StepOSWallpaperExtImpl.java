package android.content.res.stepostheme;

import android.app.ActivityThread;
import android.app.Application;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.HardwareRenderer;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.StepOSDateTimeUrlHelper;
import com.stepos.theme.IStepOSThemeService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StepOSWallpaperExtImpl implements IStepOSWallpaperExt {
    private static final String STEPOS_THEME_SERVICE = "stepos_theme";
    private static final String TAG = "StepOSWallpaper";
    private static final String THEME_WALLPAPER_HOME = "wallpaper.jpg";
    private static final String THEME_WALLPAPER_HOME_PNG = "wallpaper.png";
    private static final String THEME_WALLPAPER_LOCK = "lockscreen_wallpaper.jpg";
    private static final String THEME_WALLPAPER_LOCK_PNG = "lockscreen_wallpaper.png";
    private boolean mIsScheduled = false;
    private long mNextChangeTime = -1;
    private String mScheduledIntent;
    private String mScheduledType;

    public Drawable getThemeWallpaper(int type) throws IOException {
        Bitmap bitmap = getThemeWallpaperBitmap(type);
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable((Resources) null, bitmap);
    }

    public Bitmap getThemeWallpaperBitmap(int type) throws IOException {
        String path = getThemeWallpaperPath(type);
        if (path == null) {
            return null;
        }
        try {
            File file = new File(path);
            if (file.exists()) {
                InputStream is = new FileInputStream(file);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                is.close();
                return bitmap;
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to load wallpaper: " + e.getMessage());
        }
        return null;
    }

    public boolean hasThemeWallpaper(int type) {
        String path = getThemeWallpaperPath(type);
        if (path == null) {
            return false;
        }
        return new File(path).exists();
    }

    public String getThemeWallpaperPath(int type) {
        String wallpaperName;
        String themePath = IStepOSThemeUtilsExt.get().getThemePath();
        if (themePath == null || themePath.isEmpty()) {
            return null;
        }
        switch (type) {
            case 1:
                wallpaperName = THEME_WALLPAPER_HOME;
                break;
            case 2:
                wallpaperName = THEME_WALLPAPER_LOCK;
                break;
            default:
                wallpaperName = THEME_WALLPAPER_HOME;
                break;
        }
        String path = themePath + StepOSDateTimeUrlHelper.BACKSLASH_STRING + wallpaperName;
        if (new File(path).exists()) {
            return path;
        }
        String pngName = wallpaperName.replace(".jpg", ".png");
        String path2 = themePath + StepOSDateTimeUrlHelper.BACKSLASH_STRING + pngName;
        if (!new File(path2).exists()) {
            return null;
        }
        return path2;
    }

    public void createScheduledWallpaperChange(String intentName, String changeType, long triggerTime) {
        IStepOSThemeService service = getThemeService();
        if (service == null) {
            Log.w(TAG, "createScheduledWallpaperChange: theme service unavailable, skipping");
            return;
        }
        try {
            service.createChangeWallpaper(intentName, changeType, triggerTime);
            this.mScheduledIntent = intentName;
            this.mScheduledType = changeType;
            this.mNextChangeTime = triggerTime;
            this.mIsScheduled = true;
            StepOSLogUtil.d("Scheduled wallpaper change: " + intentName + " at " + triggerTime);
        } catch (RemoteException e) {
            Log.w(TAG, "createChangeWallpaper RPC failed, local state not updated: " + e.getMessage());
        }
    }

    public void cancelScheduledWallpaperChange() {
        IStepOSThemeService service = getThemeService();
        if (service == null) {
            Log.w(TAG, "cancelScheduledWallpaperChange: theme service unavailable, skipping");
            return;
        }
        try {
            service.cancelChangeWallpaper();
            this.mIsScheduled = false;
            this.mNextChangeTime = -1L;
            this.mScheduledIntent = null;
            this.mScheduledType = null;
            StepOSLogUtil.d("Cancelled scheduled wallpaper change");
        } catch (RemoteException e) {
            Log.w(TAG, "cancelChangeWallpaper RPC failed, local state not updated: " + e.getMessage());
        }
    }

    public boolean isWallpaperChangeScheduled() {
        return this.mIsScheduled && this.mNextChangeTime > System.currentTimeMillis();
    }

    public long getNextScheduledChangeTime() {
        if (this.mIsScheduled) {
            return this.mNextChangeTime;
        }
        return -1L;
    }

    public boolean isLiveWallpaperSupported() {
        return true;
    }

    public String getCurrentLiveWallpaperPackage() {
        WallpaperInfo info;
        Application app = ActivityThread.currentApplication();
        if (app == null) {
            return null;
        }
        try {
            WallpaperManager wm = (WallpaperManager) app.getSystemService(WallpaperManager.class);
            if (wm == null || (info = wm.getWallpaperInfo()) == null) {
                return null;
            }
            return info.getPackageName();
        } catch (Exception e) {
            Log.w(TAG, "getCurrentLiveWallpaperPackage failed: " + e.getMessage());
            return null;
        }
    }

    public Bitmap applyBlurEffect(Bitmap bitmap, float radius) {
        if (bitmap == null) {
            return null;
        }
        Bitmap blurred = applyBlurWithRenderEffect(bitmap, Math.max(1.0f, Math.min(25.0f, radius)));
        return blurred != null ? blurred : bitmap;
    }

    private Bitmap applyBlurWithRenderEffect(Bitmap bitmap, float radius) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ImageReader reader = null;
        HardwareRenderer renderer = null;
        try {
            reader = ImageReader.newInstance(width, height, 1, 1, 768L);
            RenderNode node = new RenderNode("StepOSWallpaperBlur");
            node.setPosition(0, 0, width, height);
            RecordingCanvas canvas = node.beginRecording();
            try {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                node.endRecording();
                node.setRenderEffect(RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP));
                renderer = new HardwareRenderer();
                renderer.setSurface(reader.getSurface());
                renderer.setContentRoot(node);
                renderer.createRenderRequest().setWaitForPresent(true).syncAndDraw();
                Image image = reader.acquireNextImage();
                if (image == null) {
                    renderer.destroy();
                    if (reader != null) {
                        reader.close();
                    }
                    return null;
                }
                try {
                    HardwareBuffer hb = image.getHardwareBuffer();
                    if (hb == null) {
                        renderer.destroy();
                        if (reader != null) {
                            reader.close();
                        }
                        return null;
                    }
                    try {
                        Bitmap hwBitmap = Bitmap.wrapHardwareBuffer(hb, ColorSpace.get(ColorSpace.Named.SRGB));
                        if (hwBitmap == null) {
                            renderer.destroy();
                            if (reader != null) {
                                reader.close();
                            }
                            return null;
                        }
                        Bitmap bitmapCopy = hwBitmap.copy(Bitmap.Config.ARGB_8888, false);
                        renderer.destroy();
                        if (reader != null) {
                            reader.close();
                        }
                        return bitmapCopy;
                    } finally {
                        hb.close();
                    }
                } finally {
                    image.close();
                }
            } catch (Throwable th) {
                node.endRecording();
                throw th;
            }
        } catch (Throwable t) {
            try {
                Log.w(TAG, "RenderEffect blur fallback: " + t.getMessage());
                return null;
            } finally {
                if (renderer != null) {
                    renderer.destroy();
                }
                if (reader != null) {
                    reader.close();
                }
            }
        }
    }

    public Bitmap applyDimEffect(Bitmap bitmap, float dimLevel) {
        if (bitmap == null) {
            return null;
        }
        float dimLevel2 = Math.max(0.0f, Math.min(1.0f, dimLevel));
        try {
            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            Paint dimPaint = new Paint();
            int alpha = (int) (255.0f * dimLevel2);
            dimPaint.setColor(Color.argb(alpha, 0, 0, 0));
            canvas.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), dimPaint);
            return output;
        } catch (Exception e) {
            Log.w(TAG, "Failed to apply dim: " + e.getMessage());
            return bitmap;
        }
    }

    private static IStepOSThemeService getThemeService() {
        IBinder binder = ServiceManager.getService("stepos_theme");
        if (binder != null) {
            return IStepOSThemeService.Stub.asInterface(binder);
        }
        return null;
    }
}
