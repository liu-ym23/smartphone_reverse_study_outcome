package com.bytedance.applog.monitor.v3.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.m;
import com.bytedance.applog.monitor.v3.c;
import com.bytedance.applog.monitor.v3.f;
import com.bytedance.applog.monitor.v3.g;
import com.bytedance.applog.monitor.v3.h;
import com.bytedance.applog.monitor.v3.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SentryMonitor implements Handler.Callback {
    private static final int MSG_FLUSH = 4;
    private static final int MSG_LOAD_SP = 12;
    private static final int MSG_STAGE = 8;
    private static final long flushIntervalMs = 500;
    private static final List<String> logTags = null;
    private boolean acceptAllEvents;
    public final Map<String, a> cacheMap;
    private SharedPreferences cacheSp;
    private final c configManager;
    private boolean enabled;
    private Handler handler;
    private final AtomicBoolean hasInit;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private h f5811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.applog.monitor.v3.a f5812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5813c;

        static /* synthetic */ com.bytedance.applog.monitor.v3.a a(a r0) {
            return r0.f5812b;
        }

        static /* synthetic */ com.bytedance.applog.monitor.v3.a a(a r0, com.bytedance.applog.monitor.v3.a r1) {
            r0.f5812b = r1;
            return r1;
        }

        static /* synthetic */ boolean a(a r0, boolean r1) {
            r0.f5813c = r1;
            return r1;
        }

        static /* synthetic */ h b(a r0) {
            return r0.f5811a;
        }

        static /* synthetic */ boolean c(a r0) {
            return r0.f5813c;
        }

        public a(com.bytedance.applog.monitor.v3.a r2, h r3) {
            this.f5813c = false;
            this.f5812b = r2;
            this.f5811a = r3;
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("monitor_id", this.f5811a.f5802b);     // Catch: Throwable -> L19
            if (this.f5811a.f5804d == null) goto L7;
            r0.put("event_type", this.f5811a.f5804d.a());     // Catch: Throwable -> L19
        L7:
            if (TextUtils.isEmpty(this.f5811a.f5801a) == true) goto L10;
            r0.put("event", this.f5811a.f5801a);     // Catch: Throwable -> L19
        L10:
            if (this.f5811a.f5803c <= 0) goto L13;
            r0.put("local_time_ms", this.f5811a.f5803c);     // Catch: Throwable -> L19
        L13:
            if (TextUtils.isEmpty(this.f5811a.f5805e) == true) goto L16;
            r0.put("event_priority", this.f5811a.f5805e);     // Catch: Throwable -> L19
        L16:
            if (this.f5811a.f < 0) goto L18;
            r0.put("global_priority", this.f5811a.f);     // Catch: Throwable -> L19
        L18:
            return r0;
        }

        public long b() {
            h r2 = this.f5811a;
            if (r2 == null) goto L5;
            int r3 = r2.f5801a.length();
        L7:
            return r3 + 133;
        L5:
            r3 = 0;
            goto L7
        }

        public String c() {
            StringBuilder r0 = new StringBuilder().append("v3|");
            if (TextUtils.isEmpty(this.f5811a.f5805e) == false) goto L5;
            String r1 = "";
        L7:
            return r0.append(r1).append("|").append(this.f5811a.f).append("|").append(this.f5812b.name()).append("|").append(this.f5811a.f5801a).append("|").append(this.f5811a.f5803c).append("|").append(this.f5811a.f5804d.name()).toString();
        L5:
            r1 = this.f5811a.f5805e;
            goto L7
        }

        public static a a(String r17, String r18) {
            String r1 = null;
            if (TextUtils.isEmpty(r18) == false) goto L5;
            return null;
        L5:
            String[] r0 = r18.split("\\|");
            if (r0.length > 0) goto L8;
            return null;
        L8:
            if (r0[0].equals("v3") == false) goto L18;
            int r2 = -1;
            r2 = Integer.parseInt(r0[2]);     // Catch: Throwable -> L25
        L11:
            int r11 = r2;
            com.bytedance.applog.monitor.v3.a r3 = com.bytedance.applog.monitor.v3.a.valueOf(r0[3]);
            if (TextUtils.isEmpty(r0[1]) == true) goto L16;
            r1 = r0[1];
        L16:
            return new a(r3, new h(r1, r11, r0[4], r17, Long.parseLong(r0[5]), i.a(r0[6])));
        L18:
            if (r0.length != 4) goto L22;
            return new a(com.bytedance.applog.monitor.v3.a.valueOf(r0[0]), new h(r0[1], r17, Long.parseLong(r0[2]), i.f5806a));
        L22:
            if (r0.length == 5) goto L24;
            return null;
        L24:
            return new a(com.bytedance.applog.monitor.v3.a.valueOf(r0[0]), new h(r0[1], r17, Long.parseLong(r0[2]), i.a(r0[3])));
        }
    }

    static {
        logTags = Collections.singletonList("SentryMonitor");
    }

    public SentryMonitor(c r3) {
        this.cacheMap = Collections.synchronizedMap(new LinkedHashMap());
        this.enabled = true;
        this.acceptAllEvents = true;
        this.hasInit = new AtomicBoolean(false);
        this.configManager = r3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        int r0 = r3.what;
        if (r0 != 4) goto L5;
        flushToSp();
        return false;
    L5:
        if (r0 != 8) goto L7;
        addStage((a) ZeusTransformUtils.preCheckCast(r3.obj, a.class, "com.obric.aiagent.plugin"));
        return false;
    L7:
        if (r0 != 12) goto L16;
        loadSpData();
        return false;
    L16:
        return false;
    }

    public void initWithDisabled() {
        m.a().b(8, logTags, "init with disabled", new Object[0]);
        this.enabled = false;
        this.cacheMap.clear();
        this.hasInit.set(true);
    }

    public Pair<Map<String, a>, Long> getMapBySize(long r7) {
        if (this.cacheMap.isEmpty() == true) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, a> r1 = this.cacheMap;
        monitor-enter(r1);
        Iterator<Map.Entry<String, a>> r6 = this.cacheMap.entrySet().iterator();     // Catch: Throwable -> L16
    L10:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        r0.put(r2.getKey(), r3);     // Catch: Throwable -> L16
        r7 = r7 - r3.b();     // Catch: Throwable -> L16
        if (r7 >= 0) goto L10;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return new Pair(r0, Long.valueOf(r7));
    L16:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r7));
    }

    public void removeByMap(Map<String, a> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isEmpty() == true) goto L34;
        SharedPreferences.Editor r0 = null;
        SharedPreferences r1 = this.cacheSp;
        if (r1 == null) goto L10;
        r0 = r1.edit();
    L10:
        Map<String, a> r2 = this.cacheMap;
        monitor-enter(r2);
        Iterator r8 = r7.keySet().iterator();     // Catch: Throwable -> L22
    L14:
        if (r8.hasNext() == false) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        this.cacheMap.remove(r3);     // Catch: Throwable -> L22
        if (r0 == null) goto L14;
        r0.remove(r3);     // Catch: Throwable -> L22
        goto L14
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L22
        if (r0 == null) goto L33;
        r0.apply();
        return;
    L33:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void appendMapToJSONArray(Map<String, a> r6, JSONArray r7) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        HashMap r8 = new HashMap();
        Iterator r9 = r5.values().iterator();
    L7:
        if (r9.hasNext() == false) goto L12;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.aiagent.plugin");
        JSONArray r2 = (JSONArray) ZeusTransformUtils.preCheckCast(r8.get(a.a(r1)), JSONArray.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L11;
        r2 = new JSONArray();
        r8.put(a.a(r1), r2);
    L11:
        r2.put(r1.a());
        goto L7
    L12:
        JSONObject r10 = new JSONObject();
        r10.put("event", "sdk_stage");     // Catch: Throwable -> L20
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L20
        Iterator r11 = r8.entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r11.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        r3.put(((com.bytedance.applog.monitor.v3.a) ZeusTransformUtils.preCheckCast(r4.getKey(), com.bytedance.applog.monitor.v3.a.class, "com.obric.aiagent.plugin")).toString(), r4.getValue());     // Catch: Throwable -> L20
        goto L15
    L17:
        r10.put("params", r3);     // Catch: Throwable -> L20
        r10.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L20
        r10.put("event_id", f.b());     // Catch: Throwable -> L20
        r10.put("datetime", f.d());     // Catch: Throwable -> L20
    L18:
        r7.put(r10);
    }

    public void init(Context r8, HandlerThread r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.applog.log.f r0 = m.a();
        List<String> r1 = logTags;
        r0.b(8, r1, "init with prefix sp: {}.", new Object[]{r10});
        if (this.hasInit.compareAndSet(false, true) == true) goto L7;
        m.a().d(8, r1, "init failed for already initialized with sp prefix:{}.", new Object[]{r10});
        return;
    L7:
        if (this.configManager.h() == true) goto L10;
        m.a().b(8, r1, "init but disabled!!!", new Object[0]);
        this.acceptAllEvents = false;
        this.cacheMap.clear();
        this.enabled = false;
        return;
    L10:
        this.acceptAllEvents = g.a(this.configManager.i(), KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        m.a().b(8, r1, "sentry acceptAllEvents = {}", new Object[]{Boolean.valueOf(this.acceptAllEvents)});
        this.cacheSp = r11.getSharedPreferences(r10 + "@applog_monitor_sentry", 0);
        if (isAcceptAllEvents() == true) goto L13;
        resetCacheMap();
    L13:
        Handler r12 = new Handler(r9.getLooper(), this);
        this.handler = r12;
        r12.removeMessages(4);
        this.handler.sendEmptyMessageDelayed(4, 500);
        this.handler.sendEmptyMessageDelayed(12, Math.max(10000, this.configManager.f() - 10000) + ((long) new SecureRandom().nextInt(WsConstants.APP_STATE_CHANGE_SERVICE)));
    }

    public boolean isAcceptAllEvents() {
        if (this.acceptAllEvents == false) goto L5;
    L8:
        return true;
    L5:
        if (this.configManager.j() == true) goto L8;
        return false;
    }

    public void stage(String r13, int r14, com.bytedance.applog.monitor.v3.a r15, String r16, String r17, long r18, i r20) {
        if (this.enabled == true) goto L5;
    L14:
        m.a().b(8, logTags, "stage nothing for disabled!!!", new Object[0]);
        return;
    L5:
        if (this.configManager.h() == false) goto L14;
        a r1 = new a(r15, new h(r13, r14, r16, r17, r18, r20));
        if (this.handler != null) goto L10;
    L12:
        addStage(r1);
        return;
    L10:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L12;
        Handler r0 = this.handler;
        r0.sendMessage(r0.obtainMessage(8, r1));
    }

    private void addStage(a r7) {
        m.a().b(8, logTags, "start handle stage ({})", new Object[]{r7});
        Map<String, a> r0 = this.cacheMap;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (isEventMaybeAccepted(a.b(r7).f5801a) == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L8:
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.cacheMap.get(a.b(r7).f5802b), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r1 != null) goto L11;
        this.cacheMap.put(a.b(r7).f5802b, r7);     // Catch: Throwable -> L19
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L19
        Handler r8 = this.handler;
        if (r8 == null) goto L23;
        r8.removeMessages(4);
        this.handler.sendEmptyMessageDelayed(4, 500);
        return;
    L23:
        return;
    L11:
        a.a(r1, false);     // Catch: Throwable -> L19
        a.b(r1).a(a.b(r7));     // Catch: Throwable -> L19
        if (a.a(r7).ordinal() <= a.a(r1).ordinal()) goto L14;
        a.a(r1, a.a(r7));     // Catch: Throwable -> L19
        goto L14
    }

    private void flushToSp() {
        m.a().b(8, logTags, "start flush cache map (size={}) to sp...", new Object[]{Integer.valueOf(this.cacheMap.size())});
        SharedPreferences.Editor r0 = this.cacheSp.edit();
        Map<String, a> r1 = this.cacheMap;
        monitor-enter(r1);
        Iterator<Map.Entry<String, a>> r2 = this.cacheMap.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L12;
        a r4 = (a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (a.c(r4) == true) goto L6;
        if (isEventMaybeAccepted(a.b(r4).f5801a) == false) goto L6;
        r0.putString(a.b(r4).f5802b, r4.c());     // Catch: Throwable -> L15
        a.a(r4, true);     // Catch: Throwable -> L15
        goto L6
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L15
        r0.putLong("uptime", System.currentTimeMillis());
        r0.apply();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void loadSpData() {
        if (this.cacheSp != null) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "start load cache map from sp...", new Object[0]);
        long r0 = this.cacheSp.getLong("uptime", 0);
        if (r0 > 0) goto L8;
    L11:
        Map<String, ?> r1 = this.cacheSp.getAll();
        if (r1.isEmpty() == false) goto L14;
        return;
    L14:
        Map<String, a> r2 = this.cacheMap;
        monitor-enter(r2);
        Iterator<Map.Entry<String, ?>> r3 = r1.entrySet().iterator();     // Catch: Throwable -> L30
    L18:
        if (r3.hasNext() == false) goto L28;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r5) == true) goto L18;
        if ("uptime".equals(r5) == true) goto L18;
        a r6 = a.a(r5, (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
        if (r6 == null) goto L18;
        a.a(r6, true);     // Catch: Throwable -> L30
        this.cacheMap.put(a.b(r6).f5802b, r6);     // Catch: Throwable -> L30
        goto L18
    L28:
        monitor-exit(r2);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L8:
        if ((System.currentTimeMillis() - r0) <= TimeUnit.DAYS.toMillis(this.configManager.g())) goto L11;
        this.cacheSp.edit().clear().apply();
    }

    public boolean isEventHitSampling(String r3) {
        if (isAcceptAllEvents() == false) goto L5;
        return true;
    L5:
        if (this.hasInit.get() == true) goto L8;
        return true;
    L8:
        if (isEventMaybeAccepted(r3) == true) goto L10;
        return false;
    L10:
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.configManager.k().get(r3), Integer.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L13;
    L17:
        return false;
    L13:
        if (r2.intValue() <= 0) goto L17;
        return g.a(r2.intValue(), KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
    }

    public boolean isEventMaybeAccepted(String r2) {
        if (isAcceptAllEvents() == false) goto L7;
        return true;
    L7:
        if (this.configManager.k() != null) goto L11;
        return false;
    L11:
        return this.configManager.k().containsKey(r2);
    }

    private void resetCacheMap() {
        if (this.cacheMap.isEmpty() == false) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "start reset cache map...", new Object[0]);
        if (isAcceptAllEvents() == false) goto L8;
    L13:
        Map<String, a> r0 = this.cacheMap;
        monitor-enter(r0);
        Iterator<Map.Entry<String, a>> r1 = this.cacheMap.entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r1.hasNext() == false) goto L21;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (isEventMaybeAccepted(a.b((a) ZeusTransformUtils.preCheckCast(r2.getValue(), a.class, "com.obric.aiagent.plugin")).f5801a) == true) goto L17;
        this.cacheMap.remove(r2.getKey());     // Catch: Throwable -> L23
        goto L17
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L8:
        if (this.configManager.k() != null) goto L10;
    L11:
        this.cacheMap.clear();
        return;
    L10:
        if (this.configManager.k().isEmpty() == false) goto L13;
        goto L11
    }
}
