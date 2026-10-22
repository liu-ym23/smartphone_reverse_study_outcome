package com.bytedance.android.openlive.inner.host;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import com.bytedance.android.livehostapi.business.MiniAppPreloadListener;
import com.bytedance.android.livehostapi.business.depend.floatwindow.FloatWindowContext;
import com.bytedance.android.livehostapi.business.depend.floatwindow.IFloatWindowPermissionCallback;
import com.bytedance.android.livehostapi.business.depend.miniapp.AnchorLiveData;
import com.bytedance.android.livehostapi.business.depend.miniapp.MiniAppParams;
import com.bytedance.common.wschannel.WsChannel;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface IOpenHostBusiness extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.openlive.inner.host.IOpenHostBusiness$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static WsChannel $default$getWsChannel(IOpenHostBusiness r100, Context r101, int r102, List r103, HashMap r104, Map r105, OnMessageReceiveListener r106) {
            return null;
        }

        public static boolean $default$isWsChannelEnable(IOpenHostBusiness r100) {
            return false;
        }

        public static boolean $default$openMiniApp(IOpenHostBusiness r100, Context r101, String r102, boolean r103, MiniAppParams r104, AnchorLiveData r105) {
            return false;
        }

        public static void $default$preloadMiniApp(IOpenHostBusiness r100, String r101, Map r102, MiniAppPreloadListener r103) {
        }

        public static void $default$showTTFloatWindow(IOpenHostBusiness r100, FloatWindowContext r101, IFloatWindowPermissionCallback r102) {
        }
    }

    IHostDouyinIm getDouyinIM();

    WsChannel getWsChannel(Context r100, int r101, List<String> r102, HashMap<String, String> r103, Map<String, String> r104, OnMessageReceiveListener r105);

    boolean isWsChannelEnable();

    boolean openMiniApp(Context r100, String r101, boolean r102, MiniAppParams r103, AnchorLiveData r104);

    void preloadMiniApp(String r100, Map<String, String> r101, MiniAppPreloadListener r102);

    void showTTFloatWindow(FloatWindowContext r100, IFloatWindowPermissionCallback r101);
}
