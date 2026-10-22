package androidx.compose.runtime;

import C7.r;
import S7.n;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.m;
import p9.t;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aA\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\b\b\u0000\u0010\u0000*\u00028\u0001\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00028\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\n\u001a'\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u0016\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lp9/t;", "LH7/h;", "context", "Landroidx/compose/runtime/State;", "collectAsState", "(Lp9/t;LH7/h;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "R", "Lp9/c;", "initial", "(Lp9/c;Ljava/lang/Object;LH7/h;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "block", "snapshotFlow", "(LS7/a;)Lp9/c;", "Landroidx/collection/MutableScatterSet;", "", "", "set", "", "intersects$SnapshotStateKt__SnapshotFlowKt", "(Landroidx/collection/MutableScatterSet;Ljava/util/Set;)Z", "intersects", "runtime"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {

    @J7.c(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", l = {143, 147, 170}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lp9/d;", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ S7.a $block;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(S7.a aVar, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$block = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r invokeSuspend$lambda$0(MutableScatterSet mutableScatterSet, Object obj) {
            if (obj instanceof StateObjectImpl) {
                ((StateObjectImpl) obj).m3611recordReadInh_f27i8$runtime(ReaderKind.m3598constructorimpl(4));
            }
            mutableScatterSet.add(obj);
            return r.f317a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final C7.r invokeSuspend$lambda$2(o9.InterfaceC1779e r16, java.util.Set r17, androidx.compose.runtime.snapshots.Snapshot r18) {
            /*
                r0 = r17
                boolean r1 = r0 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
                r2 = 4
                if (r1 == 0) goto L5f
                r1 = r0
                androidx.compose.runtime.collection.ScatterSetWrapper r1 = (androidx.compose.runtime.collection.ScatterSetWrapper) r1
                androidx.collection.ScatterSet r1 = r1.getSet$runtime()
                java.lang.Object[] r3 = r1.elements
                long[] r1 = r1.metadata
                int r4 = r1.length
                int r4 = r4 + (-2)
                if (r4 < 0) goto L91
                r5 = 0
                r6 = r5
            L19:
                r7 = r1[r6]
                long r9 = ~r7
                r11 = 7
                long r9 = r9 << r11
                long r9 = r9 & r7
                r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r9 = r9 & r11
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r9 == 0) goto L5a
                int r9 = r6 - r4
                int r9 = ~r9
                int r9 = r9 >>> 31
                r10 = 8
                int r9 = 8 - r9
                r11 = r5
            L33:
                if (r11 >= r9) goto L58
                r12 = 255(0xff, double:1.26E-321)
                long r12 = r12 & r7
                r14 = 128(0x80, double:6.3E-322)
                int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r12 >= 0) goto L54
                int r12 = r6 << 3
                int r12 = r12 + r11
                r12 = r3[r12]
                boolean r13 = r12 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r13 == 0) goto L8e
                androidx.compose.runtime.snapshots.StateObjectImpl r12 = (androidx.compose.runtime.snapshots.StateObjectImpl) r12
                int r13 = androidx.compose.runtime.snapshots.ReaderKind.m3598constructorimpl(r2)
                boolean r12 = r12.m3610isReadInh_f27i8$runtime(r13)
                if (r12 == 0) goto L54
                goto L8e
            L54:
                long r7 = r7 >> r10
                int r11 = r11 + 1
                goto L33
            L58:
                if (r9 != r10) goto L91
            L5a:
                if (r6 == r4) goto L91
                int r6 = r6 + 1
                goto L19
            L5f:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                boolean r3 = r1 instanceof java.util.Collection
                if (r3 == 0) goto L70
                r3 = r1
                java.util.Collection r3 = (java.util.Collection) r3
                boolean r3 = r3.isEmpty()
                if (r3 == 0) goto L70
                goto L91
            L70:
                java.util.Iterator r1 = r1.iterator()
            L74:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L91
                java.lang.Object r3 = r1.next()
                boolean r4 = r3 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r4 == 0) goto L8e
                androidx.compose.runtime.snapshots.StateObjectImpl r3 = (androidx.compose.runtime.snapshots.StateObjectImpl) r3
                int r4 = androidx.compose.runtime.snapshots.ReaderKind.m3598constructorimpl(r2)
                boolean r3 = r3.m3610isReadInh_f27i8$runtime(r4)
                if (r3 == 0) goto L74
            L8e:
                r16.a(r17)
            L91:
                C7.r r0 = C7.r.f317a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend$lambda$2(o9.e, java.util.Set, androidx.compose.runtime.snapshots.Snapshot):C7.r");
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Path cross not found for [B:34:0x00e2, B:38:0x00eb], limit reached: 75 */
        /* JADX WARN: Path cross not found for [B:42:0x00fa, B:58:0x0139], limit reached: 75 */
        /* JADX WARN: Path cross not found for [B:58:0x0139, B:42:0x00fa], limit reached: 75 */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00fa A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #3 {all -> 0x0053, blocks: (B:32:0x00de, B:34:0x00e2, B:39:0x00ec, B:42:0x00fa, B:46:0x0110, B:48:0x0119, B:56:0x0135, B:57:0x0138, B:15:0x004e, B:43:0x0105, B:45:0x010d, B:54:0x0131, B:55:0x0134), top: B:74:0x004e, inners: #5 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 335
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(p9.d dVar, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(dVar, cVar)).invokeSuspend(r.f317a);
        }
    }

    @Composable
    public static final <T> State<T> collectAsState(t tVar, H7.h hVar, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        H7.h hVar2 = hVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:49)");
        }
        State<T> stateCollectAsState = SnapshotStateKt.collectAsState(tVar, tVar.getValue(), hVar2, composer, (i & 14) | ((i << 3) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateCollectAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean intersects$SnapshotStateKt__SnapshotFlowKt(androidx.collection.MutableScatterSet<java.lang.Object> r13, java.util.Set<? extends java.lang.Object> r14) {
        /*
            java.lang.Object[] r0 = r13.elements
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L48
            r3 = r2
        Lb:
            r4 = r13[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L43
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L25:
            if (r8 >= r6) goto L41
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L3d
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            boolean r9 = r14.contains(r9)
            if (r9 == 0) goto L3d
            r13 = 1
            return r13
        L3d:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L25
        L41:
            if (r6 != r7) goto L48
        L43:
            if (r3 == r1) goto L48
            int r3 = r3 + 1
            goto Lb
        L48:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(androidx.collection.MutableScatterSet, java.util.Set):boolean");
    }

    public static final <T> p9.c snapshotFlow(S7.a aVar) {
        return new m(new AnonymousClass1(aVar, null));
    }

    @Composable
    public static final <T extends R, R> State<R> collectAsState(p9.c cVar, R r5, H7.h hVar, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        H7.h hVar2 = hVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606625098, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:65)");
        }
        boolean zChangedInstance = composer.changedInstance(hVar2) | composer.changedInstance(cVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1(hVar2, cVar, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        State<R> stateProduceState = SnapshotStateKt.produceState(r5, cVar, hVar2, (n) objRememberedValue, composer, ((i >> 3) & 14) | ((i << 3) & 112) | (i & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateProduceState;
    }
}
