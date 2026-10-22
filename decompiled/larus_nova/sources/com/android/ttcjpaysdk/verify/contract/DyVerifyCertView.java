package com.android.ttcjpaysdk.verify.contract;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.verify.data.DyVerifyGenPartCsrRes;
import com.android.ttcjpaysdk.verify.data.DyVerifyGetCertRes;
import com.android.ttcjpaysdk.verify.data.DyVerifyGetSignFactorRes;
import com.android.ttcjpaysdk.verify.data.DyVerifyInitialCsrRes;
import com.android.ttcjpaysdk.verify.data.DyVerifyInvalidCertRes;
import com.android.ttcjpaysdk.verify.data.DyVerifyQueryCertRes;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0017\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/contract/DyVerifyCertView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onGenPartCsrFail", "", "errCode", "", "errMsg", "onGenPartCsrSuccess", "res", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyGenPartCsrRes;", "onGetCertFail", "onGetCertSuccess", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyGetCertRes;", "onGetSignFactorFail", "onGetSignFactorSuccess", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyGetSignFactorRes;", "onInitialCsrFail", "onInitialCsrSuccess", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyInitialCsrRes;", "onInvalidCertFail", "onInvalidCertSuccess", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyInvalidCertRes;", "onQueryCertFail", "onQueryCertSuccess", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyQueryCertRes;", "nativeCertInfo", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyQueryCertRes$DyVerifyCertInfo;", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DyVerifyCertView extends MvpView {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onGenPartCsrFail(DyVerifyCertView r100, String r101, String r102) {
        }

        public static void onGenPartCsrSuccess(DyVerifyCertView r100, DyVerifyGenPartCsrRes r101) {
        }

        public static void onGetCertFail(DyVerifyCertView r100, String r101, String r102) {
        }

        public static void onGetCertSuccess(DyVerifyCertView r100, DyVerifyGetCertRes r101) {
        }

        public static void onGetSignFactorFail(DyVerifyCertView r100, String r101, String r102) {
        }

        public static void onGetSignFactorSuccess(DyVerifyCertView r100, DyVerifyGetSignFactorRes r101) {
        }

        public static void onInitialCsrFail(DyVerifyCertView r100, String r101, String r102) {
        }

        public static void onInitialCsrSuccess(DyVerifyCertView r100, DyVerifyInitialCsrRes r101) {
        }

        public static void onInvalidCertFail(DyVerifyCertView r100, String r101, String r102) {
        }

        public static void onInvalidCertSuccess(DyVerifyCertView r100, DyVerifyInvalidCertRes r101) {
        }

        public static void onQueryCertFail(DyVerifyCertView r100, String r101, String r102) {
        }

        public static void onQueryCertSuccess(DyVerifyCertView r100, DyVerifyQueryCertRes r101, DyVerifyQueryCertRes.DyVerifyCertInfo r102) {
        }
    }

    void onGenPartCsrFail(String r100, String r101);

    void onGenPartCsrSuccess(DyVerifyGenPartCsrRes r100);

    void onGetCertFail(String r100, String r101);

    void onGetCertSuccess(DyVerifyGetCertRes r100);

    void onGetSignFactorFail(String r100, String r101);

    void onGetSignFactorSuccess(DyVerifyGetSignFactorRes r100);

    void onInitialCsrFail(String r100, String r101);

    void onInitialCsrSuccess(DyVerifyInitialCsrRes r100);

    void onInvalidCertFail(String r100, String r101);

    void onInvalidCertSuccess(DyVerifyInvalidCertRes r100);

    void onQueryCertFail(String r100, String r101);

    void onQueryCertSuccess(DyVerifyQueryCertRes r100, DyVerifyQueryCertRes.DyVerifyCertInfo r101);
}
