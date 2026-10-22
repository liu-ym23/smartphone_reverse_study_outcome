package com.alibaba.gaiax.template;

import android.content.Context;
import android.graphics.Color;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/template/GXColor;", "", "type", "", "value", "(ILjava/lang/Object;)V", "getType", "()I", "toString", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "valueCanNull", "(Landroid/content/Context;)Ljava/lang/Integer;", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXColor {
    public static final int COLOR_TYPE_DYNAMIC = 1;
    public static final int COLOR_TYPE_STATIC = 0;
    public static final Companion Companion = null;
    private static final GXColor UNDEFINE = null;
    private static final int UNDEFINE_COLOR = 0;
    private final int type;
    private final Object value;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/alibaba/gaiax/template/GXColor$Companion;", "", "()V", "COLOR_TYPE_DYNAMIC", "", "COLOR_TYPE_STATIC", "UNDEFINE", "Lcom/alibaba/gaiax/template/GXColor;", "UNDEFINE_COLOR", "create", "targetColor", "", "createHex", "color", "createUndefine", "hexColorARGBToRGBA", "argb", "hexColorRGBAToARGB", "rgba", "parseExtendColor", "parseHexColor", "(Ljava/lang/String;)Ljava/lang/Integer;", "parseHexPositionColor", "parseRGBAColor", "parseRGBColor", "parseSimpleColor", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXColor createUndefine() {
            return GXColor.access$getUNDEFINE$cp();
        }

        private final String parseExtendColor(String r100) {
            if ((!StringsKt.isBlank(r100)) == false) goto L5;
            return r100;
        L5:
            return null;
        }

        private final Integer parseHexColor(String r100) {
            if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L5;
            return null;
        L5:
            if (r100.length() != 9) goto L8;
            return Integer.valueOf(ColorProtector.parseColor("#" + r100.substring(7, r100.length()) + r100.substring(1, r100.length() - 2)));
        L8:
            return Integer.valueOf(ColorProtector.parseColor(r100));
        }

        private final Integer parseHexPositionColor(String r110) {
            if (StringsKt.startsWith$default(r110, "#", false, 2, null) == true) goto L5;
        L10:
            return null;
        L5:
            if (StringsKt.contains$default(r110, GXTemplateKey.GAIAX_PE, false, 2, null) == false) goto L10;
            List r111 = StringsKt.split$default(r110, new String[]{" "}, false, 0, 6, null);
            if (r111.size() != 2) goto L10;
            String r100 = (String) ListProtector.get(r111, 0);
            String r112 = (String) ListProtector.get(r111, 1);
            return parseHexColor(r100);
        }

        private final Integer parseRGBAColor(String r110) {
            if (StringsKt.startsWith$default(r110, "rgba(", false, 2, null) == true) goto L5;
        L8:
            return null;
        L5:
            if (StringsKt.endsWith$default(r110, ")", false, 2, null) == false) goto L8;
            List r111 = StringsKt.split$default(r110.substring(5, StringsKt.lastIndexOf$default(r110, ")", 0, false, 6, null)), new String[]{","}, false, 0, 6, null);
            return Integer.valueOf(Color.argb((int) (CastFloatProtector.parseFloat(StringsKt.trim((String) ListProtector.get(r111, 3)).toString()) * 255), CastIntegerProtector.parseInt(StringsKt.trim((String) ListProtector.get(r111, 0)).toString()), CastIntegerProtector.parseInt(StringsKt.trim((String) ListProtector.get(r111, 1)).toString()), CastIntegerProtector.parseInt(StringsKt.trim((String) ListProtector.get(r111, 2)).toString())));
        }

        private final Integer parseRGBColor(String r110) {
            if (StringsKt.startsWith$default(r110, "rgb(", false, 2, null) == true) goto L5;
        L8:
            return null;
        L5:
            if (StringsKt.endsWith$default(r110, ")", false, 2, null) == false) goto L8;
            List r111 = StringsKt.split$default(r110.substring(4, StringsKt.lastIndexOf$default(r110, ")", 0, false, 6, null)), new String[]{","}, false, 0, 6, null);
            return Integer.valueOf(Color.rgb(CastIntegerProtector.parseInt(StringsKt.trim((String) ListProtector.get(r111, 0)).toString()), CastIntegerProtector.parseInt(StringsKt.trim((String) ListProtector.get(r111, 1)).toString()), CastIntegerProtector.parseInt(StringsKt.trim((String) ListProtector.get(r111, 2)).toString())));
        }

        private final Integer parseSimpleColor(String r100) {
            if (StringsKt.equals(r100, "BLACK", true) == false) goto L6;
            return -16777216;
        L6:
            if (StringsKt.equals(r100, "DKGRAY", true) == false) goto L9;
            return Integer.valueOf(FakePickerAvatarCreator.DKGRAY);
        L9:
            if (StringsKt.equals(r100, "GRAY", true) == false) goto L12;
            return Integer.valueOf(FakePickerAvatarCreator.GRAY);
        L12:
            if (StringsKt.equals(r100, "LTGRAY", true) == false) goto L15;
            return Integer.valueOf(FakePickerAvatarCreator.LTGRAY);
        L15:
            if (StringsKt.equals(r100, "WHITE", true) == false) goto L18;
            return -1;
        L18:
            if (StringsKt.equals(r100, "RED", true) == false) goto L21;
            return -65536;
        L21:
            if (StringsKt.equals(r100, "GREEN", true) == false) goto L24;
            return Integer.valueOf(FakePickerAvatarCreator.GREEN);
        L24:
            if (StringsKt.equals(r100, "BLUE", true) == false) goto L27;
            return Integer.valueOf(FakePickerAvatarCreator.BLUE);
        L27:
            if (StringsKt.equals(r100, "YELLOW", true) == false) goto L30;
            return -256;
        L30:
            if (StringsKt.equals(r100, "CYAN", true) == false) goto L33;
            return Integer.valueOf(FakePickerAvatarCreator.CYAN);
        L33:
            if (StringsKt.equals(r100, "MAGENTA", true) == false) goto L36;
            return Integer.valueOf(FakePickerAvatarCreator.MAGENTA);
        L36:
            if (StringsKt.equals(r100, "TRANSPARENT", true) == true) goto L51;
            return null;
        L51:
            return 0;
        }

        public final GXColor create(String r110) {
            Intrinsics.checkNotNullParameter(r110, "targetColor");
            String r111 = StringsKt.trim(r110).toString();
            int r100 = 0;
            DefaultConstructorMarker r101 = null;
            if (StringsKt.contains$default(r111, GXTemplateKey.GAIAX_PE, false, 2, null) == false) goto L7;
            List r102 = StringsKt.split$default(r111, new String[]{" "}, false, 0, 6, null);
            if (r102.size() != 2) goto L7;
            r111 = (String) ListProtector.get(r102, 0);
        L7:
            Integer r103 = parseHexColor(r111);
            if (r103 != null) goto L10;
            Integer r104 = parseRGBAColor(r111);
            if (r104 != null) goto L14;
            Integer r105 = parseRGBColor(r111);
            if (r105 != null) goto L18;
            Integer r106 = parseSimpleColor(r111);
            if (r106 != null) goto L22;
            String r112 = parseExtendColor(r111);
            if (r112 != null) goto L26;
            return null;
        L26:
            return new GXColor(1, r112, r101);
        L22:
            return new GXColor(r100, Integer.valueOf(r106.intValue()), r101);
        L18:
            return new GXColor(r100, Integer.valueOf(r105.intValue()), r101);
        L14:
            return new GXColor(r100, Integer.valueOf(r104.intValue()), r101);
        L10:
            return new GXColor(r100, Integer.valueOf(r103.intValue()), r101);
        }

        public final GXColor createHex(String r100) {
            Intrinsics.checkNotNullParameter(r100, "color");
            Integer r101 = parseHexColor(r100);
            if (r101 == null) goto L7;
            int r102 = 0;
            return new GXColor(r102, Integer.valueOf(r101.intValue()), null);
        L7:
            throw new IllegalArgumentException("Create hex color error");
        }

        public final String hexColorARGBToRGBA(String r100) {
            Intrinsics.checkNotNullParameter(r100, "argb");
            if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L5;
            return null;
        L5:
            if (r100.length() != 9) goto L9;
            String r101 = r100.substring(1, 3);
            return "#" + r100.substring(3, r100.length()) + r101;
        L9:
            return r100;
        }

        public final String hexColorRGBAToARGB(String r100) {
            Intrinsics.checkNotNullParameter(r100, "rgba");
            if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L5;
            return null;
        L5:
            if (r100.length() == 9) goto L7;
            return r100;
        L7:
            return "#" + r100.substring(7, r100.length()) + r100.substring(1, r100.length() - 2);
        }
    }

    public /* synthetic */ GXColor(int r100, Object r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        Companion = new Companion(null);
        UNDEFINE = new GXColor(0, 0);
    }

    public String toString() {
        return "GXColor(type=" + this.type + ", value=" + this.value + ')';
    }

    public static final /* synthetic */ GXColor access$getUNDEFINE$cp() {
        return UNDEFINE;
    }

    public final int getType() {
        return this.type;
    }

    public final int value(Context r100) {
        Integer r101 = valueCanNull(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.intValue();
    }

    public final Integer valueCanNull(Context r100) {
        int r101 = this.type;
        if (r101 != 0) goto L7;
        Object r102 = this.value;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        return (Integer) r102;
    L7:
        if (r101 != 1) goto L14;
        GXRegisterCenterApi.GXIExtensionColor r103 = GXRegisterCenter.Companion.getInstance().getExtensionColor$GaiaX();
        if (r103 == null) goto L14;
        Object r104 = this.value;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.String");
        Integer r105 = r103.convert(r100, (String) r104);
        if (r105 == null) goto L14;
        return Integer.valueOf(r105.intValue());
    L14:
        return null;
    }

    private GXColor(int r100, Object r101) {
        this.type = r100;
        this.value = r101;
    }

    public static /* synthetic */ int value$default(GXColor r100, Context r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.value(r101);
    }

    public static /* synthetic */ Integer valueCanNull$default(GXColor r100, Context r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.valueCanNull(r101);
    }
}
