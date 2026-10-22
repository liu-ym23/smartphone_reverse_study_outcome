package com.stepos.common.utils.filestorage;

import Ua.A0;
import Ua.C1056g;
import Ua.M;
import Ua.Y;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p", "LY8/t;", "<anonymous>", "(I)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1", f = "FileStorageManager.kt", l = {112}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FileStorageManager$enqueueBatchUpload$job$1$results$1 extends SuspendLambda implements p<Integer, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ InterfaceC5074l<Integer, t> $onTotalProgress;
    /* synthetic */ int I$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC5074l<Integer, t> $onTotalProgress;
        final /* synthetic */ int $p;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super Integer, t> interfaceC5074l, int i10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onTotalProgress = interfaceC5074l;
            this.$p = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onTotalProgress, this.$p, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$onTotalProgress.invoke(C4109a.f(this.$p));
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileStorageManager$enqueueBatchUpload$job$1$results$1(InterfaceC5074l<? super Integer, t> interfaceC5074l, InterfaceC4014c<? super FileStorageManager$enqueueBatchUpload$job$1$results$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$onTotalProgress = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FileStorageManager$enqueueBatchUpload$job$1$results$1 fileStorageManager$enqueueBatchUpload$job$1$results$1 = new FileStorageManager$enqueueBatchUpload$job$1$results$1(this.$onTotalProgress, interfaceC4014c);
        fileStorageManager$enqueueBatchUpload$job$1$results$1.I$0 = ((Number) obj).intValue();
        return fileStorageManager$enqueueBatchUpload$job$1$results$1;
    }

    public final Object f(int i10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FileStorageManager$enqueueBatchUpload$job$1$results$1) create(Integer.valueOf(i10), interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, InterfaceC4014c<? super t> interfaceC4014c) {
        return f(num.intValue(), interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            int i11 = this.I$0;
            A0 a0C = Y.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onTotalProgress, i11, null);
            this.label = 1;
            if (C1056g.j(a0C, anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
