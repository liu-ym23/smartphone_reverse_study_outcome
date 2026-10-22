package com.bytedance.android.live.room.navi.userinfo_p.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f100155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f100156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRoom f100157c;

    public c(DataCenter r100, IRoom r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f100156b = r100;
        this.f100157c = r101;
        this.f100155a = "UserInfoFollowLogUtil";
    }
}
