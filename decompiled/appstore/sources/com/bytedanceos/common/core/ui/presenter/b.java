package com.bytedanceos.common.core.ui.presenter;

import android.os.Message;
import com.bytedanceos.common.model.CommentParams;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class b extends APresenter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IView f9805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9806e;

    public b(IView r10, int r11) {
        super(Thread.currentThread());
        this.f9805d = r10;
        this.f9806e = r11;
    }

    @Override // com.bytedanceos.common.core.ui.presenter.APresenter
    public /* bridge */ /* synthetic */ void e(int r10, Object r11, Object r12) {
        g(r10, r11, (CommentParams) r12);
    }

    @Override // com.bytedanceos.common.core.ui.presenter.APresenter
    public void f(Message r10) {
        int r11 = r10.what;
        if (r11 != 1) goto L5;
        this.f9805d.onUpdateView(r10.arg1, Boolean.TRUE, (APresenter.b) r10.obj);
        return;
    L5:
        if (r11 != 2) goto L11;
        this.f9805d.onUpdateView(r10.arg1, Boolean.FALSE, (APresenter.b) r10.obj);
        return;
    }

    public void g(int r10, Object r11, CommentParams r12) {
        switch(r10) {
            case 700004: goto L8;
            case 700005: goto L3;
            case 700006: goto L3;
            case 700007: goto L7;
            case 700008: goto L6;
            case 700009: goto L3;
            case 700010: goto L5;
            case 700011: goto L3;
            case 700012: goto L4;
            default: goto L3;
        };
    L3:
        j.e("unkwon fetch data:" + r10);
        return;
    L4:
        a(r10);
        CommonAPIHelper.g0(this.f9806e, r12.mAppId, r12.mCommentId, q8.b.c(), r12.mCookie);
        return;
    L5:
        a(r10);
        CommonAPIHelper.d0(this.f9806e, r12.mAppId, r12.mCommentId, q8.b.c(), r12.mCookie);
        return;
    L6:
        a(r10);
        CommonAPIHelper.y(this.f9806e, r12.mAppPackage, q8.b.c());
        return;
    L7:
        a(r10);
        CommonAPIHelper.n(this.f9806e, r12.mAppPackage, r12.mVersionName, String.valueOf(r12.mVersionCode), String.valueOf(r12.mScore), r12.mContent, q8.b.c());
        return;
    L8:
        a(r10);
        CommonAPIHelper.q(this.f9806e, r12.mAppPackage, r12.mPageNo, q8.b.c());
    }
}
