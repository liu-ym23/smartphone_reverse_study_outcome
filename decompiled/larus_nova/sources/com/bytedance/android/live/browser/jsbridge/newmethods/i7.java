package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f63449b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f63450a;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (ContextCompat.checkSelfPermission(this.f63450a, "android.permission.WRITE_CALENDAR") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Context getContext() {
        return this.f63450a;
    }

    public i7(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f63450a = r100;
        com.bytedance.timon.calendar.c.b(r100);
    }
}
