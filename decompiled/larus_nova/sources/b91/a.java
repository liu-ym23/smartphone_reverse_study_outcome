package b91;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18244a = 0;

    static {
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        j0.l().sendLog("livesdk_rd_live_user_rank_click_enter", r100, new Object[]{new x(), IRoom.class});
    }
}
