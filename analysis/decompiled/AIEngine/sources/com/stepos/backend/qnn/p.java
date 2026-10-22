package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnImageMattingModel;
import com.stepos.backend.qnn.QnnRerankingModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6086a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6087b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6088c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f6089d;

    public /* synthetic */ p(String str, int i10, String str2, String str3) {
        this.f6086a = i10;
        this.f6087b = str;
        this.f6088c = str2;
        this.f6089d = str3;
    }

    @Override // zb.a
    public final Object invoke() {
        int iInvokeSuspend$lambda$0;
        switch (this.f6086a) {
            case 0:
                iInvokeSuspend$lambda$0 = QnnImageMattingModel.AnonymousClass2.invokeSuspend$lambda$0(this.f6087b, this.f6088c, this.f6089d);
                break;
            default:
                iInvokeSuspend$lambda$0 = QnnRerankingModel.AnonymousClass2.invokeSuspend$lambda$0(this.f6087b, this.f6088c, this.f6089d);
                break;
        }
        return Integer.valueOf(iInvokeSuspend$lambda$0);
    }
}
