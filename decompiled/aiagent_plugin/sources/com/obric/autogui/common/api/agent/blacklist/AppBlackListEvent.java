package com.obric.autogui.common.api.agent.blacklist;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AppBlackListEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AppBlackListEvent {
    private final ComponentName activityName;
    private final AppBlackListState blackListState;
    private boolean isAcknowledged;
    private final int loopNumber;
    private int stepNumber;

    public static /* synthetic */ AppBlackListEvent copy$default(AppBlackListEvent r3, ComponentName r4, AppBlackListState r5, int r6, int r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.activityName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.blackListState;
    L8:
        AppBlackListState r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.loopNumber;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.stepNumber;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isAcknowledged;
    L17:
        ComponentName r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final ComponentName component1() {
        return this.activityName;
    }

    public final AppBlackListState component2() {
        return this.blackListState;
    }

    public final int component3() {
        return this.loopNumber;
    }

    public final int component4() {
        return this.stepNumber;
    }

    public final boolean component5() {
        return this.isAcknowledged;
    }

    public final AppBlackListEvent copy(ComponentName r7, AppBlackListState r8, int r9, int r10, boolean r11) {
        o.e(r7, "activityName");
        o.e(r8, "blackListState");
        return new AppBlackListEvent(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppBlackListEvent.class) == true) goto L8;
        return false;
    L8:
        AppBlackListEvent r6 = (AppBlackListEvent) ZeusTransformUtils.preCheckCast(r5, AppBlackListEvent.class, "com.obric.aiagent.plugin");
        if (o.a(this.activityName, r6.activityName) == true) goto L12;
        return false;
    L12:
        if (this.blackListState == r6.blackListState) goto L15;
        return false;
    L15:
        if (this.loopNumber == r6.loopNumber) goto L18;
        return false;
    L18:
        if (this.stepNumber == r6.stepNumber) goto L21;
        return false;
    L21:
        if (this.isAcknowledged == r6.isAcknowledged) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.activityName.hashCode() * 31) + this.blackListState.hashCode()) * 31) + Integer.hashCode(this.loopNumber)) * 31) + Integer.hashCode(this.stepNumber)) * 31) + Boolean.hashCode(this.isAcknowledged);
    }

    public String toString() {
        return "AppBlackListEvent(activityName=" + this.activityName + ", blackListState=" + this.blackListState + ", loopNumber=" + this.loopNumber + ", stepNumber=" + this.stepNumber + ", isAcknowledged=" + this.isAcknowledged + ')';
    }

    public AppBlackListEvent(ComponentName r2, AppBlackListState r3, int r4, int r5, boolean r6) {
        o.e(r2, "activityName");
        o.e(r3, "blackListState");
        this.activityName = r2;
        this.blackListState = r3;
        this.loopNumber = r4;
        this.stepNumber = r5;
        this.isAcknowledged = r6;
    }

    public /* synthetic */ AppBlackListEvent(ComponentName r8, AppBlackListState r9, int r10, int r11, boolean r12, int r13, h r14) {
        if ((r13 & 4) == 0) goto L5;
        int r4 = -1;
    L7:
        if ((r13 & 8) == 0) goto L9;
        int r5 = -1;
    L11:
        if ((r13 & 16) == 0) goto L13;
        r12 = false;
    L13:
        this(r8, r9, r4, r5, r12);
        return;
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public final ComponentName getActivityName() {
        return this.activityName;
    }

    public final AppBlackListState getBlackListState() {
        return this.blackListState;
    }

    public final int getLoopNumber() {
        return this.loopNumber;
    }

    public final int getStepNumber() {
        return this.stepNumber;
    }

    public final void setStepNumber(int r1) {
        this.stepNumber = r1;
    }

    public final boolean isAcknowledged() {
        return this.isAcknowledged;
    }

    public final void setAcknowledged(boolean r1) {
        this.isAcknowledged = r1;
    }
}
