package androidx.compose.runtime.snapshots;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import j0.p;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00162\u00020\u0001:\u0001\u000eB\u001d\b\u0004\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH ¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0006\u001a\u00020\u00058\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R2\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u00038\u0016@PX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u001a8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010&R(\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010(8 X¡\u0004¢\u0006\f\u0012\u0004\b*\u0010\u001e\u001a\u0004\b\u0014\u0010)R\"\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010(8 X \u0004¢\u0006\u0006\u001a\u0004\b,\u0010)\u0082\u0001\u0001.¨\u0006/"}, d2 = {"Landroidx/compose/runtime/snapshots/c;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", M5.b.AUTH_STATUS_INVALID, "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "Lj0/p;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lj0/p;)V", Const.INTENT_KEY_APIKEY, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "J", Const.INTENT_KEY_UMID, "()J", "setSnapshotId$runtime", "(J)V", "", "c", "I", "getPinningTrackingHandle$annotations", "()V", "pinningTrackingHandle", "e", "()I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)V", "writeCount", "", "()Z", "readOnly", "Lkotlin/Function1;", "()Lp9/l;", "getReadObserver$annotations", "readObserver", "f", "writeObserver", "Landroidx/compose/runtime/snapshots/b;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f11783e = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public SnapshotIdSet invalid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long snapshotId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int pinningTrackingHandle;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/snapshots/c$a;", "", "<init>", "()V", "Landroidx/compose/runtime/snapshots/c;", Const.INTENT_KEY_APIKEY, "()Landroidx/compose/runtime/snapshots/c;", "current", "", Const.INTENT_KEY_PKGNAME, "()Z", "isInSnapshot", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.snapshots.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final c a() {
            return d.f();
        }

        public final boolean b() {
            return d.f11789c.a() != null;
        }

        public Companion() {
        }
    }

    public /* synthetic */ c(long j10, SnapshotIdSet snapshotIdSet, i iVar) {
        this(j10, snapshotIdSet);
    }

    /* renamed from: a, reason: from getter */
    public SnapshotIdSet getInvalid() {
        return this.invalid;
    }

    public abstract InterfaceC5074l<Object, t> b();

    public abstract boolean c();

    /* renamed from: d, reason: from getter */
    public long getSnapshotId() {
        return this.snapshotId;
    }

    /* renamed from: e */
    public int getWriteCount() {
        return 0;
    }

    public abstract InterfaceC5074l<Object, t> f();

    public abstract void g(p state);

    public void h(int i10) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public c(long j10, SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
        this.snapshotId = j10;
        this.pinningTrackingHandle = j10 != d.f11788b ? d.p(j10, getInvalid()) : -1;
    }
}
