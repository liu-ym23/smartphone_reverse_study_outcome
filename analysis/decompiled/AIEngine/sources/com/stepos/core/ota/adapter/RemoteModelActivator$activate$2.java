package com.stepos.core.ota.adapter;

import com.stepos.core.ota.IModelActivationHost;
import com.stepos.core.ota.process.PendingActivationStore;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.RemoteModelActivator$activate$2", f = "RemoteModelActivator.kt", l = {78}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteModelActivator$activate$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends n>>, Object> {
    final /* synthetic */ String $installer;
    final /* synthetic */ String $otaId;
    final /* synthetic */ String $path;
    final /* synthetic */ int $version;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteModelActivator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteModelActivator$activate$2(String str, int i10, String str2, RemoteModelActivator remoteModelActivator, String str3, b<? super RemoteModelActivator$activate$2> bVar) {
        super(2, bVar);
        this.$otaId = str;
        this.$version = i10;
        this.$path = str2;
        this.this$0 = remoteModelActivator;
        this.$installer = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        RemoteModelActivator$activate$2 remoteModelActivator$activate$2 = new RemoteModelActivator$activate$2(this.$otaId, this.$version, this.$path, this.this$0, this.$installer, bVar);
        remoteModelActivator$activate$2.L$0 = obj;
        return remoteModelActivator$activate$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends n>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<n>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        String str;
        int i10;
        String str2;
        String str3;
        IModelActivationHost iModelActivationHost;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i11 = this.label;
        try {
            if (i11 == 0) {
                kotlin.c.b(obj);
                String str4 = this.$otaId;
                int i12 = this.$version;
                String str5 = this.$path;
                RemoteModelActivator remoteModelActivator = this.this$0;
                String str6 = this.$installer;
                PendingActivationStore.INSTANCE.put(str4, i12, str5);
                this.L$0 = str4;
                this.L$1 = str5;
                this.L$2 = str6;
                this.I$0 = i12;
                this.label = 1;
                Object objAwaitHost$default = RemoteModelActivator.awaitHost$default(remoteModelActivator, 0L, this, 1, null);
                if (objAwaitHost$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
                obj = objAwaitHost$default;
                str = str4;
                i10 = i12;
                str2 = str5;
                str3 = str6;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i10 = this.I$0;
                str3 = (String) this.L$2;
                str2 = (String) this.L$1;
                str = (String) this.L$0;
                kotlin.c.b(obj);
            }
            iModelActivationHost = (IModelActivationHost) obj;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (iModelActivationHost == null) {
            throw new IllegalStateException("IModelActivationHost not connected");
        }
        boolean zActivate = iModelActivationHost.activate(str, i10, str2, str3);
        PendingActivationStore.INSTANCE.remove(str);
        if (zActivate) {
            objA = n.f10413a;
            return new Result(objA);
        }
        throw new IllegalStateException(("activate rejected: " + str).toString());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<n>> bVar) {
        return ((RemoteModelActivator$activate$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
