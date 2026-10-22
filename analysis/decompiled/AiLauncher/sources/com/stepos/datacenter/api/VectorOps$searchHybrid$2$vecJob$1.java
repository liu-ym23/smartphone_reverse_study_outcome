package com.stepos.datacenter.api;

import Ua.M;
import Y8.t;
import Z8.C1173v;
import android.util.Log;
import com.stepos.datacenter.vector.HybridSearchRequest;
import com.stepos.datacenter.vector.VectorSearchRequest;
import com.stepos.datacenter.vector.VectorSearchResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/datacenter/vector/VectorSearchResult;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.api.VectorOps$searchHybrid$2$vecJob$1", f = "VectorOps.kt", l = {156}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class VectorOps$searchHybrid$2$vecJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends VectorSearchResult>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29951a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataCenter f29952b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HybridSearchRequest f29953c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorOps$searchHybrid$2$vecJob$1(DataCenter dataCenter, HybridSearchRequest hybridSearchRequest, InterfaceC4014c<? super VectorOps$searchHybrid$2$vecJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29952b = dataCenter;
        this.f29953c = hybridSearchRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VectorOps$searchHybrid$2$vecJob$1(this.f29952b, this.f29953c, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<VectorSearchResult>> interfaceC4014c) {
        return ((VectorOps$searchHybrid$2$vecJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29951a;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                DataCenter dataCenter = this.f29952b;
                VectorSearchRequest vectorSearchRequest = new VectorSearchRequest(this.f29953c.getQueryVector(), this.f29953c.getPerPathTopK(), null, this.f29953c.getCategory(), this.f29953c.getCollection(), 4, null);
                this.f29951a = 1;
                obj = dataCenter.searchVectors$sdk_release(vectorSearchRequest, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return (List) obj;
        } catch (Exception e10) {
            Log.w("DataCenter", "searchHybrid: vector failed: " + e10.getMessage());
            return C1173v.m();
        }
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends VectorSearchResult>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<VectorSearchResult>>) interfaceC4014c);
    }
}
