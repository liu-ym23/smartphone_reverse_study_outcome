package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.contract;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&JD\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/contract/CJUnifyPayMethodCallback;", "", "clickEvent", "", "click", "", "buttonName", "onChangePaymentMethod", e.f25671s, "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "preMethod", "needJump", "", "notConfirm", "isRefreshHome", "source", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/contract/CJUnifyPayMethodCallback$ChangeMethodSource;", "onOpenMethodList", "selectMethod", "onTryManualScroll", "targetPos", "", "ChangeMethodSource", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJUnifyPayMethodCallback {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/contract/CJUnifyPayMethodCallback$ChangeMethodSource;", "", "(Ljava/lang/String;I)V", "SELECT_METHOD_VIEW", "ASSET_LIST", "EXTERNAL", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ChangeMethodSource extends Enum<ChangeMethodSource> {
        private static final /* synthetic */ ChangeMethodSource[] $VALUES = null;
        public static final ChangeMethodSource ASSET_LIST = null;
        public static final ChangeMethodSource EXTERNAL = null;
        public static final ChangeMethodSource SELECT_METHOD_VIEW = null;

        private static final /* synthetic */ ChangeMethodSource[] $values() {
            return new ChangeMethodSource[]{SELECT_METHOD_VIEW, ASSET_LIST, EXTERNAL};
        }

        public static ChangeMethodSource valueOf(String r100) {
            return (ChangeMethodSource) a.a(ChangeMethodSource.class, r100);
        }

        public static ChangeMethodSource[] values() {
            return (ChangeMethodSource[]) $VALUES.clone();
        }

        static {
            SELECT_METHOD_VIEW = new ChangeMethodSource("SELECT_METHOD_VIEW", 0);
            ASSET_LIST = new ChangeMethodSource("ASSET_LIST", 1);
            EXTERNAL = new ChangeMethodSource("EXTERNAL", 2);
            $VALUES = $values();
        }

        private ChangeMethodSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onChangePaymentMethod$default(CJUnifyPayMethodCallback r100, CJUnifyPayMethodTuple r110, CJUnifyPayMethodTuple r111, boolean r112, boolean r113, boolean r114, ChangeMethodSource r115, int r116, Object r117) {
            if (r117 != null) goto L22;
            if ((r116 & 4) == 0) goto L6;
            boolean r101 = false;
        L8:
            if ((r116 & 8) == 0) goto L10;
            boolean r102 = false;
        L12:
            if ((r116 & 16) == 0) goto L14;
            boolean r103 = false;
        L16:
            if ((r116 & 32) == 0) goto L18;
            ChangeMethodSource r104 = ChangeMethodSource.EXTERNAL;
        L19:
            r100.onChangePaymentMethod(r110, r111, r101, r102, r103, r104);
            return;
        L18:
            r104 = r115;
            goto L19
        L14:
            r103 = r114;
            goto L16
        L10:
            r102 = r113;
            goto L12
        L6:
            r101 = r112;
            goto L8
        L22:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onChangePaymentMethod");
        }
    }

    void clickEvent(String r100, String r101);

    void onChangePaymentMethod(CJUnifyPayMethodTuple r100, CJUnifyPayMethodTuple r101, boolean r102, boolean r103, boolean r104, ChangeMethodSource r105);

    void onOpenMethodList(CJUnifyPayMethodTuple r100);

    void onTryManualScroll(int r100);
}
