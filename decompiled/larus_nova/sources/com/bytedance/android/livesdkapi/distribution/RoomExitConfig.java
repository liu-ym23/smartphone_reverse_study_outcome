package com.bytedance.android.livesdkapi.distribution;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tJ\u001a\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/RoomExitConfig;", "", "()V", "canShowEndPage", "", "enableUserClose", "exitActionMap", "", "Lcom/bytedance/android/livesdkapi/distribution/ExternalRoomExitReason;", "Lcom/bytedance/android/livesdkapi/distribution/RoomExitAction;", "leaveEndPageAction", "configEnableUserClose", "", "enable", "configEndPageAction", "canShowEnd", "leaveEndAction", "configExitAction", "map", "getLeaveEndAction", "getRoomExitAction", "endReason", "isCanShowEndPage", "isEnableUserClose", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomExitConfig {
    private boolean canShowEndPage;
    private boolean enableUserClose;
    private Map<ExternalRoomExitReason, RoomExitAction> exitActionMap;
    private RoomExitAction leaveEndPageAction;

    public RoomExitConfig() {
        this.enableUserClose = true;
        ExternalRoomExitReason r100 = ExternalRoomExitReason.LIVE_DISTRIBUTION_EXIT;
        RoomExitAction r101 = RoomExitAction.REMOVE_CONTAINER;
        this.exitActionMap = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r100, r101), TuplesKt.to(ExternalRoomExitReason.NORMAL, r101), TuplesKt.to(ExternalRoomExitReason.SLIDE, RoomExitAction.NO_ACTION), TuplesKt.to(ExternalRoomExitReason.LIVE_END, r101), TuplesKt.to(ExternalRoomExitReason.NEW_ROOM_CREATE, r101), TuplesKt.to(ExternalRoomExitReason.USER_PASSIVE_KICTOUT, r101), TuplesKt.to(ExternalRoomExitReason.USER_PROACTIVE_LEAVE, r101), TuplesKt.to(ExternalRoomExitReason.REPEAT_ENTER, r101), TuplesKt.to(ExternalRoomExitReason.ROOM_ERROR, r101)});
        this.leaveEndPageAction = r101;
        this.canShowEndPage = true;
    }

    public final RoomExitAction getLeaveEndAction() {
        return this.leaveEndPageAction;
    }

    public final boolean isCanShowEndPage() {
        return this.canShowEndPage;
    }

    public final boolean isEnableUserClose() {
        return this.enableUserClose;
    }

    public final void configEnableUserClose(boolean r100) {
        this.enableUserClose = r100;
    }

    public final void configExitAction(Map<ExternalRoomExitReason, RoomExitAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.exitActionMap.putAll(r100);
    }

    public final RoomExitAction getRoomExitAction(ExternalRoomExitReason r100) {
        Intrinsics.checkNotNullParameter(r100, "endReason");
        RoomExitAction r101 = this.exitActionMap.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return RoomExitAction.REMOVE_CONTAINER;
    }

    public final void configEndPageAction(boolean r100, RoomExitAction r101) {
        Intrinsics.checkNotNullParameter(r101, "leaveEndAction");
        this.canShowEndPage = r100;
        this.leaveEndPageAction = r101;
    }
}
