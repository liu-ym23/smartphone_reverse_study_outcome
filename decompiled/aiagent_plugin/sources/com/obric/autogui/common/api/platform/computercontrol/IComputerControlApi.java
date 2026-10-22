package com.obric.autogui.common.api.platform.computercontrol;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.view.Surface;
import android.view.View;
import android.view.accessibility.AccessibilityWindowInfo;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: IComputerControlApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IComputerControlApi {

    /* JADX INFO: compiled from: IComputerControlApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object requestSession$default(IComputerControlApi r2, Context r3, CCSessionConfig r4, CCLifecycleListener r5, d r6, int r7, Object r8) {
            IComputerControlApi r9 = (IComputerControlApi) ZeusTransformUtils.wrapperContextForParams(r2, IComputerControlApi.class, "com.obric.aiagent.plugin");
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            CCLifecycleListener r11 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r5, CCLifecycleListener.class, "com.obric.aiagent.plugin");
            d<? super CCSessionRequestResult> r12 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L8;
            r11 = null;
        L8:
            return r9.requestSession(r10, r4, r11, r12);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestSession");
        }

        public static /* synthetic */ CCActionResult inputText$default(IComputerControlApi r2, CCSessionAccessor r3, String r4, boolean r5, boolean r6, int r7, Object r8) {
            IComputerControlApi r9 = (IComputerControlApi) ZeusTransformUtils.wrapperContextForParams(r2, IComputerControlApi.class, "com.obric.aiagent.plugin");
            CCSessionAccessor r10 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L13;
            if ((r7 & 4) == 0) goto L8;
            r5 = false;
        L8:
            if ((r7 & 8) == 0) goto L11;
            r6 = true;
        L11:
            return r9.inputText(r10, r4, r5, r6);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: inputText");
        }

        public static /* synthetic */ CCActionResult sendKeyEvent$default(IComputerControlApi r8, CCSessionAccessor r9, int r10, int r11, long r12, int r14, Object r15) {
            IComputerControlApi r2 = (IComputerControlApi) ZeusTransformUtils.wrapperContextForParams(r8, IComputerControlApi.class, "com.obric.aiagent.plugin");
            CCSessionAccessor r3 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r9, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L10;
            if ((r14 & 8) == 0) goto L8;
            r12 = System.nanoTime();
        L8:
            return r2.sendKeyEvent(r3, r10, r11, r12);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendKeyEvent");
        }

        public static /* synthetic */ Object dumpViewHierarchy$default(IComputerControlApi r2, CCSessionAccessor r3, boolean r4, d r5, int r6, Object r7) {
            IComputerControlApi r8 = (IComputerControlApi) ZeusTransformUtils.wrapperContextForParams(r2, IComputerControlApi.class, "com.obric.aiagent.plugin");
            CCSessionAccessor r9 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r10 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = true;
        L8:
            return r8.dumpViewHierarchy(r9, r4, r10);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dumpViewHierarchy");
        }
    }

    CCActionResult bindMirrorView(CCSessionAccessor r1, View r2);

    CCActionResult clearLifecycleListener(CCSessionAccessor r1);

    CCActionResult close(CCSessionAccessor r1);

    CCDataResult<View> createMirrorView(Context r1);

    Object dumpViewHierarchy(CCSessionAccessor r1, boolean r2, d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r3);

    CCDataResult<List<AccessibilityWindowInfo>> getAccessibilityWindows(CCSessionAccessor r1);

    CCDataResult<Integer> getVersion();

    CCActionResult handOverApplications(CCSessionAccessor r1);

    CCActionResult inputText(CCSessionAccessor r1, String r2, boolean r3, boolean r4);

    boolean isSupported(Context r1);

    CCActionResult key(CCSessionAccessor r1, int r2);

    CCActionResult launchApplication(CCSessionAccessor r1, String r2);

    CCActionResult launchApplicationAccessConsent(Context r1, IntentSender r2);

    CCActionResult longPress(CCSessionAccessor r1, int r2, int r3);

    CCActionResult longPress(CCSessionAccessor r1, int r2, int r3, int r4);

    CCActionResult notifyBlocked(CCSessionAccessor r1);

    CCActionResult performAction(CCSessionAccessor r1, int r2);

    CCDataResult<CCApplicationAccessResult> requestApplicationAccess(CCSessionAccessor r1, String r2);

    Object requestSession(Context r1, CCSessionConfig r2, CCLifecycleListener r3, d<? super CCSessionRequestResult> r4);

    CCActionResult requestUnblock(CCSessionAccessor r1);

    ScreenshotResult screenshot(CCSessionAccessor r1, ScreenshotConfig r2);

    CCActionResult sendKeyEvent(CCSessionAccessor r1, int r2, int r3, long r4);

    CCActionResult sendTouchEvent(CCSessionAccessor r1, CCTouchEvent r2);

    CCActionResult setLifecycleListener(CCSessionAccessor r1, CCLifecycleListener r2);

    CCActionResult setMirrorViewCornerRadius(View r1, int r2);

    CCActionResult setMirrorViewInteractive(View r1, boolean r2);

    CCActionResult setStabilityListener(CCSessionAccessor r1, CCStabilityListener r2);

    CCActionResult setSurface(CCSessionAccessor r1, Surface r2);

    CCActionResult setTouchListener(CCSessionAccessor r1, CCTouchListener r2);

    CCActionResult startActivity(CCSessionAccessor r1, Context r2, Intent r3);

    CCActionResult swipe(CCSessionAccessor r1, int r2, int r3, int r4, int r5);

    CCActionResult swipe(CCSessionAccessor r1, int r2, int r3, int r4, int r5, int r6);

    CCActionResult swipeWithDuration(CCSessionAccessor r1, int r2, int r3, int r4, int r5, long r6);

    CCActionResult swipeWithDuration(CCSessionAccessor r1, int r2, int r3, int r4, int r5, long r6, int r8);

    CCActionResult tap(CCSessionAccessor r1, int r2, int r3);

    CCActionResult tap(CCSessionAccessor r1, int r2, int r3, int r4);

    CCActionResult tapWithInterval(CCSessionAccessor r1, int r2, int r3, long r4);

    CCActionResult tapWithInterval(CCSessionAccessor r1, int r2, int r3, long r4, int r6);

    CCActionResult tryToMute(CCSessionAccessor r1, boolean r2);

    CCActionResult unbindMirrorView(View r1);
}
