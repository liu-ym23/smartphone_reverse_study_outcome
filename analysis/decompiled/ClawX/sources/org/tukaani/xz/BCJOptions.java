package org.tukaani.xz;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
abstract class BCJOptions extends FilterOptions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int alignment;
    int startOffset = 0;

    public BCJOptions(int i8) {
        this.alignment = i8;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }

    @Override // org.tukaani.xz.FilterOptions
    public int getDecoderMemoryUsage() {
        return SimpleInputStream.getMemoryUsage();
    }

    @Override // org.tukaani.xz.FilterOptions
    public int getEncoderMemoryUsage() {
        return SimpleOutputStream.getMemoryUsage();
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public void setStartOffset(int i8) throws UnsupportedOptionsException {
        if (((this.alignment - 1) & i8) == 0) {
            this.startOffset = i8;
        } else {
            throw new UnsupportedOptionsException("Start offset must be a multiple of " + this.alignment);
        }
    }
}
