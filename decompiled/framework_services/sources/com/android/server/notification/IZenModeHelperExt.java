package com.android.server.notification;

import android.content.Context;
import android.prometheus.ext.core.ExtLoader;
import android.prometheus.ext.core.ReflectionUtils;
import java.util.Optional;

/* JADX INFO: loaded from: classes2.dex */
public class IZenModeHelperExt {
    protected ZenModeHelper mBase;
    protected final Context mContext;
    protected final ReflectionUtils mReflectionUtils;

    public static IZenModeHelperExt get(Object obj) {
        return (IZenModeHelperExt) ExtLoader.get(IZenModeHelperExt.class, obj);
    }

    public IZenModeHelperExt(Object base) {
        this((ZenModeHelper) base);
    }

    public IZenModeHelperExt(ZenModeHelper base) {
        this.mBase = base;
        this.mReflectionUtils = new ReflectionUtils(this.mBase);
        this.mContext = (Context) this.mReflectionUtils.getFieldValue("mContext");
    }

    public Optional<Integer> applyRestrictions_overriderSuppressionBehavior(int usage) {
        return Optional.empty();
    }
}
