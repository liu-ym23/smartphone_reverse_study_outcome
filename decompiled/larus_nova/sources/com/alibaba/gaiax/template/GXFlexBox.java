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
import com.alibaba.gaiax.template.utils.GXTemplateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import u.a;
import u.d;
import u.e;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b7\b\u0086\b\u0018\u0000 w2\u00020\u0001:\u0001wB\u00ad\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#\u0012\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bu\u0010vJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b!\u0010 J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#HÆ\u0003J\u0012\u0010'\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b'\u0010 J¶\u0002\u0010=\u001a\u00020\u00002\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#2\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#2\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b=\u0010>J\t\u0010@\u001a\u00020?HÖ\u0001J\t\u0010B\u001a\u00020AHÖ\u0001J\u0013\u0010D\u001a\u00020\u00022\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010(\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b(\u0010E\u001a\u0004\bF\u0010GR\u0019\u0010)\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b)\u0010H\u001a\u0004\bI\u0010JR\u0019\u0010*\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b*\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010+\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b+\u0010N\u001a\u0004\bO\u0010PR\u0019\u0010,\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b,\u0010Q\u001a\u0004\bR\u0010SR\u0019\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b-\u0010T\u001a\u0004\bU\u0010VR\u0019\u0010.\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b.\u0010W\u001a\u0004\bX\u0010YR\u0019\u0010/\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b/\u0010Z\u001a\u0004\b[\u0010\\R\u0019\u00100\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b0\u0010]\u001a\u0004\b^\u0010_R\u0019\u00101\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b1\u0010`\u001a\u0004\ba\u0010bR\u001f\u00102\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b2\u0010c\u001a\u0004\bd\u0010eR\u001f\u00103\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b3\u0010c\u001a\u0004\bf\u0010eR\u001f\u00104\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b4\u0010c\u001a\u0004\bg\u0010eR\u001f\u00105\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b5\u0010c\u001a\u0004\bh\u0010eR\u0019\u00106\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b6\u0010i\u001a\u0004\bj\u0010 R\u0019\u00107\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b7\u0010i\u001a\u0004\bk\u0010 R\u0019\u00108\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b8\u0010l\u001a\u0004\bm\u0010nR\u001f\u00109\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b9\u0010o\u001a\u0004\bp\u0010qR\u001f\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b:\u0010o\u001a\u0004\br\u0010qR\u001f\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b;\u0010o\u001a\u0004\bs\u0010qR\u0019\u0010<\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b<\u0010i\u001a\u0004\bt\u0010 ¨\u0006x"}, d2 = {"Lcom/alibaba/gaiax/template/GXFlexBox;", "", "", "isEmpty", "Lapp/visly/stretch/Display;", "component1", "Lapp/visly/stretch/PositionType;", "component2", "Lapp/visly/stretch/Direction;", "component3", "Lapp/visly/stretch/FlexDirection;", "component4", "Lapp/visly/stretch/FlexWrap;", "component5", "Lapp/visly/stretch/Overflow;", "component6", "Lapp/visly/stretch/AlignItems;", "component7", "Lapp/visly/stretch/AlignSelf;", "component8", "Lapp/visly/stretch/AlignContent;", "component9", "Lapp/visly/stretch/JustifyContent;", "component10", "Lu/d;", "Lu/a;", "component11", "component12", "component13", "component14", "", "component15", "()Ljava/lang/Float;", "component16", "component17", "Lu/e;", "component18", "component19", "component20", "component21", "display", "positionType", "direction", "flexDirection", "flexWrap", "overflow", "alignItems", "alignSelf", "alignContent", "justifyContent", "position", GXTemplateKey.FLEXBOX_MARGIN, GXTemplateKey.FLEXBOX_PADDING, "border", "flexGrow", "flexShrink", "flexBasis", "size", "minSize", "maxSize", "aspectRatio", "copy", "(Lapp/visly/stretch/Display;Lapp/visly/stretch/PositionType;Lapp/visly/stretch/Direction;Lapp/visly/stretch/FlexDirection;Lapp/visly/stretch/FlexWrap;Lapp/visly/stretch/Overflow;Lapp/visly/stretch/AlignItems;Lapp/visly/stretch/AlignSelf;Lapp/visly/stretch/AlignContent;Lapp/visly/stretch/JustifyContent;Lu/d;Lu/d;Lu/d;Lu/d;Ljava/lang/Float;Ljava/lang/Float;Lu/a;Lu/e;Lu/e;Lu/e;Ljava/lang/Float;)Lcom/alibaba/gaiax/template/GXFlexBox;", "", "toString", "", "hashCode", "other", "equals", "Lapp/visly/stretch/Display;", "getDisplay", "()Lapp/visly/stretch/Display;", "Lapp/visly/stretch/PositionType;", "getPositionType", "()Lapp/visly/stretch/PositionType;", "Lapp/visly/stretch/Direction;", "getDirection", "()Lapp/visly/stretch/Direction;", "Lapp/visly/stretch/FlexDirection;", "getFlexDirection", "()Lapp/visly/stretch/FlexDirection;", "Lapp/visly/stretch/FlexWrap;", "getFlexWrap", "()Lapp/visly/stretch/FlexWrap;", "Lapp/visly/stretch/Overflow;", "getOverflow", "()Lapp/visly/stretch/Overflow;", "Lapp/visly/stretch/AlignItems;", "getAlignItems", "()Lapp/visly/stretch/AlignItems;", "Lapp/visly/stretch/AlignSelf;", "getAlignSelf", "()Lapp/visly/stretch/AlignSelf;", "Lapp/visly/stretch/AlignContent;", "getAlignContent", "()Lapp/visly/stretch/AlignContent;", "Lapp/visly/stretch/JustifyContent;", "getJustifyContent", "()Lapp/visly/stretch/JustifyContent;", "Lu/d;", "getPosition", "()Lu/d;", "getMargin", "getPadding", "getBorder", "Ljava/lang/Float;", "getFlexGrow", "getFlexShrink", "Lu/a;", "getFlexBasis", "()Lu/a;", "Lu/e;", "getSize", "()Lu/e;", "getMinSize", "getMaxSize", "getAspectRatio", "<init>", "(Lapp/visly/stretch/Display;Lapp/visly/stretch/PositionType;Lapp/visly/stretch/Direction;Lapp/visly/stretch/FlexDirection;Lapp/visly/stretch/FlexWrap;Lapp/visly/stretch/Overflow;Lapp/visly/stretch/AlignItems;Lapp/visly/stretch/AlignSelf;Lapp/visly/stretch/AlignContent;Lapp/visly/stretch/JustifyContent;Lu/d;Lu/d;Lu/d;Lu/d;Ljava/lang/Float;Ljava/lang/Float;Lu/a;Lu/e;Lu/e;Lu/e;Ljava/lang/Float;)V", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class GXFlexBox {
    public static final Companion Companion = null;
    private final AlignContent alignContent;
    private final AlignItems alignItems;
    private final AlignSelf alignSelf;
    private final Float aspectRatio;
    private final d<a> border;
    private final Direction direction;
    private final Display display;
    private final a flexBasis;
    private final FlexDirection flexDirection;
    private final Float flexGrow;
    private final Float flexShrink;
    private final FlexWrap flexWrap;
    private final JustifyContent justifyContent;
    private final d<a> margin;
    private final e<a> maxSize;
    private final e<a> minSize;
    private final Overflow overflow;
    private final d<a> padding;
    private final d<a> position;
    private final PositionType positionType;
    private final e<a> size;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/template/GXFlexBox$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXFlexBox;", "lowPriorityStyle", "heightPriorityStyle", GXTemplateKey.GAIAX_CSS, "Lorg/json/JSONObject;", "createByExtend", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXFlexBox create(JSONObject r210) {
            Intrinsics.checkNotNullParameter(r210, GXTemplateKey.GAIAX_CSS);
            if (r210.length() <= 0) goto L5;
            GXFlexBoxConvert r100 = GXFlexBoxConvert.INSTANCE;
            Display r101 = r100.display(r210);
            PositionType r102 = r100.positionType(r210);
            Direction r103 = r100.direction(r210);
            FlexDirection r104 = r100.flexDirection(r210);
            FlexWrap r105 = r100.flexWrap(r210);
            Overflow r106 = r100.overflow(r210);
            AlignItems r107 = r100.alignItems(r210);
            AlignSelf r110 = r100.alignSelf(r210);
            AlignContent r111 = r100.alignContent(r210);
            JustifyContent r112 = r100.justifyContent(r210);
            d<a> r113 = r100.position(r210);
            d<a> r114 = r100.margin(r210);
            d<a> r115 = r100.padding(r210);
            d<a> r116 = r100.border(r210);
            a r117 = r100.flexBasis(r210);
            e<a> r211 = r100.size(r210);
            e<a> r212 = r100.minSize(r210);
            e<a> r213 = r100.maxSize(r210);
            Float r214 = r100.aspectRatio(r210);
            return new GXFlexBox(r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r100.flexGrow(r210), r100.flexShrink(r210), r117, r211, r212, r213, r214);
        L5:
            return new GXFlexBox(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        }

        public final GXFlexBox createByExtend(JSONObject r210) {
            Intrinsics.checkNotNullParameter(r210, GXTemplateKey.GAIAX_CSS);
            if (r210.length() <= 0) goto L5;
            GXFlexBoxConvert r100 = GXFlexBoxConvert.INSTANCE;
            Display r101 = r100.display(r210);
            PositionType r102 = r100.positionType(r210);
            Direction r103 = r100.direction(r210);
            FlexDirection r104 = r100.flexDirection(r210);
            FlexWrap r105 = r100.flexWrap(r210);
            Overflow r106 = r100.overflow(r210);
            AlignItems r107 = r100.alignItems(r210);
            AlignSelf r110 = r100.alignSelf(r210);
            AlignContent r111 = r100.alignContent(r210);
            JustifyContent r112 = r100.justifyContent(r210);
            d<a> r113 = r100.positionByExtend(r210);
            d<a> r114 = r100.margin(r210);
            d<a> r115 = r100.padding(r210);
            d<a> r116 = r100.border(r210);
            a r117 = r100.flexBasis(r210);
            e<a> r211 = r100.size(r210);
            e<a> r212 = r100.minSize(r210);
            e<a> r213 = r100.maxSize(r210);
            Float r214 = r100.aspectRatio(r210);
            return new GXFlexBox(r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r100.flexGrow(r210), r100.flexShrink(r210), r117, r211, r212, r213, r214);
        L5:
            return new GXFlexBox(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        }

        public final GXFlexBox create(GXFlexBox r210, GXFlexBox r211) {
            Intrinsics.checkNotNullParameter(r210, "lowPriorityStyle");
            Intrinsics.checkNotNullParameter(r211, "heightPriorityStyle");
            Display r100 = r211.getDisplay();
            if (r100 != null) goto L5;
            r100 = r210.getDisplay();
        L5:
            PositionType r101 = r211.getPositionType();
            if (r101 != null) goto L8;
            r101 = r210.getPositionType();
        L8:
            Direction r102 = r211.getDirection();
            if (r102 != null) goto L11;
            r102 = r210.getDirection();
        L11:
            FlexDirection r103 = r211.getFlexDirection();
            if (r103 != null) goto L14;
            r103 = r210.getFlexDirection();
        L14:
            FlexWrap r104 = r211.getFlexWrap();
            if (r104 != null) goto L17;
            r104 = r210.getFlexWrap();
        L17:
            Overflow r105 = r211.getOverflow();
            if (r105 != null) goto L20;
            r105 = r210.getOverflow();
        L20:
            AlignItems r106 = r211.getAlignItems();
            if (r106 != null) goto L23;
            r106 = r210.getAlignItems();
        L23:
            AlignSelf r110 = r211.getAlignSelf();
            if (r110 != null) goto L26;
            r110 = r210.getAlignSelf();
        L26:
            AlignContent r111 = r211.getAlignContent();
            if (r111 != null) goto L29;
            r111 = r210.getAlignContent();
        L29:
            JustifyContent r112 = r211.getJustifyContent();
            if (r112 != null) goto L32;
            r112 = r210.getJustifyContent();
        L32:
            GXTemplateUtils r113 = GXTemplateUtils.INSTANCE;
            d<a> r114 = r113.createRectDimensionByPriority(r211.getPosition(), r210.getPosition());
            d<a> r115 = r113.createRectDimensionByPriority(r211.getMargin(), r210.getMargin());
            d<a> r116 = r113.createRectDimensionByPriority(r211.getPadding(), r210.getPadding());
            d<a> r117 = r113.createRectDimensionByPriority(r211.getBorder(), r210.getBorder());
            Float r107 = r211.getFlexGrow();
            if (r107 != null) goto L35;
            r107 = r210.getFlexGrow();
        L35:
            Float r118 = r107;
            Float r108 = r211.getFlexShrink();
            if (r108 != null) goto L38;
            r108 = r210.getFlexShrink();
        L38:
            Float r119 = r108;
            a r109 = r211.getFlexBasis();
            if (r109 != null) goto L41;
            r109 = r210.getFlexBasis();
        L41:
            a r212 = r109;
            e<a> r213 = r113.createSizeDimensionByPriority(r211.getSize(), r210.getSize());
            e<a> r214 = r113.createSizeDimensionByPriority(r211.getMinSize(), r210.getMinSize());
            e<a> r215 = r113.createSizeDimensionByPriority(r211.getMaxSize(), r210.getMaxSize());
            Float r120 = r211.getAspectRatio();
            if (r120 != null) goto L44;
            r120 = r210.getAspectRatio();
        L44:
            Display r121 = r100;
            PositionType r122 = r101;
            Direction r123 = r102;
            FlexDirection r124 = r103;
            FlexWrap r125 = r104;
            Overflow r126 = r105;
            AlignItems r127 = r106;
            AlignSelf r128 = r110;
            AlignContent r129 = r111;
            JustifyContent r130 = r112;
            return new GXFlexBox(r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r114, r115, r116, r117, r118, r119, r212, r213, r214, r215, r120);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GXFlexBox() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GXFlexBox copy$default(GXFlexBox r110, Display r111, PositionType r112, Direction r210, FlexDirection r211, FlexWrap r212, Overflow r213, AlignItems r214, AlignSelf r215, AlignContent r216, JustifyContent r217, d r218, d r219, d r310, d r311, Float r312, Float r313, a r314, e r315, e r316, e r317, Float r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        Display r100 = r110.display;
    L7:
        if ((r319 & 2) == 0) goto L9;
        PositionType r101 = r110.positionType;
    L11:
        if ((r319 & 4) == 0) goto L13;
        Direction r102 = r110.direction;
    L15:
        if ((r319 & 8) == 0) goto L17;
        FlexDirection r103 = r110.flexDirection;
    L19:
        if ((r319 & 16) == 0) goto L21;
        FlexWrap r104 = r110.flexWrap;
    L23:
        if ((r319 & 32) == 0) goto L25;
        Overflow r105 = r110.overflow;
    L27:
        if ((r319 & 64) == 0) goto L29;
        AlignItems r106 = r110.alignItems;
    L31:
        if ((r319 & 128) == 0) goto L33;
        AlignSelf r107 = r110.alignSelf;
    L35:
        if ((r319 & 256) == 0) goto L37;
        AlignContent r113 = r110.alignContent;
    L39:
        if ((r319 & 512) == 0) goto L41;
        JustifyContent r114 = r110.justifyContent;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        d r115 = r110.position;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        d r116 = r110.margin;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        d r117 = r110.padding;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        d r118 = r110.border;
    L58:
        d r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        Float r119 = r110.flexGrow;
    L62:
        Float r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        Float r120 = r110.flexShrink;
    L66:
        Float r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        a r121 = r110.flexBasis;
    L70:
        a r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        e r122 = r110.size;
    L74:
        e r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        e r123 = r110.minSize;
    L78:
        e r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        e r124 = r110.maxSize;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        Float r108 = r110.aspectRatio;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Display component1() {
        return this.display;
    }

    public final JustifyContent component10() {
        return this.justifyContent;
    }

    public final d<a> component11() {
        return this.position;
    }

    public final d<a> component12() {
        return this.margin;
    }

    public final d<a> component13() {
        return this.padding;
    }

    public final d<a> component14() {
        return this.border;
    }

    public final Float component15() {
        return this.flexGrow;
    }

    public final Float component16() {
        return this.flexShrink;
    }

    public final a component17() {
        return this.flexBasis;
    }

    public final e<a> component18() {
        return this.size;
    }

    public final e<a> component19() {
        return this.minSize;
    }

    public final PositionType component2() {
        return this.positionType;
    }

    public final e<a> component20() {
        return this.maxSize;
    }

    public final Float component21() {
        return this.aspectRatio;
    }

    public final Direction component3() {
        return this.direction;
    }

    public final FlexDirection component4() {
        return this.flexDirection;
    }

    public final FlexWrap component5() {
        return this.flexWrap;
    }

    public final Overflow component6() {
        return this.overflow;
    }

    public final AlignItems component7() {
        return this.alignItems;
    }

    public final AlignSelf component8() {
        return this.alignSelf;
    }

    public final AlignContent component9() {
        return this.alignContent;
    }

    public final GXFlexBox copy(Display r210, PositionType r211, Direction r212, FlexDirection r213, FlexWrap r214, Overflow r215, AlignItems r310, AlignSelf r311, AlignContent r312, JustifyContent r313, d<a> r314, d<a> r315, d<a> r316, d<a> r317, Float r318, Float r319, a r410, e<a> r411, e<a> r412, e<a> r413, Float r414) {
        return new GXFlexBox(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXFlexBox) == true) goto L8;
        return false;
    L8:
        GXFlexBox r101 = (GXFlexBox) r100;
        if (this.display == r101.display) goto L12;
        return false;
    L12:
        if (this.positionType == r101.positionType) goto L15;
        return false;
    L15:
        if (this.direction == r101.direction) goto L18;
        return false;
    L18:
        if (this.flexDirection == r101.flexDirection) goto L21;
        return false;
    L21:
        if (this.flexWrap == r101.flexWrap) goto L24;
        return false;
    L24:
        if (this.overflow == r101.overflow) goto L27;
        return false;
    L27:
        if (this.alignItems == r101.alignItems) goto L30;
        return false;
    L30:
        if (this.alignSelf == r101.alignSelf) goto L33;
        return false;
    L33:
        if (this.alignContent == r101.alignContent) goto L36;
        return false;
    L36:
        if (this.justifyContent == r101.justifyContent) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.border, r101.border) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.flexGrow, r101.flexGrow) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.flexShrink, r101.flexShrink) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.flexBasis, r101.flexBasis) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.minSize, r101.minSize) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.maxSize, r101.maxSize) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.aspectRatio, r101.aspectRatio) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        Display r100 = this.display;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PositionType r104 = this.positionType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Direction r107 = this.direction;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        FlexDirection r110 = this.flexDirection;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        FlexWrap r113 = this.flexWrap;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Overflow r116 = this.overflow;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        AlignItems r119 = this.alignItems;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        AlignSelf r122 = this.alignSelf;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        AlignContent r125 = this.alignContent;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        JustifyContent r128 = this.justifyContent;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        d<a> r131 = this.position;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        d<a> r134 = this.margin;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        d<a> r137 = this.padding;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        d<a> r140 = this.border;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Float r143 = this.flexGrow;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Float r146 = this.flexShrink;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        a r149 = this.flexBasis;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        e<a> r152 = this.size;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        e<a> r155 = this.minSize;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        e<a> r158 = this.maxSize;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Float r161 = this.aspectRatio;
        if (r161 == null) goto L87;
        r101 = r161.hashCode();
    L87:
        return r160 + r101;
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GXFlexBox(display=" + this.display + ", positionType=" + this.positionType + ", direction=" + this.direction + ", flexDirection=" + this.flexDirection + ", flexWrap=" + this.flexWrap + ", overflow=" + this.overflow + ", alignItems=" + this.alignItems + ", alignSelf=" + this.alignSelf + ", alignContent=" + this.alignContent + ", justifyContent=" + this.justifyContent + ", position=" + this.position + ", margin=" + this.margin + ", padding=" + this.padding + ", border=" + this.border + ", flexGrow=" + this.flexGrow + ", flexShrink=" + this.flexShrink + ", flexBasis=" + this.flexBasis + ", size=" + this.size + ", minSize=" + this.minSize + ", maxSize=" + this.maxSize + ", aspectRatio=" + this.aspectRatio + ')';
    }

    public final boolean isEmpty() {
        if (this.display == null) goto L5;
    L45:
        return false;
    L5:
        if (this.positionType != null) goto L45;
        if (this.direction != null) goto L45;
        if (this.flexDirection != null) goto L45;
        if (this.flexWrap != null) goto L45;
        if (this.overflow != null) goto L45;
        if (this.alignItems != null) goto L45;
        if (this.alignSelf != null) goto L45;
        if (this.alignContent != null) goto L45;
        if (this.justifyContent != null) goto L45;
        if (this.position != null) goto L45;
        if (this.margin != null) goto L45;
        if (this.padding != null) goto L45;
        if (this.border != null) goto L45;
        if (this.flexGrow != null) goto L45;
        if (this.flexShrink != null) goto L45;
        if (this.flexBasis != null) goto L45;
        if (this.size != null) goto L45;
        if (this.minSize != null) goto L45;
        if (this.maxSize != null) goto L45;
        if (this.aspectRatio != null) goto L45;
        return true;
    }

    public final AlignContent getAlignContent() {
        return this.alignContent;
    }

    public final AlignItems getAlignItems() {
        return this.alignItems;
    }

    public final AlignSelf getAlignSelf() {
        return this.alignSelf;
    }

    public final Float getAspectRatio() {
        return this.aspectRatio;
    }

    public final d<a> getBorder() {
        return this.border;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final Display getDisplay() {
        return this.display;
    }

    public final a getFlexBasis() {
        return this.flexBasis;
    }

    public final FlexDirection getFlexDirection() {
        return this.flexDirection;
    }

    public final Float getFlexGrow() {
        return this.flexGrow;
    }

    public final Float getFlexShrink() {
        return this.flexShrink;
    }

    public final FlexWrap getFlexWrap() {
        return this.flexWrap;
    }

    public final JustifyContent getJustifyContent() {
        return this.justifyContent;
    }

    public final d<a> getMargin() {
        return this.margin;
    }

    public final e<a> getMaxSize() {
        return this.maxSize;
    }

    public final e<a> getMinSize() {
        return this.minSize;
    }

    public final Overflow getOverflow() {
        return this.overflow;
    }

    public final d<a> getPadding() {
        return this.padding;
    }

    public final d<a> getPosition() {
        return this.position;
    }

    public final PositionType getPositionType() {
        return this.positionType;
    }

    public final e<a> getSize() {
        return this.size;
    }

    public GXFlexBox(Display r100, PositionType r101, Direction r102, FlexDirection r103, FlexWrap r104, Overflow r105, AlignItems r106, AlignSelf r110, AlignContent r111, JustifyContent r112, d<a> r113, d<a> r114, d<a> r115, d<a> r116, Float r117, Float r118, a r119, e<a> r210, e<a> r211, e<a> r212, Float r213) {
        this.display = r100;
        this.positionType = r101;
        this.direction = r102;
        this.flexDirection = r103;
        this.flexWrap = r104;
        this.overflow = r105;
        this.alignItems = r106;
        this.alignSelf = r110;
        this.alignContent = r111;
        this.justifyContent = r112;
        this.position = r113;
        this.margin = r114;
        this.padding = r115;
        this.border = r116;
        this.flexGrow = r117;
        this.flexShrink = r118;
        this.flexBasis = r119;
        this.size = r210;
        this.minSize = r211;
        this.maxSize = r212;
        this.aspectRatio = r213;
    }

    public /* synthetic */ GXFlexBox(Display r210, PositionType r211, Direction r212, FlexDirection r213, FlexWrap r214, Overflow r215, AlignItems r216, AlignSelf r310, AlignContent r311, JustifyContent r312, d r313, d r314, d r315, d r316, Float r317, Float r318, a r319, e r410, e r411, e r412, Float r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        Display r100 = null;
    L7:
        if ((r414 & 2) == 0) goto L9;
        PositionType r101 = null;
    L11:
        if ((r414 & 4) == 0) goto L13;
        Direction r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        FlexDirection r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        FlexWrap r104 = null;
    L23:
        if ((r414 & 32) == 0) goto L25;
        Overflow r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        AlignItems r106 = null;
    L31:
        if ((r414 & 128) == 0) goto L33;
        AlignSelf r107 = null;
    L35:
        if ((r414 & 256) == 0) goto L37;
        AlignContent r110 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        JustifyContent r111 = null;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        d r112 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        d r113 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        d r114 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        d r115 = null;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        Float r108 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        Float r116 = null;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        a r117 = null;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        e r118 = null;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        e r119 = null;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        e r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        Float r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
