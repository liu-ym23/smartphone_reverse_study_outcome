package com.alibaba.gaiax.template;

import app.visly.stretch.AlignContent;
import app.visly.stretch.AlignItems;
import app.visly.stretch.AlignSelf;
import app.visly.stretch.Direction;
import app.visly.stretch.Display;
import app.visly.stretch.FlexDirection;
import app.visly.stretch.FlexWrap;
import app.visly.stretch.JustifyContent;
import app.visly.stretch.Overflow;
import app.visly.stretch.PositionType;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.ecom.arch.slice.render.SlcDisplay;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexWrap;
import com.bytedance.android.ecom.arch.slice.render.SlcPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import u.a;
import u.d;
import u.e;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b)\u0010*J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006+"}, d2 = {"Lcom/alibaba/gaiax/template/GXFlexBoxConvert;", "", "Lorg/json/JSONObject;", "cssJson", "Lu/e;", "Lu/a;", "size", "minSize", "maxSize", "Lapp/visly/stretch/Display;", "display", "Lapp/visly/stretch/PositionType;", "positionType", "Lapp/visly/stretch/Direction;", "direction", "Lapp/visly/stretch/FlexDirection;", "flexDirection", "Lapp/visly/stretch/FlexWrap;", "flexWrap", "Lapp/visly/stretch/Overflow;", "overflow", "Lapp/visly/stretch/AlignItems;", "alignItems", "Lapp/visly/stretch/AlignSelf;", "alignSelf", "Lapp/visly/stretch/AlignContent;", "alignContent", "Lapp/visly/stretch/JustifyContent;", "justifyContent", "", "flexGrow", "(Lorg/json/JSONObject;)Ljava/lang/Float;", "flexShrink", "flexBasis", "aspectRatio", "Lu/d;", GXTemplateKey.FLEXBOX_MARGIN, GXTemplateKey.FLEXBOX_PADDING, "border", "position", "positionByExtend", "<init>", "()V", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class GXFlexBoxConvert {
    public static final GXFlexBoxConvert INSTANCE = null;

    static {
        INSTANCE = new GXFlexBoxConvert();
    }

    private GXFlexBoxConvert() {
    }

    public final AlignContent alignContent(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_ALIGN_CONTENT);
        if (r101 != null) goto L5;
    L31:
        return null;
    L5:
        switch(r101.hashCode()) {
            case -1881872635: goto L28;
            case -1364013995: goto L24;
            case -46581362: goto L20;
            case 441309761: goto L16;
            case 1742952711: goto L12;
            case 1937124468: goto L8;
            default: goto L31;
        };
    L8:
        if (r101.equals("space-around") == false) goto L31;
        return AlignContent.SpaceAround;
    L12:
        if (r101.equals("flex-end") == false) goto L31;
        return AlignContent.FlexEnd;
    L16:
        if (r101.equals("space-between") == false) goto L31;
        return AlignContent.SpaceBetween;
    L20:
        if (r101.equals("flex-start") == false) goto L31;
        return AlignContent.FlexStart;
    L24:
        if (r101.equals("center") == false) goto L31;
        return AlignContent.Center;
    L28:
        if (r101.equals("stretch") == false) goto L31;
        return AlignContent.Stretch;
    }

    public final AlignItems alignItems(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_ALIGN_ITEMS);
        if (r101 != null) goto L5;
    L27:
        return null;
    L5:
        switch(r101.hashCode()) {
            case -1881872635: goto L24;
            case -1720785339: goto L20;
            case -1364013995: goto L16;
            case -46581362: goto L12;
            case 1742952711: goto L8;
            default: goto L27;
        };
    L8:
        if (r101.equals("flex-end") == false) goto L27;
        return AlignItems.FlexEnd;
    L12:
        if (r101.equals("flex-start") == false) goto L27;
        return AlignItems.FlexStart;
    L16:
        if (r101.equals("center") == false) goto L27;
        return AlignItems.Center;
    L20:
        if (r101.equals("baseline") == false) goto L27;
        return AlignItems.Baseline;
    L24:
        if (r101.equals("stretch") == false) goto L27;
        return AlignItems.Stretch;
    }

    public final AlignSelf alignSelf(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_ALIGN_SELF);
        if (r101 != null) goto L5;
    L31:
        return null;
    L5:
        switch(r101.hashCode()) {
            case -1881872635: goto L28;
            case -1720785339: goto L24;
            case -1364013995: goto L20;
            case -46581362: goto L16;
            case 3005871: goto L12;
            case 1742952711: goto L8;
            default: goto L31;
        };
    L8:
        if (r101.equals("flex-end") == false) goto L31;
        return AlignSelf.FlexEnd;
    L12:
        if (r101.equals("auto") == false) goto L31;
        return AlignSelf.Auto;
    L16:
        if (r101.equals("flex-start") == false) goto L31;
        return AlignSelf.FlexStart;
    L20:
        if (r101.equals("center") == false) goto L31;
        return AlignSelf.Center;
    L24:
        if (r101.equals("baseline") == false) goto L31;
        return AlignSelf.Baseline;
    L28:
        if (r101.equals("stretch") == false) goto L31;
        return AlignSelf.Stretch;
    }

    public final Float aspectRatio(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "cssJson");
        String r100 = r110.optString(GXTemplateKey.FLEXBOX_ASPECT_RATIO, null);
        if (r100 != null) goto L13;
    L11:
        return null;
    L13:
        return Float.valueOf(CastFloatProtector.parseFloat(r100));
    L15:
        if (StringsKt.contains$default(r100, ":", false, 2, null) == false) goto L11;
        List r111 = StringsKt.split$default(r100, new String[]{":"}, false, 0, 6, null);     // Catch: Exception -> L12
        return Float.valueOf(CastFloatProtector.parseFloat((String) ListProtector.get(r111, 0)) / CastFloatProtector.parseFloat((String) ListProtector.get(r111, 1)));
    }

    public final d<a> border(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString("border", null);
        if (r101 == null) goto L6;
        a r102 = GXSize.Companion.create(r101).getValueDimension();
        return new d(r102, r102, r102, r102);
    L6:
        String r103 = r100.optString(GXTemplateKey.FLEXBOX_BORDER_LEFT, null);
        String r104 = r100.optString(GXTemplateKey.FLEXBOX_BORDER_RIGHT, null);
        String r105 = r100.optString(GXTemplateKey.FLEXBOX_BORDER_TOP, null);
        String r106 = r100.optString(GXTemplateKey.FLEXBOX_BORDER_BOTTOM, null);
        boolean r107 = false;
        if (r103 != null) goto L9;
    L12:
        boolean r108 = true;
    L13:
        if (r108 == false) goto L35;
        if (r104 != null) goto L16;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L35;
        if (r105 != null) goto L23;
    L26:
        boolean r110 = true;
    L27:
        if (r110 == false) goto L35;
        if (r106 != null) goto L30;
    L31:
        r107 = true;
    L32:
        if (r107 == false) goto L35;
        return null;
    L30:
        if (r106.length() != 0) goto L32;
    L23:
        if (r105.length() == 0) goto L26;
        r110 = false;
        goto L27
    L16:
        if (r104.length() == 0) goto L19;
        r109 = false;
    L35:
        GXSize.Companion r111 = GXSize.Companion;
        if (r103 != null) goto L38;
        r103 = "";
    L38:
        a r112 = r111.create(r103).getValueDimension();
        if (r104 != null) goto L41;
        r104 = "";
    L41:
        a r113 = r111.create(r104).getValueDimension();
        if (r105 != null) goto L44;
        r105 = "";
    L44:
        a r114 = r111.create(r105).getValueDimension();
        if (r106 != null) goto L48;
        r106 = "";
    L48:
        return new d(r112, r113, r114, r111.create(r106).getValueDimension());
    L9:
        if (r103.length() == 0) goto L12;
        r108 = false;
        goto L13
    }

    public final Direction direction(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString("direction");
        if (r101 == null) goto L22;
        int r102 = r101.hashCode();
        if (r102 == 107498) goto L20;
        if (r102 == 1728122231) goto L16;
        if (r102 != 1946980603) goto L22;
        if (r101.equals("inherit") == false) goto L22;
        return Direction.Inherit;
    L16:
        if (r101.equals(SlcPosition.ABSOLUTE) == false) goto L22;
        return Direction.RTL;
    L20:
        if (r101.equals("ltr") == false) goto L22;
        return Direction.LTR;
    L22:
        return null;
    }

    public final Display display(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString("display");
        if (Intrinsics.areEqual(r101, SlcDisplay.FLEX) == false) goto L6;
        return Display.Flex;
    L6:
        if (Intrinsics.areEqual(r101, "none") == true) goto L11;
        return null;
    L11:
        return Display.None;
    }

    public final a flexBasis(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_FLEX_BASIS, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return GXSize.Companion.create(r101).getValueDimension();
    }

    public final FlexDirection flexDirection(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_FLEX_DIRECTION);
        if (r101 != null) goto L5;
    L23:
        return null;
    L5:
        switch(r101.hashCode()) {
            case -1448970769: goto L20;
            case -1354837162: goto L16;
            case 113114: goto L12;
            case 1272730475: goto L8;
            default: goto L23;
        };
    L8:
        if (r101.equals(SlcFlexDirection.FLEX_COLUMN_REVERSE) == false) goto L23;
        return FlexDirection.ColumnReverse;
    L12:
        if (r101.equals(SlcFlexDirection.FLEX_ROW) == false) goto L23;
        return FlexDirection.Row;
    L16:
        if (r101.equals("column") == false) goto L23;
        return FlexDirection.Column;
    L20:
        if (r101.equals(SlcFlexDirection.FLEX_ROW_REVERSE) == false) goto L23;
        return FlexDirection.RowReverse;
    }

    public final Float flexGrow(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_FLEX_GROW, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return Float.valueOf(CastFloatProtector.parseFloat(r101));
    }

    public final Float flexShrink(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_FLEX_SHRINK, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return Float.valueOf(CastFloatProtector.parseFloat(r101));
    }

    public final FlexWrap flexWrap(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_FLEX_WRAP);
        if (r101 == null) goto L23;
        int r102 = r101.hashCode();
        if (r102 == (-1039592053)) goto L20;
        if (r102 == (-749527969)) goto L16;
        if (r102 != 3657802) goto L23;
        if (r101.equals("wrap") == false) goto L23;
        return FlexWrap.Wrap;
    L16:
        if (r101.equals(SlcFlexWrap.WRAP_REVERSE) == false) goto L23;
        return FlexWrap.WrapReverse;
    L20:
        if (r101.equals(SlcFlexWrap.NOWRAP) == false) goto L23;
        return FlexWrap.NoWrap;
    L23:
        return null;
    }

    public final JustifyContent justifyContent(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_JUSTIFY_CONTENT);
        if (r101 != null) goto L5;
    L31:
        return null;
    L5:
        switch(r101.hashCode()) {
            case -1364013995: goto L28;
            case -46581362: goto L24;
            case 441309761: goto L20;
            case 1742952711: goto L16;
            case 1937124468: goto L12;
            case 2055030478: goto L8;
            default: goto L31;
        };
    L8:
        if (r101.equals("space-evenly") == false) goto L31;
        return JustifyContent.SpaceEvenly;
    L12:
        if (r101.equals("space-around") == false) goto L31;
        return JustifyContent.SpaceAround;
    L16:
        if (r101.equals("flex-end") == false) goto L31;
        return JustifyContent.FlexEnd;
    L20:
        if (r101.equals("space-between") == false) goto L31;
        return JustifyContent.SpaceBetween;
    L24:
        if (r101.equals("flex-start") == false) goto L31;
        return JustifyContent.FlexStart;
    L28:
        if (r101.equals("center") == false) goto L31;
        return JustifyContent.Center;
    }

    public final d<a> margin(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_MARGIN, null);
        if (r101 == null) goto L6;
        a r102 = GXSize.Companion.create(r101).getValueDimension();
        return new d(r102, r102, r102, r102);
    L6:
        String r103 = r100.optString(GXTemplateKey.FLEXBOX_MARGIN_LEFT, null);
        String r104 = r100.optString(GXTemplateKey.FLEXBOX_MARGIN_RIGHT, null);
        String r105 = r100.optString(GXTemplateKey.FLEXBOX_MARGIN_TOP, null);
        String r106 = r100.optString(GXTemplateKey.FLEXBOX_MARGIN_BOTTOM, null);
        boolean r107 = false;
        if (r103 != null) goto L9;
    L12:
        boolean r108 = true;
    L13:
        if (r108 == false) goto L35;
        if (r104 != null) goto L16;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L35;
        if (r105 != null) goto L23;
    L26:
        boolean r110 = true;
    L27:
        if (r110 == false) goto L35;
        if (r106 != null) goto L30;
    L31:
        r107 = true;
    L32:
        if (r107 == false) goto L35;
        return null;
    L30:
        if (r106.length() != 0) goto L32;
    L23:
        if (r105.length() == 0) goto L26;
        r110 = false;
        goto L27
    L16:
        if (r104.length() == 0) goto L19;
        r109 = false;
    L35:
        GXSize.Companion r111 = GXSize.Companion;
        if (r103 != null) goto L38;
        r103 = "";
    L38:
        a r112 = r111.create(r103).getValueDimension();
        if (r104 != null) goto L41;
        r104 = "";
    L41:
        a r113 = r111.create(r104).getValueDimension();
        if (r105 != null) goto L44;
        r105 = "";
    L44:
        a r114 = r111.create(r105).getValueDimension();
        if (r106 != null) goto L48;
        r106 = "";
    L48:
        return new d(r112, r113, r114, r111.create(r106).getValueDimension());
    L9:
        if (r103.length() == 0) goto L12;
        r108 = false;
        goto L13
    }

    public final e<a> maxSize(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_MAX_WIDTH, null);
        String r102 = r100.optString(GXTemplateKey.FLEXBOX_MAX_HEIGHT, null);
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        GXSize.Companion r103 = GXSize.Companion;
        return new e(r103.create(r101).getValueDimension(), r103.create(r102).getValueDimension());
    L6:
        if (r101 == null) goto L9;
        if (r102 != null) goto L9;
        return new e(GXSize.Companion.create(r101).getValueDimension(), GXSize.Auto.INSTANCE.getValueDimension());
    L9:
        if (r102 == null) goto L15;
        if (r101 == null) goto L12;
        return null;
    L12:
        return new e(GXSize.Auto.INSTANCE.getValueDimension(), GXSize.Companion.create(r102).getValueDimension());
    L15:
        return null;
    }

    public final e<a> minSize(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_MIN_WIDTH, null);
        String r102 = r100.optString(GXTemplateKey.FLEXBOX_MIN_HEIGHT, null);
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        GXSize.Companion r103 = GXSize.Companion;
        return new e(r103.create(r101).getValueDimension(), r103.create(r102).getValueDimension());
    L6:
        if (r101 == null) goto L9;
        if (r102 != null) goto L9;
        return new e(GXSize.Companion.create(r101).getValueDimension(), GXSize.Auto.INSTANCE.getValueDimension());
    L9:
        if (r102 == null) goto L15;
        if (r101 == null) goto L12;
        return null;
    L12:
        return new e(GXSize.Auto.INSTANCE.getValueDimension(), GXSize.Companion.create(r102).getValueDimension());
    L15:
        return null;
    }

    public final Overflow overflow(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString("overflow");
        if (r101 == null) goto L23;
        int r102 = r101.hashCode();
        if (r102 == (-1217487446)) goto L20;
        if (r102 == (-907680051)) goto L16;
        if (r102 != 466743410) goto L23;
        if (r101.equals("visible") == false) goto L23;
        return Overflow.Visible;
    L16:
        if (r101.equals(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L23;
        return Overflow.Scroll;
    L20:
        if (r101.equals("hidden") == false) goto L23;
        return Overflow.Hidden;
    L23:
        return null;
    }

    public final d<a> padding(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString(GXTemplateKey.FLEXBOX_PADDING, null);
        if (r101 == null) goto L6;
        a r102 = GXSize.Companion.create(r101).getValueDimension();
        return new d(r102, r102, r102, r102);
    L6:
        String r103 = r100.optString(GXTemplateKey.FLEXBOX_PADDING_LEFT, null);
        String r104 = r100.optString(GXTemplateKey.FLEXBOX_PADDING_RIGHT, null);
        String r105 = r100.optString(GXTemplateKey.FLEXBOX_PADDING_TOP, null);
        String r106 = r100.optString(GXTemplateKey.FLEXBOX_PADDING_BOTTOM, null);
        boolean r107 = false;
        if (r103 != null) goto L9;
    L12:
        boolean r108 = true;
    L13:
        if (r108 == false) goto L35;
        if (r104 != null) goto L16;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L35;
        if (r105 != null) goto L23;
    L26:
        boolean r110 = true;
    L27:
        if (r110 == false) goto L35;
        if (r106 != null) goto L30;
    L31:
        r107 = true;
    L32:
        if (r107 == false) goto L35;
        return null;
    L30:
        if (r106.length() != 0) goto L32;
    L23:
        if (r105.length() == 0) goto L26;
        r110 = false;
        goto L27
    L16:
        if (r104.length() == 0) goto L19;
        r109 = false;
    L35:
        GXSize.Companion r111 = GXSize.Companion;
        if (r103 != null) goto L38;
        r103 = "";
    L38:
        a r112 = r111.create(r103).getValueDimension();
        if (r104 != null) goto L41;
        r104 = "";
    L41:
        a r113 = r111.create(r104).getValueDimension();
        if (r105 != null) goto L44;
        r105 = "";
    L44:
        a r114 = r111.create(r105).getValueDimension();
        if (r106 != null) goto L48;
        r106 = "";
    L48:
        return new d(r112, r113, r114, r111.create(r106).getValueDimension());
    L9:
        if (r103.length() == 0) goto L12;
        r108 = false;
        goto L13
    }

    public final d<a> position(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        d<a> r101 = null;
        if (positionType(r100) != PositionType.Absolute) goto L44;
        String r102 = r100.optString("left", null);
        String r103 = r100.optString("right", null);
        String r104 = r100.optString("top", null);
        String r105 = r100.optString("bottom", null);
        boolean r106 = false;
        if (r102 != null) goto L7;
    L10:
        boolean r107 = true;
    L11:
        if (r107 == false) goto L31;
        if (r103 != null) goto L14;
    L17:
        boolean r108 = true;
    L18:
        if (r108 == false) goto L31;
        if (r104 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == false) goto L31;
        if (r105 != null) goto L28;
    L29:
        r106 = true;
    L30:
        if (r106 == true) goto L44;
    L28:
        if (r105.length() != 0) goto L30;
    L21:
        if (r104.length() == 0) goto L24;
        r109 = false;
        goto L25
    L14:
        if (r103.length() == 0) goto L17;
        r108 = false;
    L31:
        GXSize.Companion r110 = GXSize.Companion;
        if (r102 != null) goto L34;
        r102 = "";
    L34:
        a r111 = r110.create(r102).getValueDimension();
        if (r103 != null) goto L37;
        r103 = "";
    L37:
        a r112 = r110.create(r103).getValueDimension();
        if (r104 != null) goto L40;
        r104 = "";
    L40:
        a r113 = r110.create(r104).getValueDimension();
        if (r105 != null) goto L43;
        r105 = "";
    L43:
        r101 = new d(r111, r112, r113, r110.create(r105).getValueDimension());
        goto L44
    L7:
        if (r102.length() == 0) goto L10;
        r107 = false;
    L44:
        return r101;
    }

    public final d<a> positionByExtend(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString("left", null);
        String r102 = r100.optString("right", null);
        String r103 = r100.optString("top", null);
        String r104 = r100.optString("bottom", null);
        boolean r105 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L31;
        if (r102 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r107 == false) goto L31;
        if (r103 != null) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == false) goto L31;
        if (r104 != null) goto L26;
    L27:
        r105 = true;
    L28:
        if (r105 == false) goto L31;
        return null;
    L26:
        if (r104.length() != 0) goto L28;
    L19:
        if (r103.length() == 0) goto L22;
        r108 = false;
        goto L23
    L12:
        if (r102.length() == 0) goto L15;
        r107 = false;
    L31:
        GXSize.Companion r109 = GXSize.Companion;
        if (r101 != null) goto L34;
        r101 = "";
    L34:
        a r110 = r109.create(r101).getValueDimension();
        if (r102 != null) goto L37;
        r102 = "";
    L37:
        a r111 = r109.create(r102).getValueDimension();
        if (r103 != null) goto L40;
        r103 = "";
    L40:
        a r112 = r109.create(r103).getValueDimension();
        if (r104 != null) goto L44;
        r104 = "";
    L44:
        return new d(r110, r111, r112, r109.create(r104).getValueDimension());
    L5:
        if (r101.length() == 0) goto L8;
        r106 = false;
        goto L9
    }

    public final PositionType positionType(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString("position");
        if (Intrinsics.areEqual(r101, SlcPosition.RELATIVE) == false) goto L6;
        return PositionType.Relative;
    L6:
        if (Intrinsics.areEqual(r101, SlcPosition.ABSOLUTE) == true) goto L11;
        return null;
    L11:
        return PositionType.Absolute;
    }

    public final e<a> size(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "cssJson");
        String r101 = r100.optString("width", null);
        String r102 = r100.optString("height", null);
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        GXSize.Companion r103 = GXSize.Companion;
        return new e(r103.create(r101).getValueDimension(), r103.create(r102).getValueDimension());
    L6:
        if (r101 == null) goto L9;
        if (r102 != null) goto L9;
        return new e(GXSize.Companion.create(r101).getValueDimension(), GXSize.Auto.INSTANCE.getValueDimension());
    L9:
        if (r102 == null) goto L15;
        if (r101 == null) goto L12;
        return null;
    L12:
        return new e(GXSize.Auto.INSTANCE.getValueDimension(), GXSize.Companion.create(r102).getValueDimension());
    L15:
        return null;
    }
}
