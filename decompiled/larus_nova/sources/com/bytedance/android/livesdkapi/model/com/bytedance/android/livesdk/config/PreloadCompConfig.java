package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.am;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadCompConfig;", "", "()V", "config", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadCompData;", "getConfig", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadCompData;", "enableComment", "", "enablePublicScreen", "enableToolbar", "getToolbarPreloadIds", "", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadCompConfig {
    public static final PreloadCompConfig INSTANCE = null;
    private static final PreloadCompData config = null;

    private PreloadCompConfig() {
    }

    static {
        INSTANCE = new PreloadCompConfig();
        config = am.f119803a.getValue();
    }

    public final boolean enableComment() {
        PreloadCompData r100 = config;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getEnableComment();
    }

    public final boolean enablePublicScreen() {
        PreloadCompData r100 = config;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getEnablePublicScreen();
    }

    public final boolean enableToolbar() {
        PreloadCompData r100 = config;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getEnableToolbar();
    }

    public final List<Integer> getToolbarPreloadIds() {
        PreloadCompData r100 = config;
        if (r100 == null) goto L7;
        List<Integer> r101 = r100.getToolbarPreloadIds();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    public final PreloadCompData getConfig() {
        return config;
    }
}
