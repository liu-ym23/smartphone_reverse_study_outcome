package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnRerankingModel;
import com.stepos.backend.qnn.QnnSmsParseModel;
import com.stepos.core.model.callback.StreamCallback;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5999a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6000b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6001c;

    public /* synthetic */ a0(int i10, String str, Object obj) {
        this.f5999a = i10;
        this.f6000b = str;
        this.f6001c = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f5999a) {
            case 0:
                return Boolean.valueOf(QnnSmsParseModel.C02691.invokeSuspend$lambda$4(this.f6000b, (StreamCallback) this.f6001c));
            case 1:
                return Boolean.valueOf(SmsParseQnnJni.nativeChatStream(this.f6000b, (StreamCallback) this.f6001c));
            default:
                return QnnRerankingModel.C02641.invokeSuspend$lambda$2$lambda$1(this.f6000b, (List) this.f6001c);
        }
    }
}
