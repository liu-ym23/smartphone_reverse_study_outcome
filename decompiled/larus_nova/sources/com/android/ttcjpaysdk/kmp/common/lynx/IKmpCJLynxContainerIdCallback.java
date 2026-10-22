package com.android.ttcjpaysdk.kmp.common.lynx;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxContainerIdCallback;", "", "onContainerIdReady", "", "containerId", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJLynxContainerIdCallback {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onContainerIdReady(IKmpCJLynxContainerIdCallback r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "containerId");
        }
    }

    void onContainerIdReady(String r100);
}
