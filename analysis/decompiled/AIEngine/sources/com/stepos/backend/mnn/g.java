package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import com.stepos.backend.mnn.MnnFaceDetectModel;
import com.stepos.backend.mnn.MnnFaceEmbedModel;
import com.stepos.backend.mnn.MnnFaceQualityModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5974a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f5975b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MnnModelBase f5976c;

    public /* synthetic */ g(MnnModelBase mnnModelBase, Bitmap bitmap, int i10) {
        this.f5974a = i10;
        this.f5976c = mnnModelBase;
        this.f5975b = bitmap;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f5974a) {
            case 0:
                return MnnFaceDetectModel.AnonymousClass1.invokeSuspend$lambda$1$lambda$0((MnnFaceDetectModel) this.f5976c, this.f5975b);
            case 1:
                return MnnFaceEmbedModel.AnonymousClass1.invokeSuspend$lambda$1((MnnFaceEmbedModel) this.f5976c, this.f5975b);
            default:
                return Float.valueOf(MnnFaceQualityModel.AnonymousClass1.invokeSuspend$lambda$1$lambda$0((MnnFaceQualityModel) this.f5976c, this.f5975b));
        }
    }
}
