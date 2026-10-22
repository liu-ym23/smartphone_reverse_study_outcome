package com.bytedance.android.livesdk.livecommerce.room;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o;

/* JADX INFO: loaded from: classes10.dex */
public interface j {
    String a();

    RoomContextController b();

    com.bytedance.android.livesdk.livecommerce.room.model.g c();

    com.bytedance.android.livesdk.livecommerce.messagev2.b d();

    com.bytedance.android.ec.adapter.api.state.a e();

    EntryController f();

    EntryController g();

    Context getContext();

    EntryController h();

    com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c i(String r100);

    boolean isAnchor();

    void j(String r100);

    com.bytedance.android.livesdk.livecommerce.room.api.c k();

    boolean l();

    oj2.a m(String r100);

    o n(String r100);

    lj2.a o(String r100);

    fh2.a p(String r100);

    com.bytedance.android.livesdk.livecommerce.intro.message.a q(String r100);

    String roomId();
}
