package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, Class r101) {
            r100.start(r101, MapsKt.emptyMap());
        }
    }

    boolean isDestroyed();

    void start(Class<? extends com.bytedance.android.livesdk.chatroom.vs_base.base.api.a> r100, Map<String, ? extends Object> r101);
}
