package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/d;", "", "", "", "bcmKeys", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "entranceInfoKeys", "c", "targetBtm", "d", "cutBtm", "b", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    @SerializedName("bcm_key")
    private final List<String> bcmKeys;

    @SerializedName("cut_btm")
    private final List<String> cutBtm;

    @SerializedName("entrance_info_key")
    private final List<String> entranceInfoKeys;

    @SerializedName("target_btm")
    private final List<String> targetBtm;

    public d() {
        this.bcmKeys = CollectionsKt.emptyList();
        this.entranceInfoKeys = CollectionsKt.emptyList();
        this.targetBtm = CollectionsKt.emptyList();
        this.cutBtm = CollectionsKt.emptyList();
    }

    public final List<String> a() {
        return this.bcmKeys;
    }

    public final List<String> b() {
        return this.cutBtm;
    }

    public final List<String> c() {
        return this.entranceInfoKeys;
    }

    public final List<String> d() {
        return this.targetBtm;
    }
}
