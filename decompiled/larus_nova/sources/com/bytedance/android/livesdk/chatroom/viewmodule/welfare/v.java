package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WelfareLandscapeCardWindow f117665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f117666b;

    public v(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f117666b = r100;
        this.f117665a = new WelfareLandscapeCardWindow(r100);
    }
}
