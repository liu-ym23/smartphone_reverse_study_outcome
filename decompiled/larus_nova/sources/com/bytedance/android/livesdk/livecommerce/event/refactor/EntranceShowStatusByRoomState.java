package com.bytedance.android.livesdk.livecommerce.event.refactor;

import com.bytedance.android.livesdk.livecommerce.utils.LogRule;
import kh2.e;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/event/refactor/EntranceShowStatusByRoomState;", "", "Lkh2/e;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "YES", "NO", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceShowStatusByRoomState extends Enum<EntranceShowStatusByRoomState> implements e<String> {
    public static final EntranceShowStatusByRoomState NO = null;
    public static final EntranceShowStatusByRoomState YES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntranceShowStatusByRoomState[] f147747a = null;
    private final String value;

    static {
        EntranceShowStatusByRoomState r100 = new EntranceShowStatusByRoomState("YES", 0, "show_cart");
        YES = r100;
        EntranceShowStatusByRoomState r101 = new EntranceShowStatusByRoomState("NO", 1, LogRule.REQUIRE_NO_CART);
        NO = r101;
        f147747a = new EntranceShowStatusByRoomState[]{r100, r101};
    }

    public static EntranceShowStatusByRoomState valueOf(String r100) {
        return (EntranceShowStatusByRoomState) a.a(EntranceShowStatusByRoomState.class, r100);
    }

    public static EntranceShowStatusByRoomState[] values() {
        return (EntranceShowStatusByRoomState[]) f147747a.clone();
    }

    @Override // kh2.e
    public /* bridge */ /* synthetic */ String getValue() {
        return getValue2();
    }

    @Override // kh2.e
    /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
    public String getValue2() {
        return this.value;
    }

    public EntranceShowStatusByRoomState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
