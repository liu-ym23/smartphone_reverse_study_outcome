package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public class LiveMessageRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f118540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f118541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f118542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f118543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f118544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f118545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f118546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<cs1.b> f118547h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f118548i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f118549j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f118550k;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollBehaviors {
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void a();
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return super.getBottomFadingEdgeStrength();
    }

    public final void t() {
        if (getVisibility() == 0) goto L5;
    L9:
        boolean r100 = false;
    L10:
        a r101 = this.f118549j;
        if (r101 == null) goto L28;
        TextMessageWidget r102 = ((com.bytedance.android.livesdk.interactivity.publicscreen.widget.f) r101).f140492a;
        boolean r103 = TextMessageWidget.V0;
        if (r100 == true) goto L16;
        r102.getClass();
        return;
    L16:
        if (r102.isViewValid() == false) goto L31;
        LiveMessageRecyclerView r104 = r102.f140459o;
        if (r104 == null) goto L32;
        RecyclerView.Adapter<?> r105 = r104.getAdapter();
        if (r105 == null) goto L33;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r106 = r102.Z;
        if (r106 == null) goto L30;
        r106.a(r105);
        return;
    L30:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L28:
        return;
    L5:
        if (getWindowVisibility() != 0) goto L9;
        if (isAttachedToWindow() == false) goto L9;
        r100 = true;
        goto L10
    }

    public LiveMessageRecyclerView(Context r100) {
        super(r100);
        this.f118544e = 0;
        this.f118545f = false;
        this.f118546g = 300;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L11;
        ViewParent r101 = getParent();
    L5:
        if (r101 == null) goto L9;
        if ((r101 instanceof cs1.a) == true) goto L9;
        r101 = r101.getParent();
    L9:
        if (r101 == null) goto L11;
        ((cs1.a) r101).setDisallowInterceptOnce(true);
    L11:
        int r102 = this.f118544e;
        if (r102 == 1) goto L43;
        if (r102 != 2) goto L15;
        this.f118541b = r100.getY();
        if (r100.getAction() != 0) goto L23;
        float r103 = r100.getY();
        this.f118540a = r103;
        this.f118543d = r103;
        this.f118542c = 0.0f;
    L42:
        return super.dispatchTouchEvent(r100);
    L23:
        if (r100.getAction() == 2) goto L25;
        this.f118542c = 0.0f;
        goto L42
    L25:
        if (canScrollVertically(1) == true) goto L27;
        this.f118542c += this.f118541b - this.f118543d;
    L28:
        this.f118543d = this.f118541b;
        if (Math.abs(this.f118542c) > this.f118546g) goto L31;
    L39:
        r(true);
        goto L42
    L31:
        if (canScrollVertically(1) == true) goto L39;
        r(false);
        if (getParent() == null) goto L42;
        WeakReference<cs1.b> r104 = this.f118547h;
        if (r104 == null) goto L42;
        cs1.b r105 = r104.get();
        if (r105 == null) goto L42;
        boolean r106 = super.dispatchTouchEvent(r100);
        MotionEvent r107 = r105.c();
        r107.setAction(0);
        r107.offsetLocation(0.0f, r105.getViewTouchSlop() + 1.0f);
        r105.d(r107);
        r107.recycle();
        return r106;
    L27:
        this.f118542c = 0.0f;
        goto L28
    L15:
        if (r100.getAction() != 0) goto L63;
        ViewParent r108 = getParent();
        if (r108 == null) goto L63;
        r108.requestDisallowInterceptTouchEvent(true);
    L63:
        return super.dispatchTouchEvent(r100);
    L43:
        this.f118541b = r100.getY();
        if (r100.getAction() != 0) goto L47;
        this.f118540a = r100.getY();
        goto L63
    L47:
        if (r100.getAction() != 2) goto L63;
        float r109 = this.f118541b - this.f118540a;
        if (this.f118545f == false) goto L57;
        if (r109 < 0.0f) goto L53;
    L55:
        r(true);
        goto L63
    L53:
        if (getScrollY() != 0) goto L55;
        r(false);
        goto L63
    L57:
        if (Math.abs(r109) > 0.0f) goto L59;
    L61:
        r(true);
        goto L63
    L59:
        if (getScrollY() != 0) goto L61;
        r(false);
        goto L63
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        t();
    }

    public final void r(boolean r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter r100) {
        if (r100 != null) goto L6;
        ALogger.w("textmessage", "on set adapter null");
        if (MainThreadPostUtils.a() == true) goto L6;
        SafetyGuard.a(null, new IllegalStateException("on set adapter null in sub thread"), "textmessage adapter null");
    L6:
        super.setAdapter(r100);
    }

    public void setCanScrollUp(boolean r100) {
        this.f118545f = r100;
    }

    public void setOnCustomVisibleChangedListener(a r100) {
        this.f118549j = r100;
    }

    public void setOnHeightChangeListener(b r100) {
        this.f118550k = r100;
    }

    public void setOnVisibilityChangedListener(c r100) {
        this.f118548i = r100;
    }

    public void setOverScrollTransEdge(int r100) {
        this.f118546g = r100;
    }

    public void setScrollBehavior(int r100) {
        this.f118544e = r100;
    }

    public void setTouchTransmitParent(cs1.b r100) {
        this.f118547h = new WeakReference(r100);
    }

    public void setTouchTransmitParent(WeakReference<cs1.b> r100) {
        this.f118547h = r100;
    }

    public LiveMessageRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f118544e = 0;
        this.f118545f = false;
        this.f118546g = 300;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        c r102 = this.f118548i;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        t();
    }

    public LiveMessageRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f118544e = 0;
        this.f118545f = false;
        this.f118546g = 300;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r103 == r101) goto L8;
        b r104 = this.f118550k;
        if (r104 == null) goto L9;
        ((com.bytedance.android.livesdk.interactivity.publicscreen.widget.g) r104).a(r103, r101);
        return;
    L9:
        return;
    }
}
