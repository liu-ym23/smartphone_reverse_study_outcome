package com.bytedance.android.livesdk.chatroom.replay.paid;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f109364a;

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f109364a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.a
    public final void a(Map<String, String> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L5;
        r101.putAll(r100);
    L5:
        r101.put(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, PaidReplayConstants.VALUE_FROM_CONTENT_TYPE);
        r101.put("is_vs", "1");
        r101.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, "paidlive_window_tryend_card_replay");
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.f118008b.e("livesdk_paidlive_buyticket_module_show", r101, new Object[0]);
    }

    public final Map<String, String> b(Map<String, String> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == null) goto L5;
        r102.putAll(r100);
    L5:
        r102.put(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, PaidReplayConstants.VALUE_FROM_CONTENT_TYPE);
        r101.putAll(r102);
        if (TextUtils.equals(this.f109364a, "search_card") == false) goto L8;
        r101.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, "paidlive_window_tryend_card_replay");
    L8:
        return r101;
    }

    public final void c(Map<String, String> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L5;
        r101.putAll(r100);
    L5:
        r101.put(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, PaidReplayConstants.VALUE_FROM_CONTENT_TYPE);
        r101.put("is_vs", "1");
        r101.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, "paidlive_window_tryend_card_replay");
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.f118008b.e("livesdk_paidlive_buyticket_module_click", r101, new Object[0]);
    }
}
