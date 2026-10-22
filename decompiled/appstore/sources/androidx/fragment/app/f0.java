package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3348d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3349e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f0 f3350f;

        public a(f0 r10, int r11, ArrayList r12, ArrayList r13, ArrayList r14, ArrayList r15) {
            this.f3350f = r10;
            this.f3345a = r11;
            this.f3346b = r12;
            this.f3347c = r13;
            this.f3348d = r14;
            this.f3349e = r15;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = 0;
        L4:
            if (r10 >= this.f3345a) goto L6;
            ViewCompat.H0((View) this.f3346b.get(r10), (String) this.f3347c.get(r10));
            ViewCompat.H0((View) this.f3348d.get(r10), (String) this.f3349e.get(r10));
            r10 = r10 + 1;
            goto L4
        }
    }

    public f0() {
    }

    public static void d(List r10, View r11) {
        int r12 = r10.size();
        if (g(r10, r11, r12) == false) goto L6;
        return;
    L6:
        if (ViewCompat.J(r11) == null) goto L8;
        r10.add(r11);
    L8:
        int r13 = r12;
    L10:
        if (r13 >= r10.size()) goto L22;
        View r14 = (View) r10.get(r13);
        if ((r14 instanceof ViewGroup) == false) goto L21;
        ViewGroup r15 = (ViewGroup) r14;
        int r16 = r15.getChildCount();
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L21;
        View r18 = r15.getChildAt(r17);
        if (g(r10, r18, r12) == true) goto L20;
        if (ViewCompat.J(r18) == null) goto L20;
        r10.add(r18);
    L20:
        r17 = r17 + 1;
    L21:
        r13 = r13 + 1;
        goto L10
    }

    public static boolean g(List r10, View r11, int r12) {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r10.get(r13) == r11) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean i(List r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.isEmpty() == true) goto L7;
        return false;
    }

    public abstract void a(Object r10, View r11);

    public abstract void b(Object r10, ArrayList r11);

    public abstract void c(ViewGroup r10, Object r11);

    public abstract boolean e(Object r10);

    public abstract Object f(Object r10);

    public void h(View r10, Rect r11) {
        if (ViewCompat.S(r10) == true) goto L5;
        return;
    L5:
        RectF r12 = new RectF();
        r12.set(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
        r10.getMatrix().mapRect(r12);
        r12.offset(r10.getLeft(), r10.getTop());
        Object r13 = r10.getParent();
    L7:
        if ((r13 instanceof View) == false) goto L9;
        View r14 = (View) r13;
        r12.offset(-r14.getScrollX(), -r14.getScrollY());
        r14.getMatrix().mapRect(r12);
        r12.offset(r14.getLeft(), r14.getTop());
        r13 = r14.getParent();
        goto L7
    L9:
        int[] r15 = new int[2];
        r10.getRootView().getLocationOnScreen(r15);
        r12.offset(r15[0], r15[1]);
        r11.set(Math.round(r12.left), Math.round(r12.top), Math.round(r12.right), Math.round(r12.bottom));
    }

    public abstract Object j(Object r10, Object r11, Object r12);

    public abstract Object k(Object r10, Object r11, Object r12);

    public ArrayList l(ArrayList r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        View r14 = (View) r10.get(r13);
        r11.add(ViewCompat.J(r14));
        ViewCompat.H0(r14, null);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public abstract void m(Object r10, View r11, ArrayList r12);

    public abstract void n(Object r10, Object r11, ArrayList r12, Object r13, ArrayList r14, Object r15, ArrayList r16);

    public abstract void o(Object r10, Rect r11);

    public abstract void p(Object r10, View r11);

    public abstract void q(Fragment r10, Object r11, CancellationSignal r12, Runnable r13);

    public void r(View r10, ArrayList r11, ArrayList r12, ArrayList r13, Map r14) {
        int r15 = r12.size();
        ArrayList r16 = new ArrayList();
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L14;
        View r18 = (View) r11.get(r17);
        String r19 = ViewCompat.J(r18);
        r16.add(r19);
        if (r19 == null) goto L13;
        ViewCompat.H0(r18, null);
        String r20 = (String) r14.get(r19);
        int r21 = 0;
    L8:
        if (r21 >= r15) goto L13;
        if (r20.equals(r13.get(r21)) == true) goto L11;
        r21 = r21 + 1;
        goto L8
    L11:
        ViewCompat.H0((View) r12.get(r21), r19);
    L13:
        r17 = r17 + 1;
        goto L3
    L14:
        androidx.core.view.j.a(r10, new a(this, r15, r12, r13, r11, r16));
    }

    public abstract void s(Object r10, View r11, ArrayList r12);

    public abstract void t(Object r10, ArrayList r11, ArrayList r12);

    public abstract Object u(Object r10);
}
