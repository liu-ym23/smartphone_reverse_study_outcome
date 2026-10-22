package android.ss.com.vboost.request;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;

/* JADX INFO: loaded from: classes2.dex */
final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f4735b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ c[] f4736c = null;

    static {
        c r100 = new c("DIRECT", 0, 0);
        f4734a = r100;
        c r101 = new c(BridgeSyncType.ASYNC, 1, 1);
        f4735b = r101;
        f4736c = new c[]{r100, r101};
    }

    private c(String r100, int r101, int r102) {
        super(r100, r101);
    }

    public static c valueOf(String r100) {
        return (c) r27.a.a(c.class, r100);
    }

    public static c[] values() {
        return (c[]) f4736c.clone();
    }
}
