package com.bytedance.android.ec.store.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/k;", "", "", "id", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "num", "Ljava/lang/Long;", "getNum", "()Ljava/lang/Long;", "", "isCurrent", "Z", "c", "()Z", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f48391id;

    @SerializedName("is_current")
    private final boolean isCurrent;

    @SerializedName("name")
    private final String name;

    @SerializedName("num")
    private final Long num;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L14;
        k r101 = (k) r100;
        if (this.f48391id == r101.f48391id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.num, r101.num) == true) goto L12;
        return false;
    L12:
        if (this.isCurrent == r101.isCurrent) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        long r100 = this.f48391id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.name;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        Long r106 = this.num;
        if (r106 == null) goto L9;
        r103 = r106.hashCode();
    L9:
        int r107 = (r105 + r103) * 31;
        boolean r108 = this.isCurrent;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        return r107 + r109;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreV2GoodTypeDTO(id=" + this.f48391id + ", name=" + this.name + ", num=" + this.num + ", isCurrent=" + this.isCurrent + ")";
    }

    public k() {
        Intrinsics.checkNotNullParameter("", "name");
        this.f48391id = 0;
        this.name = "";
        this.num = null;
        this.isCurrent = false;
    }

    public final long a() {
        return this.f48391id;
    }

    public final String b() {
        return this.name;
    }

    public final boolean c() {
        return this.isCurrent;
    }
}
