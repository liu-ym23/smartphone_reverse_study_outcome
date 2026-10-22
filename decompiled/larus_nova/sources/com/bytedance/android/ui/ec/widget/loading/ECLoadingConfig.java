package com.bytedance.android.ui.ec.widget.loading;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECLoadingConfig;", "", "()V", "<set-?>", "", "isDecided", "()Z", "usePersistentCache", "getUsePersistentCache", "decideUsePersistentCache", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLoadingConfig {
    public static final ECLoadingConfig INSTANCE = null;
    private static volatile boolean isDecided;
    private static boolean usePersistentCache;

    private ECLoadingConfig() {
    }

    static {
        INSTANCE = new ECLoadingConfig();
    }

    public final boolean getUsePersistentCache() {
        return usePersistentCache;
    }

    public final boolean isDecided() {
        return isDecided;
    }

    public final void decideUsePersistentCache(boolean r100) {
        if (isDecided == false) goto L5;
        return;
    L5:
        isDecided = true;
        usePersistentCache = r100;
    }
}
