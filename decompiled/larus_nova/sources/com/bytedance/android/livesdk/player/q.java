package com.bytedance.android.livesdk.player;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes11.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f156029a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HandlerThread f156030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f156031c;

    static {
        f156029a = PThreadExecutorsUtils.newSingleThreadExecutor(new SimpleThreadFactory("spm_logger"));
    }
}
