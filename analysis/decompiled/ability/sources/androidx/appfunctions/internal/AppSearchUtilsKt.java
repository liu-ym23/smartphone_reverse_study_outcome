package androidx.appfunctions.internal;

import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0081@¢\u0006\u0004\b\u0003\u0010\u0004\u001a<\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b\"\b\b\u0000\u0010\u0006*\u00020\u0005*\u00020\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bH\u0087@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "context", "Landroidx/appsearch/app/GlobalSearchSession;", "createSearchSession", "(Landroid/content/Context;LH7/c;)Ljava/lang/Object;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/appsearch/app/SearchResults;", "Lkotlin/Function1;", "Landroidx/appsearch/app/SearchResult;", "transformToDocumentClassOrNull", "", "readAll", "(Landroidx/appsearch/app/SearchResults;LS7/k;LH7/c;)Ljava/lang/Object;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppSearchUtilsKt {

    @J7.c(c = "androidx.appfunctions.internal.AppSearchUtilsKt", f = "AppSearchUtils.kt", l = {42}, m = "createSearchSession", v = 1)
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.appfunctions.internal.AppSearchUtilsKt$createSearchSession$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchUtilsKt.createSearchSession(null, this);
        }
    }

    @J7.c(c = "androidx.appfunctions.internal.AppSearchUtilsKt", f = "AppSearchUtils.kt", l = {60, 63}, m = "readAll", v = 1)
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.appfunctions.internal.AppSearchUtilsKt$readAll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03221<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C03221(H7.c<? super C03221> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchUtilsKt.readAll(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.RequiresApi(31)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object createSearchSession(android.content.Context r4, H7.c<? super androidx.appsearch.app.GlobalSearchSession> r5) {
        /*
            boolean r0 = r5 instanceof androidx.appfunctions.internal.AppSearchUtilsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.appfunctions.internal.AppSearchUtilsKt$createSearchSession$1 r0 = (androidx.appfunctions.internal.AppSearchUtilsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.appfunctions.internal.AppSearchUtilsKt$createSearchSession$1 r0 = new androidx.appfunctions.internal.AppSearchUtilsKt$createSearchSession$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L57
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            androidx.appsearch.platformstorage.PlatformStorage$GlobalSearchContext$Builder r5 = new androidx.appsearch.platformstorage.PlatformStorage$GlobalSearchContext$Builder
            r5.<init>(r4)
            androidx.appfunctions.internal.c r4 = new androidx.appfunctions.internal.c
            r2 = 0
            r4.<init>(r2)
            androidx.appsearch.platformstorage.PlatformStorage$GlobalSearchContext$Builder r4 = r5.setWorkerExecutor(r4)
            androidx.appsearch.platformstorage.PlatformStorage$GlobalSearchContext r4 = r4.build()
            n3.a r4 = androidx.appsearch.platformstorage.PlatformStorage.createGlobalSearchSessionAsync(r4)
            java.lang.String r5 = "createGlobalSearchSessionAsync(...)"
            kotlin.jvm.internal.k.e(r4, r5)
            r0.label = r3
            java.lang.Object r5 = com.stepos.statsrpk.d.i(r4, r0)
            if (r5 != r1) goto L57
            return r1
        L57:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.k.e(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.internal.AppSearchUtilsKt.createSearchSession(android.content.Context, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00dd -> B:35:0x00e0). Please report as a decompilation issue!!! */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object readAll(androidx.appsearch.app.SearchResults r9, S7.k r10, H7.c<? super java.util.List<? extends T>> r11) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.internal.AppSearchUtilsKt.readAll(androidx.appsearch.app.SearchResults, S7.k, H7.c):java.lang.Object");
    }
}
