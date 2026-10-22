package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements LiveSwitchButton.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppointmentSelectDialog f140671a;

    public a(AppointmentSelectDialog r100) {
        this.f140671a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
    public final void d0(LiveSwitchButton r100, boolean r101) {
        RoomIntroDataSource r102 = this.f140671a.f140644d;
        if (r102 == null) goto L9;
        PropertyOwner<Boolean> r103 = r102.f140596v;
        if (r103 != null) goto L7;
        ALogger.e("RoomIntroDialogV2", "appointment is not useable");
        return;
    L7:
        r103.a(Boolean.valueOf(r101));
        return;
    }
}
