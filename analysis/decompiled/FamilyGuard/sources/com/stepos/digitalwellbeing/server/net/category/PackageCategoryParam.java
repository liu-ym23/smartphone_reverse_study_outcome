package com.stepos.digitalwellbeing.server.net.category;

/* loaded from: classes.dex */
public class PackageCategoryParam {
    public String pkg;
    public int sys;

    public PackageCategoryParam(String str, boolean z5) {
        this.pkg = str;
        this.sys = z5 ? 1 : 0;
    }
}
