package com.android.server.pm;

import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.server.pm.pkg.PackageStateInternal;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppsFilterImplZteHook {
    private static final List<String> ZTE_FORCE_QUERYABLE_WHITELIST = null;

    public AppsFilterImplZteHook() {
    }

    static {
        ZTE_FORCE_QUERYABLE_WHITELIST = Arrays.asList(new String[]{"cn.nubia.identity"});
    }

    static boolean shouldForceQueryableZTE(PackageStateInternal pkgSetting) {
        if (pkgSetting != null) goto L5;
        return false;
    L5:
        AndroidPackageInternal r0 = pkgSetting.getPkg();
        if (r0 == null) goto L8;
        String pkgName = r0.getPackageName();
    L10:
        return ZTE_FORCE_QUERYABLE_WHITELIST.contains(pkgName);
    L8:
        pkgName = null;
        goto L10
    }
}
