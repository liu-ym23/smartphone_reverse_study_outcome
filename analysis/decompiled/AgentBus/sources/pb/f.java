package pb;

import c7.j;
import h4.n;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import ob.k0;
import ob.m0;
import ob.o;
import ob.u;
import ob.v;
import ob.x;
import ob.z;
import q7.k;

/* loaded from: classes.dex */
public final class f extends o {

    /* renamed from: e, reason: collision with root package name */
    public static final z f8588e;

    /* renamed from: b, reason: collision with root package name */
    public final ClassLoader f8589b;

    /* renamed from: c, reason: collision with root package name */
    public final o f8590c;

    /* renamed from: d, reason: collision with root package name */
    public final c7.o f8591d;

    static {
        String str = z.f8042g;
        f8588e = n.l("/", false);
    }

    public f(ClassLoader classLoader) {
        v vVar = o.f8022a;
        k.e(vVar, "systemFileSystem");
        this.f8589b = classLoader;
        this.f8590c = vVar;
        this.f8591d = s7.a.H(new a8.c(25, this));
    }

    @Override // ob.o
    public final void a(z zVar, z zVar2) throws IOException {
        k.e(zVar2, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // ob.o
    public final void b(z zVar) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // ob.o
    public final void c(z zVar) throws IOException {
        throw new IOException(this + " is read-only");
    }

    @Override // ob.o
    public final ob.n e(z zVar) {
        k.e(zVar, "path");
        if (!n.e(zVar)) {
            return null;
        }
        z zVar2 = f8588e;
        zVar2.getClass();
        String strR = c.b(zVar2, zVar, true).d(zVar2).f8043f.r();
        for (j jVar : (List) this.f8591d.getValue()) {
            ob.n nVarE = ((o) jVar.f1973f).e(((z) jVar.f1974g).e(strR));
            if (nVarE != null) {
                return nVarE;
            }
        }
        return null;
    }

    @Override // ob.o
    public final u f(z zVar) throws FileNotFoundException {
        if (!n.e(zVar)) {
            throw new FileNotFoundException("file not found: " + zVar);
        }
        z zVar2 = f8588e;
        zVar2.getClass();
        String strR = c.b(zVar2, zVar, true).d(zVar2).f8043f.r();
        Iterator it = ((List) this.f8591d.getValue()).iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            try {
                return ((o) jVar.f1973f).f(((z) jVar.f1974g).e(strR));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + zVar);
    }

    @Override // ob.o
    public final u g(z zVar) throws IOException {
        k.e(zVar, "file");
        throw new IOException("resources are not writable");
    }

    @Override // ob.o
    public final k0 h(z zVar) throws FileNotFoundException {
        k.e(zVar, "file");
        if (!n.e(zVar)) {
            throw new FileNotFoundException("file not found: " + zVar);
        }
        z zVar2 = f8588e;
        zVar2.getClass();
        InputStream resourceAsStream = this.f8589b.getResourceAsStream(c.b(zVar2, zVar, false).d(zVar2).f8043f.r());
        if (resourceAsStream != null) {
            Logger logger = x.f8039a;
            return new ob.e(1, resourceAsStream, new m0());
        }
        throw new FileNotFoundException("file not found: " + zVar);
    }
}
