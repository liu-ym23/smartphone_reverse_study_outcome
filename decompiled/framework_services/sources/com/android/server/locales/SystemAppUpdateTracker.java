package com.android.server.locales;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.LocaleList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class SystemAppUpdateTracker {
    private static final String ATTR_NAME = "name";
    private static final String PACKAGE_XML_TAG = "package";
    private static final String SYSTEM_APPS_XML_TAG = "system_apps";
    private static final String TAG = "SystemAppUpdateTracker";
    private final Context mContext;
    private final Object mFileLock;
    private final LocaleManagerService mLocaleManagerService;
    private final Set<String> mUpdatedApps;
    private final AtomicFile mUpdatedAppsFile;

    SystemAppUpdateTracker(LocaleManagerService localeManagerService) {
        this(localeManagerService.mContext, localeManagerService, new AtomicFile(new File(Environment.getDataSystemDirectory(), "locale_manager_service_updated_system_apps.xml")));
    }

    SystemAppUpdateTracker(Context context, LocaleManagerService localeManagerService, AtomicFile file) {
        this.mFileLock = new Object();
        this.mUpdatedApps = new HashSet();
        this.mContext = context;
        this.mLocaleManagerService = localeManagerService;
        this.mUpdatedAppsFile = file;
    }

    void init() {
        loadUpdatedSystemApps();
    }

    private void loadUpdatedSystemApps() {
        if (this.mUpdatedAppsFile.getBaseFile().exists() == true) goto L5;
        return;
    L5:
        InputStream updatedAppNamesInputStream = null;
        updatedAppNamesInputStream = this.mUpdatedAppsFile.openRead();     // Catch: Throwable -> L8 Throwable -> L10
        readFromXml(updatedAppNamesInputStream);     // Catch: Throwable -> L8 Throwable -> L10
    L7:
        IoUtils.closeQuietly(updatedAppNamesInputStream);
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "loadUpdatedSystemApps: Could not parse storage file ", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        IoUtils.closeQuietly(updatedAppNamesInputStream);
        throw th;
    }

    private void readFromXml(InputStream updateInfoInputStream) throws XmlPullParserException, IOException {
        TypedXmlPullParser parser = Xml.newFastPullParser();
        parser.setInput(updateInfoInputStream, StandardCharsets.UTF_8.name());
        XmlUtils.beginDocument(parser, SYSTEM_APPS_XML_TAG);
        int depth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L11;
        if (parser.getName().equals("package") == false) goto L4;
        String packageName = parser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(packageName) == true) goto L4;
        this.mUpdatedApps.add(packageName);
        goto L4
    }

    void onPackageUpdateFinished(String packageName, int uid) {
    L13:
        e = move-exception;
        Slog.e(TAG, "Exception in onPackageUpdateFinished.", e);
        return;
    L3:
        if (this.mUpdatedApps.contains(packageName) == false) goto L5;
        return;
    L5:
        if (isUpdatedSystemApp(packageName) == false) goto L28;
        int userId = UserHandle.getUserId(uid);     // Catch: Exception -> L13
        String installingPackageName = this.mLocaleManagerService.getInstallingPackageName(packageName, userId);     // Catch: Exception -> L13
        if (installingPackageName != null) goto L24;
        return;
    L24:
        LocaleList appLocales = this.mLocaleManagerService.getApplicationLocales(packageName, userId);     // Catch: Exception -> L13 RemoteException -> L15
        if (appLocales.isEmpty() == true) goto L18;
        this.mLocaleManagerService.notifyInstallerOfAppWhoseLocaleChanged(packageName, userId, appLocales);     // Catch: Exception -> L13 RemoteException -> L15
    L18:
        updateBroadcastedAppsList(packageName);     // Catch: Exception -> L13
        return;
    }

    private void updateBroadcastedAppsList(String packageName) {
        Object r0 = this.mFileLock;
        monitor-enter(r0);
        this.mUpdatedApps.add(packageName);     // Catch: Throwable -> L7
        writeUpdatedAppsFileLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void writeUpdatedAppsFileLocked() {
        FileOutputStream stream = null;
        stream = this.mUpdatedAppsFile.startWrite();     // Catch: IOException -> L5
        writeToXmlLocked(stream);     // Catch: IOException -> L5
        this.mUpdatedAppsFile.finishWrite(stream);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        this.mUpdatedAppsFile.failWrite(stream);
        Slog.e(TAG, "Failed to persist the updated apps list", e);
    }

    private void writeToXmlLocked(OutputStream stream) throws IOException {
        TypedXmlSerializer xml = Xml.newFastSerializer();
        xml.setOutput(stream, StandardCharsets.UTF_8.name());
        xml.startDocument(null, true);
        xml.startTag(null, SYSTEM_APPS_XML_TAG);
        Iterator<String> r3 = this.mUpdatedApps.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        String packageName = r3.next();
        xml.startTag(null, "package");
        xml.attribute(null, "name", packageName);
        xml.endTag(null, "package");
        goto L4
    L6:
        xml.endTag(null, SYSTEM_APPS_XML_TAG);
        xml.endDocument();
    }

    private boolean isUpdatedSystemApp(String packageName) {
        ApplicationInfo appInfo = null;
        appInfo = this.mContext.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES));     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (appInfo != null) goto L10;
        return false;
    L10:
        if ((appInfo.flags & 128) == 0) goto L15;
        return true;
    L15:
        return false;
    }

    Set<String> getUpdatedApps() {
        return this.mUpdatedApps;
    }
}
