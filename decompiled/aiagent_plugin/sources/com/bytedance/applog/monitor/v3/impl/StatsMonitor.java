package com.bytedance.applog.monitor.v3.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.m;
import com.bytedance.applog.monitor.v3.c;
import com.bytedance.applog.monitor.v3.f;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StatsMonitor implements Handler.Callback {
    private static final int MSG_FLUSH = 8;
    private static final int MSG_INCREASE = 16;
    private static final int MSG_LOAD_SP = 24;
    private static final long flushIntervalMs = 500;
    private static final List<String> logTags = null;
    private final c configManager;
    private final Map<String, Integer> countMap;
    private boolean enabled;
    private Handler handler;
    private SharedPreferences sp;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5815b;

        static /* synthetic */ String a(a r0) {
            return r0.f5814a;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f5815b;
        }

        public a(String r1, int r2) {
            this.f5814a = r1;
            this.f5815b = r2;
        }
    }

    static {
        logTags = Collections.singletonList("StatsMonitor");
    }

    public StatsMonitor(c r2) {
        this.enabled = true;
        this.countMap = new ConcurrentHashMap();
        this.configManager = r2;
    }

    public void init(Context r3, HandlerThread r4, String r5) {
        this.sp = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(r5 + "@applog_monitor_stats", 0);
        Handler r6 = new Handler(r4.getLooper(), this);
        this.handler = r6;
        r6.removeMessages(8);
        this.handler.sendEmptyMessageDelayed(8, 500);
        this.handler.sendEmptyMessageDelayed(24, Math.max(10000, this.configManager.f() - 10000) + new SecureRandom().nextInt(WsConstants.APP_STATE_CHANGE_SERVICE));
    }

    public void initWithDisabled() {
        this.enabled = false;
        this.countMap.clear();
    }

    public Pair<Map<String, Integer>, Long> getMapBySize(long r7) {
        if (this.countMap.isEmpty() == false) goto L7;
        return new Pair(null, Long.valueOf(r7));
    L7:
        return new Pair(new HashMap(this.countMap), Long.valueOf(r7 - (((long) this.countMap.size()) * 30)));
    }

    public void removeByMap(Map<String, Integer> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.isEmpty() == true) goto L39;
        Map<String, Integer> r0 = this.countMap;
        monitor-enter(r0);
        Iterator r10 = r9.entrySet().iterator();     // Catch: Throwable -> L25
    L11:
        if (r10.hasNext() == false) goto L22;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1.getValue() == null) goto L15;
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r1.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L25
    L16:
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(this.countMap.get(r2), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r4 == null) goto L11;
        int r5 = Math.max(0, r4.intValue() - r3);     // Catch: Throwable -> L25
        if (r5 == 0) goto L20;
        this.countMap.put(r2, Integer.valueOf(r5));     // Catch: Throwable -> L25
        goto L11
    L20:
        this.countMap.remove(r2);     // Catch: Throwable -> L25
        goto L11
    L15:
        r3 = 0;
        goto L16
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L25
        this.handler.removeMessages(8);
        this.handler.sendEmptyMessageDelayed(8, 500);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public void appendMapToJSONArray(Map<String, Integer> r7, JSONArray r8) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r9 = new JSONObject();
        r9.put("event", "sdk_stats");     // Catch: Throwable -> L16
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L16
        Iterator r10 = r6.entrySet().iterator();     // Catch: Throwable -> L16
    L8:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r3 == null) goto L8;
        if (r3.intValue() <= 0) goto L8;
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r3);     // Catch: Throwable -> L16
        goto L8
    L14:
        r9.put("params", r1);     // Catch: Throwable -> L16
        r9.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L16
        r9.put("event_id", f.b());     // Catch: Throwable -> L16
        r9.put("datetime", f.d());     // Catch: Throwable -> L16
    L18:
        r8.put(r9);
        return;
    L16:
        th = move-exception;
        m.a().a(8, logTags, "appendMapToJSONArray failed", th, new Object[0]);
        goto L18
    }

    public void increase(String r3, int r4) {
        if (this.enabled == true) goto L5;
        return;
    L5:
        a r0 = new a(r3, r4);
        Handler r5 = this.handler;
        if (r5 == null) goto L8;
        r5.sendMessageDelayed(r5.obtainMessage(16, r0), 16);
        return;
    L8:
        increaseMapCount(r0);
    }

    public Map<String, Integer> getMap() {
        return new HashMap(this.countMap);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        int r0 = r3.what;
        if (r0 != 8) goto L5;
        flush2Sp();
        return false;
    L5:
        if (r0 != 16) goto L7;
        increaseMapCount((a) ZeusTransformUtils.preCheckCast(r3.obj, a.class, "com.obric.aiagent.plugin"));
        return false;
    L7:
        if (r0 != 24) goto L16;
        mergeSpData();
        return false;
    L16:
        return false;
    }

    private void increaseMapCount(a r5) {
        Map<String, Integer> r0 = this.countMap;
        monitor-enter(r0);
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.countMap.get(a.a(r5)), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r1 == null) goto L7;
        int r2 = r1.intValue();     // Catch: Throwable -> L14
    L8:
        int r3 = r2 + a.b(r5);     // Catch: Throwable -> L14
        this.countMap.put(a.a(r5), Integer.valueOf(r3));     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Handler r6 = this.handler;
        if (r6 == null) goto L19;
        r6.removeMessages(8);
        this.handler.sendEmptyMessageDelayed(8, 500);
        return;
    L19:
        return;
    L7:
        r2 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    private void mergeSpData() {
        SharedPreferences r0 = this.sp;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = r0.getLong("uptime", 0);
        if (r1 > 0) goto L8;
    L11:
        Map<String, ?> r2 = this.sp.getAll();
        if (r2.isEmpty() == false) goto L14;
        return;
    L14:
        Map<String, Integer> r3 = this.countMap;
        monitor-enter(r3);
        Iterator<Map.Entry<String, ?>> r4 = r2.entrySet().iterator();     // Catch: Throwable -> L37
    L18:
        if (r4.hasNext() == false) goto L32;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r6) == true) goto L18;
        if ("uptime".equals(r5.getKey()) == true) goto L18;
        if (r5.getValue() == null) goto L27;
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r5.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L37
    L28:
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(this.countMap.get(r6), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r8 == null) goto L30;
        this.countMap.put(r6, Integer.valueOf(r7 + r8.intValue()));     // Catch: Throwable -> L37
        goto L18
    L30:
        this.countMap.put(r6, Integer.valueOf(r7));     // Catch: Throwable -> L37
        goto L18
    L27:
        r7 = 0;
        goto L28
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L37
        Handler r9 = this.handler;
        if (r9 == null) goto L53;
        r9.removeMessages(8);
        this.handler.sendEmptyMessageDelayed(8, 500);
        return;
    L53:
        return;
    L37:
        th = move-exception;
        throw th;
    L8:
        if ((System.currentTimeMillis() - r1) <= TimeUnit.DAYS.toMillis(this.configManager.g())) goto L11;
        this.sp.edit().clear().apply();
    }

    private void flush2Sp() {
        SharedPreferences.Editor r0 = this.sp.edit();
        r0.clear();
        Map<String, Integer> r1 = this.countMap;
        monitor-enter(r1);
        Iterator<Map.Entry<String, Integer>> r6 = this.countMap.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r2.getValue() == null) goto L10;
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L15
    L11:
        r0.putInt(r3, r4);     // Catch: Throwable -> L15
        goto L6
    L10:
        r4 = 0;
        goto L11
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L15
        r0.putLong("uptime", System.currentTimeMillis());
        r0.apply();
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
