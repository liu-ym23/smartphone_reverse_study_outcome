package cb;

import android.os.SystemClock;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements com.obric.capabilitykit.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair f6088a;

    public r() {
    }

    @Override // com.obric.capabilitykit.j
    public long a() {
        Pair r10 = this.f6088a;
        if (r10 == null) goto L6;
        return (SystemClock.elapsedRealtime() - ((Number) r10.getFirst()).longValue()) + ((Number) r10.getSecond()).longValue();
    L6:
        return System.currentTimeMillis();
    }

    @Override // com.obric.capabilitykit.j
    public void a(long r10) {
        if (this.f6088a != null) goto L6;
        this.f6088a = kotlin.d.a(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(r10));
        return;
    }
}
