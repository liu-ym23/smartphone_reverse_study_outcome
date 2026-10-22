package androidx.camera.video;

import android.location.Location;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_FileOutputOptions_FileOutputOptionsInternal extends FileOutputOptions.FileOutputOptionsInternal {
    private final long durationLimitMillis;
    private final File file;
    private final long fileSizeLimit;
    private final Location location;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_FileOutputOptions_FileOutputOptionsInternal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends FileOutputOptions.FileOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private File file;
        private Long fileSizeLimit;
        private Location location;

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal build() {
            if (this.fileSizeLimit != null) goto L5;
            String r100 = " fileSizeLimit";
        L7:
            if (this.durationLimitMillis != null) goto L10;
            r100 = r100 + " durationLimitMillis";
        L10:
            if (this.file != null) goto L13;
            r100 = r100 + " file";
        L13:
            if (r100.isEmpty() == false) goto L17;
            return new AutoValue_FileOutputOptions_FileOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.file, null);
        L17:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
            return build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setDurationLimitMillis(long r100) {
            this.durationLimitMillis = Long.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setFile(File r100) {
            if (r100 == null) goto L6;
            this.file = r100;
            return this;
        L6:
            throw new NullPointerException("Null file");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setFileSizeLimit(long r100) {
            this.fileSizeLimit = Long.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileOutputOptions.FileOutputOptionsInternal.Builder setLocation(Location r100) {
            return setLocation(r100);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileOutputOptions.FileOutputOptionsInternal.Builder setDurationLimitMillis(long r100) {
            return setDurationLimitMillis(r100);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileOutputOptions.FileOutputOptionsInternal.Builder setFileSizeLimit(long r100) {
            return setFileSizeLimit(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setLocation(Location r100) {
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
        int r106 = this.file.hashCode();
        return r106 ^ ((r103 ^ r105) * 1000003);
    L5:
        r105 = r104.hashCode();
        goto L6
    }

    public String toString() {
        return "FileOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", file=" + this.file + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal
    public File getFile() {
        return this.file;
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
        if ((r100 instanceof FileOutputOptions.FileOutputOptionsInternal) == false) goto L23;
        FileOutputOptions.FileOutputOptionsInternal r101 = (FileOutputOptions.FileOutputOptionsInternal) r100;
        if (this.fileSizeLimit == r101.getFileSizeLimit()) goto L10;
    L21:
        return false;
    L10:
        if (this.durationLimitMillis != r101.getDurationLimitMillis()) goto L21;
        Location r102 = this.location;
        if (r102 != null) goto L17;
        if (r101.getLocation() != null) goto L21;
    L19:
        if (this.file.equals(r101.getFile()) == false) goto L21;
        return true;
    L17:
        if (r102.equals(r101.getLocation()) == false) goto L21;
    L23:
        return false;
    }

    private AutoValue_FileOutputOptions_FileOutputOptionsInternal(long r100, long r101, Location r102, File r103) {
        this.fileSizeLimit = r100;
        this.durationLimitMillis = r101;
        this.location = r102;
        this.file = r103;
    }

    public /* synthetic */ AutoValue_FileOutputOptions_FileOutputOptionsInternal(long r100, long r101, Location r102, File r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
