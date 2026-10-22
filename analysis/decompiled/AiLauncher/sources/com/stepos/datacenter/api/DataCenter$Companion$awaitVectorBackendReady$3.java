package com.stepos.datacenter.api;

import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.api.DataCenter$Companion$awaitVectorBackendReady$3", f = "DataCenter.kt", l = {125}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DataCenter$Companion$awaitVectorBackendReady$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29823a;

    public DataCenter$Companion$awaitVectorBackendReady$3(InterfaceC4014c<? super DataCenter$Companion$awaitVectorBackendReady$3> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DataCenter$Companion$awaitVectorBackendReady$3(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((DataCenter$Companion$awaitVectorBackendReady$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29823a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        InterfaceC1083u<Boolean> ameInitDone$sdk_release = DataCenter.INSTANCE.getAmeInitDone$sdk_release();
        this.f29823a = 1;
        Object objA1 = ameInitDone$sdk_release.a1(this);
        return objA1 == objG ? objG : objA1;
    }
}
