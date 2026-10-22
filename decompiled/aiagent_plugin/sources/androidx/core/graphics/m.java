package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TypefaceCompatApi26Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends k {
    private static final String TAG = "TypefaceCompatApi26Impl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<?> f1231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Constructor<?> f1232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Method f1233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Method f1234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final Method f1235e;
    protected final Method f;
    protected final Method g;

    public m() {
        Class<?> r0 = null;
        Class<?> r1 = a();     // Catch: Throwable -> L5
        Constructor<?> r2 = a(r1);     // Catch: Throwable -> L5
        Method r3 = b(r1);     // Catch: Throwable -> L5
        Method r4 = c(r1);     // Catch: Throwable -> L5
        Method r5 = d(r1);     // Catch: Throwable -> L5
        Method r6 = e(r1);     // Catch: Throwable -> L5
        Method r7 = f(r1);     // Catch: Throwable -> L5
        r0 = r1;
    L7:
        this.f1231a = r0;
        this.f1232b = r2;
        this.f1233c = r3;
        this.f1234d = r4;
        this.f1235e = r5;
        this.f = r6;
        this.g = r7;
        return;
    L5:
        e = move-exception;
        b(TAG, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
        r7 = null;
        r2 = null;
        r3 = null;
        r4 = null;
        r5 = null;
        r6 = null;
        goto L7
    }

    private boolean b() {
        if (this.f1233c != null) goto L6;
        a(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
    L6:
        if (this.f1233c == null) goto L8;
        return true;
    L8:
        return false;
    }

    private Object c() {
        return this.f1232b.newInstance(new Object[0]);
    L4:
        return null;
    }

    private boolean a(Context r4, Object r5, String r6, int r7, int r8, int r9, FontVariationAxis[] r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f1233c.invoke(r5, new Object[]{r11.getAssets(), r6, 0, false, Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), r10}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        return false;
    }

    private boolean a(Object r3, ByteBuffer r4, int r5, int r6, int r7) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f1234d.invoke(r3, new Object[]{r4, Integer.valueOf(r5), null, Integer.valueOf(r6), Integer.valueOf(r7)}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        return false;
    }

    public Typeface a(Object r5) {
        Object r1 = Array.newInstance(this.f1231a, 1);     // Catch: Throwable -> L5
        Array.set(r1, 0, r5);     // Catch: Throwable -> L5
        return (Typeface) ZeusTransformUtils.preCheckCast(this.g.invoke(null, new Object[]{r1, -1, -1}), Typeface.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    private boolean b(Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f1235e.invoke(r3, new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        return false;
    }

    private void c(Object r2) {
        this.f.invoke(r2, new Object[0]);     // Catch: Throwable -> L4
        return;
    }

    @Override // androidx.core.graphics.k, androidx.core.graphics.p
    public Typeface a(Context r11, androidx.core.content.b.e.c r12, Resources r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        if (b() == false) goto L5;
        Object r16 = c();
        if (r16 != null) goto L9;
        return null;
    L9:
        androidx.core.content.b.e.d[] r17 = r12.a();
        int r8 = r17.length;
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L17;
        androidx.core.content.b.e.d r0 = r17[r9];
        String r3 = r0.a();
        int r4 = r0.e();
        int r5 = r0.b();
        boolean r6 = r0.c();
        if (a(r15, r16, r3, r4, r5, r6 ? 1 : 0, FontVariationAxis.fromFontVariationSettings(r0.d())) == false) goto L13;
        r9 = r9 + 1;
        goto L10
    L13:
        c(r16);
        return null;
    L17:
        if (b(r16) == true) goto L20;
        return null;
    L20:
        return a(r16);
    L5:
        return super.a(r15, r12, r13, r14);
    }

    @Override // androidx.core.graphics.k, androidx.core.graphics.p
    public Typeface a(Context r12, CancellationSignal r13, FontsContractCompat.b[] r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        if (r14.length >= 1) goto L6;
        return null;
    L6:
        if (b() == true) goto L25;
        FontsContractCompat.b r11 = a(r14, r15);
        ParcelFileDescriptor r17 = r16.getContentResolver().openFileDescriptor(r11.a(), DownloadFileUtils.MODE_READ, r13);     // Catch: IOException -> L24
        if (r17 != null) goto L50;
        if (r17 == null) goto L12;
        r17.close();     // Catch: IOException -> L24
    L12:
        return null;
    L50:
        Typeface r18 = new Typeface.Builder(r17.getFileDescriptor()).setWeight(r11.c()).setItalic(r11.d()).build();     // Catch: Throwable -> L17
        if (r17 == null) goto L16;
        r17.close();     // Catch: IOException -> L24
    L16:
        return r18;
    L17:
        th = move-exception;
        if (r17 != null) goto L52;
    L23:
        throw th;     // Catch: IOException -> L24
    L52:
        r17.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24
    L24:
        return null;
    L25:
        Map<Uri, ByteBuffer> r19 = q.a(r16, r14, r13);
        Object r110 = c();
        if (r110 != null) goto L28;
        return null;
    L28:
        int r0 = r14.length;
        boolean r4 = false;
        int r10 = 0;
    L29:
        if (r10 >= r0) goto L39;
        FontsContractCompat.b r5 = r14[r10];
        ByteBuffer r6 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r19.get(r5.a()), ByteBuffer.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L38;
        if (a(r110, r6, r5.b(), r5.c(), r5.d() ? 1 : 0) == false) goto L35;
        r4 = true;
        goto L38
    L35:
        c(r110);
        return null;
    L38:
        r10 = r10 + 1;
        goto L29
    L39:
        if (r4 == true) goto L43;
        c(r110);
        return null;
    L43:
        if (b(r110) == true) goto L45;
        return null;
    L45:
        Typeface r111 = a(r110);
        if (r111 != null) goto L49;
        return null;
    L49:
        return Typeface.create(r111, r15);
    }

    @Override // androidx.core.graphics.p
    public Typeface a(Context r9, Resources r10, int r11, String r12, int r13) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        if (b() == false) goto L5;
        Object r14 = c();
        if (r14 != null) goto L10;
        return null;
    L10:
        if (a(r1, r14, r12, 0, -1, -1, null) == true) goto L14;
        c(r14);
        return null;
    L14:
        if (b(r14) == true) goto L17;
        return null;
    L17:
        return a(r14);
    L5:
        return super.a(r1, r10, r11, r12, r13);
    }

    public Class<?> a() {
        return ZeusTransformUtils.forName("android.graphics.FontFamily", "com.obric.aiagent.plugin");
    }

    public Constructor<?> a(Class<?> r1) {
        return r1.getConstructor(new Class[0]);
    }

    public Method b(Class<?> r3) {
        return r3.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    public Method c(Class<?> r3) {
        return r3.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    public Method d(Class<?> r2) {
        return r2.getMethod("freeze", new Class[0]);
    }

    public Method e(Class<?> r2) {
        return r2.getMethod("abortCreation", new Class[0]);
    }

    public Method f(Class<?> r4) {
        Method r5 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(r4, 1).getClass(), Integer.TYPE, Integer.TYPE});
        r5.setAccessible(true);
        return r5;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
