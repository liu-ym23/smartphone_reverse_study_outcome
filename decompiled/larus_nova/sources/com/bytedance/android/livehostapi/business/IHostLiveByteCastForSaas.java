package com.bytedance.android.livehostapi.business;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostLiveByteCastForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostLiveByteCastForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$enable(IHostLiveByteCastForSaas r100) {
            return false;
        }

        public static View $default$getLoadingAnimationView(IHostLiveByteCastForSaas r100) {
            return null;
        }

        public static void $default$initCastSDK(IHostLiveByteCastForSaas r100) {
        }

        public static boolean $default$isCastSDKInit(IHostLiveByteCastForSaas r100) {
            return false;
        }

        public static void $default$startLoadingAnimation(IHostLiveByteCastForSaas r100) {
        }

        public static void $default$stopLoadingAnimation(IHostLiveByteCastForSaas r100) {
        }
    }

    boolean enable();

    View getLoadingAnimationView();

    void initCastSDK();

    boolean isCastSDKInit();

    void startLoadingAnimation();

    void stopLoadingAnimation();
}
