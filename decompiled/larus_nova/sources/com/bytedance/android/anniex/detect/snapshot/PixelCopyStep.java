package com.bytedance.android.anniex.detect.snapshot;

import com.bytedance.android.anniex.detect.j;
import com.bytedance.android.anniex.detect.k;
import com.bytedance.android.anniex.detect.m;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes43.dex */
public final class PixelCopyStep implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f40706b;

    public PixelCopyStep(long r100, float r101) {
        this.f40705a = r100;
        this.f40706b = r101;
    }

    @Override // com.bytedance.android.anniex.detect.m
    public final Object a(j r110, Continuation<? super k> r111) {
        if ((r111 instanceof PixelCopyStep$execute$1) == false) goto L7;
        PixelCopyStep$execute$1 r100 = (PixelCopyStep$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        StringBuilder r113 = (StringBuilder) r100.L$1;
        PixelCopyStep r104 = (PixelCopyStep) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L14 TimeoutCancellationException -> L30
    L22:
        return r112;
    L14:
        Exception e100 = e;
    L25:
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.i("AnnieXBlankDetect", "PixelCopy exception:" + e100.getMessage() + ", captureLog: " + r113, null, 12);
        return new k(false, "PixelCopy exception:" + e100.getMessage() + ", captureLog: " + r113);
    L28:
        String r114 = "PixelCopy timeout after " + r104.f40705a + "ms, captureLog: " + r113;
        HybridLogger.i("AnnieXBlankDetect", r114, null, 12);
        return new k(false, r114);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        HybridLogger.f("AnnieXBlankDetect", "开始截图", null, 12);
        StringBuilder r115 = new StringBuilder();
        long r106 = this.f40705a;     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        PixelCopyStep$execute$2 r107 = new PixelCopyStep$execute$2(r110, this, r115, null);     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        r100.L$0 = this;     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        r100.L$1 = r115;     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        r100.label = 1;     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        r112 = TimeoutKt.b(r106, r107, r100);     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        if (r112 != r102) goto L22;
        return r102;
    L27:
        r104 = this;
        r113 = r115;
    L23:
        e = move-exception;
        e100 = e;
        r113 = r115;
    L7:
        r100 = new PixelCopyStep$execute$1(this, r111);
        goto L8
    }
}
