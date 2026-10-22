package com.android.ttcjpaysdk.kmp.base.jsb;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/jsb/IKmpCJJsbCallback;", "", "onSuccess", "", "data", "", "onFailure", "code", "", "msg", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJJsbCallback {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onSuccess$default(IKmpCJJsbCallback r100, String r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.onSuccess(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
        }

        public static /* synthetic */ void onFailure$default(IKmpCJJsbCallback r100, int r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = 0;
        L7:
            if ((r103 & 2) == 0) goto L9;
            r102 = "fail";
        L9:
            r100.onFailure(r101, r102);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
        }
    }

    void onFailure(int r100, String r101);

    void onSuccess(String r100);
}
