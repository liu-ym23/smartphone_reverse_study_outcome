package com.obric.autoaction.vdplayer.legacy.components;

import com.obric.autoaction.vdplayer.legacy.d.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<h> f25813a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f25813a, r6.f25813a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f25813a.hashCode();
    }

    public String toString() {
        return "PopupPayload(items=" + this.f25813a + ')';
    }

    public c(List<h> r3) {
        List<h> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "items");
        this.f25813a = r4;
    }

    public final List<h> a() {
        return this.f25813a;
    }
}
