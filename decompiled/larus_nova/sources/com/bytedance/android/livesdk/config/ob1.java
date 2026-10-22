package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/ob1;", "", "", "geckoResPreLoadEnable", "Z", "localCacheLoaderEnable", "geckoLoaderEnable", "", "", "geckoOfflineUILayoutDisableList", "Ljava/util/List;", "geckoOfflineUILayoutDisableListV2", "", "", "switchLayoutFailedUiLayoutConvertMap", "Ljava/util/Map;", "localAssetsLoaderEnable", "localCodeLoaderEnable", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ob1 {

    @SerializedName("enable_gecko_loader")
    private boolean geckoLoaderEnable;

    @SerializedName("gecko_offline_ui_layout_disable_list")
    private List<String> geckoOfflineUILayoutDisableList;

    @SerializedName("gecko_offline_ui_layout_disable_list_v2")
    private List<String> geckoOfflineUILayoutDisableListV2;

    @SerializedName("enable_gecko_res_preload")
    private boolean geckoResPreLoadEnable;

    @SerializedName("enable_local_assets_loader")
    private boolean localAssetsLoaderEnable;

    @SerializedName("enable_local_cache_loader")
    private boolean localCacheLoaderEnable;

    @SerializedName("enable_local_code_loader")
    private boolean localCodeLoaderEnable;

    @SerializedName("switch_layout_failed_ui_layout_convert_map")
    private Map<Integer, Integer> switchLayoutFailedUiLayoutConvertMap;

    public final boolean a() {
        if (this.geckoLoaderEnable == false) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<String> b() {
        List<String> r100 = this.geckoOfflineUILayoutDisableListV2;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    public final boolean d() {
        if (this.geckoResPreLoadEnable == false) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e() {
        if (this.localAssetsLoaderEnable == false) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean f() {
        if (this.localCacheLoaderEnable == false) goto L5;
        return true;
    L5:
        return false;
    }

    public ob1() {
        this.geckoResPreLoadEnable = true;
        this.geckoLoaderEnable = true;
        this.switchLayoutFailedUiLayoutConvertMap = new HashMap();
        this.localAssetsLoaderEnable = true;
        this.localCodeLoaderEnable = true;
    }

    public final Map<Integer, Integer> c() {
        return this.switchLayoutFailedUiLayoutConvertMap;
    }
}
