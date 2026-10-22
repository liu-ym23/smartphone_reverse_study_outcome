package com.bytedance.android.livesdkapi.player.constants;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/constants/LiveSwitchCellularNetwork;", "", "()V", "CELLULAR", "", "DEFAULT", "usingCellularNetwork", "getUsingCellularNetwork", "()I", "setUsingCellularNetwork", "(I)V", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSwitchCellularNetwork {
    public static final int CELLULAR = 1;
    public static final int DEFAULT = 0;
    public static final LiveSwitchCellularNetwork INSTANCE = null;
    private static int usingCellularNetwork;

    private LiveSwitchCellularNetwork() {
    }

    static {
        INSTANCE = new LiveSwitchCellularNetwork();
    }

    public final int getUsingCellularNetwork() {
        return usingCellularNetwork;
    }

    public final void setUsingCellularNetwork(int r100) {
        usingCellularNetwork = r100;
    }
}
