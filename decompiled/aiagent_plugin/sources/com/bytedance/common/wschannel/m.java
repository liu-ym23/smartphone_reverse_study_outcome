package com.bytedance.common.wschannel;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: WsChannelSettings.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    private static final String TAG = "com.bytedance.common.wschannel.m";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f6980a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f6981c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WsChannelMultiProcessSharedProvider.b f6982b;

    /* JADX INFO: compiled from: WsChannelSettings.java */
    public interface a {
        Map<String, String> a(String r1, Map<String, List<String>> r2);

        Map<String, String> a(Map<String, String> r1);
    }

    static {
    }

    private m(Context r3) {
        this.f6982b = WsChannelMultiProcessSharedProvider.getMultiprocessShared((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public static m a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f6980a != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6980a != null) goto L9;
        f6980a = new m(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f6980a;
    }

    public boolean a() {
        return this.f6982b.a(WsConstants.KEY_ENABLE_OFFLINE_DETECT, false);
    }

    public void a(boolean r2) {
        this.f6982b.a().a(WsConstants.KEY_ENABLE_OFFLINE_DETECT, r2).b();
    }

    public static a b() {
        return f6981c;
    }

    public boolean c() {
        return this.f6982b.a(WsConstants.KEY_FRONTIER_ENABLED, true);
    }

    public String d() {
        return this.f6982b.a(WsConstants.KEY_WS_APPS, "");
    }

    public void a(String r2) {
        this.f6982b.a().a(WsConstants.KEY_WS_APPS, r2).b();
    }

    public boolean e() {
        return this.f6982b.a(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    public long f() {
        return this.f6982b.a(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
    }

    public long g() {
        return this.f6982b.a(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);
    }

    public boolean h() {
        return this.f6982b.a(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false);
    }

    public ArrayList<Integer> i() {
        ArrayList<Integer> r0 = new ArrayList();
        String r3 = this.f6982b.a(WsConstants.KEY_AUTO_CONNECT_DISABLED, "");
        if (TextUtils.isEmpty(r3) == false) goto L16;
        return r0;
    L16:
        JSONArray r1 = new JSONArray(r3);     // Catch: JSONException -> L13
        int r4 = 0;
    L7:
        if (r4 >= r1.length()) goto L10;
        r0.add(Integer.valueOf(r1.getInt(r4)));     // Catch: JSONException -> L13
        r4 = r4 + 1;     // Catch: JSONException -> L13
        goto L7
    L10:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "getAutoConnectDisabledChannelIds: " + r0);     // Catch: JSONException -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        Logger.e(TAG, e.getMessage());
        goto L15
    }
}
