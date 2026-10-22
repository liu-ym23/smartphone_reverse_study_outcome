package com.bytedance.android.livehostapi;

import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import com.bytedance.android.livehostapi.business.IHostGameCpConfig;
import com.bytedance.android.livehostapi.business.IHostMiniApp;
import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import com.bytedance.android.livehostapi.business.IHostSchemaHandler;
import com.bytedance.android.livehostapi.business.base.IBaseLiveHostByteCast;
import com.bytedance.android.livehostapi.foundation.IVideoContext;
import com.bytedance.android.livehostapi.foundation.player.IHostLivePlayerOptions;
import com.bytedance.android.livehostapi.platform.IHostAccountAuth;
import com.bytedance.android.livehostapi.platform.IHostCoinState;
import com.bytedance.android.livehostapi.platform.IHostDouyinOpenSDKAuth;
import com.bytedance.android.livehostapi.platform.IHostSessionAuth;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import ry.o;

/* JADX INFO: loaded from: classes7.dex */
public interface IBaseHostServiceForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.IBaseHostServiceForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IHostAccountAuth $default$account(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostCoinState $default$coinState(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostDouyinOpenSDKAuth $default$douyinOpenSDKAuth(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IBaseLiveHostByteCast $default$hostByteCast(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostDouyinIm $default$hostDouyinIm(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostGameCpConfig $default$hostGameCpConfig(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostLivePlayerOptions $default$hostLivePlayerOptions(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostMiniApp $default$hostMiniApp(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostRealNameAuthorization $default$hostRealNameAuthorization(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostSchemaHandler $default$hostSchemaHandler(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostTokenInjectionAuth $default$injectAccount(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static o $default$methodChannel(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IHostSessionAuth $default$sessionAuth(IBaseHostServiceForSaas r100) {
            return null;
        }

        public static IVideoContext $default$videoContext(IBaseHostServiceForSaas r100) {
            return null;
        }
    }

    IHostAccountAuth account();

    IHostCoinState coinState();

    IHostDouyinOpenSDKAuth douyinOpenSDKAuth();

    IBaseLiveHostByteCast hostByteCast();

    IHostDouyinIm hostDouyinIm();

    IHostGameCpConfig hostGameCpConfig();

    IHostLivePlayerOptions hostLivePlayerOptions();

    IHostMiniApp hostMiniApp();

    IHostRealNameAuthorization hostRealNameAuthorization();

    IHostSchemaHandler hostSchemaHandler();

    IHostTokenInjectionAuth injectAccount();

    o methodChannel();

    IHostSessionAuth sessionAuth();

    IVideoContext videoContext();
}
