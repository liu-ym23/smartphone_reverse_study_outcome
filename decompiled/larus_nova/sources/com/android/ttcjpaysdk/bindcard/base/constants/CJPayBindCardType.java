package com.android.ttcjpaysdk.bindcard.base.constants;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/constants/CJPayBindCardType;", "", "mType", "", "mDesc", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", AccountType.ALL, "CREDIT", "DEBIT", "UPYSFBANK", "Companion", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJPayBindCardType extends Enum<CJPayBindCardType> {
    private static final /* synthetic */ CJPayBindCardType[] $VALUES = null;
    public static final CJPayBindCardType ALL = null;
    public static final CJPayBindCardType CREDIT = null;
    public static final Companion Companion = null;
    public static final CJPayBindCardType DEBIT = null;
    public static final CJPayBindCardType UPYSFBANK = null;
    public final String mDesc;
    public final String mType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/constants/CJPayBindCardType$Companion;", "", "()V", "getCardDesc", "", "cardType", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getCardDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cardType");
            CJPayBindCardType r101 = CJPayBindCardType.CREDIT;
            if (StringsKt.equals(r101.mType, r100, true) == true) goto L13;
            CJPayBindCardType r102 = CJPayBindCardType.DEBIT;
            if (StringsKt.equals(r102.mType, r100, true) == true) goto L14;
            CJPayBindCardType r103 = CJPayBindCardType.UPYSFBANK;
            if (StringsKt.equals(r103.mType, r100, true) == true) goto L15;
            return "";
        L15:
            return r103.mDesc;
        L14:
            return r102.mDesc;
        L13:
            return r101.mDesc;
        }
    }

    private static final /* synthetic */ CJPayBindCardType[] $values() {
        return new CJPayBindCardType[]{ALL, CREDIT, DEBIT, UPYSFBANK};
    }

    public static CJPayBindCardType valueOf(String r100) {
        return (CJPayBindCardType) a.a(CJPayBindCardType.class, r100);
    }

    public static CJPayBindCardType[] values() {
        return (CJPayBindCardType[]) $VALUES.clone();
    }

    static {
        ALL = new CJPayBindCardType(AccountType.ALL, 0, AccountType.ALL, "储蓄卡,信用卡");
        CREDIT = new CJPayBindCardType("CREDIT", 1, "CREDIT", "信用卡");
        DEBIT = new CJPayBindCardType("DEBIT", 2, "DEBIT", "储蓄卡");
        UPYSFBANK = new CJPayBindCardType("UPYSFBANK", 3, "UPYSFBANK", "云闪付");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private CJPayBindCardType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.mType = r102;
        this.mDesc = r103;
    }
}
