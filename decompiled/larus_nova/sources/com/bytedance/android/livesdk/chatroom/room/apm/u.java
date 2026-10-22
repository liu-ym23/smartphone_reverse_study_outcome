package com.bytedance.android.livesdk.chatroom.room.apm;

import android.text.TextUtils;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class u implements Observer<hl0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f110741a;

    public u(p r100) {
        this.f110741a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        hl0.a r101 = (hl0.a) r100;
        if (r101 != null) goto L5;
        this.f110741a.b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.E, "enter failed"));
        this.f110741a.a("network_status", "-1");
    L18:
        p r102 = this.f110741a;
        p.b r103 = r102.f110727q;
        r103.f110734a = true;
        r103.f110735b = true;
        r103.f110736c = true;
        r102.h(4, "enter failed cause of room/enter error");
        return;
    L5:
        this.f110741a.c("enter_room_log_id", r101.f485663c);
        p r104 = this.f110741a;
        String r105 = r101.f485663c;
        r104.getClass();
        String r106 = null;
        if (r105 == null) goto L14;
        int r107 = r105.indexOf(58);
        if (r107 <= 0) goto L14;
        int r108 = r107 + 2;
        if (r108 >= r105.length()) goto L12;
        r105 = r105.substring(r108);
        goto L14
    L12:
        r105 = null;
    L14:
        if (TextUtils.isEmpty(r105) == true) goto L17;
        r106 = r105;
    L17:
        r104.f110715e = r106;
        this.f110741a.b(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.E, "enter failed", String.valueOf(r101)));
        this.f110741a.a("network_status", String.valueOf(r101.f485661a));
        goto L18
    }
}
