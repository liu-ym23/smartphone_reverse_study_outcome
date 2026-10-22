package com.android.ttcjpaysdk.bindcard.unionpay.applog;

import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\tJ&\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/UnionPayTwoElementLogger;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/BaseUnionPayBindLogger;", "()V", "EVENT_TWO_ELEMENTS_TWO_AUTH_CLICK_AGREEMENT", "", "EVENT_TWO_ELEMENTS_TWO_AUTH_CLICK_NEXT", "EVENT_TWO_ELEMENTS_TWO_AUTH_IMP", "EVENT_WALLET_ADDBCARD_ONESTEPBIND_ALIVECHECK", "agreementClick", "", "protocolGroupContentsBean", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;", "bean", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupBean;", "conflictFailClick", "conflictFailShow", "needAliveCheck", "isAliveCheck", "", "pageShow", "verifyClick", "result", "", "errorCode", "errorMsg", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayTwoElementLogger extends BaseUnionPayBindLogger {
    private final String EVENT_TWO_ELEMENTS_TWO_AUTH_CLICK_AGREEMENT;
    private final String EVENT_TWO_ELEMENTS_TWO_AUTH_CLICK_NEXT;
    private final String EVENT_TWO_ELEMENTS_TWO_AUTH_IMP;
    private final String EVENT_WALLET_ADDBCARD_ONESTEPBIND_ALIVECHECK;

    public final void conflictFailClick() {
        logEvent("wallet_businesstopay_auth_fail_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_AUTH_TYPE, "two_elements")}));
    }

    public final void conflictFailShow() {
        logEvent("wallet_businesstopay_auth_fail_imp", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("needidentify", 1), TuplesKt.to("haspass", 0), TuplesKt.to("is_onestep", 1), TuplesKt.to("show_onestep", 0), TuplesKt.to(BdpAppEventConstant.PARAMS_AUTH_TYPE, "two_elements")}));
    }

    public final void pageShow() {
        logEvent(this.EVENT_TWO_ELEMENTS_TWO_AUTH_IMP, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("twoelements_verify_status", 0), TuplesKt.to("is_onestep", 1), TuplesKt.to("needidentify", 1), TuplesKt.to("haspass", 0), TuplesKt.to("show_onestep", 0)}));
    }

    public UnionPayTwoElementLogger() {
        this.EVENT_TWO_ELEMENTS_TWO_AUTH_IMP = "wallet_two_elements_identified_page_imp";
        this.EVENT_TWO_ELEMENTS_TWO_AUTH_CLICK_AGREEMENT = "wallet_two_elements_identified_page_agreement_click";
        this.EVENT_TWO_ELEMENTS_TWO_AUTH_CLICK_NEXT = "wallet_two_elements_identified_page_next_click";
        this.EVENT_WALLET_ADDBCARD_ONESTEPBIND_ALIVECHECK = "wallet_addbcard_onestepbind_alivecheck";
    }

    public final void needAliveCheck(boolean r100) {
        logEvent(this.EVENT_WALLET_ADDBCARD_ONESTEPBIND_ALIVECHECK, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_alivecheck", Integer.valueOf(r100 ? 1 : 0))}));
    }

    public final void agreementClick(CJPayProtocolGroupContentsBean r110, CJPayProtocolGroupBean r111) {
        Intrinsics.checkNotNullParameter(r110, "protocolGroupContentsBean");
        Intrinsics.checkNotNullParameter(r111, "bean");
        logEvent(this.EVENT_TWO_ELEMENTS_TWO_AUTH_CLICK_AGREEMENT, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("type", CollectionsKt.joinToString$default(r110.getProtocolListByGroup(r111.groupName), null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null)), TuplesKt.to("is_onestep", 1), TuplesKt.to("needidentify", 1), TuplesKt.to("haspass", 0), TuplesKt.to("show_onestep", 0)}));
    }

    public final void verifyClick(int r100, String r101, String r102) {
        HashMap<String, Object> r103 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r100)), TuplesKt.to("button_name", 1), TuplesKt.to("is_onestep", 1), TuplesKt.to("needidentify", 1), TuplesKt.to("haspass", 0), TuplesKt.to("show_onestep", 0)});
        if (r101 == null) goto L5;
        r103.put("error_code", r101);
    L5:
        if (r102 == null) goto L7;
        r103.put("error_msg", r102);
    L7:
        logEvent(this.EVENT_TWO_ELEMENTS_TWO_AUTH_CLICK_NEXT, r103);
    }

    public static /* synthetic */ void verifyClick$default(UnionPayTwoElementLogger r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.verifyClick(r101, r102, r103);
    }
}
