package com.bytedance.apm.config;

import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.util.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private j mSlardarConfigFetcher;

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        j r100 = this.mSlardarConfigFetcher;
        boolean r101 = r100.k();
        if (com.bytedance.apm.d.k() == true) goto L5;
        return;
    L5:
        if (r100.f190501l <= System.currentTimeMillis()) goto L7;
        r101 = true;
    L7:
        r100.h(r101);
    }

    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.f190499j;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.f190490a;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        j r100 = this.mSlardarConfigFetcher;
        if (r100.f190497h != null) goto L14;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r100.f190497h != null) goto L8;
        r100.f190497h = gs3.e.b(com.bytedance.apm.d.getContext(), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
    L14:
        return r100.f190497h.getString("monitor_net_config", "");
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject retrieveSettingsParams() {
        return this.mSlardarConfigFetcher.i();
    }

    public SlardarConfigManagerImpl() {
        this.mSlardarConfigFetcher = new j();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject getConfigJSON(String r100) {
        j r101 = this.mSlardarConfigFetcher;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L9;
        JSONObject r102 = r101.f190499j;
        if (r102 == null) goto L9;
        return r102.optJSONObject(r100);
    L9:
        return new JSONObject();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r100) {
        j r101 = this.mSlardarConfigFetcher;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r100, "block_monitor") == false) goto L9;
        r100 = "caton_monitor";
    L9:
        if (TextUtils.equals(r100, "core_exception_monitor") == false) goto L12;
        return r101.f190491b;
    L12:
        if (r101.f190492c != null) goto L15;
        return false;
    L15:
        if (r101.f190492c.optInt(r100) != 1) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r100) {
        j r101 = this.mSlardarConfigFetcher;
        if (r101.f190493d != null) goto L5;
    L10:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101.f190493d.optInt(r100) != 1) goto L10;
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r100) {
        j r101 = this.mSlardarConfigFetcher;
        if (r101.f190494e != null) goto L5;
    L10:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101.f190494e.optInt(r100) != 1) goto L10;
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r100) {
        j r101 = this.mSlardarConfigFetcher;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L8;
        JSONObject r102 = r101.f190499j;
        if (r102 == null) goto L8;
        return r102.optBoolean(r100);
    L8:
        return false;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(IConfigListener r100) {
        j r101 = this.mSlardarConfigFetcher;
        if (r100 != null) goto L6;
        r101.getClass();
        return;
    L6:
        if (r101.f190509t != null) goto L9;
        r101.f190509t = new CopyOnWriteArrayList();
    L9:
        if (((CopyOnWriteArrayList) r101.f190509t).contains(r100) == true) goto L12;
        ((CopyOnWriteArrayList) r101.f190509t).add(r100);
    L12:
        if (com.bytedance.apm.d.j() == false) goto L15;
        ps3.b.a(new String[]{"addConfigListener, mReady=" + r101.f190490a});
    L15:
        if (r101.f190490a == false) goto L19;
        r100.onRefresh(r101.f190499j, r101.f190500k);
        r100.onReady();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(IResponseConfigListener r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (it3.c.f495718a != null) goto L8;
        it3.c.f495718a = new CopyOnWriteArrayList();
    L8:
        if (((CopyOnWriteArrayList) it3.c.f495718a).contains(r100) == true) goto L11;
        ((CopyOnWriteArrayList) it3.c.f495718a).add(r100);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(IConfigListener r100) {
        j r101 = this.mSlardarConfigFetcher;
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        List<IConfigListener> r102 = r101.f190509t;
        if (r102 == null) goto L10;
        ((CopyOnWriteArrayList) r102).remove(r100);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(IResponseConfigListener r100) {
        if (r100 == null) goto L9;
        List<IResponseConfigListener> r101 = it3.c.f495718a;
        if (r101 == null) goto L8;
        ((CopyOnWriteArrayList) r101).remove(r100);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean updateWithSpecificAidResult(JSONObject r100) {
        return this.mSlardarConfigFetcher.l(r100);
    }

    public void forceUpdateFromRemote(gs3.d r100, List<String> r101) {
        j r102 = this.mSlardarConfigFetcher;
        r102.k();
        if (r100 == null) goto L6;
        r102.f190498i = r100;
    L6:
        if (k.b(r101) == true) goto L8;
        r102.f190495f = new ArrayList(r101);
    L8:
        r102.h(true);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r100, int r101) {
        j r102 = this.mSlardarConfigFetcher;
        r102.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L9;
        JSONObject r103 = r102.f190499j;
        if (r103 != null) goto L8;
        return r101;
    L8:
        return r103.optInt(r100, r101);
    L9:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.ArrayList] */
    public void initParams(boolean r100, gs3.d r101, List<String> r102) {
        j r103 = this.mSlardarConfigFetcher;
        r103.f190505p = r100;
        r103.f190506q = com.bytedance.apm.d.k();
        if (r103.f190497h != null) goto L13;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r103.f190497h != null) goto L8;
        r103.f190497h = gs3.e.b(com.bytedance.apm.d.getContext(), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
    L13:
        r103.f190498i = r101;
        boolean r104 = false;
        if (k.b(r102) == true) goto L28;
        if (k.b(r102) == true) goto L25;
        ?? r105 = new ArrayList(2);     // Catch: MalformedURLException -> L46
        int r106 = r102.size();     // Catch: MalformedURLException -> L46
        int r107 = 0;
    L18:
        if (r107 >= r106) goto L26;
        String r108 = new URL((String) ListProtector.get(r102, r107)).getHost();     // Catch: MalformedURLException -> L46
        if (TextUtils.isEmpty(r108) == true) goto L24;
        if (r108.indexOf(46) <= 0) goto L24;
        r105.add("https://" + r108 + "/monitor/appmonitor/v5/batch_settings");     // Catch: MalformedURLException -> L46
    L24:
        r107 = r107 + 1;
    L26:
        r103.f190495f = r105;
    L25:
        r105 = Collections.emptyList();
    L28:
        if (r103.f190504o == true) goto L59;
        r103.f190504o = true;
        if (r103.f190506q == false) goto L32;
    L33:
        r104 = true;
    L34:
        if (r104 == false) goto L36;
        bt3.b.d.f20539a.a(r103);
    L36:
        IntentFilter r109 = new IntentFilter();
        r109.addAction("com.apm.setting.update.action");
        g r110 = new g(r103);
        if (com.bytedance.apm.d.getContext() == null) goto L60;
    L43:
        th = move-exception;
        av3.b.c("SlardarConfigFetcher", "registerBroadUpdateSetting", th);
        return;
    L39:
        if (Build.VERSION.SDK_INT <= 33) goto L41;
        j.a(com.bytedance.apm.d.getContext(), r110, r109);     // Catch: Throwable -> L43
    L47:
        return;
    L41:
        j.b(com.bytedance.apm.d.getContext(), r110, r109);     // Catch: Throwable -> L43
        goto L47
    L60:
        return;
    L32:
        if (r103.f190505p == false) goto L34;
    }
}
