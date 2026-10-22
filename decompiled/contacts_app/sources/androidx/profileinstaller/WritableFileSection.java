package androidx.profileinstaller;

/* JADX INFO: loaded from: classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    WritableFileSection(FileSectionType r1, int r2, byte[] r3, boolean r4) {
        this.mType = r1;
        this.mExpectedInflateSize = r2;
        this.mContents = r3;
        this.mNeedsCompression = r4;
    }
}
