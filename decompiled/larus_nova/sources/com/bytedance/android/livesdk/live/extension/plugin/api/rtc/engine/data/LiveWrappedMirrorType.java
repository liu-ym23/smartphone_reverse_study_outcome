package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedMirrorType;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MIRROR_TYPE_NONE", "MIRROR_TYPE_RENDER", "MIRROR_TYPE_RENDER_AND_ENCODER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMirrorType extends Enum<LiveWrappedMirrorType> {
    public static final a Companion = null;
    public static final LiveWrappedMirrorType MIRROR_TYPE_NONE = null;
    public static final LiveWrappedMirrorType MIRROR_TYPE_RENDER = null;
    public static final LiveWrappedMirrorType MIRROR_TYPE_RENDER_AND_ENCODER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMirrorType[] f147344a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedMirrorType$a] */
    static {
        LiveWrappedMirrorType r100 = new LiveWrappedMirrorType("MIRROR_TYPE_NONE", 0, 0);
        MIRROR_TYPE_NONE = r100;
        LiveWrappedMirrorType r101 = new LiveWrappedMirrorType("MIRROR_TYPE_RENDER", 1, 1);
        MIRROR_TYPE_RENDER = r101;
        LiveWrappedMirrorType r102 = new LiveWrappedMirrorType("MIRROR_TYPE_RENDER_AND_ENCODER", 2, 3);
        MIRROR_TYPE_RENDER_AND_ENCODER = r102;
        f147344a = new LiveWrappedMirrorType[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedMirrorType valueOf(String r100) {
        return (LiveWrappedMirrorType) r27.a.a(LiveWrappedMirrorType.class, r100);
    }

    public static LiveWrappedMirrorType[] values() {
        return (LiveWrappedMirrorType[]) f147344a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != MIRROR_TYPE_NONE) goto L7;
        return "kMirrorTypeNone";
    L7:
        if (this != MIRROR_TYPE_RENDER) goto L11;
        return "kMirrorTypeRender";
    L11:
        if (this != MIRROR_TYPE_RENDER_AND_ENCODER) goto L14;
        return "kMirrorTypeRenderAndEncoder";
    L14:
        return "";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedMirrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
