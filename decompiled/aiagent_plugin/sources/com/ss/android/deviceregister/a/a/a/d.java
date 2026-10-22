package com.ss.android.deviceregister.a.a.a;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.j;
import com.ss.android.deviceregister.k;
import com.ss.android.deviceregister.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExternalDirectoryCacheHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends b {
    private static final String TAG = "DirectoryCacheHelper";
    private static volatile Pair<byte[], String> i;
    private static volatile Pair<String, byte[]> j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f37316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f37317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f37318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f37319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f37320e;
    private String f;
    private volatile Map<String, String> g;
    private AtomicBoolean h;

    /* JADX INFO: compiled from: ExternalDirectoryCacheHelper.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f37322a;

        private a(d r1) {
            this.f37322a = r1;
        }

        /* synthetic */ a(d r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(this.f37322a).set(false);
            String r0 = "";
        L7:
            th = move-exception;
            th.printStackTrace();
        L9:
            d.a(this.f37322a, r0);
            return;
        L4:
            if (d.b(this.f37322a) == null) goto L9;
            d r1 = this.f37322a;     // Catch: Throwable -> L7
            r0 = d.a(r1, d.b(r1));     // Catch: Throwable -> L7
            goto L9
        }
    }

    static /* synthetic */ String a(d r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ AtomicBoolean a(d r0) {
        return r0.h;
    }

    static /* synthetic */ void a(d r0, String r1) {
        r0.e(r1);
    }

    static /* synthetic */ Map b(d r0) {
        return r0.g;
    }

    public d(Context r4, boolean r5, String r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.h = new AtomicBoolean(false);
        this.f37316a = Environment.getExternalStorageState();
        this.f = r6;
        this.f37318c = r5;
        this.f37317b = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
        this.f37319d = r7;
        this.f37320e = r8;
    }

    @Override // com.ss.android.deviceregister.a.a.a.b
    public void a(String r3, String r4) {
        if (Logger.debug() == false) goto L5;
        com.ss.android.common.util.e.a("DirectoryCacheHelper set key = " + r3 + " value = " + r4 + " dir = " + a());
    L5:
        a(r3, r4, false);
    }

    private String a() {
        return this.f + "/" + this.f37319d;
    }

    @Override // com.ss.android.deviceregister.a.a.a.b
    public String a(String r1) {
        return c(r1);
    }

    private synchronized String c(String r7) {
        monitor-enter(this);
    L88:
        th = move-exception;
        throw th;
    L4:
        if (j.a(r7) == true) goto L14;
        if (this.g == null) goto L14;
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.g.get(r7), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
        if (Logger.debug() == false) goto L10;
        com.ss.android.common.util.e.a("DirectoryCacheHelper get key = " + r7 + " value = " + r0 + " way = memory dir = " + a());     // Catch: Throwable -> L88
    L10:
        monitor-exit(this);
        return r0;
    L14:
        if ("mounted".equals(this.f37316a) == true) goto L123;
        monitor-exit(this);
        return null;
    L123:
    L64:
        th = th;
        RandomAccessFile r2 = null;
        FileLock r3 = null;
    L111:
    L79:
        th = move-exception;
        if (this.g != null) goto L83;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L83:
        if (r3 != null) goto L119;
    L85:
        if (r2 == null) goto L126;
        r2.close();     // Catch: Exception -> L99 Throwable -> L88
        throw th;     // Catch: Throwable -> L88
    L127:
        throw th;     // Catch: Throwable -> L88
    L126:
        throw th;     // Catch: Throwable -> L88
    L119:
        r3.release();     // Catch: Exception -> L98 Throwable -> L88
        goto L85
    L67:
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L69;
        th.printStackTrace();     // Catch: Throwable -> L79
    L69:
        com.ss.android.common.util.e.b("DirectoryCacheHelper load openudid exception " + th);     // Catch: Throwable -> L79
    L71:
        if (this.g != null) goto L73;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L73:
        if (r3 != null) goto L100;
    L75:
        if (r2 != null) goto L105;
    L77:
        monitor-exit(this);
        return null;
    L105:
        r2.close();     // Catch: Exception -> L96 Throwable -> L88
        goto L77
    L100:
        r3.release();     // Catch: Exception -> L97 Throwable -> L88
        goto L75
    L18:
        if (new File(this.f).exists() == true) goto L25;
        com.ss.android.common.util.e.a("DirectoryCacheHelper dir : " + this.f + " not exist, read failed");     // Catch: Throwable -> L64
        if (this.g != null) goto L23;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L23:
        monitor-exit(this);
        return null;
    L25:
        File r1 = new File(a());     // Catch: Throwable -> L64
        r2 = new RandomAccessFile(r1, "rwd");     // Catch: Throwable -> L64
        r3 = r2.getChannel().lock();     // Catch: Throwable -> L62
    L60:
        th = th;
        goto L111
    L28:
        if (r1.isFile() == false) goto L54;
        byte[] r4 = new byte[2049];     // Catch: Throwable -> L60
        int r5 = r2.read(r4, 0, 2049);     // Catch: Throwable -> L60
        if (r5 <= 0) goto L54;
        if (r5 >= 2049) goto L54;
        this.g = d(a(Arrays.copyOf(r4, r5)));     // Catch: Throwable -> L60
        if (j.a(r7) == true) goto L35;
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.g.get(r7), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
        if (Logger.debug() == false) goto L46;
        com.ss.android.common.util.e.a("DirectoryCacheHelper get key = " + r7 + " value = " + r6 + " way = disk dir = " + a());     // Catch: Throwable -> L60
    L46:
        if (this.g != null) goto L48;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L48:
        if (r3 == null) goto L124;
        r3.release();     // Catch: Exception -> L93 Throwable -> L88
    L124:
        r2.close();     // Catch: Exception -> L94 Throwable -> L88
    L51:
        monitor-exit(this);
        return r6;
    L35:
        if (this.g != null) goto L37;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L37:
        if (r3 != null) goto L121;
    L115:
        r2.close();     // Catch: Exception -> L92 Throwable -> L88
    L40:
        monitor-exit(this);
        return null;
    L121:
        r3.release();     // Catch: Exception -> L91 Throwable -> L88
    L54:
        if (this.g != null) goto L56;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L56:
        if (r3 == null) goto L105;
        r3.release();     // Catch: Exception -> L95 Throwable -> L88
    L62:
        th = th;
        r3 = null;
        goto L111
    }

    private Map<String, String> d(String r6) {
        if (j.a(r6) == true) goto L5;
        JSONObject r5 = new JSONObject(r6);
        Iterator<String> r7 = r5.keys();
        ConcurrentHashMap r0 = new ConcurrentHashMap();
    L8:
        if (r7.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        r0.put(r1, (String) ZeusTransformUtils.preCheckCast(r5.get(r1), String.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        return r0;
    L5:
        return new ConcurrentHashMap();
    }

    private void a(String r5, String r6, boolean r7) {
        AnonymousClass1 r1 = null;
        if (this.g != null) goto L8;
        c(null);
        if (this.g != null) goto L8;
        this.g = new ConcurrentHashMap();
    L8:
        if (j.a((String) ZeusTransformUtils.preCheckCast(this.g.get(r5), String.class, "com.obric.aiagent.plugin"), r6) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r6) == false) goto L16;
        if (this.g.containsKey(r5) == false) goto L16;
        this.g.remove(r5);
    L18:
        if (r7 == false) goto L21;
        new a(this, r1).run();
        return;
    L21:
        if (this.f37318c == true) goto L23;
        return;
    L23:
        if (this.h.compareAndSet(false, true) == false) goto L28;
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(this), 1000);
        return;
    L28:
        return;
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        this.g.put(r5, r6);
        goto L18
    }

    private void e(String r6) {
        if ("mounted".equals(this.f37316a) == true) goto L5;
        return;
    L5:
        FileLock r0 = null;
        File r1 = new File(this.f);     // Catch: Throwable -> L19
        if (r1.exists() == false) goto L9;
    L11:
        RandomAccessFile r2 = new RandomAccessFile(new File(a()), "rwd");     // Catch: Throwable -> L19
        r0 = r2.getChannel().lock();     // Catch: Throwable -> L17
        byte[] r5 = f(r6);     // Catch: Throwable -> L17
        r2.setLength(0);     // Catch: Throwable -> L17
        r2.write(r5);     // Catch: Throwable -> L17
        if (r0 != null) goto L45;
    L43:
        r2.close();     // Catch: Exception -> L37
        return;
    L58:
        return;
    L45:
        r0.release();     // Catch: Exception -> L36
    L17:
        th = th;
    L49:
    L30:
        th = move-exception;
        if (r0 != null) goto L41;
    L33:
        if (r2 == null) goto L59;
        r2.close();     // Catch: Exception -> L40
        throw th;
    L60:
        throw th;
    L59:
        throw th;
    L41:
        r0.release();     // Catch: Exception -> L39
        goto L33
    L22:
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L24;
        th.printStackTrace();     // Catch: Throwable -> L30
    L24:
        com.ss.android.common.util.e.e("DirectoryCacheHelper load exception ", th);     // Catch: Throwable -> L30
        if (r0 != null) goto L47;
    L27:
        if (r2 != null) goto L43;
        return;
    L47:
        r0.release();     // Catch: Exception -> L38
        goto L27
    L9:
        if (r1.mkdirs() == true) goto L11;
        return;
    L19:
        th = th;
        r2 = null;
        goto L49
    }

    @Override // com.ss.android.deviceregister.a.a.a.b
    public void b(String r4) {
        a(r4, null, true);
        o.b(o.f37441a, "ExternalDirectoryCacheHelper#clear key=" + r4 + " path=" + a() + " getCachedString(key)=" + a(r4));
        super.b(r4);
    }

    private String a(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return "";
    L6:
        JSONObject r6 = new JSONObject();
        Iterator r7 = r4.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (k.a() == false) goto L14;
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r1.getKey(), CharSequence.class, "com.obric.aiagent.plugin"), "device_id") == false) goto L8;
    L14:
        r6.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r1.getValue());
        goto L8
    L16:
        return r6.toString();
    }

    private String a(byte[] r4) {
        if (i == null) goto L9;
        if (Arrays.equals(r4, (byte[]) ZeusTransformUtils.preCheckCast(i.first, byte[].class, "com.obric.aiagent.plugin")) == false) goto L9;
        return (String) ZeusTransformUtils.preCheckCast(i.second, String.class, "com.obric.aiagent.plugin");
    L9:
        if (j != null) goto L11;
    L14:
        String r0 = null;
        r0 = c.a(r4, this.f37320e);     // Catch: Throwable -> L17
    L19:
        if (r0 == null) goto L21;
        i = new Pair(r4, r0);
    L21:
        return r0;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L11:
        if (Arrays.equals(r4, (byte[]) ZeusTransformUtils.preCheckCast(j.second, byte[].class, "com.obric.aiagent.plugin")) == false) goto L14;
        return (String) ZeusTransformUtils.preCheckCast(j.first, String.class, "com.obric.aiagent.plugin");
    }

    private byte[] f(String r5) {
        if (j == null) goto L9;
        if (j.a(r5, (String) ZeusTransformUtils.preCheckCast(j.first, String.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return (byte[]) ZeusTransformUtils.preCheckCast(j.second, byte[].class, "com.obric.aiagent.plugin");
    L9:
        if (i != null) goto L11;
    L14:
        byte[] r0 = null;
        r0 = c.a(r5, this.f37320e);     // Catch: Throwable -> L17
    L19:
        if (r0 == null) goto L21;
        j = new Pair(r5, r0);
    L21:
        return r0;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L11:
        if (j.a(r5, (String) ZeusTransformUtils.preCheckCast(i.second, String.class, "com.obric.aiagent.plugin")) == false) goto L14;
        return (byte[]) ZeusTransformUtils.preCheckCast(i.first, byte[].class, "com.obric.aiagent.plugin");
    }
}
