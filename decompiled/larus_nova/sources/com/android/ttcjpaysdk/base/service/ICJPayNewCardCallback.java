package com.android.ttcjpaysdk.base.service;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayNewCardCallback;", "", "getPayNewCardConfigs", "Lorg/json/JSONObject;", "isShowLoadingMask", "", DyPayConstant.KEY_SHOW_LOADING, "", "show", "code", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayNewCardCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void showLoading$default(ICJPayNewCardCallback r100, boolean r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.showLoading(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
        }
    }

    JSONObject getPayNewCardConfigs();

    boolean isShowLoadingMask();

    void showLoading(boolean r100, String r101);
}
