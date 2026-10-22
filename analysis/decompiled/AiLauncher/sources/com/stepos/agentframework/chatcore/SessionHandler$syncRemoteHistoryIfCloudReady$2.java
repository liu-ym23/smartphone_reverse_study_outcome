package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$syncRemoteHistoryIfCloudReady$2", f = "SessionHandler.kt", l = {2403, 2413}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$syncRemoteHistoryIfCloudReady$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<String> $catchUp;
    final /* synthetic */ AgentSession $current;
    final /* synthetic */ long $now;
    final /* synthetic */ String $reason;
    final /* synthetic */ LinkedHashSet<String> $targets;
    final /* synthetic */ String $topSid;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ SessionHandler this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$syncRemoteHistoryIfCloudReady$2$2", f = "SessionHandler.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.SessionHandler$syncRemoteHistoryIfCloudReady$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ SessionHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SessionHandler sessionHandler, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = sessionHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.g3();
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$syncRemoteHistoryIfCloudReady$2(LinkedHashSet<String> linkedHashSet, AgentSession agentSession, SessionHandler sessionHandler, String str, List<String> list, long j10, String str2, InterfaceC4014c<? super SessionHandler$syncRemoteHistoryIfCloudReady$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$targets = linkedHashSet;
        this.$current = agentSession;
        this.this$0 = sessionHandler;
        this.$reason = str;
        this.$catchUp = list;
        this.$now = j10;
        this.$topSid = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$syncRemoteHistoryIfCloudReady$2(this.$targets, this.$current, this.this$0, this.$reason, this.$catchUp, this.$now, this.$topSid, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$syncRemoteHistoryIfCloudReady$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0161, code lost:
    
        if (r11 == r0) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[Catch: all -> 0x0028, Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x0021, B:51:0x0164, B:53:0x01a6, B:20:0x005f, B:22:0x0065, B:24:0x0078, B:26:0x00a4, B:27:0x00a8, B:29:0x00b0, B:31:0x00ba, B:33:0x00c7, B:34:0x00ed, B:38:0x0105, B:40:0x0111, B:42:0x0137, B:44:0x013d, B:45:0x0141, B:47:0x014e, B:48:0x014f, B:64:0x01f2, B:65:0x01f3, B:55:0x01cc, B:56:0x01d1, B:58:0x01d9, B:62:0x01e5, B:16:0x0045, B:19:0x0054), top: B:112:0x000d, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0111 A[Catch: all -> 0x0028, Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x0021, B:51:0x0164, B:53:0x01a6, B:20:0x005f, B:22:0x0065, B:24:0x0078, B:26:0x00a4, B:27:0x00a8, B:29:0x00b0, B:31:0x00ba, B:33:0x00c7, B:34:0x00ed, B:38:0x0105, B:40:0x0111, B:42:0x0137, B:44:0x013d, B:45:0x0141, B:47:0x014e, B:48:0x014f, B:64:0x01f2, B:65:0x01f3, B:55:0x01cc, B:56:0x01d1, B:58:0x01d9, B:62:0x01e5, B:16:0x0045, B:19:0x0054), top: B:112:0x000d, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013d A[Catch: all -> 0x0028, Exception -> 0x002b, TryCatch #2 {Exception -> 0x002b, blocks: (B:7:0x0021, B:51:0x0164, B:53:0x01a6, B:20:0x005f, B:22:0x0065, B:24:0x0078, B:26:0x00a4, B:27:0x00a8, B:29:0x00b0, B:31:0x00ba, B:33:0x00c7, B:34:0x00ed, B:38:0x0105, B:40:0x0111, B:42:0x0137, B:44:0x013d, B:45:0x0141, B:47:0x014e, B:48:0x014f, B:64:0x01f2, B:65:0x01f3, B:55:0x01cc, B:56:0x01d1, B:58:0x01d9, B:62:0x01e5, B:16:0x0045, B:19:0x0054), top: B:112:0x000d, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0204 A[LOOP:1: B:67:0x01fe->B:69:0x0204, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0135 -> B:43:0x013a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0137 -> B:43:0x013a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0161 -> B:51:0x0164). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.SessionHandler$syncRemoteHistoryIfCloudReady$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
