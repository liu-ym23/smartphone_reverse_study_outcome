package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.b1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNRemoteVideoState;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Stoped", "Starting", "Decoding", "Frozen", "Failed", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNRemoteVideoState extends Enum<LiveWrappedWTNRemoteVideoState> {
    public static final a Companion = null;
    public static final LiveWrappedWTNRemoteVideoState Decoding = null;
    public static final LiveWrappedWTNRemoteVideoState Failed = null;
    public static final LiveWrappedWTNRemoteVideoState Frozen = null;
    public static final LiveWrappedWTNRemoteVideoState Starting = null;
    public static final LiveWrappedWTNRemoteVideoState Stoped = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedWTNRemoteVideoState[] f147383a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteVideoState$a] */
    static {
        LiveWrappedWTNRemoteVideoState r100 = new LiveWrappedWTNRemoteVideoState("Stoped", 0, 0);
        Stoped = r100;
        LiveWrappedWTNRemoteVideoState r101 = new LiveWrappedWTNRemoteVideoState("Starting", 1, 1);
        Starting = r101;
        LiveWrappedWTNRemoteVideoState r102 = new LiveWrappedWTNRemoteVideoState("Decoding", 2, 2);
        Decoding = r102;
        LiveWrappedWTNRemoteVideoState r103 = new LiveWrappedWTNRemoteVideoState("Frozen", 3, 3);
        Frozen = r103;
        LiveWrappedWTNRemoteVideoState r104 = new LiveWrappedWTNRemoteVideoState("Failed", 4, 4);
        Failed = r104;
        f147383a = new LiveWrappedWTNRemoteVideoState[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static LiveWrappedWTNRemoteVideoState valueOf(String r100) {
        return (LiveWrappedWTNRemoteVideoState) r27.a.a(LiveWrappedWTNRemoteVideoState.class, r100);
    }

    public static LiveWrappedWTNRemoteVideoState[] values() {
        return (LiveWrappedWTNRemoteVideoState[]) f147383a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = b1.f571695a[ordinal()];
        if (r100 != 1) goto L5;
        return "kWTNRemoteVideoStateStopped";
    L5:
        if (r100 != 2) goto L7;
        return "kWTNRemoteVideoStateStarting";
    L7:
        if (r100 != 3) goto L9;
        return "kWTNRemoteVideoStateDecoding";
    L9:
        if (r100 != 4) goto L11;
        return "kWTNRemoteVideoStateFrozen";
    L11:
        if (r100 == 5) goto L13;
        return "";
    L13:
        return "kWTNRemoteVideoStateFailed";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNRemoteVideoState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
