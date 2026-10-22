package org.tukaani.xz.check;

import a8.b;
import java.security.NoSuchAlgorithmException;
import org.tukaani.xz.UnsupportedOptionsException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class Check {
    String name;
    int size;

    public static Check getInstance(int i8) throws UnsupportedOptionsException {
        if (i8 == 0) {
            return new None();
        }
        if (i8 == 1) {
            return new CRC32();
        }
        if (i8 == 4) {
            return new CRC64();
        }
        if (i8 == 10) {
            try {
                return new SHA256();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        throw new UnsupportedOptionsException(b.j(i8, "Unsupported Check ID "));
    }

    public abstract byte[] finish();

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public abstract void update(byte[] bArr, int i8, int i9);
}
