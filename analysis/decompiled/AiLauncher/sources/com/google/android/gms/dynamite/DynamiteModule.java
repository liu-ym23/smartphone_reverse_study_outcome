package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class DynamiteModule {

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f19893h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f19894i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f19895j = false;

    /* renamed from: k, reason: collision with root package name */
    public static int f19896k = -1;

    /* renamed from: l, reason: collision with root package name */
    public static Boolean f19897l;

    /* renamed from: q, reason: collision with root package name */
    public static zzq f19902q;

    /* renamed from: r, reason: collision with root package name */
    public static zzr f19903r;

    /* renamed from: a, reason: collision with root package name */
    public final Context f19904a;

    /* renamed from: m, reason: collision with root package name */
    public static final ThreadLocal f19898m = new ThreadLocal();

    /* renamed from: n, reason: collision with root package name */
    public static final ThreadLocal f19899n = new v2.c();

    /* renamed from: o, reason: collision with root package name */
    public static final a.InterfaceC0228a f19900o = new com.google.android.gms.dynamite.a();

    /* renamed from: b, reason: collision with root package name */
    public static final a f19887b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final a f19888c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final a f19889d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final a f19890e = new e();

    /* renamed from: f, reason: collision with root package name */
    public static final a f19891f = new f();

    /* renamed from: g, reason: collision with root package name */
    public static final a f19892g = new g();

    /* renamed from: p, reason: collision with root package name */
    public static final a f19901p = new h();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, v2.f fVar) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, v2.f fVar) {
            super(str, th);
        }
    }

    public interface a {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a, reason: collision with other inner class name */
        public interface InterfaceC0228a {
            int a(Context context, String str, boolean z10) throws LoadingException;

            int b(Context context, String str);
        }

        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public int f19905a = 0;

            /* renamed from: b, reason: collision with root package name */
            public int f19906b = 0;

            /* renamed from: c, reason: collision with root package name */
            public int f19907c = 0;
        }

        b a(Context context, String str, InterfaceC0228a interfaceC0228a) throws LoadingException;
    }

    public DynamiteModule(Context context) {
        C1669j.k(context);
        this.f19904a = context;
    }

    public static int a(Context context, String str) throws NoSuchFieldException, ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (C1668i.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    public static int b(Context context, String str) {
        return e(context, str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #7 {all -> 0x007d, blocks: (B:7:0x0040, B:11:0x0077, B:18:0x0083, B:21:0x0089, B:24:0x0091, B:103:0x01f7, B:104:0x0202, B:107:0x0205, B:108:0x0206, B:109:0x020e, B:126:0x0265, B:127:0x027c, B:110:0x020f, B:112:0x022d, B:114:0x023c, B:124:0x025c, B:125:0x0264, B:128:0x027d, B:129:0x02ad), top: B:149:0x0040, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.dynamite.DynamiteModule d(android.content.Context r21, com.google.android.gms.dynamite.DynamiteModule.a r22, java.lang.String r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.d(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$a, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0098 A[Catch: all -> 0x0036, TryCatch #5 {, blocks: (B:9:0x0026, B:11:0x0032, B:49:0x00a1, B:16:0x003b, B:18:0x0041, B:20:0x0047, B:25:0x004e, B:27:0x0052, B:31:0x005c, B:33:0x0064, B:36:0x006b, B:40:0x0080, B:41:0x0088, B:39:0x0072, B:44:0x008b, B:47:0x008e, B:48:0x0098, B:17:0x003e), top: B:132:0x0026, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0161 A[Catch: all -> 0x00d0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:3:0x0002, B:57:0x00c5, B:59:0x00cb, B:67:0x00f1, B:95:0x0153, B:99:0x0161, B:117:0x01b6, B:118:0x01b9, B:112:0x01ad, B:65:0x00d6, B:120:0x01bb, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:55:0x00c2, B:21:0x0048, B:42:0x0089, B:45:0x008c, B:52:0x00a4, B:56:0x00c4, B:54:0x00a6), top: B:124:0x0002, inners: #7, #8 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x01ab -> B:125:0x01b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x01ad -> B:125:0x01b0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(android.content.Context r9, java.lang.String r10, boolean r11, boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static DynamiteModule g(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    public static void h(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        v2.f fVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder);
            }
            f19903r = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new LoadingException("Failed to instantiate dynamite loader", e10, fVar);
        }
    }

    public static boolean i(Cursor cursor) {
        v2.e eVar = (v2.e) f19898m.get();
        if (eVar == null || eVar.f42696a != null) {
            return false;
        }
        eVar.f42696a = cursor;
        return true;
    }

    public static boolean j(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f19897l)) {
            return true;
        }
        boolean z10 = false;
        if (f19897l == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (com.google.android.gms.common.c.f().h(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z10 = true;
            }
            f19897l = Boolean.valueOf(z10);
            if (z10 && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f19895j = true;
            }
        }
        if (!z10) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z10;
    }

    public static zzq k(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = f19902q;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    f19902q = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
            return null;
        }
    }

    public IBinder c(String str) throws LoadingException {
        try {
            return (IBinder) this.f19904a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e10, null);
        }
    }
}
