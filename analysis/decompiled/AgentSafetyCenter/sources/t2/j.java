package t2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public Object f13159a;

    /* renamed from: b, reason: collision with root package name */
    public m f13160b;

    /* renamed from: c, reason: collision with root package name */
    public n f13161c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13162d;

    public final void a(Object obj) {
        this.f13162d = true;
        m mVar = this.f13160b;
        if (mVar != null) {
            l lVar = mVar.f13165f;
            lVar.getClass();
            if (obj == null) {
                obj = i.f13155k;
            }
            if (i.f13154j.f(lVar, null, obj)) {
                i.c(lVar);
                this.f13159a = null;
                this.f13160b = null;
                this.f13161c = null;
            }
        }
    }

    public final void b(Throwable th) {
        this.f13162d = true;
        m mVar = this.f13160b;
        if (mVar == null || !mVar.f13165f.i(th)) {
            return;
        }
        this.f13159a = null;
        this.f13160b = null;
        this.f13161c = null;
    }

    public final void finalize() {
        n nVar;
        m mVar = this.f13160b;
        if (mVar != null) {
            l lVar = mVar.f13165f;
            if (!lVar.isDone()) {
                lVar.i(new c("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f13159a, 1));
            }
        }
        if (this.f13162d || (nVar = this.f13161c) == null) {
            return;
        }
        nVar.j(null);
    }
}
