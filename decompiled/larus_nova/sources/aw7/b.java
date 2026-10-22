package aw7;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static long a(int r100) {
        return (((long) r100) & BodyPartID.bodyIdMax) | (-4294967296L);
    }

    public static int b(long r100) {
        return (int) (r100 & BodyPartID.bodyIdMax);
    }
}
