package com.bytedance.android.livesdk.vscore_api.paidlive.scope;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f159506a = null;

    static {
        f159506a = new e();
    }

    public e() {
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        StringBuilder r100 = new StringBuilder("getPaidManagerService no param return active scope:");
        LinkedHashMap<String, b> r101 = f.f159507a;
        b r102 = f.f159509c;
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.g());
    L6:
        r100.append(r103);
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }
}
