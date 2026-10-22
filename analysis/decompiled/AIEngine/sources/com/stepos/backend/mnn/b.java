package com.stepos.backend.mnn;

import com.stepos.backend.mnn.MnnChineseClipModel;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5952a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MnnChineseClipModel f5953b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c.g f5954c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float[] f5955d;

    public /* synthetic */ b(MnnChineseClipModel mnnChineseClipModel, c.g gVar, float[] fArr, int i10) {
        this.f5952a = i10;
        this.f5953b = mnnChineseClipModel;
        this.f5954c = gVar;
        this.f5955d = fArr;
    }

    @Override // zb.a
    public final Object invoke() {
        int iInvokeSuspend$lambda$8$lambda$7;
        switch (this.f5952a) {
            case 0:
                iInvokeSuspend$lambda$8$lambda$7 = MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$8$lambda$7(this.f5953b, this.f5954c, this.f5955d);
                break;
            default:
                iInvokeSuspend$lambda$8$lambda$7 = MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$8(this.f5953b, this.f5954c, this.f5955d);
                break;
        }
        return Integer.valueOf(iInvokeSuspend$lambda$8$lambda$7);
    }
}
