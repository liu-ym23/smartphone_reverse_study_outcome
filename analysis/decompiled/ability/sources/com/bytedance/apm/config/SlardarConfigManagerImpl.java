package com.bytedance.apm.config;

import C.a;
import H.h;
import L.b;
import android.app.Application;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.services.slardar.config.IConfigManager;
import i0.d;
import j0.AbstractC1591a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private d mSlardarConfigFetcher;

    public SlardarConfigManagerImpl() {
        d dVar = new d();
        dVar.b = false;
        dVar.f = AbstractC1591a.b;
        dVar.g = 1200L;
        dVar.l = -1L;
        dVar.m = 15000L;
        dVar.n = -1L;
        dVar.o = false;
        this.mSlardarConfigFetcher = dVar;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        d dVar = this.mSlardarConfigFetcher;
        boolean zG = dVar.g();
        if (h.g()) {
            if (dVar.l > System.currentTimeMillis()) {
                zG = true;
            }
            dVar.c(zG);
        }
    }

    @WorkerThread
    public void forceUpdateFromRemote(@Nullable b bVar, @Nullable List<String> list) {
        d dVar = this.mSlardarConfigFetcher;
        if (dVar.h == null) {
            dVar.h = L.d.a(h.f711a, "monitor_config");
        }
        if (bVar != null) {
            dVar.i = bVar;
        }
        if (!S0.b.a0(list)) {
            dVar.f = new ArrayList(list);
        }
        dVar.c(true);
    }

    @Nullable
    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.f4601j;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String str, int i) {
        JSONObject jSONObject;
        d dVar = this.mSlardarConfigFetcher;
        dVar.getClass();
        return (TextUtils.isEmpty(str) || (jSONObject = dVar.f4601j) == null) ? i : jSONObject.optInt(str, i);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    @Nullable
    public JSONObject getConfigJSON(String str) {
        JSONObject jSONObject;
        d dVar = this.mSlardarConfigFetcher;
        dVar.getClass();
        return (TextUtils.isEmpty(str) || (jSONObject = dVar.f4601j) == null) ? new JSONObject() : jSONObject.optJSONObject(str);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String str) {
        d dVar = this.mSlardarConfigFetcher;
        dVar.getClass();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.equals(str, "block_monitor")) {
            str = "caton_monitor";
        }
        return TextUtils.equals(str, "core_exception_monitor") ? dVar.b : dVar.c != null && dVar.c.optInt(str) == 1;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String str) {
        d dVar = this.mSlardarConfigFetcher;
        return (dVar.d == null || TextUtils.isEmpty(str) || dVar.d.optInt(str) != 1) ? false : true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String str) {
        d dVar = this.mSlardarConfigFetcher;
        return (dVar.e == null || TextUtils.isEmpty(str) || dVar.e.optInt(str) != 1) ? false : true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String str) {
        JSONObject jSONObject;
        d dVar = this.mSlardarConfigFetcher;
        dVar.getClass();
        if (TextUtils.isEmpty(str) || (jSONObject = dVar.f4601j) == null) {
            return false;
        }
        return jSONObject.optBoolean(str);
    }

    public void initParams(boolean z10, b bVar, List<String> list) {
        d dVar = this.mSlardarConfigFetcher;
        dVar.p = z10;
        dVar.f4602q = h.g();
        if (dVar.h == null) {
            dVar.h = L.d.a(h.f711a, "monitor_config");
        }
        dVar.i = bVar;
        if (!S0.b.a0(list)) {
            dVar.f = list;
        }
        if (dVar.o) {
            return;
        }
        dVar.o = true;
        if (dVar.f4602q || dVar.p) {
            L0.d.f925a.a(dVar);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.apm.setting.update.action");
        N5.b bVar2 = new N5.b(dVar, 2);
        try {
            Application application = h.f711a;
            if (application != null) {
                application.registerReceiver(bVar2, intentFilter, 4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.f4600a;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        return this.mSlardarConfigFetcher.h.getString("monitor_net_config", "");
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(a aVar) {
        d dVar = this.mSlardarConfigFetcher;
        dVar.getClass();
        if (aVar == null) {
            return;
        }
        if (dVar.f4603r == null) {
            dVar.f4603r = new CopyOnWriteArrayList();
        }
        if (!dVar.f4603r.contains(aVar)) {
            dVar.f4603r.add(aVar);
        }
        if (dVar.f4600a) {
            aVar.onRefresh(dVar.f4601j, dVar.k);
            aVar.onReady();
        }
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(C.b bVar) {
        if (bVar == null) {
            return;
        }
        if (S0.b.g == null) {
            S0.b.g = new CopyOnWriteArrayList();
        }
        if (S0.b.g.contains(bVar)) {
            return;
        }
        S0.b.g.add(bVar);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(a aVar) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        d dVar = this.mSlardarConfigFetcher;
        dVar.getClass();
        if (aVar == null || (copyOnWriteArrayList = dVar.f4603r) == null) {
            return;
        }
        copyOnWriteArrayList.remove(aVar);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(C.b bVar) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (bVar == null || (copyOnWriteArrayList = S0.b.g) == null) {
            return;
        }
        copyOnWriteArrayList.remove(bVar);
    }
}
