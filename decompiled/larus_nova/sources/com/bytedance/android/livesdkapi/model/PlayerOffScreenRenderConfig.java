package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerOffScreenRenderConfig;", "", "enableDynamicOpen", "", "enableCustom", "(ZZ)V", "getEnableCustom", "()Z", "getEnableDynamicOpen", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerOffScreenRenderConfig {

    @SerializedName("enable_custom")
    private final boolean enableCustom;

    @SerializedName("enable_dynamic_open")
    private final boolean enableDynamicOpen;

    public PlayerOffScreenRenderConfig() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public final boolean getEnableCustom() {
        return this.enableCustom;
    }

    public final boolean getEnableDynamicOpen() {
        return this.enableDynamicOpen;
    }

    public PlayerOffScreenRenderConfig(boolean r100, boolean r101) {
        this.enableDynamicOpen = r100;
        this.enableCustom = r101;
    }

    public /* synthetic */ PlayerOffScreenRenderConfig(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }
}
