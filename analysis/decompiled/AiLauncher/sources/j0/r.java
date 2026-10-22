package j0;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fR&\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0006R$\u0010\u0015\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\n¨\u0006\u0016"}, d2 = {"Lj0/r;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "<init>", "(J)V", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lj0/r;)V", Const.INTENT_KEY_PKGNAME, "(J)Lj0/r;", "J", Const.INTENT_KEY_UMID, "()J", "f", "Lj0/r;", "c", "()Lj0/r;", "e", "next", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long snapshotId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public r next;

    public r(long j10) {
        this.snapshotId = j10;
    }

    public abstract void a(r value);

    public abstract r b(long snapshotId);

    /* renamed from: c, reason: from getter */
    public final r getNext() {
        return this.next;
    }

    /* renamed from: d, reason: from getter */
    public final long getSnapshotId() {
        return this.snapshotId;
    }

    public final void e(r rVar) {
        this.next = rVar;
    }

    public final void f(long j10) {
        this.snapshotId = j10;
    }
}
