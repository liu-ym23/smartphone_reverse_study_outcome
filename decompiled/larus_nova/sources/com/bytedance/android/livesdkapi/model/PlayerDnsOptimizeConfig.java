package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerDnsOptimizeConfig;", "", "enable", "", "freeFlowEnable", "(ZZ)V", "getEnable", "()Z", "getFreeFlowEnable", "setFreeFlowEnable", "(Z)V", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerDnsOptimizeConfig {
    private final boolean enable;
    private boolean freeFlowEnable;

    public PlayerDnsOptimizeConfig() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getFreeFlowEnable() {
        return this.freeFlowEnable;
    }

    public final void setFreeFlowEnable(boolean r100) {
        this.freeFlowEnable = r100;
    }

    public PlayerDnsOptimizeConfig(boolean r100, boolean r101) {
        this.enable = r100;
        this.freeFlowEnable = r101;
    }

    public /* synthetic */ PlayerDnsOptimizeConfig(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
