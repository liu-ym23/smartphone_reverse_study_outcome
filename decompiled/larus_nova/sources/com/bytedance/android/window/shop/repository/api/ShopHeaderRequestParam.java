package com.bytedance.android.window.shop.repository.api;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/ShopHeaderRequestParam;", "Ljava/io/Serializable;", "()V", "ecExtra", "", "getEcExtra", "()Ljava/lang/String;", "setEcExtra", "(Ljava/lang/String;)V", "isPrefetch", "", "()I", "setPrefetch", "(I)V", "passThroughApi", "getPassThroughApi", "setPassThroughApi", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "getSceneType", "()Ljava/lang/Integer;", "setSceneType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "secAuthorId", "getSecAuthorId", "setSecAuthorId", "sourceType", "getSourceType", "setSourceType", "upgradeVersion", "getUpgradeVersion", "setUpgradeVersion", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopHeaderRequestParam implements Serializable {
    private String ecExtra;
    private int isPrefetch;
    private String passThroughApi;
    private Integer sceneType;
    private String secAuthorId;
    private Integer sourceType;
    private Integer upgradeVersion;

    public ShopHeaderRequestParam() {
        this.secAuthorId = "";
    }

    public final String getEcExtra() {
        return this.ecExtra;
    }

    public final String getPassThroughApi() {
        return this.passThroughApi;
    }

    public final Integer getSceneType() {
        return this.sceneType;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final Integer getUpgradeVersion() {
        return this.upgradeVersion;
    }

    public final int isPrefetch() {
        return this.isPrefetch;
    }

    public final void setEcExtra(String r100) {
        this.ecExtra = r100;
    }

    public final void setPassThroughApi(String r100) {
        this.passThroughApi = r100;
    }

    public final void setPrefetch(int r100) {
        this.isPrefetch = r100;
    }

    public final void setSceneType(Integer r100) {
        this.sceneType = r100;
    }

    public final void setSecAuthorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secAuthorId = r100;
    }

    public final void setSourceType(Integer r100) {
        this.sourceType = r100;
    }

    public final void setUpgradeVersion(Integer r100) {
        this.upgradeVersion = r100;
    }
}
