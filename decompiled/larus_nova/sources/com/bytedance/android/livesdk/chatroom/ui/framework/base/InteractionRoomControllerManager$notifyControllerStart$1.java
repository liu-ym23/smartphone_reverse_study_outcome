package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class InteractionRoomControllerManager$notifyControllerStart$1 extends Lambda implements Function1<ILiveRoomController, Unit> {
    public static final InteractionRoomControllerManager$notifyControllerStart$1 INSTANCE = null;

    static {
        INSTANCE = new InteractionRoomControllerManager$notifyControllerStart$1();
    }

    public InteractionRoomControllerManager$notifyControllerStart$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ILiveRoomController r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        r100.onStart();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ILiveRoomController r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
