package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ResultType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "VICTORY", "FAIL", "DRAW", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ResultType extends Enum<ResultType> {
    private static final /* synthetic */ ResultType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ResultType DRAW = null;
    public static final ResultType FAIL = null;
    public static final ResultType NONE = null;
    public static final ResultType VICTORY = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ResultType$Companion;", "", "()V", "fromInt", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ResultType;", "value", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ResultType fromInt(int r100) {
            ResultType[] r101 = ResultType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            ResultType r104 = r101[r103];
            if (r104.getValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return ResultType.NONE;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    static {
        ResultType r100 = new ResultType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ResultType r101 = new ResultType("VICTORY", 1, 1);
        VICTORY = r101;
        ResultType r102 = new ResultType("FAIL", 2, 2);
        FAIL = r102;
        ResultType r103 = new ResultType("DRAW", 3, 3);
        DRAW = r103;
        $VALUES = new ResultType[]{r100, r101, r102, r103};
        Companion = new Companion(null);
    }

    public static ResultType valueOf(String r100) {
        return (ResultType) a.a(ResultType.class, r100);
    }

    public static ResultType[] values() {
        return (ResultType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private ResultType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
