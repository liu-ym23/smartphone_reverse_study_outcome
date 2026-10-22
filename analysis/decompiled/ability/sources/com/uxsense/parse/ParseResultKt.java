package com.uxsense.parse;

import J7.c;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.uxsense.parse.ParseResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aL\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086H¢\u0006\u0004\b\u0007\u0010\b\u001aP\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012(\b\u0004\u0010\u0006\u001a\"\b\u0001\u0012\b\u0012\u00060\tj\u0002`\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086H¢\u0006\u0004\b\u000b\u0010\b\u001a\u001f\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/uxsense/parse/ParseResult;", "Lkotlin/Function2;", "LH7/c;", "LC7/r;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "onSuccess", "(Lcom/uxsense/parse/ParseResult;LS7/n;LH7/c;)Ljava/lang/Object;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onError", "getOrNull", "(Lcom/uxsense/parse/ParseResult;)Ljava/lang/Object;", "getOrThrow", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ParseResultKt {

    @c(c = "com.uxsense.parse.ParseResultKt", f = "ParseResult.kt", l = {26}, m = "onError")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: com.uxsense.parse.ParseResultKt$onError$1, reason: invalid class name */
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
            return ParseResultKt.onError(null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.ParseResultKt", f = "ParseResult.kt", l = {17}, m = "onSuccess")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    /* renamed from: com.uxsense.parse.ParseResultKt$onSuccess$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12921<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12921(H7.c<? super C12921> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ParseResultKt.onSuccess(null, null, this);
        }
    }

    public static final <T> T getOrNull(ParseResult<? extends T> parseResult) {
        k.f(parseResult, "<this>");
        if (parseResult instanceof ParseResult.Success) {
            return (T) ((ParseResult.Success) parseResult).getData();
        }
        if (parseResult instanceof ParseResult.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> T getOrThrow(ParseResult<? extends T> parseResult) throws Exception {
        k.f(parseResult, "<this>");
        if (parseResult instanceof ParseResult.Success) {
            return (T) ((ParseResult.Success) parseResult).getData();
        }
        if (parseResult instanceof ParseResult.Error) {
            throw ((ParseResult.Error) parseResult).getException();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object onError(com.uxsense.parse.ParseResult<? extends T> r4, S7.n r5, H7.c<? super com.uxsense.parse.ParseResult<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof com.uxsense.parse.ParseResultKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.parse.ParseResultKt$onError$1 r0 = (com.uxsense.parse.ParseResultKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.parse.ParseResultKt$onError$1 r0 = new com.uxsense.parse.ParseResultKt$onError$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.uxsense.parse.ParseResult r4 = (com.uxsense.parse.ParseResult) r4
            kotlin.b.b(r6)
            return r4
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            boolean r6 = r4 instanceof com.uxsense.parse.ParseResult.Error
            if (r6 == 0) goto L4c
            r6 = r4
            com.uxsense.parse.ParseResult$Error r6 = (com.uxsense.parse.ParseResult.Error) r6
            java.lang.Exception r6 = r6.getException()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.ParseResultKt.onError(com.uxsense.parse.ParseResult, S7.n, H7.c):java.lang.Object");
    }

    private static final <T> Object onError$$forInline(ParseResult<? extends T> parseResult, n nVar, H7.c<? super ParseResult<? extends T>> cVar) {
        if (parseResult instanceof ParseResult.Error) {
            nVar.invoke(((ParseResult.Error) parseResult).getException(), cVar);
        }
        return parseResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object onSuccess(com.uxsense.parse.ParseResult<? extends T> r4, S7.n r5, H7.c<? super com.uxsense.parse.ParseResult<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof com.uxsense.parse.ParseResultKt.C12921
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.parse.ParseResultKt$onSuccess$1 r0 = (com.uxsense.parse.ParseResultKt.C12921) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.parse.ParseResultKt$onSuccess$1 r0 = new com.uxsense.parse.ParseResultKt$onSuccess$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.uxsense.parse.ParseResult r4 = (com.uxsense.parse.ParseResult) r4
            kotlin.b.b(r6)
            return r4
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            boolean r6 = r4 instanceof com.uxsense.parse.ParseResult.Success
            if (r6 == 0) goto L4c
            r6 = r4
            com.uxsense.parse.ParseResult$Success r6 = (com.uxsense.parse.ParseResult.Success) r6
            java.lang.Object r6 = r6.getData()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.ParseResultKt.onSuccess(com.uxsense.parse.ParseResult, S7.n, H7.c):java.lang.Object");
    }

    private static final <T> Object onSuccess$$forInline(ParseResult<? extends T> parseResult, n nVar, H7.c<? super ParseResult<? extends T>> cVar) {
        if (parseResult instanceof ParseResult.Success) {
            nVar.invoke(((ParseResult.Success) parseResult).getData(), cVar);
        }
        return parseResult;
    }
}
