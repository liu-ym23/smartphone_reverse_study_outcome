package com.bytedance.android.livesdk.share;

import android.content.DialogInterface;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class y implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareTicketFragment f158114a;

    public y(ShareTicketFragment r100) {
        this.f158114a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        int r102 = com.bytedance.android.livesdk.chatroom.paidlive.d.f107573a;
        Map<String, String> r103 = this.f158114a.O;
        if (r103 == null) goto L7;
        Map r104 = MapsKt.toMutableMap(r103);
        if (r104 == null) goto L7;
        r104.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "think");
        Unit r105 = Unit.INSTANCE;
    L8:
        com.bytedance.android.livesdk.chatroom.paidlive.d.a("livesdk_paidlive_get_free_ticket_return_pop_click", r104);
        return;
    L7:
        r104 = null;
        goto L8
    }
}
