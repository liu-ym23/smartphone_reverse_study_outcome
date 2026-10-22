package kotlinx.coroutines;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ch extends kotlinx.coroutines.internal.x implements bf, bu, bw {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ci f39184c;

    @Override // kotlinx.coroutines.bu
    public boolean n_() {
        return true;
    }

    @Override // kotlinx.coroutines.bu
    public cn o_() {
        return null;
    }

    public ch() {
    }

    public final void a(ci r1) {
        this.f39184c = r1;
    }

    public final ci c() {
        ci r0 = this.f39184c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d.h.b.o.c("job");
        return null;
    }

    @Override // kotlinx.coroutines.bf
    public void dispose() {
        c().a(this);
    }

    @Override // kotlinx.coroutines.internal.x
    public String toString() {
        return ar.b(this) + '@' + ar.a(this) + "[job@" + ar.a(c()) + ']';
    }
}
