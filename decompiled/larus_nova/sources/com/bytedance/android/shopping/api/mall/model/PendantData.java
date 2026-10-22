package com.bytedance.android.shopping.api.mall.model;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/PendantData;", "", "id", "", "priority", "", "schema", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSchema", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/PendantData;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PendantData {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f170571id;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private final String schema;

    public PendantData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PendantData copy$default(PendantData r100, String r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f170571id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.priority;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.schema;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f170571id;
    }

    public final Integer component2() {
        return this.priority;
    }

    public final String component3() {
        return this.schema;
    }

    public final PendantData copy(String r100, Integer r101, String r102) {
        return new PendantData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PendantData) == false) goto L12;
        PendantData r101 = (PendantData) r100;
        if (Intrinsics.areEqual(this.f170571id, r101.f170571id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.f170571id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.priority;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PendantData(id=" + this.f170571id + ", priority=" + this.priority + ", schema=" + this.schema + ")";
    }

    public final String getId() {
        return this.f170571id;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final String getSchema() {
        return this.schema;
    }

    public PendantData(String r100, Integer r101, String r102) {
        this.f170571id = r100;
        this.priority = r101;
        this.schema = r102;
    }

    public /* synthetic */ PendantData(String r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
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
