package com.stepos.backend.mnn;

import com.stepos.backend.mnn.MnnChineseClipModel;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5948a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MnnChineseClipModel f5949b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c.C0155c f5950c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float[] f5951d;

    public /* synthetic */ a(MnnChineseClipModel mnnChineseClipModel, c.C0155c c0155c, float[] fArr, int i10) {
        this.f5948a = i10;
        this.f5949b = mnnChineseClipModel;
        this.f5950c = c0155c;
        this.f5951d = fArr;
    }

    @Override // zb.a
    public final Object invoke() {
        int iInvokeSuspend$lambda$10$lambda$9;
        switch (this.f5948a) {
            case 0:
                iInvokeSuspend$lambda$10$lambda$9 = MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$10$lambda$9(this.f5949b, this.f5950c, this.f5951d);
                break;
            default:
                iInvokeSuspend$lambda$10$lambda$9 = MnnChineseClipModel.AnonymousClass1.invokeSuspend$lambda$10(this.f5949b, this.f5950c, this.f5951d);
                break;
        }
        return Integer.valueOf(iInvokeSuspend$lambda$10$lambda$9);
    }
}
