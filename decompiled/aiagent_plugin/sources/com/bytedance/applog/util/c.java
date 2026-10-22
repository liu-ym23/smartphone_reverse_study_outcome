package com.bytedance.applog.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataObserverHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.applog.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<com.bytedance.applog.i> f6031a;

    public c() {
        this.f6031a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.applog.i
    public void a(String r4, String r5, String r6) {
        Iterator<com.bytedance.applog.i> r3 = this.f6031a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bytedance.applog.i) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.applog.i.class, "com.obric.aiagent.plugin")).a(r4, r5, r6);
        goto L4
    }

    @Override // com.bytedance.applog.i
    public void a(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<com.bytedance.applog.i> r0 = this.f6031a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.applog.i) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.i.class, "com.obric.aiagent.plugin")).a(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    @Override // com.bytedance.applog.i
    public void a(boolean r4, JSONObject r5) {
        Iterator<com.bytedance.applog.i> r3 = this.f6031a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bytedance.applog.i) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.applog.i.class, "com.obric.aiagent.plugin")).a(r4, r5);
        goto L4
    }

    public void a(com.bytedance.applog.i r3) {
        com.bytedance.applog.i r4 = (com.bytedance.applog.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.i.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        this.f6031a.add(r4);
        return;
    }
}
