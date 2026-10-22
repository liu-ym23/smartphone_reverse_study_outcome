package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnASRModel;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6011a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f6012b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f6013c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c.a f6014d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f6015e;
    public final /* synthetic */ QnnASRModel$asrInferFlow$1$callback$1 h;

    public /* synthetic */ c(long j10, byte[] bArr, c.a aVar, boolean z, QnnASRModel$asrInferFlow$1$callback$1 qnnASRModel$asrInferFlow$1$callback$1, int i10) {
        this.f6011a = i10;
        this.f6012b = j10;
        this.f6013c = bArr;
        this.f6014d = aVar;
        this.f6015e = z;
        this.h = qnnASRModel$asrInferFlow$1$callback$1;
    }

    @Override // zb.a
    public final Object invoke() {
        boolean zInvokeSuspend$lambda$5$lambda$4;
        switch (this.f6011a) {
            case 0:
                zInvokeSuspend$lambda$5$lambda$4 = QnnASRModel.AnonymousClass1.invokeSuspend$lambda$5$lambda$4(this.f6012b, this.f6013c, this.f6014d, this.f6015e, this.h);
                break;
            default:
                zInvokeSuspend$lambda$5$lambda$4 = QnnASRModel.AnonymousClass1.invokeSuspend$lambda$5$lambda$4$lambda$3(this.f6012b, this.f6013c, this.f6014d, this.f6015e, this.h);
                break;
        }
        return Boolean.valueOf(zInvokeSuspend$lambda$5$lambda$4);
    }
}
