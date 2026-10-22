package com.bytedance.frameworks.baselib.network.http.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f7521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f7522b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f7523c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f7524d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile List f7525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile List f7526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f7527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile List f7528h;

    static {
        f7525e = new ArrayList();
        f7526f = new ArrayList();
        f7527g = false;
        f7528h = new ArrayList();
    }

    public static String a(String r10, String r11) {
        if (f7524d == true) goto L6;
        return r10;
    L6:
        if (r11.equals("https") == false) goto L9;
        String r12 = HttpHost.DEFAULT_SCHEME_NAME;
    L13:
        if (com.bytedance.common.utility.e.b(r12) == false) goto L15;
        return r10;
    L15:
        return r10.replaceFirst(r11, r12);
    L9:
        if (r11.equals("wss") == false) goto L11;
        r12 = "ws";
        goto L13
    L11:
        r12 = null;
        goto L13
    }

    public static int b(String r10, String r11, int r12) {
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L11;
        if (r13 != 0) goto L6;
        int r15 = 0;
    L7:
        r14 = r10.indexOf(r11, r15);
        if (r14 == (-1)) goto L9;
        r13 = r13 + 1;
        goto L3
    L9:
        return 0;
    L6:
        r15 = r14 + 1;
        goto L7
    L11:
        return r14;
    }

    public static String c(Context r10, String r11) {
        InputStream r12 = null;
        r12 = r10.getAssets().open(r11);     // Catch: Throwable -> L8
        byte[] r13 = new byte[r12.available()];     // Catch: Throwable -> L8
        r12.read(r13);     // Catch: Throwable -> L8
        String r14 = new String(r13, "UTF-8");     // Catch: Throwable -> L8
        r12.close();     // Catch: IOException -> L6
        return r14;
    L6:
        e = move-exception;
        e.printStackTrace();
        return r14;
    L8:
        if (r12 != null) goto L17;
    L13:
        return "";
    L17:
        r12.close();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static boolean d(String r10, String r11) {
        if (f7525e.isEmpty() == true) goto L5;
    L9:
        Iterator r12 = f7525e.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        if (i.i(r10, (String) r12.next()) == false) goto L11;
        return true;
    L15:
        Iterator r13 = f7526f.iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        if (i.i(r11, (String) r13.next()) == false) goto L17;
        return true;
    L21:
        String r14 = r10 + r11;
        Iterator r15 = f7528h.iterator();
    L23:
        if (r15.hasNext() == false) goto L27;
        if (((Pattern) r15.next()).matcher(r14).matches() == false) goto L23;
        return true;
    L27:
        return false;
    L5:
        if (f7526f.isEmpty() == false) goto L9;
        if (f7528h.isEmpty() == false) goto L9;
        return false;
    }

    public static boolean e(Context r10) {
        String r11 = r10.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(r11) == true) goto L14;
        if (new File(r11 + LibrarianImpl.Constants.SEPARATOR + "ttnet_boe.flag").exists() == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L14:
        return false;
    }

    public static boolean f(Context r10) {
        String r11 = c(r10, "ttnet_config.json");
        if (TextUtils.isEmpty(r11) == false) goto L11;
    L10:
        return false;
    L11:
        if (new JSONObject(r11).optBoolean("boe_proxy_enabled", false) == false) goto L10;
        return true;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static String g(String r10, String r11) {
        if (TextUtils.isEmpty(f7522b) == false) goto L5;
        return r10;
    L5:
        String[] r12 = r11.split("\\.");
        int r13 = r12.length;
        if (r13 >= 2) goto L8;
        return r10;
    L8:
        if (r13 != 2) goto L10;
        int r14 = 0;
        String r15 = r12[0];
    L12:
        if (r15.contains(f7522b) == false) goto L15;
        return r10;
    L15:
        return h(r10, r14, r15, r15 + f7522b);
    L10:
        int r16 = r13 - 3;
        r15 = r12[r16];
        r14 = b(r11, LibrarianImpl.Constants.DOT, r16);
        goto L12
    }

    public static String h(String r10, int r11, String r12, String r13) {
        return r10.substring(0, r11) + r10.substring(r11).replaceFirst(r12, r13);
    }

    public static void i(String r10) {
        f7522b = r10;
        if (TextUtils.isEmpty(r10) == true) goto L6;
        f7524d = false;
        return;
    }

    public static void j(String r10) {
        f7521a = r10;
        if (TextUtils.isEmpty(r10) == true) goto L6;
        f7524d = true;
        return;
    }

    public static String k(Context r10, String r11, List r12) {
        if (f7527g == true) goto L15;
        if (f7523c == true) goto L15;
        if (f(r10) == false) goto L9;
    L12:
        boolean r13 = true;
    L13:
        f7523c = r13;
        f7527g = true;
        goto L15
    L9:
        if (e(r10) == true) goto L12;
        r13 = false;
    L15:
        if (f7523c == true) goto L17;
    L59:
        return r11;
    L17:
        if (TextUtils.isEmpty(f7521a) == true) goto L19;
    L21:
        Uri r14 = Uri.parse(r11);
        if (com.bytedance.common.utility.e.b(r14.getScheme()) == true) goto L59;
        if (com.bytedance.common.utility.e.b(r14.getHost()) == true) goto L59;
        if (com.bytedance.common.utility.e.b(r14.getPath()) == true) goto L59;
        if (d(r14.getHost(), r14.getPath()) == false) goto L31;
        return r11;
    L31:
        Iterator r15 = r12.iterator();
    L33:
        if (r15.hasNext() == false) goto L44;
        g6.a r16 = (g6.a) r15.next();
        if (com.bytedance.common.utility.e.b(r16.a()) == true) goto L33;
        if (com.bytedance.common.utility.e.b(r16.b()) == true) goto L33;
        if (r16.a().equals("bypass-boe") == false) goto L33;
        if (r16.b().equals("1") == false) goto L33;
        return r11;
    L44:
        r11 = a(r11, r14.getScheme());
        if (c.a(r14.getHost()) == true) goto L59;
        if (c.c(r14.getHost()) == true) goto L59;
        if (c.b(r14.getHost()) == true) goto L59;
        if (f7524d == false) goto L58;
        String r17 = r14.getHost();
        if (r17.contains(f7521a) == false) goto L56;
        return r11;
    L56:
        return r11.replaceFirst(r17, r17 + f7521a);
    L58:
        return g(r11, r14.getHost());
    L19:
        if (TextUtils.isEmpty(f7522b) == false) goto L21;
        goto L21
    }
}
