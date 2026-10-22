package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ec.common.impl.sku.view.SkuTrustTagContentView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/presenter/SkuTrustTagsView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;", "getContentView", "()Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;", "setContentView", "(Lcom/bytedance/android/ec/common/impl/sku/view/SkuTrustTagContentView;)V", "contentView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuTrustTagsView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SkuTrustTagContentView f43168a;

    public SkuTrustTagsView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SkuTrustTagsView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final SkuTrustTagContentView getContentView() {
        return this.f43168a;
    }

    public final void setContentView(SkuTrustTagContentView r100) {
        this.f43168a = r100;
    }

    public SkuTrustTagsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setPadding(com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8), 0);
        setGravity(16);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 16;
        Unit r104 = Unit.INSTANCE;
        setLayoutParams(r103);
    }

    public /* synthetic */ SkuTrustTagsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
