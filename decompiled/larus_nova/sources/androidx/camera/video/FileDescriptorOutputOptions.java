package androidx.camera.video;

import android.location.Location;
import android.os.ParcelFileDescriptor;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class FileDescriptorOutputOptions extends OutputOptions {
    private final FileDescriptorOutputOptionsInternal mFileDescriptorOutputOptionsInternal;

    public static final class Builder extends OutputOptions.Builder<FileDescriptorOutputOptions, Builder> {
        private final FileDescriptorOutputOptionsInternal.Builder mInternalBuilder;

        @Override // androidx.camera.video.OutputOptions.Builder
        public FileDescriptorOutputOptions build() {
            return new FileDescriptorOutputOptions(this.mInternalBuilder.build());
        }

        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ OutputOptions build() {
            return build();
        }

        public Builder(ParcelFileDescriptor r100) {
            super(new AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(r100, "File descriptor can't be null.");
            FileDescriptorOutputOptionsInternal.Builder r101 = (FileDescriptorOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = r101;
            r101.setParcelFileDescriptor(r100);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setDurationLimitMillis(long r100) {
            return super.setDurationLimitMillis(r100);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setFileSizeLimit(long r100) {
            return super.setFileSizeLimit(r100);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setLocation(Location r100) {
            return super.setLocation(r100);
        }
    }

    public static abstract class FileDescriptorOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {

        public static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public abstract FileDescriptorOutputOptionsInternal build();

            public abstract Builder setParcelFileDescriptor(ParcelFileDescriptor r100);

            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
                return build();
            }

            public Builder() {
            }
        }

        public abstract ParcelFileDescriptor getParcelFileDescriptor();

        public FileDescriptorOutputOptionsInternal() {
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mFileDescriptorOutputOptionsInternal.getParcelFileDescriptor();
    }

    public int hashCode() {
        return this.mFileDescriptorOutputOptionsInternal.hashCode();
    }

    public String toString() {
        return this.mFileDescriptorOutputOptionsInternal.toString().replaceFirst("FileDescriptorOutputOptionsInternal", "FileDescriptorOutputOptions");
    }

    public FileDescriptorOutputOptions(FileDescriptorOutputOptionsInternal r100) {
        super(r100);
        this.mFileDescriptorOutputOptionsInternal = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileDescriptorOutputOptions) == true) goto L10;
        return false;
    L10:
        return this.mFileDescriptorOutputOptionsInternal.equals(((FileDescriptorOutputOptions) r100).mFileDescriptorOutputOptionsInternal);
    }
}
