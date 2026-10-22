package com.bytedance.frameworks.baselib.network.http.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.Keva;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebviewCookieRawSyncUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private static final String TAG = "WebviewCookieSyncUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Keva f8176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JSONObject f8177b = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.b.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: WebviewCookieRawSyncUtil.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: WebviewCookieRawSyncUtil.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b f8178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f8180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<f> f8181d;

        private a() {
            this.f8178a = b.f8182a;
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: WebviewCookieRawSyncUtil.java */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8182a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f8183b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f8184c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f8185d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f8186e = null;
        public static final b f = null;
        public static final b g = null;
        private static final /* synthetic */ b[] h = null;

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(h.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("INVALID", 0);
            f8182a = r0;
            b r1 = new b("EMPTY_COOKIE_DB", 1);
            f8183b = r1;
            b r3 = new b("WEBVIEW_DB_NOT_EXIST", 2);
            f8184c = r3;
            b r5 = new b("WEBVIEW_DB_COPY_FAILED", 3);
            f8185d = r5;
            b r7 = new b("TEMP_DB_NOT_EXIST", 4);
            f8186e = r7;
            b r9 = new b("QUERY_DB_FAILED", 5);
            f = r9;
            b r11 = new b("SUCCESS", 6);
            g = r11;
            h = new b[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public static /* synthetic */ void lambda$SR1yffCSCKkbJxglmS8pXLhnkFA(Context r0, com.bytedance.frameworks.baselib.network.http.d.d.e r1) {
        d(r0, r1);
    }

    static {
        f8177b = new JSONObject();
        f8176a = Keva.getRepo("ttnetCookieConfig", 1);
    }

    public static String a() {
        JSONObject r0 = f8177b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.length() <= 0) goto L7;
        String r1 = r0.toString();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = null;
        goto L8
    }

    public static boolean b() {
        if (f8176a.getInt("cookie_sync_result", -1) != b.g.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(Context r17, final com.bytedance.frameworks.baselib.network.http.d.d.e r18) {
        final Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (com.bytedance.frameworks.baselib.network.b.b.f() == false) goto L7;
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.b.b.l() == false) goto L10;
        return;
    L10:
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(r0) == true) goto L12;
        return;
    L12:
        Keva r1 = f8176a;
        int r5 = r1.getInt("cookie_sync_result", -1);
        long r8 = r1.getLong("cookie_last_sync_time", -1);
        boolean r4 = true;
        if (r5 == b.g.ordinal()) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L24;
        long r11 = com.bytedance.frameworks.baselib.network.b.b.h();
        if (r8 >= 0) goto L20;
    L23:
        r2 = r4;
        goto L24
    L20:
        if ((System.currentTimeMillis() - r8) >= (r11 * 1000)) goto L23;
        r4 = false;
    L24:
        if (r2 == true) goto L27;
        String r12 = r1.getString("cookie_synced_error", null);
        a(true, r5, r1.getInt("cookie_db_path_index", -1), r8, r1.getLong("cookie_sync_cost_ms", -1), r12, r1.getLong("cookie_sync_count", -1));
        return;
    L27:
        com.bytedance.common.utility.a.a.b().schedule(new $$Lambda$h$SR1yffCSCKkbJxglmS8pXLhnkFA(r0, r18), com.bytedance.frameworks.baselib.network.b.b.g(), TimeUnit.MILLISECONDS);
        return;
    L15:
        r2 = false;
        goto L16
    }

    private static /* synthetic */ void d(Context r2, com.bytedance.frameworks.baselib.network.http.d.d.e r3) {
        b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    private static void b(Context r18, com.bytedance.frameworks.baselib.network.http.d.d.e r19) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        long r2 = System.currentTimeMillis();
        a r4 = c(r0, r19);
        if (com.bytedance.common.utility.collection.a.a(r4.f8181d) == true) goto L13;
        Iterator<f> r5 = r4.f8181d.iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r5.next(), f.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        com.bytedance.frameworks.baselib.network.http.d.b.a().a(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Logger.e(TAG, "setHttpCookie failed", th);
    L13:
        long r11 = System.currentTimeMillis();
        long r13 = r11 - r2;
        int r9 = r4.f8178a.ordinal();
        Keva r3 = f8176a;
        r3.storeInt("cookie_sync_result", r9);
        r3.storeLong("cookie_last_sync_time", r11);
        r3.storeInt("cookie_db_path_index", r4.f8179b);
        r3.storeLong("cookie_sync_cost_ms", r13);
        if (com.bytedance.common.utility.collection.a.a(r4.f8181d) == false) goto L16;
        long r6 = 0;
    L18:
        if (r6 <= 0) goto L21;
        r3.storeLong("cookie_sync_count", r6);
    L21:
        if (TextUtils.isEmpty(r4.f8180c) == true) goto L23;
        r3.storeString("cookie_synced_error", r4.f8180c);
    L24:
        a(false, r9, r4.f8179b, r11, r13, r4.f8180c, r6);
        return;
    L23:
        r3.erase("cookie_synced_error");
        goto L24
    L16:
        r6 = r4.f8181d.size();
        goto L18
    }

    private static void a(boolean r3, int r4, int r5, long r6, long r8, String r10, long r11) {
        JSONObject r0 = f8177b;
        monitor-enter(r0);
        r0.put("skip", r3);     // Catch: Throwable -> L23
        r0.put("result", r4);     // Catch: Throwable -> L23
        r0.put("p", r5);     // Catch: Throwable -> L23
        if (r3 == false) goto L10;
        if (r6 <= 0) goto L10;
        r0.put("after_s", (System.currentTimeMillis() - r6) / 1000);     // Catch: Throwable -> L23
    L10:
        if (r8 < 0) goto L13;
        r0.put("cost_ms", r8);     // Catch: Throwable -> L23
    L13:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        r0.put(WsConstants.KEY_CONNECTION_ERROR, r10);     // Catch: Throwable -> L23
    L16:
        if (r11 < 0) goto L26;
        r0.put("count", r11);     // Catch: Throwable -> L23
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static a c(Context r12, com.bytedance.frameworks.baselib.network.http.d.d.e r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        Cursor r1 = null;
        Object[] r2 = 0;
        a r0 = new a(0 == true ? 1 : 0);
        if (r13 != com.bytedance.frameworks.baselib.network.http.d.d.e.f8299c) goto L90;
    L10:
        String r15 = a(r14, r0);
        if (TextUtils.isEmpty(r15) == false) goto L101;
        r0.f8178a = b.f8184c;
        return r0;
    L101:
        File r16 = a(r14, r15);     // Catch: Throwable -> L84
        if (r16 != null) goto L17;
    L82:
        r0.f8178a = b.f8186e;
        return r0;
    L17:
        if (r16.exists() == false) goto L82;
        SQLiteDatabase r17 = SQLiteDatabase.openDatabase(r16.getAbsolutePath(), null, 17);     // Catch: Throwable -> L66
        Cursor r3 = r17.query("cookies", null, null, null, null, null, null);     // Catch: Throwable -> L64
        if (r3 == null) goto L55;
        if (r3.moveToFirst() == false) goto L55;
    L24:
        long r4 = a(r3.getLong(r3.getColumnIndexOrThrow("expires_utc")));     // Catch: Throwable -> L64
        if (r4 > 0) goto L27;
    L29:
        String r5 = a(r3, "name");     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(r5) == true) goto L53;
        String r6 = a(r3, "value");     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(r6) == false) goto L35;
        r6 = "";
    L35:
        String r7 = a(r3, "host_key");     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(r7) == true) goto L53;
        String r8 = a(r3, DownloadConstants.PATH_KEY);     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(r8) == false) goto L41;
        r8 = "/";
    L41:
        boolean r9 = false;
        if (r3.getInt(r3.getColumnIndexOrThrow("is_secure")) != 1) goto L44;
        boolean r10 = true;
    L45:
        f r11 = new f();     // Catch: Throwable -> L64
        r11.b(r5);     // Catch: Throwable -> L64
        r11.c(r6);     // Catch: Throwable -> L64
        if (r7.startsWith(".") == true) goto L48;
        r9 = true;
    L48:
        r11.a(r7, r9);     // Catch: Throwable -> L64
        r11.a(r8);     // Catch: Throwable -> L64
        r11.a(r10);     // Catch: Throwable -> L64
        r11.b(String.valueOf(System.currentTimeMillis()), true);     // Catch: Throwable -> L64
        r11.a(r4);     // Catch: Throwable -> L64
        if (r0.f8181d != null) goto L51;
        r0.f8181d = new ArrayList();     // Catch: Throwable -> L64
    L51:
        r0.f8181d.add(r11);     // Catch: Throwable -> L64
        goto L53
    L44:
        r10 = false;
    L53:
        if (r3.moveToNext() == true) goto L24;
    L27:
        if (r4 >= System.currentTimeMillis()) goto L29;
    L55:
        if (com.bytedance.common.utility.collection.a.a(r0.f8181d) == false) goto L57;
        r0.f8178a = b.f8183b;     // Catch: Throwable -> L64
    L58:
        if (r3 != null) goto L98;
    L60:
        if (r17 == null) goto L62;
        r17.close();     // Catch: Throwable -> L87
    L62:
        r16.delete();     // Catch: Throwable -> L87
    L63:
        return r0;
    L98:
        r3.close();     // Catch: Throwable -> L87
        goto L60
    L57:
        r0.f8178a = b.g;     // Catch: Throwable -> L64
    L64:
        th = th;
    L96:
        r0.f8178a = b.f;     // Catch: Throwable -> L75
        r0.f8180c = th.getMessage();     // Catch: Throwable -> L75
        if (0 != 0) goto L94;
    L71:
        if (r17 == null) goto L73;
        r17.close();     // Catch: Throwable -> L88
    L73:
        r16.delete();     // Catch: Throwable -> L88
    L74:
        return r0;
    L94:
        (r2 == true ? 1 : 0).close();     // Catch: Throwable -> L88
    L75:
        th = move-exception;
        if (0 != 0) goto L92;
    L78:
        if (r17 == null) goto L80;
        r17.close();     // Catch: Throwable -> L89
    L80:
        r16.delete();     // Catch: Throwable -> L89
    L81:
        throw th;
    L92:
        r1.close();     // Catch: Throwable -> L89
    L66:
        th = th;
        r17 = null;
    L84:
        th = move-exception;
        r0.f8178a = b.f8185d;
        r0.f8180c = th.getMessage();
        return r0;
    L90:
    L8:
        th = move-exception;
        Logger.e(TAG, "CookieInitV2 CookieManager flush failed", th);
        goto L10
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L10;
        CookieManager.getInstance().flush();     // Catch: Throwable -> L8
        goto L10
    }

    private static String a(Context r6, a r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        ArrayList r1 = new ArrayList();
    L12:
        th = move-exception;
        th.printStackTrace();
    L14:
        Iterator r9 = r1.iterator();
    L16:
        if (r9.hasNext() == false) goto L21;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");
        if (new File(r0).exists() == false) goto L16;
        r7.f8179b = r1.indexOf(r0);
        return r0;
    L21:
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 24) goto L6;
        String r3 = r8.getDataDir().getAbsolutePath();     // Catch: Throwable -> L12
    L7:
        String r10 = com.bytedance.frameworks.baselib.network.http.i.h.d(r8);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r10) == true) goto L10;
        r1.add(r3 + "/app_webviewbytedance_" + r10 + "/Cookies");     // Catch: Throwable -> L12
        r1.add(r3 + "/app_ttwebview_bytedance_" + r10 + "/cookie/Cookies");     // Catch: Throwable -> L12
        r1.add(r3 + "/app_webview_" + r10 + "/Default/Cookies");     // Catch: Throwable -> L12
        r1.add(r3 + "/hws_app_webview_" + r10 + "/Default/Cookies");     // Catch: Throwable -> L12
    L10:
        r1.add(r3 + "/app_webview/Default/Cookies");     // Catch: Throwable -> L12
        r1.add(r3 + "/hws_app_webview/Default/Cookies");     // Catch: Throwable -> L12
        goto L14
    L6:
        r3 = r8.getApplicationInfo().dataDir;     // Catch: Throwable -> L12
        goto L7
    }

    private static File a(Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        File r0 = r11.getCacheDir();
        String r12 = com.bytedance.frameworks.baselib.network.http.i.h.d(r11);
        String r2 = "ttnet_cookie_raw_temp_";
        if (TextUtils.isEmpty(r12) == true) goto L5;
        r2 = "ttnet_cookie_raw_temp_" + r12;
    L5:
        File r13 = new File(r0, r2);
        if (r13.exists() == false) goto L8;
        r13.delete();
    L8:
        FileChannel r1 = null;
        FileInputStream r3 = new FileInputStream(r10);     // Catch: Throwable -> L26
        FileOutputStream r14 = new FileOutputStream(r13);     // Catch: Throwable -> L24
        FileChannel r8 = r3.getChannel();     // Catch: Throwable -> L22
        r1 = r14.getChannel();     // Catch: Throwable -> L20
        r1.transferFrom(r8, 0, r8.size());     // Catch: Throwable -> L20
        if (r1 != null) goto L74;
    L15:
        if (r8 != null) goto L62;
    L60:
        r14.close();     // Catch: IOException -> L44
    L54:
        r3.close();     // Catch: IOException -> L45
    L19:
        return r13;
    L62:
        r8.close();     // Catch: IOException -> L43
        goto L60
    L74:
        r1.close();     // Catch: IOException -> L42
    L20:
        th = th;
    L72:
    L32:
        th = move-exception;
        if (r1 != null) goto L56;
    L35:
        if (r8 != null) goto L50;
    L37:
        if (r14 != null) goto L66;
    L39:
        if (r3 == null) goto L76;
        r3.close();     // Catch: IOException -> L49
        throw th;
    L77:
        throw th;
    L76:
        throw th;
    L66:
        r14.close();     // Catch: IOException -> L48
        goto L39
    L50:
        r8.close();     // Catch: IOException -> L47
        goto L37
    L56:
        r1.close();     // Catch: IOException -> L46
        goto L35
    L29:
        if (r13.exists() == false) goto L31;
        r13.delete();     // Catch: Throwable -> L32
    L31:
        throw th;     // Catch: Throwable -> L32
    L22:
        th = th;
        r8 = null;
    L24:
        th = th;
        r14 = null;
        r8 = null;
    L26:
        th = th;
        r14 = null;
        r3 = null;
        r8 = null;
        goto L72
    }

    private static String a(Cursor r2, String r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        int r5 = r4.getColumnIndex(r3);
        if (r5 != (-1)) goto L5;
        return null;
    L5:
        if (r4.isNull(r5) == false) goto L8;
        return null;
    L8:
        return r4.getString(r5);
    }

    private static long a(long r4) {
        if (r4 > 0) goto L6;
        return -1;
    L6:
        long r5 = (r4 / 1000) - 11644473600000L;
        if (r5 > 0) goto L9;
        return 0;
    L9:
        return r5;
    }
}
