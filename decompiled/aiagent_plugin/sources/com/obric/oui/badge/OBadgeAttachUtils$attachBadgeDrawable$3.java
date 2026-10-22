package com.obric.oui.badge;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: OBadgeAttachUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBadgeAttachUtils$attachBadgeDrawable$3 implements View.OnLayoutChangeListener {
    final /* synthetic */ View $anchor;
    final /* synthetic */ View $host;
    final /* synthetic */ d.h.a.a<x> $updatePosition;

    OBadgeAttachUtils$attachBadgeDrawable$3(View r3, View r4, d.h.a.a<x> r5) {
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        this.$anchor = r3;
        this.$host = r4;
        this.$updatePosition = r6;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        o.e(r1, "v");
        if (a.a(a.f34011a, this.$anchor) == true) goto L5;
        return;
    L5:
        if (a.a(a.f34011a, this.$host) == false) goto L10;
        this.$anchor.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.aiagent.plugin"));
        this.$updatePosition.invoke();
        return;
    }
}
