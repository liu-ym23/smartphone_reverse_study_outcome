package com.bytedance.android.ecom.slice.ext.template.gecko.loader;

import com.bytedance.forest.model.ResourceFrom;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f51318a = null;

    static {
        int[] r100 = new int[ResourceFrom.values().length];
        f51318a = r100;
        r100[ResourceFrom.BUILTIN.ordinal()] = 1;
        r100[ResourceFrom.GECKO.ordinal()] = 2;
        r100[ResourceFrom.CDN.ordinal()] = 3;
        r100[ResourceFrom.MEMORY.ordinal()] = 4;
    }
}
