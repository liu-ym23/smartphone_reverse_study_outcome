package androidx.compose.foundation;

import C7.r;
import J7.c;
import S7.n;
import androidx.compose.foundation.DefaultDebugIndication;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import m9.InterfaceC1733z;
import p9.d;

@c(c = "androidx.compose.foundation.DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1", f = "Indication.kt", l = {240}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1 extends SuspendLambda implements n {
    int label;
    final /* synthetic */ DefaultDebugIndication.DefaultDebugIndicationInstance this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance, H7.c<? super DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1> cVar) {
        super(2, cVar);
        this.this$0 = defaultDebugIndicationInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            final Ref$IntRef ref$IntRef3 = new Ref$IntRef();
            p9.c interactions = this.this$0.interactionSource.getInteractions();
            final DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance = this.this$0;
            d dVar = new d() { // from class: androidx.compose.foundation.DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1.1
                @Override // p9.d
                public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                    return emit((Interaction) obj2, (H7.c<? super r>) cVar);
                }

                public final Object emit(Interaction interaction, H7.c<? super r> cVar) {
                    boolean z10 = true;
                    if (interaction instanceof PressInteraction.Press) {
                        ref$IntRef.f4918a++;
                    } else if (interaction instanceof PressInteraction.Release) {
                        Ref$IntRef ref$IntRef4 = ref$IntRef;
                        ref$IntRef4.f4918a--;
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        Ref$IntRef ref$IntRef5 = ref$IntRef;
                        ref$IntRef5.f4918a--;
                    } else if (interaction instanceof HoverInteraction.Enter) {
                        ref$IntRef2.f4918a++;
                    } else if (interaction instanceof HoverInteraction.Exit) {
                        Ref$IntRef ref$IntRef6 = ref$IntRef2;
                        ref$IntRef6.f4918a--;
                    } else if (interaction instanceof FocusInteraction.Focus) {
                        ref$IntRef3.f4918a++;
                    } else if (interaction instanceof FocusInteraction.Unfocus) {
                        Ref$IntRef ref$IntRef7 = ref$IntRef3;
                        ref$IntRef7.f4918a--;
                    }
                    boolean z11 = false;
                    boolean z12 = ref$IntRef.f4918a > 0;
                    boolean z13 = ref$IntRef2.f4918a > 0;
                    boolean z14 = ref$IntRef3.f4918a > 0;
                    if (defaultDebugIndicationInstance.isPressed != z12) {
                        defaultDebugIndicationInstance.isPressed = z12;
                        z11 = true;
                    }
                    if (defaultDebugIndicationInstance.isHovered != z13) {
                        defaultDebugIndicationInstance.isHovered = z13;
                        z11 = true;
                    }
                    if (defaultDebugIndicationInstance.isFocused != z14) {
                        defaultDebugIndicationInstance.isFocused = z14;
                    } else {
                        z10 = z11;
                    }
                    if (z10) {
                        DrawModifierNodeKt.invalidateDraw(defaultDebugIndicationInstance);
                    }
                    return r.f317a;
                }
            };
            this.label = 1;
            if (interactions.collect(dVar, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
