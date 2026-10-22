package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/i;", "", "", "id", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "bundleUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "d", "extra", "getExtra", "setExtra", "", "zIndex", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setZIndex", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("bundle_url")
    private String bundleUrl;

    @SerializedName("extra")
    private String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f186824id;

    @SerializedName("z_index")
    private Integer zIndex;

    public i() {
    }

    public final String a() {
        return this.bundleUrl;
    }

    public final String b() {
        return this.f186824id;
    }

    public final Integer c() {
        return this.zIndex;
    }

    public final void d(String r100) {
        this.bundleUrl = r100;
    }
}
