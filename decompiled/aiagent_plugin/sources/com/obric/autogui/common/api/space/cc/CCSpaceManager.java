package com.obric.autogui.common.api.space.cc;

import android.content.Context;
import android.view.View;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.space.BaseDisplaySpaceManager;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.d;
import d.h.b.o;
import d.k;
import d.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.f.a;

/* JADX INFO: compiled from: CCSpaceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CCSpaceManager extends BaseDisplaySpaceManager<CCSpace> {
    public static final CCSpaceManager INSTANCE = null;
    private static final String logTag = null;
    private static final AtomicReference<WeakReference<View>> mCurrentMirrorView = null;

    private CCSpaceManager() {
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager
    public /* synthetic */ Object destroyDisplaySpace(Context r3, DisplayOperatingSpace r4, d r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        DisplayOperatingSpace r7 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d<? super x> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return destroyDisplaySpace(r6, (CCSpace) ZeusTransformUtils.preCheckCast(r7, CCSpace.class, "com.obric.aiagent.plugin"), r8);
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager
    public /* synthetic */ void logCreateSpaceSuccess(DisplayOperatingSpace r3) {
        logCreateSpaceSuccess((CCSpace) ZeusTransformUtils.preCheckCast((DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin"), CCSpace.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager
    public /* synthetic */ Object onSpaceCreated(Context r3, DisplayOperatingSpace r4, d r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        DisplayOperatingSpace r7 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d<? super x> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return onSpaceCreated(r6, (CCSpace) ZeusTransformUtils.preCheckCast(r7, CCSpace.class, "com.obric.aiagent.plugin"), r8);
    }

    static {
        INSTANCE = new CCSpaceManager();
        logTag = "CCSpaceManager";
        mCurrentMirrorView = new AtomicReference();
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager
    public String getLogTag() {
        return logTag;
    }

    public final a getCCLock() {
        return getManagerLock();
    }

    public final View getCurrentMirrorView$common_release() {
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(mCurrentMirrorView.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.aiagent.plugin");
    }

    public Object onSpaceCreated(Context r3, CCSpace r4, d<? super x> r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        WeakReference r7 = (WeakReference) ZeusTransformUtils.preCheckCast(mCurrentMirrorView.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L8;
        View r8 = (View) ZeusTransformUtils.preCheckCast(r7.get(), View.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L8;
        Loog r9 = Loog.INSTANCE;
        CCSpaceManager r10 = INSTANCE;
        r9.i(r10.getLogTag(), "createSpace: restoring existing MirrorView to the new CCSpace.");
        r10.bindMirrorView(r4, r8);
    L8:
        return x.f38692a;
    }

    public void logCreateSpaceSuccess(CCSpace r4) {
        o.e(r4, "space");
        Loog.INSTANCE.i(getLogTag(), "createSpace success: spaceId=" + r4.getSpaceId() + ", displayId=" + r4.getDisplayId() + ", size=" + r4.getSessionAccessor().getDisplaySize());
    }

    public Object destroyDisplaySpace(Context r2, CCSpace r3, d<? super x> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Object r5 = r3.destroyCC((d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
        if (r5 != b.a()) goto L6;
        return r5;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager, com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void attachMonitor(OperatingSpaceMonitor r4) {
        OperatingSpaceMonitor r5 = (OperatingSpaceMonitor) ZeusTransformUtils.wrapperContextForParams(r4, OperatingSpaceMonitor.class, "com.obric.aiagent.plugin");
        o.e(r5, "monitor");
        DisplayHost r0 = r5.getHost();
        if (ZeusTransformUtils.instanceOf(r0, DisplayHost.Surface.class) == false) goto L6;
        super.attachMonitor(r5);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, DisplayHost.Mirror.class) == false) goto L10;
        attachMirrorHost((DisplayHost.Mirror) ZeusTransformUtils.preCheckCast(r0, DisplayHost.Mirror.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        throw new k();
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager, com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void detachMonitor(OperatingSpaceMonitor r4) {
        OperatingSpaceMonitor r5 = (OperatingSpaceMonitor) ZeusTransformUtils.wrapperContextForParams(r4, OperatingSpaceMonitor.class, "com.obric.aiagent.plugin");
        o.e(r5, "monitor");
        DisplayHost r0 = r5.getHost();
        if (ZeusTransformUtils.instanceOf(r0, DisplayHost.Surface.class) == false) goto L6;
        super.detachMonitor(r5);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, DisplayHost.Mirror.class) == false) goto L10;
        detachMirrorHost((DisplayHost.Mirror) ZeusTransformUtils.preCheckCast(r0, DisplayHost.Mirror.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        throw new k();
    }

    private final void attachMirrorHost(DisplayHost.Mirror r7) {
        AtomicReference<WeakReference<View>> r0 = mCurrentMirrorView;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.get(), View.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
    L10:
        r0.set(new WeakReference(r7.getView()));
        Loog.INSTANCE.i(getLogTag(), "[CCMirrorView] attachMonitor: oldMirror=" + describeMirrorView(r2) + ", newMirror=" + describeMirrorView(r7.getView()) + ", activeSpace=" + getActiveSpace());
        CCSpace r6 = (CCSpace) ZeusTransformUtils.preCheckCast(getActiveSpace(), CCSpace.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L14;
        INSTANCE.bindMirrorView(r6, r7.getView());
        return;
    L14:
        return;
    L8:
        if (r2 == r7.getView()) goto L10;
        unbindMirrorView(r2);
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private final void detachMirrorHost(DisplayHost.Mirror r10) {
        AtomicReference<WeakReference<View>> r0 = mCurrentMirrorView;
        WeakReference<View> r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r1.get(), View.class, "com.obric.aiagent.plugin");
    L6:
        Loog.INSTANCE.i(getLogTag(), "[CCMirrorView] detachMonitor: mirror=" + describeMirrorView(r10.getView()) + ", currentMirror=" + describeMirrorView(r4) + ", activeSpace=" + getActiveSpace());
        if (r4 == r10.getView()) goto L10;
        Loog.INSTANCE.i(getLogTag(), "[CCMirrorView] detachMonitor: skipped because mirror is not current.");
        return;
    L10:
        CCSpace r5 = (CCSpace) ZeusTransformUtils.preCheckCast(getActiveSpace(), CCSpace.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L13;
        r5.configureHandUsing(false, (DisplayHost) ZeusTransformUtils.preCheckCast(r10, DisplayHost.class, "com.obric.aiagent.plugin"), null);
    L13:
        unbindMirrorView(r10.getView());
        if (r0.compareAndSet(r1, null) == true) goto L17;
        Loog.INSTANCE.i(getLogTag(), "[CCMirrorView] detachMonitor: skipped clearing current mirror because it has changed.");
        return;
    L17:
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void bindMirrorView(CCSpace r3, View r4) {
        CCActionResult r5 = AOPlatformTools.INSTANCE.computerControl().bindMirrorView(r3.getSessionAccessor(), r4);
        if (ZeusTransformUtils.instanceOf(r5, CCActionResult.Failed.class) == false) goto L6;
        Loog.INSTANCE.w(getLogTag(), "[CCMirrorView] bindMirrorView failed: " + r5);
        return;
    }

    private final void unbindMirrorView(View r4) {
        CCActionResult r5 = AOPlatformTools.INSTANCE.computerControl().unbindMirrorView(r4);
        if (ZeusTransformUtils.instanceOf(r5, CCActionResult.Failed.class) == false) goto L6;
        Loog.INSTANCE.w(getLogTag(), "[CCMirrorView] unbindMirrorView failed: " + r5);
        return;
    }

    private final String describeMirrorView(View r3) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        int r2 = System.identityHashCode(r3);
        StringBuilder r4 = new StringBuilder().append("MirrorView@");
        String r0 = Integer.toString(r2, d.o.a.a(16));
        o.c(r0, "toString(...)");
        return r4.append(r0).append('(').append(r2).append(')').toString();
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplaySpaceManager
    public Object spawnSpace(Context r4, CCLifecycleListener r5, d<? super CCSpace> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r8 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r5, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        d<? super CCSpace> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        ICCSpaceSpawner r0 = (ICCSpaceSpawner) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ICCSpaceSpawner.class), ICCSpaceSpawner.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(getLogTag(), "createSpace: ICCSpaceSpawner service missing.");
        return null;
    L7:
        return r0.spawn(r7, r8, r9);
    }
}
