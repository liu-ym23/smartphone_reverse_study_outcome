package com.bytedance.android.shopping.inflow.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/InFlowRankLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Lkotlin/Function0;", "", "onClickCallBack", "setOnClickCallBack", "", "size", "setTextSize", "(Ljava/lang/Float;)V", "", "weight", "setTextStyle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowRankLayout extends FrameLayout implements com.bytedance.android.shopping.feed.view.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f176337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f176338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f176339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f176340d;

    public InFlowRankLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InFlowRankLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final void b(TextView r100) {
        Float r101 = this.f176338b;
        if (r101 == null) goto L5;
        r100.setTextSize(r101.floatValue());
    L5:
        Integer r102 = Integer.valueOf(this.f176339c);
        if (r102.intValue() < 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L14;
        int r104 = r102.intValue();
        ViewExtensionsKt.e(r100, r100.getPaint(), r104);
    L14:
        float r105 = se3.a.f541559a;
        Float r106 = this.f176338b;
        if (r106 == null) goto L17;
        float r107 = r106.floatValue();
    L18:
        se3.a.c(r100, 2, r107);
        return;
    L17:
        r107 = 13.0f;
        goto L18
    L8:
        r103 = false;
        goto L9
    }

    public final void setOnClickCallBack(Function0<Unit> r100) {
        this.f176340d = r100;
    }

    public final void setTextSize(Float r100) {
        this.f176338b = r100;
    }

    public final void setTextStyle(int r100) {
        this.f176339c = r100;
    }

    public InFlowRankLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f176339c = -1;
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_inflow_rank_layout, this, true);
        return;
    L5:
        u63.a.a(r100, R.layout.ec_inflow_rank_layout, this, true);
    }

    public /* synthetic */ InFlowRankLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
