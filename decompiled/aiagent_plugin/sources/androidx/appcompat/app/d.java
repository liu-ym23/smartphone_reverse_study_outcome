package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: AppLocalesStorageHelper.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: compiled from: AppLocalesStorageHelper.java */
    static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue<Runnable> f242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Runnable f244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f245d;

        public static /* synthetic */ void lambda$tOxaRmb6tC88OfRVB7nAk3BG1QU(a r0, Runnable r1) {
            r0.a(r1);
        }

        a(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            this.f245d = new Object();
            this.f242a = new ArrayDeque();
            this.f243b = r4;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            Object r0 = this.f245d;
            monitor-enter(r0);
            this.f242a.add(new $$Lambda$d$a$tOxaRmb6tC88OfRVB7nAk3BG1QU(this, r5));     // Catch: Throwable -> L9
            if (this.f244c != null) goto L7;
            a();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void a(Runnable r3) {
            ((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin")).run();     // Catch: Throwable -> L6
            a();
            return;
        L6:
            th = move-exception;
            a();
            throw th;
        }

        public void a() {
            Object r0 = this.f245d;
            monitor-enter(r0);
            Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(this.f242a.poll(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            this.f244c = r1;     // Catch: Throwable -> L9
            if (r1 == null) goto L7;
            this.f243b.execute(r1);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: AppLocalesStorageHelper.java */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r2) {
            new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin")).start();
        }
    }

    static String a(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        String r2 = "";
        FileInputStream r3 = r10.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: FileNotFoundException -> L34
        XmlPullParser r4 = Xml.newPullParser();     // Catch: Throwable -> L21 Throwable -> L23
        r4.setInput(r3, "UTF-8");     // Catch: Throwable -> L21 Throwable -> L23
        int r5 = r4.getDepth();     // Catch: Throwable -> L21 Throwable -> L23
    L5:
        int r6 = r4.next();     // Catch: Throwable -> L21 Throwable -> L23
        if (r6 == 1) goto L18;
        if (r6 == 3) goto L10;
    L11:
        if (r6 == 3) goto L5;
        if (r6 == 4) goto L5;
        if (r4.getName().equals("locales") == false) goto L5;
        r2 = r4.getAttributeValue(null, "application_locales");     // Catch: Throwable -> L21 Throwable -> L23
    L10:
        if (r4.getDepth() > r5) goto L11;
    L18:
        if (r3 == null) goto L27;
    L39:
        r3.close();     // Catch: IOException -> L36
    L27:
        if (r2.isEmpty() == true) goto L29;
        b("AppLocalesStorageHelper", "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: " + r2);
    L30:
        return r2;
    L29:
        r10.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
    L21:
        th = move-exception;
        if (r3 != null) goto L44;
    L33:
        throw th;
    L44:
        r3.close();     // Catch: IOException -> L37
    L23:
        a("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L21
        if (r3 == null) goto L27;
    L34:
        a("AppLocalesStorageHelper", "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return "";
    }

    static void a(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r7.equals("") == false) goto L34;
        r8.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return;
    L34:
        FileOutputStream r9 = r8.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);     // Catch: FileNotFoundException -> L23
        XmlSerializer r3 = Xml.newSerializer();
        r3.setOutput(r9, null);     // Catch: Throwable -> L13 Exception -> L15
        r3.startDocument("UTF-8", true);     // Catch: Throwable -> L13 Exception -> L15
        r3.startTag(null, "locales");     // Catch: Throwable -> L13 Exception -> L15
        r3.attribute(null, "application_locales", r7);     // Catch: Throwable -> L13 Exception -> L15
        r3.endTag(null, "locales");     // Catch: Throwable -> L13 Exception -> L15
        r3.endDocument();     // Catch: Throwable -> L13 Exception -> L15
        b("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + r7 + " persisted successfully.");     // Catch: Throwable -> L13 Exception -> L15
        if (r9 != null) goto L32;
    L27:
        return;
    L32:
        r9.close();     // Catch: IOException -> L25
    L37:
        return;
    L13:
        th = move-exception;
        if (r9 != null) goto L30;
    L22:
        throw th;
    L30:
        r9.close();     // Catch: IOException -> L26
    L15:
        e = move-exception;
        a("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: " + r7, e);     // Catch: Throwable -> L13
        if (r9 == null) goto L27;
    L23:
        a("AppLocalesStorageHelper", String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{"androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"}));
    }

    static void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 33) goto L13;
        ComponentName r0 = new ComponentName(r5, "androidx.appcompat.app.AppLocalesMetadataHolderService");
        if (r5.getPackageManager().getComponentEnabledSetting(r0) != 1) goto L7;
        return;
    L7:
        if (c.getApplicationLocales().b() == false) goto L11;
        String r1 = a(r5);
        Object r3 = r5.getSystemService("locale");
        if (r3 == null) goto L11;
        c.b.a(r3, c.a.a(r1));
    L11:
        ZeusTransformUtils.setComponentEnabledSetting(r5.getPackageManager(), r0, 1, 1);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
