package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/SnackbarHostState;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "<set-?>", "Landroidx/compose/material/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "showSnackbar", "Landroidx/compose/material/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final MutableState currentSnackbarData$delegate;
    private final kotlinx.coroutines.sync.a mutex;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material/SnackbarData;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material/SnackbarResult;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlinx/coroutines/CancellableContinuation;)V", "getMessage", "()Ljava/lang/String;", "getActionLabel", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "performAction", "", "dismiss", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SnackbarDataImpl implements SnackbarData {
        private final String actionLabel;
        private final kotlinx.coroutines.i<SnackbarResult> continuation;
        private final SnackbarDuration duration;
        private final String message;

        @Override // androidx.compose.material.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive() == false) goto L6;
            kotlinx.coroutines.i<SnackbarResult> r100 = this.continuation;
            Result.Companion r101 = Result.Companion;
            r100.resumeWith(Result.m9449constructorimpl(SnackbarResult.Dismissed));
            return;
        }

        @Override // androidx.compose.material.SnackbarData
        public void performAction() {
            if (this.continuation.isActive() == false) goto L6;
            kotlinx.coroutines.i<SnackbarResult> r100 = this.continuation;
            Result.Companion r101 = Result.Companion;
            r100.resumeWith(Result.m9449constructorimpl(SnackbarResult.ActionPerformed));
            return;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material.SnackbarData
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SnackbarDataImpl(String r100, String r101, SnackbarDuration r102, kotlinx.coroutines.i<? super SnackbarResult> r103) {
            this.message = r100;
            this.actionLabel = r101;
            this.duration = r102;
            this.continuation = r103;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostState$showSnackbar$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SnackbarHostState", f = "SnackbarHost.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME, 370}, m = "showSnackbar", n = {"message", "actionLabel", "duration", "$this$withLock_u24default$iv", "message", "actionLabel", "duration", "$this$withLock_u24default$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SnackbarHostState this$0;

        public AnonymousClass1(SnackbarHostState r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.showSnackbar(null, null, null, this);
        }
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    public SnackbarHostState() {
        this.mutex = kotlinx.coroutines.sync.b.a();
        this.currentSnackbarData$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private final void setCurrentSnackbarData(SnackbarData r100) {
        this.currentSnackbarData$delegate.setValue(r100);
    }

    public static final /* synthetic */ void access$setCurrentSnackbarData(SnackbarHostState r100, SnackbarData r101) {
        r100.setCurrentSnackbarData(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object showSnackbar(String r100, String r101, SnackbarDuration r110, Continuation<? super SnackbarResult> r111) {
        if ((r111 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        AnonymousClass1 r106 = (AnonymousClass1) r102.L$4;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$3;
        SnackbarDuration r108 = (SnackbarDuration) r102.L$2;
        String r109 = (String) r102.L$1;
        String r113 = (String) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L15
    L29:
        setCurrentSnackbarData(null);     // Catch: Throwable -> L36
        r107.unlock(null);
        return r112;
    L15:
        th = th;
    L34:
        setCurrentSnackbarData(null);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r102.L$3;
        r110 = (SnackbarDuration) r102.L$2;
        r101 = (String) r102.L$1;
        String r115 = (String) r102.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r116 = r114;
        String r117 = r115;
    L41:
        r102.L$0 = r117;     // Catch: Throwable -> L32
        r102.L$1 = r101;     // Catch: Throwable -> L32
        r102.L$2 = r110;     // Catch: Throwable -> L32
        r102.L$3 = r116;     // Catch: Throwable -> L32
        r102.L$4 = r102;     // Catch: Throwable -> L32
        r102.label = 2;     // Catch: Throwable -> L32
        kotlinx.coroutines.j r118 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);     // Catch: Throwable -> L32
        r118.C();     // Catch: Throwable -> L32
        access$setCurrentSnackbarData(this, new SnackbarDataImpl(r117, r101, r110, r118));     // Catch: Throwable -> L32
        Object r119 = r118.B();     // Catch: Throwable -> L32
        if (r119 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r102);     // Catch: Throwable -> L32
    L26:
        if (r119 != r104) goto L28;
        return r104;
    L28:
        kotlinx.coroutines.sync.a r120 = r116;
        r112 = r119;
        r107 = r120;
    L32:
        th = th;
        goto L34
    L20:
        ResultKt.throwOnFailure(r112);
        r116 = this.mutex;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r110;
        r102.L$3 = r116;
        r102.label = 1;
        r117 = r100;
        if (r116.a(null, r102) != r104) goto L41;
        return r104;
    L36:
        th = move-exception;
        r100.unlock(null);
        throw th;
    L7:
        r102 = new AnonymousClass1(this, r111);
        goto L8
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState r100, String r101, String r102, SnackbarDuration r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = SnackbarDuration.Short;
    L9:
        return r100.showSnackbar(r101, r102, r103, r104);
    }
}
