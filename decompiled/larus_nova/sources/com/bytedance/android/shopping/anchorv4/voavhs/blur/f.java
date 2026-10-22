package com.bytedance.android.shopping.anchorv4.voavhs.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f168042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f168043g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f168044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f168045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f168046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f168047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f168048e;

    public static final class a {
        public a() {
        }

        public static e b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (f.f168042f != 0) goto L8;
            com.bytedance.android.shopping.anchorv4.voavhs.blur.a r101 = new com.bytedance.android.shopping.anchorv4.voavhs.blur.a();     // Catch: Throwable -> L6
            Bitmap r102 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L6
            r101.a(r100, r102, 4.0f);     // Catch: Throwable -> L6
            r101.release();     // Catch: Throwable -> L6
            r102.recycle();     // Catch: Throwable -> L6
            f.f168042f = 3;     // Catch: Throwable -> L6
        L8:
            if (f.f168042f != 0) goto L13;
            ClassLoader r103 = a.class.getClassLoader();     // Catch: Throwable -> L11
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L11
            a(r103, "androidx.renderscript.RenderScript");     // Catch: Throwable -> L11
            b r104 = new b();     // Catch: Throwable -> L11
            Bitmap r105 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L11
            r104.a(r100, r105, 4.0f);     // Catch: Throwable -> L11
            r104.release();     // Catch: Throwable -> L11
            r105.recycle();     // Catch: Throwable -> L11
            f.f168042f = 1;     // Catch: Throwable -> L11
        L13:
            if (f.f168042f != 0) goto L18;
            ClassLoader r106 = a.class.getClassLoader();     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L16
            a(r106, "android.support.v8.renderscript.RenderScript");     // Catch: Throwable -> L16
            h r107 = new h();     // Catch: Throwable -> L16
            Bitmap r108 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L16
            r107.a(r100, r108, 4.0f);     // Catch: Throwable -> L16
            r107.release();     // Catch: Throwable -> L16
            r108.recycle();     // Catch: Throwable -> L16
            f.f168042f = 2;     // Catch: Throwable -> L16
        L18:
            if (f.f168042f != 0) goto L20;
            f.f168042f = -1;
        L20:
            int r109 = f.f168042f;
            if (r109 == 1) goto L28;
            if (r109 == 2) goto L37;
            if (r109 == 3) goto L36;
            return new g();
        L36:
            return new com.bytedance.android.shopping.anchorv4.voavhs.blur.a();
        L37:
            return new h();
        L28:
            return new b();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static void a(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
            return;
        L36:
            return;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
            return;
        L37:
            return;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == false) goto L26;
        L29:
            MiraPluginFix.loadClass(r101);
            return;
        L26:
            if ((th instanceof NoClassDefFoundError) == true) goto L29;
            throw th;
        }
    }

    static {
        f168043g = new a();
    }

    public final Context getContext() {
        return this.f168046c;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f168046c = r100;
        this.f168047d = 12.5f;
        this.f168048e = 8.0f;
        this.f168045b = LazyKt.lazy(new BlurManager$blurImpl$2(this));
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L6;
        Bitmap r101 = this.f168044a;
        if (r101 == null) goto L6;
        r101.recycle();
        this.f168044a = null;
    L6:
        ((e) this.f168045b.getValue()).release();
    }

    public static /* synthetic */ Bitmap b(f r100, Bitmap r101, int r102, int r110, Integer r111, int r112) {
        if ((r112 & 16) == 0) goto L6;
        r111 = null;
    L6:
        return r100.a(r101, r102, r110, 1.0f, r111, null);
    }

    public final Bitmap a(Bitmap r100, int r101, int r102, float r103, Integer r104, d r105) {
        Intrinsics.checkNotNullParameter(r100, "bitmapToBlur");
        Bitmap r106 = c(r100, r101, r102, r103, r104, r105);     // Catch: Exception -> L5
        ((e) this.f168045b.getValue()).b(r106, r106);     // Catch: Exception -> L5
        d(false);     // Catch: Exception -> L5
        this.f168044a = r106;     // Catch: Exception -> L5
        return r106;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        d(true);
        return null;
    }

    public final Bitmap c(Bitmap r110, int r111, int r112, float r113, Integer r114, d r210) {
        Float r100 = Float.valueOf(this.f168048e);
        float r101 = 0;
        if (r100.floatValue() <= r101) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        float r103 = r100.floatValue();
    L13:
        float r104 = this.f168047d;
        if (r104 <= 25) goto L16;
        r104 = 25.0f;
    L16:
        int r105 = r111;
        if (r103 == 0.0f) goto L19;
        r105 = RangesKt.coerceAtLeast(1, (int) (r105 / r103));
    L19:
        if (r103 == 0.0f) goto L21;
        int r106 = RangesKt.coerceAtLeast(1, (int) (r112 / r103));
    L22:
        Bitmap r107 = Bitmap.createBitmap(r105, r106, Bitmap.Config.ARGB_8888);
        Canvas r115 = new Canvas(r107);
        Rect r116 = new Rect(0, 0, r110.getWidth(), r110.getHeight());
        float r108 = 1;
        if (r113 < r108) goto L25;
    L27:
        if (r210 == null) goto L29;
        r116.left += r210.f168038a;
        r116.top += r210.f168039b;
        r116.right -= r210.f168040c;
        r116.bottom -= r210.f168041d;
    L29:
        Unit r109 = Unit.INSTANCE;
        r115.drawBitmap(r110, r116, new Rect(0, 0, r105, r106), null);
        if (r114 == null) goto L32;
        r115.drawColor(r114.intValue());
    L32:
        ((e) this.f168045b.getValue()).a(this.f168046c, r107, r104);
        return r107;
    L25:
        if (r113 <= r101) goto L27;
        float r117 = r108 - r113;
        float r118 = 2;
        r116.inset((int) ((r110.getWidth() * r117) / r118), (int) ((r110.getHeight() * r117) / r118));
        goto L29
    L21:
        r106 = r112;
        goto L22
    L12:
        r103 = 4.0f;
        goto L13
    L5:
        r102 = false;
        goto L7
    }
}
