package com.bytedance.android.livesdk.vscore_api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import vlc.d;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.EpisodeInteractiveService")
public interface IEpisodeInteractiveService extends IService {
    Class<? extends Widget> getEpisodePlayEventNotifyWidgetClass();

    Class<? extends Widget> getEpisodeSeekMessageServiceWidgetClass();

    d provideSeekMessageManager(Context r100, DataCenter r101, boolean r102, long r103, long r104, int r105, long r106);

    void setUpForTemplate(Object r100, DataCenter r101);
}
