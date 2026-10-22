package androidx.profileinstaller;

/* JADX INFO: loaded from: classes17.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    public WritableFileSection(FileSectionType r100, int r101, byte[] r102, boolean r103) {
        this.mType = r100;
        this.mExpectedInflateSize = r101;
        this.mContents = r102;
        this.mNeedsCompression = r103;
    }
}
