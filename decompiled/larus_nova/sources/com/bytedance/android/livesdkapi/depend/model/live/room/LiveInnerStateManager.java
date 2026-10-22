package com.bytedance.android.livesdkapi.depend.model.live.room;

import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/room/LiveInnerStateManager;", "", "externalConfigJudger", "Lcom/bytedance/android/livesdkapi/distribution/IExternalConfigJudger;", "(Lcom/bytedance/android/livesdkapi/distribution/IExternalConfigJudger;)V", "curState", "", "getExternalConfigJudger", "()Lcom/bytedance/android/livesdkapi/distribution/IExternalConfigJudger;", "canContinueExit", "", "canExitRoom", "canPartExit", "canStartRoom", "isDistributionMode", "isEnableRepeatLeaveCheck", "isPartExit", "onRoomFullFinish", "", "onRoomPartFinish", "onRoomStart", "Companion", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerStateManager {
    public static final Companion Companion = null;
    public static final String STATE_FULL_FINISH = "full_finish";
    public static final String STATE_INIT = "init";
    public static final String STATE_PART_FINISH = "part_finish";
    public static final String STATE_START = "start";
    private String curState;
    private final IExternalConfigJudger externalConfigJudger;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/room/LiveInnerStateManager$Companion;", "", "()V", "STATE_FULL_FINISH", "", "STATE_INIT", "STATE_PART_FINISH", "STATE_START", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final boolean isDistributionMode() {
        IExternalConfigJudger r100 = this.externalConfigJudger;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isInExternalMode() != true) goto L7;
        return true;
    }

    private final boolean isEnableRepeatLeaveCheck() {
        IExternalConfigJudger r100 = this.externalConfigJudger;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isEnableRepeatLeaveCheck());
    L7:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L7
    }

    public final boolean canContinueExit() {
        if (isDistributionMode() == true) goto L7;
        return false;
    L7:
        if (isEnableRepeatLeaveCheck() == true) goto L11;
        return true;
    L11:
        return Intrinsics.areEqual(this.curState, STATE_PART_FINISH);
    }

    public final boolean canExitRoom() {
        if (isDistributionMode() == true) goto L5;
    L14:
        return true;
    L5:
        if (isEnableRepeatLeaveCheck() == false) goto L14;
        if (Intrinsics.areEqual(this.curState, "start") == true) goto L14;
        if (Intrinsics.areEqual(this.curState, STATE_PART_FINISH) == true) goto L14;
        return false;
    }

    public final boolean canPartExit() {
        if (isDistributionMode() == true) goto L7;
        return false;
    L7:
        if (isEnableRepeatLeaveCheck() == true) goto L11;
        return true;
    L11:
        return Intrinsics.areEqual(this.curState, "start");
    }

    public final boolean canStartRoom() {
        if (isDistributionMode() == true) goto L5;
    L12:
        return true;
    L5:
        if (isEnableRepeatLeaveCheck() == false) goto L12;
        if (Intrinsics.areEqual(this.curState, "init") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean isPartExit() {
        if (isDistributionMode() == true) goto L6;
        return false;
    L6:
        if (isEnableRepeatLeaveCheck() == true) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual(this.curState, STATE_PART_FINISH);
    }

    public final void onRoomFullFinish() {
        if (isDistributionMode() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.curState, "start") == false) goto L8;
    L9:
        this.curState = "init";
        return;
    L8:
        if (Intrinsics.areEqual(this.curState, STATE_PART_FINISH) == true) goto L9;
    }

    public final void onRoomPartFinish() {
        if (isDistributionMode() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.curState, "start") == false) goto L9;
        this.curState = STATE_PART_FINISH;
        return;
    }

    public final void onRoomStart() {
        if (isDistributionMode() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.curState, "init") == false) goto L9;
        this.curState = "start";
        return;
    }

    public final IExternalConfigJudger getExternalConfigJudger() {
        return this.externalConfigJudger;
    }

    public LiveInnerStateManager(IExternalConfigJudger r100) {
        Intrinsics.checkNotNullParameter(r100, "externalConfigJudger");
        this.externalConfigJudger = r100;
        this.curState = "init";
    }
}
