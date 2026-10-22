package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/Brush;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/graphics/Paint;", "p", "", "alpha", "LC7/r;", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "applyTo", "intrinsicSize", "J", "getIntrinsicSize-NH-jbRc", "()J", "Companion", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/SolidColor;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Brush {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long intrinsicSize;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0004\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0004\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0014J;\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019JY\u0010\u0015\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u001aJ;\u0010\u001b\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u0019JY\u0010\u001b\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u001aJY\u0010\u001f\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\"\u0010#J;\u0010\u001f\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\"\u0010$JE\u0010%\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b&\u0010'J'\u0010%\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b&\u0010(J'\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Landroidx/compose/ui/graphics/Brush$Companion;", "", AppAgent.CONSTRUCT, "()V", "linearGradient", "Landroidx/compose/ui/graphics/Brush;", "colorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "linearGradient-mHitzGk", "([Lkotlin/Pair;JJI)Landroidx/compose/ui/graphics/Brush;", "colors", "", "(Ljava/util/List;JJI)Landroidx/compose/ui/graphics/Brush;", "horizontalGradient", "startX", "endX", "horizontalGradient-8A-3gB4", "(Ljava/util/List;FFI)Landroidx/compose/ui/graphics/Brush;", "([Lkotlin/Pair;FFI)Landroidx/compose/ui/graphics/Brush;", "verticalGradient", "startY", "endY", "verticalGradient-8A-3gB4", "radialGradient", "center", "radius", "radialGradient-P_Vx-Ks", "([Lkotlin/Pair;JFI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JFI)Landroidx/compose/ui/graphics/Brush;", "sweepGradient", "sweepGradient-Uv8p0NA", "([Lkotlin/Pair;J)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;J)Landroidx/compose/ui/graphics/Brush;", "composite", "dstBrush", "srcBrush", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "composite-7EN7VTw", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Brush;I)Landroidx/compose/ui/graphics/Brush;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m4087horizontalGradient8A3gB4$default(Companion companion, List list, float f, float f7, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                f = 0.0f;
            }
            if ((i6 & 4) != 0) {
                f7 = Float.POSITIVE_INFINITY;
            }
            if ((i6 & 8) != 0) {
                i = TileMode.INSTANCE.m4528getClamp3opZhB0();
            }
            return companion.m4098horizontalGradient8A3gB4((List<Color>) list, f, f7, i);
        }

        /* renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m4090linearGradientmHitzGk$default(Companion companion, Pair[] pairArr, long j5, long j6, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                j5 = Offset.INSTANCE.m3911getZeroF1C5BW0();
            }
            long j10 = j5;
            if ((i6 & 4) != 0) {
                j6 = Offset.INSTANCE.m3909getInfiniteF1C5BW0();
            }
            long j11 = j6;
            if ((i6 & 8) != 0) {
                i = TileMode.INSTANCE.m4528getClamp3opZhB0();
            }
            return companion.m4101linearGradientmHitzGk((Pair<Float, Color>[]) pairArr, j10, j11, i);
        }

        /* renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m4092radialGradientP_VxKs$default(Companion companion, Pair[] pairArr, long j5, float f, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                j5 = Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
            }
            long j6 = j5;
            if ((i6 & 4) != 0) {
                f = Float.POSITIVE_INFINITY;
            }
            float f7 = f;
            if ((i6 & 8) != 0) {
                i = TileMode.INSTANCE.m4528getClamp3opZhB0();
            }
            return companion.m4103radialGradientP_VxKs((Pair<Float, Color>[]) pairArr, j6, f7, i);
        }

        /* renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m4094sweepGradientUv8p0NA$default(Companion companion, Pair[] pairArr, long j5, int i, Object obj) {
            if ((i & 2) != 0) {
                j5 = Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
            }
            return companion.m4105sweepGradientUv8p0NA((Pair<Float, Color>[]) pairArr, j5);
        }

        /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m4095verticalGradient8A3gB4$default(Companion companion, List list, float f, float f7, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                f = 0.0f;
            }
            if ((i6 & 4) != 0) {
                f7 = Float.POSITIVE_INFINITY;
            }
            if ((i6 & 8) != 0) {
                i = TileMode.INSTANCE.m4528getClamp3opZhB0();
            }
            return companion.m4106verticalGradient8A3gB4((List<Color>) list, f, f7, i);
        }

        @Stable
        /* renamed from: composite-7EN7VTw, reason: not valid java name */
        public final Brush m4097composite7EN7VTw(Brush dstBrush, Brush srcBrush, int blendMode) {
            return new CompositeShaderBrush(BrushKt.toShaderBrush(dstBrush), BrushKt.toShaderBrush(srcBrush), blendMode, null);
        }

        @Stable
        /* renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m4099horizontalGradient8A3gB4(Pair<Float, Color>[] colorStops, float startX, float endX, int tileMode) {
            return m4101linearGradientmHitzGk((Pair<Float, Color>[]) Arrays.copyOf(colorStops, colorStops.length), Offset.m3887constructorimpl((Float.floatToRawIntBits(startX) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), Offset.m3887constructorimpl((Float.floatToRawIntBits(endX) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), tileMode);
        }

        @Stable
        /* renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m4101linearGradientmHitzGk(Pair<Float, Color>[] colorStops, long start, long end, int tileMode) {
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair : colorStops) {
                arrayList.add(Color.m4129boximpl(((Color) pair.b).m4149unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair2 : colorStops) {
                arrayList2.add(Float.valueOf(((Number) pair2.f4886a).floatValue()));
            }
            return new LinearGradient(arrayList, arrayList2, start, end, tileMode, null);
        }

        @Stable
        /* renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m4103radialGradientP_VxKs(Pair<Float, Color>[] colorStops, long center, float radius, int tileMode) {
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair : colorStops) {
                arrayList.add(Color.m4129boximpl(((Color) pair.b).m4149unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair2 : colorStops) {
                arrayList2.add(Float.valueOf(((Number) pair2.f4886a).floatValue()));
            }
            return new RadialGradient(arrayList, arrayList2, center, radius, tileMode, null);
        }

        @Stable
        /* renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m4105sweepGradientUv8p0NA(Pair<Float, Color>[] colorStops, long center) {
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair : colorStops) {
                arrayList.add(Color.m4129boximpl(((Color) pair.b).m4149unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(colorStops.length);
            for (Pair<Float, Color> pair2 : colorStops) {
                arrayList2.add(Float.valueOf(((Number) pair2.f4886a).floatValue()));
            }
            return new SweepGradient(center, arrayList, arrayList2, null);
        }

        @Stable
        /* renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m4107verticalGradient8A3gB4(Pair<Float, Color>[] colorStops, float startY, float endY, int tileMode) {
            return m4101linearGradientmHitzGk((Pair<Float, Color>[]) Arrays.copyOf(colorStops, colorStops.length), Offset.m3887constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(startY) & 4294967295L)), Offset.m3887constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(endY) & 4294967295L)), tileMode);
        }

        private Companion() {
        }

        /* renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m4088horizontalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f, float f7, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                f = 0.0f;
            }
            if ((i6 & 4) != 0) {
                f7 = Float.POSITIVE_INFINITY;
            }
            if ((i6 & 8) != 0) {
                i = TileMode.INSTANCE.m4528getClamp3opZhB0();
            }
            return companion.m4099horizontalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f, f7, i);
        }

        /* renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m4093sweepGradientUv8p0NA$default(Companion companion, List list, long j5, int i, Object obj) {
            if ((i & 2) != 0) {
                j5 = Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
            }
            return companion.m4104sweepGradientUv8p0NA((List<Color>) list, j5);
        }

        /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m4096verticalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f, float f7, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                f = 0.0f;
            }
            if ((i6 & 4) != 0) {
                f7 = Float.POSITIVE_INFINITY;
            }
            if ((i6 & 8) != 0) {
                i = TileMode.INSTANCE.m4528getClamp3opZhB0();
            }
            return companion.m4107verticalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f, f7, i);
        }

        /* renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m4091radialGradientP_VxKs$default(Companion companion, List list, long j5, float f, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                j5 = Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
            }
            long j6 = j5;
            if ((i6 & 4) != 0) {
                f = Float.POSITIVE_INFINITY;
            }
            float f7 = f;
            if ((i6 & 8) != 0) {
                i = TileMode.INSTANCE.m4528getClamp3opZhB0();
            }
            return companion.m4102radialGradientP_VxKs((List<Color>) list, j6, f7, i);
        }

        /* renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m4089linearGradientmHitzGk$default(Companion companion, List list, long j5, long j6, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                j5 = Offset.INSTANCE.m3911getZeroF1C5BW0();
            }
            long j10 = j5;
            if ((i6 & 4) != 0) {
                j6 = Offset.INSTANCE.m3909getInfiniteF1C5BW0();
            }
            long j11 = j6;
            if ((i6 & 8) != 0) {
                i = TileMode.INSTANCE.m4528getClamp3opZhB0();
            }
            return companion.m4100linearGradientmHitzGk((List<Color>) list, j10, j11, i);
        }

        @Stable
        /* renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m4100linearGradientmHitzGk(List<Color> colors, long start, long end, int tileMode) {
            return new LinearGradient(colors, null, start, end, tileMode, null);
        }

        @Stable
        /* renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m4102radialGradientP_VxKs(List<Color> colors, long center, float radius, int tileMode) {
            return new RadialGradient(colors, null, center, radius, tileMode, null);
        }

        @Stable
        /* renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m4104sweepGradientUv8p0NA(List<Color> colors, long center) {
            return new SweepGradient(center, colors, null, null);
        }

        @Stable
        /* renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m4098horizontalGradient8A3gB4(List<Color> colors, float startX, float endX, int tileMode) {
            return m4100linearGradientmHitzGk(colors, Offset.m3887constructorimpl((Float.floatToRawIntBits(startX) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), Offset.m3887constructorimpl((Float.floatToRawIntBits(endX) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), tileMode);
        }

        @Stable
        /* renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m4106verticalGradient8A3gB4(List<Color> colors, float startY, float endY, int tileMode) {
            return m4100linearGradientmHitzGk(colors, Offset.m3887constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(startY) & 4294967295L)), Offset.m3887constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(endY) & 4294967295L)), tileMode);
        }
    }

    public /* synthetic */ Brush(e eVar) {
        this();
    }

    /* renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo4085applyToPq9zytI(long size, Paint p, float alpha);

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name and from getter */
    public long getIntrinsicSize() {
        return this.intrinsicSize;
    }

    private Brush() {
        this.intrinsicSize = Size.INSTANCE.m3972getUnspecifiedNHjbRc();
    }
}
