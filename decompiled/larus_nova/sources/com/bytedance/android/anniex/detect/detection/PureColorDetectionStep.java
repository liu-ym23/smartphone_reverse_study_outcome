package com.bytedance.android.anniex.detect.detection;

import com.bytedance.android.anniex.detect.FailureStage;
import com.bytedance.android.anniex.detect.c;
import com.bytedance.android.anniex.detect.f;
import com.bytedance.android.anniex.detect.h;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes43.dex */
public final class PureColorDetectionStep implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f40669b;

    public PureColorDetectionStep(long r100, float r101) {
        this.f40668a = r100;
        this.f40669b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.anniex.detect.h
    public final Object a(f r110, Continuation<? super c> r111) {
        if ((r111 instanceof PureColorDetectionStep$execute$1) == false) goto L7;
        PureColorDetectionStep$execute$1 r100 = (PureColorDetectionStep$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r104 = r100.J$0;
        Ref.ObjectRef r113 = (Ref.ObjectRef) r100.L$2;
        Ref.ObjectRef r105 = (Ref.ObjectRef) r100.L$1;
        f r106 = (f) r100.L$0;
        ResultKt.throwOnFailure(r112);
        Ref.ObjectRef r114 = r113;
        r110 = r106;
        Object r107 = r112;
    L18:
        c r108 = (c) r107;
        T r109 = r108;
        if (r108 != null) goto L21;
        c.a r115 = new c.a(1002, "PureColorDetection timeout", FailureStage.PureColorDetection);
        r110.f40678b.f40685f = true;
        r109 = r115;
    L21:
        r114.element = r109;
        long r116 = System.currentTimeMillis() - r104;
        HybridLogger r117 = HybridLogger.f246343a;
        HybridLogger.f("AnnieXBlankDetect", "纯色检测结束，检测耗时为 ：" + r116, null, 12);
        r110.f40678b.f40686g = Boxing.boxLong(r116);
        return r105.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        HybridLogger.f("AnnieXBlankDetect", "开启纯色检测", null, 12);
        r114 = new Ref.ObjectRef();
        long r118 = System.currentTimeMillis();
        long r119 = this.f40668a;
        PureColorDetectionStep$execute$duration$1$1 r120 = new PureColorDetectionStep$execute$duration$1$1(r110, this, null);
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.L$2 = r114;
        r100.J$0 = r118;
        r100.label = 1;
        r107 = TimeoutKt.c(r119, r120, r100);
        if (r107 != r102) goto L17;
        return r102;
    L17:
        r104 = r118;
        r105 = r114;
    L7:
        r100 = new PureColorDetectionStep$execute$1(this, r111);
        goto L8
    }
}
