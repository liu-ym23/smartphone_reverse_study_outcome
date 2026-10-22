package com.bytedance.android.livesdk.chatroom.monitor;

import android.os.Looper;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.a9;
import com.bytedance.android.livesdk.utils.u;
import com.bytedance.android.livesdk.utils.v;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ActivityBaseTimeMonitor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f106993b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f106994a;

    public static final class a {
    }

    static {
    }

    public JSONObject a() {
        return null;
    }

    public abstract String b();

    public JSONObject c() {
        return null;
    }

    public abstract JSONObject e(Map<String, Long> r100);

    public final void g() {
        final LinkedHashMap r100 = new LinkedHashMap(this.f106994a);
        ((LinkedHashMap) this.f106994a).clear();
        int r101 = v.f159185a;
        Function0<Unit> r102 = new ActivityBaseTimeMonitor$stop$1(this, r100);
        Intrinsics.checkNotNullParameter(r102, "function");
        if (a9.f102999a.getValue().booleanValue() == true) goto L5;
    L7:
        r102.invoke();
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        Schedulers.computation().scheduleDirect(new u(r102));
    }

    public ActivityBaseTimeMonitor() {
        this.f106994a = new LinkedHashMap();
    }

    public void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (LiveInfraSettingKeys.LIVE_ACTIVIY_TIME_MONITOR_SWITCH.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        this.f106994a.put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    public static void f(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r100.put(r101, r102);     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
