package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.e;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UnknownFormatConversionException;
import org.json.JSONObject;
import q4.g;
import w4.c;
import y4.d;

/* JADX INFO: loaded from: classes.dex */
public class SsCronetHttpClient implements IHttpClient, ICronetClient.ICronetBootFailureChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7235a = "SsCronetHttpClient";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7236b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f7237c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ICronetClient f7238d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile SsCronetHttpClient f7239e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f7240f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile int f7241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ICronetBootFailureChecker f7242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ICronetHttpDnsConfig f7243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ITncInfoGet f7244j;

    public interface ICronetBootFailureChecker {
        boolean isCronetBootFailureExpected();
    }

    public interface ICronetHttpDnsConfig {
        boolean isCronetHttpDnsOpen();
    }

    public interface ITncInfoGet {
        JSONObject getABTest();
    }

    static {
    }

    public SsCronetHttpClient(Context r10) {
        f7237c = r10.getApplicationContext();
    }

    public static boolean A(BaseHttpRequestInfo r10) {
        if (r10 == null) goto L10;
        o4.a r11 = r10.f7163b;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.f22487j == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static /* synthetic */ void B(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        C(r10, r11, r12, r13, r14, r15, r16, r17);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void C(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        ICronetClient r18 = f7238d;
        if (r18 == null) goto L7;
        Reflect.on(r18).call("notifyStoreRegionUpdated", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r10, r11, r12, r13, r14, r15, r16, r17}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void E(SharedPreferences r10) {
        f7241g = r10.getInt("cronet_inputstream_buff_size", 0);
    }

    public static void F(SharedPreferences.Editor r10) {
        r10.putInt("cronet_inputstream_buff_size", f7241g);
    }

    public static void G(JSONObject r10) {
        f7241g = r10.optInt("cronet_inputstream_buff_size", 0);
    }

    public static HttpURLConnection H(String r10) {
        d0();
        ICronetClient r11 = f7238d;
        if (r11 == null) goto L12;
        r11.setCronetBootFailureChecker(f7239e);
        ICronetClient r12 = f7238d;
        Context r13 = f7237c;
        ICronetHttpDnsConfig r14 = f7243i;
        if (r14 != null) goto L8;
        boolean r15 = false;
    L7:
        boolean r16 = r15;
        HttpURLConnection r17 = r12.openConnection(r13, r10, r16, NetworkParams.m(), new c());
        r17.setConnectTimeout(NetworkParams.g());
        r17.setReadTimeout(NetworkParams.k());
        return r17;
    L8:
        r15 = r14.isCronetHttpDnsOpen();
        goto L7
    L12:
        throw new IllegalArgumentException("CronetClient is null");
    }

    public static void J(HttpURLConnection r10, g6.b r11) {
        r10.setRequestMethod(r11.x());
        r10.setDoInput(true);
        Iterator r12 = r11.u().iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L14;
        g6.a r14 = (g6.a) r12.next();
        if (e.b(r14.a()) == true) goto L4;
        if (e.b(r14.b()) == true) goto L4;
        if ("User-Agent".equalsIgnoreCase(r14.a()) == false) goto L13;
        r13 = true;
    L13:
        r10.setRequestProperty(r14.a(), r14.b());
        goto L4
    L14:
        if (r13 == true) goto L21;
        String r15 = NetworkParams.m();
        if (e.b(r15) == true) goto L21;
        if (f7238d == null) goto L20;
        r15 = r15 + " cronet/" + f7238d.getCronetVersion();
    L20:
        r10.setRequestProperty("User-Agent", r15);
    L21:
        TypedOutput r16 = r11.r();
        if (r16 == null) goto L38;
        r10.setDoOutput(true);
        r10.setRequestProperty("Content-Type", r16.mimeType());
        String r17 = r16.md5Stub();
        if (r17 == null) goto L26;
        r10.setRequestProperty("X-SS-STUB", r17);
    L26:
        long r18 = r16.length();
        if (r18 == (-1)) goto L29;
        r10.setFixedLengthStreamingMode((int) r18);
        r10.setRequestProperty("Content-Length", String.valueOf(r18));
        return;
    L29:
        r10.setChunkedStreamingMode(4096);
        return;
    }

    public static String K(HttpURLConnection r10, BaseHttpRequestInfo r11, int r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        v(q(r10, "x-net-info.remoteaddr"), r11);
        if (r11 == null) goto L11;
        o4.a r13 = r11.f7163b;
        if (r13 == null) goto L11;
        r13.f22479b = r12;
    L11:
        return q(r10, "X-TT-LOGID");
    }

    public static void L(String r11, long r12, BaseHttpRequestInfo r14, String r15, Exception r16, HttpURLConnection r17, RetrofitMetrics r18) {
        if (r11 == null) goto L28;
        if (r16 == null) goto L29;
        if (r14 == null) goto L31;
    L10:
        th = move-exception;
        th.printStackTrace();
    L18:
        if (e.b(r14.f7162a) == false) goto L20;
        v(r(r16), r14);
    L20:
        long r10 = System.currentTimeMillis() - r12;
        r14.f7169h = System.currentTimeMillis();
        w(r17, r14, r18);
        NetworkParams.n(r11, r16, r10, r14);
        NetworkParams.q(r10, r12, r11, r15, r14, r16);
        if (r14.A == false) goto L23;
        r14.f7161J.set(true);
    L23:
        if (r17 == null) goto L30;
        r17.disconnect();
        return;
    L30:
        return;
    L8:
        if (r14.f7187z != null) goto L12;
        r14.f7187z = g(r17);     // Catch: Throwable -> L10
    L12:
        r14.f7187z.put("ex", r16.getMessage());     // Catch: Throwable -> L10
        String r13 = k(r17);     // Catch: Throwable -> L10
        if (e.b(r13) == true) goto L18;
        r14.f7187z.put("response-headers", r13);     // Catch: Throwable -> L10
        goto L18
    L31:
        return;
    L29:
        return;
    }

    public static int M(g6.b r10, HttpURLConnection r11) {
        if (r10 == null) goto L15;
        if (r11 == null) goto L17;
        TypedOutput r12 = r10.r();
        if (r12 == null) goto L9;
        r12.writeTo(r11.getOutputStream());
    L9:
        if (NetworkParams.t() == false) goto L14;
        if (NetworkParams.p(r10.s()) == true) goto L14;
        NetworkParams.I();
        Logger.d(f7235a, "newCookieBlockPositionEnabled true:" + r10.D());
    L14:
        return r11.getResponseCode();
    L17:
        return -1;
    L15:
        return -1;
    }

    public static void N(HttpURLConnection r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.disconnect();
    }

    public static void O(boolean r10, Map r11, int r12, InputStream r13, String r14, String r15, RetrofitMetrics r16) {
        if (r13 != null) goto L4;
        return;
    L4:
        int[] r17 = new int[1];
        r17[0] = 0;     // Catch: Throwable -> L32
        byte[] r18 = v4.c.g(r10, r11, r12, r13, r17, r16);     // Catch: Throwable -> L32
        v4.c.i(r13);
        int r19 = r17[0];
        byte[] r110 = new byte[r19];
        if (r18 == null) goto L10;
        if (r19 <= 0) goto L10;
        System.arraycopy(r18, 0, r110, 0, r19);
    L10:
        if (r19 > 0) goto L12;
        return;
    L12:
        if (e.b(r14) == false) goto L14;
        return;
    L14:
        if (Logger.debug() == false) goto L41;
        MimeType r20 = new MimeType(r14);     // Catch: Throwable -> L20
        if ("text".equalsIgnoreCase(r20.getPrimaryType()) == false) goto L18;
    L22:
        String r21 = r20.getParameter("charset");     // Catch: Throwable -> L20
        if (e.b(r21) == false) goto L25;
        r21 = "utf-8";
    L25:
        String r22 = f7235a;     // Catch: Throwable -> L20
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L20
        r111.append(" response body = ");     // Catch: Throwable -> L20
        r111.append(new String(r110, r21));     // Catch: Throwable -> L20
        r111.append(" for url = ");     // Catch: Throwable -> L20
        if (r15 != null) goto L28;
        r15 = "";
    L28:
        r111.append(r15);     // Catch: Throwable -> L20
        Logger.d(r22, r111.toString());     // Catch: Throwable -> L20
        return;
    L18:
        if ("application/json".equalsIgnoreCase(r20.getBaseType()) == true) goto L22;
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L41:
        return;
    L32:
        th = move-exception;
        v4.c.i(r13);
        throw th;
    }

    public static byte[] P(String r15, int r16, HttpURLConnection r17, long r18, BaseHttpRequestInfo r20, String r21, int r22, RetrofitMetrics r23) {
        if (r17 == null) goto L5;
        boolean r10 = "gzip".equals(q(r17, "Content-Encoding"));
        ICronetClient r11 = f7238d;
        if (r11 != null) goto L9;
    L11:
        boolean r13 = r10;
    L12:
        String r14 = q(r17, "Content-Type");
        if (r22 != 200) goto L15;
    L34:
        r20.f7168g = System.currentTimeMillis();
        InputStream r12 = r17.getInputStream();     // Catch: Exception -> L37
    L36:
        InputStream r19 = r12;
        int[] r24 = new int[1];
        r24[0] = 0;     // Catch: Throwable -> L53
        byte[] r25 = v4.c.g(r13, r17.getHeaderFields(), r16, r19, r24, r23);     // Catch: Throwable -> L53
        v4.c.i(r19);
        int r26 = r24[0];
        byte[] r110 = new byte[r26];
        if (r25 == null) goto L48;
        if (r26 <= 0) goto L48;
        System.arraycopy(r25, 0, r110, 0, r26);
    L48:
        if (v4.c.k(r14) == false) goto L50;
        v4.c.a(r110, r26);
    L50:
        long r27 = System.currentTimeMillis() - r18;
        r20.f7169h = System.currentTimeMillis();
        w(r17, r20, r23);
        NetworkParams.o(r15, r27, r20);
        NetworkParams.s(r27, r18, r15, r21, r20);
        StoreRegionManager.m().s(r17, r110, new q4.e());     // Catch: Throwable -> L57
    L52:
        return r110;
    L53:
        th = move-exception;
        v4.c.i(r19);
        throw th;
    L37:
        e = move-exception;
        if (A(r20) == false) goto L56;
        r12 = r17.getErrorStream();
        goto L36
    L56:
        throw e;
    L15:
        if (A(r20) == true) goto L34;
        if (r22 != 304) goto L20;
        r20.f7168g = System.currentTimeMillis();
        long r28 = System.currentTimeMillis() - r18;
        r20.f7169h = System.currentTimeMillis();
        w(r17, r20, r23);
        NetworkParams.o(r15, r28, r20);
        NetworkParams.s(r28, r18, r15, r21, r20);
    L20:
        String r111 = r17.getResponseMessage();
        InputStream r29 = r17.getInputStream();     // Catch: Throwable -> L23 Exception -> L25
    L26:
        O(r13, r17.getHeaderFields(), r16, r29, r14, r15, r23);     // Catch: Throwable -> L23
    L32:
        r17.disconnect();
        throw new HttpResponseException(r22, r111);
    L25:
        r29 = r17.getErrorStream();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
        StringBuilder r30 = new StringBuilder();
        r30.append("reason = ");
        if (r111 != null) goto L31;
        r111 = "";
    L31:
        r30.append(r111);
        r30.append("  exception = ");
        r30.append(th.getMessage());
        r111 = r30.toString();
        goto L32
    L9:
        if (r11.isCronetHttpURLConnection(r17) == false) goto L11;
        r13 = false;
        goto L12
    L5:
        return new byte[0];
    }

    public static void T(boolean r10) {
        f7240f = r10;
    }

    public static void U(ICronetBootFailureChecker r10) {
        f7242h = r10;
    }

    public static void W(ICronetHttpDnsConfig r10) {
        f7243i = r10;
    }

    public static void X(ITncInfoGet r10) {
        f7244j = r10;
    }

    public static /* synthetic */ void a(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        B(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static boolean a0(HttpURLConnection r10, BaseHttpRequestInfo r11, int r12) {
        Map<String, List<String>> r13 = r10.getHeaderFields();
        if (r13 != null) goto L5;
    L16:
        return false;
    L5:
        if (r13.containsKey("bdturing-verify") == false) goto L16;
        String r14 = r10.getRequestProperty("x-tt-bypass-bdturing");
        if (TextUtils.isEmpty(r14) == false) goto L10;
    L12:
        TreeMap r15 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r15.putAll(r13);
        long r16 = SystemClock.uptimeMillis();
        boolean r17 = NetworkParams.E(r12, r15);
        r11.H = SystemClock.uptimeMillis() - r16;
        if (r15.containsKey("bdturing-verify") == true) goto L15;
        r11.G = true;
    L15:
        return r17;
    L10:
        if (r14.equalsIgnoreCase("1") == false) goto L12;
        return false;
    }

    public static void c0(g6.b r10) {
        NetworkParams.H();
        if (NetworkParams.t() == false) goto L5;
        return;
    L5:
        if (NetworkParams.p(r10.s()) == true) goto L9;
        NetworkParams.I();
        Logger.d(f7235a, "newCookieBlockPositionEnabled false:" + r10.D());
        return;
    }

    public static void d(boolean r10, String r11) {
        if (f7240f == true) goto L13;
        if (r10 == true) goto L13;
        Context r12 = f7237c;
        if (r12 == null) goto L13;
        if (NetworkUtils.l(r12) == true) goto L13;
        throw new NetworkNotAvailabeException("network not available");
    L13:
        if (f7240f == true) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r11) == false) goto L17;
        return;
    L17:
        if (r11.contains("net::ERR_INTERNET_DISCONNECTED") == true) goto L20;
        return;
    L20:
        throw new NetworkNotAvailabeException("network not available");
    }

    public static void d0() {
        if (f7238d == null) goto L5;
        return;
    L5:
        if (e.b(f7236b) == true) goto L7;
        String r10 = f7236b;
    L8:
        Logger.w(f7235a, "tryResolveImpl:" + r10);
        Object r11 = Class.forName(r10).newInstance();     // Catch: Throwable -> L13
        if ((r11 instanceof ICronetClient) == false) goto L19;
        f7238d = (ICronetClient) r11;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w(f7235a, "load CronetClient exception: " + th);
        return;
    L7:
        r10 = "org.chromium.CronetClient";
        goto L8
    }

    public static HttpURLConnection f(String r11, g6.b r12, BaseHttpRequestInfo r13, long r14) {
        c0(r12);
        HttpURLConnection r15 = H(r11);
        if (z(f7241g) == true) goto L72;
    L8:
        r15.setInstanceFollowRedirects(true);
        if (r13.f7163b == null) goto L68;
        o4.a r10 = r13.f7163b;
        long r16 = r10.f22480c;
        if (r16 <= 0) goto L13;
        r15.setConnectTimeout((int) r16);
    L13:
        long r17 = r10.f22481d;
        if (r17 <= 0) goto L17;
        r15.setReadTimeout((int) r17);
    L17:
        if (r10.f22486i <= 0) goto L31;
        Reflect r18 = Reflect.on(r15);     // Catch: Throwable -> L25
        Class r19 = Integer.TYPE;     // Catch: Throwable -> L25
        r18.call("setRequestTimeout", new Class[]{r19}, new Object[]{Integer.valueOf((int) r10.f22486i)});     // Catch: Throwable -> L25
        r15.setConnectTimeout(0);     // Catch: Throwable -> L25
        r15.setReadTimeout(0);     // Catch: Throwable -> L25
        if (r10.f22483f <= 0) goto L21;
    L27:
        Reflect.on(r15).call("setSocketConnectTimeout", new Class[]{r19}, new Object[]{Integer.valueOf((int) r10.f22483f)});     // Catch: Throwable -> L25
        Reflect.on(r15).call("setSocketReadTimeout", new Class[]{r19}, new Object[]{Integer.valueOf((int) r10.f22485h)});     // Catch: Throwable -> L25
        Reflect.on(r15).call("setSocketWriteTimeout", new Class[]{r19}, new Object[]{Integer.valueOf((int) r10.f22484g)});     // Catch: Throwable -> L25
        goto L31
    L21:
        if (r10.f22485h > 0) goto L27;
        if (r10.f22484g <= 0) goto L31;
    L25:
        th = move-exception;
        th.printStackTrace();
    L31:
        if (z(f7241g) == true) goto L39;
        if (z(r10.f22489l) == false) goto L39;
        Reflect.on(r15).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r10.f22489l)});     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.printStackTrace();
    L39:
        if (r10.f22490m > 0) goto L64;
    L44:
        long r20 = r10.f22491n;
        if (r20 <= 0) goto L50;
        if (r14 != 0) goto L50;
        r14 = r20;
    L50:
        if (r10.f22492o == true) goto L68;
        r15.setInstanceFollowRedirects(false);
        goto L68
    L64:
        Reflect.on(r15).call("setRequestFlag", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r10.f22490m)});     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();
    L68:
        Reflect.on(r15).call("setRequestPriority", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r12.C())});     // Catch: Throwable -> L54
    L57:
        if (r14 > 0) goto L66;
    L62:
        J(r15, r12);
        r13.f7187z = g(r15);
        return r15;
    L66:
        Reflect.on(r15).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, new Object[]{Long.valueOf(r14)});     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        th.printStackTrace();
    L54:
        th = move-exception;
        th.printStackTrace();
        goto L57
    L72:
        Reflect.on(r15).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(m())});     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static JSONObject g(HttpURLConnection r10) {
        JSONObject r11 = new JSONObject();
        if (r10 != null) goto L20;
        return r11;
    L20:
        ITncInfoGet r12 = f7244j;     // Catch: Exception -> L8
        if (r12 == null) goto L10;
        JSONObject r13 = r12.getABTest();     // Catch: Exception -> L8
    L11:
        if (r13 == null) goto L13;
        r11.put("ab_test", r13);     // Catch: Exception -> L8
    L13:
        r11.put("hc", "SsCronetHttpClient");     // Catch: Exception -> L8
        ICronetClient r14 = f7238d;     // Catch: Exception -> L8
        if (r14 == null) goto L16;
        r11.put("hcv", r14.getCronetVersion());     // Catch: Exception -> L8
    L16:
        r11.put("ua", r10.getRequestProperty("User-Agent"));     // Catch: Exception -> L8
    L19:
        return r11;
    L10:
        r13 = null;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static List h(HttpURLConnection r10, boolean r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r12 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r13 = r10.getHeaderFields().entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L18;
        Map.Entry<String, List<String>> r14 = r13.next();
        String r15 = r14.getKey();
        if (r15 == null) goto L14;
        if (r15.equalsIgnoreCase("bdturing-verify") == false) goto L14;
        if (r11 == true) goto L7;
    L14:
        Iterator<String> r16 = r14.getValue().iterator();
    L16:
        if (r16.hasNext() == false) goto L7;
        r12.add(new g6.a(r15, r16.next()));
        goto L16
    L18:
        return r12;
    }

    public static String k(HttpURLConnection r10) {
        if (r10 != null) goto L42;
        return "";
    L42:
        Map<String, List<String>> r11 = r10.getHeaderFields();     // Catch: Throwable -> L32
        if (r11 != null) goto L8;
    L39:
        return "";
    L8:
        if (r11.isEmpty() == true) goto L39;
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L32
        Iterator<Map.Entry<String, List<String>>> r13 = r11.entrySet().iterator();     // Catch: Throwable -> L32
    L12:
        if (r13.hasNext() == false) goto L37;
        Map.Entry<String, List<String>> r14 = r13.next();     // Catch: Throwable -> L32
        if (r14 == null) goto L12;
        String r15 = r14.getKey();     // Catch: Throwable -> L32
        if (e.b(r15) == true) goto L12;
        List<String> r16 = r14.getValue();     // Catch: Throwable -> L32
        if (r16 == null) goto L12;
        if (r16.isEmpty() == true) goto L12;
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L32
        Iterator<String> r18 = r16.iterator();     // Catch: Throwable -> L32
        int r19 = 0;
    L26:
        if (r18.hasNext() == false) goto L36;
        String r20 = r18.next();     // Catch: Throwable -> L32
        if (e.b(r20) == true) goto L26;
        if (r19 != 0) goto L34;
        r17.append(r20);     // Catch: Throwable -> L32
    L35:
        r19 = r19 + 1;     // Catch: Throwable -> L32
        goto L26
    L34:
        r17.append("; ");     // Catch: Throwable -> L32
        r17.append(r20);     // Catch: Throwable -> L32
        goto L35
    L36:
        r12.put(r15, r17.toString());     // Catch: Throwable -> L32
        goto L12
    L37:
        return r12.toString();
    L32:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String l(String r10) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (e.b(r10) == true) goto L12;
        return new MimeType(r10).getBaseType();
    L12:
        return "";
    }

    public static int m() {
        return f7241g;
    }

    public static int n(HttpURLConnection r10) {
        return f7238d.getCronetInternalErrorCode(r10);
    }

    public static String q(HttpURLConnection r10, String r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L13;
        String r12 = r10.getHeaderField(r11);
        if (TextUtils.isEmpty(r12) == true) goto L9;
        return r12;
    L9:
        return r10.getHeaderField(r11.toLowerCase());
    L13:
        return null;
    }

    public static String r(Exception r10) {
        if (r10 != null) goto L21;
        return "";
    L21:
        String r11 = r10.getMessage();     // Catch: Throwable -> L15
        if (r11 != null) goto L8;
        return "";
    L8:
        String[] r12 = r11.split("\\|");     // Catch: Throwable -> L15
        if (r12 != null) goto L11;
    L20:
        return "";
    L11:
        if (r12.length < 2) goto L20;
        if (Logger.debug() == false) goto L17;
        Logger.d(f7235a, "getHostAddress remoteIp = " + r12[0]);     // Catch: Throwable -> L15
    L17:
        return r12[0];
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public static void v(String r10, BaseHttpRequestInfo r11) {
        if (e.b(r10) == true) goto L16;
        if (r11 == null) goto L18;
        if (Logger.debug() == false) goto L9;
        Logger.d(f7235a, "getRequestInfo remoteIp = " + r10);     // Catch: Throwable -> L13
    L9:
        r11.f7162a = r10;     // Catch: Throwable -> L13
        o4.a r12 = r11.f7163b;     // Catch: Throwable -> L13
        if (r12 == null) goto L17;
        r12.f22478a = r10;     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void w(HttpURLConnection r10, BaseHttpRequestInfo r11, RetrofitMetrics r12) {
        if (r11 != null) goto L23;
        return;
    L23:
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f7238d == null) goto L12;
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Throwable -> L10
        f7238d.getRequestMetrics(r10, r13);     // Catch: Throwable -> L10
        if (r13.isEmpty() == true) goto L12;
        r11.f7162a = (String) x(r13.get(ICronetClient.KEY_REMOTE_IP), String.class, "");     // Catch: Throwable -> L10
        r11.f7171j = ((Long) x(r13.get(ICronetClient.KEY_DNS_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7172k = ((Long) x(r13.get(ICronetClient.KEY_CONNECT_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7173l = ((Long) x(r13.get(ICronetClient.KEY_SSL_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7174m = ((Long) x(r13.get(ICronetClient.KEY_SEND_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7175n = ((Long) x(r13.get(ICronetClient.KEY_PUSH_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7176o = ((Long) x(r13.get(ICronetClient.KEY_RECEIVE_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7177p = ((Boolean) x(r13.get(ICronetClient.KEY_SOCKET_REUSED), Boolean.class, Boolean.FALSE)).booleanValue();     // Catch: Throwable -> L10
        r11.f7178q = ((Long) x(r13.get(ICronetClient.KEY_TTFB), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7179r = ((Long) x(r13.get(ICronetClient.KEY_TOTAL_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7180s = ((Long) x(r13.get(ICronetClient.KEY_SEND_BYTE_COUNT), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7181t = ((Long) x(r13.get(ICronetClient.KEY_RECEIVED_BYTE_COUNT), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f7186y = (String) x(r13.get("request_log"), String.class, "");     // Catch: Throwable -> L10
        r11.f7182u = ((Long) x(r13.get(ICronetClient.KEY_RETRY_ATTEMPTS), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.B = (String) x(r13.get(ICronetClient.KEY_REQUEST_HEADERS), String.class, "");     // Catch: Throwable -> L10
        r11.C = (String) x(r13.get(ICronetClient.KEY_RESPONSE_HEADERS), String.class, "");     // Catch: Throwable -> L10
        r11.E = ((Long) x(r13.get(ICronetClient.KEY_POST_TASK_START), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.D = ((Long) x(r13.get(ICronetClient.KEY_REQUEST_START), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.F = ((Long) x(r13.get(ICronetClient.KEY_WAIT_CONTEXT), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
    L12:
        if (r12 == null) goto L25;
        r12.f7894a = r11.f7184w;     // Catch: Throwable -> L10
        r12.f7914u = SystemClock.uptimeMillis();     // Catch: Throwable -> L10
        r12.f7904k = System.currentTimeMillis();     // Catch: Throwable -> L10
        r12.O = "4.1.79.42-pico";     // Catch: Throwable -> L10
        r12.N.put(RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, Long.valueOf(r11.f7180s));     // Catch: Throwable -> L10
        r12.N.put(RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, Long.valueOf(r11.f7181t));     // Catch: Throwable -> L10
        JSONObject r14 = r11.f7187z;     // Catch: Throwable -> L10
        if (r11.G == false) goto L17;
        r14.put("turing_callback", r11.H);     // Catch: Throwable -> L10
    L17:
        if (r11.I == false) goto L19;
        r14.put("turing_retry", "1");     // Catch: Throwable -> L10
    L19:
        r14.put("retrofit", r12.f());     // Catch: Throwable -> L10
        return;
    }

    public static Object x(Object r10, Class r11, Object r12) {
        if (r10 != null) goto L4;
    L6:
        return r12;
    L4:
        if (r10.getClass().equals(r11) == false) goto L6;
        return r10;
    }

    public static SsCronetHttpClient y(Context r10) {
        if (f7239e != null) goto L16;
        monitor-enter(SsCronetHttpClient.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7239e != null) goto L11;
        f7239e = new SsCronetHttpClient(r10);     // Catch: Throwable -> L9
        d0();     // Catch: Throwable -> L9
    L11:
        monitor-exit(SsCronetHttpClient.class);     // Catch: Throwable -> L9
    L16:
        return f7239e;
    }

    public static boolean z(int r10) {
        if (r10 >= 8192) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 20971520) goto L7;
        return true;
    }

    public void D(String r10, String r11, String r12, String r13, String r14, String r15) {
        c();
        Reflect.on(f7238d).call("notifyTNCConfigUpdated", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r10, r11, r12, r13, r14, r15}).get();
    }

    public void I(String r10) {
        ICronetClient r11 = f7238d;
        if (r11 == null) goto L7;
        Reflect.on(r11).call("preconnectUrl", new Class[]{String.class}, new Object[]{r10}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void Q(String r10) {
        ICronetClient r11 = f7238d;     // Catch: Throwable -> L9
        if (r11 != null) goto L5;
        return;
    L5:
        if (f7237c == null) goto L16;
        Reflect.on(r11).call("removeClientOpaqueData", new Class[]{Context.class, String.class}, new Object[]{f7237c, r10});     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public void R(String r10) {
        ICronetClient r11 = f7238d;
        if (r11 == null) goto L7;
        Reflect.on(r11).call("reportNetDiagnosisUserLog", new Class[]{String.class}, new Object[]{r10});
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void S(long r10) {
        ICronetClient r11 = f7238d;
        if (r11 == null) goto L7;
        Reflect.on(r11).call("setAlogFuncAddr", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r10)});
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void V(boolean r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        d0();
        ICronetClient r10 = f7238d;
        if (r10 == null) goto L6;
        r10.setCronetBootFailureChecker(this);
        f7238d.setCronetEngine(f7237c, r11, r12, r13, r14, NetworkParams.m(), new c(), r15);
        return;
    }

    public void Y(String r10) {
        c();
        Reflect.on(f7238d).call("setHostResolverRules", new Class[]{String.class}, new Object[]{r10});
    }

    public void Z(String r10) {
        c();
        Reflect.on(f7238d).call("setProxy", new Class[]{String.class}, new Object[]{r10}).get();
    }

    public void b(String[] r10, byte[] r11, byte[] r12) {
        ICronetClient r13 = f7238d;     // Catch: Throwable -> L10
        if (r13 != null) goto L6;
        return;
    L6:
        if (f7237c == null) goto L17;
        Reflect.on(r13).call("addClientOpaqueData", new Class[]{Context.class, String[].class, byte[].class, byte[].class}, new Object[]{f7237c, r10, r11, r12});     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void b0(boolean r10) {
        ICronetClient r11 = f7238d;     // Catch: Throwable -> L9
        if (r11 != null) goto L5;
        return;
    L5:
        if (f7237c == null) goto L16;
        Reflect.on(r11).call("triggerGetDomain", new Class[]{Context.class, Boolean.TYPE}, new Object[]{f7237c, Boolean.valueOf(r10)});     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public final void c() {
        if (f7238d == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void e() {
        ICronetClient r10 = f7238d;     // Catch: Throwable -> L9
        if (r10 != null) goto L5;
        return;
    L5:
        if (f7237c == null) goto L16;
        Reflect.on(r10).call("clearClientOpaqueData", new Class[]{Context.class}, new Object[]{f7237c});     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public void e0(String[] r10, int r11, int r12) {
        ICronetClient r13 = f7238d;
        if (r13 == null) goto L7;
        Reflect r14 = Reflect.on(r13);
        Class r15 = Integer.TYPE;
        r14.call("tryStartNetDetect", new Class[]{String[].class, r15, r15}, new Object[]{r10, Integer.valueOf(r11), Integer.valueOf(r12)}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void f0(String r10, int r11, String r12) {
        ICronetClient r13 = f7238d;
        if (r13 == null) goto L7;
        Reflect.on(r13).call("ttDnsResolve", new Class[]{String[].class, Integer.TYPE, String.class}, new Object[]{r10, Integer.valueOf(r11), r12}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public g g0(String r10) {
        ICronetClient r11 = f7238d;
        if (r11 == null) goto L13;
        String[] r12 = (String[]) Reflect.on(r11).call("ttUrlDispatch", new Class[]{String.class}, new Object[]{r10}).get();
        if (r12.length != 3) goto L11;
        if (TextUtils.isEmpty(r12[0]) == true) goto L11;
        new URL(r12[0]).toURI();
        return new g(r10, r12[0], r12[1], r12[2]);
    L11:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L13:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public List i(String r10) {
        ICronetClient r11 = f7238d;
        if (r11 == null) goto L7;
        return (List) Reflect.on(r11).call("dnsLookup", new Class[]{String.class}, new Object[]{r10}).get();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureChecker
    public boolean isCronetBootFailureExpected() {
        ICronetBootFailureChecker r10 = f7242h;
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.isCronetBootFailureExpected();
    }

    public void j(boolean r10, String r11, String r12, String r13, boolean r14, String r15) {
        ICronetClient r16 = f7238d;
        if (r16 == null) goto L7;
        Reflect r17 = Reflect.on(r16);
        Class r18 = Boolean.TYPE;
        r17.call("enableTTBizHttpDns", new Class[]{r18, String.class, String.class, String.class, r18, String.class}, new Object[]{Boolean.valueOf(r10), r11, r12, r13, Boolean.valueOf(r14), r15}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(g6.b r10) {
        long r11 = SystemClock.uptimeMillis();
        g6.b r12 = d.e().d(r10);
        if (r10.y() == null) goto L5;
        RetrofitMetrics r13 = r10.y();
        r13.L = SystemClock.uptimeMillis() - r11;
    L5:
        if (r12 == null) goto L8;
        r10 = r12;
    L8:
        if (b.d().e() == false) goto L20;
        if (r10.D().contains("no_retry=1") == true) goto L20;
        b.a r14 = b.d().b(r10);
        if (r14 == null) goto L20;
        if (r14.a() == null) goto L20;
        if (r14.a().size() < 2) goto L20;
        return new a(r10, r14);
    L20:
        return new q4.b(r10, f7238d);
    }

    public int o() {
        c();
        return ((Integer) Reflect.on(f7238d).call("getEffectiveConnectionType").get()).intValue();
    }

    public Map p() {
        c();
        HashMap r10 = new HashMap();
        Iterator r11 = ((Map) Reflect.on(f7238d).call("getGroupRTTEstimates").get()).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (((int[]) r12.getValue()).length != 2) goto L9;
        q4.c r13 = new q4.c();
        r13.f23530a = ((int[]) r12.getValue())[0];
        r13.f23531b = ((int[]) r12.getValue())[1];
        r13.f23532c = -1;
        r10.put(r12.getKey(), r13);
        goto L4
    L9:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L10:
        return r10;
    }

    public void s(String r10) {
        c();
        Reflect.on(f7238d).call("getMappingRequestState", new Class[]{String.class}, new Object[]{r10}).get();
    }

    public q4.c t() {
        c();
        int[] r10 = (int[]) Reflect.on(f7238d).call("getNetworkQuality").get();
        if (r10.length != 3) goto L7;
        q4.c r11 = new q4.c();
        r11.f23530a = r10[0];
        r11.f23531b = r10[1];
        r11.f23532c = r10[2];
        return r11;
    L7:
        throw new UnknownFormatConversionException("getNetworkQuality returns wrong format");
    }

    public q4.d u(int r10) {
        c();
        return (q4.d) Reflect.on(f7238d).call("getPacketLossRateMetrics", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r10)}).get();
    }
}
