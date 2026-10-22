package cl0;

import com.bytedance.android.live.core.privacy.av.api.b;
import com.bytedance.android.live.livepkaudience.security.LinkSecurityMonitor;
import com.bytedance.android.livesdk.config.mh0;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends LinkSecurityMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f24084d = null;

    static {
        f24084d = new a();
    }

    @Override // com.bytedance.android.live.livepkaudience.security.LinkSecurityMonitor
    public final boolean b() {
        return mh0.f120756a.getValue().booleanValue();
    }

    public a() {
    }

    public static void f(a r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        b.f65134a.getClass();
        b.a.C1072a r102 = b.a.f65135a;
        com.bytedance.android.live.core.privacy.av.api.a r103 = com.bytedance.android.live.core.privacy.av.api.a.f65132b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "config");
        r100.c("on_link_destroyed", r101, r102, r103);
    }

    public static void g(a r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        b.f65134a.getClass();
        b.a.C1072a r102 = b.a.f65135a;
        com.bytedance.android.live.core.privacy.av.api.a r103 = com.bytedance.android.live.core.privacy.av.api.a.f65132b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "config");
        r100.d("self_mute", r101, r102, r103);
    }
}
