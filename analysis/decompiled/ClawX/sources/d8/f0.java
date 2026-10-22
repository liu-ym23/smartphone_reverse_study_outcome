package d8;

import java.nio.charset.StandardCharsets;
import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f0 extends d0 {
    public static final l1 d;

    /* renamed from: b, reason: collision with root package name */
    public int f1989b;

    /* renamed from: c, reason: collision with root package name */
    public String f1990c;

    static {
        l1 l1Var = new l1("EDNS Extended Error Codes", 1);
        d = l1Var;
        l1Var.f2066f = Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
        l1Var.f("EDE");
        l1Var.a(0, "OTHER");
        l1Var.a(1, "UNSUPPORTED_DNSKEY_ALGORITHM");
        l1Var.a(2, "UNSUPPORTED_DS_DIGEST_TYPE");
        l1Var.a(3, "STALE_ANSWER");
        l1Var.a(4, "FORGED_ANSWER");
        l1Var.a(5, "DNSSEC_INDETERMINATE");
        l1Var.a(6, "DNSSEC_BOGUS");
        l1Var.a(7, "SIGNATURE_EXPIRED");
        l1Var.a(8, "SIGNATURE_NOT_YET_VALID");
        l1Var.a(9, "DNSKEY_MISSING");
        l1Var.a(10, "RRSIGS_MISSING");
        l1Var.a(11, "NO_ZONE_KEY_BIT_SET");
        l1Var.a(12, "NSEC_MISSING");
        l1Var.a(13, "CACHED_ERROR");
        l1Var.a(14, "NOT_READY");
        l1Var.a(15, "BLOCKED");
        l1Var.a(16, "CENSORED");
        l1Var.a(17, "FILTERED");
        l1Var.a(18, "PROHIBITED");
        l1Var.a(19, "STALE_NXDOMAIN_ANSWER");
        l1Var.a(20, "NOT_AUTHORITATIVE");
        l1Var.a(21, "NOT_SUPPORTED");
        l1Var.a(22, "NO_REACHABLE_AUTHORITY");
        l1Var.a(23, "NETWORK_ERROR");
        l1Var.a(24, "INVALID_DATA");
        l1Var.a(25, "SIGNATURE_EXPIRED_BEFORE_VALID");
        l1Var.a(26, "TOO_EARLY");
        l1Var.a(27, "UNSUPPORTED_NSEC3_ITERATIONS_VALUE");
        l1Var.a(28, "UNABLE_TO_CONFORM_TO_POLICY");
        l1Var.a(29, "SYNTHESIZED");
    }

    @Override // d8.d0
    public final void a(u uVar) {
        this.f1989b = uVar.d();
        if (uVar.f2171a.remaining() > 0) {
            byte[] bArrA = uVar.a();
            int length = bArrA.length;
            if (bArrA[bArrA.length - 1] == 0) {
                length--;
            }
            this.f1990c = new String(bArrA, 0, length, StandardCharsets.UTF_8);
        }
    }

    @Override // d8.d0
    public final String b() {
        String str = this.f1990c;
        l1 l1Var = d;
        if (str == null) {
            return l1Var.d(this.f1989b);
        }
        return l1Var.d(this.f1989b) + ": " + this.f1990c;
    }

    @Override // d8.d0
    public final void c(b0.j jVar) {
        jVar.j(this.f1989b);
        String str = this.f1990c;
        if (str == null || str.isEmpty()) {
            return;
        }
        jVar.h(this.f1990c.getBytes(StandardCharsets.UTF_8));
    }
}
