package com.slardaros.client.monitor.network.httpurlconnection;

/* JADX INFO: loaded from: classes4.dex */
final enum TransactionState$State extends Enum<TransactionState$State> {
    private static final /* synthetic */ TransactionState$State[] $VALUES = null;
    public static final TransactionState$State COMPLETE = null;
    public static final TransactionState$State READY = null;
    public static final TransactionState$State SENT = null;

    static {
        TransactionState$State r10 = new TransactionState$State("READY", 0);
        READY = r10;
        TransactionState$State r11 = new TransactionState$State("SENT", 1);
        SENT = r11;
        TransactionState$State r12 = new TransactionState$State("COMPLETE", 2);
        COMPLETE = r12;
        $VALUES = new TransactionState$State[]{r10, r11, r12};
    }

    private TransactionState$State(String r10, int r11) {
        super(r10, r11);
    }

    public static TransactionState$State valueOf(String r10) {
        return (TransactionState$State) Enum.valueOf(TransactionState$State.class, r10);
    }

    public static TransactionState$State[] values() {
        return (TransactionState$State[]) $VALUES.clone();
    }
}
