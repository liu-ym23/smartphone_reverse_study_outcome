package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ6\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ.\u0010$\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010%\u001a\u00020\u0005J\b\u0010&\u001a\u00020\u0005H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "lock", "monitorEnabled", "", "hasPendingImmediateRequest", "includeInsertionMarker", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "matrix", "[F", "androidMatrix", "Landroid/graphics/Matrix;", "requestUpdate", "immediate", "monitor", "updateTextLayoutResult", "invalidate", "updateCursorAnchorInfo", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LegacyCursorAnchorInfoController {
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
    private final Function1<androidx.compose.ui.graphics.Matrix, Unit> localToScreen;
    private final Object lock;
    private final float[] matrix;
    private boolean monitorEnabled;
    private OffsetMapping offsetMapping;
    private TextFieldValue textFieldValue;
    private TextLayoutResult textLayoutResult;

    private final void updateCursorAnchorInfo() {
        if (this.inputMethodManager.isActive() == true) goto L5;
        return;
    L5:
        if (this.textFieldValue != null) goto L7;
        return;
    L7:
        if (this.offsetMapping != null) goto L9;
        return;
    L9:
        if (this.textLayoutResult != null) goto L11;
        return;
    L11:
        if (this.innerTextFieldBounds != null) goto L13;
        return;
    L13:
        if (this.decorationBoxBounds == null) goto L22;
        androidx.compose.ui.graphics.Matrix.m5086resetimpl(this.matrix);
        this.localToScreen.invoke(androidx.compose.ui.graphics.Matrix.m5075boximpl(this.matrix));
        float[] r100 = this.matrix;
        Rect r101 = this.decorationBoxBounds;
        Intrinsics.checkNotNull(r101);
        float r102 = -r101.getLeft();
        Rect r103 = this.decorationBoxBounds;
        Intrinsics.checkNotNull(r103);
        androidx.compose.ui.graphics.Matrix.m5098translateimpl(r100, r102, -r103.getTop(), 0.0f);
        AndroidMatrixConversions_androidKt.m4695setFromEL8BTi8(this.androidMatrix, this.matrix);
        InputMethodManager r104 = this.inputMethodManager;
        CursorAnchorInfo.Builder r105 = this.builder;
        TextFieldValue r106 = this.textFieldValue;
        Intrinsics.checkNotNull(r106);
        OffsetMapping r107 = this.offsetMapping;
        Intrinsics.checkNotNull(r107);
        TextLayoutResult r108 = this.textLayoutResult;
        Intrinsics.checkNotNull(r108);
        Matrix r109 = this.androidMatrix;
        Rect r110 = this.innerTextFieldBounds;
        Intrinsics.checkNotNull(r110);
        Rect r111 = this.decorationBoxBounds;
        Intrinsics.checkNotNull(r111);
        r104.updateCursorAnchorInfo(LegacyCursorAnchorInfoBuilder_androidKt.build(r105, r106, r107, r108, r109, r110, r111, this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds));
        this.hasPendingImmediateRequest = false;
        return;
    }

    public final void invalidate() {
        Object r100 = this.lock;
        monitor-enter(r100);
        this.textFieldValue = null;     // Catch: Throwable -> L8
        this.offsetMapping = null;     // Catch: Throwable -> L8
        this.textLayoutResult = null;     // Catch: Throwable -> L8
        this.innerTextFieldBounds = null;     // Catch: Throwable -> L8
        this.decorationBoxBounds = null;     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LegacyCursorAnchorInfoController(Function1<? super androidx.compose.ui.graphics.Matrix, Unit> r100, InputMethodManager r101) {
        this.localToScreen = r100;
        this.inputMethodManager = r101;
        this.lock = new Object();
        this.builder = new CursorAnchorInfo.Builder();
        this.matrix = androidx.compose.ui.graphics.Matrix.m5077constructorimpl$default(null, 1, null);
        this.androidMatrix = new Matrix();
    }

    public final void updateTextLayoutResult(TextFieldValue r100, OffsetMapping r101, TextLayoutResult r102, Rect r103, Rect r104) {
        Object r105 = this.lock;
        monitor-enter(r105);
        this.textFieldValue = r100;     // Catch: Throwable -> L12
        this.offsetMapping = r101;     // Catch: Throwable -> L12
        this.textLayoutResult = r102;     // Catch: Throwable -> L12
        this.innerTextFieldBounds = r103;     // Catch: Throwable -> L12
        this.decorationBoxBounds = r104;     // Catch: Throwable -> L12
        if (this.hasPendingImmediateRequest == false) goto L7;
    L8:
        updateCursorAnchorInfo();     // Catch: Throwable -> L12
    L9:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r105);
        return;
    L7:
        if (this.monitorEnabled == false) goto L9;
    L12:
        th = move-exception;
        throw th;
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
}
