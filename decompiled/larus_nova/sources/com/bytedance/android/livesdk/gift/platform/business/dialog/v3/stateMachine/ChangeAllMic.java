package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ChangeAllMic;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "preAllMic", "", "allMic", "(ZZ)V", "getAllMic", "()Z", "getPreAllMic", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeAllMic extends GiftRepoAction {
    private final boolean allMic;
    private final boolean preAllMic;

    public final boolean getAllMic() {
        return this.allMic;
    }

    public final boolean getPreAllMic() {
        return this.preAllMic;
    }

    public ChangeAllMic(boolean r100, boolean r101) {
        super("ChangeAllMic");
        this.preAllMic = r100;
        this.allMic = r101;
    }
}
