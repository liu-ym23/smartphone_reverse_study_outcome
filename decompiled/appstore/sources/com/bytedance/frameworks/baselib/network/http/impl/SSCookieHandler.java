package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.c;
import com.bytedance.common.utility.e;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import r4.d;

/* JADX INFO: loaded from: classes.dex */
public class SSCookieHandler extends CookieManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f7299f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f7300g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final android.webkit.CookieManager f7301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile r4.a f7302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pattern f7303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ICookieEventHandler f7304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f7305e;

    public interface ICookieEventHandler {
        void onEvent(String r10, String r11, JSONObject r12);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SSCookieHandler f7307b;

        public a(SSCookieHandler r10, Context r11) {
            this.f7307b = r10;
            this.f7306a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSCookieHandler.a(this.f7307b, new r4.a(new d(this.f7306a), CookiePolicy.ACCEPT_ALL));
        }
    }

    static {
    }

    public SSCookieHandler(Context r10, int r11, android.webkit.CookieManager r12, ArrayList r13, ICookieEventHandler r14) {
        this.f7303c = Pattern.compile("(?<=Domain=)([^;]*)", 2);
        if (r11 <= 0) goto L5;
        w3.a.b().schedule(new a(this, r10), r11, TimeUnit.SECONDS);
    L6:
        this.f7301a = r12;
        this.f7305e = r13;
        this.f7304d = r14;
        JSONObject r15 = new JSONObject();
        r15.put("init", "success");     // Catch: JSONException -> L9
    L11:
        ICookieEventHandler r16 = this.f7304d;
        if (r16 == null) goto L17;
        r16.onEvent("TTNET-COOKIE", "init", r15);
        return;
    L17:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        this.f7302b = new r4.a(new d(r10), CookiePolicy.ACCEPT_ALL);
        goto L6
    }

    public static /* synthetic */ r4.a a(SSCookieHandler r10, r4.a r11) {
        r10.f7302b = r11;
        return r11;
    }

    public final void b(String r10, boolean r11) {
        if (r11 == false) goto L6;
        android.webkit.CookieManager.getInstance().flush();
        Logger.d("SSCookieHandler", "Force flush cookie: " + r10);
        return;
    L6:
        ArrayList r12 = this.f7305e;
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isEmpty() == true) goto L22;
        Iterator r13 = this.f7305e.iterator();
    L13:
        if (r13.hasNext() == false) goto L23;
        if (r10.equals((String) r13.next()) == false) goto L13;
        android.webkit.CookieManager.getInstance().flush();
        Logger.d("SSCookieHandler", "Path match flush cookie: " + r10);
        return;
    L23:
        return;
    }

    public final Map c(List r10, Map r11) {
        Map r12 = Collections.emptyMap();
        if (f7299f == false) goto L20;
        LinkedHashMap r13 = new LinkedHashMap();
        if (r11 == null) goto L11;
        List r14 = d(r11, "Cookie");
        if (r14 != null) goto L9;
    L10:
        r13.put("Cookie", r10);
    L13:
        if (r11 == null) goto L19;
        List r15 = d(r11, "X-SS-Cookie");
        if (r15 != null) goto L17;
    L18:
        r13.put("X-SS-Cookie", r10);
        return r13;
    L17:
        if (r15.isEmpty() == true) goto L18;
        return r13;
    L19:
        r13.put("X-SS-Cookie", r10);
        return r13;
    L9:
        if (r14.isEmpty() == false) goto L13;
    L11:
        r13.put("Cookie", r10);
        goto L13
    L20:
        if (r11 == null) goto L27;
        List r16 = d(r11, "Cookie");
        if (r16 == null) goto L32;
        if (r16.isEmpty() == true) goto L32;
        return r12;
    L32:
        return Collections.singletonMap("Cookie", r10);
    L27:
        return Collections.singletonMap("Cookie", r10);
    }

    public final List d(Map r10, String r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        List r12 = (List) r10.get(r11);
        if (r12 == null) goto L11;
        if (r12.isEmpty() == true) goto L11;
        return r12;
    L11:
        return (List) r10.get(r11.toLowerCase());
    L15:
        return null;
    }

    public final boolean e(URI r10, String r11) {
        if (r10 != null) goto L5;
    L19:
        return false;
    L5:
        if (e.b(r11) == true) goto L19;
        String r12 = r10.getHost().toLowerCase();     // Catch: Throwable -> L10
        String r13 = "";
        Matcher r14 = this.f7303c.matcher(r11);     // Catch: Throwable -> L10
        if (r14.find() == false) goto L13;
        r13 = r14.group().toLowerCase();     // Catch: Throwable -> L10
    L13:
        if (TextUtils.isEmpty(r13) == true) goto L22;
        if (r12.endsWith(r13) == false) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L19
    }

    public final void f(JSONObject r10, String r11, boolean r12) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f7304d == null) goto L13;
        if (r12 == false) goto L14;
        r10.put("return", r11);     // Catch: JSONException -> L10
    L8:
        this.f7304d.onEvent("TTNET-COOKIE", "put", r10);
        return;
    L14:
        return;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map get(URI r10, Map r11) {
        android.webkit.CookieManager r12 = null;
        String r13 = r10.toString();     // Catch: Throwable -> L32
        if (r11 != null) goto L88;
    L21:
        NetworkParams.AppCookieStore r14 = NetworkParams.e();     // Catch: Throwable -> L17
        if (r14 == null) goto L35;
        Map<String, List<String>> r15 = r14.get(r10, r11);     // Catch: Throwable -> L17
        if (r15 == null) goto L35;
        if (r15.isEmpty() == true) goto L35;
        if (r15.containsKey("Cookie") == false) goto L30;
    L31:
        return r15;
    L30:
        if (r15.containsKey("X-SS-Cookie") == true) goto L31;
    L35:
        if (r10 == null) goto L85;
        if (this.f7301a == null) goto L85;
        NetworkParams.CookieShareInterceptor r16 = NetworkParams.i();     // Catch: Throwable -> L49
        if (r16 == null) goto L52;
        if (f7300g == true) goto L45;
        r12 = this.f7301a;     // Catch: Throwable -> L49
    L45:
        List<String> r17 = r16.getShareCookie(r12, this.f7302b, r10);     // Catch: Throwable -> L49
        if (c.a(r17) == true) goto L52;
        return c(r17, r11);
    L52:
        if (f7300g == true) goto L66;
        String r18 = this.f7301a.getCookie(r13);     // Catch: Exception -> L60
        if (r18 == null) goto L66;
        if (r18.length() <= 0) goto L66;
        if (Logger.debug() == false) goto L62;
        Logger.v("SSCookieHandler", "send cookie: " + r13 + " " + r18);     // Catch: Exception -> L60
    L62:
        return c(Collections.singletonList(r18), r11);
    L60:
        e = move-exception;
        e.printStackTrace();
    L66:
        if (this.f7302b == null) goto L68;
        r4.a r19 = this.f7302b;     // Catch: Throwable -> L72
        if (r11 != null) goto L74;
        Map r20 = new LinkedHashMap();     // Catch: Throwable -> L72
    L75:
        Map r21 = r19.get(r10, r20);     // Catch: Throwable -> L72
        if (r21 == null) goto L83;
        if (r21.isEmpty() == true) goto L83;
        return c((List) r21.get("Cookie"), r11);
    L83:
        return Collections.emptyMap();
    L74:
        r20 = r11;
    L72:
        th = move-exception;
        th.printStackTrace();
        goto L83
    L68:
        return Collections.emptyMap();
    L49:
        th = move-exception;
        th.printStackTrace();
    L85:
        return Collections.emptyMap();
    L88:
        List r22 = d(r11, "X-SS-No-Cookie");     // Catch: Throwable -> L17
        if (r22 == null) goto L21;
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L17
    L9:
        if (r23.hasNext() == false) goto L21;
        String r24 = (String) r23.next();     // Catch: Throwable -> L17
        if (r24 == null) goto L9;
        if (Boolean.parseBoolean(r24) == false) goto L9;
        if (Logger.debug() == false) goto L20;
        Logger.v("SSCookieHandler", "X-SS-No-Cookie " + r13);     // Catch: Throwable -> L17
    L20:
        return Collections.emptyMap();
    L17:
        th = th;
    L34:
        th.printStackTrace();
    L32:
        th = th;
        r13 = null;
        goto L34
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r22, Map r23) {
        NetworkParams.CookieShareInterceptor r10 = NetworkParams.i();
        if (r10 == null) goto L6;
        List<String> r11 = r10.getShareCookieHostList(r22.getHost());
    L5:
        List<String> r12 = r11;
        JSONObject r13 = new JSONObject();
        int r14 = 0;
        if (r23 != null) goto L10;
    L12:
        boolean r15 = false;
    L14:
        String r16 = "";
        if (r12 != null) goto L152;
        String r17 = "";
    L18:
        r13.put("shareHostList", r17);     // Catch: JSONException -> L145
        if (r15 == false) goto L22;
        r13.put("responseHeaders", r23.toString());     // Catch: JSONException -> L145
    L22:
        if (r22 == null) goto L25;
        r16 = r22.toString();     // Catch: JSONException -> L145
    L25:
        r13.put("url", r16);     // Catch: JSONException -> L145
    L165:
        NetworkParams.AppCookieStore r18 = NetworkParams.e();     // Catch: Throwable -> L30
        if (r18 == null) goto L33;
        r18.put(r22, r23);     // Catch: Throwable -> L30
    L33:
        if (f7300g == true) goto L101;
        if (r22 == null) goto L98;
        if (r23 == null) goto L98;
        if (this.f7301a == null) goto L98;
        String r19 = r22.toString();
        if (f7299f == false) goto L42;
        String[] r110 = {"X-SS-Set-Cookie", "Set-Cookie"};
    L43:
        int r111 = r110.length;
        boolean r112 = false;
    L44:
        if (r14 >= r111) goto L161;
        String r113 = r110[r14];
        List r114 = (List) r23.get(r113);
        if (r114 != null) goto L48;
    L49:
        r114 = (List) r23.get(r113.toLowerCase());
        if (r114 == null) goto L95;
        if (r114.isEmpty() == true) goto L95;
    L163:
        r13.put("cookieMgrList", r114.toString());     // Catch: JSONException -> L146
    L59:
        Iterator r20 = r114.iterator();
    L61:
        if (r20.hasNext() == false) goto L95;
        String r115 = (String) r20.next();
        Iterator r116 = r20;
        if (r115.toLowerCase().trim().contains("sessionid=") == false) goto L65;
        r112 = true;
    L65:
        this.f7301a.setCookie(r19, r115);
        if (c.a(r12) == false) goto L69;
        int r21 = r111;
    L94:
        r20 = r116;
        r111 = r21;
        goto L61
    L69:
        Iterator<String> r24 = r12.iterator();     // Catch: Throwable -> L149
    L71:
        if (r24.hasNext() == false) goto L91;
        String r117 = r24.next();     // Catch: Throwable -> L149
        if (e.b(r117) == true) goto L71;
        Iterator<String> r118 = r24;
        if (r22.getHost().endsWith(r117) == true) goto L79;
        if (e(r22, r115) == false) goto L79;
        String r25 = this.f7303c.matcher(r115).replaceFirst(r117);     // Catch: Throwable -> L148
        if (e.b(r25) == true) goto L88;
        int r26 = r111;
        this.f7301a.setCookie(r117, r25);     // Catch: Throwable -> L147
    L90:
        r24 = r118;
        r111 = r26;
    L79:
        r24 = r118;
    L88:
        r26 = r111;
    L89:
        r118 = r24;
    L91:
        r21 = r111;
        if (Logger.debug() == false) goto L94;
        Logger.v("SSCookieHandler", "receive cookie: " + r19 + " " + r113 + ": " + r115);
    L95:
        r14 = r14 + 1;
        r110 = r110;
        r111 = r111;
        goto L44
    L48:
        if (r114.isEmpty() == false) goto L163;
    L161:
        b(r22.getPath(), r112);     // Catch: Throwable -> L150
        goto L101
    L42:
        r110 = new String[]{"Set-Cookie"};
    L98:
        f(r13, "uri responseHeaders or mCookieMgr is null", r15);
        return;
    L101:
        if (this.f7302b != null) goto L154;
        f(r13, "mAppCookieMgr is null", r15);
        return;
    L154:
        LinkedHashMap r27 = new LinkedHashMap();     // Catch: Throwable -> L111
        if (f7299f == true) goto L107;
    L113:
        r27.putAll(r23);     // Catch: Throwable -> L111
        this.f7302b.put(r22, r27);     // Catch: Throwable -> L111
        if (c.a(r12) == false) goto L117;
        f(r13, "isInShareCookieList is false", r15);     // Catch: Throwable -> L111
        return;
    L117:
        Iterator<String> r28 = r12.iterator();     // Catch: Throwable -> L111
    L119:
        if (r28.hasNext() == false) goto L143;
        String r29 = r28.next();     // Catch: Throwable -> L111
        if (e.b(r29) == true) goto L119;
        if (r22.getHost().endsWith(r29) == true) goto L119;
        List r30 = (List) r23.get("Set-Cookie");     // Catch: Throwable -> L151
        if (r30 != null) goto L131;
        f(r13, "cookieList is null", r15);     // Catch: Throwable -> L151
        return;
    L131:
        LinkedList r119 = new LinkedList();     // Catch: Throwable -> L151
        Iterator r31 = r30.iterator();     // Catch: Throwable -> L151
    L133:
        if (r31.hasNext() == false) goto L140;
        String r120 = (String) r31.next();     // Catch: Throwable -> L151
        if (e(r22, r120) == false) goto L133;
        String r121 = this.f7303c.matcher(r120).replaceFirst(r29);     // Catch: Throwable -> L151
        if (e.b(r121) == true) goto L133;
        r119.add(r121);     // Catch: Throwable -> L151
        goto L133
    L140:
        r27.put("Set-Cookie", r119);     // Catch: Throwable -> L151
        this.f7302b.put(URI.create(r22.getScheme() + "://" + r29), r27);     // Catch: Throwable -> L151
    L143:
        f(r13, "last return", r15);
        return;
    L107:
        if (r23.containsKey("X-SS-Set-Cookie") == false) goto L113;
        if (r23.containsKey("Set-Cookie") == true) goto L113;
        r27.put("Set-Cookie", r23.get("X-SS-Set-Cookie"));     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        th.printStackTrace();
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L33
    L152:
        r17 = r12.toString();     // Catch: JSONException -> L145
        goto L18
    L10:
        if (r23.containsKey("Set-Cookie") == false) goto L12;
        r15 = true;
        goto L14
    L6:
        r11 = null;
        goto L5
    }
}
