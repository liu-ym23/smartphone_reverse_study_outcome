package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent2;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.ah0;
import com.bytedance.android.livesdk.config.dh0;
import com.bytedance.android.livesdk.config.t31;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class GestureDetectLayout extends FrameLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f160873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f160874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f160875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f160876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f160877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f160878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f160879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<View.OnTouchListener> f160880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<View.OnTouchListener> f160881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<WeakReference<y>> f160882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f160883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f160884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f160885m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f160886n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f160887o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f160888p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f160889q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y f160890r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f160891s;

    public interface a {
        void a(int r100);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
    }

    @Override // android.view.View
    public final boolean performClick() {
        y r100 = this.f160890r;
        if (r100 == null) goto L9;
        if (r100.a(this) == false) goto L9;
        return true;
    L9:
        return super.performClick();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e(false);
    }

    public GestureDetectLayout(Context r100) {
        super(r100);
        this.f160873a = false;
        this.f160874b = false;
        this.f160875c = false;
        this.f160880h = new ArrayList();
        this.f160881i = new ArrayList();
        this.f160882j = new ArrayList();
        this.f160884l = 35.0f;
        this.f160885m = false;
    }

    public final synchronized void a(y r100) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f160882j != null) goto L6;
        this.f160882j = new ArrayList();     // Catch: Throwable -> L19
    L6:
        Iterator r101 = ((ArrayList) this.f160882j).iterator();     // Catch: Throwable -> L19
    L8:
        if (r101.hasNext() == false) goto L14;
        WeakReference r102 = (WeakReference) r101.next();     // Catch: Throwable -> L19
        if (r102 == null) goto L8;
        if (r102.get() != r100) goto L8;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
        List<WeakReference<y>> r104 = this.f160882j;     // Catch: Throwable -> L19
        ArrayList r105 = (ArrayList) r104;     // Catch: Throwable -> L19
        r105.add(new WeakReference(r100));     // Catch: Throwable -> L19
        this.f160882j = GestureBehaviorSort.a(this.f160882j);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L14:
        r103 = false;
        goto L15
    }

    public final void b(View.OnTouchListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f160881i.contains(r100) == true) goto L9;
        this.f160881i.add(r100);
        return;
    }

    public final boolean c(MotionEvent r110) {
        int r100 = r110.getActionMasked();
        List<WeakReference<y>> r101 = this.f160882j;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L22:
        return r102;
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L22;
        Iterator r103 = ((ArrayList) this.f160882j).iterator();
        MotionEvent r104 = null;
    L8:
        if (r103.hasNext() == false) goto L22;
        WeakReference r105 = (WeakReference) r103.next();
        if (r105 == null) goto L8;
        y r106 = (y) r105.get();
        if (r106 == null) goto L8;
        if (r102 == false) goto L18;
        if (r100 == 0) goto L18;
        if (r104 != null) goto L17;
        long r107 = SystemClock.uptimeMillis();
        r104 = MotionEvent.obtain(r107, r107, 3, 0.0f, 0.0f, 0);
    L17:
        r106.c(this, r104);
    L18:
        if (r102 == true) goto L8;
        r102 = r106.c(this, r110);
        if (r102 == false) goto L8;
        ALogger.i("GestureDetectLayout", "dispatchTouchEvent-performDispatchTouchEvent behavior is " + r106);
        this.f160890r = r106;
        goto L8
    }

    public final synchronized void d(y r100) {
        monitor-enter(this);
        List<WeakReference<y>> r101 = this.f160882j;     // Catch: Throwable -> L23
        if (r101 != null) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (((ArrayList) r101).isEmpty() == true) goto L21;
        if (this.f160890r != r100) goto L11;
        this.f160890r = null;     // Catch: Throwable -> L23
    L11:
        Iterator r102 = ((ArrayList) this.f160882j).iterator();     // Catch: Throwable -> L23
    L13:
        if (r102.hasNext() == false) goto L19;
        WeakReference r103 = (WeakReference) r102.next();     // Catch: Throwable -> L23
        if (r103 == null) goto L13;
        if (r103.get() != r100) goto L13;
        r102.remove();     // Catch: Throwable -> L23
    L19:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = ((ArrayList) this.f160880h).size() - 1;
    L3:
        if (r101 < 0) goto L6;
        ((View.OnTouchListener) ListProtector.get(this.f160880h, r101)).onTouch(this, r100);
        r101 = r101 - 1;
        goto L3
    L6:
        if (r100 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L21;
        if (t31.f121270a.getValue().booleanValue() == false) goto L21;
        boolean r103 = super.dispatchTouchEvent(r100);
        boolean r104 = c(r100);
        if (r103 == true) goto L28;
        if (r104 == true) goto L29;
        return false;
    L29:
        return true;
    L28:
        return true;
    L21:
        if (c(r100) == false) goto L23;
        return true;
    L23:
        if (super.dispatchTouchEvent(r100) == true) goto L31;
        return false;
    L31:
        return true;
    L8:
        if (r100.getAction() != 0) goto L10;
        r102 = true;
        goto L11
    }

    public final void e(boolean r110) {
        List<WeakReference<y>> r100 = this.f160882j;
        if (r100 != null) goto L5;
    L18:
        this.f160890r = null;
        this.f160891s = false;
        return;
    L5:
        if (((ArrayList) r100).isEmpty() == true) goto L18;
        Iterator r101 = ((ArrayList) this.f160882j).iterator();
    L8:
        if (r101.hasNext() == false) goto L18;
        WeakReference r102 = (WeakReference) r101.next();
        if (r102 == null) goto L8;
        y r103 = (y) r102.get();
        if (r103 == null) goto L8;
        long r104 = SystemClock.uptimeMillis();
        MotionEvent r105 = MotionEvent.obtain(r104, r104, 3, 0.0f, 0.0f, 0);
        if (r110 == false) goto L16;
        r103.b(this, r105);
    L17:
        r105.recycle();
        goto L8
    L16:
        r103.onTouchEvent(this, r105);
        goto L17
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        int r100 = r110.getActionMasked();
        if (r100 != 0) goto L5;
        e(true);
    L5:
        int r101 = r110.getActionMasked();
        List<WeakReference<y>> r102 = this.f160882j;
        if (r102 != null) goto L8;
    L27:
        boolean r103 = false;
    L28:
        if (r100 != 1) goto L30;
    L31:
        e(true);
    L33:
        if (r110.getAction() != 0) goto L48;
        float r104 = r110.getY();
        if (r104 > this.f160876d) goto L37;
    L39:
        boolean r105 = false;
    L40:
        this.f160887o = r105;
        if (r104 > this.f160878f) goto L43;
    L45:
        boolean r106 = false;
    L46:
        this.f160888p = r106;
        goto L48
    L43:
        if (r104 >= this.f160879g) goto L45;
        r106 = true;
        goto L46
    L37:
        if (r104 >= this.f160877e) goto L39;
        r105 = true;
    L48:
        if (dh0.f120033a.getValue().booleanValue() == false) goto L73;
        if (this.f160873a == false) goto L54;
        if (this.f160887o == false) goto L54;
    L57:
        boolean r107 = true;
    L59:
        if (r107 == false) goto L73;
        if (this.f160889q.booleanValue() == true) goto L73;
        if (this.f160874b == true) goto L73;
        if (r110.getAction() != 0) goto L68;
        this.f160886n = r110.getX();
    L68:
        if (r110.getAction() != 2) goto L73;
        if (Math.abs(this.f160886n - r110.getX()) <= 10.0f) goto L73;
        return true;
    L54:
        if (this.f160875c == true) goto L56;
    L58:
        r107 = false;
        goto L59
    L56:
        if (this.f160888p == false) goto L58;
    L73:
        if (this.f160874b == false) goto L84;
        Boolean r108 = this.f160889q;
        if (r108 == null) goto L84;
        if (r108.booleanValue() == true) goto L84;
        Boolean r109 = ah0.f119790a.getValue();
        if (r109 == null) goto L84;
        if (r109.booleanValue() == false) goto L84;
        requestDisallowInterceptTouchEvent(true);
        return false;
    L84:
        if (r103 == false) goto L86;
        return true;
    L86:
        if (super.onInterceptTouchEvent(r110) == true) goto L105;
        return false;
    L105:
        return true;
    L30:
        if (r100 != 3) goto L33;
    L8:
        if (((ArrayList) r102).isEmpty() == true) goto L27;
        Iterator r111 = ((ArrayList) this.f160882j).iterator();
        MotionEvent r112 = null;
        r103 = false;
    L11:
        if (r111.hasNext() == false) goto L28;
        WeakReference r113 = (WeakReference) r111.next();
        if (r113 == null) goto L11;
        y r114 = (y) r113.get();
        if (r114 == null) goto L11;
        if (r103 == false) goto L21;
        if (r101 == 0) goto L21;
        if (r112 != null) goto L20;
        long r115 = SystemClock.uptimeMillis();
        r112 = MotionEvent.obtain(r115, r115, 3, 0.0f, 0.0f, 0);
    L20:
        r114.b(this, r112);
    L21:
        if (r103 == true) goto L11;
        r103 = r114.b(this, r110);
        if (r103 == false) goto L11;
        ALogger.i("GestureDetectLayout", "onInterceptTouchEvent-performIntercept behavior is " + r114);
        this.f160890r = r114;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        int r100 = r110.getActionMasked();
        int r101 = r110.getActionMasked();
        y r102 = this.f160890r;
        if (r102 == null) goto L5;
        r102.onTouchEvent(this, r110);
    L26:
        if (r100 != 1) goto L28;
    L29:
        e(false);
    L30:
        int r103 = ((ArrayList) this.f160881i).size() - 1;
    L31:
        if (r103 < 0) goto L33;
        ((View.OnTouchListener) ListProtector.get(this.f160881i, r103)).onTouch(this, r110);
        r103 = r103 - 1;
        goto L31
    L33:
        return true;
    L28:
        if (r100 != 3) goto L30;
    L5:
        List<WeakReference<y>> r104 = this.f160882j;
        if (r104 == null) goto L26;
        if (((ArrayList) r104).isEmpty() == true) goto L26;
        Iterator r105 = ((ArrayList) this.f160882j).iterator();
        MotionEvent r106 = null;
        boolean r107 = false;
    L11:
        if (r105.hasNext() == false) goto L26;
        WeakReference r108 = (WeakReference) r105.next();
        if (r108 == null) goto L11;
        y r109 = (y) r108.get();
        if (r109 == null) goto L11;
        if (r107 == false) goto L21;
        if (r101 == 0) goto L21;
        if (r106 != null) goto L20;
        long r111 = SystemClock.uptimeMillis();
        r106 = MotionEvent.obtain(r111, r111, 3, 0.0f, 0.0f, 0);
    L20:
        r109.onTouchEvent(this, r106);
    L21:
        if (r107 == true) goto L11;
        r107 = r109.onTouchEvent(this, r110);
        if (r107 == false) goto L11;
        ALogger.i("GestureDetectLayout", "onTouchEvent-performTouchEvent behavior is " + r109);
        this.f160890r = r109;
        goto L11
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f160891s == true) goto L9;
        e(false);
        this.f160891s = true;
        return;
    }

    public void setEnableSlide(boolean r100) {
        this.f160885m = r100;
    }

    public void setIsAnchor(Boolean r100) {
        this.f160889q = r100;
    }

    public void setIsInMultiAnchorLink(boolean r100) {
        this.f160875c = r100;
    }

    public void setIsInPk(boolean r100) {
        this.f160873a = r100;
    }

    public void setIsInPkGame(boolean r100) {
        this.f160874b = r100;
    }

    public void setMultiAnchorBottomY(int r100) {
        this.f160879g = r100;
    }

    public void setMultiAnchorTopY(int r100) {
        this.f160878f = r100;
    }

    public void setPkBottomY(int r100) {
        this.f160877e = r100;
    }

    public void setPkTopY(int r100) {
        this.f160876d = r100;
    }

    public void setSlideAction(a r100) {
        this.f160883k = r100;
    }

    public GestureDetectLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f160873a = false;
        this.f160874b = false;
        this.f160875c = false;
        this.f160880h = new ArrayList();
        this.f160881i = new ArrayList();
        this.f160882j = new ArrayList();
        this.f160884l = 35.0f;
        this.f160885m = false;
        this.f160884l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public GestureDetectLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160873a = false;
        this.f160874b = false;
        this.f160875c = false;
        this.f160880h = new ArrayList();
        this.f160881i = new ArrayList();
        this.f160882j = new ArrayList();
        this.f160884l = 35.0f;
        this.f160885m = false;
        this.f160884l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return super.onNestedPreFling(r100, r101, r102);
    L4:
        toString();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return super.onNestedFling(r100, r101, r102, r103);
    L4:
        toString();
        return false;
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        new Exception();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        super.setPaddingRelative(r100, r101, r102, r103);
        new Exception();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        if (this.f160885m == true) goto L5;
        return;
    L5:
        if (Math.abs(r101) > this.f160884l) goto L7;
        return;
    L7:
        if (Math.abs(r102) >= this.f160884l) goto L19;
        if (r104 != 0) goto L20;
        a r105 = this.f160883k;
        if (r105 == null) goto L21;
        r105.a(r101);
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.length <= 0) goto L23;
        r103[0] = r101;
        return;
    L23:
        return;
    L21:
        return;
    L20:
        return;
    }
}
