package com.bytedance.applog.h;

import com.bytedance.applog.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: SessionObserverHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<o> f5645a;

    public c() {
        this.f5645a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.applog.o
    public void a(long r4, String r6) {
        Iterator<o> r3 = this.f5645a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((o) ZeusTransformUtils.preCheckCast(r3.next(), o.class, "com.obric.aiagent.plugin")).a(r4, r6);
        goto L4
    }

    @Override // com.bytedance.applog.o
    public void a(long r4, String r6, JSONObject r7) {
        Iterator<o> r3 = this.f5645a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((o) ZeusTransformUtils.preCheckCast(r3.next(), o.class, "com.obric.aiagent.plugin")).a(r4, r6, r7);
        goto L4
    }

    @Override // com.bytedance.applog.o
    public void b(long r4, String r6, JSONObject r7) {
        Iterator<o> r3 = this.f5645a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((o) ZeusTransformUtils.preCheckCast(r3.next(), o.class, "com.obric.aiagent.plugin")).b(r4, r6, r7);
        goto L4
    }
}
