package com.bytedance.lego.init.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: InitTaskExtra.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitTaskExtra {
    private List<String> children;
    private long costTime;
    private List<String> dependencies;
    private List<String> parent;
    private int priority;
    private float realPriority;

    public InitTaskExtra() {
        this.priority = -1;
        this.children = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.parent = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.dependencies = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int r1) {
        this.priority = r1;
    }

    public final float getRealPriority() {
        return this.realPriority;
    }

    public final void setRealPriority(float r1) {
        this.realPriority = r1;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    public final void setCostTime(long r1) {
        this.costTime = r1;
    }

    public final List<String> getChildren() {
        return this.children;
    }

    public final void setChildren(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.d(r4, "<set-?>");
        this.children = r4;
    }

    public final List<String> getParent() {
        return this.parent;
    }

    public final void setParent(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.d(r4, "<set-?>");
        this.parent = r4;
    }

    public final List<String> getDependencies() {
        return this.dependencies;
    }

    public final void setDependencies(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.d(r4, "<set-?>");
        this.dependencies = r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("priority:" + this.priority);
        r0.append(", children: ");
        Iterator<String> r1 = this.children.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        goto L4
    L6:
        r0.append(", parent: ");
        Iterator<String> r3 = this.parent.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        goto L8
    L10:
        r0.append(", dependencies: ");
        Iterator<String> r5 = this.dependencies.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        goto L12
    L14:
        String r7 = r0.toString();
        o.b(r7, "stringBuilder.toString()");
        return r7;
    }
}
