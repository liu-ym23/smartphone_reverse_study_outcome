package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import j0.C4748f;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001+B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0017H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR*\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b#\u0010$\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\"R\u0017\u0010'\u001a\u00028\u00008G¢\u0006\f\u0012\u0004\b&\u0010$\u001a\u0004\b%\u0010\u0016R\u0014\u0010*\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Landroidx/compose/runtime/q;", ExifInterface.GPS_DIRECTION_TRUE, "Lj0/q;", "", UxipConstants.f30680s, "Landroidx/compose/runtime/r;", PolicySdkConstants.policyFileDir, "<init>", "(Ljava/lang/Object;Landroidx/compose/runtime/r;)V", "Lj0/r;", "LY8/t;", "prependStateRecord", "(Lj0/r;)V", "previous", "current", "applied", "mergeRecords", "(Lj0/r;Lj0/r;Lj0/r;)Lj0/r;", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/lang/Object;", "Lkotlin/Function1;", "component2", "()Lp9/l;", "Landroidx/compose/runtime/r;", "getPolicy", "()Landroidx/compose/runtime/r;", "Landroidx/compose/runtime/q$a;", "next", "Landroidx/compose/runtime/q$a;", "getValue", "setValue", "(Ljava/lang/Object;)V", "getValue$annotations", "()V", "getDebuggerDisplayValue", "getDebuggerDisplayValue$annotations", "debuggerDisplayValue", "getFirstStateRecord", "()Lj0/r;", "firstStateRecord", Const.INTENT_KEY_APIKEY, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.q, reason: from toString */
/* loaded from: classes.dex */
public class MutableState<T> extends j0.q {
    public static final int $stable = 0;
    private a<T> next;
    private final r<T> policy;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u001b\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\t\u001a\u00028\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/q$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lj0/r;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "myValue", "<init>", "(JLjava/lang/Object;)V", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lj0/r;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(J)Landroidx/compose/runtime/q$a;", "c", "Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Object;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.q$a */
    public static final class a<T> extends j0.r {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public T value;

        public a(long j10, T t10) {
            super(j10);
            this.value = t10;
        }

        @Override // j0.r
        public void a(j0.r value) {
            kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
            this.value = ((a) value).value;
        }

        @Override // j0.r
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a<T> b(long snapshotId) {
            return new a<>(androidx.compose.runtime.snapshots.d.f().getSnapshotId(), this.value);
        }

        public final T h() {
            return this.value;
        }

        public final void i(T t10) {
            this.value = t10;
        }
    }

    public MutableState(T t10, r<T> rVar) {
        this.policy = rVar;
        androidx.compose.runtime.snapshots.c cVarF = androidx.compose.runtime.snapshots.d.f();
        a<T> aVar = new a<>(cVarF.getSnapshotId(), t10);
        if (!(cVarF instanceof androidx.compose.runtime.snapshots.a)) {
            aVar.e(new a(C4748f.c(1), t10));
        }
        this.next = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t component2$lambda$6(MutableState mutableState, Object obj) {
        mutableState.setValue(obj);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public T component1() {
        return getValue();
    }

    public InterfaceC5074l<T, Y8.t> component2() {
        return new InterfaceC5074l() { // from class: androidx.compose.runtime.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MutableState.component2$lambda$6(this.f11758a, obj);
            }
        };
    }

    public final T getDebuggerDisplayValue() {
        return (T) ((a) androidx.compose.runtime.snapshots.d.e(this.next)).h();
    }

    @Override // j0.p
    public j0.r getFirstStateRecord() {
        return this.next;
    }

    public r<T> getPolicy() {
        return this.policy;
    }

    public T getValue() {
        return (T) ((a) androidx.compose.runtime.snapshots.d.o(this.next, this)).h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j0.p
    public j0.r mergeRecords(j0.r previous, j0.r current, j0.r applied) {
        kotlin.jvm.internal.p.g(previous, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar = (a) previous;
        kotlin.jvm.internal.p.g(current, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar2 = (a) current;
        kotlin.jvm.internal.p.g(applied, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        a aVar3 = (a) applied;
        if (getPolicy().b(aVar2.h(), aVar3.h())) {
            return current;
        }
        Object objA = getPolicy().a(aVar.h(), aVar2.h(), aVar3.h());
        if (objA == null) {
            return null;
        }
        a aVarB = aVar3.b(aVar3.getSnapshotId());
        aVarB.i(objA);
        return aVarB;
    }

    @Override // j0.p
    public void prependStateRecord(j0.r value) {
        kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        this.next = (a) value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setValue(T t10) {
        androidx.compose.runtime.snapshots.c cVarA;
        a aVar = (a) androidx.compose.runtime.snapshots.d.e(this.next);
        if (getPolicy().b(aVar.h(), t10)) {
            return;
        }
        a<T> aVar2 = this.next;
        synchronized (androidx.compose.runtime.snapshots.d.h()) {
            cVarA = androidx.compose.runtime.snapshots.c.INSTANCE.a();
            ((a) androidx.compose.runtime.snapshots.d.l(aVar2, this, cVarA, aVar)).i(t10);
            Y8.t tVar = Y8.t.f7040a;
        }
        androidx.compose.runtime.snapshots.d.k(cVarA, this);
    }

    public String toString() {
        return "MutableState(value=" + ((a) androidx.compose.runtime.snapshots.d.e(this.next)).h() + ")@" + hashCode();
    }
}
