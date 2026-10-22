package Z7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class T {

    /* renamed from: e, reason: collision with root package name */
    public static T f7373e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f7374f = System.currentTimeMillis();

    /* renamed from: a, reason: collision with root package name */
    public Context f7375a;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences f7378d;

    /* renamed from: c, reason: collision with root package name */
    public Map<Integer, Map<String, com.tencent.bugly.proguard.t>> f7377c = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public String f7376b = C1130b.l().f7455f;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7379a = 1004;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7380b;

        public a(int i10) {
            this.f7380b = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.proguard.t tVar;
            try {
                if (TextUtils.isEmpty(T.this.f7376b)) {
                    return;
                }
                List<com.tencent.bugly.proguard.t> listO = T.this.o(this.f7379a);
                if (listO == null) {
                    listO = new ArrayList();
                }
                if (T.this.f7377c.get(Integer.valueOf(this.f7379a)) == null) {
                    T.this.f7377c.put(Integer.valueOf(this.f7379a), new HashMap());
                }
                if (((Map) T.this.f7377c.get(Integer.valueOf(this.f7379a))).get(T.this.f7376b) == null) {
                    tVar = new com.tencent.bugly.proguard.t();
                    tVar.f31697a = this.f7379a;
                    tVar.f31703g = T.f7374f;
                    tVar.f31698b = T.this.f7376b;
                    tVar.f31702f = C1130b.l().f7422D;
                    tVar.f31701e = C1130b.l().f7463j;
                    tVar.f31699c = System.currentTimeMillis();
                    tVar.f31700d = this.f7380b;
                    ((Map) T.this.f7377c.get(Integer.valueOf(this.f7379a))).put(T.this.f7376b, tVar);
                } else {
                    tVar = (com.tencent.bugly.proguard.t) ((Map) T.this.f7377c.get(Integer.valueOf(this.f7379a))).get(T.this.f7376b);
                    tVar.f31700d = this.f7380b;
                }
                ArrayList arrayList = new ArrayList();
                boolean z10 = false;
                for (com.tencent.bugly.proguard.t tVar2 : listO) {
                    if (T.h(tVar2, tVar)) {
                        tVar2.f31700d = tVar.f31700d;
                        z10 = true;
                    }
                    if (T.l(tVar2, tVar)) {
                        arrayList.add(tVar2);
                    }
                }
                listO.removeAll(arrayList);
                if (!z10) {
                    listO.add(tVar);
                }
                T.this.f(this.f7379a, listO);
            } catch (Exception unused) {
                C1139k.j("saveCrashRecord failed", new Object[0]);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7382a;

        public b(int i10) {
            this.f7382a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean zN = T.this.n(this.f7382a);
            T.this.f7378d.edit().putBoolean(this.f7382a + "_" + T.this.f7376b, !zN).commit();
        }
    }

    public T(Context context) {
        this.f7375a = context;
        this.f7378d = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized T a() {
        return f7373e;
    }

    public static synchronized T b(Context context) {
        try {
            if (f7373e == null) {
                f7373e = new T(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7373e;
    }

    public static /* synthetic */ boolean h(com.tencent.bugly.proguard.t tVar, com.tencent.bugly.proguard.t tVar2) {
        String str;
        return tVar.f31703g == tVar2.f31703g && (str = tVar.f31698b) != null && str.equalsIgnoreCase(tVar2.f31698b);
    }

    public static /* synthetic */ boolean l(com.tencent.bugly.proguard.t tVar, com.tencent.bugly.proguard.t tVar2) {
        String str = tVar.f31701e;
        if (str != null && !str.equalsIgnoreCase(tVar2.f31701e)) {
            return true;
        }
        String str2 = tVar.f31702f;
        return !(str2 == null || str2.equalsIgnoreCase(tVar2.f31702f)) || tVar.f31700d <= 0;
    }

    public final void e(int i10) {
        C1138j.a().b(new a(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004c A[Catch: all -> 0x002a, Exception -> 0x0050, TRY_ENTER, TryCatch #1 {Exception -> 0x0050, blocks: (B:7:0x0006, B:11:0x0025, B:32:0x004c, B:33:0x004f, B:26:0x0043), top: B:39:0x0006, outer: #3 }] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized <T extends java.util.List<?>> void f(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
            android.content.Context r2 = r4.f7375a     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r2.writeObject(r6)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            r2.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
            monitor-exit(r4)
            return
        L2a:
            r5 = move-exception
            goto L59
        L2c:
            r5 = move-exception
            goto L4a
        L2e:
            r5 = move-exception
            goto L37
        L30:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L4a
        L34:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L37:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L2c
            Z7.C1139k.d(r5, r6)     // Catch: java.lang.Throwable -> L2c
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
            monitor-exit(r4)
            return
        L48:
            monitor-exit(r4)
            return
        L4a:
            if (r2 == 0) goto L4f
            r2.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
        L4f:
            throw r5     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L50
        L50:
            java.lang.String r5 = "writeCrashRecord error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L2a
            Z7.C1139k.j(r5, r6)     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r4)
            return
        L59:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2a
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.T.f(int, java.util.List):void");
    }

    public final synchronized boolean j(int i10) {
        boolean z10;
        z10 = true;
        try {
            z10 = this.f7378d.getBoolean(i10 + "_" + this.f7376b, true);
            C1138j.a().b(new b(i10));
        } catch (Exception unused) {
            C1139k.j("canInit error", new Object[0]);
            return z10;
        }
        return z10;
    }

    public final synchronized boolean n(int i10) {
        try {
            try {
                List<com.tencent.bugly.proguard.t> listO = o(i10);
                if (listO == null) {
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (com.tencent.bugly.proguard.t tVar : listO) {
                    String str = tVar.f31698b;
                    if (str != null && str.equalsIgnoreCase(this.f7376b) && tVar.f31700d > 0) {
                        arrayList.add(tVar);
                    }
                    if (tVar.f31699c + 86400000 < jCurrentTimeMillis) {
                        arrayList2.add(tVar);
                    }
                }
                Collections.sort(arrayList);
                if (arrayList.size() < 2) {
                    listO.removeAll(arrayList2);
                    f(i10, listO);
                    return false;
                }
                if (arrayList.size() <= 0 || ((com.tencent.bugly.proguard.t) arrayList.get(arrayList.size() - 1)).f31699c + 86400000 >= jCurrentTimeMillis) {
                    return true;
                }
                listO.clear();
                f(i10, listO);
                return false;
            } catch (Exception unused) {
                C1139k.j("isFrequentCrash failed", new Object[0]);
                return false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042 A[Catch: all -> 0x0031, Exception -> 0x0057, PHI: r6
      0x0042: PHI (r6v10 java.io.ObjectInputStream) = (r6v9 java.io.ObjectInputStream), (r6v11 java.io.ObjectInputStream) binds: [B:21:0x0040, B:26:0x004e] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x0057, blocks: (B:4:0x0003, B:10:0x002c, B:29:0x0053, B:30:0x0056, B:22:0x0042), top: B:38:0x0003, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized <T extends java.util.List<?>> T o(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
            android.content.Context r3 = r5.f7375a     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
            if (r6 != 0) goto L1c
            monitor-exit(r5)
            return r0
        L1c:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L35 java.lang.ClassNotFoundException -> L38 java.io.IOException -> L46
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L35 java.lang.ClassNotFoundException -> L38 java.io.IOException -> L46
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L35 java.lang.ClassNotFoundException -> L38 java.io.IOException -> L46
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L35 java.lang.ClassNotFoundException -> L38 java.io.IOException -> L46
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L39 java.io.IOException -> L47
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L39 java.io.IOException -> L47
            r6.close()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
            monitor-exit(r5)
            return r2
        L31:
            r6 = move-exception
            goto L60
        L33:
            r2 = move-exception
            goto L51
        L35:
            r2 = move-exception
            r6 = r0
            goto L51
        L38:
            r6 = r0
        L39:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L33
            Z7.C1139k.d(r2, r3)     // Catch: java.lang.Throwable -> L33
            if (r6 == 0) goto L5e
        L42:
            r6.close()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
            goto L5e
        L46:
            r6 = r0
        L47:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L33
            Z7.C1139k.d(r2, r3)     // Catch: java.lang.Throwable -> L33
            if (r6 == 0) goto L5e
            goto L42
        L51:
            if (r6 == 0) goto L56
            r6.close()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
        L56:
            throw r2     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L57
        L57:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L31
            Z7.C1139k.j(r6, r1)     // Catch: java.lang.Throwable -> L31
        L5e:
            monitor-exit(r5)
            return r0
        L60:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L31
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.T.o(int):java.util.List");
    }
}
