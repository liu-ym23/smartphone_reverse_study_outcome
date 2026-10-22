package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.utils.c5;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f80579a;

    public p(m r100) {
        this.f80579a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        StringBuilder r102 = new StringBuilder("[RadioSubtitleComponent] request error: ");
        String r103 = null;
        if (r101 == null) goto L5;
        Integer r104 = Integer.valueOf(c5.a(r101));
    L6:
        r102.append(r104);
        r102.append(',');
        if (r101 == null) goto L9;
        r103 = r101.getMessage();
    L9:
        r102.append(r103);
        ALogger.e("RadioStageContainerWidget", r102.toString());
        m r105 = this.f80579a;
        if (r105.f80572e == false) goto L13;
        return;
    L13:
        if (r105.f80571d >= 3) goto L16;
        MainThreadPostUtils.c(new o(this), 2000);
        return;
    L16:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
