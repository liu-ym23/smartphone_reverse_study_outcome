package com.bytedance.android.livesdk.log.filter;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u0 implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f153346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f153347b;

    public static final class a {
    }

    public u0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f153346a = true;
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = r100.hashCode();
        if (r102 == (-1284480695)) goto L11;
        if (r102 == (-773966155)) goto L8;
        return;
    L8:
        if (r100.equals("livesdk_live_leave") == false) goto L16;
        r101.put("duration_session", String.valueOf(System.currentTimeMillis() - f153347b));
        f153346a = true;
        f153347b = 0;
        return;
    L16:
        return;
    L11:
        if (r100.equals("livesdk_room_enter_success") == true) goto L13;
        return;
    L13:
        if (f153346a == false) goto L19;
        f153347b = System.currentTimeMillis();
        f153346a = false;
        return;
    }
}
