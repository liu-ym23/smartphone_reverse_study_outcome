package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7119b = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7120a;

    static {
    }

    public c(Context r10) {
        this.f7120a = r10;
    }

    public final boolean a(IWsApp r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getChannelId() > 0) goto L9;
        return false;
    L9:
        if (r10.getAppId() > 0) goto L12;
        return false;
    L12:
        if (e.b(r10.getAppKey()) == false) goto L15;
        return false;
    L15:
        if (r10.getAppVersion() > 0) goto L18;
        return false;
    L18:
        if (r10.getConnectUrls().isEmpty() == false) goto L21;
        return false;
    L21:
        if (e.b(r10.getDeviceId()) == false) goto L24;
        return false;
    L24:
        if (r10.getFPID() > 0) goto L27;
        return false;
    L27:
        if (e.b(r10.getInstallId()) == false) goto L30;
        return false;
    L30:
        if (r10.getPlatform() == 0) goto L32;
        return false;
    L32:
        return true;
    }

    public Map b() {
        LinkedHashMap r10 = new LinkedHashMap();
        String r11 = com.bytedance.common.wschannel.b.d(this.f7120a).c();     // Catch: Exception -> L15
        Logger.d(f7119b, "load from sp : " + r11);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r10;
    L6:
        JSONArray r12 = new JSONArray(r11);     // Catch: Exception -> L15
        int r13 = r12.length();     // Catch: Exception -> L15
        if (r13 > 0) goto L9;
        return r10;
    L9:
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L19;
        SsWsApp r15 = new SsWsApp.b().a(r12.optJSONObject(r14));     // Catch: Exception -> L15
        if (a(r15) == false) goto L17;
        r10.put(Integer.valueOf(WsChannelService.b(r15)), r15);     // Catch: Exception -> L15
    L17:
        r14 = r14 + 1;
    L19:
        return r10;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public void c(Map r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONArray r11 = new JSONArray();
        monitor-enter(WsChannelService.class);
        Iterator r12 = r10.entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L8
    L11:
        if (a((IWsApp) r13.getValue()) == false) goto L8;
        r11.put(((IWsApp) r13.getValue()).toJson());     // Catch: Throwable -> L14 Exception -> L16
    L18:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L14
        Logger.d(f7119b, "save to sp : " + r11.toString());     // Catch: Exception -> L21
        com.bytedance.common.wschannel.b.d(this.f7120a).h(r11.toString());     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
