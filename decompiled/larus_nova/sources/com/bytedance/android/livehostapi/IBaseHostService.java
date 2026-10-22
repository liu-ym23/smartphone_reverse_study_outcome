package com.bytedance.android.livehostapi;

import com.bytedance.android.livehostapi.business.IHostCheckLive;
import com.bytedance.android.livehostapi.business.IHostEmoji;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livehostapi.business.IHostMiniAppCard;
import com.bytedance.android.livehostapi.business.IHostPad;
import com.bytedance.android.livehostapi.business.IHostWMiniGameInitializer;
import com.bytedance.android.livehostapi.business.base.IBaseHostBusiness;
import com.bytedance.android.livehostapi.business.base.IBaseHostHSFunc;
import com.bytedance.android.livehostapi.business.base.IBaseHostLiveAd;
import com.bytedance.android.livehostapi.business.base.IBaseHostProfile;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.base.IBaseHostVerify;
import com.bytedance.android.livehostapi.business.base.IBaseHostWallet;
import com.bytedance.android.livehostapi.foundation.IHostCommerceMonitor;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostApp;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostContext;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostFrescoHelper;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostNetwork;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostPlugin;
import com.bytedance.android.livehostapi.platform.IHostPerformanceHelper;
import com.bytedance.android.livehostapi.platform.base.IBaseHostAction;
import com.bytedance.android.livehostapi.platform.base.IBaseHostConfig;
import com.bytedance.android.livehostapi.platform.base.IBaseHostLog;
import com.bytedance.android.livehostapi.platform.base.IBaseHostMonitor;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.base.IBaseHostUser;
import com.bytedance.android.livehostapi.platform.base.IBaseHostWebView;

/* JADX INFO: loaded from: classes7.dex */
public interface IBaseHostService extends IBaseHostServiceForSaas {
    IBaseHostAction action();

    IBaseHostContext appContext();

    IBaseHostConfig config();

    IBaseHostFrescoHelper frescoHelper();

    IBaseHostApp hostApp();

    IBaseHostBusiness hostBusiness();

    IHostCheckLive hostCheckLive();

    IHostCommerceMonitor hostCommerceMonitor();

    IHostEmoji hostEmoji();

    IHostFeed hostFeed();

    IHostGameCP hostGameCP();

    IBaseHostLiveAd hostLiveAd();

    IHostLiveLocalLife hostLiveLocalLife();

    IHostMiniAppCard hostMiniAppCard();

    IHostLiveOpenPlatform hostOpenPlatform();

    IHostPad hostPad();

    IHostPerformanceHelper hostPerformanceHelper();

    IBaseHostPerformanceMonitor hostPerformanceMonitor();

    IHostWMiniGameInitializer hostWMiniGameInitializer();

    IBaseHostHSFunc hsHostFunc();

    IBaseHostLog log();

    IBaseHostMonitor monitor();

    IBaseHostNetwork network();

    IBaseHostPlugin plugin();

    IBaseHostProfile profile();

    IBaseHostShare share();

    IBaseHostUser user();

    IBaseHostVerify verify();

    IBaseHostWallet wallet();

    IBaseHostWebView webView();
}
