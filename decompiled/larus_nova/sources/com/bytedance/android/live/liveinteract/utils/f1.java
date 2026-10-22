package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class f1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f1 f78767a = null;

    static {
        f78767a = new f1();
    }

    public f1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
        ALogger.e("[PaidQueue]", String.valueOf(Unit.INSTANCE));
    }
}
