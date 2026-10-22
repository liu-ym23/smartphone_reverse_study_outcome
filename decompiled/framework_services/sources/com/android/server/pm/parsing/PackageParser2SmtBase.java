package com.android.server.pm.parsing;

import android.os.SystemProperties;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.server.slice.SliceClientPermissions;
import dalvik.system.DexClassLoader;

/* JADX INFO: loaded from: classes2.dex */
public class PackageParser2SmtBase {
    public PackageParser2SmtBase() {
    }

    protected boolean onParsePackage(ParsedPackage parsed) {
        return false;
    }

    public static void verifyLibraryFiles(ParsedPackage parsed) {
        String dexPath = null;
        String path = parsed.getPath();
        if (SystemProperties.getInt("persist.sys.classoverrider.close", 0) != 1) goto L16;
        parsed.getApplicationInfoSysEx().mOverrideClassSDK = 0;
        return;
    L16:
        DexClassLoader classLoader = new DexClassLoader(path + SliceClientPermissions.SliceAuthority.DELIMITER + "base.apk", path, null, ClassLoader.getSystemClassLoader());     // Catch: Exception -> L10
        Class checkClass = classLoader.loadClass("com.picovr.picovrlib.cvcontrollerclient.ControllerClient");     // Catch: Exception -> L10
        if (checkClass == null) goto L13;
        dexPath = "/system/framework/sys-sharememory.jar";
    L13:
        if (dexPath == null) goto L18;
        parsed.getApplicationInfoSysEx().mOverrideClassSDK = 1;
        return;
    }
}
