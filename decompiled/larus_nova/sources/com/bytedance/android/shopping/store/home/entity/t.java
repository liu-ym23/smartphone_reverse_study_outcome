package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/t;", "", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;", "tabData", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;", "b", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;", "setTabData", "(Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;)V", "", "passThroughFE", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setPassThroughFE", "(Ljava/lang/String;)V", "tabEventName", "d", "setTabEventName", "tabEventExtraParams", "c", "setTabEventExtraParams", "tmpId", "e", "setTmpId", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("pass_through_fe")
    private String passThroughFE;

    @SerializedName("tab_data")
    private ECStoreDynamicTabData tabData;

    @SerializedName("tab_event_extra_params")
    private String tabEventExtraParams;

    @SerializedName("tab_event_name")
    private String tabEventName;

    @SerializedName("tmp_id")
    private String tmpId;

    public t() {
    }

    public final String a() {
        return this.passThroughFE;
    }

    public final ECStoreDynamicTabData b() {
        return this.tabData;
    }

    public final String c() {
        return this.tabEventExtraParams;
    }

    public final String d() {
        return this.tabEventName;
    }

    public final String e() {
        return this.tmpId;
    }
}
