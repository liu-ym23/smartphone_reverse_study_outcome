package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Transition f5072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal f5073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList f5074c;

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Transition f5075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f5076b;

        /* JADX INFO: renamed from: androidx.transition.p$a$a, reason: collision with other inner class name */
        public class C0052a extends o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayMap f5077a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f5078b;

            public C0052a(a r10, ArrayMap r11) {
                this.f5078b = r10;
                this.f5077a = r11;
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition r10) {
                ((ArrayList) this.f5077a.get(this.f5078b.f5076b)).remove(r10);
                r10.removeListener(this);
            }
        }

        public a(Transition r10, ViewGroup r11) {
            this.f5075a = r10;
            this.f5076b = r11;
        }

        public final void a() {
            this.f5076b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f5076b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (p.f5074c.remove(this.f5076b) == true) goto L5;
            return true;
        L5:
            ArrayMap r10 = p.b();
            ArrayList r11 = (ArrayList) r10.get(this.f5076b);
            ArrayList r12 = null;
            if (r11 != null) goto L9;
            r11 = new ArrayList();
            r10.put(this.f5076b, r11);
        L11:
            r11.add(this.f5075a);
            this.f5075a.addListener(new C0052a(this, r10));
            this.f5075a.captureValues(this.f5076b, false);
            if (r12 == null) goto L17;
            Iterator r13 = r12.iterator();
        L15:
            if (r13.hasNext() == false) goto L17;
            ((Transition) r13.next()).resume(this.f5076b);
        L17:
            this.f5075a.playTransition(this.f5076b);
            return true;
        L9:
            if (r11.size() <= 0) goto L11;
            r12 = new ArrayList(r11);
            goto L11
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            a();
            p.f5074c.remove(this.f5076b);
            ArrayList r11 = (ArrayList) p.b().get(this.f5076b);
            if (r11 != null) goto L5;
        L10:
            this.f5075a.clearValues(true);
            return;
        L5:
            if (r11.size() <= 0) goto L10;
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            ((Transition) r12.next()).resume(this.f5076b);
            goto L8
        }
    }

    static {
        f5072a = new AutoTransition();
        f5073b = new ThreadLocal();
        f5074c = new ArrayList();
    }

    public static void a(ViewGroup r10, Transition r11) {
        if (f5074c.contains(r10) == false) goto L5;
        return;
    L5:
        if (ViewCompat.T(r10) == false) goto L12;
        f5074c.add(r10);
        if (r11 != null) goto L9;
        r11 = f5072a;
    L9:
        Transition r12 = r11.clone();
        d(r10, r12);
        m.b(r10, null);
        c(r10, r12);
        return;
    }

    public static ArrayMap b() {
        WeakReference r10 = (WeakReference) f5073b.get();
        if (r10 == null) goto L7;
        ArrayMap r11 = (ArrayMap) r10.get();
        if (r11 == null) goto L7;
        return r11;
    L7:
        ArrayMap r12 = new ArrayMap();
        WeakReference r13 = new WeakReference(r12);
        f5073b.set(r13);
        return r12;
    }

    public static void c(ViewGroup r10, Transition r11) {
        if (r11 == null) goto L6;
        if (r10 == null) goto L7;
        a r12 = new a(r11, r10);
        r10.addOnAttachStateChangeListener(r12);
        r10.getViewTreeObserver().addOnPreDrawListener(r12);
        return;
    L7:
        return;
    }

    public static void d(ViewGroup r10, Transition r11) {
        ArrayList r12 = (ArrayList) b().get(r10);
        if (r12 != null) goto L5;
    L10:
        if (r11 == null) goto L12;
        r11.captureValues(r10, true);
    L12:
        m.a(r10);
        return;
    L5:
        if (r12.size() <= 0) goto L10;
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ((Transition) r13.next()).pause(r10);
        goto L8
    }
}
