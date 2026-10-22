package com.android.contacts.common.extensions;

import android.content.Context;
import com.GlobalProxyLancet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class ExtensionsFactory {
    private static final String EXTENDED_PHONE_DIRECTORIES_KEY = "extendedPhoneDirectories";
    private static final String EXTENSIONS_PROPERTIES = "contacts_extensions.properties";
    private static String TAG = "ExtensionsFactory";
    private static ExtendedPhoneDirectoriesManager mExtendedPhoneDirectoriesManager;
    private static Properties sProperties;

    static {
    }

    public ExtensionsFactory() {
    }

    public static synchronized void init(Context r2) {
        monitor-enter(ExtensionsFactory.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sProperties == null) goto L23;
        monitor-exit(ExtensionsFactory.class);
        return;
    L23:
        InputStream r3 = r2.getAssets().open(EXTENSIONS_PROPERTIES);     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L18
        Properties r1 = new Properties();     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L18
        sProperties = r1;     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L18
        r1.load(r3);     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L18
        r3.close();     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L18
        String r4 = sProperties.getProperty(EXTENDED_PHONE_DIRECTORIES_KEY);     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L18
        if (r4 == null) goto L11;
        mExtendedPhoneDirectoriesManager = (ExtendedPhoneDirectoriesManager) createInstance(r4);     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L18
    L22:
    L16:
        monitor-exit(ExtensionsFactory.class);
        return;
    L11:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "extendedPhoneDirectories not found in properties file.");     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L18
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "No custom extensions.");     // Catch: Throwable -> L18
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, e.toString());     // Catch: Throwable -> L18
        goto L16
    }

    private static <T> T createInstance(String r4) {
        return (T) Class.forName(r4).newInstance();
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r4 + ": unable to create instance.", e);
        return null;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r4 + ": unable to create instance.", e);
        return null;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r4 + ": unable to create instance.", e);
        return null;
    }

    public static ExtendedPhoneDirectoriesManager getExtendedPhoneDirectoriesManager() {
        return mExtendedPhoneDirectoriesManager;
    }
}
