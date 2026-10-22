package androidx.window.layout;

import C7.r;
import J7.c;
import S7.n;
import android.app.Activity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import o9.InterfaceC1779e;
import p9.d;
import p9.m;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "Landroidx/window/layout/WindowMetricsCalculator;", "windowMetricsCalculator", "Landroidx/window/layout/WindowBackend;", "windowBackend", AppAgent.CONSTRUCT, "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/WindowBackend;)V", "Landroid/app/Activity;", "activity", "Lp9/c;", "Landroidx/window/layout/WindowLayoutInfo;", "windowLayoutInfo", "(Landroid/app/Activity;)Lp9/c;", "Landroidx/window/layout/WindowMetricsCalculator;", "Landroidx/window/layout/WindowBackend;", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    @c(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp9/d;", "Landroidx/window/layout/WindowLayoutInfo;", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {1, 6, 0})
    /* renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$activity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        public static final void m7312invokeSuspend$lambda0(InterfaceC1779e interfaceC1779e, WindowLayoutInfo info) {
            k.e(info, "info");
            interfaceC1779e.a(info);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = WindowInfoTrackerImpl.this.new AnonymousClass1(this.$activity, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0091, code lost:
        
            if (r5.emit(r11, r10) == r0) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[Catch: all -> 0x001e, TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:7:0x0018, B:18:0x0064, B:22:0x0077, B:24:0x007f, B:14:0x0035, B:17:0x005f), top: B:31:0x0006 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0091 -> B:8:0x001b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L39
                if (r1 == r3) goto L29
                if (r1 != r2) goto L21
                java.lang.Object r1 = r10.L$2
                o9.b r1 = (o9.C1776b) r1
                java.lang.Object r4 = r10.L$1
                androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
                java.lang.Object r5 = r10.L$0
                p9.d r5 = (p9.d) r5
                kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L1e
            L1b:
                r11 = r5
                r5 = r1
                goto L64
            L1e:
                r11 = move-exception
                goto La0
            L21:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L29:
                java.lang.Object r1 = r10.L$2
                o9.b r1 = (o9.C1776b) r1
                java.lang.Object r4 = r10.L$1
                androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
                java.lang.Object r5 = r10.L$0
                p9.d r5 = (p9.d) r5
                kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L1e
                goto L77
            L39:
                kotlin.b.b(r11)
                java.lang.Object r11 = r10.L$0
                p9.d r11 = (p9.d) r11
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.b
                r4 = 4
                r5 = 10
                kotlinx.coroutines.channels.a r1 = Z6.k.b(r5, r4, r1)
                androidx.window.layout.a r4 = new androidx.window.layout.a
                r4.<init>()
                androidx.window.layout.WindowInfoTrackerImpl r5 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r5 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r5)
                android.app.Activity r6 = r10.$activity
                androidx.appfunctions.internal.c r7 = new androidx.appfunctions.internal.c
                r8 = 0
                r7.<init>(r8)
                r5.registerLayoutChangeCallback(r6, r7, r4)
                o9.b r5 = new o9.b     // Catch: java.lang.Throwable -> L1e
                r5.<init>(r1)     // Catch: java.lang.Throwable -> L1e
            L64:
                r10.L$0 = r11     // Catch: java.lang.Throwable -> L1e
                r10.L$1 = r4     // Catch: java.lang.Throwable -> L1e
                r10.L$2 = r5     // Catch: java.lang.Throwable -> L1e
                r10.label = r3     // Catch: java.lang.Throwable -> L1e
                java.lang.Object r1 = r5.b(r10)     // Catch: java.lang.Throwable -> L1e
                if (r1 != r0) goto L73
                goto L93
            L73:
                r9 = r5
                r5 = r11
                r11 = r1
                r1 = r9
            L77:
                java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L1e
                boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L1e
                if (r11 == 0) goto L94
                java.lang.Object r11 = r1.d()     // Catch: java.lang.Throwable -> L1e
                androidx.window.layout.WindowLayoutInfo r11 = (androidx.window.layout.WindowLayoutInfo) r11     // Catch: java.lang.Throwable -> L1e
                r10.L$0 = r5     // Catch: java.lang.Throwable -> L1e
                r10.L$1 = r4     // Catch: java.lang.Throwable -> L1e
                r10.L$2 = r1     // Catch: java.lang.Throwable -> L1e
                r10.label = r2     // Catch: java.lang.Throwable -> L1e
                java.lang.Object r11 = r5.emit(r11, r10)     // Catch: java.lang.Throwable -> L1e
                if (r11 != r0) goto L1b
            L93:
                return r0
            L94:
                androidx.window.layout.WindowInfoTrackerImpl r10 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r10 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r10)
                r10.unregisterLayoutChangeCallback(r4)
                C7.r r10 = C7.r.f317a
                return r10
            La0:
                androidx.window.layout.WindowInfoTrackerImpl r10 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r10 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r10)
                r10.unregisterLayoutChangeCallback(r4)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(d dVar, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(dVar, cVar)).invokeSuspend(r.f317a);
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        k.f(windowMetricsCalculator, "windowMetricsCalculator");
        k.f(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public p9.c windowLayoutInfo(Activity activity) {
        k.f(activity, "activity");
        return new m(new AnonymousClass1(activity, null));
    }
}
