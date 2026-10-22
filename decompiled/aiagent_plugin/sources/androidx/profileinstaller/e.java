package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ProfileInstaller.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String TAG = "ProfileInstaller";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f2255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f2256b = null;

    /* JADX INFO: compiled from: ProfileInstaller.java */
    public interface a {
        void a(int r1, Object r2);

        void b(int r1, Object r2);
    }

    public static /* synthetic */ void lambda$3own_gKtNlh8nhBcVqAr9ZdUNso(a r0, int r1, Object r2) {
        a(r0, r1, r2);
    }

    private static /* synthetic */ void a(a r2, int r3, Object r4) {
        ((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin")).b(r3, r4);
    }

    static void a(Executor r2, a r3, final int r4, final Object r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.aiagent.plugin");
        final a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        r6.execute(new $$Lambda$e$3own_gKtNlh8nhBcVqAr9ZdUNso(r7, r4, r5));
    }

    static {
        f2256b = new AnonymousClass1();
        f2255a = new AnonymousClass2();
    }

    static boolean a(PackageInfo r4, File r5, a r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        File r0 = new File(r5, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        boolean r1 = false;
        if (r0.exists() == true) goto L21;
        return false;
    L21:
        DataInputStream r8 = new DataInputStream(new FileInputStream(r0));     // Catch: IOException -> L20
        long r2 = r8.readLong();     // Catch: Throwable -> L14
        r8.close();     // Catch: IOException -> L20
        if (r2 != r4.lastUpdateTime) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L13;
        r7.b(2, null);
    L13:
        return r1;
    L14:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        return false;
    }

    static void a(PackageInfo r2, File r3) {
        DataOutputStream r4 = new DataOutputStream(new FileOutputStream(new File(r3, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));     // Catch: IOException -> L14
        r4.writeLong(r2.lastUpdateTime);     // Catch: Throwable -> L7
        r4.close();     // Catch: IOException -> L14
        return;
    L7:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L14
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    }

    private static boolean a(AssetManager r10, String r11, PackageInfo r12, File r13, String r14, Executor r15, a r16) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r15, Executor.class, "com.obric.aiagent.plugin");
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r16, a.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L6;
        a(r4, r5, 3, null);
        return false;
    L6:
        androidx.profileinstaller.a r0 = new androidx.profileinstaller.a(r10, r4, r5, r14, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", r11), "primary.prof"));
        if (r0.a() == true) goto L9;
        return false;
    L9:
        boolean r1 = r0.b().c().d();
        if (r1 == false) goto L12;
        a(r12, r13);
    L12:
        return r1;
    }

    public static void a(Context r2) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE, f2256b);
    }

    public static void a(Context r2, Executor r3, a r4) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), false);
    }

    static void a(Context r9, Executor r10, a r11, boolean r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.aiagent.plugin");
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r11, a.class, "com.obric.aiagent.plugin");
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r3 = r14.getPackageName();
        ApplicationInfo r15 = r14.getApplicationInfo();
        AssetManager r2 = r14.getAssets();
        String r6 = new File(r15.sourceDir).getName();
        boolean r16 = false;
        PackageInfo r4 = r13.getPackageManager().getPackageInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        File r5 = r13.getFilesDir();
        if (r12 == false) goto L7;
    L10:
        a(TAG, "Installing profile for " + r13.getPackageName());
        if (a(r2, r3, r4, r5, r6, r7, r8) == false) goto L14;
        if (r12 == false) goto L14;
        r16 = true;
    L14:
        g.a(r13, r16);
        return;
    L7:
        if (a(r4, r5, r8) == false) goto L10;
        a(TAG, "Skipping profile installation for " + r13.getPackageName());
        g.a(r13, false);
        return;
    L16:
        e = move-exception;
        r8.b(7, e);
        g.a(r13, false);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
