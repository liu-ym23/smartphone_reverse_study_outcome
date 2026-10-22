package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import android.net.Uri;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.WakeService$Companion$wake$5", f = "WakeService.kt", l = {1550, 1561}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class WakeService$Companion$wake$5 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appCtx;
    final /* synthetic */ String $text;
    final /* synthetic */ List<Uri> $uris;
    Object L$0;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WakeService$Companion$wake$5(String str, List<? extends Uri> list, Context context, InterfaceC4014c<? super WakeService$Companion$wake$5> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$text = str;
        this.$uris = list;
        this.$appCtx = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new WakeService$Companion$wake$5(this.$text, this.$uris, this.$appCtx, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((WakeService$Companion$wake$5) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
    
        if (r7 == r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            java.lang.Object r0 = r6.L$0
            com.stepos.ailauncher.chat.wake.WakeService$a r0 = (com.stepos.ailauncher.chat.wake.WakeService.SharePayload) r0
            kotlin.C4849c.b(r7)
            goto L90
        L18:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L20:
            kotlin.C4849c.b(r7)
            goto L3f
        L24:
            kotlin.C4849c.b(r7)
            Ua.A0 r7 = Ua.Y.c()
            Ua.A0 r7 = r7.getImmediate()
            com.stepos.ailauncher.chat.wake.WakeService$Companion$wake$5$allowed$1 r1 = new com.stepos.ailauncher.chat.wake.WakeService$Companion$wake$5$allowed$1
            android.content.Context r5 = r6.$appCtx
            r1.<init>(r5, r4)
            r6.label = r3
            java.lang.Object r7 = Ua.C1056g.j(r7, r1, r6)
            if (r7 != r0) goto L3f
            goto L8f
        L3f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L4f
            com.stepos.ailauncher.chat.wake.WakeService$Companion r6 = com.stepos.ailauncher.chat.wake.WakeService.INSTANCE
            r6.u1(r4)
            Y8.t r6 = Y8.t.f7040a
            return r6
        L4f:
            java.lang.String r1 = r6.$text
            if (r1 == 0) goto L5a
            boolean r3 = La.H.x0(r1)
            if (r3 != 0) goto L5a
            goto L5b
        L5a:
            r1 = r4
        L5b:
            java.util.List<android.net.Uri> r3 = r6.$uris
            com.stepos.ailauncher.chat.wake.WakeService$a r5 = new com.stepos.ailauncher.chat.wake.WakeService$a
            r5.<init>(r1, r3)
            com.stepos.ailauncher.chat.wake.WakeService$Companion r1 = com.stepos.ailauncher.chat.wake.WakeService.INSTANCE
            r1.u1(r5)
            java.lang.String r3 = "share_agent"
            r1.v1(r3)
            com.stepos.ailauncher.chat.trace.ChatTracker r1 = com.stepos.ailauncher.chat.trace.ChatTracker.INSTANCE
            r1.y(r3)
            Ua.A0 r1 = Ua.Y.c()
            Ua.A0 r1 = r1.getImmediate()
            com.stepos.ailauncher.chat.wake.WakeService$Companion$wake$5$handled$1 r3 = new com.stepos.ailauncher.chat.wake.WakeService$Companion$wake$5$handled$1
            r3.<init>(r5, r4)
            java.lang.Object r4 = g9.h.a(r5)
            r6.L$0 = r4
            r6.Z$0 = r7
            r6.label = r2
            java.lang.Object r7 = Ua.C1056g.j(r1, r3, r6)
            if (r7 != r0) goto L90
        L8f:
            return r0
        L90:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L9b
            Y8.t r6 = Y8.t.f7040a
            return r6
        L9b:
            android.content.Intent r7 = new android.content.Intent
            android.content.Context r0 = r6.$appCtx
            java.lang.Class<com.stepos.ailauncher.chat.wake.WakeService> r1 = com.stepos.ailauncher.chat.wake.WakeService.class
            r7.<init>(r0, r1)
            java.lang.String r0 = "com.stepos.ailauncher.action.WAKE"
            r7.setAction(r0)
            android.content.Context r6 = r6.$appCtx
            r6.startService(r7)
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeService$Companion$wake$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
