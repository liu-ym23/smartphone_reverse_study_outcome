package org.tukaani.xz;

/* JADX INFO: loaded from: classes3.dex */
abstract class BCJOptions extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int alignment;
    int startOffset;

    static {
    }

    BCJOptions(int alignment) {
        this.startOffset = 0;
        this.alignment = alignment;
    }

    public void setStartOffset(int startOffset) throws UnsupportedOptionsException {
        if (((this.alignment - 1) & startOffset) != 0) goto L7;
        this.startOffset = startOffset;
        return;
    L7:
        throw new UnsupportedOptionsException("Start offset must be a multiple of " + this.alignment);
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    @Override // org.tukaani.xz.FilterOptions
    public int getEncoderMemoryUsage() {
        return SimpleOutputStream.getMemoryUsage();
    }

    @Override // org.tukaani.xz.FilterOptions
    public int getDecoderMemoryUsage() {
        return SimpleInputStream.getMemoryUsage();
    }

    public Object clone() {
        return super.clone();
    L6:
        throw new RuntimeException();
    }
}
