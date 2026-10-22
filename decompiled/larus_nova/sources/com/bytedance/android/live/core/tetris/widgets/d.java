package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveInteractOptConfig;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<LiveInteractOptConfig> f65980a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SettingKey<a0> f65981b = null;

    static {
        f65980a = new SettingKey("live_preload_interaction_switch", "直播间是否开启预加载交互层", new LiveInteractOptConfig(), new LiveInteractOptConfig(), false);
        f65981b = new SettingKey("live_widget_priority_split", "组件优先级打散", new a0(), new a0(), false);
    }

    @JvmStatic
    public static final boolean d() {
        return f65981b.getValue().a();
    }

    public static LiveInteractOptConfig f() {
        return f65980a.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        if (f().isTurnon() == true) goto L5;
    L7:
        return false;
    L5:
        if (f().getEnablePreEnter() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean b() {
        return f().isTurnon();
    }

    @JvmStatic
    public static final boolean c() {
        if (f().isTurnon() == true) goto L5;
    L7:
        return false;
    L5:
        if (f().getEnableWidgetLoadPriority() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("LiveInteractionOpt", r100);
    }

    @JvmStatic
    public static final void e(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "errorService");
        LocalTestManager.a(new Class[]{wy.a.class});
        JSONObject r102 = new JSONObject();
        Iterator r103 = ((HashMap) r101).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), r104.getValue());
        goto L4
    L6:
        LiveTracingMonitor.d(r100, LiveTracingMonitor.EventModule.INTERACTION_OPT, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r102);
    }
}
