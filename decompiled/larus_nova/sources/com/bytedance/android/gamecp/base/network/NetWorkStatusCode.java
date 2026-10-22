package com.bytedance.android.gamecp.base.network;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/base/network/NetWorkStatusCode;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "NOT_SUPPORT_FORIGNER", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NetWorkStatusCode extends Enum<NetWorkStatusCode> {
    public static final NetWorkStatusCode NOT_SUPPORT_FORIGNER = null;
    public static final NetWorkStatusCode SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetWorkStatusCode[] f51683a = null;
    private final int value;

    static {
        NetWorkStatusCode r100 = new NetWorkStatusCode("SUCCESS", 0, 200);
        SUCCESS = r100;
        NetWorkStatusCode r101 = new NetWorkStatusCode("NOT_SUPPORT_FORIGNER", 1, 4014671);
        NOT_SUPPORT_FORIGNER = r101;
        f51683a = new NetWorkStatusCode[]{r100, r101};
    }

    public static NetWorkStatusCode valueOf(String r100) {
        return (NetWorkStatusCode) a.a(NetWorkStatusCode.class, r100);
    }

    public static NetWorkStatusCode[] values() {
        return (NetWorkStatusCode[]) f51683a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public NetWorkStatusCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
