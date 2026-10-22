package com.obric.autogui.common.api.virtualdisplay;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionVDListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionVDListener {

    /* JADX INFO: compiled from: IAutoActionVDListener.kt */
    public static final class DefaultImpls {
        public static void appMovedToMdBackground(IAutoActionVDListener r2, String r3) {
            IAutoActionVDListener r4 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "appPackage");
        }

        public static boolean canMoveTrackingAppToVdOnScreenOff(IAutoActionVDListener r2) {
            IAutoActionVDListener r3 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
            return false;
        }

        public static String captureOperationOwnerToken(IAutoActionVDListener r2) {
            IAutoActionVDListener r3 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static void taskClosed(IAutoActionVDListener r0, int r1, boolean r2) {
            IAutoActionVDListener r3 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r0, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
        }

        public static void trackingAppMovedToMd(IAutoActionVDListener r2, VDTrackingApp r3) {
            IAutoActionVDListener r4 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "trackingApp");
        }

        public static void trackingAppMovedToVd(IAutoActionVDListener r2, VDTrackingApp r3) {
            IAutoActionVDListener r4 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "app");
        }

        public static void trackingAppTerminated(IAutoActionVDListener r2, VDTrackingApp r3) {
            IAutoActionVDListener r4 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "trackingApp");
        }

        public static void vdBlacklistAppOpen(IAutoActionVDListener r1, String r2) {
            IAutoActionVDListener r3 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r1, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
        }

        public static void vdOperatingAppChanged(IAutoActionVDListener r1, VDTrackingApp r2) {
            IAutoActionVDListener r3 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r1, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
        }

        public static void vdStartActivityIntercepted(IAutoActionVDListener r0, int r1, int r2, ComponentName r3) {
            IAutoActionVDListener r4 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r0, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
        }

        public static void vdTaskIdChanged(IAutoActionVDListener r1, int r2) {
            IAutoActionVDListener r3 = (IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r1, IAutoActionVDListener.class, "com.obric.aiagent.plugin");
        }

        public static void vdOperatingAppChanged(IAutoActionVDListener r1, VDTrackingApp r2, String r3) {
            ((IAutoActionVDListener) ZeusTransformUtils.wrapperContextForParams(r1, IAutoActionVDListener.class, "com.obric.aiagent.plugin")).vdOperatingAppChanged(r2);
        }
    }

    void appMovedToMdBackground(String r1);

    boolean canMoveTrackingAppToVdOnScreenOff();

    String captureOperationOwnerToken();

    String getTrackingAppPkgName();

    void taskClosed(int r1, boolean r2);

    void trackingAppMovedToMd(VDTrackingApp r1);

    void trackingAppMovedToVd(VDTrackingApp r1);

    void trackingAppTerminated(VDTrackingApp r1);

    void vdBlacklistAppOpen(String r1);

    void vdOperatingAppChanged(VDTrackingApp r1);

    void vdOperatingAppChanged(VDTrackingApp r1, String r2);

    void vdStartActivityIntercepted(int r1, int r2, ComponentName r3);

    void vdTaskIdChanged(int r1);
}
