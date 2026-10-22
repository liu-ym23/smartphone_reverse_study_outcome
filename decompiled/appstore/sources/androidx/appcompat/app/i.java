package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    public static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue f382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Executor f383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f384d;

        public a(Executor r10) {
            this.f381a = new Object();
            this.f382b = new ArrayDeque();
            this.f383c = r10;
        }

        public static /* synthetic */ void a(a r10, Runnable r11) {
            r10.b(r11);
        }

        public final /* synthetic */ void b(Runnable r10) {
            r10.run();     // Catch: Throwable -> L5
            c();
            return;
        L5:
            th = move-exception;
            c();
            throw th;
        }

        public void c() {
            Object r10 = this.f381a;
            monitor-enter(r10);
            Runnable r11 = (Runnable) this.f382b.poll();     // Catch: Throwable -> L7
            this.f384d = r11;     // Catch: Throwable -> L7
            if (r11 == null) goto L9;
            this.f383c.execute(r11);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable r10) {
            Object r11 = this.f381a;
            monitor-enter(r11);
            this.f382b.add(new h(this, r10));     // Catch: Throwable -> L7
            if (this.f384d != null) goto L9;
            c();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            new Thread(r10).start();
        }
    }

    public static void a(Context r10, String r11) {
        if (r11.equals("") == false) goto L30;
        r10.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return;
    L30:
        FileOutputStream r12 = r10.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);     // Catch: FileNotFoundException -> L23
        XmlSerializer r13 = Xml.newSerializer();
        r13.setOutput(r12, null);     // Catch: Throwable -> L13 Exception -> L15
        r13.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L13 Exception -> L15
        r13.startTag(null, "locales");     // Catch: Throwable -> L13 Exception -> L15
        r13.attribute(null, "application_locales", r11);     // Catch: Throwable -> L13 Exception -> L15
        r13.endTag(null, "locales");     // Catch: Throwable -> L13 Exception -> L15
        r13.endDocument();     // Catch: Throwable -> L13 Exception -> L15
        Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + r11 + " persisted successfully.");     // Catch: Throwable -> L13 Exception -> L15
        if (r12 != null) goto L35;
    L27:
        return;
    L35:
        r12.close();     // Catch: IOException -> L25
    L37:
        return;
    L13:
        th = move-exception;
        if (r12 != null) goto L32;
    L22:
        throw th;
    L32:
        r12.close();     // Catch: IOException -> L26
    L15:
        e = move-exception;
        Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: " + r11, e);     // Catch: Throwable -> L13
        if (r12 == null) goto L27;
    L23:
        Log.w("AppLocalesStorageHelper", String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{"androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"}));
    }

    public static String b(Context r10) {
        String r11 = "";
        FileInputStream r12 = r10.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: FileNotFoundException -> L35
        XmlPullParser r13 = Xml.newPullParser();     // Catch: Throwable -> L12 Throwable -> L24
        r13.setInput(r12, "UTF-8");     // Catch: Throwable -> L12 Throwable -> L24
        int r14 = r13.getDepth();     // Catch: Throwable -> L12 Throwable -> L24
    L5:
        int r15 = r13.next();     // Catch: Throwable -> L12 Throwable -> L24
        if (r15 == 1) goto L21;
        if (r15 == 3) goto L10;
    L14:
        if (r15 == 3) goto L5;
        if (r15 == 4) goto L5;
        if (r13.getName().equals("locales") == false) goto L5;
        r11 = r13.getAttributeValue(null, "application_locales");     // Catch: Throwable -> L12 Throwable -> L24
    L10:
        if (r13.getDepth() > r14) goto L14;
    L21:
        if (r12 == null) goto L28;
    L43:
        r12.close();     // Catch: IOException -> L37
    L28:
        if (r11.isEmpty() == true) goto L30;
        Log.d("AppLocalesStorageHelper", "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: " + r11);
    L31:
        return r11;
    L30:
        r10.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
    L24:
        Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L12
        if (r12 == null) goto L28;
    L12:
        th = move-exception;
        if (r12 != null) goto L39;
    L34:
        throw th;
    L39:
        r12.close();     // Catch: IOException -> L38
    L35:
        Log.w("AppLocalesStorageHelper", "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return "";
    }

    public static void c(Context r10) {
        if (Build.VERSION.SDK_INT < 33) goto L13;
        ComponentName r11 = new ComponentName(r10, "androidx.appcompat.app.AppLocalesMetadataHolderService");
        if (r10.getPackageManager().getComponentEnabledSetting(r11) != 1) goto L7;
        return;
    L7:
        if (AppCompatDelegate.i().e() == false) goto L11;
        String r12 = b(r10);
        Object r13 = r10.getSystemService("locale");
        if (r13 == null) goto L11;
        AppCompatDelegate.b.b(r13, AppCompatDelegate.a.a(r12));
    L11:
        r10.getPackageManager().setComponentEnabledSetting(r11, 1, 1);
        return;
    }
}
