package com.bytedance.frameworks.baselib.network.asynctask;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetworkAsyncTaskType extends Enum<NetworkAsyncTaskType> {
    private static final /* synthetic */ NetworkAsyncTaskType[] $VALUES = null;
    public static final NetworkAsyncTaskType NETWORK = null;

    private NetworkAsyncTaskType(String r1, int r2) {
        super(r1, r2);
    }

    public static NetworkAsyncTaskType valueOf(String r1) {
        return (NetworkAsyncTaskType) Enum.valueOf(NetworkAsyncTaskType.class, r1);
    }

    public static NetworkAsyncTaskType[] values() {
        return (NetworkAsyncTaskType[]) $VALUES.clone();
    }

    static {
        NetworkAsyncTaskType r0 = new NetworkAsyncTaskType("NETWORK", 0);
        NETWORK = r0;
        $VALUES = new NetworkAsyncTaskType[]{r0};
    }
}
