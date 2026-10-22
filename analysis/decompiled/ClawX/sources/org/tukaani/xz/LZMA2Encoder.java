package org.tukaani.xz;

import org.tukaani.xz.lzma.LZMAEncoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class LZMA2Encoder extends LZMA2Coder implements FilterEncoder {
    private final LZMA2Options options;
    private final byte[] props;

    public LZMA2Encoder(LZMA2Options lZMA2Options) {
        byte[] bArr = new byte[1];
        this.props = bArr;
        if (lZMA2Options.getPresetDict() != null) {
            throw new IllegalArgumentException("XZ doesn't support a preset dictionary for now");
        }
        if (lZMA2Options.getMode() == 0) {
            bArr[0] = 0;
        } else {
            bArr[0] = (byte) (LZMAEncoder.getDistSlot(Math.max(lZMA2Options.getDictSize(), 4096) - 1) - 23);
        }
        this.options = (LZMA2Options) lZMA2Options.clone();
    }

    @Override // org.tukaani.xz.FilterEncoder
    public long getFilterID() {
        return 33L;
    }

    @Override // org.tukaani.xz.FilterEncoder
    public byte[] getFilterProps() {
        return this.props;
    }

    @Override // org.tukaani.xz.FilterEncoder
    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        return this.options.getOutputStream(finishableOutputStream, arrayCache);
    }

    @Override // org.tukaani.xz.FilterEncoder
    public boolean supportsFlushing() {
        return true;
    }
}
