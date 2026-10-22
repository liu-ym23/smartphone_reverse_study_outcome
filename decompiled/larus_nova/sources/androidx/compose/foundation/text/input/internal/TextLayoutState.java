package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020;J-\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u000208¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020I¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020I2\u0006\u0010N\u001a\u00020IH\u0000¢\u0006\u0004\bR\u0010SR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R;\u0010\u0006\u001a#\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010\u001f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR/\u0010#\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR+\u0010(\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001e\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006T"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "", "<init>", "()V", "layoutCache", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "Lkotlin/ExtensionFunctionType;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function2;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function2;)V", "layoutResult", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult$delegate", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutNodeCoordinates", "getTextLayoutNodeCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setTextLayoutNodeCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "textLayoutNodeCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "coreNodeCoordinates", "getCoreNodeCoordinates", "setCoreNodeCoordinates", "coreNodeCoordinates$delegate", "decoratorNodeCoordinates", "getDecoratorNodeCoordinates", "setDecoratorNodeCoordinates", "decoratorNodeCoordinates$delegate", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "bringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "getBringIntoViewRequester", "()Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "layoutWithNewMeasureInputs", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release", "(J)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutState {
    public static final int $stable = 8;
    private final BringIntoViewRequester bringIntoViewRequester;
    private final MutableState coreNodeCoordinates$delegate;
    private final MutableState decoratorNodeCoordinates$delegate;
    private TextFieldLayoutStateCache layoutCache;
    private final TextFieldLayoutStateCache layoutResult$delegate;
    private final MutableState minHeightForSingleLineField$delegate;
    private Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout;
    private final MutableState textLayoutNodeCoordinates$delegate;

    public static /* synthetic */ TextLayoutResult a(TextLayoutState r100) {
        return layoutWithNewMeasureInputs__hBUhpc$lambda$1$lambda$0(r100);
    }

    public final LayoutCoordinates getCoreNodeCoordinates() {
        return (LayoutCoordinates) this.coreNodeCoordinates$delegate.getValue();
    }

    public final LayoutCoordinates getDecoratorNodeCoordinates() {
        return (LayoutCoordinates) this.decoratorNodeCoordinates$delegate.getValue();
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMinHeightForSingleLineField-D9Ej5fM, reason: not valid java name */
    public final float m1306getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((Dp) this.minHeightForSingleLineField$delegate.getValue()).m7558unboximpl();
    }

    public final LayoutCoordinates getTextLayoutNodeCoordinates() {
        return (LayoutCoordinates) this.textLayoutNodeCoordinates$delegate.getValue();
    }

    public TextLayoutState() {
        TextFieldLayoutStateCache r100 = new TextFieldLayoutStateCache();
        this.layoutCache = r100;
        this.layoutResult$delegate = r100;
        this.textLayoutNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.coreNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.decoratorNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.minHeightForSingleLineField$delegate = SnapshotStateKt.mutableStateOf$default(Dp.m7542boximpl(Dp.m7544constructorimpl(0)), null, 2, null);
        this.bringIntoViewRequester = BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public final BringIntoViewRequester getBringIntoViewRequester() {
        return this.bringIntoViewRequester;
    }

    public final Function2<Density, Function0<TextLayoutResult>, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    private static final TextLayoutResult layoutWithNewMeasureInputs__hBUhpc$lambda$1$lambda$0(TextLayoutState r100) {
        return r100.layoutCache.getValue();
    }

    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1305coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(long r100) {
        LayoutCoordinates r101 = getTextLayoutNodeCoordinates();
        if (r101 != null) goto L5;
    L11:
        Rect r102 = Rect.Companion.getZero();
    L13:
        return TextLayoutStateKt.m1311coerceIn3MmeM6k(r100, r102);
    L5:
        if (r101.isAttached() == false) goto L9;
        LayoutCoordinates r103 = getDecoratorNodeCoordinates();
        r102 = null;
        if (r103 == null) goto L10;
        r102 = LayoutCoordinates.CC.localBoundingBoxOf$default(r103, r101, false, 2, null);
    L10:
        if (r102 != null) goto L13;
    L9:
        r102 = Rect.Companion.getZero();
        goto L10
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m1308isPositionOnTextk4lQ0M(long r100) {
        TextLayoutResult r101 = getLayoutResult();
        if (r101 != null) goto L5;
        return false;
    L5:
        long r102 = TextLayoutStateKt.m1312fromDecorationToTextLayoutUv8p0NA(this, m1305coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(r100));
        int r103 = r101.getLineForVerticalPosition(Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r102)));
        int r104 = (int) (r102 >> 32);
        if (Float.intBitsToFloat(r104) >= r101.getLineLeft(r103)) goto L8;
        return false;
    L8:
        if (Float.intBitsToFloat(r104) > r101.getLineRight(r103)) goto L12;
        return true;
    L12:
        return false;
    }

    public final void setCoreNodeCoordinates(LayoutCoordinates r100) {
        this.coreNodeCoordinates$delegate.setValue(r100);
    }

    public final void setDecoratorNodeCoordinates(LayoutCoordinates r100) {
        this.decoratorNodeCoordinates$delegate.setValue(r100);
    }

    /* JADX INFO: renamed from: setMinHeightForSingleLineField-0680j_4, reason: not valid java name */
    public final void m1310setMinHeightForSingleLineField0680j_4(float r100) {
        this.minHeightForSingleLineField$delegate.setValue(Dp.m7542boximpl(r100));
    }

    public final void setOnTextLayout(Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r100) {
        this.onTextLayout = r100;
    }

    public final void setTextLayoutNodeCoordinates(LayoutCoordinates r100) {
        this.textLayoutNodeCoordinates$delegate.setValue(r100);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m1307getOffsetForPosition3MmeM6k(long r100, boolean r101) {
        TextLayoutResult r102 = getLayoutResult();
        if (r102 != null) goto L6;
        return -1;
    L6:
        if (r101 == false) goto L9;
        r100 = m1305coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(r100);
    L9:
        return r102.m6968getOffsetForPositionk4lQ0M(TextLayoutStateKt.m1312fromDecorationToTextLayoutUv8p0NA(this, r100));
    }

    /* JADX INFO: renamed from: layoutWithNewMeasureInputs--hBUhpc, reason: not valid java name */
    public final TextLayoutResult m1309layoutWithNewMeasureInputshBUhpc(Density r100, LayoutDirection r101, FontFamily.Resolver r102, long r110) {
        TextLayoutResult r103 = this.layoutCache.m1298layoutWithNewMeasureInputshBUhpc(r100, r101, r102, r110);
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r104 = this.onTextLayout;
        if (r104 == null) goto L5;
        r104.invoke(r100, new z1(this));
    L5:
        return r103;
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m1304getOffsetForPosition3MmeM6k$default(TextLayoutState r100, long r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = true;
    L6:
        return r100.m1307getOffsetForPosition3MmeM6k(r101, r102);
    }

    public final void updateNonMeasureInputs(TransformedTextFieldState r100, TextStyle r101, boolean r102, boolean r110, KeyboardOptions r111) {
        this.layoutCache.updateNonMeasureInputs(r100, r101, r102, r110, r111);
    }
}
