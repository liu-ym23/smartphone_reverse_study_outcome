package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class u extends MutableLiveData {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i.b f3571l;

    public static class a implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveData f3572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observer f3573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3574c;

        public a(LiveData r10, Observer r11) {
            this.f3574c = -1;
            this.f3572a = r10;
            this.f3573b = r11;
        }

        public void a() {
            this.f3572a.j(this);
        }

        public void b() {
            this.f3572a.n(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object r10) {
            if (this.f3574c == this.f3572a.f()) goto L6;
            this.f3574c = this.f3572a.f();
            this.f3573b.onChanged(r10);
            return;
        }
    }

    public u() {
        this.f3571l = new i.b();
    }

    @Override // androidx.lifecycle.LiveData
    public void k() {
        Iterator r10 = this.f3571l.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((a) ((Map.Entry) r10.next()).getValue()).a();
        goto L4
    }

    @Override // androidx.lifecycle.LiveData
    public void l() {
        Iterator r10 = this.f3571l.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((a) ((Map.Entry) r10.next()).getValue()).b();
        goto L4
    }

    public void q(LiveData r10, Observer r11) {
        if (r10 == null) goto L17;
        a r12 = new a(r10, r11);
        a r13 = (a) this.f3571l.f(r10, r12);
        if (r13 != null) goto L6;
    L10:
        if (r13 == null) goto L13;
        return;
    L13:
        if (g() == false) goto L18;
        r12.a();
        return;
    L18:
        return;
    L6:
        if (r13.f3573b == r11) goto L10;
        throw new IllegalArgumentException("This source was already added with the different observer");
    L17:
        throw new NullPointerException("source cannot be null");
    }

    public void r(LiveData r10) {
        a r11 = (a) this.f3571l.g(r10);
        if (r11 == null) goto L6;
        r11.b();
        return;
    }
}
