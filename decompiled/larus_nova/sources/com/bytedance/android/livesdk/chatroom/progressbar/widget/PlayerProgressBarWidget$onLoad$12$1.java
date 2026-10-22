package com.bytedance.android.livesdk.chatroom.progressbar.widget;

import com.bytedance.android.livesdk.chatroom.vsplayer.api.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/d;", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/d;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PlayerProgressBarWidget$onLoad$12$1 extends FunctionReferenceImpl implements Function2<d, Boolean, Unit> {
    public static final PlayerProgressBarWidget$onLoad$12$1 INSTANCE = null;

    static {
        INSTANCE = new PlayerProgressBarWidget$onLoad$12$1();
    }

    public PlayerProgressBarWidget$onLoad$12$1() {
        super(2, d.class, "onProgressBarStartTracking", "onProgressBarStartTracking(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(d r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(d r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        r100.E5();
    }
}
