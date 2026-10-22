package com.alibaba.gaiax.adapter;

import androidx.camera.core.processing.util.GLUtils;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alibaba.gaiax.utils.GXExtJsonKt;
import com.alibaba.gaiax.utils.JsonExt;
import com.alipay.sdk.m.u.i;
import com.bytedance.lark.pb.space.drive.v1.CoverDownloadInfo;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0014\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001cB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016\u0082\u0001\u0013\u001d\u001e\u001f !\"#$%&'()*+,-./¨\u00060"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "Lcom/alibaba/gaiax/template/GXIExpression;", "()V", "desireData", "", "rawJson", "expression", "value", "templateData", "Companion", "GBool", "GEnv", "GEval", "GFloat", "GInt", "GJsonArrayObj", "GJsonObj", "GNull", "GScroll", "GSize", "GString", "GTernaryValue1", "GTernaryValue2", "GTernaryValue3", "GText", "GTextValue", "GValue", "Self", "Undefined", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GBool;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GEnv;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GEval;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GFloat;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GInt;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GJsonArrayObj;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GJsonObj;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GNull;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GScroll;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GSize;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GString;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue1;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue2;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue3;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GText;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTextValue;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GValue;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$Self;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$Undefined;", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class GaiaXExpression implements GXIExpression {
    public static final Companion Companion = null;
    private static final Pattern valueFullRegex = null;
    private static final Pattern valueRegex = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0013R\u001f\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$Companion;", "", "()V", "valueFullRegex", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getValueFullRegex$annotations", "getValueFullRegex", "()Ljava/util/regex/Pattern;", "valueRegex", "getValueRegex$annotations", "getValueRegex", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "expression", "isCondition", "", "condition", "isFitContentCondition", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getValueFullRegex$annotations() {
        }

        public static /* synthetic */ void getValueRegex$annotations() {
        }

        public final Pattern getValueFullRegex() {
            return GaiaXExpression.access$getValueFullRegex$cp();
        }

        public final Pattern getValueRegex() {
            return GaiaXExpression.access$getValueRegex$cp();
        }

        public final GaiaXExpression create(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "expression");
            if ((r100 instanceof JSONObject) == false) goto L9;
            GJsonObj.Companion r101 = GJsonObj.Companion;
            if (r101.isExpression(r100) == false) goto L81;
            return r101.create((JSONObject) r100);
        L81:
            return Undefined.INSTANCE;
        L9:
            if ((r100 instanceof JSONArray) == false) goto L15;
            GJsonArrayObj.Companion r102 = GJsonArrayObj.Companion;
            if (r102.isExpression(r100) == false) goto L83;
            return r102.create((JSONArray) r100);
        L83:
            return Undefined.INSTANCE;
        L15:
            if ((r100 instanceof String) == false) goto L69;
            String r103 = StringsKt.trim((String) r100).toString();
            Self r104 = Self.INSTANCE;
            if (r104.isExpression(r103) == true) goto L84;
            GNull.Companion r105 = GNull.Companion;
            if (r105.isExpression(r103) == true) goto L85;
            GBool.Companion r106 = GBool.Companion;
            if (r106.isExpression(r103) == true) goto L86;
            GInt.Companion r107 = GInt.Companion;
            if (r107.isExpression(r103) == true) goto L87;
            GFloat.Companion r108 = GFloat.Companion;
            if (r108.isExpression(r103) == true) goto L88;
            GString.Companion r109 = GString.Companion;
            if (r109.isExpression(r103) == true) goto L89;
            GEval.Companion r110 = GEval.Companion;
            if (r110.isExpression(r103) == true) goto L90;
            GEnv.Companion r111 = GEnv.Companion;
            if (r111.isExpression(r103) == true) goto L91;
            GScroll.Companion r112 = GScroll.Companion;
            if (r112.isExpression(r103) == true) goto L92;
            GSize.Companion r113 = GSize.Companion;
            if (r113.isExpression(r103) == true) goto L93;
            GTextValue.Companion r114 = GTextValue.Companion;
            if (r114.isExpression(r103) == true) goto L94;
            GValue.Companion r115 = GValue.Companion;
            if (r115.isExpression(r103) == true) goto L95;
            GTernaryValue3.Companion r116 = GTernaryValue3.Companion;
            if (r116.isExpression(r103) == true) goto L96;
            GTernaryValue1.Companion r117 = GTernaryValue1.Companion;
            if (r117.isExpression(r103) == true) goto L97;
            GTernaryValue2.Companion r118 = GTernaryValue2.Companion;
            if (r118.isExpression(r103) == true) goto L98;
            GText.Companion r119 = GText.Companion;
            if (r119.isExpression(r103) == false) goto L65;
            return r119.create(r103);
        L65:
            if (Intrinsics.areEqual(r100, "\n") == false) goto L101;
            return r119.create("\n");
        L101:
            return Undefined.INSTANCE;
        L98:
            return r118.create(r103);
        L97:
            return r117.create(r103);
        L96:
            return r116.create(r103);
        L95:
            return r115.create(r103);
        L94:
            return r114.create(r103);
        L93:
            return r113.create(r103);
        L92:
            return r112.create(r103);
        L91:
            return r111.create(r103);
        L90:
            return r110.create(r103);
        L89:
            return r109.create(r103);
        L88:
            return r108.create(r103);
        L87:
            return r107.create(r103);
        L86:
            return r106.create(r103);
        L85:
            return r105.create();
        L84:
            return r104;
        L69:
            if ((r100 instanceof Boolean) == false) goto L73;
            GaiaXExpression r120 = new GBool(((Boolean) r100).booleanValue());
        L102:
            return r120;
        L73:
            if ((r100 instanceof Integer) == false) goto L76;
            r120 = new GInt(((Number) r100).intValue());
            goto L102
        L76:
            if ((r100 instanceof Float) == false) goto L79;
            r120 = new GFloat(((Number) r100).floatValue());
            goto L102
        L79:
            return Undefined.INSTANCE;
        }

        public final boolean isCondition(Object r100) {
            if ((r100 instanceof Boolean) == false) goto L8;
            if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L8;
            return true;
        L8:
            if ((r100 instanceof Number) == false) goto L16;
            if (((Number) r100).floatValue() != 0.0f) goto L12;
            boolean r101 = true;
        L13:
            if (r101 == true) goto L16;
            return true;
        L12:
            r101 = false;
        L16:
            if (Intrinsics.areEqual(r100, "0") == false) goto L18;
        L41:
            return false;
        L18:
            if (Intrinsics.areEqual(r100, "false") == true) goto L41;
            if (Intrinsics.areEqual(r100, Boolean.FALSE) == true) goto L41;
            if (Intrinsics.areEqual(r100, 0) == true) goto L41;
            if (Intrinsics.areEqual(r100, Float.valueOf(0.0f)) == true) goto L41;
            if (Intrinsics.areEqual(r100, "1") == false) goto L29;
            return true;
        L29:
            if (Intrinsics.areEqual(r100, "true") == true) goto L44;
            boolean r102 = r100 instanceof String;
            if (r102 == true) goto L33;
        L35:
            if (r102 == true) goto L37;
        L39:
            if (r100 == null) goto L41;
            return true;
        L37:
            if (StringsKt.isBlank((CharSequence) r100) == false) goto L39;
            return false;
        L33:
            if ((!StringsKt.isBlank((CharSequence) r100)) == false) goto L35;
            return true;
        L44:
            return true;
        }

        public final boolean isFitContentCondition(String r100) {
            Intrinsics.checkNotNullParameter(r100, "condition");
            switch(r100.hashCode()) {
                case 48: goto L18;
                case 49: goto L15;
                case 47602: goto L13;
                case 48563: goto L11;
                case 3569038: goto L8;
                case 97196323: goto L5;
                default: goto L21;
            };
        L5:
            String r101 = "false";
        L6:
            r100.equals(r101);
            return false;
        L13:
            r101 = GLUtils.VERSION_UNKNOWN;
            goto L6
        L18:
            r101 = "0";
            goto L6
        L21:
            return false;
        L8:
            if (r100.equals("true") == false) goto L22;
        L17:
            return true;
        L22:
            return false;
        L11:
            if (r100.equals("1.0") == true) goto L17;
            return false;
        L15:
            if (r100.equals("1") == true) goto L17;
            return false;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GBool;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "", "(Z)V", "getValue", "()Z", "component1", "copy", "desireData", "", "rawJson", "equals", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GBool extends GaiaXExpression {
        public static final Companion Companion = null;
        private final boolean value;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GBool$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GBool;", "value", "", "isExpression", "", "expression", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GBool create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                return new GBool(Boolean.parseBoolean(r100));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                if (Intrinsics.areEqual(r100, "true") == false) goto L5;
            L8:
                return true;
            L5:
                if (Intrinsics.areEqual(r100, "false") == true) goto L8;
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GBool copy$default(GBool r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.value;
        }

        public final GBool copy(boolean r100) {
            return new GBool(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GBool) == true) goto L9;
            return false;
        L9:
            if (this.value == ((GBool) r100).value) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            boolean r100 = this.value;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public String toString() {
            return "GBool(value=" + this.value + ')';
        }

        public final boolean getValue() {
            return this.value;
        }

        public GBool(boolean r100) {
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GEnv;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GEnv extends GaiaXExpression {
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GEnv$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GEnv;", "value", "", "isExpression", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GEnv create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                return new GEnv(r100.substring(4, r100.length() - 1));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                if (StringsKt.startsWith$default(r100, "env(", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.endsWith$default(r100, ")", false, 2, null) == false) goto L9;
                return true;
            L9:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GEnv copy$default(GEnv r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.value;
        }

        public final GEnv copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GEnv(r100);
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return null;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GEnv) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((GEnv) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "GEnv(value='" + this.value + "')";
        }

        public final String getValue() {
            return this.value;
        }

        public GEnv(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0001HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001HÆ\u0001J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010 \u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010!\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010#\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006%"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GEval;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "operate", "", "leftValue", "rightValue", "(Ljava/lang/String;Lcom/alibaba/gaiax/adapter/GaiaXExpression;Lcom/alibaba/gaiax/adapter/GaiaXExpression;)V", "getLeftValue", "()Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "getOperate", "()Ljava/lang/String;", "getRightValue", "component1", "component2", "component3", "copy", "desireData", "", "rawJson", "doubleAnd", "left", "right", "doubleOr", CoverDownloadInfo.DEFAULT_POLICY, "equals", "", "other", "greaterThan", "greaterThanOrEqual", "hashCode", "", "lessThan", "lessThanOrEqual", "mod", "notEqual", "toString", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GEval extends GaiaXExpression {
        public static final Companion Companion = null;
        private final GaiaXExpression leftValue;
        private final String operate;
        private final GaiaXExpression rightValue;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GEval$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GEval;", "value", "", "createEval", "operate", "realValue", "isExpression", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GEval create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                String r101 = r100.substring(5, r100.length() - 1);
                GEval r102 = createEval("==", r101);
                if (r102 == null) goto L5;
                return r102;
            L5:
                GEval r103 = createEval(">=", r101);
                if (r103 == null) goto L8;
                return r103;
            L8:
                GEval r104 = createEval(">", r101);
                if (r104 == null) goto L11;
                return r104;
            L11:
                GEval r105 = createEval("<=", r101);
                if (r105 == null) goto L14;
                return r105;
            L14:
                GEval r106 = createEval("<", r101);
                if (r106 == null) goto L17;
                return r106;
            L17:
                GEval r107 = createEval("!=", r101);
                if (r107 == null) goto L20;
                return r107;
            L20:
                GEval r108 = createEval("||", r101);
                if (r108 == null) goto L23;
                return r108;
            L23:
                GEval r109 = createEval("&&", r101);
                if (r109 == null) goto L26;
                return r109;
            L26:
                GEval r110 = createEval(GXTemplateKey.GAIAX_PE, r101);
                if (r110 == null) goto L29;
                return r110;
            L29:
                Undefined r111 = Undefined.INSTANCE;
                return new GEval("", r111, r111);
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                if (StringsKt.startsWith$default(r100, "eval(", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.endsWith$default(r100, ")", false, 2, null) == false) goto L9;
                return true;
            L9:
                return false;
            }

            private final GEval createEval(String r100, String r110) {
                List r111 = StringsKt.split$default(r110, new String[]{r100}, false, 0, 6, null);
                if (r111.size() != 2) goto L6;
                String r101 = (String) ListProtector.get(r111, 0);
                String r112 = (String) ListProtector.get(r111, 1);
                Companion r102 = GaiaXExpression.Companion;
                return new GEval(r100, r102.create(r101), r102.create(r112));
            L6:
                return null;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GEval copy$default(GEval r100, String r101, GaiaXExpression r102, GaiaXExpression r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.operate;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.leftValue;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.rightValue;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.operate;
        }

        public final GaiaXExpression component2() {
            return this.leftValue;
        }

        public final GaiaXExpression component3() {
            return this.rightValue;
        }

        public final GEval copy(String r100, GaiaXExpression r101, GaiaXExpression r102) {
            Intrinsics.checkNotNullParameter(r100, "operate");
            Intrinsics.checkNotNullParameter(r101, "leftValue");
            Intrinsics.checkNotNullParameter(r102, "rightValue");
            return new GEval(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GEval) == true) goto L8;
            return false;
        L8:
            GEval r101 = (GEval) r100;
            if (Intrinsics.areEqual(this.operate, r101.operate) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.leftValue, r101.leftValue) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.rightValue, r101.rightValue) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.operate.hashCode() * 31) + this.leftValue.hashCode()) * 31) + this.rightValue.hashCode();
        }

        public String toString() {
            return "GEval(operate='" + this.operate + "', leftValue=" + this.leftValue + ", rightValue=" + this.rightValue + ')';
        }

        public final GaiaXExpression getLeftValue() {
            return this.leftValue;
        }

        public final String getOperate() {
            return this.operate;
        }

        public final GaiaXExpression getRightValue() {
            return this.rightValue;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            Object r101 = this.leftValue.desireData(r100);
            Object r102 = this.rightValue.desireData(r100);
            String r103 = this.operate;
            int r104 = r103.hashCode();
            if (r104 == 37) goto L54;
            if (r104 == 60) goto L50;
            if (r104 == 62) goto L46;
            if (r104 == 1084) goto L42;
            if (r104 == 1216) goto L38;
            if (r104 == 1921) goto L34;
            if (r104 == 1952) goto L30;
            if (r104 == 1983) goto L26;
            if (r104 != 3968) goto L66;
            if (r103.equals("||") == false) goto L66;
            return doubleOr(r101, r102);
        L66:
            return Boolean.FALSE;
        L26:
            if (r103.equals(">=") == false) goto L66;
            return greaterThanOrEqual(r101, r102);
        L30:
            if (r103.equals("==") == false) goto L66;
            return equal(r101, r102);
        L34:
            if (r103.equals("<=") == false) goto L66;
            return lessThanOrEqual(r101, r102);
        L38:
            if (r103.equals("&&") == false) goto L66;
            return doubleAnd(r101, r102);
        L42:
            if (r103.equals("!=") == false) goto L66;
            return notEqual(r101, r102);
        L46:
            if (r103.equals(">") == false) goto L66;
            return greaterThan(r101, r102);
        L50:
            if (r103.equals("<") == false) goto L66;
            return lessThan(r101, r102);
        L54:
            if (r103.equals(GXTemplateKey.GAIAX_PE) == false) goto L66;
            return mod(r101, r102);
        }

        private final Object doubleAnd(Object r100, Object r101) {
            boolean r102 = r100 instanceof Number;
            boolean r103 = true;
            if (r102 == true) goto L5;
        L18:
            if (r102 == true) goto L20;
        L29:
            if (r102 == true) goto L31;
        L38:
            boolean r104 = r100 instanceof Boolean;
            if (r104 == true) goto L41;
        L47:
            if (r104 == true) goto L49;
        L58:
            if (r104 == true) goto L60;
        L62:
            boolean r105 = r100 instanceof String;
            if (r105 == true) goto L65;
        L67:
            if (r105 == true) goto L69;
        L71:
            if (r105 == true) goto L73;
        L17:
            r103 = false;
        L80:
            return Boolean.valueOf(r103);
        L73:
            if ((r101 instanceof Number) == false) goto L17;
            if (((Number) r101).floatValue() != 0.0f) goto L77;
            boolean r106 = true;
        L78:
            if (r106 == true) goto L17;
        L77:
            r106 = false;
            goto L78
        L69:
            if ((r101 instanceof Boolean) == false) goto L71;
            r103 = ((Boolean) r101).booleanValue();
            goto L80
        L65:
            if ((r101 instanceof String) == false) goto L67;
        L60:
            if ((r101 instanceof String) == false) goto L62;
            r103 = ((Boolean) r100).booleanValue();
            goto L80
        L49:
            if ((r101 instanceof Number) == false) goto L58;
            if (((Boolean) r100).booleanValue() == false) goto L17;
            if (((Number) r101).floatValue() != 0.0f) goto L55;
            boolean r107 = true;
        L56:
            if (r107 == true) goto L17;
        L55:
            r107 = false;
            goto L56
        L41:
            if ((r101 instanceof Boolean) == false) goto L47;
            if (((Boolean) r100).booleanValue() == false) goto L17;
            if (((Boolean) r101).booleanValue() == false) goto L17;
        L31:
            if ((r101 instanceof String) == false) goto L38;
            if (((Number) r100).floatValue() != 0.0f) goto L35;
            boolean r108 = true;
        L36:
            if (r108 == true) goto L17;
        L35:
            r108 = false;
            goto L36
        L20:
            if ((r101 instanceof Boolean) == false) goto L29;
            if (((Number) r100).floatValue() != 0.0f) goto L24;
            boolean r109 = true;
        L25:
            if (r109 == true) goto L17;
            if (((Boolean) r101).booleanValue() == false) goto L17;
        L24:
            r109 = false;
            goto L25
        L5:
            if ((r101 instanceof Number) == false) goto L18;
            if (((Number) r100).floatValue() != 0.0f) goto L9;
            boolean r110 = true;
        L10:
            if (r110 == true) goto L17;
            if (((Number) r101).floatValue() != 0.0f) goto L14;
            boolean r111 = true;
        L15:
            if (r111 == true) goto L17;
        L14:
            r111 = false;
            goto L15
        L9:
            r110 = false;
            goto L10
        }

        private final Object doubleOr(Object r100, Object r101) {
            boolean r102 = r100 instanceof Number;
            boolean r103 = false;
            if (r102 == true) goto L5;
        L17:
            if (r102 == true) goto L19;
        L28:
            if (r102 == true) goto L30;
        L32:
            boolean r104 = r100 instanceof Boolean;
            if (r104 == true) goto L35;
        L41:
            if (r104 == true) goto L43;
        L52:
            if (r104 == true) goto L54;
        L56:
            boolean r105 = r100 instanceof String;
            if (r105 == true) goto L59;
        L61:
            if (r105 == true) goto L63;
        L65:
            if (r105 == true) goto L67;
        L69:
            if (r100 == null) goto L71;
            if (r101 == null) goto L86;
        L100:
            return Boolean.valueOf(r103);
        L86:
            if ((r100 instanceof Boolean) == false) goto L89;
            r103 = ((Boolean) r100).booleanValue();
            goto L100
        L89:
            if ((r100 instanceof Number) == false) goto L97;
            if (((Number) r100).floatValue() != 0.0f) goto L93;
            boolean r106 = true;
        L94:
            if (r106 == true) goto L100;
        L31:
            r103 = true;
            goto L100
        L93:
            r106 = false;
            goto L94
        L97:
            if ((r100 instanceof String) == false) goto L100;
        L71:
            if ((r101 instanceof Boolean) == false) goto L74;
            r103 = ((Boolean) r101).booleanValue();
            goto L100
        L74:
            if ((r101 instanceof Number) == false) goto L82;
            if (((Number) r101).floatValue() != 0.0f) goto L78;
            boolean r107 = true;
        L79:
            if (r107 == true) goto L100;
        L78:
            r107 = false;
            goto L79
        L82:
            if ((r101 instanceof String) == false) goto L100;
        L67:
            if ((r101 instanceof Number) == false) goto L69;
        L63:
            if ((r101 instanceof Boolean) == false) goto L65;
        L59:
            if ((r101 instanceof String) == false) goto L61;
        L54:
            if ((r101 instanceof String) == false) goto L56;
        L43:
            if ((r101 instanceof Number) == false) goto L52;
            if (((Boolean) r100).booleanValue() == true) goto L31;
            if (((Number) r101).floatValue() != 0.0f) goto L49;
            boolean r108 = true;
        L50:
            if (r108 == true) goto L100;
        L49:
            r108 = false;
            goto L50
        L35:
            if ((r101 instanceof Boolean) == false) goto L41;
            if (((Boolean) r100).booleanValue() == true) goto L31;
            if (((Boolean) r101).booleanValue() == false) goto L100;
        L30:
            if ((r101 instanceof String) == false) goto L32;
        L19:
            if ((r101 instanceof Boolean) == false) goto L28;
            if (((Number) r100).floatValue() != 0.0f) goto L23;
            boolean r109 = true;
        L24:
            if (r109 == false) goto L31;
            if (((Boolean) r101).booleanValue() == false) goto L100;
        L23:
            r109 = false;
            goto L24
        L5:
            if ((r101 instanceof Number) == false) goto L17;
            if (((Number) r100).floatValue() != 0.0f) goto L9;
            boolean r110 = true;
        L10:
            if (r110 == false) goto L31;
            if (((Number) r101).floatValue() != 0.0f) goto L14;
            boolean r111 = true;
        L15:
            if (r111 == true) goto L100;
        L14:
            r111 = false;
            goto L15
        L9:
            r110 = false;
            goto L10
        }

        private final Object equal(Object r100, Object r101) {
            if ((r100 instanceof String) == true) goto L5;
        L7:
            boolean r102 = r100 instanceof Number;
            if (r102 == true) goto L10;
        L15:
            boolean r103 = r100 instanceof Boolean;
            if (r103 == false) goto L21;
            if ((r101 instanceof Boolean) == false) goto L21;
            boolean r104 = Intrinsics.areEqual(r100, r101);
        L61:
            return Boolean.valueOf(r104);
        L21:
            if (r102 == true) goto L23;
        L39:
            if (r103 == true) goto L41;
        L57:
            if (r100 == null) goto L58;
        L14:
            r104 = false;
            goto L61
        L58:
            if (r101 != null) goto L14;
        L13:
            r104 = true;
            goto L61
        L41:
            if ((r101 instanceof Number) == false) goto L57;
            if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L50;
            if (((Number) r101).floatValue() != 0.0f) goto L47;
            boolean r105 = true;
        L48:
            if (r105 == false) goto L13;
        L47:
            r105 = false;
        L50:
            if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L14;
            if (((Number) r101).floatValue() != 0.0f) goto L54;
            boolean r106 = true;
        L55:
            if (r106 == false) goto L14;
        L54:
            r106 = false;
            goto L55
        L23:
            if ((r101 instanceof Boolean) == false) goto L39;
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L32;
            if (((Number) r100).floatValue() != 0.0f) goto L29;
            boolean r107 = true;
        L30:
            if (r107 == false) goto L13;
        L29:
            r107 = false;
        L32:
            if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L14;
            if (((Number) r100).floatValue() != 0.0f) goto L36;
            boolean r108 = true;
        L37:
            if (r108 == false) goto L14;
        L36:
            r108 = false;
            goto L37
        L10:
            if ((r101 instanceof Number) == false) goto L15;
            if (((Number) r100).floatValue() != ((Number) r101).floatValue()) goto L14;
        L5:
            if ((r101 instanceof String) == false) goto L7;
            r104 = Intrinsics.areEqual(r100, r101);
            goto L61
        }

        private final Object greaterThan(Object r100, Object r101) {
            boolean r102 = false;
            if ((r100 instanceof Number) == false) goto L10;
            if ((r101 instanceof Number) == false) goto L10;
            if (((Number) r100).floatValue() <= ((Number) r101).floatValue()) goto L10;
            r102 = true;
        L10:
            return Boolean.valueOf(r102);
        }

        private final Object greaterThanOrEqual(Object r100, Object r101) {
            boolean r102 = false;
            if ((r100 instanceof Number) == false) goto L10;
            if ((r101 instanceof Number) == false) goto L10;
            if (((Number) r100).floatValue() < ((Number) r101).floatValue()) goto L10;
            r102 = true;
        L10:
            return Boolean.valueOf(r102);
        }

        private final Object lessThan(Object r100, Object r101) {
            boolean r102 = false;
            if ((r100 instanceof Number) == false) goto L10;
            if ((r101 instanceof Number) == false) goto L10;
            if (((Number) r100).floatValue() >= ((Number) r101).floatValue()) goto L10;
            r102 = true;
        L10:
            return Boolean.valueOf(r102);
        }

        private final Object lessThanOrEqual(Object r100, Object r101) {
            boolean r102 = false;
            if ((r100 instanceof Number) == false) goto L10;
            if ((r101 instanceof Number) == false) goto L10;
            if (((Number) r100).floatValue() > ((Number) r101).floatValue()) goto L10;
            r102 = true;
        L10:
            return Boolean.valueOf(r102);
        }

        private final Object mod(Object r100, Object r101) {
            if ((r100 instanceof Number) == false) goto L18;
            if ((r101 instanceof Number) == false) goto L18;
            if ((r100 instanceof Integer) == false) goto L12;
            if ((r101 instanceof Integer) == false) goto L12;
            return Integer.valueOf(((Number) r100).intValue() % ((Number) r101).intValue());
        L12:
            if ((r100 instanceof Float) == false) goto L21;
            if ((r101 instanceof Float) == false) goto L21;
            return Float.valueOf(((Number) r100).floatValue() % ((Number) r101).floatValue());
        L21:
            return Float.valueOf(((Number) r100).floatValue() % ((Number) r101).floatValue());
        L18:
            return Boolean.FALSE;
        }

        private final Object notEqual(Object r100, Object r101) {
            boolean r102 = true;
            if ((r100 instanceof String) == true) goto L5;
        L10:
            boolean r103 = r100 instanceof Number;
            if (r103 == true) goto L13;
        L20:
            boolean r104 = r100 instanceof Boolean;
            if (r104 == false) goto L28;
            if ((r101 instanceof Boolean) == false) goto L28;
            if (Intrinsics.areEqual(r100, r101) == false) goto L64;
        L9:
            r102 = false;
        L64:
            return Boolean.valueOf(r102);
        L28:
            if (r103 == true) goto L30;
        L46:
            if (r104 == false) goto L9;
            if ((r101 instanceof Number) == false) goto L9;
            if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L57;
            if (((Number) r101).floatValue() != 0.0f) goto L54;
            boolean r105 = true;
        L55:
            if (r105 == true) goto L64;
        L54:
            r105 = false;
        L57:
            if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L9;
            if (((Number) r101).floatValue() != 0.0f) goto L61;
            boolean r106 = true;
        L62:
            if (r106 == true) goto L9;
        L61:
            r106 = false;
            goto L62
        L30:
            if ((r101 instanceof Boolean) == false) goto L46;
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L39;
            if (((Number) r100).floatValue() != 0.0f) goto L36;
            boolean r107 = true;
        L37:
            if (r107 == true) goto L64;
        L36:
            r107 = false;
        L39:
            if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L9;
            if (((Number) r100).floatValue() != 0.0f) goto L43;
            boolean r108 = true;
        L44:
            if (r108 == true) goto L9;
        L43:
            r108 = false;
            goto L44
        L13:
            if ((r101 instanceof Number) == false) goto L20;
            if (((Number) r100).floatValue() != ((Number) r101).floatValue()) goto L17;
            boolean r109 = true;
        L18:
            if (r109 == true) goto L9;
        L17:
            r109 = false;
            goto L18
        L5:
            if ((r101 instanceof String) == false) goto L10;
            if (Intrinsics.areEqual(r100, r101) == true) goto L9;
            goto L9
        }

        public GEval(String r100, GaiaXExpression r101, GaiaXExpression r102) {
            Intrinsics.checkNotNullParameter(r100, "operate");
            Intrinsics.checkNotNullParameter(r101, "leftValue");
            Intrinsics.checkNotNullParameter(r102, "rightValue");
            super(null);
            this.operate = r100;
            this.leftValue = r101;
            this.rightValue = r102;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GFloat;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GFloat extends GaiaXExpression {
        public static final Companion Companion = null;
        private final float value;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GFloat$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GFloat;", "value", "", "isExpression", "", "expression", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GFloat create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                return new GFloat(CastFloatProtector.parseFloat(r100));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                return Intrinsics.areEqual(String.valueOf(CastFloatProtector.parseFloat(r100)), r100);
            L5:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GFloat copy$default(GFloat r100, float r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final float component1() {
            return this.value;
        }

        public final GFloat copy(float r100) {
            return new GFloat(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GFloat) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.value, ((GFloat) r100).value) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "GFloat(value=" + this.value + ')';
        }

        public final float getValue() {
            return this.value;
        }

        public GFloat(float r100) {
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return Float.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GInt;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "", "(I)V", "getValue", "()I", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GInt extends GaiaXExpression {
        public static final Companion Companion = null;
        private final int value;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GInt$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GInt;", "value", "", "isExpression", "", "expression", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GInt create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                return new GInt(CastIntegerProtector.parseInt(r100));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                return Intrinsics.areEqual(String.valueOf(CastIntegerProtector.parseInt(r100)), r100);
            L5:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GInt copy$default(GInt r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final int component1() {
            return this.value;
        }

        public final GInt copy(int r100) {
            return new GInt(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GInt) == true) goto L9;
            return false;
        L9:
            if (this.value == ((GInt) r100).value) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "GInt(value=" + this.value + ')';
        }

        public final int getValue() {
            return this.value;
        }

        public GInt(int r100) {
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GJsonArrayObj;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)V", "getValue", "()Lorg/json/JSONArray;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GJsonArrayObj extends GaiaXExpression {
        public static final Companion Companion = null;
        private final JSONArray value;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GJsonArrayObj$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GJsonArrayObj;", "value", "Lorg/json/JSONArray;", "isExpression", "", "expression", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GJsonArrayObj create(JSONArray r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                final JSONArray r101 = new JSONArray();
                GXExtJsonKt.forEach(r100, new GaiaXExpression$GJsonArrayObj$Companion$create$1(r101));
                return new GJsonArrayObj(r101);
            }

            public final boolean isExpression(Object r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                return r100 instanceof JSONArray;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GJsonArrayObj copy$default(GJsonArrayObj r100, JSONArray r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final JSONArray component1() {
            return this.value;
        }

        public final GJsonArrayObj copy(JSONArray r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GJsonArrayObj(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GJsonArrayObj) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((GJsonArrayObj) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "GJsonArrayObj(value=" + this.value + ')';
        }

        public final JSONArray getValue() {
            return this.value;
        }

        public GJsonArrayObj(JSONArray r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(final Object r100) {
            final JSONArray r101 = new JSONArray();
            if (this.value.length() <= 0) goto L5;
            GXExtJsonKt.forEach(this.value, new GaiaXExpression$GJsonArrayObj$desireData$1(r101, r100));
        L5:
            return r101;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GJsonObj;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getValue", "()Lorg/json/JSONObject;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GJsonObj extends GaiaXExpression {
        public static final Companion Companion = null;
        private final JSONObject value;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GJsonObj$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GJsonObj;", "value", "Lorg/json/JSONObject;", "isExpression", "", "expression", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GJsonObj create(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                JSONObject r101 = new JSONObject();
                Iterator<String> r102 = r100.keys();
            L4:
                if (r102.hasNext() == false) goto L20;
                String r103 = r102.next();
                if (r103 == null) goto L4;
                if (r100.opt(r103) == null) goto L4;
                if ((r100.opt(r103) instanceof Integer) == true) goto L18;
                if ((r100.opt(r103) instanceof Boolean) == true) goto L18;
                Companion r104 = GaiaXExpression.Companion;
                Object r105 = r100.opt(r103);
                if (r105 != null) goto L17;
                r105 = new Object();
            L17:
                r101.put(r103, r104.create(r105));
            L18:
                r101.put(r103, r100.opt(r103));
                goto L4
            L20:
                return new GJsonObj(r101);
            }

            public final boolean isExpression(Object r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                return r100 instanceof JSONObject;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GJsonObj copy$default(GJsonObj r100, JSONObject r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final JSONObject component1() {
            return this.value;
        }

        public final GJsonObj copy(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GJsonObj(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GJsonObj) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((GJsonObj) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "GJsonObj(value=" + this.value + ')';
        }

        public final JSONObject getValue() {
            return this.value;
        }

        public GJsonObj(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            JSONObject r101 = new JSONObject();
            if (this.value.length() <= 0) goto L15;
            Iterator<String> r102 = this.value.keys();
        L6:
            if (r102.hasNext() == false) goto L15;
            String r103 = r102.next();
            if (r103 == null) goto L6;
            if (this.value.opt(r103) == null) goto L6;
            if ((this.value.opt(r103) instanceof GaiaXExpression) == true) goto L13;
            r101.put(r103, this.value.opt(r103));
            goto L6
        L13:
            Object r104 = this.value.opt(r103);
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.alibaba.gaiax.adapter.GaiaXExpression");
            r101.put(r103, ((GaiaXExpression) r104).desireData(r100));
        L15:
            return r101;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GNull;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "()V", "desireData", "", "rawJson", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GNull extends GaiaXExpression {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GNull$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GNull;", "isExpression", "", "expression", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GNull create() {
                return new GNull();
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                return Intrinsics.areEqual(r100, "null");
            }
        }

        static {
            Companion = new Companion(null);
        }

        public GNull() {
            super(null);
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return null;
        }

        public String toString() {
            return "GNull()";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GScroll;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GScroll extends GaiaXExpression {
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GScroll$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GScroll;", "value", "", "isExpression", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GScroll create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                return new GScroll(r100.substring(7, r100.length() - 1));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                if (StringsKt.startsWith$default(r100, "scroll(", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.endsWith$default(r100, ")", false, 2, null) == false) goto L9;
                return true;
            L9:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GScroll copy$default(GScroll r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.value;
        }

        public final GScroll copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GScroll(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GScroll) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((GScroll) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "GScroll(value='" + this.value + "')";
        }

        public final String getValue() {
            return this.value;
        }

        public GScroll(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return -1;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GSize;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "(Lcom/alibaba/gaiax/adapter/GaiaXExpression;)V", "getValue", "()Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GSize extends GaiaXExpression {
        public static final Companion Companion = null;
        private final GaiaXExpression value;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GSize$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GSize;", "value", "", "isExpression", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GSize create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                return new GSize(GaiaXExpression.Companion.create(r100.substring(5, r100.length() - 1)));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                if (StringsKt.startsWith$default(r100, "size(", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.endsWith$default(r100, ")", false, 2, null) == false) goto L9;
                return true;
            L9:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GSize copy$default(GSize r100, GaiaXExpression r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final GaiaXExpression component1() {
            return this.value;
        }

        public final GSize copy(GaiaXExpression r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GSize(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GSize) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((GSize) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "GSize(value=" + this.value + ')';
        }

        public final GaiaXExpression getValue() {
            return this.value;
        }

        public GSize(GaiaXExpression r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            Object r101 = this.value.desireData(r100);
            if ((r101 instanceof String) == false) goto L6;
            return Integer.valueOf(((String) r101).length());
        L6:
            if ((r101 instanceof JSONArray) == false) goto L9;
            return Integer.valueOf(((JSONArray) r101).length());
        L9:
            if ((r101 instanceof JSONObject) == true) goto L15;
            return null;
        L15:
            return Integer.valueOf(((JSONObject) r101).length());
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GString;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GString extends GaiaXExpression {
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GString$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GString;", "value", "", "isExpression", "", "expression", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GString create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                return new GString(r100.substring(1, r100.length() - 1));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                if (StringsKt.startsWith$default(r100, "'", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.endsWith$default(r100, "'", false, 2, null) == false) goto L9;
                return true;
            L9:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GString copy$default(GString r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.value;
        }

        public final GString copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GString(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GString) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((GString) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "GString(value='" + this.value + "')";
        }

        public final String getValue() {
            return this.value;
        }

        public GString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue1;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "condition", "trueBranch", "falseBranch", "(Lcom/alibaba/gaiax/adapter/GaiaXExpression;Lcom/alibaba/gaiax/adapter/GaiaXExpression;Lcom/alibaba/gaiax/adapter/GaiaXExpression;)V", "getCondition", "()Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "getFalseBranch", "getTrueBranch", "component1", "component2", "component3", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GTernaryValue1 extends GaiaXExpression {
        public static final Companion Companion = null;
        private final GaiaXExpression condition;
        private final GaiaXExpression falseBranch;
        private final GaiaXExpression trueBranch;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue1$Companion;", "", "()V", "conditionValue", "", "expression", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue1;", "falseValue", "getExpressionValue", "isExp", "", "isExp2", "isExpression", "trueValue", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            private final String conditionValue(String r100) {
                List r101 = StringsKt.split$default(r100, new String[]{" ? "}, false, 0, 6, null);
                if ((!r101.isEmpty()) == true) goto L5;
                return "";
            L5:
                return (String) ListProtector.get(r101, 0);
            }

            private final String falseValue(String r110) {
                List r111 = StringsKt.split$default(r110, new String[]{" ? "}, false, 0, 6, null);
                if (r111.size() < 2) goto L14;
                List r100 = StringsKt.split$default((CharSequence) ListProtector.get(r111, 1), new String[]{" : "}, false, 0, 6, null);
                if (r100.size() != 2) goto L9;
                return (String) ListProtector.get(r100, 1);
            L9:
                if (r100.size() <= 2) goto L16;
                List r112 = StringsKt.split$default((CharSequence) ListProtector.get(r111, 1), new String[]{" : "}, false, 0, 6, null);
                if (r112.size() == 2) goto L13;
                return "";
            L13:
                return (String) ListProtector.get(r112, 1);
            L16:
                return "";
            L14:
                return "";
            }

            private final String getExpressionValue(String r100) {
                int r101 = StringsKt.indexOf$default(r100, "{", 0, false, 6, null);
                int r102 = r101 + 1;
                return r100.substring(r102, StringsKt.lastIndexOf$default(r100, i.f25855d, 0, false, 6, null));
            }

            private final boolean isExp(String r100) {
                if (StringsKt.contains$default(r100, "${", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.startsWith$default(r100, "@{", false, 2, null) == true) goto L7;
                return false;
            L7:
                if (StringsKt.endsWith$default(r100, i.f25855d, false, 2, null) == true) goto L9;
                return false;
            L9:
                if (StringsKt.contains$default(r100, " ? ", false, 2, null) == true) goto L11;
                return false;
            L11:
                if (StringsKt.contains$default(r100, " : ", false, 2, null) == true) goto L13;
                return false;
            L13:
                if (StringsKt.contains$default(r100, " ?: ", false, 2, null) == true) goto L21;
                return true;
            L21:
                return false;
            }

            private final boolean isExp2(String r100) {
                if (StringsKt.startsWith$default(r100, "@{", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.endsWith$default(r100, i.f25855d, false, 2, null) == true) goto L7;
                return false;
            L7:
                if (StringsKt.contains$default(r100, " ? ", false, 2, null) == true) goto L9;
                return false;
            L9:
                if (StringsKt.contains$default(r100, " : ", false, 2, null) == true) goto L11;
                return false;
            L11:
                if (StringsKt.contains$default(r100, " ?: ", false, 2, null) == true) goto L18;
                return true;
            L18:
                return false;
            }

            private final String trueValue(String r110) {
                List r111 = StringsKt.split$default(r110, new String[]{" ? "}, false, 0, 6, null);
                if (r111.size() != 2) goto L14;
                List r100 = StringsKt.split$default((CharSequence) ListProtector.get(r111, 1), new String[]{" : "}, false, 0, 6, null);
                if (r100.size() != 2) goto L9;
                return (String) ListProtector.get(r100, 0);
            L9:
                if (r100.size() <= 2) goto L16;
                List r112 = StringsKt.split$default((CharSequence) ListProtector.get(r111, 1), new String[]{" : "}, false, 0, 6, null);
                if (r112.size() == 2) goto L13;
                return "";
            L13:
                return (String) ListProtector.get(r112, 0);
            L16:
                return "";
            L14:
                return "";
            }

            public final GTernaryValue1 create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                String r101 = getExpressionValue(r100);
                Companion r102 = GaiaXExpression.Companion;
                return new GTernaryValue1(r102.create(conditionValue(r101)), r102.create(trueValue(r101)), r102.create(falseValue(r101)));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                if (isExp(r100) == false) goto L5;
            L8:
                return true;
            L5:
                if (isExp2(r100) == true) goto L8;
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GTernaryValue1 copy$default(GTernaryValue1 r100, GaiaXExpression r101, GaiaXExpression r102, GaiaXExpression r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.condition;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.trueBranch;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.falseBranch;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final GaiaXExpression component1() {
            return this.condition;
        }

        public final GaiaXExpression component2() {
            return this.trueBranch;
        }

        public final GaiaXExpression component3() {
            return this.falseBranch;
        }

        public final GTernaryValue1 copy(GaiaXExpression r100, GaiaXExpression r101, GaiaXExpression r102) {
            Intrinsics.checkNotNullParameter(r100, "condition");
            Intrinsics.checkNotNullParameter(r101, "trueBranch");
            Intrinsics.checkNotNullParameter(r102, "falseBranch");
            return new GTernaryValue1(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GTernaryValue1) == true) goto L8;
            return false;
        L8:
            GTernaryValue1 r101 = (GTernaryValue1) r100;
            if (Intrinsics.areEqual(this.condition, r101.condition) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.trueBranch, r101.trueBranch) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.falseBranch, r101.falseBranch) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.condition.hashCode() * 31) + this.trueBranch.hashCode()) * 31) + this.falseBranch.hashCode();
        }

        public String toString() {
            return "GTernaryValue1(condition=" + this.condition + ", trueBranch=" + this.trueBranch + ", falseBranch=" + this.falseBranch + ')';
        }

        public final GaiaXExpression getCondition() {
            return this.condition;
        }

        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        public final GaiaXExpression getTrueBranch() {
            return this.trueBranch;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            Object r101 = this.condition.desireData(r100);
            if (GaiaXExpression.Companion.isCondition(r101) == false) goto L6;
            return this.trueBranch.desireData(r100);
        L6:
            return this.falseBranch.desireData(r100);
        }

        public GTernaryValue1(GaiaXExpression r100, GaiaXExpression r101, GaiaXExpression r102) {
            Intrinsics.checkNotNullParameter(r100, "condition");
            Intrinsics.checkNotNullParameter(r101, "trueBranch");
            Intrinsics.checkNotNullParameter(r102, "falseBranch");
            super(null);
            this.condition = r100;
            this.trueBranch = r101;
            this.falseBranch = r102;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001HÆ\u0001J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue2;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "conditionAndTrueBranch", "falseBranch", "(Lcom/alibaba/gaiax/adapter/GaiaXExpression;Lcom/alibaba/gaiax/adapter/GaiaXExpression;)V", "getConditionAndTrueBranch", "()Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "getFalseBranch", "component1", "component2", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GTernaryValue2 extends GaiaXExpression {
        public static final Companion Companion = null;
        private final GaiaXExpression conditionAndTrueBranch;
        private final GaiaXExpression falseBranch;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue2$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue2;", "expression", "", "falseValue", "getExpressionValue", "isExp", "", "isExp2", "isExpression", "trueValue", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            private final String falseValue(String r100) {
                List r101 = StringsKt.split$default(r100, new String[]{" ?: "}, false, 0, 6, null);
                if (r101.size() == 2) goto L5;
                return "";
            L5:
                return (String) ListProtector.get(r101, 1);
            }

            private final String getExpressionValue(String r100) {
                int r101 = StringsKt.indexOf$default(r100, "{", 0, false, 6, null);
                int r102 = r101 + 1;
                return r100.substring(r102, StringsKt.lastIndexOf$default(r100, i.f25855d, 0, false, 6, null));
            }

            private final boolean isExp(String r100) {
                if (StringsKt.contains$default(r100, "${", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.startsWith$default(r100, "@{", false, 2, null) == true) goto L7;
                return false;
            L7:
                if (StringsKt.endsWith$default(r100, i.f25855d, false, 2, null) == true) goto L9;
                return false;
            L9:
                if (StringsKt.contains$default(r100, " ?: ", false, 2, null) == false) goto L15;
                return true;
            L15:
                return false;
            }

            private final boolean isExp2(String r100) {
                if (StringsKt.startsWith$default(r100, "@{", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.endsWith$default(r100, i.f25855d, false, 2, null) == true) goto L7;
                return false;
            L7:
                if (StringsKt.contains$default(r100, " ?: ", false, 2, null) == false) goto L12;
                return true;
            L12:
                return false;
            }

            private final String trueValue(String r100) {
                List r101 = StringsKt.split$default(r100, new String[]{" ?: "}, false, 0, 6, null);
                if (r101.size() == 2) goto L5;
                return "";
            L5:
                return (String) ListProtector.get(r101, 0);
            }

            public final GTernaryValue2 create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                String r101 = getExpressionValue(r100);
                Companion r102 = GaiaXExpression.Companion;
                return new GTernaryValue2(r102.create(trueValue(r101)), r102.create(falseValue(r101)));
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                if (isExp(r100) == false) goto L5;
            L8:
                return true;
            L5:
                if (isExp2(r100) == true) goto L8;
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GTernaryValue2 copy$default(GTernaryValue2 r100, GaiaXExpression r101, GaiaXExpression r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.conditionAndTrueBranch;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.falseBranch;
        L9:
            return r100.copy(r101, r102);
        }

        public final GaiaXExpression component1() {
            return this.conditionAndTrueBranch;
        }

        public final GaiaXExpression component2() {
            return this.falseBranch;
        }

        public final GTernaryValue2 copy(GaiaXExpression r100, GaiaXExpression r101) {
            Intrinsics.checkNotNullParameter(r100, "conditionAndTrueBranch");
            Intrinsics.checkNotNullParameter(r101, "falseBranch");
            return new GTernaryValue2(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GTernaryValue2) == true) goto L8;
            return false;
        L8:
            GTernaryValue2 r101 = (GTernaryValue2) r100;
            if (Intrinsics.areEqual(this.conditionAndTrueBranch, r101.conditionAndTrueBranch) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.falseBranch, r101.falseBranch) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.conditionAndTrueBranch.hashCode() * 31) + this.falseBranch.hashCode();
        }

        public String toString() {
            return "GTernaryValue2(conditionAndTrueBranch=" + this.conditionAndTrueBranch + ", falseBranch=" + this.falseBranch + ')';
        }

        public final GaiaXExpression getConditionAndTrueBranch() {
            return this.conditionAndTrueBranch;
        }

        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            Object r101 = this.conditionAndTrueBranch.desireData(r100);
            if (GaiaXExpression.Companion.isCondition(r101) == false) goto L6;
            return r101;
        L6:
            return this.falseBranch.desireData(r100);
        }

        public GTernaryValue2(GaiaXExpression r100, GaiaXExpression r101) {
            Intrinsics.checkNotNullParameter(r100, "conditionAndTrueBranch");
            Intrinsics.checkNotNullParameter(r101, "falseBranch");
            super(null);
            this.conditionAndTrueBranch = r100;
            this.falseBranch = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue3;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "trueBranch", "falseBranch", "(Lcom/alibaba/gaiax/adapter/GaiaXExpression;Lcom/alibaba/gaiax/adapter/GaiaXExpression;Lcom/alibaba/gaiax/adapter/GaiaXExpression;)V", "getFalseBranch", "()Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "getTrueBranch", "getValue", "component1", "component2", "component3", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GTernaryValue3 extends GaiaXExpression {
        public static final Companion Companion = null;
        private static final Regex regex = null;
        private final GaiaXExpression falseBranch;
        private final GaiaXExpression trueBranch;
        private final GaiaXExpression value;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\"\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTernaryValue3$Companion;", "", "()V", "regex", "Lkotlin/text/Regex;", "getRegex$annotations", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "expression", "", "isExp", "", "isExp2", "isExp3", "isExpression", "splitBranch", "Lkotlin/Pair;", "expressionSpace", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            private static /* synthetic */ void getRegex$annotations() {
            }

            private final boolean isExp(String r100) {
                if (StringsKt.contains$default(r100, "${", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.startsWith$default(r100, "@{", false, 2, null) == true) goto L7;
                return false;
            L7:
                if (StringsKt.endsWith$default(r100, i.f25855d, false, 2, null) == true) goto L9;
                return false;
            L9:
                if (StringsKt.contains$default(r100, " ? ", false, 2, null) == true) goto L11;
                return false;
            L11:
                if (StringsKt.contains$default(r100, " : ", false, 2, null) == true) goto L13;
                return false;
            L13:
                if (StringsKt.contains$default(r100, " ?: ", false, 2, null) == true) goto L21;
                return true;
            L21:
                return false;
            }

            private final boolean isExp2(String r100) {
                if (StringsKt.startsWith$default(r100, "@{", false, 2, null) == true) goto L5;
                return false;
            L5:
                if (StringsKt.endsWith$default(r100, i.f25855d, false, 2, null) == true) goto L7;
                return false;
            L7:
                if (StringsKt.contains$default(r100, " ? ", false, 2, null) == true) goto L9;
                return false;
            L9:
                if (StringsKt.contains$default(r100, " : ", false, 2, null) == true) goto L11;
                return false;
            L11:
                if (StringsKt.contains$default(r100, " ?: ", false, 2, null) == true) goto L18;
                return true;
            L18:
                return false;
            }

            private final boolean isExp3(String r100) {
                if (StringsKt.split$default(r100, new String[]{"@{"}, false, 0, 6, null).size() <= 2) goto L6;
                return true;
            L6:
                return false;
            }

            private final Pair<String, String> splitBranch(String r110) {
                int r100 = r110.length() - 1;
                int r101 = 0;
                boolean r102 = false;
            L3:
                if (r101 > r100) goto L18;
                if (r102 == true) goto L6;
                int r103 = r101;
            L8:
                if (Intrinsics.compare(r110.charAt(r103), 32) > 0) goto L10;
                boolean r104 = true;
            L11:
                if (r102 == false) goto L12;
                if (r104 == false) goto L18;
                r100 = r100 - 1;
                goto L3
            L12:
                if (r104 == false) goto L13;
                r101 = r101 + 1;
                goto L3
            L13:
                r102 = true;
                goto L3
            L10:
                r104 = false;
                goto L11
            L6:
                r103 = r100;
            L18:
                String r111 = r110.subSequence(r101, r100 + 1).toString();
                int r105 = StringsKt.indexOf$default(r111, "@{", 0, false, 6, null);
                if (r105 != (-1)) goto L22;
                String[] r112 = (String[]) StringsKt.split$default(r111, new String[]{" : "}, false, 0, 6, null).toArray(new String[0]);
                return new Pair(r112[0], r112[1]);
            L22:
                int r106 = StringsKt.indexOf$default(r111, " : ", 0, false, 6, null);
                if (r106 < r105) goto L59;
                String r113 = r111.substring(r105);
                int r107 = 0;
                int r108 = 0;
            L27:
                if (r107 >= r113.length()) goto L39;
                if ('@' != r113.charAt(r107)) goto L31;
            L32:
                r108 = r108 + 1;
                r107 = r107 + 1;
            L34:
                if ('}' != r113.charAt(r107)) goto L36;
                r108 = r108 - 1;
            L36:
                if (r108 == 0) goto L40;
                r107 = r107 + 1;
            L40:
                if (r107 == (-1)) goto L45;
                int r109 = r107 + 1;
                int r114 = StringsKt.indexOf$default(r113, " : ", r109, false, 4, null);
                if (r114 == (-1)) goto L45;
                return new Pair(r113.substring(0, r109), r113.substring(r114 + 2, r113.length()));
            L45:
                return null;
            L31:
                if ('$' != r113.charAt(r107)) goto L34;
            L39:
                r107 = -1;
                goto L40
            L59:
                return new Pair(r111.substring(0, r106), r111.substring(r106 + 2));
            }

            public final GaiaXExpression create(String r110) {
                Intrinsics.checkNotNullParameter(r110, "expression");
                Sequence r100 = Regex.findAll$default(GTernaryValue3.access$getRegex$cp(), r110, 0, 2, null);
                if (SequencesKt.count(r100) <= 0) goto L26;
                if (((MatchResult) SequencesKt.first(r100)).getGroupValues().size() <= 1) goto L26;
                String r111 = (String) ListProtector.get(((MatchResult) SequencesKt.first(r100)).getGroupValues(), 1);
                int r101 = StringsKt.indexOf$default(r111, " ? ", 0, false, 6, null);
                if (r101 == (-1)) goto L24;
                String r102 = r111.substring(0, r101);
                Companion r103 = GaiaXExpression.Companion;
                GaiaXExpression r104 = r103.create(r102);
                if (StringsKt.indexOf$default(r111, " : ", 0, false, 6, null) == (-1)) goto L28;
                Pair<String, String> r112 = splitBranch(r111.substring(r101 + 3));
                String r105 = "";
                if (r112 == null) goto L14;
                String r106 = r112.getFirst();
                if (r106 == null) goto L14;
            L15:
                GaiaXExpression r107 = r103.create(r106);
                if (r112 == null) goto L27;
                String r113 = r112.getSecond();
                if (r113 == null) goto L27;
                r105 = r113;
            L27:
                return new GTernaryValue3(r104, r107, r103.create(r105));
            L14:
                r106 = "";
                goto L15
            L28:
                return r103.create(r104);
            L24:
                return GaiaXExpression.Companion.create(r111);
            L26:
                return GaiaXExpression.Companion.create(r110);
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                if (isExp(r100) == true) goto L7;
                if (isExp2(r100) == true) goto L7;
            L9:
                return false;
            L7:
                if (isExp3(r100) == false) goto L9;
                return true;
            }
        }

        public static /* synthetic */ GTernaryValue3 copy$default(GTernaryValue3 r100, GaiaXExpression r101, GaiaXExpression r102, GaiaXExpression r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.trueBranch;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.falseBranch;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final GaiaXExpression component1() {
            return this.value;
        }

        public final GaiaXExpression component2() {
            return this.trueBranch;
        }

        public final GaiaXExpression component3() {
            return this.falseBranch;
        }

        public final GTernaryValue3 copy(GaiaXExpression r100, GaiaXExpression r101, GaiaXExpression r102) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GTernaryValue3(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GTernaryValue3) == true) goto L8;
            return false;
        L8:
            GTernaryValue3 r101 = (GTernaryValue3) r100;
            if (Intrinsics.areEqual(this.value, r101.value) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.trueBranch, r101.trueBranch) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.falseBranch, r101.falseBranch) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.value.hashCode() * 31;
            GaiaXExpression r101 = this.trueBranch;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            GaiaXExpression r105 = this.falseBranch;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        static {
            Companion = new Companion(null);
            regex = new Regex("@\\{(.*)\\}");
        }

        public String toString() {
            return "GTernaryValue3(value=" + this.value + ", trueBranch=" + this.trueBranch + ", falseBranch=" + this.falseBranch + ')';
        }

        public static final /* synthetic */ Regex access$getRegex$cp() {
            return regex;
        }

        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        public final GaiaXExpression getTrueBranch() {
            return this.trueBranch;
        }

        public final GaiaXExpression getValue() {
            return this.value;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            if (this.falseBranch == null) goto L14;
            if (this.trueBranch == null) goto L14;
            Object r101 = this.value.desireData(r100);
            if (GaiaXExpression.Companion.isCondition(r101) == false) goto L12;
            return this.trueBranch.desireData(r100);
        L12:
            return this.falseBranch.desireData(r100);
        L14:
            return this.value.desireData(r100);
        }

        public GTernaryValue3(GaiaXExpression r100, GaiaXExpression r101, GaiaXExpression r102) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
            this.trueBranch = r101;
            this.falseBranch = r102;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GText;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GText extends GaiaXExpression {
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GText$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GText;", "value", "", "isExpression", "", "expression", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GText create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                return new GText(r100);
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                if (r100.length() <= 0) goto L5;
                return true;
            L5:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GText copy$default(GText r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.value;
        }

        public final GText copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GText(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GText) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((GText) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "GText(value='" + this.value + "')";
        }

        public final String getValue() {
            return this.value;
        }

        public GText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            if (Intrinsics.areEqual(this.value, "null") == false) goto L7;
            return null;
        L7:
            return this.value;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTextValue;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "values", "", "(Ljava/util/List;)V", "getValues", "()Ljava/util/List;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GTextValue extends GaiaXExpression {
        public static final Companion Companion = null;
        private final List<GaiaXExpression> values;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTextValue$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GTextValue;", "expression", "", "isExpression", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final GTextValue create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                GTextValue r101 = new GTextValue(null, 1, 0 == true ? 1 : 0);
                Iterator r102 = StringsKt.split$default(r100, new String[]{" + "}, false, 0, 6, null).iterator();
            L4:
                if (r102.hasNext() == false) goto L6;
                String r103 = (String) r102.next();
                r101.getValues().add(GaiaXExpression.Companion.create(r103));
                goto L4
            L6:
                return r101;
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                if (StringsKt.startsWith$default(r100, "@", false, 2, null) == false) goto L5;
                return false;
            L5:
                if (StringsKt.contains$default(r100, " + ", false, 2, null) == false) goto L9;
                return true;
            L9:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GTextValue() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GTextValue copy$default(GTextValue r100, List r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.values;
        L6:
            return r100.copy(r101);
        }

        public final List<GaiaXExpression> component1() {
            return this.values;
        }

        public final GTextValue copy(List<GaiaXExpression> r100) {
            Intrinsics.checkNotNullParameter(r100, "values");
            return new GTextValue(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GTextValue) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.values, ((GTextValue) r100).values) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.values.hashCode();
        }

        public String toString() {
            return "GTextValue(values=" + this.values + ')';
        }

        public final List<GaiaXExpression> getValues() {
            return this.values;
        }

        public GTextValue(List<GaiaXExpression> r100) {
            Intrinsics.checkNotNullParameter(r100, "values");
            super(null);
            this.values = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            StringBuilder r101 = new StringBuilder();
            Iterator<T> r102 = this.values.iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            Object r103 = ((GaiaXExpression) r102.next()).desireData(r100);
            if (r103 == null) goto L4;
            r101.append(r103);
            goto L4
        L9:
            return r101.toString();
        }

        public /* synthetic */ GTextValue(List r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = new ArrayList();
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nHÖ\u0003J\b\u0010\u000f\u001a\u00020\nH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\nJ\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GValue;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "desireData", "", "rawJson", "equals", "", "other", "expression", "hashCode", "", "setData", "", PickerReporterConstants.KEY.TARGET, "toString", "Companion", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GValue extends GaiaXExpression {
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$GValue$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/adapter/GaiaXExpression$GValue;", "expression", "", "isExpression", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GValue create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                Matcher r101 = GaiaXExpression.Companion.getValueRegex().matcher(r100);     // Catch: Exception -> L5
            L6:
                boolean r102 = false;
                if (r101 != null) goto L9;
            L11:
                if (r102 == false) goto L15;
                return new GValue(r101.group(1));
            L15:
                return new GValue("");
            L9:
                if (r101.find() != true) goto L11;
                r102 = true;
            L5:
                r101 = null;
                goto L6
            }

            public final boolean isExpression(String r100) {
                Intrinsics.checkNotNullParameter(r100, "expression");
                Companion r101 = GaiaXExpression.Companion;     // Catch: Exception -> L14
                if (r101.getValueFullRegex().matcher(r100).find() == false) goto L20;
                Matcher r102 = r101.getValueRegex().matcher(r100);     // Catch: Exception -> L14
                int r103 = 0;
            L6:
                if (r102.find() == false) goto L11;
                r103 = r103 + 1;
                if (r103 < 2) goto L6;
            L11:
                if (r103 != 1) goto L21;
                return true;
            L21:
                return false;
            L20:
                return false;
            L22:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ GValue copy$default(GValue r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.value;
        }

        public final GValue copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new GValue(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GValue) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((GValue) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "GValue(value='" + this.value + "')";
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression, com.alibaba.gaiax.template.GXIExpression
        public Object expression() {
            return this.value;
        }

        public final String getValue() {
            return this.value;
        }

        public GValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return JsonExt.INSTANCE.getAnyExt(r100, this.value);
        }

        public final void setData(Object r100, Object r101) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            if (r100 == null) goto L6;
            JsonExt.INSTANCE.setValueExt(r100, this.value, r101);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$Self;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "()V", "desireData", "", "rawJson", "isExpression", "", "expression", "", "toString", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Self extends GaiaXExpression {
        public static final Self INSTANCE = null;

        static {
            INSTANCE = new Self();
        }

        private Self() {
            super(null);
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return r100;
        }

        public String toString() {
            return "Self()";
        }

        public final boolean isExpression(String r100) {
            Intrinsics.checkNotNullParameter(r100, "expression");
            return Intrinsics.areEqual("$$", r100);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/adapter/GaiaXExpression$Undefined;", "Lcom/alibaba/gaiax/adapter/GaiaXExpression;", "()V", "desireData", "", "rawJson", "toString", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Undefined extends GaiaXExpression {
        public static final Undefined INSTANCE = null;

        static {
            INSTANCE = new Undefined();
        }

        private Undefined() {
            super(null);
        }

        @Override // com.alibaba.gaiax.adapter.GaiaXExpression
        public Object desireData(Object r100) {
            return null;
        }

        public String toString() {
            return "Undefined()";
        }
    }

    private GaiaXExpression() {
    }

    public /* synthetic */ GaiaXExpression(DefaultConstructorMarker r100) {
        this();
    }

    public abstract Object desireData(Object r100);

    @Override // com.alibaba.gaiax.template.GXIExpression
    public Object expression() {
        return "";
    }

    static {
        Companion = new Companion(null);
        valueFullRegex = PatternProtector.compile("^\\$\\{(.*?)\\}$");
        valueRegex = PatternProtector.compile("\\$\\{(.*?)\\}");
    }

    public static final /* synthetic */ Pattern access$getValueFullRegex$cp() {
        return valueFullRegex;
    }

    public static final /* synthetic */ Pattern access$getValueRegex$cp() {
        return valueRegex;
    }

    @Override // com.alibaba.gaiax.template.GXIExpression
    public Object value(Object r100) {
        return desireData(r100);
    }

    public static /* synthetic */ Object desireData$default(GaiaXExpression r100, Object r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = null;
    L7:
        return r100.desireData(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: desireData");
    }
}
