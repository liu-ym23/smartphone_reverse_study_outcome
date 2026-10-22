package androidx.compose.runtime;

import S7.n;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b.\b\u0001\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001qB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J)\u0010\u0018\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u0012J\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b \u0010!J#\u0010#\u001a\u00020\t2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\"2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b&\u0010!J\r\u0010'\u001a\u00020\t¢\u0006\u0004\b'\u0010\u0012J#\u0010*\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\t\u0018\u00010(2\u0006\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b*\u0010+J1\u0010.\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\"2\u0018\u0010-\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"\u0012\u0006\u0012\u0004\u0018\u00010\f0,H\u0002¢\u0006\u0004\b.\u0010/J\u0018\u00101\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0016H\u0082\b¢\u0006\u0004\b1\u00102J \u00103\u001a\u00020\t2\u0006\u00100\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u001fH\u0082\b¢\u0006\u0004\b3\u00104R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u0010\u0006R\u0016\u00109\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010BR\u0016\u0010C\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010:R\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR*\u0010G\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0011\u0010K\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0011\u0010M\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bL\u0010JR$\u0010Q\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010J\"\u0004\bO\u0010PR$\u0010T\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010J\"\u0004\bS\u0010PR$\u0010W\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010J\"\u0004\bV\u0010PR$\u0010Z\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010J\"\u0004\bY\u0010PR$\u0010]\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010J\"\u0004\b\\\u0010PR$\u0010`\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010J\"\u0004\b_\u0010PR$\u0010c\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010J\"\u0004\bb\u0010PR$\u0010f\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010J\"\u0004\be\u0010PR$\u0010i\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010J\"\u0004\bh\u0010PR$\u0010l\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8@@BX\u0080\u000e¢\u0006\f\u001a\u0004\bj\u0010J\"\u0004\bk\u0010PR\u0011\u0010m\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bm\u0010JR$\u0010p\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bn\u0010J\"\u0004\bo\u0010P¨\u0006r"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "owner", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "Landroidx/compose/runtime/Composer;", "composer", "LC7/r;", "compose", "(Landroidx/compose/runtime/Composer;)V", "", "value", "Landroidx/compose/runtime/InvalidationResult;", "invalidateForResult", "(Ljava/lang/Object;)Landroidx/compose/runtime/InvalidationResult;", "release", "()V", "adoptedBy", "invalidate", "Lkotlin/Function2;", "", "block", "updateScope", "(LS7/n;)V", "token", "start", "(I)V", "scopeSkipped", "instance", "", "recordRead", "(Ljava/lang/Object;)Z", "Landroidx/compose/runtime/DerivedState;", "recordDerivedStateValue", "(Landroidx/compose/runtime/DerivedState;Ljava/lang/Object;)V", "instances", "isInvalidFor", "rereadTrackedInstances", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "end", "(I)LS7/k;", "Landroidx/collection/MutableScatterMap;", "dependencies", "checkDerivedStateChanged", "(Landroidx/compose/runtime/DerivedState;Landroidx/collection/MutableScatterMap;)Z", "flag", "getFlag", "(I)Z", "setFlag", "(IZ)V", "Landroidx/compose/runtime/RecomposeScopeOwner;", "getOwner$runtime", "()Landroidx/compose/runtime/RecomposeScopeOwner;", "setOwner$runtime", "flags", "I", "Landroidx/compose/runtime/Anchor;", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "LS7/n;", "currentToken", "Landroidx/collection/MutableObjectIntMap;", "trackedInstances", "Landroidx/collection/MutableObjectIntMap;", "trackedDependencies", "Landroidx/collection/MutableScatterMap;", "getValid", "()Z", "valid", "getCanRecompose", "canRecompose", "getUsed", "setUsed", "(Z)V", "used", "getReusing", "setReusing", "reusing", "getResetReusing", "setResetReusing", "resetReusing", "getPaused", "setPaused", "paused", "getResuming", "setResuming", "resuming", "getDefaultsInScope", "setDefaultsInScope", "defaultsInScope", "getDefaultsInvalid", "setDefaultsInvalid", "defaultsInvalid", "getRequiresRecompose", "setRequiresRecompose", "requiresRecompose", "getForcedRecompose", "setForcedRecompose", "forcedRecompose", "getSkipped$runtime", "setSkipped", "skipped", "isConditional", "getRereading", "setRereading", "rereading", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    private Anchor anchor;
    private n block;
    private int currentToken;
    private int flags;
    private RecomposeScopeOwner owner;
    private MutableScatterMap<DerivedState<?>, Object> trackedDependencies;
    private MutableObjectIntMap<Object> trackedInstances;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/SlotWriter;", "slots", "", "Landroidx/compose/runtime/Anchor;", "anchors", "Landroidx/compose/runtime/RecomposeScopeOwner;", "newOwner", "LC7/r;", "adoptAnchoredScopes$runtime", "(Landroidx/compose/runtime/SlotWriter;Ljava/util/List;Landroidx/compose/runtime/RecomposeScopeOwner;)V", "adoptAnchoredScopes", "Landroidx/compose/runtime/SlotTable;", "", "hasAnchoredRecomposeScopes$runtime", "(Landroidx/compose/runtime/SlotTable;Ljava/util/List;)Z", "hasAnchoredRecomposeScopes", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final void adoptAnchoredScopes$runtime(SlotWriter slots, List<Anchor> anchors, RecomposeScopeOwner newOwner) {
            List<Anchor> list = anchors;
            if (list.isEmpty()) {
                return;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object objSlot = slots.slot(anchors.get(i), 0);
                RecomposeScopeImpl recomposeScopeImpl = objSlot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) objSlot : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.adoptedBy(newOwner);
                }
            }
        }

        public final boolean hasAnchoredRecomposeScopes$runtime(SlotTable slots, List<Anchor> anchors) {
            List<Anchor> list = anchors;
            if (!list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Anchor anchor = anchors.get(i);
                    if (slots.ownsAnchor(anchor) && (slots.slot$runtime(slots.anchorIndex(anchor), 0) instanceof RecomposeScopeImpl)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    public RecomposeScopeImpl(RecomposeScopeOwner recomposeScopeOwner) {
        this.owner = recomposeScopeOwner;
    }

    private final boolean checkDerivedStateChanged(DerivedState<?> derivedState, MutableScatterMap<DerivedState<?>, Object> mutableScatterMap) {
        kotlin.jvm.internal.k.d(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
        if (policy == null) {
            policy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return !policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), mutableScatterMap.get(derivedState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final C7.r end$lambda$9$lambda$8(androidx.compose.runtime.RecomposeScopeImpl r18, int r19, androidx.collection.MutableObjectIntMap r20, androidx.compose.runtime.Composition r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            int r4 = r0.currentToken
            if (r4 != r1) goto L8a
            androidx.collection.MutableObjectIntMap<java.lang.Object> r4 = r0.trackedInstances
            boolean r4 = kotlin.jvm.internal.k.b(r2, r4)
            if (r4 == 0) goto L8a
            boolean r4 = r3 instanceof androidx.compose.runtime.CompositionImpl
            if (r4 == 0) goto L8a
            long[] r4 = r2.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L8a
            r7 = 0
        L20:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L85
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L3a:
            if (r12 >= r10) goto L82
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L79
            int r13 = r7 << 3
            int r13 = r13 + r12
            java.lang.Object[] r14 = r2.keys
            r14 = r14[r13]
            int[] r15 = r2.values
            r15 = r15[r13]
            if (r15 == r1) goto L54
            r15 = 1
            goto L55
        L54:
            r15 = 0
        L55:
            if (r15 == 0) goto L71
            r6 = r3
            androidx.compose.runtime.CompositionImpl r6 = (androidx.compose.runtime.CompositionImpl) r6
            r6.removeObservation$runtime(r14, r0)
            r17 = r11
            boolean r11 = r14 instanceof androidx.compose.runtime.DerivedState
            if (r11 == 0) goto L73
            r11 = r14
            androidx.compose.runtime.DerivedState r11 = (androidx.compose.runtime.DerivedState) r11
            r6.removeDerivedStateObservation$runtime(r11)
            androidx.collection.MutableScatterMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r6 = r0.trackedDependencies
            if (r6 == 0) goto L73
            r6.remove(r14)
            goto L73
        L71:
            r17 = r11
        L73:
            if (r15 == 0) goto L7b
            r2.removeValueAt(r13)
            goto L7b
        L79:
            r17 = r11
        L7b:
            long r8 = r8 >> r17
            int r12 = r12 + 1
            r11 = r17
            goto L3a
        L82:
            r6 = r11
            if (r10 != r6) goto L8a
        L85:
            if (r7 == r5) goto L8a
            int r7 = r7 + 1
            goto L20
        L8a:
            C7.r r0 = C7.r.f317a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.end$lambda$9$lambda$8(androidx.compose.runtime.RecomposeScopeImpl, int, androidx.collection.MutableObjectIntMap, androidx.compose.runtime.Composition):C7.r");
    }

    private final boolean getFlag(int flag) {
        return (this.flags & flag) != 0;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setFlag(int flag, boolean value) {
        int i = this.flags;
        this.flags = value ? flag | i : (~flag) & i;
    }

    private final void setRereading(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 32 : i & (-33);
    }

    private final void setSkipped(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 16 : i & (-17);
    }

    public final void adoptedBy(RecomposeScopeOwner owner) {
        this.owner = owner;
    }

    public final void compose(Composer composer) {
        n nVar = this.block;
        if (nVar == null) {
            throw new IllegalStateException("Invalid restart scope");
        }
        nVar.invoke(composer, 1);
    }

    public final S7.k end(int token) {
        MutableObjectIntMap<Object> mutableObjectIntMap = this.trackedInstances;
        if (mutableObjectIntMap == null || getSkipped$runtime()) {
            return null;
        }
        Object[] objArr = mutableObjectIntMap.keys;
        int[] iArr = mutableObjectIntMap.values;
        long[] jArr = mutableObjectIntMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return null;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        if (iArr[i11] != token) {
                            return new h(token, 0, this, mutableObjectIntMap);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return null;
                }
            }
            if (i == length) {
                return null;
            }
            i++;
        }
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final boolean getForcedRecompose() {
        return (this.flags & 64) != 0;
    }

    /* renamed from: getOwner$runtime, reason: from getter */
    public final RecomposeScopeOwner getOwner() {
        return this.owner;
    }

    public final boolean getPaused() {
        return (this.flags & 256) != 0;
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final boolean getResetReusing() {
        return (this.flags & 1024) != 0;
    }

    public final boolean getResuming() {
        return (this.flags & 512) != 0;
    }

    public final boolean getReusing() {
        return (this.flags & 128) != 0;
    }

    public final boolean getSkipped$runtime() {
        return (this.flags & 16) != 0;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final boolean getValid() {
        if (this.owner != null) {
            Anchor anchor = this.anchor;
            if (anchor != null ? anchor.getValid() : false) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.invalidate(this, null);
        }
    }

    public final InvalidationResult invalidateForResult(Object value) {
        InvalidationResult invalidationResultInvalidate;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        return (recomposeScopeOwner == null || (invalidationResultInvalidate = recomposeScopeOwner.invalidate(this, value)) == null) ? InvalidationResult.IGNORED : invalidationResultInvalidate;
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInvalidFor(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r1 != 0) goto L8
            return r2
        L8:
            androidx.collection.MutableScatterMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r3 = r0.trackedDependencies
            if (r3 != 0) goto Ld
            return r2
        Ld:
            boolean r4 = r1 instanceof androidx.compose.runtime.DerivedState
            if (r4 == 0) goto L18
            androidx.compose.runtime.DerivedState r1 = (androidx.compose.runtime.DerivedState) r1
            boolean r0 = r0.checkDerivedStateChanged(r1, r3)
            return r0
        L18:
            boolean r4 = r1 instanceof androidx.collection.ScatterSet
            if (r4 == 0) goto L72
            androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
            boolean r4 = r1.isNotEmpty()
            r5 = 0
            if (r4 == 0) goto L71
            java.lang.Object[] r4 = r1.elements
            long[] r1 = r1.metadata
            int r6 = r1.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L71
            r7 = r5
        L2f:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L6c
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r5
        L49:
            if (r12 >= r10) goto L6a
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L66
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r4[r13]
            boolean r14 = r13 instanceof androidx.compose.runtime.DerivedState
            if (r14 == 0) goto L65
            androidx.compose.runtime.DerivedState r13 = (androidx.compose.runtime.DerivedState) r13
            boolean r13 = r0.checkDerivedStateChanged(r13, r3)
            if (r13 == 0) goto L66
        L65:
            return r2
        L66:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L49
        L6a:
            if (r10 != r11) goto L71
        L6c:
            if (r7 == r6) goto L71
            int r7 = r7 + 1
            goto L2f
        L71:
            return r5
        L72:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.isInvalidFor(java.lang.Object):boolean");
    }

    public final void recordDerivedStateValue(DerivedState<?> instance, Object value) {
        MutableScatterMap<DerivedState<?>, Object> mutableScatterMap = this.trackedDependencies;
        if (mutableScatterMap == null) {
            mutableScatterMap = new MutableScatterMap<>(0, 1, null);
            this.trackedDependencies = mutableScatterMap;
        }
        mutableScatterMap.set(instance, value);
    }

    public final boolean recordRead(Object instance) {
        int i = 0;
        if (getRereading()) {
            return false;
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = this.trackedInstances;
        int i6 = 1;
        if (mutableObjectIntMap == null) {
            mutableObjectIntMap = new MutableObjectIntMap<>(i, i6, null);
            this.trackedInstances = mutableObjectIntMap;
        }
        return mutableObjectIntMap.put(instance, this.currentToken, -1) == this.currentToken;
    }

    public final void release() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.recomposeScopeReleased(this);
        }
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
        this.block = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void rereadTrackedInstances() {
        /*
            r17 = this;
            r1 = r17
            androidx.compose.runtime.RecomposeScopeOwner r0 = r1.owner
            if (r0 == 0) goto L60
            androidx.collection.MutableObjectIntMap<java.lang.Object> r2 = r1.trackedInstances
            if (r2 == 0) goto L60
            r3 = 1
            r1.setRereading(r3)
            r3 = 0
            java.lang.Object[] r4 = r2.keys     // Catch: java.lang.Throwable -> L4b
            int[] r5 = r2.values     // Catch: java.lang.Throwable -> L4b
            long[] r2 = r2.metadata     // Catch: java.lang.Throwable -> L4b
            int r6 = r2.length     // Catch: java.lang.Throwable -> L4b
            int r6 = r6 + (-2)
            if (r6 < 0) goto L58
            r7 = r3
        L1b:
            r8 = r2[r7]     // Catch: java.lang.Throwable -> L4b
            long r10 = ~r8     // Catch: java.lang.Throwable -> L4b
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L53
            int r10 = r7 - r6
            int r10 = ~r10     // Catch: java.lang.Throwable -> L4b
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r3
        L35:
            if (r12 >= r10) goto L51
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L4d
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r4[r13]     // Catch: java.lang.Throwable -> L4b
            r13 = r5[r13]     // Catch: java.lang.Throwable -> L4b
            r0.recordReadOf(r14)     // Catch: java.lang.Throwable -> L4b
            goto L4d
        L4b:
            r0 = move-exception
            goto L5c
        L4d:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L35
        L51:
            if (r10 != r11) goto L58
        L53:
            if (r7 == r6) goto L58
            int r7 = r7 + 1
            goto L1b
        L58:
            r1.setRereading(r3)
            return
        L5c:
            r1.setRereading(r3)
            throw r0
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.rereadTrackedInstances():void");
    }

    public final void scopeSkipped() {
        if (getReusing()) {
            return;
        }
        setSkipped(true);
    }

    public final void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public final void setDefaultsInScope(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 2 : i & (-3);
    }

    public final void setDefaultsInvalid(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 4 : i & (-5);
    }

    public final void setForcedRecompose(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 64 : i & (-65);
    }

    public final void setOwner$runtime(RecomposeScopeOwner recomposeScopeOwner) {
        this.owner = recomposeScopeOwner;
    }

    public final void setPaused(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 256 : i & (-257);
    }

    public final void setRequiresRecompose(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 8 : i & (-9);
    }

    public final void setResetReusing(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 1024 : i & (-1025);
    }

    public final void setResuming(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 512 : i & (-513);
    }

    public final void setReusing(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 128 : i & (-129);
    }

    public final void setUsed(boolean z10) {
        int i = this.flags;
        this.flags = z10 ? i | 1 : i & (-2);
    }

    public final void start(int token) {
        this.currentToken = token;
        setSkipped(false);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(n block) {
        this.block = block;
    }
}
