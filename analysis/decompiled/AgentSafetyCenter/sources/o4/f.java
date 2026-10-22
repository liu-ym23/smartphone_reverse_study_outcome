package o4;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements x4.a, sc.a {

    /* renamed from: c, reason: collision with root package name */
    public x4.a f9172c;

    /* renamed from: f, reason: collision with root package name */
    public sc.a f9173f;

    /* renamed from: g, reason: collision with root package name */
    public nb.g f9174g;

    /* renamed from: h, reason: collision with root package name */
    public Throwable f9175h;

    @Override // x4.a
    public final x4.c K(String str) {
        str.getClass();
        return this.f9172c.K(str);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        this.f9172c.close();
    }

    @Override // sc.a
    public final Object d(pb.c cVar) {
        return this.f9173f.d(cVar);
    }

    @Override // sc.a
    public final void e(Object obj) {
        this.f9173f.e(null);
    }

    public final void g(StringBuilder sb2) {
        if (this.f9174g == null && this.f9175h == null) {
            sb2.append("\t\tStatus: Free connection");
            sb2.append('\n');
            return;
        }
        sb2.append("\t\tStatus: Acquired connection");
        sb2.append('\n');
        nb.g gVar = this.f9174g;
        if (gVar != null) {
            sb2.append("\t\tCoroutine: " + gVar);
            sb2.append('\n');
        }
        Throwable th = this.f9175h;
        if (th != null) {
            sb2.append("\t\tAcquired:");
            sb2.append('\n');
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String string = stringWriter.toString();
            string.getClass();
            Iterator it = kb.l.u0(1, gc.m.U(hc.h.i0(string))).iterator();
            while (it.hasNext()) {
                sb2.append("\t\t" + ((String) it.next()));
                sb2.append('\n');
            }
        }
    }

    public final String toString() {
        return this.f9172c.toString();
    }
}
