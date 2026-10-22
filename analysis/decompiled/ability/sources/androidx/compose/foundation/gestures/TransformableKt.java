package androidx.compose.foundation.gestures;

import J7.c;
import S7.k;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001aC\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u000b\u001a>\u0010\u0012\u001a\u00020\u0011*\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/gestures/TransformableState;", "state", "", "lockRotationOnZoomPan", "enabled", "transformable", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/TransformableState;ZZ)Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "canPan", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/TransformableState;LS7/k;ZZ)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "Lo9/e;", "Landroidx/compose/foundation/gestures/TransformEvent;", "channel", "LC7/r;", "detectZoom", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLo9/e;LS7/k;LH7/c;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformableKt {

    @c(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", l = {216, 218, 262}, m = "detectZoom")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, false, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02b0, code lost:
    
        if (r6 != 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02b2, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02b7 A[EDGE_INSN: B:103:0x02b7->B:92:0x02b7 BREAK  A[LOOP:0: B:86:0x02a2->B:91:0x02b4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0286 -> B:85:0x0295). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r30, boolean r31, o9.InterfaceC1779e r32, S7.k r33, H7.c<? super C7.r> r34) {
        /*
            Method dump skipped, instructions count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, o9.e, S7.k, H7.c):java.lang.Object");
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z10, boolean z11) {
        return transformable(modifier, transformableState, new k() { // from class: androidx.compose.foundation.gestures.TransformableKt.transformable.1
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m530invokek4lQ0M(((Offset) obj).m3905unboximpl());
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final Boolean m530invokek4lQ0M(long j5) {
                return Boolean.TRUE;
            }
        }, z10, z11);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z10, boolean z11, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        if ((i & 4) != 0) {
            z11 = true;
        }
        return transformable(modifier, transformableState, z10, z11);
    }

    @ExperimentalFoundationApi
    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, k kVar, boolean z10, boolean z11) {
        return modifier.then(new TransformableElement(transformableState, kVar, z10, z11));
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, k kVar, boolean z10, boolean z11, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = false;
        }
        if ((i & 8) != 0) {
            z11 = true;
        }
        return transformable(modifier, transformableState, kVar, z10, z11);
    }
}
