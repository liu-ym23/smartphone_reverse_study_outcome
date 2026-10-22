package com.bytedance.android.livesdk.widget.schedule.v2;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("ttlive_descriptor_load_new", r100);
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        a("name: FragmentAction; msg: ".concat(r100));
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        a("name: LiveWidgetLoadTaskInOrder; msg: " + r100);
    }

    @JvmStatic
    public static final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        a("name: LiveWidgetLoadTaskTogether; msg: ".concat(r100));
    }

    @JvmStatic
    public static final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        a("name: LiveWidgetLoadTaskTrigger; msg: ".concat(r100));
    }
}
