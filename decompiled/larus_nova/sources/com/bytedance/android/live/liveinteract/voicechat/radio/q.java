package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;

/* JADX INFO: loaded from: classes46.dex */
public final class q implements nj0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAudioSubtitleContent f80580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RadioSubtitleComponent$startSubTitleWithDependence$1 f80581b;

    public q(IAudioSubtitleContent r100, RadioSubtitleComponent$startSubTitleWithDependence$1 r101) {
        this.f80580a = r100;
        this.f80581b = r101;
    }

    @Override // nj0.c
    public final void a(boolean r100, CustomApiServerException r101) {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] updateSubtitleSetting onResult isSuccess:" + r100);
        if (r100 == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e<IAudioSubtitleContent> r102 = b6.f65253p0;
        IAudioSubtitleContent r103 = this.f80580a;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        this.f80581b.invoke2();
        return;
    L5:
        StringBuilder r104 = new StringBuilder("[RadioSubtitleComponent][AudioSubtitle] updateSubtitleSetting error:");
        if (r101 == null) goto L8;
        String r105 = r101.getMessage();
    L9:
        r104.append(r105);
        ALogger.e("RadioStageContainerWidget", r104.toString());
        return;
    L8:
        r105 = null;
        goto L9
    }
}
