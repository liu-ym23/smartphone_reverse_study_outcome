package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$awaitNetworkThenSend$2", f = "AgentSession.kt", l = {4526, 4537, 4540}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$awaitNetworkThenSend$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $deepThinking;
    final /* synthetic */ List<AgentMessage> $messages;
    final /* synthetic */ Map<String, String> $meta;
    final /* synthetic */ ChatRound $round;
    int label;
    final /* synthetic */ AgentSession.AgentConversation this$0;
    final /* synthetic */ AgentSession this$1;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ESessionStatus.values().length];
            try {
                iArr[ESessionStatus.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ESessionStatus.PREPARING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$AgentConversation$awaitNetworkThenSend$2(ChatRound chatRound, AgentSession.AgentConversation agentConversation, AgentSession agentSession, List<AgentMessage> list, boolean z10, Map<String, String> map, InterfaceC4014c<? super AgentSession$AgentConversation$awaitNetworkThenSend$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$round = chatRound;
        this.this$0 = agentConversation;
        this.this$1 = agentSession;
        this.$messages = list;
        this.$deepThinking = z10;
        this.$meta = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$AgentConversation$awaitNetworkThenSend$2(this.$round, this.this$0, this.this$1, this.$messages, this.$deepThinking, this.$meta, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$AgentConversation$awaitNetworkThenSend$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00dd, code lost:
    
        if (r15 == r1) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[Catch: all -> 0x00ca, TryCatch #7 {all -> 0x00ca, blocks: (B:20:0x0039, B:22:0x0043, B:24:0x004d, B:26:0x0053, B:29:0x005f, B:31:0x0069, B:33:0x0073, B:36:0x007c, B:38:0x008a, B:39:0x0095, B:42:0x00a7), top: B:147:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069 A[Catch: all -> 0x00ca, TryCatch #7 {all -> 0x00ca, blocks: (B:20:0x0039, B:22:0x0043, B:24:0x004d, B:26:0x0053, B:29:0x005f, B:31:0x0069, B:33:0x0073, B:36:0x007c, B:38:0x008a, B:39:0x0095, B:42:0x00a7), top: B:147:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010b A[Catch: all -> 0x00c3, TryCatch #5 {all -> 0x00c3, blocks: (B:47:0x00bc, B:64:0x010b, B:66:0x0115, B:68:0x011f, B:71:0x0126, B:84:0x015a, B:44:0x00b5, B:62:0x00ea, B:56:0x00d0, B:59:0x00e0, B:98:0x017b), top: B:145:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0178  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0088 -> B:147:0x0039). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0178 -> B:147:0x0039). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$awaitNetworkThenSend$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
