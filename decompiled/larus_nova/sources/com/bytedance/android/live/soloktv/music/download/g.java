package com.bytedance.android.live.soloktv.music.download;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Consumer {
    public g(a r100) {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        ALogger.i(bb0.b.b(), "DownloadServiceImpl :mv and other music resource download success, invoke class :".concat(a.class.getSimpleName()));
    }
}
