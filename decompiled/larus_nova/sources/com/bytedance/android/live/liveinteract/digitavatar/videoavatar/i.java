package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f72724a = null;

    static {
        f72724a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("KtvDigitAvatar", "getAvatarAuditResult失败", (Throwable) r100);
    }
}
