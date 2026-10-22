package com.obric.autogui.common.api.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: IAutoActionGlobalUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IslandState {
    private final boolean inDialogueMode;
    private final boolean isExpand;
    private final boolean visible;

    public IslandState() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ IslandState copy$default(IslandState r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.visible;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isExpand;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.inDialogueMode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final boolean component2() {
        return this.isExpand;
    }

    public final boolean component3() {
        return this.inDialogueMode;
    }

    public final IslandState copy(boolean r1, boolean r2, boolean r3) {
        return new IslandState(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IslandState.class) == true) goto L8;
        return false;
    L8:
        IslandState r6 = (IslandState) ZeusTransformUtils.preCheckCast(r5, IslandState.class, "com.obric.aiagent.plugin");
        if (this.visible == r6.visible) goto L12;
        return false;
    L12:
        if (this.isExpand == r6.isExpand) goto L15;
        return false;
    L15:
        if (this.inDialogueMode == r6.inDialogueMode) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.visible) * 31) + Boolean.hashCode(this.isExpand)) * 31) + Boolean.hashCode(this.inDialogueMode);
    }

    public String toString() {
        return "IslandState(visible=" + this.visible + ", isExpand=" + this.isExpand + ", inDialogueMode=" + this.inDialogueMode + ')';
    }

    public IslandState(boolean r1, boolean r2, boolean r3) {
        this.visible = r1;
        this.isExpand = r2;
        this.inDialogueMode = r3;
    }

    public /* synthetic */ IslandState(boolean r2, boolean r3, boolean r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final boolean isExpand() {
        return this.isExpand;
    }

    public final boolean getInDialogueMode() {
        return this.inDialogueMode;
    }
}
