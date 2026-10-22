package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o2 {
    public static final boolean a(m2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLinkRoom");
        if (r100.getParticipantRooms() == null) goto L15;
        List<IRoom> r101 = r100.getParticipantRooms();
        if (r101 == null) goto L10;
        if (r101.isEmpty() != true) goto L10;
        return false;
    L10:
        if (r100.getRoomScene() != 1) goto L12;
    L13:
        return true;
    L12:
        if (r100.getRoomScene() == 7) goto L13;
        return false;
    L15:
        return false;
    }
}
