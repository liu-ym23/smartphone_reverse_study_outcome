package com.bytedance.android.live.core.utils;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes45.dex */
public final class v0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v0 f66419e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f66420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f66421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f66422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f66423d;

    static {
        f66419e = new v0();
    }

    public v0() {
        this.f66422c = new Object();
        this.f66423d = null;
        this.f66420a = PThreadExecutorsUtils.newFixedThreadPool(1, new DefaultThreadFactory("ImageMonitorHelper"));
        this.f66421b = new LinkedList();
    }
}
