package com.stepos.backend.mnn;

import com.stepos.backend.mnn.MnnChineseClipModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5960a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MnnChineseClipModel f5961b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5962c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float[] f5963d;

    public /* synthetic */ d(MnnChineseClipModel mnnChineseClipModel, Object obj, float[] fArr, int i10) {
        this.f5960a = i10;
        this.f5961b = mnnChineseClipModel;
        this.f5962c = obj;
        this.f5963d = fArr;
    }

    @Override // zb.a
    public final Object invoke() {
        int iInvokeSuspend$lambda$4;
        switch (this.f5960a) {
            case 0:
                iInvokeSuspend$lambda$4 = MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$4(this.f5961b, this.f5962c, this.f5963d);
                break;
            default:
                iInvokeSuspend$lambda$4 = MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$2$lambda$1(this.f5961b, this.f5962c, this.f5963d);
                break;
        }
        return Integer.valueOf(iInvokeSuspend$lambda$4);
    }
}
