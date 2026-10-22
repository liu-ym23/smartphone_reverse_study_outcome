package android.view;

import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a2\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0086H¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/activity/FullyDrawnReporter;", "Lkotlin/Function1;", "LH7/c;", "LC7/r;", "", "reporter", "reportWhenComplete", "(Landroidx/activity/FullyDrawnReporter;LS7/k;LH7/c;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FullyDrawnReporterKt {

    @c(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {173}, m = "reportWhenComplete")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    /* renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object reportWhenComplete(android.view.FullyDrawnReporter r5, S7.k r6, H7.c<? super C7.r> r7) {
        /*
            boolean r0 = r7 instanceof android.view.FullyDrawnReporterKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (android.view.FullyDrawnReporterKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r5 = r0.L$0
            androidx.activity.FullyDrawnReporter r5 = (android.view.FullyDrawnReporter) r5
            kotlin.b.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r6 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.b.b(r7)
            r5.addReporter()
            boolean r7 = r5.isFullyDrawnReported()
            if (r7 == 0) goto L44
            return r3
        L44:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2d
            r0.label = r4     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r6 = r6.invoke(r0)     // Catch: java.lang.Throwable -> L2d
            if (r6 != r1) goto L4f
            return r1
        L4f:
            r5.removeReporter()
            return r3
        L53:
            r5.removeReporter()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, S7.k, H7.c):java.lang.Object");
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, k kVar, H7.c<? super r> cVar) {
        fullyDrawnReporter.addReporter();
        boolean zIsFullyDrawnReported = fullyDrawnReporter.isFullyDrawnReported();
        r rVar = r.f317a;
        if (zIsFullyDrawnReported) {
            return rVar;
        }
        try {
            kVar.invoke(cVar);
            return rVar;
        } finally {
            fullyDrawnReporter.removeReporter();
        }
    }
}
