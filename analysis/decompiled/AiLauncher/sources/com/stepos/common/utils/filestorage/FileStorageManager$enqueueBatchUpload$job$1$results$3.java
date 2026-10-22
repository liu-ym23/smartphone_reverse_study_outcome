package com.stepos.common.utils.filestorage;

import P6.UploadResult;
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
import p9.p;
import p9.r;
import p9.s;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "idx", "LP6/m;", "r", "done", "total", "LY8/t;", "<anonymous>", "(ILP6/m;II)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3", f = "FileStorageManager.kt", l = {118}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FileStorageManager$enqueueBatchUpload$job$1$results$3 extends SuspendLambda implements s<Integer, UploadResult, Integer, Integer, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ r<Integer, UploadResult, Integer, Integer, t> $onFileFinished;
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    /* synthetic */ int I$2;
    /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ int $done;
        final /* synthetic */ int $idx;
        final /* synthetic */ r<Integer, UploadResult, Integer, Integer, t> $onFileFinished;
        final /* synthetic */ UploadResult $r;
        final /* synthetic */ int $total;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(r<? super Integer, ? super UploadResult, ? super Integer, ? super Integer, t> rVar, int i10, UploadResult uploadResult, int i11, int i12, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onFileFinished = rVar;
            this.$idx = i10;
            this.$r = uploadResult;
            this.$done = i11;
            this.$total = i12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onFileFinished, this.$idx, this.$r, this.$done, this.$total, interfaceC4014c);
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
            this.$onFileFinished.invoke(C4109a.f(this.$idx), this.$r, C4109a.f(this.$done), C4109a.f(this.$total));
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileStorageManager$enqueueBatchUpload$job$1$results$3(r<? super Integer, ? super UploadResult, ? super Integer, ? super Integer, t> rVar, InterfaceC4014c<? super FileStorageManager$enqueueBatchUpload$job$1$results$3> interfaceC4014c) {
        super(5, interfaceC4014c);
        this.$onFileFinished = rVar;
    }

    public final Object f(int i10, UploadResult uploadResult, int i11, int i12, InterfaceC4014c<? super t> interfaceC4014c) {
        FileStorageManager$enqueueBatchUpload$job$1$results$3 fileStorageManager$enqueueBatchUpload$job$1$results$3 = new FileStorageManager$enqueueBatchUpload$job$1$results$3(this.$onFileFinished, interfaceC4014c);
        fileStorageManager$enqueueBatchUpload$job$1$results$3.I$0 = i10;
        fileStorageManager$enqueueBatchUpload$job$1$results$3.L$0 = uploadResult;
        fileStorageManager$enqueueBatchUpload$job$1$results$3.I$1 = i11;
        fileStorageManager$enqueueBatchUpload$job$1$results$3.I$2 = i12;
        return fileStorageManager$enqueueBatchUpload$job$1$results$3.invokeSuspend(t.f7040a);
    }

    @Override // p9.s
    public /* bridge */ /* synthetic */ Object invoke(Integer num, UploadResult uploadResult, Integer num2, Integer num3, InterfaceC4014c<? super t> interfaceC4014c) {
        return f(num.intValue(), uploadResult, num2.intValue(), num3.intValue(), interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            int i11 = this.I$0;
            UploadResult uploadResult = (UploadResult) this.L$0;
            int i12 = this.I$1;
            int i13 = this.I$2;
            A0 a0C = Y.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onFileFinished, i11, uploadResult, i12, i13, null);
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
