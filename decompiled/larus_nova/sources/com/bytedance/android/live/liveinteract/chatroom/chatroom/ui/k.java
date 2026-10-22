package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f72469a = null;

    static {
        f72469a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "e");
        int r102 = VideoTalkRoomApplyCancelDialog.f72433e;
        ALogger.e("VideoTalkRoomApplyCancelDialog", "LinkAudienceApi#getUserWaitingRankPosition()失败", r101);
    }
}
