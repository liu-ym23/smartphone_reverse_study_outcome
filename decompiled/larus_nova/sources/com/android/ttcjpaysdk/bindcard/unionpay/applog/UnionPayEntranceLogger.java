package com.android.ttcjpaysdk.bindcard.unionpay.applog;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/UnionPayEntranceLogger;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/BaseUnionPayBindLogger;", "()V", "authFailClick", "", "authFailShow", "needAliveCheck", "isAliveCheck", "", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayEntranceLogger extends BaseUnionPayBindLogger {
    public final void authFailClick() {
        BaseUnionPayBindLogger.logEvent$default(this, "wallet_ysf_auth_fail_click", null, 2, null);
    }

    public final void authFailShow() {
        BaseUnionPayBindLogger.logEvent$default(this, "wallet_ysf_auth_fail_pop", null, 2, null);
    }

    public UnionPayEntranceLogger() {
    }

    public final void needAliveCheck(boolean r100) {
        logEvent("wallet_addbcard_onestepbind_alivecheck", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_alivecheck", Integer.valueOf(r100 ? 1 : 0))}));
    }
}
