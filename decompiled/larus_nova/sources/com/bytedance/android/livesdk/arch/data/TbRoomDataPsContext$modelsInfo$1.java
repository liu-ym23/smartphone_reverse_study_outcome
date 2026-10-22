package com.bytedance.android.livesdk.arch.data;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class TbRoomDataPsContext$modelsInfo$1 extends Lambda implements Function1<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s, CharSequence> {
    public static final TbRoomDataPsContext$modelsInfo$1 INSTANCE = null;

    static {
        INSTANCE = new TbRoomDataPsContext$modelsInfo$1();
    }

    public TbRoomDataPsContext$modelsInfo$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.f116191a + '-' + r100.f116192b;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        return invoke2(r100);
    }
}
