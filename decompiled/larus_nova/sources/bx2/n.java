package bx2;

import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21334b;

    @Override // bx2.a
    public final String h() {
        return "sta";
    }

    public n() {
        this.f21334b = "";
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = this.f21334b;
        if (Intrinsics.areEqual(r101, SVGRenderEngine.SAVE) == false) goto L6;
        r100.a().save();
        return;
    L6:
        if (Intrinsics.areEqual(r101, SVGRenderEngine.RESTORE) == false) goto L10;
        r100.a().restore();
        return;
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r100, ax2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "dataManager");
        Object r102 = r100.get("state");
        if (r102 == null) goto L6;
        String r103 = r102.toString();
        if (r103 == null) goto L6;
    L7:
        this.f21334b = r103;
        return;
    L6:
        r103 = "";
        goto L7
    }
}
