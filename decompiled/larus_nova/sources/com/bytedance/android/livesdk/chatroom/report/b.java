package com.bytedance.android.livesdk.chatroom.report;

import android.app.Dialog;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReportDialogFragment f110407a;

    public b(ReportDialogFragment r100) {
        this.f110407a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ReportDialogFragment r102 = this.f110407a;
        TokenCert r103 = ReportDialogFragment.f110381o;
        r102.showLoading(false);
        SafetyGuard.a(null, r101, "report room error");
        ReportDialogFragment.b r104 = this.f110407a.f110389k;
        if (r104 == null) goto L5;
        r104.b(false, r101.getMessage());
    L5:
        Dialog r105 = this.f110407a.getDialog();
        if (r105 == null) goto L9;
        r105.cancel();
        return;
    }
}
