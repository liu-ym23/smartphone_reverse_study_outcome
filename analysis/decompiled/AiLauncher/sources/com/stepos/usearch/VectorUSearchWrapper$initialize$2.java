package com.stepos.usearch;

import O7.a;
import Ua.M;
import Y8.t;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.usearch.VectorUSearchWrapper$initialize$2", f = "VectorUSearchWrapper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class VectorUSearchWrapper$initialize$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f31147a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VectorUSearchWrapper f31148b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorUSearchWrapper$initialize$2(VectorUSearchWrapper vectorUSearchWrapper, InterfaceC4014c<? super VectorUSearchWrapper$initialize$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f31148b = vectorUSearchWrapper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VectorUSearchWrapper$initialize$2(this.f31148b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((VectorUSearchWrapper$initialize$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f31147a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!USearchNative.f31118a.b()) {
            throw new RuntimeException("Failed to load USearch native library");
        }
        VectorUSearchWrapper vectorUSearchWrapper = this.f31148b;
        vectorUSearchWrapper.index = new a(vectorUSearchWrapper.dimension, this.f31148b.metric, this.f31148b.connectivity, this.f31148b.expansionAdd, this.f31148b.expansionSearch);
        if (this.f31148b.addThreads > 0 || this.f31148b.searchThreads > 0) {
            Log.i("VectorUSearchWrapper", "USearch threaded reserve: add=" + this.f31148b.addThreads + " search=" + this.f31148b.searchThreads);
            a aVar = this.f31148b.index;
            if (aVar != null) {
                C4109a.a(aVar.l(100000L, this.f31148b.addThreads, this.f31148b.searchThreads));
            }
        } else {
            a aVar2 = this.f31148b.index;
            if (aVar2 != null) {
                C4109a.a(aVar2.i(100000L));
            }
        }
        Log.i("VectorUSearchWrapper", "USearch initialized: dim=" + this.f31148b.dimension + ", capacity=100000");
        return t.f7040a;
    }
}
