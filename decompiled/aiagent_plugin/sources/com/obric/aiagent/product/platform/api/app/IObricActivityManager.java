package com.obric.aiagent.product.platform.api.app;

import android.app.ActivityManager;
import android.app.ITopActivityAssistDataReceiver;
import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: IObricActivityManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IObricActivityManager {

    /* JADX INFO: compiled from: IObricActivityManager.kt */
    public static final class DefaultImpls {
        public static void setMuteWhitelist(IObricActivityManager r2, List<String> r3) {
            IObricActivityManager r4 = (IObricActivityManager) ZeusTransformUtils.wrapperContextForParams(r2, IObricActivityManager.class, "com.obric.aiagent.plugin");
            o.e((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), "whiteList");
        }
    }

    boolean addAutoVirtualDisplayRecordPackages(long r1, String[] r3);

    void addDisablePackage(String[] r1);

    void addExtraTaskNotTrimFlag(Intent r1);

    long beginAutoVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3);

    void enableCallUser(boolean r1);

    void endAutoVirtualDisplayRecordSet(long r1);

    boolean forceStopPackageOfCaller(Context r1);

    int getAutoDisplayId();

    ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1);

    Boolean isAutoActionTopActivityInSystemAnimation();

    boolean isPackageVisibleOnDisplay(String r1, int r2);

    boolean moveTaskToDisplay(int r1, int r2, boolean r3);

    boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1);

    boolean registerBackNavigationListener(ObricBackNavigationListener r1);

    boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r1);

    boolean registerTaskStackListenerEx(ObricTaskStackListener r1);

    boolean requestTopActivityAssistData(int r1, int r2, ITopActivityAssistDataReceiver r3);

    void setMuteWhitelist(List<String> r1);

    boolean supportsAutoVirtualDisplayRecordSet();

    void tryToMute(boolean r1);

    boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1);

    boolean unregisterBackNavigationListener(ObricBackNavigationListener r1);

    boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r1);

    boolean unregisterTaskStackListenerEx(ObricTaskStackListener r1);
}
