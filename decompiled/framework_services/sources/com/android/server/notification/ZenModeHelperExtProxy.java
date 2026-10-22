package com.android.server.notification;

import android.prometheus.ext.core.ExtLoader;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeHelperExtProxy {
    private ZenModeHelper mBase;
    private List<IZenModeHelperExt> mZenModeHelperExts;

    public static ZenModeHelperExtProxy get(ZenModeHelper obj) {
        return new ZenModeHelperExtProxy(obj);
    }

    public ZenModeHelperExtProxy(ZenModeHelper base) {
        this.mZenModeHelperExts = ExtLoader.getAll(IZenModeHelperExt.class, base);
        this.mBase = base;
    }

    public int applyRestrictions_overriderSuppressionBehavior(int usage, int defaultBehavior) {
        if (this.mZenModeHelperExts.isEmpty() == true) goto L12;
        Iterator<IZenModeHelperExt> r0 = this.mZenModeHelperExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        IZenModeHelperExt ext = r0.next();
        Optional<Integer> result = ext.applyRestrictions_overriderSuppressionBehavior(usage);
        if (result.isPresent() == false) goto L6;
        return result.get().intValue();
    L12:
        return defaultBehavior;
    }
}
