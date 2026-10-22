package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public class FtsOptions {
    public static final String TOKENIZER_ICU = "icu";
    public static final String TOKENIZER_PORTER = "porter";
    public static final String TOKENIZER_SIMPLE = "simple";
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    public static final enum MatchInfo extends Enum<MatchInfo> {
        private static final /* synthetic */ MatchInfo[] $VALUES = null;
        public static final MatchInfo FTS3 = null;
        public static final MatchInfo FTS4 = null;

        private MatchInfo(String r1, int r2) {
            super(r1, r2);
        }

        public static MatchInfo valueOf(String r1) {
            return (MatchInfo) Enum.valueOf(MatchInfo.class, r1);
        }

        public static MatchInfo[] values() {
            return (MatchInfo[]) $VALUES.clone();
        }

        static {
            MatchInfo r0 = new MatchInfo("FTS3", 0);
            FTS3 = r0;
            MatchInfo r1 = new MatchInfo("FTS4", 1);
            FTS4 = r1;
            $VALUES = new MatchInfo[]{r0, r1};
        }
    }

    public static final enum Order extends Enum<Order> {
        private static final /* synthetic */ Order[] $VALUES = null;
        public static final Order ASC = null;
        public static final Order DESC = null;

        private Order(String r1, int r2) {
            super(r1, r2);
        }

        public static Order valueOf(String r1) {
            return (Order) Enum.valueOf(Order.class, r1);
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }

        static {
            Order r0 = new Order("ASC", 0);
            ASC = r0;
            Order r1 = new Order("DESC", 1);
            DESC = r1;
            $VALUES = new Order[]{r0, r1};
        }
    }

    private FtsOptions() {
    }
}
