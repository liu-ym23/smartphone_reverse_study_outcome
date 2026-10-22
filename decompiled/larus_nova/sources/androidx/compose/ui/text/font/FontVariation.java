package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005\u0015\u0004\u001e\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0013J1\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001b\"\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation;", "", "<init>", "()V", "Setting", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "name", "", "value", "", "italic", "opticalSizing", "textSize", "Landroidx/compose/ui/unit/TextUnit;", "opticalSizing--R2X_6o", "(J)Landroidx/compose/ui/text/font/FontVariation$Setting;", "slant", "width", "weight", "", "grade", "Settings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "settings", "", "Settings-6EWAqTQ", "(Landroidx/compose/ui/text/font/FontWeight;I[Landroidx/compose/ui/text/font/FontVariation$Setting;)Landroidx/compose/ui/text/font/FontVariation$Settings;", "SettingFloat", "SettingTextUnit", "SettingInt", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FontVariation {
    public static final int $stable = 0;
    public static final FontVariation INSTANCE = null;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0003\u000e\u000f\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$Setting;", "", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "axisName", "", "getAxisName", "()Ljava/lang/String;", "Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Setting {
        String getAxisName();

        boolean getNeedsDensity();

        float toVariationValue(Density r100);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0013\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "<init>", "(Ljava/lang/String;F)V", "getAxisName", "()Ljava/lang/String;", "getValue", "()F", "toVariationValue", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", "", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SettingFloat implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final float value;

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + Float.floatToIntBits(this.value);
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final float getValue() {
            return this.value;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SettingFloat) == true) goto L8;
            return false;
        L8:
            SettingFloat r101 = (SettingFloat) r100;
            if (Intrinsics.areEqual(getAxisName(), r101.getAxisName()) == true) goto L12;
            return false;
        L12:
            if (this.value != r101.value) goto L14;
            boolean r102 = true;
        L15:
            if (r102 == true) goto L17;
            return false;
        L17:
            return true;
        L14:
            r102 = false;
            goto L15
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(Density r100) {
            return this.value;
        }

        public SettingFloat(String r100, float r101) {
            this.axisName = r100;
            this.value = r101;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getAxisName", "()Ljava/lang/String;", "getValue", "()I", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SettingInt implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final int value;

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final int getValue() {
            return this.value;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SettingInt) == true) goto L8;
            return false;
        L8:
            SettingInt r101 = (SettingInt) r100;
            if (Intrinsics.areEqual(getAxisName(), r101.getAxisName()) == true) goto L12;
            return false;
        L12:
            if (this.value == r101.value) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(Density r100) {
            return this.value;
        }

        public SettingInt(String r100, int r101) {
            this.axisName = r100;
            this.value = r101;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0013\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "Landroidx/compose/ui/unit/TextUnit;", "<init>", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAxisName", "()Ljava/lang/String;", "getValue-XSAIIZE", "()J", "J", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "needsDensity", "", "getNeedsDensity", "()Z", "equals", "other", "", "hashCode", "", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SettingTextUnit implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final long value;

        public /* synthetic */ SettingTextUnit(String r100, long r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + TextUnit.m7749toStringimpl(this.value) + ')';
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + TextUnit.m7743hashCodeimpl(this.value);
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        /* JADX INFO: renamed from: getValue-XSAIIZE, reason: not valid java name */
        public final long m7136getValueXSAIIZE() {
            return this.value;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SettingTextUnit) == true) goto L8;
            return false;
        L8:
            SettingTextUnit r101 = (SettingTextUnit) r100;
            if (Intrinsics.areEqual(getAxisName(), r101.getAxisName()) == true) goto L12;
            return false;
        L12:
            if (TextUnit.m7739equalsimpl0(this.value, r101.value) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(Density r100) {
            if (r100 != null) goto L4;
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("density must not be null");
            throw new KotlinNothingValueException();
        L4:
            return TextUnit.m7742getValueimpl(this.value) * r100.getFontScale();
        }

        private SettingTextUnit(String r100, long r101) {
            this.axisName = r100;
            this.value = r101;
            this.needsDensity = true;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$Settings;", "", "settings", "", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "<init>", "([Landroidx/compose/ui/text/font/FontVariation$Setting;)V", "", "getSettings", "()Ljava/util/List;", "needsDensity", "", "getNeedsDensity$ui_text", "()Z", "equals", "other", "hashCode", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Settings {
        public static final int $stable = 0;
        private final boolean needsDensity;
        private final List<Setting> settings;

        public int hashCode() {
            return this.settings.hashCode();
        }

        public final boolean getNeedsDensity$ui_text() {
            return this.needsDensity;
        }

        public final List<Setting> getSettings() {
            return this.settings;
        }

        public Settings(Setting... r110) {
            LinkedHashMap r100 = new LinkedHashMap();
            int r101 = r110.length;
            boolean r102 = false;
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L8;
            Setting r104 = r110[r103];
            String r105 = r104.getAxisName();
            Object r106 = r100.get(r105);
            if (r106 != null) goto L7;
            r106 = new ArrayList();
            r100.put(r105, r106);
        L7:
            ((List) r106).add(r104);
            r103 = r103 + 1;
            goto L3
        L8:
            ArrayList r111 = new ArrayList();
            Iterator r107 = r100.entrySet().iterator();
        L9:
            boolean r108 = true;
            if (r107.hasNext() == false) goto L19;
            Map.Entry r109 = (Map.Entry) r107.next();
            String r112 = (String) r109.getKey();
            List r113 = (List) r109.getValue();
            if (r113.size() == 1) goto L15;
            r108 = false;
        L15:
            if (r108 == false) goto L18;
            CollectionsKt.addAll(r111, r113);
            goto L9
        L18:
            throw new IllegalArgumentException(("'" + r112 + "' must be unique. Actual [ [" + CollectionsKt.joinToString$default(r113, null, null, null, 0, null, null, 63, null) + ']').toString());
        L19:
            ArrayList r114 = new ArrayList(r111);
            this.settings = r114;
            int r115 = r114.size();
            int r116 = 0;
        L20:
            if (r116 >= r115) goto L25;
            if (((Setting) ListProtector.get(r114, r116)).getNeedsDensity() == true) goto L23;
            r116 = r116 + 1;
            goto L20
        L23:
            r102 = true;
        L25:
            this.needsDensity = r102;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Settings) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.settings, ((Settings) r100).settings) == true) goto L11;
            return false;
        L11:
            return true;
        }
    }

    static {
        INSTANCE = new FontVariation();
    }

    private FontVariation() {
    }

    public final Setting grade(int r100) {
        boolean r101 = false;
        if ((-1000) <= r100) goto L5;
    L7:
        if (r101 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("'GRAD' must be in -1000..1000");
    L10:
        return new SettingInt("GRAD", r100);
    L5:
        if (r100 >= 1001) goto L7;
        r101 = true;
        goto L7
    }

    public final Setting italic(float r100) {
        boolean r101 = false;
        if (0.0f <= r100) goto L5;
    L7:
        if (r101 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("'ital' must be in 0.0f..1.0f. Actual: " + r100);
    L10:
        return new SettingFloat("ital", r100);
    L5:
        if (r100 > 1.0f) goto L7;
        r101 = true;
        goto L7
    }

    /* JADX INFO: renamed from: opticalSizing--R2X_6o, reason: not valid java name */
    public final Setting m7135opticalSizingR2X_6o(long r100) {
        if (TextUnit.m7745isSpimpl(r100) == true) goto L6;
        InlineClassHelperKt.throwIllegalArgumentException("'opsz' must be provided in sp units");
    L6:
        return new SettingTextUnit("opsz", r100, null);
    }

    public final Setting slant(float r100) {
        boolean r101 = false;
        if ((-90.0f) <= r100) goto L5;
    L7:
        if (r101 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("'slnt' must be in -90f..90f. Actual: " + r100);
    L10:
        return new SettingFloat("slnt", r100);
    L5:
        if (r100 > 90.0f) goto L7;
        r101 = true;
        goto L7
    }

    public final Setting weight(int r100) {
        boolean r101 = false;
        if (1 <= r100) goto L5;
    L7:
        if (r101 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("'wght' value must be in [1, 1000]. Actual: " + r100);
    L10:
        return new SettingInt("wght", r100);
    L5:
        if (r100 >= 1001) goto L7;
        r101 = true;
        goto L7
    }

    public final Setting width(float r100) {
        if (r100 <= 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("'wdth' must be strictly > 0.0f. Actual: " + r100);
    L9:
        return new SettingFloat("wdth", r100);
    L5:
        r101 = false;
        goto L6
    }

    public final Setting Setting(String r100, float r101) {
        if (r100.length() != 4) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("Name must be exactly four characters. Actual: '" + r100 + '\'');
    L9:
        return new SettingFloat(r100, r101);
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: Settings-6EWAqTQ, reason: not valid java name */
    public final Settings m7134Settings6EWAqTQ(FontWeight r100, int r101, Setting... r102) {
        SpreadBuilder r103 = new SpreadBuilder(3);
        r103.add(weight(r100.getWeight()));
        r103.add(italic(r101));
        r103.addSpread(r102);
        return new Settings((Setting[]) r103.toArray(new Setting[r103.size()]));
    }
}
