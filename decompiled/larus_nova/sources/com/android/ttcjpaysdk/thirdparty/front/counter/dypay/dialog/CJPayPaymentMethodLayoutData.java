package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0013\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayPaymentMethodLayoutData;", "", "bankCardPointSelectionInfo", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;)V", "getBankCardPointSelectionInfo", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;", "SingleMethodData", "TwoMethodData", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayPaymentMethodLayoutData$SingleMethodData;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayPaymentMethodLayoutData$TwoMethodData;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJPayPaymentMethodLayoutData {
    private final BankCardPointSelectionInfo bankCardPointSelectionInfo;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayPaymentMethodLayoutData$SingleMethodData;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayPaymentMethodLayoutData;", "assetIconUrl", "", "assetText", "subtitle", "subDescTitle", "bankCardPointSelectionInfo", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;)V", "getAssetIconUrl", "()Ljava/lang/String;", "getAssetText", "getBankCardPointSelectionInfo", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;", "getSubDescTitle", "getSubtitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SingleMethodData extends CJPayPaymentMethodLayoutData {
        private final String assetIconUrl;
        private final String assetText;
        private final BankCardPointSelectionInfo bankCardPointSelectionInfo;
        private final String subDescTitle;
        private final String subtitle;

        public static /* synthetic */ SingleMethodData copy$default(SingleMethodData r100, String r101, String r102, String r103, String r104, BankCardPointSelectionInfo r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.assetIconUrl;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.assetText;
        L8:
            String r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.subtitle;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.subDescTitle;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.bankCardPointSelectionInfo;
        L17:
            String r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final String component1() {
            return this.assetIconUrl;
        }

        public final String component2() {
            return this.assetText;
        }

        public final String component3() {
            return this.subtitle;
        }

        public final String component4() {
            return this.subDescTitle;
        }

        public final BankCardPointSelectionInfo component5() {
            return this.bankCardPointSelectionInfo;
        }

        public final SingleMethodData copy(String r100, String r101, String r110, String r111, BankCardPointSelectionInfo r112) {
            return new SingleMethodData(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SingleMethodData) == true) goto L8;
            return false;
        L8:
            SingleMethodData r101 = (SingleMethodData) r100;
            if (Intrinsics.areEqual(this.assetIconUrl, r101.assetIconUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.assetText, r101.assetText) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.subDescTitle, r101.subDescTitle) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.bankCardPointSelectionInfo, r101.bankCardPointSelectionInfo) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            String r100 = this.assetIconUrl;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.assetText;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.subtitle;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.subDescTitle;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            BankCardPointSelectionInfo r113 = this.bankCardPointSelectionInfo;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return r112 + r101;
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "SingleMethodData(assetIconUrl=" + this.assetIconUrl + ", assetText=" + this.assetText + ", subtitle=" + this.subtitle + ", subDescTitle=" + this.subDescTitle + ", bankCardPointSelectionInfo=" + this.bankCardPointSelectionInfo + ')';
        }

        public final String getAssetIconUrl() {
            return this.assetIconUrl;
        }

        public final String getAssetText() {
            return this.assetText;
        }

        @Override // com.android.ttcjpaysdk.thirdparty.front.counter.dypay.dialog.CJPayPaymentMethodLayoutData
        public BankCardPointSelectionInfo getBankCardPointSelectionInfo() {
            return this.bankCardPointSelectionInfo;
        }

        public final String getSubDescTitle() {
            return this.subDescTitle;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public SingleMethodData(String r100, String r101, String r102, String r103, BankCardPointSelectionInfo r104) {
            super(r104, null);
            this.assetIconUrl = r100;
            this.assetText = r101;
            this.subtitle = r102;
            this.subDescTitle = r103;
            this.bankCardPointSelectionInfo = r104;
        }

        public /* synthetic */ SingleMethodData(String r100, String r101, String r110, String r111, BankCardPointSelectionInfo r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 4) == 0) goto L5;
            String r102 = null;
        L7:
            if ((r113 & 8) == 0) goto L9;
            String r103 = null;
        L11:
            if ((r113 & 16) == 0) goto L13;
            BankCardPointSelectionInfo r104 = null;
        L14:
            this(r100, r101, r102, r103, r104);
            return;
        L13:
            r104 = r112;
            goto L14
        L9:
            r103 = r111;
            goto L11
        L5:
            r102 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayPaymentMethodLayoutData$TwoMethodData;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayPaymentMethodLayoutData;", "title1", "", "desc1", "title2", "desc2", "bankCardPointSelectionInfo", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;)V", "getBankCardPointSelectionInfo", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/BankCardPointSelectionInfo;", "getDesc1", "()Ljava/lang/String;", "getDesc2", "getTitle1", "getTitle2", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TwoMethodData extends CJPayPaymentMethodLayoutData {
        private final BankCardPointSelectionInfo bankCardPointSelectionInfo;
        private final String desc1;
        private final String desc2;
        private final String title1;
        private final String title2;

        public static /* synthetic */ TwoMethodData copy$default(TwoMethodData r100, String r101, String r102, String r103, String r104, BankCardPointSelectionInfo r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.title1;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.desc1;
        L8:
            String r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.title2;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.desc2;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.bankCardPointSelectionInfo;
        L17:
            String r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final String component1() {
            return this.title1;
        }

        public final String component2() {
            return this.desc1;
        }

        public final String component3() {
            return this.title2;
        }

        public final String component4() {
            return this.desc2;
        }

        public final BankCardPointSelectionInfo component5() {
            return this.bankCardPointSelectionInfo;
        }

        public final TwoMethodData copy(String r100, String r101, String r110, String r111, BankCardPointSelectionInfo r112) {
            return new TwoMethodData(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TwoMethodData) == true) goto L8;
            return false;
        L8:
            TwoMethodData r101 = (TwoMethodData) r100;
            if (Intrinsics.areEqual(this.title1, r101.title1) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.desc1, r101.desc1) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.title2, r101.title2) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.desc2, r101.desc2) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.bankCardPointSelectionInfo, r101.bankCardPointSelectionInfo) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            String r100 = this.title1;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.desc1;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.title2;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.desc2;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            BankCardPointSelectionInfo r113 = this.bankCardPointSelectionInfo;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return r112 + r101;
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "TwoMethodData(title1=" + this.title1 + ", desc1=" + this.desc1 + ", title2=" + this.title2 + ", desc2=" + this.desc2 + ", bankCardPointSelectionInfo=" + this.bankCardPointSelectionInfo + ')';
        }

        @Override // com.android.ttcjpaysdk.thirdparty.front.counter.dypay.dialog.CJPayPaymentMethodLayoutData
        public BankCardPointSelectionInfo getBankCardPointSelectionInfo() {
            return this.bankCardPointSelectionInfo;
        }

        public final String getDesc1() {
            return this.desc1;
        }

        public final String getDesc2() {
            return this.desc2;
        }

        public final String getTitle1() {
            return this.title1;
        }

        public final String getTitle2() {
            return this.title2;
        }

        public TwoMethodData(String r100, String r101, String r102, String r103, BankCardPointSelectionInfo r104) {
            super(r104, null);
            this.title1 = r100;
            this.desc1 = r101;
            this.title2 = r102;
            this.desc2 = r103;
            this.bankCardPointSelectionInfo = r104;
        }

        public /* synthetic */ TwoMethodData(String r100, String r101, String r102, String r110, BankCardPointSelectionInfo r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 16) == 0) goto L5;
            r111 = null;
        L5:
            this(r100, r101, r102, r110, r111);
        }
    }

    public /* synthetic */ CJPayPaymentMethodLayoutData(BankCardPointSelectionInfo r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public BankCardPointSelectionInfo getBankCardPointSelectionInfo() {
        return this.bankCardPointSelectionInfo;
    }

    private CJPayPaymentMethodLayoutData(BankCardPointSelectionInfo r100) {
        this.bankCardPointSelectionInfo = r100;
    }

    public /* synthetic */ CJPayPaymentMethodLayoutData(BankCardPointSelectionInfo r100, int r101, DefaultConstructorMarker r102) {
        DefaultConstructorMarker r103 = null;
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, r103);
    }
}
