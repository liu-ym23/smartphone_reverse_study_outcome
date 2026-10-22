package com.bytedance.android.window.shop.eventcard.windowability;

import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowAnchorAbility {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f187808e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f187809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f187810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnchorPosition f187811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f> f187812d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$AnchorPosition;", "", "BEFORE", "AFTER", "ABOVE", "BELOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnchorPosition extends Enum<AnchorPosition> {

        @SerializedName("above")
        public static final AnchorPosition ABOVE = null;

        @SerializedName("after")
        public static final AnchorPosition AFTER = null;

        @SerializedName("before")
        public static final AnchorPosition BEFORE = null;

        @SerializedName("below")
        public static final AnchorPosition BELOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorPosition[] f187813a = null;

        static {
            AnchorPosition r100 = new AnchorPosition("BEFORE", 0);
            BEFORE = r100;
            AnchorPosition r101 = new AnchorPosition("AFTER", 1);
            AFTER = r101;
            AnchorPosition r102 = new AnchorPosition("ABOVE", 2);
            ABOVE = r102;
            AnchorPosition r103 = new AnchorPosition("BELOW", 3);
            BELOW = r103;
            f187813a = new AnchorPosition[]{r100, r101, r102, r103};
        }

        public static AnchorPosition valueOf(String r100) {
            return (AnchorPosition) r27.a.a(AnchorPosition.class, r100);
        }

        public static AnchorPosition[] values() {
            return (AnchorPosition[]) f187813a.clone();
        }

        public AnchorPosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$a;", "", "", "anchorTarget", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "anchorIndex", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$AnchorPosition;", "anchorPosition", "Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$AnchorPosition;", "b", "()Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$AnchorPosition;", "Lcom/google/gson/JsonArray;", "cards", "Lcom/google/gson/JsonArray;", "d", "()Lcom/google/gson/JsonArray;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("anchor_index")
        private final Integer anchorIndex;

        @SerializedName("anchor_position")
        private final AnchorPosition anchorPosition;

        @SerializedName("anchor_target")
        private final String anchorTarget;

        @SerializedName("mix_full_items")
        private final JsonArray cards;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.anchorTarget, r101.anchorTarget) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.anchorIndex, r101.anchorIndex) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.anchorPosition, r101.anchorPosition) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.cards, r101.cards) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.anchorTarget;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.anchorIndex;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            AnchorPosition r107 = this.anchorPosition;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            JsonArray r110 = this.cards;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "AbilityDTO(anchorTarget=" + this.anchorTarget + ", anchorIndex=" + this.anchorIndex + ", anchorPosition=" + this.anchorPosition + ", cards=" + this.cards + ")";
        }

        public final Integer a() {
            return this.anchorIndex;
        }

        public final AnchorPosition b() {
            return this.anchorPosition;
        }

        public final String c() {
            return this.anchorTarget;
        }

        public final JsonArray d() {
            return this.cards;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        f187808e = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowAnchorAbility(String r100, int r101, AnchorPosition r102, List<? extends f> r103) {
        Intrinsics.checkNotNullParameter(r100, "anchorTarget");
        Intrinsics.checkNotNullParameter(r102, "anchorPosition");
        Intrinsics.checkNotNullParameter(r103, "cardList");
        this.f187809a = r100;
        this.f187810b = r101;
        this.f187811c = r102;
        this.f187812d = r103;
    }
}
