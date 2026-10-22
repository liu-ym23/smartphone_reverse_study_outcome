package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRemoteUserPriority;", "", "", "value", "I", "REMOTE_USER_PRIORITY_LOW", "REMOTE_USER_PRIORITY_MEDIUM", "REMOTE_USER_PRIORITY_HIGH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRemoteUserPriority extends Enum<LiveWrappedRemoteUserPriority> {
    public static final LiveWrappedRemoteUserPriority REMOTE_USER_PRIORITY_HIGH = null;
    public static final LiveWrappedRemoteUserPriority REMOTE_USER_PRIORITY_LOW = null;
    public static final LiveWrappedRemoteUserPriority REMOTE_USER_PRIORITY_MEDIUM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedRemoteUserPriority[] f147438a = null;
    private int value;

    static {
        LiveWrappedRemoteUserPriority r100 = new LiveWrappedRemoteUserPriority("REMOTE_USER_PRIORITY_LOW", 0, 0);
        REMOTE_USER_PRIORITY_LOW = r100;
        LiveWrappedRemoteUserPriority r101 = new LiveWrappedRemoteUserPriority("REMOTE_USER_PRIORITY_MEDIUM", 1, 100);
        REMOTE_USER_PRIORITY_MEDIUM = r101;
        LiveWrappedRemoteUserPriority r102 = new LiveWrappedRemoteUserPriority("REMOTE_USER_PRIORITY_HIGH", 2, 200);
        REMOTE_USER_PRIORITY_HIGH = r102;
        f147438a = new LiveWrappedRemoteUserPriority[]{r100, r101, r102};
    }

    public static LiveWrappedRemoteUserPriority valueOf(String r100) {
        return (LiveWrappedRemoteUserPriority) a.a(LiveWrappedRemoteUserPriority.class, r100);
    }

    public static LiveWrappedRemoteUserPriority[] values() {
        return (LiveWrappedRemoteUserPriority[]) f147438a.clone();
    }

    public LiveWrappedRemoteUserPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
