package com.bytedance.android.shopping.anchorv4.topnav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.p;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.utils.y;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/topnav/AnchorV4TopNavViewOpt;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/topnav/g;", "", RXScreenCaptureService.KEY_INDEX, "Z", "getDisableTouchEvent", "()Z", "setDisableTouchEvent", "(Z)V", "disableTouchEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4TopNavViewOpt extends FrameLayout implements g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f167467j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SlcTemplateViewHelper f167468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SlcContext f167469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.g f167470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Object> f167471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IdentityHashMap<com.bytedance.android.ecom.arch.slice.g, com.bytedance.android.ecom.arch.slice.h> f167472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, j> f167473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f167474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f167475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f167476i;

    public static final class a implements com.bytedance.android.ecom.arch.slice.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4TopNavViewOpt f167477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ecom.arch.slice.g f167478b;

        @Override // com.bytedance.android.ecom.arch.slice.h
        public final void f1(boolean r100) {
            AnchorV4TopNavViewOpt r101 = this.f167477a;
            r101.b(this.f167478b, r101.f167471d);
        }

        public a(AnchorV4TopNavViewOpt r100, com.bytedance.android.ecom.arch.slice.g r101) {
            this.f167477a = r100;
            this.f167478b = r101;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.topnav.g
    public final AnchorV4TopNavViewOpt asView() {
        return this;
    }

    public final void d() {
        Iterator<T> r100 = this.f167472e.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.ecom.arch.slice.g) r100.next()).setSliceRebindTarget(null);
        goto L4
    L6:
        this.f167472e.clear();
    }

    public final void f() {
        if (this.f167475h == true) goto L17;
        SlcTemplateViewHelper r100 = this.f167468a;
        if (r100 != null) goto L7;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L18;
        this.f167475h = true;
        h r102 = this.f167474g;
        if (r102 == null) goto L19;
        r102.onViewReady();
        return;
    L19:
        return;
    L18:
        return;
    L7:
        if (r100.f166930d != true) goto L11;
        if (getChildCount() == 0) goto L11;
        r101 = true;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    public boolean getDisableTouchEvent() {
        return this.f167476i;
    }

    @Override // com.bytedance.android.shopping.anchorv4.topnav.g
    public final View a(String r100) {
        View r101 = null;
        if (r100 == null) goto L22;
        SlcTemplateViewHelper r102 = this.f167468a;
        if (r102 == null) goto L11;
        boolean r103 = true;
        if (r102.f166930d != true) goto L11;
        if (getChildCount() == 0) goto L11;
    L12:
        if (r103 == false) goto L22;
        j r104 = (j) ((LinkedHashMap) this.f167473f).get(r100);
        if (r104 != null) goto L21;
        SlcTemplateViewHelper r105 = this.f167468a;
        if (r105 == null) goto L19;
        r101 = r105.d(r100);
    L19:
        r104 = new j(r101);
        this.f167473f.put(r100, r104);
    L21:
        return r104.f167495a;
    L11:
        r103 = false;
    L22:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (getDisableTouchEvent() == false) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.topnav.g
    public void setDisableTouchEvent(boolean r100) {
        this.f167476i = r100;
    }

    public AnchorV4TopNavViewOpt(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f167472e = new IdentityHashMap();
        this.f167473f = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.anchorv4.topnav.g
    public final void b(com.bytedance.android.ecom.arch.slice.g r100, Map<String, ? extends Object> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f167471d = r101;
        if (this.f167470c == r100) goto L7;
        d();
    L7:
        e(r100, r100);
        SlcContext r102 = this.f167469b;
        if (r102 == null) goto L13;
        com.bytedance.android.ecom.arch.slice.d r103 = r102.f49961v0;
        if (r103 == null) goto L13;
        r103.G("top_nav_v1", new AnchorV4TopNavViewOpt$bindSlice$1(this));
    L13:
        if (this.f167468a == null) goto L18;
        com.bytedance.android.ecom.arch.slice.g r104 = this.f167470c;
        if (r104 == null) goto L18;
        int r105 = y.f187160a;
        if (y.h(r104, r100) != true) goto L18;
    L25:
        this.f167470c = r100;
        SlcTemplateViewHelper r106 = this.f167468a;
        if (r106 == null) goto L29;
        r106.b(r100, MapsKt.mapOf(TuplesKt.to("native", r101)), null);
    L29:
        if (getChildCount() != 0) goto L37;
        SlcTemplateViewHelper r107 = this.f167468a;
        if (r107 == null) goto L35;
        View r108 = SlcTemplateViewHelper.e(r107);
        if (r108 == null) goto L35;
        addView(r108, new FrameLayout.LayoutParams(-1, -2));
    L35:
        f();
        return;
    L37:
        return;
    L18:
        SlcTemplateViewHelper r109 = new SlcTemplateViewHelper(new b(this));
        SlcContext r110 = this.f167469b;
        if (r110 == null) goto L22;
        r109.f(r110);
    L22:
        if (this.f167468a == null) goto L24;
        removeAllViews();
        ((LinkedHashMap) this.f167473f).clear();
    L24:
        this.f167468a = r109;
        goto L25
    }

    @Override // com.bytedance.android.shopping.anchorv4.topnav.g
    public final void c(SlcContext r100, AnchorV4TopNavComponent.a r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f167469b = r100;
        this.f167474g = r101;
    }

    public final void e(com.bytedance.android.ecom.arch.slice.g r100, com.bytedance.android.ecom.arch.slice.g r101) {
        if (this.f167472e.containsKey(r100) == false) goto L5;
        return;
    L5:
        a r102 = new a(this, r101);
        r100.setSliceRebindTarget(r102);
        this.f167472e.put(r100, r102);
        if ((r100 instanceof p) == false) goto L13;
        List<com.bytedance.android.ecom.arch.slice.g> r103 = ((p) r100).a();
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        e((com.bytedance.android.ecom.arch.slice.g) r104.next(), r101);
        goto L11
    L16:
        return;
    L15:
        return;
    }
}
