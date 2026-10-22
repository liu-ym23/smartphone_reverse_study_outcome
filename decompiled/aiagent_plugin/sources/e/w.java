package e;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SegmentPool.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f38760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f38761b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final v f38762c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f38763d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReference<v>[] f38764e = null;

    private w() {
    }

    static {
        f38760a = new w();
        f38761b = 65536;
        int r7 = 0;
        f38762c = new v(new byte[0], 0, 0, false, false);
        int r0 = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f38763d = r0;
        AtomicReference<v>[] r1 = new AtomicReference[r0];
    L3:
        if (r7 >= r0) goto L5;
        r1[r7] = new AtomicReference();
        r7 = r7 + 1;
        goto L3
    L5:
        f38764e = r1;
    }

    public static final v a() {
        AtomicReference<v> r0 = f38760a.b();
        v r1 = f38762c;
        v r2 = (v) ZeusTransformUtils.preCheckCast(r0.getAndSet(r1), v.class, "com.obric.aiagent.plugin");
        if (r2 != r1) goto L7;
        return new v();
    L7:
        if (r2 != null) goto L10;
        r0.set(null);
        return new v();
    L10:
        r0.set(r2.g);
        r2.g = null;
        r2.f38758d = 0;
        return r2;
    }

    public static final void a(v r6) {
        d.h.b.o.e(r6, MonitorConstants.SEGMENT);
        if (r6.g == null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L25;
        if (r6.f38759e == false) goto L12;
        return;
    L12:
        AtomicReference<v> r1 = f38760a.b();
        v r2 = f38762c;
        v r3 = (v) ZeusTransformUtils.preCheckCast(r1.getAndSet(r2), v.class, "com.obric.aiagent.plugin");
        if (r3 != r2) goto L15;
        return;
    L15:
        if (r3 == null) goto L17;
        int r4 = r3.f38758d;
    L19:
        if (r4 < f38761b) goto L22;
        r1.set(r3);
        return;
    L22:
        r6.g = r3;
        r6.f38757c = 0;
        r6.f38758d = r4 + 8192;
        r1.set(r6);
        return;
    L17:
        r4 = 0;
        goto L19
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r6.h != null) goto L7;
        r0 = true;
        goto L8
    }

    private final AtomicReference<v> b() {
        int r6 = (int) (Thread.currentThread().getId() & (((long) f38763d) - 1));
        return f38764e[r6];
    }
}
