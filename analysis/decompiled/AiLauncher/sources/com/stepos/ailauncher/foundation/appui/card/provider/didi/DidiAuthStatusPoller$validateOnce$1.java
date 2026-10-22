package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.stepos.ailauncher.common.utils.NetworkPhase;
import com.stepos.ailauncher.common.utils.NetworkStateMonitor;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3315l;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusPoller$validateOnce$1", f = "DidiAuthStatusPoller.kt", l = {324}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class DidiAuthStatusPoller$validateOnce$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $accountScope;
    final /* synthetic */ String $cardId;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $thirdUid;
    final /* synthetic */ DidiCardView $view;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DidiAuthStatusPoller$validateOnce$1(String str, String str2, String str3, String str4, DidiCardView didiCardView, String str5, InterfaceC4014c<? super DidiAuthStatusPoller$validateOnce$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$thirdUid = str;
        this.$cardId = str2;
        this.$accountScope = str3;
        this.$reason = str4;
        this.$view = didiCardView;
        this.$deviceId = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DidiAuthStatusPoller$validateOnce$1(this.$thirdUid, this.$cardId, this.$accountScope, this.$reason, this.$view, this.$deviceId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((DidiAuthStatusPoller$validateOnce$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
                X.INSTANCE.o(this.$thirdUid, this.$cardId);
                R5.b.INSTANCE.c("didi.auth.realtime.skip.privacy", Y8.j.a("accountScope", this.$accountScope), Y8.j.a("taskId", this.$cardId));
                return Y8.t.f7040a;
            }
            if (!DidiAuthStatusRepository.INSTANCE.x()) {
                X.INSTANCE.o(this.$thirdUid, this.$cardId);
                R5.b.INSTANCE.h("didi.auth.realtime.skip.api", Y8.j.a("accountScope", this.$accountScope), Y8.j.a("taskId", this.$cardId));
                return Y8.t.f7040a;
            }
            if (NetworkStateMonitor.e().getValue() != NetworkPhase.AVAILABLE) {
                X.INSTANCE.o(this.$thirdUid, this.$cardId);
                R5.b.INSTANCE.c("didi.auth.realtime.skip.network", Y8.j.a("accountScope", this.$accountScope), Y8.j.a("taskId", this.$cardId), Y8.j.a("phase", NetworkStateMonitor.e().getValue()));
                return Y8.t.f7040a;
            }
            DidiAuthStatusPoller$validateOnce$1$result$1 didiAuthStatusPoller$validateOnce$1$result$1 = new DidiAuthStatusPoller$validateOnce$1$result$1(this.$thirdUid, this.$deviceId, null);
            this.label = 1;
            obj = TimeoutKt.e(5000L, didiAuthStatusPoller$validateOnce$1$result$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Object obj2 = (InterfaceC3315l) obj;
        if (obj2 == null) {
            obj2 = InterfaceC3315l.c.INSTANCE;
        }
        R5.b.INSTANCE.c("didi.auth.realtime.tick", Y8.j.a("accountScope", this.$accountScope), Y8.j.a("taskId", this.$cardId), Y8.j.a("result", obj2.getClass().getSimpleName()), Y8.j.a("reason", this.$reason));
        if (obj2 instanceof InterfaceC3315l.Authorized) {
            if (!this.$view.o0(((InterfaceC3315l.Authorized) obj2).getDto(), this.$thirdUid, this.$cardId, this.$reason)) {
                X.INSTANCE.o(this.$thirdUid, this.$cardId);
            }
        } else if (obj2 instanceof InterfaceC3315l.NotAuthorized) {
            X.INSTANCE.j(this.$thirdUid, this.$cardId);
            C4109a.a(this.$view.p0(this.$thirdUid, this.$cardId, this.$reason));
        } else {
            if (!kotlin.jvm.internal.p.d(obj2, InterfaceC3315l.c.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            X.INSTANCE.o(this.$thirdUid, this.$cardId);
        }
        return Y8.t.f7040a;
    }
}
