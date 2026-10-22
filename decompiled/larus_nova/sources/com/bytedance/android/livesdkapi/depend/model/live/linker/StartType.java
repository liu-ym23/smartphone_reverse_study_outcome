package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/StartType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "START_AGAIN", "START_WITH_SWITCH_SCENE", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum StartType extends Enum<StartType> {
    private static final /* synthetic */ StartType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final StartType START_AGAIN = null;
    public static final StartType START_WITH_SWITCH_SCENE = null;
    public static final StartType UNKNOWN = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/StartType$Companion;", "", "()V", "fromInt", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/StartType;", "value", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final StartType fromInt(int r100) {
            StartType[] r101 = StartType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            StartType r104 = r101[r103];
            if (r104.getValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return StartType.UNKNOWN;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    static {
        StartType r100 = new StartType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        StartType r101 = new StartType("START_AGAIN", 1, 1);
        START_AGAIN = r101;
        StartType r102 = new StartType("START_WITH_SWITCH_SCENE", 2, 100);
        START_WITH_SWITCH_SCENE = r102;
        $VALUES = new StartType[]{r100, r101, r102};
        Companion = new Companion(null);
    }

    public static StartType valueOf(String r100) {
        return (StartType) a.a(StartType.class, r100);
    }

    public static StartType[] values() {
        return (StartType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private StartType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
