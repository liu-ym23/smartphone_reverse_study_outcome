package com.bytedance.apm;

import android.content.Context;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.v;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApmAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6283a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f6284b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f6285c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f6286d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static MappedByteBuffer f6287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AtomicLong f6288f;

    public interface IBatteryDataListener {
        void onData(float r10, float r11, String r12);
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h1.d f6289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6290b;

        public a(h1.d r10, JSONObject r11) {
            this.f6289a = r10;
            this.f6290b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            k2.a.f(this.f6289a.e(), this.f6289a.f(), null, this.f6289a.b(), this.f6289a.d(), this.f6290b);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h1.d f6291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6294d;

        public b(h1.d r10, JSONObject r11, JSONObject r12, JSONObject r13) {
            this.f6291a = r10;
            this.f6292b = r11;
            this.f6293c = r12;
            this.f6294d = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new m1.c(this.f6291a.e(), this.f6291a.f(), null, this.f6292b, this.f6293c, this.f6294d, this.f6291a.g()).packLog();
            if (r10 == null) goto L6;
            ApmAgent.r("monitorEvent", r10.toString());
            return;
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6297c;

        public c(String r10, int r11, JSONObject r12) {
            this.f6295a = r10;
            this.f6296b = r11;
            this.f6297c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new m1.c(this.f6295a, this.f6296b, null, null, null, this.f6297c).packLog();
            if (r10 == null) goto L6;
            ApmAgent.r("monitorStatusRate", r10.toString());
            return;
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6300c;

        public d(String r10, JSONObject r11, JSONObject r12) {
            this.f6298a = r10;
            this.f6299b = r11;
            this.f6300c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new m1.c(this.f6298a, 0, this.f6299b, null, null, this.f6300c).packLog();
            if (r10 == null) goto L6;
            ApmAgent.r("monitorDuration", r10.toString());
            return;
        }
    }

    public static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6304d;

        public e(String r10, int r11, JSONObject r12, JSONObject r13) {
            this.f6301a = r10;
            this.f6302b = r11;
            this.f6303c = r12;
            this.f6304d = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new m1.c(this.f6301a, this.f6302b, this.f6303c, null, null, this.f6304d).packLog();
            if (r10 == null) goto L6;
            ApmAgent.r("monitorStatusAndDuration", r10.toString());
            return;
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6306b;

        public f(String r10, JSONObject r11) {
            this.f6305a = r10;
            this.f6306b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            l1.a.p().e(new m1.d(this.f6305a, this.f6306b));
        }
    }

    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f6307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f6308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f6309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f6310d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f6311e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f6312f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6313g;

        public g(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            this.f6307a = r10;
            this.f6308b = r11;
            this.f6309c = r12;
            this.f6310d = r13;
            this.f6311e = r14;
            this.f6312f = r15;
            this.f6313g = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            l1.b.t().e(new m1.a("api_all", this.f6307a, this.f6308b, this.f6309c, this.f6310d, this.f6311e, this.f6312f, ApmAgent.a(this.f6313g, false)));
        }
    }

    public static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6315b;

        public h(String r10, JSONObject r11) {
            this.f6314a = r10;
            this.f6315b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new m1.d(this.f6314a, this.f6315b).packLog();
            if (r10 == null) goto L6;
            ApmAgent.r("monitorExceptionLog", r10.toString());
            return;
        }
    }

    public static class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6317b;

        public i(String r10, JSONObject r11) {
            this.f6316a = r10;
            this.f6317b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            k2.a.c(this.f6316a, this.f6317b);
        }
    }

    public static class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f6320c;

        public j(String r10, JSONObject r11, boolean r12) {
            this.f6318a = r10;
            this.f6319b = r11;
            this.f6320c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new m1.b(this.f6318a, this.f6319b, this.f6320c).packLog();
            if (r10 == null) goto L6;
            ApmAgent.r("monitorCommonLog", r10.toString());
            return;
        }
    }

    public static class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f6321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f6322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f6323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f6324d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f6325e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f6326f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6327g;

        public k(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            this.f6321a = r10;
            this.f6322b = r11;
            this.f6323c = r12;
            this.f6324d = r13;
            this.f6325e = r14;
            this.f6326f = r15;
            this.f6327g = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r12 = new m1.a("api_all", this.f6321a, this.f6322b, this.f6323c, this.f6324d, this.f6325e, this.f6326f, this.f6327g).packLog();
            if (r12 == null) goto L6;
            ApmAgent.r("monitorSLA", r12.toString());
            return;
        }
    }

    public static class l implements Comparator {
        public l() {
        }

        public int a(File r10, File r11) {
            return Long.compare(r10.lastModified(), r11.lastModified());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((File) r10, (File) r11);
        }
    }

    public static class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f6328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f6329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f6330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f6331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f6332e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f6333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6334g;

        public m(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            this.f6328a = r10;
            this.f6329b = r11;
            this.f6330c = r12;
            this.f6331d = r13;
            this.f6332e = r14;
            this.f6333f = r15;
            this.f6334g = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            l1.b.t().e(new m1.a("api_error", this.f6328a, this.f6329b, this.f6330c, this.f6331d, this.f6332e, this.f6333f, ApmAgent.a(this.f6334g, false)));
        }
    }

    public static class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f6335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f6336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f6337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f6338d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f6339e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f6340f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6341g;

        public n(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            this.f6335a = r10;
            this.f6336b = r11;
            this.f6337c = r12;
            this.f6338d = r13;
            this.f6339e = r14;
            this.f6340f = r15;
            this.f6341g = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r12 = new m1.a("api_error", this.f6335a, this.f6336b, this.f6337c, this.f6338d, this.f6339e, this.f6340f, this.f6341g).packLog();
            if (r12 == null) goto L6;
            ApmAgent.r("monitorApiError", r12.toString());
            return;
        }
    }

    public static class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6345d;

        public o(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
            this.f6342a = r10;
            this.f6343b = r11;
            this.f6344c = r12;
            this.f6345d = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new m1.c(this.f6342a, 0, null, this.f6343b, this.f6344c, this.f6345d).packLog();
            if (r10 == null) goto L6;
            ApmAgent.r("monitorEvent", r10.toString());
            return;
        }
    }

    static {
        f6288f = new AtomicLong(0);
    }

    public static /* synthetic */ JSONObject a(JSONObject r10, boolean r11) {
        return n(r10, r11);
    }

    public static void b(JSONObject r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L6
        r11.put("_debug_uuid", w0.c.z() + "_" + f6288f.getAndAdd(1));     // Catch: Exception -> L6
        r10.put("_debug_self", r11);     // Catch: Exception -> L6
        return;
    }

    public static JSONObject c(JSONObject r10) {
        if (r10 != null) goto L5;
        r10 = new JSONObject();
    L5:
        if (r10.isNull("timestamp") == true) goto L11;
    L10:
        return r10;
    L11:
        r10.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static void d(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = o(r21);
        AsyncEventManager.e().h(new m(r13, r15, r17, r18, r19, r20, r10));
        if (w0.c.D() == false) goto L6;
        d2.b.a().b(new n(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void e(String r10, JSONObject r11) {
        f(r10, r11, false);
    }

    public static void f(String r10, JSONObject r11, boolean r12) {
        if (k2.a.l(r10, Boolean.FALSE) == false) goto L6;
        m(r10, r11);
        return;
    L6:
        JSONObject r13 = p(r11);
        b(r13);
        AsyncEventManager.e().h(new i(r10, r13));
        if (w0.c.D() == false) goto L10;
        JSONObject r14 = n(r13, true);
        d2.b.a().b(new j(r10, r14, r12));
        return;
    }

    public static void g(String r10, JSONObject r11, JSONObject r12) {
        if (k2.a.l(r10, Boolean.TRUE) == false) goto L6;
        m(r10, r11);
        return;
    L6:
        JSONObject r13 = p(r12);
        b(r13);
        if (f6286d == false) goto L9;
        JSONObject r14 = com.bytedance.apm.util.i.h(r11);
    L10:
        k2.a.e(r10, r14, r13);
        if (w0.c.D() == false) goto L14;
        JSONObject r15 = n(r11, true);
        JSONObject r16 = n(r13, true);
        d2.b.a().b(new d(r10, r15, r16));
        return;
    L14:
        return;
    L9:
        r14 = r11;
        goto L10
    }

    public static void h(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        if (k2.a.l(r10, Boolean.TRUE) == false) goto L6;
        m(r10, r11);
        return;
    L6:
        JSONObject r14 = p(r13);
        b(r14);
        k2.a.g(r10, n(r11, true), n(r12, true), r14);
        if (w0.c.D() == false) goto L10;
        JSONObject r15 = n(r11, true);
        JSONObject r16 = n(r12, true);
        JSONObject r17 = n(r14, true);
        d2.b.a().b(new o(r10, r15, r16, r17));
        return;
    }

    public static void i(String r10, JSONObject r11) {
        JSONObject r12 = p(r11);
        AsyncEventManager.e().h(new f(r10, r12));
        if (w0.c.D() == false) goto L6;
        d2.b.a().b(new h(r10, r12));
        return;
    }

    public static void j(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = o(r21);
        AsyncEventManager.e().h(new g(r13, r15, r17, r18, r19, r20, r10));
        if (w0.c.D() == false) goto L6;
        d2.b.a().b(new k(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void k(String r10, int r11, JSONObject r12, JSONObject r13) {
        if (k2.a.l(r10, Boolean.TRUE) == false) goto L6;
        m(r10, r12);
        return;
    L6:
        JSONObject r14 = o(r13);
        b(r14);
        k2.a.h(r10, r11, n(r12, true), n(r14, false));
        if (w0.c.D() == false) goto L10;
        JSONObject r15 = n(r12, true);
        JSONObject r16 = n(r13, true);
        d2.b.a().b(new e(r10, r11, r15, r16));
        return;
    }

    public static void l(String r10, int r11, JSONObject r12) {
        if (k2.a.l(r10, Boolean.TRUE) == false) goto L6;
        m(r10, r12);
        return;
    L6:
        JSONObject r13 = p(r12);
        b(r13);
        k2.a.j(r10, r11, r13);
        if (w0.c.D() == false) goto L10;
        JSONObject r14 = n(r13, true);
        d2.b.a().b(new c(r10, r11, r14));
        return;
    }

    public static void m(String r10, JSONObject r11) {
        if (w0.c.B() == false) goto L8;
        if (r11 != null) goto L6;
        r11 = new JSONObject();
    L6:
        o1.a.b(r10, r11, false);
        return;
    }

    public static void monitorEvent(h1.d r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (k2.a.l(r10.e(), Boolean.TRUE) == false) goto L8;
        m(r10.e(), null);
        return;
    L8:
        JSONObject r11 = c(r10.c());
        b(r11);
        AsyncEventManager.e().h(new a(r10, r11));
        if (w0.c.D() == false) goto L12;
        JSONObject r12 = n(r10.b(), true);
        JSONObject r13 = n(r10.d(), true);
        JSONObject r14 = n(r11, true);
        d2.b.a().b(new b(r10, r12, r13, r14));
        return;
    }

    public static JSONObject n(JSONObject r10, boolean r11) {
        if (f6283a == false) goto L8;
        if (r11 == true) goto L7;
        return r10;
    L7:
        return com.bytedance.apm.util.i.j(r10);
    L8:
        return com.bytedance.apm.util.i.c(r10);
    }

    public static JSONObject o(JSONObject r10) {
        if (f6283a == false) goto L6;
        return com.bytedance.apm.util.i.j(r10);
    L6:
        return p(r10);
    }

    public static JSONObject p(JSONObject r10) {
        if (r10 != null) goto L6;
        r10 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r10;
    L6:
        if (r10.isNull("timestamp") == false) goto L8;
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    public static void q(Context r10, long r11, long r12, boolean r13) {
    }

    public static void r(String r18, String r19) {
        monitor-enter(ApmAgent.class);     // Catch: Throwable -> L41
        String r10 = w0.c.h();     // Catch: Throwable -> L9
        long r11 = Thread.currentThread().getId();     // Catch: Throwable -> L9
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L9
        String r13 = v.a();     // Catch: Throwable -> L9
        StringBuffer r14 = new StringBuffer();     // Catch: Throwable -> L9
        r14.append(r18);     // Catch: Throwable -> L9
        r14.append("#");     // Catch: Throwable -> L9
        r14.append(r11);     // Catch: Throwable -> L9
        r14.append("#");     // Catch: Throwable -> L9
        r14.append(r12);     // Catch: Throwable -> L9
        r14.append("#");     // Catch: Throwable -> L9
        r14.append(r13);     // Catch: Throwable -> L9
        r14.append("\n");     // Catch: Throwable -> L9
        r14.append(r19);     // Catch: Throwable -> L9
        r14.append("\n");     // Catch: Throwable -> L9
        byte[] r15 = r14.toString().getBytes("UTF-8");     // Catch: Throwable -> L9
        String r16 = w0.c.g().getExternalFilesDir(null).getAbsolutePath();     // Catch: Throwable -> L9
        if (f6287e != null) goto L20;
        File r17 = new File(r16 + "/logs");     // Catch: Throwable -> L9
        f6284b = new File(r16 + "/logs/proc: " + r10);     // Catch: Throwable -> L9
        File r20 = new File(r16 + "/logs/proc: " + r10 + LibrarianImpl.Constants.SEPARATOR + r13);     // Catch: Throwable -> L9
        if (r17.exists() == true) goto L12;
        r17.mkdirs();     // Catch: Throwable -> L9
    L12:
        if (f6284b.exists() == true) goto L14;
        f6284b.mkdirs();     // Catch: Throwable -> L9
    L14:
        r20.createNewFile();     // Catch: Throwable -> L9
        FileChannel r110 = new RandomAccessFile(r20, "rw").getChannel();     // Catch: Throwable -> L9
        FileChannel.MapMode r111 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L9
        if (w0.c.F() == false) goto L17;
        long r112 = 2097152;
    L18:
        f6287e = r110.map(r111, 0, r112);     // Catch: Throwable -> L9
        goto L20
    L17:
        r112 = 262144;
    L20:
        if (f6287e.remaining() >= r15.length) goto L26;
        f6287e.force();     // Catch: Throwable -> L9
        FileChannel r113 = new RandomAccessFile(new File(r16 + "/logs/proc: " + r10 + LibrarianImpl.Constants.SEPARATOR + r13), "rw").getChannel();     // Catch: Throwable -> L9
        FileChannel.MapMode r114 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L9
        if (w0.c.F() == false) goto L24;
        long r115 = 2097152;
    L25:
        f6287e = r113.map(r114, 0, r115);     // Catch: Throwable -> L9
        goto L26
    L24:
        r115 = 262144;
    L26:
        f6287e.put(r15);     // Catch: Throwable -> L9
        if (f6285c == (-1)) goto L31;
        if ((System.currentTimeMillis() - f6285c) > 3600000) goto L31;
    L36:
        monitor-exit(ApmAgent.class);     // Catch: Throwable -> L9
        goto L46
    L40:
        return;
    L31:
        if (com.bytedance.apm.util.f.b(f6284b) <= 1073741824) goto L33;
    L34:
        s();     // Catch: Throwable -> L9
    L35:
        f6285c = System.currentTimeMillis();     // Catch: Throwable -> L9
        goto L36
    L33:
        if (com.bytedance.apm.util.f.a(w0.c.g()).getFreeSpace() >= 1073741824) goto L35;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    }

    public static void s() {
        if (w0.c.F() == true) goto L6;
        return;
    L6:
        if (f6284b.exists() == true) goto L8;
        return;
    L8:
        File[] r10 = f6284b.listFiles();
        Arrays.sort(r10, new l());
        int r11 = 60;
        if (r10.length > 60) goto L12;
        r11 = r10.length;
    L12:
        int r12 = 0;
    L13:
        if (r12 >= r11) goto L15;
        r10[r12].delete();
        r12 = r12 + 1;
        goto L13
    }
}
