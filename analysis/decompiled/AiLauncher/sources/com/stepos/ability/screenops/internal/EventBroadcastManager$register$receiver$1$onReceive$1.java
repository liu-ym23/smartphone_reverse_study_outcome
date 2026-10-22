package com.stepos.ability.screenops.internal;

import Ua.M;
import W3.ScreenOpsEvent;
import W3.e;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ability.screenops.internal.EventBroadcastManager$register$receiver$1$onReceive$1", f = "EventBroadcastManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class EventBroadcastManager$register$receiver$1$onReceive$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f22068a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f22069b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScreenOpsEvent f22070c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventBroadcastManager$register$receiver$1$onReceive$1(e eVar, ScreenOpsEvent screenOpsEvent, InterfaceC4014c<? super EventBroadcastManager$register$receiver$1$onReceive$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f22069b = eVar;
        this.f22070c = screenOpsEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new EventBroadcastManager$register$receiver$1$onReceive$1(this.f22069b, this.f22070c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((EventBroadcastManager$register$receiver$1$onReceive$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f22068a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.f22069b.a(this.f22070c);
        return t.f7040a;
    }
}
