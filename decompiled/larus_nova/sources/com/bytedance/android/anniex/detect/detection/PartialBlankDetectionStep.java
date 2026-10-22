package com.bytedance.android.anniex.detect.detection;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.detect.FailureStage;
import com.bytedance.android.anniex.detect.c;
import com.bytedance.android.anniex.detect.f;
import com.bytedance.android.anniex.detect.h;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import ga.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes43.dex */
public final class PartialBlankDetectionStep implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<Bitmap, e, Continuation<? super Unit>, Object> f40666b;

    /* JADX WARN: Multi-variable type inference failed */
    public PartialBlankDetectionStep(long r100, Function3<? super Bitmap, ? super e, ? super Continuation<? super Unit>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "checker");
        this.f40665a = r100;
        this.f40666b = r101;
    }

    @Override // com.bytedance.android.anniex.detect.h
    public final Object a(f r110, Continuation<? super c> r111) {
        f r100 = r110;
        if ((r111 instanceof PartialBlankDetectionStep$execute$1) == false) goto L7;
        PartialBlankDetectionStep$execute$1 r101 = (PartialBlankDetectionStep$execute$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L25:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r112 = r101.J$0;
        CompletableDeferred r106 = (CompletableDeferred) r101.L$1;
        f r107 = (f) r101.L$0;
        ResultKt.throwOnFailure(r103);
        CompletableDeferred r108 = r106;
        r100 = r107;
        Object r109 = r103;
    L20:
        if (((c) r109) != null) goto L22;
        c.a r113 = new c.a(1004, "PartialBlankDetection timeout", FailureStage.PartialBlankDetection);
        r100.f40678b.f40689j = true;
        Boxing.boxBoolean(r108.complete(r113));
    L22:
        long r114 = System.currentTimeMillis() - r112;
        r100.f40678b.f40690k = Boxing.boxLong(r114);
        HybridLogger r115 = HybridLogger.f246343a;
        HybridLogger.f("AnnieXBlankDetect", "半白屏检测结束，检测耗时为 ：" + r114, null, 12);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        r103 = r108.await(r101);
        if (r103 != r104) goto L25;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        HybridLogger.f("AnnieXBlankDetect", "开启半白屏检测", null, 12);
        r108 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r112 = System.currentTimeMillis();
        long r116 = this.f40665a;
        PartialBlankDetectionStep$execute$duration$1$1 r117 = new PartialBlankDetectionStep$execute$duration$1$1(this, r100, r108, null);
        r101.L$0 = r100;
        r101.L$1 = r108;
        r101.J$0 = r112;
        r101.label = 1;
        r109 = TimeoutKt.c(r116, r117, r101);
        if (r109 != r104) goto L20;
        return r104;
    L7:
        r101 = new PartialBlankDetectionStep$execute$1(this, r111);
        goto L8
    }
}
