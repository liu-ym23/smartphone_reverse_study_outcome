package com.bytedance.android.shopping.anchorv4.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/data/SchemaDiffResult;", "Ljava/io/Serializable;", "newPackReq", "", "oldPackReq", "onLineV2PackReq", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNewPackReq", "()Ljava/lang/String;", "getOldPackReq", "getOnLineV2PackReq", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SchemaDiffResult implements Serializable {

    @SerializedName("new_pack_req")
    private final String newPackReq;

    @SerializedName("old_pack_req")
    private final String oldPackReq;

    @SerializedName("online_v2_pack_req")
    private final String onLineV2PackReq;

    public static /* synthetic */ SchemaDiffResult copy$default(SchemaDiffResult r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.newPackReq;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.oldPackReq;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.onLineV2PackReq;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.newPackReq;
    }

    public final String component2() {
        return this.oldPackReq;
    }

    public final String component3() {
        return this.onLineV2PackReq;
    }

    public final SchemaDiffResult copy(String r100, String r101, String r102) {
        return new SchemaDiffResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SchemaDiffResult) == false) goto L12;
        SchemaDiffResult r101 = (SchemaDiffResult) r100;
        if (Intrinsics.areEqual(this.newPackReq, r101.newPackReq) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.oldPackReq, r101.oldPackReq) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.onLineV2PackReq, r101.onLineV2PackReq) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.newPackReq;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.oldPackReq;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.onLineV2PackReq;
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
        return "SchemaDiffResult(newPackReq=" + this.newPackReq + ", oldPackReq=" + this.oldPackReq + ", onLineV2PackReq=" + this.onLineV2PackReq + ")";
    }

    public final String getNewPackReq() {
        return this.newPackReq;
    }

    public final String getOldPackReq() {
        return this.oldPackReq;
    }

    public final String getOnLineV2PackReq() {
        return this.onLineV2PackReq;
    }

    public SchemaDiffResult(String r100, String r101, String r102) {
        this.newPackReq = r100;
        this.oldPackReq = r101;
        this.onLineV2PackReq = r102;
    }
}
