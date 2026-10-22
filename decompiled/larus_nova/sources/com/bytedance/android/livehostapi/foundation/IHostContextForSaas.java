package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.callback.TicketCallback;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostContextForSaas extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.foundation.IHostContextForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$clientKey(IHostContextForSaas r100) {
            return "";
        }

        public static boolean $default$enableLynxProfileAB(IHostContextForSaas r100) {
            return false;
        }

        public static String $default$getBtmJsbVersion(IHostContextForSaas r100) {
            return null;
        }

        public static String $default$getHostEffectAccessKey(IHostContextForSaas r100) {
            return null;
        }

        public static String $default$getPlayActivityName(IHostContextForSaas r100) {
            return null;
        }

        public static String $default$getXTTicket(IHostContextForSaas r100, TicketCallback r101) {
            return "";
        }

        public static boolean $default$hasLocation(IHostContextForSaas r100) {
            return false;
        }

        public static boolean $default$isSettingEnableForTargetKey(IHostContextForSaas r100, String r101) {
            return false;
        }

        public static void $default$loadVESDKForSaas(IHostContextForSaas r100, Context r101) {
        }

        public static boolean $default$skipSecSdkCheck(IHostContextForSaas r100) {
            return false;
        }
    }

    String clientKey();

    boolean enableLynxProfileAB();

    String getBtmJsbVersion();

    String getHostEffectAccessKey();

    String getPlayActivityName();

    String getXTTicket(TicketCallback r100);

    boolean hasLocation();

    boolean isSettingEnableForTargetKey(String r100);

    void loadVESDKForSaas(Context r100);

    boolean skipSecSdkCheck();
}
