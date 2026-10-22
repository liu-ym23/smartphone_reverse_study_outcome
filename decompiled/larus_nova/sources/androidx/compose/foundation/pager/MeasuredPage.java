package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003J\u000e\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0003J\u0017\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101J(\u00105\u001a\u00020\t*\u00020\t2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000307H\u0082\b¢\u0006\u0004\b8\u00109R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u000e\u0010&\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00102\u001a\u00020\u0003*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006:"}, d2 = {"Landroidx/compose/foundation/pager/MeasuredPage;", "Landroidx/compose/foundation/pager/PageInfo;", "index", "", "size", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "", "<init>", "(IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getSize", "J", "getKey", "()Ljava/lang/Object;", "isVertical", "crossAxisSize", "getCrossAxisSize", "placeableOffsets", "", "value", "offset", "getOffset", "mainAxisLayoutSize", "position", "", "layoutWidth", "layoutHeight", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "applyScrollDelta", "delta", "getOffset-Bjo55l4", "(I)J", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MeasuredPage implements PageInfo {
    public static final int $stable = 8;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ MeasuredPage(int r100, int r101, List r102, long r103, Object r104, Orientation r105, Alignment.Horizontal r106, Alignment.Vertical r107, LayoutDirection r110, boolean r111, DefaultConstructorMarker r112) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getOffset() {
        return this.offset;
    }

    public final int getSize() {
        return this.size;
    }

    private final int getMainAxisSize(Placeable r100) {
        if (this.isVertical == false) goto L6;
        return r100.getHeight();
    L6:
        return r100.getWidth();
    }

    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    private final long m970getOffsetBjo55l4(int r100) {
        int[] r101 = this.placeableOffsets;
        int r102 = r100 * 2;
        int r103 = r101[r102];
        int r104 = r101[r102 + 1];
        return IntOffset.m7670constructorimpl((((long) r103) << 32) | (((long) r104) & BodyPartID.bodyIdMax));
    }

    public final void applyScrollDelta(int r100) {
        this.offset = getOffset() + r100;
        int r101 = this.placeableOffsets.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L13;
        boolean r103 = this.isVertical;
        if (r103 == true) goto L7;
    L8:
        if (r103 == true) goto L12;
        if ((r102 % 2) != 0) goto L12;
    L11:
        int[] r104 = this.placeableOffsets;
        r104[r102] = r104[r102] + r100;
    L12:
        r102 = r102 + 1;
        goto L3
    L7:
        if ((r102 % 2) == 1) goto L11;
    }

    public final void place(Placeable.PlacementScope r110) {
        int r100 = 0;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
    L8:
        int r102 = this.placeables.size();
    L9:
        if (r100 >= r102) goto L26;
        Placeable r103 = (Placeable) ListProtector.get(this.placeables, r100);
        long r104 = m970getOffsetBjo55l4(r100);
        if (this.reverseLayout == true) goto L13;
    L21:
        long r105 = IntOffset.m7680plusqkQi6aY(r104, this.visualOffset);
        if (this.isVertical == false) goto L24;
        Placeable.PlacementScope.m6331placeWithLayeraW9wM$default(r110, r103, r105, 0.0f, null, 6, null);
    L25:
        r100 = r100 + 1;
        goto L9
    L24:
        Placeable.PlacementScope.m6329placeRelativeWithLayeraW9wM$default(r110, r103, r105, 0.0f, null, 6, null);
        goto L25
    L13:
        if (this.isVertical == false) goto L15;
        int r106 = IntOffset.m7676getXimpl(r104);
    L17:
        if (this.isVertical == false) goto L19;
        int r107 = IntOffset.m7677getYimpl(r104);
        int r108 = (this.mainAxisLayoutSize - r107) - getMainAxisSize(r103);
    L20:
        r104 = IntOffset.m7670constructorimpl((((long) r106) << 32) | (((long) r108) & BodyPartID.bodyIdMax));
        goto L21
    L19:
        r108 = IntOffset.m7677getYimpl(r104);
        goto L20
    L15:
        int r109 = IntOffset.m7676getXimpl(r104);
        r106 = (this.mainAxisLayoutSize - r109) - getMainAxisSize(r103);
        goto L17
    L26:
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m969copy4Tuh3kE(long r100, Function1<? super Integer, Integer> r101) {
        if (this.isVertical == false) goto L5;
        int r102 = IntOffset.m7676getXimpl(r100);
    L6:
        boolean r103 = this.isVertical;
        int r104 = IntOffset.m7677getYimpl(r100);
        if (r103 == false) goto L10;
        r104 = r101.invoke(Integer.valueOf(r104)).intValue();
    L10:
        return IntOffset.m7670constructorimpl((((long) r102) << 32) | (((long) r104) & BodyPartID.bodyIdMax));
    L5:
        r102 = r101.invoke(Integer.valueOf(IntOffset.m7676getXimpl(r100))).intValue();
        goto L6
    }

    public final void position(int r110, int r111, int r112) {
        this.offset = r110;
        if (this.isVertical == false) goto L5;
        int r100 = r112;
    L6:
        this.mainAxisLayoutSize = r100;
        List<Placeable> r101 = this.placeables;
        int r102 = r101.size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L21;
        Placeable r104 = (Placeable) ListProtector.get(r101, r103);
        int r105 = r103 * 2;
        if (this.isVertical == false) goto L15;
        int[] r106 = this.placeableOffsets;
        Alignment.Horizontal r107 = this.horizontalAlignment;
        if (r107 == null) goto L13;
        r106[r105] = r107.align(r104.getWidth(), r111, this.layoutDirection);
        this.placeableOffsets[r105 + 1] = r110;
        int r108 = r104.getHeight();
    L18:
        r110 = r110 + r108;
        r103 = r103 + 1;
        goto L7
    L13:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment");
        throw new KotlinNothingValueException();
    L15:
        int[] r109 = this.placeableOffsets;
        r109[r105] = r110;
        int r113 = r105 + 1;
        Alignment.Vertical r114 = this.verticalAlignment;
        if (r114 == null) goto L19;
        r109[r113] = r114.align(r104.getHeight(), r112);
        r108 = r104.getWidth();
        goto L18
    L19:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalAlignment");
        throw new KotlinNothingValueException();
    L21:
        return;
    L5:
        r100 = r111;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MeasuredPage(int r100, int r101, List<? extends Placeable> r102, long r103, Object r104, Orientation r105, Alignment.Horizontal r106, Alignment.Vertical r107, LayoutDirection r110, boolean r111) {
        this.index = r100;
        this.size = r101;
        this.placeables = r102;
        this.visualOffset = r103;
        this.key = r104;
        this.horizontalAlignment = r106;
        this.verticalAlignment = r107;
        this.layoutDirection = r110;
        this.reverseLayout = r111;
        int r108 = 0;
        if (r105 != Orientation.Vertical) goto L5;
        boolean r109 = true;
    L6:
        this.isVertical = r109;
        int r112 = r102.size();
        int r113 = 0;
    L7:
        if (r108 >= r112) goto L13;
        Placeable r114 = (Placeable) ListProtector.get(r102, r108);
        if (this.isVertical == true) goto L11;
        int r115 = r114.getHeight();
    L12:
        r113 = Math.max(r113, r115);
        r108 = r108 + 1;
        goto L7
    L11:
        r115 = r114.getWidth();
        goto L12
    L13:
        this.crossAxisSize = r113;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        return;
    L5:
        r109 = false;
        goto L6
    }
}
