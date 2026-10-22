package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreTabRenderConfig;", "Ljava/io/Serializable;", "", "size", "Ljava/lang/Integer;", "getSize", "()Ljava/lang/Integer;", "setSize", "(Ljava/lang/Integer;)V", "", "tmpId", "Ljava/lang/String;", "getTmpId", "()Ljava/lang/String;", "setTmpId", "(Ljava/lang/String;)V", "token", "getToken", "setToken", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreTabRenderConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("size")
    private Integer size;

    @SerializedName("tmp_id")
    private String tmpId;

    @SerializedName("token")
    private String token;

    public static final class a {
        public a() {
        }

        public static ECStoreTabRenderConfig a(ECStoreParam r100) {
            Intrinsics.checkNotNullParameter(r100, "storeParam");
            ECStoreTabRenderConfig r101 = new ECStoreTabRenderConfig();
            r101.setSize(10);
            r101.setTmpId(r100.getProductBasicRequestParam().getTmpId());
            r101.setToken(r100.getProductBasicRequestParam().getToken());
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreTabRenderConfig() {
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getTmpId() {
        return this.tmpId;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setSize(Integer r100) {
        this.size = r100;
    }

    public final void setTmpId(String r100) {
        this.tmpId = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }
}
