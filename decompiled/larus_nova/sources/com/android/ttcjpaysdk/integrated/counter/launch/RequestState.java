package com.android.ttcjpaysdk.integrated.counter.launch;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/launch/RequestState;", "", "(Ljava/lang/String;I)V", ErrorCode.INIT, "REQUESTING", "REQUEST_SUCCESS", "REQUEST_FAILURE", "CANCELED", "TIMEOUT", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum RequestState extends Enum<RequestState> {
    private static final /* synthetic */ RequestState[] $VALUES = null;
    public static final RequestState CANCELED = null;
    public static final RequestState INIT = null;
    public static final RequestState REQUESTING = null;
    public static final RequestState REQUEST_FAILURE = null;
    public static final RequestState REQUEST_SUCCESS = null;
    public static final RequestState TIMEOUT = null;

    private static final /* synthetic */ RequestState[] $values() {
        return new RequestState[]{INIT, REQUESTING, REQUEST_SUCCESS, REQUEST_FAILURE, CANCELED, TIMEOUT};
    }

    public static RequestState valueOf(String r100) {
        return (RequestState) a.a(RequestState.class, r100);
    }

    public static RequestState[] values() {
        return (RequestState[]) $VALUES.clone();
    }

    static {
        INIT = new RequestState(ErrorCode.INIT, 0);
        REQUESTING = new RequestState("REQUESTING", 1);
        REQUEST_SUCCESS = new RequestState("REQUEST_SUCCESS", 2);
        REQUEST_FAILURE = new RequestState("REQUEST_FAILURE", 3);
        CANCELED = new RequestState("CANCELED", 4);
        TIMEOUT = new RequestState("TIMEOUT", 5);
        $VALUES = $values();
    }

    private RequestState(String r100, int r101) {
        super(r100, r101);
    }
}
