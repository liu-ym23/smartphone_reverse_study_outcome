package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.f0;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedPublishStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PUBLISH", "UNPUBLISH", "NO_PUBLISH_PERMISSION", "OVER_STREAM_PUBLISH_LIMIT", "MULTIROOM_UNPUBLISH_FAILED", "PUBLISH_STREAM_FAILED", "PUBLISH_STREAM_FORBIDEN", "USER_IN_PUBLISH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPublishStateChangeReason extends Enum<LiveWrappedPublishStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedPublishStateChangeReason MULTIROOM_UNPUBLISH_FAILED = null;
    public static final LiveWrappedPublishStateChangeReason NO_PUBLISH_PERMISSION = null;
    public static final LiveWrappedPublishStateChangeReason OVER_STREAM_PUBLISH_LIMIT = null;
    public static final LiveWrappedPublishStateChangeReason PUBLISH = null;
    public static final LiveWrappedPublishStateChangeReason PUBLISH_STREAM_FAILED = null;
    public static final LiveWrappedPublishStateChangeReason PUBLISH_STREAM_FORBIDEN = null;
    public static final LiveWrappedPublishStateChangeReason UNPUBLISH = null;
    public static final LiveWrappedPublishStateChangeReason USER_IN_PUBLISH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedPublishStateChangeReason[] f147349a = null;
    private int value;

    public static LiveWrappedPublishStateChangeReason valueOf(String r100) {
        return (LiveWrappedPublishStateChangeReason) r27.a.a(LiveWrappedPublishStateChangeReason.class, r100);
    }

    public static LiveWrappedPublishStateChangeReason[] values() {
        return (LiveWrappedPublishStateChangeReason[]) f147349a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPublishStateChangeReason$a] */
    static {
        LiveWrappedPublishStateChangeReason r100 = new LiveWrappedPublishStateChangeReason("PUBLISH", 0, 0);
        PUBLISH = r100;
        LiveWrappedPublishStateChangeReason r101 = new LiveWrappedPublishStateChangeReason("UNPUBLISH", 1, 1);
        UNPUBLISH = r101;
        LiveWrappedPublishStateChangeReason r102 = new LiveWrappedPublishStateChangeReason("NO_PUBLISH_PERMISSION", 2, 2);
        NO_PUBLISH_PERMISSION = r102;
        LiveWrappedPublishStateChangeReason r103 = new LiveWrappedPublishStateChangeReason("OVER_STREAM_PUBLISH_LIMIT", 3, 3);
        OVER_STREAM_PUBLISH_LIMIT = r103;
        LiveWrappedPublishStateChangeReason r104 = new LiveWrappedPublishStateChangeReason("MULTIROOM_UNPUBLISH_FAILED", 4, 4);
        MULTIROOM_UNPUBLISH_FAILED = r104;
        LiveWrappedPublishStateChangeReason r105 = new LiveWrappedPublishStateChangeReason("PUBLISH_STREAM_FAILED", 5, 5);
        PUBLISH_STREAM_FAILED = r105;
        LiveWrappedPublishStateChangeReason r106 = new LiveWrappedPublishStateChangeReason("PUBLISH_STREAM_FORBIDEN", 6, 6);
        PUBLISH_STREAM_FORBIDEN = r106;
        LiveWrappedPublishStateChangeReason r107 = new LiveWrappedPublishStateChangeReason("USER_IN_PUBLISH", 7, 7);
        USER_IN_PUBLISH = r107;
        f147349a = new LiveWrappedPublishStateChangeReason[]{r100, r101, r102, r103, r104, r105, r106, r107};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(f0.f571714a[ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kPublishStateChangeReasonUserInPublish";
    L6:
        return "kPublishStateChangeReasonPublishStreamForbidden";
    L7:
        return "kPublishStateChangeReasonPublishStreamFailed";
    L8:
        return "kPublishStateChangeReasonMultiRoomUnpublishFailed";
    L9:
        return "kPublishStateChangeReasonOverStreamPublishLimit";
    L10:
        return "kPublishStateChangeReasonNoPublishPermission";
    L11:
        return "kPublishStateChangeReasonUnpublish";
    L12:
        return "kPublishStateChangeReasonPublish";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedPublishStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
