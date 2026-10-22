package com.bytedance.android.livehostapi.business.depend;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/IShareMsgCallback;", "", "onFail", "", "onSuccess", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IShareMsgCallback {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.IShareMsgCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFail(IShareMsgCallback r100) {
        }

        public static void $default$onSuccess(IShareMsgCallback r100) {
        }

        public static /* synthetic */ void access$onFail$jd(IShareMsgCallback r100) {
            $default$onFail(r100);
        }

        public static /* synthetic */ void access$onSuccess$jd(IShareMsgCallback r100) {
            $default$onSuccess(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onFail(IShareMsgCallback r100) {
            CC.access$onFail$jd(r100);
        }

        public static void onSuccess(IShareMsgCallback r100) {
            CC.access$onSuccess$jd(r100);
        }
    }

    void onFail();

    void onSuccess();
}
