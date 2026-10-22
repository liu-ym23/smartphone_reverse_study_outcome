package com.bytedance.android.livesdkapi.service;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.fragment.app.DialogFragment;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface IReactNativeHost {

    public interface Callback1<T> {
        void call(T r100);
    }

    public interface Callback2<T1, T2> {
        void call(T1 r100, T2 r101);
    }

    Map<String, String> apiParam();

    JSONObject callJSBridge(String r100, HashMap<String, Object> r101) throws Exception;

    void centerToast(String r100);

    DialogFragment createWebDialogFragment(String r100, int r101, int r102, int r103, int r104, String r105);

    Activity currentActivity();

    int dp2Px(int r100);

    void fetch(String r100, String r101, Map<String, String> r102, Callback2<String, Map<String, Object>> r103);

    Application getApplication();

    String getOfflinePath(String r100);

    <T> T getSettingValue(String r100, Class<T> r101, T r102);

    void openScheme(Context r100, String r101, String r102);

    void sendLogV3(String r100, Map<String, String> r101);

    void showDialog(String r100, String r101, String r102, String r103, boolean r104, Callback1<Boolean> r105);
}
