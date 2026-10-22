package com.bytedance.android.accessibilityLib_Core.config.bean;

import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseConfig f38170a;

    public final String toString() {
        IBaseConfig r100 = this.f38170a;
        if (r100 == null) goto L9;
        ViewVirtualNode r101 = r100.getVirtualNode();
        if (r101 == null) goto L9;
        String r102 = r101.toString();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return "null config";
    }

    public a(IBaseConfig r100) {
        this.f38170a = r100;
    }
}
