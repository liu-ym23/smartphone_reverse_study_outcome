package com.bytedance.android.livesdk.chatroom.replay.session.video.task;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.room.data.EndReason;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f109949a;

    public d(e r100) {
        this.f109949a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        com.bytedance.android.livesdk.chatroom.vs_base.base.api.b r102 = this.f109949a.a();
        ls2.e r103 = new ls2.e(208);
        r103.setRoomErrorCodeV2(208);
        r103.setErrMsgV2("user cancel");
        r103.setReasonV2(EndReason.ENTER_FAILED.INSTANCE);
        Unit r104 = Unit.INSTANCE;
        r102.start(b.class, MapsKt.mapOf(TuplesKt.to("key_error", r103)));
    }
}
