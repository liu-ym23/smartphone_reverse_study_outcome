package Oa;

import Oa.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \r2\u00020\u0001:\u0001\u000bB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"LOa/d;", "", "", UxipConstants.f30680s, "LOa/f;", "trace", "<init>", "(JLOa/f;)V", "expect", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "", Const.INTENT_KEY_APIKEY, "(JJ)Z", "c", "()J", "", "toString", "()Ljava/lang/String;", "LOa/f;", "getTrace", "()LOa/f;", "getTrace$annotations", "()V", Const.INTENT_KEY_PKGNAME, "J", Const.INTENT_KEY_UMID, "(J)V", "atomicfu"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater<d> f5318d = AtomicLongFieldUpdater.newUpdater(d.class, Const.INTENT_KEY_PKGNAME);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final f trace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile long value;

    public d(long j10, f trace) {
        p.i(trace, "trace");
        this.trace = trace;
        this.value = j10;
    }

    public final boolean a(long expect, long update) {
        f fVar;
        boolean zCompareAndSet = f5318d.compareAndSet(this, expect, update);
        if (zCompareAndSet && (fVar = this.trace) != f.a.f5325a) {
            fVar.a("CAS(" + expect + ", " + update + ')');
        }
        return zCompareAndSet;
    }

    /* renamed from: b, reason: from getter */
    public final long getValue() {
        return this.value;
    }

    public final long c() {
        long jIncrementAndGet = f5318d.incrementAndGet(this);
        f fVar = this.trace;
        if (fVar != f.a.f5325a) {
            fVar.a("incAndGet():" + jIncrementAndGet);
        }
        return jIncrementAndGet;
    }

    public final void d(long j10) {
        this.value = j10;
        f fVar = this.trace;
        if (fVar != f.a.f5325a) {
            fVar.a("set(" + j10 + ')');
        }
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
