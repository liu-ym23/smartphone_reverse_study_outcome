package com.stepos.common.utils.filestorage;

import androidx.compose.runtime.i;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1", f = "FileStorageManager.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FileStorageManager$enqueueBatchUpload$job$1$results$1 extends SuspendLambda implements p<Integer, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6599a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int f6600b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f6601c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f6602a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6603b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(i iVar, int i10, b bVar) {
            super(2, bVar);
            this.f6602a = iVar;
            this.f6603b = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass1(this.f6602a, this.f6603b, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            this.f6602a.invoke(new Integer(this.f6603b));
            return n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageManager$enqueueBatchUpload$job$1$results$1(i iVar, b bVar) {
        super(2, bVar);
        this.f6601c = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        FileStorageManager$enqueueBatchUpload$job$1$results$1 fileStorageManager$enqueueBatchUpload$job$1$results$1 = new FileStorageManager$enqueueBatchUpload$job$1$results$1(this.f6601c, bVar);
        fileStorageManager$enqueueBatchUpload$job$1$results$1.f6600b = ((Number) obj).intValue();
        return fileStorageManager$enqueueBatchUpload$job$1$results$1;
    }

    @Override // zb.p
    public final Object invoke(Integer num, b<? super n> bVar) {
        return ((FileStorageManager$enqueueBatchUpload$job$1$results$1) create(Integer.valueOf(num.intValue()), bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f6599a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            int i11 = this.f6600b;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f6601c, i11, null);
            this.f6599a = 1;
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
