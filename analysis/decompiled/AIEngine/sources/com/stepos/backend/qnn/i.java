package com.stepos.backend.qnn;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.stepos.backend.qnn.QnnImageExtendModel;
import com.stepos.backend.qnn.QnnTTSModel;
import java.util.concurrent.CountDownLatch;
import kotlinx.coroutines.channels.ProducerScope;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6053a = 2;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6054b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f6055c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6056d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6057e;
    public final /* synthetic */ Object h;

    public /* synthetic */ i(long j10, byte[] bArr, c.a aVar, boolean z, QnnASRModel$feedAudioFrame$nativeCb$1 qnnASRModel$feedAudioFrame$nativeCb$1) {
        this.f6055c = j10;
        this.f6056d = bArr;
        this.f6057e = aVar;
        this.f6054b = z;
        this.h = qnnASRModel$feedAudioFrame$nativeCb$1;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f6053a) {
            case 0:
                return Integer.valueOf(QnnImageExtendModel.C02381.invokeSuspend$lambda$2((Bitmap) this.f6056d, this.f6055c, (Rect) this.h, (Bitmap) this.f6057e, this.f6054b));
            case 1:
                return QnnTTSModel.C02741.invokeSuspend$lambda$7(this.f6054b, (ProducerScope) this.f6056d, (CountDownLatch) this.f6057e, (QnnTTSModel) this.h, this.f6055c);
            default:
                return Boolean.valueOf(QnnASRModel.feedAudioFrame$lambda$10$lambda$8(this.f6055c, (byte[]) this.f6056d, (c.a) this.f6057e, this.f6054b, (QnnASRModel$feedAudioFrame$nativeCb$1) this.h));
        }
    }

    public /* synthetic */ i(Bitmap bitmap, long j10, Rect rect, Bitmap bitmap2, boolean z) {
        this.f6056d = bitmap;
        this.f6055c = j10;
        this.h = rect;
        this.f6057e = bitmap2;
        this.f6054b = z;
    }

    public /* synthetic */ i(boolean z, ProducerScope producerScope, CountDownLatch countDownLatch, QnnTTSModel qnnTTSModel, long j10) {
        this.f6054b = z;
        this.f6056d = producerScope;
        this.f6057e = countDownLatch;
        this.h = qnnTTSModel;
        this.f6055c = j10;
    }
}
