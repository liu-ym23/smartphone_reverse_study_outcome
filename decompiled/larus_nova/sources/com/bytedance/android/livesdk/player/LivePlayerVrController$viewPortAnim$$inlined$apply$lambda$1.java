package com.bytedance.android.livesdk.player;

import android.view.MotionEvent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/MotionEvent;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/player/LivePlayerVrController$viewPortAnim$1$1"}, k = 3, mv = {1, 4, 3})
final class LivePlayerVrController$viewPortAnim$$inlined$apply$lambda$1 extends Lambda implements Function1<MotionEvent, Unit> {
    final /* synthetic */ float $height$inlined;
    final /* synthetic */ float $width$inlined;
    final /* synthetic */ LivePlayerVrController this$0;

    public LivePlayerVrController$viewPortAnim$$inlined$apply$lambda$1(LivePlayerVrController r100, float r101, float r102) {
        this.this$0 = r100;
        this.$width$inlined = r101;
        this.$height$inlined = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.this$0.onTouchEvent(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MotionEvent r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
