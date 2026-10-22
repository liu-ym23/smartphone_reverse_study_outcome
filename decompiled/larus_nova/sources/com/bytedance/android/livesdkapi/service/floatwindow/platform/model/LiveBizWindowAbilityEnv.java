package com.bytedance.android.livesdkapi.service.floatwindow.platform.model;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;", "", "()V", "isShowingOnToolbar", "Lkotlin/Function1;", "", "", "()Lkotlin/jvm/functions/Function1;", "setShowingOnToolbar", "(Lkotlin/jvm/functions/Function1;)V", "requestPage", "", "getRequestPage", "()Ljava/lang/String;", "setRequestPage", "(Ljava/lang/String;)V", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "clear", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBizWindowAbilityEnv {
    private Function1<? super Integer, Boolean> isShowingOnToolbar;
    private String requestPage;
    private Room room;

    public final void clear() {
        this.room = null;
        this.requestPage = "";
    }

    public LiveBizWindowAbilityEnv() {
        this.requestPage = "";
    }

    public final String getRequestPage() {
        return this.requestPage;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final Function1<Integer, Boolean> isShowingOnToolbar() {
        return this.isShowingOnToolbar;
    }

    public final void setRequestPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestPage = r100;
    }

    public final void setRoom(Room r100) {
        this.room = r100;
    }

    public final void setShowingOnToolbar(Function1<? super Integer, Boolean> r100) {
        this.isShowingOnToolbar = r100;
    }
}
