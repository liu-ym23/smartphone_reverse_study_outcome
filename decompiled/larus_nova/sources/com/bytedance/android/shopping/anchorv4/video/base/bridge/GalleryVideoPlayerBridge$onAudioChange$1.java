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
final class GalleryVideoPlayerBridge$onAudioChange$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ boolean $mute;

    public GalleryVideoPlayerBridge$onAudioChange$1(boolean r100) {
        this.$mute = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.P1(this.$mute);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
