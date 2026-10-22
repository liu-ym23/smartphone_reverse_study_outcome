package com.android.server.pm.parsing.library;

import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PackageSharedLibraryUpdater {
    public abstract void updatePackage(ParsedPackage r1, boolean r2, boolean r3);

    public PackageSharedLibraryUpdater() {
    }

    static void removeLibrary(ParsedPackage parsedPackage, String libraryName) {
        parsedPackage.removeUsesLibrary(libraryName).removeUsesOptionalLibrary(libraryName);
    }

    static <T> ArrayList<T> prefix(ArrayList<T> cur, T val) {
        if (cur != null) goto L4;
        cur = new ArrayList();
    L4:
        cur.add(0, val);
        return cur;
    }

    private static boolean isLibraryPresent(List<String> usesLibraries, List<String> usesOptionalLibraries, String apacheHttpLegacy) {
        if (ArrayUtils.contains(usesLibraries, apacheHttpLegacy) == false) goto L5;
    L8:
        return true;
    L5:
        if (ArrayUtils.contains(usesOptionalLibraries, apacheHttpLegacy) == true) goto L8;
        return false;
    }

    void prefixImplicitDependency(ParsedPackage parsedPackage, String existingLibrary, String implicitDependency) {
        List<String> usesLibraries = parsedPackage.getUsesLibraries();
        List<String> usesOptionalLibraries = parsedPackage.getUsesOptionalLibraries();
        if (isLibraryPresent(usesLibraries, usesOptionalLibraries, implicitDependency) == false) goto L5;
        return;
    L5:
        if (ArrayUtils.contains(usesLibraries, existingLibrary) == false) goto L8;
        parsedPackage.addUsesLibrary(0, implicitDependency);
        return;
    L8:
        if (ArrayUtils.contains(usesOptionalLibraries, existingLibrary) == false) goto L13;
        parsedPackage.addUsesOptionalLibrary(0, implicitDependency);
        return;
    }

    void prefixRequiredLibrary(ParsedPackage parsedPackage, String libraryName) {
        List<String> usesLibraries = parsedPackage.getUsesLibraries();
        List<String> usesOptionalLibraries = parsedPackage.getUsesOptionalLibraries();
        boolean alreadyPresent = isLibraryPresent(usesLibraries, usesOptionalLibraries, libraryName);
        if (alreadyPresent == true) goto L6;
        parsedPackage.addUsesLibrary(0, libraryName);
        return;
    }
}
