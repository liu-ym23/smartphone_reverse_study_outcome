package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/s;", "", "", "switch", "I", "c", "()I", "chainLength", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "bcmWhiteList", "Ljava/util/List;", "getBcmWhiteList", "()Ljava/util/List;", "enableChainByToken", "b", "useGecko", "getUseGecko", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class s {

    @SerializedName("bcm_whitelist")
    private final List<String> bcmWhiteList;

    @SerializedName("chain_length")
    private final int chainLength;

    @SerializedName("enable_chain_by_token")
    private final int enableChainByToken;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f77switch;

    @SerializedName("use_gecko")
    private final int useGecko;

    public s() {
        this.f77switch = 1;
        this.chainLength = 20;
        this.bcmWhiteList = CollectionsKt.emptyList();
        this.enableChainByToken = 1;
        this.useGecko = 1;
    }

    public final int a() {
        return this.chainLength;
    }

    public final int b() {
        return this.enableChainByToken;
    }

    public final int c() {
        return this.f77switch;
    }
}
