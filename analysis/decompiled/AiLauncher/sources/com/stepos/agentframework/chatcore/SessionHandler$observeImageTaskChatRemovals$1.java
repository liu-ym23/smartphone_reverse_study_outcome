package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.ImageTaskChatRemoval;
import com.stepos.agentframework.chatcore.session.V0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.lang.ref.WeakReference;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$observeImageTaskChatRemovals$1", f = "SessionHandler.kt", l = {524}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$observeImageTaskChatRemovals$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $logTag;
    final /* synthetic */ WeakReference<SessionHandler> $ref;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ M $$this$launch;
        final /* synthetic */ String $logTag;
        final /* synthetic */ WeakReference<SessionHandler> $ref;

        public a(WeakReference<SessionHandler> weakReference, String str, M m10) {
            this.$ref = weakReference;
            this.$logTag = str;
            this.$$this$launch = m10;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(ImageTaskChatRemoval imageTaskChatRemoval, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            SessionHandler sessionHandler = this.$ref.get();
            if (sessionHandler != null) {
                sessionHandler.y0(imageTaskChatRemoval);
                return Y8.t.f7040a;
            }
            C4148a.k(this.$logTag, "image task removal collector self-destruct: handler unreachable", false, 4, null);
            kotlinx.coroutines.d.e(this.$$this$launch, null, 1, null);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$observeImageTaskChatRemovals$1(WeakReference<SessionHandler> weakReference, String str, InterfaceC4014c<? super SessionHandler$observeImageTaskChatRemovals$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$ref = weakReference;
        this.$logTag = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SessionHandler$observeImageTaskChatRemovals$1 sessionHandler$observeImageTaskChatRemovals$1 = new SessionHandler$observeImageTaskChatRemovals$1(this.$ref, this.$logTag, interfaceC4014c);
        sessionHandler$observeImageTaskChatRemovals$1.L$0 = obj;
        return sessionHandler$observeImageTaskChatRemovals$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$observeImageTaskChatRemovals$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<ImageTaskChatRemoval> oVarM = V0.INSTANCE.m();
            a aVar = new a(this.$ref, this.$logTag, m10);
            this.L$0 = g9.h.a(m10);
            this.label = 1;
            if (oVarM.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
