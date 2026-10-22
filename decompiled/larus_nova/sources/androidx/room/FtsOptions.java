package androidx.room;

/* JADX INFO: loaded from: classes17.dex */
public class FtsOptions {
    public static final String TOKENIZER_ICU = "icu";
    public static final String TOKENIZER_PORTER = "porter";
    public static final String TOKENIZER_SIMPLE = "simple";
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    public static final enum MatchInfo extends Enum<MatchInfo> {
        private static final /* synthetic */ MatchInfo[] $VALUES = null;
        public static final MatchInfo FTS3 = null;
        public static final MatchInfo FTS4 = null;

        static {
            MatchInfo r100 = new MatchInfo("FTS3", 0);
            FTS3 = r100;
            MatchInfo r101 = new MatchInfo("FTS4", 1);
            FTS4 = r101;
            $VALUES = new MatchInfo[]{r100, r101};
        }

        public static MatchInfo[] values() {
            return (MatchInfo[]) $VALUES.clone();
        }

        public static MatchInfo valueOf(String r100) {
            return (MatchInfo) r27.a.a(MatchInfo.class, r100);
        }

        private MatchInfo(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Order extends Enum<Order> {
        private static final /* synthetic */ Order[] $VALUES = null;
        public static final Order ASC = null;
        public static final Order DESC = null;

        static {
            Order r100 = new Order("ASC", 0);
            ASC = r100;
            Order r101 = new Order("DESC", 1);
            DESC = r101;
            $VALUES = new Order[]{r100, r101};
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }

        public static Order valueOf(String r100) {
            return (Order) r27.a.a(Order.class, r100);
        }

        private Order(String r100, int r101) {
            super(r100, r101);
        }
    }

    private FtsOptions() {
    }
}
