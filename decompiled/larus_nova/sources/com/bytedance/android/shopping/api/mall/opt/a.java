package com.bytedance.android.shopping.api.mall.opt;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/a;", "", "", "enable", "Z", "b", "()Z", "", "", "domains", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "expireDuration", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("domains")
    private final List<String> domains;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("expire_duration")
    private final Long expireDuration;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.api.mall.opt.a$a, reason: collision with other inner class name */
    public static final class C2562a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.domains, r101.domains) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.expireDuration, r101.expireDuration) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.domains;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        Long r107 = this.expireDuration;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "ECMallDomainPreConnectConfig(enable=" + this.enable + ", domains=" + this.domains + ", expireDuration=" + this.expireDuration + ")";
    }

    public final List<String> a() {
        return this.domains;
    }

    public final boolean b() {
        return this.enable;
    }

    public final Long c() {
        return this.expireDuration;
    }

    public a(Object r100) {
        this.enable = false;
        this.domains = null;
        this.expireDuration = null;
    }
}
