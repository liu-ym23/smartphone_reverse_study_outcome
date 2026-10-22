package com.android.server.devicepolicy;

import android.content.ComponentName;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes2.dex */
final class CallerIdentity {
    private final ComponentName mComponentName;
    private final String mPackageName;
    private final int mUid;

    CallerIdentity(int uid, String packageName, ComponentName componentName) {
        this.mUid = uid;
        this.mPackageName = packageName;
        this.mComponentName = componentName;
    }

    public int getUid() {
        return this.mUid;
    }

    public int getUserId() {
        return UserHandle.getUserId(this.mUid);
    }

    public UserHandle getUserHandle() {
        return UserHandle.getUserHandleForUid(this.mUid);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public boolean hasAdminComponent() {
        if (this.mComponentName == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasPackage() {
        if (this.mPackageName == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("CallerIdentity[uid=").append(this.mUid);
        if (this.mPackageName == null) goto L6;
        builder.append(", pkg=");
        builder.append(this.mPackageName);
    L6:
        if (this.mComponentName == null) goto L8;
        builder.append(", cmp=");
        builder.append(this.mComponentName.flattenToShortString());
    L8:
        builder.append("]");
        return builder.toString();
    }
}
