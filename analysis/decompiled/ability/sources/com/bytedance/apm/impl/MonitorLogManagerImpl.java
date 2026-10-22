package com.bytedance.apm.impl;

import B.d;
import H.h;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import m0.C1667a;
import m0.C1669c;
import org.json.JSONArray;
import org.json.JSONObject;
import v1.AbstractC2055a;
import v1.b;
import x1.a;

/* loaded from: classes2.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    @Nullable
    private static a getLogStoreByType(String str) {
        return TextUtils.equals(str, "network") ? (a) ((HashMap) b.f6765a.b).get(C1667a.class) : (a) ((HashMap) b.f6765a.b).get(C1669c.class);
    }

    private static String packLog(JSONArray jSONArray, long j5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SettingsConfig.KEY_DATA, jSONArray);
            JSONObject jSONObjectD = h.d();
            if (jSONObjectD == null) {
                return "";
            }
            JSONObject jSONObject2 = new JSONObject(jSONObjectD.toString());
            S0.b.V(jSONObject2, AbstractC2055a.f6764a.a(j5));
            jSONObject2.put("debug_fetch", 1);
            jSONObject.put("header", jSONObject2);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String str, String str2) {
        a logStoreByType = getLogStoreByType(str);
        if (logStoreByType != null) {
            logStoreByType.k(str2);
        }
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long j5, long j6, String str, d dVar) {
        List<C1669c> listE;
        if (dVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        a logStoreByType = getLogStoreByType(str);
        if (logStoreByType == null) {
            dVar.a();
            return;
        }
        synchronized (logStoreByType) {
            if (TextUtils.isEmpty(str)) {
                listE = Collections.EMPTY_LIST;
            } else {
                try {
                    String[] strArr = {String.valueOf(j5), String.valueOf(j6), str};
                    String[] strArrSplit = "0,100".split(",");
                    listE = logStoreByType.e("timestamp >= ? AND timestamp <= ?  AND type2 = ? ", strArr, "_id ASC " + (strArrSplit.length == 2 ? " LIMIT " + strArrSplit[1] + " OFFSET " + strArrSplit[0] : ""), logStoreByType);
                } catch (Throwable unused) {
                    listE = Collections.EMPTY_LIST;
                }
            }
        }
        if (S0.b.a0(listE)) {
            dVar.a();
            return;
        }
        JSONArray jSONArray = new JSONArray();
        LinkedList linkedList = new LinkedList();
        long j10 = -1;
        for (C1669c c1669c : listE) {
            try {
                if (j10 == -1) {
                    j10 = c1669c.e;
                } else if (c1669c.e != j10) {
                    break;
                }
                jSONArray.put(c1669c.d);
                linkedList.add(Long.valueOf(c1669c.f5294a));
            } catch (Exception unused2) {
            }
        }
        packLog(jSONArray, j10);
        S0.b.o(",", linkedList);
        dVar.a();
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return (LinkedList) ((B1.b) Q.a.a().b).c;
    }
}
