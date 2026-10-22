package com.baidu.android.bbalbs.common.util;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public class CommonParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f30037a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f30038b = "CommonParam";

    public CommonParam() {
    }

    public static String getCUID(Context r100) {
        return DeviceId.getCUID(r100);
    }
}
