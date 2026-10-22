package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoSuperResolutionModeChangedReason;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoSuperResolutionModeChangedReason extends Enum<LiveWrappedVideoSuperResolutionModeChangedReason> {
    public static final a Companion = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedVideoSuperResolutionModeChangedReason[] f147376a = null;
    private int value;

    public static LiveWrappedVideoSuperResolutionModeChangedReason valueOf(String r100) {
        return (LiveWrappedVideoSuperResolutionModeChangedReason) r27.a.a(LiveWrappedVideoSuperResolutionModeChangedReason.class, r100);
    }

    public static LiveWrappedVideoSuperResolutionModeChangedReason[] values() {
        return (LiveWrappedVideoSuperResolutionModeChangedReason[]) f147376a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionModeChangedReason$a] */
    static {
        LiveWrappedVideoSuperResolutionModeChangedReason r100 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF", 0, 0);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF = r100;
        LiveWrappedVideoSuperResolutionModeChangedReason r101 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON", 1, 1);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON = r101;
        LiveWrappedVideoSuperResolutionModeChangedReason r102 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED", 2, 2);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED = r102;
        LiveWrappedVideoSuperResolutionModeChangedReason r103 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE", 3, 3);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE = r103;
        LiveWrappedVideoSuperResolutionModeChangedReason r104 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT", 4, 4);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT = r104;
        LiveWrappedVideoSuperResolutionModeChangedReason r105 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE", 5, 5);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE = r105;
        LiveWrappedVideoSuperResolutionModeChangedReason r106 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED", 6, 6);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED = r106;
        LiveWrappedVideoSuperResolutionModeChangedReason r107 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED", 7, 7);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED = r107;
        LiveWrappedVideoSuperResolutionModeChangedReason r108 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT", 8, 8);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT = r108;
        LiveWrappedVideoSuperResolutionModeChangedReason r109 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST", 9, 9);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST = r109;
        f147376a = new LiveWrappedVideoSuperResolutionModeChangedReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "kVideoSuperResolutionModeChangedReasonAPIOff";
    L5:
        if (r100 != 1) goto L7;
        return "kVideoSuperResolutionModeChangedReasonAPIOn";
    L7:
        if (r100 != 2) goto L9;
        return "kVideoSuperResolutionModeChangedReasonResolutionExceed";
    L9:
        if (r100 != 3) goto L11;
        return "kVideoSuperResolutionModeChangedReasonOverUse";
    L11:
        if (r100 != 4) goto L13;
        return "kVideoSuperResolutionModeChangedReasonDeviceNotSupport";
    L13:
        if (r100 != 5) goto L15;
        return "kVideoSuperResolutionModeChangedReasonDynamicClose";
    L15:
        if (r100 != 100) goto L17;
        return "kVideoSuperResolutionModeChangedReasonNoComponent";
    L17:
        if (r100 != 101) goto L19;
        return "kVideoSuperResolutionModeChangedReasonStreamNotExist";
    L19:
        if (r100 == 200) goto L22;
        return "";
    L22:
        return "kVideoSuperResolutionModeChangedReasonOther";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoSuperResolutionModeChangedReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
