package com.stepos.agentframework.adapter.dify;

import C7.r;
import J7.c;
import S7.n;
import V4.k;
import V4.l;
import androidx.appcompat.app.AppCompatDelegate;
import com.stepos.agentframework.adapter.dify.bean.SuggestResult;
import com.stepos.agentframework.adapter.netcore.EventListener;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;

@c(c = "com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1", f = "DifyCoreAgentClient.kt", l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 122}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class DifyCoreAgentClient$chat$eventSource$1$onClosed$1 extends SuspendLambda implements n {
    final /* synthetic */ Ref$ObjectRef<k> $lastReplyInfo;
    final /* synthetic */ EventListener $listener;
    final /* synthetic */ Ref$ObjectRef<String> $messageId;
    final /* synthetic */ l $request;
    int label;

    @c(c = "com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$1", f = "DifyCoreAgentClient.kt", l = {110}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ Ref$ObjectRef<k> $lastReplyInfo;
        final /* synthetic */ EventListener $listener;
        final /* synthetic */ Ref$ObjectRef<String> $messageId;
        final /* synthetic */ l $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, Ref$ObjectRef<String> ref$ObjectRef, Ref$ObjectRef<k> ref$ObjectRef2, EventListener eventListener, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$request = lVar;
            this.$messageId = ref$ObjectRef;
            this.$lastReplyInfo = ref$ObjectRef2;
            this.$listener = eventListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$request, this.$messageId, this.$lastReplyInfo, this.$listener, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            r rVar = r.f317a;
            try {
                if (i == 0) {
                    b.b(obj);
                    DifyClient companion = DifyClient.INSTANCE.getInstance();
                    String str = this.$request.f1364a;
                    String str2 = (String) this.$messageId.f4920a;
                    if (str2 == null) {
                        str2 = "";
                    }
                    this.label = 1;
                    obj = companion.getSuggested(str, str2, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                SuggestResult suggestResult = (SuggestResult) obj;
                k kVar = (k) this.$lastReplyInfo.f4920a;
                if (kVar == null) {
                    return null;
                }
                EventListener eventListener = this.$listener;
                l lVar = this.$request;
                if (suggestResult != null) {
                    suggestResult.getData();
                }
                eventListener.onEvent(lVar, kVar);
                return rVar;
            } catch (Exception e) {
                e.printStackTrace();
                return rVar;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$2", f = "DifyCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ EventListener $listener;
        final /* synthetic */ l $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(EventListener eventListener, l lVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$listener = eventListener;
            this.$request = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$listener, this.$request, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            this.$listener.onClosed(this.$request);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DifyCoreAgentClient$chat$eventSource$1$onClosed$1(l lVar, Ref$ObjectRef<String> ref$ObjectRef, Ref$ObjectRef<k> ref$ObjectRef2, EventListener eventListener, H7.c<? super DifyCoreAgentClient$chat$eventSource$1$onClosed$1> cVar) {
        super(2, cVar);
        this.$request = lVar;
        this.$messageId = ref$ObjectRef;
        this.$lastReplyInfo = ref$ObjectRef2;
        this.$listener = eventListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new DifyCoreAgentClient$chat$eventSource$1$onClosed$1(this.$request, this.$messageId, this.$lastReplyInfo, this.$listener, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
    
        if (m9.AbstractC1683A.w(r11, r1, r10) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.b.b(r11)
            goto L51
        L10:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L18:
            kotlin.b.b(r11)
            goto L3a
        L1c:
            kotlin.b.b(r11)
            u9.d r11 = m9.AbstractC1691I.f5315a
            u9.c r11 = u9.c.f6743a
            com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$1 r4 = new com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$1
            V4.l r5 = r10.$request
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r6 = r10.$messageId
            kotlin.jvm.internal.Ref$ObjectRef<V4.k> r7 = r10.$lastReplyInfo
            com.stepos.agentframework.adapter.netcore.EventListener r8 = r10.$listener
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r10.label = r3
            java.lang.Object r11 = m9.AbstractC1683A.w(r11, r4, r10)
            if (r11 != r0) goto L3a
            goto L50
        L3a:
            u9.d r11 = m9.AbstractC1691I.f5315a
            u9.c r11 = u9.c.f6743a
            com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$2 r1 = new com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$2
            com.stepos.agentframework.adapter.netcore.EventListener r3 = r10.$listener
            V4.l r4 = r10.$request
            r5 = 0
            r1.<init>(r3, r4, r5)
            r10.label = r2
            java.lang.Object r10 = m9.AbstractC1683A.w(r11, r1, r10)
            if (r10 != r0) goto L51
        L50:
            return r0
        L51:
            C7.r r10 = C7.r.f317a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((DifyCoreAgentClient$chat$eventSource$1$onClosed$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
