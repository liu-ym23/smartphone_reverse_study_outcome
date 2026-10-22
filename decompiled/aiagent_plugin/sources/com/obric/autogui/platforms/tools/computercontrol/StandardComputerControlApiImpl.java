package com.obric.autogui.platforms.tools.computercontrol;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.view.Surface;
import android.view.View;
import android.view.accessibility.AccessibilityWindowInfo;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessResult;
import com.obric.autogui.common.api.platform.computercontrol.CCDataResult;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionConfig;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionRequestResult;
import com.obric.autogui.common.api.platform.computercontrol.CCStabilityListener;
import com.obric.autogui.common.api.platform.computercontrol.CCTouchEvent;
import com.obric.autogui.common.api.platform.computercontrol.CCTouchListener;
import com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.j;
import java.util.List;

/* JADX INFO: compiled from: StandardComputerControlApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StandardComputerControlApiImpl implements IComputerControlApi {
    private static final Companion Companion = null;
    private static final String TAG = "StandardComputerControlApiImpl";
    private final f delegate$delegate;

    /* JADX INFO: compiled from: StandardComputerControlApiImpl.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ IComputerControlApi lambda$VHFkcC1fsV1l8uudbXZvD3aTgHE(StandardComputerControlApiImpl r0) {
        return delegate_delegate$lambda$0(r0);
    }

    public StandardComputerControlApiImpl() {
        this.delegate$delegate = g.a(j.f38505a, new $$Lambda$StandardComputerControlApiImpl$VHFkcC1fsV1l8uudbXZvD3aTgHE(this));
    }

    private final IComputerControlApi getDelegate() {
        return (IComputerControlApi) ZeusTransformUtils.preCheckCast(this.delegate$delegate.b(), IComputerControlApi.class, "com.obric.aiagent.plugin");
    }

    private static final IComputerControlApi delegate_delegate$lambda$0(StandardComputerControlApiImpl r0) {
        return r0.createDelegate();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<Integer> getVersion() {
        return getDelegate().getVersion();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public boolean isSupported(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        return getDelegate().isSupported(r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public Object requestSession(Context r3, CCSessionConfig r4, CCLifecycleListener r5, d<? super CCSessionRequestResult> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r8 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r5, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        d<? super CCSessionRequestResult> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        return getDelegate().requestSession(r7, r4, r8, r9);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setSurface(CCSessionAccessor r3, Surface r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return getDelegate().setSurface(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<View> createMirrorView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        return getDelegate().createMirrorView(r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult bindMirrorView(CCSessionAccessor r3, View r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        o.e(r4, "mirrorView");
        return getDelegate().bindMirrorView(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult unbindMirrorView(View r2) {
        o.e(r2, "mirrorView");
        return getDelegate().unbindMirrorView(r2);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setMirrorViewInteractive(View r2, boolean r3) {
        o.e(r2, "mirrorView");
        return getDelegate().setMirrorViewInteractive(r2, r3);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setMirrorViewCornerRadius(View r2, int r3) {
        o.e(r2, "mirrorView");
        return getDelegate().setMirrorViewCornerRadius(r2, r3);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tap(CCSessionAccessor r3, int r4, int r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        return getDelegate().tap(r6, r4, r5);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tap(CCSessionAccessor r3, int r4, int r5, int r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, SensitiveType.SESSION);
        return getDelegate().tap(r7, r4, r5, r6);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tapWithInterval(CCSessionAccessor r7, int r8, int r9, long r10) {
        CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r7, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r1, SensitiveType.SESSION);
        return getDelegate().tapWithInterval(r1, r8, r9, r10);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tapWithInterval(CCSessionAccessor r8, int r9, int r10, long r11, int r13) {
        CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r1, SensitiveType.SESSION);
        return getDelegate().tapWithInterval(r1, r9, r10, r11, r13);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipe(CCSessionAccessor r7, int r8, int r9, int r10, int r11) {
        CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r7, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r1, SensitiveType.SESSION);
        return getDelegate().swipe(r1, r8, r9, r10, r11);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipe(CCSessionAccessor r8, int r9, int r10, int r11, int r12, int r13) {
        CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r1, SensitiveType.SESSION);
        return getDelegate().swipe(r1, r9, r10, r11, r12, r13);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipeWithDuration(CCSessionAccessor r9, int r10, int r11, int r12, int r13, long r14) {
        CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r9, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r1, SensitiveType.SESSION);
        return getDelegate().swipeWithDuration(r1, r10, r11, r12, r13, r14);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipeWithDuration(CCSessionAccessor r11, int r12, int r13, int r14, int r15, long r16, int r18) {
        CCSessionAccessor r2 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r11, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r2, SensitiveType.SESSION);
        return getDelegate().swipeWithDuration(r2, r12, r13, r14, r15, r16, r18);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult longPress(CCSessionAccessor r3, int r4, int r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        return getDelegate().longPress(r6, r4, r5);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult longPress(CCSessionAccessor r3, int r4, int r5, int r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, SensitiveType.SESSION);
        return getDelegate().longPress(r7, r4, r5, r6);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult sendTouchEvent(CCSessionAccessor r3, CCTouchEvent r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        o.e(r4, "event");
        return getDelegate().sendTouchEvent(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setTouchListener(CCSessionAccessor r3, CCTouchListener r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CCTouchListener r6 = (CCTouchListener) ZeusTransformUtils.wrapperContextForParams(r4, CCTouchListener.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return getDelegate().setTouchListener(r5, r6);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult inputText(CCSessionAccessor r3, String r4, boolean r5, boolean r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, SensitiveType.SESSION);
        o.e(r4, "text");
        return getDelegate().inputText(r7, r4, r5, r6);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult key(CCSessionAccessor r3, int r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return getDelegate().key(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult performAction(CCSessionAccessor r3, int r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return getDelegate().performAction(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult sendKeyEvent(CCSessionAccessor r7, int r8, int r9, long r10) {
        CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r7, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r1, SensitiveType.SESSION);
        return getDelegate().sendKeyEvent(r1, r8, r9, r10);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult startActivity(CCSessionAccessor r3, Context r4, Intent r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        o.e(r7, "context");
        o.e(r5, MemorySourceLinkType.INTENT);
        return getDelegate().startActivity(r6, r7, r5);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tryToMute(CCSessionAccessor r3, boolean r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return getDelegate().tryToMute(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<CCApplicationAccessResult> requestApplicationAccess(CCSessionAccessor r3, String r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        o.e(r4, "packageName");
        return getDelegate().requestApplicationAccess(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult launchApplicationAccessConsent(Context r3, IntentSender r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "intentSender");
        return getDelegate().launchApplicationAccessConsent(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult launchApplication(CCSessionAccessor r3, String r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        o.e(r4, "packageName");
        return getDelegate().launchApplication(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult handOverApplications(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return getDelegate().handOverApplications(r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult notifyBlocked(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return getDelegate().notifyBlocked(r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult requestUnblock(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return getDelegate().requestUnblock(r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setLifecycleListener(CCSessionAccessor r3, CCLifecycleListener r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r6 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r4, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return getDelegate().setLifecycleListener(r5, r6);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult clearLifecycleListener(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return getDelegate().clearLifecycleListener(r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<List<AccessibilityWindowInfo>> getAccessibilityWindows(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return getDelegate().getAccessibilityWindows(r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public Object dumpViewHierarchy(CCSessionAccessor r3, boolean r4, d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return getDelegate().dumpViewHierarchy(r6, r4, r7);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setStabilityListener(CCSessionAccessor r3, CCStabilityListener r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CCStabilityListener r6 = (CCStabilityListener) ZeusTransformUtils.wrapperContextForParams(r4, CCStabilityListener.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return getDelegate().setStabilityListener(r5, r6);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public ScreenshotResult screenshot(CCSessionAccessor r3, ScreenshotConfig r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return getDelegate().screenshot(r5, r4);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult close(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return getDelegate().close(r4);
    }

    private final IComputerControlApi createDelegate() {
        return (IComputerControlApi) ZeusTransformUtils.preCheckCast(new ComputerControlSdkApiImpl(), IComputerControlApi.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "Computer Control SDK is unavailable, fallback to unsupported api.", th);
        return (IComputerControlApi) ZeusTransformUtils.preCheckCast(new UnsupportedComputerControlApi(th), IComputerControlApi.class, "com.obric.aiagent.plugin");
    }
}
