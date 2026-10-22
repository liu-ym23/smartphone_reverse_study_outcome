package com.android.server.pm.parsing;

import android.os.ServiceManager;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.pm.parsing.PackageParser2;

/* JADX INFO: loaded from: classes2.dex */
public class PackageParserUtils {
    public PackageParserUtils() {
    }

    public static PackageParser2 forParsingFileWithDefaults() {
        final IPlatformCompat platformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
        return new PackageParser2(null, null, null, new AnonymousClass1(platformCompat));
    }
}
