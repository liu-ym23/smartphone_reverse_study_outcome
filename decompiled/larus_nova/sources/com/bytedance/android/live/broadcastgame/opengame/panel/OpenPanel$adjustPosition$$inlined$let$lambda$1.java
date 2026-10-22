package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/broadcastgame/opengame/panel/OpenPanel$adjustPosition$1$1$1", "com/bytedance/android/live/broadcastgame/opengame/panel/OpenPanel$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 4, 3})
final class OpenPanel$adjustPosition$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $gravity$inlined;
    final /* synthetic */ Window $it$inlined;
    final /* synthetic */ WindowManager.LayoutParams $lp;
    final /* synthetic */ OpenPanel this$0;

    public OpenPanel$adjustPosition$$inlined$let$lambda$1(WindowManager.LayoutParams r100, Window r101, OpenPanel r102, int r103) {
        this.$lp = r100;
        this.$it$inlined = r101;
        this.this$0 = r102;
        this.$gravity$inlined = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Window r100 = this.this$0.getWindow();
        if (r100 == null) goto L6;
        r100.setAttributes(this.$lp);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
