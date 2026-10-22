package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/IntroAuctionAtmosphereState;", "Ljava/io/Serializable;", "()V", "hasShown", "", "getHasShown", "()Z", "setHasShown", "(Z)V", "isFold", "setFold", "lastInfo", "", "getLastInfo", "()Ljava/lang/String;", "setLastInfo", "(Ljava/lang/String;)V", "lastNum", "", "getLastNum", "()I", "setLastNum", "(I)V", "lastType", "getLastType", "setLastType", BasicTestActionHandler.TEST_ACTION_RESET, "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroAuctionAtmosphereState implements Serializable {
    private boolean hasShown;
    private boolean isFold;
    private String lastInfo;
    private int lastNum;
    private int lastType;

    public final void reset() {
        this.lastInfo = "";
        this.lastType = 0;
        this.lastNum = 0;
        this.isFold = false;
        this.hasShown = false;
    }

    public IntroAuctionAtmosphereState() {
        this.lastInfo = "";
    }

    public final boolean getHasShown() {
        return this.hasShown;
    }

    public final String getLastInfo() {
        return this.lastInfo;
    }

    public final int getLastNum() {
        return this.lastNum;
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

    public final void setHasShown(boolean r100) {
        this.hasShown = r100;
    }

    public final void setLastInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lastInfo = r100;
    }

    public final void setLastNum(int r100) {
        this.lastNum = r100;
    }

    public final void setLastType(int r100) {
        this.lastType = r100;
    }
}
