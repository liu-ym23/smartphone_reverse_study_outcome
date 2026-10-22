package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionProductCommentTagsStruct;", "Ljava/io/Serializable;", "", "component1", "component2", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component3", "tagType", "tagText", "tagIcon", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTagType", "()Ljava/lang/String;", "getTagText", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTagIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentTagsStruct implements Serializable {
    public static final a Companion = null;
    public static final String MALL_GOLD_CARD = "4";
    public static final String RANK_TAG_TYPE = "2";
    public static final String REPEAT_TAG_TYPE = "1";
    public static final String SHOPPING_FANS_GROUP_TYPE = "3";

    @SerializedName("tag_icon")
    private final ECUrlModel tagIcon;

    @SerializedName("tag_text")
    private final String tagText;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    private final String tagType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionProductCommentTagsStruct() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PromotionProductCommentTagsStruct copy$default(PromotionProductCommentTagsStruct r100, String r101, String r102, ECUrlModel r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tagType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.tagText;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tagIcon;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.tagType;
    }

    public final String component2() {
        return this.tagText;
    }

    public final ECUrlModel component3() {
        return this.tagIcon;
    }

    public final PromotionProductCommentTagsStruct copy(String r100, String r101, ECUrlModel r102) {
        return new PromotionProductCommentTagsStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductCommentTagsStruct) == false) goto L12;
        PromotionProductCommentTagsStruct r101 = (PromotionProductCommentTagsStruct) r100;
        if (Intrinsics.areEqual(this.tagType, r101.tagType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tagText, r101.tagText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tagIcon, r101.tagIcon) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.tagType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.tagText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.tagIcon;
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
        return "PromotionProductCommentTagsStruct(tagType=" + this.tagType + ", tagText=" + this.tagText + ", tagIcon=" + this.tagIcon + ")";
    }

    public final ECUrlModel getTagIcon() {
        return this.tagIcon;
    }

    public final String getTagText() {
        return this.tagText;
    }

    public final String getTagType() {
        return this.tagType;
    }

    public PromotionProductCommentTagsStruct(String r100, String r101, ECUrlModel r102) {
        this.tagType = r100;
        this.tagText = r101;
        this.tagIcon = r102;
    }

    public /* synthetic */ PromotionProductCommentTagsStruct(String r100, String r101, ECUrlModel r102, int r103, DefaultConstructorMarker r104) {
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
