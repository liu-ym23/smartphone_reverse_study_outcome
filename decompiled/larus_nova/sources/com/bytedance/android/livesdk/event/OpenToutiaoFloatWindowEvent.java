package com.bytedance.android.livesdk.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public final class OpenToutiaoFloatWindowEvent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/event/OpenToutiaoFloatWindowEvent$FloatWindowSource;", "", "", "logString", "Ljava/lang/String;", "getLogString", "()Ljava/lang/String;", "SMALL_WINDOW_BUTTON", "BACK_BUTTON", "POPUP", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FloatWindowSource extends Enum<FloatWindowSource> {
        public static final FloatWindowSource BACK_BUTTON = null;
        public static final FloatWindowSource POPUP = null;
        public static final FloatWindowSource SMALL_WINDOW_BUTTON = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FloatWindowSource[] f123313a = null;
        private final String logString;

        static {
            FloatWindowSource r100 = new FloatWindowSource("SMALL_WINDOW_BUTTON", 0, "small_window_button");
            SMALL_WINDOW_BUTTON = r100;
            FloatWindowSource r101 = new FloatWindowSource("BACK_BUTTON", 1, "back_button");
            BACK_BUTTON = r101;
            FloatWindowSource r102 = new FloatWindowSource("POPUP", 2, "popup");
            POPUP = r102;
            f123313a = new FloatWindowSource[]{r100, r101, r102};
        }

        public static FloatWindowSource valueOf(String r100) {
            return (FloatWindowSource) r27.a.a(FloatWindowSource.class, r100);
        }

        public static FloatWindowSource[] values() {
            return (FloatWindowSource[]) f123313a.clone();
        }

        public final String getLogString() {
            return this.logString;
        }

        public FloatWindowSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.logString = r102;
        }
    }
}
