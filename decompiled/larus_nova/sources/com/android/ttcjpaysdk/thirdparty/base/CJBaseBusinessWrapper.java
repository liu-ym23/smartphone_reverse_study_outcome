package com.android.ttcjpaysdk.thirdparty.base;

import android.content.res.Configuration;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/base/CJBaseBusinessWrapper;", "", "isDisableBack", "", "onBackPressed", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", LiveCommonConstants.REASON_ON_DEDTROY, "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJBaseBusinessWrapper {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isDisableBack(CJBaseBusinessWrapper r100) {
            return false;
        }

        public static void onConfigurationChanged(CJBaseBusinessWrapper r100, Configuration r101) {
            Intrinsics.checkNotNullParameter(r101, "newConfig");
        }
    }

    boolean isDisableBack();

    void onBackPressed();

    void onConfigurationChanged(Configuration r100);

    void onDestroy();
}
