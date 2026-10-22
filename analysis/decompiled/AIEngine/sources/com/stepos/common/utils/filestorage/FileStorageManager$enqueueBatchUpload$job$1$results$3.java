package com.stepos.common.utils.filestorage;

import com.stepos.core.common.cloud.f;
import java.io.Serializable;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import lb.n;
import o8.i;
import qb.b;
import rb.c;
import zb.p;
import zb.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3", f = "FileStorageManager.kt", l = {117}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FileStorageManager$enqueueBatchUpload$job$1$results$3 extends SuspendLambda implements s<Integer, i, Integer, Integer, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6613a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int f6614b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ i f6615c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f6616d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ int f6617e;
    public final /* synthetic */ f h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f6618a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6619b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f6620c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f6621d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f6622e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(f fVar, int i10, i iVar, int i11, int i12, b bVar) {
            super(2, bVar);
            this.f6618a = fVar;
            this.f6619b = i10;
            this.f6620c = iVar;
            this.f6621d = i11;
            this.f6622e = i12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass1(this.f6618a, this.f6619b, this.f6620c, this.f6621d, this.f6622e, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            this.f6618a.a(new Integer(this.f6619b), this.f6620c, new Integer(this.f6621d), new Integer(this.f6622e));
            return n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageManager$enqueueBatchUpload$job$1$results$3(f fVar, b bVar) {
        super(5, bVar);
        this.h = fVar;
    }

    @Override // zb.s
    public final Object d(Integer num, Object obj, Integer num2, Object obj2, Serializable serializable) {
        int iIntValue = num.intValue();
        int iIntValue2 = num2.intValue();
        int iIntValue3 = ((Number) obj2).intValue();
        FileStorageManager$enqueueBatchUpload$job$1$results$3 fileStorageManager$enqueueBatchUpload$job$1$results$3 = new FileStorageManager$enqueueBatchUpload$job$1$results$3(this.h, (b) serializable);
        fileStorageManager$enqueueBatchUpload$job$1$results$3.f6614b = iIntValue;
        fileStorageManager$enqueueBatchUpload$job$1$results$3.f6615c = (i) obj;
        fileStorageManager$enqueueBatchUpload$job$1$results$3.f6616d = iIntValue2;
        fileStorageManager$enqueueBatchUpload$job$1$results$3.f6617e = iIntValue3;
        return fileStorageManager$enqueueBatchUpload$job$1$results$3.invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f6613a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            int i11 = this.f6614b;
            i iVar = this.f6615c;
            int i12 = this.f6616d;
            int i13 = this.f6617e;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.h, i11, iVar, i12, i13, null);
            this.f6613a = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return n.f10413a;
    }
}
