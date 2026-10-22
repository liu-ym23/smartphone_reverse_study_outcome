package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.ui.Utils.keepdialog.CJPayKeepDialogConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/RetainTypeNativeV2;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RETAIN_TYPE_VOUCHER", "RETAIN_TYPE_RECOMMEND_FACE", "MERCHANT_RETAIN_INFO", "RETAIN_TYPE_REVERSE_COUNTER", "RETAIN_TYPE_VOUCHER_LIST", "RETAIN_TYPE_DEFAULT_COUNTER", "RETAIN_TYPE_DEFAULT", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum RetainTypeNativeV2 extends Enum<RetainTypeNativeV2> {
    private static final /* synthetic */ RetainTypeNativeV2[] $VALUES = null;
    public static final Companion Companion = null;
    public static final RetainTypeNativeV2 MERCHANT_RETAIN_INFO = null;
    public static final RetainTypeNativeV2 RETAIN_TYPE_DEFAULT = null;
    public static final RetainTypeNativeV2 RETAIN_TYPE_DEFAULT_COUNTER = null;
    public static final RetainTypeNativeV2 RETAIN_TYPE_RECOMMEND_FACE = null;
    public static final RetainTypeNativeV2 RETAIN_TYPE_REVERSE_COUNTER = null;
    public static final RetainTypeNativeV2 RETAIN_TYPE_VOUCHER = null;
    public static final RetainTypeNativeV2 RETAIN_TYPE_VOUCHER_LIST = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/RetainTypeNativeV2$Companion;", "", "()V", "from", "Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/RetainTypeNativeV2;", "inputValue", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final RetainTypeNativeV2 from(String r100) {
            RetainTypeNativeV2[] r101 = RetainTypeNativeV2.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            RetainTypeNativeV2 r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ RetainTypeNativeV2[] $values() {
        return new RetainTypeNativeV2[]{RETAIN_TYPE_VOUCHER, RETAIN_TYPE_RECOMMEND_FACE, MERCHANT_RETAIN_INFO, RETAIN_TYPE_REVERSE_COUNTER, RETAIN_TYPE_VOUCHER_LIST, RETAIN_TYPE_DEFAULT_COUNTER, RETAIN_TYPE_DEFAULT};
    }

    public static RetainTypeNativeV2 valueOf(String r100) {
        return (RetainTypeNativeV2) a.a(RetainTypeNativeV2.class, r100);
    }

    public static RetainTypeNativeV2[] values() {
        return (RetainTypeNativeV2[]) $VALUES.clone();
    }

    static {
        RETAIN_TYPE_VOUCHER = new RetainTypeNativeV2("RETAIN_TYPE_VOUCHER", 0, CJPayKeepDialogConfig.RETAIN_TYPE_VOUCHER);
        RETAIN_TYPE_RECOMMEND_FACE = new RetainTypeNativeV2("RETAIN_TYPE_RECOMMEND_FACE", 1, CJPayKeepDialogConfig.RETAIN_TYPE_RECOMMEND_FACE);
        MERCHANT_RETAIN_INFO = new RetainTypeNativeV2("MERCHANT_RETAIN_INFO", 2, CJPayConstant.CJ_PAY_RETAIN_INFO_V2_INFO_KEY2);
        RETAIN_TYPE_REVERSE_COUNTER = new RetainTypeNativeV2("RETAIN_TYPE_REVERSE_COUNTER", 3, "retain_type_reverse_counter");
        RETAIN_TYPE_VOUCHER_LIST = new RetainTypeNativeV2("RETAIN_TYPE_VOUCHER_LIST", 4, "retain_type_voucher_list");
        RETAIN_TYPE_DEFAULT_COUNTER = new RetainTypeNativeV2("RETAIN_TYPE_DEFAULT_COUNTER", 5, "retain_type_default_counter");
        RETAIN_TYPE_DEFAULT = new RetainTypeNativeV2("RETAIN_TYPE_DEFAULT", 6, CJPayKeepDialogConfig.RETAIN_TYPE_DEFAULT);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getValue() {
        return this.value;
    }

    private RetainTypeNativeV2(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
