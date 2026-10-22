package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import com.stepos.backend.mnn.MnnFaceDetectModel;
import com.stepos.backend.mnn.MnnFaceEmbedModel;
import com.stepos.backend.mnn.MnnFaceQualityModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5977a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f5978b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MnnModelBase f5979c;

    public /* synthetic */ h(MnnModelBase mnnModelBase, Bitmap bitmap, int i10) {
        this.f5977a = i10;
        this.f5979c = mnnModelBase;
        this.f5978b = bitmap;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f5977a) {
            case 0:
                return MnnFaceDetectModel.AnonymousClass1.invokeSuspend$lambda$1((MnnFaceDetectModel) this.f5979c, this.f5978b);
            case 1:
                return MnnFaceEmbedModel.AnonymousClass1.invokeSuspend$lambda$1$lambda$0((MnnFaceEmbedModel) this.f5979c, this.f5978b);
            default:
                return Float.valueOf(MnnFaceQualityModel.AnonymousClass1.invokeSuspend$lambda$1((MnnFaceQualityModel) this.f5979c, this.f5978b));
        }
    }
}
