package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.livesdk.config.q4;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static q4 f121219a;

    public static final class a implements b70.a {
        public a() {
        }

        @Override // b70.a
        public final void onSuccess() {
            q4 r100 = w.f121219a;
            w.f121219a = b.f121220a.getValue();
            ALogger.i("SlowFuncOpt", "update live_enter_room_slow_fun_opt: " + w.f121219a);
        }
    }

    public static final class b extends SettingKey<q4> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f121220a = null;

        static {
            f121220a = new b();
        }

        public b() {
            super("live_enter_room_slow_fun_opt", "进房慢函数优化一期", new q4(), new q4());
        }
    }

    static {
        f121219a = b.f121220a.getValue();
        SettingIncStrategy.a(new a());
    }

    @JvmStatic
    public static final boolean a() {
        if (f121219a.a() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
