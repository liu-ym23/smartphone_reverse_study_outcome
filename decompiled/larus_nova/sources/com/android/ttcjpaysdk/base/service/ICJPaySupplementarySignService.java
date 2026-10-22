package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPaySupplementarySignService extends ICJPayService {
    ICJPaySupplementarySignCallBack getCallBack();

    Fragment getFragment(int r100, Bundle r101, ICJPaySupplementarySignCallBack r102);

    boolean getIsQueryConnecting(Fragment r100);

    void inOrOutWithAnimation(Fragment r100, boolean r101, boolean r102);

    void release();

    void startUpdateCardInfoActivity(Context r100, JSONObject r101, JSONObject r102, ICJPaySupplementarySignCallBack r103);
}
