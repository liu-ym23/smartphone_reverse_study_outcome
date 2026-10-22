package bx2;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f21332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21333c;

    @Override // bx2.a
    public final String h() {
        return SRStrategy.KEY_SR_STRATEGY_CONFIG;
    }

    public m() {
        this.f21332b = 1.0f;
        this.f21333c = 1.0f;
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.a().scale(this.f21332b, this.f21333c);
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21332b = a.c(r100, "sX");
        this.f21333c = a.c(r100, "sY");
    }
}
