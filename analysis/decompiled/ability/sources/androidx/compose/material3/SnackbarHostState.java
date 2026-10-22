package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import m9.InterfaceC1717j;
import w9.InterfaceC2108a;

@Stable
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R/\u0010\u001c\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/SnackbarHostState;", "", AppAgent.CONSTRUCT, "()V", "", "message", "actionLabel", "", "withDismissAction", "Landroidx/compose/material3/SnackbarDuration;", TypedValues.TransitionType.S_DURATION, "Landroidx/compose/material3/SnackbarResult;", "showSnackbar", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/material3/SnackbarVisuals;", "visuals", "(Landroidx/compose/material3/SnackbarVisuals;LH7/c;)Ljava/lang/Object;", "Lw9/a;", "mutex", "Lw9/a;", "Landroidx/compose/material3/SnackbarData;", "<set-?>", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData", "SnackbarDataImpl", "SnackbarVisualsImpl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final InterfaceC2108a mutex = new kotlinx.coroutines.sync.a();

    /* renamed from: currentSnackbarData$delegate, reason: from kotlin metadata */
    private final MutableState currentSnackbarData = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "Landroidx/compose/material3/SnackbarVisuals;", "visuals", "Lm9/j;", "Landroidx/compose/material3/SnackbarResult;", "continuation", AppAgent.CONSTRUCT, "(Landroidx/compose/material3/SnackbarVisuals;Lm9/j;)V", "LC7/r;", "performAction", "()V", "dismiss", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroidx/compose/material3/SnackbarVisuals;", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "Lm9/j;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SnackbarDataImpl implements SnackbarData {
        private final InterfaceC1717j continuation;
        private final SnackbarVisuals visuals;

        public SnackbarDataImpl(SnackbarVisuals snackbarVisuals, InterfaceC1717j interfaceC1717j) {
            this.visuals = snackbarVisuals;
            this.continuation = interfaceC1717j;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive()) {
                this.continuation.resumeWith(SnackbarResult.Dismissed);
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || SnackbarDataImpl.class != other.getClass()) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) other;
            return k.b(getVisuals(), snackbarDataImpl.getVisuals()) && k.b(this.continuation, snackbarDataImpl.continuation);
        }

        @Override // androidx.compose.material3.SnackbarData
        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        public int hashCode() {
            return this.continuation.hashCode() + (getVisuals().hashCode() * 31);
        }

        @Override // androidx.compose.material3.SnackbarData
        public void performAction() {
            if (this.continuation.isActive()) {
                this.continuation.resumeWith(SnackbarResult.ActionPerformed);
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", TypedValues.TransitionType.S_DURATION, "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "getMessage", "getWithDismissAction", "()Z", "equals", "other", "", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SnackbarVisualsImpl implements SnackbarVisuals {
        private final String actionLabel;
        private final SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;

        public SnackbarVisualsImpl(String str, String str2, boolean z10, SnackbarDuration snackbarDuration) {
            this.message = str;
            this.actionLabel = str2;
            this.withDismissAction = z10;
            this.duration = snackbarDuration;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || SnackbarVisualsImpl.class != other.getClass()) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) other;
            return k.b(getMessage(), snackbarVisualsImpl.getMessage()) && k.b(getActionLabel(), snackbarVisualsImpl.getActionLabel()) && getWithDismissAction() == snackbarVisualsImpl.getWithDismissAction() && getDuration() == snackbarVisualsImpl.getDuration();
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

        public int hashCode() {
            int iHashCode = getMessage().hashCode() * 31;
            String actionLabel = getActionLabel();
            return getDuration().hashCode() + androidx.appfunctions.metadata.a.d((iHashCode + (actionLabel != null ? actionLabel.hashCode() : 0)) * 31, 31, getWithDismissAction());
        }
    }

    @J7.c(c = "androidx.compose.material3.SnackbarHostState", f = "SnackbarHost.kt", l = {446, 449}, m = "showSnackbar")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.SnackbarHostState$showSnackbar$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnackbarHostState.this.showSnackbar(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData.setValue(snackbarData);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, boolean z10, SnackbarDuration snackbarDuration, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i & 8) != 0) {
            snackbarDuration = str3 == null ? SnackbarDuration.Short : SnackbarDuration.Indefinite;
        }
        return snackbarHostState.showSnackbar(str, str3, z11, snackbarDuration, cVar);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData.getValue();
    }

    public final Object showSnackbar(String str, String str2, boolean z10, SnackbarDuration snackbarDuration, H7.c<? super SnackbarResult> cVar) {
        return showSnackbar(new SnackbarVisualsImpl(str, str2, z10, snackbarDuration), cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object showSnackbar(androidx.compose.material3.SnackbarVisuals r8, H7.c<? super androidx.compose.material3.SnackbarResult> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.material3.SnackbarHostState.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r0 = (androidx.compose.material3.SnackbarHostState.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r0 = new androidx.compose.material3.SnackbarHostState$showSnackbar$2
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r7 = r0.L$3
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r7 = (androidx.compose.material3.SnackbarHostState.AnonymousClass2) r7
            java.lang.Object r7 = r0.L$2
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r8 = r0.L$1
            androidx.compose.material3.SnackbarVisuals r8 = (androidx.compose.material3.SnackbarVisuals) r8
            java.lang.Object r8 = r0.L$0
            androidx.compose.material3.SnackbarHostState r8 = (androidx.compose.material3.SnackbarHostState) r8
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L3b
            goto L95
        L3b:
            r9 = move-exception
            goto La3
        L3e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L46:
            java.lang.Object r7 = r0.L$2
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r8 = r0.L$1
            androidx.compose.material3.SnackbarVisuals r8 = (androidx.compose.material3.SnackbarVisuals) r8
            java.lang.Object r2 = r0.L$0
            androidx.compose.material3.SnackbarHostState r2 = (androidx.compose.material3.SnackbarHostState) r2
            kotlin.b.b(r9)
            r9 = r7
            r7 = r2
            goto L6c
        L58:
            kotlin.b.b(r9)
            w9.a r9 = r7.mutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.label = r4
            java.lang.Object r2 = r9.lock(r5, r0)
            if (r2 != r1) goto L6c
            goto L90
        L6c:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L9e
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L9e
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L9e
            r0.L$3 = r0     // Catch: java.lang.Throwable -> L9e
            r0.label = r3     // Catch: java.lang.Throwable -> L9e
            m9.k r2 = new m9.k     // Catch: java.lang.Throwable -> L9e
            H7.c r0 = U7.a.I(r0)     // Catch: java.lang.Throwable -> L9e
            r2.<init>(r4, r0)     // Catch: java.lang.Throwable -> L9e
            r2.y()     // Catch: java.lang.Throwable -> L9e
            androidx.compose.material3.SnackbarHostState$SnackbarDataImpl r0 = new androidx.compose.material3.SnackbarHostState$SnackbarDataImpl     // Catch: java.lang.Throwable -> L9e
            r0.<init>(r8, r2)     // Catch: java.lang.Throwable -> L9e
            access$setCurrentSnackbarData(r7, r0)     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r8 = r2.x()     // Catch: java.lang.Throwable -> L9e
            if (r8 != r1) goto L91
        L90:
            return r1
        L91:
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L95:
            r8.setCurrentSnackbarData(r5)     // Catch: java.lang.Throwable -> L9c
            r7.unlock(r5)
            return r9
        L9c:
            r8 = move-exception
            goto La7
        L9e:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        La3:
            r8.setCurrentSnackbarData(r5)     // Catch: java.lang.Throwable -> L9c
            throw r9     // Catch: java.lang.Throwable -> L9c
        La7:
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostState.showSnackbar(androidx.compose.material3.SnackbarVisuals, H7.c):java.lang.Object");
    }
}
