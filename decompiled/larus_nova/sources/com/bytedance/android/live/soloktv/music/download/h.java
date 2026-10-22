package com.bytedance.android.live.soloktv.music.download;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.music.download.DownloadException;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {
    public h(a r100) {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        SoloKtvContext.a r102 = SoloKtvContext.Companion;
        com.bytedance.android.live.ktv.common.model.bean.f r103 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
        r102.getClass();
        SoloKtvContext.a.c(r103);
        if ((r101 instanceof DownloadException) == true) goto L5;
        Throwable r104 = null;
    L7:
        if (((DownloadException) r104) == null) goto L9;
        f2.c(((DownloadException) r101).getToastMsg(), 0);
    L9:
        String r105 = "mv and other music resource download failed, message: " + r101.getMessage();
        ALogger.i(bb0.b.b(), "DownloadServiceImpl :" + r105 + ", invoke class :" + a.class.getSimpleName());
        return;
    L5:
        r104 = r101;
        goto L7
    }
}
