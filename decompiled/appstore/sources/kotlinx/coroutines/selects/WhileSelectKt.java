package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class WhileSelectKt {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004c -> B:18:0x004f). Please report as a decompilation issue!!! */
    public static final Object a(Function1 r10, Continuation r11) {
        if ((r11 instanceof WhileSelectKt$whileSelect$1) == false) goto L7;
        WhileSelectKt$whileSelect$1 r12 = (WhileSelectKt$whileSelect$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (Function1) r12.L$0;
        kotlin.c.b(r14);
    L19:
        if (((Boolean) r14).booleanValue() == false) goto L21;
    L15:
        SelectImplementation r17 = new SelectImplementation(r12.getContext());
        r10.invoke(r17);
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r17.j(r12);
        if (r14 != r15) goto L19;
        return r15;
    L21:
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
    L7:
        r12 = new WhileSelectKt$whileSelect$1(r11);
        goto L8
    }
}
