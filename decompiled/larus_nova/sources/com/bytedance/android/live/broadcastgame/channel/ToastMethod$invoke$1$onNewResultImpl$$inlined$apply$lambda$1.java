package com.bytedance.android.live.broadcastgame.channel;

import android.graphics.Bitmap;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/broadcastgame/channel/ToastMethod$invoke$1$onNewResultImpl$1$1"}, k = 3, mv = {1, 4, 3})
final class ToastMethod$invoke$1$onNewResultImpl$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Bitmap $bitmap$inlined;
    final /* synthetic */ f this$0;

    public ToastMethod$invoke$1$onNewResultImpl$$inlined$apply$lambda$1(f r100, Bitmap r101) {
        this.$bitmap$inlined = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$bitmap$inlined.copy(Bitmap.Config.ARGB_8888, true) != null) goto L5;
        return;
    L5:
        String r100 = rm3.c.f538539a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
