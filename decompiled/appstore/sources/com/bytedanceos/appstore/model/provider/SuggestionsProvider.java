package com.bytedanceos.appstore.model.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.bytedanceos.appstore.utils.b;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.k;
import com.obric.appstore.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import org.apache.http.protocol.HttpRequestExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class SuggestionsProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f9426c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UriMatcher f9427d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f9428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMap f9429b;

    static {
        f9426c = new String[]{"suggest_icon_1", "suggest_text_1", "suggest_text_2", "suggest_text_2_url", "suggest_intent_extra_data", "suggest_intent_data", "suggest_shortcut_id", "drag_uri", "drag_type", "drag_text", ServerElements.FILESIZE};
        UriMatcher r10 = new UriMatcher(-1);
        f9427d = r10;
        r10.addURI("com.obric.appstore.SuggestionsProvider", "search_suggest_query", 0);
        r10.addURI("com.obric.appstore.SuggestionsProvider", "search_suggest_query/*", 0);
        r10.addURI("com.obric.appstore.SuggestionsProvider", "search_suggest_shortcut", 1);
        r10.addURI("com.obric.appstore.SuggestionsProvider", "search_suggest_shortcut/*", 2);
        r10.addURI("com.obric.appstore.SuggestionsProvider", "query_short_link/*", 3);
        r10.addURI("com.obric.appstore.SuggestionsProvider", "query_short_link", 3);
    }

    public SuggestionsProvider() {
        final int r10 = 20;
        this.f9429b = new AnonymousClass1(this, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.File[]] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.File] */
    public final File a(String r12) {
        ?? r10 = 0;
        if (TextUtils.isEmpty(r12) == false) goto L5;
        return null;
    L5:
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f9428a != null) goto L11;
        this.f9428a = new File(e.H(), ".search");     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        if (this.f9428a.exists() == true) goto L15;
        j.a("create dir:" + this.f9428a.mkdirs());
    L15:
        String r11 = k.f(r12);
        ?? r13 = this.f9428a;
        File r14 = new File(r13, r11);
        if (r14.exists() == false) goto L18;
        return r14;
    L18:
        ?? r15 = this.f9428a.listFiles();
        if (r15 == 0) goto L96;
        r13 = r15.length;
        if (r13 <= 20) goto L96;
        r13 = r15.length;
        int r16 = 0;
        ?? r17 = 0;
    L23:
        if (r16 >= r13) goto L30;
        ?? r18 = r15[r16];
        if (r17 != 0) goto L27;
    L28:
        r17 = r18;
    L29:
        r16 = r16 + 1;
        r17 = r17;
        goto L23
    L27:
        if (r17.lastModified() <= r18.lastModified()) goto L29;
    L30:
        if (r17 == 0) goto L96;
        r17.delete();
    L96:
        r15 = (HttpURLConnection) new URL(r12).openConnection();     // Catch: Throwable -> L61 IOException -> L63
    L101:
        r15.setReadTimeout(HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);     // Catch: Throwable -> L56 IOException -> L58
        r15.setConnectTimeout(HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);     // Catch: Throwable -> L56 IOException -> L58
        r12 = r15.getInputStream();     // Catch: Throwable -> L56 IOException -> L58
    L103:
        ?? r19 = new FileOutputStream(r14);     // Catch: Throwable -> L52 IOException -> L54
    L99:
        byte[] r20 = new byte[1024];     // Catch: Throwable -> L42 IOException -> L44
    L38:
        int r21 = r12.read(r20);     // Catch: Throwable -> L42 IOException -> L44
        if (r21 == (-1)) goto L46;
        r19.write(r20, 0, r21);     // Catch: Throwable -> L42 IOException -> L44
        goto L38
    L46:
        r15.disconnect();
        r12.close();     // Catch: IOException -> L49
        r19.close();     // Catch: IOException -> L49
    L51:
        return r14;
    L49:
        e = move-exception;
        e.printStackTrace();
    L44:
        e = e;
    L65:
        e.printStackTrace();     // Catch: Throwable -> L42
        if (r15 == 0) goto L68;
        r15.disconnect();
    L68:
        if (r12 != 0) goto L94;
    L72:
        if (r19 == 0) goto L76;
        r19.close();     // Catch: IOException -> L70
    L70:
        e = move-exception;
        e.printStackTrace();
    L76:
        return null;
    L94:
        r12.close();     // Catch: IOException -> L70
    L54:
        e = e;
        r19 = 0;
    L52:
        th = th;
        r13 = 0;
    L43:
        r10 = r15;
        ?? r22 = r13;
        ?? r110 = r12;
    L77:
        if (r10 == 0) goto L79;
        r10.disconnect();
    L79:
        if (r110 != 0) goto L90;
    L83:
        if (r22 == 0) goto L87;
        r22.close();     // Catch: IOException -> L81
    L81:
        e = move-exception;
        e.printStackTrace();
    L87:
        throw th;
    L90:
        r110.close();     // Catch: IOException -> L81
    L58:
        e = e;
        r12 = 0;
        r15 = r15;
    L60:
        r19 = r12;
    L56:
        th = th;
        r12 = 0;
        r13 = 0;
    L42:
        th = th;
    L63:
        e = e;
        r15 = 0;
        r12 = 0;
    L61:
        th = th;
        r110 = 0;
        r22 = 0;
        goto L77
    }

    public final String b(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return "";
    L7:
        return BaseApplication.c().getString(R.string.share_text_example, new Object[]{r10, r11 + "&source=share&version=2"});
    }

    public final String c(String[] r10) {
        return null;
    }

    public final String[] d(String r10, boolean r11) {
        String r12 = com.bytedanceos.appstore.utils.a.i(com.bytedanceos.appstore.network.a.i0(r10), true);
        if (r12 != null) goto L6;
        j.a("json is null");
        return null;
    L6:
        String[] r13 = b.i0(r12, f9426c.length);
        if (r13 != null) goto L10;
        j.a("parse json failed:" + r12);
        return null;
    L10:
        r13[7] = "content:" + new Uri.Builder().authority("com.obric.appstore.SuggestionsProvider").appendPath("query_short_link").appendQueryParameter(ServerElements.DOWNLOAD_URL, r13[3]).appendQueryParameter("app_name", r13[1]).build().toString();
        if (r11 == true) goto L13;
    L21:
        r13[9] = b(r13[1], r13[9]);
        j.a("search finish:" + r10);
        return r13;
    L13:
        if (com.bytedanceos.appstore.datacache.a.N0().b0(r13[2]) == false) goto L16;
        j.a("app isInstalled,value = " + r13[2]);
        return null;
    L16:
        File r14 = a(r13[0]);
        if (r14 != null) goto L20;
        j.a("icon is not exit:" + r14);
        return null;
    L20:
        r13[0] = r14.getAbsolutePath();
        goto L21
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        boolean r15 = false;
        BaseApplication.u("SuggestionsProvider", false);
        if (SystemProperties.getInt("persist.radio.cta.test.mode", 0) != 1) goto L6;
        j.a("current mode is cta mode and do not support search online apps");
        BaseApplication.u("SuggestionsProvider", true);
        return null;
    L6:
        String[] r16 = f9426c;
        MatrixCursor r17 = new MatrixCursor(r16);
        int r18 = f9427d.match(r10);
        if (r18 != 0) goto L9;
        if (r13 != null) goto L19;
    L47:
        return r17;
    L19:
        if (r13.length == 0) goto L47;
        if (com.bytedanceos.appstore.utils.a.p(getContext()) == true) goto L25;
        j.a("Network is not available!");
        return r17;
    L25:
        String r19 = r13[0];
        String[] r20 = (String[]) this.f9429b.get(r19);
        String r21 = r10.getQueryParameter("check_install");     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r21) == true) goto L33;
        if (Integer.parseInt(r21) != 1) goto L33;
    L34:
        if (r20 != null) goto L36;
    L42:
        r20 = d(r19, r15);
        if (r20 == null) goto L46;
    L45:
        this.f9429b.put(r19, r20);
        r17.addRow(r20);
    L46:
        BaseApplication.u("SuggestionsProvider", true);
        goto L47
    L36:
        if (r20.length <= 0) goto L42;
        if (r15 == true) goto L39;
    L41:
        this.f9429b.remove(r19);
        goto L45
    L39:
        if (com.bytedanceos.appstore.datacache.a.N0().b0(r20[2]) == false) goto L41;
        j.a("app isInstalled,value = " + r20[2]);
    L33:
        r15 = true;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L9:
        if (r18 != 3) goto L46;
        String r22 = r10.getQueryParameter(ServerElements.DOWNLOAD_URL);
        String r23 = r10.getQueryParameter("app_name");
        if (TextUtils.isEmpty(r22) == true) goto L46;
        if (TextUtils.isEmpty(r23) == true) goto L46;
        String[] r24 = new String[r16.length];
        r24[8] = AdReportParam.ClickPosType.SKIP;
        r24[9] = c(new String[]{r23, r22});
        r17.addRow(r24);
        goto L46
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        return 0;
    }
}
