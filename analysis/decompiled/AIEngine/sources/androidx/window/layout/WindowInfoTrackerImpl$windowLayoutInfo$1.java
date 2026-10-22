package androidx.window.layout;

import android.app.Activity;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements p<FlowCollector<? super m>, qb.b<? super lb.n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public u0.a f2716a;

    /* renamed from: b, reason: collision with root package name */
    public ChannelIterator f2717b;

    /* renamed from: c, reason: collision with root package name */
    public int f2718c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f2719d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ WindowInfoTrackerImpl f2720e;
    public final /* synthetic */ Activity h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, qb.b<? super WindowInfoTrackerImpl$windowLayoutInfo$1> bVar) {
        super(2, bVar);
        this.f2720e = windowInfoTrackerImpl;
        this.h = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.f2720e, this.h, bVar);
        windowInfoTrackerImpl$windowLayoutInfo$1.f2719d = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // zb.p
    public final Object invoke(FlowCollector<? super m> flowCollector, qb.b<? super lb.n> bVar) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
    
        if (r6.emit(r10, r9) == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #0 {all -> 0x001d, blocks: (B:7:0x0018, B:18:0x0058, B:22:0x006a, B:24:0x0072, B:14:0x002f, B:17:0x0054), top: B:31:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0084 -> B:8:0x001b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            androidx.window.layout.WindowInfoTrackerImpl r0 = r9.f2720e
            androidx.window.layout.k r0 = r0.f2715b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r9.f2718c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 == r4) goto L27
            if (r2 != r3) goto L1f
            kotlinx.coroutines.channels.ChannelIterator r2 = r9.f2717b
            u0.a r5 = r9.f2716a
            java.lang.Object r6 = r9.f2719d
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.c.b(r10)     // Catch: java.lang.Throwable -> L1d
        L1b:
            r10 = r6
            goto L58
        L1d:
            r9 = move-exception
            goto L8d
        L1f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L27:
            kotlinx.coroutines.channels.ChannelIterator r2 = r9.f2717b
            u0.a r5 = r9.f2716a
            java.lang.Object r6 = r9.f2719d
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.c.b(r10)     // Catch: java.lang.Throwable -> L1d
            goto L6a
        L33:
            kotlin.c.b(r10)
            java.lang.Object r10 = r9.f2719d
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlinx.coroutines.channels.BufferOverflow r2 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
            r5 = 4
            r6 = 10
            r7 = 0
            kotlinx.coroutines.channels.Channel r2 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r6, r2, r7, r5, r7)
            androidx.fragment.app.m r5 = new androidx.fragment.app.m
            r6 = 1
            r5.<init>(r2, r6)
            t1.b r6 = new t1.b
            r6.<init>()
            android.app.Activity r7 = r9.h
            r0.b(r7, r6, r5)
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L1d
        L58:
            r9.f2719d = r10     // Catch: java.lang.Throwable -> L1d
            r9.f2716a = r5     // Catch: java.lang.Throwable -> L1d
            r9.f2717b = r2     // Catch: java.lang.Throwable -> L1d
            r9.f2718c = r4     // Catch: java.lang.Throwable -> L1d
            java.lang.Object r6 = r2.hasNext(r9)     // Catch: java.lang.Throwable -> L1d
            if (r6 != r1) goto L67
            goto L86
        L67:
            r8 = r6
            r6 = r10
            r10 = r8
        L6a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L1d
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L1d
            if (r10 == 0) goto L87
            java.lang.Object r10 = r2.next()     // Catch: java.lang.Throwable -> L1d
            androidx.window.layout.m r10 = (androidx.window.layout.m) r10     // Catch: java.lang.Throwable -> L1d
            r9.f2719d = r6     // Catch: java.lang.Throwable -> L1d
            r9.f2716a = r5     // Catch: java.lang.Throwable -> L1d
            r9.f2717b = r2     // Catch: java.lang.Throwable -> L1d
            r9.f2718c = r3     // Catch: java.lang.Throwable -> L1d
            java.lang.Object r10 = r6.emit(r10, r9)     // Catch: java.lang.Throwable -> L1d
            if (r10 != r1) goto L1b
        L86:
            return r1
        L87:
            r0.a(r5)
            lb.n r9 = lb.n.f10413a
            return r9
        L8d:
            r0.a(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
