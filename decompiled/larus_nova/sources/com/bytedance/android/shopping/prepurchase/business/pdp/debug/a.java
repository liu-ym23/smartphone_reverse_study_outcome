package com.bytedance.android.shopping.prepurchase.business.pdp.debug;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.shopping.anchorv4.helper.JisooManager;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e;
import kotlin.jvm.internal.Intrinsics;
import vg3.o;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JissoAbilityImpl$jisooListener$1 f181845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f181846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f181847c;

    @Override // vg3.o
    public final boolean isEnable() {
        return JisooManager.f166876d.a();
    }

    public a(j r100, ProductDetailDebugComponent r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        this.f181846b = r100;
        this.f181847c = r101;
        if (JisooManager.f166876d.a() == false) goto L5;
        JissoAbilityImpl$jisooListener$1 r102 = new JissoAbilityImpl$jisooListener$1(this);
    L6:
        this.f181845a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
