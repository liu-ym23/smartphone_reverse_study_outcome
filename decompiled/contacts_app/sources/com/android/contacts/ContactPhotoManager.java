package com.android.contacts;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactPhotoManager implements ComponentCallbacks2 {
    public static final String CONTACT_PHOTO_SERVICE = "contactPhotos";
    static final boolean DEBUG = false;
    public static final DefaultImageProvider DEFAULT_AVATER = null;
    public static final DefaultImageProvider DEFAULT_BLANK = null;
    static final String TAG = "ContactPhotoManager";
    private static ContactPhotoManager mContactPhotoManager;

    /* JADX INFO: renamed from: com.android.contacts.ContactPhotoManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AvatarDefaultImageProvider extends DefaultImageProvider {
        private AvatarDefaultImageProvider() {
        }

        /* synthetic */ AvatarDefaultImageProvider(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.ContactPhotoManager.DefaultImageProvider
        public void applyDefaultImage(ImageView r1, boolean r2, boolean r3) {
            r1.setImageResource(ContactPhotoManager.getDefaultAvatarResId(r2, r3));
        }
    }

    private static class BlankDefaultImageProvider extends DefaultImageProvider {
        private static Drawable sDrawable;

        private BlankDefaultImageProvider() {
        }

        /* synthetic */ BlankDefaultImageProvider(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.ContactPhotoManager.DefaultImageProvider
        public void applyDefaultImage(ImageView r1, boolean r2, boolean r3) {
            if (sDrawable != null) goto L5;
            sDrawable = new ColorDrawable(r1.getContext().getResources().getColor(R.color.image_placeholder));
        L5:
            r1.setImageDrawable(sDrawable);
        }
    }

    public static abstract class DefaultImageProvider {
        public abstract void applyDefaultImage(ImageView r1, boolean r2, boolean r3);

        public DefaultImageProvider() {
        }
    }

    public static int getDefaultAvatarResId(boolean r0, boolean r1) {
        return R.drawable.photo_default_in_detail;
    }

    public abstract void loadPhoto(ImageView r1, long r2, boolean r4, boolean r5, DefaultImageProvider r6);

    public abstract void loadPhoto(ImageView r1, Uri r2, boolean r3, boolean r4, DefaultImageProvider r5);

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
    }

    public abstract void pause();

    public abstract void preloadPhotosInBackground();

    public abstract void refreshCache();

    public abstract void removePhoto(ImageView r1);

    public abstract void resume();

    public ContactPhotoManager() {
    }

    static {
        AnonymousClass1 r1 = null;
        DEFAULT_AVATER = new AvatarDefaultImageProvider(r1);
        DEFAULT_BLANK = new BlankDefaultImageProvider(r1);
        mContactPhotoManager = null;
    }

    public static ContactPhotoManager getInstance(Context r1) {
        if (mContactPhotoManager != null) goto L6;
        mContactPhotoManager = new ContactPhotoManagerImpl(r1.getApplicationContext());
    L6:
        return mContactPhotoManager;
    }

    public final void loadPhoto(ImageView r8, long r9, boolean r11, boolean r12) {
        loadPhoto(r8, r9, r11, r12, DEFAULT_AVATER);
    }

    public final void loadPhoto(ImageView r7, Uri r8, boolean r9, boolean r10) {
        loadPhoto(r7, r8, r9, r10, DEFAULT_AVATER);
    }
}
