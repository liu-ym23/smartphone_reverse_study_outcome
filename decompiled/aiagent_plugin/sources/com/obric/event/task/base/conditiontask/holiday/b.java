package com.obric.event.task.base.conditiontask.holiday;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HolidayKevaManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32694a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Keva f32695b = null;

    private b() {
    }

    static {
        f32694a = new b();
        f32695b = Keva.getRepo("obric_holiday_prefs");
    }

    public final int a(Context r2, int r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        return f32695b.getInt("key_holidays_lastest_year", r3);
    }

    public final void b(Context r2, int r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        f32695b.storeInt("key_holidays_lastest_year", r3);
    }

    public final long a(Context r2, long r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        return f32695b.getLong("key_last_time_checked", r3);
    }

    public final void b(Context r2, long r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        f32695b.storeLong("key_last_time_checked", r3);
    }
}
