package com.stepos.datacenter.vector;

import Ua.M;
import Y8.t;
import android.content.Context;
import android.util.Log;
import com.stepos.aiengine.algorithm.embedding.IEmbedding;
import com.stepos.aiengine.client.AlgorithmClient;
import com.stepos.aiengine.clients.AlgorithmClients;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.vector.BgeEmbedProvider$prewarmAsync$1", f = "BgeEmbedProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BgeEmbedProvider$prewarmAsync$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30102a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BgeEmbedProvider f30103b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgeEmbedProvider$prewarmAsync$1(BgeEmbedProvider bgeEmbedProvider, InterfaceC4014c<? super BgeEmbedProvider$prewarmAsync$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30103b = bgeEmbedProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BgeEmbedProvider$prewarmAsync$1(this.f30103b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((BgeEmbedProvider$prewarmAsync$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f30102a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            AlgorithmClient<IEmbedding> bgeEmbedding = AlgorithmClients.INSTANCE.getBgeEmbedding();
            Context context = this.f30103b.appContext;
            kotlin.jvm.internal.p.h(context, "access$getAppContext$p(...)");
            AlgorithmClient.loadAlgorithm$default(bgeEmbedding, context, null, 2, null);
            Log.i("BgeEmbedProvider", "BGE client prewarmed (loadAlgorithm ok)");
        } catch (Throwable th) {
            Log.w("BgeEmbedProvider", "BGE prewarm (loadAlgorithm) failed: " + th.getMessage(), th);
        }
        return t.f7040a;
    }
}
