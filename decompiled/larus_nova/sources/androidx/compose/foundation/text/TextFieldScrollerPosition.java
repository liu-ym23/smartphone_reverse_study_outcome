package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\r\b\u0001\u0018\u0000 :2\u00020\u0001:\u0001:B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ&\u0010-\u001a\u00020.2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0015J%\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0015H\u0000¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020 ¢\u0006\u0004\b8\u00109R+\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00158F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010&\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "", "initialOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "initial", "", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;F)V", "()V", "<set-?>", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "maximum", "getMaximum", "setMaximum", "maximum$delegate", "", "viewportSize", "getViewportSize", "()I", "setViewportSize", "(I)V", "viewportSize$delegate", "Landroidx/compose/runtime/MutableIntState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "getPreviousSelection-d9O1mEE", "()J", "setPreviousSelection-5zc-tL8", "(J)V", "J", "orientation", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "orientation$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "cursorRect", "containerSize", "textFieldSize", "coerceOffset", "cursorStart", "cursorEnd", "coerceOffset$foundation_release", "getOffsetToFollow", "selection", "getOffsetToFollow-5zc-tL8", "(J)I", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldScrollerPosition {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<TextFieldScrollerPosition, Object> Saver = null;
    private final MutableFloatState maximum$delegate;
    private final MutableFloatState offset$delegate;
    private final MutableState orientation$delegate;
    private Rect previousCursorRect;
    private long previousSelection;
    private final MutableIntState viewportSize$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Saver<TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.access$getSaver$cp();
        }
    }

    public static /* synthetic */ List a(SaverScope r100, TextFieldScrollerPosition r101) {
        return Saver$lambda$0(r100, r101);
    }

    public static /* synthetic */ TextFieldScrollerPosition b(List r100) {
        return Saver$lambda$1(r100);
    }

    static {
        Companion = new Companion(null);
        Saver = ListSaverKt.listSaver(new b4(), new c4());
    }

    public TextFieldScrollerPosition() {
        float r100 = 0.0f;
        this(Orientation.Vertical, r100, 2, null);
    }

    public final float getMaximum() {
        return this.maximum$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Orientation getOrientation() {
        return (Orientation) this.orientation$delegate.getValue();
    }

    public final int getViewportSize() {
        return this.viewportSize$delegate.getIntValue();
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    /* JADX INFO: renamed from: getPreviousSelection-d9O1mEE, reason: not valid java name */
    public final long m1153getPreviousSelectiond9O1mEE() {
        return this.previousSelection;
    }

    private static final TextFieldScrollerPosition Saver$lambda$1(List r100) {
        Object r101 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) r101).booleanValue() == false) goto L5;
        Orientation r102 = Orientation.Vertical;
    L6:
        Object r103 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
        return new TextFieldScrollerPosition(r102, ((Float) r103).floatValue());
    L5:
        r102 = Orientation.Horizontal;
        goto L6
    }

    private final void setMaximum(float r100) {
        this.maximum$delegate.setFloatValue(r100);
    }

    private final void setViewportSize(int r100) {
        this.viewportSize$delegate.setIntValue(r100);
    }

    /* JADX INFO: renamed from: getOffsetToFollow-5zc-tL8, reason: not valid java name */
    public final int m1152getOffsetToFollow5zctL8(long r100) {
        if (TextRange.m6998getStartimpl(r100) == TextRange.m6998getStartimpl(this.previousSelection)) goto L6;
        return TextRange.m6998getStartimpl(r100);
    L6:
        if (TextRange.m6993getEndimpl(r100) == TextRange.m6993getEndimpl(this.previousSelection)) goto L9;
        return TextRange.m6993getEndimpl(r100);
    L9:
        return TextRange.m6996getMinimpl(r100);
    }

    public final void setOffset(float r100) {
        this.offset$delegate.setFloatValue(r100);
    }

    public final void setOrientation(Orientation r100) {
        this.orientation$delegate.setValue(r100);
    }

    /* JADX INFO: renamed from: setPreviousSelection-5zc-tL8, reason: not valid java name */
    public final void m1154setPreviousSelection5zctL8(long r100) {
        this.previousSelection = r100;
    }

    public TextFieldScrollerPosition(Orientation r100, float r101) {
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r101);
        this.maximum$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.viewportSize$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.previousCursorRect = Rect.Companion.getZero();
        this.previousSelection = TextRange.Companion.m7003getZerod9O1mEE();
        this.orientation$delegate = SnapshotStateKt.mutableStateOf(r100, SnapshotStateKt.structuralEqualityPolicy());
    }

    private static final List Saver$lambda$0(SaverScope r100, TextFieldScrollerPosition r101) {
        Object[] r102 = new Object[2];
        boolean r103 = false;
        r102[0] = Float.valueOf(r101.getOffset());
        if (r101.getOrientation() != Orientation.Vertical) goto L5;
        r103 = true;
    L5:
        r102[1] = Boolean.valueOf(r103);
        return CollectionsKt.listOf(r102);
    }

    public final void coerceOffset$foundation_release(float r100, float r101, int r102) {
        float r103 = getOffset();
        float r104 = r102;
        float r105 = r103 + r104;
        if (r101 <= r105) goto L6;
    L4:
        float r106 = r101 - r105;
    L15:
        setOffset(getOffset() + r106);
        return;
    L6:
        if (r100 < r103) goto L8;
    L10:
        if (r100 < r103) goto L12;
    L14:
        r106 = 0.0f;
        goto L15
    L12:
        if ((r101 - r100) > r104) goto L14;
        r106 = r100 - r103;
        goto L15
    L8:
        if ((r101 - r100) <= r104) goto L10;
        goto L10
    }

    public /* synthetic */ TextFieldScrollerPosition(Orientation r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0.0f;
    L5:
        this(r100, r101);
    }

    public final void update(Orientation r100, Rect r101, int r102, int r103) {
        float r104 = r103 - r102;
        setMaximum(r104);
        boolean r105 = true;
        if (r101.getLeft() != this.previousCursorRect.getLeft()) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L13;
        if (r101.getTop() != this.previousCursorRect.getTop()) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L13;
    L23:
        setOffset(RangesKt.coerceIn(getOffset(), 0.0f, r104));
        setViewportSize(r102);
        return;
    L10:
        r107 = false;
    L13:
        if (r100 == Orientation.Vertical) goto L16;
        r105 = false;
    L16:
        if (r105 == false) goto L18;
        float r108 = r101.getTop();
    L19:
        if (r105 == false) goto L21;
        float r109 = r101.getBottom();
    L22:
        coerceOffset$foundation_release(r108, r109, r102);
        this.previousCursorRect = r101;
        goto L23
    L21:
        r109 = r101.getRight();
        goto L22
    L18:
        r108 = r101.getLeft();
        goto L19
    L5:
        r106 = false;
        goto L6
    }
}
