package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class w1 {
    public static final boolean a(d90.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAnchor");
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L7;
        Boolean r102 = (Boolean) r101.get("data_is_anchor", Boolean.FALSE);
        if (r102 == null) goto L7;
        return r102.booleanValue();
    L7:
        return false;
    }

    public static final boolean b(d90.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLandscape");
        return !c(r100);
    }

    public static final boolean c(d90.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPortrait");
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L7;
        Boolean r102 = (Boolean) r101.get("data_is_portrait", Boolean.TRUE);
        if (r102 == null) goto L7;
        return r102.booleanValue();
    L7:
        return true;
    }

    public static final boolean d(d90.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVSRoom");
        IRoom r101 = e(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isMergeVSRoom();
    }

    public static final IRoom e(d90.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$vsRoom");
        DataCenter r101 = r100.f467480h;
        IRoom r102 = null;
        if (r101 == null) goto L5;
        IRoom r103 = (IRoom) r101.get("data_room");
    L6:
        DataCenter r104 = r100.f467480h;
        if (r104 == null) goto L10;
        r102 = (IRoom) r104.get("data_prepare_room");
    L10:
        if (r103 == null) goto L12;
        long r105 = r103.getId();
    L14:
        if (r105 <= 0) goto L17;
        return r103;
    L17:
        return r102;
    L12:
        r105 = 0;
        goto L14
    L5:
        r103 = null;
        goto L6
    }
}
