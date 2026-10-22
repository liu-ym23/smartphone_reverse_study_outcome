package bx2;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class r extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f21348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21349c;

    @Override // bx2.a
    public final String h() {
        return "ts";
    }

    public r() {
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.a().translate(this.f21348b, this.f21349c);
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21348b = a.c(r100, "dx");
        this.f21349c = a.c(r100, "dy");
    }
}
