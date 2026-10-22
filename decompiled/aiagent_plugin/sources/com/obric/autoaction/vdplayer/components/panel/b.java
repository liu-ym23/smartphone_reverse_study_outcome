package com.obric.autoaction.vdplayer.components.panel;

import com.obric.autoaction.vdplayer.d.k;
import com.obric.autoaction.vdplayer.d.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PanelBubbleComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f25445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f25446b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f25445a, r6.f25445a) == true) goto L12;
        return false;
    L12:
        if (this.f25446b == r6.f25446b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f25445a.hashCode() * 31) + this.f25446b.hashCode();
    }

    public String toString() {
        return "BubbleUIState(panelState=" + this.f25445a + ", userOperateMode=" + this.f25446b + ')';
    }

    public b(k r2, o r3) {
        d.h.b.o.e(r2, "panelState");
        d.h.b.o.e(r3, "userOperateMode");
        this.f25445a = r2;
        this.f25446b = r3;
    }

    public final k a() {
        return this.f25445a;
    }

    public final o b() {
        return this.f25446b;
    }
}
