package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f80820a = null;

    static {
        f80820a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "error message : " + ((Throwable) r100));
    }
}
