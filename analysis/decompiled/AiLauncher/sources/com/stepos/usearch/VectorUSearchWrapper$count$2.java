package com.stepos.usearch;

import O7.a;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)I"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.usearch.VectorUSearchWrapper$count$2", f = "VectorUSearchWrapper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class VectorUSearchWrapper$count$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Integer>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f31139a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VectorUSearchWrapper f31140b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorUSearchWrapper$count$2(VectorUSearchWrapper vectorUSearchWrapper, InterfaceC4014c<? super VectorUSearchWrapper$count$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f31140b = vectorUSearchWrapper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VectorUSearchWrapper$count$2(this.f31140b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((VectorUSearchWrapper$count$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f31139a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        a aVar = this.f31140b.index;
        return C4109a.f(aVar != null ? (int) aVar.size() : 0);
    }
}
