package androidx.compose.foundation.text.input.internal;

import C7.r;
import S7.n;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineStart;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0014\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010#R\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010#R\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010#R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020+8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoController;", "", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "composeImm", "Lm9/z;", "monitorScope", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lm9/z;)V", "", "immediate", "monitor", "includeInsertionMarker", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "LC7/r;", "requestUpdates", "(ZZZZZZ)V", "startOrStopMonitoring", "()V", "Landroid/view/inputmethod/CursorAnchorInfo;", "calculateCursorAnchorInfo", "()Landroid/view/inputmethod/CursorAnchorInfo;", "", "cursorUpdateMode", "(I)V", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "Lm9/z;", "monitorEnabled", "Z", "hasPendingImmediateRequest", "Lm9/c0;", "monitorJob", "Lm9/c0;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "[F", "Landroid/graphics/Matrix;", "androidMatrix", "Landroid/graphics/Matrix;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CursorAnchorInfoController {
    public static final int $stable = 8;
    private final ComposeInputMethodManager composeImm;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private boolean monitorEnabled;
    private c0 monitorJob;
    private final InterfaceC1733z monitorScope;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
    private final float[] matrix = Matrix.m4380constructorimpl$default(null, 1, null);
    private final android.graphics.Matrix androidMatrix = new android.graphics.Matrix();

    @J7.c(c = "androidx.compose.foundation.text.input.internal.CursorAnchorInfoController$startOrStopMonitoring$1", f = "CursorAnchorInfoController.android.kt", l = {155}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController$startOrStopMonitoring$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return CursorAnchorInfoController.this.new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            r rVar = r.f317a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return rVar;
            }
            kotlin.b.b(obj);
            final CursorAnchorInfoController cursorAnchorInfoController = CursorAnchorInfoController.this;
            p9.c cVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new S7.a() { // from class: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController.startOrStopMonitoring.1.1
                {
                    super(0);
                }

                @Override // S7.a
                public final CursorAnchorInfo invoke() {
                    return cursorAnchorInfoController.calculateCursorAnchorInfo();
                }
            });
            final CursorAnchorInfoController cursorAnchorInfoController2 = CursorAnchorInfoController.this;
            p9.d dVar = new p9.d() { // from class: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController.startOrStopMonitoring.1.2
                public final Object emit(CursorAnchorInfo cursorAnchorInfo, H7.c<? super r> cVar) {
                    cursorAnchorInfoController2.composeImm.updateCursorAnchorInfo(cursorAnchorInfo);
                    return r.f317a;
                }

                @Override // p9.d
                public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                    return emit((CursorAnchorInfo) obj2, (H7.c<? super r>) cVar);
                }
            };
            this.label = 1;
            Object objCollect = cVarSnapshotFlow.collect(new kotlinx.coroutines.flow.f(new Ref$IntRef(), new com.stepos.policy.sdk.b(dVar, 5)), this);
            if (objCollect != CoroutineSingletons.f4909a) {
                objCollect = rVar;
            }
            if (objCollect != coroutineSingletons) {
                objCollect = rVar;
            }
            return objCollect == coroutineSingletons ? coroutineSingletons : rVar;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public CursorAnchorInfoController(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ComposeInputMethodManager composeInputMethodManager, InterfaceC1733z interfaceC1733z) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.composeImm = composeInputMethodManager;
        this.monitorScope = interfaceC1733z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CursorAnchorInfo calculateCursorAnchorInfo() {
        LayoutCoordinates coreNodeCoordinates;
        LayoutCoordinates decoratorNodeCoordinates;
        TextLayoutResult layoutResult;
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null && (coreNodeCoordinates = this.textLayoutState.getCoreNodeCoordinates()) != null) {
                if (!coreNodeCoordinates.isAttached()) {
                    coreNodeCoordinates = null;
                }
                if (coreNodeCoordinates != null && (decoratorNodeCoordinates = this.textLayoutState.getDecoratorNodeCoordinates()) != null) {
                    if (!decoratorNodeCoordinates.isAttached()) {
                        decoratorNodeCoordinates = null;
                    }
                    if (decoratorNodeCoordinates == null || (layoutResult = this.textLayoutState.getLayoutResult()) == null) {
                        return null;
                    }
                    TextFieldCharSequence visualText = this.textFieldState.getVisualText();
                    Matrix.m4389resetimpl(this.matrix);
                    textLayoutNodeCoordinates.mo5565transformToScreen58bKbWc(this.matrix);
                    AndroidMatrixConversions_androidKt.m4007setFromEL8BTi8(this.androidMatrix, this.matrix);
                    Rect rectVisibleBounds = SelectionManagerKt.visibleBounds(coreNodeCoordinates);
                    Offset.Companion companion = Offset.INSTANCE;
                    return CursorAnchorInfoBuilder_androidKt.m1170buildvxqZcH0(this.builder, visualText, visualText.getSelection(), visualText.getComposition(), layoutResult, this.androidMatrix, rectVisibleBounds.m3932translatek4lQ0M(textLayoutNodeCoordinates.mo5558localPositionOfR5De75A(coreNodeCoordinates, companion.m3911getZeroF1C5BW0())), SelectionManagerKt.visibleBounds(decoratorNodeCoordinates).m3932translatek4lQ0M(textLayoutNodeCoordinates.mo5558localPositionOfR5De75A(decoratorNodeCoordinates, companion.m3911getZeroF1C5BW0())), this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds);
                }
            }
        }
        return null;
    }

    private final void startOrStopMonitoring() {
        if (!this.monitorEnabled) {
            c0 c0Var = this.monitorJob;
            if (c0Var != null) {
                c0Var.cancel(null);
            }
            this.monitorJob = null;
            return;
        }
        c0 c0Var2 = this.monitorJob;
        if (c0Var2 == null || !c0Var2.isActive()) {
            InterfaceC1733z interfaceC1733z = this.monitorScope;
            CoroutineStart coroutineStart = CoroutineStart.f5175a;
            this.monitorJob = AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(null), 1);
        }
    }

    public final void requestUpdates(int cursorUpdateMode) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        CursorAnchorInfoController cursorAnchorInfoController;
        boolean z14 = false;
        boolean z15 = (cursorUpdateMode & 1) != 0;
        boolean z16 = (cursorUpdateMode & 2) != 0;
        int i = Build.VERSION.SDK_INT;
        boolean z17 = (cursorUpdateMode & 16) != 0;
        boolean z18 = (cursorUpdateMode & 8) != 0;
        boolean z19 = (cursorUpdateMode & 4) != 0;
        if (i >= 34 && (cursorUpdateMode & 32) != 0) {
            z14 = true;
        }
        if (z17 || z18 || z19 || z14) {
            z10 = z14;
            z11 = z19;
            z12 = z18;
            z13 = z17;
            cursorAnchorInfoController = this;
        } else {
            cursorAnchorInfoController = this;
            if (i >= 34) {
                z13 = true;
                z12 = true;
                z11 = true;
                z10 = true;
            } else {
                z10 = z14;
                z13 = true;
                z12 = true;
                z11 = true;
            }
        }
        cursorAnchorInfoController.requestUpdates(z15, z16, z13, z12, z11, z10);
    }

    private final void requestUpdates(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        this.includeInsertionMarker = includeInsertionMarker;
        this.includeCharacterBounds = includeCharacterBounds;
        this.includeEditorBounds = includeEditorBounds;
        this.includeLineBounds = includeLineBounds;
        if (immediate) {
            this.hasPendingImmediateRequest = true;
            CursorAnchorInfo cursorAnchorInfoCalculateCursorAnchorInfo = calculateCursorAnchorInfo();
            if (cursorAnchorInfoCalculateCursorAnchorInfo != null) {
                this.composeImm.updateCursorAnchorInfo(cursorAnchorInfoCalculateCursorAnchorInfo);
            }
        }
        this.monitorEnabled = monitor;
        startOrStopMonitoring();
    }
}
