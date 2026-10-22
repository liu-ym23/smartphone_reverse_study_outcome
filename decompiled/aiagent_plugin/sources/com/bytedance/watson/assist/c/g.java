package com.bytedance.watson.assist.c;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: SystemPolicyTimeInStateFile.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<File> f11859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Integer> f11860c;

    public g() {
        super("");
        this.f11859b = new ArrayList();
        this.f11860c = new ArrayList();
    }

    @Override // com.bytedance.watson.assist.c.a
    public b a() {
        if (this.f11859b.isEmpty() == false) goto L12;
        List<com.bytedance.watson.assist.d.a.C0263a> r0 = com.bytedance.watson.assist.d.a.d();
        if (r0 != null) goto L8;
        return null;
    L8:
        Iterator<com.bytedance.watson.assist.d.a.C0263a> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        com.bytedance.watson.assist.d.a.C0263a r2 = (com.bytedance.watson.assist.d.a.C0263a) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.watson.assist.d.a.C0263a.class, "com.obric.aiagent.plugin");
        this.f11859b.add(new File("/sys/devices/system/cpu/cpufreq/" + r2.a() + "/stats/time_in_state"));
        this.f11860c.add(Integer.valueOf(r2.b().size()));
    L12:
        this.f11851a = a(this.f11859b, this.f11860c);
        return this.f11851a;
    }

    private b a(List<File> r8, List<Integer> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == true) goto L24;
        if (r11 != null) goto L8;
        return null;
    L8:
        if (r11.isEmpty() == false) goto L10;
        return null;
    L10:
        if (r10.size() != r11.size()) goto L27;
        com.bytedance.watson.assist.b.c.c r0 = new com.bytedance.watson.assist.b.c.c();
        int r2 = r10.size();
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L18;
        LinkedHashMap<Long, Long> r4 = a((File) ZeusTransformUtils.preCheckCast(r10.get(r3), File.class, "com.obric.aiagent.plugin"), ((Integer) ZeusTransformUtils.preCheckCast(r11.get(r3), Integer.class, "com.obric.aiagent.plugin")).intValue());
        if (r4 == null) goto L17;
        r0.a(r4);
    L17:
        r3 = r3 + 1;
        goto L13
    L18:
        return r0;
    L27:
        return null;
    L24:
        return null;
    }

    private LinkedHashMap<Long, Long> a(File r8, int r9) {
        BufferedReader r7 = com.bytedance.watson.assist.d.c.a(r8);
        LinkedHashMap<Long, Long> r10 = null;
        if (r7 != null) goto L25;
        return null;
    L25:
        String r0 = r7.readLine();     // Catch: Exception -> L19 Throwable -> L23
        if (r0 == null) goto L17;
        if (r0.isEmpty() == true) goto L17;
        String[] r1 = r0.split(" ");     // Catch: Exception -> L19 Throwable -> L23
        if (r1.length <= 1) goto L17;
        if (r10 != null) goto L15;
        r10 = new LinkedHashMap();     // Catch: Exception -> L19 Throwable -> L23
    L15:
        r10.put(Long.valueOf(Long.parseLong(r1[0])), Long.valueOf(((long) (r9 * 10)) * Long.parseLong(r1[1])));     // Catch: Exception -> L19 Throwable -> L23
    L17:
        com.bytedance.watson.assist.d.c.a(r7);
        return r10;
    L23:
        com.bytedance.watson.assist.d.c.a(r7);
        return r10;
    L19:
        e = move-exception;
        com.bytedance.watson.assist.d.b.d(Log.getStackTraceString(e));     // Catch: Throwable -> L23
        com.bytedance.watson.assist.d.c.a(r7);
        return r10;
    }
}
