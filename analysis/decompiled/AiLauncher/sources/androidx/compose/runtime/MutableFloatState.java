package androidx.compose.runtime;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import j0.C4748f;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001'B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0007R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Landroidx/compose/runtime/k;", "Lj0/q;", "Landroidx/compose/runtime/b;", "", "", UxipConstants.f30680s, "<init>", "(F)V", "component1", "()Ljava/lang/Float;", "Lkotlin/Function1;", "LY8/t;", "component2", "()Lp9/l;", "Lj0/r;", "prependStateRecord", "(Lj0/r;)V", "previous", "current", "applied", "mergeRecords", "(Lj0/r;Lj0/r;Lj0/r;)Lj0/r;", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/runtime/k$a;", "next", "Landroidx/compose/runtime/k$a;", "getFirstStateRecord", "()Lj0/r;", "firstStateRecord", "getFloatValue", "()F", "setFloatValue", "floatValue", "Landroidx/compose/runtime/r;", "getPolicy", "()Landroidx/compose/runtime/r;", PolicySdkConstants.policyFileDir, Const.INTENT_KEY_APIKEY, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.k, reason: from toString */
/* loaded from: classes.dex */
public class MutableFloatState extends j0.q implements b {
    public static final int $stable = 0;
    private a next;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/k$a;", "Lj0/r;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "", UxipConstants.f30680s, "<init>", "(JF)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lj0/r;)V", Const.INTENT_KEY_PKGNAME, "(J)Lj0/r;", "c", "F", Const.INTENT_KEY_BACKGROUND_COMMAND, "()F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(F)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.k$a */
    public static final class a extends j0.r {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public float value;

        public a(long j10, float f10) {
            super(j10);
            this.value = f10;
        }

        @Override // j0.r
        public void a(j0.r value) {
            kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
            this.value = ((a) value).value;
        }

        @Override // j0.r
        public j0.r b(long snapshotId) {
            return new a(snapshotId, this.value);
        }

        /* renamed from: g, reason: from getter */
        public final float getValue() {
            return this.value;
        }

        public final void h(float f10) {
            this.value = f10;
        }
    }

    public MutableFloatState(float f10) {
        androidx.compose.runtime.snapshots.c cVarF = androidx.compose.runtime.snapshots.d.f();
        a aVar = new a(cVarF.getSnapshotId(), f10);
        if (!(cVarF instanceof androidx.compose.runtime.snapshots.a)) {
            aVar.e(new a(C4748f.c(1), f10));
        }
        this.next = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t component2$lambda$4(MutableFloatState mutableFloatState, float f10) {
        mutableFloatState.setFloatValue(f10);
        return Y8.t.f7040a;
    }

    public InterfaceC5074l<Float, Y8.t> component2() {
        return new InterfaceC5074l() { // from class: androidx.compose.runtime.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MutableFloatState.component2$lambda$4(this.f11752a, ((Float) obj).floatValue());
            }
        };
    }

    @Override // j0.p
    public j0.r getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.b
    public float getFloatValue() {
        return ((a) androidx.compose.runtime.snapshots.d.o(this.next, this)).getValue();
    }

    public r<Float> getPolicy() {
        return s.c();
    }

    @Override // j0.p
    public j0.r mergeRecords(j0.r previous, j0.r current, j0.r applied) {
        kotlin.jvm.internal.p.g(current, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        kotlin.jvm.internal.p.g(applied, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        if (((a) current).getValue() == ((a) applied).getValue()) {
            return current;
        }
        return null;
    }

    @Override // j0.p
    public void prependStateRecord(j0.r value) {
        kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.next = (a) value;
    }

    @Override // androidx.compose.runtime.b
    public void setFloatValue(float f10) {
        androidx.compose.runtime.snapshots.c cVarA;
        a aVar = (a) androidx.compose.runtime.snapshots.d.e(this.next);
        if (aVar.getValue() == f10) {
            return;
        }
        a aVar2 = this.next;
        synchronized (androidx.compose.runtime.snapshots.d.h()) {
            cVarA = androidx.compose.runtime.snapshots.c.INSTANCE.a();
            ((a) androidx.compose.runtime.snapshots.d.l(aVar2, this, cVarA, aVar)).h(f10);
            Y8.t tVar = Y8.t.f7040a;
        }
        androidx.compose.runtime.snapshots.d.k(cVarA, this);
    }

    public String toString() {
        return "MutableFloatState(value=" + ((a) androidx.compose.runtime.snapshots.d.e(this.next)).getValue() + ")@" + hashCode();
    }

    /* renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Float m6component1() {
        return Float.valueOf(getFloatValue());
    }
}
