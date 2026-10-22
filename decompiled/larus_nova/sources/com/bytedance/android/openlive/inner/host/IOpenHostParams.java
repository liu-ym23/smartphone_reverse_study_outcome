package com.bytedance.android.openlive.inner.host;

import android.app.Activity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.callback.TicketCallback;
import com.bytedance.android.livehostapi.platform.depend.user.HostUserDetail;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public interface IOpenHostParams extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.openlive.inner.host.IOpenHostParams$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$enableLynxProfileAB(IOpenHostParams r100) {
            return true;
        }

        public static String $default$getHostEffectAccessKey(IOpenHostParams r100) {
            return "";
        }

        public static String $default$getHostGeckoCacheDir(IOpenHostParams r100) {
            return "";
        }

        public static String $default$getXTTicket(IOpenHostParams r100, TicketCallback r101) {
            return "";
        }

        public static boolean $default$isSettingEnableForTargetKey(IOpenHostParams r100, String r101) {
            return false;
        }

        public static HostUserDetail $default$hostUserDetail(IOpenHostParams r100) {
            return new HostUserDetail();
        }
    }

    boolean enableLynxProfileAB();

    List<Class> getAllLiveActivity();

    String getCJAppId();

    String getCJMerchantId();

    Activity getCurrentActivity();

    String getHostEffectAccessKey();

    String getHostGeckoCacheDir();

    String getPlayActivityName();

    String getSessionId();

    Activity getTopActivity();

    String getXTTicket(TicketCallback r100);

    int hostAppId();

    HostUserDetail hostUserDetail();

    long hostUserId();

    boolean isSettingEnableForTargetKey(String r100);
}
