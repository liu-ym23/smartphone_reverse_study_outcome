package com.bytedance.android.live.liveinteract.bgComponent.theme.util;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f71816a = null;

    static {
        f71816a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i("[VoiceChat]ToolbarAudioThemeBehavior", "getLastBg failed " + ((Throwable) r100).getMessage());
    }
}
