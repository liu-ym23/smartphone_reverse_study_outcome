package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnLLMModel;
import com.stepos.core.model.callback.StreamCallback;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6102a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6103b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ QnnLLMModel f6104c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f6105d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ StreamCallback f6106e;
    public final /* synthetic */ int h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ float f6107j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f6108k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ float f6109l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ float f6110m;

    public /* synthetic */ u(String str, QnnLLMModel qnnLLMModel, String str2, StreamCallback streamCallback, int i10, float f8, int i11, float f9, float f10, int i12) {
        this.f6102a = i12;
        this.f6103b = str;
        this.f6104c = qnnLLMModel;
        this.f6105d = str2;
        this.f6106e = streamCallback;
        this.h = i10;
        this.f6107j = f8;
        this.f6108k = i11;
        this.f6109l = f9;
        this.f6110m = f10;
    }

    @Override // zb.a
    public final Object invoke() {
        boolean zInvokeSuspend$lambda$7;
        switch (this.f6102a) {
            case 0:
                zInvokeSuspend$lambda$7 = QnnLLMModel.C02491.invokeSuspend$lambda$7(this.f6103b, this.f6104c, this.f6105d, this.f6106e, this.h, this.f6107j, this.f6108k, this.f6109l, this.f6110m);
                break;
            default:
                zInvokeSuspend$lambda$7 = QnnLLMModel.C02491.invokeSuspend$lambda$7$lambda$6(this.f6103b, this.f6104c, this.f6105d, this.f6106e, this.h, this.f6107j, this.f6108k, this.f6109l, this.f6110m);
                break;
        }
        return Boolean.valueOf(zInvokeSuspend$lambda$7);
    }
}
