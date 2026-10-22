package com.android.server.pm.parsing;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import bytedanceos.os.PeroptWhiteListParser;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInfoUtilsSmtEx {
    public PackageInfoUtilsSmtEx() {
    }

    public static void updateBytedanceXMLFlags(ActivityInfo info) {
        info.getSysEx().smXMLFlags = 0;
        ComponentName componentName = new ComponentName(info.packageName, info.name);
        PeroptWhiteListParser.WhiteItem item = (PeroptWhiteListParser.WhiteItem) PeroptWhiteListParser.activityWhiteList.get(componentName.flattenToShortString());
        if (item == null) goto L5;
        info.getSysEx().smXMLFlags = item.SMFlag;
    L5:
        PeroptWhiteListParser.WhiteItem item2 = (PeroptWhiteListParser.WhiteItem) PeroptWhiteListParser.activityWhiteList.get(info.name);
        if (item2 == null) goto L9;
        info.getSysEx().smXMLFlags |= item2.SMFlag;
        return;
    }
}
