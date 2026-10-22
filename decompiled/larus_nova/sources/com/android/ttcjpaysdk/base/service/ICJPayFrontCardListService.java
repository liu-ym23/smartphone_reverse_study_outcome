package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayFrontCardListService extends ICJPayService {
    ICJPayFrontCardListCallBack getFrontCardCallBack();

    void release();

    void startCJPayFrontCardListMethodActivity(Activity r100, int r101, int r102, String r103, String r104, String r105, ArrayList<String> r106, ICJPayFrontCardListCallBack r107, JSONObject r108, JSONObject r110, JSONObject r111, boolean r112);
}
