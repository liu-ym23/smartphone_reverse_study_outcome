package androidx.camera.video;

import android.location.Location;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal {
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;
    private final ParcelFileDescriptor parcelFileDescriptor;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;
        private ParcelFileDescriptor parcelFileDescriptor;

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal build() {
            if (this.fileSizeLimit != null) goto L5;
            String r100 = " fileSizeLimit";
        L7:
            if (this.durationLimitMillis != null) goto L10;
            r100 = r100 + " durationLimitMillis";
        L10:
            if (this.parcelFileDescriptor != null) goto L13;
            r100 = r100 + " parcelFileDescriptor";
        L13:
            if (r100.isEmpty() == false) goto L17;
            return new AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.parcelFileDescriptor, null);
        L17:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
            return build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setDurationLimitMillis(long r100) {
            this.durationLimitMillis = Long.valueOf(r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setFileSizeLimit(long r100) {
            this.fileSizeLimit = Long.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setLocation(Location r100) {
            return setLocation(r100);
        }

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setParcelFileDescriptor(ParcelFileDescriptor r100) {
            if (r100 == null) goto L6;
            this.parcelFileDescriptor = r100;
            return this;
        L6:
            throw new NullPointerException("Null parcelFileDescriptor");
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setDurationLimitMillis(long r100) {
            return setDurationLimitMillis(r100);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setFileSizeLimit(long r100) {
            return setFileSizeLimit(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setLocation(Location r100) {
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
        int r106 = this.parcelFileDescriptor.hashCode();
        return r106 ^ ((r103 ^ r105) * 1000003);
    L5:
        r105 = r104.hashCode();
        goto L6
    }

    public String toString() {
        return "FileDescriptorOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", parcelFileDescriptor=" + this.parcelFileDescriptor + com.alipay.sdk.m.u.i.f25855d;
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

    @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.parcelFileDescriptor;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) == false) goto L23;
        FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal r101 = (FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) r100;
        if (this.fileSizeLimit == r101.getFileSizeLimit()) goto L10;
    L21:
        return false;
    L10:
        if (this.durationLimitMillis != r101.getDurationLimitMillis()) goto L21;
        Location r102 = this.location;
        if (r102 != null) goto L17;
        if (r101.getLocation() != null) goto L21;
    L19:
        if (this.parcelFileDescriptor.equals(r101.getParcelFileDescriptor()) == false) goto L21;
        return true;
    L17:
        if (r102.equals(r101.getLocation()) == false) goto L21;
    L23:
        return false;
    }

    private AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(long r100, long r101, Location r102, ParcelFileDescriptor r103) {
        this.fileSizeLimit = r100;
        this.durationLimitMillis = r101;
        this.location = r102;
        this.parcelFileDescriptor = r103;
    }

    public /* synthetic */ AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(long r100, long r101, Location r102, ParcelFileDescriptor r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
