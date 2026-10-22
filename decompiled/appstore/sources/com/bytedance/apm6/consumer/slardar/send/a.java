package com.bytedance.apm6.consumer.slardar.send;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f6686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f6687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f6688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap f6689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f6691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f6692g;

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.send.a$a, reason: collision with other inner class name */
    public class C0078a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f6693a;

        public C0078a(a r10) {
            this.f6693a = r10;
        }

        public int a(String r10, String r11) {
            return String.CASE_INSENSITIVE_ORDER.compare(r10, r11);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((String) r10, (String) r11);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f6694a;

        static {
            f6694a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f6694a;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f6696b;

        public c(int r10, long r11) {
            this.f6695a = r10;
            this.f6696b = r11;
        }

        public static /* synthetic */ int a(c r10) {
            return r10.f6695a;
        }

        public static /* synthetic */ long b(c r10) {
            return r10.f6696b;
        }

        public static c e(String r10) {
            String[] r11 = r10.split("_");     // Catch: Exception -> L4
            return new c(Integer.parseInt(r11[0]), Long.parseLong(r11[1]));
        L4:
            return null;
        }

        public int c() {
            return this.f6695a;
        }

        public String d() {
            return this.f6695a + "_" + this.f6696b;
        }

        public void f(int r10, long r11) {
            this.f6695a = r10;
            this.f6696b = r11;
        }
    }

    public /* synthetic */ a(C0078a r10) {
        this();
    }

    public static long d(File r10) {
        String[] r11 = r10.getName().split("_");     // Catch: Throwable -> L8
        if (r11.length == 2) goto L6;
        return -1;
    L6:
        return Long.parseLong(r11[0]);
    L11:
        return -1;
    }

    public static a f() {
        return b.a();
    }

    public final void a(String r10) {
        if (this.f6692g.size() <= PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L6;
        this.f6690e++;
        return;
    L6:
        this.f6692g.add(r10);
    }

    public synchronized void b(File r10) {
        monitor-enter(this);
        if (r10 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f6692g.remove(r10.getName());     // Catch: Throwable -> L9
        c();     // Catch: Throwable -> L9
        r3.c.a(r10);     // Catch: Throwable -> L9
        this.f6689d.remove(r10.getName());     // Catch: Throwable -> L9
        SharedPreferences.Editor r11 = this.f6686a.edit();     // Catch: Throwable -> L9
        r11.remove(r10.getName());     // Catch: Throwable -> L9
        r11.commit();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f6687b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        File r10 = new File(n2.b.f(), "log");     // Catch: Throwable -> L10
        if (r10.exists() == true) goto L12;
        r10.mkdirs();     // Catch: Throwable -> L10
    L12:
        this.f6688c = r10;     // Catch: Throwable -> L10
        this.f6686a = r3.a.b().getSharedPreferences("log_report_message", 0);     // Catch: Throwable -> L10
        this.f6687b = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public File e() {
        c();
        return this.f6688c;
    }

    public c g(File r10) {
        c r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        c();
        String r12 = r10.getName();
        if (this.f6689d.containsKey(r12) == false) goto L10;
        return (c) this.f6689d.get(r12);
    L10:
        if (this.f6686a.contains(r12) == false) goto L16;
        String r13 = this.f6686a.getString(r12, "");
        if (TextUtils.isEmpty(r13) == true) goto L14;
        r11 = c.e(r13);
    L14:
        if (r11 == null) goto L16;
        this.f6689d.put(r12, r11);
    L16:
        return r11;
    }

    public synchronized File h(String r10) {
        monitor-enter(this);
        String r11 = LibrarianImpl.Constants.DOT + r10;     // Catch: Throwable -> L6
        i();     // Catch: Throwable -> L6
        if (r3.a.c() == false) goto L9;
        s3.a.a(n2.a.f22354a, "failedFiles:" + this.f6692g + " " + r11);     // Catch: Throwable -> L6
    L9:
        File r12 = null;
        if (this.f6692g.size() != 0) goto L13;
        monitor-exit(this);
        return null;
    L13:
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L6
        Iterator r14 = this.f6692g.iterator();     // Catch: Throwable -> L6
    L15:
        if (r14.hasNext() == false) goto L20;
        String r15 = (String) r14.next();     // Catch: Throwable -> L6
        if (r15.endsWith(r11) == false) goto L15;
        r13.add(r15);     // Catch: Throwable -> L6
        goto L15
    L20:
        if (ListUtils.b(r13) == false) goto L23;
        monitor-exit(this);
        return null;
    L23:
        Collections.sort(r13, new C0078a(this));     // Catch: Throwable -> L6
        Iterator r16 = r13.iterator();     // Catch: Throwable -> L6
        c r17 = null;
    L24:
        if (r16.hasNext() == false) goto L43;
        File r18 = new File(f().e(), (String) r16.next());     // Catch: Throwable -> L6
        c r19 = g(r18);     // Catch: Throwable -> L6
        if (r19 == null) goto L42;
        if (r3.a.c() == false) goto L33;
        s3.a.a(n2.a.f22354a, "list send file:" + r18.getName() + " " + c.a(r19) + " " + c.b(r19) + " " + System.currentTimeMillis());     // Catch: Throwable -> L6
    L33:
        if (c.a(r19) == 0) goto L42;
        if (c.b(r19) < System.currentTimeMillis()) goto L42;
        if (r17 == null) goto L41;
        if (c.b(r17) <= c.b(r19)) goto L24;
    L41:
        r17 = r19;
        r12 = r18;
    L42:
        r12 = r18;
    L43:
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void i() {
        monitor-enter(this);
        int r10 = 0;
        if (this.f6691f == true) goto L15;
        String[] r11 = f().e().list();     // Catch: Throwable -> L10
        int r12 = r11.length;     // Catch: Throwable -> L10
    L6:
        if (r10 >= r12) goto L13;
        String r13 = r11[r10];     // Catch: Throwable -> L10
        if (this.f6692g.contains(r13) == true) goto L12;
        a(r13);     // Catch: Throwable -> L10
    L12:
        r10 = r10 + 1;     // Catch: Throwable -> L10
        goto L6
    L13:
        this.f6691f = true;     // Catch: Throwable -> L10
    L25:
        monitor-exit(this);
        return;
    L15:
        if (this.f6690e <= 0) goto L25;
        if (this.f6692g.size() != 0) goto L25;
        String[] r14 = f().e().list();     // Catch: Throwable -> L10
        int r15 = r14.length;     // Catch: Throwable -> L10
    L19:
        if (r10 >= r15) goto L24;
        String r16 = r14[r10];     // Catch: Throwable -> L10
        if (this.f6692g.contains(r16) == true) goto L23;
        a(r16);     // Catch: Throwable -> L10
    L23:
        r10 = r10 + 1;     // Catch: Throwable -> L10
        goto L19
    L24:
        this.f6690e -= (long) this.f6692g.size();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public File[] j() {
        c();
        File r10 = this.f6688c;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.listFiles();
    }

    public synchronized boolean k(byte[] r10, String r11, int r12, long r13) {
        monitor-enter(this);
        c();     // Catch: Throwable -> L22
        if (this.f6688c != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        String r14 = String.format("%d%s%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), LibrarianImpl.Constants.DOT, r11});     // Catch: Throwable -> L22
        File r15 = new File(this.f6688c, r14);     // Catch: Throwable -> L22
        FileChannel r16 = null;
        l(r15, r12, r13);     // Catch: Throwable -> L13
        r16 = new FileOutputStream(r15).getChannel();     // Catch: Throwable -> L13
        r16.write(ByteBuffer.wrap(r10));     // Catch: Throwable -> L13
        if (this.f6692g.contains(r14) == true) goto L16;
        a(r14);     // Catch: Throwable -> L13
    L16:
        if (r3.a.c() == false) goto L18;
        s3.a.a(n2.a.f22354a, "saveFile:" + r15.getName());     // Catch: Throwable -> L13
    L18:
        r3.d.a(r16);     // Catch: Throwable -> L22
        monitor-exit(this);
        return true;
    L13:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "saveFile", th);     // Catch: Throwable -> L28
        r3.d.a(r16);     // Catch: Throwable -> L22
        return false;
    L28:
        th = move-exception;
        r3.d.a(r16);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public void l(File r10, int r11, long r12) {
        if (r10 != null) goto L14;
        return;
    L14:
        c();     // Catch: Throwable -> L7
        SharedPreferences.Editor r13 = this.f6686a.edit();     // Catch: Throwable -> L7
        String r14 = r10.getName();     // Catch: Throwable -> L7
        if (this.f6689d.containsKey(r14) == false) goto L9;
        c r15 = (c) this.f6689d.get(r14);     // Catch: Throwable -> L7
    L10:
        r15.f(r11, r12);     // Catch: Throwable -> L7
        r13.putString(r14, r15.d());     // Catch: Throwable -> L7
        r13.commit();     // Catch: Throwable -> L7
        return;
    L9:
        c r16 = new c(r11, r12);     // Catch: Throwable -> L7
        this.f6689d.put(r14, r16);     // Catch: Throwable -> L7
        r15 = r16;
    L7:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "updateRetryMessage", th);
    }

    public a() {
        this.f6689d = new ConcurrentHashMap();
        this.f6690e = 0;
        this.f6691f = false;
        this.f6692g = new ArrayList();
    }
}
