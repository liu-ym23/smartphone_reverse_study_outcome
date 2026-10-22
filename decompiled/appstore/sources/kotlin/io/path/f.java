package kotlin.io.path;

import com.bytedance.apm.constant.TraceStatsConsts;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.q;
import kotlin.text.o;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f21149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Path f21150b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Path f21151c = null;

    static {
        f21149a = new f();
        f21150b = Paths.get("", new String[0]);
        f21151c = Paths.get("..", new String[0]);
    }

    public f() {
    }

    public final Path a(Path r10, Path r11) {
        q.g(r10, "path");
        q.g(r11, TraceStatsConsts.STATS_BASE_MODULE);
        Path r12 = r11.normalize();
        Path r13 = r10.normalize();
        Path r14 = r12.relativize(r13);
        int r15 = Math.min(r12.getNameCount(), r13.getNameCount());
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L12;
        Path r17 = r12.getName(r16);
        Path r18 = f21151c;
        if (q.b(r17, r18) == false) goto L12;
        if (q.b(r13.getName(r16), r18) == false) goto L10;
        r16 = r16 + 1;
        goto L3
    L10:
        throw new IllegalArgumentException("Unable to compute relative path");
    L12:
        if (q.b(r13, r12) == false) goto L14;
    L16:
        String r19 = r14.toString();
        String r20 = r14.getFileSystem().getSeparator();
        q.f(r20, "getSeparator(...)");
        if (o.o(r19, r20, false, 2, null) == false) goto L19;
        r13 = r14.getFileSystem().getPath(kotlin.text.q.D0(r19, r14.getFileSystem().getSeparator().length()), new String[0]);
    L20:
        q.d(r13);
        return r13;
    L19:
        r13 = r14;
        goto L20
    L14:
        if (q.b(r12, f21150b) == false) goto L16;
        goto L16
    }
}
