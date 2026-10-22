package androidx.compose.foundation.text.input.internal;

import C7.r;
import S7.k;
import S7.n;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.h;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import p9.i;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJM\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0013J\u000f\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J!\u0010\u0017\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJK\u0010&\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u0003R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidLegacyPlatformTextInputServiceAdapter;", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "LC7/r;", "initializeRequest", "startInput", "(LS7/k;)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "value", "Landroidx/compose/ui/text/input/ImeOptions;", "imeOptions", "", "Landroidx/compose/ui/text/input/EditCommand;", "onEditCommand", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/ImeOptions;LS7/k;LS7/k;)V", "stopInput", "oldValue", "newValue", "updateState", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;)V", "Landroidx/compose/ui/geometry/Rect;", "rect", "notifyFocusedRect", "(Landroidx/compose/ui/geometry/Rect;)V", "textFieldValue", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "Landroidx/compose/ui/graphics/Matrix;", "textFieldToRootTransform", "innerTextFieldBounds", "decorationBoxBounds", "updateTextLayoutResult", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;LS7/k;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)V", "startStylusHandwriting", "Lm9/c0;", "job", "Lm9/c0;", "currentRequest", "Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "Lp9/i;", "backingStylusHandwritingTrigger", "Lp9/i;", "getStylusHandwritingTrigger", "()Lp9/i;", "stylusHandwritingTrigger", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidLegacyPlatformTextInputServiceAdapter extends LegacyPlatformTextInputServiceAdapter {
    public static final int $stable = 8;
    private i backingStylusHandwritingTrigger;
    private LegacyTextInputMethodRequest currentRequest;
    private c0 job;

    @J7.c(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2", f = "LegacyPlatformTextInputServiceAdapter.android.kt", l = {123}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ k $initializeRequest;
        final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

        @J7.c(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", l = {146}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/Void;"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ PlatformTextInputSession $$this$launchTextInputSession;
            final /* synthetic */ k $initializeRequest;
            final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

            @J7.c(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", l = {137, 138}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00471 extends SuspendLambda implements n {
                final /* synthetic */ InputMethodManager $inputMethodManager;
                int label;
                final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00471(AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, InputMethodManager inputMethodManager, H7.c<? super C00471> cVar) {
                    super(2, cVar);
                    this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
                    this.$inputMethodManager = inputMethodManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new C00471(this.this$0, this.$inputMethodManager, cVar);
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
                
                    if (r5.collect(r1, r4) == r0) goto L17;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                    /*
                        r4 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                        int r1 = r4.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L1c
                        if (r1 == r3) goto L18
                        if (r1 == r2) goto L14
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L14:
                        kotlin.b.b(r5)
                        goto L42
                    L18:
                        kotlin.b.b(r5)
                        goto L2a
                    L1c:
                        kotlin.b.b(r5)
                        androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1 r5 = new S7.k() { // from class: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.2.1.1.1
                            static {
                                /*
                                    androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1 r0 = new androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1
                                    r0.<init>()
                                    
                                    // error: 0x0005: SPUT (r0 I:androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1) androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.2.1.1.1.INSTANCE androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.AnonymousClass2.AnonymousClass1.C00471.C00481.<clinit>():void");
                            }

                            {
                                /*
                                    r1 = this;
                                    r0 = 1
                                    r1.<init>(r0)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.AnonymousClass2.AnonymousClass1.C00471.C00481.<init>():void");
                            }

                            public final void invoke(long r1) {
                                /*
                                    r0 = this;
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.AnonymousClass2.AnonymousClass1.C00471.C00481.invoke(long):void");
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r3) {
                                /*
                                    r2 = this;
                                    java.lang.Number r3 = (java.lang.Number) r3
                                    long r0 = r3.longValue()
                                    r2.invoke(r0)
                                    C7.r r2 = C7.r.f317a
                                    return r2
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.AnonymousClass2.AnonymousClass1.C00471.C00481.invoke(java.lang.Object):java.lang.Object");
                            }
                        }
                        r4.label = r3
                        java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r5, r4)
                        if (r5 != r0) goto L2a
                        goto L41
                    L2a:
                        androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter r5 = r4.this$0
                        p9.i r5 = androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.access$getStylusHandwritingTrigger(r5)
                        if (r5 == 0) goto L48
                        androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$2 r1 = new androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$2
                        androidx.compose.foundation.text.input.internal.InputMethodManager r3 = r4.$inputMethodManager
                        r1.<init>()
                        r4.label = r2
                        java.lang.Object r4 = r5.collect(r1, r4)
                        if (r4 != r0) goto L42
                    L41:
                        return r0
                    L42:
                        kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
                        r4.<init>()
                        throw r4
                    L48:
                        C7.r r4 = C7.r.f317a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.AnonymousClass2.AnonymousClass1.C00471.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // S7.n
                public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                    return ((C00471) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(PlatformTextInputSession platformTextInputSession, k kVar, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$$this$launchTextInputSession = platformTextInputSession;
                this.$initializeRequest = kVar;
                this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
                this.$node = legacyPlatformTextInputNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$launchTextInputSession, this.$initializeRequest, this.this$0, this.$node, cVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                try {
                    if (i == 0) {
                        kotlin.b.b(obj);
                        InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                        InputMethodManager inputMethodManager = (InputMethodManager) LegacyPlatformTextInputServiceAdapter_androidKt.getInputMethodManagerFactory().invoke(this.$$this$launchTextInputSession.getView());
                        LegacyTextInputMethodRequest legacyTextInputMethodRequest = new LegacyTextInputMethodRequest(this.$$this$launchTextInputSession.getView(), new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1(this.$node), inputMethodManager);
                        if (StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
                            AbstractC1683A.n(interfaceC1733z, null, new C00471(this.this$0, inputMethodManager, null), 3);
                        }
                        k kVar = this.$initializeRequest;
                        if (kVar != null) {
                            kVar.invoke(legacyTextInputMethodRequest);
                        }
                        this.this$0.currentRequest = legacyTextInputMethodRequest;
                        PlatformTextInputSession platformTextInputSession = this.$$this$launchTextInputSession;
                        this.label = 1;
                        if (platformTextInputSession.startInputMethod(legacyTextInputMethodRequest, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.b.b(obj);
                    }
                    throw new KotlinNothingValueException();
                } catch (Throwable th) {
                    this.this$0.currentRequest = null;
                    throw th;
                }
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<?> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$initializeRequest = kVar;
            this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
            this.$node = legacyPlatformTextInputNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$initializeRequest, this.this$0, this.$node, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(PlatformTextInputSession platformTextInputSession, H7.c<?> cVar) {
            return ((AnonymousClass2) create(platformTextInputSession, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1((PlatformTextInputSession) this.L$0, this.$initializeRequest, this.this$0, this.$node, null);
                this.label = 1;
                if (AbstractC1683A.f(anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i getStylusHandwritingTrigger() {
        i iVar = this.backingStylusHandwritingTrigger;
        if (iVar != null) {
            return iVar;
        }
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            return null;
        }
        h hVarB = p9.e.b(1, 0, BufferOverflow.c, 2);
        this.backingStylusHandwritingTrigger = hVarB;
        return hVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInput$localToScreen(LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, float[] fArr) {
        LayoutCoordinates layoutCoordinates = legacyPlatformTextInputNode.getLayoutCoordinates();
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached()) {
                layoutCoordinates = null;
            }
            if (layoutCoordinates == null) {
                return;
            }
            layoutCoordinates.mo5565transformToScreen58bKbWc(fArr);
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void notifyFocusedRect(Rect rect) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.notifyFocusedRect(rect);
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void startInput(final TextFieldValue value, final ImeOptions imeOptions, final k onEditCommand, final k onImeActionPerformed) {
        startInput(new k() { // from class: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LegacyTextInputMethodRequest) obj);
                return r.f317a;
            }

            public final void invoke(LegacyTextInputMethodRequest legacyTextInputMethodRequest) {
                legacyTextInputMethodRequest.startInput(value, this.getTextInputModifierNode(), imeOptions, onEditCommand, onImeActionPerformed);
            }
        });
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter
    public void startStylusHandwriting() {
        i stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            stylusHandwritingTrigger.a(r.f317a);
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void stopInput() {
        c0 c0Var = this.job;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.job = null;
        i stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            stylusHandwritingTrigger.b();
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void updateState(TextFieldValue oldValue, TextFieldValue newValue) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.updateState(oldValue, newValue);
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, k textFieldToRootTransform, Rect innerTextFieldBounds, Rect decorationBoxBounds) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, innerTextFieldBounds, decorationBoxBounds);
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void startInput() {
        startInput(null);
    }

    private final void startInput(k initializeRequest) {
        LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode textInputModifierNode = getTextInputModifierNode();
        if (textInputModifierNode == null) {
            return;
        }
        this.job = textInputModifierNode.launchTextInputSession(new AnonymousClass2(initializeRequest, this, textInputModifierNode, null));
    }
}
