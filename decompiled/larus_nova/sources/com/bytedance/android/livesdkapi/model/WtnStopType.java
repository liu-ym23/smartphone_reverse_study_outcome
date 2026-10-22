package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/WtnStopType;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WtnStopType {
    public static final Companion Companion = null;
    private static final int STOP_WTN_TYPE_FALLBACK = 0;
    private static final int STOP_WTN_TYPE_NORMAL = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/WtnStopType$Companion;", "", "()V", "STOP_WTN_TYPE_FALLBACK", "", "getSTOP_WTN_TYPE_FALLBACK", "()I", "STOP_WTN_TYPE_NORMAL", "getSTOP_WTN_TYPE_NORMAL", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final int getSTOP_WTN_TYPE_FALLBACK() {
            return WtnStopType.access$getSTOP_WTN_TYPE_FALLBACK$cp();
        }

        public final int getSTOP_WTN_TYPE_NORMAL() {
            return WtnStopType.access$getSTOP_WTN_TYPE_NORMAL$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public WtnStopType() {
    }

    static {
        Companion = new Companion(null);
        STOP_WTN_TYPE_FALLBACK = 1;
    }

    public static final /* synthetic */ int access$getSTOP_WTN_TYPE_FALLBACK$cp() {
        return STOP_WTN_TYPE_FALLBACK;
    }

    public static final /* synthetic */ int access$getSTOP_WTN_TYPE_NORMAL$cp() {
        return STOP_WTN_TYPE_NORMAL;
    }
}
