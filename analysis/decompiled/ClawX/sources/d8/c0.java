package d8;

import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final l1 f1963a;

    static {
        l1 l1Var = new l1("EDNS Option Codes", 1);
        f1963a = l1Var;
        l1Var.f2066f = Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
        l1Var.f("CODE");
        l1Var.a(1, "LLQ");
        l1Var.a(2, "UL");
        l1Var.a(3, "NSID");
        l1Var.a(5, "DAU");
        l1Var.a(6, "DHU");
        l1Var.a(7, "N3U");
        l1Var.a(8, "edns-client-subnet");
        l1Var.a(9, "EDNS_EXPIRE");
        l1Var.a(10, "COOKIE");
        l1Var.a(11, "edns-tcp-keepalive");
        l1Var.a(12, "Padding");
        l1Var.a(13, "CHAIN");
        l1Var.a(14, "edns-key-tag");
        l1Var.a(15, "Extended_DNS_Error");
        l1Var.a(16, "EDNS-Client-Tag");
        l1Var.a(17, "EDNS-Server-Tag");
        l1Var.a(18, "Report-Channel");
    }
}
