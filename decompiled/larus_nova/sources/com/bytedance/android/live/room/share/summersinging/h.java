package com.bytedance.android.live.room.share.summersinging;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f100351a = null;

    static {
        f100351a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        ALogger.e("GroupPhotoDialogLauncher", "download avatar error: " + r101.getMessage());
        return sh6.a.f541970a;
    }
}
