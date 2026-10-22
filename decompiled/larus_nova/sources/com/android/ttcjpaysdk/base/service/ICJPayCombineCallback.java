package com.android.ttcjpaysdk.base.service;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCombineCallback;", "", "gotoBindCard", "", "newCardParams", "Lorg/json/JSONObject;", "gotoMethodFragment", "isLocalEnableFingerprint", "", "()Ljava/lang/Boolean;", "setCheckoutResponseBean", "jsonObject", "startPayWithoutPwd", "startVerifyFingerprint", "startVerifyForAddPwd", "startVerifyForCardSign", "startVerifyForPwd", "startVerifyForToken", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayCombineCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void gotoBindCard$default(ICJPayCombineCallback r100, JSONObject r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.gotoBindCard(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gotoBindCard");
        }
    }

    void gotoBindCard(JSONObject r100);

    void gotoMethodFragment();

    Boolean isLocalEnableFingerprint();

    void setCheckoutResponseBean(JSONObject r100);

    void startPayWithoutPwd();

    void startVerifyFingerprint();

    void startVerifyForAddPwd();

    void startVerifyForCardSign();

    void startVerifyForPwd();

    void startVerifyForToken();
}
