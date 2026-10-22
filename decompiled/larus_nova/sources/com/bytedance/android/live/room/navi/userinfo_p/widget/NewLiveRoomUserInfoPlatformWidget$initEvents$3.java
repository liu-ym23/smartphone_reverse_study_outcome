package com.bytedance.android.live.room.navi.userinfo_p.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import zg1.n3;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/n3;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lzg1/n3;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NewLiveRoomUserInfoPlatformWidget$initEvents$3 extends FunctionReferenceImpl implements Function1<n3, Unit> {
    public NewLiveRoomUserInfoPlatformWidget$initEvents$3(NewLiveRoomUserInfoPlatformWidget r100) {
        super(1, r100, NewLiveRoomUserInfoPlatformWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/VrLandscapeEnterImmersedMode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(n3 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(n3 r100) {
        ((NewLiveRoomUserInfoPlatformWidget) this.receiver).onEvent(r100);
    }
}
