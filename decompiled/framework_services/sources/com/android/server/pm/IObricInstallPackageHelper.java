package com.android.server.pm;

import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricInstallPackageHelper extends IObricBase {
    default boolean deletePackageForAssist(String packageName, ParsedPackage parsedPackage) {
        return false;
    }

    default void checkAssistInstallRestriction(ParsedPackage parsedPackage) throws PrepareFailure {
    }
}
