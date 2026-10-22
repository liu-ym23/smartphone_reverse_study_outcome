package com.bytedance.android.livesdk.log;

import android.text.TextUtils;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.config.ju0;
import com.bytedance.android.livesdk.config.rk0;
import com.bytedance.android.livesdk.log.scope.ScopeLoggerLifeManagerService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.logsdk.format.Spm;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class LoggerLifeManagerService implements ILoggerLifeManagerService {
    private static final String PARAM_LIVE_PLATFORM = "_param_live_platform";
    private static final String PREFIX = "livesdk_";
    private static final String ROOM_ORIENTATION = "room_orientation";
    public static final String SDK_VERSION = "sdk_version";
    private h mConfig;
    private Set<String> noMappingEvents;

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void afterExecuteLogFilter() {
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getFakeTempMap() {
        return this.mConfig.getFakeTempMap();
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getMap() {
        return this.mConfig.getMap();
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter() {
        return this.mConfig.getSendLogFilter();
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public void initConfig() {
        this.mConfig.initConfig();
    }

    public LoggerLifeManagerService() {
        this.noMappingEvents = new CopyOnWriteArraySet();
        this.mConfig = new v();
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == false) goto L13;
        h r100 = this.mConfig;
        if ((r100 instanceof v) == false) goto L16;
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r101 = ((v) r100).f153447b;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.putAll(v.a());
    L16:
        ConcurrentHashMap<Class<? extends IService>, Object> r103 = jc1.k.f498081a;     // Catch: Exception -> L12
        if (r103.containsKey(ILoggerLifeManagerService.class) == true) goto L14;
        r103.put(ILoggerLifeManagerService.class, this);     // Catch: Exception -> L12
    L14:
        this.noMappingEvents.add("livesdk_draw_room_bottom");
        this.noMappingEvents.add("livesdk_show_next_room");
        return;
    L13:
        initConfig();
        jc1.k.l(ILoggerLifeManagerService.class, this);
        goto L14
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void beforeExecuteLogFilter(Map<String, String> r100) {
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r101 = this.mConfig.getMap();
        if (r101.containsKey(am2.d.class) == false) goto L6;
        r101.get(am2.d.class).a(r100);
    L6:
        if (r101.containsKey(am2.i.class) == false) goto L9;
        r101.get(am2.i.class).a(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public ILoggerLifeManagerService getNewInstance(String r100) {
        return new ScopeLoggerLifeManagerService(r100);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public boolean needDropEventBySampling(String r100) {
        qm0.a r101 = om0.c.d();
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.needDropEventBySampling(r100);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r100) {
        return this.mConfig.removeSendLogFilter(r100);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public <T> void unregister(Class<? extends T> r100) {
        this.mConfig.unregister(r100);
    }

    private void logEvent(String r100, Map<String, String> r101) {
        Spm r102 = Spm.obtain("a100.c100.d400");
        HashMap r103 = new HashMap();
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, String> r105 = r104.next();
        r103.put(r105.getKey(), r105.getValue());
        goto L4
    L6:
        r102.args(r103).businessId(r100).apply("tea_event");
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public boolean addSendLogFilter(Object r100, com.bytedance.android.livesdk.log.filter.v r101) {
        return this.mConfig.addSendLogFilter(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void afterSendAppLog(String r100, Map<String, String> r101) {
        ce1.d r102 = ce1.e.f23443a;
        if (r102 == null) goto L6;
        r102.b();
    L6:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        logEvent(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void beforeSendAppLog(String r100, Map<String, String> r101) {
        Map<Object, com.bytedance.android.livesdk.log.filter.v> r102 = this.mConfig.getSendLogFilter();
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r103 = this.mConfig.getMap();
        if (r101.containsKey("_param_live_platform") == true) goto L5;
        r101.put("_param_live_platform", "live");
    L5:
        r101.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r101.put(ROOM_ORIENTATION, j0.f153362d);
        Iterator<com.bytedance.android.livesdk.log.filter.v> r104 = r102.values().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r104.next().L9(r100, r101);
        goto L7
    L9:
        boolean r105 = false;
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r100.equals("livesdk_live_show") == false) goto L18;
        if (r101.containsKey(MonitorConstants.EXTRA_DOWNLOAD_PAGE) == false) goto L15;
        String r106 = r101.get(MonitorConstants.EXTRA_DOWNLOAD_PAGE);
    L15:
        if (r101.containsKey("event_module") == false) goto L24;
        String r107 = r101.get("event_module");
    L24:
        if (r101.containsKey("bypass_mapping") == false) goto L27;
        r105 = TextUtils.equals("true", r101.get("bypass_mapping"));
    L27:
        if (this.noMappingEvents.contains(r100) == true) goto L31;
        if (r105 == true) goto L31;
        Map<String, String> r108 = e0.f153286a;
    L31:
        if (ju0.f120553a.getValue().booleanValue() == false) goto L33;
    L34:
        String r109 = ee1.a.f472272a;
        ee1.a.a(r100, r101, r103.get(Room.class));
        return;
    L33:
        if (rk0.f121139a.getValue().booleanValue() == true) goto L34;
        return;
    L18:
        if (r101.containsKey("enter_from") == false) goto L21;
        String r110 = r101.get("enter_from");
    L21:
        if (r101.containsKey("source") == false) goto L24;
        String r111 = r101.get("source");
        goto L24
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public String onChangeEventName(boolean r100, String r101) {
        if (r101.startsWith("noLivePrefix") == false) goto L5;
        r101 = r101.split("noLivePrefix")[1];
        r100 = false;
    L5:
        if (r100 == true) goto L7;
        return r101;
    L7:
        if (r101.startsWith(PREFIX) == false) goto L9;
        return r101;
    L9:
        return PREFIX.concat(r101);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void onSendAppLog(String r100, Map<String, String> r101) {
        IHostLog r102 = (IHostLog) jc1.k.f(IHostLog.class);
        if (r102 == null) goto L6;
        r102.logV3(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public <T> void register(Class<? extends T> r100, com.bytedance.android.livesdk.log.filter.o<? extends T> r101) {
        this.mConfig.register(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void onExecuteLogFilter(Map<String, String> r100, Map<String, String> r101, Object... r102) {
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r103 = this.mConfig.getMap();
        if (r102 == null) goto L20;
        int r104 = r102.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L20;
        Object r106 = r102[r105];
        if (r106 == null) goto L19;
        if ((r106 instanceof Class) == false) goto L16;
        if (r103.containsKey(r106) == false) goto L19;
        r103.get(r106).a(r101);
        goto L19
    L16:
        if (r103.containsKey(r106.getClass()) == false) goto L19;
        ALogger.e("onExecuteLogFilter", "obj:" + r106);
        r103.get(r106.getClass()).u(r101, r106);
    L19:
        r105 = r105 + 1;
    L20:
        if (r100 != null) goto L22;
    L24:
        Map<String, String> r107 = n.f153409a;
        Intrinsics.checkNotNullParameter(r101, "map");
        Map<? extends String, ? extends String> r108 = n.b();
        if (r108 == null) goto L34;
        r101.putAll(r108);
        return;
    L34:
        return;
    L22:
        if (r100.size() <= 0) goto L24;
        r101.putAll(r100);
        goto L24
    }
}
