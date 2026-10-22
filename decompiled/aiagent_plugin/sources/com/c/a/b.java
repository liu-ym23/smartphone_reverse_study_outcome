package com.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.apm.c;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.e;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.g;
import com.bytedance.services.apm.api.m;
import com.bytedance.services.slardar.config.IConfigManager;
import com.c.a.b.f;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CloudMessageWidget.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends e implements com.bytedance.services.slardar.config.b, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.c.a.a.a f11888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f11890d;

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.j
    public boolean isOnlyMainProcess() {
        return true;
    }

    public b() {
        this.f11889c = false;
        this.f11890d = Arrays.asList(new String[]{"timer", "count", "disk", "memory", MonitorConstants.CPU, "fps", "traffic", "start", "page_load", "image_monitor", "api_all", "api_error", "common_log", "service_monitor", "performance_monitor", "ui_action"});
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.j
    public void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super.init(r4);
        this.f11887a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        a.a(r4);
        ((IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin")).registerResponseConfigListener(this);
        a.a(this);
        ActivityLifeObserver.getInstance().register(this);
        registerConfigService();
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.j
    public void start() {
        super.start();
    }

    @Override // com.bytedance.apm.e
    public void stop() {
        super.stop();
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.slardar.config.a
    public void onReady() {
        super.onReady();
        if (this.f11889c == false) goto L5;
        return;
    L5:
        this.f11889c = true;
        if (getServiceSwitch("close_cloud_request") == false) goto L8;
        return;
    L8:
        if (c.d() == false) goto L12;
        this.f11888b = new com.c.a.a.a();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ZeusTransformUtils.registerReceiver(this.f11887a, this.f11888b, r0, "com.obric.aiagent.plugin");
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this));
        return;
    }

    @Override // com.bytedance.apm.e
    public void destroy() {
        super.destroy();
        com.c.a.a.a r0 = this.f11888b;     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        ZeusTransformUtils.unregisterReceiver(this.f11887a, r0, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    @Override // com.bytedance.services.apm.api.j
    public void notifyParams(m r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (com.bytedance.common.utility.collection.a.a(r4.a()) == false) goto L11;
        return;
    L11:
        URL r0 = new URL((String) ZeusTransformUtils.preCheckCast(r4.a().get(0), String.class, "com.obric.aiagent.plugin"));     // Catch: MalformedURLException -> L8
        com.c.a.h.c.a.f11944a = String.format("%s://%s/%s", new Object[]{r0.getProtocol(), r0.getHost(), "monitor/collect/c/cloudcontrol/file"});     // Catch: MalformedURLException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.apm.e
    public String getTag() {
        return b.class.getSimpleName();
    }

    @Override // com.bytedance.services.slardar.config.b
    public void a(JSONObject r3) {
        if (a.b() == true) goto L10;
        JSONArray r2 = r3.optJSONArray("cloud_commands");
        if (r2 == null) goto L12;
        int r4 = 0;
    L8:
        if (r4 >= r2.length()) goto L13;
        String r0 = r2.optString(r4);
        a.a().a(r0);
        r4 = r4 + 1;
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // com.c.a.b.f
    public String[] b(JSONObject r5) {
        JSONArray r6 = r5.optJSONArray("upload_type");
        int r0 = 0;
        if (r6 != null) goto L9;
        String[] r7 = new String[this.f11890d.size()];
    L6:
        if (r0 >= this.f11890d.size()) goto L8;
        r7[r0] = (String) ZeusTransformUtils.preCheckCast(this.f11890d.get(r0), String.class, "com.obric.aiagent.plugin");
        r0 = r0 + 1;
        goto L6
    L8:
        return r7;
    L9:
        String[] r4 = new String[r6.length()];
    L11:
        if (r0 >= r6.length()) goto L13;
        r4[r0] = r6.optString(r0);
        r0 = r0 + 1;
        goto L11
    L13:
        return r4;
    }

    @Override // com.c.a.b.f
    public void a(long r9, long r11, String r13, g r14) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r14, g.class, "com.obric.aiagent.plugin");
        ((IMonitorLogManager) ZeusTransformUtils.preCheckCast(d.a(IMonitorLogManager.class), IMonitorLogManager.class, "com.obric.aiagent.plugin")).getLegacyLog(r9 * 1000, r11 * 1000, r13, r7);
    }

    @Override // com.c.a.b.f
    public void a(String r3, String r4) {
        ((IMonitorLogManager) ZeusTransformUtils.preCheckCast(d.a(IMonitorLogManager.class), IMonitorLogManager.class, "com.obric.aiagent.plugin")).deleteLegacyLogByIds(r3, r4);
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.d
    public void onBackground(Activity r4) {
        super.onBackground((Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin"));
        if (getServiceSwitch("close_cloud_request") == false) goto L5;
        return;
    L5:
        if (c.d() == false) goto L9;
        com.bytedance.apm.thread.b.a().a(new AnonymousClass2(this), 2000);
        return;
    }
}
