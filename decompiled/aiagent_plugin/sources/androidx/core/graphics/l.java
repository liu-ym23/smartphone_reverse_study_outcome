package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TypefaceCompatApi24Impl.java */
/* JADX INFO: loaded from: classes.dex */
class l extends p {
    private static final String TAG = "TypefaceCompatApi24Impl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f1227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Constructor<?> f1228b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f1229c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f1230d = null;

    l() {
    }

    static {
        Constructor<?> r0 = null;
        Class<?> r1 = ZeusTransformUtils.forName("android.graphics.FontFamily", "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Constructor<?> r3 = r1.getConstructor(new Class[0]);     // Catch: Throwable -> L5
        Method r4 = r1.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L5
        Method r2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(r1, 1).getClass()});     // Catch: Throwable -> L5
        r0 = r3;
    L7:
        f1228b = r0;
        f1227a = r1;
        f1229c = r4;
        f1230d = r2;
        return;
    L5:
        e = move-exception;
        a(TAG, e.getClass().getName(), e);
        r1 = null;
        r2 = null;
        r4 = null;
        goto L7
    }

    public static boolean a() {
        Method r0 = f1229c;
        if (r0 != null) goto L5;
        a(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
    L5:
        if (r0 == null) goto L7;
        return true;
    L7:
        return false;
    }

    private static Object b() {
        return f1228b.newInstance(new Object[0]);
    L4:
        return null;
    }

    private static boolean a(Object r3, ByteBuffer r4, int r5, int r6, boolean r7) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f1229c.invoke(r3, new Object[]{r4, Integer.valueOf(r5), null, Integer.valueOf(r6), Boolean.valueOf(r7)}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        return false;
    }

    private static Typeface a(Object r4) {
        Object r1 = Array.newInstance(f1227a, 1);     // Catch: Throwable -> L5
        Array.set(r1, 0, r4);     // Catch: Throwable -> L5
        return (Typeface) ZeusTransformUtils.preCheckCast(f1230d.invoke(null, new Object[]{r1}), Typeface.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    @Override // androidx.core.graphics.p
    public Typeface a(Context r10, CancellationSignal r11, FontsContractCompat.b[] r12, int r13) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        Object r14 = b();
        if (r14 != null) goto L5;
        return null;
    L5:
        androidx.b.g r2 = new androidx.b.g();
        int r3 = r12.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L16;
        FontsContractCompat.b r5 = r12[r4];
        Uri r6 = r5.a();
        ByteBuffer r7 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r2.get(r6), ByteBuffer.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L10;
        r7 = q.a(r9, r11, r6);
        r2.put(r6, r7);
    L10:
        if (r7 == null) goto L11;
        if (a(r14, r7, r5.b(), r5.c(), r5.d()) == false) goto L14;
        r4 = r4 + 1;
        goto L6
    L14:
        return null;
    L11:
        return null;
    L16:
        Typeface r15 = a(r14);
        if (r15 != null) goto L20;
        return null;
    L20:
        return Typeface.create(r15, r13);
    }

    @Override // androidx.core.graphics.p
    public Typeface a(Context r7, androidx.core.content.b.e.c r8, Resources r9, int r10) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Object r11 = b();
        if (r11 != null) goto L5;
        return null;
    L5:
        androidx.core.content.b.e.d[] r12 = r8.a();
        int r0 = r12.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L15;
        androidx.core.content.b.e.d r2 = r12[r1];
        ByteBuffer r3 = q.a(r6, r9, r2.f());
        if (r3 == null) goto L9;
        if (a(r11, r3, r2.e(), r2.b(), r2.c()) == false) goto L12;
        r1 = r1 + 1;
        goto L6
    L12:
        return null;
    L9:
        return null;
    L15:
        return a(r11);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
