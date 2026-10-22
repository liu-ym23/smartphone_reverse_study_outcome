package d8;

import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final l1 f1999a;

    static {
        l1 l1Var = new l1("EDNS Flag", 3);
        f1999a = l1Var;
        l1Var.f2066f = Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
        l1Var.f("FLAG");
        l1Var.a(32768, "do");
    }
}
