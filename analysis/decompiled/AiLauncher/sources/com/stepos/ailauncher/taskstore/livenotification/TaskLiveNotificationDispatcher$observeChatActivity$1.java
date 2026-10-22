package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.agentframework.chatcore.session.list.SessionChatActivitySnapshot;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1", f = "TaskLiveNotificationDispatcher.kt", l = {424}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$observeChatActivity$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appContext;
    int label;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/stepos/agentframework/chatcore/session/list/a;", "<unused var>", "", "LY8/t;", "<anonymous>", "(Ljava/util/Map;J)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$1", f = "TaskLiveNotificationDispatcher.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<Map<String, ? extends SessionChatActivitySnapshot>, Long, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        public final Object f(Map<String, SessionChatActivitySnapshot> map, long j10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return new AnonymousClass1(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // p9.q
        public /* bridge */ /* synthetic */ Object invoke(Map<String, ? extends SessionChatActivitySnapshot> map, Long l10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return f(map, l10.longValue(), interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Xa.c {
        final /* synthetic */ Context $appContext;

        public AnonymousClass2(Context context) {
            this.$appContext = context;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:
        
            if (r8 != r1) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(Y8.t r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$2$emit$1 r0 = (com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$2$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$2$emit$1 r0 = new com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$2$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 3
                r4 = 1
                r5 = 2
                if (r2 == 0) goto L4b
                if (r2 == r4) goto L43
                if (r2 == r5) goto L3b
                if (r2 != r3) goto L33
                java.lang.Object r7 = r0.L$0
                Y8.t r7 = (Y8.t) r7
                kotlin.C4849c.b(r8)
                goto L8b
            L33:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3b:
                java.lang.Object r7 = r0.L$0
                Y8.t r7 = (Y8.t) r7
                kotlin.C4849c.b(r8)
                goto L75
            L43:
                java.lang.Object r7 = r0.L$0
                Y8.t r7 = (Y8.t) r7
                kotlin.C4849c.b(r8)
                goto L5f
            L4b:
                kotlin.C4849c.b(r8)
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher r8 = com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.INSTANCE
                java.lang.Object r2 = g9.h.a(r7)
                r0.L$0 = r2
                r0.label = r4
                java.lang.Object r8 = com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.D(r8, r0)
                if (r8 != r1) goto L5f
                goto L8a
            L5f:
                java.util.List r8 = (java.util.List) r8
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.N(r8)
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher r8 = com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.INSTANCE
                java.lang.Object r2 = g9.h.a(r7)
                r0.L$0 = r2
                r0.label = r5
                java.lang.Object r8 = com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.B(r8, r0)
                if (r8 != r1) goto L75
                goto L8a
            L75:
                java.util.Set r8 = (java.util.Set) r8
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.M(r8)
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher r8 = com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.INSTANCE
                java.lang.Object r7 = g9.h.a(r7)
                r0.L$0 = r7
                r0.label = r3
                java.lang.Object r8 = com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.A(r8, r0)
                if (r8 != r1) goto L8b
            L8a:
                return r1
            L8b:
                java.util.Set r8 = (java.util.Set) r8
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.L(r8)
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher r7 = com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.INSTANCE
                android.content.Context r6 = r6.$appContext
                r8 = 0
                r0 = 0
                com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher.N0(r7, r6, r8, r5, r0)
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1.AnonymousClass2.emit(Y8.t, e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$observeChatActivity$1(Context context, InterfaceC4014c<? super TaskLiveNotificationDispatcher$observeChatActivity$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$appContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskLiveNotificationDispatcher$observeChatActivity$1(this.$appContext, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$observeChatActivity$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            SessionActivityTracker sessionActivityTracker = SessionActivityTracker.INSTANCE;
            Xa.b bVarN = Xa.d.n(sessionActivityTracker.e(), sessionActivityTracker.d(), new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$appContext);
            this.label = 1;
            if (bVarN.collect(anonymousClass2, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
