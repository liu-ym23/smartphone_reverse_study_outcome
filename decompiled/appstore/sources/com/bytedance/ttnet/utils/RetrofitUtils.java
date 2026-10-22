package com.bytedance.ttnet.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.e;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.intercept.Interceptor;
import f6.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class RetrofitUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f8193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Map f8194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.bytedance.frameworks.baselib.network.http.util.d f8195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static com.bytedance.frameworks.baselib.network.http.util.d f8196d;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r10 = new CompressType("NONE", 0, 0);
            NONE = r10;
            CompressType r11 = new CompressType("GZIP", 1, 1);
            GZIP = r11;
            CompressType r12 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r12;
            $VALUES = new CompressType[]{r10, r11, r12};
        }

        private CompressType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static CompressType valueOf(String r10) {
            return (CompressType) Enum.valueOf(CompressType.class, r10);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }
    }

    public static class a implements Client.Provider {
        public a() {
        }

        @Override // com.bytedance.retrofit2.client.Client.Provider
        public Client get() {
            return new r6.c();
        }
    }

    public static class b implements Client.Provider {
        public b() {
        }

        @Override // com.bytedance.retrofit2.client.Client.Provider
        public Client get() {
            return new r6.c();
        }
    }

    public static abstract class c implements Interceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Interceptor f8197a;

        public c(Interceptor r10) {
            this.f8197a = r10;
        }
    }

    public static class d extends c {
        public d(Interceptor r10) {
            super(r10);
        }

        @Override // com.bytedance.retrofit2.intercept.Interceptor
        public f intercept(Interceptor.Chain r10) {
            long r11 = System.currentTimeMillis();
            String r12 = this.f8197a.getClass().getName();
            String r13 = r12.substring(r12.lastIndexOf(46) + 1, r12.length());
            r10.metrics().Q.put(r13 + "Time", Long.valueOf(r11));
            return this.f8197a.intercept(r10);
        }
    }

    static {
        f8193a = new CopyOnWriteArrayList();
        f8194b = new ConcurrentHashMap();
        com.bytedance.retrofit2.f.r(f8193a);
        f8195c = new com.bytedance.frameworks.baselib.network.http.util.d(10);
        f8196d = new com.bytedance.frameworks.baselib.network.http.util.d(10);
    }

    public static synchronized void a(Interceptor r10) {
        monitor-enter(RetrofitUtils.class);
        if (r10 != null) goto L18;
        monitor-exit(RetrofitUtils.class);
        return;
    L18:
        String r11 = r10.getClass().getName();     // Catch: Throwable -> L10
        if (f8194b.containsKey(r11) == true) goto L12;
        Interceptor r12 = new d(r10);     // Catch: Throwable -> L10
        f8193a.add(r12);     // Catch: Throwable -> L10
        f8194b.put(r11, r12);     // Catch: Throwable -> L10
    L13:
        com.bytedance.ttnet.utils.c.d(f8195c, r12);     // Catch: Throwable -> L10
        com.bytedance.ttnet.utils.c.d(f8196d, r12);     // Catch: Throwable -> L10
        monitor-exit(RetrofitUtils.class);
        return;
    L12:
        r12 = (Interceptor) f8194b.get(r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized com.bytedance.retrofit2.f b(String r10, List r11, Converter.a r12, CallAdapter.a r13, Client.Provider r14) {
        monitor-enter(RetrofitUtils.class);
        ArrayList r15 = null;
        if (r12 != null) goto L17;
        ArrayList r16 = null;
    L10:
        if (r13 == null) goto L12;
        r15 = new ArrayList();     // Catch: Throwable -> L7
        r15.add(r13);     // Catch: Throwable -> L7
    L12:
        com.bytedance.retrofit2.f r17 = c(r11, r16, r15, r14, r10);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r17;
    L7:
        th = move-exception;
        throw th;
    L17:
        r16 = new ArrayList();     // Catch: Throwable -> L7
        r16.add(r12);     // Catch: Throwable -> L7
        goto L10
    }

    public static synchronized com.bytedance.retrofit2.f c(List r10, List r11, List r12, Client.Provider r13, String r14) {
        monitor-enter(RetrofitUtils.class);
        if (r13 == null) goto L57;
    L8:
        com.bytedance.retrofit2.f.b r15 = new com.bytedance.retrofit2.f.b().h(r14).e(r13).f(new w4.c());     // Catch: Throwable -> L6
        if (r11 != null) goto L12;
        r11 = new ArrayList();     // Catch: Throwable -> L6
    L12:
        if (r11.isEmpty() == false) goto L14;
        r11.add(x4.a.f());     // Catch: Throwable -> L6
    L14:
        Iterator r16 = r11.iterator();     // Catch: Throwable -> L6
    L16:
        if (r16.hasNext() == false) goto L18;
        r15.b((Converter.a) r16.next());     // Catch: Throwable -> L6
        goto L16
    L18:
        if (r12 != null) goto L20;
    L25:
        LinkedList r17 = new LinkedList();     // Catch: Throwable -> L6
        if (r10 != null) goto L28;
    L40:
        boolean r18 = false;
    L41:
        if (r18 == true) goto L44;
        r17.add(0, new r6.b());     // Catch: Throwable -> L6
    L44:
        if (f8193a != null) goto L46;
    L48:
        r17.add(new w4.b());     // Catch: Throwable -> L6
        Iterator r19 = r17.iterator();     // Catch: Throwable -> L6
    L50:
        if (r19.hasNext() == false) goto L52;
        r15.c((Interceptor) r19.next());     // Catch: Throwable -> L6
        goto L50
    L52:
        com.bytedance.retrofit2.f r20 = r15.d();     // Catch: Throwable -> L6
        monitor-exit(RetrofitUtils.class);
        return r20;
    L6:
        th = move-exception;
        throw th;
    L46:
        if (f8193a.size() <= 0) goto L48;
        r17.addAll(f8193a);     // Catch: Throwable -> L6
        goto L48
    L28:
        if (r10.size() <= 0) goto L40;
        Iterator r21 = r10.iterator();     // Catch: Throwable -> L6
        r18 = false;
    L31:
        if (r21.hasNext() == false) goto L41;
        Interceptor r22 = (Interceptor) r21.next();     // Catch: Throwable -> L6
        if ((r22 instanceof r6.b) == true) goto L34;
        if ((r22 instanceof w4.b) == true) goto L31;
    L39:
        r17.add(r22);     // Catch: Throwable -> L6
        goto L31
    L34:
        if (r18 == true) goto L31;
        r17.add(r22);     // Catch: Throwable -> L6
        r18 = true;
        goto L39
    L20:
        if (r12.isEmpty() == true) goto L25;
        Iterator r23 = r12.iterator();     // Catch: Throwable -> L6
    L23:
        if (r23.hasNext() == false) goto L25;
        r15.a((CallAdapter.a) r23.next());     // Catch: Throwable -> L6
        goto L23
    L57:
        r13 = new b();     // Catch: Throwable -> L6
        goto L8
    }

    public static synchronized Object d(com.bytedance.retrofit2.f r10, Class r11) {
        monitor-enter(RetrofitUtils.class);
        if (r10 != null) goto L14;
        monitor-exit(RetrofitUtils.class);
        return null;
    L14:
        Object r12 = r10.e(r11);     // Catch: Throwable -> L8
        monitor-exit(RetrofitUtils.class);
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized com.bytedance.retrofit2.f e(String r10, List r11, Converter.a r12, CallAdapter.a r13) {
        monitor-enter(RetrofitUtils.class);
        com.bytedance.retrofit2.f r14 = b(r10, r11, r12, r13, new a());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r14;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Object f(String r10, Class r11) {
        monitor-enter(RetrofitUtils.class);
        Object r12 = d(h(r10), r11);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static String g(List r10, String r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L23;
        Iterator r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        g6.a r13 = (g6.a) r12.next();
        if (r11.equalsIgnoreCase(r13.a()) == false) goto L10;
        return r13.b();
    L15:
        return "";
    L23:
        return null;
    }

    public static synchronized com.bytedance.retrofit2.f h(String r10) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (e.b(r10) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        com.bytedance.retrofit2.f r11 = (com.bytedance.retrofit2.f) f8195c.d(r10);     // Catch: Throwable -> L16
        if (r11 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r11;
    L13:
        com.bytedance.retrofit2.f r12 = e(r10, null, null, null);     // Catch: Throwable -> L16
        f8195c.f(r10, r12);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r12;
    }

    public static Pair i(String r10) {
        String r11 = null;
        if (r10 != null) goto L17;
        return null;
    L17:
        MimeType r12 = new MimeType(r10);     // Catch: Throwable -> L10
        String r13 = r12.getBaseType();     // Catch: Throwable -> L10
        r11 = r12.getParameter("charset");     // Catch: Throwable -> L8
    L14:
        return new Pair(r13, r11);
    L8:
        th = th;
    L12:
        th.printStackTrace();
    L10:
        th = th;
        r13 = null;
        goto L12
    }
}
