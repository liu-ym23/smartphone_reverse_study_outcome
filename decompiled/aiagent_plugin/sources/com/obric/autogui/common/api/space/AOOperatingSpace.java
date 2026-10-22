package com.obric.autogui.common.api.space;

import android.content.ComponentName;
import android.content.Context;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.space.handusing.HandUsingConfigResult;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.common.api.space.status.SpaceStatus;
import com.obric.autogui.common.api.space.status.SpaceStatusCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.d.a;
import d.d.b;
import d.m;

/* JADX INFO: compiled from: AOOperatingSpace.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface AOOperatingSpace {

    /* JADX INFO: compiled from: AOOperatingSpace.kt */
    public static final enum SpaceType extends Enum<SpaceType> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ SpaceType[] $VALUES = null;
        public static final SpaceType ComputerControl = null;
        public static final SpaceType MainDisplay = null;
        public static final SpaceType VirtualDisplay = null;

        private static final /* synthetic */ SpaceType[] $values() {
            return new SpaceType[]{MainDisplay, VirtualDisplay, ComputerControl};
        }

        public static a<SpaceType> getEntries() {
            return $ENTRIES;
        }

        private SpaceType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            MainDisplay = new SpaceType("MainDisplay", 0);
            VirtualDisplay = new SpaceType("VirtualDisplay", 1);
            ComputerControl = new SpaceType("ComputerControl", 2);
            SpaceType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static SpaceType valueOf(String r2) {
            return (SpaceType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SpaceType.class, r2), SpaceType.class, "com.obric.aiagent.plugin");
        }

        public static SpaceType[] values() {
            return (SpaceType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SpaceType[].class, "com.obric.aiagent.plugin");
        }
    }

    Object acquireScreenshot(Context r1, ScreenshotConfig r2, d<? super ScreenshotResult> r3);

    HandUsingConfigResult configureHandUsing(boolean r1, DisplayHost r2, HandUsingEventsCallback r3);

    DisplayedAppInfo fetchTopDisplayed();

    m<Integer, Integer> getDimensions();

    kotlinx.coroutines.f.a getLock();

    String getRobotsProxyPolicy();

    RobotsScreenshotBlockReason getRobotsScreenshotBlockReason();

    String getSpaceId();

    SpaceStatus getSpaceStatus();

    SpaceType getType();

    boolean isValid();

    void setMuted(boolean r1);

    void setStatusCallback(SpaceStatusCallback r1);

    void updateRobotsPolicyCache(ComponentName r1);
}
