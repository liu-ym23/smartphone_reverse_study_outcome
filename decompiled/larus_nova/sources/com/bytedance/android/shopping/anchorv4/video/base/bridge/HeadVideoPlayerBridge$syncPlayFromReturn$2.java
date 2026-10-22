package com.bytedance.android.shopping.anchorv4.video.base.bridge;

import com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/video/base/bridge/intf/callback/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/shopping/anchorv4/video/base/bridge/intf/callback/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class HeadVideoPlayerBridge$syncPlayFromReturn$2 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ HeadVideoPlayerBridge this$0;

    public HeadVideoPlayerBridge$syncPlayFromReturn$2(HeadVideoPlayerBridge r100, boolean r101) {
        this.this$0 = r100;
        this.$isPlaying = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (this.$isPlaying == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        r100.i2(r101);
        return;
    L5:
        if (this.this$0.isPlaying() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
