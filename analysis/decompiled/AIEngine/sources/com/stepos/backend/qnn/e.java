package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnASRModel;
import com.stepos.backend.qnn.QnnSmsParseModel;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6027a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6028b;

    public /* synthetic */ e(Object obj, int i10) {
        this.f6027a = i10;
        this.f6028b = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f6027a;
        Object obj = this.f6028b;
        switch (i10) {
            case 0:
                return QnnASRModel.AnonymousClass2.invokeSuspend$lambda$0((QnnASRModel) obj);
            case 1:
                return QnnSmsParseModel.C02691.invokeSuspend$lambda$1((ProducerScope) obj);
            default:
                return QnnLLMModel.doClose$lambda$1((QnnLLMModel) obj);
        }
    }
}
