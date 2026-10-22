package a97;

import android.app.Application;
import android.os.Looper;
import com.bytedance.reparo.core.ClassModifier;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.exception.JavaLoadException;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.i;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b<d97.c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f2290c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d97.c f2291b;

    public interface a {
    }

    public e(i r100) {
        super(r100);
    }

    public static void a(d97.c r100, WandTrick.a r101, f r102) throws Exception {
        c r103 = new c(r101, r100, r102);
        d r104 = new d(r103, r102, r100);
        if (r103.c() == false) goto L6;
        return;
    L6:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L8;
        e97.c.a().execute(r104);
        return;
    L8:
        r104.run();
    }

    public final void b(d97.c r110, f r111, d97.b r112) throws JavaLoadException {
        WandTrick r100 = WandTrick.e();     // Catch: Throwable -> L5 PatchException -> L8 ClassModifier.ClassVerifingException -> L10
        i r101 = this.f2283a;     // Catch: Throwable -> L5 PatchException -> L8 ClassModifier.ClassVerifingException -> L10
        Application r102 = r101.f267371a;     // Catch: Throwable -> L5 PatchException -> L8 ClassModifier.ClassVerifingException -> L10
        boolean r103 = r101.f267377g;     // Catch: Throwable -> L5 PatchException -> L8 ClassModifier.ClassVerifingException -> L10
        c97.d r104 = r110.f467630c;     // Catch: Throwable -> L5 PatchException -> L8 ClassModifier.ClassVerifingException -> L10
        WandTrick.a r105 = r100.b(r102, r103, r104.f22863a, r104.f22864b, r104.f22865c, r104.f22866d, r112, r110.f467631d);     // Catch: Throwable -> L5 PatchException -> L8 ClassModifier.ClassVerifingException -> L10
    L26:
        a(r110, r105, r111);     // Catch: Throwable -> L15 PatchException -> L18
        this.f2291b = r110;
        return;
    L18:
        e = move-exception;
        throw e;
    L15:
        th = move-exception;
        throw new JavaLoadException(String.format("load java patch %s failed.", new Object[]{r110.f467629b.getAbsolutePath()}), th, 103);
    L10:
        WandTrick r106 = WandTrick.e();     // Catch: Throwable -> L21 PatchException -> L24
        i r107 = this.f2283a;     // Catch: Throwable -> L21 PatchException -> L24
        Application r108 = r107.f267371a;     // Catch: Throwable -> L21 PatchException -> L24
        boolean r109 = r107.f267377g;     // Catch: Throwable -> L21 PatchException -> L24
        c97.d r113 = r110.f467630c;     // Catch: Throwable -> L21 PatchException -> L24
        r105 = r106.b(r108, r109, r113.f22863a, r113.f22864b, r113.f22865c, r113.f22866d, r112, r110.f467631d);     // Catch: Throwable -> L21 PatchException -> L24
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        throw new JavaLoadException(String.format("load java patch %s failed.", new Object[]{r110.f467629b.getAbsolutePath()}), th, 103);
    L24:
        e = move-exception;
        throw e;
    L21:
        th = move-exception;
        throw new JavaLoadException(String.format("load java patch %s failed2.", new Object[]{r110.f467629b.getAbsolutePath()}), th, 103);
    }
}
