package com.bytedance.android.livesdk.chatroom.replay.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/e;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/e;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ReplayToolbarFilterUtils$getCastScreenSaasFilter$1 extends Lambda implements Function1<e, Boolean> {
    public static final ReplayToolbarFilterUtils$getCastScreenSaasFilter$1 INSTANCE = null;

    static {
        INSTANCE = new ReplayToolbarFilterUtils$getCastScreenSaasFilter$1();
    }

    public ReplayToolbarFilterUtils$getCastScreenSaasFilter$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(e r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r.d().isSaas() == false) goto L20;
        String r101 = r100.f110129a.f();
        if (Intrinsics.areEqual(r101, ToolbarButton.VS_CAST_SCREEN.name()) == true) goto L17;
        if (Intrinsics.areEqual(r101, ToolbarButton.REPLAY_CAST_SCREEN.name()) == true) goto L17;
        if (Intrinsics.areEqual(r101, ToolbarButton.CAST_FEED_BACK.name()) == true) goto L14;
        if (Intrinsics.areEqual(r101, ToolbarButton.REPLAY_CAST_SCREEN_FEED_BACK.name()) == false) goto L20;
    L14:
        if (r100.f110130b != null) goto L20;
    L19:
        return false;
    L17:
        if (r100.f110130b == null) goto L19;
    L20:
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(e r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
