package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal extends MediaStoreOutputOptions.MediaStoreOutputOptionsInternal {
    private final Uri collectionUri;
    private final ContentResolver contentResolver;
    private final ContentValues contentValues;
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder {
        private Uri collectionUri;
        private ContentResolver contentResolver;
        private ContentValues contentValues;
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal build() {
            if (this.fileSizeLimit != null) goto L5;
            String r100 = " fileSizeLimit";
        L7:
            if (this.durationLimitMillis != null) goto L10;
            r100 = r100 + " durationLimitMillis";
        L10:
            if (this.contentResolver != null) goto L13;
            r100 = r100 + " contentResolver";
        L13:
            if (this.collectionUri != null) goto L16;
            r100 = r100 + " collectionUri";
        L16:
            if (this.contentValues != null) goto L19;
            r100 = r100 + " contentValues";
        L19:
            if (r100.isEmpty() == false) goto L23;
            return new AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.contentResolver, this.collectionUri, this.contentValues, null);
        L23:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
            return build();
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setCollectionUri(Uri r100) {
            if (r100 == null) goto L6;
            this.collectionUri = r100;
            return this;
        L6:
            throw new NullPointerException("Null collectionUri");
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setContentResolver(ContentResolver r100) {
            if (r100 == null) goto L6;
            this.contentResolver = r100;
            return this;
        L6:
            throw new NullPointerException("Null contentResolver");
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setContentValues(ContentValues r100) {
            if (r100 == null) goto L6;
            this.contentValues = r100;
            return this;
        L6:
            throw new NullPointerException("Null contentValues");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setDurationLimitMillis(long r100) {
            this.durationLimitMillis = Long.valueOf(r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setFileSizeLimit(long r100) {
            this.fileSizeLimit = Long.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setLocation(Location r100) {
            return setLocation(r100);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setDurationLimitMillis(long r100) {
            return setDurationLimitMillis(r100);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setFileSizeLimit(long r100) {
            return setFileSizeLimit(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setLocation(Location r100) {
            this.location = r100;
            return this;
        }
    }

    public int hashCode() {
        long r100 = this.fileSizeLimit;
        int r101 = (((int) (r100 ^ (r100 >>> 32))) ^ 1000003) * 1000003;
        long r102 = this.durationLimitMillis;
        int r103 = (r101 ^ ((int) ((r102 >>> 32) ^ r102))) * 1000003;
        Location r104 = this.location;
        if (r104 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (((((r103 ^ r105) * 1000003) ^ this.contentResolver.hashCode()) * 1000003) ^ this.collectionUri.hashCode()) * 1000003;
        return this.contentValues.hashCode() ^ r106;
    L5:
        r105 = r104.hashCode();
        goto L6
    }

    public String toString() {
        return "MediaStoreOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", contentResolver=" + this.contentResolver + ", collectionUri=" + this.collectionUri + ", contentValues=" + this.contentValues + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    public Uri getCollectionUri() {
        return this.collectionUri;
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    public ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    public ContentValues getContentValues() {
        return this.contentValues;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getFileSizeLimit() {
        return this.fileSizeLimit;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public Location getLocation() {
        return this.location;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaStoreOutputOptions.MediaStoreOutputOptionsInternal) == false) goto L27;
        MediaStoreOutputOptions.MediaStoreOutputOptionsInternal r101 = (MediaStoreOutputOptions.MediaStoreOutputOptionsInternal) r100;
        if (this.fileSizeLimit == r101.getFileSizeLimit()) goto L10;
    L25:
        return false;
    L10:
        if (this.durationLimitMillis != r101.getDurationLimitMillis()) goto L25;
        Location r102 = this.location;
        if (r102 != null) goto L17;
        if (r101.getLocation() != null) goto L25;
    L19:
        if (this.contentResolver.equals(r101.getContentResolver()) == false) goto L25;
        if (this.collectionUri.equals(r101.getCollectionUri()) == false) goto L25;
        if (this.contentValues.equals(r101.getContentValues()) == false) goto L25;
        return true;
    L17:
        if (r102.equals(r101.getLocation()) == false) goto L25;
    L27:
        return false;
    }

    private AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(long r100, long r101, Location r102, ContentResolver r103, Uri r104, ContentValues r105) {
        this.fileSizeLimit = r100;
        this.durationLimitMillis = r101;
        this.location = r102;
        this.contentResolver = r103;
        this.collectionUri = r104;
        this.contentValues = r105;
    }

    public /* synthetic */ AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(long r100, long r101, Location r102, ContentResolver r103, Uri r104, ContentValues r105, AnonymousClass1 r106) {
        this(r100, r101, r102, r103, r104, r105);
    }
}
