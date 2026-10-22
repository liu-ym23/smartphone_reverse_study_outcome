package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.stepos.backend.qnn.QnnImageExtendModel;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6061a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f6062b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f6063c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6064d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6065e;
    public final /* synthetic */ Object h;

    public /* synthetic */ j(long j10, byte[] bArr, c.a aVar, boolean z, QnnASRModel$feedAudioFrame$nativeCb$1 qnnASRModel$feedAudioFrame$nativeCb$1) {
        this.f6062b = j10;
        this.f6064d = bArr;
        this.f6065e = aVar;
        this.f6063c = z;
        this.h = qnnASRModel$feedAudioFrame$nativeCb$1;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f6061a) {
            case 0:
                return Integer.valueOf(QnnImageExtendModel.C02381.invokeSuspend$lambda$2$lambda$1((Bitmap) this.f6064d, this.f6062b, (Rect) this.h, (Bitmap) this.f6065e, this.f6063c));
            default:
                return Boolean.valueOf(QnnASRModel.feedAudioFrame$lambda$10$lambda$9(this.f6062b, (byte[]) this.f6064d, (c.a) this.f6065e, this.f6063c, (QnnASRModel$feedAudioFrame$nativeCb$1) this.h));
        }
    }

    public /* synthetic */ j(Bitmap bitmap, long j10, Rect rect, Bitmap bitmap2, boolean z) {
        this.f6064d = bitmap;
        this.f6062b = j10;
        this.h = rect;
        this.f6065e = bitmap2;
        this.f6063c = z;
    }
}
