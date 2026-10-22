package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.utils.y;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends FrameLayout implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f180955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SlcTemplateViewHelper f180956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SlcContext f180957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f180958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.g f180959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, a> f180960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f180961g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f180962a;

        public a(View r100) {
            this.f180962a = r100;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public final c asView() {
        return this;
    }

    public final void c() {
        if (this.f180958d == false) goto L5;
        return;
    L5:
        SlcTemplateViewHelper r100 = this.f180956b;
        if (r100 != null) goto L8;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == false) goto L18;
        this.f180958d = true;
        l r102 = this.f180955a;
        if (r102 == null) goto L19;
        r102.b1();
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (r100.f166930d != true) goto L12;
        if (getChildCount() == 0) goto L12;
        r101 = true;
        goto L13
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f180960f = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public final View a(String r100) {
        View r101 = null;
        if (r100 == null) goto L22;
        SlcTemplateViewHelper r102 = this.f180956b;
        if (r102 == null) goto L11;
        boolean r103 = true;
        if (r102.f166930d != true) goto L11;
        if (getChildCount() == 0) goto L11;
    L12:
        if (r103 == false) goto L22;
        a r104 = (a) ((LinkedHashMap) this.f180960f).get(r100);
        if (r104 != null) goto L21;
        SlcTemplateViewHelper r105 = this.f180956b;
        if (r105 == null) goto L19;
        r101 = r105.d(r100);
    L19:
        r104 = new a(r101);
        this.f180960f.put(r100, r104);
    L21:
        return r104.f180962a;
    L11:
        r103 = false;
    L22:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f180961g == false) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public void setDisableTouchEvent(boolean r100) {
        this.f180961g = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public void setOnViewReadyCallback(l r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f180955a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g
    public final boolean b(com.bytedance.android.ecom.arch.slice.g r100, Map<String, ? extends Object> r101, String r102) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f180956b == null) goto L11;
        com.bytedance.android.ecom.arch.slice.g r103 = this.f180959e;
        if (r103 == null) goto L11;
        int r104 = y.f187160a;
        if (y.h(r103, r100) != true) goto L11;
    L18:
        this.f180959e = r100;
        SlcTemplateViewHelper r105 = this.f180956b;
        if (r105 == null) goto L22;
        r105.b(r100, r101, r102);
    L22:
        if (getChildCount() != 0) goto L29;
        SlcTemplateViewHelper r106 = this.f180956b;
        if (r106 == null) goto L28;
        View r107 = SlcTemplateViewHelper.e(r106);
        if (r107 == null) goto L28;
        addView(r107, new FrameLayout.LayoutParams(-1, -2));
    L28:
        c();
    L29:
        return true;
    L11:
        SlcTemplateViewHelper r108 = new SlcTemplateViewHelper(new d(this));
        SlcContext r109 = this.f180957c;
        if (r109 == null) goto L15;
        r108.f(r109);
    L15:
        if (this.f180956b == null) goto L17;
        removeAllViews();
        ((LinkedHashMap) this.f180960f).clear();
    L17:
        this.f180956b = r108;
        goto L18
    }
}
