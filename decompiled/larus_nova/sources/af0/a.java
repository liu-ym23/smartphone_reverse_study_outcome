package af0;

import bb0.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.livesdk.config.tz;
import com.bytedance.android.livesdk.log.j0;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nd0.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3134a = null;

    static {
        f3134a = new a();
    }

    public a() {
    }

    public static /* synthetic */ void m(LinkMonitorData r100) {
        l(r100, new JSONObject());
    }

    @JvmStatic
    public static final void l(LinkMonitorData r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "extra");
        c.p(c.f518746a, r110, r111, MultiLinkEventModule.HAMLET_AVATAR, 0, null, false, null, 120);
        String r100 = "businessName:" + r110.getEventTypeValue() + ", extra:" + r111;
        ALogger.i(b.b(), "HamletAvatarFullMonitor :" + r100 + ", invoke class :" + a.class.getSimpleName());
        if (tz.f121336a.getValue().booleanValue() == false) goto L19;
        j0 r101 = j0.l();
        String r112 = r110.getEventTypeValue();
        Intrinsics.checkNotNullParameter(r111, "$this$toAnyMap");
        HashMap r102 = new HashMap();
        Iterator<String> r103 = r111.keys();
    L6:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next();
        Object r105 = r111.get(r104);
        if ((r105 instanceof String) == true) goto L9;
        r102.put(r104, r105.toString());
        goto L6
    L9:
        r102.put(r104, r105);
        goto L6
    L11:
        r101.sendLog(r112, r102, new Object[0]);
        return;
    }
}
