package org.tukaani.xz;

/* JADX INFO: loaded from: classes3.dex */
class BCJEncoder extends BCJCoder implements FilterEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long filterID;
    private final BCJOptions options;
    private final byte[] props;

    static {
    }

    BCJEncoder(BCJOptions options, long filterID) {
        int startOffset = options.getStartOffset();
        if (startOffset != 0) goto L5;
        this.props = new byte[0];
    L8:
        this.filterID = filterID;
        this.options = (BCJOptions) options.clone();
        return;
    L5:
        this.props = new byte[4];
        int i = 0;
    L6:
        if (i >= 4) goto L8;
        this.props[i] = (byte) (startOffset >>> (i * 8));
        i = i + 1;
        goto L6
    }

    @Override // org.tukaani.xz.FilterEncoder
    public long getFilterID() {
        return this.filterID;
    }

    @Override // org.tukaani.xz.FilterEncoder
    public byte[] getFilterProps() {
        return this.props;
    }

    @Override // org.tukaani.xz.FilterEncoder
    public boolean supportsFlushing() {
        return false;
    }

    @Override // org.tukaani.xz.FilterEncoder
    public FinishableOutputStream getOutputStream(FinishableOutputStream out, ArrayCache arrayCache) {
        return this.options.getOutputStream(out, arrayCache);
    }
}
