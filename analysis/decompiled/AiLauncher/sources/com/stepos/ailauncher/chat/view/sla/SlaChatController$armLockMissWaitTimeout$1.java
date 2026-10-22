package com.stepos.ailauncher.chat.view.sla;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.sla.SlaGate;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C0919o;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$armLockMissWaitTimeout$1", f = "SlaChatController.kt", l = {925, 926}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaChatController$armLockMissWaitTimeout$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    int label;
    final /* synthetic */ SlaChatController this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$armLockMissWaitTimeout$1$1", f = "SlaChatController.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.SlaChatController$armLockMissWaitTimeout$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        int label;
        final /* synthetic */ SlaChatController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SlaChatController slaChatController, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = slaChatController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!SlaGate.INSTANCE.d()) {
                return t.f7040a;
            }
            C4148a.u("SlaChatController", "lockMiss 等待解锁超时 120000ms -> drop", false, 4, null);
            C0919o.d(SlaGate.TAG, "等待解锁超时,放弃重放", false, 4, null);
            this.this$0.getGate().I();
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaChatController$armLockMissWaitTimeout$1(SlaChatController slaChatController, InterfaceC4014c<? super SlaChatController$armLockMissWaitTimeout$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = slaChatController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SlaChatController$armLockMissWaitTimeout$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SlaChatController$armLockMissWaitTimeout$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (Ua.C1056g.j(r6, r1, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r6)
            goto L42
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1a:
            kotlin.C4849c.b(r6)
            goto L2d
        L1e:
            kotlin.C4849c.b(r6)
            r5.label = r3
            r3 = 120000(0x1d4c0, double:5.9288E-319)
            java.lang.Object r6 = Ua.U.a(r3, r5)
            if (r6 != r0) goto L2d
            goto L41
        L2d:
            Ua.A0 r6 = Ua.Y.c()
            com.stepos.ailauncher.chat.view.sla.SlaChatController$armLockMissWaitTimeout$1$1 r1 = new com.stepos.ailauncher.chat.view.sla.SlaChatController$armLockMissWaitTimeout$1$1
            com.stepos.ailauncher.chat.view.sla.SlaChatController r3 = r5.this$0
            r4 = 0
            r1.<init>(r3, r4)
            r5.label = r2
            java.lang.Object r5 = Ua.C1056g.j(r6, r1, r5)
            if (r5 != r0) goto L42
        L41:
            return r0
        L42:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController$armLockMissWaitTimeout$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
