package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/Brush;", "", "<init>", "()V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "Companion", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/SolidColor;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Brush {
    public static final Companion Companion = null;
    private final long intrinsicSize;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0004\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0004\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0014J;\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019JY\u0010\u0015\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u001aJ;\u0010\u001b\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u0019JY\u0010\u001b\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u001aJY\u0010\u001f\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\"\u0010#J;\u0010\u001f\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\"\u0010$JE\u0010%\u001a\u00020\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b&\u0010'J'\u0010%\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b&\u0010(J'\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Landroidx/compose/ui/graphics/Brush$Companion;", "", "<init>", "()V", SVGRenderEngine.LINEAR_GRADIENT, "Landroidx/compose/ui/graphics/Brush;", "colorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "linearGradient-mHitzGk", "([Lkotlin/Pair;JJI)Landroidx/compose/ui/graphics/Brush;", "colors", "", "(Ljava/util/List;JJI)Landroidx/compose/ui/graphics/Brush;", "horizontalGradient", "startX", "endX", "horizontalGradient-8A-3gB4", "(Ljava/util/List;FFI)Landroidx/compose/ui/graphics/Brush;", "([Lkotlin/Pair;FFI)Landroidx/compose/ui/graphics/Brush;", "verticalGradient", "startY", "endY", "verticalGradient-8A-3gB4", SVGRenderEngine.RADIAL_GRADIENT, "center", "radius", "radialGradient-P_Vx-Ks", "([Lkotlin/Pair;JFI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JFI)Landroidx/compose/ui/graphics/Brush;", "sweepGradient", "sweepGradient-Uv8p0NA", "([Lkotlin/Pair;J)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;J)Landroidx/compose/ui/graphics/Brush;", "composite", "dstBrush", "srcBrush", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "composite-7EN7VTw", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Brush;I)Landroidx/compose/ui/graphics/Brush;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m4793sweepGradientUv8p0NA(Pair<Float, Color>[] r100, long r101) {
            int r102 = r100.length;
            ArrayList r103 = new ArrayList(r102);
            int r104 = 0;
            int r105 = 0;
        L3:
            if (r105 >= r102) goto L5;
            r103.add(Color.m4817boximpl(r100[r105].getSecond().m4837unboximpl()));
            r105 = r105 + 1;
            goto L3
        L5:
            int r106 = r100.length;
            ArrayList r107 = new ArrayList(r106);
        L6:
            if (r104 >= r106) goto L9;
            r107.add(Float.valueOf(r100[r104].getFirst().floatValue()));
            r104 = r104 + 1;
            goto L6
        L9:
            return new SweepGradient(r101, r103, r107, null);
        }

        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m4792sweepGradientUv8p0NA(List<Color> r100, long r101) {
            return new SweepGradient(r101, r100, null, null);
        }

        /* JADX INFO: renamed from: composite-7EN7VTw, reason: not valid java name */
        public final Brush m4785composite7EN7VTw(Brush r100, Brush r101, int r102) {
            return new CompositeShaderBrush(BrushKt.toShaderBrush(r100), BrushKt.toShaderBrush(r101), r102, null);
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m4787horizontalGradient8A3gB4(Pair<Float, Color>[] r110, float r111, float r112, int r113) {
            return m4789linearGradientmHitzGk((Pair[]) Arrays.copyOf(r110, r110.length), Offset.m4574constructorimpl((Float.floatToRawIntBits(r111) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & BodyPartID.bodyIdMax)), Offset.m4574constructorimpl((Float.floatToRawIntBits(r112) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & BodyPartID.bodyIdMax)), r113);
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m4789linearGradientmHitzGk(Pair<Float, Color>[] r110, long r111, long r112, int r113) {
            int r100 = r110.length;
            ArrayList r101 = new ArrayList(r100);
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r103 >= r100) goto L5;
            r101.add(Color.m4817boximpl(r110[r103].getSecond().m4837unboximpl()));
            r103 = r103 + 1;
            goto L3
        L5:
            int r104 = r110.length;
            ArrayList r105 = new ArrayList(r104);
        L6:
            if (r102 >= r104) goto L9;
            r105.add(Float.valueOf(r110[r102].getFirst().floatValue()));
            r102 = r102 + 1;
            goto L6
        L9:
            return new LinearGradient(r101, r105, r111, r112, r113, null);
        }

        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m4791radialGradientP_VxKs(Pair<Float, Color>[] r110, long r111, float r112, int r113) {
            int r100 = r110.length;
            ArrayList r101 = new ArrayList(r100);
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r103 >= r100) goto L5;
            r101.add(Color.m4817boximpl(r110[r103].getSecond().m4837unboximpl()));
            r103 = r103 + 1;
            goto L3
        L5:
            int r104 = r110.length;
            ArrayList r105 = new ArrayList(r104);
        L6:
            if (r102 >= r104) goto L9;
            r105.add(Float.valueOf(r110[r102].getFirst().floatValue()));
            r102 = r102 + 1;
            goto L6
        L9:
            return new RadialGradient(r101, r105, r111, r112, r113, null);
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m4795verticalGradient8A3gB4(Pair<Float, Color>[] r110, float r111, float r112, int r113) {
            return m4789linearGradientmHitzGk((Pair[]) Arrays.copyOf(r110, r110.length), Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (((long) Float.floatToRawIntBits(r111)) & BodyPartID.bodyIdMax)), Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(r112) & BodyPartID.bodyIdMax)), r113);
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m4786horizontalGradient8A3gB4(List<Color> r110, float r111, float r112, int r113) {
            return m4788linearGradientmHitzGk(r110, Offset.m4574constructorimpl((Float.floatToRawIntBits(r111) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & BodyPartID.bodyIdMax)), Offset.m4574constructorimpl((Float.floatToRawIntBits(r112) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & BodyPartID.bodyIdMax)), r113);
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m4788linearGradientmHitzGk(List<Color> r110, long r111, long r112, int r113) {
            return new LinearGradient(r110, null, r111, r112, r113, null);
        }

        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m4790radialGradientP_VxKs(List<Color> r110, long r111, float r112, int r113) {
            return new RadialGradient(r110, null, r111, r112, r113, null);
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m4794verticalGradient8A3gB4(List<Color> r110, float r111, float r112, int r113) {
            return m4788linearGradientmHitzGk(r110, Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (((long) Float.floatToRawIntBits(r111)) & BodyPartID.bodyIdMax)), Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (((long) Float.floatToRawIntBits(r112)) & BodyPartID.bodyIdMax)), r113);
        }

        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m4781sweepGradientUv8p0NA$default(Companion r100, List r101, long r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = Offset.Companion.m4597getUnspecifiedF1C5BW0();
        L6:
            return r100.m4792sweepGradientUv8p0NA(r101, r102);
        }

        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m4782sweepGradientUv8p0NA$default(Companion r100, Pair[] r101, long r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = Offset.Companion.m4597getUnspecifiedF1C5BW0();
        L6:
            return r100.m4793sweepGradientUv8p0NA(r101, r102);
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m4775horizontalGradient8A3gB4$default(Companion r100, List r101, float r102, float r103, int r104, int r105, Object r106) {
            if ((r105 & 2) == 0) goto L6;
            r102 = 0.0f;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = Float.POSITIVE_INFINITY;
        L9:
            if ((r105 & 8) == 0) goto L12;
            r104 = TileMode.Companion.m5226getClamp3opZhB0();
        L12:
            return r100.m4786horizontalGradient8A3gB4(r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m4777linearGradientmHitzGk$default(Companion r100, List r101, long r102, long r110, int r111, int r112, Object r113) {
            if ((r112 & 2) == 0) goto L5;
            r102 = Offset.Companion.m4598getZeroF1C5BW0();
        L5:
            long r103 = r102;
            if ((r112 & 4) == 0) goto L8;
            r110 = Offset.Companion.m4596getInfiniteF1C5BW0();
        L8:
            long r104 = r110;
            if ((r112 & 8) == 0) goto L12;
            r111 = TileMode.Companion.m5226getClamp3opZhB0();
        L12:
            return r100.m4788linearGradientmHitzGk(r101, r103, r104, r111);
        }

        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m4779radialGradientP_VxKs$default(Companion r100, List r101, long r102, float r110, int r111, int r112, Object r113) {
            if ((r112 & 2) == 0) goto L5;
            r102 = Offset.Companion.m4597getUnspecifiedF1C5BW0();
        L5:
            long r103 = r102;
            if ((r112 & 4) == 0) goto L8;
            float r104 = Float.POSITIVE_INFINITY;
        L10:
            if ((r112 & 8) == 0) goto L13;
            r111 = TileMode.Companion.m5226getClamp3opZhB0();
        L13:
            return r100.m4790radialGradientP_VxKs(r101, r103, r104, r111);
        L8:
            r104 = r110;
            goto L10
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m4783verticalGradient8A3gB4$default(Companion r100, List r101, float r102, float r103, int r104, int r105, Object r106) {
            if ((r105 & 2) == 0) goto L6;
            r102 = 0.0f;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = Float.POSITIVE_INFINITY;
        L9:
            if ((r105 & 8) == 0) goto L12;
            r104 = TileMode.Companion.m5226getClamp3opZhB0();
        L12:
            return r100.m4794verticalGradient8A3gB4(r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m4776horizontalGradient8A3gB4$default(Companion r100, Pair[] r101, float r102, float r103, int r104, int r105, Object r106) {
            if ((r105 & 2) == 0) goto L6;
            r102 = 0.0f;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = Float.POSITIVE_INFINITY;
        L9:
            if ((r105 & 8) == 0) goto L12;
            r104 = TileMode.Companion.m5226getClamp3opZhB0();
        L12:
            return r100.m4787horizontalGradient8A3gB4(r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m4778linearGradientmHitzGk$default(Companion r100, Pair[] r101, long r102, long r110, int r111, int r112, Object r113) {
            if ((r112 & 2) == 0) goto L5;
            r102 = Offset.Companion.m4598getZeroF1C5BW0();
        L5:
            long r103 = r102;
            if ((r112 & 4) == 0) goto L8;
            r110 = Offset.Companion.m4596getInfiniteF1C5BW0();
        L8:
            long r104 = r110;
            if ((r112 & 8) == 0) goto L12;
            r111 = TileMode.Companion.m5226getClamp3opZhB0();
        L12:
            return r100.m4789linearGradientmHitzGk(r101, r103, r104, r111);
        }

        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m4780radialGradientP_VxKs$default(Companion r100, Pair[] r101, long r102, float r110, int r111, int r112, Object r113) {
            if ((r112 & 2) == 0) goto L5;
            r102 = Offset.Companion.m4597getUnspecifiedF1C5BW0();
        L5:
            long r103 = r102;
            if ((r112 & 4) == 0) goto L8;
            float r104 = Float.POSITIVE_INFINITY;
        L10:
            if ((r112 & 8) == 0) goto L13;
            r111 = TileMode.Companion.m5226getClamp3opZhB0();
        L13:
            return r100.m4791radialGradientP_VxKs(r101, r103, r104, r111);
        L8:
            r104 = r110;
            goto L10
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m4784verticalGradient8A3gB4$default(Companion r100, Pair[] r101, float r102, float r103, int r104, int r105, Object r106) {
            if ((r105 & 2) == 0) goto L6;
            r102 = 0.0f;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = Float.POSITIVE_INFINITY;
        L9:
            if ((r105 & 8) == 0) goto L12;
            r104 = TileMode.Companion.m5226getClamp3opZhB0();
        L12:
            return r100.m4795verticalGradient8A3gB4(r101, r102, r103, r104);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ Brush(DefaultConstructorMarker r100) {
        this();
    }

    /* JADX INFO: renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo4773applyToPq9zytI(long r100, Paint r101, float r102);

    private Brush() {
        this.intrinsicSize = Size.Companion.m4659getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo4774getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }
}
