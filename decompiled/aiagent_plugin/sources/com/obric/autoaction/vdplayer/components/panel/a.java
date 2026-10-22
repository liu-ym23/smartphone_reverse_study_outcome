package com.obric.autoaction.vdplayer.components.panel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PanelAutoExitComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f25444a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f25444a, r6.f25444a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Long r0 = this.f25444a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "AutoExitUIState(countDown=" + this.f25444a + ')';
    }

    public a(Long r1) {
        this.f25444a = r1;
    }

    public final Long a() {
        return this.f25444a;
    }
}
