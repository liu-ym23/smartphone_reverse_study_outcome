package com.bytedance.android.livesdk.message.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class n8 {
    public static final long a(MusicInterval r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$end");
        return r100.getStartMs() + r100.getDurationMs();
    }

    public static final String b(b8 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$idString");
        String r101 = r100.getIdStr();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L10:
        boolean r103 = false;
    L11:
        String r104 = null;
        if (r103 == true) goto L15;
        r101 = null;
    L15:
        if (r101 != null) goto L28;
        r101 = r100.getOpenId();
        if (r101 != null) goto L19;
    L24:
        if (r102 == true) goto L27;
        r101 = null;
    L27:
        if (r101 != null) goto L28;
    L29:
        if (r104 == null) goto L31;
        return r104;
    L31:
        return String.valueOf(r100.getId());
    L19:
        if (r101.length() <= 0) goto L21;
        boolean r105 = true;
    L22:
        if (r105 != true) goto L24;
        r102 = true;
        goto L24
    L21:
        r105 = false;
    L28:
        r104 = r101;
        goto L29
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 != true) goto L10;
        r103 = true;
        goto L11
    L7:
        r106 = false;
        goto L8
    }
}
