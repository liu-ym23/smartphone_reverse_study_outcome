package ci7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.applog.AppLog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f23883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f23884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f23885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f23886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ v f23887e;

    public final void a() {
        String r100 = this.f23883a;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = "unknown";
    L5:
        v r101 = this.f23887e;
        Uri r102 = this.f23884b;
        String r103 = this.f23885c;
        Map r104 = this.f23886d;
        r101.getClass();
        JSONObject r105 = new JSONObject();
        r105.put(AppConstants.BUNDLE_GD_LABEL, r100);     // Catch: JSONException -> L27
        if (r102 == null) goto L9;
        r105.put("scheme", r102.toString());     // Catch: JSONException -> L27
    L10:
        r105.put(SoloKtvContext.SOLO_PAGE_ENTRANCE, r103);     // Catch: JSONException -> L27
        r105.put("code_launch_mode", r101.f23888a);     // Catch: JSONException -> L27
        if (r104 != null) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == false) goto L29;
        Iterator r107 = r104.entrySet().iterator();     // Catch: JSONException -> L27
    L18:
        if (r107.hasNext() == false) goto L29;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: JSONException -> L27
        if (r108 == null) goto L18;
        if (TextUtils.isEmpty((CharSequence) r108.getKey()) == true) goto L18;
        r105.put((String) r108.getKey(), r108.getValue());     // Catch: JSONException -> L27
    L29:
        mi7.e.c("LaunchLogManager", "reportLaunchLogEvent, gd_label = " + r100 + ", scheme = " + r105.opt("scheme") + ", entrance = " + r103 + ", code_launch_mode = " + r101.f23888a);
        if (mi7.c.a("launch_log", r105) == true) goto L49;
        jta.g.d();     // Catch: NoClassDefFoundError -> L33
        AppLogNewUtils.onEventV3("launch_log", r105);     // Catch: NoClassDefFoundError -> L33
        return;
    L33:
        AppLog.getDid();     // Catch: NoClassDefFoundError -> L35
        AppLog.onEventV3("launch_log", r105);     // Catch: NoClassDefFoundError -> L35
        return;
    L51:
        return;
    L49:
        return;
    L13:
        if (r104.size() <= 0) goto L15;
        r106 = true;
        goto L16
    L9:
        r105.put("scheme", "");     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        mi7.e.d(6, "LaunchLogManager", "reportLaunchLogEvent json exception : " + e.getMessage(), e);
        goto L29
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public u(String r100, Uri r101, String r102) {
        this.f23887e = v.a.f23889a;
        this.f23883a = r100;
        this.f23884b = r101;
        this.f23885c = r102;
        this.f23886d = null;
    }
}
