package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TypefaceCompatApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
class k extends p {
    private static final String TAG = "TypefaceCompatApi21Impl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f1222a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Constructor<?> f1223b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f1224c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f1225d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f1226e = false;

    static {
    }

    k() {
    }

    private static void a() {
        if (f1226e == false) goto L5;
        return;
    L5:
        f1226e = true;
        Constructor<?> r1 = null;
        Class<?> r2 = ZeusTransformUtils.forName("android.graphics.FontFamily", "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        Constructor<?> r4 = r2.getConstructor(new Class[0]);     // Catch: Throwable -> L8
        Method r5 = r2.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L8
        Method r0 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(r2, 1).getClass()});     // Catch: Throwable -> L8
        r1 = r4;
    L10:
        f1223b = r1;
        f1222a = r2;
        f1224c = r5;
        f1225d = r0;
        return;
    L8:
        e = move-exception;
        a(TAG, e.getClass().getName(), e);
        r0 = null;
        r2 = null;
        r5 = null;
        goto L10
    }

    private File a(ParcelFileDescriptor r3) {
        String r4 = Os.readlink("/proc/self/fd/" + r3.getFd());     // Catch: ErrnoException -> L8
        if (OsConstants.S_ISREG(Os.stat(r4).st_mode) == false) goto L7;
        return new File(r4);
    L7:
        return null;
    }

    private static Object b() {
        a();
        return f1223b.newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static Typeface a(Object r4) {
        a();
        Object r0 = Array.newInstance(f1222a, 1);     // Catch: Throwable -> L5
        Array.set(r0, 0, r4);     // Catch: Throwable -> L5
        return (Typeface) ZeusTransformUtils.preCheckCast(f1225d.invoke(null, new Object[]{r0}), Typeface.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static boolean a(Object r3, String r4, int r5, boolean r6) {
        a();
        return ((Boolean) ZeusTransformUtils.preCheckCast(f1224c.invoke(r3, new Object[]{r4, Integer.valueOf(r5), Boolean.valueOf(r6)}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // androidx.core.graphics.p
    public Typeface a(Context r4, CancellationSignal r5, FontsContractCompat.b[] r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r6.length >= 1) goto L5;
        return null;
    L5:
        FontsContractCompat.b r9 = a(r6, r7);
        ContentResolver r10 = r8.getContentResolver();
        ParcelFileDescriptor r11 = r10.openFileDescriptor(r9.a(), DownloadFileUtils.MODE_READ, r5);     // Catch: IOException -> L39
        if (r11 != null) goto L40;
        if (r11 == null) goto L10;
        r11.close();     // Catch: IOException -> L39
    L10:
        return null;
    L40:
        File r12 = a(r11);     // Catch: Throwable -> L32
        if (r12 != null) goto L14;
    L20:
        FileInputStream r13 = new FileInputStream(r11.getFileDescriptor());     // Catch: Throwable -> L32
        Typeface r3 = super.a(r8, r13);     // Catch: Throwable -> L26
        r13.close();     // Catch: Throwable -> L32
        if (r11 == null) goto L25;
        r11.close();     // Catch: IOException -> L39
    L25:
        return r3;
    L26:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Throwable -> L32
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
        goto L31
    L14:
        if (r12.canRead() == false) goto L20;
        Typeface r14 = Typeface.createFromFile(r12);     // Catch: Throwable -> L32
        if (r11 == null) goto L19;
        r11.close();     // Catch: IOException -> L39
    L19:
        return r14;
    L32:
        th = move-exception;
        if (r11 != null) goto L43;
    L38:
        throw th;     // Catch: IOException -> L39
    L43:
        r11.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L39
    L39:
        return null;
    }

    @Override // androidx.core.graphics.p
    public Typeface a(Context r7, androidx.core.content.b.e.c r8, Resources r9, int r10) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Object r11 = b();
        androidx.core.content.b.e.d[] r12 = r8.a();
        int r13 = r12.length;
        int r0 = 0;
    L3:
        if (r0 >= r13) goto L22;
        androidx.core.content.b.e.d r1 = r12[r0];
        File r2 = q.a(r6);
        if (r2 == null) goto L6;
    L19:
        r2.delete();
        return null;
    L16:
        th = move-exception;
        r2.delete();
        throw th;
    L8:
        if (q.a(r2, r9, r1.f()) == false) goto L9;
        if (a(r11, r2.getPath(), r1.b(), r1.c()) == false) goto L13;
        r2.delete();
        r0 = r0 + 1;
        goto L3
    L13:
        r2.delete();
        return null;
    L9:
        r2.delete();
        return null;
    L6:
        return null;
    L22:
        return a(r11);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
