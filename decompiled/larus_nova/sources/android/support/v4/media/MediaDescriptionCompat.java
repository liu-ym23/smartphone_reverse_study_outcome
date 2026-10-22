package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
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

    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public Builder() {
        }

        public Builder setDescription(CharSequence r100) {
            this.mDescription = r100;
            return this;
        }

        public Builder setExtras(Bundle r100) {
            this.mExtras = r100;
            return this;
        }

        public Builder setIconBitmap(Bitmap r100) {
            this.mIcon = r100;
            return this;
        }

        public Builder setIconUri(Uri r100) {
            this.mIconUri = r100;
            return this;
        }

        public Builder setMediaId(String r100) {
            this.mMediaId = r100;
            return this;
        }

        public Builder setMediaUri(Uri r100) {
            this.mMediaUri = r100;
            return this;
        }

        public Builder setSubtitle(CharSequence r100) {
            this.mSubtitle = r100;
            return this;
        }

        public Builder setTitle(CharSequence r100) {
            this.mTitle = r100;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Object getMediaDescription() {
        Object r100 = this.mDescriptionObj;
        if (r100 != null) goto L16;
        int r101 = Build.VERSION.SDK_INT;
        Object r102 = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(r102, this.mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle(r102, this.mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle(r102, this.mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription(r102, this.mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(r102, this.mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri(r102, this.mIconUri);
        Bundle r103 = this.mExtras;
        if (r101 < 23) goto L7;
    L11:
        MediaDescriptionCompatApi21.Builder.setExtras(r102, r103);
        if (r101 < 23) goto L14;
        MediaDescriptionCompatApi23.Builder.setMediaUri(r102, this.mMediaUri);
    L14:
        Object r104 = MediaDescriptionCompatApi21.Builder.build(r102);
        this.mDescriptionObj = r104;
        return r104;
    L7:
        if (this.mMediaUri == null) goto L11;
        if (r103 != null) goto L10;
        r103 = new Bundle();
        r103.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
    L10:
        r103.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
        goto L11
    L16:
        return r100;
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public MediaDescriptionCompat(Parcel r100) {
        this.mMediaId = r100.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
        ClassLoader r101 = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = (Bitmap) r100.readParcelable(r101);
        this.mIconUri = (Uri) r100.readParcelable(r101);
        this.mExtras = r100.readBundle(r101);
        this.mMediaUri = (Uri) r100.readParcelable(r101);
    }

    public static MediaDescriptionCompat fromMediaDescription(Object r100) {
        Bundle r101 = null;
        if (r100 == null) goto L24;
        int r102 = Build.VERSION.SDK_INT;
        Builder r103 = new Builder();
        r103.setMediaId(MediaDescriptionCompatApi21.getMediaId(r100));
        r103.setTitle(MediaDescriptionCompatApi21.getTitle(r100));
        r103.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(r100));
        r103.setDescription(MediaDescriptionCompatApi21.getDescription(r100));
        r103.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(r100));
        r103.setIconUri(MediaDescriptionCompatApi21.getIconUri(r100));
        Bundle r104 = MediaDescriptionCompatApi21.getExtras(r100);
        if (r104 == null) goto L7;
        MediaSessionCompat.ensureClassLoader(r104);
        Uri r105 = (Uri) r104.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
    L8:
        if (r105 != null) goto L10;
    L15:
        r101 = r104;
    L16:
        r103.setExtras(r101);
        if (r105 == null) goto L20;
        r103.setMediaUri(r105);
    L22:
        MediaDescriptionCompat r106 = r103.build();
        r106.mDescriptionObj = r100;
        return r106;
    L20:
        if (r102 < 23) goto L22;
        r103.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(r100));
        goto L22
    L10:
        if (r104.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) == true) goto L12;
    L14:
        r104.remove(DESCRIPTION_KEY_MEDIA_URI);
        r104.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
        goto L15
    L12:
        if (r104.size() != 2) goto L14;
    L7:
        r105 = null;
        goto L8
    L24:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), r100, r101);
    }

    public MediaDescriptionCompat(String r100, CharSequence r101, CharSequence r102, CharSequence r103, Bitmap r104, Uri r105, Bundle r106, Uri r107) {
        this.mMediaId = r100;
        this.mTitle = r101;
        this.mSubtitle = r102;
        this.mDescription = r103;
        this.mIcon = r104;
        this.mIconUri = r105;
        this.mExtras = r106;
        this.mMediaUri = r107;
    }
}
