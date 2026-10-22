package bs1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20221a = 0;

    static {
    }

    public static void b(DataCenter r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "param");
        r100.put("data_live_quick_shot_path", r101);
        r.m().logQuickShotFinish(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(r101.f20225d)), TuplesKt.to("download_duration", String.valueOf(System.currentTimeMillis() - r101.f20225d)), TuplesKt.to("is_success", "1")}));
    }

    public static void a(long r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "failReason");
        r.m().logQuickShotFinish(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(r100)), TuplesKt.to("is_success", "0"), TuplesKt.to("error_code", String.valueOf(r101)), TuplesKt.to("error_msg", r102)}));
    }
}
