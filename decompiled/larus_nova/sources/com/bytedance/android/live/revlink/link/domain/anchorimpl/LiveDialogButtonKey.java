package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/anchorimpl/LiveDialogButtonKey;", "", "HORIZONTAL_1", "HORIZONTAL_2", "VERTICAL_1", "VERTICAL_2", "VERTICAL_3", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveDialogButtonKey extends Enum<LiveDialogButtonKey> {
    public static final LiveDialogButtonKey HORIZONTAL_1 = null;
    public static final LiveDialogButtonKey HORIZONTAL_2 = null;
    public static final LiveDialogButtonKey VERTICAL_1 = null;
    public static final LiveDialogButtonKey VERTICAL_2 = null;
    public static final LiveDialogButtonKey VERTICAL_3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDialogButtonKey[] f98411a = null;

    static {
        LiveDialogButtonKey r100 = new LiveDialogButtonKey("HORIZONTAL_1", 0);
        HORIZONTAL_1 = r100;
        LiveDialogButtonKey r101 = new LiveDialogButtonKey("HORIZONTAL_2", 1);
        HORIZONTAL_2 = r101;
        LiveDialogButtonKey r102 = new LiveDialogButtonKey("VERTICAL_1", 2);
        VERTICAL_1 = r102;
        LiveDialogButtonKey r103 = new LiveDialogButtonKey("VERTICAL_2", 3);
        VERTICAL_2 = r103;
        LiveDialogButtonKey r104 = new LiveDialogButtonKey("VERTICAL_3", 4);
        VERTICAL_3 = r104;
        f98411a = new LiveDialogButtonKey[]{r100, r101, r102, r103, r104};
    }

    public static LiveDialogButtonKey valueOf(String r100) {
        return (LiveDialogButtonKey) r27.a.a(LiveDialogButtonKey.class, r100);
    }

    public static LiveDialogButtonKey[] values() {
        return (LiveDialogButtonKey[]) f98411a.clone();
    }

    public LiveDialogButtonKey(String r100, int r101) {
        super(r100, r101);
    }
}
