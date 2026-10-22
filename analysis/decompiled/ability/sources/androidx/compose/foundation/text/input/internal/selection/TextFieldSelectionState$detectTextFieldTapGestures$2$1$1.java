package androidx.compose.foundation.text.input.internal.selection;

import C7.r;
import J7.c;
import S7.n;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1", f = "TextFieldSelectionState.kt", l = {TypedValues.PositionType.TYPE_PERCENT_HEIGHT, 511}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 extends SuspendLambda implements n {
    final /* synthetic */ PressGestureScope $$this$detectTapAndPress;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldSelectionState this$0;

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1", f = "TextFieldSelectionState.kt", l = {496, TypedValues.PositionType.TYPE_TRANSITION_EASING}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ long $offset;
        Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TextFieldSelectionState textFieldSelectionState, long j5, MutableInteractionSource mutableInteractionSource, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = textFieldSelectionState;
            this.$offset = j5;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$offset, this.$interactionSource, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
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
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L1d
                if (r1 != r3) goto L15
                java.lang.Object r0 = r7.L$0
                androidx.compose.foundation.interaction.PressInteraction$Press r0 = (androidx.compose.foundation.interaction.PressInteraction.Press) r0
                kotlin.b.b(r8)
                goto L5d
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1d:
                java.lang.Object r1 = r7.L$0
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r1
                kotlin.b.b(r8)
                goto L45
            L25:
                kotlin.b.b(r8)
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r8 = r7.this$0
                androidx.compose.foundation.interaction.PressInteraction$Press r8 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$getPressInteraction$p(r8)
                if (r8 == 0) goto L48
                androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.$interactionSource
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r5 = r7.this$0
                androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                r6.<init>(r8)
                r7.L$0 = r5
                r7.label = r4
                java.lang.Object r8 = r1.emit(r6, r7)
                if (r8 != r0) goto L44
                goto L5b
            L44:
                r1 = r5
            L45:
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$setPressInteraction$p(r1, r2)
            L48:
                androidx.compose.foundation.interaction.PressInteraction$Press r8 = new androidx.compose.foundation.interaction.PressInteraction$Press
                long r4 = r7.$offset
                r8.<init>(r4, r2)
                androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.$interactionSource
                r7.L$0 = r8
                r7.label = r3
                java.lang.Object r1 = r1.emit(r8, r7)
                if (r1 != r0) goto L5c
            L5b:
                return r0
            L5c:
                r0 = r8
            L5d:
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r7 = r7.this$0
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$setPressInteraction$p(r7, r0)
                C7.r r7 = C7.r.f317a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(PressGestureScope pressGestureScope, TextFieldSelectionState textFieldSelectionState, long j5, MutableInteractionSource mutableInteractionSource, H7.c<? super TextFieldSelectionState$detectTextFieldTapGestures$2$1$1> cVar) {
        super(2, cVar);
        this.$$this$detectTapAndPress = pressGestureScope;
        this.this$0 = textFieldSelectionState;
        this.$offset = j5;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 textFieldSelectionState$detectTextFieldTapGestures$2$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(this.$$this$detectTapAndPress, this.this$0, this.$offset, this.$interactionSource, cVar);
        textFieldSelectionState$detectTextFieldTapGestures$2$1$1.L$0 = obj;
        return textFieldSelectionState$detectTextFieldTapGestures$2$1$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r4.emit(r12, r11) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r11.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1d
            if (r1 == r4) goto L19
            if (r1 != r3) goto L11
            kotlin.b.b(r12)
            goto L65
        L11:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L19:
            kotlin.b.b(r12)
            goto L3f
        L1d:
            kotlin.b.b(r12)
            java.lang.Object r12 = r11.L$0
            m9.z r12 = (m9.InterfaceC1733z) r12
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1 r5 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r11.this$0
            long r7 = r11.$offset
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r11.$interactionSource
            r10 = 0
            r5.<init>(r6, r7, r9, r10)
            r1 = 3
            m9.AbstractC1683A.n(r12, r2, r5, r1)
            androidx.compose.foundation.gestures.PressGestureScope r12 = r11.$$this$detectTapAndPress
            r11.label = r4
            java.lang.Object r12 = r12.tryAwaitRelease(r11)
            if (r12 != r0) goto L3f
            goto L64
        L3f:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = r11.this$0
            androidx.compose.foundation.interaction.PressInteraction$Press r1 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$getPressInteraction$p(r1)
            if (r1 == 0) goto L65
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r11.$interactionSource
            if (r12 == 0) goto L57
            androidx.compose.foundation.interaction.PressInteraction$Release r12 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r12.<init>(r1)
            goto L5c
        L57:
            androidx.compose.foundation.interaction.PressInteraction$Cancel r12 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r12.<init>(r1)
        L5c:
            r11.label = r3
            java.lang.Object r12 = r4.emit(r12, r11)
            if (r12 != r0) goto L65
        L64:
            return r0
        L65:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r11 = r11.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$setPressInteraction$p(r11, r2)
            C7.r r11 = C7.r.f317a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((TextFieldSelectionState$detectTextFieldTapGestures$2$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
