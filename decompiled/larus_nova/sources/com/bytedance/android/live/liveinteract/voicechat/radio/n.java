package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.model.interact.k2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f80577a;

    public n(m r100) {
        this.f80577a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        StringBuilder r102 = new StringBuilder("[RadioSubtitleComponent] requestInitRtcInfo suc: ");
        k2 r103 = null;
        if (r101 == null) goto L5;
        k2 r104 = (k2) r101.data;
    L6:
        r102.append(r104);
        r102.append(" isDestroy:");
        r102.append(this.f80577a.f80572e);
        ALogger.i("RadioStageContainerWidget", r102.toString());
        m r105 = this.f80577a;
        if (r105.f80572e == true) goto L16;
        if (r101 == null) goto L11;
        r103 = (k2) r101.data;
    L11:
        if (r103 != null) goto L13;
        f2.b(R.string.ttlive_radio_subtitle_request_error, 0);
        return;
    L13:
        k2 r106 = (k2) r101.data;
        r105.f80573f = r106;
        r105.i(r106);
        return;
    L16:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
