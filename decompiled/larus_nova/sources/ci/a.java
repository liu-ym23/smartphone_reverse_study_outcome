package ci;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pi.b;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23836a = 0;

    static {
    }

    public static void b(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        int r104 = ECSdk.f48106a;
        b r105 = (b) ECSdk.a(b.class);
        if (r105 == null) goto L11;
        JSONObject r106 = new JSONObject();
        r106.put("scene", r101);
        if (r102 == null) goto L7;
        r106.put("name", r102);
    L7:
        if (r103 == null) goto L9;
        r106.put("source_type", r103);
    L9:
        Unit r107 = Unit.INSTANCE;
        JSONObject r108 = new JSONObject();
        r108.put("duration", r100);
        r105.monitorEvent("livesdk_vmsdk_init_time", r106, r108, null);
        return;
    }

    public static void a(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        if (r100 == null) goto L5;
        r105.put("init_script_error", r100);
    L5:
        if (r101 == null) goto L7;
        r105.put("script_error", r101);
    L7:
        if (r102 == null) goto L9;
        r105.put("script_exce_error", r102);
    L9:
        if (r103 == null) goto L11;
        r105.put("scene", r103);
    L11:
        if (r104 == null) goto L13;
        r105.put(MapMonitorConst.ERROR_INFO, r104);
    L13:
        int r106 = ECSdk.f48106a;
        b r107 = (b) ECSdk.a(b.class);
        if (r107 != null) goto L16;
        return;
    L16:
        if (r105.length() > 0) goto L19;
        r105 = null;
    L19:
        r107.monitorEvent("livesdk_vmsdk_init_error", null, null, r105);
    }
}
