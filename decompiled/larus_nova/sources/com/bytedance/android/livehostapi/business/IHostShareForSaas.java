package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostShareForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostShareForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isSupportLiveShare(IHostShareForSaas r100) {
            return false;
        }

        public static void $default$showNativeShareDialog(IHostShareForSaas r100, Activity r101, ShareParams r102, IShareCallback r103) {
        }
    }

    boolean isSupportLiveShare();

    void showNativeShareDialog(Activity r100, ShareParams r101, IShareCallback r102);
}
