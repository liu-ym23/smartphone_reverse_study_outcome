package com.android.ttcjpaysdk.ttcjpayapi;

import android.app.Activity;
import com.android.ttcjpaysdk.base.CJPayHostInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IGeneralPay {
    public static final String FromH5 = "from_h5";
    public static final String FromLynx = "from_lynx";
    public static final String FromNative = "from_native";
    public static final String FromScan = "from_scan";
    public static final String FromSwitchUnify = "from_switch_unify";

    /* JADX INFO: loaded from: classes39.dex */
    public interface IGeneralPayCallback {

        /* JADX INFO: renamed from: com.android.ttcjpaysdk.ttcjpayapi.IGeneralPay$IGeneralPayCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCallbackIdGenerated(IGeneralPayCallback r100, int r101) {
            }
        }

        void onCallbackIdGenerated(int r100);

        void onResult(int r100, String r101, String r102);
    }

    void pay(Activity r100, String r101, int r102, String r103, String r104, String r105, String r106, CJPayHostInfo r107, IGeneralPayCallback r108);
}
