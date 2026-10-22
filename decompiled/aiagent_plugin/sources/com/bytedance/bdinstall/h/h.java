package com.bytedance.bdinstall.h;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.ba;
import com.bytedance.bdinstall.j.s;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExternalCache.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends d {
    private static final String TAG = "DirectoryCacheHelper";
    private static volatile Pair<byte[], String> j;
    private static volatile Pair<String, byte[]> k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f6281e;
    private String f;
    private volatile Map<String, String> g;
    private AtomicBoolean h;
    private String i;

    /* JADX INFO: compiled from: ExternalCache.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f6283a;

        private a(h r1) {
            this.f6283a = r1;
        }

        /* synthetic */ a(h r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.b(this.f6283a).set(false);
            String r0 = "";
        L7:
            th = move-exception;
            th.printStackTrace();
        L9:
            h.a(this.f6283a, r0);
            return;
        L4:
            if (h.c(this.f6283a) == null) goto L9;
            h r1 = this.f6283a;     // Catch: Throwable -> L7
            r0 = h.a(r1, h.c(r1));     // Catch: Throwable -> L7
            goto L9
        }
    }

    static /* synthetic */ String a(h r0) {
        return r0.i;
    }

    static /* synthetic */ String a(h r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(h r0, String r1) {
        r0.e(r1);
    }

    static /* synthetic */ AtomicBoolean b(h r0) {
        return r0.h;
    }

    static /* synthetic */ Map c(h r0) {
        return r0.g;
    }

    h(Context r4, boolean r5, String r6, String r7, String r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.h = new AtomicBoolean(false);
        this.f6277a = Environment.getExternalStorageState();
        this.f = r6;
        this.f6279c = r5;
        this.f6278b = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
        this.f6280d = r7;
        this.f6281e = r8;
        this.i = r9;
    }

    @Override // com.bytedance.bdinstall.h.d, com.bytedance.bdinstall.h.i
    public void a(String r1, String r2) {
        g(r1, r2);
    }

    private String a() {
        return this.f + "/" + this.f6280d;
    }

    @Override // com.bytedance.bdinstall.h.d, com.bytedance.bdinstall.h.i
    public String a(String r1) {
        return c(r1);
    }

    @Override // com.bytedance.bdinstall.h.d
    public String[] b(String r1) {
        String r0 = c(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    @Override // com.bytedance.bdinstall.h.d
    public void a(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        a(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    private String c(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (this.g == null) goto L11;
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.g.get(r10), String.class, "com.obric.aiagent.plugin");
        if (t.a() == false) goto L9;
        t.b("get key = " + r10 + " value = " + r0 + " way = memory dir = " + a());
    L9:
        return r0;
    L11:
        if ("mounted".equals(this.f6277a) == true) goto L89;
        return null;
    L89:
    L56:
        th = th;
        RandomAccessFile r5 = null;
        FileLock r6 = null;
    L91:
    L69:
        th = move-exception;
        if (this.g != null) goto L73;
        this.g = new ConcurrentHashMap();
    L73:
        if (r6 != null) goto L101;
    L75:
        if (r5 == null) goto L113;
        r5.close();     // Catch: Exception -> L86
        throw th;
    L114:
        throw th;
    L113:
        throw th;
    L101:
        r6.release();     // Catch: Exception -> L85
        goto L75
    L59:
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L62;
        th.printStackTrace();     // Catch: Throwable -> L69
    L62:
        if (this.g != null) goto L64;
        this.g = new ConcurrentHashMap();
    L64:
        if (r6 != null) goto L87;
    L66:
        if (r5 != null) goto L105;
    L68:
        return null;
    L105:
        r5.close();     // Catch: Exception -> L83
        goto L68
    L87:
        r6.release();     // Catch: Exception -> L84
        goto L66
    L14:
        if (new File(this.f).exists() == false) goto L16;
        File r1 = new File(a());     // Catch: Throwable -> L56
        r5 = new RandomAccessFile(r1, "rwd");     // Catch: Throwable -> L56
        r6 = r5.getChannel().lock();     // Catch: Throwable -> L54
    L52:
        th = th;
        goto L91
    L22:
        if (r1.isFile() == false) goto L46;
        byte[] r7 = new byte[2049];     // Catch: Throwable -> L52
        int r8 = r5.read(r7, 0, 2049);     // Catch: Throwable -> L52
        if (r8 <= 0) goto L46;
        if (r8 >= 2049) goto L46;
        this.g = d(a(Arrays.copyOf(r7, r8)));     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r10) == true) goto L29;
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.g.get(r10), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (t.a() == false) goto L39;
        t.b("get key = " + r10 + " value = " + r2 + " way = file dir = " + a());     // Catch: Throwable -> L52
    L39:
        if (this.g != null) goto L41;
        this.g = new ConcurrentHashMap();
    L41:
        if (r6 != null) goto L103;
    L97:
        r5.close();     // Catch: Exception -> L81
    L44:
        return r2;
    L103:
        r6.release();     // Catch: Exception -> L80
        goto L97
    L29:
        if (this.g != null) goto L31;
        this.g = new ConcurrentHashMap();
    L31:
        if (r6 != null) goto L107;
    L99:
        r5.close();     // Catch: Exception -> L79
    L34:
        return null;
    L107:
        r6.release();     // Catch: Exception -> L78
    L46:
        if (this.g != null) goto L48;
        this.g = new ConcurrentHashMap();
    L48:
        if (r6 == null) goto L105;
        r6.release();     // Catch: Exception -> L82
    L54:
        th = th;
        r6 = null;
        goto L91
    L16:
        if (this.g != null) goto L18;
        this.g = new ConcurrentHashMap();
    L18:
        return null;
    }

    private Map<String, String> d(String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L5;
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

    private void g(String r4, String r5) {
        if (this.g != null) goto L8;
        c(null);
        if (this.g != null) goto L8;
        this.g = new ConcurrentHashMap();
    L8:
        if (ba.a((String) ZeusTransformUtils.preCheckCast(this.g.get(r4), String.class, "com.obric.aiagent.plugin"), r5) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        if (this.g.containsKey(r4) == false) goto L16;
        this.g.remove(r4);
    L19:
        if (this.f6279c == true) goto L21;
        return;
    L21:
        if (this.h.compareAndSet(false, true) == false) goto L25;
        w.b(this.i).postDelayed(new AnonymousClass1(this), 1000);
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        this.g.put(r4, r5);
        goto L19
    }

    private void e(String r6) {
        if ("mounted".equals(this.f6277a) == true) goto L5;
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
        if (r0 == null) goto L48;
        r0.release();     // Catch: Exception -> L35
    L48:
        r2.close();     // Catch: Exception -> L36
        return;
    L57:
        return;
    L17:
        th = th;
    L44:
    L29:
        th = move-exception;
        if (r0 != null) goto L42;
    L32:
        if (r2 == null) goto L58;
        r2.close();     // Catch: Exception -> L39
        throw th;
    L59:
        throw th;
    L58:
        throw th;
    L42:
        r0.release();     // Catch: Exception -> L38
        goto L32
    L22:
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L24;
        th.printStackTrace();     // Catch: Throwable -> L29
    L24:
        if (r0 != null) goto L52;
    L26:
        if (r2 != null) goto L48;
        return;
    L52:
        r0.release();     // Catch: Exception -> L37
        goto L26
    L9:
        if (r1.mkdirs() == true) goto L11;
        return;
    L19:
        th = th;
        r2 = null;
        goto L44
    }

    @Override // com.bytedance.bdinstall.h.d
    public void a(List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r6.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (this.g == null) goto L11;
        this.g.remove(r2);
    L11:
        g(r2, null);
        goto L7
    L12:
        super.a(r6);
    }

    private String a(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return "";
    L6:
        JSONObject r6 = new JSONObject();
        Iterator r7 = r4.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r6.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r1.getValue());
        goto L8
    L11:
        return r6.toString();
    }

    private String a(byte[] r4) {
        if (j == null) goto L9;
        if (Arrays.equals(r4, (byte[]) ZeusTransformUtils.preCheckCast(j.first, byte[].class, "com.obric.aiagent.plugin")) == false) goto L9;
        return (String) ZeusTransformUtils.preCheckCast(j.second, String.class, "com.obric.aiagent.plugin");
    L9:
        if (k != null) goto L11;
    L14:
        String r0 = null;
        r0 = s.a(r4, this.f6281e);     // Catch: Throwable -> L17
    L19:
        if (r0 == null) goto L21;
        j = new Pair(r4, r0);
    L21:
        return r0;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L11:
        if (Arrays.equals(r4, (byte[]) ZeusTransformUtils.preCheckCast(k.second, byte[].class, "com.obric.aiagent.plugin")) == false) goto L14;
        return (String) ZeusTransformUtils.preCheckCast(k.first, String.class, "com.obric.aiagent.plugin");
    }

    private byte[] f(String r5) {
        if (k == null) goto L9;
        if (ba.a(r5, (String) ZeusTransformUtils.preCheckCast(k.first, String.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return (byte[]) ZeusTransformUtils.preCheckCast(k.second, byte[].class, "com.obric.aiagent.plugin");
    L9:
        if (j != null) goto L11;
    L14:
        byte[] r0 = null;
        r0 = s.a(r5, this.f6281e);     // Catch: Throwable -> L17
    L19:
        if (r0 == null) goto L21;
        k = new Pair(r5, r0);
    L21:
        return r0;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L11:
        if (ba.a(r5, (String) ZeusTransformUtils.preCheckCast(j.second, String.class, "com.obric.aiagent.plugin")) == false) goto L14;
        return (byte[]) ZeusTransformUtils.preCheckCast(j.first, byte[].class, "com.obric.aiagent.plugin");
    }
}
