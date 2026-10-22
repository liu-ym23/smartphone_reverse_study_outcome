package com.bytedance.android.livesdk.chatroom.presenter;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements vlc.l, wlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.view.b f107650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f107651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vlc.d f107652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f107653d;

    public g(DataCenter r100) {
        this.f107651b = r100;
        this.f107653d = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
    }

    @Override // wlc.b
    public final void Rk(IStreamMessage r100) {
        com.bytedance.android.livesdk.chatroom.view.b r101 = this.f107650a;
        if (r101 == null) goto L5;
        r101.Ft((ControlMessage) r100);
        return;
    L5:
        HashMap r102 = new HashMap();
        r102.put("action", Long.valueOf(((ControlMessage) r100).getAction()));
        LiveSlardarMonitor.monitorStatus("ttlive_control_message_status", 1, r102);
    }

    public final void a(com.bytedance.android.livesdk.chatroom.view.b r100) {
        this.f107650a = r100;
        this.f107652c = (vlc.d) this.f107651b.get("data_message_manager");
        emc.a r101 = (emc.a) this.f107651b.get("data_stream_message_manager");
        if (this.f107653d == true) goto L6;
        if (r101 == null) goto L10;
        r101.addMessageListener(MessageType.CONTROL.getIntType(), this);
        return;
    L10:
        return;
    L6:
        vlc.d r102 = this.f107652c;
        if (r102 == null) goto L12;
        r102.addMessageListener(MessageType.CONTROL.getIntType(), this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        com.bytedance.android.livesdk.chatroom.view.b r101 = this.f107650a;
        if (r101 == null) goto L5;
        r101.Ft((ControlMessage) r100);
        return;
    L5:
        HashMap r102 = new HashMap();
        r102.put("action", Long.valueOf(((ControlMessage) r100).getAction()));
        LiveSlardarMonitor.monitorStatus("ttlive_control_message_status", 1, r102);
    }
}
