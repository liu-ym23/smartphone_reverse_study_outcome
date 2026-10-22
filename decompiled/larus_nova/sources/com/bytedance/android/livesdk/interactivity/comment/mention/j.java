package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f135309a = null;

    static {
        f135309a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.e("MentionSectionController", " query user failed.");
    }
}
