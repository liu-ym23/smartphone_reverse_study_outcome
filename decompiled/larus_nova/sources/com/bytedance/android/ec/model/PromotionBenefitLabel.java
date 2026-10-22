package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 N2\u00020\u0001:\u0001\u0019B\u009d\u0001\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010$\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010$\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00108\u001a\u000207\u0012\b\b\u0002\u0010>\u001a\u000207\u0012\b\b\u0002\u0010@\u001a\u000207\u0012\u0016\b\u0003\u0010C\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u00010B\u0012\n\b\u0003\u0010H\u001a\u0004\u0018\u00010G¢\u0006\u0004\bL\u0010MJ\u0006\u0010\u0002\u001a\u00020\u0000R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b1\u0010/R\u001c\u00103\u001a\u0004\u0018\u0001028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u0002078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010;R\u001a\u0010@\u001a\u0002078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u00109\u001a\u0004\bA\u0010;R(\u0010C\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u00010B8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010H\u001a\u0004\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "Ljava/io/Serializable;", "createClone", "Lcom/bytedance/android/ec/model/TextPattern;", "textPattern", "Lcom/bytedance/android/ec/model/TextPattern;", "getTextPattern", "()Lcom/bytedance/android/ec/model/TextPattern;", "setTextPattern", "(Lcom/bytedance/android/ec/model/TextPattern;)V", "Lcom/bytedance/android/ec/model/ColorPattern;", "colorPattern", "Lcom/bytedance/android/ec/model/ColorPattern;", "getColorPattern", "()Lcom/bytedance/android/ec/model/ColorPattern;", "setColorPattern", "(Lcom/bytedance/android/ec/model/ColorPattern;)V", "Lcom/bytedance/android/ec/model/DivLinePattern;", "divLinePattern", "Lcom/bytedance/android/ec/model/DivLinePattern;", "getDivLinePattern", "()Lcom/bytedance/android/ec/model/DivLinePattern;", "setDivLinePattern", "(Lcom/bytedance/android/ec/model/DivLinePattern;)V", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "isUsable", "()Z", "setUsable", "(Z)V", "Lcom/bytedance/android/ec/model/response/b;", "left", "Lcom/bytedance/android/ec/model/response/b;", "getLeft", "()Lcom/bytedance/android/ec/model/response/b;", "", "leftV2", "Ljava/util/List;", "getLeftV2", "()Ljava/util/List;", "right", "getRight", "", "leftText", "Ljava/lang/String;", "getLeftText", "()Ljava/lang/String;", "rightText", "getRightText", "Lcom/bytedance/android/ec/model/ECUrlModel;", "rightIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getRightIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "textStyle", "I", "getTextStyle", "()I", "setTextStyle", "(I)V", "colorStyle", "getColorStyle", "divLineStyle", "getDivLineStyle", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/RitTagTrack;", "tagTrack", "Lcom/bytedance/android/ec/model/RitTagTrack;", "getTagTrack", "()Lcom/bytedance/android/ec/model/RitTagTrack;", "<init>", "(Lcom/bytedance/android/ec/model/response/b;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;IIILjava/util/Map;Lcom/bytedance/android/ec/model/RitTagTrack;)V", "Companion", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionBenefitLabel implements Serializable {
    public static final a Companion = null;
    public static final String KEY_PASS_THROUGH = "pass_through";
    public static final String KEY_STICKINESS = "stickiness";
    public static final String VALUE_NOT_STICKINESS = "0";
    public static final String VALUE_SHOULD_PASS_THROUGH = "1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f47853a;
    private ColorPattern colorPattern;

    @SerializedName("color_style")
    private final int colorStyle;
    private DivLinePattern divLinePattern;

    @SerializedName("div_line")
    private final int divLineStyle;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("left")
    private final com.bytedance.android.ec.model.response.b left;

    @SerializedName("left_text")
    private final String leftText;

    @SerializedName("left_v2")
    private final List<com.bytedance.android.ec.model.response.b> leftV2;

    @SerializedName("right")
    private final List<com.bytedance.android.ec.model.response.b> right;

    @SerializedName("right_icon")
    private final ECUrlModel rightIcon;

    @SerializedName("right_text")
    private final String rightText;

    @SerializedName("tag_track")
    private final RitTagTrack tagTrack;
    private TextPattern textPattern;

    @SerializedName("text_style")
    private int textStyle;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionBenefitLabel() {
        this(null, null, null, null, null, null, 0, 0, 0, null, null, 2047, null);
    }

    public final PromotionBenefitLabel createClone() {
        return new PromotionBenefitLabel(this.left, this.leftV2, this.right, this.leftText, this.rightText, this.rightIcon, this.textStyle, this.colorStyle, this.divLineStyle, this.extra, this.tagTrack);
    }

    public final ColorPattern getColorPattern() {
        return this.colorPattern;
    }

    public final int getColorStyle() {
        return this.colorStyle;
    }

    public final DivLinePattern getDivLinePattern() {
        return this.divLinePattern;
    }

    public final int getDivLineStyle() {
        return this.divLineStyle;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final com.bytedance.android.ec.model.response.b getLeft() {
        return this.left;
    }

    public final String getLeftText() {
        return this.leftText;
    }

    public final List<com.bytedance.android.ec.model.response.b> getLeftV2() {
        return this.leftV2;
    }

    public final List<com.bytedance.android.ec.model.response.b> getRight() {
        return this.right;
    }

    public final ECUrlModel getRightIcon() {
        return this.rightIcon;
    }

    public final String getRightText() {
        return this.rightText;
    }

    public final RitTagTrack getTagTrack() {
        return this.tagTrack;
    }

    public final TextPattern getTextPattern() {
        return this.textPattern;
    }

    public final int getTextStyle() {
        return this.textStyle;
    }

    public final boolean isUsable() {
        return this.f47853a;
    }

    public final void setColorPattern(ColorPattern r100) {
        this.colorPattern = r100;
    }

    public final void setDivLinePattern(DivLinePattern r100) {
        this.divLinePattern = r100;
    }

    public final void setTextPattern(TextPattern r100) {
        this.textPattern = r100;
    }

    public final void setTextStyle(int r100) {
        this.textStyle = r100;
    }

    public final void setUsable(boolean r100) {
        this.f47853a = r100;
    }

    public PromotionBenefitLabel(com.bytedance.android.ec.model.response.b r100, List<com.bytedance.android.ec.model.response.b> r101, List<com.bytedance.android.ec.model.response.b> r102, String r103, String r104, ECUrlModel r105, int r106, int r107, int r108, Map<String, String> r110, RitTagTrack r111) {
        this.left = r100;
        this.leftV2 = r101;
        this.right = r102;
        this.leftText = r103;
        this.rightText = r104;
        this.rightIcon = r105;
        this.textStyle = r106;
        this.colorStyle = r107;
        this.divLineStyle = r108;
        this.extra = r110;
        this.tagTrack = r111;
        this.f47853a = true;
    }

    public /* synthetic */ PromotionBenefitLabel(com.bytedance.android.ec.model.response.b r110, List r111, List r112, String r113, String r114, ECUrlModel r115, int r116, int r210, int r211, Map r212, RitTagTrack r213, int r214, DefaultConstructorMarker r215) {
        RitTagTrack r100 = null;
        if ((r214 & 1) == 0) goto L5;
        com.bytedance.android.ec.model.response.b r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r103 = null;
    L14:
        String r104 = "";
        if ((r214 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r214 & 16) != 0) goto L23;
        r104 = r114;
    L23:
        if ((r214 & 32) == 0) goto L25;
        ECUrlModel r106 = null;
    L26:
        int r107 = 0;
        if ((r214 & 64) == 0) goto L29;
        int r108 = 0;
    L31:
        if ((r214 & 128) == 0) goto L33;
        int r117 = 0;
    L35:
        if ((r214 & 256) != 0) goto L39;
        r107 = r211;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Map r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r105, r104, r106, r108, r117, r107, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L33:
        r117 = r210;
        goto L35
    L29:
        r108 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L26
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
