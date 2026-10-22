package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.WakeService$Companion$sendTextToVisibleChatOrWake$1", f = "WakeService.kt", l = {1639, 1641}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class WakeService$Companion$sendTextToVisibleChatOrWake$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appCtx;
    final /* synthetic */ String $text;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WakeService$Companion$sendTextToVisibleChatOrWake$1(Context context, String str, InterfaceC4014c<? super WakeService$Companion$sendTextToVisibleChatOrWake$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$appCtx = context;
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new WakeService$Companion$sendTextToVisibleChatOrWake$1(this.$appCtx, this.$text, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((WakeService$Companion$sendTextToVisibleChatOrWake$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (r9 == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r8.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1f
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.C4849c.b(r9)
            goto L5f
        L13:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1b:
            kotlin.C4849c.b(r9)
            goto L3a
        L1f:
            kotlin.C4849c.b(r9)
            Ua.A0 r9 = Ua.Y.c()
            Ua.A0 r9 = r9.getImmediate()
            com.stepos.ailauncher.chat.wake.WakeService$Companion$sendTextToVisibleChatOrWake$1$allowed$1 r1 = new com.stepos.ailauncher.chat.wake.WakeService$Companion$sendTextToVisibleChatOrWake$1$allowed$1
            android.content.Context r5 = r8.$appCtx
            r1.<init>(r5, r2)
            r8.label = r4
            java.lang.Object r9 = Ua.C1056g.j(r9, r1, r8)
            if (r9 != r0) goto L3a
            goto L5e
        L3a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L45
            Y8.t r8 = Y8.t.f7040a
            return r8
        L45:
            Ua.A0 r1 = Ua.Y.c()
            Ua.A0 r1 = r1.getImmediate()
            com.stepos.ailauncher.chat.wake.WakeService$Companion$sendTextToVisibleChatOrWake$1$handledInPlace$1 r4 = new com.stepos.ailauncher.chat.wake.WakeService$Companion$sendTextToVisibleChatOrWake$1$handledInPlace$1
            java.lang.String r5 = r8.$text
            r4.<init>(r5, r2)
            r8.Z$0 = r9
            r8.label = r3
            java.lang.Object r9 = Ua.C1056g.j(r1, r4, r8)
            if (r9 != r0) goto L5f
        L5e:
            return r0
        L5f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L6a
            Y8.t r8 = Y8.t.f7040a
            return r8
        L6a:
            com.stepos.ailauncher.chat.wake.WakeService$Companion r0 = com.stepos.ailauncher.chat.wake.WakeService.INSTANCE
            android.content.Context r1 = r8.$appCtx
            kotlin.jvm.internal.p.f(r1)
            java.lang.String r2 = r8.$text
            r6 = 16
            r7 = 0
            r3 = 0
            r4 = 1
            r5 = 0
            com.stepos.ailauncher.chat.wake.WakeService.Companion.N1(r0, r1, r2, r3, r4, r5, r6, r7)
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeService$Companion$sendTextToVisibleChatOrWake$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
