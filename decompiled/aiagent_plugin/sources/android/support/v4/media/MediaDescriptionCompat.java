package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = null;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f62a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f63b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f64c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f65d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f66e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public a() {
        }

        public a a(String r1) {
            this.f62a = r1;
            return this;
        }

        public a a(CharSequence r3) {
            this.f63b = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a b(CharSequence r3) {
            this.f64c = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a c(CharSequence r3) {
            this.f65d = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(Bitmap r1) {
            this.f66e = r1;
            return this;
        }

        public a a(Uri r1) {
            this.f = r1;
            return this;
        }

        public a a(Bundle r1) {
            this.g = r1;
            return this;
        }

        public a b(Uri r1) {
            this.h = r1;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f62a, this.f63b, this.f64c, this.f65d, this.f66e, this.f, this.g, this.h);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String r3, CharSequence r4, CharSequence r5, CharSequence r6, Bitmap r7, Uri r8, Bundle r9, Uri r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        this.mMediaId = r3;
        this.mTitle = r11;
        this.mSubtitle = r12;
        this.mDescription = r13;
        this.mIcon = r7;
        this.mIconUri = r8;
        this.mExtras = r9;
        this.mMediaUri = r10;
    }

    MediaDescriptionCompat(Parcel r5) {
        this.mMediaId = r5.readString();
        this.mTitle = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r5), CharSequence.class, "com.obric.aiagent.plugin");
        this.mSubtitle = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r5), CharSequence.class, "com.obric.aiagent.plugin");
        this.mDescription = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r5), CharSequence.class, "com.obric.aiagent.plugin");
        ClassLoader r0 = getClass().getClassLoader();
        this.mIcon = (Bitmap) ZeusTransformUtils.preCheckCast(r5.readParcelable(r0), Bitmap.class, "com.obric.aiagent.plugin");
        this.mIconUri = (Uri) ZeusTransformUtils.preCheckCast(r5.readParcelable(r0), Uri.class, "com.obric.aiagent.plugin");
        this.mExtras = r5.readBundle(r0);
        this.mMediaUri = (Uri) ZeusTransformUtils.preCheckCast(r5.readParcelable(r0), Uri.class, "com.obric.aiagent.plugin");
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        r3.writeString(this.mMediaId);
        TextUtils.writeToParcel(this.mTitle, r3, r4);
        TextUtils.writeToParcel(this.mSubtitle, r3, r4);
        TextUtils.writeToParcel(this.mDescription, r3, r4);
        r3.writeParcelable(this.mIcon, r4);
        r3.writeParcelable(this.mIconUri, r4);
        r3.writeBundle(this.mExtras);
        r3.writeParcelable(this.mMediaUri, r4);
        return;
    L5:
        android.support.v4.media.a.a(getMediaDescription(), r3, r4);
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    public Object getMediaDescription() {
        if (this.mDescriptionObj != null) goto L20;
        if (Build.VERSION.SDK_INT < 21) goto L20;
        Object r0 = android.support.v4.media.a.C0000a.a();
        android.support.v4.media.a.C0000a.a(r0, this.mMediaId);
        android.support.v4.media.a.C0000a.a(r0, this.mTitle);
        android.support.v4.media.a.C0000a.b(r0, this.mSubtitle);
        android.support.v4.media.a.C0000a.c(r0, this.mDescription);
        android.support.v4.media.a.C0000a.a(r0, this.mIcon);
        android.support.v4.media.a.C0000a.a(r0, this.mIconUri);
        Bundle r1 = this.mExtras;
        if (Build.VERSION.SDK_INT < 23) goto L10;
    L14:
        android.support.v4.media.a.C0000a.a(r0, r1);
        if (Build.VERSION.SDK_INT < 23) goto L17;
        b.a.a(r0, this.mMediaUri);
    L17:
        Object r2 = android.support.v4.media.a.C0000a.a(r0);
        this.mDescriptionObj = r2;
        return r2;
    L10:
        if (this.mMediaUri == null) goto L14;
        if (r1 != null) goto L13;
        r1 = new Bundle();
        r1.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
    L13:
        r1.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
    L20:
        return this.mDescriptionObj;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object r8) {
        Bundle r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L27;
        a r1 = new a();
        r1.a(android.support.v4.media.a.a(r8));
        r1.a(android.support.v4.media.a.b(r8));
        r1.b(android.support.v4.media.a.c(r8));
        r1.c(android.support.v4.media.a.d(r8));
        r1.a(android.support.v4.media.a.e(r8));
        r1.a(android.support.v4.media.a.f(r8));
        Bundle r2 = android.support.v4.media.a.g(r8);
        if (r2 == null) goto L9;
        MediaSessionCompat.a(r2);
        Uri r4 = (Uri) ZeusTransformUtils.preCheckCast(r2.getParcelable(DESCRIPTION_KEY_MEDIA_URI), Uri.class, "com.obric.aiagent.plugin");
    L10:
        if (r4 != null) goto L12;
    L17:
        r0 = r2;
    L18:
        r1.a(r0);
        if (r4 == null) goto L22;
        r1.b(r4);
    L24:
        MediaDescriptionCompat r3 = r1.a();
        r3.mDescriptionObj = r8;
        return r3;
    L22:
        if (Build.VERSION.SDK_INT < 23) goto L24;
        r1.b(b.a(r8));
        goto L24
    L12:
        if (r2.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) == true) goto L14;
    L16:
        r2.remove(DESCRIPTION_KEY_MEDIA_URI);
        r2.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
        goto L17
    L14:
        if (r2.size() != 2) goto L16;
    L9:
        r4 = null;
        goto L10
    L27:
        return null;
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
