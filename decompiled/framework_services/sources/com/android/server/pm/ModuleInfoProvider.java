package com.android.server.pm;

import android.R;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.util.XmlUtils;
import com.android.server.LocalServices;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ModuleInfoProvider {
    private static final String MODULE_METADATA_KEY = "android.content.pm.MODULE_METADATA";
    private static final String TAG = "PackageManager.ModuleInfoProvider";
    private final ApexManager mApexManager;
    private final Context mContext;
    private volatile boolean mMetadataLoaded;
    private final Map<String, ModuleInfo> mModuleInfo;
    private IPackageManager mPackageManager;
    private volatile String mPackageName;

    ModuleInfoProvider(Context context) {
        this.mContext = context;
        this.mApexManager = ApexManager.getInstance();
        this.mModuleInfo = new ArrayMap();
    }

    public ModuleInfoProvider(XmlResourceParser metadata, Resources resources, ApexManager apexManager) {
        this.mContext = null;
        this.mApexManager = apexManager;
        this.mModuleInfo = new ArrayMap();
        loadModuleMetadata(metadata, resources);
    }

    private IPackageManager getPackageManager() {
        if (this.mPackageManager != null) goto L6;
        this.mPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService(Settings.ATTR_PACKAGE));
    L6:
        return this.mPackageManager;
    }

    public void systemReady() {
        this.mPackageName = this.mContext.getResources().getString(R.string.config_factoryResetPackage);
        if (TextUtils.isEmpty(this.mPackageName) == false) goto L12;
        Slog.w(TAG, "No configured module metadata provider.");
        return;
    L12:
        PackageInfo pi = getPackageManager().getPackageInfo(this.mPackageName, 128, 0);     // Catch: Throwable -> L9
        Context packageContext = this.mContext.createPackageContext(this.mPackageName, 0);     // Catch: Throwable -> L9
        Resources packageResources = packageContext.getResources();     // Catch: Throwable -> L9
        XmlResourceParser parser = packageResources.getXml(pi.applicationInfo.metaData.getInt(MODULE_METADATA_KEY));
        loadModuleMetadata(parser, packageResources);
        return;
    L9:
        e = move-exception;
        Slog.w(TAG, "Unable to discover metadata package: " + this.mPackageName, e);
    }

    private void loadModuleMetadata(XmlResourceParser parser, Resources packageResources) {
        XmlUtils.beginDocument(parser, "module-metadata");     // Catch: Throwable -> L11 Throwable -> L13
    L4:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L11 Throwable -> L13
        if (parser.getEventType() == 1) goto L10;
        if ("module".equals(parser.getName()) == false) goto L9;
        CharSequence moduleName = packageResources.getText(Integer.parseInt(parser.getAttributeValue(null, "name").substring(1)));     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        String modulePackageName = XmlUtils.readStringAttribute(parser, "packageName");     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        boolean isHidden = XmlUtils.readBooleanAttribute(parser, "isHidden");     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        ModuleInfo mi = new ModuleInfo();     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        mi.setHidden(isHidden);     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        mi.setPackageName(modulePackageName);     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        mi.setName(moduleName);     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        mi.setApexModuleName(this.mApexManager.getApexModuleNameForPackageName(modulePackageName));     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        mi.setApkInApexPackageNames(this.mApexManager.getApksInApex(modulePackageName));     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        this.mModuleInfo.put(modulePackageName, mi);     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
        goto L4
    L9:
        Slog.w(TAG, "Unexpected metadata element: " + parser.getName());     // Catch: Throwable -> L11 Throwable -> L13
        this.mModuleInfo.clear();     // Catch: Throwable -> L11 Throwable -> L13
    L10:
        parser.close();
        this.mMetadataLoaded = true;
        return;
    L11:
        th = move-exception;
        parser.close();
        this.mMetadataLoaded = true;
        throw th;
    L13:
        e = move-exception;
        Slog.w(TAG, "Error parsing module metadata", e);     // Catch: Throwable -> L11
        this.mModuleInfo.clear();     // Catch: Throwable -> L11
        goto L10
    }

    List<ModuleInfo> getInstalledModules(int flags) {
        if (this.mMetadataLoaded == false) goto L19;
        if ((131072 & flags) != 0) goto L7;
        if (flags != 0) goto L10;
        flags = 65536;
    L10:
        List<PackageInfo> allPackages = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getInstalledPackagesUncheck(1073741824 | flags, UserHandle.getCallingUserId()).getList();
        ArrayList<ModuleInfo> installedModules = new ArrayList(allPackages.size());
        Iterator<PackageInfo> r2 = allPackages.iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        PackageInfo p = r2.next();
        ModuleInfo m = this.mModuleInfo.get(p.packageName);
        if (m == null) goto L12;
        installedModules.add(m);
        goto L12
    L17:
        return installedModules;
    L7:
        return new ArrayList(this.mModuleInfo.values());
    L19:
        throw new IllegalStateException("Call to getInstalledModules before metadata loaded");
    }

    ModuleInfo getModuleInfo(String name, int flags) {
        if (this.mMetadataLoaded == false) goto L18;
        if ((flags & 1) == 0) goto L16;
        Iterator<ModuleInfo> r0 = this.mModuleInfo.values().iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        ModuleInfo moduleInfo = r0.next();
        if (name.equals(moduleInfo.getApexModuleName()) == false) goto L8;
        return moduleInfo;
    L13:
        return null;
    L16:
        return this.mModuleInfo.get(name);
    L18:
        throw new IllegalStateException("Call to getModuleInfo before metadata loaded");
    }

    String getPackageName() {
        if (this.mMetadataLoaded == false) goto L7;
        return this.mPackageName;
    L7:
        throw new IllegalStateException("Call to getVersion before metadata loaded");
    }
}
