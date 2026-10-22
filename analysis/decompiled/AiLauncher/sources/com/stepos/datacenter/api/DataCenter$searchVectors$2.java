package com.stepos.datacenter.api;

import Y8.t;
import Z8.C1173v;
import android.util.Log;
import com.stepos.datacenter.vector.VectorSearchRequest;
import com.stepos.datacenter.vector.VectorSearchResult;
import e7.p;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/stepos/datacenter/vector/VectorSearchResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.api.DataCenter$searchVectors$2", f = "DataCenter.kt", l = {193}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DataCenter$searchVectors$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super List<? extends VectorSearchResult>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29824a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataCenter f29825b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VectorSearchRequest f29826c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataCenter$searchVectors$2(DataCenter dataCenter, VectorSearchRequest vectorSearchRequest, InterfaceC4014c<? super DataCenter$searchVectors$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f29825b = dataCenter;
        this.f29826c = vectorSearchRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new DataCenter$searchVectors$2(this.f29825b, this.f29826c, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super List<VectorSearchResult>> interfaceC4014c) {
        return ((DataCenter$searchVectors$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29824a;
        if (i10 == 0) {
            C4849c.b(obj);
            p vectorStorageProvider = this.f29825b.getVectorStorageProvider();
            if (vectorStorageProvider == null) {
                Log.w("DataCenter", "searchVectors: no provider yet (AME still initializing?); returning empty");
                return C1173v.m();
            }
            VectorSearchRequest vectorSearchRequest = this.f29826c;
            this.f29824a = 1;
            obj = vectorStorageProvider.i(vectorSearchRequest, this);
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
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super List<? extends VectorSearchResult>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super List<VectorSearchResult>>) interfaceC4014c);
    }
}
