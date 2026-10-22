package cja;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23991a;

    public final float a() {
        return Float.intBitsToFloat((int) (this.f23991a >> 32));
    }

    public final float b() {
        return Float.intBitsToFloat((int) (this.f23991a & BodyPartID.bodyIdMax));
    }

    public d(long r100) {
        this.f23991a = r100;
    }
}
