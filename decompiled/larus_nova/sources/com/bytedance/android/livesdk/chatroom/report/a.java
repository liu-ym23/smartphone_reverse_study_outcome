package com.bytedance.android.livesdk.chatroom.report;

import android.app.Dialog;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReportDialogFragment f110406a;

    public a(ReportDialogFragment r100) {
        this.f110406a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d r101 = (d) r100;
        ReportDialogFragment r102 = this.f110406a;
        TokenCert r103 = ReportDialogFragment.f110381o;
        r102.showLoading(false);
        if (r101.a() != 0) goto L7;
        ReportDialogFragment.b r104 = this.f110406a.f110389k;
        if (r104 == null) goto L10;
        r104.b(true, null);
    L10:
        Dialog r105 = this.f110406a.getDialog();
        if (r105 == null) goto L14;
        r105.cancel();
        return;
    L14:
        return;
    L7:
        ReportDialogFragment.b r106 = this.f110406a.f110389k;
        if (r106 == null) goto L10;
        r106.b(false, r101.b());
        goto L10
    }
}
