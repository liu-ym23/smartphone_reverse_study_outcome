package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import zf2.x;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedMediaPlayerCustomSourceSeekWhence;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SET", "CUR", GXAnimation.STATE_END, "SIZE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMediaPlayerCustomSourceSeekWhence extends Enum<LiveWrappedMediaPlayerCustomSourceSeekWhence> {
    public static final LiveWrappedMediaPlayerCustomSourceSeekWhence CUR = null;
    public static final a Companion = null;
    public static final LiveWrappedMediaPlayerCustomSourceSeekWhence END = null;
    public static final LiveWrappedMediaPlayerCustomSourceSeekWhence SET = null;
    public static final LiveWrappedMediaPlayerCustomSourceSeekWhence SIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedMediaPlayerCustomSourceSeekWhence[] f147342a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedMediaPlayerCustomSourceSeekWhence$a] */
    static {
        LiveWrappedMediaPlayerCustomSourceSeekWhence r100 = new LiveWrappedMediaPlayerCustomSourceSeekWhence("SET", 0, 0);
        SET = r100;
        LiveWrappedMediaPlayerCustomSourceSeekWhence r101 = new LiveWrappedMediaPlayerCustomSourceSeekWhence("CUR", 1, 1);
        CUR = r101;
        LiveWrappedMediaPlayerCustomSourceSeekWhence r102 = new LiveWrappedMediaPlayerCustomSourceSeekWhence(GXAnimation.STATE_END, 2, 2);
        END = r102;
        LiveWrappedMediaPlayerCustomSourceSeekWhence r103 = new LiveWrappedMediaPlayerCustomSourceSeekWhence("SIZE", 3, 3);
        SIZE = r103;
        f147342a = new LiveWrappedMediaPlayerCustomSourceSeekWhence[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static LiveWrappedMediaPlayerCustomSourceSeekWhence valueOf(String r100) {
        return (LiveWrappedMediaPlayerCustomSourceSeekWhence) r27.a.a(LiveWrappedMediaPlayerCustomSourceSeekWhence.class, r100);
    }

    public static LiveWrappedMediaPlayerCustomSourceSeekWhence[] values() {
        return (LiveWrappedMediaPlayerCustomSourceSeekWhence[]) f147342a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = x.f571750a[ordinal()];
        if (r100 != 1) goto L5;
        return "SET";
    L5:
        if (r100 != 2) goto L7;
        return "CUR";
    L7:
        if (r100 != 3) goto L9;
        return GXAnimation.STATE_END;
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "SIZE";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedMediaPlayerCustomSourceSeekWhence(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
