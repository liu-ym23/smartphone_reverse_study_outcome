package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Bundle;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class BadParcelableLancet {
    public BadParcelableLancet() {
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public Bundle getBundleExtra(String r10) {
        Bundle r11 = (Bundle) Origin.call();
        Context r12 = BadParcelableCrashOptimizer.getContext();
        if (r11 == null) goto L6;
        if (r12 == null) goto L6;
        r11.setClassLoader(r12.getClassLoader());
    L6:
        return r11;
    }
}
