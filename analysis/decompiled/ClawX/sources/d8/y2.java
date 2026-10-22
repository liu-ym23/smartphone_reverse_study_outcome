package d8;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y2 {

    /* renamed from: c, reason: collision with root package name */
    public static final z7.b f2227c = z7.d.b(y2.class);
    public static y2 d;

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList f2228e;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2229a = new ArrayList(2);

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2230b = new ArrayList(0);

    public y2() {
        int i8 = 0;
        synchronized (y2.class) {
            try {
                if (f2228e == null) {
                    f2228e = new ArrayList(8);
                    if (!Boolean.getBoolean("dnsjava.configprovider.skipinit")) {
                        f2228e.add(new e8.h(0));
                        f2228e.add(new e8.h(1));
                        ArrayList arrayList = f2228e;
                        e8.k kVar = new e8.k();
                        if (System.getProperty("os.name").contains("Windows")) {
                            try {
                                kVar.f2406a = new e8.j();
                            } catch (NoClassDefFoundError unused) {
                                e8.k.f2405b.o("JNA not available");
                            }
                        }
                        arrayList.add(kVar);
                        f2228e.add(new e8.a());
                        ArrayList arrayList2 = f2228e;
                        e8.g gVar = new e8.g();
                        if (!System.getProperty("java.vendor").contains("Android")) {
                            try {
                                gVar.f2403a = new e8.f();
                            } catch (NoClassDefFoundError unused2) {
                                e8.g.f2402b.o("JNDI DNS not available");
                            }
                        }
                        arrayList2.add(gVar);
                        f2228e.add(new e8.h(2));
                        f2228e.add(new e8.c(0));
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList3 = f2228e;
        int size = arrayList3.size();
        while (i8 < size) {
            Object obj = arrayList3.get(i8);
            i8++;
            e8.i iVar = (e8.i) obj;
            if (iVar.isEnabled()) {
                try {
                    iVar.a();
                    if (this.f2229a.isEmpty()) {
                        this.f2229a.addAll(iVar.b());
                    }
                    if (this.f2230b.isEmpty()) {
                        List listC = iVar.c();
                        if (!listC.isEmpty()) {
                            this.f2230b.addAll(listC);
                        }
                    }
                    if (!this.f2229a.isEmpty() && !this.f2230b.isEmpty()) {
                        return;
                    }
                } catch (e8.e e9) {
                    f2227c.n("Failed to initialize provider", e9);
                }
            }
        }
        if (this.f2229a.isEmpty()) {
            this.f2229a.add(new InetSocketAddress(InetAddress.getLoopbackAddress(), 53));
        }
    }
}
