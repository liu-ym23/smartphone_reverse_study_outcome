package fg;

import android.support.v4.media.session.PlaybackStateCompat;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static p f19723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f19724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f19725c = null;

    static {
        f19725c = new q();
    }

    public q() {
    }

    public static final void a(p r10) {
        kotlin.jvm.internal.q.h(r10, "segment");
        if (r10.f19721f != null) goto L24;
        if (r10.f19722g != null) goto L24;
        if (r10.f19719d == false) goto L9;
        return;
    L9:
        q r11 = f19725c;
        monitor-enter(r11);
        long r12 = f19724b;     // Catch: Throwable -> L20
        long r13 = 8192;
        if ((r12 + r13) <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L17;
        monitor-exit(r11);
        return;
    L17:
        f19724b = r12 + r13;     // Catch: Throwable -> L20
        r10.f19721f = f19723a;     // Catch: Throwable -> L20
        r10.f19718c = 0;     // Catch: Throwable -> L20
        r10.f19717b = 0;     // Catch: Throwable -> L20
        f19723a = r10;     // Catch: Throwable -> L20
        Unit r14 = Unit.f21064a;     // Catch: Throwable -> L20
        monitor-exit(r11);
        return;
    L20:
        th = move-exception;
        throw th;
    L24:
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final p b() {
        q r10 = f19725c;
        monitor-enter(r10);
        p r11 = f19723a;     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        f19723a = r11.f19721f;     // Catch: Throwable -> L9
        r11.f19721f = null;     // Catch: Throwable -> L9
        f19724b -= (long) 8192;     // Catch: Throwable -> L9
        monitor-exit(r10);
        return r11;
    L11:
        monitor-exit(r10);
        return new p();
    L9:
        th = move-exception;
        throw th;
    }
}
