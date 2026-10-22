package com.android.ttcjpaysdk.integrated.counter.launch;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/launch/ActivityState;", "", "(Ljava/lang/String;I)V", ErrorCode.INIT, "ROUTING", "CREATED", "READY", "DESTROYED", "CANCELED", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ActivityState extends Enum<ActivityState> {
    private static final /* synthetic */ ActivityState[] $VALUES = null;
    public static final ActivityState CANCELED = null;
    public static final ActivityState CREATED = null;
    public static final ActivityState DESTROYED = null;
    public static final ActivityState INIT = null;
    public static final ActivityState READY = null;
    public static final ActivityState ROUTING = null;

    private static final /* synthetic */ ActivityState[] $values() {
        return new ActivityState[]{INIT, ROUTING, CREATED, READY, DESTROYED, CANCELED};
    }

    public static ActivityState valueOf(String r100) {
        return (ActivityState) a.a(ActivityState.class, r100);
    }

    public static ActivityState[] values() {
        return (ActivityState[]) $VALUES.clone();
    }

    static {
        INIT = new ActivityState(ErrorCode.INIT, 0);
        ROUTING = new ActivityState("ROUTING", 1);
        CREATED = new ActivityState("CREATED", 2);
        READY = new ActivityState("READY", 3);
        DESTROYED = new ActivityState("DESTROYED", 4);
        CANCELED = new ActivityState("CANCELED", 5);
        $VALUES = $values();
    }

    private ActivityState(String r100, int r101) {
        super(r100, r101);
    }
}
