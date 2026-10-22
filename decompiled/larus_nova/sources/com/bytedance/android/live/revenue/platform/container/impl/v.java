package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonObject f91352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f91353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f91354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f91355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i57.a f91356e;

    public v(JsonObject r100, View r101, String r102, String r103, i57.g r104) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(r104, "aioCallContext");
        this.f91352a = r100;
        this.f91353b = r101;
        this.f91354c = r102;
        this.f91355d = r103;
        this.f91356e = r104;
    }
}
