package bq2;

import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGameCPTrackService f20020a;

    public final Map<String, String> a() {
        IGameCPTrackService r100 = this.f20020a;
        if (r100 == null) goto L7;
        Map<String, String> r101 = IGameCPTrackService.CC.getGPCommonParams$default(r100, null, null, 2, null);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return MapsKt.emptyMap();
    }

    public c(IGameCPTrackService r100) {
        this.f20020a = r100;
    }

    public final void b(Map r100) {
        Intrinsics.checkNotNullParameter("dygame_result_show", "eventName");
        Intrinsics.checkNotNullParameter(r100, "extra");
        IGameCPTrackService r101 = this.f20020a;
        if (r101 == null) goto L6;
        r101.sendLog("dygame_result_show", r100);
        return;
    }
}
