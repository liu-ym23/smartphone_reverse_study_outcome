package androidx.camera.video;

import android.location.Location;
import androidx.core.util.Preconditions;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class FileOutputOptions extends OutputOptions {
    private final FileOutputOptionsInternal mFileOutputOptionsInternal;

    public static final class Builder extends OutputOptions.Builder<FileOutputOptions, Builder> {
        private final FileOutputOptionsInternal.Builder mInternalBuilder;

        @Override // androidx.camera.video.OutputOptions.Builder
        public FileOutputOptions build() {
            return new FileOutputOptions(this.mInternalBuilder.build());
        }

        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ OutputOptions build() {
            return build();
        }

        public Builder(File r100) {
            super(new AutoValue_FileOutputOptions_FileOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(r100, "File can't be null.");
            FileOutputOptionsInternal.Builder r101 = (FileOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = r101;
            r101.setFile(r100);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setDurationLimitMillis(long r100) {
            return super.setDurationLimitMillis(r100);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setFileSizeLimit(long r100) {
            return super.setFileSizeLimit(r100);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setLocation(Location r100) {
            return super.setLocation(r100);
        }
    }

    public static abstract class FileOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {

        public static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public abstract FileOutputOptionsInternal build();

            public abstract Builder setFile(File r100);

            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
                return build();
            }

            public Builder() {
            }
        }

        public abstract File getFile();

        public FileOutputOptionsInternal() {
        }
    }

    public File getFile() {
        return this.mFileOutputOptionsInternal.getFile();
    }

    public int hashCode() {
        return this.mFileOutputOptionsInternal.hashCode();
    }

    public String toString() {
        return this.mFileOutputOptionsInternal.toString().replaceFirst("FileOutputOptionsInternal", "FileOutputOptions");
    }

    public FileOutputOptions(FileOutputOptionsInternal r100) {
        super(r100);
        this.mFileOutputOptionsInternal = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileOutputOptions) == true) goto L10;
        return false;
    L10:
        return this.mFileOutputOptionsInternal.equals(((FileOutputOptions) r100).mFileOutputOptionsInternal);
    }
}
