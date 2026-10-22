package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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

        public Builder() {
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public Builder setDescription(@Nullable CharSequence r10) {
            this.mDescription = r10;
            return this;
        }

        public Builder setExtras(@Nullable Bundle r10) {
            this.mExtras = r10;
            return this;
        }

        public Builder setIconBitmap(@Nullable Bitmap r10) {
            this.mIcon = r10;
            return this;
        }

        public Builder setIconUri(@Nullable Uri r10) {
            this.mIconUri = r10;
            return this;
        }

        public Builder setMediaId(@Nullable String r10) {
            this.mMediaId = r10;
            return this;
        }

        public Builder setMediaUri(@Nullable Uri r10) {
            this.mMediaUri = r10;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence r10) {
            this.mSubtitle = r10;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence r10) {
            this.mTitle = r10;
            return this;
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaDescriptionCompat(String r10, CharSequence r11, CharSequence r12, CharSequence r13, Bitmap r14, Uri r15, Bundle r16, Uri r17) {
        this.mMediaId = r10;
        this.mTitle = r11;
        this.mSubtitle = r12;
        this.mDescription = r13;
        this.mIcon = r14;
        this.mIconUri = r15;
        this.mExtras = r16;
        this.mMediaUri = r17;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object r10) {
        Bundle r11 = null;
        if (r10 == null) goto L22;
        Builder r12 = new Builder();
        r12.setMediaId(MediaDescriptionCompatApi21.getMediaId(r10));
        r12.setTitle(MediaDescriptionCompatApi21.getTitle(r10));
        r12.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(r10));
        r12.setDescription(MediaDescriptionCompatApi21.getDescription(r10));
        r12.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(r10));
        r12.setIconUri(MediaDescriptionCompatApi21.getIconUri(r10));
        Bundle r13 = MediaDescriptionCompatApi21.getExtras(r10);
        if (r13 == null) goto L7;
        MediaSessionCompat.ensureClassLoader(r13);
        Uri r14 = (Uri) r13.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
    L8:
        if (r14 != null) goto L10;
    L15:
        r11 = r13;
    L16:
        r12.setExtras(r11);
        if (r14 == null) goto L19;
        r12.setMediaUri(r14);
    L20:
        MediaDescriptionCompat r15 = r12.build();
        r15.mDescriptionObj = r10;
        return r15;
    L19:
        r12.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(r10));
        goto L20
    L10:
        if (r13.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) == true) goto L12;
    L14:
        r13.remove(DESCRIPTION_KEY_MEDIA_URI);
        r13.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
        goto L15
    L12:
        if (r13.size() != 2) goto L14;
    L7:
        r14 = null;
        goto L8
    L22:
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public CharSequence getDescription() {
        return this.mDescription;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    @Nullable
    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        Object r10 = this.mDescriptionObj;
        if (r10 != null) goto L6;
        Object r11 = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(r11, this.mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle(r11, this.mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle(r11, this.mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription(r11, this.mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(r11, this.mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri(r11, this.mIconUri);
        MediaDescriptionCompatApi21.Builder.setExtras(r11, this.mExtras);
        MediaDescriptionCompatApi23.Builder.setMediaUri(r11, this.mMediaUri);
        Object r12 = MediaDescriptionCompatApi21.Builder.build(r11);
        this.mDescriptionObj = r12;
        return r12;
    L6:
        return r10;
    }

    @Nullable
    public String getMediaId() {
        return this.mMediaId;
    }

    @Nullable
    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), r10, r11);
    }

    public MediaDescriptionCompat(Parcel r10) {
        this.mMediaId = r10.readString();
        Parcelable.Creator r11 = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.mTitle = (CharSequence) r11.createFromParcel(r10);
        this.mSubtitle = (CharSequence) r11.createFromParcel(r10);
        this.mDescription = (CharSequence) r11.createFromParcel(r10);
        ClassLoader r12 = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = (Bitmap) r10.readParcelable(r12);
        this.mIconUri = (Uri) r10.readParcelable(r12);
        this.mExtras = r10.readBundle(r12);
        this.mMediaUri = (Uri) r10.readParcelable(r12);
    }
}
