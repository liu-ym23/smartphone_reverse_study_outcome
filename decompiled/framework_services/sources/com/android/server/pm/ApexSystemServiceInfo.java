package com.android.server.pm;

/* JADX INFO: loaded from: classes2.dex */
public final class ApexSystemServiceInfo implements Comparable<ApexSystemServiceInfo> {
    final int mInitOrder;
    final String mJarPath;
    final String mName;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ApexSystemServiceInfo r1) {
        return compareTo2(r1);
    }

    public ApexSystemServiceInfo(String name, String jarPath, int initOrder) {
        this.mName = name;
        this.mJarPath = jarPath;
        this.mInitOrder = initOrder;
    }

    public String getName() {
        return this.mName;
    }

    public String getJarPath() {
        return this.mJarPath;
    }

    public int getInitOrder() {
        return this.mInitOrder;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ApexSystemServiceInfo other) {
        if (this.mInitOrder != other.mInitOrder) goto L7;
        return this.mName.compareTo(other.mName);
    L7:
        return -Integer.compare(this.mInitOrder, other.mInitOrder);
    }
}
