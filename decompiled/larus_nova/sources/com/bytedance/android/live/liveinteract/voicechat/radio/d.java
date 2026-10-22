package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jk0.b f80538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vlc.d f80539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f80540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f80541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f80542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f80543f;

    public d(DataCenter r100) {
        this.f80543f = r100;
        this.f80540c = System.currentTimeMillis();
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof cj) == false) goto L30;
        StringBuilder r101 = new StringBuilder("[RadioMessageComponent] message.msgType:");
        cj r102 = (cj) r100;
        r101.append(r102.msgType);
        ALogger.i("RadioStageContainerWidget", r101.toString());
        Integer r103 = r102.msgType;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.intValue() != 1) goto L31;
        cj.f r104 = r102.metaContent;
        StringBuilder r105 = new StringBuilder("[RadioMessageComponent] meta content:");
        Long r106 = null;
        if (r104 == null) goto L12;
        Boolean r107 = r104.isActivate;
    L13:
        r105.append(r107);
        ALogger.i("RadioStageContainerWidget", r105.toString());
        if (r104 == null) goto L16;
        Boolean r108 = r104.isActivate;
    L18:
        if (Intrinsics.areEqual(r108, Boolean.TRUE) == false) goto L22;
        this.f80540c = System.currentTimeMillis();
        this.f80542e = true;
        jk0.b r109 = this.f80538a;
        if (r109 == null) goto L26;
        r109.onStart();
    L26:
        if (r104 == null) goto L28;
        r106 = Long.valueOf(r104.giftId);
    L28:
        this.f80541d = r106;
        return;
    L22:
        jk0.b r110 = this.f80538a;
        if (r110 == null) goto L25;
        r110.onStop();
    L25:
        this.f80542e = false;
        goto L26
    L16:
        r108 = null;
        goto L18
    L12:
        r107 = null;
        goto L13
    L31:
        return;
    }
}
