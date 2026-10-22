package com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import gz1.c;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public class a extends pz1.a<h1> {
    @Override // pz1.a
    public final void k() {
    }

    @Override // pz1.a
    public final String l() {
        return "";
    }

    @Override // pz1.a
    public final boolean o() {
        return false;
    }

    @Override // pz1.a
    public final boolean p() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String a() {
        return ((h1) this.f126620h).getDescribe();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final long c() {
        return ((h1) this.f126620h).getId();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k d() {
        return ((h1) this.f126620h).getImage();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k e() {
        return ((h1) this.f126620h).getLeftLogo();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public String f() {
        return ((h1) this.f126620h).getName();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final boolean i() {
        k0 r100 = ((h1) this.f126620h).getGiftPreviewInfo();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (((h1) this.f126620h).getType() != 1) goto L11;
        return false;
    L11:
        if (((h1) this.f126620h).getType() != 5) goto L13;
        return false;
    L13:
        if (((h1) this.f126620h).getType() != 10) goto L15;
        return false;
    L15:
        if (((h1) this.f126620h).getType() == 12) goto L22;
        if (r101 == true) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L5:
        if (r100.getLockStatus() == k0.UNLOCKED) goto L7;
        r101 = true;
        goto L9
    }

    @Override // pz1.a
    public final long j() {
        return ((h1) this.f126620h).getDiamondCount();
    }

    @Override // pz1.a
    public final boolean m() {
        return !((h1) this.f126620h).getGiftGroupList().isEmpty();
    }

    @Override // pz1.a
    public final boolean n() {
        return ((h1) this.f126620h).isSupportLongPressCombo();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k g() {
        if (s.a() != null) goto L5;
        return null;
    L5:
        n r100 = s.a().I(Long.valueOf(c()));
        if (r100 == null) goto L9;
        this.f126618f = AbsPanel.GiftPanelIconSource.DIY_CARD;
        return r100.getIconImg();
    L9:
        return null;
    }

    public final void q() {
        if (s.a() != null) goto L5;
        return;
    L5:
        n r100 = s.a().I(Long.valueOf(c()));
        if (r100 == null) goto L9;
        this.f126618f = AbsPanel.GiftPanelIconSource.DIY_CARD;
        this.f126614b = c.g(r100);
        this.f126619g = r100.getConfigId();
        this.f126615c = r100.getCardName();
        return;
    }

    public a(h1 r100) {
        super(1, r100);
        if (u.r() == false) goto L6;
        q();
        return;
    }

    public a(h1 r100, int r101) {
        super(5, r100);
        if (u.r() == false) goto L6;
        q();
        return;
    }
}
