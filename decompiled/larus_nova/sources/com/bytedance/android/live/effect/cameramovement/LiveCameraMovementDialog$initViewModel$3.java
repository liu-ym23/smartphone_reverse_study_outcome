package com.bytedance.android.live.effect.cameramovement;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Class;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveCameraMovementDialog$initViewModel$3 extends Lambda implements Function1<Class<?>, Object> {
    final /* synthetic */ LiveCameraMovementDialog this$0;

    public LiveCameraMovementDialog$initViewModel$3(LiveCameraMovementDialog r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LiveCameraMovementDialog r101 = this.this$0;
        int r102 = LiveCameraMovementDialog.f67799d;
        r101.getClass();
        this.this$0.getClass();
        return new LiveCameraMovementUIViewModel(null, null, "live_camera_move");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Class<?> r100) {
        return invoke2(r100);
    }
}
