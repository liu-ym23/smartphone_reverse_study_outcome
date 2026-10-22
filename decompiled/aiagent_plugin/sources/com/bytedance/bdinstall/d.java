package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Api.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f6201a = null;

    /* JADX WARN: Multi-variable type inference failed */
    static com.bytedance.bdinstall.e.a a(ai r4, aj r5, String r6, JSONObject r7, boolean r8, ad r9, boolean r10, List<Pair<String, String>> r11) {
        ai r12 = (ai) ZeusTransformUtils.wrapperContextForParams(r4, ai.class, "com.obric.aiagent.plugin");
        aj r13 = (aj) ZeusTransformUtils.wrapperContextForParams(r5, aj.class, "com.obric.aiagent.plugin");
        ad r14 = (ad) ZeusTransformUtils.wrapperContextForParams(r9, ad.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        HashMap<String, String> r16 = a(r8, r10);
        if (r15 != null) goto L5;
    L10:
        com.bytedance.bdinstall.e.a r17 = null;
        byte[] r18 = b(r7.toString(), r8, r14);     // Catch: Exception -> L22
        if (r18 == null) goto L15;
        if (r8 == false) goto L15;
        r6 = r6 + "&tt_data=a";     // Catch: Exception -> L22
    L15:
        if (r13 == null) goto L17;
        com.bytedance.bdinstall.e.a r19 = r13.a(r6, r18, r16);     // Catch: Exception -> L22
        t.a("ticket network client is ready. response is " + r19);     // Catch: Exception -> L22
        return r19;
    L17:
        com.bytedance.bdinstall.e.a r20 = new com.bytedance.bdinstall.e.a(r6, 200, null, r12.a(r6, r18, r16));     // Catch: Exception -> L22
        t.a("network client is ready. response is " + r20);     // Catch: Exception -> L20
        return r20;
    L20:
        e = e;
        r17 = r20;
    L23:
        t.b("Register#doRegister http error = ", e);
        e.printStackTrace();
        return r17;
    L22:
        e = e;
        goto L23
    L5:
        if (r15.size() <= 0) goto L10;
        int r0 = 0;
    L8:
        if (r0 >= r15.size()) goto L10;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r15.get(r0), Pair.class, "com.obric.aiagent.plugin");
        r16.put(r2.first, r2.second);
        r0 = r0 + 1;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean b(ai r6, aj r7, String r8, JSONObject r9, boolean r10, ad r11, boolean r12, List<Pair<String, String>> r13) {
        ai r14 = (ai) ZeusTransformUtils.wrapperContextForParams(r6, ai.class, "com.obric.aiagent.plugin");
        aj r15 = (aj) ZeusTransformUtils.wrapperContextForParams(r7, aj.class, "com.obric.aiagent.plugin");
        ad r16 = (ad) ZeusTransformUtils.wrapperContextForParams(r11, ad.class, "com.obric.aiagent.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        HashMap<String, String> r18 = a(r10, r12);
        if (r17.size() <= 0) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= r17.size()) goto L8;
        r18.put(((Pair) ZeusTransformUtils.preCheckCast(r17.get(r0), Pair.class, "com.obric.aiagent.plugin")).first, ((Pair) ZeusTransformUtils.preCheckCast(r17.get(r0), Pair.class, "com.obric.aiagent.plugin")).second);
        r0 = r0 + 1;
    L8:
        t.a("TicketGuard# [before verify] add headers " + r18);
        JSONObject r19 = null;
        byte[] r20 = b(r9.toString(), r10, r16);     // Catch: Exception -> L19
        if (r20 == null) goto L13;
        if (r10 == false) goto L13;
        r8 = r8 + "&tt_data=a";     // Catch: Exception -> L19
    L13:
        if (r15 == null) goto L15;
        com.bytedance.bdinstall.e.a r21 = r15.a(r8, r20, r18);     // Catch: Exception -> L19
        t.a("ticket network client is ready. response is " + r21);     // Catch: Exception -> L19
    L16:
        if (r21 == null) goto L21;
        r19 = new JSONObject(r21.b());     // Catch: Exception -> L19
    L21:
        if (r19 != null) goto L23;
        return false;
    L23:
        if ("success".equals(r19.optString("message", "")) == false) goto L30;
        return true;
    L30:
        return false;
    L15:
        com.bytedance.bdinstall.e.a r22 = new com.bytedance.bdinstall.e.a(r8, 200, null, r14.a(r8, r20, r18));     // Catch: Exception -> L19
        t.a(" network client is ready. response is " + r22);     // Catch: Exception -> L19
        r21 = r22;
    L19:
        e = move-exception;
        t.b("TicketGuard# doVerify http error = ", e);
        e.printStackTrace();
        goto L21
    }

    static {
        f6201a = new String[]{WsConstants.KEY_APP_ID, WsConstants.KEY_APP_VERSION, "tt_data", "device_id", "bd_did"};
    }

    private static String a(String r9, boolean r10, ad r11) {
        ad r12 = (ad) ZeusTransformUtils.wrapperContextForParams(r11, ad.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r9) == true) goto L20;
        Uri r13 = Uri.parse(r9);
        String r0 = r13.getQuery();
        ArrayList r2 = new ArrayList();
        String[] r3 = f6201a;
        int r4 = r3.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L10;
        String r6 = r3[r5];
        String r7 = r13.getQueryParameter(r6);
        if (TextUtils.isEmpty(r7) == true) goto L9;
        r2.add(new Pair(r6, r7));
    L9:
        r5 = r5 + 1;
        goto L5
    L10:
        Uri.Builder r14 = r13.buildUpon();
        r14.clearQuery();
        Iterator r8 = r2.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        Pair r15 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.aiagent.plugin");
        r14.appendQueryParameter((String) ZeusTransformUtils.preCheckCast(r15.first, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r15.second, String.class, "com.obric.aiagent.plugin"));
        goto L12
    L14:
        r14.appendQueryParameter("tt_info", new String(Base64.encode(b(r0, r10, r12), 8)));
        return r14.build().toString();
    L20:
        return r9;
    }

    static boolean a(ai r3, aj r4, String r5, boolean r6, ad r7, boolean r8) {
        ai r9 = (ai) ZeusTransformUtils.wrapperContextForParams(r3, ai.class, "com.obric.aiagent.plugin");
        aj r10 = (aj) ZeusTransformUtils.wrapperContextForParams(r4, aj.class, "com.obric.aiagent.plugin");
        ad r11 = (ad) ZeusTransformUtils.wrapperContextForParams(r7, ad.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder(r5);
        HashMap<String, String> r12 = a(r8);
        JSONObject r1 = null;
        if (r10 == null) goto L9;
        com.bytedance.bdinstall.e.a r13 = r10.a(a(r0.toString(), r6, r11), r12);     // Catch: Exception -> L14
        t.a("ticket network client is ready. response is " + r13);     // Catch: Exception -> L7
    L31:
    L17:
        if (r13 != null) goto L40;
    L25:
        if (r1 != null) goto L27;
    L29:
        return false;
    L27:
        if ("success".equals(r1.optString("message", "")) == false) goto L29;
        return true;
    L40:
        JSONObject r14 = new JSONObject(r13.b());     // Catch: JSONException -> L23
        t.a("active response body " + r14);     // Catch: JSONException -> L21
        r1 = r14;
    L21:
        e = e;
        r1 = r14;
    L24:
        t.b("active parse json error " + r13 + ", ", e);
        e.printStackTrace();
    L23:
        e = e;
    L7:
        e = e;
    L16:
        t.b("active http error = ", e);
        e.printStackTrace();
        goto L17
    L9:
        com.bytedance.bdinstall.e.a r15 = new com.bytedance.bdinstall.e.a(r5, 200, null, r9.a(a(r0.toString(), r6, r11), r12));     // Catch: Exception -> L14
        t.a("network client is ready. response is " + r15);     // Catch: Exception -> L12
        r13 = r15;
    L12:
        e = move-exception;
        e = e;
        r13 = r15;
    L14:
        e = e;
        r13 = null;
        goto L16
    }

    private static byte[] b(String r4, boolean r5, ad r6) {
        ad r7 = (ad) ZeusTransformUtils.wrapperContextForParams(r6, ad.class, "com.obric.aiagent.plugin");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r2 = null;
        if (r5 == false) goto L11;
        GZIPOutputStream r3 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r3.write(r4.getBytes("UTF-8"));     // Catch: Throwable -> L7
        r2 = r3;
    L12:
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L41:
    L21:
        byte[] r8 = r0.toByteArray();
        if (r5 == false) goto L43;
        if (r7 != null) goto L25;
        return r8;
    L25:
        return r7.a(r8, r8.length);
    L43:
        return r8;
    L7:
        th = th;
        r2 = r3;
    L33:
        t.a(th);     // Catch: Throwable -> L26
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L26:
        th = move-exception;
        if (r2 != null) goto L35;
    L32:
        throw th;
    L35:
        r2.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        t.a(e);
        goto L32
    L11:
        r0.write(r4.getBytes("UTF-8"));     // Catch: Throwable -> L9
    L9:
        th = th;
    L19:
        e = move-exception;
        t.a(e);
        goto L21
    }

    static void a(StringBuilder r2, String r3, String r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (r2.toString().indexOf(63) >= 0) goto L11;
        r2.append("?");
    L12:
        r2.append(r3).append("=").append(Uri.encode(r4));
        return;
    L11:
        r2.append("&");
        goto L12
    }

    private static HashMap<String, String> a(boolean r1, boolean r2) {
        HashMap<String, String> r3 = a(r2);
        if (r1 == false) goto L5;
        r3.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");
    L6:
        return r3;
    L5:
        r3.put(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8");
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> a(final boolean r3) {
        HashMap<String, String> r0 = new HashMap();
        Pair r4 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r3));     // Catch: Throwable -> L7
        if (r4 == null) goto L9;
        r0.put(r4.first, r4.second);     // Catch: Throwable -> L7
    L9:
        return r0;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }
}
