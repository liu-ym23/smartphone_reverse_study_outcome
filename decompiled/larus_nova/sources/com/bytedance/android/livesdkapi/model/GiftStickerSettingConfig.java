package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GiftStickerSettingConfig;", "", "()V", "assetPathCheck", "", "getAssetPathCheck", "()Z", "setAssetPathCheck", "(Z)V", "pathExceptionReset", "getPathExceptionReset", "setPathExceptionReset", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftStickerSettingConfig {

    @SerializedName("asset_path")
    private boolean assetPathCheck;

    @SerializedName("path_exception_reset")
    private boolean pathExceptionReset;

    public GiftStickerSettingConfig() {
        this.assetPathCheck = true;
        this.pathExceptionReset = true;
    }

    public final boolean getAssetPathCheck() {
        return this.assetPathCheck;
    }

    public final boolean getPathExceptionReset() {
        return this.pathExceptionReset;
    }

    public final void setAssetPathCheck(boolean r100) {
        this.assetPathCheck = r100;
    }

    public final void setPathExceptionReset(boolean r100) {
        this.pathExceptionReset = r100;
    }
}
