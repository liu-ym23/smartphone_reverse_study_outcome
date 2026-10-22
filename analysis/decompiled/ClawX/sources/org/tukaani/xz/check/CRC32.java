package org.tukaani.xz.check;

import org.tukaani.xz.common.ByteArrayView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class CRC32 extends Check {
    private final java.util.zip.CRC32 state = new java.util.zip.CRC32();

    public CRC32() {
        this.size = 4;
        this.name = "CRC32";
    }

    @Override // org.tukaani.xz.check.Check
    public byte[] finish() {
        byte[] bArr = new byte[4];
        ByteArrayView.setIntLE(bArr, 0, (int) this.state.getValue());
        this.state.reset();
        return bArr;
    }

    @Override // org.tukaani.xz.check.Check
    public void update(byte[] bArr, int i8, int i9) {
        this.state.update(bArr, i8, i9);
    }
}
