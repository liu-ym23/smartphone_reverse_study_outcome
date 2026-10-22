package com.stepos.datacenter.api;

import Y8.t;
import android.util.Log;
import com.stepos.datacenter.vector.VectorEntry;
import e7.p;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.api.VectorWriteOps$storeVector$2", f = "VectorWriteOps.kt", l = {32}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class VectorWriteOps$storeVector$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Long>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29970a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataCenter f29971b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VectorEntry f29972c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorWriteOps$storeVector$2(DataCenter dataCenter, VectorEntry vectorEntry, InterfaceC4014c<? super VectorWriteOps$storeVector$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f29971b = dataCenter;
        this.f29972c = vectorEntry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new VectorWriteOps$storeVector$2(this.f29971b, this.f29972c, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super Long> interfaceC4014c) {
        return ((VectorWriteOps$storeVector$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29970a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        p vectorStorageProvider = this.f29971b.getVectorStorageProvider();
        if (vectorStorageProvider == null) {
            Log.w("DataCenter", "storeVector: no provider yet (AME still initializing?); returning -1");
            return C4109a.g(-1L);
        }
        VectorEntry vectorEntry = this.f29972c;
        this.f29970a = 1;
        Object objB = vectorStorageProvider.b(vectorEntry, this);
        return objB == objG ? objG : objB;
    }
}
