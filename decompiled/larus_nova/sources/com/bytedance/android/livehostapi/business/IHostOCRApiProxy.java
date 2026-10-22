package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostOCRProxy;
import com.bytedance.android.livehostapi.business.depend.IHostReady;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostOCRApiProxy extends IService, IBaseHostOCRProxy, IHostReady {

    public interface BytedCertCallback {
        void onH5Close(JSONObject r100);
    }

    public interface FaceLiveProxyCallback {
        void onDetectFaceLiveFinish(boolean r100, int r101, int r102, String r103, String r104, JSONObject r105);
    }

    public interface ICertDialogDependProxy {
        ICertLoadingDialogProxy showloading(Context r100, String r101);
    }

    public interface ICertLoadingDialogProxy {
        void dismiss();

        void show();
    }

    public interface LiveCertPreloadListener {
        void onCertPluginLoaded(boolean r100, boolean r101);
    }

    public interface OCRProxyCallback {
        void onDetectOCRFinish(int r100, int r101, String r102, JSONObject r103);
    }

    public interface PermissionCallbackProxy {
        void onRequest(boolean r100);
    }

    JSONObject convertOCRData(Context r100, int r101, String r102, int r103, int r104);

    void doOCRDetect(Context r100, String r101, int r102, HashMap<String, String> r103, OCRProxyCallback r104);

    void enableBoe(boolean r100);

    Intent getTakeOCRPhotoIntent(Activity r100, String r101);

    boolean isCertPluginLoaded();

    void keepUriPhoto(Context r100, String r101, Uri r102);

    void setTheme(HashMap<String, Object> r100);

    void startBytedCert(Activity r100, HashMap<String, String> r101, BytedCertCallback r102);

    void startFaceLiveness(Context r100, HashMap<String, String> r101, ICertDialogDependProxy r102, FaceLiveProxyCallback r103);

    void startFaceLiveness(Context r100, HashMap<String, String> r101, String r102, String r103, FaceLiveProxyCallback r104);

    boolean startTakeOCRPhoto(Activity r100, String r101, int r102, PermissionCallbackProxy r103);

    void tryLoadCertPlugin(Context r100, LiveCertPreloadListener r101);
}
