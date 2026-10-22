package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.ss.bduploader.BDAbstractUpload;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/SnackbarHostState;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "<set-?>", "Landroidx/compose/material3/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "showSnackbar", "Landroidx/compose/material3/SnackbarResult;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarVisualsImpl", "SnackbarDataImpl", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final MutableState currentSnackbarData$delegate;
    private final kotlinx.coroutines.sync.a mutex;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material3/SnackbarResult;", "<init>", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlinx/coroutines/CancellableContinuation;)V", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "performAction", "", "dismiss", "equals", "", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SnackbarDataImpl implements SnackbarData {
        private final kotlinx.coroutines.i<SnackbarResult> continuation;
        private final SnackbarVisuals visuals;

        @Override // androidx.compose.material3.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive() == false) goto L6;
            kotlinx.coroutines.i<SnackbarResult> r100 = this.continuation;
            Result.Companion r101 = Result.Companion;
            r100.resumeWith(Result.m9449constructorimpl(SnackbarResult.Dismissed));
            return;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void performAction() {
            if (this.continuation.isActive() == false) goto L6;
            kotlinx.coroutines.i<SnackbarResult> r100 = this.continuation;
            Result.Companion r101 = Result.Companion;
            r100.resumeWith(Result.m9449constructorimpl(SnackbarResult.ActionPerformed));
            return;
        }

        public int hashCode() {
            return (getVisuals().hashCode() * 31) + this.continuation.hashCode();
        }

        @Override // androidx.compose.material3.SnackbarData
        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (SnackbarDataImpl.class != r100.getClass()) goto L17;
            SnackbarDataImpl r101 = (SnackbarDataImpl) r100;
            if (Intrinsics.areEqual(getVisuals(), r101.getVisuals()) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.continuation, r101.continuation) == true) goto L16;
            return false;
        L16:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SnackbarDataImpl(SnackbarVisuals r100, kotlinx.coroutines.i<? super SnackbarResult> r101) {
            this.visuals = r100;
            this.continuation = r101;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getMessage", "()Ljava/lang/String;", "getActionLabel", "getWithDismissAction", "()Z", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "equals", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SnackbarVisualsImpl implements SnackbarVisuals {
        private final String actionLabel;
        private final SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;

        public int hashCode() {
            int r100 = getMessage().hashCode() * 31;
            String r101 = getActionLabel();
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L6:
            int r103 = (r100 + r102) * 31;
            if (getWithDismissAction() == false) goto L9;
            int r104 = 1231;
        L11:
            return ((r103 + r104) * 31) + getDuration().hashCode();
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = 0;
            goto L6
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L23:
            return false;
        L8:
            if (SnackbarVisualsImpl.class != r100.getClass()) goto L23;
            SnackbarVisualsImpl r101 = (SnackbarVisualsImpl) r100;
            if (Intrinsics.areEqual(getMessage(), r101.getMessage()) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(getActionLabel(), r101.getActionLabel()) == true) goto L17;
            return false;
        L17:
            if (getWithDismissAction() == r101.getWithDismissAction()) goto L20;
            return false;
        L20:
            if (getDuration() == r101.getDuration()) goto L22;
            return false;
        L22:
            return true;
        }

        public SnackbarVisualsImpl(String r100, String r101, boolean r102, SnackbarDuration r103) {
            this.message = r100;
            this.actionLabel = r101;
            this.withDismissAction = r102;
            this.duration = r103;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnackbarHostState$showSnackbar$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SnackbarHostState", f = "SnackbarHost.kt", i = {0, 0, 1, 1, 1}, l = {BDAbstractUpload.KeyIsSDKMaxRetryTimeout, 431}, m = "showSnackbar", n = {"visuals", "$this$withLock_u24default$iv", "visuals", "$this$withLock_u24default$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SnackbarHostState this$0;

        public AnonymousClass2(SnackbarHostState r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.showSnackbar(null, this);
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
    public final Object showSnackbar(SnackbarVisuals r100, Continuation<? super SnackbarResult> r101) {
        if ((r101 instanceof AnonymousClass2) == false) goto L7;
        AnonymousClass2 r102 = (AnonymousClass2) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        AnonymousClass2 r107 = (AnonymousClass2) r102.L$2;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r102.L$1;
        SnackbarVisuals r109 = (SnackbarVisuals) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
    L29:
        setCurrentSnackbarData(null);     // Catch: Throwable -> L36
        r108.unlock(null);
        return r104;
    L15:
        Throwable th10 = th;
    L34:
        setCurrentSnackbarData(null);     // Catch: Throwable -> L36
        throw th10;     // Catch: Throwable -> L36
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r110 = (kotlinx.coroutines.sync.a) r102.L$1;
        SnackbarVisuals r111 = (SnackbarVisuals) r102.L$0;
        ResultKt.throwOnFailure(r104);
        kotlinx.coroutines.sync.a r112 = r110;
        SnackbarVisuals r113 = r111;
    L40:
        r102.L$0 = r113;     // Catch: Throwable -> L32
        r102.L$1 = r112;     // Catch: Throwable -> L32
        r102.L$2 = r102;     // Catch: Throwable -> L32
        r102.label = 2;     // Catch: Throwable -> L32
        kotlinx.coroutines.j r114 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);     // Catch: Throwable -> L32
        r114.C();     // Catch: Throwable -> L32
        access$setCurrentSnackbarData(this, new SnackbarDataImpl(r113, r114));     // Catch: Throwable -> L32
        Object r115 = r114.B();     // Catch: Throwable -> L32
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r102);     // Catch: Throwable -> L32
    L26:
        if (r115 != r105) goto L28;
        return r105;
    L28:
        kotlinx.coroutines.sync.a r116 = r112;
        r104 = r115;
        r108 = r116;
    L32:
        th = move-exception;
        th10 = th;
        goto L34
    L20:
        ResultKt.throwOnFailure(r104);
        r112 = this.mutex;
        r102.L$0 = r100;
        r102.L$1 = r112;
        r102.label = 1;
        r113 = r100;
        if (r112.a(null, r102) != r105) goto L40;
        return r105;
    L36:
        th = move-exception;
        r100.unlock(null);
        throw th;
    L7:
        r102 = new AnonymousClass2(this, r101);
        goto L8
    }

    public final Object showSnackbar(String r100, String r101, boolean r102, SnackbarDuration r103, Continuation<? super SnackbarResult> r104) {
        return showSnackbar(new SnackbarVisualsImpl(r100, r101, r102, r103), r104);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState r100, String r101, String r102, boolean r103, SnackbarDuration r110, Continuation r111, int r112, Object r113) {
        if ((r112 & 2) == 0) goto L5;
        r102 = null;
    L5:
        String r104 = r102;
        if ((r112 & 4) == 0) goto L8;
        boolean r105 = false;
    L10:
        if ((r112 & 8) == 0) goto L16;
        if (r104 != null) goto L13;
        SnackbarDuration r106 = SnackbarDuration.Short;
    L14:
        r110 = r106;
        goto L16
    L13:
        r106 = SnackbarDuration.Indefinite;
    L16:
        return r100.showSnackbar(r101, r104, r105, r110, r111);
    L8:
        r105 = r103;
        goto L10
    }
}
