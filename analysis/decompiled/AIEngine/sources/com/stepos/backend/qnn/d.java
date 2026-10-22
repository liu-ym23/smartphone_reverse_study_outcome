package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import com.stepos.backend.qnn.QnnASRModel;
import com.stepos.backend.qnn.QnnImageInpaintAigcModel;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6017a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6018b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6019c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f6020d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6021e;

    public /* synthetic */ d(Bitmap bitmap, Bitmap bitmap2, long j10, boolean z) {
        this.f6017a = 2;
        this.f6019c = bitmap;
        this.f6021e = bitmap2;
        this.f6020d = j10;
        this.f6018b = z;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f6017a) {
            case 0:
                return QnnASRModel.AnonymousClass1.invokeSuspend$lambda$11(this.f6018b, (ProducerScope) this.f6019c, this.f6020d, (QnnASRModel) this.f6021e);
            case 1:
                return QnnASRModel.C02371.invokeSuspend$lambda$10(this.f6018b, (ProducerScope) this.f6019c, this.f6020d, (QnnASRModel) this.f6021e);
            default:
                return QnnImageInpaintAigcModel.C02411.invokeSuspend$lambda$2$lambda$1((Bitmap) this.f6019c, (Bitmap) this.f6021e, this.f6020d, this.f6018b);
        }
    }

    public /* synthetic */ d(boolean z, ProducerScope producerScope, long j10, QnnASRModel qnnASRModel, int i10) {
        this.f6017a = i10;
        this.f6018b = z;
        this.f6019c = producerScope;
        this.f6020d = j10;
        this.f6021e = qnnASRModel;
    }
}
