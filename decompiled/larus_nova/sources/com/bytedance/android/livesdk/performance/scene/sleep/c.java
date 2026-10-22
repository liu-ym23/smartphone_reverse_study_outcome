package com.bytedance.android.livesdk.performance.scene.sleep;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f154800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f154801b;

    public static final class a {
    }

    static {
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = r100.what;
        if (r101 != 1) goto L5;
        ALogger.d(this.f154800a, "handleMessage, EVENT_CHECK_START");
        boolean r102 = SleepMode.f154768a;
        SleepMode.d();
        return;
    L5:
        if (r101 != 2) goto L7;
        ALogger.d(this.f154800a, "handleMessage, EVENT_CHECK_END");
        boolean r103 = SleepMode.f154768a;
        SleepMode.e();
        return;
    L7:
        if (r101 != 3) goto L9;
        ALogger.d(this.f154800a, "handleMessage, EVENT_CHECK_WHEN_ENV_CHANGE");
        boolean r104 = SleepMode.f154768a;
        if (SleepMode.f154776i == false) goto L17;
        boolean r105 = SleepMode.e();
    L18:
        if (r105 == true) goto L29;
        b r106 = this.f154801b;
        if (r106 == null) goto L30;
        ALogger.d(r106.f154786a, "envChanged");
        if (r106.f154790e == false) goto L31;
        r106.a();
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L17:
        r105 = SleepMode.d();
        goto L18
    L9:
        if (r101 != 4) goto L34;
        ALogger.d(this.f154800a, "handleMessage, EVENT_CHECK_ACTION");
        b r107 = this.f154801b;
        if (r107 == null) goto L27;
        r107.a();
        return;
    L27:
        return;
    }

    public c(Looper r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "looper");
        Intrinsics.checkNotNullParameter(r101, "action");
        super(r100);
        this.f154800a = "LiveSleep_Handler";
        this.f154801b = r101;
    }
}
