package com.bytedance.android.livesdk.chatroom.helper;

import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b4\u00105J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0016\u0010\u0010\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J0\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\u0018\u0010$\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R,\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070(0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u001e\u0010.\u001a\f\u0012\b\u0012\u00060-R\u00020\u00000,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010*R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010*¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/helper/LiveUserInterfaceTracer;", "Lcom/bytedance/android/livesdkapi/service/ILiveUxTracer;", "", "sceneStart", "msStart", "sceneEnd", "msEnd", "", "getCustomSceneDurationMs", "Lorg/json/JSONObject;", "generateCategoryJson", "generateMetricsJson", "processSceneStartEndDurations", "Lkotlin/Function0;", "", "callback", "setBeforeReportCallback", "key", "", "value", "setArgument", "getArgument", "scene", "start", "end", "getSceneDurationMs", "milestone", "recordTimeStamp", "getTimeStamp", "name", "milestoneStart", "mileStoneEnd", "markDurationForReport", "report", BasicTestActionHandler.TEST_ACTION_RESET, "durationMs", "traceDirectDuration", "getDirectDuration", "recordSingleTimeStamp", "getSingleTimeStamp", "", "scenePhaseTimeStamp", "Ljava/util/Map;", "arguments", "", "Lcom/bytedance/android/livesdk/chatroom/helper/LiveUserInterfaceTracer$a;", "customReportDurations", "Ljava/util/List;", "directMarkedDurations", "_beforeReportCallback", "Lkotlin/jvm/functions/Function0;", "singlePhaseTimestamp", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveUserInterfaceTracer implements ILiveUxTracer {
    private Function0<Unit> _beforeReportCallback;
    private final Map<String, Object> arguments;
    private final List<a> customReportDurations;
    private final Map<String, Long> directMarkedDurations;
    private final Map<String, Map<String, Long>> scenePhaseTimeStamp;
    private final Map<String, Long> singlePhaseTimestamp;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f106411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f106412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f106413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f106414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f106415e;

        public a(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "scene1");
            Intrinsics.checkNotNullParameter(r102, "milestone1");
            Intrinsics.checkNotNullParameter(r103, "scene2");
            Intrinsics.checkNotNullParameter(r104, "milestone2");
            this.f106411a = r100;
            this.f106412b = r101;
            this.f106413c = r102;
            this.f106414d = r103;
            this.f106415e = r104;
        }
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public void reset() {
        LocalTestManager.a(new Class[]{wy.a.class});
        this.arguments.clear();
        this.scenePhaseTimeStamp.clear();
        this.customReportDurations.clear();
        this.directMarkedDurations.clear();
        this.singlePhaseTimestamp.clear();
    }

    private final JSONObject generateCategoryJson() {
        JSONObject r100 = new JSONObject();
        Object r101 = getArgument("is_commerce_room");
        if (r101 == null) goto L5;
        r100.put("is_commerce_room", r101);
    L5:
        Object r102 = getArgument("first_after_app_launch");
        if (r102 == null) goto L8;
        r100.put("first_after_app_launch", r102);
    L8:
        Object r103 = getArgument("slide_container_create");
        if (r103 == null) goto L11;
        r100.put("slide_container_create", r103);
    L11:
        return r100;
    }

    private final JSONObject processSceneStartEndDurations() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, Map<String, Long>>> r101 = this.scenePhaseTimeStamp.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L16;
        Map.Entry<String, Map<String, Long>> r102 = r101.next();
        String r103 = r102.getKey();
        Map<String, Long> r104 = r102.getValue();
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L4;
        long r106 = getSceneDurationMs(r103, "start", "end");
        if (r106 < 0) goto L4;
        r100.put(r103, r106);
        goto L4
    L8:
        if (r104.isEmpty() == true) goto L11;
        r105 = false;
        goto L12
    L16:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public void report() {
        Function0<Unit> r100 = this._beforeReportCallback;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke();
    L5:
        this._beforeReportCallback = null;
        LiveTracingMonitor.e("ttlive_enter_room_ux_trace", LiveTracingMonitor.EventModule.ENTER_ROOM, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, generateCategoryJson(), generateMetricsJson(), new JSONObject());
        reset();
    }

    public LiveUserInterfaceTracer() {
        this.scenePhaseTimeStamp = new LinkedHashMap();
        this.arguments = new LinkedHashMap();
        this.customReportDurations = new ArrayList();
        this.directMarkedDurations = new LinkedHashMap();
        this.singlePhaseTimestamp = new LinkedHashMap();
    }

    private final JSONObject generateMetricsJson() {
        JSONObject r100 = processSceneStartEndDurations();
        Iterator<T> r101 = this.customReportDurations.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        a r102 = (a) r101.next();
        long r103 = getCustomSceneDurationMs(r102.f106412b, r102.f106413c, r102.f106414d, r102.f106415e);
        if (r103 < 0) goto L4;
        r100.put(r102.f106411a, r103);
        goto L4
    L8:
        Iterator<Map.Entry<String, Long>> r104 = this.directMarkedDurations.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        Map.Entry<String, Long> r105 = r104.next();
        r100.put(r105.getKey(), r105.getValue().longValue());
        goto L10
    L12:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public Object getArgument(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.arguments.get(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public long getDirectDuration(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Long r101 = this.directMarkedDurations.get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.longValue();
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public long getSingleTimeStamp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Long r101 = this.singlePhaseTimestamp.get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.longValue();
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public void recordSingleTimeStamp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.singlePhaseTimestamp.put(r100, Long.valueOf(SystemClock.uptimeMillis()));
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public void setBeforeReportCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this._beforeReportCallback = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public long getTimeStamp(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "milestone");
        Map<String, Long> r102 = this.scenePhaseTimeStamp.get(r100);
        if (r102 == null) goto L7;
        Long r103 = r102.get(r101);
        if (r103 == null) goto L7;
        return r103.longValue();
    L7:
        return 0;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public void recordTimeStamp(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "milestone");
        Map<String, Long> r102 = this.scenePhaseTimeStamp.get(r100);
        if (r102 != null) goto L5;
        r102 = new HashMap(2);
        this.scenePhaseTimeStamp.put(r100, r102);
    L5:
        r102.put(r101, Long.valueOf(SystemClock.uptimeMillis()));
        ALogger.d("LiveUxTracer", r100 + ", " + r101 + ": " + r102.get(r101));
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public void setArgument(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L5;
        this.arguments.put(r100, r101);
        return;
    L5:
        this.arguments.remove(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public void traceDirectDuration(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        if (r101 < 0) goto L10;
        this.directMarkedDurations.put(r100, Long.valueOf(r101));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public long getSceneDurationMs(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "start");
        Intrinsics.checkNotNullParameter(r102, "end");
        return getCustomSceneDurationMs(r100, r101, r100, r102);
    }

    private final long getCustomSceneDurationMs(String r100, String r101, String r102, String r103) {
        Map<String, Long> r104 = this.scenePhaseTimeStamp.get(r100);
        if (r104 == null) goto L15;
        Long r105 = r104.get(r101);
        if (r105 == null) goto L15;
        long r106 = r105.longValue();
        Map<String, Long> r107 = this.scenePhaseTimeStamp.get(r102);
        if (r107 == null) goto L15;
        Long r108 = r107.get(r103);
        if (r108 == null) goto L15;
        long r109 = r108.longValue() - r106;
        if (r109 <= 0) goto L14;
        return r109;
    L14:
        return 0;
    L15:
        return -1;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveUxTracer
    public void markDurationForReport(String r100, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r110, "sceneStart");
        Intrinsics.checkNotNullParameter(r111, "milestoneStart");
        Intrinsics.checkNotNullParameter(r112, "sceneEnd");
        Intrinsics.checkNotNullParameter(r113, "mileStoneEnd");
        this.customReportDurations.add(new a(r100, r110, r111, r112, r113));
    }
}
