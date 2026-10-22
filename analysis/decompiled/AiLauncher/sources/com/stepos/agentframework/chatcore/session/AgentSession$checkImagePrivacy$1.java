package com.stepos.agentframework.chatcore.session;

import android.content.Context;
import com.stepos.agentframework.chatcore.file.FileInfo;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$checkImagePrivacy$1", f = "AgentSession.kt", l = {1437}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$checkImagePrivacy$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ FileInfo $fileInfo;
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onResult;
    final /* synthetic */ String $traceId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AgentSession this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$checkImagePrivacy$1$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$checkImagePrivacy$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onResult;
        final /* synthetic */ boolean $passed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, boolean z10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onResult = interfaceC5074l;
            this.$passed = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onResult, this.$passed, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$onResult.invoke(C4109a.a(this.$passed));
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$checkImagePrivacy$1(FileInfo fileInfo, Context context, AgentSession agentSession, String str, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, InterfaceC4014c<? super AgentSession$checkImagePrivacy$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileInfo = fileInfo;
        this.$context = context;
        this.this$0 = agentSession;
        this.$traceId = str;
        this.$onResult = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentSession$checkImagePrivacy$1 agentSession$checkImagePrivacy$1 = new AgentSession$checkImagePrivacy$1(this.$fileInfo, this.$context, this.this$0, this.$traceId, this.$onResult, interfaceC4014c);
        agentSession$checkImagePrivacy$1.L$0 = obj;
        return agentSession$checkImagePrivacy$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$checkImagePrivacy$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.L$0
            r1 = r0
            Ua.M r1 = (Ua.M) r1
            java.lang.Object r2 = f9.C4063a.g()
            int r0 = r11.label
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L30
            if (r0 != r4) goto L28
            java.lang.Object r0 = r11.L$3
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r0 = r11.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r11.L$1
            java.lang.String r0 = (java.lang.String) r0
            kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L23
            r10 = r11
            goto La6
        L23:
            r0 = move-exception
            r12 = r0
            r10 = r11
            goto Lbb
        L28:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L30:
            kotlin.C4849c.b(r12)
            com.stepos.agentframework.chatcore.file.FileInfo r12 = r11.$fileInfo
            android.net.Uri r12 = r12.getFileUri()
            java.lang.String r7 = r12.toString()
            java.lang.String r12 = "toString(...)"
            kotlin.jvm.internal.p.h(r7, r12)
            android.content.Context r12 = r11.$context
            com.stepos.agentframework.chatcore.file.FileInfo r0 = r11.$fileInfo
            kotlin.Result$a r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L59
            android.content.ContentResolver r12 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L59
            android.net.Uri r0 = r0.getFileUri()     // Catch: java.lang.Throwable -> L59
            java.lang.String r12 = r12.getType(r0)     // Catch: java.lang.Throwable -> L59
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch: java.lang.Throwable -> L59
            goto L65
        L59:
            r0 = move-exception
            r12 = r0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r12 = kotlin.C4849c.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L65:
            boolean r0 = kotlin.Result.g(r12)
            if (r0 == 0) goto L6c
            r12 = r3
        L6c:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 != 0) goto L72
            java.lang.String r12 = "image/*"
        L72:
            r8 = r12
            com.stepos.agentframework.chatcore.session.AgentSession r12 = r11.this$0
            android.content.Context r6 = r11.$context
            java.lang.String r9 = r11.$traceId
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r12 = com.stepos.agentframework.chatcore.session.AgentSession.D(r12)     // Catch: java.lang.Throwable -> Lb8
            com.stepos.agentframework.chatcore.agents.u r5 = r12.getClient()     // Catch: java.lang.Throwable -> Lb8
            java.lang.Object r12 = g9.h.a(r1)     // Catch: java.lang.Throwable -> Lb8
            r11.L$0 = r12     // Catch: java.lang.Throwable -> Lb8
            java.lang.Object r12 = g9.h.a(r7)     // Catch: java.lang.Throwable -> Lb8
            r11.L$1 = r12     // Catch: java.lang.Throwable -> Lb8
            java.lang.Object r12 = g9.h.a(r8)     // Catch: java.lang.Throwable -> Lb8
            r11.L$2 = r12     // Catch: java.lang.Throwable -> Lb8
            java.lang.Object r12 = g9.h.a(r1)     // Catch: java.lang.Throwable -> Lb8
            r11.L$3 = r12     // Catch: java.lang.Throwable -> Lb8
            r12 = 0
            r11.I$0 = r12     // Catch: java.lang.Throwable -> Lb8
            r11.label = r4     // Catch: java.lang.Throwable -> Lb8
            r10 = r11
            java.lang.Object r12 = r5.B(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lb5
            if (r12 != r2) goto La6
            return r2
        La6:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> Lb5
            boolean r11 = r12.booleanValue()     // Catch: java.lang.Throwable -> Lb5
            java.lang.Boolean r11 = g9.C4109a.a(r11)     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r11 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> Lb5
            goto Lc5
        Lb5:
            r0 = move-exception
        Lb6:
            r12 = r0
            goto Lbb
        Lb8:
            r0 = move-exception
            r10 = r11
            goto Lb6
        Lbb:
            kotlin.Result$a r11 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r12)
            java.lang.Object r11 = kotlin.Result.b(r11)
        Lc5:
            java.lang.Boolean r12 = g9.C4109a.a(r4)
            boolean r0 = kotlin.Result.g(r11)
            if (r0 == 0) goto Ld0
            r11 = r12
        Ld0:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            com.stepos.agentframework.chatcore.session.AgentSession$checkImagePrivacy$1$1 r12 = new com.stepos.agentframework.chatcore.session.AgentSession$checkImagePrivacy$1$1
            p9.l<java.lang.Boolean, Y8.t> r0 = r10.$onResult
            r12.<init>(r0, r11, r3)
            kotlin.Function2.b(r12)
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$checkImagePrivacy$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
