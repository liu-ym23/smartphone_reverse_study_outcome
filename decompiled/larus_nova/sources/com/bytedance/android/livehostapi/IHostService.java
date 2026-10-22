package com.bytedance.android.livehostapi;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IHostEmoji;
import com.bytedance.android.livehostapi.business.IHostHSFunc;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.IHostProfile;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.android.livehostapi.business.IHostWMiniGameInitializer;
import com.bytedance.android.livehostapi.business.IHostWallet;
import com.bytedance.android.livehostapi.business.base.IBaseHostBusiness;
import com.bytedance.android.livehostapi.business.base.IBaseHostHSFunc;
import com.bytedance.android.livehostapi.business.base.IBaseHostLiveAd;
import com.bytedance.android.livehostapi.business.base.IBaseHostProfile;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.base.IBaseHostVerify;
import com.bytedance.android.livehostapi.business.base.IBaseHostWallet;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.IHostCommerceMonitor;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostApp;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostContext;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostFrescoHelper;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostNetwork;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostPlugin;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livehostapi.platform.IHostConfig;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livehostapi.platform.IHostPerformanceHelper;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostUser;
import com.bytedance.android.livehostapi.platform.base.IBaseHostAction;
import com.bytedance.android.livehostapi.platform.base.IBaseHostConfig;
import com.bytedance.android.livehostapi.platform.base.IBaseHostLog;
import com.bytedance.android.livehostapi.platform.base.IBaseHostMonitor;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.base.IBaseHostUser;
import com.bytedance.android.livehostapi.platform.base.IBaseHostWebView;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostService extends IBaseHostService, IMiddleHostService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.IHostService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ IMiddlewareHostAction $default$action(IHostService r100) {
            return r100.action();
        }

        public static /* bridge */ /* synthetic */ IMiddleWareHostContext $default$appContext(IHostService r100) {
            return r100.appContext();
        }

        public static /* bridge */ /* synthetic */ IMiddlewareHostConfig $default$config(IHostService r100) {
            return r100.config();
        }

        public static /* bridge */ /* synthetic */ IBaseHostFrescoHelper $default$frescoHelper(IHostService r100) {
            return r100.frescoHelper();
        }

        public static /* bridge */ /* synthetic */ IBaseHostApp $default$hostApp(IHostService r100) {
            return r100.hostApp();
        }

        public static /* bridge */ /* synthetic */ IBaseHostBusiness $default$hostBusiness(IHostService r100) {
            return r100.hostBusiness();
        }

        public static /* bridge */ /* synthetic */ IBaseHostLiveAd $default$hostLiveAd(IHostService r100) {
            return r100.hostLiveAd();
        }

        public static /* bridge */ /* synthetic */ IBaseHostPerformanceMonitor $default$hostPerformanceMonitor(IHostService r100) {
            return r100.hostPerformanceMonitor();
        }

        public static /* bridge */ /* synthetic */ IBaseHostHSFunc $default$hsHostFunc(IHostService r100) {
            return r100.hsHostFunc();
        }

        public static /* bridge */ /* synthetic */ IBaseHostLog $default$log(IHostService r100) {
            return r100.log();
        }

        public static /* bridge */ /* synthetic */ IBaseHostMonitor $default$monitor(IHostService r100) {
            return r100.monitor();
        }

        public static /* bridge */ /* synthetic */ IBaseHostNetwork $default$network(IHostService r100) {
            return r100.network();
        }

        public static /* bridge */ /* synthetic */ IBaseHostPlugin $default$plugin(IHostService r100) {
            return r100.plugin();
        }

        public static /* bridge */ /* synthetic */ IBaseHostProfile $default$profile(IHostService r100) {
            return r100.profile();
        }

        public static /* bridge */ /* synthetic */ IBaseHostShare $default$share(IHostService r100) {
            return r100.share();
        }

        public static /* bridge */ /* synthetic */ IMiddlewareHostUser $default$user(IHostService r100) {
            return r100.user();
        }

        public static /* bridge */ /* synthetic */ IBaseHostVerify $default$verify(IHostService r100) {
            return r100.verify();
        }

        public static /* bridge */ /* synthetic */ IBaseHostWallet $default$wallet(IHostService r100) {
            return r100.wallet();
        }

        public static /* bridge */ /* synthetic */ IBaseHostWebView $default$webView(IHostService r100) {
            return r100.webView();
        }

        /* JADX INFO: renamed from: $default$action, reason: collision with other method in class */
        public static /* bridge */ /* synthetic */ IBaseHostAction m8225$default$action(IHostService r100) {
            return r100.action();
        }

        /* JADX INFO: renamed from: $default$appContext, reason: collision with other method in class */
        public static /* bridge */ /* synthetic */ IBaseHostContext m8226$default$appContext(IHostService r100) {
            return r100.appContext();
        }

        /* JADX INFO: renamed from: $default$config, reason: collision with other method in class */
        public static /* bridge */ /* synthetic */ IBaseHostConfig m8227$default$config(IHostService r100) {
            return r100.config();
        }

        /* JADX INFO: renamed from: $default$user, reason: collision with other method in class */
        public static /* bridge */ /* synthetic */ IBaseHostUser m8228$default$user(IHostService r100) {
            return r100.user();
        }
    }

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    IHostAction action();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IMiddlewareHostAction action();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IBaseHostAction action();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    IHostContext appContext();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IMiddleWareHostContext appContext();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IBaseHostContext appContext();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    IHostConfig config();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IMiddlewareHostConfig config();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IBaseHostConfig config();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostFrescoHelper frescoHelper();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostFrescoHelper frescoHelper();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostApp hostApp();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostApp hostApp();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostBusiness hostBusiness();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostBusiness hostBusiness();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostCommerceMonitor hostCommerceMonitor();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostEmoji hostEmoji();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostLiveAd hostLiveAd();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostLiveAd hostLiveAd();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostPerformanceHelper hostPerformanceHelper();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    IHostPerformanceMonitor hostPerformanceMonitor();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IBaseHostPerformanceMonitor hostPerformanceMonitor();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostWMiniGameInitializer hostWMiniGameInitializer();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostHSFunc hsHostFunc();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostHSFunc hsHostFunc();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    IHostLog log();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IBaseHostLog log();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostMonitor monitor();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostMonitor monitor();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostNetwork network();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostNetwork network();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostPlugin plugin();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostPlugin plugin();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostProfile profile();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostProfile profile();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostShare share();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostShare share();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    IHostUser user();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IMiddlewareHostUser user();

    @Override // com.bytedance.android.livehostapi.IBaseHostService, com.bytedance.android.livehostapi.IMiddleHostService
    /* bridge */ /* synthetic */ IBaseHostUser user();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostVerify verify();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostVerify verify();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostWallet wallet();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostWallet wallet();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    IHostWebView webView();

    @Override // com.bytedance.android.livehostapi.IBaseHostService
    /* bridge */ /* synthetic */ IBaseHostWebView webView();
}
