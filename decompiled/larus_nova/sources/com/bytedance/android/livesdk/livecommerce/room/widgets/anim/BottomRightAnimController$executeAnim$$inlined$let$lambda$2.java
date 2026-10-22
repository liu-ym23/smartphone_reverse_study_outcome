package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/livecommerce/room/widgets/anim/BottomRightAnimController$executeAnim$1$2"}, k = 3, mv = {1, 4, 3})
final class BottomRightAnimController$executeAnim$$inlined$let$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b $it;
    final /* synthetic */ b $requestAnim$inlined;
    final /* synthetic */ BottomRightAnimController this$0;

    public BottomRightAnimController$executeAnim$$inlined$let$lambda$2(b r100, BottomRightAnimController r101, b r102) {
        this.$it = r100;
        this.this$0 = r101;
        this.$requestAnim$inlined = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BottomRightAnimController r100 = this.this$0;
        int r101 = BottomRightAnimController.f151962j;
        r100.getClass();
        this.$it.b();
        b r102 = this.$it;
        r102.f151994e.invoke(r102.f151992c, new AnonymousClass1(this));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
