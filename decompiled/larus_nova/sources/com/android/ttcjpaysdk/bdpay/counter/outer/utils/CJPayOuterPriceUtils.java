package com.android.ttcjpaysdk.bdpay.counter.outer.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayOuterPriceUtils;", "", "()V", "buildMapKay", "", "promotionScene", "useRetainReward", "", "StandardMapKey", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOuterPriceUtils {
    public static final CJPayOuterPriceUtils INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayOuterPriceUtils$StandardMapKey;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "DEFAULT", "PAY_AND_X", "CHOOSE", "COLLECTED_RETAIN", "PAY_AND_X_RETAIN", "RETAIN", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum StandardMapKey extends Enum<StandardMapKey> {
        private static final /* synthetic */ StandardMapKey[] $VALUES = null;
        public static final StandardMapKey CHOOSE = null;
        public static final StandardMapKey COLLECTED_RETAIN = null;
        public static final StandardMapKey DEFAULT = null;
        public static final StandardMapKey PAY_AND_X = null;
        public static final StandardMapKey PAY_AND_X_RETAIN = null;
        public static final StandardMapKey RETAIN = null;
        private final String key;

        private static final /* synthetic */ StandardMapKey[] $values() {
            return new StandardMapKey[]{DEFAULT, PAY_AND_X, CHOOSE, COLLECTED_RETAIN, PAY_AND_X_RETAIN, RETAIN};
        }

        public static StandardMapKey valueOf(String r100) {
            return (StandardMapKey) a.a(StandardMapKey.class, r100);
        }

        public static StandardMapKey[] values() {
            return (StandardMapKey[]) $VALUES.clone();
        }

        static {
            DEFAULT = new StandardMapKey("DEFAULT", 0, "default");
            PAY_AND_X = new StandardMapKey("PAY_AND_X", 1, "pay_and_x");
            CHOOSE = new StandardMapKey("CHOOSE", 2, "choose");
            COLLECTED_RETAIN = new StandardMapKey("COLLECTED_RETAIN", 3, "collected_retain");
            PAY_AND_X_RETAIN = new StandardMapKey("PAY_AND_X_RETAIN", 4, "pay_and_x_retain");
            RETAIN = new StandardMapKey("RETAIN", 5, "retain");
            $VALUES = $values();
        }

        public final String getKey() {
            return this.key;
        }

        private StandardMapKey(String r100, int r101, String r102) {
            super(r100, r101);
            this.key = r102;
        }
    }

    static {
        INSTANCE = new CJPayOuterPriceUtils();
    }

    private CJPayOuterPriceUtils() {
    }

    public final String buildMapKay(String r100, boolean r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        StandardMapKey r102 = StandardMapKey.PAY_AND_X;
        if (Intrinsics.areEqual(r100, r102.getKey()) == false) goto L10;
        if (r101 == false) goto L17;
        r102 = StandardMapKey.PAY_AND_X_RETAIN;
    L17:
        return r102.getKey();
    L10:
        if ((!StringsKt.isBlank(r100)) == true) goto L19;
        if (r101 == false) goto L15;
        return StandardMapKey.COLLECTED_RETAIN.getKey();
    L15:
        return StandardMapKey.DEFAULT.getKey();
    L19:
        return r100;
    }

    public static /* synthetic */ String buildMapKay$default(CJPayOuterPriceUtils r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.buildMapKay(r101, r102);
    }
}
