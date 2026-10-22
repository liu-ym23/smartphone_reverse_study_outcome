package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.bytedance.android.livesdk.config.setting.w;
import com.bytedance.android.livesdk.config.wu0;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f116799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f116800b;

    public c() {
        Boolean r100 = w.f121219a.b();
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        this.f116799a = r101;
        this.f116800b = (List) wu0.f121554a.getValue();
        return;
    L5:
        r101 = false;
        goto L6
    }
}
