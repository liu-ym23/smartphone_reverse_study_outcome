package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnPerceptionModel;
import com.stepos.backend.qnn.QnnSmsParseModel;
import com.stepos.backend.qnn.QnnTTSModel;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6115a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6116b;

    public /* synthetic */ w(Object obj, int i10) {
        this.f6115a = i10;
        this.f6116b = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f6115a;
        Object obj = this.f6116b;
        switch (i10) {
            case 0:
                return QnnPerceptionModel.C02601.invokeSuspend$lambda$0((QnnPerceptionModel) obj);
            case 1:
                return QnnSmsParseModel.C02691.invokeSuspend$lambda$5((QnnSmsParseModel) obj);
            case 2:
                return QnnTTSModel.C02741.invokeSuspend$lambda$1((ProducerScope) obj);
            case 3:
                return Boolean.valueOf(QnnLLMModel.doInitialize$lambda$0((QnnLLMModel) obj));
            case 4:
                return QnnTTSModel.doClose$lambda$0((QnnTTSModel) obj);
            default:
                return QnnVLMModel.doClose$lambda$0((QnnVLMModel) obj);
        }
    }
}
