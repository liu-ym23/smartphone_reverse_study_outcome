package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/x;", "", "", "switch", "Z", "c", "()Z", "removeSearchTokenC", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "urlAllowList", "Ljava/util/List;", "d", "()Ljava/util/List;", "Lcom/bytedance/android/btm/impl/setting/v;", "sourceToVirtualNode", "b", "Lcom/bytedance/android/btm/impl/setting/y;", "virtualNodeChangePreList", "e", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class x {

    @SerializedName("remove_search_token_c")
    private final boolean removeSearchTokenC;

    @SerializedName("source_to_virtual_node")
    private final List<v> sourceToVirtualNode;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final boolean f65switch;

    @SerializedName("url_allow_list")
    private final List<String> urlAllowList;

    @SerializedName("virtual_node_change_pre_list")
    private final List<y> virtualNodeChangePreList;

    public x() {
        this.urlAllowList = CollectionsKt.emptyList();
        this.sourceToVirtualNode = CollectionsKt.emptyList();
        this.virtualNodeChangePreList = CollectionsKt.emptyList();
    }

    public final boolean a() {
        return this.removeSearchTokenC;
    }

    public final List<v> b() {
        return this.sourceToVirtualNode;
    }

    public final boolean c() {
        return this.f65switch;
    }

    public final List<String> d() {
        return this.urlAllowList;
    }

    public final List<y> e() {
        return this.virtualNodeChangePreList;
    }
}
