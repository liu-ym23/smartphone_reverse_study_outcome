package androidx.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"androidx/room/FtsOptions$Order", "", "Landroidx/room/FtsOptions$Order;", "<init>", "(Ljava/lang/String;I)V", "ASC", "DESC", "room-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum FtsOptions$Order extends Enum<FtsOptions$Order> {
    private static final /* synthetic */ FtsOptions$Order[] $VALUES = null;
    public static final FtsOptions$Order ASC = null;
    public static final FtsOptions$Order DESC = null;

    private static final /* synthetic */ FtsOptions$Order[] $values() {
        return new FtsOptions$Order[]{ASC, DESC};
    }

    static {
        ASC = new FtsOptions$Order("ASC", 0);
        DESC = new FtsOptions$Order("DESC", 1);
        $VALUES = $values();
    }

    private FtsOptions$Order(String r10, int r11) {
        super(r10, r11);
    }

    public static FtsOptions$Order valueOf(String r10) {
        return (FtsOptions$Order) Enum.valueOf(FtsOptions$Order.class, r10);
    }

    public static FtsOptions$Order[] values() {
        return (FtsOptions$Order[]) $VALUES.clone();
    }
}
