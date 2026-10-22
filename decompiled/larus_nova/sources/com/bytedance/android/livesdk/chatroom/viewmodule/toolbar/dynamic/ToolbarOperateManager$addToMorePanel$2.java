package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "p1", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ToolbarOperateManager$addToMorePanel$2 extends FunctionReferenceImpl implements Function2<s, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Unit> {
    public ToolbarOperateManager$addToMorePanel$2(g3 r100) {
        super(2, r100, g3.class, "loadNetButton", "loadNetButton(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/NewToolbarModel;Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/IToolbarManager$IToolbarBehavior;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(s r100, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        ((g3) this.receiver).A(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(s r100, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
