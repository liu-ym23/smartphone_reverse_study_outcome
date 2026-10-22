package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnLLMModel;
import com.stepos.backend.qnn.QnnVLMModel;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6111a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QnnModelBase f6112b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6113c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6114d;

    public /* synthetic */ v(QnnModelBase qnnModelBase, Object obj, Object obj2, int i10) {
        this.f6111a = i10;
        this.f6112b = qnnModelBase;
        this.f6113c = obj;
        this.f6114d = obj2;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f6111a) {
            case 0:
                return QnnLLMModel.AnonymousClass2.invokeSuspend$lambda$0((QnnLLMModel) this.f6112b, (String) this.f6113c, (String) this.f6114d);
            case 1:
                return QnnVLMModel.C02771.invokeSuspend$lambda$1((QnnVLMModel) this.f6112b, (StringBuilder) this.f6113c, (ProducerScope) this.f6114d);
            default:
                return QnnVLMModel.AnonymousClass2.invokeSuspend$lambda$0((QnnVLMModel) this.f6112b, (String) this.f6113c, (String) this.f6114d);
        }
    }
}
