package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\n0\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\u0014H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u001e\u0010\u000e\u001a\u00020\n2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0016J\u001a\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0016JD\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020 H\u0016J\b\u0010+\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006,"}, d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidLegacyPlatformTextInputServiceAdapter;", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "<init>", "()V", "job", "Lkotlinx/coroutines/Job;", "currentRequest", "Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "backingStylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "stylusHandwritingTrigger", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "startInput", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "initializeRequest", "stopInput", "updateState", "oldValue", "newValue", "notifyFocusedRect", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "startStylusHandwriting", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidLegacyPlatformTextInputServiceAdapter extends LegacyPlatformTextInputServiceAdapter {
    public static final int $stable = 8;
    private MutableSharedFlow<Unit> backingStylusHandwritingTrigger;
    private LegacyTextInputMethodRequest currentRequest;

    /* JADX INFO: renamed from: job, reason: collision with root package name */
    private Job f7104job;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<PlatformTextInputSession, Continuation<?>, Object> {
        final /* synthetic */ Function1<LegacyTextInputMethodRequest, Unit> $initializeRequest;
        final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ PlatformTextInputSession $$this$launchTextInputSession;
            final /* synthetic */ Function1<LegacyTextInputMethodRequest, Unit> $initializeRequest;
            final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {140, 141}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ InputMethodManager $inputMethodManager;
                int label;
                final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

                public C01291(AndroidLegacyPlatformTextInputServiceAdapter r100, InputMethodManager r101, Continuation<? super C01291> r102) {
                    this.this$0 = r100;
                    this.$inputMethodManager = r101;
                    super(2, r102);
                }

                public static /* synthetic */ Unit a(long r100) {
                    return invokeSuspend$lambda$0(r100);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C01291(this.this$0, this.$inputMethodManager, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C01291) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                private static final Unit invokeSuspend$lambda$0(long r100) {
                    return Unit.INSTANCE;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L10;
                    if (r102 == 1) goto L9;
                    if (r102 != 2) goto L7;
                    ResultKt.throwOnFailure(r100);
                L19:
                    throw new KotlinNothingValueException();
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L9:
                    ResultKt.throwOnFailure(r100);
                L13:
                    MutableSharedFlow r103 = AndroidLegacyPlatformTextInputServiceAdapter.access$getStylusHandwritingTrigger(this.this$0);
                    if (r103 == null) goto L21;
                    final InputMethodManager r104 = this.$inputMethodManager;
                    FlowCollector r105 = new C01302(r104);
                    this.label = 2;
                    if (r103.collect(r105, this) != r101) goto L19;
                    return r101;
                L21:
                    return Unit.INSTANCE;
                L10:
                    ResultKt.throwOnFailure(r100);
                    Function1 r106 = new b();
                    this.label = 1;
                    if (MonotonicFrameClockKt.withFrameMillis(r106, this) != r101) goto L13;
                    return r101;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(PlatformTextInputSession r100, Function1<? super LegacyTextInputMethodRequest, Unit> r101, AndroidLegacyPlatformTextInputServiceAdapter r102, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r103, Continuation<? super AnonymousClass1> r104) {
                this.$$this$launchTextInputSession = r100;
                this.$initializeRequest = r101;
                this.this$0 = r102;
                this.$node = r103;
                super(2, r104);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                AnonymousClass1 r102 = new AnonymousClass1(this.$$this$launchTextInputSession, this.$initializeRequest, this.this$0, this.$node, r101);
                r102.L$0 = r100;
                return r102;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<?> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<?> r101) {
                return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L11;
                if (r101 != 1) goto L6;
                ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L9
            L22:
                throw new KotlinNothingValueException();     // Catch: Throwable -> L9
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r110);
                CoroutineScope r102 = (CoroutineScope) this.L$0;
                InputMethodManager r111 = LegacyPlatformTextInputServiceAdapter_androidKt.getInputMethodManagerFactory().invoke(this.$$this$launchTextInputSession.getView());
                LegacyTextInputMethodRequest r103 = new LegacyTextInputMethodRequest(this.$$this$launchTextInputSession.getView(), new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1(this.$node), r111);
                if (StylusHandwriting_androidKt.isStylusHandwritingSupported() == false) goto L14;
                BuildersKt.launch$default(r102, null, null, new C01291(this.this$0, r111, null), 3, null);
            L14:
                Function1<LegacyTextInputMethodRequest, Unit> r112 = this.$initializeRequest;
                if (r112 == null) goto L17;
                r112.invoke(r103);
            L17:
                AndroidLegacyPlatformTextInputServiceAdapter.access$setCurrentRequest$p(this.this$0, r103);
                PlatformTextInputSession r113 = this.$$this$launchTextInputSession;     // Catch: Throwable -> L9
                this.label = 1;     // Catch: Throwable -> L9
                if (r113.startInputMethod(r103, this) != r100) goto L22;
                return r100;
            L9:
                th = move-exception;
                AndroidLegacyPlatformTextInputServiceAdapter.access$setCurrentRequest$p(this.this$0, null);
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super LegacyTextInputMethodRequest, Unit> r100, AndroidLegacyPlatformTextInputServiceAdapter r101, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r102, Continuation<? super AnonymousClass2> r103) {
            this.$initializeRequest = r100;
            this.this$0 = r101;
            this.$node = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.$initializeRequest, this.this$0, this.$node, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(PlatformTextInputSession r100, Continuation<?> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(PlatformTextInputSession r100, Continuation<?> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L6;
            ResultKt.throwOnFailure(r110);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            AnonymousClass1 r111 = new AnonymousClass1((PlatformTextInputSession) this.L$0, this.$initializeRequest, this.this$0, this.$node, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(r111, this) != r100) goto L12;
            return r100;
        }
    }

    public static /* synthetic */ Unit a(TextFieldValue r100, AndroidLegacyPlatformTextInputServiceAdapter r101, ImeOptions r102, Function1 r103, Function1 r104, LegacyTextInputMethodRequest r105) {
        return startInput$lambda$1(r100, r101, r102, r103, r104, r105);
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter, androidx.compose.ui.text.input.PlatformTextInputService
    public void startInput() {
        startInput(null);
    }

    private final MutableSharedFlow<Unit> getStylusHandwritingTrigger() {
        MutableSharedFlow<Unit> r100 = this.backingStylusHandwritingTrigger;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() == true) goto L8;
        return null;
    L8:
        MutableSharedFlow<Unit> r101 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, null);
        this.backingStylusHandwritingTrigger = r101;
        return r101;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void stopInput() {
        Job r100 = this.f7104job;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f7104job = null;
        MutableSharedFlow<Unit> r101 = getStylusHandwritingTrigger();
        if (r101 == null) goto L9;
        r101.resetReplayCache();
        return;
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter
    public void startStylusHandwriting() {
        MutableSharedFlow<Unit> r100 = getStylusHandwritingTrigger();
        if (r100 == null) goto L6;
        r100.tryEmit(Unit.INSTANCE);
        return;
    }

    public AndroidLegacyPlatformTextInputServiceAdapter() {
    }

    public static final /* synthetic */ MutableSharedFlow access$getStylusHandwritingTrigger(AndroidLegacyPlatformTextInputServiceAdapter r100) {
        return r100.getStylusHandwritingTrigger();
    }

    private final void startInput(Function1<? super LegacyTextInputMethodRequest, Unit> r100) {
        LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r101 = getTextInputModifierNode();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f7104job = r101.launchTextInputSession(new AnonymousClass2(r100, this, r101, null));
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter, androidx.compose.ui.text.input.PlatformTextInputService
    public void notifyFocusedRect(Rect r100) {
        LegacyTextInputMethodRequest r101 = this.currentRequest;
        if (r101 == null) goto L6;
        r101.notifyFocusedRect(r100);
        return;
    }

    public static final /* synthetic */ void access$setCurrentRequest$p(AndroidLegacyPlatformTextInputServiceAdapter r100, LegacyTextInputMethodRequest r101) {
        r100.currentRequest = r101;
    }

    public static final /* synthetic */ void access$startInput$localToScreen(LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r100, float[] r101) {
        startInput$localToScreen(r100, r101);
    }

    private static final void startInput$localToScreen(LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r100, float[] r101) {
        LayoutCoordinates r102 = r100.getLayoutCoordinates();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isAttached() == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L13;
        r102.mo6266transformToScreen58bKbWc(r101);
        return;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void updateState(TextFieldValue r100, TextFieldValue r101) {
        LegacyTextInputMethodRequest r102 = this.currentRequest;
        if (r102 == null) goto L6;
        r102.updateState(r100, r101);
        return;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void startInput(final TextFieldValue r100, final ImeOptions r101, final Function1<? super List<? extends EditCommand>, Unit> r110, final Function1<? super ImeAction, Unit> r111) {
        startInput(new a(r100, this, r101, r110, r111));
    }

    private static final Unit startInput$lambda$1(TextFieldValue r100, AndroidLegacyPlatformTextInputServiceAdapter r101, ImeOptions r102, Function1 r103, Function1 r110, LegacyTextInputMethodRequest r111) {
        r111.startInput(r100, r101.getTextInputModifierNode(), r102, r103, r110);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter, androidx.compose.ui.text.input.PlatformTextInputService
    public void updateTextLayoutResult(TextFieldValue r100, OffsetMapping r101, TextLayoutResult r102, Function1<? super Matrix, Unit> r110, Rect r111, Rect r112) {
        LegacyTextInputMethodRequest r103 = this.currentRequest;
        if (r103 == null) goto L6;
        r103.updateTextLayoutResult(r100, r101, r102, r111, r112);
        return;
    }
}
