package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util;

import com.bytedance.android.livesdk.chatroom.l;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.live.datacontext.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class MultiCameraChangedLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159778a = 0;

    static {
    }

    public static void a(final Map r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        j<l> r101 = r.l().h(null);
        if (r101 == null) goto L6;
        r101.c(new MultiCameraChangedLogger$logContentUpdate$1(r100));
        return;
    }

    public static void b(final Map r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        j<l> r101 = r.l().h(null);
        if (r101 == null) goto L6;
        r101.c(new MultiCameraChangedLogger$logUpdate$1(r100));
        return;
    }
}
