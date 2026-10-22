package com.android.contacts.common;

import android.accounts.Account;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.GlobalProxyLancet;
import com.android.contacts.common.lettertiles.LetterTileDrawable;
import com.android.contacts.common.util.PermissionsUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactPhotoManager implements ComponentCallbacks2 {
    private static final String CONTACT_TYPE_PARAM_KEY = "contact_type";
    static final boolean DEBUG = false;
    static final boolean DEBUG_SIZES = false;
    public static DefaultImageProvider DEFAULT_AVATAR = null;
    public static final DefaultImageProvider DEFAULT_BLANK = null;
    private static final Uri DEFAULT_IMAGE_URI = null;
    private static final String DEFAULT_IMAGE_URI_SCHEME = "defaultimage";
    private static final String DISPLAY_NAME_PARAM_KEY = "display_name";
    private static final String IDENTIFIER_PARAM_KEY = "identifier";
    public static final boolean IS_CIRCULAR_DEFAULT = false;
    private static final String IS_CIRCULAR_PARAM_KEY = "is_circular";
    public static final float OFFSET_DEFAULT = 0.0f;
    private static final String OFFSET_PARAM_KEY = "offset";
    public static final float SCALE_DEFAULT = 1.0f;
    private static final String SCALE_PARAM_KEY = "scale";
    static final String TAG = "ContactPhotoManager";
    public static final int TYPE_BUSINESS = 2;
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_PERSON = 1;
    public static final int TYPE_VOICEMAIL = 3;
    private static int s180DipInPixel;
    private static Drawable sDefaultLetterAvatar;
    private static ContactPhotoManager sInstance;

    /* JADX INFO: renamed from: com.android.contacts.common.ContactPhotoManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BlankDefaultImageProvider extends DefaultImageProvider {
        private static Drawable sDrawable;

        private BlankDefaultImageProvider() {
        }

        /* synthetic */ BlankDefaultImageProvider(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.common.ContactPhotoManager.DefaultImageProvider
        public void applyDefaultImage(ImageView r1, int r2, boolean r3, DefaultImageRequest r4) {
            if (sDrawable != null) goto L5;
            sDrawable = new ColorDrawable(r1.getContext().getResources().getColor(R.color.image_placeholder));
        L5:
            r1.setImageDrawable(sDrawable);
        }
    }

    public static abstract class DefaultImageProvider {
        public abstract void applyDefaultImage(ImageView r1, int r2, boolean r3, DefaultImageRequest r4);

        public void applyDefaultImage(ImageView r1, Account r2, int r3, boolean r4, DefaultImageRequest r5) {
        }

        public DefaultImageProvider() {
        }
    }

    public static class DefaultImageRequest {
        public static DefaultImageRequest EMPTY_CIRCULAR_BUSINESS_IMAGE_REQUEST;
        public static DefaultImageRequest EMPTY_CIRCULAR_DEFAULT_IMAGE_REQUEST;
        public static DefaultImageRequest EMPTY_DEFAULT_BUSINESS_IMAGE_REQUEST;
        public static DefaultImageRequest EMPTY_DEFAULT_IMAGE_REQUEST;
        public int contactType;
        public String displayName;
        public String identifier;
        public boolean isCircular;
        public float offset;
        public float scale;

        static {
            EMPTY_DEFAULT_IMAGE_REQUEST = new DefaultImageRequest();
            EMPTY_DEFAULT_BUSINESS_IMAGE_REQUEST = new DefaultImageRequest(null, null, 2, false);
            EMPTY_CIRCULAR_DEFAULT_IMAGE_REQUEST = new DefaultImageRequest(null, null, true);
            EMPTY_CIRCULAR_BUSINESS_IMAGE_REQUEST = new DefaultImageRequest(null, null, 2, true);
        }

        public DefaultImageRequest() {
            this.contactType = 1;
            this.scale = 1.0f;
            this.offset = 0.0f;
            this.isCircular = false;
        }

        public DefaultImageRequest(String r8, String r9, boolean r10) {
            this(r8, r9, 1, 1.0f, 0.0f, r10);
        }

        public DefaultImageRequest(String r8, String r9, int r10, boolean r11) {
            this(r8, r9, r10, 1.0f, 0.0f, r11);
        }

        public DefaultImageRequest(String r1, String r2, int r3, float r4, float r5, boolean r6) {
            this.displayName = r1;
            this.identifier = r2;
            this.contactType = r3;
            this.scale = r4;
            this.offset = r5;
            this.isCircular = r6;
        }
    }

    private static class LetterTileDefaultImageProvider extends DefaultImageProvider {
        private LetterTileDefaultImageProvider() {
        }

        /* synthetic */ LetterTileDefaultImageProvider(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.common.ContactPhotoManager.DefaultImageProvider
        public void applyDefaultImage(ImageView r7, int r8, boolean r9, DefaultImageRequest r10) {
            applyDefaultImage(r7, null, r8, r9, r10);
        }

        @Override // com.android.contacts.common.ContactPhotoManager.DefaultImageProvider
        public void applyDefaultImage(ImageView r1, Account r2, int r3, boolean r4, DefaultImageRequest r5) {
            r1.setImageDrawable(getDefaultImageForContact(r1.getContext(), r1.getResources(), r5, r2));
        }

        public static Drawable getDefaultImageForContact(Context r1, Resources r2, DefaultImageRequest r3, Account r4) {
            LetterTileDrawable r0 = new LetterTileDrawable(r2, r1, r4);
            if (r3 != null) goto L5;
        L9:
            return r0;
        L5:
            if (TextUtils.isEmpty(r3.identifier) == false) goto L7;
            r0.setLetterAndColorFromContactDetails(null, r3.displayName);
        L8:
            r0.setContactType(r3.contactType);
            r0.setScale(r3.scale);
            r0.setOffset(r3.offset);
            r0.setIsCircular(r3.isCircular);
            goto L9
        L7:
            r0.setLetterAndColorFromContactDetails(r3.displayName, r3.identifier);
            goto L8
        }
    }

    public abstract void cacheBitmap(Uri r1, Bitmap r2, byte[] r3);

    public abstract void cancelPendingRequests(View r1);

    public abstract void clear();

    public abstract void loadPhoto(ImageView r1, Uri r2, Account r3, int r4, boolean r5, boolean r6, DefaultImageRequest r7, DefaultImageProvider r8);

    public abstract void loadThumbnail(ImageView r1, long r2, Account r4, boolean r5, boolean r6, DefaultImageRequest r7, DefaultImageProvider r8);

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
        DEFAULT_IMAGE_URI = Uri.parse("defaultimage://");
        AnonymousClass1 r0 = null;
        sDefaultLetterAvatar = null;
        s180DipInPixel = -1;
        DEFAULT_AVATAR = new LetterTileDefaultImageProvider(r0);
        DEFAULT_BLANK = new BlankDefaultImageProvider(r0);
    }

    public static int getDefaultAvatarResId(Context r3, int r4, boolean r5) {
        boolean r1 = true;
        if (s180DipInPixel != (-1)) goto L5;
        s180DipInPixel = (int) TypedValue.applyDimension(1, 180.0f, r3.getResources().getDisplayMetrics());
    L5:
        if (r4 != (-1)) goto L7;
    L9:
        r1 = false;
    L11:
        return getDefaultAvatarResId(r1, r5);
    L7:
        if (r4 <= s180DipInPixel) goto L9;
        goto L9
    }

    public static int getDefaultAvatarResId(boolean r0, boolean r1) {
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return R.drawable.ic_contact_picture_180_holo_dark;
    L6:
        if (r0 == true) goto L8;
        if (r1 == false) goto L13;
        return R.drawable.ic_contact_picture_holo_dark;
    L13:
        return R.drawable.ic_contact_picture_holo_light;
    L8:
        return R.drawable.ic_contact_picture_180_holo_light;
    }

    public static Drawable getDefaultAvatarDrawableForContact(Resources r1, boolean r2, DefaultImageRequest r3) {
        return getDefaultAvatarDrawableForContact(null, r1, r2, r3, null);
    }

    public static Drawable getDefaultAvatarDrawableForContact(Context r0, Resources r1, boolean r2, DefaultImageRequest r3, Account r4) {
        if (r3 != null) goto L9;
        if (sDefaultLetterAvatar != null) goto L7;
        sDefaultLetterAvatar = LetterTileDefaultImageProvider.getDefaultImageForContact(r0, r1, null, r4);
    L7:
        return sDefaultLetterAvatar;
    L9:
        return LetterTileDefaultImageProvider.getDefaultImageForContact(r0, r1, r3, r4);
    }

    public static Uri getDefaultAvatarUriForContact(DefaultImageRequest r3) {
        Uri.Builder r0 = DEFAULT_IMAGE_URI.buildUpon();
        if (r3 == null) goto L23;
        if (TextUtils.isEmpty(r3.displayName) == true) goto L8;
        r0.appendQueryParameter(DISPLAY_NAME_PARAM_KEY, r3.displayName);
    L8:
        if (TextUtils.isEmpty(r3.identifier) == true) goto L11;
        r0.appendQueryParameter("identifier", r3.identifier);
    L11:
        if (r3.contactType == 1) goto L14;
        r0.appendQueryParameter(CONTACT_TYPE_PARAM_KEY, String.valueOf(r3.contactType));
    L14:
        if (r3.scale == 1.0f) goto L17;
        r0.appendQueryParameter(SCALE_PARAM_KEY, String.valueOf(r3.scale));
    L17:
        if (r3.offset == 0.0f) goto L20;
        r0.appendQueryParameter("offset", String.valueOf(r3.offset));
    L20:
        if (r3.isCircular == false) goto L23;
        r0.appendQueryParameter(IS_CIRCULAR_PARAM_KEY, String.valueOf(r3.isCircular));
    L23:
        return r0.build();
    }

    public static String appendBusinessContactType(String r1) {
        Uri.Builder r2 = Uri.parse(r1).buildUpon();
        r2.encodedFragment(String.valueOf(2));
        return r2.build().toString();
    }

    public static Uri removeContactType(Uri r1) {
        if (TextUtils.isEmpty(r1.getEncodedFragment()) == true) goto L6;
        Uri.Builder r2 = r1.buildUpon();
        r2.encodedFragment(null);
        return r2.build();
    L6:
        return r1;
    }

    public static boolean isBusinessContactUri(Uri r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        String r3 = r2.getEncodedFragment();
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r3.equals(String.valueOf(2)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    protected static DefaultImageRequest getDefaultImageRequestFromUri(Uri r4) {
        DefaultImageRequest r0 = new DefaultImageRequest(r4.getQueryParameter(DISPLAY_NAME_PARAM_KEY), r4.getQueryParameter("identifier"), false);
        String r1 = r4.getQueryParameter(CONTACT_TYPE_PARAM_KEY);     // Catch: NumberFormatException -> L16
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r0.contactType = Integer.valueOf(r1).intValue();     // Catch: NumberFormatException -> L16
    L6:
        String r2 = r4.getQueryParameter(SCALE_PARAM_KEY);     // Catch: NumberFormatException -> L16
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r0.scale = Float.valueOf(r2).floatValue();     // Catch: NumberFormatException -> L16
    L9:
        String r3 = r4.getQueryParameter("offset");     // Catch: NumberFormatException -> L16
        if (TextUtils.isEmpty(r3) == true) goto L12;
        r0.offset = Float.valueOf(r3).floatValue();     // Catch: NumberFormatException -> L16
    L12:
        String r5 = r4.getQueryParameter(IS_CIRCULAR_PARAM_KEY);     // Catch: NumberFormatException -> L16
        if (TextUtils.isEmpty(r5) == true) goto L17;
        r0.isCircular = Boolean.valueOf(r5).booleanValue();     // Catch: NumberFormatException -> L16
    L17:
        return r0;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Invalid DefaultImageRequest image parameters provided, ignoring and using defaults.");
        goto L17
    }

    protected boolean isDefaultImageUri(Uri r1) {
        return DEFAULT_IMAGE_URI_SCHEME.equals(r1.getScheme());
    }

    public static ContactPhotoManager getInstance(Context r2) {
        if (sInstance != null) goto L8;
        Context r0 = r2.getApplicationContext();
        ContactPhotoManager r1 = createContactPhotoManager(r0);
        sInstance = r1;
        r0.registerComponentCallbacks(r1);
        if (PermissionsUtil.hasContactsPermissions(r2) == false) goto L8;
        sInstance.preloadPhotosInBackground();
    L8:
        return sInstance;
    }

    public static synchronized ContactPhotoManager createContactPhotoManager(Context r2) {
        monitor-enter(ContactPhotoManager.class);
        ContactPhotoManagerImpl r1 = new ContactPhotoManagerImpl(r2);     // Catch: Throwable -> L7
        monitor-exit(ContactPhotoManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void injectContactPhotoManagerForTesting(ContactPhotoManager r0) {
        sInstance = r0;
    }

    public final void loadThumbnail(ImageView r10, long r11, Account r13, boolean r14, boolean r15, DefaultImageRequest r16) {
        loadThumbnail(r10, r11, r13, r14, r15, r16, DEFAULT_AVATAR);
    }

    public final void loadThumbnail(ImageView r10, long r11, boolean r13, boolean r14, DefaultImageRequest r15) {
        loadThumbnail(r10, r11, null, r13, r14, r15, DEFAULT_AVATAR);
    }

    public final void loadThumbnail(ImageView r10, long r11, boolean r13, boolean r14, DefaultImageRequest r15, DefaultImageProvider r16) {
        loadThumbnail(r10, r11, null, r13, r14, r15, r16);
    }

    public final void loadThumbnail(ImageView r8, long r9, boolean r11) {
        loadThumbnail(r8, r9, r11, false, null);
    }

    public final void loadPhoto(ImageView r10, Uri r11, Account r12, int r13, boolean r14, boolean r15, DefaultImageRequest r16) {
        loadPhoto(r10, r11, r12, r13, r14, r15, r16, DEFAULT_AVATAR);
    }

    public final void loadPhoto(ImageView r10, Uri r11, int r12, boolean r13, boolean r14, DefaultImageRequest r15) {
        loadPhoto(r10, r11, null, r12, r13, r14, r15, DEFAULT_AVATAR);
    }

    public final void loadPhoto(ImageView r10, Uri r11, int r12, boolean r13, boolean r14, DefaultImageRequest r15, DefaultImageProvider r16) {
        loadPhoto(r10, r11, null, r12, r13, r14, r15, r16);
    }

    public final void loadDirectoryPhoto(ImageView r10, Uri r11, Account r12, boolean r13, boolean r14, DefaultImageRequest r15) {
        loadPhoto(r10, r11, r12, -1, r13, r14, r15, DEFAULT_AVATAR);
    }

    public final void loadDirectoryPhoto(ImageView r10, Uri r11, boolean r12, boolean r13, DefaultImageRequest r14) {
        loadPhoto(r10, r11, null, -1, r12, r13, r14, DEFAULT_AVATAR);
    }
}
