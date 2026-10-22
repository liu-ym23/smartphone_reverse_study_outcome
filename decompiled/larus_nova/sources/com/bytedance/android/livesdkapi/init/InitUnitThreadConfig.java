package com.bytedance.android.livesdkapi.init;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/InitUnitThreadConfig;", "", "()V", "ensureLazy", "", "getEnsureLazy", "()I", "setEnsureLazy", "(I)V", "initLazyTask", "getInitLazyTask", "setInitLazyTask", "initLazyTaskV2", "getInitLazyTaskV2", "setInitLazyTaskV2", "initLiveio", "getInitLiveio", "setInitLiveio", "initOtherLazy", "getInitOtherLazy", "setInitOtherLazy", "revenueLazy", "getRevenueLazy", "setRevenueLazy", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InitUnitThreadConfig {

    @SerializedName("ensure_lazy")
    private int ensureLazy;

    @SerializedName("init_lazy_task")
    private int initLazyTask;

    @SerializedName("init_lazy_task_v2")
    private int initLazyTaskV2;

    @SerializedName("init_liveio")
    private int initLiveio;

    @SerializedName("init_other_lazy")
    private int initOtherLazy;

    @SerializedName("revenue_lazy")
    private int revenueLazy;

    public InitUnitThreadConfig() {
    }

    public final int getEnsureLazy() {
        return this.ensureLazy;
    }

    public final int getInitLazyTask() {
        return this.initLazyTask;
    }

    public final int getInitLazyTaskV2() {
        return this.initLazyTaskV2;
    }

    public final int getInitLiveio() {
        return this.initLiveio;
    }

    public final int getInitOtherLazy() {
        return this.initOtherLazy;
    }

    public final int getRevenueLazy() {
        return this.revenueLazy;
    }

    public final void setEnsureLazy(int r100) {
        this.ensureLazy = r100;
    }

    public final void setInitLazyTask(int r100) {
        this.initLazyTask = r100;
    }

    public final void setInitLazyTaskV2(int r100) {
        this.initLazyTaskV2 = r100;
    }

    public final void setInitLiveio(int r100) {
        this.initLiveio = r100;
    }

    public final void setInitOtherLazy(int r100) {
        this.initOtherLazy = r100;
    }

    public final void setRevenueLazy(int r100) {
        this.revenueLazy = r100;
    }
}
