package kotlin.io.path;

import com.bytedance.apm.constant.TraceStatsConsts;
import java.nio.file.Path;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k extends j {
    public static final Path o(Path r10, Path r11) {
        q.g(r10, "<this>");
        q.g(r11, TraceStatsConsts.STATS_BASE_MODULE);
        return f.f21149a.a(r10, r11);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + r10 + "\nbase path: " + r11, e);
    }
}
