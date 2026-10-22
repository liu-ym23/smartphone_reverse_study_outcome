package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import com.android.common.speech.LoggingEvents;
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
class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final String APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME = "androidx.appcompat.app.AppLocalesMetadataHolderService";
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";

    static class SerialExecutor implements Executor {
        Runnable mActive;
        final Executor mExecutor;
        private final Object mLock;
        final Queue<Runnable> mTasks;

        SerialExecutor(Executor r2) {
            this.mLock = new Object();
            this.mTasks = new ArrayDeque();
            this.mExecutor = r2;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable r4) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mTasks.add(new AppLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0(this, r4));     // Catch: Throwable -> L9
            if (this.mActive != null) goto L7;
            scheduleNext();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        /* JADX INFO: renamed from: lambda$execute$0$androidx-appcompat-app-AppLocalesStorageHelper$SerialExecutor, reason: not valid java name */
        /* synthetic */ void m7xd188c474(Runnable r1) {
            r1.run();     // Catch: Throwable -> L5
            scheduleNext();
            return;
        L5:
            th = move-exception;
            scheduleNext();
            throw th;
        }

        protected void scheduleNext() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Runnable r1 = this.mTasks.poll();     // Catch: Throwable -> L9
            this.mActive = r1;     // Catch: Throwable -> L9
            if (r1 == null) goto L7;
            this.mExecutor.execute(r1);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    static class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r1) {
            new Thread(r1).start();
        }
    }

    private AppLocalesStorageHelper() {
    }

    static String readLocales(Context r9) {
        String r2 = "";
        FileInputStream r3 = r9.openFileInput(APPLICATION_LOCALES_RECORD_FILE);     // Catch: FileNotFoundException -> L34
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
        if (r4.getName().equals(LOCALE_RECORD_FILE_TAG) == false) goto L5;
        r2 = r4.getAttributeValue(null, LOCALE_RECORD_ATTRIBUTE_TAG);     // Catch: Throwable -> L21 Throwable -> L23
    L10:
        if (r4.getDepth() > r5) goto L11;
    L18:
        if (r3 == null) goto L27;
    L44:
        r3.close();     // Catch: IOException -> L36
    L27:
        if (r2.isEmpty() == true) goto L29;
        Log.d(TAG, "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: " + r2);
    L30:
        return r2;
    L29:
        r9.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
    L21:
        th = move-exception;
        if (r3 != null) goto L42;
    L33:
        throw th;
    L42:
        r3.close();     // Catch: IOException -> L37
    L23:
        Log.w(TAG, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");     // Catch: Throwable -> L21
        if (r3 == null) goto L27;
    L34:
        Log.w(TAG, "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        return "";
    }

    static void persistLocales(Context r8, String r9) {
        if (r9.equals("") == false) goto L27;
        r8.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
        return;
    L27:
        FileOutputStream r10 = r8.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);     // Catch: FileNotFoundException -> L23
        XmlSerializer r5 = Xml.newSerializer();
        r5.setOutput(r10, null);     // Catch: Throwable -> L13 Exception -> L15
        r5.startDocument("UTF-8", true);     // Catch: Throwable -> L13 Exception -> L15
        r5.startTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L13 Exception -> L15
        r5.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, r9);     // Catch: Throwable -> L13 Exception -> L15
        r5.endTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L13 Exception -> L15
        r5.endDocument();     // Catch: Throwable -> L13 Exception -> L15
        Log.d(TAG, "Storing App Locales : app-locales: " + r9 + " persisted successfully.");     // Catch: Throwable -> L13 Exception -> L15
        if (r10 != null) goto L34;
        return;
    L34:
        r10.close();     // Catch: IOException -> L25
        return;
    L38:
        return;
    L15:
        e = move-exception;
        Log.w(TAG, "Storing App Locales : Failed to persist app-locales: " + r9, e);     // Catch: Throwable -> L13
        if (r10 != null) goto L34;
        return;
    L13:
        th = move-exception;
        if (r10 != null) goto L29;
    L22:
        throw th;
    L29:
        r10.close();     // Catch: IOException -> L26
    L23:
        Log.w(TAG, String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{APPLICATION_LOCALES_RECORD_FILE}));
    }

    static void syncLocalesToFramework(Context r4) {
        if (Build.VERSION.SDK_INT < 33) goto L13;
        ComponentName r0 = new ComponentName(r4, APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME);
        if (r4.getPackageManager().getComponentEnabledSetting(r0) != 1) goto L7;
        return;
    L7:
        if (AppCompatDelegate.getApplicationLocales().isEmpty() == false) goto L11;
        String r1 = readLocales(r4);
        Object r3 = r4.getSystemService(LoggingEvents.VoiceIme.EXTRA_START_LOCALE);
        if (r3 == null) goto L11;
        AppCompatDelegate.Api33Impl.localeManagerSetApplicationLocales(r3, AppCompatDelegate.Api24Impl.localeListForLanguageTags(r1));
    L11:
        r4.getPackageManager().setComponentEnabledSetting(r0, 1, 1);
        return;
    }
}
