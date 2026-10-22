package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import com.heytap.mcssdk.constant.b;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile DowngradeInfo f190731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qt3.a f190732b;

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.send.downgrade.a$a, reason: collision with other inner class name */
    public static class C2766a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f190733a = null;

        static {
            f190733a = new a();
        }
    }

    public a() {
    }

    public final void a(Context r100) {
        qt3.a r101 = new qt3.a(r100);
        this.f190732b = r101;
        DowngradeInfo r102 = null;
        String r103 = r101.f534783a.getString(b.f276366p, null);
        if (r103 != null) goto L15;
    L13:
        b(r102, false);
        return;
    L15:
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L5:
        if (xu3.a.a() == false) goto L7;
        av3.b.d("APM-Downgrade", "DowngradeData-load-".concat(r103));     // Catch: JSONException -> L11
    L7:
        DowngradeInfo r104 = DowngradeInfo.a(new JSONObject(r103));     // Catch: JSONException -> L11
        if (System.currentTimeMillis() >= r104.f190726a) goto L13;
        r102 = r104;
        goto L13
    }

    public final void b(DowngradeInfo r100, boolean r101) {
        if (r100 == null) goto L25;
        monitor-enter(this);
        this.f190731a = r100;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (r101 == false) goto L32;
        qt3.a r102 = this.f190732b;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.f534783a == null) goto L34;
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L16
        r103.put("expire_time", r100.f190726a);     // Catch: JSONException -> L16
        Iterator r104 = ((HashMap) r100.f190727b).entrySet().iterator();     // Catch: JSONException -> L16
    L13:
        if (r104.hasNext() == false) goto L17;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: JSONException -> L16
        r103.put(((DowngradeInfo.LogType) r105.getKey()).logType, ((DowngradeInfo.a) r105.getValue()).b());     // Catch: JSONException -> L16
    L17:
        if (r103 == null) goto L35;
        String r106 = r103.toString();
        if (xu3.a.a() == false) goto L21;
        av3.b.d("APM-Downgrade", "DowngradeData-save-" + r106);
    L21:
        r102.f534783a.edit().putString(b.f276366p, r103.toString()).apply();
        return;
    L35:
        return;
    L16:
        r103 = null;
        goto L17
    L34:
        return;
    L32:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final boolean c(JSONObject r100, int r101) {
        boolean r102 = true;
        if (this.f190731a != null) goto L5;
    L46:
        return true;
    L5:
        if (System.currentTimeMillis() > this.f190731a.f190726a) goto L46;
        String r103 = String.valueOf(r101);
        String r104 = r100.optString(FrescoMonitorConst.LOG_TYPE);
        monitor-enter(this);
        DowngradeInfo.LogType r105 = DowngradeInfo.LogType.SERVICE_MONITOR;     // Catch: Throwable -> L43
        if (r105.logType.equals(r104) == false) goto L26;
        String r106 = r100.optString("service");     // Catch: Throwable -> L43
        DowngradeInfo.a r107 = (DowngradeInfo.a) ((HashMap) this.f190731a.f190727b).get(r105);     // Catch: Throwable -> L43
        if (r107 == null) goto L41;
        JSONObject r108 = (JSONObject) ((HashMap) r107.f190730b).get(r103);     // Catch: Throwable -> L43
        if (r108 != null) goto L16;
    L23:
        boolean r109 = r107.f190729a;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r109;
    L16:
        if (r108.optInt(r106, -1) == (-1)) goto L23;
        if (r108.optInt(r106, -1) == 1) goto L21;
        r102 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r102;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L43
        return true;
    L26:
        Map<DowngradeInfo.LogType, DowngradeInfo.a> r110 = this.f190731a.f190727b;     // Catch: Throwable -> L43
        HashMap r111 = (HashMap) r110;     // Catch: Throwable -> L43
        DowngradeInfo.a r112 = (DowngradeInfo.a) r111.get(DowngradeInfo.LogType.OTHER_LOG_TYPE);     // Catch: Throwable -> L43
        if (r112 == null) goto L41;
        JSONObject r113 = (JSONObject) ((HashMap) r112.f190730b).get(r103);     // Catch: Throwable -> L43
        if (r113 != null) goto L31;
    L38:
        boolean r114 = r112.f190729a;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r114;
    L31:
        if (r113.optInt(r104, -1) == (-1)) goto L38;
        if (r113.optInt(r104, -1) == 1) goto L36;
        r102 = false;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r102;
    L43:
        th = move-exception;
        throw th;
    }
}
