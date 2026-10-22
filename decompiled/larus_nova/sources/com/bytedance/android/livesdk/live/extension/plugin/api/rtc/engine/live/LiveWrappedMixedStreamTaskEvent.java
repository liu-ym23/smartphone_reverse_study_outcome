package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import bg2.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamTaskEvent;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "BASE", "START_SUCCESS", "START_FAILED", "UPDATE_SUCCESS", "UPDATE_FAILED", "STOP_SUCCESS", "STOP_FAILED", "WARNING", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamTaskEvent extends Enum<LiveWrappedMixedStreamTaskEvent> {
    public static final LiveWrappedMixedStreamTaskEvent BASE = null;
    public static final a Companion = null;
    public static final LiveWrappedMixedStreamTaskEvent START_FAILED = null;
    public static final LiveWrappedMixedStreamTaskEvent START_SUCCESS = null;
    public static final LiveWrappedMixedStreamTaskEvent STOP_FAILED = null;
    public static final LiveWrappedMixedStreamTaskEvent STOP_SUCCESS = null;
    public static final LiveWrappedMixedStreamTaskEvent UPDATE_FAILED = null;
    public static final LiveWrappedMixedStreamTaskEvent UPDATE_SUCCESS = null;
    public static final LiveWrappedMixedStreamTaskEvent WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMixedStreamTaskEvent[] f147402a = null;
    private int value;

    public static LiveWrappedMixedStreamTaskEvent valueOf(String r100) {
        return (LiveWrappedMixedStreamTaskEvent) r27.a.a(LiveWrappedMixedStreamTaskEvent.class, r100);
    }

    public static LiveWrappedMixedStreamTaskEvent[] values() {
        return (LiveWrappedMixedStreamTaskEvent[]) f147402a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamTaskEvent$a] */
    static {
        LiveWrappedMixedStreamTaskEvent r100 = new LiveWrappedMixedStreamTaskEvent("BASE", 0, 0);
        BASE = r100;
        LiveWrappedMixedStreamTaskEvent r101 = new LiveWrappedMixedStreamTaskEvent("START_SUCCESS", 1, 1);
        START_SUCCESS = r101;
        LiveWrappedMixedStreamTaskEvent r102 = new LiveWrappedMixedStreamTaskEvent("START_FAILED", 2, 2);
        START_FAILED = r102;
        LiveWrappedMixedStreamTaskEvent r103 = new LiveWrappedMixedStreamTaskEvent("UPDATE_SUCCESS", 3, 3);
        UPDATE_SUCCESS = r103;
        LiveWrappedMixedStreamTaskEvent r104 = new LiveWrappedMixedStreamTaskEvent("UPDATE_FAILED", 4, 4);
        UPDATE_FAILED = r104;
        LiveWrappedMixedStreamTaskEvent r105 = new LiveWrappedMixedStreamTaskEvent("STOP_SUCCESS", 5, 5);
        STOP_SUCCESS = r105;
        LiveWrappedMixedStreamTaskEvent r106 = new LiveWrappedMixedStreamTaskEvent("STOP_FAILED", 6, 6);
        STOP_FAILED = r106;
        LiveWrappedMixedStreamTaskEvent r107 = new LiveWrappedMixedStreamTaskEvent("WARNING", 7, 7);
        WARNING = r107;
        f147402a = new LiveWrappedMixedStreamTaskEvent[]{r100, r101, r102, r103, r104, r105, r106, r107};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(m.f18919a[ordinal()]) {
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
        return "WARNING";
    L6:
        return "STREAM_MIXING_STOP_FAILED";
    L7:
        return "STREAM_MIXING_STOP_SUCCESS";
    L8:
        return "UPDATE_FAILED";
    L9:
        return "UPDATE_SUCCESS";
    L10:
        return "START_FAILED";
    L11:
        return "START_SUCCESS";
    L12:
        return "BASE";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedMixedStreamTaskEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
