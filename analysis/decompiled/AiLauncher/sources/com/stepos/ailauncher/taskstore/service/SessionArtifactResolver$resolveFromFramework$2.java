package com.stepos.ailauncher.taskstore.service;

import Ua.M;
import Y8.t;
import Z8.A;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import b9.b;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.SessionArtifactKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import q4.TaskResultArtifact;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.service.SessionArtifactResolver$resolveFromFramework$2", f = "SessionArtifactResolver.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SessionArtifactResolver$resolveFromFramework$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends SessionArtifact>>, Object> {
    final /* synthetic */ List<String> $sessionKeys;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b.d(Long.valueOf(((SessionArtifact) t11).getCreatedAt()), Long.valueOf(((SessionArtifact) t10).getCreatedAt()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionArtifactResolver$resolveFromFramework$2(List<String> list, InterfaceC4014c<? super SessionArtifactResolver$resolveFromFramework$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionKeys = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SessionArtifactResolver$resolveFromFramework$2 sessionArtifactResolver$resolveFromFramework$2 = new SessionArtifactResolver$resolveFromFramework$2(this.$sessionKeys, interfaceC4014c);
        sessionArtifactResolver$resolveFromFramework$2.L$0 = obj;
        return sessionArtifactResolver$resolveFromFramework$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<SessionArtifact>> interfaceC4014c) {
        return ((SessionArtifactResolver$resolveFromFramework$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        SessionHandler sessionHandlerN = AgentConfig.INSTANCE.a().n();
        List<String> list = this.$sessionKeys;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(sessionHandlerN.L1(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t("SessionArtifactResolver", "getSessionArtifacts failed key=" + str, thE, false, 8, null);
            }
            if (Result.e(objB) != null) {
                objB = C1173v.m();
            }
            A.E(arrayList, (Iterable) objB);
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(SessionArtifactResolver.INSTANCE.c((TaskResultArtifact) it.next()));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!SessionArtifactKt.isImageArtifact((SessionArtifact) obj2)) {
                arrayList3.add(obj2);
            }
        }
        return F.c1(arrayList3, new a());
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends SessionArtifact>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<SessionArtifact>>) interfaceC4014c);
    }
}
