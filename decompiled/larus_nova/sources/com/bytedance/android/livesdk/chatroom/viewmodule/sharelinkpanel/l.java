package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class l {
    public l() {
    }

    public abstract String b();

    public abstract int c();

    public abstract String d();

    public abstract String e();

    public boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (puc.a.isInstalledApp(r100, d()) == true) goto L6;
        return false;
    L6:
        return true;
    }
}
