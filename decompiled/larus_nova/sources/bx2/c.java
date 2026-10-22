package bx2;

import android.graphics.Path;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f21284b;

    @Override // bx2.a
    public final String h() {
        return "cp";
    }

    public c() {
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Path r101 = this.f21284b;
        if (r101 == null) goto L6;
        r100.a().clipPath(r101);
        return;
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        this.f21284b = (Path) CollectionsKt.last(r101.f16626j);
        r101.f16625i = true;
    }
}
