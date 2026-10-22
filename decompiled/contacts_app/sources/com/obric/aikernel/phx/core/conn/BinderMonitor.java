package com.obric.aikernel.phx.core.conn;

import android.os.IBinder;
import com.obric.aikernel.AIKBinder;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: BinderMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/BinderMonitor;", "", "()V", "TAG", "", "binderWatcher", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/aikernel/phx/core/conn/BinderMonitor$BinderInfo;", "monitorTransact", "Lkotlinx/coroutines/Job;", "ctx", "Lkotlin/coroutines/CoroutineContext;", "binder", "Lcom/obric/aikernel/AIKBinder;", "onDied", "Lkotlin/Function0;", "", "BinderInfo", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BinderMonitor {
    public static final BinderMonitor INSTANCE = null;
    private static final String TAG = "BinderMonitor";
    private static final ConcurrentHashMap<Integer, BinderInfo> binderWatcher = null;

    /* JADX INFO: compiled from: BinderMonitor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/phx/core/conn/BinderMonitor$BinderInfo;", "", "binder", "Landroid/os/IBinder;", "stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "recipient", "Landroid/os/IBinder$DeathRecipient;", "(Landroid/os/IBinder;Lkotlinx/coroutines/flow/MutableStateFlow;Landroid/os/IBinder$DeathRecipient;)V", "getBinder", "()Landroid/os/IBinder;", "getRecipient", "()Landroid/os/IBinder$DeathRecipient;", "getStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BinderInfo {
        private final IBinder binder;
        private final IBinder.DeathRecipient recipient;
        private final MutableStateFlow<Boolean> stateFlow;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BinderInfo copy$default(BinderInfo r0, IBinder r1, MutableStateFlow r2, IBinder.DeathRecipient r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.binder;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.stateFlow;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.recipient;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final IBinder component1() {
            return this.binder;
        }

        public final MutableStateFlow<Boolean> component2() {
            return this.stateFlow;
        }

        public final IBinder.DeathRecipient component3() {
            return this.recipient;
        }

        public final BinderInfo copy(IBinder r1, MutableStateFlow<Boolean> r2, IBinder.DeathRecipient r3) {
            Intrinsics.checkNotNullParameter(r1, "binder");
            Intrinsics.checkNotNullParameter(r2, "stateFlow");
            Intrinsics.checkNotNullParameter(r3, "recipient");
            return new BinderInfo(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof BinderInfo) == true) goto L8;
            return false;
        L8:
            BinderInfo r6 = (BinderInfo) r5;
            if (Intrinsics.areEqual(this.binder, r6.binder) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.stateFlow, r6.stateFlow) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.recipient, r6.recipient) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.binder.hashCode() * 31) + this.stateFlow.hashCode()) * 31) + this.recipient.hashCode();
        }

        public String toString() {
            return "BinderInfo(binder=" + this.binder + ", stateFlow=" + this.stateFlow + ", recipient=" + this.recipient + ')';
        }

        public BinderInfo(IBinder r2, MutableStateFlow<Boolean> r3, IBinder.DeathRecipient r4) {
            Intrinsics.checkNotNullParameter(r2, "binder");
            Intrinsics.checkNotNullParameter(r3, "stateFlow");
            Intrinsics.checkNotNullParameter(r4, "recipient");
            this.binder = r2;
            this.stateFlow = r3;
            this.recipient = r4;
        }

        public final IBinder getBinder() {
            return this.binder;
        }

        public /* synthetic */ BinderInfo(final IBinder r1, final MutableStateFlow r2, IBinder.DeathRecipient r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = StateFlowKt.MutableStateFlow(true);
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = new AnonymousClass1(r1, r2);
        L8:
            this(r1, r2, r3);
        }

        public final MutableStateFlow<Boolean> getStateFlow() {
            return this.stateFlow;
        }

        public final IBinder.DeathRecipient getRecipient() {
            return this.recipient;
        }
    }

    private BinderMonitor() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBinderWatcher$p() {
        return binderWatcher;
    }

    static {
        INSTANCE = new BinderMonitor();
        binderWatcher = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, com.obric.aikernel.phx.core.conn.BinderMonitor$BinderInfo, java.lang.Object] */
    public final Job monitorTransact(CoroutineContext r11, AIKBinder r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "ctx");
        Intrinsics.checkNotNullParameter(r12, "binder");
        Intrinsics.checkNotNullParameter(r13, "onDied");
        IBinder r14 = r12.asBinder();
        int r0 = r14.hashCode();
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        ConcurrentHashMap<Integer, BinderInfo> r8 = binderWatcher;
        r7.element = r8.get(Integer.valueOf(r0));
        if (r7.element != 0) goto L17;
        monitor-enter(this);
        r7.element = r8.get(Integer.valueOf(r0));     // Catch: Throwable -> L13
        if (r14.isBinderAlive() == true) goto L8;
    L10:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        goto L17
    L8:
        if (r7.element != 0) goto L10;
        Intrinsics.checkNotNullExpressionValue(r14, "bd");     // Catch: Throwable -> L13
        ?? r9 = new BinderInfo(r14, null, null, 6, null);     // Catch: Throwable -> L13
        ConcurrentHashMap<Integer, BinderInfo> r10 = r8;     // Catch: Throwable -> L13
        r10.put(Integer.valueOf(r0), r9);     // Catch: Throwable -> L13
        r14.linkToDeath(r9.getRecipient(), 0);     // Catch: Throwable -> L13
        r7.element = r9;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r11), null, null, new BinderMonitor$monitorTransact$job$1(r7, r11, r13, null), 3, null);
    }
}
