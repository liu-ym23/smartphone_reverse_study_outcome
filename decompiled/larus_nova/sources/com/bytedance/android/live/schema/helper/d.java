package com.bytedance.android.live.schema.helper;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f100516a = null;

    static {
        f100516a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ALogger.i("LynxCacheHelper", "evict success");
    }
}
