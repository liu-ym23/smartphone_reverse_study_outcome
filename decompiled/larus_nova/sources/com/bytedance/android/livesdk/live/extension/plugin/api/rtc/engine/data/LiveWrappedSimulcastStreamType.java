package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.m0;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedSimulcastStreamType;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SIMULCAST_STREAM_TYPE_WEAK", "SIMULCAST_STREAM_TYPE_LOW", "SIMULCAST_STREAM_TYPE_MID", "SIMULCAST_STREAM_TYPE_HIGH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSimulcastStreamType extends Enum<LiveWrappedSimulcastStreamType> {
    public static final a Companion = null;
    public static final LiveWrappedSimulcastStreamType SIMULCAST_STREAM_TYPE_HIGH = null;
    public static final LiveWrappedSimulcastStreamType SIMULCAST_STREAM_TYPE_LOW = null;
    public static final LiveWrappedSimulcastStreamType SIMULCAST_STREAM_TYPE_MID = null;
    public static final LiveWrappedSimulcastStreamType SIMULCAST_STREAM_TYPE_WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSimulcastStreamType[] f147356a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSimulcastStreamType$a] */
    static {
        LiveWrappedSimulcastStreamType r100 = new LiveWrappedSimulcastStreamType("SIMULCAST_STREAM_TYPE_WEAK", 0, 0);
        SIMULCAST_STREAM_TYPE_WEAK = r100;
        LiveWrappedSimulcastStreamType r101 = new LiveWrappedSimulcastStreamType("SIMULCAST_STREAM_TYPE_LOW", 1, 1);
        SIMULCAST_STREAM_TYPE_LOW = r101;
        LiveWrappedSimulcastStreamType r102 = new LiveWrappedSimulcastStreamType("SIMULCAST_STREAM_TYPE_MID", 2, 2);
        SIMULCAST_STREAM_TYPE_MID = r102;
        LiveWrappedSimulcastStreamType r103 = new LiveWrappedSimulcastStreamType("SIMULCAST_STREAM_TYPE_HIGH", 3, 3);
        SIMULCAST_STREAM_TYPE_HIGH = r103;
        f147356a = new LiveWrappedSimulcastStreamType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedSimulcastStreamType valueOf(String r100) {
        return (LiveWrappedSimulcastStreamType) r27.a.a(LiveWrappedSimulcastStreamType.class, r100);
    }

    public static LiveWrappedSimulcastStreamType[] values() {
        return (LiveWrappedSimulcastStreamType[]) f147356a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = m0.f571734a[ordinal()];
        if (r100 != 1) goto L5;
        return "kSimulcastStreamTypeWeak";
    L5:
        if (r100 != 2) goto L7;
        return "kSimulcastStreamTypeLow";
    L7:
        if (r100 != 3) goto L9;
        return "kSimulcastStreamTypeMid";
    L9:
        if (r100 == 4) goto L12;
        return "valid";
    L12:
        return "kSimulcastStreamTypeHigh";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSimulcastStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
