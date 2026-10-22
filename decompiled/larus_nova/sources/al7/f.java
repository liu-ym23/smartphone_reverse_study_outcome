package al7;

import gk7.j;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f4188a = null;

    static {
        f4188a = new f();
    }

    public f() {
    }

    @Override // gk7.j
    public final void a(boolean r100, long r101) {
        AtomicInteger r102 = d.f4167a;
        d.f4176j.set(false);
        d.h();
        hl7.b r103 = hl7.b.b();
        r103.f485693e.remove(d.f4177k);
        d.f4177k = null;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "时间校准回调 current = " + r101);
    }
}
