package com.bytedance.android.ec.live.api.commerce.userinfo;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\b\u0005\b\u0011\f\u0019\u001a\u001b\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea;", "", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$a;", "avatar", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$a;", "avatarBorder", "b", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$g;", InstantPlayContext.NICKNAME, "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$g;", "d", "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$g;", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$b;", "introduction", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$b;", "c", "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$b;", "", "", "eventParams", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "e", "IntroductionDataType", "f", ce.f26391f, "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECAuthorArea {

    @SerializedName("avatar")
    private final a avatar;

    @SerializedName("avatar_border")
    private final a avatarBorder;

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("introduction")
    private final b introduction;

    @SerializedName(InstantPlayContext.NICKNAME)
    private final g nickname;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$IntroductionDataType;", "", "UNKNOWN", "IMAGE", CardAdapter.TEXT, "SPLIT", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum IntroductionDataType extends Enum<IntroductionDataType> {

        @SerializedName("1")
        public static final IntroductionDataType IMAGE = null;

        @SerializedName("3")
        public static final IntroductionDataType SPLIT = null;

        @SerializedName("2")
        public static final IntroductionDataType TEXT = null;

        @SerializedName("-1")
        public static final IntroductionDataType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IntroductionDataType[] f47841a = null;

        static {
            IntroductionDataType r100 = new IntroductionDataType("UNKNOWN", 0);
            UNKNOWN = r100;
            IntroductionDataType r101 = new IntroductionDataType("IMAGE", 1);
            IMAGE = r101;
            IntroductionDataType r102 = new IntroductionDataType(CardAdapter.TEXT, 2);
            TEXT = r102;
            IntroductionDataType r103 = new IntroductionDataType("SPLIT", 3);
            SPLIT = r103;
            f47841a = new IntroductionDataType[]{r100, r101, r102, r103};
        }

        public static IntroductionDataType valueOf(String r100) {
            return (IntroductionDataType) r27.a.a(IntroductionDataType.class, r100);
        }

        public static IntroductionDataType[] values() {
            return (IntroductionDataType[]) f47841a.clone();
        }

        public IntroductionDataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$a;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("image")
        private final ECUrlModel image;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.image, ((a) r100).image) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ECUrlModel r100 = this.image;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Avatar(image=" + this.image + ")";
        }

        public a() {
            this.image = null;
        }

        public final ECUrlModel a() {
            return this.image;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$b;", "", "", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$e;", "items", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("items")
        private final List<e> items;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.items, ((b) r100).items) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<e> r100 = this.items;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Introduction(items=" + this.items + ")";
        }

        public b() {
            this.items = null;
        }

        public final List<e> a() {
            return this.items;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$c;", "", "", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$d;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "", "carouselTime", "J", "getCarouselTime", "()J", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("carousel_time")
        private final long carouselTime;

        @SerializedName("items")
        private final List<d> items;

        public final List<d> a() {
            return this.items;
        }

        public final long b() {
            return this.carouselTime;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.items, r101.items) == true) goto L8;
            return false;
        L8:
            if (this.carouselTime == r101.carouselTime) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<d> r100 = this.items;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.carouselTime;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "IntroductionContent(items=" + this.items + ", carouselTime=" + this.carouselTime + ")";
        }

        public c() {
            this.items = null;
            this.carouselTime = -1;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$d;", "", "", "text", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "textColor", "b", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("text")
        private final String text;

        @SerializedName("text_color")
        private final String textColor;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L10;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.text;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.textColor;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "IntroductionContentItem(text=" + this.text + ", textColor=" + this.textColor + ")";
        }

        public d() {
            this.text = null;
            this.textColor = null;
        }

        public final String a() {
            return this.text;
        }

        public final String b() {
            return this.textColor;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$e;", "", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$IntroductionDataType;", "type", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$IntroductionDataType;", "getType", "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$IntroductionDataType;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$c;", "content", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$c;", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$f;", "split", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$f;", "c", "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$f;", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("content")
        private final c content;

        @SerializedName("image")
        private final ECUrlModel image;

        @SerializedName("split")
        private final f split;

        @SerializedName("type")
        private final IntroductionDataType type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L14;
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.image, r101.image) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.split, r101.split) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            IntroductionDataType r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ECUrlModel r104 = this.image;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            c r107 = this.content;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            f r110 = this.split;
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
            return "IntroductionData(type=" + this.type + ", image=" + this.image + ", content=" + this.content + ", split=" + this.split + ")";
        }

        public e() {
            this.type = IntroductionDataType.UNKNOWN;
            this.image = null;
            this.content = null;
            this.split = null;
        }

        public final c a() {
            return this.content;
        }

        public final ECUrlModel b() {
            return this.image;
        }

        public final f c() {
            return this.split;
        }

        public final IntroductionDataType getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$f;", "", "", "color", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class f {

        @SerializedName("color")
        private final String color;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.color, ((f) r100).color) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.color;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "IntroductionSplit(color=" + this.color + ")";
        }

        public f() {
            this.color = null;
        }

        public final String a() {
            return this.color;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$g;", "", "", "text", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "textColor", "Ljava/util/List;", "b", "()Ljava/util/List;", "ecom-live-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class g {

        @SerializedName("text")
        private final String text;

        @SerializedName("text_color")
        private final List<String> textColor;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof g) == false) goto L10;
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.text;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.textColor;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "NickName(text=" + this.text + ", textColor=" + this.textColor + ")";
        }

        public g() {
            this.text = null;
            this.textColor = null;
        }

        public final String a() {
            return this.text;
        }

        public final List<String> b() {
            return this.textColor;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAuthorArea) == false) goto L16;
        ECAuthorArea r101 = (ECAuthorArea) r100;
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatarBorder, r101.avatarBorder) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.nickname, r101.nickname) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.introduction, r101.introduction) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        a r100 = this.avatar;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.avatarBorder;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.nickname;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.introduction;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.eventParams;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "ECAuthorArea(avatar=" + this.avatar + ", avatarBorder=" + this.avatarBorder + ", nickname=" + this.nickname + ", introduction=" + this.introduction + ", eventParams=" + this.eventParams + ")";
    }

    public ECAuthorArea() {
        this.avatar = null;
        this.avatarBorder = null;
        this.nickname = null;
        this.introduction = null;
        this.eventParams = null;
    }

    public final a a() {
        return this.avatar;
    }

    public final a b() {
        return this.avatarBorder;
    }

    public final b c() {
        return this.introduction;
    }

    public final g d() {
        return this.nickname;
    }
}
