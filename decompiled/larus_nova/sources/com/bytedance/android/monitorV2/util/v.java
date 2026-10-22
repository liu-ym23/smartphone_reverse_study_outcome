package com.bytedance.android.monitorV2.util;

import java.util.UUID;

/* JADX INFO: loaded from: classes12.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163258a = 0;

    static {
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        r100.append(System.currentTimeMillis());
        r100.append('-');
        r100.append(UUID.randomUUID());
        return r100.toString();
    }
}
