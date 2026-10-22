package e8;

import d8.c4;
import d8.x1;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b implements i {
    public static final boolean d = Boolean.getBoolean("java.net.preferIPv4Stack");

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f2396e = Boolean.getBoolean("java.net.preferIPv6Addresses");

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2397a = new ArrayList(3);

    /* renamed from: b, reason: collision with root package name */
    public final z7.b f2398b = z7.d.b(getClass());

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2399c = new ArrayList(1);

    public static int f(String str) throws NumberFormatException {
        if (str == null || str.isEmpty()) {
            return 1;
        }
        try {
            int i8 = Integer.parseInt(str);
            if (i8 < 0) {
                return 1;
            }
            if (i8 > 15) {
                return 15;
            }
            return i8;
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    @Override // e8.i
    public final List b() {
        boolean z = f2396e;
        ArrayList arrayList = this.f2397a;
        return z ? (List) arrayList.stream().sorted(new b0.b(1)).collect(Collectors.toList()) : d ? (List) arrayList.stream().filter(new d3.a(4)).collect(Collectors.toList()) : Collections.unmodifiableList(arrayList);
    }

    @Override // e8.i
    public final List c() {
        return Collections.unmodifiableList(this.f2399c);
    }

    public final void d(InetSocketAddress inetSocketAddress) {
        ArrayList arrayList = this.f2397a;
        if (arrayList.contains(inetSocketAddress)) {
            return;
        }
        arrayList.add(inetSocketAddress);
        this.f2398b.l(inetSocketAddress, "Added {} to nameservers");
    }

    public final void e(String str) {
        z7.b bVar = this.f2398b;
        ArrayList arrayList = this.f2399c;
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            x1 x1VarF = x1.f(str, x1.f2208g);
            if (arrayList.contains(x1VarF)) {
                return;
            }
            arrayList.add(x1VarF);
            bVar.l(x1VarF, "Added {} to search paths");
        } catch (c4 unused) {
            bVar.k(str, "Could not parse search path {} as a dns name, ignoring");
        }
    }

    public final void g() {
        this.f2397a.clear();
        this.f2399c.clear();
    }
}
