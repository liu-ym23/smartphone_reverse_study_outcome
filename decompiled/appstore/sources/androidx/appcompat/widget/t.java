package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: loaded from: classes.dex */
public abstract class t implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f1111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f1112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f1113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f1116i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f1117a;

        public a(t r10) {
            this.f1117a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent r10 = this.f1117a.f1111d.getParent();
            if (r10 == null) goto L6;
            r10.requestDisallowInterceptTouchEvent(true);
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f1118a;

        public b(t r10) {
            this.f1118a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1118a.e();
        }
    }

    public t(View r10) {
        this.f1116i = new int[2];
        this.f1111d = r10;
        r10.setLongClickable(true);
        r10.addOnAttachStateChangeListener(this);
        this.f1108a = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
        int r11 = ViewConfiguration.getTapTimeout();
        this.f1109b = r11;
        this.f1110c = (r11 + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View r10, float r11, float r12, float r13) {
        float r14 = -r13;
        if (r11 >= r14) goto L5;
    L11:
        return false;
    L5:
        if (r12 < r14) goto L11;
        if (r11 >= ((r10.getRight() - r10.getLeft()) + r13)) goto L11;
        if (r12 >= ((r10.getBottom() - r10.getTop()) + r13)) goto L11;
        return true;
    }

    public final void a() {
        Runnable r10 = this.f1113f;
        if (r10 == null) goto L5;
        this.f1111d.removeCallbacks(r10);
    L5:
        Runnable r11 = this.f1112e;
        if (r11 == null) goto L9;
        this.f1111d.removeCallbacks(r11);
        return;
    }

    public abstract ShowableListMenu b();

    public abstract boolean c();

    public boolean d() {
        ShowableListMenu r10 = b();
        if (r10 != null) goto L5;
        return true;
    L5:
        if (r10.isShowing() == false) goto L10;
        r10.dismiss();
        return true;
    L10:
        return true;
    }

    public void e() {
        a();
        View r10 = this.f1111d;
        if (r10.isEnabled() == true) goto L5;
        return;
    L5:
        if (r10.isLongClickable() == false) goto L8;
        return;
    L8:
        if (c() == true) goto L10;
        return;
    L10:
        r10.getParent().requestDisallowInterceptTouchEvent(true);
        long r11 = SystemClock.uptimeMillis();
        MotionEvent r12 = MotionEvent.obtain(r11, r11, 3, 0.0f, 0.0f, 0);
        r10.onTouchEvent(r12);
        r12.recycle();
        this.f1114g = true;
    }

    public final boolean f(MotionEvent r10) {
        View r11 = this.f1111d;
        ShowableListMenu r12 = b();
        if (r12 != null) goto L5;
        return false;
    L5:
        if (r12.isShowing() == false) goto L26;
        s r13 = (s) r12.getListView();
        if (r13 != null) goto L10;
        return false;
    L10:
        if (r13.isShown() == false) goto L27;
        MotionEvent r14 = MotionEvent.obtainNoHistory(r10);
        i(r11, r14);
        j(r13, r14);
        boolean r15 = r13.e(r14, this.f1115h);
        r14.recycle();
        int r16 = r10.getActionMasked();
        if (r16 != 1) goto L15;
    L17:
        boolean r17 = false;
    L18:
        if (r15 == false) goto L24;
        if (r17 == true) goto L21;
        return false;
    L21:
        return true;
    L24:
        return false;
    L15:
        if (r16 == 3) goto L17;
        r17 = true;
        goto L18
    L27:
        return false;
    L26:
        return false;
    }

    public final boolean g(MotionEvent r10) {
        View r11 = this.f1111d;
        if (r11.isEnabled() == true) goto L5;
        return false;
    L5:
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L8;
        this.f1115h = r10.getPointerId(0);
        if (this.f1112e != null) goto L24;
        this.f1112e = new a(this);
    L24:
        r11.postDelayed(this.f1112e, this.f1109b);
        if (this.f1113f != null) goto L27;
        this.f1113f = new b(this);
    L27:
        r11.postDelayed(this.f1113f, this.f1110c);
    L28:
        return false;
    L8:
        if (r12 != 1) goto L10;
    L20:
        a();
        goto L28
    L10:
        if (r12 != 2) goto L12;
        int r13 = r10.findPointerIndex(this.f1115h);
        if (r13 < 0) goto L28;
        if (h(r11, r10.getX(r13), r10.getY(r13), this.f1108a) == true) goto L28;
        a();
        r11.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        if (r12 == 3) goto L20;
        goto L20
    }

    public final boolean i(View r10, MotionEvent r11) {
        int[] r12 = this.f1116i;
        r10.getLocationOnScreen(r12);
        r11.offsetLocation(r12[0], r12[1]);
        return true;
    }

    public final boolean j(View r10, MotionEvent r11) {
        int[] r12 = this.f1116i;
        r10.getLocationOnScreen(r12);
        r11.offsetLocation(-r12[0], -r12[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r11, MotionEvent r12) {
        boolean r13 = this.f1114g;
        if (r13 == false) goto L12;
        if (f(r12) == false) goto L7;
    L10:
        boolean r14 = true;
    L19:
        this.f1114g = r14;
        if (r14 == true) goto L25;
        if (r13 == false) goto L24;
        return true;
    L24:
        return false;
    L25:
        return true;
    L7:
        if (d() == false) goto L10;
        r14 = false;
        goto L19
    L12:
        if (g(r12) == true) goto L14;
    L16:
        r14 = false;
    L17:
        if (r14 == false) goto L19;
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r15 = MotionEvent.obtain(r10, r10, 3, 0.0f, 0.0f, 0);
        this.f1111d.onTouchEvent(r15);
        r15.recycle();
        goto L19
    L14:
        if (c() == false) goto L16;
        r14 = true;
        goto L17
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r10) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r10) {
        this.f1114g = false;
        this.f1115h = -1;
        Runnable r11 = this.f1112e;
        if (r11 == null) goto L6;
        this.f1111d.removeCallbacks(r11);
        return;
    }
}
