package com.bytedance.android.ec.hybrid.list.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f47333b;

    public static final class a {
    }

    static {
    }

    public i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        Intrinsics.checkNotNullParameter("default_group", "group");
        this.f47332a = r100;
        this.f47333b = "default_group";
    }
}
