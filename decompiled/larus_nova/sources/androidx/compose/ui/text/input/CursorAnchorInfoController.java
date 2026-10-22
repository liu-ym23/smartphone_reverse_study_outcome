package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this class in foundation is used by the legacy BasicTextField.")
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJB\u0010&\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010'\u001a\u00020\u0019J\b\u0010(\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/input/CursorAnchorInfoController;", "", "rootPositionCalculator", "Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "<init>", "(Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;Landroidx/compose/ui/text/input/InputMethodManager;)V", "lock", "monitorEnabled", "", "hasPendingImmediateRequest", "includeInsertionMarker", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textFieldToRootTransform", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "matrix", "[F", "androidMatrix", "Landroid/graphics/Matrix;", "requestUpdate", "immediate", "monitor", "updateTextLayoutResult", "invalidate", "updateCursorAnchorInfo", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CursorAnchorInfoController {
    public static final int $stable = 8;
    private final Matrix androidMatrix;
    private final CursorAnchorInfo.Builder builder;
    private Rect decorationBoxBounds;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private Rect innerTextFieldBounds;
    private final InputMethodManager inputMethodManager;
    private final Object lock;
    private final float[] matrix;
    private boolean monitorEnabled;
    private OffsetMapping offsetMapping;
    private final MatrixPositionCalculator rootPositionCalculator;
    private Function1<? super androidx.compose.ui.graphics.Matrix, Unit> textFieldToRootTransform;
    private TextFieldValue textFieldValue;
    private TextLayoutResult textLayoutResult;

    private final void updateCursorAnchorInfo() {
        if (this.inputMethodManager.isActive() == true) goto L5;
        return;
    L5:
        this.textFieldToRootTransform.invoke(androidx.compose.ui.graphics.Matrix.m5075boximpl(this.matrix));
        this.rootPositionCalculator.mo6055localToScreen58bKbWc(this.matrix);
        AndroidMatrixConversions_androidKt.m4695setFromEL8BTi8(this.androidMatrix, this.matrix);
        InputMethodManager r100 = this.inputMethodManager;
        CursorAnchorInfo.Builder r101 = this.builder;
        TextFieldValue r102 = this.textFieldValue;
        Intrinsics.checkNotNull(r102);
        OffsetMapping r103 = this.offsetMapping;
        Intrinsics.checkNotNull(r103);
        TextLayoutResult r104 = this.textLayoutResult;
        Intrinsics.checkNotNull(r104);
        Matrix r105 = this.androidMatrix;
        Rect r106 = this.innerTextFieldBounds;
        Intrinsics.checkNotNull(r106);
        Rect r107 = this.decorationBoxBounds;
        Intrinsics.checkNotNull(r107);
        r100.updateCursorAnchorInfo(CursorAnchorInfoBuilder_androidKt.build(r101, r102, r103, r104, r105, r106, r107, this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds));
        this.hasPendingImmediateRequest = false;
    }

    public final void invalidate() {
        Object r100 = this.lock;
        monitor-enter(r100);
        this.textFieldValue = null;     // Catch: Throwable -> L8
        this.offsetMapping = null;     // Catch: Throwable -> L8
        this.textLayoutResult = null;     // Catch: Throwable -> L8
        this.textFieldToRootTransform = CursorAnchorInfoController$invalidate$1$1.INSTANCE;     // Catch: Throwable -> L8
        this.innerTextFieldBounds = null;     // Catch: Throwable -> L8
        this.decorationBoxBounds = null;     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public CursorAnchorInfoController(MatrixPositionCalculator r100, InputMethodManager r101) {
        this.rootPositionCalculator = r100;
        this.inputMethodManager = r101;
        this.lock = new Object();
        this.textFieldToRootTransform = CursorAnchorInfoController$textFieldToRootTransform$1.INSTANCE;
        this.builder = new CursorAnchorInfo.Builder();
        this.matrix = androidx.compose.ui.graphics.Matrix.m5077constructorimpl$default(null, 1, null);
        this.androidMatrix = new Matrix();
    }

    public final void requestUpdate(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        Object r106 = this.lock;
        monitor-enter(r106);
        this.includeInsertionMarker = r102;     // Catch: Throwable -> L12
        this.includeCharacterBounds = r103;     // Catch: Throwable -> L12
        this.includeEditorBounds = r104;     // Catch: Throwable -> L12
        this.includeLineBounds = r105;     // Catch: Throwable -> L12
        if (r100 == false) goto L9;
        this.hasPendingImmediateRequest = true;     // Catch: Throwable -> L12
        if (this.textFieldValue == null) goto L9;
        updateCursorAnchorInfo();     // Catch: Throwable -> L12
    L9:
        this.monitorEnabled = r101;     // Catch: Throwable -> L12
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r106);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void updateTextLayoutResult(TextFieldValue r100, OffsetMapping r101, TextLayoutResult r102, Function1<? super androidx.compose.ui.graphics.Matrix, Unit> r103, Rect r104, Rect r105) {
        Object r106 = this.lock;
        monitor-enter(r106);
        this.textFieldValue = r100;     // Catch: Throwable -> L12
        this.offsetMapping = r101;     // Catch: Throwable -> L12
        this.textLayoutResult = r102;     // Catch: Throwable -> L12
        this.textFieldToRootTransform = r103;     // Catch: Throwable -> L12
        this.innerTextFieldBounds = r104;     // Catch: Throwable -> L12
        this.decorationBoxBounds = r105;     // Catch: Throwable -> L12
        if (this.hasPendingImmediateRequest == false) goto L7;
    L8:
        updateCursorAnchorInfo();     // Catch: Throwable -> L12
    L9:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r106);
        return;
    L7:
        if (this.monitorEnabled == false) goto L9;
    L12:
        th = move-exception;
        throw th;
    }
}
