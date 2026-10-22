package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CreateType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "FIRST", "AGAIN", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CreateType extends Enum<CreateType> {
    private static final /* synthetic */ CreateType[] $VALUES = null;
    public static final CreateType AGAIN = null;
    public static final Companion Companion = null;
    public static final CreateType FIRST = null;
    public static final CreateType UNKNOWN = null;
    private final String value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CreateType$Companion;", "", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        CreateType r100 = new CreateType("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        CreateType r101 = new CreateType("FIRST", 1, GearStrategyConsts.EV_SELECT_BEGIN);
        FIRST = r101;
        CreateType r102 = new CreateType("AGAIN", 2, "again");
        AGAIN = r102;
        $VALUES = new CreateType[]{r100, r101, r102};
        Companion = new Companion(null);
    }

    public static CreateType valueOf(String r100) {
        return (CreateType) a.a(CreateType.class, r100);
    }

    public static CreateType[] values() {
        return (CreateType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    private CreateType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
