package com.android.ttcjpaysdk.integrated.sign.counter.session;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/session/SignPreRouteSessionState;", "", "(Ljava/lang/String;I)V", "CREATED", "REQUESTING", "FINISHED", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum SignPreRouteSessionState extends Enum<SignPreRouteSessionState> {
    private static final /* synthetic */ SignPreRouteSessionState[] $VALUES = null;
    public static final SignPreRouteSessionState CREATED = null;
    public static final SignPreRouteSessionState FINISHED = null;
    public static final SignPreRouteSessionState REQUESTING = null;

    private static final /* synthetic */ SignPreRouteSessionState[] $values() {
        return new SignPreRouteSessionState[]{CREATED, REQUESTING, FINISHED};
    }

    public static SignPreRouteSessionState valueOf(String r100) {
        return (SignPreRouteSessionState) a.a(SignPreRouteSessionState.class, r100);
    }

    public static SignPreRouteSessionState[] values() {
        return (SignPreRouteSessionState[]) $VALUES.clone();
    }

    static {
        CREATED = new SignPreRouteSessionState("CREATED", 0);
        REQUESTING = new SignPreRouteSessionState("REQUESTING", 1);
        FINISHED = new SignPreRouteSessionState("FINISHED", 2);
        $VALUES = $values();
    }

    private SignPreRouteSessionState(String r100, int r101) {
        super(r100, r101);
    }
}
