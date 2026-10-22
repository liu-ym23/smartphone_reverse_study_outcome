package bx2;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class l extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f21331b;

    @Override // bx2.a
    public final String h() {
        return "ro";
    }

    public l() {
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.a().rotate(this.f21331b);
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21331b = (float) ((((double) a.c(r100, "degree")) / 3.141592653589793d) * ((double) 180));
    }
}
