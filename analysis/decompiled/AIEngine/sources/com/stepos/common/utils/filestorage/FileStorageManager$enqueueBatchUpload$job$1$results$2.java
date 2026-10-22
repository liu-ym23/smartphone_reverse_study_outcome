package com.stepos.common.utils.filestorage;

import com.stepos.core.common.cloud.e;
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
import zb.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$2", f = "FileStorageManager.kt", l = {114}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FileStorageManager$enqueueBatchUpload$job$1$results$2 extends SuspendLambda implements r<Integer, String, Integer, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6604a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int f6605b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f6606c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f6607d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e f6608e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$2$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f6609a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6610b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f6611c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f6612d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(e eVar, int i10, String str, int i11, b bVar) {
            super(2, bVar);
            this.f6609a = eVar;
            this.f6610b = i10;
            this.f6611c = str;
            this.f6612d = i11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass1(this.f6609a, this.f6610b, this.f6611c, this.f6612d, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            this.f6609a.invoke(new Integer(this.f6610b), this.f6611c, new Integer(this.f6612d));
            return n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageManager$enqueueBatchUpload$job$1$results$2(e eVar, b bVar) {
        super(4, bVar);
        this.f6608e = eVar;
    }

    @Override // zb.r
    public final Object a(Integer num, String str, Integer num2, b<? super n> bVar) {
        int iIntValue = num.intValue();
        int iIntValue2 = num2.intValue();
        FileStorageManager$enqueueBatchUpload$job$1$results$2 fileStorageManager$enqueueBatchUpload$job$1$results$2 = new FileStorageManager$enqueueBatchUpload$job$1$results$2(this.f6608e, bVar);
        fileStorageManager$enqueueBatchUpload$job$1$results$2.f6605b = iIntValue;
        fileStorageManager$enqueueBatchUpload$job$1$results$2.f6606c = str;
        fileStorageManager$enqueueBatchUpload$job$1$results$2.f6607d = iIntValue2;
        return fileStorageManager$enqueueBatchUpload$job$1$results$2.invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f6604a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            int i11 = this.f6605b;
            String str = this.f6606c;
            int i12 = this.f6607d;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f6608e, i11, str, i12, null);
            this.f6604a = 1;
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
