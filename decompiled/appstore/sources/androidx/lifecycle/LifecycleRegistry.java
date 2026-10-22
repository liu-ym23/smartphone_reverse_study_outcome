package androidx.lifecycle;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.f1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f3432k = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i.a f3434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle.State f3435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f3436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f3440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableStateFlow f3441j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State r10, Lifecycle.State r11) {
            kotlin.jvm.internal.q.g(r10, "state1");
            if (r11 != null) goto L5;
            return r10;
        L5:
            if (r11.compareTo(r10) < 0) goto L7;
            return r10;
        L7:
            return r11;
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Lifecycle.State f3442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LifecycleEventObserver f3443b;

        public b(LifecycleObserver r10, Lifecycle.State r11) {
            kotlin.jvm.internal.q.g(r11, "initialState");
            kotlin.jvm.internal.q.d(r10);
            this.f3443b = t.f(r10);
            this.f3442a = r11;
        }

        public final void a(LifecycleOwner r10, Lifecycle.Event r11) {
            kotlin.jvm.internal.q.g(r11, "event");
            Lifecycle.State r12 = r11.getTargetState();
            this.f3442a = LifecycleRegistry.f3432k.a(this.f3442a, r12);
            LifecycleEventObserver r13 = this.f3443b;
            kotlin.jvm.internal.q.d(r10);
            r13.onStateChanged(r10, r11);
            this.f3442a = r12;
        }

        public final Lifecycle.State b() {
            return this.f3442a;
        }

        public final void setLifecycleObserver(@NotNull LifecycleEventObserver r10) {
            kotlin.jvm.internal.q.g(r10, "<set-?>");
            this.f3443b = r10;
        }
    }

    static {
        f3432k = new a(null);
    }

    public LifecycleRegistry(LifecycleOwner r10, boolean r11) {
        this.f3433b = r11;
        this.f3434c = new i.a();
        Lifecycle.State r12 = Lifecycle.State.INITIALIZED;
        this.f3435d = r12;
        this.f3440i = new ArrayList();
        this.f3436e = new WeakReference(r10);
        this.f3441j = f1.a(r12);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(LifecycleObserver r10) {
        kotlin.jvm.internal.q.g(r10, "observer");
        g("addObserver");
        Lifecycle.State r11 = this.f3435d;
        Lifecycle.State r12 = Lifecycle.State.DESTROYED;
        if (r11 == r12) goto L6;
        r12 = Lifecycle.State.INITIALIZED;
    L6:
        b r13 = new b(r10, r12);
        if (((b) this.f3434c.f(r10, r13)) == null) goto L9;
        return;
    L9:
        LifecycleOwner r14 = (LifecycleOwner) this.f3436e.get();
        if (r14 != null) goto L13;
        return;
    L13:
        if (this.f3437f == 0) goto L15;
    L18:
        boolean r15 = true;
    L19:
        Lifecycle.State r16 = f(r10);
        this.f3437f++;
    L21:
        if (r13.b().compareTo(r16) >= 0) goto L29;
        if (this.f3434c.contains(r10) == false) goto L29;
        m(r13.b());
        Lifecycle.Event r17 = Lifecycle.Event.Companion.c(r13.b());
        if (r17 == null) goto L28;
        r13.a(r14, r17);
        l();
        r16 = f(r10);
        goto L21
    L28:
        throw new IllegalStateException("no event up from " + r13.b());
    L29:
        if (r15 == true) goto L31;
        o();
    L31:
        this.f3437f--;
        return;
    L15:
        if (this.f3438g == true) goto L18;
        r15 = false;
        goto L19
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State b() {
        return this.f3435d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void d(LifecycleObserver r10) {
        kotlin.jvm.internal.q.g(r10, "observer");
        g("removeObserver");
        this.f3434c.g(r10);
    }

    public final void e(LifecycleOwner r10) {
        Iterator r11 = this.f3434c.descendingIterator();
        kotlin.jvm.internal.q.f(r11, "observerMap.descendingIterator()");
    L4:
        if (r11.hasNext() == false) goto L19;
        if (this.f3439h == true) goto L27;
        Map.Entry r12 = (Map.Entry) r11.next();
        kotlin.jvm.internal.q.f(r12, "next()");
        LifecycleObserver r13 = (LifecycleObserver) r12.getKey();
        b r14 = (b) r12.getValue();
    L9:
        if (r14.b().compareTo(this.f3435d) <= 0) goto L4;
        if (this.f3439h == true) goto L4;
        if (this.f3434c.contains(r13) == false) goto L4;
        Lifecycle.Event r15 = Lifecycle.Event.Companion.a(r14.b());
        if (r15 == null) goto L18;
        m(r15.getTargetState());
        r14.a(r10, r15);
        l();
        goto L9
    L18:
        throw new IllegalStateException("no event down from " + r14.b());
    L27:
        return;
    }

    public final Lifecycle.State f(LifecycleObserver r10) {
        Map.Entry r11 = this.f3434c.h(r10);
        Lifecycle.State r12 = null;
        if (r11 == null) goto L7;
        b r13 = (b) r11.getValue();
        if (r13 == null) goto L7;
        Lifecycle.State r14 = r13.b();
    L9:
        if (this.f3440i.isEmpty() == true) goto L11;
        ArrayList r15 = this.f3440i;
        r12 = (Lifecycle.State) r15.get(r15.size() - 1);
    L11:
        a r16 = f3432k;
        return r16.a(r16.a(this.f3435d, r14), r12);
    L7:
        r14 = null;
        goto L9
    }

    public final void g(String r10) {
        if (this.f3433b == true) goto L5;
        return;
    L5:
        if (h.c.h().c() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(("Method " + r10 + " must be called on the main thread").toString());
    }

    public final void h(LifecycleOwner r10) {
        i.b.d r11 = this.f3434c.c();
        kotlin.jvm.internal.q.f(r11, "observerMap.iteratorWithAdditions()");
    L4:
        if (r11.hasNext() == false) goto L19;
        if (this.f3439h == true) goto L27;
        Map.Entry r12 = (Map.Entry) r11.next();
        LifecycleObserver r13 = (LifecycleObserver) r12.getKey();
        b r14 = (b) r12.getValue();
    L9:
        if (r14.b().compareTo(this.f3435d) >= 0) goto L4;
        if (this.f3439h == true) goto L4;
        if (this.f3434c.contains(r13) == false) goto L4;
        m(r14.b());
        Lifecycle.Event r15 = Lifecycle.Event.Companion.c(r14.b());
        if (r15 == null) goto L18;
        r14.a(r10, r15);
        l();
        goto L9
    L18:
        throw new IllegalStateException("no event up from " + r14.b());
    L27:
        return;
    }

    public void handleLifecycleEvent(@NotNull Lifecycle.Event r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        g("handleLifecycleEvent");
        k(r10.getTargetState());
    }

    public final boolean i() {
        if (this.f3434c.size() != 0) goto L5;
        return true;
    L5:
        Map.Entry r10 = this.f3434c.a();
        kotlin.jvm.internal.q.d(r10);
        Lifecycle.State r11 = ((b) r10.getValue()).b();
        Map.Entry r12 = this.f3434c.d();
        kotlin.jvm.internal.q.d(r12);
        Lifecycle.State r13 = ((b) r12.getValue()).b();
        if (r11 == r13) goto L8;
    L10:
        return false;
    L8:
        if (this.f3435d != r13) goto L10;
        return true;
    }

    public void j(Lifecycle.State r10) {
        kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        g("markState");
        n(r10);
    }

    public final void k(Lifecycle.State r10) {
        Lifecycle.State r11 = this.f3435d;
        if (r11 != r10) goto L6;
        return;
    L6:
        if (r11 == Lifecycle.State.INITIALIZED) goto L8;
    L12:
        this.f3435d = r10;
        if (this.f3438g == false) goto L15;
    L21:
        this.f3439h = true;
        return;
    L15:
        if (this.f3437f != 0) goto L21;
        this.f3438g = true;
        o();
        this.f3438g = false;
        if (this.f3435d != Lifecycle.State.DESTROYED) goto L23;
        this.f3434c = new i.a();
        return;
    L23:
        return;
    L8:
        if (r10 != Lifecycle.State.DESTROYED) goto L12;
        throw new IllegalStateException(("no event down from " + this.f3435d + " in component " + this.f3436e.get()).toString());
    }

    public final void l() {
        ArrayList r10 = this.f3440i;
        r10.remove(r10.size() - 1);
    }

    public final void m(Lifecycle.State r10) {
        this.f3440i.add(r10);
    }

    public void n(Lifecycle.State r10) {
        kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        g("setCurrentState");
        k(r10);
    }

    public final void o() {
        LifecycleOwner r10 = (LifecycleOwner) this.f3436e.get();
        if (r10 == null) goto L18;
    L5:
        if (i() == true) goto L15;
        this.f3439h = false;
        Lifecycle.State r11 = this.f3435d;
        Map.Entry r12 = this.f3434c.a();
        kotlin.jvm.internal.q.d(r12);
        if (r11.compareTo(((b) r12.getValue()).b()) >= 0) goto L9;
        e(r10);
    L9:
        Map.Entry r13 = this.f3434c.d();
        if (this.f3439h == true) goto L5;
        if (r13 == null) goto L5;
        if (this.f3435d.compareTo(((b) r13.getValue()).b()) <= 0) goto L5;
        h(r10);
        goto L5
    L15:
        this.f3439h = false;
        this.f3441j.setValue(b());
        return;
    L18:
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    public LifecycleRegistry(LifecycleOwner r10) {
        kotlin.jvm.internal.q.g(r10, "provider");
        this(r10, true);
    }
}
