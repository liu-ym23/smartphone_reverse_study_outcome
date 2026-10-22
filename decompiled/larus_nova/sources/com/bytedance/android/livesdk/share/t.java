package com.bytedance.android.livesdk.share;

import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareTicketFragment f158108a;

    public t(ShareTicketFragment r100) {
        this.f158108a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ShareTicketFragment.ba0(this.f158108a, true);
        int r102 = com.bytedance.android.livesdk.chatroom.paidlive.d.f107573a;
        Map<String, String> r103 = this.f158108a.O;
        if (r103 == null) goto L7;
        Map r104 = MapsKt.toMutableMap(r103);
        if (r104 == null) goto L7;
        r104.put("fail_reason", s1.B(R.string.ttlive_get_error));
        Unit r105 = Unit.INSTANCE;
    L8:
        com.bytedance.android.livesdk.chatroom.paidlive.d.a("livesdk_paidlive_get_free_ticket_fail_toast_show", r104);
        return;
    L7:
        r104 = null;
        goto L8
    }
}
