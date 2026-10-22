package androidx.compose.runtime;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import j0.C4748f;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001'B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0007R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Landroidx/compose/runtime/o;", "Lj0/q;", "Landroidx/compose/runtime/d;", "", "", UxipConstants.f30680s, "<init>", "(J)V", "component1", "()Ljava/lang/Long;", "Lkotlin/Function1;", "LY8/t;", "component2", "()Lp9/l;", "Lj0/r;", "prependStateRecord", "(Lj0/r;)V", "previous", "current", "applied", "mergeRecords", "(Lj0/r;Lj0/r;Lj0/r;)Lj0/r;", "", "toString", "()Ljava/lang/String;", "Landroidx/compose/runtime/o$a;", "next", "Landroidx/compose/runtime/o$a;", "getFirstStateRecord", "()Lj0/r;", "firstStateRecord", "getLongValue", "()J", "setLongValue", "longValue", "Landroidx/compose/runtime/r;", "getPolicy", "()Landroidx/compose/runtime/r;", PolicySdkConstants.policyFileDir, Const.INTENT_KEY_APIKEY, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.o, reason: from toString */
/* loaded from: classes.dex */
public class MutableLongState extends j0.q implements d {
    public static final int $stable = 0;
    private a next;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/o$a;", "Lj0/r;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", UxipConstants.f30680s, "<init>", "(JJ)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lj0/r;)V", Const.INTENT_KEY_PKGNAME, "(J)Lj0/r;", "c", "J", Const.INTENT_KEY_BACKGROUND_COMMAND, "()J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(J)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.o$a */
    public static final class a extends j0.r {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public long value;

        public a(long j10, long j11) {
            super(j10);
            this.value = j11;
        }

        @Override // j0.r
        public void a(j0.r value) {
            kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
            this.value = ((a) value).value;
        }

        @Override // j0.r
        public j0.r b(long snapshotId) {
            return new a(snapshotId, this.value);
        }

        /* renamed from: g, reason: from getter */
        public final long getValue() {
            return this.value;
        }

        public final void h(long j10) {
            this.value = j10;
        }
    }

    public MutableLongState(long j10) {
        androidx.compose.runtime.snapshots.c cVarF = androidx.compose.runtime.snapshots.d.f();
        a aVar = new a(cVarF.getSnapshotId(), j10);
        if (!(cVarF instanceof androidx.compose.runtime.snapshots.a)) {
            aVar.e(new a(C4748f.c(1), j10));
        }
        this.next = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t component2$lambda$4(MutableLongState mutableLongState, long j10) {
        mutableLongState.setLongValue(j10);
        return Y8.t.f7040a;
    }

    public InterfaceC5074l<Long, Y8.t> component2() {
        return new InterfaceC5074l() { // from class: androidx.compose.runtime.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MutableLongState.component2$lambda$4(this.f11756a, ((Long) obj).longValue());
            }
        };
    }

    @Override // j0.p
    public j0.r getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.d
    public long getLongValue() {
        return ((a) androidx.compose.runtime.snapshots.d.o(this.next, this)).getValue();
    }

    public r<Long> getPolicy() {
        return s.c();
    }

    @Override // j0.p
    public j0.r mergeRecords(j0.r previous, j0.r current, j0.r applied) {
        kotlin.jvm.internal.p.g(current, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        kotlin.jvm.internal.p.g(applied, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        if (((a) current).getValue() == ((a) applied).getValue()) {
            return current;
        }
        return null;
    }

    @Override // j0.p
    public void prependStateRecord(j0.r value) {
        kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.next = (a) value;
    }

    @Override // androidx.compose.runtime.d
    public void setLongValue(long j10) {
        androidx.compose.runtime.snapshots.c cVarA;
        a aVar = (a) androidx.compose.runtime.snapshots.d.e(this.next);
        if (aVar.getValue() != j10) {
            a aVar2 = this.next;
            synchronized (androidx.compose.runtime.snapshots.d.h()) {
                cVarA = androidx.compose.runtime.snapshots.c.INSTANCE.a();
                ((a) androidx.compose.runtime.snapshots.d.l(aVar2, this, cVarA, aVar)).h(j10);
                Y8.t tVar = Y8.t.f7040a;
            }
            androidx.compose.runtime.snapshots.d.k(cVarA, this);
        }
    }

    public String toString() {
        return "MutableLongState(value=" + ((a) androidx.compose.runtime.snapshots.d.e(this.next)).getValue() + ")@" + hashCode();
    }

    /* renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Long m8component1() {
        return Long.valueOf(getLongValue());
    }
}
