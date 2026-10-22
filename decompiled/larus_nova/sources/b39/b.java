package b39;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.applog.api.IApplog;
import com.larus.deeplink.api.IDeeplinkService;
import com.larus.push.api.IPushService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17386a = 0;

    static {
    }

    public static String a(Uri r100) {
        IDeeplinkService r101 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);
        if (r101 != null) goto L5;
    L13:
        return "";
    L5:
        if (r101.k(r100) == false) goto L8;
        return "push";
    L8:
        if (r101.a(r100) == false) goto L11;
        return "bot_share";
    L11:
        if (r101.g(r100) == false) goto L13;
        return "outer_schema";
    }

    public static void b(Uri r100) {
        String r101 = a(r100);
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        IApplog.Companion r104 = IApplog.f287053a;
        JSONObject r105 = new JSONObject();
        r105.put("source_type", r101);
        r105.put("absolute_schema", String.valueOf(r100));
        r105.put("handle_status", "fail");
        r105.put("fail_reason", "block");
        Set<String> r106 = null;
        if (r100 == null) goto L11;
        String r107 = r100.getHost();
    L12:
        r105.put("schema_host", r107);
        if (r100 == null) goto L15;
        String r108 = r100.getPath();
    L16:
        r105.put("schema_path", r108);
        if (r100 == null) goto L19;
        r106 = UriProtector.getQueryParameterNames(r100);
    L19:
        r105.put("schema_queries", String.valueOf(r106));
        Unit r109 = Unit.INSTANCE;
        r104.reportEvent("rd_external_schema_did_handle", r105);
        IDeeplinkService r110 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);
        if (r110 != null) goto L22;
    L24:
        if (r102 == false) goto L29;
        IPushService r111 = (IPushService) ServiceManager.get().getService(IPushService.class);
        if (r111 == null) goto L30;
        r111.g(String.valueOf(r100), "block");
        return;
    L30:
        return;
    L29:
        return;
    L22:
        if (r110.k(r100) != true) goto L24;
        r102 = true;
        goto L24
    L15:
        r108 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    public static void c(Uri r100) {
        String r101 = a(r100);
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        IApplog.Companion r104 = IApplog.f287053a;
        JSONObject r105 = new JSONObject();
        r105.put("source_type", r101);
        r105.put("absolute_schema", String.valueOf(r100));
        r105.put("handle_status", "success");
        Set<String> r106 = null;
        if (r100 == null) goto L11;
        String r107 = r100.getHost();
    L12:
        r105.put("schema_host", r107);
        if (r100 == null) goto L15;
        String r108 = r100.getPath();
    L16:
        r105.put("schema_path", r108);
        if (r100 == null) goto L19;
        r106 = UriProtector.getQueryParameterNames(r100);
    L19:
        r105.put("schema_queries", String.valueOf(r106));
        Unit r109 = Unit.INSTANCE;
        r104.reportEvent("rd_external_schema_did_handle", r105);
        IDeeplinkService r110 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);
        if (r110 != null) goto L22;
    L24:
        if (r102 == false) goto L29;
        IPushService r111 = (IPushService) ServiceManager.get().getService(IPushService.class);
        if (r111 == null) goto L30;
        r111.f(String.valueOf(r100));
        return;
    L30:
        return;
    L29:
        return;
    L22:
        if (r110.k(r100) != true) goto L24;
        r102 = true;
        goto L24
    L15:
        r108 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    L5:
        r103 = false;
        goto L6
    }
}
