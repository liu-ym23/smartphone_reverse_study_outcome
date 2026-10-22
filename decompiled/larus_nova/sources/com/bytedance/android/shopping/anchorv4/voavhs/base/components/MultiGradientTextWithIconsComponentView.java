package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.MultiGradientTextWithIconsComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MultiGradientTextWithIconsComponentView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/d;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiGradientTextWithIconsComponent;", "description", "", "update", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiGradientTextWithIconsComponentView extends LinearLayout implements ActionHubAccessor, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultiGradientTextWithIconsComponent f167808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167809b;

    public MultiGradientTextWithIconsComponentView(Context r100) {
        this(r100, null, 0, 14);
    }

    public MultiGradientTextWithIconsComponentView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public MultiGradientTextWithIconsComponentView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.d
    public final List<ShowEvent> showEvent() {
        MultiGradientTextWithIconsComponent r100 = this.f167808a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getShowEvent();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167809b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.f167808a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167809b = r100;
    }

    public final void update(MultiGradientTextWithIconsComponent r100) {
        this.f167808a = r100;
    }

    public MultiGradientTextWithIconsComponentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167809b = null;
        setOrientation(0);
    }
}
