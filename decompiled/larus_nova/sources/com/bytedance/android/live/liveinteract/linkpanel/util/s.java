package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f75059a = null;

    static {
        f75059a = new s();
    }

    public s() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i("MultiLinkSettingPanelReuseManager", "preloadSettingPanelContainerCard cost=" + ((Long) r100));
    }
}
