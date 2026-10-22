package com.bytedance.android.livesdk.chatroom.paidlive;

import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f107573a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        g r102 = u.l();
        if (r101 != null) goto L5;
        r101 = MapsKt.emptyMap();
    L5:
        r102.sendLog(r100, r101, new Object[0]);
    }
}
