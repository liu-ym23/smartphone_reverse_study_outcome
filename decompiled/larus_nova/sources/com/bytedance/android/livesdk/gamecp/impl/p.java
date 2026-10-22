package com.bytedance.android.livesdk.gamecp.impl;

import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p implements dw.k {
    public p() {
    }

    @Override // dw.k
    public final void dismissDialog(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        MatchRoomLandScapeAnimUtil.E.j(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dw.k
    public final void showDialog(String r100, DialogFragment r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r103 = -1;
        if ((r101 instanceof dw.b) == false) goto L5;
        int r104 = ((dw.b) r101).getActualContentWidth();
    L6:
        if (r104 > 0) goto L14;
        if (r102 != null) goto L10;
    L11:
        if (r102 == null) goto L13;
        r103 = r102.intValue();
    L13:
        r104 = r103;
        goto L14
    L10:
        if (r102.intValue() != (-1)) goto L11;
    L14:
        if (r104 > 0) goto L16;
        r104 = s1.f(375.0f);
    L16:
        boolean r105 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.y(r100, r101, Integer.valueOf(r104));
        return;
    L5:
        r104 = -1;
        goto L6
    }
}
