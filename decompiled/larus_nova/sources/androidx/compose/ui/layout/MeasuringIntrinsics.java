package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÂ\u0002\u0018\u00002\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005J&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics;", "", "<init>", "()V", "minWidth", "", "modifier", "Landroidx/compose/ui/layout/LayoutModifier;", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "h", "minHeight", "w", "maxWidth", "maxHeight", "DefaultIntrinsicMeasurable", "EmptyPlaceable", "IntrinsicMinMax", "IntrinsicWidthHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MeasuringIntrinsics {
    public static final MeasuringIntrinsics INSTANCE = null;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "<init>", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getMinMax", "()Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "getWidthHeight", "()Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicWidth", "", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultIntrinsicMeasurable implements Measurable {
        private final IntrinsicMeasurable measurable;
        private final IntrinsicMinMax minMax;
        private final IntrinsicWidthHeight widthHeight;

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.measurable.getParentData();
        }

        public final IntrinsicMeasurable getMeasurable() {
            return this.measurable;
        }

        public final IntrinsicMinMax getMinMax() {
            return this.minMax;
        }

        public final IntrinsicWidthHeight getWidthHeight() {
            return this.widthHeight;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int r100) {
            return this.measurable.maxIntrinsicHeight(r100);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int r100) {
            return this.measurable.maxIntrinsicWidth(r100);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* JADX INFO: renamed from: measure-BRTryo0 */
        public Placeable mo6256measureBRTryo0(long r100) {
            int r101 = 32767;
            if (this.widthHeight != IntrinsicWidthHeight.Width) goto L14;
            if (this.minMax != IntrinsicMinMax.Max) goto L7;
            int r102 = this.measurable.maxIntrinsicWidth(Constraints.m7486getMaxHeightimpl(r100));
        L9:
            if (Constraints.m7482getHasBoundedHeightimpl(r100) == false) goto L12;
            r101 = Constraints.m7486getMaxHeightimpl(r100);
        L12:
            return new EmptyPlaceable(r102, r101);
        L7:
            r102 = this.measurable.minIntrinsicWidth(Constraints.m7486getMaxHeightimpl(r100));
            goto L9
        L14:
            if (this.minMax != IntrinsicMinMax.Max) goto L16;
            int r103 = this.measurable.maxIntrinsicHeight(Constraints.m7487getMaxWidthimpl(r100));
        L18:
            if (Constraints.m7483getHasBoundedWidthimpl(r100) == false) goto L21;
            r101 = Constraints.m7487getMaxWidthimpl(r100);
        L21:
            return new EmptyPlaceable(r101, r103);
        L16:
            r103 = this.measurable.minIntrinsicHeight(Constraints.m7487getMaxWidthimpl(r100));
            goto L18
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int r100) {
            return this.measurable.minIntrinsicHeight(r100);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int r100) {
            return this.measurable.minIntrinsicWidth(r100);
        }

        public DefaultIntrinsicMeasurable(IntrinsicMeasurable r100, IntrinsicMinMax r101, IntrinsicWidthHeight r102) {
            this.measurable = r100;
            this.minMax = r101;
            this.widthHeight = r102;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0096\u0002J:\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0019\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011¢\u0006\u0002\b\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$EmptyPlaceable;", "Landroidx/compose/ui/layout/Placeable;", "width", "", "height", "<init>", "(II)V", MonitorConstants.CONNECT_TYPE_GET, "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeAt", "", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EmptyPlaceable extends Placeable {
        @Override // androidx.compose.ui.layout.Measured
        public int get(AlignmentLine r100) {
            return Integer.MIN_VALUE;
        }

        @Override // androidx.compose.ui.layout.Placeable
        /* JADX INFO: renamed from: placeAt-f8xVGno */
        public void mo6257placeAtf8xVGno(long r100, float r101, Function1<? super GraphicsLayerScope, Unit> r102) {
        }

        public EmptyPlaceable(int r100, int r101) {
            long r102 = ((long) r100) << 32;
            m6325setMeasuredSizeozmzZPI(IntSize.m7714constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r102));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "", "<init>", "(Ljava/lang/String;I)V", "Min", "Max", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum IntrinsicMinMax extends Enum<IntrinsicMinMax> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ IntrinsicMinMax[] $VALUES = null;
        public static final IntrinsicMinMax Max = null;
        public static final IntrinsicMinMax Min = null;

        private static final /* synthetic */ IntrinsicMinMax[] $values() {
            return new IntrinsicMinMax[]{Min, Max};
        }

        public static EnumEntries<IntrinsicMinMax> getEntries() {
            return $ENTRIES;
        }

        static {
            Min = new IntrinsicMinMax("Min", 0);
            Max = new IntrinsicMinMax("Max", 1);
            IntrinsicMinMax[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static IntrinsicMinMax[] values() {
            return (IntrinsicMinMax[]) $VALUES.clone();
        }

        public static IntrinsicMinMax valueOf(String r100) {
            return (IntrinsicMinMax) r27.a.a(IntrinsicMinMax.class, r100);
        }

        private IntrinsicMinMax(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "", "<init>", "(Ljava/lang/String;I)V", "Width", "Height", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum IntrinsicWidthHeight extends Enum<IntrinsicWidthHeight> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ IntrinsicWidthHeight[] $VALUES = null;
        public static final IntrinsicWidthHeight Height = null;
        public static final IntrinsicWidthHeight Width = null;

        private static final /* synthetic */ IntrinsicWidthHeight[] $values() {
            return new IntrinsicWidthHeight[]{Width, Height};
        }

        public static EnumEntries<IntrinsicWidthHeight> getEntries() {
            return $ENTRIES;
        }

        static {
            Width = new IntrinsicWidthHeight("Width", 0);
            Height = new IntrinsicWidthHeight("Height", 1);
            IntrinsicWidthHeight[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static IntrinsicWidthHeight[] values() {
            return (IntrinsicWidthHeight[]) $VALUES.clone();
        }

        public static IntrinsicWidthHeight valueOf(String r100) {
            return (IntrinsicWidthHeight) r27.a.a(IntrinsicWidthHeight.class, r100);
        }

        private IntrinsicWidthHeight(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        INSTANCE = new MeasuringIntrinsics();
    }

    private MeasuringIntrinsics() {
    }

    public final int maxHeight(LayoutModifier r110, IntrinsicMeasureScope r111, IntrinsicMeasurable r112, int r113) {
        DefaultIntrinsicMeasurable r100 = new DefaultIntrinsicMeasurable(r112, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height);
        long r114 = ConstraintsKt.Constraints$default(0, r113, 0, 0, 13, null);
        return r110.mo652measure3p2s80s(new IntrinsicsMeasureScope(r111, r111.getLayoutDirection()), r100, r114).getHeight();
    }

    public final int maxWidth(LayoutModifier r110, IntrinsicMeasureScope r111, IntrinsicMeasurable r112, int r113) {
        DefaultIntrinsicMeasurable r100 = new DefaultIntrinsicMeasurable(r112, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width);
        long r114 = ConstraintsKt.Constraints$default(0, 0, 0, r113, 7, null);
        return r110.mo652measure3p2s80s(new IntrinsicsMeasureScope(r111, r111.getLayoutDirection()), r100, r114).getWidth();
    }

    public final int minHeight(LayoutModifier r110, IntrinsicMeasureScope r111, IntrinsicMeasurable r112, int r113) {
        DefaultIntrinsicMeasurable r100 = new DefaultIntrinsicMeasurable(r112, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height);
        long r114 = ConstraintsKt.Constraints$default(0, r113, 0, 0, 13, null);
        return r110.mo652measure3p2s80s(new IntrinsicsMeasureScope(r111, r111.getLayoutDirection()), r100, r114).getHeight();
    }

    public final int minWidth(LayoutModifier r110, IntrinsicMeasureScope r111, IntrinsicMeasurable r112, int r113) {
        DefaultIntrinsicMeasurable r100 = new DefaultIntrinsicMeasurable(r112, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width);
        long r114 = ConstraintsKt.Constraints$default(0, 0, 0, r113, 7, null);
        return r110.mo652measure3p2s80s(new IntrinsicsMeasureScope(r111, r111.getLayoutDirection()), r100, r114).getWidth();
    }
}
