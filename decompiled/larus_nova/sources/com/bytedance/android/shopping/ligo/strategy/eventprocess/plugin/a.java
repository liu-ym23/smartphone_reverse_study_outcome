package com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f176492a = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin.a$a, reason: collision with other inner class name */
    public static final class C2613a {
    }

    static {
        f176492a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("AbsLigoEventProcessPlugin"));
    }
}
