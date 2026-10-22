package com.alibaba.gaiax.template;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.utils.GXScreenUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import u.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u0001:\u0006\u0015\u0014\u0016\u0017\u0018\u0019B\t\b\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0005\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/alibaba/gaiax/template/GXSize;", "", "", "getName", "()Ljava/lang/String;", "name", "Lu/a;", "getValueDimension", "()Lu/a;", "valueDimension", "", "getValueInt", "()I", "valueInt", "", "getValueFloat", "()F", "valueFloat", "<init>", "()V", "Companion", "Auto", "PE", "PT", "PX", "Undefined", "Lcom/alibaba/gaiax/template/GXSize$Auto;", "Lcom/alibaba/gaiax/template/GXSize$PE;", "Lcom/alibaba/gaiax/template/GXSize$PT;", "Lcom/alibaba/gaiax/template/GXSize$PX;", "Lcom/alibaba/gaiax/template/GXSize$Undefined;", "GaiaX"}, k = 1, mv = {1, 7, 1})
public abstract class GXSize {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/alibaba/gaiax/template/GXSize$Auto;", "Lcom/alibaba/gaiax/template/GXSize;", "()V", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Auto extends GXSize {
        public static final Auto INSTANCE = null;

        static {
            INSTANCE = new Auto();
        }

        private Auto() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\n\u0010\f\u001a\u00020\r*\u00020\u0004J\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0004J\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0004J\f\u0010\u0010\u001a\u00020\u0006*\u00020\u0006H\u0002J\f\u0010\u0011\u001a\u00020\u0006*\u00020\u0006H\u0002J\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0006H\u0002¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/template/GXSize$Companion;", "", "()V", "convertPE", "", "value", "", "convertPT", "convertPx", "create", "Lcom/alibaba/gaiax/template/GXSize;", "targetSize", "dpToIntPx", "", "dpToPx", "ptToPx", "replacePeToEmpty", "replacePtToEmpty", "replacePxToEmpty", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static DisplayMetrics INVOKEVIRTUAL_com_alibaba_gaiax_template_GXSize$Companion_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        private final float convertPE(String r100) {
            return CastFloatProtector.parseFloat(replacePeToEmpty(r100)) / 100.0f;
        }

        private final float convertPT(String r100) {
            return CastFloatProtector.parseFloat(replacePtToEmpty(r100));
        }

        private final float convertPx(String r100) {
            return dpToPx(CastFloatProtector.parseFloat(replacePxToEmpty(r100)));
        }

        private final String replacePeToEmpty(String r100) {
            return r100.substring(0, r100.length() - 1);
        }

        private final String replacePtToEmpty(String r100) {
            return r100.substring(0, r100.length() - 2);
        }

        private final String replacePxToEmpty(String r100) {
            return r100.substring(0, r100.length() - 2);
        }

        public final GXSize create(String r100) {
            Intrinsics.checkNotNullParameter(r100, "targetSize");
            String r101 = StringsKt.trim(r100).toString();
            if (StringsKt.endsWith$default(r101, GXTemplateKey.GAIAX_PX, false, 2, null) == false) goto L6;
            return new PX(r101, convertPx(r101));
        L6:
            if (StringsKt.endsWith$default(r101, GXTemplateKey.GAIAX_PT, false, 2, null) == false) goto L9;
            return new PT(r101, convertPT(r101));
        L9:
            if (StringsKt.endsWith$default(r101, GXTemplateKey.GAIAX_PE, false, 2, null) == false) goto L12;
            return new PE(r101, convertPE(r101));
        L12:
            if (Intrinsics.areEqual(r101, "auto") == false) goto L15;
            return Auto.INSTANCE;
        L15:
            if ((!StringsKt.isBlank(r101)) == false) goto L29;
            Float r102 = StringsKt.toFloatOrNull(r101);
            if (r102 != null) goto L19;
            GXRegisterCenterApi.GXIExtensionSize r103 = GXRegisterCenter.Companion.getInstance().getExtensionSize$GaiaX();
            if (r103 == null) goto L27;
            Float r104 = r103.create(r101);
            if (r104 == null) goto L27;
            return new PX(r101, r104.floatValue());
        L27:
            return Undefined.INSTANCE;
        L19:
            return new PX(r101, GXSize.Companion.dpToPx(r102.floatValue()));
        L29:
            return Undefined.INSTANCE;
        }

        public final int dpToIntPx(float r100) {
            return MathKt.roundToInt(TypedValue.applyDimension(1, r100, INVOKEVIRTUAL_com_alibaba_gaiax_template_GXSize$Companion_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        }

        public final float dpToPx(float r100) {
            return MathKt.roundToInt(TypedValue.applyDimension(1, r100, INVOKEVIRTUAL_com_alibaba_gaiax_template_GXSize$Companion_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        }

        public final float ptToPx(float r100) {
            GXScreenUtils r101 = GXScreenUtils.INSTANCE;
            GXTemplateEngine.Companion r102 = GXTemplateEngine.Companion;
            float r103 = r101.getScreenWidthDP(r102.getInstance().getContext$GaiaX());
            float r104 = r101.getScreenHeightDP(r102.getInstance().getContext$GaiaX());
            float r105 = Math.min(r103, r104) / dpToPx(375.0f);
            GXRegisterCenterApi.GXIExtensionSize r106 = GXRegisterCenter.Companion.getInstance().getExtensionSize$GaiaX();
            if (r106 == null) goto L8;
            Float r107 = r106.convert(r105);
            if (r107 == null) goto L8;
            r105 = r107.floatValue();
        L8:
            return MathKt.roundToInt(dpToPx(r100)) * Math.max(r105, 1.0f);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/alibaba/gaiax/template/GXSize$PE;", "Lcom/alibaba/gaiax/template/GXSize;", "targetName", "", "targetValue", "", "(Ljava/lang/String;F)V", "getTargetName", "()Ljava/lang/String;", "getTargetValue", "()F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PE extends GXSize {
        private final String targetName;
        private final float targetValue;

        public static /* synthetic */ PE copy$default(PE r100, String r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.targetName;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.targetValue;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.targetName;
        }

        public final float component2() {
            return this.targetValue;
        }

        public final PE copy(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "targetName");
            return new PE(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PE) == true) goto L8;
            return false;
        L8:
            PE r101 = (PE) r100;
            if (Intrinsics.areEqual(this.targetName, r101.targetName) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.targetValue, r101.targetValue) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.targetName.hashCode() * 31) + Float.floatToIntBits(this.targetValue);
        }

        public String toString() {
            return "PE(targetName=" + this.targetName + ", targetValue=" + this.targetValue + ')';
        }

        public final String getTargetName() {
            return this.targetName;
        }

        public final float getTargetValue() {
            return this.targetValue;
        }

        public PE(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "targetName");
            super(null);
            this.targetName = r100;
            this.targetValue = r101;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/alibaba/gaiax/template/GXSize$PT;", "Lcom/alibaba/gaiax/template/GXSize;", "targetName", "", "targetValue", "", "(Ljava/lang/String;F)V", "getTargetName", "()Ljava/lang/String;", "getTargetValue", "()F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PT extends GXSize {
        private final String targetName;
        private final float targetValue;

        public static /* synthetic */ PT copy$default(PT r100, String r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.targetName;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.targetValue;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.targetName;
        }

        public final float component2() {
            return this.targetValue;
        }

        public final PT copy(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "targetName");
            return new PT(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PT) == true) goto L8;
            return false;
        L8:
            PT r101 = (PT) r100;
            if (Intrinsics.areEqual(this.targetName, r101.targetName) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.targetValue, r101.targetValue) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.targetName.hashCode() * 31) + Float.floatToIntBits(this.targetValue);
        }

        public String toString() {
            return "PT(targetName=" + this.targetName + ", targetValue=" + this.targetValue + ')';
        }

        public final String getTargetName() {
            return this.targetName;
        }

        public final float getTargetValue() {
            return this.targetValue;
        }

        public PT(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "targetName");
            super(null);
            this.targetName = r100;
            this.targetValue = r101;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/alibaba/gaiax/template/GXSize$PX;", "Lcom/alibaba/gaiax/template/GXSize;", "targetName", "", "targetValue", "", "(Ljava/lang/String;F)V", "getTargetName", "()Ljava/lang/String;", "getTargetValue", "()F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PX extends GXSize {
        private final String targetName;
        private final float targetValue;

        public static /* synthetic */ PX copy$default(PX r100, String r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.targetName;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.targetValue;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.targetName;
        }

        public final float component2() {
            return this.targetValue;
        }

        public final PX copy(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "targetName");
            return new PX(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PX) == true) goto L8;
            return false;
        L8:
            PX r101 = (PX) r100;
            if (Intrinsics.areEqual(this.targetName, r101.targetName) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.targetValue, r101.targetValue) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.targetName.hashCode() * 31) + Float.floatToIntBits(this.targetValue);
        }

        public String toString() {
            return "PX(targetName=" + this.targetName + ", targetValue=" + this.targetValue + ')';
        }

        public final String getTargetName() {
            return this.targetName;
        }

        public final float getTargetValue() {
            return this.targetValue;
        }

        public PX(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "targetName");
            super(null);
            this.targetName = r100;
            this.targetValue = r101;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/alibaba/gaiax/template/GXSize$Undefined;", "Lcom/alibaba/gaiax/template/GXSize;", "()V", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Undefined extends GXSize {
        public static final Undefined INSTANCE = null;

        static {
            INSTANCE = new Undefined();
        }

        private Undefined() {
            super(null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private GXSize() {
    }

    public /* synthetic */ GXSize(DefaultConstructorMarker r100) {
        this();
    }

    public final String getName() {
        if ((this instanceof PX) == false) goto L6;
        return ((PX) this).getTargetName();
    L6:
        if ((this instanceof PE) == false) goto L9;
        return ((PE) this).getTargetName();
    L9:
        if ((this instanceof PT) == false) goto L12;
        return ((PT) this).getTargetName();
    L12:
        if ((this instanceof Auto) == false) goto L15;
        return "Auto";
    L15:
        if ((this instanceof Undefined) == false) goto L19;
        return "Undefined";
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public final a getValueDimension() {
        if ((this instanceof PX) == false) goto L6;
        return new a.c(((PX) this).getTargetValue());
    L6:
        if ((this instanceof PE) == false) goto L9;
        return new a.b(((PE) this).getTargetValue());
    L9:
        if ((this instanceof PT) == false) goto L12;
        return new a.c(Companion.ptToPx(((PT) this).getTargetValue()));
    L12:
        if ((this instanceof Auto) == false) goto L15;
        return a.C7810a.f548078a;
    L15:
        if ((this instanceof Undefined) == false) goto L19;
        return a.d.f548081a;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public final float getValueFloat() {
        if ((this instanceof PX) == false) goto L6;
        return ((PX) this).getTargetValue();
    L6:
        if ((this instanceof PE) == false) goto L9;
        return ((PE) this).getTargetValue();
    L9:
        if ((this instanceof PT) == true) goto L15;
        return 0.0f;
    L15:
        return Companion.ptToPx(((PT) this).getTargetValue());
    }

    public final int getValueInt() {
        if ((this instanceof PX) == false) goto L7;
        float r100 = ((PX) this).getTargetValue();
    L14:
        return (int) r100;
    L7:
        if ((this instanceof PE) == false) goto L10;
        r100 = ((PE) this).getTargetValue();
        goto L14
    L10:
        if ((this instanceof PT) == false) goto L12;
        r100 = Companion.ptToPx(((PT) this).getTargetValue());
        goto L14
    L12:
        return 0;
    }
}
