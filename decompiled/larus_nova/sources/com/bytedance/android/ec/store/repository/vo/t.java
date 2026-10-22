package com.bytedance.android.ec.store.repository.vo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/t;", "Lcom/ss/android/ugc/aweme/kiwi/model/QModel;", "", "activityId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "promotionTag", "c", "setPromotionTag", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f48499a;

    @SerializedName("full_discount_activity_id")
    private String activityId;

    @SerializedName("promotion_tag")
    private String promotionTag;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L12;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.activityId, r101.activityId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionTag, r101.promotionTag) == true) goto L10;
        return false;
    L10:
        if (this.f48499a == r101.f48499a) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.activityId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.promotionTag;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f48499a;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 101;
    }

    public final String toString() {
        return "TagDataVO(activityId=" + this.activityId + ", promotionTag=" + this.promotionTag + ", isSelected=" + this.f48499a + ")";
    }

    public t() {
        this.activityId = null;
        this.promotionTag = null;
        this.f48499a = false;
    }

    public final String b() {
        return this.activityId;
    }

    public final String c() {
        return this.promotionTag;
    }
}
