package stepos.app;

import android.app.IWallpaperManager;
import android.app.IWallpaperManagerCallback;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.IntentExt;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import stepos.app.IStepOSWallpaperManager;

/* loaded from: classes.dex */
public class StepOSWallpaperManager {
    public static final String STEPOS_LIGHT = "stepos_light";
    private static final String TAG = "StepOSWallpaperManager";
    public static final String WALLPAPER_EXT_SERVICE = "wallpaper_ext";
    private static IStepOSWallpaperManager mService;
    private static StepOSWallpaperManager sInstance;

    public static StepOSWallpaperManager getInstance() {
        StepOSWallpaperManager stepOSWallpaperManager;
        synchronized (StepOSWallpaperManager.class) {
            if (sInstance == null) {
                sInstance = new StepOSWallpaperManager();
            }
            stepOSWallpaperManager = sInstance;
        }
        return stepOSWallpaperManager;
    }

    private StepOSWallpaperManager() {
        IBinder b = ServiceManager.getService(WALLPAPER_EXT_SERVICE);
        if (b != null) {
            mService = IStepOSWallpaperManager.Stub.asInterface(b);
        }
    }

    public IStepOSWallpaperManager getService() {
        return mService;
    }

    public ParcelFileDescriptor getStepOSNightModeLauncherWallpaperFD() {
        if (mService == null) {
            Slog.w(TAG, "WallpaperExtService not running");
            return null;
        }
        try {
            return mService.getStepOSNightModeLauncherWallpaperFD();
        } catch (RemoteException e) {
            Slog.w(TAG, "getStepOSNightModeLauncherWallpaperFD failed", e);
            return null;
        }
    }

    public ParcelFileDescriptor getStepOSNightModeLockWallpaperFD() {
        if (mService == null) {
            Slog.w(TAG, "WallpaperExtService not running");
            return null;
        }
        try {
            return mService.getStepOSNightModeLockWallpaperFD();
        } catch (RemoteException e) {
            Slog.w(TAG, "getStepOSNightModeLockWallpaperFD failed", e);
            return null;
        }
    }

    public void createNightModeLauncherWallpaper(InputStream inputStream) throws IOException {
        if (mService == null) {
            Slog.w(TAG, "WallpaperExtService not running");
        } else {
            ParcelFileDescriptor fd = getStepOSNightModeLauncherWallpaperFD();
            createNightModeWallpaper(inputStream, fd);
        }
    }

    public void createNightModeLockWallpaper(InputStream inputStream) throws IOException {
        if (mService == null) {
            Slog.w(TAG, "WallpaperExtService not running");
        } else {
            ParcelFileDescriptor fd = getStepOSNightModeLockWallpaperFD();
            createNightModeWallpaper(inputStream, fd);
        }
    }

    private void createNightModeWallpaper(InputStream inputStream, ParcelFileDescriptor fd) throws IOException {
        if (fd == null) {
            return;
        }
        FileOutputStream fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
        try {
            writeWallpaperStream(inputStream, fos);
            fos.close();
        } catch (Throwable th) {
            try {
                fos.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void writeWallpaperStream(InputStream data, FileOutputStream fos) throws IOException {
        byte[] buffer = new byte[IntentExt.STEPOS_FLAG_WM_SPECIAL_SIZE];
        while (true) {
            int amt = data.read(buffer);
            if (amt > 0) {
                fos.write(buffer, 0, amt);
            } else {
                return;
            }
        }
    }

    public int getStepOSNightModeWallpaperStatus() {
        if (mService == null) {
            Slog.w(TAG, "WallpaperExtService not running");
            return 0;
        }
        try {
            return mService.getStepOSNightModeWallpaperStatus();
        } catch (RemoteException e) {
            Slog.w(TAG, "getStepOSNightModeWallpaperStatus failed", e);
            return -1;
        }
    }

    public void onStepOSLockWallpaperReady() {
        if (mService == null) {
            Slog.w(TAG, "WallpaperExtService not running");
            return;
        }
        try {
            mService.onStepOSLockWallpaperReady();
        } catch (RemoteException e) {
            Slog.w(TAG, "onStepOSLockWallpaperReady failed", e);
        }
    }

    public void forgetLoadedLockWallpaper(Context context) {
        WallpaperManager wm = WallpaperManager.getInstance(context);
        wm.forgetLoadedLockWallpaper();
    }

    public Drawable getLockDrawable(Context context) {
        WallpaperManager wm = WallpaperManager.getInstance(context);
        return wm.getDrawable(2);
    }

    public Drawable getFastLockDrawable(Context context) {
        WallpaperManager wm = WallpaperManager.getInstance(context);
        return wm.getFastDrawable(2);
    }

    public Bitmap getLockBitmapAsUser(Context context, int userId, boolean hardware) {
        WallpaperManager wm = WallpaperManager.getInstance(context);
        return wm.getBitmapAsUser(userId, hardware, 2);
    }

    public Bitmap getLockBitmap(Context context) {
        WallpaperManager wm = WallpaperManager.getInstance(context);
        return wm.getBitmapAsUser(context.getUserId(), false, 2);
    }

    public int setLockBitmap(Context context, Bitmap bitmap) throws IOException {
        WallpaperManager wm = WallpaperManager.getInstance(context);
        return wm.setBitmap(bitmap, null, true, 2);
    }

    public void setLockStream(Context context, InputStream bitmapData) throws IOException {
        WallpaperManager wm = WallpaperManager.getInstance(context);
        wm.setStream(bitmapData, null, true, 2);
    }

    public Bitmap getLightBitmap(Context context, int which) {
        return fetchLightWallpaperBitmap(context, which);
    }

    private Bitmap fetchLightWallpaperBitmap(Context context, int which) throws IOException {
        Throwable e;
        Bundle params;
        IBinder b = ServiceManager.getService("wallpaper");
        if (b == null) {
            Slog.w(TAG, "fetchLightWallpaperBitmap: wallpaper service not available");
            return null;
        }
        IWallpaperManager service = IWallpaperManager.Stub.asInterface(b);
        try {
            params = new Bundle();
            params.putBoolean(STEPOS_LIGHT, true);
        } catch (RemoteException | IOException | OutOfMemoryError e2) {
            e = e2;
        }
        try {
            ParcelFileDescriptor pfd = service.getWallpaperWithFeature(context.getOpPackageName(), context.getAttributionTag(), (IWallpaperManagerCallback) null, which, params, context.getUserId(), true);
            if (pfd == null) {
                return null;
            }
            InputStream is = new ParcelFileDescriptor.AutoCloseInputStream(pfd);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(is);
                is.close();
                return bitmapDecodeStream;
            } finally {
            }
        } catch (RemoteException | IOException | OutOfMemoryError e3) {
            e = e3;
            Slog.w(TAG, "fetchLightWallpaperBitmap failed", e);
            return null;
        }
    }
}
