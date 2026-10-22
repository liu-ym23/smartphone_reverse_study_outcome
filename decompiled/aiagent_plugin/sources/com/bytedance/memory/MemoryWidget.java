package com.bytedance.memory;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.e;
import com.bytedance.apm.util.j;
import com.bytedance.memory.b.c;
import com.bytedance.memory.f.a;
import com.bytedance.memory.i.b;
import com.bytedance.services.apm.api.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryWidget extends e {
    public static final String KEY_CLIENT_ANALYZE = "client_analyze";
    public static final String KEY_ENABLE_WIDGET_MEMORY = "enable_widget_memory";
    public static final String KEY_MAX_CAPACITY_ANALYSE = "max_capacity_analyse";
    public static final String KEY_MEMORY_RATE = "rate_memory_occupied";
    public static final String KEY_RUN_STRATEGY = "memory_strategy";
    private Context mAppContext;
    private volatile boolean mCheckedFolder;
    private boolean mClientAnalyze;
    private boolean mEnable;
    private volatile boolean mInitEd;
    private boolean mIsDebug;
    private a mMemoryWidgetConfig;
    private volatile boolean mNeedStop;
    private b mResultListener;
    private JSONObject memory;

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.j
    public boolean isOnlyMainProcess() {
        return false;
    }

    public MemoryWidget(a r2) {
        this.mClientAnalyze = false;
        this.mMemoryWidgetConfig = r2;
    }

    public MemoryWidget(a r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        this.mClientAnalyze = false;
        this.mMemoryWidgetConfig = r3;
        this.mResultListener = r5;
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.j
    public void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super.init(r4);
        this.mAppContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        registerConfigService();
        com.bytedance.memory.a.a.c().a(this.mAppContext);
        com.bytedance.memory.a.a r5 = com.bytedance.memory.a.a.c();
        a r0 = this.mMemoryWidgetConfig;
        if (r0 == null) goto L5;
        String r1 = r0.b();
    L6:
        r5.a(r1);
        com.bytedance.memory.c.b.i();     // Catch: Exception -> L9
        return;
    L9:
        this.mNeedStop = true;
        return;
    L5:
        r1 = "";
        goto L6
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r5, boolean r6) {
        super.onRefresh(r5, r6);
        if (this.mNeedStop == false) goto L5;
        return;
    L5:
        this.mIsDebug = this.mMemoryWidgetConfig.d();
        parseConfig(r5);
        if (ableToInit() == true) goto L8;
    L25:
        c.a("onRefresh run", new Object[0]);
        if (com.bytedance.memory.d.a.d("npth_hprof_close") == true) goto L29;
        com.bytedance.memory.e.b.a().b();
    L29:
        if (this.mCheckedFolder == false) goto L31;
        return;
    L31:
        this.mCheckedFolder = true;
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass2(this), 10000);
        return;
    L8:
        if (this.mInitEd == true) goto L20;
        registerAppLifeCycle();
        int r7 = this.mMemoryWidgetConfig.f();
        JSONObject r1 = this.memory;
        if (r1 == null) goto L17;
        this.mMemoryWidgetConfig.a(r1.optInt(KEY_RUN_STRATEGY, this.mMemoryWidgetConfig.a()));
        r7 = this.memory.optInt(KEY_MEMORY_RATE, this.mMemoryWidgetConfig.f());
        if (this.memory.optInt(KEY_CLIENT_ANALYZE, 0) != 1) goto L14;
        boolean r2 = true;
    L15:
        this.mClientAnalyze = r2;
        this.mMemoryWidgetConfig.a(r2);
        goto L17
    L14:
        r2 = false;
    L17:
        if (this.mMemoryWidgetConfig.a() != 2) goto L19;
        c.a("reach top mode", new Object[0]);
        this.mMemoryWidgetConfig.c(r7);
        a r8 = this.mMemoryWidgetConfig;
        r8.b(getConfigInt(KEY_MAX_CAPACITY_ANALYSE, r8.e()));
    L19:
        com.bytedance.memory.a.a.c().a(this.mAppContext, this.mMemoryWidgetConfig, this.mResultListener);
        c.a("memorywidget is inited", new Object[0]);
        c.a(this.mMemoryWidgetConfig.toString(), new Object[0]);
        this.mInitEd = true;
    L20:
        Handler r9 = new Handler(Looper.getMainLooper());
        Runnable r3 = new AnonymousClass1(this);
        if (com.bytedance.memory.a.a.c().b() == false) goto L23;
        long r4 = 0;
    L24:
        r9.postDelayed(r3, r4);
        goto L25
    L23:
        r4 = 20000;
        goto L24
    }

    private void parseConfig(JSONObject r3) {
        JSONObject r4 = r3.optJSONObject("performance_modules");
        if (r4 == null) goto L11;
        JSONObject r5 = r4.optJSONObject("memory");
        this.memory = r5;
        if (r5 == null) goto L12;
        boolean r1 = false;
        if (r5.optInt(KEY_ENABLE_WIDGET_MEMORY, 0) != 1) goto L9;
        r1 = true;
    L9:
        this.mEnable = r1;
        return;
    L12:
        return;
    }

    private boolean inited() {
        if (this.mInitEd == true) goto L5;
    L7:
        return false;
    L5:
        if (ableToInit() == false) goto L7;
        return true;
    }

    private boolean ableToInit() {
        if (this.mEnable == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsDebug == true) goto L8;
        return false;
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.j
    public void start() {
        super.start();
    }

    @Override // com.bytedance.services.apm.api.j
    public void notifyParams(m r3) {
        if (r3 == null) goto L23;
        List<String> r4 = r3.a();
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.size() <= 0) goto L25;
        List<String> r0 = convertHost(r4, "/monitor/collect/c/memory_upload_check?aid=%d&os=android");
        if (r0 != null) goto L10;
    L12:
        List<String> r1 = convertHost(r4, "/monitor/collect/c/mom_dump_collect");
        if (r1 != null) goto L15;
    L17:
        List<String> r2 = convertHost(r4, "/monitor/collect/c/exception");
        if (r2 != null) goto L20;
        return;
    L20:
        if (r2.size() <= 0) goto L27;
        com.bytedance.memory.h.a.f8830c = r2;
        return;
    L27:
        return;
    L15:
        if (r1.size() <= 0) goto L17;
        com.bytedance.memory.h.a.f8829b = r1;
        goto L17
    L10:
        if (r0.size() <= 0) goto L12;
        com.bytedance.memory.h.a.f8828a = r0;
        goto L12
    L25:
        return;
    }

    private List<String> convertHost(List<String> r7, String r8) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        return Collections.emptyList();
    L4:
        if (j.a(r6) == true) goto L17;
        ArrayList r9 = new ArrayList(2);     // Catch: Exception -> L14
        int r1 = r6.size();     // Catch: Exception -> L14
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        String r3 = new URL((String) ZeusTransformUtils.preCheckCast(r6.get(r2), String.class, "com.obric.aiagent.plugin")).getHost();     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r3) == true) goto L12;
        if (r3.indexOf(46) <= 0) goto L12;
        r9.add("https://" + r3 + r8);     // Catch: Exception -> L14
    L12:
        r2 = r2 + 1;
        goto L6
    L13:
        return r9;
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.d
    public void onFront(Activity r3) {
        super.onFront((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        if (inited() == true) goto L5;
        return;
    L5:
        if (this.mMemoryWidgetConfig.a() != 2) goto L9;
        c.a("onFront", new Object[0]);
        com.bytedance.memory.a.a.c().d();
        return;
    }

    @Override // com.bytedance.apm.e, com.bytedance.services.apm.api.d
    public void onBackground(Activity r3) {
        super.onBackground((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        if (inited() == true) goto L5;
        return;
    L5:
        if (this.mMemoryWidgetConfig.a() != 2) goto L9;
        com.bytedance.memory.i.a.a().b();
        return;
    }
}
