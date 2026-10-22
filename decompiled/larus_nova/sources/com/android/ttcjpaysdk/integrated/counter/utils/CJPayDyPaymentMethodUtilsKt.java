package com.android.ttcjpaysdk.integrated.counter.utils;

import com.android.ttcjpaysdk.integrated.counter.data.PayTypeData;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"getVoucherMsgV2", "", "", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "voucherTag", "Lcom/android/ttcjpaysdk/integrated/counter/utils/VoucherV2Tag;", "integrated-counter_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayDyPaymentMethodUtilsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[VoucherV2Tag.values().length];
            r100[VoucherV2Tag.TAG12.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VoucherV2Tag.TAG34.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VoucherV2Tag.TAG56.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final List<String> getVoucherMsgV2(PaymentMethodInfo r100, VoucherV2Tag r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "voucherTag");
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r102 != 1) goto L5;
        ArrayList<PayTypeData.PayTypeVoucherMsgV2.PayTypeVoucherMsgV2Tag> r103 = r100.voucherMsgV2.tag12;
    L14:
        if (r100.combineType == null) goto L16;
        String r104 = "combine_pay";
    L17:
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r103.iterator();
    L19:
        if (r106.hasNext() == false) goto L38;
        PayTypeData.PayTypeVoucherMsgV2.PayTypeVoucherMsgV2Tag r107 = (PayTypeData.PayTypeVoucherMsgV2.PayTypeVoucherMsgV2Tag) r106.next();
        if (Intrinsics.areEqual(r107.event_type, r104) == false) goto L19;
        Iterator<T> r108 = r107.label.iterator();
    L23:
        String r109 = null;
        if (r108.hasNext() == false) goto L28;
        Object r110 = r108.next();
        if (Intrinsics.areEqual("text", ((PayTypeData.PayTypeVoucherMsgV2.PayTypeVoucherMsgV2Tag.VoucherDetailLabel) r110).type) == false) goto L23;
    L29:
        PayTypeData.PayTypeVoucherMsgV2.PayTypeVoucherMsgV2Tag.VoucherDetailLabel r111 = (PayTypeData.PayTypeVoucherMsgV2.PayTypeVoucherMsgV2Tag.VoucherDetailLabel) r110;
        if (r111 == null) goto L19;
        String r112 = r111.text;
        if (r112 == null) goto L19;
        if ((!StringsKt.isBlank(r112)) == false) goto L36;
        r109 = r112;
    L36:
        if (r109 == null) goto L19;
        r105.add(r109);
        goto L19
    L28:
        r110 = null;
        goto L29
    L38:
        return r105;
    L16:
        r104 = "default";
        goto L17
    L5:
        if (r102 != 2) goto L7;
        r103 = r100.voucherMsgV2.tag34;
        goto L14
    L7:
        if (r102 != 3) goto L10;
        r103 = r100.voucherMsgV2.tag56;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
