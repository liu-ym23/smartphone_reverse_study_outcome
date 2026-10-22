package com.obric.autogui.common.api;

import android.content.Context;
import android.graphics.PointF;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatform;
import com.obric.autogui.common.api.platform.AOPlatformInformation;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;
import d.m;

/* JADX INFO: compiled from: AODeviceSpecificTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AODeviceSpecificTools {
    public static final AODeviceSpecificTools INSTANCE = null;
    public static final String TAG = "AO/DevSpecTool";

    /* JADX INFO: compiled from: AODeviceSpecificTools.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DisplayAccessor.Rotation.values().length];
            r0[DisplayAccessor.Rotation.Rotation0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DisplayAccessor.Rotation.Rotation90.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DisplayAccessor.Rotation.Rotation180.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DisplayAccessor.Rotation.Rotation270.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new AODeviceSpecificTools();
    }

    private AODeviceSpecificTools() {
    }

    public final m<Integer, Integer> getScreenDimensions() {
        DisplayAccessor r0 = AOPlatformTools.INSTANCE.display().getMDAccess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        if (r0 != null) goto L8;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getScreenDimensions failed (mdAccess is null)");
        return null;
    L8:
        return r0.getDecoratedDimensions();
    L9:
        th = move-exception;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getScreenDimensions failed when getting mdAccess", th);
        return null;
    }

    public static /* synthetic */ PointF denormaliseOperatingSpacePosition$default(AODeviceSpecificTools r0, PointF r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.denormaliseOperatingSpacePosition(r1, r2);
    }

    public final PointF denormaliseOperatingSpacePosition(PointF r7, boolean r8) {
        o.e(r7, "position");
        AOOperatingSpace r6 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r6 != null) goto L6;
        Loog.INSTANCE.e(TAG, "denormaliseOperatingSpacePosition failed (operatingSpace is null)");
        return null;
    L6:
        m<Integer, Integer> r0 = r6.getDimensions();
        PointF r1 = new PointF(r7.x * ((Number) ZeusTransformUtils.preCheckCast(r0.a(), Number.class, "com.obric.aiagent.plugin")).floatValue(), r7.y * ((Number) ZeusTransformUtils.preCheckCast(r0.b(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        if (r8 == true) goto L9;
        return r1;
    L9:
        DisplayAccessor.Rotation r9 = r6.getSpaceStatus().getRotation();
        int r10 = WhenMappings.$EnumSwitchMapping$0[r9.ordinal()];
        if (r10 != 1) goto L12;
        return r1;
    L12:
        if (r10 != 2) goto L14;
        PointF r11 = new PointF(((Number) ZeusTransformUtils.preCheckCast(r0.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() - r1.y, r1.x);
    L23:
        return r11;
    L14:
        if (r10 != 3) goto L16;
        r11 = new PointF(((Number) ZeusTransformUtils.preCheckCast(r0.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() - r1.x, ((Number) ZeusTransformUtils.preCheckCast(r0.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() - r1.y);
        goto L23
    L16:
        if (r10 != 4) goto L19;
        r11 = new PointF(r1.y, ((Number) ZeusTransformUtils.preCheckCast(r0.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() - r1.x);
        goto L23
    L19:
        throw new k();
    }

    public final PointF normaliseOperatingSpacePosition(PointF r6) {
        o.e(r6, "position");
        AOOperatingSpace r5 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r5 != null) goto L6;
        Loog.INSTANCE.e(TAG, "normaliseOperatingSpacePosition failed (operatingSpace is null)");
        return null;
    L6:
        m<Integer, Integer> r7 = r5.getDimensions();
        if (((Number) ZeusTransformUtils.preCheckCast(r7.a(), Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L9;
        return null;
    L9:
        if (((Number) ZeusTransformUtils.preCheckCast(r7.b(), Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L12;
        return null;
    L12:
        return new PointF(r6.x / ((Number) ZeusTransformUtils.preCheckCast(r7.a(), Number.class, "com.obric.aiagent.plugin")).floatValue(), r6.y / ((Number) ZeusTransformUtils.preCheckCast(r7.b(), Number.class, "com.obric.aiagent.plugin")).floatValue());
    }

    public final String generateDeviceInfo() {
        AOPlatformInformation r4 = AOPlatform.INSTANCE.getPlatform().getInformation();
        return "DT=" + (r4.getName() + '-' + r4.getProject()) + "FWK=" + r4.getFrameworkApiVersion() + "RM=" + r4.getRomVersion();
    }
}
