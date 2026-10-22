package pd;

import com.fasterxml.jackson.core.JsonPointer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import jb.k;
import kb.l;
import kb.m;
import kb.q;
import od.g0;
import od.i0;
import od.n;
import od.o;
import od.u;
import od.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends o {

    /* renamed from: e, reason: collision with root package name */
    public static final z f10009e;

    /* renamed from: b, reason: collision with root package name */
    public ClassLoader f10010b;

    /* renamed from: c, reason: collision with root package name */
    public o f10011c;

    /* renamed from: d, reason: collision with root package name */
    public k f10012d;

    static {
        String str = z.f9497f;
        f10009e = f8.b.n("/");
    }

    @Override // od.o
    public final g0 a(z zVar) throws IOException {
        zVar.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // od.o
    public final void b(z zVar, z zVar2) throws IOException {
        zVar.getClass();
        zVar2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // od.o
    public final void c(z zVar) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // od.o
    public final void d(z zVar) throws IOException {
        zVar.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // od.o
    public final List g(z zVar) throws FileNotFoundException {
        zVar.getClass();
        z zVar2 = f10009e;
        zVar2.getClass();
        String strP = c.b(zVar2, zVar, true).c(zVar2).f9498c.p();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z10 = false;
        for (jb.g gVar : (List) this.f10012d.getValue()) {
            o oVar = (o) gVar.f6759c;
            z zVar3 = (z) gVar.f6760f;
            try {
                List listG = oVar.g(zVar3.d(strP));
                ArrayList arrayList = new ArrayList();
                for (Object obj : listG) {
                    if (f8.b.g((z) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(m.m0(arrayList, 10));
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    z zVar4 = (z) obj2;
                    zVar4.getClass();
                    String strReplace = hc.h.l0(zVar4.f9498c.p(), zVar3.f9498c.p()).replace('\\', JsonPointer.SEPARATOR);
                    strReplace.getClass();
                    arrayList2.add(zVar2.d(strReplace));
                }
                q.p0(arrayList2, linkedHashSet);
                z10 = true;
            } catch (IOException unused) {
            }
        }
        if (z10) {
            return l.L0(linkedHashSet);
        }
        od.f.d(zVar, "file not found: ");
        return null;
    }

    @Override // od.o
    public final n i(z zVar) {
        zVar.getClass();
        if (!f8.b.g(zVar)) {
            return null;
        }
        z zVar2 = f10009e;
        zVar2.getClass();
        String strP = c.b(zVar2, zVar, true).c(zVar2).f9498c.p();
        for (jb.g gVar : (List) this.f10012d.getValue()) {
            n nVarI = ((o) gVar.f6759c).i(((z) gVar.f6760f).d(strP));
            if (nVarI != null) {
                return nVarI;
            }
        }
        return null;
    }

    @Override // od.o
    public final u j(z zVar) throws FileNotFoundException {
        zVar.getClass();
        if (!f8.b.g(zVar)) {
            od.f.d(zVar, "file not found: ");
            return null;
        }
        z zVar2 = f10009e;
        zVar2.getClass();
        String strP = c.b(zVar2, zVar, true).c(zVar2).f9498c.p();
        Iterator it = ((List) this.f10012d.getValue()).iterator();
        while (it.hasNext()) {
            jb.g gVar = (jb.g) it.next();
            try {
                return ((o) gVar.f6759c).j(((z) gVar.f6760f).d(strP));
            } catch (FileNotFoundException unused) {
            }
        }
        od.f.d(zVar, "file not found: ");
        return null;
    }

    @Override // od.o
    public final g0 k(z zVar) throws IOException {
        zVar.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // od.o
    public final i0 l(z zVar) throws IOException {
        zVar.getClass();
        if (!f8.b.g(zVar)) {
            od.f.d(zVar, "file not found: ");
            return null;
        }
        z zVar2 = f10009e;
        zVar2.getClass();
        URL resource = this.f10010b.getResource(c.b(zVar2, zVar, false).c(zVar2).f9498c.p());
        if (resource == null) {
            od.f.d(zVar, "file not found: ");
            return null;
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        inputStream.getClass();
        return ac.a.W(inputStream);
    }
}
