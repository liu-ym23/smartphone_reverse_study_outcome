package com.stepos.agentframework.chatui;

import android.os.SystemClock;
import android.os.Trace;
import com.stepos.agentframework.chatui.longtext.LongTextDocument;
import com.stepos.agentframework.chatui.longtext.LongTextFallbackReason;
import com.stepos.agentframework.chatui.longtext.c;
import com.stepos.core.download.ModelFlowMeta;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import z4.LongTextCandidate;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.ChatMessageAdapter$prepareLongText$1$document$1", f = "ChatMessageAdapter.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ChatMessageAdapter$prepareLongText$1$document$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super LongTextDocument>, Object> {
    final /* synthetic */ LongTextCandidate $candidate;
    final /* synthetic */ Ref$LongRef $cleanMs;
    final /* synthetic */ Ref$IntRef $cleanedChars;
    final /* synthetic */ Ref$ObjectRef<String> $fallbackReason;
    final /* synthetic */ Ref$LongRef $indexMs;
    final /* synthetic */ Ref$LongRef $queueMs;
    final /* synthetic */ long $startedAt;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatMessageAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageAdapter$prepareLongText$1$document$1(Ref$LongRef ref$LongRef, long j10, LongTextCandidate longTextCandidate, Ref$IntRef ref$IntRef, Ref$LongRef ref$LongRef2, Ref$LongRef ref$LongRef3, Ref$ObjectRef<String> ref$ObjectRef, ChatMessageAdapter chatMessageAdapter, InterfaceC4014c<? super ChatMessageAdapter$prepareLongText$1$document$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$queueMs = ref$LongRef;
        this.$startedAt = j10;
        this.$candidate = longTextCandidate;
        this.$cleanedChars = ref$IntRef;
        this.$cleanMs = ref$LongRef2;
        this.$indexMs = ref$LongRef3;
        this.$fallbackReason = ref$ObjectRef;
        this.this$0 = chatMessageAdapter;
    }

    public static final Y8.t h(Ua.M m10) {
        kotlinx.coroutines.d.g(m10);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChatMessageAdapter$prepareLongText$1$document$1 chatMessageAdapter$prepareLongText$1$document$1 = new ChatMessageAdapter$prepareLongText$1$document$1(this.$queueMs, this.$startedAt, this.$candidate, this.$cleanedChars, this.$cleanMs, this.$indexMs, this.$fallbackReason, this.this$0, interfaceC4014c);
        chatMessageAdapter$prepareLongText$1$document$1.L$0 = obj;
        return chatMessageAdapter$prepareLongText$1$document$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super LongTextDocument> interfaceC4014c) {
        return ((ChatMessageAdapter$prepareLongText$1$document$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Ua.M m10 = (Ua.M) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.$queueMs.f34819a = jElapsedRealtime - this.$startedAt;
        Trace.beginSection("Chat.longText.prepare");
        LongTextDocument document = null;
        try {
            try {
                String strN = La.w.n(com.stepos.agentframework.chatui.util.a.INSTANCE.a(this.$candidate.getAgentId(), com.stepos.agentframework.chatui.util.r.INSTANCE.a(O6.f.INSTANCE.b(this.$candidate.getSource()))));
                this.$cleanedChars.f34818a = strN.length();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                this.$cleanMs.f34819a = jElapsedRealtime2 - jElapsedRealtime;
                try {
                    com.stepos.agentframework.chatui.longtext.c cVarE = com.stepos.agentframework.chatui.longtext.b.INSTANCE.e(strN, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.E1
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return ChatMessageAdapter$prepareLongText$1$document$1.h(m10);
                        }
                    });
                    this.$indexMs.f34819a = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    if (cVarE instanceof c.Ready) {
                        document = ((c.Ready) cVarE).getDocument();
                    } else {
                        if (!(cVarE instanceof c.Fallback)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Ref$ObjectRef<String> ref$ObjectRef = this.$fallbackReason;
                        LongTextFallbackReason reason = ((c.Fallback) cVarE).getReason();
                        String nodeType = ((c.Fallback) cVarE).getNodeType();
                        String htmlTag = ((c.Fallback) cVarE).getHtmlTag();
                        if (htmlTag.length() == 0) {
                            htmlTag = ModelFlowMeta.PLAN_NONE;
                        }
                        ref$ObjectRef.f34820a = reason + " node=" + nodeType + " htmlTag=" + ((Object) htmlTag);
                    }
                    Trace.endSection();
                    return document;
                } catch (Throwable th) {
                    this.$indexMs.f34819a = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    throw th;
                }
            } catch (CancellationException e10) {
                throw e10;
            } catch (Exception e11) {
                this.$fallbackReason.f34820a = "EXCEPTION type=" + e11.getClass().getSimpleName();
                C4148a.t(this.this$0.TAG, "long text preparation failed", e11, false, 8, null);
                Trace.endSection();
                return null;
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }
}
