package com.bytedance.android.ecom.arch.slice.slices.template;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.widget.SlcRootView;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u0013\u0010\f\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/slices/template/SlcTemplateView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundFrameLayout;", "", "Landroid/view/View;", "getSlcRootView", "Lcom/bytedance/android/ecom/arch/slice/render/b;", "actionHandler", "", "setActionHandler", "Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", "getTemplateContext", "()Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", "templateContext", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcTemplateView extends SlcRoundFrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f51041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f51043e;

    public SlcTemplateView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SlcTemplateView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public final SlcTemplateContext getTemplateContext() {
        r r100 = this.f51041c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f50700b;
    }

    public View getSlcRootView() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        View r102 = getChildAt(r101);
        if ((r102 instanceof SlcRootView) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return r102;
    L8:
        nq.a.c(null, AnonymousClass1.INSTANCE, 1);
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public final void setActionHandler(com.bytedance.android.ecom.arch.slice.render.b r100) {
        Intrinsics.checkNotNullParameter(r100, "actionHandler");
        r r101 = this.f51041c;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final void b(SlcContext r100, r r101) {
        Intrinsics.checkNotNullParameter(r100, "renderContext");
        Intrinsics.checkNotNullParameter(r101, "templateViewInfo");
        removeView(this.f51043e);
        addView(r101.f50701c);
        BaseSlcViewManager<?> r102 = r101.f50700b.f50218f;
        Object r103 = null;
        if (r102 == null) goto L5;
        SlcElement r104 = r102.f50270e;
    L6:
        if (r104 == null) goto L10;
        Map<String, Object> r105 = r104.getStyle();
        if (r105 == null) goto L10;
        r103 = r105.get("width");
    L10:
        if (r103 != null) goto L14;
        ViewGroup.LayoutParams r106 = r101.f50701c.getLayoutParams();
        if (r106 == null) goto L14;
        r106.width = -1;
    L14:
        Unit r107 = Unit.INSTANCE;
        this.f51041c = r101;
        this.f51042d = true;
        return;
    L5:
        r104 = null;
        goto L6
    }

    public SlcTemplateView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = new View(r100);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        Unit r104 = Unit.INSTANCE;
        this.f51043e = r103;
        addView(r103);
        setImportantForAccessibility(2);
    }

    public /* synthetic */ SlcTemplateView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
