package com.bytedance.apm.perf;

import com.bytedance.apm.util.i;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.services.slardar.config.IConfigManager;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.services.slardar.config.a {
    private static final String TAG = "PerfConfigManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Boolean> f4790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f4791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f4792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f4793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f4794e;
    private Map<String, String> f;
    private volatile JSONObject g;

    /* JADX INFO: renamed from: com.bytedance.apm.perf.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: PerfConfigManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: PerfConfigManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f4795a = null;

        static /* synthetic */ c a() {
            return f4795a;
        }

        static {
            f4795a = new c(null);
        }
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
    }

    /* synthetic */ c(AnonymousClass1 r1) {
        this();
    }

    private c() {
        this.f4790a = new ConcurrentHashMap();
        this.f4791b = new ConcurrentHashMap();
        this.f = new HashMap();
        LinkedList r0 = new LinkedList();
        this.f4792c = r0;
        r0.addAll(Arrays.asList(new String[]{Scraps.BATTERY, "smooth", MonitorConstants.CPU, "disk", "memory", "thread", "fd", "page_load", "page_load_trace", "start", "start_trace", "traffic", "ui"}));
        ArrayList r1 = new ArrayList();
        this.f4793d = r1;
        r1.add("enable_upload");
        this.f4793d.add("drop_enable_upload");
        this.f4793d.add("serious_block_enable_upload");
        this.f4793d.add("block_enable_upload");
        this.f4793d.add("slow_method_enable_upload");
        LinkedList r2 = new LinkedList();
        this.f4794e = r2;
        r2.add("enable_perf_data_collect");
        this.f.put("enable_upload", "fps");
        this.f.put("drop_enable_upload", "fps_drop");
        this.f.put("block_enable_upload", "block_monitor");
        this.f.put("slow_method_enable_upload", "drop_frame_stack");
        this.f.put("serious_block_enable_upload", "serious_block_monitor");
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin")).registerConfigListener(this);
    }

    public static c a() {
        return a.a();
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        a(r1);
    }

    private void a(JSONObject r6) {
        JSONObject r7 = r6.optJSONObject("performance_modules");
        if (r7 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.f4792c.iterator();
    L7:
        if (r0.hasNext() == false) goto L29;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        JSONObject r3 = r7.optJSONObject(r1);
        if ("smooth".equals(r1) == true) goto L10;
        if ("memory".equals(r1) == false) goto L15;
        d(r3);
    L15:
        if (Scraps.BATTERY.equals(r1) == false) goto L18;
        e(r3);
    L18:
        if (MonitorConstants.CPU.equals(r1) == false) goto L21;
        f(r3);
    L21:
        if ("start_trace".equals(r1) == false) goto L24;
        b(r3);
    L24:
        if (r3 == null) goto L28;
        if (r3.optInt("enable_upload", 0) != 1) goto L28;
        this.f4790a.put(r1, true);
    L28:
        this.f4790a.put(r1, false);
        goto L7
    L10:
        c(r3);
        goto L7
    L29:
        this.g = i.a(r7, "smooth", "scene_enable_upload");
    }

    private void b(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = this.f4794e.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        Map<String, Boolean> r2 = this.f4791b;     // Catch: Exception -> L13
        boolean r3 = false;
        if (r7.optInt(r1, 0) != 1) goto L11;
        r3 = true;
    L11:
        r2.put(r1, Boolean.valueOf(r3));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void c(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = this.f4793d.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        Map<String, Boolean> r2 = this.f4791b;     // Catch: Exception -> L13
        String r3 = this.f.get(r1);     // Catch: Exception -> L13
        boolean r4 = false;
        if (r7.optInt(r1, 0) != 1) goto L11;
        r4 = true;
    L11:
        r2.put(r3, Boolean.valueOf(r4));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void d(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r3 = this.f4791b;
        boolean r1 = false;
        if (r4.optInt("memory_object_monitor", 0) != 1) goto L7;
        r1 = true;
    L7:
        r3.put("memory_object_monitor", Boolean.valueOf(r1));
    }

    private void e(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r0 = this.f4791b;
        boolean r2 = false;
        if (r6.optInt("temperature_enable_upload", 0) != 1) goto L7;
        boolean r1 = true;
    L8:
        r0.put("temperature", Boolean.valueOf(r1));
        Map<String, Boolean> r5 = this.f4791b;
        if (r6.optInt("exception_enable_upload", 0) != 1) goto L11;
        r2 = true;
    L11:
        r5.put("battery_trace", Boolean.valueOf(r2));
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void f(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r2 = this.f4791b;
        boolean r1 = false;
        if (r3.optInt("exception", 0) != 1) goto L7;
        r1 = true;
    L7:
        r2.put("cpu_trace", Boolean.valueOf(r1));
    }

    public boolean a(String r2) {
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(this.f4790a.get(r2), Boolean.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    public boolean a(String r4, String r5) {
        Boolean r6 = (Boolean) ZeusTransformUtils.preCheckCast(this.f4791b.get(r4), Boolean.class, "com.obric.aiagent.plugin");
        if (this.g != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r6 != null) goto L10;
    L12:
        if (r3 == true) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (r6.booleanValue() == false) goto L12;
    L5:
        if (this.g.optInt(r5) != 1) goto L7;
        r3 = true;
        goto L8
    }

    public boolean b(String r2) {
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(this.f4791b.get(r2), Boolean.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }
}
