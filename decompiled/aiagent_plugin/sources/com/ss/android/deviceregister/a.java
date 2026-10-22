package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.ss.android.common.applog.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbsDeviceParamsProvider.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements com.ss.android.deviceregister.a.a.a {
    private static final String TAG = "DeviceParamsProvider";
    private static String f;
    private static String g;
    private static volatile String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f37297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f37298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final String f37299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ss.android.deviceregister.a.a.a.b f37300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.ss.android.deviceregister.a.a.a.a f37301e;

    private String b(boolean r1) {
        if (r1 == false) goto L4;
        return "_local";
    L4:
        return "";
    }

    public void a(c r1, com.ss.android.deviceregister.a.a.a.b r2) {
    }

    a(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f37299c = b(r4);
        this.f37298b = r4;
        Context r6 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f37297a = r6;
        c r0 = new c(r5, com.ss.android.deviceregister.base.b.b());
        this.f37300d = new com.ss.android.deviceregister.a.a.a.e(r6);
        com.ss.android.deviceregister.a.a.a.a r1 = new com.ss.android.deviceregister.a.a.a.a(r6);
        this.f37301e = r1;
        this.f37300d.a(r1);
        if (com.ss.android.deviceregister.c.e.x() == false) goto L7;
        if (com.ss.android.deviceregister.c.e.b(r5) == false) goto L7;
    L10:
        if (g.p() == true) goto L12;
        return;
    L12:
        if (g.o() == true) goto L16;
        r0.a();
        return;
    L16:
        return;
    L7:
        if (g.o() == false) goto L10;
        a(r0, r1);
        goto L10
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public String a(boolean r8) {
        if (com.bytedance.common.utility.j.a(f) == false) goto L5;
        String r0 = com.ss.android.deviceregister.c.c.c(this.f37297a);
        if (r0 != null) goto L34;
    L12:
        SharedPreferences r2 = this.f37297a.getSharedPreferences(com.ss.android.deviceregister.base.b.c(), 0);     // Catch: Exception -> L25
        String r3 = r2.getString("openudid", null);     // Catch: Exception -> L25
        if (com.ss.android.deviceregister.c.b.a(r3) == true) goto L24;
        r3 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L25
        if (r3.charAt(0) != '-') goto L17;
        r3 = r3.substring(1);     // Catch: Exception -> L25
    L17:
        int r1 = 13 - r3.length();     // Catch: Exception -> L25
        if (r1 <= 0) goto L23;
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L25
    L20:
        if (r1 <= 0) goto L22;
        r4.append('F');     // Catch: Exception -> L25
        r1 = r1 - 1;     // Catch: Exception -> L25
        goto L20
    L22:
        r4.append(r3);     // Catch: Exception -> L25
        r3 = r4.toString();     // Catch: Exception -> L25
    L23:
        SharedPreferences.Editor r5 = r2.edit();     // Catch: Exception -> L25
        r5.putString("openudid", r3);     // Catch: Exception -> L25
        r5.commit();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        com.ss.android.common.util.e.e("DeviceParamsProviderexception when making openudid: ", e);
    L28:
        if (com.bytedance.common.utility.j.a(r0) == true) goto L31;
        r0 = r0 + this.f37299c;
    L31:
        if (com.bytedance.common.utility.j.a(r0) == true) goto L33;
        f = r0;
    L33:
        return r0;
    L24:
        r0 = r3;
        goto L28
    L34:
        if (r0.equals("9774d56d682e549c") == true) goto L12;
        if (r0.length() >= 13) goto L28;
    L5:
        return f;
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public String a() {
        if (TextUtils.isEmpty(g) == false) goto L5;
        SharedPreferences r1 = this.f37297a.getSharedPreferences(com.ss.android.deviceregister.base.b.c(), 0);     // Catch: Exception -> L14
        String r2 = r1.getString("clientudid", null);     // Catch: Exception -> L14
        if (com.ss.android.deviceregister.c.b.a(r2) == true) goto L10;
        r2 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r3 = r1.edit();     // Catch: Exception -> L14
        r3.putString("clientudid", r2);     // Catch: Exception -> L14
        r3.commit();     // Catch: Exception -> L14
    L10:
        if (com.bytedance.common.utility.j.a(r2) == true) goto L12;
        r2 = r2 + this.f37299c;     // Catch: Exception -> L14
    L12:
        g = r2;     // Catch: Exception -> L14
        return r2;
    L14:
        e = move-exception;
        com.ss.android.common.util.e.d("DeviceParamsProvider exception when making client_udid: ", e);
        return "";
    L5:
        return g;
    }

    public void a(JSONArray r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L19;
        int r4 = 0;
    L7:
        if (r4 >= r5.length()) goto L20;
        JSONObject r0 = r5.optJSONObject(r4);
        if (r0 == null) goto L13;
        String r2 = r0.optString(DbHelper.COL_ID);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        r0.remove(DbHelper.COL_ID);
        r0.put(DbHelper.COL_ID, r2 + r6);
    L13:
        r4 = r4 + 1;
        goto L7
    L20:
        return;
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public String b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.common.utility.j.a(h) == true) goto L8;
        String r0 = h;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r0;
    L8:
        h = this.f37300d.b("", "");     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return h;
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public void a(String r2) {
        if (y.a(r2) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.j.a(r2, h) == true) goto L10;
        h = this.f37300d.b(r2, h);
        return;
    }

    @Override // com.ss.android.deviceregister.a.a.a
    public void b(String r3) {
        if (TextUtils.equals(r3, "device_id") == false) goto L6;
        h = null;
    L6:
        if (TextUtils.equals(r3, "openudid") == false) goto L9;
        f = null;
    L9:
        if (TextUtils.equals(r3, "clientudid") == false) goto L11;
        g = null;
    L11:
        this.f37300d.b(r3);
    }

    public void a(Account r1) {
        this.f37301e.a(r1);
    }

    public void a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        h = null;
        String r0 = "clear_key_prefix" + r6;
        SharedPreferences r8 = com.ss.android.deviceregister.base.b.a(r7);
        if (r8.getBoolean(r0, false) == true) goto L17;
        SharedPreferences.Editor r1 = r8.edit();
        r1.putBoolean(r0, true);
        if (r8.contains("device_id") == false) goto L11;
        r1.remove("device_id");
    L11:
        if (r8.contains("install_id") == false) goto L13;
        r1.remove("install_id");
    L13:
        r1.commit();
        this.f37300d.b("device_id");
        if (Logger.debug() == false) goto L19;
        com.ss.android.common.util.e.d("DeviceParamsProvider clearKey : " + r6 + " :clear installId and deviceId finish");
    L19:
        o.b(o.f37441a, "DeviceParamsProvider#clear mCacheHandler.loadDeviceId()=" + this.f37300d.b("", ""));
        return;
    L17:
        if (Logger.debug() == false) goto L19;
        com.ss.android.common.util.e.d("DeviceParamsProvider clearKey : " + r6 + " : is already cleared");
        goto L19
    }

    static String a(Context r13) {
        String r14 = ((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.key_external_derectory_device_parameter, WsChannelMultiProcessSharedProvider.STRING_TYPE, "key_external_derectory_device_parameter")) + com.ss.android.deviceregister.a.a.a.c.a();
        return new String(new char[]{r14.charAt(1), r14.charAt(3), r14.charAt(1), r14.charAt(11), r14.charAt(15), r14.charAt(10), r14.charAt(8), r14.charAt(17), r14.charAt(9), r14.charAt(9), r14.charAt(12), r14.charAt(13), r14.charAt(13), r14.charAt(5), r14.charAt(18), r14.charAt(13), r14.charAt(14), r14.charAt(11), r14.charAt(4), r14.charAt(19), r14.charAt(7)}).substring(2, 18);
    }
}
