package com.stepos.datacenter.fts.sqlite;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.fts.sqlite.AsyncIndexQueue$start$1", f = "AsyncIndexQueue.kt", l = {69}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AsyncIndexQueue$start$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30058a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AsyncIndexQueue f30059b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncIndexQueue$start$1(AsyncIndexQueue asyncIndexQueue, InterfaceC4014c<? super AsyncIndexQueue$start$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30059b = asyncIndexQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AsyncIndexQueue$start$1(this.f30059b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AsyncIndexQueue$start$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f30058a;
        if (i10 == 0) {
            C4849c.b(obj);
            AsyncIndexQueue asyncIndexQueue = this.f30059b;
            this.f30058a = 1;
            if (asyncIndexQueue.d(this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
