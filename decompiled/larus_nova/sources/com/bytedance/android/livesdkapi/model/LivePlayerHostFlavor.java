package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePlayerHostFlavor;", "", "(Ljava/lang/String;I)V", "DOU_YIN", "DOU_YIN_LITE", "HOT_SOON", "SAAS", "DEFAULT", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePlayerHostFlavor extends Enum<LivePlayerHostFlavor> {
    private static final /* synthetic */ LivePlayerHostFlavor[] $VALUES = null;
    public static final LivePlayerHostFlavor DEFAULT = null;
    public static final LivePlayerHostFlavor DOU_YIN = null;
    public static final LivePlayerHostFlavor DOU_YIN_LITE = null;
    public static final LivePlayerHostFlavor HOT_SOON = null;
    public static final LivePlayerHostFlavor SAAS = null;

    static {
        LivePlayerHostFlavor r100 = new LivePlayerHostFlavor("DOU_YIN", 0);
        DOU_YIN = r100;
        LivePlayerHostFlavor r101 = new LivePlayerHostFlavor("DOU_YIN_LITE", 1);
        DOU_YIN_LITE = r101;
        LivePlayerHostFlavor r102 = new LivePlayerHostFlavor("HOT_SOON", 2);
        HOT_SOON = r102;
        LivePlayerHostFlavor r103 = new LivePlayerHostFlavor("SAAS", 3);
        SAAS = r103;
        LivePlayerHostFlavor r104 = new LivePlayerHostFlavor("DEFAULT", 4);
        DEFAULT = r104;
        $VALUES = new LivePlayerHostFlavor[]{r100, r101, r102, r103, r104};
    }

    public static LivePlayerHostFlavor valueOf(String r100) {
        return (LivePlayerHostFlavor) a.a(LivePlayerHostFlavor.class, r100);
    }

    public static LivePlayerHostFlavor[] values() {
        return (LivePlayerHostFlavor[]) $VALUES.clone();
    }

    private LivePlayerHostFlavor(String r100, int r101) {
        super(r100, r101);
    }
}
