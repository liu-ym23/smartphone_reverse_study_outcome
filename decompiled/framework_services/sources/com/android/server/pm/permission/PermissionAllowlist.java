package com.android.server.pm.permission;

import android.util.ArrayMap;

/* JADX INFO: loaded from: classes2.dex */
public final class PermissionAllowlist {
    private final ArrayMap<String, ArrayMap<String, ArrayMap<String, Boolean>>> mApexPrivilegedAppAllowlists;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mApexSignatureAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mOemAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mPrivilegedAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mProductPrivilegedAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mProductSignatureAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mSignatureAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mSystemExtPrivilegedAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mSystemExtSignatureAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mVendorPrivilegedAppAllowlist;
    private final ArrayMap<String, ArrayMap<String, Boolean>> mVendorSignatureAppAllowlist;

    public PermissionAllowlist() {
        this.mOemAppAllowlist = new ArrayMap();
        this.mPrivilegedAppAllowlist = new ArrayMap();
        this.mVendorPrivilegedAppAllowlist = new ArrayMap();
        this.mProductPrivilegedAppAllowlist = new ArrayMap();
        this.mSystemExtPrivilegedAppAllowlist = new ArrayMap();
        this.mApexPrivilegedAppAllowlists = new ArrayMap();
        this.mSignatureAppAllowlist = new ArrayMap();
        this.mVendorSignatureAppAllowlist = new ArrayMap();
        this.mProductSignatureAppAllowlist = new ArrayMap();
        this.mSystemExtSignatureAppAllowlist = new ArrayMap();
        this.mApexSignatureAppAllowlist = new ArrayMap();
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getOemAppAllowlist() {
        return this.mOemAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getPrivilegedAppAllowlist() {
        return this.mPrivilegedAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getVendorPrivilegedAppAllowlist() {
        return this.mVendorPrivilegedAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getProductPrivilegedAppAllowlist() {
        return this.mProductPrivilegedAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getSystemExtPrivilegedAppAllowlist() {
        return this.mSystemExtPrivilegedAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, ArrayMap<String, Boolean>>> getApexPrivilegedAppAllowlists() {
        return this.mApexPrivilegedAppAllowlists;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getSignatureAppAllowlist() {
        return this.mSignatureAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getVendorSignatureAppAllowlist() {
        return this.mVendorSignatureAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getProductSignatureAppAllowlist() {
        return this.mProductSignatureAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getSystemExtSignatureAppAllowlist() {
        return this.mSystemExtSignatureAppAllowlist;
    }

    public ArrayMap<String, ArrayMap<String, Boolean>> getApexSignatureAppAllowlist() {
        return this.mApexSignatureAppAllowlist;
    }

    public Boolean getOemAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mOemAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getPrivilegedAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mPrivilegedAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getVendorPrivilegedAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mVendorPrivilegedAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getProductPrivilegedAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mProductPrivilegedAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getSystemExtPrivilegedAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mSystemExtPrivilegedAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getApexPrivilegedAppAllowlistState(String moduleName, String packageName, String permissionName) {
        ArrayMap<String, ArrayMap<String, Boolean>> allowlist = this.mApexPrivilegedAppAllowlists.get(moduleName);
        if (allowlist != null) goto L5;
        return null;
    L5:
        ArrayMap<String, Boolean> permissions = allowlist.get(packageName);
        if (permissions != null) goto L9;
        return null;
    L9:
        return permissions.get(permissionName);
    }

    public Boolean getSignatureAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mSignatureAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getVendorSignatureAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mVendorSignatureAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getProductSignatureAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mProductSignatureAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getSystemExtSignatureAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mSystemExtSignatureAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }

    public Boolean getApexSignatureAppAllowlistState(String packageName, String permissionName) {
        ArrayMap<String, Boolean> permissions = this.mApexSignatureAppAllowlist.get(packageName);
        if (permissions != null) goto L7;
        return null;
    L7:
        return permissions.get(permissionName);
    }
}
