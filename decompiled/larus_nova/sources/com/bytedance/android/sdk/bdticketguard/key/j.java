package com.bytedance.android.sdk.bdticketguard.key;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes12.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f163904a = null;

    static {
        f163904a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ParallelKeyPairVerifier"));
    }
}
