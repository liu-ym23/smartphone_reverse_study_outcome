package com.bytedance.android.livesdk.end;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/end/WindowCardType;", "", "", "type", "J", "getType", "()J", "NO_COMPONENT", "WINDOW_RANK", "SHOP_CARD", "SECURITY_CARD", "VIP_END", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WindowCardType extends Enum<WindowCardType> {
    public static final WindowCardType NO_COMPONENT = null;
    public static final WindowCardType SECURITY_CARD = null;
    public static final WindowCardType SHOP_CARD = null;
    public static final WindowCardType VIP_END = null;
    public static final WindowCardType WINDOW_RANK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowCardType[] f123296a = null;
    private final long type;

    static {
        WindowCardType r100 = new WindowCardType("NO_COMPONENT", 0, 0);
        NO_COMPONENT = r100;
        WindowCardType r101 = new WindowCardType("WINDOW_RANK", 1, 1);
        WINDOW_RANK = r101;
        WindowCardType r102 = new WindowCardType("SHOP_CARD", 2, 2);
        SHOP_CARD = r102;
        WindowCardType r103 = new WindowCardType("SECURITY_CARD", 3, 3);
        SECURITY_CARD = r103;
        WindowCardType r104 = new WindowCardType("VIP_END", 4, 4);
        VIP_END = r104;
        f123296a = new WindowCardType[]{r100, r101, r102, r103, r104};
    }

    public static WindowCardType valueOf(String r100) {
        return (WindowCardType) a.a(WindowCardType.class, r100);
    }

    public static WindowCardType[] values() {
        return (WindowCardType[]) f123296a.clone();
    }

    public final long getType() {
        return this.type;
    }

    public WindowCardType(String r100, int r101, long r102) {
        super(r100, r101);
        this.type = r102;
    }
}
