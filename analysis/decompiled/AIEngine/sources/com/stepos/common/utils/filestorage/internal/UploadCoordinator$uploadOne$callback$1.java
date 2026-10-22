package com.stepos.common.utils.filestorage.internal;

import android.content.Context;
import android.net.Uri;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import lb.n;
import o8.f;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadOne$callback$1", f = "UploadCoordinator.kt", l = {242}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class UploadCoordinator$uploadOne$callback$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super f>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6744a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UploadCoordinator f6745b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f6746c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o8.c f6747d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Uri f6748e;
    public final /* synthetic */ String h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Long f6749j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ n8.a f6750k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadOne$callback$1$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<Long, n> {
        @Override // zb.l
        public final n invoke(Long l10) {
            long jLongValue = l10.longValue();
            n8.a aVar = (n8.a) this.receiver;
            long j10 = aVar.f10648c + jLongValue;
            aVar.f10648c = j10;
            long j11 = aVar.f10647b;
            if (j10 > j11) {
                j10 = j11;
            }
            if (j10 > aVar.f10649d) {
                long j12 = j10 - aVar.f10649d;
                aVar.f10649d = j10;
                aVar.f10646a.addAndGet(j12);
            }
            return n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadCoordinator$uploadOne$callback$1(UploadCoordinator uploadCoordinator, Context context, o8.c cVar, Uri uri, String str, Long l10, n8.a aVar, qb.b<? super UploadCoordinator$uploadOne$callback$1> bVar) {
        super(2, bVar);
        this.f6745b = uploadCoordinator;
        this.f6746c = context;
        this.f6747d = cVar;
        this.f6748e = uri;
        this.h = str;
        this.f6749j = l10;
        this.f6750k = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new UploadCoordinator$uploadOne$callback$1(this.f6745b, this.f6746c, this.f6747d, this.f6748e, this.h, this.f6749j, this.f6750k, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super f> bVar) {
        return ((UploadCoordinator$uploadOne$callback$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f6744a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        stepos.support.v7.app.palette.b bVar = this.f6745b.f6685c;
        String str = this.f6747d.f10791b;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(1, this.f6750k, n8.a.class, "onBytesRead", "onBytesRead(J)V", 0);
        this.f6744a = 1;
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new TosUploader$put$2(this.h, this.f6746c, this.f6748e, this.f6749j, anonymousClass1, str, bVar, null), this);
        return objWithContext == coroutineSingletons ? coroutineSingletons : objWithContext;
    }
}
