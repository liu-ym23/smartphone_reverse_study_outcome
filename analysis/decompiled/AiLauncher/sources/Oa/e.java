package Oa;

import Oa.f;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000bB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00008\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LOa/e;", ExifInterface.GPS_DIRECTION_TRUE, "", UxipConstants.f30680s, "LOa/f;", "trace", "<init>", "(Ljava/lang/Object;LOa/f;)V", "expect", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "LOa/f;", "getTrace", "()LOa/f;", "getTrace$annotations", "()V", "Ljava/lang/Object;", "c", "()Ljava/lang/Object;", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)V", "atomicfu"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e<T> {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<e<?>, Object> f5322d = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, Const.INTENT_KEY_PKGNAME);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final f trace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile T value;

    public e(T t10, f trace) {
        p.i(trace, "trace");
        this.trace = trace;
        this.value = t10;
    }

    public final boolean a(T expect, T update) {
        f fVar;
        boolean zCompareAndSet = f5322d.compareAndSet(this, expect, update);
        if (zCompareAndSet && (fVar = this.trace) != f.a.f5325a) {
            fVar.a("CAS(" + expect + ", " + update + ')');
        }
        return zCompareAndSet;
    }

    public final T b(T value) {
        T t10 = (T) f5322d.getAndSet(this, value);
        f fVar = this.trace;
        if (fVar != f.a.f5325a) {
            fVar.a("getAndSet(" + value + "):" + t10);
        }
        return t10;
    }

    public final T c() {
        return this.value;
    }

    public final void d(T t10) {
        this.value = t10;
        f fVar = this.trace;
        if (fVar != f.a.f5325a) {
            fVar.a("set(" + t10 + ')');
        }
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
