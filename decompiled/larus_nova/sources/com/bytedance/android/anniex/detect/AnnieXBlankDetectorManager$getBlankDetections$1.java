package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.ability.service.AnnieXPitayaProvider;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "Lga/e;", "callback", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$getBlankDetections$1", f = "AnnieXBlankDetectorManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXBlankDetectorManager$getBlankDetections$1 extends SuspendLambda implements Function3<Bitmap, ga.e, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public AnnieXBlankDetectorManager$getBlankDetections$1(Continuation<? super AnnieXBlankDetectorManager$getBlankDetections$1> r100) {
        super(3, r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Bitmap r100, ga.e r101, Continuation<? super Unit> r102) {
        AnnieXBlankDetectorManager$getBlankDetections$1 r103 = new AnnieXBlankDetectorManager$getBlankDetections$1(r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Bitmap r100, ga.e r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        Bitmap r101 = (Bitmap) this.L$0;
        ga.e r102 = (ga.e) this.L$1;
        AnnieXServiceCenter.f40313a.getClass();
        if (((AnnieXPitayaProvider) AnnieXServiceCenter.d("default_bid", AnnieXPitayaProvider.class)) == null) goto L8;
        ga.d r103 = new ga.d();
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "snapshot");
        Intrinsics.checkNotNullParameter(r103, "taskConfig");
        Intrinsics.checkNotNullParameter(r104, "data");
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
