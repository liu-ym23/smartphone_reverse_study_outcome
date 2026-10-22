package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.api.SchemaPackRequest;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/data/SchemaDiffParam;", "Ljava/io/Serializable;", "newSchemaReq", "Lcom/bytedance/android/shopping/anchorv3/repository/api/SchemaPackRequest;", "oldSchemaReq", "Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "(Lcom/bytedance/android/shopping/anchorv3/repository/api/SchemaPackRequest;Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;)V", "getNewSchemaReq", "()Lcom/bytedance/android/shopping/anchorv3/repository/api/SchemaPackRequest;", "getOldSchemaReq", "()Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SchemaDiffParam implements Serializable {

    @SerializedName("new_schema_req")
    private final SchemaPackRequest newSchemaReq;

    @SerializedName("old_schema_req")
    private final AnchorV3PromotionRequestParam oldSchemaReq;

    public static /* synthetic */ SchemaDiffParam copy$default(SchemaDiffParam r100, SchemaPackRequest r101, AnchorV3PromotionRequestParam r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.newSchemaReq;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.oldSchemaReq;
    L9:
        return r100.copy(r101, r102);
    }

    public final SchemaPackRequest component1() {
        return this.newSchemaReq;
    }

    public final AnchorV3PromotionRequestParam component2() {
        return this.oldSchemaReq;
    }

    public final SchemaDiffParam copy(SchemaPackRequest r100, AnchorV3PromotionRequestParam r101) {
        return new SchemaDiffParam(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SchemaDiffParam) == false) goto L10;
        SchemaDiffParam r101 = (SchemaDiffParam) r100;
        if (Intrinsics.areEqual(this.newSchemaReq, r101.newSchemaReq) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.oldSchemaReq, r101.oldSchemaReq) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        SchemaPackRequest r100 = this.newSchemaReq;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV3PromotionRequestParam r104 = this.oldSchemaReq;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SchemaDiffParam(newSchemaReq=" + this.newSchemaReq + ", oldSchemaReq=" + this.oldSchemaReq + ")";
    }

    public final SchemaPackRequest getNewSchemaReq() {
        return this.newSchemaReq;
    }

    public final AnchorV3PromotionRequestParam getOldSchemaReq() {
        return this.oldSchemaReq;
    }

    public SchemaDiffParam(SchemaPackRequest r100, AnchorV3PromotionRequestParam r101) {
        this.newSchemaReq = r100;
        this.oldSchemaReq = r101;
    }
}
