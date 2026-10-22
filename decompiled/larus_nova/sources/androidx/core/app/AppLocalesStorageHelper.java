package androidx.core.app;

import android.content.Context;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes17.dex */
public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = null;

    private AppLocalesStorageHelper() {
    }

    static {
        sAppLocaleStorageSync = new Object();
    }

    public static String readLocales(Context r100) {
        Object r101 = sAppLocaleStorageSync;
        monitor-enter(r101);
        String r102 = "";
        FileInputStream r103 = r100.openFileInput(APPLICATION_LOCALES_RECORD_FILE);     // Catch: FileNotFoundException -> L35 Throwable -> L37
        goto L36
    L48:
        XmlPullParser r104 = Xml.newPullParser();     // Catch: Throwable -> L23 Throwable -> L27
        r104.setInput(r103, "UTF-8");     // Catch: Throwable -> L23 Throwable -> L27
        int r105 = r104.getDepth();     // Catch: Throwable -> L23 Throwable -> L27
    L7:
        int r106 = r104.next();     // Catch: Throwable -> L23 Throwable -> L27
        if (r106 == 1) goto L20;
        if (r106 == 3) goto L12;
    L13:
        if (r106 == 3) goto L7;
        if (r106 == 4) goto L7;
        if (r104.getName().equals(LOCALE_RECORD_FILE_TAG) == false) goto L7;
        r102 = r104.getAttributeValue(null, LOCALE_RECORD_ATTRIBUTE_TAG);     // Catch: Throwable -> L23 Throwable -> L27
    L12:
        if (r104.getDepth() > r105) goto L13;
    L20:
        if (r103 == null) goto L30;
    L44:
        r103.close();     // Catch: IOException -> L40 Throwable -> L37
    L30:
        if (r102.isEmpty() == false) goto L33;
        r100.deleteFile(APPLICATION_LOCALES_RECORD_FILE);     // Catch: Throwable -> L37
    L33:
        monitor-exit(r101);     // Catch: Throwable -> L37
        return r102;
    L27:
        if (r103 == null) goto L30;
    L23:
        th = move-exception;
        if (r103 != null) goto L46;
    L26:
        throw th;     // Catch: Throwable -> L37
    L46:
        r103.close();     // Catch: IOException -> L41 Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L36:
        return "";
    }

    public static void persistLocales(Context r100, String r101) {
        Object r102 = sAppLocaleStorageSync;
        monitor-enter(r102);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (r101.equals("") == false) goto L38;
        r100.deleteFile(APPLICATION_LOCALES_RECORD_FILE);     // Catch: Throwable -> L28
        monitor-exit(r102);     // Catch: Throwable -> L28
        return;
    L38:
        FileOutputStream r103 = r100.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);     // Catch: FileNotFoundException -> L25 Throwable -> L28
        XmlSerializer r104 = Xml.newSerializer();     // Catch: Throwable -> L28
        r104.setOutput(r103, null);     // Catch: Throwable -> L17 Exception -> L21
        r104.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L17 Exception -> L21
        r104.startTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L17 Exception -> L21
        r104.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, r101);     // Catch: Throwable -> L17 Exception -> L21
        r104.endTag(null, LOCALE_RECORD_FILE_TAG);     // Catch: Throwable -> L17 Exception -> L21
        r104.endDocument();     // Catch: Throwable -> L17 Exception -> L21
        if (r103 != null) goto L33;
    L23:
        monitor-exit(r102);     // Catch: Throwable -> L28
        return;
    L33:
        r103.close();     // Catch: IOException -> L31 Throwable -> L28
        goto L23
    L21:
        if (r103 == null) goto L23;
    L17:
        th = move-exception;
        if (r103 != null) goto L35;
    L20:
        throw th;     // Catch: Throwable -> L28
    L35:
        r103.close();     // Catch: IOException -> L32 Throwable -> L28
        goto L20
    L25:
        String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", new Object[]{APPLICATION_LOCALES_RECORD_FILE});     // Catch: Throwable -> L28
    }
}
