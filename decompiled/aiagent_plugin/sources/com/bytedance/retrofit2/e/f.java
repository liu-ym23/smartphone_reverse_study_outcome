package com.bytedance.retrofit2.e;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTRequestCompressManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String TAG = "TTRequestCompress";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f9522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f9523b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f9524c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f9525d = 1048576;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentMap<String, Integer> f9526e = null;
    private static final ConcurrentMap<String, Integer> f = null;
    private static int g;
    private static int h;
    private static int i;
    private static d j;
    private static volatile boolean k;
    private static CopyOnWriteArraySet<String> l;
    private static CopyOnWriteArraySet<String> m;
    private static CopyOnWriteArraySet<Pattern> n;
    private static CopyOnWriteArraySet<String> o;
    private static CopyOnWriteArraySet<String> p;
    private static CopyOnWriteArraySet<Pattern> q;
    private static CopyOnWriteArraySet<String> r;
    private static CopyOnWriteArraySet<String> s;
    private static CopyOnWriteArraySet<Pattern> t;
    private static final char[] u = null;
    private static a v;

    /* JADX INFO: compiled from: TTRequestCompressManager.java */
    public interface a {
        byte[] a(byte[] r1, int r2);
    }

    /* JADX INFO: compiled from: TTRequestCompressManager.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f9527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f9528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f9531e;

        b(int r1) {
            this.f9530d = r1;
        }
    }

    /* JADX INFO: compiled from: TTRequestCompressManager.java */
    public interface c {
        byte[] compressData(byte[] r1, int r2, int r3, int r4);
    }

    /* JADX INFO: compiled from: TTRequestCompressManager.java */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f9532a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f9533b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f9534c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f9535d = null;
        private static final /* synthetic */ d[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f9536e;

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        static {
            d r0 = new d("NONE", 0, 0);
            f9532a = r0;
            d r1 = new d("GZIP", 1, 1);
            f9533b = r1;
            d r3 = new d("BROTLI", 2, 2);
            f9534c = r3;
            d r5 = new d("ZSTD", 3, 3);
            f9535d = r5;
            f = new d[]{r0, r1, r3, r5};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f9536e = r3;
        }

        public int getType() {
            return this.f9536e;
        }
    }

    /* JADX INFO: compiled from: TTRequestCompressManager.java */
    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f9537a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f9538b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f9539c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f9540d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final e f9541e = null;
        public static final e f = null;
        public static final e g = null;
        public static final e h = null;
        public static final e i = null;
        public static final e j = null;
        public static final e k = null;
        public static final e l = null;
        public static final e m = null;
        public static final e n = null;
        private static final /* synthetic */ e[] p = null;
        private final int o;

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(p.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        static {
            e r0 = new e("NONE", 0, 0);
            f9537a = r0;
            e r1 = new e("GLOBAL_DISABLE", 1, 1);
            f9538b = r1;
            e r3 = new e("TNC_DISABLE", 2, 2);
            f9539c = r3;
            e r5 = new e("URL_MISMATCH", 3, 3);
            f9540d = r5;
            e r7 = new e("BODY_SIZE_MISMATCH", 4, 4);
            f9541e = r7;
            e r9 = new e("BODY_SIZE_OVERFLOW", 5, 5);
            f = r9;
            e r11 = new e("ZSTD_PREFIX_MISMATCH", 6, 6);
            g = r11;
            e r13 = new e("GZIP_PREFIX_MISMATCH", 7, 7);
            h = r13;
            e r15 = new e("BODY_ENCRYPTED", 8, 8);
            i = r15;
            e r14 = new e("REMOVE_ENCODING", 9, 9);
            j = r14;
            e r12 = new e("DATA_NULL", 10, 10);
            k = r12;
            e r10 = new e("NON_POST_METHOD", 11, 11);
            l = r10;
            e r8 = new e("BODY_ENCODED", 12, 12);
            m = r8;
            e r6 = new e("USER_DISABLE", 13, 13);
            n = r6;
            p = new e[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.o = r3;
        }

        public int a() {
            return this.o;
        }
    }

    static {
        f9526e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = 100;
        h = 4;
        i = 6;
        j = d.f9532a;
        l = new CopyOnWriteArraySet();
        m = new CopyOnWriteArraySet();
        n = new CopyOnWriteArraySet();
        o = new CopyOnWriteArraySet();
        p = new CopyOnWriteArraySet();
        q = new CopyOnWriteArraySet();
        r = new CopyOnWriteArraySet();
        s = new CopyOnWriteArraySet();
        t = new CopyOnWriteArraySet();
        f9523b = false;
        u = "0123456789ABCDEF".toCharArray();
    }

    private static void c() {
        f9524c = false;
        f9525d = 1048576;
        f9526e.clear();
        f.clear();
        g = 100;
        j = d.f9532a;
        l.clear();
        m.clear();
        n.clear();
        o.clear();
        p.clear();
        q.clear();
        r.clear();
        s.clear();
        t.clear();
    }

    public static boolean a() {
        return k;
    }

    public static void a(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        c();
        JSONObject r5 = r4.optJSONObject("tt_compress");
        if (r5 != null) goto L7;
        return;
    L7:
        boolean r1 = false;
        if (r5.optInt("enabled", 0) <= 0) goto L10;
        boolean r0 = true;
    L11:
        f9524c = r0;
        if (r5.optInt("opt_enabled", 0) <= 0) goto L14;
        r1 = true;
    L14:
        k = r1;
        f9525d = r5.optInt("max_body_size", 1048576);
        JSONObject r2 = r5.optJSONObject("max_body_size_map");
        if (r2 == null) goto L17;
        a(r2, "path_eq", f9526e);
        a(r2, "path_wc", f);
    L17:
        g = r5.optInt("min_body_size", 100);
        int r3 = r5.optInt("br_level", 4);
        if (r3 >= 0) goto L20;
    L22:
        int r6 = r5.optInt("zstd_level", 6);
        if (r6 >= 1) goto L25;
    L27:
        int r7 = r5.optInt("type", d.f9533b.getType());
        a(r7);
        a(r5.optJSONArray("equal_path"), l);
        a(r5.optJSONArray("prefix_path"), m);
        b(r5.optJSONArray("regex_path"), n);
        a(r5.optJSONArray("zstd_equal_path"), o);
        a(r5.optJSONArray("zstd_prefix_path"), p);
        b(r5.optJSONArray("zstd_regex_path"), q);
        a(r5.optJSONArray("host_group"), r);
        a(r5.optJSONArray("block_path_equal_list"), s);
        b(r5.optJSONArray("block_path_regex_list"), t);
        if (Logger.debug() == false) goto L31;
        a(TAG, "sRequestCompressEnabled:" + f9524c + " type:" + r7);
        return;
    L31:
        return;
    L25:
        if (r6 > 22) goto L27;
        i = r6;
        goto L27
    L20:
        if (r3 > 11) goto L22;
        h = r3;
        goto L22
    L10:
        r0 = false;
        goto L11
    }

    private static void a(JSONObject r4, String r5, ConcurrentMap<String, Integer> r6) {
        ConcurrentMap r7 = (ConcurrentMap) ZeusTransformUtils.wrapperContextForParams(r6, ConcurrentMap.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L30;
        if (r7 == null) goto L31;
        JSONObject r8 = r4.optJSONObject(r5);
        if (r8 != null) goto L11;
        return;
    L11:
        HashMap r9 = new HashMap();
        Iterator<String> r0 = r8.keys();
    L13:
        if (r0.hasNext() == false) goto L20;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L13;
        int r3 = r8.optInt(r2);
        if (r3 <= 0) goto L13;
        r9.put(r2, Integer.valueOf(r3));
        goto L13
    L20:
        r7.clear();
        r7.putAll(r9);
        return;
    L31:
        return;
    }

    private static void a(JSONArray r3, CopyOnWriteArraySet<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private static void b(JSONArray r3, CopyOnWriteArraySet<Pattern> r4) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L23;
        int r0 = 0;
    L16:
        if (r0 >= r3.length()) goto L25;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r4.add(Pattern.compile(r1, 2));     // Catch: Throwable -> L14
    L12:
        r0 = r0 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    private static void a(int r1) {
        if (r1 != 1) goto L5;
        j = d.f9533b;
        return;
    L5:
        if (r1 != 2) goto L7;
        j = d.f9534c;
        return;
    L7:
        if (r1 == 3) goto L9;
        j = d.f9532a;
        return;
    L9:
        j = d.f9535d;
    }

    public static void a(c r2) {
        f9522a = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
    }

    public static void b() {
        f9523b = true;
    }

    private static d c(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == true) goto L86;
        if (TextUtils.isEmpty(r5) == true) goto L86;
        if (a(o) == true) goto L14;
        if (o.contains(r5) == false) goto L14;
        return d.f9535d;
    L14:
        if (a(p) == true) goto L23;
        Iterator<String> r0 = p.iterator();
    L17:
        if (r0.hasNext() == false) goto L23;
        if (r5.startsWith((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L17;
        return d.f9535d;
    L23:
        if (a(q) == true) goto L34;
        Iterator<Pattern> r1 = q.iterator();
    L26:
        if (r1.hasNext() == false) goto L34;
        Pattern r2 = (Pattern) ZeusTransformUtils.preCheckCast(r1.next(), Pattern.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L26;
        if (r2.matcher(r5).matches() == false) goto L26;
        return d.f9535d;
    L34:
        if (a(l) == true) goto L40;
        if (l.contains(r5) == false) goto L40;
        return j;
    L40:
        if (a(m) == true) goto L49;
        Iterator<String> r3 = m.iterator();
    L43:
        if (r3.hasNext() == false) goto L49;
        if (r5.startsWith((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L43;
        return j;
    L49:
        if (a(n) == true) goto L60;
        Iterator<Pattern> r6 = n.iterator();
    L52:
        if (r6.hasNext() == false) goto L60;
        Pattern r7 = (Pattern) ZeusTransformUtils.preCheckCast(r6.next(), Pattern.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L52;
        if (r7.matcher(r5).matches() == false) goto L52;
        return j;
    L60:
        if (a(r) == true) goto L84;
        if (a(r4) == false) goto L84;
        if (a(s) == true) goto L71;
        if (s.contains(r5) == false) goto L71;
        return d.f9532a;
    L71:
        if (a(t) == true) goto L82;
        Iterator<Pattern> r8 = t.iterator();
    L74:
        if (r8.hasNext() == false) goto L82;
        Pattern r9 = (Pattern) ZeusTransformUtils.preCheckCast(r8.next(), Pattern.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L74;
        if (r9.matcher(r5).matches() == false) goto L74;
        return d.f9532a;
    L82:
        return j;
    L84:
        return d.f9532a;
    L86:
        return d.f9532a;
    }

    private static boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        Iterator<String> r0 = r.iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        if (d(r5, (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private static boolean a(Set<?> r2) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r3.isEmpty() == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static b a(byte[] r4, int r5, String r6, String r7, boolean r8) {
        b r0 = new b(0);
        if (f9523b.booleanValue() == false) goto L10;
        if (Logger.debug() == false) goto L7;
        a(TAG, "global compress is disabled.");
    L7:
        r0.f9530d = e.f9538b.a();
        return r0;
    L10:
        if (f9524c == false) goto L57;
        if (j == d.f9532a) goto L57;
        d r1 = c(r6, r7);
        if (r8 == true) goto L24;
        if (r1 != d.f9532a) goto L24;
        if (Logger.debug() == false) goto L21;
        a(TAG, "Url is not matched:" + r6 + r7);
    L21:
        r0.f9530d = e.f9540d.a();
        return r0;
    L24:
        if (r5 > b(r7)) goto L52;
        if (r5 < g) goto L52;
        if (r1 != d.f9533b) goto L36;
        byte[] r9 = a(r4, r5);
        if (a(r5, r9, r1, r0) == true) goto L33;
        return r0;
    L33:
        r0.f9527a = r9;
        r0.f9528b = r1;
        r0.f9529c = DownloadHelper.GZIP;
        return r0;
    L36:
        if (r1 != d.f9534c) goto L43;
        byte[] r10 = a(r4, r5, h);
        if (a(r5, r10, r1, r0) == true) goto L40;
        return r0;
    L40:
        r0.f9527a = r10;
        r0.f9528b = r1;
        r0.f9529c = "br";
        return r0;
    L43:
        if (r1 != d.f9535d) goto L49;
        byte[] r11 = b(r4, i);
        if (a(r5, r11, r1, r0) == true) goto L47;
        return r0;
    L47:
        r0.f9527a = r11;
        r0.f9528b = r1;
        r0.f9529c = "zstd";
        return r0;
    L49:
        return null;
    L52:
        if (Logger.debug() == false) goto L54;
        a(TAG, "Request body size is not matched:" + r5);
    L54:
        r0.f9530d = e.f9541e.a();
        return r0;
    L57:
        if (Logger.debug() == false) goto L59;
        a(TAG, "Request compress is disabled.");
    L59:
        r0.f9530d = e.f9539c.a();
        return r0;
    }

    private static int b(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L5;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(f9526e.get(r5), Integer.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
        Iterator<Map.Entry<String, Integer>> r1 = f.entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L21;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (d(r5, (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L12;
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L19;
        return r6.intValue();
    L19:
        return f9525d;
    L21:
        return f9525d;
    L9:
        return r0.intValue();
    L5:
        return f9525d;
    }

    private static String a(byte[] r6) {
        char[] r0 = new char[r6.length * 2];
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L7;
        int r2 = r6[r1] & 255;
        int r3 = r1 * 2;
        char[] r4 = u;
        r0[r3] = r4[r2 >>> 4];
        r0[r3 + 1] = r4[r2 & 15];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    public static boolean a(int r5, byte[] r6, d r7, b r8) {
        if (r6 != null) goto L5;
    L37:
        return false;
    L5:
        if (r6.length <= 3) goto L37;
        if (k == true) goto L11;
        return true;
    L11:
        if (r6.length < r5) goto L15;
        r8.f9530d = e.f.a();
        return false;
    L15:
        if (r7 != d.f9533b) goto L26;
        byte r9 = r6[0];
        byte r10 = r6[1];
        byte r11 = r6[2];
        if (r9 == 31) goto L19;
    L23:
        r8.f9530d = e.h.a();
        r8.f9531e = a(new byte[]{r9, r10, r11});
        return false;
    L19:
        if (r10 != (-117)) goto L23;
        if (r11 != 8) goto L23;
        return true;
    L26:
        if (r7 != d.f9535d) goto L36;
        byte r12 = r6[0];
        byte r13 = r6[1];
        byte r14 = r6[2];
        if (r12 == 40) goto L30;
    L34:
        r8.f9530d = e.g.a();
        r8.f9531e = a(new byte[]{r12, r13, r14});
        return false;
    L30:
        if (r13 != (-75)) goto L34;
        if (r14 != 47) goto L34;
        return true;
    L36:
        return true;
    }

    public static byte[] a(byte[] r2, int r3, int r4) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (f9522a != null) goto L8;
        return null;
    L8:
        return f9522a.compressData(r2, r3, r4, d.f9534c.getType());
    }

    public static byte[] a(byte[] r5, int r6) {
        GZIPOutputStream r7 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        GZIPOutputStream r1 = new GZIPOutputStream(r0);     // Catch: Throwable -> L16 IOException -> L18
        r1.write(r5);     // Catch: IOException -> L14 Throwable -> L29
        r1.close();     // Catch: IOException -> L10
        r0.close();     // Catch: IOException -> L10
    L13:
        return r0.toByteArray();
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = e;
    L20:
        b(TAG, "Compress with gzip exception: " + e);     // Catch: Throwable -> L29
        if (r1 != null) goto L43;
    L25:
        r0.close();     // Catch: IOException -> L23
    L28:
        return null;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L43:
        r1.close();     // Catch: IOException -> L23
    L29:
        th = th;
        r7 = r1;
    L31:
        if (r7 != null) goto L39;
    L35:
        r0.close();     // Catch: IOException -> L33
    L38:
        throw th;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L39:
        r7.close();     // Catch: IOException -> L33
        goto L35
    L18:
        e = e;
        r1 = null;
    L16:
        th = th;
        goto L31
    }

    public static void a(a r2) {
        v = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
    }

    public static byte[] b(byte[] r1, int r2) {
        a r0 = v;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2);
    }

    private static boolean d(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r1 = r12.length();
        int r2 = r13.length();
        int r4 = 0;
        int r5 = 0;
        int r6 = -1;
        int r7 = -1;
    L8:
        if (r4 >= r1) goto L22;
        if (r5 >= r2) goto L15;
        if (r13.charAt(r5) == '?') goto L14;
        if (r13.charAt(r5) != r12.charAt(r4)) goto L15;
    L14:
        r4 = r4 + 1;
        r5 = r5 + 1;
    L15:
        if (r5 >= r2) goto L19;
        if (r13.charAt(r5) != '*') goto L19;
        r7 = r4;
        r6 = r5;
        r5 = r5 + 1;
    L19:
        if (r6 == (-1)) goto L20;
        r5 = r6 + 1;
        r7 = r7 + 1;
        r4 = r7;
        goto L8
    L20:
        return false;
    L22:
        if (r5 >= r2) goto L27;
        if (r13.charAt(r5) != '*') goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
