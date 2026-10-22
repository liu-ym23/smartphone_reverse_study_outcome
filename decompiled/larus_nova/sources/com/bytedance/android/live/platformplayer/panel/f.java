package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdk.message.model.nk;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, vlc.l> f85761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public nk f85762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StreamAutoAdapterService f85763c;

    public f() {
        StreamAutoAdapterService r100 = StreamAutoAdapterService.f85743o;
        Intrinsics.checkNotNullParameter(r100, "streamAdapterService");
        this.f85763c = r100;
        this.f85761a = new HashMap();
    }

    public final void a(nk r100) {
        int r101 = r100.H();
        nk r102 = this.f85762b;
        if (r102 != null) goto L5;
    L11:
        StreamAutoAdapterService r103 = this.f85763c;
        StringBuilder r104 = new StringBuilder("room@");
        CommonMessageData r105 = r100.baseMessage;
        if (r105 == null) goto L14;
        Long r106 = Long.valueOf(r105.roomId);
    L15:
        r104.append(r106);
        r104.append(" cache message, adaptationType: ");
        r104.append(r100.H());
        r104.append(", adaptationHeightRatio: ");
        r104.append(r100.G());
        r104.append(", adaptationBodyCenterRatio: ");
        r104.append(r100.E());
        r103.e(r104.toString());
        this.f85762b = r100;
        return;
    L14:
        r106 = null;
        goto L15
    L5:
        if (r101 != r102.H()) goto L11;
        float r107 = r100.G();
        nk r108 = this.f85762b;
        if (r108 == null) goto L11;
        if (r107 != r108.G()) goto L11;
    }
}
