package com.bytedance.android.shopping.sku.inner.repo.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/repo/model/SkuPassThroughItem;", "Ljava/io/Serializable;", "", "", RemoteMessageConst.TO, "Ljava/util/List;", "getTo", "()Ljava/util/List;", "data", "Ljava/lang/String;", "getData", "()Ljava/lang/String;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/Map;", "getRawMap", "()Ljava/util/Map;", "rawMap", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Map;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuPassThroughItem implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Map<String, String> f182964a;

    @SerializedName("data")
    private final String data;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    @SerializedName(RemoteMessageConst.TO)
    private final List<String> f182965to;

    public SkuPassThroughItem() {
        this(null, null, null, 7, null);
    }

    public final String getData() {
        return this.data;
    }

    public final Map<String, String> getRawMap() {
        return this.f182964a;
    }

    public final List<String> getTo() {
        return this.f182965to;
    }

    public SkuPassThroughItem(List<String> r100, String r101, Map<String, String> r102) {
        this.f182965to = r100;
        this.data = r101;
        this.f182964a = r102;
    }

    public /* synthetic */ SkuPassThroughItem(List r100, String r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
