package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.LynxCardView;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;

/* JADX INFO: loaded from: classes12.dex */
public final class k extends com.bytedance.android.ec.core.anchorv3.q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l f165846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LynxCardComponent f165847f;

    @Override // com.bytedance.android.ec.core.anchorv3.q
    public final void c() {
        LynxCardView r100 = this.f165846e.f165852c;
        LynxCardComponent r101 = this.f165847f;
        if (LargeFontModeUtil.a() <= 1.0f) goto L5;
        boolean r102 = true;
    L6:
        LynxCardView.a(r100, r101, r102, 2);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public k(l r100, LynxCardComponent r101) {
        this.f165846e = r100;
        this.f165847f = r101;
        super(3);
    }
}
