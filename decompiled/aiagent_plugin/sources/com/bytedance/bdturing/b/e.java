package com.bytedance.bdturing.b;

import android.text.TextUtils;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.g;
import com.bytedance.bdturing.j;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VerifyDialogHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {
    public void a() {
    }

    public void a(int r1, int r2) {
    }

    public void a(int r1, String r2, String r3, String r4, String r5) {
    }

    public void a(c r1) {
    }

    public void a(String r1, com.bytedance.bdturing.c r2) {
        com.bytedance.bdturing.c r0 = (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin");
    }

    public void b() {
    }

    public void b(int r1, int r2) {
    }

    public e() {
    }

    static /* synthetic */ void a(e r0, c r1, String r2) {
        r0.a(r1, r2);
    }

    @Override // com.bytedance.bdturing.b.a
    public void b(final c r8) {
        String r0 = r8.f6520b;     // Catch: Exception -> L68
        byte r1 = -1;
        switch(r0.hashCode()) {
            case -1759249244: goto L42;
            case -1628743486: goto L39;
            case -1563440329: goto L36;
            case -1534238297: goto L33;
            case -1471628194: goto L30;
            case -1366167938: goto L27;
            case -1028963129: goto L24;
            case -985680828: goto L21;
            case -514719849: goto L18;
            case 428780843: goto L15;
            case 491779646: goto L12;
            case 1154510586: goto L9;
            case 1176627553: goto L6;
            default: goto L45;
        };     // Catch: Exception -> L68
    L45:
        switch(r1) {
            case 0: goto L66;
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L54;
            case 6: goto L53;
            case 7: goto L52;
            case 8: goto L51;
            case 9: goto L50;
            case 10: goto L49;
            case 11: goto L48;
            case 12: goto L47;
            default: goto L86;
        };
    L47:
        com.bytedance.bdturing.e.b(System.currentTimeMillis() - j.a().c());     // Catch: Exception -> L68
        return;
    L48:
        j.a().d();     // Catch: Exception -> L68
        com.bytedance.bdturing.e.a(System.currentTimeMillis() - j.a().b());     // Catch: Exception -> L68
        return;
    L49:
        b();     // Catch: Exception -> L68
        return;
    L50:
        a(new JSONObject(r8.f6521c).getString("params"), new AnonymousClass1(this, r8));     // Catch: Exception -> L68
        return;
    L51:
        a(r8);     // Catch: Exception -> L68
        return;
    L52:
        c(r8);     // Catch: Exception -> L68
        return;
    L53:
        JSONObject r7 = new JSONObject(r8.f6521c);     // Catch: Exception -> L68
        com.bytedance.bdturing.e.a(r7.optString("event"), r7);     // Catch: Exception -> L68
        return;
    L54:
        JSONObject r9 = new JSONObject(r8.f6521c);     // Catch: Exception -> L68
        HashMap r10 = new HashMap();     // Catch: Exception -> L68
        Iterator<String> r2 = r9.keys();     // Catch: Exception -> L68
    L56:
        if (r2.hasNext() == false) goto L88;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L68
        Object r4 = r9.opt(r3);     // Catch: Exception -> L68
        if (r4 == null) goto L60;
        String r5 = r4.toString();     // Catch: Exception -> L68
    L61:
        r10.put(r3, r5);     // Catch: Exception -> L68
        goto L56
    L60:
        r5 = null;
        goto L61
    L88:
        return;
    L62:
        JSONObject r6 = new JSONObject(r8.f6521c);     // Catch: Exception -> L68
        a(r6.optInt("result"), r6.optString("mode"), r6.optString("type"), r6.optString("token"), r6.optString(SensitiveType.MOBILE));     // Catch: Exception -> L68
        return;
    L63:
        a();     // Catch: Exception -> L68
        return;
    L64:
        VerifyTaskHandler.a().a(2, r8);     // Catch: Exception -> L68
        return;
    L65:
        JSONObject r11 = new JSONObject(r8.f6521c);     // Catch: Exception -> L68
        b(r11.getInt(DownloadFileUtils.MODE_WRITE), r11.getInt("h"));     // Catch: Exception -> L68
        return;
    L66:
        JSONObject r12 = new JSONObject(r8.f6521c);     // Catch: Exception -> L68
        a(r12.getInt(DownloadFileUtils.MODE_WRITE), r12.getInt("h"));     // Catch: Exception -> L68
        return;
    L86:
        return;
    L6:
        if (r0.equals("bytedcert.network.request") == false) goto L45;
        r1 = 7;
        goto L45
    L9:
        if (r0.equals("bytedcert.readyView") == false) goto L45;
        r1 = 10;
        goto L45
    L12:
        if (r0.equals("bytedcert.eventToNative") == false) goto L45;
        r1 = 6;
        goto L45
    L15:
        if (r0.equals("bytedcert.getSettings") == false) goto L45;
        r1 = 8;
        goto L45
    L18:
        if (r0.equals("bytedcert.dialogSize") == false) goto L45;
        r1 = 0;
        goto L45
    L21:
        if (r0.equals("bytedcert.dialogSize_V2") == false) goto L45;
        r1 = 1;
        goto L45
    L24:
        if (r0.equals("bytedcert.preLoadVerifyFinish") == false) goto L45;
        r1 = 11;
        goto L45
    L27:
        if (r0.equals("bytedcert.refreshVerifyViewFinish") == false) goto L45;
        r1 = 12;
        goto L45
    L30:
        if (r0.equals("bytedcert.pageEnd") == false) goto L45;
        r1 = 3;
        goto L45
    L33:
        if (r0.equals("bytedcert.verify") == false) goto L45;
        r1 = 9;
        goto L45
    L36:
        if (r0.equals("bytedcert.getTouch") == false) goto L45;
        r1 = 2;
        goto L45
    L39:
        if (r0.equals("bytedcert.h5_state_changed") == false) goto L45;
        r1 = 5;
        goto L45
    L42:
        if (r0.equals("bytedcert.verifyResult") == false) goto L45;
        r1 = 4;
    L68:
        e = move-exception;
        e.printStackTrace();
    }

    private void c(final c r11) {
        JSONObject r0 = new JSONObject(r11.f6521c);     // Catch: JSONException -> L25
        String r1 = r0.getString("url");     // Catch: JSONException -> L25
        String r2 = r0.getString("method");     // Catch: JSONException -> L25
        JSONObject r3 = r0.optJSONObject(DownloadConstants.QUERY_KEY);     // Catch: JSONException -> L25
        JSONObject r4 = r0.optJSONObject("data");     // Catch: JSONException -> L25
        final String r5 = null;
        if (r3 == null) goto L13;
        StringBuilder r6 = new StringBuilder(r1).append("?");     // Catch: JSONException -> L25
        Iterator<String> r7 = r3.keys();     // Catch: JSONException -> L25
    L6:
        if (r7.hasNext() == false) goto L12;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L25
        if (r3.get(r8) == null) goto L10;
        String r9 = r3.get(r8).toString();     // Catch: JSONException -> L25
    L11:
        r6.append("&" + r8 + "=").append(r9);     // Catch: JSONException -> L25
        goto L6
    L10:
        r9 = null;
        goto L11
    L12:
        r1 = r6.toString();     // Catch: JSONException -> L25
    L13:
        final String r10 = r1;
        if (r4 == null) goto L18;
        r5 = r4.toString().replaceAll("\\\\/", "/");     // Catch: JSONException -> L25
    L18:
        if (g.a() == false) goto L20;
        g.g("CallNativeRequest", r10);     // Catch: JSONException -> L25
    L20:
        final HashMap r12 = new HashMap();     // Catch: JSONException -> L25
        r12.put(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8");     // Catch: JSONException -> L25
        if (r2.equals(CozeCloudExt.API_KEY_HTTP_POST_METHOD) == false) goto L23;
        VerifyTaskHandler.a().a(new AnonymousClass2(this, r10, r12, r5, r11));     // Catch: JSONException -> L25
        return;
    L23:
        VerifyTaskHandler.a().a(new AnonymousClass3(this, r10, r12, r11));     // Catch: JSONException -> L25
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
    }

    private void a(c r3, String r4) {
        if (g.a() == false) goto L5;
        g.g("CallNativeRequest", r4);
    L5:
        int r2 = !TextUtils.isEmpty(r4) ? 1 : 0;
        JSONObject r0 = new JSONObject();
        r0.put("content", r4);     // Catch: JSONException -> L8
        r0 = new JSONObject(r4);     // Catch: JSONException -> L8
    L10:
        r3.a(r2, r0);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        r2 = 0;
        goto L10
    }
}
