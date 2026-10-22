package ne;

import ad.n;
import ad.y;
import android.content.Context;
import android.net.ConnectivityManager;
import hc.h;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import l5.k;
import m5.d;
import m5.f;
import n5.e;
import s.o;
import s.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b implements o {

    /* renamed from: f, reason: collision with root package name */
    public static b f8957f;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f8958c;

    public b(y yVar) {
        yVar.getClass();
        e eVar = (e) yVar.f632b;
        m5.c cVar = new m5.c(0);
        cVar.f8240a = eVar;
        VarHandle.storeStoreFence();
        n5.a aVar = (n5.a) yVar.f633c;
        m5.c cVar2 = new m5.c(1);
        cVar2.f8240a = aVar;
        VarHandle.storeStoreFence();
        e eVar2 = (e) yVar.f635e;
        m5.c cVar3 = new m5.c(4);
        cVar3.f8240a = eVar2;
        VarHandle.storeStoreFence();
        e eVar3 = (e) yVar.f634d;
        m5.c cVar4 = new m5.c(2);
        cVar4.f8240a = eVar3;
        VarHandle.storeStoreFence();
        m5.c cVar5 = new m5.c(3);
        cVar5.f8240a = eVar3;
        VarHandle.storeStoreFence();
        f fVar = new f();
        fVar.f8240a = eVar3;
        VarHandle.storeStoreFence();
        m5.e eVar4 = new m5.e();
        eVar4.f8240a = eVar3;
        VarHandle.storeStoreFence();
        Context context = (Context) yVar.f631a;
        String str = k.f7750a;
        Object systemService = context.getSystemService("connectivity");
        systemService.getClass();
        long j10 = k.f7751b;
        l5.e eVar5 = new l5.e();
        eVar5.f7738a = (ConnectivityManager) systemService;
        eVar5.f7739b = j10;
        VarHandle.storeStoreFence();
        this.f8958c = kb.k.p0(new d[]{cVar, cVar2, cVar3, cVar4, cVar5, fVar, eVar4, eVar5});
    }

    public static synchronized b e() {
        try {
            if (f8957f == null) {
                b bVar = new b();
                bVar.f8958c = new ArrayList();
                VarHandle.storeStoreFence();
                f8957f = bVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8957f;
    }

    public void a(String str, String str2) {
        str.getClass();
        str2.getClass();
        id.c.h(str);
        id.c.i(str2, str);
        b(str, str2);
    }

    public void b(String str, String str2) {
        str.getClass();
        str2.getClass();
        ArrayList arrayList = this.f8958c;
        arrayList.add(str);
        arrayList.add(h.w0(str2).toString());
    }

    public void c(String str, String str2) {
        str.getClass();
        str2.getClass();
        if (str.length() <= 0) {
            g5.f.s("name is empty");
            return;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                od.f.c(bd.b.h("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                return;
            }
        }
        b(str, str2);
    }

    public n d() {
        return new n((String[]) this.f8958c.toArray(new String[0]));
    }

    public Object f() {
        return this.f8958c.remove(r1.size() - 1);
    }

    public void g(Object obj) {
        this.f8958c.add(obj);
    }

    @Override // s.o
    public s.y get(int i) {
        return (z) this.f8958c.get(i);
    }

    public void h(String str) {
        ArrayList arrayList = this.f8958c;
        int i = 0;
        while (i < arrayList.size()) {
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }

    public void i(int i) {
        ArrayList arrayList = this.f8958c;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((a) obj).b(i);
        }
    }

    public b(int i) {
        this.f8958c = new ArrayList(i);
    }

    public b() {
        this.f8958c = new ArrayList(20);
    }
}
