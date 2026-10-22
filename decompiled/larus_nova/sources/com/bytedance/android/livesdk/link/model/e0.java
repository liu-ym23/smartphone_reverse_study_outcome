package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e0 {
    public static final long a(b0 r100) {
        if (r100 == null) goto L11;
        c0 r101 = r100.getConfig();
        if (r101 != null) goto L8;
        return 10;
    L8:
        if (r101.getInviteLimitSec() > 0) goto L10;
        return 10;
    L10:
        return r101.getInviteLimitSec();
    L11:
        return 10;
    }

    public static final String b(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toSimpleString");
        StringBuilder r101 = new StringBuilder("AutoMatchInfo{waitSec=");
        r101.append(r100.getWaitSec());
        r101.append(", accelerateLimit=");
        r101.append(r100.getAccelerateLimit());
        r101.append(", defaultWaitLimit=");
        r101.append(r100.getDefaultWaitLimit());
        r101.append(", inviteLimitSec=");
        c0 r102 = r100.getConfig();
        Long r103 = null;
        if (r102 == null) goto L5;
        Long r104 = Long.valueOf(r102.getInviteLimitSec());
    L6:
        r101.append(r104);
        r101.append(", pkAutoMatchIndex=");
        c0 r105 = r100.getConfig();
        if (r105 == null) goto L9;
        r103 = Long.valueOf(r105.getPkAutoMatchIndex());
    L9:
        r101.append(r103);
        r101.append(", mainTitle=");
        r101.append(r100.getMainTitle());
        r101.append('}');
        return r101.toString();
    L5:
        r104 = null;
        goto L6
    }
}
