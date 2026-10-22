package com.bytedance.android.ec.core.slice.ectaggroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.slice.ectag.ECTagViewWrapper;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/slice/ectaggroup/ECTagGroupViewWrapper;", "Landroid/widget/FrameLayout;", "", "serverTimeSecond", "", "setServerTime", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagGroupViewWrapper extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f45337c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SlcRenderContext f45338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f45339b;

    public static final class a {
    }

    public ECTagGroupViewWrapper(Context r100) {
        this(r100, null, 0, 14);
    }

    public ECTagGroupViewWrapper(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public ECTagGroupViewWrapper(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    static {
        f45337c = LazyKt.lazy(ECTagGroupViewWrapper$Companion$ecTagGroupElement$2.INSTANCE);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 == null) goto L8;
        r r101 = this.f45339b;
        if (r101 == null) goto L8;
        View r102 = r101.f50701c;
        if (r102 == null) goto L8;
        r102.setLayoutParams(new FrameLayout.LayoutParams(r100.width, r100.height));
    L8:
        super.setLayoutParams(r100);
    }

    public final void setServerTime(long r100) {
        SlcRenderContext r101 = this.f45338a;
        if (r101 == null) goto L6;
        r101.r(r100);
        return;
    }

    public ECTagGroupViewWrapper(Context r100, AttributeSet r101, int r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 4) == 0) goto L8;
        r110 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        ECTagViewWrapper.f45333f.getClass();
        SlcRenderContext r102 = ECTagViewWrapper.a.a(r100, null);
        this.f45338a = r102;
        if (r102 != null) goto L11;
        nq.a.c(null, AnonymousClass1.INSTANCE, 1);
        return;
    L11:
        SliceRender r103 = SliceRender.f50121o;
        SlcElement r112 = ((SlcElement) f45337c.getValue()).deepClone();
        p r113 = new p("native_ectag_group_url", "native_ectag_group", null, null, 124);
        r103.getClass();
        r.f50698d.getClass();
        r r104 = r.a.a(r102, r112, r113);
        addView(r104.f50701c, 0);
        r104.b(new com.bytedance.android.ec.core.slice.ectaggroup.a(this));
        Unit r105 = Unit.INSTANCE;
        this.f45339b = r104;
    }
}
