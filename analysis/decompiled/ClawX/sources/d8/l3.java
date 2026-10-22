package d8;

import java.util.HashMap;
import java.util.function.Supplier;
import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l3 extends l1 {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2073g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f2074h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(int i8) {
        super("SVCB/HTTPS Parameters", 3);
        this.f2073g = i8;
        switch (i8) {
            case 1:
                super("Type", 2);
                f("TYPE");
                this.f2066f = Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
                this.f2074h = new HashMap();
                break;
            default:
                f("key");
                this.f2066f = Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
                this.f2074h = new HashMap();
                break;
        }
    }

    @Override // d8.l1
    public void c(int i8) {
        switch (this.f2073g) {
            case 1:
                f4.a(i8);
                break;
            default:
                super.c(i8);
                break;
        }
    }

    public final void g(int i8, String str, Supplier supplier) {
        switch (this.f2073g) {
            case 0:
                a(i8, str);
                this.f2074h.put(Integer.valueOf(i8), supplier);
                break;
            default:
                a(i8, str);
                this.f2074h.put(Integer.valueOf(i8), supplier);
                break;
        }
    }
}
