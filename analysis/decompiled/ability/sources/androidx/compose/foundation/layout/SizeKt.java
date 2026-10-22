package androidx.compose.foundation.layout;

import C7.r;
import S7.k;
import androidx.annotation.FloatRange;
import androidx.compose.foundation.b;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.WrapContentElement;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0015\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0016\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a*\u0010\u001a\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0011\u001a\u001e\u0010\u001e\u001a\u00020\f*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0019\u001a*\u0010 \u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0019\u001a&\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a>\u0010*\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001e\u0010/\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019\u001a*\u00101\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0019\u001a&\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u0010)\u001a>\u00106\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b7\u0010.\u001a\u001e\u0010%\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019\u001a*\u00109\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0011\u001a \u0010;\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010@\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020A2\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010B\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020?H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillElement;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "defaultMinSize", "Landroidx/compose/ui/Modifier;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fraction", "", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", "min", "max", "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", "size", "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "Landroidx/compose/ui/unit/DpSize;", "requiredSize-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "requiredSizeIn", "maxWidth", "maxHeight", "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "size-6HolHcs", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "wrapContentSize", "Landroidx/compose/ui/Alignment;", "wrapContentWidth", "Landroidx/compose/ui/Alignment$Horizontal;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SizeKt {
    private static final FillElement FillWholeMaxHeight;
    private static final FillElement FillWholeMaxSize;
    private static final FillElement FillWholeMaxWidth;
    private static final WrapContentElement WrapContentHeightCenter;
    private static final WrapContentElement WrapContentHeightTop;
    private static final WrapContentElement WrapContentSizeCenter;
    private static final WrapContentElement WrapContentSizeTopStart;
    private static final WrapContentElement WrapContentWidthCenter;
    private static final WrapContentElement WrapContentWidthStart;

    static {
        FillElement.Companion companion = FillElement.INSTANCE;
        FillWholeMaxWidth = companion.width(1.0f);
        FillWholeMaxHeight = companion.height(1.0f);
        FillWholeMaxSize = companion.size(1.0f);
        WrapContentElement.Companion companion2 = WrapContentElement.INSTANCE;
        Alignment.Companion companion3 = Alignment.INSTANCE;
        WrapContentWidthCenter = companion2.width(companion3.getCenterHorizontally(), false);
        WrapContentWidthStart = companion2.width(companion3.getStart(), false);
        WrapContentHeightCenter = companion2.height(companion3.getCenterVertically(), false);
        WrapContentHeightTop = companion2.height(companion3.getTop(), false);
        WrapContentSizeCenter = companion2.size(companion3.getCenter(), false);
        WrapContentSizeTopStart = companion2.size(companion3.getTopStart(), false);
    }

    @Stable
    /* renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m729defaultMinSizeVpY3zN4(Modifier modifier, float f, float f7) {
        return modifier.then(new UnspecifiedConstraintsElement(f, f7, null));
    }

    /* renamed from: defaultMinSize-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m730defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m729defaultMinSizeVpY3zN4(modifier, f, f7);
    }

    @Stable
    public static final Modifier fillMaxHeight(Modifier modifier, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxHeight : FillElement.INSTANCE.height(f));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxHeight(modifier, f);
    }

    @Stable
    public static final Modifier fillMaxSize(Modifier modifier, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxSize : FillElement.INSTANCE.size(f));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxSize(modifier, f);
    }

    @Stable
    public static final Modifier fillMaxWidth(Modifier modifier, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxWidth : FillElement.INSTANCE.width(f));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxWidth(modifier, f);
    }

    @Stable
    /* renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m731height3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("height");
                inspectorInfo.setValue(Dp.m6842boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    @Stable
    /* renamed from: heightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m732heightInVpY3zN4(Modifier modifier, final float f, final float f7) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f7, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("heightIn");
                b.j(f, inspectorInfo.getProperties(), "min", inspectorInfo).set("max", Dp.m6842boximpl(f7));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* renamed from: heightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m733heightInVpY3zN4$default(Modifier modifier, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m732heightInVpY3zN4(modifier, f, f7);
    }

    @Stable
    /* renamed from: requiredHeight-3ABfNKs, reason: not valid java name */
    public static final Modifier m734requiredHeight3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeight-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredHeight");
                inspectorInfo.setValue(Dp.m6842boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    @Stable
    /* renamed from: requiredHeightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m735requiredHeightInVpY3zN4(Modifier modifier, final float f, final float f7) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f7, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeightIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredHeightIn");
                b.j(f, inspectorInfo.getProperties(), "min", inspectorInfo).set("max", Dp.m6842boximpl(f7));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* renamed from: requiredHeightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m736requiredHeightInVpY3zN4$default(Modifier modifier, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m735requiredHeightInVpY3zN4(modifier, f, f7);
    }

    @Stable
    /* renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m737requiredSize3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, f, f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredSize");
                inspectorInfo.setValue(Dp.m6842boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    /* renamed from: requiredSize-6HolHcs, reason: not valid java name */
    public static final Modifier m738requiredSize6HolHcs(Modifier modifier, long j5) {
        return m739requiredSizeVpY3zN4(modifier, DpSize.m6942getWidthD9Ej5fM(j5), DpSize.m6940getHeightD9Ej5fM(j5));
    }

    @Stable
    /* renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m739requiredSizeVpY3zN4(Modifier modifier, final float f, final float f7) {
        return modifier.then(new SizeElement(f, f7, f, f7, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredSize");
                b.j(f, inspectorInfo.getProperties(), "width", inspectorInfo).set("height", Dp.m6842boximpl(f7));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    /* renamed from: requiredSizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m740requiredSizeInqDBjuR0(Modifier modifier, final float f, final float f7, final float f9, final float f10) {
        return modifier.then(new SizeElement(f, f7, f9, f10, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredSizeIn");
                b.j(f9, b.j(f7, b.j(f, inspectorInfo.getProperties(), "minWidth", inspectorInfo), "minHeight", inspectorInfo), "maxWidth", inspectorInfo).set("maxHeight", Dp.m6842boximpl(f10));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m741requiredSizeInqDBjuR0$default(Modifier modifier, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f9 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f10 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m740requiredSizeInqDBjuR0(modifier, f, f7, f9, f10);
    }

    @Stable
    /* renamed from: requiredWidth-3ABfNKs, reason: not valid java name */
    public static final Modifier m742requiredWidth3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidth-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredWidth");
                inspectorInfo.setValue(Dp.m6842boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    @Stable
    /* renamed from: requiredWidthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m743requiredWidthInVpY3zN4(Modifier modifier, final float f, final float f7) {
        return modifier.then(new SizeElement(f, 0.0f, f7, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidthIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredWidthIn");
                b.j(f, inspectorInfo.getProperties(), "min", inspectorInfo).set("max", Dp.m6842boximpl(f7));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* renamed from: requiredWidthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m744requiredWidthInVpY3zN4$default(Modifier modifier, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m743requiredWidthInVpY3zN4(modifier, f, f7);
    }

    @Stable
    /* renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m745size3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, f, f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("size");
                inspectorInfo.setValue(Dp.m6842boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    /* renamed from: size-6HolHcs, reason: not valid java name */
    public static final Modifier m746size6HolHcs(Modifier modifier, long j5) {
        return m747sizeVpY3zN4(modifier, DpSize.m6942getWidthD9Ej5fM(j5), DpSize.m6940getHeightD9Ej5fM(j5));
    }

    @Stable
    /* renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m747sizeVpY3zN4(Modifier modifier, final float f, final float f7) {
        return modifier.then(new SizeElement(f, f7, f, f7, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("size");
                b.j(f, inspectorInfo.getProperties(), "width", inspectorInfo).set("height", Dp.m6842boximpl(f7));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    /* renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m748sizeInqDBjuR0(Modifier modifier, final float f, final float f7, final float f9, final float f10) {
        return modifier.then(new SizeElement(f, f7, f9, f10, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("sizeIn");
                b.j(f9, b.j(f7, b.j(f, inspectorInfo.getProperties(), "minWidth", inspectorInfo), "minHeight", inspectorInfo), "maxWidth", inspectorInfo).set("maxHeight", Dp.m6842boximpl(f10));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m749sizeInqDBjuR0$default(Modifier modifier, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f9 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f10 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m748sizeInqDBjuR0(modifier, f, f7, f9, f10);
    }

    @Stable
    /* renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m750width3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("width");
                inspectorInfo.setValue(Dp.m6842boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    @Stable
    /* renamed from: widthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m751widthInVpY3zN4(Modifier modifier, final float f, final float f7) {
        return modifier.then(new SizeElement(f, 0.0f, f7, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("widthIn");
                b.j(f, inspectorInfo.getProperties(), "min", inspectorInfo).set("max", Dp.m6842boximpl(f7));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* renamed from: widthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m752widthInVpY3zN4$default(Modifier modifier, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f7 = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        return m751widthInVpY3zN4(modifier, f, f7);
    }

    @Stable
    public static final Modifier wrapContentHeight(Modifier modifier, Alignment.Vertical vertical, boolean z10) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return modifier.then((!kotlin.jvm.internal.k.b(vertical, companion.getCenterVertically()) || z10) ? (!kotlin.jvm.internal.k.b(vertical, companion.getTop()) || z10) ? WrapContentElement.INSTANCE.height(vertical, z10) : WrapContentHeightTop : WrapContentHeightCenter);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = Alignment.INSTANCE.getCenterVertically();
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        return wrapContentHeight(modifier, vertical, z10);
    }

    @Stable
    public static final Modifier wrapContentSize(Modifier modifier, Alignment alignment, boolean z10) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return modifier.then((!kotlin.jvm.internal.k.b(alignment, companion.getCenter()) || z10) ? (!kotlin.jvm.internal.k.b(alignment, companion.getTopStart()) || z10) ? WrapContentElement.INSTANCE.size(alignment, z10) : WrapContentSizeTopStart : WrapContentSizeCenter);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        return wrapContentSize(modifier, alignment, z10);
    }

    @Stable
    public static final Modifier wrapContentWidth(Modifier modifier, Alignment.Horizontal horizontal, boolean z10) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return modifier.then((!kotlin.jvm.internal.k.b(horizontal, companion.getCenterHorizontally()) || z10) ? (!kotlin.jvm.internal.k.b(horizontal, companion.getStart()) || z10) ? WrapContentElement.INSTANCE.width(horizontal, z10) : WrapContentWidthStart : WrapContentWidthCenter);
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = Alignment.INSTANCE.getCenterHorizontally();
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        return wrapContentWidth(modifier, horizontal, z10);
    }
}
