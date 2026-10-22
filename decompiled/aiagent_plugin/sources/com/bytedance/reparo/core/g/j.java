package com.bytedance.reparo.core.g;

import com.bytedance.reparo.core.WandTrick;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SoFileList.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f9243b = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9244a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<i> f9245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9246d;

    static {
    }

    public boolean a() {
        return this.f9246d;
    }

    public j(String r2) {
        this.f9245c = new ArrayList();
        this.f9246d = false;
        this.f9244a = r2;
    }

    public void a(i r3) {
        if (f9243b == true) goto L10;
        if (r3.f9240c.contains(this.f9244a) == true) goto L10;
        throw new AssertionError();
    L10:
        if (this.f9245c.contains(r3) == false) goto L12;
        return;
    L12:
        this.f9245c.add(r3);
        if (WandTrick.a(r3.f9239b) == true) goto L16;
        this.f9246d = true;
        return;
    }

    public i a(com.bytedance.reparo.core.i.g<i> r3) {
        com.bytedance.reparo.core.i.g r4 = (com.bytedance.reparo.core.i.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.reparo.core.i.g.class, "com.obric.aiagent.plugin");
        return (i) ZeusTransformUtils.preCheckCast(com.bytedance.reparo.core.i.h.a(this.f9245c, r4), i.class, "com.obric.aiagent.plugin");
    }

    public int b() {
        return this.f9245c.size();
    }

    public HashMap<String, i> c() {
        HashMap<String, i> r0 = new HashMap();
        Iterator<i> r4 = this.f9245c.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        i r1 = (i) ZeusTransformUtils.preCheckCast(r4.next(), i.class, "com.obric.aiagent.plugin");
        r0.put(r1.f9240c, r1);
        goto L4
    L6:
        return r0;
    }

    public static i a(String r4) {
        String r1 = r4.substring(r4.lastIndexOf("/") + 1);
        i r3 = new i();
        r3.f9239b = r1;
        r3.f9240c = r4;
        r3.f9238a = r4.split("/")[1];
        return r3;
    }
}
