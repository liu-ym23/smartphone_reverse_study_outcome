package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f140296a;

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public final boolean a(PSFirstMessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        int r101 = this.f140296a;
        if ((r100.getStatusCode() & r101) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(PSFirstMessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        if (this.f140296a != 0) goto L5;
        ALogger.i("PS_FIRST_MESSAGE", "first message type: " + r100.name());
    L5:
        this.f140296a = r100.getStatusCode() | this.f140296a;
    }
}
