package x8;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.VolleyLog;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.e;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Cache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f25832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f25833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f25834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25836e;

    /* JADX INFO: renamed from: x8.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0405a {
    }

    public static class b extends Cache.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f25837a;

        public b() {
            this.f25837a = false;
        }

        @Override // com.android.volley.Cache.Entry
        public boolean isExpired() {
            if (this.f25837a == false) goto L10;
            if (e.t() != null) goto L10;
            return false;
        L10:
            return super.isExpired();
        }

        @Override // com.android.volley.Cache.Entry
        public boolean refreshNeeded() {
            if (this.f25837a == false) goto L10;
            if (e.t() != null) goto L10;
            return false;
        L10:
            return super.refreshNeeded();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f25838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f25839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f25840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f25841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f25842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f25843f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f25844g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map f25845h;

        public c() {
        }

        public static c a(InputStream r10) {
            c r11 = new c();
            if (a.g(r10) != 538247942) goto L10;
            r11.f25839b = a.i(r10);
            String r12 = a.i(r10);
            r11.f25840c = r12;
            if (r12.equals("") == false) goto L7;
            r11.f25840c = null;
        L7:
            r11.f25841d = a.h(r10);
            r11.f25842e = a.h(r10);
            r11.f25843f = a.h(r10);
            r11.f25844g = a.h(r10);
            r11.f25845h = a.j(r10);
            return r11;
        L10:
            throw new IOException();
        }

        public Cache.Entry b(byte[] r10, boolean r11) {
            b r12 = new b();
            r12.data = r10;
            r12.etag = this.f25840c;
            r12.serverDate = this.f25841d;
            r12.ttl = this.f25843f;
            r12.softTtl = this.f25844g;
            r12.responseHeaders = this.f25845h;
            r12.f25837a = r11;
            return r12;
        }

        public boolean c(OutputStream r10) {
            a.m(r10, 538247942);     // Catch: IOException -> L6
            a.o(r10, this.f25839b);     // Catch: IOException -> L6
            String r11 = this.f25840c;     // Catch: IOException -> L6
            if (r11 != null) goto L8;
            r11 = "";
        L8:
            a.o(r10, r11);     // Catch: IOException -> L6
            a.n(r10, this.f25841d);     // Catch: IOException -> L6
            a.n(r10, this.f25842e);     // Catch: IOException -> L6
            a.n(r10, this.f25843f);     // Catch: IOException -> L6
            a.n(r10, this.f25844g);     // Catch: IOException -> L6
            a.p(this.f25845h, r10);     // Catch: IOException -> L6
            r10.flush();     // Catch: IOException -> L6
            return true;
        L6:
            e = move-exception;
            VolleyLog.d("%s", new Object[]{e.toString()});
            return false;
        }

        public c(String r10, Cache.Entry r11) {
            this.f25839b = r10;
            this.f25838a = r11.data.length;
            this.f25840c = r11.etag;
            this.f25841d = r11.serverDate;
            this.f25843f = r11.ttl;
            this.f25844g = r11.softTtl;
            this.f25845h = r11.responseHeaders;
        }
    }

    public static class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25846a;

        public /* synthetic */ d(InputStream r10, C0405a r11) {
            this(r10);
        }

        public static /* synthetic */ int a(d r10) {
            return r10.f25846a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int r10 = super.read();
            if (r10 == (-1)) goto L5;
            this.f25846a++;
        L5:
            return r10;
        }

        public d(InputStream r10) {
            super(r10);
            this.f25846a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] r10, int r11, int r12) {
            int r13 = super.read(r10, r11, r12);
            if (r13 == (-1)) goto L5;
            this.f25846a += r13;
        L5:
            return r13;
        }
    }

    public a(File r10, int r11) {
        this.f25832a = new LinkedHashMap(16, 0.75f, true);
        this.f25833b = 0;
        this.f25836e = false;
        this.f25834c = r10;
        this.f25835d = r11;
    }

    public static int f(InputStream r10) {
        int r11 = r10.read();
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        throw new EOFException();
    }

    public static int g(InputStream r10) {
        int r11 = (f(r10) | (f(r10) << 8)) | (f(r10) << 16);
        return (f(r10) << 24) | r11;
    }

    public static long h(InputStream r10) {
        return (((((((((long) f(r10)) & 255) | ((((long) f(r10)) & 255) << 8)) | ((((long) f(r10)) & 255) << 16)) | ((((long) f(r10)) & 255) << 24)) | ((((long) f(r10)) & 255) << 32)) | ((((long) f(r10)) & 255) << 40)) | ((((long) f(r10)) & 255) << 48)) | ((255 & ((long) f(r10))) << 56);
    }

    public static String i(InputStream r10) {
        return new String(l(r10, (int) h(r10)), "UTF-8");
    }

    public static Map j(InputStream r10) {
        int r11 = g(r10);
        if (r11 != 0) goto L5;
        Map r12 = Collections.emptyMap();
    L6:
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L9;
        r12.put(i(r10).intern(), i(r10).intern());
        r13 = r13 + 1;
        goto L7
    L9:
        return r12;
    L5:
        r12 = new HashMap(r11);
        goto L6
    }

    public static byte[] l(InputStream r10, int r11) {
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L7;
        int r14 = r10.read(r12, r13, r11 - r13);
        if (r14 == (-1)) goto L7;
        r13 = r13 + r14;
    L7:
        if (r13 != r11) goto L10;
        return r12;
    L10:
        throw new IOException("Expected " + r11 + " bytes, read " + r13 + " bytes");
    }

    public static void m(OutputStream r10, int r11) {
        r10.write(r11 & PrivateKeyType.INVALID);
        r10.write((r11 >> 8) & PrivateKeyType.INVALID);
        r10.write((r11 >> 16) & PrivateKeyType.INVALID);
        r10.write((r11 >> 24) & PrivateKeyType.INVALID);
    }

    public static void n(OutputStream r10, long r11) {
        r10.write((byte) r11);
        r10.write((byte) (r11 >>> 8));
        r10.write((byte) (r11 >>> 16));
        r10.write((byte) (r11 >>> 24));
        r10.write((byte) (r11 >>> 32));
        r10.write((byte) (r11 >>> 40));
        r10.write((byte) (r11 >>> 48));
        r10.write((byte) (r11 >>> 56));
    }

    public static void o(OutputStream r10, String r11) {
        byte[] r12 = c0.a(r11);
        n(r10, r12.length);
        r10.write(r12, 0, r12.length);
    }

    public static void p(Map r10, OutputStream r11) {
        if (r10 == null) goto L7;
        m(r11, r10.size());
        Iterator r12 = r10.entrySet().iterator();
    L5:
        if (r12.hasNext() == false) goto L10;
        Map.Entry r13 = (Map.Entry) r12.next();
        o(r11, (String) r13.getKey());
        o(r11, (String) r13.getValue());
        goto L5
    L10:
        return;
    L7:
        m(r11, 0);
    }

    public File a(String r10) {
        return new File(this.f25834c, b(r10));
    }

    public final String b(String r10) {
        int r11 = r10.length() / 2;
        return String.valueOf(r10.substring(0, r11).hashCode()) + String.valueOf(r10.substring(r11).hashCode());
    }

    public void c() {
        this.f25836e = true;
    }

    @Override // com.android.volley.Cache
    public synchronized void clear() {
        monitor-enter(this);
        File[] r10 = this.f25834c.listFiles();     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        int r11 = r10.length;     // Catch: Throwable -> L8
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L10;
        r10[r12].delete();     // Catch: Throwable -> L8
        r12 = r12 + 1;     // Catch: Throwable -> L8
    L10:
        this.f25832a.clear();     // Catch: Throwable -> L8
        this.f25833b = 0;     // Catch: Throwable -> L8
        VolleyLog.d("Cache cleared," + this.f25834c.getPath(), new Object[0]);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void d(int r13) {
        long r10 = r13;
        if ((this.f25833b + r10) >= this.f25835d) goto L5;
        return;
    L5:
        int r11 = 0;
        if (VolleyLog.DEBUG == false) goto L8;
        VolleyLog.v("Pruning old cache entries.", new Object[0]);
    L8:
        long r12 = this.f25833b;
        long r14 = SystemClock.elapsedRealtime();
        Iterator r15 = this.f25832a.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L18;
        c r16 = (c) ((Map.Entry) r15.next()).getValue();
        if (a(r16.f25839b).delete() == false) goto L14;
        this.f25833b -= r16.f25838a;
    L15:
        r15.remove();
        r11 = r11 + 1;
        if ((this.f25833b + r10) >= (this.f25835d * 0.9f)) goto L10;
    L14:
        String r17 = r16.f25839b;
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{r17, b(r17)});
    L18:
        if (VolleyLog.DEBUG == false) goto L24;
        VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[]{Integer.valueOf(r11), Long.valueOf(this.f25833b - r12), Long.valueOf(SystemClock.elapsedRealtime() - r14)});
        return;
    }

    public final void e(String r10, c r11) {
        if (this.f25832a.containsKey(r10) == true) goto L5;
        this.f25833b += r11.f25838a;
    L6:
        this.f25832a.put(r10, r11);
        return;
    L5:
        this.f25833b += r11.f25838a - ((c) this.f25832a.get(r10)).f25838a;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.volley.Cache
    public synchronized Cache.Entry get(String r10) {
        monitor-enter(this);
        c r11 = (c) this.f25832a.get(r10);     // Catch: Throwable -> L14
        FilterInputStream r12 = null;
        Object[] r13 = 0;
        if (r11 != null) goto L55;
        monitor-exit(this);
        return null;
    L55:
        File r14 = a(r10);     // Catch: Throwable -> L14
        d r15 = new d(new BufferedInputStream(new FileInputStream(r14)), r13 == true ? 1 : 0);     // Catch: Throwable -> L24 OutOfMemoryError -> L26 IOException -> L28
        c.a(r15);     // Catch: Throwable -> L18 OutOfMemoryError -> L20 IOException -> L22
        Cache.Entry r16 = r11.b(l(r15, (int) (r14.length() - ((long) d.a(r15)))), this.f25836e);     // Catch: Throwable -> L18 OutOfMemoryError -> L20 IOException -> L22
        r15.close();     // Catch: Throwable -> L14 IOException -> L16
        monitor-exit(this);
        return r16;
    L17:
        return null;
    L22:
        e = e;
    L39:
        VolleyLog.d("%s: %s", new Object[]{r14.getAbsolutePath(), e.toString()});     // Catch: Throwable -> L18
        remove(r10);     // Catch: Throwable -> L18
        if (r15 != null) goto L63;
    L45:
        monitor-exit(this);
        return null;
    L63:
        r15.close();     // Catch: Throwable -> L14 IOException -> L43
    L44:
        return null;
    L20:
        e = e;
    L31:
        e.P0(r10, true);     // Catch: Throwable -> L18
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r15 != null) goto L60;
    L37:
        monitor-exit(this);
        return null;
    L60:
        r15.close();     // Catch: Throwable -> L14 IOException -> L35
    L36:
        return null;
    L28:
        e = e;
        r15 = null;
    L26:
        e = e;
        r15 = null;
    L24:
        th = th;
    L47:
        if (0 != 0) goto L56;
    L52:
        throw th;     // Catch: Throwable -> L14
    L56:
        r12.close();     // Catch: Throwable -> L14 IOException -> L50
    L51:
        return null;
    L18:
        th = th;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f25834c.exists() == false) goto L6;
        File[] r10 = this.f25834c.listFiles();     // Catch: Throwable -> L9
        if (r10 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        int r11 = r10.length;     // Catch: Throwable -> L9
        int r12 = 0;
    L18:
        if (r12 >= r11) goto L39;
        File r13 = r10[r12];     // Catch: Throwable -> L9
        BufferedInputStream r14 = null;
        BufferedInputStream r15 = new BufferedInputStream(new FileInputStream(r13));     // Catch: Throwable -> L28 IOException -> L45
        goto L30
    L53:
        c r16 = c.a(r15);     // Catch: Throwable -> L25 IOException -> L27
        r16.f25838a = r13.length();     // Catch: Throwable -> L25 IOException -> L27
        e(r16.f25839b, r16);     // Catch: Throwable -> L25 IOException -> L27
        r15.close();     // Catch: Throwable -> L9 IOException -> L43
    L38:
        r12 = r12 + 1;
        goto L18
    L27:
        r14 = r15;
    L25:
        th = th;
        r14 = r15;
    L33:
        if (r14 != null) goto L49;
    L35:
        throw th;     // Catch: Throwable -> L9
    L49:
        r14.close();     // Catch: Throwable -> L9 IOException -> L44
    L28:
        th = th;
    L30:
        if (r13 == null) goto L36;
        r13.delete();     // Catch: Throwable -> L28
    L36:
        if (r14 == null) goto L38;
        r14.close();     // Catch: Throwable -> L9 IOException -> L43
        goto L38
    L39:
        monitor-exit(this);
        return;
    L6:
        if (this.f25834c.mkdirs() == true) goto L11;
        VolleyLog.e("Unable to create cache dir %s", new Object[]{this.f25834c.getAbsolutePath()});     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
    }

    @Override // com.android.volley.Cache
    public synchronized void invalidate(String r10, boolean r11) {
        monitor-enter(this);
        Cache.Entry r12 = get(r10);     // Catch: Throwable -> L8
        if (r12 == null) goto L11;
        r12.softTtl = 0;     // Catch: Throwable -> L8
        if (r11 == false) goto L10;
        r12.ttl = 0;     // Catch: Throwable -> L8
    L10:
        put(r10, r12);     // Catch: Throwable -> L8
    L11:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void k(String r10) {
        c r11 = (c) this.f25832a.get(r10);
        if (r11 == null) goto L6;
        this.f25833b -= r11.f25838a;
        this.f25832a.remove(r10);
        return;
    }

    @Override // com.android.volley.Cache
    public synchronized void put(String r10, Cache.Entry r11) {
        monitor-enter(this);
        d(r11.data.length);     // Catch: Throwable -> L9
        File r12 = a(r10);     // Catch: Throwable -> L9
        BufferedOutputStream r13 = new BufferedOutputStream(new FileOutputStream(r12));     // Catch: Throwable -> L9 IOException -> L13
        c r14 = new c(r10, r11);     // Catch: Throwable -> L9 IOException -> L13
        if (r14.c(r13) == false) goto L11;
        r13.write(r11.data);     // Catch: Throwable -> L9 IOException -> L13
        r13.close();     // Catch: Throwable -> L9 IOException -> L13
        e(r10, r14);     // Catch: Throwable -> L9 IOException -> L13
        monitor-exit(this);
        return;
    L11:
        r13.close();     // Catch: Throwable -> L9 IOException -> L13
        VolleyLog.d("Failed to write header for %s", new Object[]{r12.getAbsolutePath()});     // Catch: Throwable -> L9 IOException -> L13
        throw new IOException();     // Catch: Throwable -> L9 IOException -> L13
    L14:
        if (r12.delete() == true) goto L22;
        VolleyLog.d("Could not clean up file %s", new Object[]{r12.getAbsolutePath()});     // Catch: Throwable -> L9
        return;
    L22:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Cache
    public synchronized void remove(String r10) {
        monitor-enter(this);
        boolean r11 = a(r10).delete();     // Catch: Throwable -> L7
        k(r10);     // Catch: Throwable -> L7
        if (r11 == true) goto L9;
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{r10, b(r10)});     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
