package kotlin.uuid;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a3\u0010\u0012\u001a\u00020\u0011*\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lkotlin/uuid/Uuid;", "c", "()Lkotlin/uuid/Uuid;", "uuid", "", Const.INTENT_KEY_UMID, "(Lkotlin/uuid/Uuid;)Ljava/lang/Object;", "", "", "index", "", Const.INTENT_KEY_PKGNAME, "([BI)J", "dst", "dstOffset", "startIndex", "endIndex", "LY8/t;", Const.INTENT_KEY_APIKEY, "(J[BIII)V", "", "hexDashString", "f", "(Ljava/lang/String;)Lkotlin/uuid/Uuid;", "hexString", "e", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
/* loaded from: classes5.dex */
public class a {
    public static final void a(long j10, byte[] dst, int i10, int i11, int i12) {
        p.i(dst, "dst");
        b.j(j10, dst, i10, i11, i12);
    }

    public static final long b(byte[] bArr, int i10) {
        p.i(bArr, "<this>");
        return b.k(bArr, i10);
    }

    public static final Uuid c() {
        byte[] bArr = new byte[16];
        Na.a.f5034a.a().nextBytes(bArr);
        return b.n(bArr);
    }

    public static final Object d(Uuid uuid) {
        p.i(uuid, "uuid");
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final Uuid e(String hexString) {
        p.i(hexString, "hexString");
        return b.o(hexString);
    }

    public static final Uuid f(String hexDashString) {
        p.i(hexDashString, "hexDashString");
        return b.p(hexDashString);
    }
}
