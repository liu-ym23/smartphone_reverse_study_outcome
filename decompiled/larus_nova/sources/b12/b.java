package b12;

import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.m;
import com.bytedance.live.kmp.core.c;
import cy0.e;
import cy0.j;
import j01.d;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f16922a = 0;

    static {
    }

    public static void b(String r100, JSONObject r101, int r110) {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "extra");
        Intrinsics.checkNotNullParameter(r103, "metric");
        EventModule r105 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r105, "eventModule");
        String r106 = r105.getValue();
        r103.put("status", String.valueOf(r110));
        Intrinsics.checkNotNullParameter(r104, "map");
        Iterator<String> r111 = r101.keys();
    L4:
        if (r111.hasNext() == false) goto L6;
        String r107 = r111.next();
        Object r108 = r101.get(r107);
        Intrinsics.checkNotNullParameter(r107, "key");
        Intrinsics.checkNotNullParameter(r108, "value");
        r104.put(r107, r108);
        goto L4
    L6:
        e.f465759a.getClass();
        j r112 = e.a.f465760a;
        m.f163449e.getClass();
        Object r109 = m.b(r112).b(n97.a.class);
        Intrinsics.checkNotNull(r109);
        ((n97.a) ((c) r109)).g(r100, r106, "bussiness_api_call", r102, r103, r104);
    }

    @JvmStatic
    public static final void a(Long r100, Long r101, Integer r102, String r103) {
        JSONObject r104 = new JSONObject();
        long r105 = 0;
        if (r100 == null) goto L5;
        long r106 = r100.longValue();
    L6:
        d.b(r104, "asset_id", Long.valueOf(r106));
        if (r101 == null) goto L9;
        r105 = r101.longValue();
    L9:
        d.b(r104, "download_assets_from", Long.valueOf(r105));
        if (r102 == null) goto L12;
        int r107 = r102.intValue();
    L13:
        d.b(r104, "error_code", Integer.valueOf(r107));
        if (r103 != null) goto L16;
        r103 = "";
    L16:
        d.b(r104, "error_msg", r103);
        Intrinsics.checkNotNullParameter("ttlive_download_befview_resource_status", "name");
        b(z.a("ttlive_download_befview_resource_status"), r104, 1);
        Intrinsics.checkNotNullParameter("ttlive_download_befview_resource_status", "name");
        b(z.b("ttlive_download_befview_resource_status"), r104, 1);
        return;
    L12:
        r107 = 0;
        goto L13
    L5:
        r106 = 0;
        goto L6
    }
}
