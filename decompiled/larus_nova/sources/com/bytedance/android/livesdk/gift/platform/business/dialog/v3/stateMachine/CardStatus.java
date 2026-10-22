package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/CardStatus;", "", "()V", OpenNetMethod.LOCK, "", "getLOCK", "()I", "UNLOCK", "getUNLOCK", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardStatus {
    public static final CardStatus INSTANCE = null;
    private static final int LOCK = 0;
    private static final int UNLOCK = 0;

    private CardStatus() {
    }

    static {
        INSTANCE = new CardStatus();
        LOCK = 1;
    }

    public final int getLOCK() {
        return LOCK;
    }

    public final int getUNLOCK() {
        return UNLOCK;
    }
}
