package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.p;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedColorSpace;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "BT601_LIMITED_RANGE", "BT601_FULL_RANGE", "BT709_LIMITED_RANGE", "BT709_FULL_RANGE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedColorSpace extends Enum<LiveWrappedColorSpace> {
    public static final LiveWrappedColorSpace BT601_FULL_RANGE = null;
    public static final LiveWrappedColorSpace BT601_LIMITED_RANGE = null;
    public static final LiveWrappedColorSpace BT709_FULL_RANGE = null;
    public static final LiveWrappedColorSpace BT709_LIMITED_RANGE = null;
    public static final a Companion = null;
    public static final LiveWrappedColorSpace UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedColorSpace[] f147333a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedColorSpace$a] */
    static {
        LiveWrappedColorSpace r100 = new LiveWrappedColorSpace("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        LiveWrappedColorSpace r101 = new LiveWrappedColorSpace("BT601_LIMITED_RANGE", 1, 1);
        BT601_LIMITED_RANGE = r101;
        LiveWrappedColorSpace r102 = new LiveWrappedColorSpace("BT601_FULL_RANGE", 2, 2);
        BT601_FULL_RANGE = r102;
        LiveWrappedColorSpace r103 = new LiveWrappedColorSpace("BT709_LIMITED_RANGE", 3, 3);
        BT709_LIMITED_RANGE = r103;
        LiveWrappedColorSpace r104 = new LiveWrappedColorSpace("BT709_FULL_RANGE", 4, 4);
        BT709_FULL_RANGE = r104;
        f147333a = new LiveWrappedColorSpace[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static LiveWrappedColorSpace valueOf(String r100) {
        return (LiveWrappedColorSpace) r27.a.a(LiveWrappedColorSpace.class, r100);
    }

    public static LiveWrappedColorSpace[] values() {
        return (LiveWrappedColorSpace[]) f147333a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = p.f571738a[ordinal()];
        if (r100 != 1) goto L5;
        return "kColorSpaceYCbCrBT601LimitedRange";
    L5:
        if (r100 != 2) goto L7;
        return "kColorSpaceYCbCrBT601FullRange";
    L7:
        if (r100 != 3) goto L9;
        return "kColorSpaceYCbCrBT709LimitedRange";
    L9:
        if (r100 == 4) goto L12;
        return "kColorSpaceUnknown";
    L12:
        return "kColorSpaceYCbCrBT709FullRange";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedColorSpace(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
