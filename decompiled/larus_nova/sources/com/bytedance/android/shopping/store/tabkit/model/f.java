package com.bytedance.android.shopping.store.tabkit.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/f;", "", "", "name", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "clickUrl", "b", "setClickUrl", "Lcom/bytedance/android/shopping/store/tabkit/model/c;", "bizConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/shopping/store/tabkit/model/c;", "setBizConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/c;)V", "text", "e", "setText", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f186823a;

    @SerializedName("biz_config")
    private c bizConfig;

    @SerializedName("click_url")
    private String clickUrl;

    @SerializedName("image")
    private ECUrlModel image;

    @SerializedName("name")
    private String name;

    @SerializedName("text")
    private String text;

    public f() {
    }

    public final c a() {
        return this.bizConfig;
    }

    public final String b() {
        return this.clickUrl;
    }

    public final ECUrlModel c() {
        return this.image;
    }

    public final String d() {
        return this.name;
    }

    public final String e() {
        return this.text;
    }
}
