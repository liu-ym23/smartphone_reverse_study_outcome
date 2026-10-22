package k4;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e0 implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f3605c;
    public static final LinkedHashMap d;

    /* renamed from: a, reason: collision with root package name */
    public final String f3606a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3607b;

    static {
        e0 e0Var = new e0("http", 80);
        f3605c = e0Var;
        List listS = c5.l.S(new e0[]{e0Var, new e0("https", 443), new e0("ws", 80), new e0("wss", 443), new e0("socks", 1080)});
        int iT = c5.z.T(c5.o.n0(listS, 10));
        if (iT < 16) {
            iT = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iT);
        for (Object obj : listS) {
            linkedHashMap.put(((e0) obj).f3606a, obj);
        }
        d = linkedHashMap;
    }

    public e0(String name, int i8) {
        kotlin.jvm.internal.p.e(name, "name");
        this.f3606a = name;
        this.f3607b = i8;
        for (int i9 = 0; i9 < name.length(); i9++) {
            char cCharAt = name.charAt(i9);
            if (Character.toLowerCase(cCharAt) != cCharAt) {
                throw new IllegalArgumentException("All characters should be lower case");
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return kotlin.jvm.internal.p.a(this.f3606a, e0Var.f3606a) && this.f3607b == e0Var.f3607b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3607b) + (this.f3606a.hashCode() * 31);
    }

    public final String toString() {
        return "URLProtocol(name=" + this.f3606a + ", defaultPort=" + this.f3607b + ')';
    }
}
