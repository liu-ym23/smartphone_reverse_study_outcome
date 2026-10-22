package com.bytedance.bdinstall.j;

import com.bytedance.bdinstall.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: DataObserverInstance.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<ac> f6305a;

    public b() {
        this.f6305a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.bdinstall.ac
    public void a(String r4, String r5, String r6) {
        Iterator<ac> r3 = this.f6305a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ac) ZeusTransformUtils.preCheckCast(r3.next(), ac.class, "com.obric.aiagent.plugin")).a(r4, r5, r6);
        goto L4
    }

    @Override // com.bytedance.bdinstall.ac
    public void a(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<ac> r0 = this.f6305a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ac) ZeusTransformUtils.preCheckCast(r0.next(), ac.class, "com.obric.aiagent.plugin")).a(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    public void a(ac r3) {
        ac r4 = (ac) ZeusTransformUtils.wrapperContextForParams(r3, ac.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        this.f6305a.add(r4);
        return;
    }
}
