package com.bytedance.android.livehostapi.business;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.business.depend.ad.IAdDownloadListener;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdAnchorView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostLiveAdForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostLiveAdForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$action(IHostLiveAdForSaas r100, Context r101, JSONObject r102, JSONObject r103) {
        }

        public static void $default$cancelDownload(IHostLiveAdForSaas r100, Context r101, JSONObject r102, JSONObject r103) {
        }

        public static ILiveAdAnchorView $default$getLiveAdAnchorView(IHostLiveAdForSaas r100, Context r101, Bundle r102) {
            return null;
        }

        public static void $default$subscribe(IHostLiveAdForSaas r100, Context r101, JSONObject r102, JSONObject r103, IAdDownloadListener r104) {
        }

        public static void $default$unSubscribe(IHostLiveAdForSaas r100, Context r101, JSONObject r102, JSONObject r103) {
        }

        public static void $default$updateDownloadConfig(IHostLiveAdForSaas r100, Context r101, JSONObject r102, JSONObject r103) {
        }
    }

    void action(Context r100, JSONObject r101, JSONObject r102);

    void cancelDownload(Context r100, JSONObject r101, JSONObject r102);

    ILiveAdAnchorView getLiveAdAnchorView(Context r100, Bundle r101);

    void subscribe(Context r100, JSONObject r101, JSONObject r102, IAdDownloadListener r103);

    void unSubscribe(Context r100, JSONObject r101, JSONObject r102);

    void updateDownloadConfig(Context r100, JSONObject r101, JSONObject r102);
}
