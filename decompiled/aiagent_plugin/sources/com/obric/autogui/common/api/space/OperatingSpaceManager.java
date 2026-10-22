package com.obric.autogui.common.api.space;

import android.content.Context;
import com.obric.autogui.common.a.b;
import com.obric.autogui.common.a.c;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.space.cc.CCSpaceManager;
import com.obric.autogui.common.api.space.handusing.HandUsingConfigResult;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor;
import com.obric.autogui.common.api.space.status.SpaceStatusCallback;
import com.obric.autogui.common.api.space.vd.VDSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.f;
import d.g;
import d.h.b.o;
import d.x;
import java.util.Collection;

/* JADX INFO: compiled from: OperatingSpaceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatingSpaceManager implements IOperatingSpaceManager {
    public static final OperatingSpaceManager INSTANCE = null;
    private static final String TAG = "OperatingSpaceManager";
    private static final f delegate$delegate = null;

    /* JADX INFO: renamed from: lambda$RzWx-7TjNtsocB5extO4cnn-pNw, reason: not valid java name */
    public static /* synthetic */ BaseDisplaySpaceManager m807lambda$RzWx7TjNtsocB5extO4cnnpNw() {
        return delegate_delegate$lambda$0();
    }

    private OperatingSpaceManager() {
    }

    static {
        INSTANCE = new OperatingSpaceManager();
        delegate$delegate = g.a($$Lambda$OperatingSpaceManager$RzWx7TjNtsocB5extO4cnnpNw.INSTANCE);
    }

    private final IOperatingSpaceManager getDelegate() {
        return (IOperatingSpaceManager) ZeusTransformUtils.preCheckCast(delegate$delegate.b(), IOperatingSpaceManager.class, "com.obric.aiagent.plugin");
    }

    private static final BaseDisplaySpaceManager delegate_delegate$lambda$0() {
        b r0 = c.f28972a.a();
        if (r0.c() == false) goto L5;
        BaseDisplaySpaceManager r1 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(CCSpaceManager.INSTANCE, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
    L6:
        Loog.INSTANCE.i(TAG, "Selected operating space manager: " + r1.getClass().getSimpleName() + ", config=" + r0);
        return r1;
    L5:
        r1 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(VDSpaceManager.INSTANCE, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        goto L6
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void setGlobalDisabledApps(Collection<String> r3) {
        Collection<String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "packages");
        getDelegate().setGlobalDisabledApps(r4);
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public AOOperatingSpace getActiveSpace() {
        return getDelegate().getActiveSpace();
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public Object createSpace(Context r3, CCLifecycleListener r4, d<? super IOperatingSpaceManager.OpSpaceCreationResult> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r7 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r4, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        d<? super IOperatingSpaceManager.OpSpaceCreationResult> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return getDelegate().createSpace(r6, r7, r8);
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public Object destroySpace(Context r3, AOOperatingSpace r4, d<? super x> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r7 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d<? super x> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        Object r2 = getDelegate().destroySpace(r6, r7, r8);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void postDestroyAllSpaces(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        getDelegate().postDestroyAllSpaces(r4);
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public HandUsingConfigResult configureHandUsing(Context r3, boolean r4, DisplayHost r5, HandUsingEventsCallback r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        HandUsingEventsCallback r8 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r6, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        return getDelegate().configureHandUsing(r7, r4, r5, r8);
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void configureStatusListening(Context r3, SpaceStatusCallback r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        SpaceStatusCallback r6 = (SpaceStatusCallback) ZeusTransformUtils.wrapperContextForParams(r4, SpaceStatusCallback.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        getDelegate().configureStatusListening(r5, r6);
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void attachMonitor(OperatingSpaceMonitor r3) {
        OperatingSpaceMonitor r4 = (OperatingSpaceMonitor) ZeusTransformUtils.wrapperContextForParams(r3, OperatingSpaceMonitor.class, "com.obric.aiagent.plugin");
        o.e(r4, "monitor");
        getDelegate().attachMonitor(r4);
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void detachMonitor(OperatingSpaceMonitor r3) {
        OperatingSpaceMonitor r4 = (OperatingSpaceMonitor) ZeusTransformUtils.wrapperContextForParams(r3, OperatingSpaceMonitor.class, "com.obric.aiagent.plugin");
        o.e(r4, "monitor");
        getDelegate().detachMonitor(r4);
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void setMuted(boolean r1) {
        getDelegate().setMuted(r1);
    }
}
