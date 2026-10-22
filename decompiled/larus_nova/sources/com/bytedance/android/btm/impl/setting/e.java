package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/e;", "", "", "useGecko", "I", "f", "()I", "setUseGecko", "(I)V", "switch", "e", "setSwitch", "deleteUnregistered", "c", "setDeleteUnregistered", "", "", "bizWhitelist", "Ljava/util/List;", "b", "()Ljava/util/List;", "setBizWhitelist", "(Ljava/util/List;)V", "keyWhitelist", "d", "setKeyWhitelist", "bcmPassThroughList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class e {

    @SerializedName("bcm_pass_through")
    private final List<String> bcmPassThroughList;

    @SerializedName("biz_whitelist")
    private List<String> bizWhitelist;

    @SerializedName("delete_unregistered")
    private int deleteUnregistered;

    @SerializedName("key_whitelist")
    private List<String> keyWhitelist;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private int f59switch;

    @SerializedName("use_gecko")
    private int useGecko;

    public e() {
        this.useGecko = 1;
        this.deleteUnregistered = 1;
        this.bizWhitelist = CollectionsKt.emptyList();
        this.keyWhitelist = CollectionsKt.emptyList();
        this.bcmPassThroughList = CollectionsKt.emptyList();
    }

    public final List<String> a() {
        return this.bcmPassThroughList;
    }

    public final List<String> b() {
        return this.bizWhitelist;
    }

    public final int c() {
        return this.deleteUnregistered;
    }

    public final List<String> d() {
        return this.keyWhitelist;
    }

    public final int e() {
        return this.f59switch;
    }

    public final int f() {
        return this.useGecko;
    }
}
