package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f75060a = null;

    static {
        f75060a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.w("MultiLinkSettingPanelReuseManager", "preloadSettingPanelContainerCard fail=" + ((Throwable) r100).getMessage());
    }
}
