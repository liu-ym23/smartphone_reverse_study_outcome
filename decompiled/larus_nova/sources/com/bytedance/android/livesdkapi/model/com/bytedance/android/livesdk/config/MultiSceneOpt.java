package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/MultiSceneOpt;", "", "()V", "backendOpt", "", "getBackendOpt", "()Z", "setBackendOpt", "(Z)V", "isLoadAfterP0", "setLoadAfterP0", "isLoadBeforeP0", "setLoadBeforeP0", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiSceneOpt {

    @SerializedName("backend_opt")
    private boolean backendOpt;

    @SerializedName("is_load_after_p0")
    private boolean isLoadAfterP0;

    @SerializedName("is_load_before_p0")
    private boolean isLoadBeforeP0;

    public MultiSceneOpt() {
        this.isLoadBeforeP0 = true;
        this.backendOpt = true;
    }

    public final boolean getBackendOpt() {
        return this.backendOpt;
    }

    public final boolean isLoadAfterP0() {
        return this.isLoadAfterP0;
    }

    public final boolean isLoadBeforeP0() {
        return this.isLoadBeforeP0;
    }

    public final void setBackendOpt(boolean r100) {
        this.backendOpt = r100;
    }

    public final void setLoadAfterP0(boolean r100) {
        this.isLoadAfterP0 = r100;
    }

    public final void setLoadBeforeP0(boolean r100) {
        this.isLoadBeforeP0 = r100;
    }
}
