package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/PriceElementView;", "Lcom/bytedance/android/ec/core/widget/price/PriceView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceElementView extends PriceView implements ActionHubAccessor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PriceElement f167855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167856d;

    public PriceElementView(Context r100) {
        this(r100, null, 6);
    }

    public PriceElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 4);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167856d;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.f167855c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final void D(final PriceElement r100) {
        this.f167855c = r100;
        if (r100 == null) goto L5;
        C(new PriceElementView$bind$$inlined$let$lambda$1(r100, this));
        setVisibility(0);
    L6:
        if (r100 == null) goto L8;
        Action r101 = r100.getAction();
    L9:
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r101);
        return;
    L8:
        r101 = null;
        goto L9
    L5:
        setVisibility(8);
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167856d = r100;
    }

    public PriceElementView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0, 12);
        this.f167856d = null;
    }
}
