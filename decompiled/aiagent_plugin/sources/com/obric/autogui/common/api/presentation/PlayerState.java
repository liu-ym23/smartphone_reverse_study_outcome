package com.obric.autogui.common.api.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionGlobalUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerState {
    private final IAutoActionPresentationApi.PlayerVisibility visible;

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PlayerState copy$default(PlayerState r0, IAutoActionPresentationApi.PlayerVisibility r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.visible;
    L6:
        return r0.copy(r1);
    }

    public final IAutoActionPresentationApi.PlayerVisibility component1() {
        return this.visible;
    }

    public final PlayerState copy(IAutoActionPresentationApi.PlayerVisibility r1) {
        o.e(r1, "visible");
        return new PlayerState(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PlayerState.class) == true) goto L8;
        return false;
    L8:
        PlayerState r6 = (PlayerState) ZeusTransformUtils.preCheckCast(r5, PlayerState.class, "com.obric.aiagent.plugin");
        if (this.visible == r6.visible) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.visible.hashCode();
    }

    public String toString() {
        return "PlayerState(visible=" + this.visible + ')';
    }

    public PlayerState(IAutoActionPresentationApi.PlayerVisibility r2) {
        o.e(r2, "visible");
        this.visible = r2;
    }

    public /* synthetic */ PlayerState(IAutoActionPresentationApi.PlayerVisibility r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = IAutoActionPresentationApi.PlayerVisibility.Invisible;
    L5:
        this(r1);
    }

    public final IAutoActionPresentationApi.PlayerVisibility getVisible() {
        return this.visible;
    }
}
