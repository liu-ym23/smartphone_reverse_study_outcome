package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJD\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&JN\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010H&J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J(\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010H&J&\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u0019\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u001a\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IUnionPayBindCardService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "createUnionPaySignOrder", "", "activity", "Landroid/app/Activity;", "authorizeClicked", "", "isNeedShowAuth", "outTradeNo", "", "voucherLabel", "isBindCardNotPay", "callBack", "Lcom/android/ttcjpaysdk/base/service/ICJPayServiceCallBack;", "signCardMapJO", "Lorg/json/JSONObject;", "busiAuthorizeInfoJO", "unionPayVoucher", "delayFinishMillis", "", "hostInfo", "createUnionPaySignOrderForBindCard", "handleUnionPayFaceCheck", "eventJO", "startUnionPayBindCard", "startUnionPaySmsBindCard", BrowserDependency.UrlClickType.CARD, "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IUnionPayBindCardService extends ICJPayService {
    public static final Companion Companion = null;
    public static final String IS_SKIP_SET_PWD = "is_skip_set_pwd";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IUnionPayBindCardService$Companion;", "", "()V", "IS_SKIP_SET_PWD", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String IS_SKIP_SET_PWD = "is_skip_set_pwd";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void createUnionPaySignOrderForBindCard$default(IUnionPayBindCardService r100, Activity r101, ICJPayServiceCallBack r102, JSONObject r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.createUnionPaySignOrderForBindCard(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createUnionPaySignOrderForBindCard");
        }

        public static /* synthetic */ void createUnionPaySignOrder$default(IUnionPayBindCardService r100, Activity r110, JSONObject r111, JSONObject r112, JSONObject r113, int r114, ICJPayServiceCallBack r115, JSONObject r116, int r117, Object r118) {
            if (r118 != null) goto L10;
            if ((r117 & 64) == 0) goto L6;
            JSONObject r101 = null;
        L7:
            r100.createUnionPaySignOrder(r110, r111, r112, r113, r114, r115, r101);
            return;
        L6:
            r101 = r116;
            goto L7
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createUnionPaySignOrder");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void createUnionPaySignOrder(Activity r100, JSONObject r101, JSONObject r102, JSONObject r103, int r104, ICJPayServiceCallBack r105, JSONObject r106);

    void createUnionPaySignOrder(Activity r100, boolean r101, boolean r102, String r103, String r104, boolean r105, ICJPayServiceCallBack r106);

    void createUnionPaySignOrderForBindCard(Activity r100, ICJPayServiceCallBack r101);

    void createUnionPaySignOrderForBindCard(Activity r100, ICJPayServiceCallBack r101, JSONObject r102);

    void handleUnionPayFaceCheck(Activity r100, JSONObject r101, ICJPayServiceCallBack r102);

    void startUnionPayBindCard(Activity r100, ICJPayServiceCallBack r101);

    void startUnionPaySmsBindCard(Activity r100, JSONObject r101);
}
