package Oa;

import Oa.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u000bB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LOa/c;", "", "", UxipConstants.f30680s, "LOa/f;", "trace", "<init>", "(ILOa/f;)V", "expect", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "", Const.INTENT_KEY_APIKEY, "(II)Z", Const.INTENT_KEY_UMID, "()I", Const.INTENT_KEY_PKGNAME, "", "toString", "()Ljava/lang/String;", "LOa/f;", "getTrace", "()LOa/f;", "getTrace$annotations", "()V", "I", "c", "e", "(I)V", "atomicfu"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater<c> f5314d = AtomicIntegerFieldUpdater.newUpdater(c.class, Const.INTENT_KEY_PKGNAME);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final f trace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile int value;

    public c(int i10, f trace) {
        p.i(trace, "trace");
        this.trace = trace;
        this.value = i10;
    }

    public final boolean a(int expect, int update) {
        f fVar;
        boolean zCompareAndSet = f5314d.compareAndSet(this, expect, update);
        if (zCompareAndSet && (fVar = this.trace) != f.a.f5325a) {
            fVar.a("CAS(" + expect + ", " + update + ')');
        }
        return zCompareAndSet;
    }

    public final int b() {
        int iDecrementAndGet = f5314d.decrementAndGet(this);
        f fVar = this.trace;
        if (fVar != f.a.f5325a) {
            fVar.a("decAndGet():" + iDecrementAndGet);
        }
        return iDecrementAndGet;
    }

    /* renamed from: c, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final int d() {
        int iIncrementAndGet = f5314d.incrementAndGet(this);
        f fVar = this.trace;
        if (fVar != f.a.f5325a) {
            fVar.a("incAndGet():" + iIncrementAndGet);
        }
        return iIncrementAndGet;
    }

    public final void e(int i10) {
        this.value = i10;
        f fVar = this.trace;
        if (fVar != f.a.f5325a) {
            fVar.a("set(" + i10 + ')');
        }
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
