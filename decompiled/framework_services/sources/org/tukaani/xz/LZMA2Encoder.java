package org.tukaani.xz;

import org.tukaani.xz.lzma.LZMAEncoder;

/* JADX INFO: loaded from: classes3.dex */
class LZMA2Encoder extends LZMA2Coder implements FilterEncoder {
    private final LZMA2Options options;
    private final byte[] props;

    LZMA2Encoder(LZMA2Options options) {
        this.props = new byte[1];
        if (options.getPresetDict() != null) goto L11;
        if (options.getMode() != 0) goto L7;
        this.props[0] = 0;
    L8:
        this.options = (LZMA2Options) options.clone();
        return;
    L7:
        int d = Math.max(options.getDictSize(), 4096);
        this.props[0] = (byte) (LZMAEncoder.getDistSlot(d - 1) - 23);
        goto L8
    L11:
        throw new IllegalArgumentException("XZ doesn't support a preset dictionary for now");
    }

    @Override // org.tukaani.xz.FilterEncoder
    public long getFilterID() {
        return 33;
    }

    @Override // org.tukaani.xz.FilterEncoder
    public byte[] getFilterProps() {
        return this.props;
    }

    @Override // org.tukaani.xz.FilterEncoder
    public boolean supportsFlushing() {
        return true;
    }

    @Override // org.tukaani.xz.FilterEncoder
    public FinishableOutputStream getOutputStream(FinishableOutputStream out, ArrayCache arrayCache) {
        return this.options.getOutputStream(out, arrayCache);
    }
}
