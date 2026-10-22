package com.obric.autoaction.vdplayer.legacy.components.panel;

import com.obric.autoaction.vdplayer.legacy.d.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PanelBubbleComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f25852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f25853b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f25852a == r6.f25852a) goto L12;
        return false;
    L12:
        if (o.a(this.f25853b, r6.f25853b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f25852a.hashCode() * 31;
        Long r1 = this.f25853b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "BubbleUIState(panelStatus=" + this.f25852a + ", countdown=" + this.f25853b + ')';
    }

    public b(l r2, Long r3) {
        o.e(r2, "panelStatus");
        this.f25852a = r2;
        this.f25853b = r3;
    }

    public final l a() {
        return this.f25852a;
    }

    public final Long b() {
        return this.f25853b;
    }
}
