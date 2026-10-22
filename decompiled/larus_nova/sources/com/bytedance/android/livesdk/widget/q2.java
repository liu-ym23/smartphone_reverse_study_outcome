package com.bytedance.android.livesdk.widget;

import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.bw;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSPremiereToast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class q2<T> implements h80.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSFirstShowPopUpServiceWidget f161944a;

    public q2(VSFirstShowPopUpServiceWidget r100) {
        this.f161944a = r100;
    }

    @Override // h80.a
    public final void accept(Object r110) {
        Room r111 = (Room) r110;
        VSFirstShowPopUpServiceWidget r112 = this.f161944a;
        r112.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        EpisodeExtraInfo r113 = com.bytedance.android.live.core.utils.z.o(r112.dataCenter).getEpisodeExtra2();
        if (r113 == null) goto L10;
        VSPremiereToast r114 = r113.getVsPremiereToast();
    L11:
        if (r114 == null) goto L18;
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.model.c1> r115 = com.bytedance.android.livesdk.sharedpref.b.f158195p2;
        com.bytedance.android.livesdk.model.c1 r100 = r115.getValue();
        if (r100.f153935b >= 3) goto L18;
        if (TimeUtils.isToday(r100.f153934a) == true) goto L18;
        r100.f153934a = System.currentTimeMillis();
        r100.f153935b++;
        com.bytedance.android.livesdk.sharedpref.f.d(r115, r100);
    L20:
        boolean r116 = true;
    L21:
        if (r116 == false) goto L27;
        VSFirstShowPopUpServiceWidget r117 = this.f161944a;
        View r101 = LayoutInflater.from(r117.context).inflate(R.layout.ttlive_view_vs_firtst_show_popup, null, false);
        if (r101 == null) goto L26;
        yo2.e r102 = new yo2.e(r117.context);
        r102.f568651m = 8;
        r102.f568645g = false;
        r102.f568650l = true;
        r102.f568642d = r101;
        r102.f568643e = 0;
        r102.f568662x = new r2(r117);
        r102.a();
        r102.i(r117.containerView, 2, 3, UtilityKotlinExtentionsKt.i(12), UtilityKotlinExtentionsKt.i(-12));
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L27:
        return;
    L18:
        r116 = false;
        goto L21
    L10:
        r114 = null;
        goto L11
    L5:
        if (bw.f119903a.getValue().booleanValue() == false) goto L7;
        goto L7
    }
}
