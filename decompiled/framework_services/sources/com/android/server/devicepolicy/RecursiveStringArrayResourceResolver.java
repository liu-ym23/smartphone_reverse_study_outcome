package com.android.server.devicepolicy;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class RecursiveStringArrayResourceResolver {
    private static final String IMPORT_PREFIX = "#import:";
    private static final String PWP = ".";
    private static final String SEPARATOR = "/";
    private final Resources mResources;

    public RecursiveStringArrayResourceResolver(Resources resources) {
        this.mResources = resources;
    }

    public Set<String> resolve(String pkg, int rootId) {
        return resolve(List.of(), pkg, rootId);
    }

    private Set<String> resolve(Collection<String> cache, String pkg, int rootId) {
        String[] strings = this.mResources.getStringArray(rootId);
        ArrayList<String> runningCache = new ArrayList(cache);
        HashSet<String> result = new HashSet();
        int r3 = strings.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L14;
        String string = strings[r4];
        if (string.startsWith(IMPORT_PREFIX) == false) goto L7;
        String ref = string.substring(IMPORT_PREFIX.length());
    L8:
        if (ref != null) goto L11;
        result.add(string);
    L13:
        r4 = r4 + 1;
        goto L3
    L11:
        if (runningCache.contains(ref) == true) goto L13;
        Set<String> next = resolveImport(runningCache, pkg, ref);
        runningCache.addAll(next);
        result.addAll(next);
        goto L13
    L7:
        ref = null;
        goto L8
    L14:
        return result;
    }

    private Set<String> resolveImport(Collection<String> cache, String importingPackage, String ref) {
        String[] chunks = ref.split("/", 2);
        String pkg = chunks[0];
        String name = chunks[1];
        if (Objects.equals(pkg, PWP) == false) goto L5;
        String resolvedPkg = importingPackage;
    L6:
        int importId = this.mResources.getIdentifier(name, "array", resolvedPkg);
        if (importId == 0) goto L11;
        return resolve(cache, resolvedPkg, importId);
    L11:
        throw new Resources.NotFoundException(String.format("%s:array/%s", new Object[]{resolvedPkg, name}));
    L5:
        resolvedPkg = pkg;
        goto L6
    }
}
