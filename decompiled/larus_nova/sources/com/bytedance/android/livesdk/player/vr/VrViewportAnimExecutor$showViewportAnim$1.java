package com.bytedance.android.livesdk.player.vr;

import android.view.MotionEvent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class VrViewportAnimExecutor$showViewportAnim$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $downTime;
    final /* synthetic */ float $xOneStart;
    final /* synthetic */ float $xTwoStart;
    final /* synthetic */ float $yOneStart;
    final /* synthetic */ float $yTwoStart;
    final /* synthetic */ e this$0;

    public VrViewportAnimExecutor$showViewportAnim$1(e r100, long r101, float r102, float r103, float r104, float r105) {
        this.this$0 = r100;
        this.$downTime = r101;
        this.$xOneStart = r102;
        this.$xTwoStart = r103;
        this.$yOneStart = r104;
        this.$yTwoStart = r105;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        e r100 = this.this$0;
        long r101 = this.$downTime;
        float r110 = this.$xOneStart;
        float r102 = this.$xTwoStart;
        float r111 = this.$yOneStart;
        float r103 = this.$yTwoStart;
        r100.getClass();
        MotionEvent r112 = MotionEvent.obtain(r101, System.currentTimeMillis(), 6, r102, r103, 0);
        MotionEvent r104 = MotionEvent.obtain(r101, System.currentTimeMillis(), 0, r110, r111, 0);
        r100.b(r112);
        r100.b(r104);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
