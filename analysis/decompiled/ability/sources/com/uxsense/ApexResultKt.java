package com.uxsense;

import S7.n;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.uxsense.ApexException;
import com.uxsense.ApexResult;
import com.uxsense.file.FileException;
import com.uxsense.file.FileResult;
import com.uxsense.parse.ParseResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086H¢\u0006\u0004\b\u0007\u0010\b\u001aL\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086H¢\u0006\u0004\b\n\u0010\b\u001a\u001f\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\r\u0010\f\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u000f\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\t*\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/uxsense/ApexResult;", "Lkotlin/Function2;", "LH7/c;", "LC7/r;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "onSuccess", "(Lcom/uxsense/ApexResult;LS7/n;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/ApexException;", "onError", "getOrNull", "(Lcom/uxsense/ApexResult;)Ljava/lang/Object;", "getOrThrow", "Lcom/uxsense/file/FileResult;", "toApexResult", "(Lcom/uxsense/file/FileResult;)Lcom/uxsense/ApexResult;", "Lcom/uxsense/parse/ParseResult;", "(Lcom/uxsense/parse/ParseResult;)Lcom/uxsense/ApexResult;", "Lcom/uxsense/file/FileException;", "toApexException", "(Lcom/uxsense/file/FileException;)Lcom/uxsense/ApexException;", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexResultKt {

    @J7.c(c = "com.uxsense.ApexResultKt", f = "ApexResult.kt", l = {40}, m = "onError")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: com.uxsense.ApexResultKt$onError$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexResultKt.onError(null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexResultKt", f = "ApexResult.kt", l = {33}, m = "onSuccess")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: com.uxsense.ApexResultKt$onSuccess$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12111<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12111(H7.c<? super C12111> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexResultKt.onSuccess(null, null, this);
        }
    }

    public static final <T> T getOrNull(ApexResult<? extends T> apexResult) {
        k.f(apexResult, "<this>");
        if (apexResult instanceof ApexResult.Success) {
            return (T) ((ApexResult.Success) apexResult).getData();
        }
        if (apexResult instanceof ApexResult.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> T getOrThrow(ApexResult<? extends T> apexResult) throws ApexException {
        k.f(apexResult, "<this>");
        if (apexResult instanceof ApexResult.Success) {
            return (T) ((ApexResult.Success) apexResult).getData();
        }
        if (apexResult instanceof ApexResult.Error) {
            throw ((ApexResult.Error) apexResult).getException();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object onError(com.uxsense.ApexResult<? extends T> r4, S7.n r5, H7.c<? super com.uxsense.ApexResult<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof com.uxsense.ApexResultKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.ApexResultKt$onError$1 r0 = (com.uxsense.ApexResultKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexResultKt$onError$1 r0 = new com.uxsense.ApexResultKt$onError$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.uxsense.ApexResult r4 = (com.uxsense.ApexResult) r4
            kotlin.b.b(r6)
            return r4
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            boolean r6 = r4 instanceof com.uxsense.ApexResult.Error
            if (r6 == 0) goto L4c
            r6 = r4
            com.uxsense.ApexResult$Error r6 = (com.uxsense.ApexResult.Error) r6
            com.uxsense.ApexException r6 = r6.getException()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexResultKt.onError(com.uxsense.ApexResult, S7.n, H7.c):java.lang.Object");
    }

    private static final <T> Object onError$$forInline(ApexResult<? extends T> apexResult, n nVar, H7.c<? super ApexResult<? extends T>> cVar) {
        if (apexResult instanceof ApexResult.Error) {
            nVar.invoke(((ApexResult.Error) apexResult).getException(), cVar);
        }
        return apexResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object onSuccess(com.uxsense.ApexResult<? extends T> r4, S7.n r5, H7.c<? super com.uxsense.ApexResult<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof com.uxsense.ApexResultKt.C12111
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.ApexResultKt$onSuccess$1 r0 = (com.uxsense.ApexResultKt.C12111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.ApexResultKt$onSuccess$1 r0 = new com.uxsense.ApexResultKt$onSuccess$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.uxsense.ApexResult r4 = (com.uxsense.ApexResult) r4
            kotlin.b.b(r6)
            return r4
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            boolean r6 = r4 instanceof com.uxsense.ApexResult.Success
            if (r6 == 0) goto L4c
            r6 = r4
            com.uxsense.ApexResult$Success r6 = (com.uxsense.ApexResult.Success) r6
            java.lang.Object r6 = r6.getData()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexResultKt.onSuccess(com.uxsense.ApexResult, S7.n, H7.c):java.lang.Object");
    }

    private static final <T> Object onSuccess$$forInline(ApexResult<? extends T> apexResult, n nVar, H7.c<? super ApexResult<? extends T>> cVar) {
        if (apexResult instanceof ApexResult.Success) {
            nVar.invoke(((ApexResult.Success) apexResult).getData(), cVar);
        }
        return apexResult;
    }

    private static final ApexException toApexException(FileException fileException) {
        if (fileException instanceof FileException.FileNotFound) {
            String message = fileException.getMessage();
            return new ApexException.FileNotFound(message != null ? message : "");
        }
        if (fileException instanceof FileException.PermissionDenied) {
            String message2 = fileException.getMessage();
            return new ApexException.IoError(message2 != null ? message2 : "", fileException);
        }
        if (fileException instanceof FileException.ReadError) {
            String message3 = fileException.getMessage();
            return new ApexException.IoError(message3 != null ? message3 : "", fileException);
        }
        if (fileException instanceof FileException.WriteError) {
            String message4 = fileException.getMessage();
            return new ApexException.IoError(message4 != null ? message4 : "", fileException);
        }
        if (fileException instanceof FileException.InvalidPath) {
            String message5 = fileException.getMessage();
            return new ApexException.InvalidArgument(message5 != null ? message5 : "");
        }
        if (!(fileException instanceof FileException.DiskFull)) {
            throw new NoWhenBranchMatchedException();
        }
        String message6 = fileException.getMessage();
        return new ApexException.IoError(message6 != null ? message6 : "", fileException);
    }

    public static final <T> ApexResult<T> toApexResult(FileResult<? extends T> fileResult) {
        k.f(fileResult, "<this>");
        if (fileResult instanceof FileResult.Success) {
            return new ApexResult.Success(((FileResult.Success) fileResult).getData());
        }
        if (fileResult instanceof FileResult.Error) {
            return new ApexResult.Error(toApexException(((FileResult.Error) fileResult).getException()));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> ApexResult<T> toApexResult(ParseResult<? extends T> parseResult) {
        k.f(parseResult, "<this>");
        if (parseResult instanceof ParseResult.Success) {
            return new ApexResult.Success(((ParseResult.Success) parseResult).getData());
        }
        if (parseResult instanceof ParseResult.Error) {
            ParseResult.Error error = (ParseResult.Error) parseResult;
            return new ApexResult.Error(new ApexException.ParseError(error.getMessage(), error.getException()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
