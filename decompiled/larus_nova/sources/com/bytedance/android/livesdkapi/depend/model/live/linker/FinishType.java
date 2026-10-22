package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/FinishType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "FINISH_WITH_SWITCH_SCENE", "FINISH_NORMAL", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FinishType extends Enum<FinishType> {
    private static final /* synthetic */ FinishType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final FinishType FINISH_NORMAL = null;
    public static final FinishType FINISH_WITH_SWITCH_SCENE = null;
    public static final FinishType UNKNOWN = null;
    private final int value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/FinishType$Companion;", "", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        FinishType r100 = new FinishType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        FinishType r101 = new FinishType("FINISH_WITH_SWITCH_SCENE", 1, 1);
        FINISH_WITH_SWITCH_SCENE = r101;
        FinishType r102 = new FinishType("FINISH_NORMAL", 2, 2);
        FINISH_NORMAL = r102;
        $VALUES = new FinishType[]{r100, r101, r102};
        Companion = new Companion(null);
    }

    public static FinishType valueOf(String r100) {
        return (FinishType) a.a(FinishType.class, r100);
    }

    public static FinishType[] values() {
        return (FinishType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private FinishType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
