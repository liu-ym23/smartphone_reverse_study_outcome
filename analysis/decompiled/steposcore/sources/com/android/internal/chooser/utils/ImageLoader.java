package com.android.internal.chooser.utils;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.stepostheme.StepOSThemeHelper;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.chooser.AppInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ImageLoader {
    private static ImageLoader sInstance;
    private ImageLoaderListener mImageLoaderListener = new ImageLoaderListener() { // from class: com.android.internal.chooser.utils.ImageLoader.1
        @Override // com.android.internal.chooser.utils.ImageLoader.ImageLoaderListener
        public void onLoadSuccess(DisplayResolveInfo displayResolveInfo, List<WeakReference<ImageView>> attachViews, Drawable drawable) {
            displayResolveInfo.displayIcon = drawable;
            ImageLoader.this.mTasks.remove(displayResolveInfo);
            for (WeakReference<ImageView> weakReference : attachViews) {
                ImageView imageView = weakReference.get();
                if (imageView != null && displayResolveInfo.equals(imageView.getTag())) {
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        @Override // com.android.internal.chooser.utils.ImageLoader.ImageLoaderListener
        public void onLoadFailure(DisplayResolveInfo displayResolveInfo, List<WeakReference<ImageView>> attachViews, Exception e) {
            ImageLoader.this.mTasks.remove(displayResolveInfo);
        }
    };
    private Map<DisplayResolveInfo, DrawableCallable> mTasks = new HashMap();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    interface ImageLoaderListener {
        void onLoadFailure(DisplayResolveInfo displayResolveInfo, List<WeakReference<ImageView>> list, Exception exc);

        void onLoadSuccess(DisplayResolveInfo displayResolveInfo, List<WeakReference<ImageView>> list, Drawable drawable);
    }

    public static ImageLoader getInstance() {
        synchronized (ImageLoader.class) {
            if (sInstance == null) {
                sInstance = new ImageLoader();
            }
        }
        return sInstance;
    }

    private ImageLoader() {
    }

    public void load(ImageView imageView, DisplayResolveInfo displayResolveInfo, int iconDpi, PackageManager packageManager, Resources resources) {
        if (displayResolveInfo.displayIcon != null) {
            imageView.setImageDrawable(displayResolveInfo.displayIcon);
            return;
        }
        if (displayResolveInfo.resolveInfo == null) {
            return;
        }
        imageView.setTag(displayResolveInfo);
        DrawableCallable callable = this.mTasks.get(displayResolveInfo);
        if (callable == null) {
            DrawableCallable callable2 = new DrawableCallable(this.mMainHandler, this.mImageLoaderListener, displayResolveInfo, iconDpi, packageManager, resources);
            Executor.getInstance().submit(callable2);
            callable2.attach(imageView);
            this.mTasks.put(displayResolveInfo, callable2);
            return;
        }
        callable.attach(imageView);
    }

    private static class DrawableCallable implements Runnable {
        private List<WeakReference<ImageView>> mAttachViews = new ArrayList();
        private DisplayResolveInfo mDisplayResolveInfo;
        private int mIconDpi;
        private ImageLoaderListener mLoaderListener;
        private Handler mMainHandler;
        private PackageManager mPackageManager;
        private Resources mResources;

        public DrawableCallable(Handler handler, ImageLoaderListener loaderListener, DisplayResolveInfo resolveInfo, int iconDpi, PackageManager packageManager, Resources resources) {
            this.mMainHandler = handler;
            this.mLoaderListener = loaderListener;
            this.mDisplayResolveInfo = resolveInfo;
            this.mIconDpi = iconDpi;
            this.mPackageManager = packageManager;
            this.mResources = resources;
        }

        void attach(ImageView imageView) {
            this.mAttachViews.add(new WeakReference<>(imageView));
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            final Drawable displayIcon = loadIconForResolveInfo(this.mPackageManager, this.mDisplayResolveInfo.resolveInfo, this.mIconDpi);
            if (displayIcon == null) {
                this.mMainHandler.post(new Runnable() { // from class: com.android.internal.chooser.utils.ImageLoader.DrawableCallable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableCallable.this.mLoaderListener.onLoadFailure(DrawableCallable.this.mDisplayResolveInfo, DrawableCallable.this.mAttachViews, new Exception("displayIcon == null"));
                    }
                });
            } else {
                this.mMainHandler.post(new Runnable() { // from class: com.android.internal.chooser.utils.ImageLoader.DrawableCallable.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableCallable.this.mLoaderListener.onLoadSuccess(DrawableCallable.this.mDisplayResolveInfo, DrawableCallable.this.mAttachViews, displayIcon);
                    }
                });
            }
        }

        private Drawable loadIconForResolveInfo(PackageManager packageManager, ResolveInfo ri, int dpi) throws Resources.NotFoundException {
            int drawableRes = AppInfo.getAppIcon(ri);
            if (drawableRes != 0) {
                return this.mResources.getDrawable(drawableRes);
            }
            Drawable dr = ri.loadIcon(packageManager);
            if (dr == null) {
                try {
                    if (ri.resolvePackageName != null && ri.icon != 0) {
                        dr = getIcon(packageManager.getResourcesForApplication(ri.resolvePackageName), ri.icon, dpi);
                    }
                    int iconRes = ri.getIconResource();
                    if (iconRes != 0 && dr == null) {
                        dr = getIcon(packageManager.getResourcesForApplication(ri.activityInfo.packageName), iconRes, dpi);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                }
            }
            if (dr != null) {
                return StepOSThemeHelper.makeStandardStyleIconInChooser(this.mResources, dr);
            }
            return dr;
        }

        private Drawable getIcon(Resources res, int resId, int dpi) throws Resources.NotFoundException {
            try {
                Drawable result = res.getDrawableForDensity(resId, dpi);
                return result;
            } catch (Resources.NotFoundException e) {
                return null;
            }
        }
    }
}
