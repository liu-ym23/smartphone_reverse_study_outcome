package com.stepos.datacenter.api;

import Ua.M;
import Y8.t;
import android.util.Log;
import com.stepos.datacenter.vector.VectorStoreManager;
import e7.VectorStoreConfig;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.api.LifecycleOps$initVectorStore$1", f = "LifecycleOps.kt", l = {110}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LifecycleOps$initVectorStore$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29891a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VectorStoreManager f29892b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VectorStoreConfig f29893c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleOps$initVectorStore$1(VectorStoreManager vectorStoreManager, VectorStoreConfig vectorStoreConfig, InterfaceC4014c<? super LifecycleOps$initVectorStore$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29892b = vectorStoreManager;
        this.f29893c = vectorStoreConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new LifecycleOps$initVectorStore$1(this.f29892b, this.f29893c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((LifecycleOps$initVectorStore$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29891a;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                VectorStoreManager vectorStoreManager = this.f29892b;
                this.f29891a = 1;
                if (vectorStoreManager.g(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            Log.d("DataCenter", "VectorStore initialized (dimension=" + this.f29893c.getDimension() + ", metric=" + this.f29893c.getMetric() + ")");
        } catch (Throwable th) {
            Log.e("DataCenter", "VectorStore initialization failed", th);
        }
        return t.f7040a;
    }
}
