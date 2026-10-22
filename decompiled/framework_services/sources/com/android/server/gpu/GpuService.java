package com.android.server.gpu;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.updatabledriver.UpdatableDriverProto;
import android.util.Base64;
import com.android.framework.protobuf.InvalidProtocolBufferException;
import com.android.server.SystemService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GpuService extends SystemService {
    private static final int BASE64_FLAGS = 3;
    public static final boolean DEBUG = false;
    private static final String DEV_DRIVER_PROPERTY = "ro.gfx.driver.1";
    private static final String PROD_DRIVER_PROPERTY = "ro.gfx.driver.0";
    public static final String TAG = "GpuService";
    private static final String UPDATABLE_DRIVER_PRODUCTION_ALLOWLIST_FILENAME = "allowlist.txt";
    private ContentResolver mContentResolver;
    private final Context mContext;
    private UpdatableDriverProto.Denylists mDenylists;
    private final String mDevDriverPackageName;
    private DeviceConfigListener mDeviceConfigListener;
    private final Object mDeviceConfigLock;
    private final boolean mHasDevDriver;
    private final boolean mHasProdDriver;
    private final Object mLock;
    private final PackageManager mPackageManager;
    private final String mProdDriverPackageName;
    private long mProdDriverVersionCode;
    private SettingsObserver mSettingsObserver;

    private final class DeviceConfigListener implements DeviceConfig.OnPropertiesChangedListener {
        final /* synthetic */ GpuService this$0;

        DeviceConfigListener(GpuService r2) {
            this.this$0 = r2;
            DeviceConfig.addOnPropertiesChangedListener("game_driver", GpuService.m4242$$Nest$fgetmContext(r2).getMainExecutor(), this);
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            Object r0 = GpuService.m4244$$Nest$fgetmDeviceConfigLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (properties.getKeyset().contains("updatable_driver_production_denylists") == false) goto L9;
            GpuService.m4248$$Nest$mparseDenylists(this.this$0, properties.getString("updatable_driver_production_denylists", ""));     // Catch: Throwable -> L7
            GpuService.m4250$$Nest$msetDenylist(this.this$0);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    private final class PackageReceiver extends BroadcastReceiver {
        final /* synthetic */ GpuService this$0;

        /* synthetic */ PackageReceiver(GpuService r1, GpuServiceIA r2) {
            this(r1);
        }

        private PackageReceiver(GpuService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String packageName = data.getSchemeSpecificPart();
            boolean isProdDriver = packageName.equals(GpuService.m4245$$Nest$fgetmProdDriverPackageName(this.this$0));
            boolean isDevDriver = packageName.equals(GpuService.m4243$$Nest$fgetmDevDriverPackageName(this.this$0));
            if (isProdDriver == true) goto L6;
            if (isDevDriver == true) goto L6;
            return;
        L6:
            String r4 = intent.getAction();
            switch(r4.hashCode()) {
                case 172491798: goto L16;
                case 525384130: goto L13;
                case 1544582882: goto L10;
                default: goto L18;
            };
        L18:
            byte r5 = -1;
        L19:
            switch(r5) {
                case 0: goto L21;
                case 1: goto L21;
                case 2: goto L21;
                default: goto L28;
            };
        L21:
            if (isProdDriver == false) goto L23;
            GpuService.m4247$$Nest$mfetchProductionDriverPackageProperties(this.this$0);
            GpuService.m4250$$Nest$msetDenylist(this.this$0);
            return;
        L23:
            if (isDevDriver == false) goto L27;
            GpuService.m4246$$Nest$mfetchPrereleaseDriverPackageProperties(this.this$0);
            return;
        L27:
            return;
        L28:
            return;
        L10:
            if (r4.equals("android.intent.action.PACKAGE_ADDED") == false) goto L18;
            r5 = 0;
            goto L19
        L13:
            if (r4.equals("android.intent.action.PACKAGE_REMOVED") == false) goto L18;
            r5 = 2;
            goto L19
        L16:
            if (r4.equals("android.intent.action.PACKAGE_CHANGED") == false) goto L18;
            r5 = 1;
            goto L19
        }
    }

    private final class SettingsObserver extends ContentObserver {
        private final Uri mProdDriverDenylistsUri;
        final /* synthetic */ GpuService this$0;

        SettingsObserver(GpuService r4) {
            this.this$0 = r4;
            super(new Handler());
            this.mProdDriverDenylistsUri = Settings.Global.getUriFor("updatable_driver_production_denylists");
            GpuService.m4241$$Nest$fgetmContentResolver(r4).registerContentObserver(this.mProdDriverDenylistsUri, false, this, -1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (uri != null) goto L5;
            return;
        L5:
            if (this.mProdDriverDenylistsUri.equals(uri) == false) goto L8;
            GpuService.m4249$$Nest$mprocessDenylists(this.this$0);
            GpuService.m4250$$Nest$msetDenylist(this.this$0);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContentResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentResolver m4241$$Nest$fgetmContentResolver(GpuService r0) {
        return r0.mContentResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m4242$$Nest$fgetmContext(GpuService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDevDriverPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4243$$Nest$fgetmDevDriverPackageName(GpuService r0) {
        return r0.mDevDriverPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceConfigLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m4244$$Nest$fgetmDeviceConfigLock(GpuService r0) {
        return r0.mDeviceConfigLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProdDriverPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4245$$Nest$fgetmProdDriverPackageName(GpuService r0) {
        return r0.mProdDriverPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$mfetchPrereleaseDriverPackageProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4246$$Nest$mfetchPrereleaseDriverPackageProperties(GpuService r0) {
        r0.fetchPrereleaseDriverPackageProperties();
    }

    /* JADX INFO: renamed from: -$$Nest$mfetchProductionDriverPackageProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4247$$Nest$mfetchProductionDriverPackageProperties(GpuService r0) {
        r0.fetchProductionDriverPackageProperties();
    }

    /* JADX INFO: renamed from: -$$Nest$mparseDenylists, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4248$$Nest$mparseDenylists(GpuService r0, String r1) {
        r0.parseDenylists(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessDenylists, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4249$$Nest$mprocessDenylists(GpuService r0) {
        r0.processDenylists();
    }

    /* JADX INFO: renamed from: -$$Nest$msetDenylist, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4250$$Nest$msetDenylist(GpuService r0) {
        r0.setDenylist();
    }

    private static native void nSetUpdatableDriverPath(String r0);

    public GpuService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mDeviceConfigLock = new Object();
        this.mContext = context;
        this.mProdDriverPackageName = SystemProperties.get(PROD_DRIVER_PROPERTY);
        this.mProdDriverVersionCode = -1;
        this.mDevDriverPackageName = SystemProperties.get(DEV_DRIVER_PROPERTY);
        this.mPackageManager = context.getPackageManager();
        this.mHasProdDriver = !TextUtils.isEmpty(this.mProdDriverPackageName);
        this.mHasDevDriver = !TextUtils.isEmpty(this.mDevDriverPackageName);
        if (this.mHasDevDriver == false) goto L5;
    L6:
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        packageFilter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);
        getContext().registerReceiverAsUser(new PackageReceiver(this, null), UserHandle.ALL, packageFilter, null, null);
        return;
    L5:
        if (this.mHasProdDriver == true) goto L6;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 1000) goto L11;
        this.mContentResolver = this.mContext.getContentResolver();
        if (this.mHasProdDriver == false) goto L7;
    L9:
        this.mSettingsObserver = new SettingsObserver(this);
        this.mDeviceConfigListener = new DeviceConfigListener(this);
        fetchProductionDriverPackageProperties();
        processDenylists();
        setDenylist();
        fetchPrereleaseDriverPackageProperties();
        return;
    L7:
        if (this.mHasDevDriver == true) goto L9;
        return;
    }

    private static void assetToSettingsGlobal(Context context, Context driverContext, String fileName, String settingsGlobal, CharSequence delimiter) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(driverContext.getAssets().open(fileName)));     // Catch: IOException -> L6
        ArrayList<String> assetStrings = new ArrayList();     // Catch: IOException -> L6
    L3:
        String assetString = reader.readLine();     // Catch: IOException -> L6
        if (assetString == null) goto L8;
        assetStrings.add(assetString);     // Catch: IOException -> L6
        goto L3
    L8:
        Settings.Global.putString(context.getContentResolver(), settingsGlobal, String.join(delimiter, assetStrings));     // Catch: IOException -> L6
        return;
    }

    private void fetchProductionDriverPackageProperties() {
        ApplicationInfo driverInfo = this.mPackageManager.getApplicationInfo(this.mProdDriverPackageName, 1048576);     // Catch: PackageManager.NameNotFoundException -> L11
        if (driverInfo.targetSdkVersion >= 26) goto L6;
        return;
    L6:
        Settings.Global.putString(this.mContentResolver, "updatable_driver_production_allowlist", "");
        this.mProdDriverVersionCode = driverInfo.longVersionCode;
        Context driverContext = this.mContext.createPackageContext(this.mProdDriverPackageName, 4);     // Catch: PackageManager.NameNotFoundException -> L9
        assetToSettingsGlobal(this.mContext, driverContext, UPDATABLE_DRIVER_PRODUCTION_ALLOWLIST_FILENAME, "updatable_driver_production_allowlist", ",");     // Catch: PackageManager.NameNotFoundException -> L9
        return;
    L10:
        return;
    }

    private void processDenylists() {
        String base64String = DeviceConfig.getProperty("game_driver", "updatable_driver_production_denylists");
        if (base64String != null) goto L5;
        base64String = Settings.Global.getString(this.mContentResolver, "updatable_driver_production_denylists");
    L5:
        if (base64String == null) goto L7;
        String r1 = base64String;
    L8:
        parseDenylists(r1);
        return;
    L7:
        r1 = "";
        goto L8
    }

    private void parseDenylists(String base64String) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDenylists = null;     // Catch: Throwable -> L9
        this.mDenylists = UpdatableDriverProto.Denylists.parseFrom(Base64.decode(base64String, 3));     // Catch: Throwable -> L9 InvalidProtocolBufferException -> L11 IllegalArgumentException -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void setDenylist() {
        Settings.Global.putString(this.mContentResolver, "updatable_driver_production_denylist", "");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDenylists != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        List<UpdatableDriverProto.Denylist> denylists = this.mDenylists.getDenylistsList();     // Catch: Throwable -> L8
        Iterator<UpdatableDriverProto.Denylist> r2 = denylists.iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L19;
        UpdatableDriverProto.Denylist denylist = r2.next();     // Catch: Throwable -> L8
        if (denylist.getVersionCode() != this.mProdDriverVersionCode) goto L12;
        Settings.Global.putString(this.mContentResolver, "updatable_driver_production_denylist", String.join(",", denylist.getPackageNamesList()));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void fetchPrereleaseDriverPackageProperties() {
        ApplicationInfo driverInfo = this.mPackageManager.getApplicationInfo(this.mDevDriverPackageName, 1048576);     // Catch: PackageManager.NameNotFoundException -> L8
        if (driverInfo.targetSdkVersion >= 26) goto L6;
        return;
    L6:
        setUpdatableDriverPath(driverInfo);
        return;
    }

    private void setUpdatableDriverPath(ApplicationInfo ai) {
        if (ai.primaryCpuAbi != null) goto L6;
        nSetUpdatableDriverPath("");
        return;
    L6:
        nSetUpdatableDriverPath(ai.sourceDir + "!/lib/");
    }
}
