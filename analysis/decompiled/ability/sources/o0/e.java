package o0;

import F.g;
import H.h;
import Z6.k;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.apm.insight.MonitorCrash;
import com.bytedance.apm.insight.ApmInsight;
import com.bytedance.apm.insight.ApmInsightInitConfig;
import com.bytedance.apm.insight.IDynamicParams;
import e2.C1404a;
import e2.C1406c;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ApmInsightInitConfig f5414a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ IDynamicParams c;
    public final /* synthetic */ ApmInsight d;

    public e(ApmInsight apmInsight, ApmInsightInitConfig apmInsightInitConfig, Context context, IDynamicParams iDynamicParams) {
        this.d = apmInsight;
        this.f5414a = apmInsightInitConfig;
        this.b = context;
        this.c = iDynamicParams;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext;
        ApplicationInfo applicationInfo;
        int i;
        Context context = this.b;
        boolean zIsEmpty = TextUtils.isEmpty(h.f713q);
        ApmInsightInitConfig apmInsightInitConfig = this.f5414a;
        if ((zIsEmpty || apmInsightInitConfig.isDebug()) && h.g()) {
            ApmInsight apmInsight = this.d;
            if (apmInsight.c) {
                return;
            }
            apmInsight.c = true;
            try {
                applicationContext = context.getApplicationContext();
                try {
                    applicationInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).applicationInfo;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            String string = (applicationInfo == null || (i = applicationInfo.labelRes) <= 0) ? "" : applicationContext.getString(i);
            MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(context, MonitorCrash.Config.sdk("240734").token("aa77e9b33b8b45a3ab7c8efb94728a31").versionCode(1050451L).versionName("1.5.4.cn-rc.1").channel("apm_insight").keyWords(ApmInsight.sPackage).dynamicParams(new d(this)).customData(new c()).build());
            monitorCrashInitSDK.addTags("host_appid", apmInsightInitConfig.getAid());
            monitorCrashInitSDK.addTags("app_display_name", string);
            monitorCrashInitSDK.addTags("sdk_version_name", "1.5.4.cn-rc.1");
            h.y = monitorCrashInitSDK;
            C1406c c1406c = new C1406c("240734", "aa77e9b33b8b45a3ab7c8efb94728a31", "apm_insight");
            IDynamicParams iDynamicParams = this.c;
            if (iDynamicParams != null && !TextUtils.isEmpty(iDynamicParams.getDid())) {
                c1406c.l = iDynamicParams.getDid();
            }
            if (!TextUtils.isEmpty(h.f713q)) {
                monitorCrashInitSDK.setReportUrl(k.f + h.f713q);
                g gVar = new g(6);
                StringBuilder sb = new StringBuilder();
                sb.append(k.f);
                gVar.b = B7.a.q(sb, h.f713q, "/apm/device_register");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(k.f);
                gVar.c = new String[]{B7.a.q(sb2, h.f713q, "/monitor/collect/c/session")};
                c1406c.f = new A5.c(gVar);
            }
            HashMap map = new HashMap();
            StringBuilder sbX = androidx.appfunctions.metadata.a.x(string, "[");
            sbX.append(apmInsightInitConfig.getAid());
            sbX.append("]");
            map.put("host_app_id", sbX.toString());
            map.put("sdk_version", "1.5.4.cn-rc.1");
            c1406c.k = map;
            C1404a.d(context, c1406c, null);
        }
    }
}
