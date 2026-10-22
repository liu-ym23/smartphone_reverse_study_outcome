package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.android.livesdk.link.model.q4;
import com.bytedance.android.livesdk.revenue.toolbar.BubbleOpenLocalPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f92165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f92166b;

    public final void a(q4 r210) {
        if (r210 != null) goto L4;
        return;
    L4:
        d r100 = this.f92165a;
        String r101 = r210.getBubbleText();
        PkPanelType.a r102 = PkPanelType.Companion;
        Integer r110 = Integer.valueOf(r210.getBubblePanel());
        r102.getClass();
        PkPanelType r103 = PkPanelType.a.a(r110);
        if (r103 != PkPanelType.PK) goto L9;
        BubbleOpenLocalPanel r104 = BubbleOpenLocalPanel.PkPanel;
    L12:
        r100.a(new zr2.e(r101, null, null, 0, null, null, 0, 0, null, 0, r104, null, null, null, 15358));
        return;
    L9:
        if (r103 != PkPanelType.Anchor) goto L11;
        r104 = BubbleOpenLocalPanel.LinkPanel;
        goto L12
    L11:
        r104 = null;
        goto L12
    }

    public j(d r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "buttonHelper");
        this.f92165a = r100;
        this.f92166b = r101;
    }
}
