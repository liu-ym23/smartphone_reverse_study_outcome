package com.stepos.datacenter.core.structured;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.core.structured.ObjectBoxRepository$delete$2", f = "BaseRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ObjectBoxRepository$delete$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30024a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObjectBoxRepository<T> f30025b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ T f30026c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectBoxRepository$delete$2(ObjectBoxRepository<T> objectBoxRepository, T t10, InterfaceC4014c<? super ObjectBoxRepository$delete$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30025b = objectBoxRepository;
        this.f30026c = t10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ObjectBoxRepository$delete$2(this.f30025b, this.f30026c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ObjectBoxRepository$delete$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f30024a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return C4109a.a(this.f30025b.h().m(this.f30026c));
    }
}
