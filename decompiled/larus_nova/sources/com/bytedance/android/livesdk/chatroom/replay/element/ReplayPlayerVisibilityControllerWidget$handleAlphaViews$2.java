package com.bytedance.android.livesdk.chatroom.replay.element;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ReplayPlayerVisibilityControllerWidget$handleAlphaViews$2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> {
    final /* synthetic */ ReplayPlayerVisibilityControllerWidget$handleAlphaViews$1 $realHandle$1;

    public ReplayPlayerVisibilityControllerWidget$handleAlphaViews$2(ReplayPlayerVisibilityControllerWidget$handleAlphaViews$1 r100) {
        this.$realHandle$1 = r100;
        super(1, null, "realHandle", "invoke(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/VSPlayerViewControlItem;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        this.$realHandle$1.invoke2(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
