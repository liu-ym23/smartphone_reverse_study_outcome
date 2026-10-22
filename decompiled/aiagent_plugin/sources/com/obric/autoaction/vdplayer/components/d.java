package com.obric.autoaction.vdplayer.components;

import com.obric.autoaction.vdplayer.d.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<h> f25394a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f25394a, r6.f25394a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f25394a.hashCode();
    }

    public String toString() {
        return "PopupPayload(items=" + this.f25394a + ')';
    }

    public d(List<h> r3) {
        List<h> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "items");
        this.f25394a = r4;
    }

    public final List<h> a() {
        return this.f25394a;
    }
}
