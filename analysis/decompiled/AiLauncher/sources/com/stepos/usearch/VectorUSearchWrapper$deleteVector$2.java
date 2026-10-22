package com.stepos.usearch;

import O7.a;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.usearch.VectorUSearchWrapper$deleteVector$2", f = "VectorUSearchWrapper.kt", l = {715}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class VectorUSearchWrapper$deleteVector$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f31141a;

    /* renamed from: b, reason: collision with root package name */
    public Object f31142b;

    /* renamed from: c, reason: collision with root package name */
    public long f31143c;

    /* renamed from: d, reason: collision with root package name */
    public int f31144d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ VectorUSearchWrapper f31145e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f31146f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorUSearchWrapper$deleteVector$2(VectorUSearchWrapper vectorUSearchWrapper, long j10, InterfaceC4014c<? super VectorUSearchWrapper$deleteVector$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f31145e = vectorUSearchWrapper;
        this.f31146f = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VectorUSearchWrapper$deleteVector$2(this.f31145e, this.f31146f, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((VectorUSearchWrapper$deleteVector$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC4021a interfaceC4021a;
        VectorUSearchWrapper vectorUSearchWrapper;
        long j10;
        Object objG = C4063a.g();
        int i10 = this.f31144d;
        if (i10 == 0) {
            C4849c.b(obj);
            InterfaceC4021a interfaceC4021a2 = this.f31145e.writeMutex;
            VectorUSearchWrapper vectorUSearchWrapper2 = this.f31145e;
            long j11 = this.f31146f;
            this.f31141a = interfaceC4021a2;
            this.f31142b = vectorUSearchWrapper2;
            this.f31143c = j11;
            this.f31144d = 1;
            if (interfaceC4021a2.m(null, this) == objG) {
                return objG;
            }
            interfaceC4021a = interfaceC4021a2;
            vectorUSearchWrapper = vectorUSearchWrapper2;
            j10 = j11;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = this.f31143c;
            vectorUSearchWrapper = (VectorUSearchWrapper) this.f31142b;
            interfaceC4021a = (InterfaceC4021a) this.f31141a;
            C4849c.b(obj);
        }
        try {
            a aVar = vectorUSearchWrapper.index;
            if (aVar == null) {
                throw new IllegalStateException("Index not initialized");
            }
            aVar.g(j10);
            vectorUSearchWrapper.metadataMap.remove(C4109a.g(j10));
            t tVar = t.f7040a;
            interfaceC4021a.l(null);
            return t.f7040a;
        } catch (Throwable th) {
            interfaceC4021a.l(null);
            throw th;
        }
    }
}
