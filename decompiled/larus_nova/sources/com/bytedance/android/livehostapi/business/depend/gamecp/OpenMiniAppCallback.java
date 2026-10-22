package com.bytedance.android.livehostapi.business.depend.gamecp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/OpenMiniAppCallback;", "", "onFail", "", "errorCode", "", "errorMsg", "", "onSuccess", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OpenMiniAppCallback {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecp.OpenMiniAppCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void onFail$default(OpenMiniAppCallback r100, int r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.onFail(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFail");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void onFail$default(OpenMiniAppCallback r100, int r101, String r102, int r103, Object r104) {
            CC.onFail$default(r100, r101, r102, r103, r104);
        }
    }

    void onFail(int r100, String r101);

    void onSuccess();
}
