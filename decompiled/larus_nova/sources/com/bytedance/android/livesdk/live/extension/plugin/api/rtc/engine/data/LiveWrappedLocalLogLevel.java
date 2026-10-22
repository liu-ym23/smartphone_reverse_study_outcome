package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedLocalLogLevel;", "", "", "<set-?>", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "INFO", "WARNING", "ERROR", UserProfileEvent.POSITION_NONE, "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLocalLogLevel extends Enum<LiveWrappedLocalLogLevel> {
    public static final a Companion = null;
    public static final LiveWrappedLocalLogLevel ERROR = null;
    public static final LiveWrappedLocalLogLevel INFO = null;
    public static final LiveWrappedLocalLogLevel NONE = null;
    public static final LiveWrappedLocalLogLevel WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedLocalLogLevel[] f147340a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedLocalLogLevel$a] */
    static {
        LiveWrappedLocalLogLevel r100 = new LiveWrappedLocalLogLevel("INFO", 0, 0);
        INFO = r100;
        LiveWrappedLocalLogLevel r101 = new LiveWrappedLocalLogLevel("WARNING", 1, 1);
        WARNING = r101;
        LiveWrappedLocalLogLevel r102 = new LiveWrappedLocalLogLevel("ERROR", 2, 2);
        ERROR = r102;
        LiveWrappedLocalLogLevel r103 = new LiveWrappedLocalLogLevel(UserProfileEvent.POSITION_NONE, 3, 3);
        NONE = r103;
        f147340a = new LiveWrappedLocalLogLevel[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedLocalLogLevel valueOf(String r100) {
        return (LiveWrappedLocalLogLevel) r27.a.a(LiveWrappedLocalLogLevel.class, r100);
    }

    public static LiveWrappedLocalLogLevel[] values() {
        return (LiveWrappedLocalLogLevel[]) f147340a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static final /* synthetic */ int access$getValue$p(LiveWrappedLocalLogLevel r100) {
        return r100.value;
    }

    public static final /* synthetic */ void access$setValue$p(LiveWrappedLocalLogLevel r100, int r101) {
        r100.value = r101;
    }

    public LiveWrappedLocalLogLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
