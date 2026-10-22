package bx2;

import android.graphics.RectF;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f21283b;

    @Override // bx2.a
    public final String h() {
        return SRStrategy.KEY_CURRENT_RESOLUTION;
    }

    public b() {
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        RectF r101 = this.f21283b;
        if (r101 == null) goto L6;
        r100.a().drawRect(r101, r100.f16615c);
        return;
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21283b = new RectF();
        float r102 = a.c(r100, "x");
        float r103 = a.c(r100, "y");
        RectF r104 = this.f21283b;
        if (r104 == null) goto L6;
        r104.left = r102;
        r104.top = r103;
        r104.right = a.c(r100, "w") + r102;
        r104.bottom = r102 + a.c(r100, "h");
        return;
    }
}
