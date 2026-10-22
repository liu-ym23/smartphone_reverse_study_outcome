package com.obric.autogui.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.packages.StartActivityPosition;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.cc.CCSpace;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: AOSystemTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOSystemTools {
    public static final AOSystemTools INSTANCE = null;

    static {
        INSTANCE = new AOSystemTools();
    }

    private AOSystemTools() {
    }

    public final long nowTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long upTimeMillis() {
        return SystemClock.uptimeMillis();
    }

    public final long bootTimeMillis() {
        return SystemClock.elapsedRealtime();
    }

    public final int getMainDisplayId() {
        return AOPlatformTools.INSTANCE.display().getMainDisplayId();
    }

    public final String getHostAppPackage() {
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();
        o.c(r2, "getPackageName(...)");
        return r2;
    }

    public final boolean isDebugVersion() {
        return IAppContext.Companion.isDebug();
    }

    public final boolean isDebuggable() {
        return AOPlatformTools.INSTANCE.system().isSystemDebuggable();
    }

    public final String randomId() {
        StringBuilder r0 = new StringBuilder();
        String r1 = UUID.randomUUID().toString();
        o.c(r1, "toString(...)");
        String r2 = r1.substring(0, 8);
        o.c(r2, "substring(...)");
        return r0.append(r2).append('_').append(Integer.toHexString((int) (nowTimeMillis() % ((long) 100000)))).toString();
    }

    public static /* synthetic */ StartActivityResult startActivity$default(AOSystemTools r1, Context r2, Intent r3, StartActivityPosition r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = StartActivityPosition.ActiveOperatingSpace;
    L6:
        return r1.startActivity(r7, r3, r4);
    }

    public final StartActivityResult startActivity(Context r2, Intent r3, StartActivityPosition r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, MemorySourceLinkType.INTENT);
        o.e(r4, "position");
        return AOPlatformTools.INSTANCE.packages().startActivity(r1, r3, r4);
    }

    public final void returnToLauncher(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        DisplayAccessor r3 = AOPlatformTools.INSTANCE.display().getMDAccess(r1);
        if (r3 == null) goto L6;
        AOPlatformTools.INSTANCE.input().key(r3, 3);
        return;
    }

    public static /* synthetic */ Object dumpViewHierarchy$default(AOSystemTools r1, int r2, boolean r3, d r4, int r5, Object r6) {
        d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = true;
    L6:
        return r1.dumpViewHierarchy(r2, r3, r7);
    }

    public final Object dumpViewHierarchy(int r3, boolean r4, d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r5) {
        d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r2 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r6 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (ZeusTransformUtils.instanceOf(r6, CCSpace.class) == false) goto L9;
        if (((CCSpace) ZeusTransformUtils.preCheckCast(r6, CCSpace.class, "com.obric.aiagent.plugin")).getDisplayId() != r3) goto L9;
        return AOPlatformTools.INSTANCE.computerControl().dumpViewHierarchy(((CCSpace) ZeusTransformUtils.preCheckCast(r6, CCSpace.class, "com.obric.aiagent.plugin")).getSessionAccessor(), r4, r2);
    L9:
        return AOPlatformTools.INSTANCE.system().dumpViewHierarchy(r3, r4, r2);
    }
}
