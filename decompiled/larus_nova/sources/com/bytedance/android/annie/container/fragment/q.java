package com.bytedance.android.annie.container.fragment;

import kotlin.Deprecated;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "迫不得已加的下沉接口，内部重构使用，外部千万不要使用，出了问题不负责修复")
public interface q {
    v7.b getLoadingFragment();

    void registerOnRequestPermissionsCallBack(com.bytedance.android.annie.bridge.method.permission.b r100);

    void requestPermissionsProxy(String[] r100, int r101);
}
