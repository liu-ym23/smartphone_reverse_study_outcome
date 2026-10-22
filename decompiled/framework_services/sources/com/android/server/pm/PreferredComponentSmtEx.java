package com.android.server.pm;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredComponentSmtEx {
    private final PreferredComponent mComponent;

    public PreferredComponentSmtEx(PreferredComponent component) {
        this.mComponent = component;
    }

    public boolean sameSet(List<ResolveInfo> query, ComponentName searchPackage) {
        if (this.mComponent.mSetPackages != null) goto L6;
        return false;
    L6:
        if (searchPackage == null) goto L15;
        query = new ArrayList(query);
        int i = query.size() - 1;
    L8:
        if (i < 0) goto L15;
        ActivityInfo ai = query.get(i).activityInfo;
        if (searchPackage.getPackageName().equals(ai.packageName) == false) goto L14;
        if (searchPackage.getClassName().equals(ai.name) == false) goto L14;
        query.remove(i);
    L14:
        i = i - 1;
    L15:
        int NQ = query.size();
        int NS = this.mComponent.mSetPackages.length;
        int numMatch = 0;
        int i2 = 0;
    L16:
        if (i2 >= NQ) goto L28;
        ResolveInfo ri = query.get(i2);
        ActivityInfo ai2 = ri.activityInfo;
        boolean good = false;
        int j = 0;
    L18:
        if (j >= NS) goto L25;
        if (this.mComponent.mSetPackages[j].equals(ai2.packageName) == false) goto L24;
        if (this.mComponent.mSetClasses[j].equals(ai2.name) == false) goto L24;
        numMatch = numMatch + 1;
        good = true;
    L24:
        j = j + 1;
    L25:
        if (good == false) goto L26;
        i2 = i2 + 1;
        goto L16
    L26:
        return false;
    L28:
        int count = 0;
        if (searchPackage == null) goto L38;
        int i3 = 0;
    L31:
        if (i3 >= NS) goto L38;
        if (this.mComponent.mSetPackages[i3].equals(searchPackage.getPackageName()) == false) goto L37;
        if (this.mComponent.mSetClasses[i3].equals(searchPackage.getClassName()) == false) goto L37;
        count = count + 1;
    L37:
        i3 = i3 + 1;
    L38:
        int i4 = NS - count;
        if (numMatch == i4) goto L41;
        return false;
    L41:
        return true;
    }
}
