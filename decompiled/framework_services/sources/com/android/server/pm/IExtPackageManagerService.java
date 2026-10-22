package com.android.server.pm;

import android.content.pm.IPackageManagerExt;
import android.pico.utils.IExtBase;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtPackageManagerService extends IExtBase {
    void dump(PrintWriter r1, String[] r2);

    IPackageManagerExt getIExt();

    boolean hasAppCategoryType(String r1, int r2);

    void interceptSetEnabledSettingsIfNeeded(int r1, String r2);

    void setPendingClearAppData(String r1);

    void shutdown();

    void systemReady();

    void updateAppCategory(ParsedPackage r1);
}
