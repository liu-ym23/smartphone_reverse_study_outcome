package f3;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.util.ListUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h implements SlardarHandlerConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f19463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f19464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f19465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f19466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f19467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f19468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile o2.a f19469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f19470k;

    public class a implements IConfigChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f19471a;

        public a(h r10) {
            this.f19471a = r10;
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            h.a(this.f19471a, r10, r11);
        }
    }

    public h(JSONObject r10) {
        this.f19460a = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT;
        this.f19461b = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_ENCRYPT;
        this.f19462c = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS;
        this.f19463d = "apm6_once_max_size_kb";
        this.f19464e = "apm6_uploading_interval";
        this.f19465f = "enable_report_internal_exception";
        this.f19466g = SlardarSettingsConsts.LOG_RESERVE_DAYS;
        this.f19467h = SlardarSettingsConsts.LOG_MAX_SIZE_MB;
        this.f19468i = "compress_type";
        this.f19470k = r10;
        b();
    }

    public static /* synthetic */ void a(h r10, JSONObject r11, boolean r12) {
        r10.c(r11, r12);
    }

    public static List d(JSONArray r10) {
        if (r10 == null) goto L23;
    L14:
        e = move-exception;
        s3.a.c("APM-Setting", "parse setting host malformedurl exception", e);
    L16:
        e = move-exception;
        s3.a.c("APM-Setting", "parse setting host json exception", e);
        goto L23
    L5:
        if (r10.length() <= 0) goto L23;
        ArrayList r11 = new ArrayList(2);     // Catch: MalformedURLException -> L14 JSONException -> L16
        int r12 = r10.length();     // Catch: MalformedURLException -> L14 JSONException -> L16
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L19;
        String r14 = new URL(r10.getString(r13)).getHost();     // Catch: MalformedURLException -> L14 JSONException -> L16
        if (TextUtils.isEmpty(r14) == true) goto L18;
        if (r14.indexOf(46) <= 0) goto L18;
        r11.add(r14);     // Catch: MalformedURLException -> L14 JSONException -> L16
    L18:
        r13 = r13 + 1;
        goto L7
    L19:
        return r11;
    L23:
        return Collections.emptyList();
    }

    public final void b() {
        g3.a.g().h();
        g3.a.g().k(new a(this));
    }

    public final void c(JSONObject r14, boolean r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        JSONObject r16 = r3.e.h(r14, "general", "slardar_api_settings", this.f19460a);
        if (r16 != null) goto L7;
        return;
    L7:
        List r10 = d(r16.optJSONArray(this.f19462c));
        ArrayList r11 = new ArrayList();
        String r12 = null;
        if (ListUtils.b(r10) == true) goto L17;
        Iterator r13 = r10.iterator();
        String r17 = null;
    L11:
        if (r13.hasNext() == false) goto L18;
        String r18 = (String) r13.next();
        r11.add("https://" + r18 + "/monitor/collect/batch/");
        if (r12 != null) goto L15;
        r12 = "https://" + r18 + "/monitor/collect/c/exception";
    L15:
        if (r17 != null) goto L11;
        r17 = "https://" + r18 + "/monitor/collect/c/trace_collect";
    L18:
        boolean r19 = true;
        boolean r20 = r16.optBoolean(this.f19461b, true);
        long r21 = r16.optLong(this.f19463d, -1) * 1024;
        long r22 = r16.optLong(this.f19464e, -1) * 1000;
        if (r3.e.f(r14, "general", this.f19465f) == 1) goto L22;
        r19 = false;
    L22:
        o2.a r23 = new o2.a();
        r23.s(r11);
        r23.m(r12);
        r23.t(r17);
        r23.q(r21);
        r23.l(r20);
        r23.r(r22);
        r23.u(r19);
        JSONObject r24 = this.f19470k;
        if (r24 == null) goto L25;
        r23.p(r24.optInt(CommonKey.OUTSIDE_MAX_SIZE_MB_TODAY, -1));
    L25:
        r23.k(r16.optInt(this.f19468i, 2));
        JSONObject r110 = r14.optJSONObject("general");
        if (r110 == null) goto L30;
        JSONObject r111 = r110.optJSONObject("cleanup");
        if (r111 == null) goto L30;
        r23.o(r111.optInt(this.f19467h, 80));
        r23.n(r111.optInt(this.f19466g, 5));
    L30:
        this.f19469j = r23;
        if (r3.a.c() == false) goto L33;
        s3.a.a(ConfigConstants.LOG_TAG, "received reportSetting=" + r16);
        s3.a.a(ConfigConstants.LOG_TAG, "parsed SlardarHandlerConfig=" + this.f19469j);
    L33:
        e3.a.h(r19);
        e3.a.i(r12);
        n2.e.c().f(getConfig());
        return;
    L17:
        r17 = null;
        goto L18
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public o2.a getConfig() {
        return this.f19469j;
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public void setOutsideConfig(JSONObject r10) {
        this.f19470k = r10;
    }
}
