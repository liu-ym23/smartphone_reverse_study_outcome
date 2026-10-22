package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.model;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/model/AuctionAtmosphereState;", "Ljava/io/Serializable;", "()V", "isFold", "", "()Z", "setFold", "(Z)V", "lastInfo", "", "getLastInfo", "()Ljava/lang/String;", "setLastInfo", "(Ljava/lang/String;)V", "lastType", "", "getLastType", "()I", "setLastType", "(I)V", BasicTestActionHandler.TEST_ACTION_RESET, "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionAtmosphereState implements Serializable {
    private boolean isFold;
    private String lastInfo;
    private int lastType;

    public final void reset() {
        this.lastInfo = "";
        this.lastType = 0;
    }

    public AuctionAtmosphereState() {
        this.lastInfo = "";
    }

    public final String getLastInfo() {
        return this.lastInfo;
    }

    public final int getLastType() {
        return this.lastType;
    }

    public final boolean isFold() {
        return this.isFold;
    }

    public final void setFold(boolean r100) {
        this.isFold = r100;
    }

    public final void setLastInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lastInfo = r100;
    }

    public final void setLastType(int r100) {
        this.lastType = r100;
    }
}
