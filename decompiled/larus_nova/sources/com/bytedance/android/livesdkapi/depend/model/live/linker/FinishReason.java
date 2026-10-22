package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/FinishReason;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", EffectConstants.NORMAL, "CUT_SHORT", "FALLBACK", "SCENE_CHANGED", "COND_LIMIT", "LINKMIC_CLOSE", "LIVE_CLOSE", "PLAY_MODE_CONTROL", "AGAIN", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FinishReason extends Enum<FinishReason> {
    private static final /* synthetic */ FinishReason[] $VALUES = null;
    public static final FinishReason AGAIN = null;
    public static final FinishReason COND_LIMIT = null;
    public static final FinishReason CUT_SHORT = null;
    public static final Companion Companion = null;
    public static final FinishReason FALLBACK = null;
    public static final FinishReason LINKMIC_CLOSE = null;
    public static final FinishReason LIVE_CLOSE = null;
    public static final FinishReason NORMAL = null;
    public static final FinishReason PLAY_MODE_CONTROL = null;
    public static final FinishReason SCENE_CHANGED = null;
    public static final FinishReason UNKNOWN = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/FinishReason$Companion;", "", "()V", "fromInt", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/FinishReason;", "value", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final FinishReason fromInt(int r100) {
            FinishReason[] r101 = FinishReason.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            FinishReason r104 = r101[r103];
            if (r104.getValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return FinishReason.UNKNOWN;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static FinishReason valueOf(String r100) {
        return (FinishReason) a.a(FinishReason.class, r100);
    }

    public static FinishReason[] values() {
        return (FinishReason[]) $VALUES.clone();
    }

    static {
        FinishReason r100 = new FinishReason("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        FinishReason r101 = new FinishReason(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        FinishReason r102 = new FinishReason("CUT_SHORT", 2, 2);
        CUT_SHORT = r102;
        FinishReason r103 = new FinishReason("FALLBACK", 3, 3);
        FALLBACK = r103;
        FinishReason r104 = new FinishReason("SCENE_CHANGED", 4, 4);
        SCENE_CHANGED = r104;
        FinishReason r105 = new FinishReason("COND_LIMIT", 5, 5);
        COND_LIMIT = r105;
        FinishReason r106 = new FinishReason("LINKMIC_CLOSE", 6, 6);
        LINKMIC_CLOSE = r106;
        FinishReason r107 = new FinishReason("LIVE_CLOSE", 7, 7);
        LIVE_CLOSE = r107;
        FinishReason r108 = new FinishReason("PLAY_MODE_CONTROL", 8, 8);
        PLAY_MODE_CONTROL = r108;
        FinishReason r109 = new FinishReason("AGAIN", 9, 100);
        AGAIN = r109;
        $VALUES = new FinishReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        Companion = new Companion(null);
    }

    public final int getValue() {
        return this.value;
    }

    private FinishReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
