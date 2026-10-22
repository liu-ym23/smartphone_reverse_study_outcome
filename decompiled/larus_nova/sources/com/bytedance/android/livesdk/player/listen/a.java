package com.bytedance.android.livesdk.player.listen;

import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import fm3.e;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListenLiveOnlyView f155578a;

    public a(ListenLiveOnlyView r100) {
        this.f155578a = r100;
    }

    public final void a() {
        InteractionWidgetsPosContext.a r100 = InteractionWidgetsPosContext.Companion;
        InteractionWidgetsPosContext r101 = InteractionWidgetsPosContext.a.c(r100, this.f155578a.getDataCenter(), 0, 2);
        if (r101 == null) goto L9;
        m<Integer> r102 = r101.getPublicScreenHeight();
        if (r102 == null) goto L9;
        Integer r103 = r102.getValue();
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        InteractionWidgetsPosContext r105 = InteractionWidgetsPosContext.a.c(r100, this.f155578a.getDataCenter(), 0, 2);
        if (r105 == null) goto L17;
        m<Integer> r106 = r105.getPublicScreenBottomMargin();
        if (r106 == null) goto L17;
        Integer r107 = r106.getValue();
        if (r107 == null) goto L17;
        int r108 = r107.intValue();
    L18:
        int r109 = r104 + r108;
        int r110 = (e.b(this.f155578a.getContext()) - r109) - x1.f();
        int[] r111 = new int[2];
        this.f155578a.findViewById(R.id.live_listen_recover_live).getLocationOnScreen(r111);
        int r112 = r111[1];
        if (r112 <= r110) goto L22;
        int r113 = this.f155578a.getPaddingTop() - ((r112 - r110) + ((int) e.a(this.f155578a.getContext(), 5.0f)));
        this.f155578a.setPadding(0, r113, 0, 0);
        return;
    L22:
        return;
    L17:
        r108 = 0;
    L9:
        r104 = 0;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
