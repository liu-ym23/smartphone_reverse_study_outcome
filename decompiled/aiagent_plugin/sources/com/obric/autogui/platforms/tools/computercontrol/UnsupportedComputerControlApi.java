package com.obric.autogui.platforms.tools.computercontrol;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.view.Surface;
import android.view.View;
import android.view.accessibility.AccessibilityWindowInfo;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.platform.computercontrol.CCActionFailureReason;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessResult;
import com.obric.autogui.common.api.platform.computercontrol.CCDataResult;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionConfig;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionFailureReason;
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
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: StandardComputerControlApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
final class UnsupportedComputerControlApi implements IComputerControlApi {
    private final Throwable cause;

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public boolean isSupported(Context r2) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        return false;
    }

    public UnsupportedComputerControlApi(Throwable r1) {
        this.cause = r1;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<Integer> getVersion() {
        return unsupportedData();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public Object requestSession(Context r7, CCSessionConfig r8, CCLifecycleListener r9, d<? super CCSessionRequestResult> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r12 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r9, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        return new CCSessionRequestResult.Failed(CCSessionFailureReason.Unsupported, null, this.cause, 2, null);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setSurface(CCSessionAccessor r2, Surface r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r2, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<View> createMirrorView(Context r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        return unsupportedData();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult bindMirrorView(CCSessionAccessor r3, View r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        o.e(r4, "mirrorView");
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult unbindMirrorView(View r2) {
        o.e(r2, "mirrorView");
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setMirrorViewInteractive(View r1, boolean r2) {
        o.e(r1, "mirrorView");
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setMirrorViewCornerRadius(View r1, int r2) {
        o.e(r1, "mirrorView");
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tap(CCSessionAccessor r1, int r2, int r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tap(CCSessionAccessor r1, int r2, int r3, int r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tapWithInterval(CCSessionAccessor r1, int r2, int r3, long r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tapWithInterval(CCSessionAccessor r1, int r2, int r3, long r4, int r6) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipe(CCSessionAccessor r1, int r2, int r3, int r4, int r5) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipe(CCSessionAccessor r1, int r2, int r3, int r4, int r5, int r6) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipeWithDuration(CCSessionAccessor r1, int r2, int r3, int r4, int r5, long r6) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipeWithDuration(CCSessionAccessor r1, int r2, int r3, int r4, int r5, long r6, int r8) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult longPress(CCSessionAccessor r1, int r2, int r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult longPress(CCSessionAccessor r1, int r2, int r3, int r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult sendTouchEvent(CCSessionAccessor r3, CCTouchEvent r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        o.e(r4, "event");
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setTouchListener(CCSessionAccessor r3, CCTouchListener r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CCTouchListener r6 = (CCTouchListener) ZeusTransformUtils.wrapperContextForParams(r4, CCTouchListener.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult inputText(CCSessionAccessor r1, String r2, boolean r3, boolean r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        o.e(r2, "text");
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult key(CCSessionAccessor r2, int r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r2, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult performAction(CCSessionAccessor r2, int r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r2, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult sendKeyEvent(CCSessionAccessor r1, int r2, int r3, long r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult startActivity(CCSessionAccessor r3, Context r4, Intent r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        o.e(r7, "context");
        o.e(r5, MemorySourceLinkType.INTENT);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tryToMute(CCSessionAccessor r2, boolean r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r2, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<CCApplicationAccessResult> requestApplicationAccess(CCSessionAccessor r3, String r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        o.e(r4, "packageName");
        return unsupportedData();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult launchApplicationAccessConsent(Context r3, IntentSender r4) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r4, "intentSender");
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult launchApplication(CCSessionAccessor r3, String r4) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        o.e(r4, "packageName");
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult handOverApplications(CCSessionAccessor r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult notifyBlocked(CCSessionAccessor r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult requestUnblock(CCSessionAccessor r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setLifecycleListener(CCSessionAccessor r3, CCLifecycleListener r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r6 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r4, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult clearLifecycleListener(CCSessionAccessor r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<List<AccessibilityWindowInfo>> getAccessibilityWindows(CCSessionAccessor r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedData();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public Object dumpViewHierarchy(CCSessionAccessor r1, boolean r2, d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r3) {
        CCSessionAccessor r0 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r1, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.d.f29012a.a("unsupported");
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setStabilityListener(CCSessionAccessor r3, CCStabilityListener r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        CCStabilityListener r6 = (CCStabilityListener) ZeusTransformUtils.wrapperContextForParams(r4, CCStabilityListener.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return unsupportedAction();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public ScreenshotResult screenshot(CCSessionAccessor r10, ScreenshotConfig r11) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r10, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return new ScreenshotResult(ScreenshotResult.Status.NotSupported, null, null, 0, null, null, 62, null);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult close(CCSessionAccessor r3) {
        o.e((CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin"), SensitiveType.SESSION);
        return unsupportedAction();
    }

    private final CCActionResult unsupportedAction() {
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.Unsupported, this.cause), CCActionResult.class, "com.obric.aiagent.plugin");
    }

    private final <T> CCDataResult<T> unsupportedData() {
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.Unsupported, this.cause), CCDataResult.class, "com.obric.aiagent.plugin");
    }
}
