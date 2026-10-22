package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine;

import com.alipay.sdk.m.u.i;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveWrappedSubscribeConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f147305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveWrappedSVCLayer f147306b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedSubscribeConfig$LiveWrappedSVCLayer;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DEFAULT", "BASE", AccountType.MAIN, "HIGH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveWrappedSVCLayer extends Enum<LiveWrappedSVCLayer> {
        public static final LiveWrappedSVCLayer BASE = null;
        public static final a Companion = null;
        public static final LiveWrappedSVCLayer DEFAULT = null;
        public static final LiveWrappedSVCLayer HIGH = null;
        public static final LiveWrappedSVCLayer MAIN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveWrappedSVCLayer[] f147307a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveWrappedSVCLayer r100 = new LiveWrappedSVCLayer("DEFAULT", 0, 0);
            DEFAULT = r100;
            LiveWrappedSVCLayer r101 = new LiveWrappedSVCLayer("BASE", 1, 1);
            BASE = r101;
            LiveWrappedSVCLayer r102 = new LiveWrappedSVCLayer(AccountType.MAIN, 2, 2);
            MAIN = r102;
            LiveWrappedSVCLayer r103 = new LiveWrappedSVCLayer("HIGH", 3, 3);
            HIGH = r103;
            f147307a = new LiveWrappedSVCLayer[]{r100, r101, r102, r103};
            Companion = new a();
        }

        public static LiveWrappedSVCLayer valueOf(String r100) {
            return (LiveWrappedSVCLayer) r27.a.a(LiveWrappedSVCLayer.class, r100);
        }

        public static LiveWrappedSVCLayer[] values() {
            return (LiveWrappedSVCLayer[]) f147307a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LiveWrappedSVCLayer(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "SubscribeConfig{isScreen=false, subVideo=false, subAudio=false, videoIndex=0, svcLayer=" + this.f147306b + ", sub_width=0, sub_height=0, sub_video_index=" + this.f147305a + i.f25855d;
    }

    public LiveWrappedSubscribeConfig() {
        this.f147305a = -1;
        this.f147306b = LiveWrappedSVCLayer.DEFAULT;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L15:
        return false;
    L8:
        if ((!Intrinsics.areEqual(LiveWrappedSubscribeConfig.class, r100.getClass())) == true) goto L15;
        if (this.f147306b == ((LiveWrappedSubscribeConfig) r100).f147306b) goto L16;
        return false;
    L16:
        return true;
    }
}
