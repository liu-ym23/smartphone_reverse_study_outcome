package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0015H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/SecureTextFieldController;", "", "obfuscationMaskState", "Landroidx/compose/runtime/State;", "", "<init>", "(Landroidx/compose/runtime/State;)V", "passwordInputTransformation", "Landroidx/compose/foundation/text/PasswordInputTransformation;", "getPasswordInputTransformation", "()Landroidx/compose/foundation/text/PasswordInputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "getCodepointTransformation", "()Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "focusChangeModifier", "Landroidx/compose/ui/Modifier;", "getFocusChangeModifier", "()Landroidx/compose/ui/Modifier;", "resetTimerSignal", "Lkotlinx/coroutines/channels/Channel;", "", "observeHideEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleHide", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SecureTextFieldController {
    public static final int $stable = 8;
    private final CodepointTransformation codepointTransformation;
    private final Modifier focusChangeModifier;
    private final State<Character> obfuscationMaskState;
    private final PasswordInputTransformation passwordInputTransformation;
    private final Channel<Unit> resetTimerSignal;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.SecureTextFieldController$observeHideEvents$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.SecureTextFieldController$observeHideEvents$2", f = "BasicSecureTextField.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SecureTextFieldController this$0;

        public AnonymousClass2(SecureTextFieldController r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Unit r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            this.this$0.getPasswordInputTransformation().hide();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            this.label = 1;
            if (DelayKt.delay(1500, this) != r101) goto L11;
            return r101;
        }
    }

    public static /* synthetic */ int a(SecureTextFieldController r100, int r101, int r102) {
        return codepointTransformation$lambda$0(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(SecureTextFieldController r100, FocusState r101) {
        return focusChangeModifier$lambda$1(r100, r101);
    }

    private final void scheduleHide() {
        Object r100 = this.resetTimerSignal.mo10962trySendJP2dKIU(Unit.INSTANCE);
        kotlinx.coroutines.channels.g.c r101 = kotlinx.coroutines.channels.g.f504696b;
        if ((r100 instanceof kotlinx.coroutines.channels.g.c) == false) goto L6;
        this.passwordInputTransformation.hide();
        return;
    }

    public final CodepointTransformation getCodepointTransformation() {
        return this.codepointTransformation;
    }

    public final Modifier getFocusChangeModifier() {
        return this.focusChangeModifier;
    }

    public final PasswordInputTransformation getPasswordInputTransformation() {
        return this.passwordInputTransformation;
    }

    public SecureTextFieldController(State<Character> r100) {
        this.obfuscationMaskState = r100;
        this.passwordInputTransformation = new PasswordInputTransformation(new SecureTextFieldController$passwordInputTransformation$1(this));
        this.codepointTransformation = new f3(this);
        this.focusChangeModifier = FocusChangedModifierKt.onFocusChanged(Modifier.Companion, new g3(this));
        this.resetTimerSignal = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    public static final /* synthetic */ void access$scheduleHide(SecureTextFieldController r100) {
        r100.scheduleHide();
    }

    public final Object observeHideEvents(Continuation<? super Unit> r100) {
        Object r101 = kotlinx.coroutines.flow.e.i(kotlinx.coroutines.flow.e.l(this.resetTimerSignal), new AnonymousClass2(this, null), r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit focusChangeModifier$lambda$1(SecureTextFieldController r100, FocusState r101) {
        if (r101.isFocused() == true) goto L6;
        r100.passwordInputTransformation.hide();
    L6:
        return Unit.INSTANCE;
    }

    private static final int codepointTransformation$lambda$0(SecureTextFieldController r100, int r101, int r102) {
        if (r101 != r100.passwordInputTransformation.getRevealCodepointIndex$foundation_release()) goto L6;
        return r102;
    L6:
        return r100.obfuscationMaskState.getValue().charValue();
    }
}
