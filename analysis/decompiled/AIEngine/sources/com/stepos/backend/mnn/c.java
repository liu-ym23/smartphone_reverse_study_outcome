package com.stepos.backend.mnn;

import com.stepos.backend.mnn.MnnChineseClipModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5956a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MnnChineseClipModel f5957b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5958c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float[] f5959d;

    public /* synthetic */ c(MnnChineseClipModel mnnChineseClipModel, Object obj, float[] fArr, int i10) {
        this.f5956a = i10;
        this.f5957b = mnnChineseClipModel;
        this.f5958c = obj;
        this.f5959d = fArr;
    }

    @Override // zb.a
    public final Object invoke() {
        int iInvokeSuspend$lambda$2;
        switch (this.f5956a) {
            case 0:
                iInvokeSuspend$lambda$2 = MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$2(this.f5957b, this.f5958c, this.f5959d);
                break;
            default:
                iInvokeSuspend$lambda$2 = MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$4$lambda$3(this.f5957b, this.f5958c, this.f5959d);
                break;
        }
        return Integer.valueOf(iInvokeSuspend$lambda$2);
    }
}
