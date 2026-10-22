package androidx.compose.ui.platform;

import C7.r;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/GlobalSnapshotManager;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "ensureStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sent", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GlobalSnapshotManager {
    public static final GlobalSnapshotManager INSTANCE = new GlobalSnapshotManager();
    private static final AtomicBoolean started = new AtomicBoolean(false);
    private static final AtomicBoolean sent = new AtomicBoolean(false);
    public static final int $stable = 8;

    @J7.c(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", l = {ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
        final /* synthetic */ InterfaceC1779e $channel;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC1779e interfaceC1779e, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$channel = interfaceC1779e;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$channel, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[Catch: all -> 0x0016, TRY_LEAVE, TryCatch #0 {all -> 0x0016, blocks: (B:6:0x0012, B:17:0x0037, B:19:0x003f, B:14:0x002a, B:13:0x0025), top: B:32:0x0006 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0034 -> B:17:0x0037). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r6.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 != r3) goto L18
                java.lang.Object r1 = r6.L$1
                o9.b r1 = (o9.C1776b) r1
                java.lang.Object r4 = r6.L$0
                o9.n r4 = (o9.n) r4
                kotlin.b.b(r7)     // Catch: java.lang.Throwable -> L16
                goto L37
            L16:
                r6 = move-exception
                goto L59
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L20:
                kotlin.b.b(r7)
                o9.e r4 = r6.$channel
                o9.b r7 = r4.iterator()     // Catch: java.lang.Throwable -> L16
                r1 = r7
            L2a:
                r6.L$0 = r4     // Catch: java.lang.Throwable -> L16
                r6.L$1 = r1     // Catch: java.lang.Throwable -> L16
                r6.label = r3     // Catch: java.lang.Throwable -> L16
                java.lang.Object r7 = r1.b(r6)     // Catch: java.lang.Throwable -> L16
                if (r7 != r0) goto L37
                return r0
            L37:
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L16
                boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L16
                if (r7 == 0) goto L53
                java.lang.Object r7 = r1.d()     // Catch: java.lang.Throwable -> L16
                C7.r r7 = (C7.r) r7     // Catch: java.lang.Throwable -> L16
                java.util.concurrent.atomic.AtomicBoolean r7 = androidx.compose.ui.platform.GlobalSnapshotManager.access$getSent$p()     // Catch: java.lang.Throwable -> L16
                r5 = 0
                r7.set(r5)     // Catch: java.lang.Throwable -> L16
                androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L16
                r7.sendApplyNotifications()     // Catch: java.lang.Throwable -> L16
                goto L2a
            L53:
                r4.cancel(r2)
                C7.r r6 = C7.r.f317a
                return r6
            L59:
                throw r6     // Catch: java.lang.Throwable -> L5a
            L5a:
                r7 = move-exception
                boolean r0 = r6 instanceof java.util.concurrent.CancellationException
                if (r0 == 0) goto L62
                r2 = r6
                java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
            L62:
                if (r2 != 0) goto L6e
                java.util.concurrent.CancellationException r2 = new java.util.concurrent.CancellationException
                java.lang.String r0 = "Channel was consumed, consumer had failed"
                r2.<init>(r0)
                r2.initCause(r6)
            L6e:
                r4.cancel(r2)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private GlobalSnapshotManager() {
    }

    public final void ensureStarted() {
        if (started.compareAndSet(false, true)) {
            final kotlinx.coroutines.channels.a aVarB = Z6.k.b(1, 6, null);
            AbstractC1683A.n(AbstractC1683A.b(AndroidUiDispatcher.INSTANCE.getMain()), null, new AnonymousClass1(aVarB, null), 3);
            Snapshot.INSTANCE.registerGlobalWriteObserver(new S7.k() { // from class: androidx.compose.ui.platform.GlobalSnapshotManager.ensureStarted.2
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m6015invoke(obj);
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m6015invoke(Object obj) {
                    if (GlobalSnapshotManager.sent.compareAndSet(false, true)) {
                        aVarB.a(r.f317a);
                    }
                }
            });
        }
    }
}
