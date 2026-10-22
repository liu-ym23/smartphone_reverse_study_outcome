package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AwaitKt {
    public static final Object a(Collection r10, Continuation r11) {
        if (r10.isEmpty() == false) goto L7;
        return kotlin.collections.t.i();
    L7:
        return new e((Deferred[]) r10.toArray(new Deferred[0])).c(r11);
    }

    public static final Object b(Collection r10, Continuation r11) {
        if ((r11 instanceof AwaitKt$joinAll$3) == false) goto L7;
        AwaitKt$joinAll$3 r12 = (AwaitKt$joinAll$3) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Iterator r17 = (Iterator) r12.L$0;
        kotlin.c.b(r14);
    L16:
        if (r17.hasNext() == false) goto L21;
        Job r18 = (Job) r17.next();
        r12.L$0 = r17;
        r12.label = 1;
        if (r18.join(r12) != r15) goto L16;
        return r15;
    L21:
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        r17 = r10.iterator();
    L7:
        r12 = new AwaitKt$joinAll$3(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:19:0x0055). Please report as a decompilation issue!!! */
    public static final Object c(Job[] r10, Continuation r11) {
        if ((r11 instanceof AwaitKt$joinAll$1) == false) goto L7;
        AwaitKt$joinAll$1 r12 = (AwaitKt$joinAll$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        int r17 = r12.I$1;
        int r18 = r12.I$0;
        Job[] r19 = (Job[]) r12.L$0;
        kotlin.c.b(r14);
        Job[] r20 = r19;
    L19:
        r18 = r18 + 1;
    L15:
        if (r18 >= r17) goto L21;
        Job r21 = r20[r18];
        r12.L$0 = r20;
        r12.I$0 = r18;
        r12.I$1 = r17;
        r12.label = 1;
        if (r21.join(r12) != r15) goto L19;
        return r15;
    L21:
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        r18 = 0;
        r20 = r10;
        r17 = r10.length;
    L7:
        r12 = new AwaitKt$joinAll$1(r11);
        goto L8
    }
}
