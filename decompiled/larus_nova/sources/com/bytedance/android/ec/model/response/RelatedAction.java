package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.response.adapter.ECRelatedTypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/RelatedAction;", "Ljava/io/Serializable;", "relatedType", "Lcom/bytedance/android/ec/model/response/RelatedAction$RelatedType;", "bannerRelatedMeta", "Lcom/bytedance/android/ec/model/response/RelatedAction$BannerRelatedMeta;", "(Lcom/bytedance/android/ec/model/response/RelatedAction$RelatedType;Lcom/bytedance/android/ec/model/response/RelatedAction$BannerRelatedMeta;)V", "getBannerRelatedMeta", "()Lcom/bytedance/android/ec/model/response/RelatedAction$BannerRelatedMeta;", "getRelatedType", "()Lcom/bytedance/android/ec/model/response/RelatedAction$RelatedType;", "setRelatedType", "(Lcom/bytedance/android/ec/model/response/RelatedAction$RelatedType;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "BannerRelatedMeta", "RelatedType", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class RelatedAction implements Serializable {

    @SerializedName("banner_related_meta")
    private final BannerRelatedMeta bannerRelatedMeta;

    @SerializedName("related_type")
    private RelatedType relatedType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/RelatedAction$BannerRelatedMeta;", "Ljava/io/Serializable;", "afterShowDuration", "", "cartIconRelatedInfo", "", "(JLjava/lang/String;)V", "getAfterShowDuration", "()J", "getCartIconRelatedInfo", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class BannerRelatedMeta implements Serializable {

        @SerializedName("after_show_duration")
        private final long afterShowDuration;

        @SerializedName("cart_icon_related_info")
        private final String cartIconRelatedInfo;

        public BannerRelatedMeta() {
            this(0, null, 3, null);
        }

        public static /* synthetic */ BannerRelatedMeta copy$default(BannerRelatedMeta r100, long r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.afterShowDuration;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.cartIconRelatedInfo;
        L9:
            return r100.copy(r101, r102);
        }

        public final long component1() {
            return this.afterShowDuration;
        }

        public final String component2() {
            return this.cartIconRelatedInfo;
        }

        public final BannerRelatedMeta copy(long r100, String r101) {
            return new BannerRelatedMeta(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof BannerRelatedMeta) == false) goto L10;
            BannerRelatedMeta r101 = (BannerRelatedMeta) r100;
            if (this.afterShowDuration == r101.afterShowDuration) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.cartIconRelatedInfo, r101.cartIconRelatedInfo) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            long r100 = this.afterShowDuration;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.cartIconRelatedInfo;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L7:
            return r101 + r103;
        L5:
            r103 = 0;
            goto L7
        }

        public String toString() {
            return "BannerRelatedMeta(afterShowDuration=" + this.afterShowDuration + ", cartIconRelatedInfo=" + this.cartIconRelatedInfo + ")";
        }

        public final long getAfterShowDuration() {
            return this.afterShowDuration;
        }

        public final String getCartIconRelatedInfo() {
            return this.cartIconRelatedInfo;
        }

        public BannerRelatedMeta(long r100, String r101) {
            this.afterShowDuration = r100;
            this.cartIconRelatedInfo = r101;
        }

        public /* synthetic */ BannerRelatedMeta(long r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @JsonAdapter(ECRelatedTypeAdapterFactory.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/response/RelatedAction$RelatedType;", "", "Ljava/io/Serializable;", "UNKNOWN", "BANNER", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final enum RelatedType extends Enum<RelatedType> implements Serializable {

        @SerializedName("1")
        public static final RelatedType BANNER = null;

        @SerializedName("0")
        public static final RelatedType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RelatedType[] f47919a = null;

        static {
            RelatedType r100 = new RelatedType("UNKNOWN", 0);
            UNKNOWN = r100;
            RelatedType r101 = new RelatedType("BANNER", 1);
            BANNER = r101;
            f47919a = new RelatedType[]{r100, r101};
        }

        public static RelatedType valueOf(String r100) {
            return (RelatedType) r27.a.a(RelatedType.class, r100);
        }

        public static RelatedType[] values() {
            return (RelatedType[]) f47919a.clone();
        }

        public RelatedType(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RelatedAction() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RelatedAction copy$default(RelatedAction r100, RelatedType r101, BannerRelatedMeta r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.relatedType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.bannerRelatedMeta;
    L9:
        return r100.copy(r101, r102);
    }

    public final RelatedType component1() {
        return this.relatedType;
    }

    public final BannerRelatedMeta component2() {
        return this.bannerRelatedMeta;
    }

    public final RelatedAction copy(RelatedType r100, BannerRelatedMeta r101) {
        Intrinsics.checkNotNullParameter(r100, "relatedType");
        return new RelatedAction(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RelatedAction) == false) goto L10;
        RelatedAction r101 = (RelatedAction) r100;
        if (Intrinsics.areEqual(this.relatedType, r101.relatedType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bannerRelatedMeta, r101.bannerRelatedMeta) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        RelatedType r100 = this.relatedType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BannerRelatedMeta r104 = this.bannerRelatedMeta;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RelatedAction(relatedType=" + this.relatedType + ", bannerRelatedMeta=" + this.bannerRelatedMeta + ")";
    }

    public final BannerRelatedMeta getBannerRelatedMeta() {
        return this.bannerRelatedMeta;
    }

    public final RelatedType getRelatedType() {
        return this.relatedType;
    }

    public final void setRelatedType(RelatedType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.relatedType = r100;
    }

    public RelatedAction(RelatedType r100, BannerRelatedMeta r101) {
        Intrinsics.checkNotNullParameter(r100, "relatedType");
        this.relatedType = r100;
        this.bannerRelatedMeta = r101;
    }

    public /* synthetic */ RelatedAction(RelatedType r100, BannerRelatedMeta r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = RelatedType.UNKNOWN;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
