package com.bytedance.android.livesdk.livecommerce.promotion.card;

import androidx.core.provider.FontsContractCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.anchorv3.utils.n;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class IPromotionUIConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f150021a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f150022b = null;

    public static final class a {
        public static k a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonStr");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L22
            LinkedHashMap r102 = new LinkedHashMap();     // Catch: Throwable -> L22
            JSONObject r103 = com.bytedance.android.shopping.anchorv3.a.d(r100);     // Catch: Throwable -> L22
            if (r103 == null) goto L19;
            Iterator<String> r104 = r103.keys();     // Catch: Throwable -> L22
        L7:
            if (r104.hasNext() == false) goto L20;
            String r105 = r104.next();     // Catch: Throwable -> L22
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
            int r107 = n.f165314a;     // Catch: Throwable -> L11
            Object r108 = Result.m9449constructorimpl((d) n.a.f165315a.fromJson(r103.optString(r105), d.class));     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r108) == false) goto L16;
            r108 = null;
        L16:
            d r109 = (d) r108;     // Catch: Throwable -> L22
            if (r109 == null) goto L7;
            PromotionCardModuleName.Companion.getClass();     // Catch: Throwable -> L22
            r102.put(PromotionCardModuleName.a.a(r105), r109);     // Catch: Throwable -> L22
        L11:
            th = move-exception;
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L22
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
        L20:
            Object r111 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L22
        L24:
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L28;
            ye.a.b(r112);
        L28:
            if (Result.m9455isFailureimpl(r111) == false) goto L30;
            r111 = null;
        L30:
            Map r113 = (Map) r111;
            if (r113 != null) goto L33;
            return null;
        L33:
            return new k(r113);
        L19:
            Lazy r114 = IPromotionUIConfig.f150021a;     // Catch: Throwable -> L22
            ye.a.a("UI config of promotion card cannot be parsed.");     // Catch: Throwable -> L22
            Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L24
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001a\u0010\u001f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$b;", "", "", "bgColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "radius", "[F", RXScreenCaptureService.KEY_INDEX, "()[F", "", "fontSize", FaceService.girlLabel, "e", "()F", "", "fontUseSp", "Z", "f", "()Z", "", "fontWeight", "I", ce.f26391f, "()I", "fontColor", "d", "lineSpacingExtra", "h", "drawableScale", "c", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("bg_color")
        private final String bgColor;

        @SerializedName("drawable_scale")
        private final float drawableScale;

        @SerializedName("font_color")
        private final String fontColor;

        @SerializedName("font_size")
        private final float fontSize;

        @SerializedName("font_sp")
        private final boolean fontUseSp;

        @SerializedName(FontsContractCompat.Columns.WEIGHT)
        private final int fontWeight;

        @SerializedName("line_spacing_extra")
        private final float lineSpacingExtra;

        @SerializedName("radius")
        private final float[] radius;

        public b() {
            this(null, null, 0.0f, true, 0, null, 0.0f, 1.0f);
        }

        public final String toString() {
            return "Design(bgColor=" + this.bgColor + ", radius=" + Arrays.toString(this.radius) + ", fontSize=" + this.fontSize + ", fontUseSp=" + this.fontUseSp + ", fontWeight=" + this.fontWeight + ", fontColor=" + this.fontColor + ", lineSpacingExtra=" + this.lineSpacingExtra + ", drawableScale=" + this.drawableScale + ")";
        }

        public final int hashCode() {
            String r100 = this.bgColor;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            float[] r104 = this.radius;
            if (r104 == null) goto L9;
            int r105 = Arrays.hashCode(r104);
        L10:
            int r106 = (((r103 + r105) * 31) + Float.floatToIntBits(this.fontSize)) * 31;
            if (this.fontUseSp == false) goto L13;
            int r107 = 1231;
        L14:
            int r108 = (((r106 + r107) * 31) + this.fontWeight) * 31;
            String r109 = this.fontColor;
            if (r109 == null) goto L18;
            r101 = r109.hashCode();
        L18:
            return ((((r108 + r101) * 31) + Float.floatToIntBits(this.lineSpacingExtra)) * 31) + Float.floatToIntBits(this.drawableScale);
        L13:
            r107 = 1237;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String b() {
            return this.bgColor;
        }

        public final float c() {
            return this.drawableScale;
        }

        public final String d() {
            return this.fontColor;
        }

        public final float e() {
            return this.fontSize;
        }

        public final boolean f() {
            return this.fontUseSp;
        }

        public final int g() {
            return this.fontWeight;
        }

        public final float h() {
            return this.lineSpacingExtra;
        }

        public final float[] i() {
            return this.radius;
        }

        public static b a(b r100) {
            return new b(null, r100.radius, r100.fontSize, r100.fontUseSp, r100.fontWeight, r100.fontColor, r100.lineSpacingExtra, r100.drawableScale);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if ((!Intrinsics.areEqual(b.class, r101)) == false) goto L12;
            return false;
        L12:
            if (r100 == null) goto L45;
            b r102 = (b) r100;
            if ((true ^ Intrinsics.areEqual(this.bgColor, r102.bgColor)) == false) goto L16;
            return false;
        L16:
            float[] r103 = this.radius;
            if (r103 == null) goto L25;
            float[] r104 = r102.radius;
            if (r104 != null) goto L22;
            return false;
        L22:
            if (Arrays.equals(r103, r104) == true) goto L28;
            return false;
        L28:
            if (this.fontSize == r102.fontSize) goto L31;
            return false;
        L31:
            if (this.fontUseSp == r102.fontUseSp) goto L34;
            return false;
        L34:
            if (this.fontWeight == r102.fontWeight) goto L37;
            return false;
        L37:
            if (this.lineSpacingExtra == r102.lineSpacingExtra) goto L40;
            return false;
        L40:
            if (this.drawableScale == r102.drawableScale) goto L43;
            return false;
        L43:
            return Intrinsics.areEqual(this.fontColor, r102.fontColor);
        L25:
            if (r102.radius == null) goto L28;
            return false;
        L45:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig.Design");
        L8:
            r101 = null;
            goto L10
        }

        public b(String r100, float[] r101, float r102, boolean r103, int r104, String r105, float r106, float r107) {
            this.bgColor = r100;
            this.radius = r101;
            this.fontSize = r102;
            this.fontUseSp = r103;
            this.fontWeight = r104;
            this.fontColor = r105;
            this.lineSpacingExtra = r106;
            this.drawableScale = r107;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001c\u0010$\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u001c\u0010(\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001fR\u001c\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u001fR\u001c\u0010,\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001f¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$c;", "", "", "width", "I", "r", "()I", "height", "c", "paddingTop", "Ljava/lang/Integer;", "m", "()Ljava/lang/Integer;", "paddingRight", "l", "paddingBottom", ce.f26395j, "paddingLeft", ce.f26396k, "marginTop", RXScreenCaptureService.KEY_INDEX, "marginRight", "h", "marginBottom", "f", "marginLeft", ce.f26391f, "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardModuleName;", "leftToLeft", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardModuleName;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardModuleName;", "leftToRight", "e", "rightToLeft", OfficeSDKRequestTag.KEY_NEW_USER, "rightToRight", "o", "topToTop", "q", "topToBottom", "p", "bottomToTop", "b", "bottomToBottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("bottom_to_bottom")
        private final PromotionCardModuleName bottomToBottom;

        @SerializedName("bottom_to_top")
        private final PromotionCardModuleName bottomToTop;

        @SerializedName("height")
        private final int height;

        @SerializedName("left_to_left")
        private final PromotionCardModuleName leftToLeft;

        @SerializedName("left_to_right")
        private final PromotionCardModuleName leftToRight;

        @SerializedName("bottom_margin")
        private final Integer marginBottom;

        @SerializedName("left_margin")
        private final Integer marginLeft;

        @SerializedName("right_margin")
        private final Integer marginRight;

        @SerializedName("top_margin")
        private final Integer marginTop;

        @SerializedName("bottom_padding")
        private final Integer paddingBottom;

        @SerializedName("left_padding")
        private final Integer paddingLeft;

        @SerializedName("right_padding")
        private final Integer paddingRight;

        @SerializedName("top_padding")
        private final Integer paddingTop;

        @SerializedName("right_to_left")
        private final PromotionCardModuleName rightToLeft;

        @SerializedName("right_to_right")
        private final PromotionCardModuleName rightToRight;

        @SerializedName("top_to_bottom")
        private final PromotionCardModuleName topToBottom;

        @SerializedName("top_to_top")
        private final PromotionCardModuleName topToTop;

        @SerializedName("width")
        private final int width;

        public c() {
            this(0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        }

        public final String toString() {
            return "Layout(width=" + this.width + ", height=" + this.height + ", paddingTop=" + this.paddingTop + ", paddingRight=" + this.paddingRight + ", paddingBottom=" + this.paddingBottom + ", paddingLeft=" + this.paddingLeft + ", marginTop=" + this.marginTop + ", marginRight=" + this.marginRight + ", marginBottom=" + this.marginBottom + ", marginLeft=" + this.marginLeft + ", leftToLeft=" + this.leftToLeft + ", leftToRight=" + this.leftToRight + ", rightToLeft=" + this.rightToLeft + ", rightToRight=" + this.rightToRight + ", topToTop=" + this.topToTop + ", topToBottom=" + this.topToBottom + ", bottomToTop=" + this.bottomToTop + ", bottomToBottom=" + this.bottomToBottom + ")";
        }

        public final int hashCode() {
            int r100 = ((this.width * 31) + this.height) * 31;
            Integer r101 = this.paddingTop;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.intValue();
        L6:
            int r104 = (r100 + r103) * 31;
            Integer r105 = this.paddingRight;
            if (r105 == null) goto L9;
            int r106 = r105.intValue();
        L10:
            int r107 = (r104 + r106) * 31;
            Integer r108 = this.paddingBottom;
            if (r108 == null) goto L13;
            int r109 = r108.intValue();
        L14:
            int r110 = (r107 + r109) * 31;
            Integer r111 = this.paddingLeft;
            if (r111 == null) goto L17;
            int r112 = r111.intValue();
        L18:
            int r113 = (r110 + r112) * 31;
            Integer r114 = this.marginTop;
            if (r114 == null) goto L21;
            int r115 = r114.intValue();
        L22:
            int r116 = (r113 + r115) * 31;
            Integer r117 = this.marginRight;
            if (r117 == null) goto L25;
            int r118 = r117.intValue();
        L26:
            int r119 = (r116 + r118) * 31;
            Integer r120 = this.marginBottom;
            if (r120 == null) goto L29;
            int r121 = r120.intValue();
        L30:
            int r122 = (r119 + r121) * 31;
            Integer r123 = this.marginLeft;
            if (r123 == null) goto L33;
            int r124 = r123.intValue();
        L34:
            int r125 = (r122 + r124) * 31;
            PromotionCardModuleName r126 = this.leftToLeft;
            if (r126 == null) goto L37;
            int r127 = r126.hashCode();
        L38:
            int r128 = (r125 + r127) * 31;
            PromotionCardModuleName r129 = this.leftToRight;
            if (r129 == null) goto L41;
            int r130 = r129.hashCode();
        L42:
            int r131 = (r128 + r130) * 31;
            PromotionCardModuleName r132 = this.rightToLeft;
            if (r132 == null) goto L45;
            int r133 = r132.hashCode();
        L46:
            int r134 = (r131 + r133) * 31;
            PromotionCardModuleName r135 = this.rightToRight;
            if (r135 == null) goto L49;
            int r136 = r135.hashCode();
        L50:
            int r137 = (r134 + r136) * 31;
            PromotionCardModuleName r138 = this.topToTop;
            if (r138 == null) goto L53;
            int r139 = r138.hashCode();
        L54:
            int r140 = (r137 + r139) * 31;
            PromotionCardModuleName r141 = this.topToBottom;
            if (r141 == null) goto L57;
            int r142 = r141.hashCode();
        L58:
            int r143 = (r140 + r142) * 31;
            PromotionCardModuleName r144 = this.bottomToTop;
            if (r144 == null) goto L61;
            int r145 = r144.hashCode();
        L62:
            int r146 = (r143 + r145) * 31;
            PromotionCardModuleName r147 = this.bottomToBottom;
            if (r147 == null) goto L66;
            r102 = r147.hashCode();
        L66:
            return r146 + r102;
        L61:
            r145 = 0;
            goto L62
        L57:
            r142 = 0;
            goto L58
        L53:
            r139 = 0;
            goto L54
        L49:
            r136 = 0;
            goto L50
        L45:
            r133 = 0;
            goto L46
        L41:
            r130 = 0;
            goto L42
        L37:
            r127 = 0;
            goto L38
        L33:
            r124 = 0;
            goto L34
        L29:
            r121 = 0;
            goto L30
        L25:
            r118 = 0;
            goto L26
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        public final PromotionCardModuleName a() {
            return this.bottomToBottom;
        }

        public final PromotionCardModuleName b() {
            return this.bottomToTop;
        }

        public final int c() {
            return this.height;
        }

        public final PromotionCardModuleName d() {
            return this.leftToLeft;
        }

        public final PromotionCardModuleName e() {
            return this.leftToRight;
        }

        public final Integer f() {
            return this.marginBottom;
        }

        public final Integer g() {
            return this.marginLeft;
        }

        public final Integer h() {
            return this.marginRight;
        }

        public final Integer i() {
            return this.marginTop;
        }

        public final Integer j() {
            return this.paddingBottom;
        }

        public final Integer k() {
            return this.paddingLeft;
        }

        public final Integer l() {
            return this.paddingRight;
        }

        public final Integer m() {
            return this.paddingTop;
        }

        public final PromotionCardModuleName n() {
            return this.rightToLeft;
        }

        public final PromotionCardModuleName o() {
            return this.rightToRight;
        }

        public final PromotionCardModuleName p() {
            return this.topToBottom;
        }

        public final PromotionCardModuleName q() {
            return this.topToTop;
        }

        public final int r() {
            return this.width;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if ((!Intrinsics.areEqual(c.class, r101)) == false) goto L12;
            return false;
        L12:
            if (r100 == null) goto L70;
            c r102 = (c) r100;
            if (this.width == r102.width) goto L17;
            return false;
        L17:
            if (this.height == r102.height) goto L20;
            return false;
        L20:
            if ((!Intrinsics.areEqual(this.paddingTop, r102.paddingTop)) == false) goto L23;
            return false;
        L23:
            if ((!Intrinsics.areEqual(this.paddingRight, r102.paddingRight)) == false) goto L26;
            return false;
        L26:
            if ((!Intrinsics.areEqual(this.paddingBottom, r102.paddingBottom)) == false) goto L29;
            return false;
        L29:
            if ((!Intrinsics.areEqual(this.paddingLeft, r102.paddingLeft)) == false) goto L32;
            return false;
        L32:
            if ((!Intrinsics.areEqual(this.marginTop, r102.marginTop)) == false) goto L35;
            return false;
        L35:
            if ((!Intrinsics.areEqual(this.marginRight, r102.marginRight)) == false) goto L38;
            return false;
        L38:
            if ((!Intrinsics.areEqual(this.marginBottom, r102.marginBottom)) == false) goto L41;
            return false;
        L41:
            if ((!Intrinsics.areEqual(this.marginLeft, r102.marginLeft)) == false) goto L44;
            return false;
        L44:
            if (this.leftToLeft == r102.leftToLeft) goto L47;
            return false;
        L47:
            if (this.leftToRight == r102.leftToRight) goto L50;
            return false;
        L50:
            if (this.rightToLeft == r102.rightToLeft) goto L53;
            return false;
        L53:
            if (this.rightToRight == r102.rightToRight) goto L56;
            return false;
        L56:
            if (this.topToTop == r102.topToTop) goto L59;
            return false;
        L59:
            if (this.topToBottom == r102.topToBottom) goto L62;
            return false;
        L62:
            if (this.bottomToTop == r102.bottomToTop) goto L65;
            return false;
        L65:
            if (this.bottomToBottom == r102.bottomToBottom) goto L71;
            return false;
        L71:
            return true;
        L70:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig.Layout");
        L8:
            r101 = null;
            goto L10
        }

        public final boolean s(Map<PromotionCardModuleName, Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "moduleIdMap");
            PromotionCardModuleName r101 = this.leftToLeft;
            if (r101 != null) goto L5;
        L6:
            PromotionCardModuleName r102 = this.leftToRight;
            if (r102 != null) goto L9;
        L10:
            PromotionCardModuleName r103 = this.rightToLeft;
            if (r103 != null) goto L13;
        L14:
            PromotionCardModuleName r104 = this.rightToRight;
            if (r104 != null) goto L17;
        L18:
            PromotionCardModuleName r105 = this.topToTop;
            if (r105 != null) goto L21;
        L22:
            PromotionCardModuleName r106 = this.topToBottom;
            if (r106 != null) goto L25;
        L26:
            PromotionCardModuleName r107 = this.bottomToTop;
            if (r107 != null) goto L29;
        L30:
            PromotionCardModuleName r108 = this.bottomToBottom;
            if (r108 != null) goto L33;
        L35:
            return false;
        L33:
            if (r100.get(r108) == null) goto L35;
        L34:
            return true;
        L29:
            if (r100.get(r107) != null) goto L34;
        L25:
            if (r100.get(r106) != null) goto L34;
        L21:
            if (r100.get(r105) != null) goto L34;
        L17:
            if (r100.get(r104) != null) goto L34;
        L13:
            if (r100.get(r103) != null) goto L34;
        L9:
            if (r100.get(r102) != null) goto L34;
        L5:
            if (r100.get(r101) != null) goto L34;
            goto L6
        }

        public c(int r100, int r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r110, Integer r111, Integer r112, PromotionCardModuleName r113, PromotionCardModuleName r114, PromotionCardModuleName r115, PromotionCardModuleName r116, PromotionCardModuleName r117, PromotionCardModuleName r118, PromotionCardModuleName r119, PromotionCardModuleName r210) {
            this.width = r100;
            this.height = r101;
            this.paddingTop = r102;
            this.paddingRight = r103;
            this.paddingBottom = r104;
            this.paddingLeft = r105;
            this.marginTop = r106;
            this.marginRight = r110;
            this.marginBottom = r111;
            this.marginLeft = r112;
            this.leftToLeft = r113;
            this.leftToRight = r114;
            this.rightToLeft = r115;
            this.rightToRight = r116;
            this.topToTop = r117;
            this.topToBottom = r118;
            this.bottomToTop = r119;
            this.bottomToBottom = r210;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$d;", "", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$b;", "design", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$b;", "", RemoteMessageConst.Notification.VISIBILITY, "I", "c", "()I", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$c;", "layout", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$c;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$c;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("design")
        private final b design;

        @SerializedName("layout")
        private final c layout;

        @SerializedName(RemoteMessageConst.Notification.VISIBILITY)
        private final int visibility;

        public static final class a {
        }

        static {
        }

        public d() {
            this(null, -1, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L12;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.design, r101.design) == true) goto L8;
            return false;
        L8:
            if (this.visibility == r101.visibility) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.layout, r101.layout) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            b r100 = this.design;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((r102 * 31) + this.visibility) * 31;
            c r104 = this.layout;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Style(design=" + this.design + ", visibility=" + this.visibility + ", layout=" + this.layout + ")";
        }

        public final Boolean d() {
            int r100 = this.visibility;
            if (r100 == 0) goto L9;
            if (r100 == 1) goto L11;
            return null;
        L11:
            return Boolean.FALSE;
        L9:
            return Boolean.TRUE;
        }

        public final b a() {
            return this.design;
        }

        public final c b() {
            return this.layout;
        }

        public final int c() {
            return this.visibility;
        }

        public d(b r100, int r101, c r102) {
            this.design = r100;
            this.visibility = r101;
            this.layout = r102;
        }
    }

    static {
        f150021a = LazyKt.lazy(IPromotionUIConfig$Companion$PROMOTION_CARD$2.INSTANCE);
        f150022b = LazyKt.lazy(IPromotionUIConfig$Companion$PROMOTION_CARD_V2$2.INSTANCE);
    }
}
