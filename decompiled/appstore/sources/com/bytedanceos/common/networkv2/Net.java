package com.bytedanceos.common.networkv2;

import com.bytedanceos.common.networkv2.params.NetParamFactory;

/* JADX INFO: loaded from: classes2.dex */
public class Net {
    public static final String V1_5_APP_STORE = "appstore/api/v1_5/";
    public static final String V1_6_APP_STORE = "appstore/api/v1_6/";

    public Net() {
    }

    public static void init() {
        NetParamFactory.instance().init();
    }
}
