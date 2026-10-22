package com.bytedance.android.livesdk.chatroom.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements com.bytedance.android.livesdk.log.filter.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.log.b f114608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f114609b = null;

    public r() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f114609b = new r();
        f114608a = new com.bytedance.android.livesdk.log.b("DislikeParamsInjector", null);
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100.hashCode() == (-1103263308)) goto L6;
        return;
    L6:
        if (r100.equals("livesdk_dislike") == false) goto L9;
        r101.put("source_page", "native");
        f114608a.a("inject source_page native");
        return;
    }
}
