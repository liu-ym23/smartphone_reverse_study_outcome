package org.tukaani.xz.check;

import java.security.MessageDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class SHA256 extends Check {
    private final MessageDigest sha256;

    public SHA256() {
        this.size = 32;
        this.name = "SHA-256";
        this.sha256 = MessageDigest.getInstance("SHA-256");
    }

    @Override // org.tukaani.xz.check.Check
    public byte[] finish() {
        byte[] bArrDigest = this.sha256.digest();
        this.sha256.reset();
        return bArrDigest;
    }

    @Override // org.tukaani.xz.check.Check
    public void update(byte[] bArr, int i8, int i9) {
        this.sha256.update(bArr, i8, i9);
    }
}
