package com.obric.oui.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: WidgetContainer.java */
/* JADX INFO: loaded from: classes4.dex */
public class n extends e {
    public ArrayList<e> aV;

    public n() {
        this.aV = new ArrayList();
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public void w() {
        this.aV.clear();
        super.w();
    }

    public void b(e r4) {
        this.aV.add(r4);
        if (r4.A() == null) goto L5;
        ((n) ZeusTransformUtils.preCheckCast(r4.A(), n.class, "com.obric.aiagent.plugin")).c(r4);
    L5:
        r4.a_(this);
    }

    public void c(e r1) {
        this.aV.remove(r1);
        r1.w();
    }

    public ArrayList<e> ak() {
        return this.aV;
    }

    public void ah() {
        ArrayList<e> r1 = this.aV;
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = r1.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        e r4 = (e) ZeusTransformUtils.preCheckCast(this.aV.get(r3), e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, n.class) == false) goto L10;
        ((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin")).ah();
    L10:
        r3 = r3 + 1;
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public void a(com.obric.oui.constraintlayout.a.c r6) {
        super.a(r6);
        int r0 = this.aV.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((e) ZeusTransformUtils.preCheckCast(this.aV.get(r1), e.class, "com.obric.aiagent.plugin")).a(r6);
        r1 = r1 + 1;
        goto L3
    }

    public void al() {
        this.aV.clear();
    }
}
