package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnVLMModel;
import com.stepos.core.model.callback.StreamCallback;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6037a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QnnVLMModel f6038b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ QnnVLMModel.ResolvedVlmInputs f6039c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StreamCallback f6040d;

    public /* synthetic */ f0(QnnVLMModel qnnVLMModel, QnnVLMModel.ResolvedVlmInputs resolvedVlmInputs, StreamCallback streamCallback, int i10) {
        this.f6037a = i10;
        this.f6038b = qnnVLMModel;
        this.f6039c = resolvedVlmInputs;
        this.f6040d = streamCallback;
    }

    @Override // zb.a
    public final Object invoke() {
        boolean zInvokeSuspend$lambda$6$lambda$5;
        switch (this.f6037a) {
            case 0:
                zInvokeSuspend$lambda$6$lambda$5 = QnnVLMModel.C02771.invokeSuspend$lambda$6$lambda$5(this.f6038b, this.f6039c, this.f6040d);
                break;
            default:
                zInvokeSuspend$lambda$6$lambda$5 = QnnVLMModel.C02771.invokeSuspend$lambda$6(this.f6038b, this.f6039c, this.f6040d);
                break;
        }
        return Boolean.valueOf(zInvokeSuspend$lambda$6$lambda$5);
    }
}
