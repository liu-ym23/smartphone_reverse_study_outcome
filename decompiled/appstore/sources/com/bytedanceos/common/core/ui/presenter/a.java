package com.bytedanceos.common.core.ui.presenter;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.CommentParams;
import com.bytedanceos.common.model.Model;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.c0;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    public a(IView r10, int r11) {
        super(r10, r11);
    }

    @Override // com.bytedanceos.common.core.ui.presenter.b, com.bytedanceos.common.core.ui.presenter.APresenter
    public /* bridge */ /* synthetic */ void e(int r10, Object r11, Object r12) {
        h(r10, (Model) r11, (CommentParams) r12);
    }

    @Override // com.bytedanceos.common.core.ui.presenter.b
    public /* bridge */ /* synthetic */ void g(int r10, Object r11, CommentParams r12) {
        h(r10, (Model) r11, r12);
    }

    public void h(int r10, Model r11, CommentParams r12) {
        switch(r10) {
            case 400004: goto L9;
            case 400005: goto L8;
            case 700001: goto L7;
            case 700002: goto L7;
            case 700005: goto L6;
            case 1400004: goto L5;
            default: goto L4;
        };
    L4:
        super.g(r10, r11, r12);
        return;
    L5:
        CommonAPIHelper.B(r11, this);
        return;
    L6:
        a(r10);
        CommonAPIHelper.t(this.f9806e, r11.getName(), c0.b("20"), 1, q8.b.c());
        return;
    L7:
        a(r10);
        CommonAPIHelper.r(this.f9806e, r10, r11.getName(), q8.b.c());
        return;
    L8:
        a(r10);
        CommonAPIHelper.G(q8.b.c());
        return;
    L9:
        if (r11 != null) goto L11;
        return;
    L11:
        if ((r11 instanceof AppInfo) == false) goto L20;
        a(r10);
        CommonAPIHelper.C((AppInfo) r11, 1, q8.b.c());
        return;
    }
}
