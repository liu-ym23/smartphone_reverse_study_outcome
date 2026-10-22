package com.obric.autogui.common.api.space.vd;

import android.content.Context;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.space.BaseDisplaySpaceManager;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.vd.spawn.VDSpaceSpawner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.d;
import d.x;
import kotlinx.coroutines.f.a;

/* JADX INFO: compiled from: VDSpaceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDSpaceManager extends BaseDisplaySpaceManager<VDSpace> {
    public static final VDSpaceManager INSTANCE = null;
    private static final String logTag = null;

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager
    public /* synthetic */ Object destroyDisplaySpace(Context r3, DisplayOperatingSpace r4, d r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        DisplayOperatingSpace r7 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d<? super x> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return destroyDisplaySpace(r6, (VDSpace) ZeusTransformUtils.preCheckCast(r7, VDSpace.class, "com.obric.aiagent.plugin"), r8);
    }

    private VDSpaceManager() {
    }

    static {
        INSTANCE = new VDSpaceManager();
        logTag = "VDSpaceManager";
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager
    public String getLogTag() {
        return logTag;
    }

    public final a getVDLock() {
        return getManagerLock();
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager
    public Object spawnSpace(Context r2, CCLifecycleListener r3, d<? super VDSpace> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r5 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r3, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        d<? super VDSpace> r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return new VDSpaceSpawner(r1).spawn(r6);
    }

    public Object destroyDisplaySpace(Context r2, VDSpace r3, d<? super x> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Object r5 = r3.destroyVD((d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
        if (r5 != b.a()) goto L6;
        return r5;
    L6:
        return x.f38692a;
    }
}
