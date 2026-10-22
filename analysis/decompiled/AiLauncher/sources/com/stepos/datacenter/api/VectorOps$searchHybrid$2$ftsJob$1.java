package com.stepos.datacenter.api;

import Ua.M;
import Y8.t;
import Z8.C1173v;
import android.content.Context;
import android.util.Log;
import b7.C1453a;
import b7.C1454b;
import com.stepos.datacenter.vector.HybridSearchRequest;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lb7/d;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.api.VectorOps$searchHybrid$2$ftsJob$1", f = "VectorOps.kt", l = {148}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class VectorOps$searchHybrid$2$ftsJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends b7.d>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f29948a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HybridSearchRequest f29949b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f29950c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorOps$searchHybrid$2$ftsJob$1(HybridSearchRequest hybridSearchRequest, Context context, InterfaceC4014c<? super VectorOps$searchHybrid$2$ftsJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29949b = hybridSearchRequest;
        this.f29950c = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VectorOps$searchHybrid$2$ftsJob$1(this.f29949b, this.f29950c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super List<? extends b7.d>> interfaceC4014c) {
        return ((VectorOps$searchHybrid$2$ftsJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f29948a;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                C1454b.a aVar = new C1454b.a(this.f29949b.getKeyword());
                HybridSearchRequest hybridSearchRequest = this.f29949b;
                String keywordTableName = hybridSearchRequest.getKeywordTableName();
                if (keywordTableName != null) {
                    aVar.l(keywordTableName);
                }
                aVar.k(hybridSearchRequest.getPerPathTopK());
                C1454b c1454bJ = aVar.j();
                C1453a c1453aA = C1453a.INSTANCE.a(this.f29950c);
                kotlin.jvm.internal.p.f(c1454bJ);
                this.f29948a = 1;
                obj = c1453aA.g(c1454bJ, this);
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
            Log.w("DataCenter", "searchHybrid: FTS failed: " + e10.getMessage());
            return C1173v.m();
        }
    }
}
