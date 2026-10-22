package com.zyql.protobuf.runtime;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class RequestAck$AckTypeCase {

    /* renamed from: a, reason: collision with root package name */
    public static final RequestAck$AckTypeCase f4277a;
    public static final RequestAck$AckTypeCase b;
    public static final RequestAck$AckTypeCase c;
    public static final RequestAck$AckTypeCase d;
    public static final /* synthetic */ RequestAck$AckTypeCase[] e;

    static {
        RequestAck$AckTypeCase requestAck$AckTypeCase = new RequestAck$AckTypeCase("START_AGENT_ACK", 0);
        f4277a = requestAck$AckTypeCase;
        RequestAck$AckTypeCase requestAck$AckTypeCase2 = new RequestAck$AckTypeCase("SEND_INPUT_ACK", 1);
        b = requestAck$AckTypeCase2;
        RequestAck$AckTypeCase requestAck$AckTypeCase3 = new RequestAck$AckTypeCase("CANCEL_ACK", 2);
        c = requestAck$AckTypeCase3;
        RequestAck$AckTypeCase requestAck$AckTypeCase4 = new RequestAck$AckTypeCase("ACKTYPE_NOT_SET", 3);
        d = requestAck$AckTypeCase4;
        e = new RequestAck$AckTypeCase[]{requestAck$AckTypeCase, requestAck$AckTypeCase2, requestAck$AckTypeCase3, requestAck$AckTypeCase4};
    }

    public static RequestAck$AckTypeCase valueOf(String str) {
        return (RequestAck$AckTypeCase) Enum.valueOf(RequestAck$AckTypeCase.class, str);
    }

    public static RequestAck$AckTypeCase[] values() {
        return (RequestAck$AckTypeCase[]) e.clone();
    }
}
