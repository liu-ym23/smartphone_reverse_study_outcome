package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f80837a = null;

    static {
        f80837a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i("[VideoTalk]ToolbarVideoThemeBehavior", "getLastBg failed " + ((Throwable) r100).getMessage());
    }
}
