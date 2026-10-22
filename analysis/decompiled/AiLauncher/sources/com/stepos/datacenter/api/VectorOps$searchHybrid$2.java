package com.stepos.datacenter.api;

import Ua.C1060i;
import Ua.M;
import Ua.Q;
import Y8.t;
import android.content.Context;
import com.stepos.datacenter.vector.HybridSearchRequest;
import com.stepos.datacenter.vector.VectorSearchResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "", "Lb7/d;", "Lcom/stepos/datacenter/vector/VectorSearchResult;", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.api.VectorOps$searchHybrid$2", f = "VectorOps.kt", l = {169, 169}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class VectorOps$searchHybrid$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Pair<? extends List<? extends b7.d>, ? extends List<? extends VectorSearchResult>>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29943a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29944b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HybridSearchRequest f29945c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f29946d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DataCenter f29947e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorOps$searchHybrid$2(HybridSearchRequest hybridSearchRequest, Context context, DataCenter dataCenter, InterfaceC4014c<? super VectorOps$searchHybrid$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29945c = hybridSearchRequest;
        this.f29946d = context;
        this.f29947e = dataCenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        VectorOps$searchHybrid$2 vectorOps$searchHybrid$2 = new VectorOps$searchHybrid$2(this.f29945c, this.f29946d, this.f29947e, interfaceC4014c);
        vectorOps$searchHybrid$2.f29944b = obj;
        return vectorOps$searchHybrid$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Pair<? extends List<? extends b7.d>, ? extends List<VectorSearchResult>>> interfaceC4014c) {
        return ((VectorOps$searchHybrid$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Q qB;
        Object obj2;
        Object objG = C4063a.g();
        int i10 = this.f29943a;
        if (i10 == 0) {
            C4849c.b(obj);
            M m10 = (M) this.f29944b;
            Q qB2 = C1060i.b(m10, null, null, new VectorOps$searchHybrid$2$ftsJob$1(this.f29945c, this.f29946d, null), 3, null);
            qB = C1060i.b(m10, null, null, new VectorOps$searchHybrid$2$vecJob$1(this.f29947e, this.f29945c, null), 3, null);
            this.f29944b = qB;
            this.f29943a = 1;
            obj = qB2.a1(this);
            if (obj != objG) {
            }
            return objG;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = this.f29944b;
            C4849c.b(obj);
            return new Pair(obj2, obj);
        }
        qB = (Q) this.f29944b;
        C4849c.b(obj);
        this.f29944b = obj;
        this.f29943a = 2;
        Object objA1 = qB.a1(this);
        if (objA1 != objG) {
            Object obj3 = obj;
            obj = objA1;
            obj2 = obj3;
            return new Pair(obj2, obj);
        }
        return objG;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Pair<? extends List<? extends b7.d>, ? extends List<? extends VectorSearchResult>>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Pair<? extends List<? extends b7.d>, ? extends List<VectorSearchResult>>>) interfaceC4014c);
    }
}
