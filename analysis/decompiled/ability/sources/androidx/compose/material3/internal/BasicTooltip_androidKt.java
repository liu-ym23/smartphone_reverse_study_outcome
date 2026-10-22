package androidx.compose.material3.internal;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import android.content.res.Resources;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.R;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import p9.j;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u001ac\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a<\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001aB\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0017\u001a\u00020\b*\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a3\u0010\u001b\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/window/PopupPositionProvider;", "positionProvider", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "tooltip", "Landroidx/compose/material3/TooltipState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", "", "focusable", "enableUserInput", "content", "BasicTooltipBox", "(Landroidx/compose/ui/window/PopupPositionProvider;LS7/n;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLS7/n;Landroidx/compose/runtime/Composer;II)V", "WrappedAnchor", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;LS7/n;Landroidx/compose/runtime/Composer;II)V", "Lm9/z;", "scope", "TooltipPopup", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/material3/TooltipState;Lm9/z;ZLS7/n;Landroidx/compose/runtime/Composer;I)V", "enabled", "handleGestures", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/TooltipState;)Landroidx/compose/ui/Modifier;", "", "label", "anchorSemantics", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLandroidx/compose/material3/TooltipState;Lm9/z;)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTooltip_androidKt {

    @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1", f = "BasicTooltip.android.kt", l = {162}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06761 extends SuspendLambda implements n {
        final /* synthetic */ TooltipState $state;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1", f = "BasicTooltip.android.kt", l = {163}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01071 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ TooltipState $state;
            private /* synthetic */ Object L$0;
            int label;

            @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1", f = "BasicTooltip.android.kt", l = {171, 177, 197}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01081 extends RestrictedSuspendLambda implements n {
                final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
                final /* synthetic */ TooltipState $state;
                long J$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$1", f = "BasicTooltip.android.kt", l = {178}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C01091 extends RestrictedSuspendLambda implements n {
                    final /* synthetic */ PointerEventPass $pass;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C01091(PointerEventPass pointerEventPass, H7.c<? super C01091> cVar) {
                        super(2, cVar);
                        this.$pass = pointerEventPass;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                        C01091 c01091 = new C01091(this.$pass, cVar);
                        c01091.L$0 = obj;
                        return c01091;
                    }

                    @Override // S7.n
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super PointerInputChange> cVar) {
                        return ((C01091) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            b.b(obj);
                            return obj;
                        }
                        b.b(obj);
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        PointerEventPass pointerEventPass = this.$pass;
                        this.label = 1;
                        Object objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, this);
                        return objWaitForUpOrCancellation == coroutineSingletons ? coroutineSingletons : objWaitForUpOrCancellation;
                    }
                }

                @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2", f = "BasicTooltip.android.kt", l = {185, 187, 187}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2, reason: invalid class name */
                public static final class AnonymousClass2 extends SuspendLambda implements n {
                    final /* synthetic */ j $isLongPressedFlow;
                    final /* synthetic */ TooltipState $state;
                    Object L$0;
                    int label;

                    @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1", f = "BasicTooltip.android.kt", l = {}, m = "invokeSuspend")
                    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isLongPressed", "LC7/r;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 8, 0})
                    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1, reason: invalid class name and collision with other inner class name */
                    public static final class C01101 extends SuspendLambda implements n {
                        final /* synthetic */ TooltipState $state;
                        /* synthetic */ boolean Z$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C01101(TooltipState tooltipState, H7.c<? super C01101> cVar) {
                            super(2, cVar);
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                            C01101 c01101 = new C01101(this.$state, cVar);
                            c01101.Z$0 = ((Boolean) obj).booleanValue();
                            return c01101;
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            return invoke(((Boolean) obj).booleanValue(), (H7.c<? super r>) obj2);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            b.b(obj);
                            if (!this.Z$0) {
                                this.$state.dismiss();
                            }
                            return r.f317a;
                        }

                        public final Object invoke(boolean z10, H7.c<? super r> cVar) {
                            return ((C01101) create(Boolean.valueOf(z10), cVar)).invokeSuspend(r.f317a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass2(j jVar, TooltipState tooltipState, H7.c<? super AnonymousClass2> cVar) {
                        super(2, cVar);
                        this.$isLongPressedFlow = jVar;
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                        return new AnonymousClass2(this.$isLongPressedFlow, this.$state, cVar);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
                    
                        if (r6 == r0) goto L26;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r3v0 */
                    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.material3.TooltipState] */
                    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                        /*
                            r6 = this;
                            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                            int r1 = r6.label
                            r2 = 0
                            r3 = 3
                            r4 = 2
                            r5 = 1
                            if (r1 == 0) goto L2a
                            if (r1 == r5) goto L24
                            if (r1 == r4) goto L20
                            if (r1 == r3) goto L18
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L18:
                            java.lang.Object r6 = r6.L$0
                            java.lang.Throwable r6 = (java.lang.Throwable) r6
                            kotlin.b.b(r7)
                            goto L6d
                        L20:
                            kotlin.b.b(r7)
                            goto L55
                        L24:
                            kotlin.b.b(r7)     // Catch: java.lang.Throwable -> L28
                            goto L43
                        L28:
                            r7 = move-exception
                            goto L58
                        L2a:
                            kotlin.b.b(r7)
                            p9.j r7 = r6.$isLongPressedFlow     // Catch: java.lang.Throwable -> L28
                            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L28
                            kotlinx.coroutines.flow.i r7 = (kotlinx.coroutines.flow.i) r7     // Catch: java.lang.Throwable -> L28
                            r7.i(r1)     // Catch: java.lang.Throwable -> L28
                            androidx.compose.material3.TooltipState r7 = r6.$state     // Catch: java.lang.Throwable -> L28
                            androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.PreventUserInput     // Catch: java.lang.Throwable -> L28
                            r6.label = r5     // Catch: java.lang.Throwable -> L28
                            java.lang.Object r7 = r7.show(r1, r6)     // Catch: java.lang.Throwable -> L28
                            if (r7 != r0) goto L43
                            goto L6b
                        L43:
                            p9.j r7 = r6.$isLongPressedFlow
                            androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1 r1 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1
                            androidx.compose.material3.TooltipState r3 = r6.$state
                            r1.<init>(r3, r2)
                            r6.label = r4
                            java.lang.Object r6 = kotlinx.coroutines.flow.d.d(r7, r1, r6)
                            if (r6 != r0) goto L55
                            goto L6b
                        L55:
                            C7.r r6 = C7.r.f317a
                            return r6
                        L58:
                            p9.j r1 = r6.$isLongPressedFlow
                            androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1 r4 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1
                            androidx.compose.material3.TooltipState r5 = r6.$state
                            r4.<init>(r5, r2)
                            r6.L$0 = r7
                            r6.label = r3
                            java.lang.Object r6 = kotlinx.coroutines.flow.d.d(r1, r4, r6)
                            if (r6 != r0) goto L6c
                        L6b:
                            return r0
                        L6c:
                            r6 = r7
                        L6d:
                            throw r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt.C06761.C01071.C01081.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // S7.n
                    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                        return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01081(InterfaceC1733z interfaceC1733z, TooltipState tooltipState, H7.c<? super C01081> cVar) {
                    super(2, cVar);
                    this.$$this$coroutineScope = interfaceC1733z;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    C01081 c01081 = new C01081(this.$$this$coroutineScope, this.$state, cVar);
                    c01081.L$0 = obj;
                    return c01081;
                }

                @Override // S7.n
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
                    return ((C01081) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:35:0x00dc, code lost:
                
                    if (r15 == r0) goto L36;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r14v0, types: [androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1] */
                /* JADX WARN: Type inference failed for: r14v1 */
                /* JADX WARN: Type inference failed for: r14v10 */
                /* JADX WARN: Type inference failed for: r14v18 */
                /* JADX WARN: Type inference failed for: r14v19 */
                /* JADX WARN: Type inference failed for: r3v1 */
                /* JADX WARN: Type inference failed for: r3v4 */
                /* JADX WARN: Type inference failed for: r3v7, types: [p9.j] */
                /* JADX WARN: Type inference failed for: r8v4, types: [p9.j] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instructions count: 254
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt.C06761.C01071.C01081.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01071(PointerInputScope pointerInputScope, TooltipState tooltipState, H7.c<? super C01071> cVar) {
                super(2, cVar);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = tooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C01071 c01071 = new C01071(this.$$this$pointerInput, this.$state, cVar);
                c01071.L$0 = obj;
                return c01071;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C01081 c01081 = new C01081(interfaceC1733z, this.$state, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c01081, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01071) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06761(TooltipState tooltipState, H7.c<? super C06761> cVar) {
            super(2, cVar);
            this.$state = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C06761 c06761 = new C06761(this.$state, cVar);
            c06761.L$0 = obj;
            return c06761;
        }

        @Override // S7.n
        public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
            return ((C06761) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                C01071 c01071 = new C01071((PointerInputScope) this.L$0, this.$state, null);
                this.label = 1;
                if (AbstractC1683A.f(c01071, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2", f = "BasicTooltip.android.kt", l = {ComposerKt.reuseKey}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06772 extends SuspendLambda implements n {
        final /* synthetic */ TooltipState $state;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1", f = "BasicTooltip.android.kt", l = {208}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ TooltipState $state;
            private /* synthetic */ Object L$0;
            int label;

            @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1", f = "BasicTooltip.android.kt", l = {212}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01111 extends RestrictedSuspendLambda implements n {
                final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
                final /* synthetic */ TooltipState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1", f = "BasicTooltip.android.kt", l = {217}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C01121 extends SuspendLambda implements n {
                    final /* synthetic */ TooltipState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C01121(TooltipState tooltipState, H7.c<? super C01121> cVar) {
                        super(2, cVar);
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                        return new C01121(this.$state, cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                        int i = this.label;
                        if (i == 0) {
                            b.b(obj);
                            TooltipState tooltipState = this.$state;
                            MutatePriority mutatePriority = MutatePriority.UserInput;
                            this.label = 1;
                            if (tooltipState.show(mutatePriority, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            b.b(obj);
                        }
                        return r.f317a;
                    }

                    @Override // S7.n
                    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                        return ((C01121) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01111(InterfaceC1733z interfaceC1733z, TooltipState tooltipState, H7.c<? super C01111> cVar) {
                    super(2, cVar);
                    this.$$this$coroutineScope = interfaceC1733z;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    C01111 c01111 = new C01111(this.$$this$coroutineScope, this.$state, cVar);
                    c01111.L$0 = obj;
                    return c01111;
                }

                @Override // S7.n
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
                    return ((C01111) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
                }

                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0031 -> B:12:0x0034). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                    /*
                        r7 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                        int r1 = r7.label
                        r2 = 1
                        if (r1 == 0) goto L1d
                        if (r1 != r2) goto L15
                        java.lang.Object r1 = r7.L$1
                        androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                        java.lang.Object r3 = r7.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                        kotlin.b.b(r8)
                        goto L34
                    L15:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L1d:
                        kotlin.b.b(r8)
                        java.lang.Object r8 = r7.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
                        androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                        r3 = r8
                    L27:
                        r7.L$0 = r3
                        r7.L$1 = r1
                        r7.label = r2
                        java.lang.Object r8 = r3.awaitPointerEvent(r1, r7)
                        if (r8 != r0) goto L34
                        return r0
                    L34:
                        androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
                        java.util.List r4 = r8.getChanges()
                        r5 = 0
                        java.lang.Object r4 = r4.get(r5)
                        androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                        int r4 = r4.getType()
                        androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
                        int r5 = r5.m5497getMouseT8wyACA()
                        boolean r4 = androidx.compose.ui.input.pointer.PointerType.m5492equalsimpl0(r4, r5)
                        if (r4 == 0) goto L27
                        int r8 = r8.getType()
                        androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                        int r5 = r4.m5374getEnter7fucELk()
                        boolean r5 = androidx.compose.ui.input.pointer.PointerEventType.m5370equalsimpl0(r8, r5)
                        if (r5 == 0) goto L70
                        m9.z r8 = r7.$$this$coroutineScope
                        androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1 r4 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$2$1$1$1
                        androidx.compose.material3.TooltipState r5 = r7.$state
                        r6 = 0
                        r4.<init>(r5, r6)
                        r5 = 3
                        m9.AbstractC1683A.n(r8, r6, r4, r5)
                        goto L27
                    L70:
                        int r4 = r4.m5375getExit7fucELk()
                        boolean r8 = androidx.compose.ui.input.pointer.PointerEventType.m5370equalsimpl0(r8, r4)
                        if (r8 == 0) goto L27
                        androidx.compose.material3.TooltipState r8 = r7.$state
                        r8.dismiss()
                        goto L27
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt.C06772.AnonymousClass1.C01111.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(PointerInputScope pointerInputScope, TooltipState tooltipState, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = tooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$state, cVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C01111 c01111 = new C01111(interfaceC1733z, this.$state, null);
                    this.label = 1;
                    if (pointerInputScope.awaitPointerEventScope(c01111, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06772(TooltipState tooltipState, H7.c<? super C06772> cVar) {
            super(2, cVar);
            this.$state = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C06772 c06772 = new C06772(this.$state, cVar);
            c06772.L$0 = obj;
            return c06772;
        }

        @Override // S7.n
        public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
            return ((C06772) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.L$0, this.$state, null);
                this.label = 1;
                if (AbstractC1683A.f(anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ff  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTooltipBox(final androidx.compose.ui.window.PopupPositionProvider r17, final S7.n r18, androidx.compose.material3.TooltipState r19, androidx.compose.ui.Modifier r20, boolean r21, boolean r22, final S7.n r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt.BasicTooltipBox(androidx.compose.ui.window.PopupPositionProvider, S7.n, androidx.compose.material3.TooltipState, androidx.compose.ui.Modifier, boolean, boolean, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void TooltipPopup(final PopupPositionProvider popupPositionProvider, final TooltipState tooltipState, final InterfaceC1733z interfaceC1733z, final boolean z10, final n nVar, Composer composer, final int i) throws Resources.NotFoundException {
        PopupPositionProvider popupPositionProvider2;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-273292979);
        if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i6 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= (i & 64) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(interfaceC1733z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273292979, i6, -1, "androidx.compose.material3.internal.TooltipPopup (BasicTooltip.android.kt:135)");
            }
            boolean z11 = false;
            final String strStringResource = StringResources_androidKt.stringResource(R.string.tooltip_description, composerStartRestartGroup, 0);
            if ((i6 & 112) == 32 || ((i6 & 64) != 0 && composerStartRestartGroup.changedInstance(tooltipState))) {
                z11 = true;
            }
            boolean zChangedInstance = z11 | composerStartRestartGroup.changedInstance(interfaceC1733z);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new S7.a() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt$TooltipPopup$1$1

                    @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$TooltipPopup$1$1$1", f = "BasicTooltip.android.kt", l = {}, m = "invokeSuspend")
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$TooltipPopup$1$1$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends SuspendLambda implements n {
                        final /* synthetic */ TooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(TooltipState tooltipState, H7.c<? super AnonymousClass1> cVar) {
                            super(2, cVar);
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                            return new AnonymousClass1(this.$state, cVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            b.b(obj);
                            this.$state.dismiss();
                            return r.f317a;
                        }

                        @Override // S7.n
                        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2669invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2669invoke() {
                        if (tooltipState.getIsVisible()) {
                            AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(tooltipState, null), 3);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            AndroidPopup_androidKt.Popup(popupPositionProvider2, (S7.a) objRememberedValue, new PopupProperties(z10, false, false, false, 14, (e) null), ComposableLambdaKt.rememberComposableLambda(610617071, true, new n() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.TooltipPopup.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(610617071, i10, -1, "androidx.compose.material3.internal.TooltipPopup.<anonymous> (BasicTooltip.android.kt:146)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    boolean zChanged = composer2.changed(strStringResource);
                    final String str = strStringResource;
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new k() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt$TooltipPopup$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return r.f317a;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m6099setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m6072getAssertive0phEisY());
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (k) objRememberedValue2, 1, null);
                    n nVar2 = nVar;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierSemantics$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer2);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    if (androidx.appfunctions.metadata.a.C(nVar2, composer2, 0)) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.TooltipPopup.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) throws Resources.NotFoundException {
                    BasicTooltip_androidKt.TooltipPopup(popupPositionProvider, tooltipState, interfaceC1733z, z10, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void WrappedAnchor(final boolean z10, final TooltipState tooltipState, Modifier modifier, final n nVar, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1848240995);
        if ((i6 & 1) != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i6 & 2) != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= (i & 64) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        int i11 = i6 & 4;
        if (i11 != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i10 |= 3072;
        } else if ((i & 3072) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 2048 : 1024;
        }
        if ((i10 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1848240995, i10, -1, "androidx.compose.material3.internal.WrappedAnchor (BasicTooltip.android.kt:115)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composerStartRestartGroup), composerStartRestartGroup);
            }
            Modifier modifierAnchorSemantics = anchorSemantics(handleGestures(modifier, z10, tooltipState), StringResources_androidKt.stringResource(R.string.tooltip_label, composerStartRestartGroup, 0), z10, tooltipState, ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope());
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchorSemantics);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (androidx.appfunctions.metadata.a.C(nVar, composerStartRestartGroup, (i10 >> 9) & 14)) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.WrappedAnchor.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    BasicTooltip_androidKt.WrappedAnchor(z10, tooltipState, modifier2, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    private static final Modifier anchorSemantics(Modifier modifier, final String str, boolean z10, final TooltipState tooltipState, final InterfaceC1733z interfaceC1733z) {
        return z10 ? SemanticsModifierKt.semantics(modifier, true, new k() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.anchorSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                String str2 = str;
                final InterfaceC1733z interfaceC1733z2 = interfaceC1733z;
                final TooltipState tooltipState2 = tooltipState;
                SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, str2, new S7.a() { // from class: androidx.compose.material3.internal.BasicTooltip_androidKt.anchorSemantics.1.1

                    @c(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$anchorSemantics$1$1$1", f = "BasicTooltip.android.kt", l = {241}, m = "invokeSuspend")
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$anchorSemantics$1$1$1, reason: invalid class name and collision with other inner class name */
                    public static final class C01061 extends SuspendLambda implements n {
                        final /* synthetic */ TooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C01061(TooltipState tooltipState, H7.c<? super C01061> cVar) {
                            super(2, cVar);
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                            return new C01061(this.$state, cVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                            int i = this.label;
                            if (i == 0) {
                                b.b(obj);
                                TooltipState tooltipState = this.$state;
                                this.label = 1;
                                if (TooltipState.show$default(tooltipState, null, this, 1, null) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                b.b(obj);
                            }
                            return r.f317a;
                        }

                        @Override // S7.n
                        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                            return ((C01061) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Boolean invoke() {
                        AbstractC1683A.n(interfaceC1733z2, null, new C01061(tooltipState2, null), 3);
                        return Boolean.TRUE;
                    }
                });
            }
        }) : modifier;
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z10, TooltipState tooltipState) {
        return z10 ? modifier.then(new SuspendPointerInputElement(tooltipState, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new C06761(tooltipState, null)), 6, null)).then(new SuspendPointerInputElement(tooltipState, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new C06772(tooltipState, null)), 6, null)) : modifier;
    }
}
