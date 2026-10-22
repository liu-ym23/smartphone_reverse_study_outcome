package Oa;

import Oa.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\nB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LOa/a;", "", "", "v", "LOa/f;", "trace", "<init>", "(ZLOa/f;)V", "expect", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, Const.INTENT_KEY_APIKEY, "(ZZ)Z", "", "toString", "()Ljava/lang/String;", "LOa/f;", "getTrace", "()LOa/f;", "getTrace$annotations", "()V", "", Const.INTENT_KEY_PKGNAME, "I", "_value", UxipConstants.f30680s, "()Z", "c", "(Z)V", "atomicfu"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater<a> f5310d = AtomicIntegerFieldUpdater.newUpdater(a.class, Const.INTENT_KEY_PKGNAME);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final f trace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile int _value;

    public a(boolean z10, f trace) {
        p.i(trace, "trace");
        this.trace = trace;
        this._value = z10 ? 1 : 0;
    }

    public final boolean a(boolean expect, boolean update) {
        f fVar;
        boolean zCompareAndSet = f5310d.compareAndSet(this, expect ? 1 : 0, update ? 1 : 0);
        if (zCompareAndSet && (fVar = this.trace) != f.a.f5325a) {
            fVar.a("CAS(" + expect + ", " + update + ')');
        }
        return zCompareAndSet;
    }

    public final boolean b() {
        return this._value != 0;
    }

    public final void c(boolean z10) {
        this._value = z10 ? 1 : 0;
        f fVar = this.trace;
        if (fVar != f.a.f5325a) {
            fVar.a("set(" + z10 + ')');
        }
    }

    public String toString() {
        return String.valueOf(b());
    }
}
