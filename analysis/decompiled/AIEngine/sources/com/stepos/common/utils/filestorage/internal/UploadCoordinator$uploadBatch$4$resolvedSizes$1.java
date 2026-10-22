package com.stepos.common.utils.filestorage.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import mb.m;
import o8.h;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$resolvedSizes$1", f = "UploadCoordinator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class UploadCoordinator$uploadBatch$4$resolvedSizes$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super List<? extends Long>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6720a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<h> f6721b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UploadCoordinator f6722c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f6723d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadCoordinator$uploadBatch$4$resolvedSizes$1(List<h> list, UploadCoordinator uploadCoordinator, Context context, qb.b<? super UploadCoordinator$uploadBatch$4$resolvedSizes$1> bVar) {
        super(2, bVar);
        this.f6721b = list;
        this.f6722c = uploadCoordinator;
        this.f6723d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        UploadCoordinator$uploadBatch$4$resolvedSizes$1 uploadCoordinator$uploadBatch$4$resolvedSizes$1 = new UploadCoordinator$uploadBatch$4$resolvedSizes$1(this.f6721b, this.f6722c, this.f6723d, bVar);
        uploadCoordinator$uploadBatch$4$resolvedSizes$1.f6720a = obj;
        return uploadCoordinator$uploadBatch$4$resolvedSizes$1;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super List<? extends Long>> bVar) {
        return ((UploadCoordinator$uploadBatch$4$resolvedSizes$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        kotlin.c.b(obj);
        Context context = this.f6723d;
        List<h> list = this.f6721b;
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            try {
                objA = UploadCoordinator.c(context, UploadCoordinator.b(((h) it.next()).f10822a));
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            arrayList.add((Long) objA);
        }
        return arrayList;
    }
}
