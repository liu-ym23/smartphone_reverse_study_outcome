package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.monitorV2.hybridSetting.k;
import com.bytedance.android.monitorV2.settings.e;
import com.bytedance.android.monitorV2.settings.g;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.util.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import fz2.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class NativeCommon extends a {
    public long attachTs;
    public long clickStart;
    public long containerInitTs;
    public Boolean containerReuse;
    public String containerType;
    public JSONObject context;
    public JSONObject debugContext;
    public long detachTs;
    public String nativePage;
    public String navigationId;
    public String url;
    public String virtualAid;

    private boolean useVirtualAid() {
        k.a r100 = k.f163106a;     // Catch: Throwable -> L10
        g r101 = k.f163107b;     // Catch: Throwable -> L10
        if (r101 != null) goto L5;
        return true;
    L5:
        if (r101.a(e.class) == null) goto L13;
        return ((e) k.f163107b.a(e.class)).d();
    L13:
        return true;
    L14:
        return true;
    }

    public NativeCommon() {
        this.url = null;
        this.navigationId = v.a();
        this.containerType = null;
        this.nativePage = null;
        this.clickStart = 0;
        this.debugContext = new JSONObject();
    }

    public void addContext(JSONObject r100) {
        if (this.context != null) goto L5;
        this.context = new JSONObject();
    L5:
        l.a(this.context, r100);
    }

    @Override // fz2.a
    public void fillInJsonObject(JSONObject r100) {
        l.q(r100, "navigation_id", this.navigationId);
        l.q(r100, "url", this.url);
        l.q(r100, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, this.containerType);
        l.q(r100, "native_page", this.nativePage);
        l.q(r100, "sdk_version", "10.4.0");
        if (useVirtualAid() == false) goto L5;
        l.q(r100, "virtual_aid", this.virtualAid);
    L5:
        l.p(r100, PerfLog.PARAM_KEY_CONTEXT_ID, this.context);
        l.q(r100, "sdk_version", "10.4.0");
        l.p(r100, "debug_context", this.debugContext);
        long r101 = this.containerInitTs;
        if (r101 == 0) goto L8;
        l.o(r100, "container_init_ts", r101);
    L8:
        Boolean r102 = this.containerReuse;
        if (r102 == null) goto L11;
        l.p(r100, "container_reuse", r102);
    L11:
        l.q(this.debugContext, "monitor_package", "monitorV2");
    }

    public NativeCommon(String r100, String r101) {
        this.url = null;
        this.navigationId = v.a();
        this.containerType = null;
        this.nativePage = null;
        this.clickStart = 0;
        this.debugContext = new JSONObject();
        this.url = r100;
        this.containerType = r101;
    }

    public void addContext(String r100, Object r101) {
        if (this.context != null) goto L5;
        this.context = new JSONObject();
    L5:
        l.q(this.context, r100, String.valueOf(r101));
    }
}
