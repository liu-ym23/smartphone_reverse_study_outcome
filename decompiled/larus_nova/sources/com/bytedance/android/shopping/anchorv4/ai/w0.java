package com.bytedance.android.shopping.anchorv4.ai;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.AIChatMessage;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class w0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f165698a;

    public w0(t0 r100) {
        this.f165698a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r210) {
        t0 r100 = this.f165698a;
        int r101 = u0.f165693a[r100.f165690g.ordinal()];
        if (r101 != 1) goto L5;
        s0.a("mock input clicked in collapsed state, expand");
        s0.a("expandWindow called");
        r100.g(MockAIChatWindowState.EXPANDED);
        return;
    L5:
        if (r101 != 2) goto L7;
        s0.a("mock input clicked in expanded state, enter thinking");
        r100.g(MockAIChatWindowState.THINKING);
        String r102 = "pdp_ai_mock_" + System.currentTimeMillis();
        AIChatMessage r103 = new AIChatMessage(r102, null, null, null, null, false, false, false, null, null, 1022, null);
        s0.a("mock send message, localMessageId=" + r102);
        Iterator<T> r104 = r100.f165684a.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        ((xe.e) r104.next()).c(r103);
        goto L12
    L14:
        Iterator<T> r105 = r100.f165684a.iterator();
    L16:
        if (r105.hasNext() == false) goto L24;
        ((xe.e) r105.next()).a(AIChatMessage.copy$default(r103, null, "server_" + r102, null, null, null, false, false, false, null, null, 1021, null));
        r103 = r103;
        goto L16
    L24:
        return;
    L7:
        if (r101 != 3) goto L23;
        s0.a("mock input clicked in thinking state, expand");
        s0.a("expandWindow called");
        r100.g(MockAIChatWindowState.EXPANDED);
        return;
    }
}
