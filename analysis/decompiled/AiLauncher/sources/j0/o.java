package j0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\b\u0000\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00022\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001c¨\u0006\""}, d2 = {"Lj0/o;", ExifInterface.GPS_DIRECTION_TRUE, "Lj0/r;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Ld0/e;", "list", "<init>", "(JLd0/e;)V", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lj0/r;)V", Const.INTENT_KEY_PKGNAME, "(J)Lj0/r;", "c", "Ld0/e;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ld0/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ld0/e;)V", "", Const.INTENT_KEY_UMID, "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()I", "k", "(I)V", "modification", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "l", "structuralChange", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o<T> extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public d0.e<? extends T> list;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int modification;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int structuralChange;

    public o(long j10, d0.e<? extends T> eVar) {
        super(j10);
        this.list = eVar;
    }

    @Override // j0.r
    public void a(r value) {
        synchronized (C4753k.f34438a) {
            kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.StateListStateRecord>");
            this.list = ((o) value).list;
            this.modification = ((o) value).modification;
            this.structuralChange = ((o) value).structuralChange;
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // j0.r
    public r b(long snapshotId) {
        return new o(snapshotId, this.list);
    }

    public final d0.e<T> g() {
        return this.list;
    }

    /* renamed from: h, reason: from getter */
    public final int getModification() {
        return this.modification;
    }

    /* renamed from: i, reason: from getter */
    public final int getStructuralChange() {
        return this.structuralChange;
    }

    public final void j(d0.e<? extends T> eVar) {
        this.list = eVar;
    }

    public final void k(int i10) {
        this.modification = i10;
    }

    public final void l(int i10) {
        this.structuralChange = i10;
    }
}
