package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdk.config.si;
import com.bytedance.android.livesdk.config.x11;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes11.dex */
public final class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f159105a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x11 f159106b = null;

    static {
        f159105a = PThreadExecutorsUtils.newSingleThreadExecutor(new SimpleThreadFactory("live_buffer"));
        f159106b = si.f121230a.getValue();
    }
}
