package com.bytedance.android.livesdk.announcement.highlight;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f103484a = null;

    static {
        f103484a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = AnnouncementHighlightAnchorWidgetOpt.D;
        ALogger.e("AnnouncementHighlightAnchorWidgetOpt", "submitAnnouncementOpt error is: ");
        ALogger.e("AnnouncementHighlightAnchorWidgetOpt", (Throwable) r100);
    }
}
