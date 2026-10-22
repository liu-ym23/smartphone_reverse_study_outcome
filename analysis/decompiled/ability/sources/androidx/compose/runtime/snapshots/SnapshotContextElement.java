package androidx.compose.runtime.snapshots;

import H7.f;
import H7.g;
import H7.h;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import z2.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "LH7/f;", "Key", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SnapshotContextElement extends f {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(SnapshotContextElement snapshotContextElement, R r5, n nVar) {
            return (R) l.w(snapshotContextElement, r5, nVar);
        }

        public static <E extends f> E get(SnapshotContextElement snapshotContextElement, g gVar) {
            return (E) l.x(snapshotContextElement, gVar);
        }

        public static h minusKey(SnapshotContextElement snapshotContextElement, g gVar) {
            return l.C(snapshotContextElement, gVar);
        }

        public static h plus(SnapshotContextElement snapshotContextElement, h hVar) {
            return l.H(snapshotContextElement, hVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElement$Key;", "LH7/g;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", AppAgent.CONSTRUCT, "()V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.snapshots.SnapshotContextElement$Key, reason: from kotlin metadata */
    public static final class Companion implements g {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Override // H7.h
    /* synthetic */ Object fold(Object obj, n nVar);

    @Override // H7.h
    /* synthetic */ f get(g gVar);

    @Override // H7.f
    /* synthetic */ g getKey();

    @Override // H7.h
    /* synthetic */ h minusKey(g gVar);

    @Override // H7.h
    /* synthetic */ h plus(h hVar);
}
