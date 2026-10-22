package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedSEIStreamUpdateEvent;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "STREAM_ADD", "STREAM_REMOVE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSEIStreamUpdateEvent extends Enum<LiveWrappedSEIStreamUpdateEvent> {
    public static final a Companion = null;
    public static final LiveWrappedSEIStreamUpdateEvent STREAM_ADD = null;
    public static final LiveWrappedSEIStreamUpdateEvent STREAM_REMOVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSEIStreamUpdateEvent[] f147446a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSEIStreamUpdateEvent$a] */
    static {
        LiveWrappedSEIStreamUpdateEvent r100 = new LiveWrappedSEIStreamUpdateEvent("STREAM_ADD", 0, 0);
        STREAM_ADD = r100;
        LiveWrappedSEIStreamUpdateEvent r101 = new LiveWrappedSEIStreamUpdateEvent("STREAM_REMOVE", 1, 1);
        STREAM_REMOVE = r101;
        f147446a = new LiveWrappedSEIStreamUpdateEvent[]{r100, r101};
        Companion = new a();
    }

    public static LiveWrappedSEIStreamUpdateEvent valueOf(String r100) {
        return (LiveWrappedSEIStreamUpdateEvent) r27.a.a(LiveWrappedSEIStreamUpdateEvent.class, r100);
    }

    public static LiveWrappedSEIStreamUpdateEvent[] values() {
        return (LiveWrappedSEIStreamUpdateEvent[]) f147446a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public final int value() {
        return this.value;
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public LiveWrappedSEIStreamUpdateEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
