package com.android.server.usage;

import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class PackagesTokenData {
    private static final int PACKAGE_NAME_INDEX = 0;
    public static final int UNASSIGNED_TOKEN = -1;
    public int counter;
    public final ArrayMap<String, ArrayMap<String, Integer>> packagesToTokensMap;
    public final ArraySet<Integer> removedPackageTokens;
    public final ArrayMap<String, Long> removedPackagesMap;
    public final SparseArray<ArrayList<String>> tokensToPackagesMap;

    public PackagesTokenData() {
        this.counter = 1;
        this.tokensToPackagesMap = new SparseArray();
        this.packagesToTokensMap = new ArrayMap();
        this.removedPackagesMap = new ArrayMap();
        this.removedPackageTokens = new ArraySet();
    }

    public int getPackageTokenOrAdd(String packageName, long timeStamp) {
        Long timeRemoved = this.removedPackagesMap.get(packageName);
        if (timeRemoved != null) goto L5;
    L7:
        ArrayMap<String, Integer> packageTokensMap = this.packagesToTokensMap.get(packageName);
        if (packageTokensMap != null) goto L10;
        packageTokensMap = new ArrayMap();
        this.packagesToTokensMap.put(packageName, packageTokensMap);
    L10:
        int token = packageTokensMap.getOrDefault(packageName, -1).intValue();
        if (token != (-1)) goto L14;
        int token2 = this.counter;
        this.counter = token2 + 1;
        ArrayList<String> tokenPackages = new ArrayList();
        tokenPackages.add(packageName);
        packageTokensMap.put(packageName, Integer.valueOf(token2));
        this.tokensToPackagesMap.put(token2, tokenPackages);
        return token2;
    L14:
        return token;
    L5:
        if (timeRemoved.longValue() <= timeStamp) goto L7;
        return -1;
    }

    public int getTokenOrAdd(int packageToken, String packageName, String key) {
        if (packageName.equals(key) == false) goto L6;
        return 0;
    L6:
        int token = this.packagesToTokensMap.get(packageName).getOrDefault(key, -1).intValue();
        if (token != (-1)) goto L10;
        int token2 = this.tokensToPackagesMap.get(packageToken).size();
        this.packagesToTokensMap.get(packageName).put(key, Integer.valueOf(token2));
        this.tokensToPackagesMap.get(packageToken).add(key);
        return token2;
    L10:
        return token;
    }

    public String getPackageString(int packageToken) {
        ArrayList<String> packageStrings = this.tokensToPackagesMap.get(packageToken);
        if (packageStrings != null) goto L7;
        return null;
    L7:
        return packageStrings.get(0);
    }

    public String getString(int packageToken, int token) {
        return this.tokensToPackagesMap.get(packageToken).get(token);
    L7:
        npe = move-exception;
        Slog.e("PackagesTokenData", "Unable to find tokenized strings for package " + packageToken, npe);
        return null;
    L10:
        return null;
    }

    public int removePackage(String packageName, long timeRemoved) {
        this.removedPackagesMap.put(packageName, Long.valueOf(timeRemoved));
        if (this.packagesToTokensMap.containsKey(packageName) == true) goto L6;
        return -1;
    L6:
        int packageToken = this.packagesToTokensMap.get(packageName).get(packageName).intValue();
        this.packagesToTokensMap.remove(packageName);
        this.tokensToPackagesMap.delete(packageToken);
        this.removedPackageTokens.add(Integer.valueOf(packageToken));
        return packageToken;
    }
}
