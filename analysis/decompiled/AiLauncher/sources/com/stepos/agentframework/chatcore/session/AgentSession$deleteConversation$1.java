package com.stepos.agentframework.chatcore.session;

import com.stepos.launcher.assistant.widgetdrag.GlobalDragConstant;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$deleteConversation$1", f = "AgentSession.kt", l = {2812, GlobalDragConstant.DRAG_FLAG}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$deleteConversation$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.p<Boolean, w4.e, Y8.t> $callback;
    final /* synthetic */ String $sessionId;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ AgentSession this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$deleteConversation$1$4", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$deleteConversation$1$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ AgentSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AgentSession agentSession, InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = agentSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass4(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.getHandler().A2();
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$deleteConversation$1(AgentSession agentSession, String str, p9.p<? super Boolean, ? super w4.e, Y8.t> pVar, InterfaceC4014c<? super AgentSession$deleteConversation$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$sessionId = str;
        this.$callback = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentSession$deleteConversation$1 agentSession$deleteConversation$1 = new AgentSession$deleteConversation$1(this.this$0, this.$sessionId, this.$callback, interfaceC4014c);
        agentSession$deleteConversation$1.L$0 = obj;
        return agentSession$deleteConversation$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$deleteConversation$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d2 A[Catch: all -> 0x003f, CancellationException -> 0x0047, Exception -> 0x0323, TRY_LEAVE, TryCatch #18 {Exception -> 0x0323, blocks: (B:112:0x02ca, B:114:0x02d2, B:127:0x032a, B:128:0x0332, B:130:0x0338), top: B:203:0x02ca }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x032a A[Catch: all -> 0x003f, CancellationException -> 0x0047, Exception -> 0x0323, TRY_ENTER, TryCatch #18 {Exception -> 0x0323, blocks: (B:112:0x02ca, B:114:0x02d2, B:127:0x032a, B:128:0x0332, B:130:0x0338), top: B:203:0x02ca }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0404 A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #20 {all -> 0x003f, blocks: (B:7:0x0034, B:112:0x02ca, B:114:0x02d2, B:115:0x0300, B:117:0x0304, B:120:0x0315, B:172:0x03ec, B:175:0x03f3, B:176:0x0400, B:178:0x0404, B:127:0x032a, B:128:0x0332, B:130:0x0338, B:132:0x034a, B:135:0x0360, B:108:0x0292, B:107:0x0288), top: B:189:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ff A[Catch: all -> 0x01e7, Exception -> 0x01eb, CancellationException -> 0x01f1, TRY_ENTER, TRY_LEAVE, TryCatch #27 {CancellationException -> 0x01f1, Exception -> 0x01eb, all -> 0x01e7, blocks: (B:77:0x01c7, B:79:0x01de, B:91:0x01ff, B:94:0x0215), top: B:214:0x01c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0215 A[Catch: all -> 0x01e7, Exception -> 0x01eb, CancellationException -> 0x01f1, TRY_ENTER, TRY_LEAVE, TryCatch #27 {CancellationException -> 0x01f1, Exception -> 0x01eb, all -> 0x01e7, blocks: (B:77:0x01c7, B:79:0x01de, B:91:0x01ff, B:94:0x0215), top: B:214:0x01c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0262  */
    /* JADX WARN: Type inference failed for: r0v52, types: [T, java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.Set] */
    /* JADX WARN: Type inference failed for: r13v0, types: [T, java.lang.Object, java.util.Set] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$deleteConversation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
