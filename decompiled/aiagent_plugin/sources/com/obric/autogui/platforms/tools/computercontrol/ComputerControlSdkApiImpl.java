package com.obric.autogui.platforms.tools.computercontrol;

import android.app.Activity;
import android.app.TaskInfo;
import android.app.assist.AssistStructure;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.hardware.display.VirtualDisplayConfig;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.accessibility.AccessibilityWindowInfo;
import com.android.extensions.computercontrol.AssistantComputerControlExtensions;
import com.android.extensions.computercontrol.AssistantComputerControlSession;
import com.android.extensions.computercontrol.AssistantScreenshotResult;
import com.android.extensions.computercontrol.ComputerControlExtensions;
import com.android.extensions.computercontrol.ComputerControlSession;
import com.android.extensions.computercontrol.input.KeyEvent;
import com.android.extensions.computercontrol.input.TouchEvent;
import com.android.extensions.computercontrol.view.AssistantMirrorView;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.computercontrol.CCActionFailureReason;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessResult;
import com.obric.autogui.common.api.platform.computercontrol.CCApplicationAccessState;
import com.obric.autogui.common.api.platform.computercontrol.CCDataResult;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionConfig;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionFailureReason;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionRequestResult;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionState;
import com.obric.autogui.common.api.platform.computercontrol.CCStabilityListener;
import com.obric.autogui.common.api.platform.computercontrol.CCTouchEvent;
import com.obric.autogui.common.api.platform.computercontrol.CCTouchListener;
import com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi;
import com.obric.autogui.common.api.platform.display.capture.BitmapScreenshot;
import com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.e;
import com.obric.autogui.platforms.tools.internal.a;
import com.obric.autogui.platforms.tools.platstrategy.ComputerControlApplicationAccessActivity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.f.c;
import d.h.b.h;
import d.h.b.o;
import d.s;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: ComputerControlSdkApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ComputerControlSdkApiImpl implements IComputerControlApi {
    private static final String ACCESS_LOG_TAG = "CCAppAccess";
    private static final String APPLICATION_ACCESS_ACTION = "android.companion.virtual.computercontrol.action.REQUEST_ACCESS";
    private static final ComponentName APPLICATION_ACCESS_COMPONENT = null;
    private static final Companion Companion = null;
    private static final Executor DIRECT_EXECUTOR = null;
    private static final String TAG = "ComputerControlSdkApiImpl";
    private final ComputerControlViewHierarchyDumpAsync viewHierarchyDump;

    /* JADX INFO: compiled from: ComputerControlSdkApiImpl.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.computercontrol.ComputerControlSdkApiImpl$dumpViewHierarchy$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComputerControlSdkApiImpl.kt */
    @f(b = "ComputerControlSdkApiImpl.kt", c = {596}, d = "dumpViewHierarchy", e = "com.obric.autogui.platforms.tools.computercontrol.ComputerControlSdkApiImpl")
    static final class AnonymousClass1 extends d {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ComputerControlSdkApiImpl this$0;

        AnonymousClass1(ComputerControlSdkApiImpl r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.dumpViewHierarchy(null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.computercontrol.ComputerControlSdkApiImpl$requestSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ComputerControlSdkApiImpl.kt */
    @f(b = "ComputerControlSdkApiImpl.kt", c = {1287}, d = "requestSession", e = "com.obric.autogui.platforms.tools.computercontrol.ComputerControlSdkApiImpl")
    static final class C11601 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ComputerControlSdkApiImpl this$0;

        C11601(ComputerControlSdkApiImpl r3, d.c.d<? super C11601> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.requestSession(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$6M9XjRKU2VT4p9d-vkZzZpKkAf4, reason: not valid java name */
    public static /* synthetic */ x m852lambda$6M9XjRKU2VT4p9dvkZzZpKkAf4(AssistantMirrorView r0, AssistantComputerControlSession r1) {
        return bindMirrorView$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8KFwboYepAT7a-cX0aFIoFwFb_s, reason: not valid java name */
    public static /* synthetic */ x m853lambda$8KFwboYepAT7acX0aFIoFwFb_s(ComputerControlSdkApiImpl r0, CCTouchEvent r1, AssistantComputerControlSession r2) {
        return sendTouchEvent$lambda$14(r0, r1, r2);
    }

    public static /* synthetic */ List lambda$ArviGDl_MSQvo0XzSnYsGp_Q2FI(AssistantComputerControlSession r0) {
        return getAccessibilityWindows$lambda$28(r0);
    }

    public static /* synthetic */ x lambda$CBaxzQ04EC5t4trQ9GXEkHiNx04(AssistantComputerControlSession r0) {
        return cleanupSessionCallbacks$lambda$34(r0);
    }

    public static /* synthetic */ x lambda$DqfbDujJqHXqoGdr1FCffD0dFuo(ComputerControlSdkApiImpl r0, int r1, int r2, long r3, AssistantComputerControlSession r5) {
        return sendKeyEvent$lambda$19(r0, r1, r2, r3, r5);
    }

    public static /* synthetic */ x lambda$I1BTbdAhEa6MYQSMc3hnpDZ9BwQ(int r0, int r1, long r2, int r4, AssistantComputerControlSession r5) {
        return tapWithInterval$lambda$7(r0, r1, r2, r4, r5);
    }

    public static /* synthetic */ x lambda$L3ERtSLOTvHlkHumrfW4nYtoFBU(CCLifecycleListener r0, ComputerControlSdkApiImpl r1, StandardCCSessionAccessor r2, AssistantComputerControlSession r3) {
        return setLifecycleListener$lambda$27(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$LtFM_9HeZFXSL51txduikp6GxL8(String r0, AssistantComputerControlSession r1) {
        return launchApplication$lambda$23(r0, r1);
    }

    public static /* synthetic */ x lambda$NH6xsLVhFcZCTfhYS5SyTlrAep4(int r0, AssistantComputerControlSession r1) {
        return performAction$lambda$18(r0, r1);
    }

    public static /* synthetic */ x lambda$OkK0vWgH2XXLJVqw9nYEZqPUVYk(ComputerControlSdkApiImpl r0, AssistantComputerControlSession r1, StandardCCSessionAccessor r2) {
        return cleanupSessionCallbacks$lambda$35(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$PPuWPeAUW5b_9QHwFzm3iI_UrsM(CCStabilityListener r0, StandardCCSessionAccessor r1, AssistantComputerControlSession r2) {
        return setStabilityListener$lambda$29(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$QQZ_NB6kXFD4j8UTPgcGCw0vkpI(Runnable r0) {
        DIRECT_EXECUTOR$lambda$37(r0);
    }

    /* JADX INFO: renamed from: lambda$VxATe940WL7iOB6qngBujU70g-4, reason: not valid java name */
    public static /* synthetic */ x m854lambda$VxATe940WL7iOB6qngBujU70g4(int r0, int r1, AssistantComputerControlSession r2) {
        return longPress$lambda$12(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$WLZKbQ1PHIJqyUeQAY6BsfkGOZk(AssistantComputerControlSession r0) {
        return requestUnblock$lambda$26(r0);
    }

    public static /* synthetic */ x lambda$Xp7yhJZy4APYnx1am5tpbL9lZfI(int r0, int r1, int r2, int r3, long r4, int r6, AssistantComputerControlSession r7) {
        return swipeWithDuration$lambda$11(r0, r1, r2, r3, r4, r6, r7);
    }

    public static /* synthetic */ CCApplicationAccessResult lambda$YCkQf_i9bSsC7mgUEA5I2aPQM14(String r0, ComputerControlSdkApiImpl r1, AssistantComputerControlSession r2) {
        return requestApplicationAccess$lambda$22(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$ZH9xP375dK3fZ9oooZ2Zy_mIxmA(int r0, int r1, int r2, AssistantComputerControlSession r3) {
        return longPress$lambda$13(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$ZfzFRBbK4iEjBhLu6Q6_BL8tmdA(int r0, int r1, long r2, AssistantComputerControlSession r4) {
        return tapWithInterval$lambda$6(r0, r1, r2, r4);
    }

    public static /* synthetic */ x lambda$_XKvbfIv6wDR1U3xH6WvzLVM0ms(int r0, int r1, AssistantComputerControlSession r2) {
        return tap$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$chNGDPd9EN8wgioSzxFvhcP7dWE(AssistantComputerControlSession r0) {
        return cleanupSessionCallbacks$lambda$33(r0);
    }

    public static /* synthetic */ x lambda$eoCsuIQ_OUniuENKCSB2fhpHCaQ(CCTouchListener r0, ComputerControlSdkApiImpl r1, AssistantComputerControlSession r2) {
        return setTouchListener$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$f2mHAA3OGxxvWDLH93_Z7RhQLBM(int r0, int r1, int r2, int r3, int r4, AssistantComputerControlSession r5) {
        return swipe$lambda$9(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$jNnNeeIkSt67qTpBsl7NuoFXQvI(int r0, int r1, int r2, int r3, AssistantComputerControlSession r4) {
        return swipe$lambda$8(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$mfCBLUYTe4oCe813AIFua-sadv4, reason: not valid java name */
    public static /* synthetic */ x m855lambda$mfCBLUYTe4oCe813AIFuasadv4(AssistantComputerControlSession r0) {
        return notifyBlocked$lambda$25(r0);
    }

    /* JADX INFO: renamed from: lambda$nVRygv0Udc0kPOKtCny2CL-ZySM, reason: not valid java name */
    public static /* synthetic */ x m856lambda$nVRygv0Udc0kPOKtCny2CLZySM(AssistantComputerControlSession r0) {
        return handOverApplications$lambda$24(r0);
    }

    /* JADX INFO: renamed from: lambda$nqdhgcb1-akUvfN1NpndwhEXNBI, reason: not valid java name */
    public static /* synthetic */ x m857lambda$nqdhgcb1akUvfN1NpndwhEXNBI(int r0, int r1, int r2, int r3, long r4, AssistantComputerControlSession r6) {
        return swipeWithDuration$lambda$10(r0, r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ x lambda$rkpjjuXlTVfUO47MYSBc1XLtHGk(AssistantComputerControlSession r0) {
        return cleanupSessionCallbacks$lambda$36(r0);
    }

    public static /* synthetic */ x lambda$u75HV4PFlcoFaQsXmkzpGH0BUoI(String r0, boolean r1, boolean r2, AssistantComputerControlSession r3) {
        return inputText$lambda$17(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$wHFfPLTM0-cmiLzslTuml1ktZKo, reason: not valid java name */
    public static /* synthetic */ x m858lambda$wHFfPLTM0cmiLzslTuml1ktZKo(int r0, int r1, int r2, AssistantComputerControlSession r3) {
        return tap$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$wdn43jy0TR4TyBWSOFIHebaZUJg(boolean r0, AssistantComputerControlSession r1) {
        return tryToMute$lambda$21(r0, r1);
    }

    public static /* synthetic */ x lambda$yp5T27oK3wpENO0VC8MaJGc1w7U(Context r0, Intent r1, AssistantComputerControlSession r2) {
        return startActivity$lambda$20(r0, r1, r2);
    }

    public ComputerControlSdkApiImpl() {
        this.viewHierarchyDump = new ComputerControlViewHierarchyDumpAsync();
    }

    public static final /* synthetic */ StandardCCSessionAccessor access$buildAccessorOrNull(ComputerControlSdkApiImpl r2, Context r3, AssistantComputerControlSession r4) {
        return r2.buildAccessorOrNull((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ComputerControlSession.Params access$buildParams(ComputerControlSdkApiImpl r2, Context r3, CCSessionConfig r4) {
        return r2.buildParams((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ void access$cleanupSessionCallbacks(ComputerControlSdkApiImpl r0, StandardCCSessionAccessor r1) {
        r0.cleanupSessionCallbacks(r1);
    }

    public static final /* synthetic */ CCActionResult access$closeSafely(ComputerControlSdkApiImpl r2, AssistantComputerControlSession r3) {
        return r2.closeSafely((AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$disposeUnclaimedSession(ComputerControlSdkApiImpl r0, StandardCCSessionAccessor r1) {
        r0.disposeUnclaimedSession(r1);
    }

    public static final /* synthetic */ Executor access$getDIRECT_EXECUTOR$cp() {
        return DIRECT_EXECUTOR;
    }

    public static final /* synthetic */ void access$installApplicationAccessCallback(ComputerControlSdkApiImpl r2, AssistantComputerControlSession r3, StandardCCSessionAccessor r4, CCLifecycleListener r5) {
        r2.installApplicationAccessCallback((AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin"), r4, (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r5, CCLifecycleListener.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$installLifecycleCallback(ComputerControlSdkApiImpl r2, AssistantComputerControlSession r3, StandardCCSessionAccessor r4, CCLifecycleListener r5) {
        r2.installLifecycleCallback((AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin"), r4, (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r5, CCLifecycleListener.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$notifyApplicationAccessPending(ComputerControlSdkApiImpl r2, CCLifecycleListener r3, CCSessionAccessor r4, IntentSender r5) {
        r2.notifyApplicationAccessPending((CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r3, CCLifecycleListener.class, "com.obric.aiagent.plugin"), (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin"), r5);
    }

    public static final /* synthetic */ void access$notifyLifecycle(ComputerControlSdkApiImpl r2, CCLifecycleListener r3, CCSessionAccessor r4, CCSessionState r5) {
        r2.notifyLifecycle((CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r3, CCLifecycleListener.class, "com.obric.aiagent.plugin"), (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin"), r5);
    }

    public static final /* synthetic */ boolean access$resumeRequest(ComputerControlSdkApiImpl r2, AtomicBoolean r3, n r4, CCSessionRequestResult r5) {
        return r2.resumeRequest(r3, (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin"), r5);
    }

    public static final /* synthetic */ VirtualDisplay access$setupVirtualDisplay(ComputerControlSdkApiImpl r2, Context r3, CCSessionConfig r4, int r5) {
        return r2.setupVirtualDisplay((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public static final /* synthetic */ boolean access$shouldCreateSurfaceMirrorDisplay(ComputerControlSdkApiImpl r0) {
        return r0.shouldCreateSurfaceMirrorDisplay();
    }

    public static final /* synthetic */ CCApplicationAccessResult access$toApplicationAccessResult(ComputerControlSdkApiImpl r0, int r1) {
        return r0.toApplicationAccessResult(r1);
    }

    public static final /* synthetic */ CCTouchEvent access$toCcTouchEvent(ComputerControlSdkApiImpl r2, TouchEvent r3) {
        return r2.toCcTouchEvent((TouchEvent) ZeusTransformUtils.wrapperContextForParams(r3, TouchEvent.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<Integer> getVersion() {
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Success(Integer.valueOf(ComputerControlExtensions.getVersion())), CCDataResult.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "getVersion failed.", th);
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.ApiError, th), CCDataResult.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public boolean isSupported(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L9
        ComputerControlSdkApiImpl r5 = (ComputerControlSdkApiImpl) ZeusTransformUtils.preCheckCast(this, ComputerControlSdkApiImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (AssistantComputerControlExtensions.getInstance(r7) == null) goto L6;
        boolean r8 = true;
    L7:
        Loog.INSTANCE.i(TAG, "isSupported: " + r8);     // Catch: Throwable -> L9
        Object r9 = d.n.f(Boolean.valueOf(r8));     // Catch: Throwable -> L9
    L11:
        Throwable r10 = d.n.c(r9);
        if (r10 == null) goto L15;
        Loog.INSTANCE.e(TAG, "isSupported check failed.", r10);
    L15:
        if (d.n.b(r9) == false) goto L18;
        r9 = false;
    L18:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        r8 = false;
    L9:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L11
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public Object requestSession(Context r23, final CCSessionConfig r24, CCLifecycleListener r25, d.c.d<? super CCSessionRequestResult> r26) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        final CCLifecycleListener r5 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r25, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C11601.class) == false) goto L7;
        C11601 r2 = (C11601) ZeusTransformUtils.preCheckCast(r1, C11601.class, "com.obric.aiagent.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        C11601 r12 = r2;
        Object r3 = r12.result;
        Object r13 = b.a();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        AtomicReference r0 = (AtomicReference) ZeusTransformUtils.preCheckCast(r12.L$6, AtomicReference.class, "com.obric.aiagent.plugin");
        AtomicReference r7 = (AtomicReference) ZeusTransformUtils.preCheckCast(r12.L$5, AtomicReference.class, "com.obric.aiagent.plugin");
        AtomicBoolean r8 = (AtomicBoolean) ZeusTransformUtils.preCheckCast(r12.L$4, AtomicBoolean.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r9 = (CCLifecycleListener) ZeusTransformUtils.preCheckCast(r12.L$3, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        CCSessionConfig r10 = (CCSessionConfig) ZeusTransformUtils.preCheckCast(r12.L$2, CCSessionConfig.class, "com.obric.aiagent.plugin");
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(r12.L$1, Context.class, "com.obric.aiagent.plugin");
        ComputerControlSdkApiImpl r14 = (ComputerControlSdkApiImpl) ZeusTransformUtils.preCheckCast(r12.L$0, ComputerControlSdkApiImpl.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L38:
        CCSessionRequestResult r15 = (CCSessionRequestResult) ZeusTransformUtils.preCheckCast(r3, CCSessionRequestResult.class, "com.obric.aiagent.plugin");
        r7.set(null);
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        final AtomicBoolean r16 = new AtomicBoolean(false);
        final AtomicReference r17 = new AtomicReference(null);
        final AtomicReference r18 = new AtomicReference(null);
        r12.L$0 = this;
        r12.L$1 = r6;
        r12.L$2 = r24;
        r12.L$3 = r5;
        r12.L$4 = r16;
        r12.L$5 = r17;
        r12.L$6 = r18;
        r12.label = 1;
        kotlinx.coroutines.o r19 = new kotlinx.coroutines.o(b.a((d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r19.e();
        final n r20 = (n) ZeusTransformUtils.preCheckCast(r19, n.class, "com.obric.aiagent.plugin");
        access$notifyLifecycle(this, r5, null, (CCSessionState) ZeusTransformUtils.preCheckCast(CCSessionState.Requesting.INSTANCE, CCSessionState.class, "com.obric.aiagent.plugin"));
        r20.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new ComputerControlSdkApiImpl$requestSession$result$1$1(r16, r17, this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        AssistantComputerControlExtensions r21 = AssistantComputerControlExtensions.getInstance(r6);     // Catch: Throwable -> L27
        if (r21 == null) goto L40;
        Object r27 = r13;
        C11601 r110 = r12;
        kotlinx.coroutines.o r111 = r19;
        AtomicReference r112 = r17;
        r21.requestSession(access$buildParams(this, r6, r24), access$getDIRECT_EXECUTOR$cp(), (AssistantComputerControlSession.Callback) ZeusTransformUtils.preCheckCast(new ComputerControlSdkApiImpl$requestSession$result$1$2(r18, r16, this, r5, r6, r20, r24, r17), AssistantComputerControlSession.Callback.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
    L31:
        r3 = r111.h();
        if (r3 != b.a()) goto L34;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r110, d.c.d.class, "com.obric.aiagent.plugin"));
    L34:
        Object r22 = r27;
        if (r3 != r22) goto L37;
        return r22;
    L37:
        r7 = r112;
    L25:
        th = th;
    L29:
        Throwable r28 = th;
    L30:
        Loog.INSTANCE.e(TAG, "requestSession failed.", r28);
        access$resumeRequest(this, r16, r20, (CCSessionRequestResult) ZeusTransformUtils.preCheckCast(new CCSessionRequestResult.Failed(CCSessionFailureReason.ApiError, null, r28, 2, null), CCSessionRequestResult.class, "com.obric.aiagent.plugin"));
        goto L31
    L40:
        access$resumeRequest(this, r16, r20, (CCSessionRequestResult) ZeusTransformUtils.preCheckCast(new CCSessionRequestResult.Failed(CCSessionFailureReason.Unsupported, null, null, 6, null), CCSessionRequestResult.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        r111 = r19;
        r112 = r17;
        r110 = r12;
        r27 = r13;
    L19:
        th = move-exception;
        r28 = th;
        r20 = r20;
        r111 = r19;
        r112 = r17;
        r110 = r12;
        r27 = r13;
    L27:
        th = th;
        r111 = r19;
        r112 = r17;
        r110 = r12;
        r27 = r13;
    L7:
        r2 = new C11601(this, r1);
        goto L8
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setSurface(CCSessionAccessor r4, Surface r5) {
        CCSessionAccessor r3 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r3, SensitiveType.SESSION);
        if (ZeusTransformUtils.instanceOf(r3, StandardCCSessionAccessor.class) == false) goto L5;
        StandardCCSessionAccessor r6 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r3, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L7:
        if (r6 != null) goto L11;
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidSession, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L11:
        if (r6.isClosed() == false) goto L15;
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.SessionClosed, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L15:
        return r6.setMirrorSurface(r5);
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<View> createMirrorView(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Success(new AssistantMirrorView(r3)), CCDataResult.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "createMirrorView failed.", th);
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.ApiError, th), CCDataResult.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult bindMirrorView(CCSessionAccessor r4, View r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        o.e(r5, "mirrorView");
        if (ZeusTransformUtils.instanceOf(r5, AssistantMirrorView.class) == false) goto L5;
        final AssistantMirrorView r7 = (AssistantMirrorView) ZeusTransformUtils.preCheckCast(r5, AssistantMirrorView.class, "com.obric.aiagent.plugin");
    L6:
        if (r7 != null) goto L10;
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidArgument, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L10:
        return withRawSession(r6, new $$Lambda$ComputerControlSdkApiImpl$6M9XjRKU2VT4p9dvkZzZpKkAf4(r7));
    L5:
        r7 = null;
        goto L6
    }

    private static final x bindMirrorView$lambda$3(AssistantMirrorView r2, AssistantComputerControlSession r3) {
        AssistantMirrorView r4 = (AssistantMirrorView) ZeusTransformUtils.wrapperContextForParams(r2, AssistantMirrorView.class, "com.obric.aiagent.plugin");
        AssistantComputerControlSession r5 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r5, "raw");
        r4.setAssistantComputerControlSession(r5);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult unbindMirrorView(View r4) {
        o.e(r4, "mirrorView");
        if (ZeusTransformUtils.instanceOf(r4, AssistantMirrorView.class) == false) goto L5;
        AssistantMirrorView r3 = (AssistantMirrorView) ZeusTransformUtils.preCheckCast(r4, AssistantMirrorView.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 == null) goto L8;
        r3.setAssistantComputerControlSession(null);     // Catch: Throwable -> L11
        return (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");
    L11:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "unbindMirrorView failed.", th);
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.ApiError, th), CCActionResult.class, "com.obric.aiagent.plugin");
    L8:
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidArgument, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setMirrorViewInteractive(View r3, boolean r4) {
        o.e(r3, "mirrorView");
        if (ZeusTransformUtils.instanceOf(r3, AssistantMirrorView.class) == false) goto L5;
        AssistantMirrorView r2 = (AssistantMirrorView) ZeusTransformUtils.preCheckCast(r3, AssistantMirrorView.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L8;
        r2.setInteractive(r4);     // Catch: Throwable -> L11
        return (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");
    L11:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "setMirrorViewInteractive failed.", th);
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.ApiError, th), CCActionResult.class, "com.obric.aiagent.plugin");
    L8:
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidArgument, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setMirrorViewCornerRadius(View r3, int r4) {
        o.e(r3, "mirrorView");
        if (ZeusTransformUtils.instanceOf(r3, AssistantMirrorView.class) == false) goto L5;
        AssistantMirrorView r2 = (AssistantMirrorView) ZeusTransformUtils.preCheckCast(r3, AssistantMirrorView.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L8;
        r2.setCornerRadius(r4);     // Catch: Throwable -> L11
        return (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");
    L11:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "setMirrorViewCornerRadius failed.", th);
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.ApiError, th), CCActionResult.class, "com.obric.aiagent.plugin");
    L8:
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidArgument, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L5:
        r2 = null;
        goto L6
    }

    private static final x tap$lambda$4(int r2, int r3, AssistantComputerControlSession r4) {
        AssistantComputerControlSession r5 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r5, "it");
        r5.tap(r2, r3);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tap(CCSessionAccessor r3, final int r4, final int r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        return withRawSession(r6, new $$Lambda$ComputerControlSdkApiImpl$_XKvbfIv6wDR1U3xH6WvzLVM0ms(r4, r5));
    }

    private static final x tap$lambda$5(int r2, int r3, int r4, AssistantComputerControlSession r5) {
        AssistantComputerControlSession r6 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r5, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r6, "it");
        r6.tap(r2, r3, r4);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tap(CCSessionAccessor r3, final int r4, final int r5, final int r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, SensitiveType.SESSION);
        return withAssistantSession(r7, new $$Lambda$ComputerControlSdkApiImpl$wHFfPLTM0cmiLzslTuml1ktZKo(r4, r5, r6));
    }

    private static final x tapWithInterval$lambda$6(int r2, int r3, long r4, AssistantComputerControlSession r6) {
        AssistantComputerControlSession r7 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r6, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r7, "it");
        r7.tapWithInterval(r2, r3, r4);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tapWithInterval(CCSessionAccessor r3, final int r4, final int r5, final long r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, SensitiveType.SESSION);
        return withAssistantSession(r7, new $$Lambda$ComputerControlSdkApiImpl$ZfzFRBbK4iEjBhLu6Q6_BL8tmdA(r4, r5, r6));
    }

    private static final x tapWithInterval$lambda$7(int r6, int r7, long r8, int r10, AssistantComputerControlSession r11) {
        AssistantComputerControlSession r0 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r11, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r0, "it");
        r0.tapWithInterval(r6, r7, r8, r10);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tapWithInterval(CCSessionAccessor r8, final int r9, final int r10, final long r11, final int r13) {
        CCSessionAccessor r12 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r12, SensitiveType.SESSION);
        return withAssistantSession(r12, new $$Lambda$ComputerControlSdkApiImpl$I1BTbdAhEa6MYQSMc3hnpDZ9BwQ(r9, r10, r11, r13));
    }

    private static final x swipe$lambda$8(int r2, int r3, int r4, int r5, AssistantComputerControlSession r6) {
        AssistantComputerControlSession r7 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r6, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r7, "it");
        r7.swipe(r2, r3, r4, r5);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipe(CCSessionAccessor r3, final int r4, final int r5, final int r6, final int r7) {
        CCSessionAccessor r8 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r8, SensitiveType.SESSION);
        return withRawSession(r8, new $$Lambda$ComputerControlSdkApiImpl$jNnNeeIkSt67qTpBsl7NuoFXQvI(r4, r5, r6, r7));
    }

    private static final x swipe$lambda$9(int r6, int r7, int r8, int r9, int r10, AssistantComputerControlSession r11) {
        AssistantComputerControlSession r0 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r11, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r0, "it");
        r0.swipe(r6, r7, r8, r9, r10);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipe(CCSessionAccessor r8, final int r9, final int r10, final int r11, final int r12, final int r13) {
        CCSessionAccessor r14 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r14, SensitiveType.SESSION);
        return withAssistantSession(r14, new $$Lambda$ComputerControlSdkApiImpl$f2mHAA3OGxxvWDLH93_Z7RhQLBM(r9, r10, r11, r12, r13));
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipeWithDuration(CCSessionAccessor r9, final int r10, final int r11, final int r12, final int r13, final long r14) {
        CCSessionAccessor r15 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r9, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r15, SensitiveType.SESSION);
        return withAssistantSession(r15, new $$Lambda$ComputerControlSdkApiImpl$nqdhgcb1akUvfN1NpndwhEXNBI(r10, r11, r12, r13, r14));
    }

    private static final x swipeWithDuration$lambda$10(int r7, int r8, int r9, int r10, long r11, AssistantComputerControlSession r13) {
        AssistantComputerControlSession r0 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r13, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r0, "it");
        r0.swipeWithDuration(r7, r8, r9, r10, r11);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult swipeWithDuration(CCSessionAccessor r11, final int r12, final int r13, final int r14, final int r15, final long r16, final int r18) {
        CCSessionAccessor r0 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r11, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r0, SensitiveType.SESSION);
        return withAssistantSession(r0, new $$Lambda$ComputerControlSdkApiImpl$Xp7yhJZy4APYnx1am5tpbL9lZfI(r12, r13, r14, r15, r16, r18));
    }

    private static final x swipeWithDuration$lambda$11(int r8, int r9, int r10, int r11, long r12, int r14, AssistantComputerControlSession r15) {
        AssistantComputerControlSession r0 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r15, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r0, "it");
        r0.swipeWithDuration(r8, r9, r10, r11, r12, r14);
        return x.f38692a;
    }

    private static final x longPress$lambda$12(int r2, int r3, AssistantComputerControlSession r4) {
        AssistantComputerControlSession r5 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r5, "it");
        r5.longPress(r2, r3);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult longPress(CCSessionAccessor r3, final int r4, final int r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        return withRawSession(r6, new $$Lambda$ComputerControlSdkApiImpl$VxATe940WL7iOB6qngBujU70g4(r4, r5));
    }

    private static final x longPress$lambda$13(int r2, int r3, int r4, AssistantComputerControlSession r5) {
        AssistantComputerControlSession r6 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r5, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r6, "it");
        r6.longPress(r2, r3, r4);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult longPress(CCSessionAccessor r3, final int r4, final int r5, final int r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, SensitiveType.SESSION);
        return withAssistantSession(r7, new $$Lambda$ComputerControlSdkApiImpl$ZH9xP375dK3fZ9oooZ2Zy_mIxmA(r4, r5, r6));
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult sendTouchEvent(CCSessionAccessor r3, final CCTouchEvent r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        o.e(r4, "event");
        return withAssistantSession(r5, new $$Lambda$ComputerControlSdkApiImpl$8KFwboYepAT7acX0aFIoFwFb_s(this, r4));
    }

    private static final x sendTouchEvent$lambda$14(ComputerControlSdkApiImpl r2, CCTouchEvent r3, AssistantComputerControlSession r4) {
        AssistantComputerControlSession r5 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r5, "raw");
        r5.sendTouchEvent(r2.toSdkTouchEvent(r3));
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setTouchListener(CCSessionAccessor r3, CCTouchListener r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        final CCTouchListener r6 = (CCTouchListener) ZeusTransformUtils.wrapperContextForParams(r4, CCTouchListener.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return withAssistantSession(r5, new $$Lambda$ComputerControlSdkApiImpl$eoCsuIQ_OUniuENKCSB2fhpHCaQ(r6, this));
    }

    private static final x setTouchListener$lambda$16(CCTouchListener r2, final ComputerControlSdkApiImpl r3, AssistantComputerControlSession r4) {
        final CCTouchListener r5 = (CCTouchListener) ZeusTransformUtils.wrapperContextForParams(r2, CCTouchListener.class, "com.obric.aiagent.plugin");
        AssistantComputerControlSession r6 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r6, "raw");
        if (r5 == null) goto L5;
        AssistantComputerControlSession.TouchListener r0 = new ComputerControlSdkApiImpl$setTouchListener$1$1$1(r5, r3);
    L6:
        r6.setTouchListener((AssistantComputerControlSession.TouchListener) ZeusTransformUtils.preCheckCast(r0, AssistantComputerControlSession.TouchListener.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L5:
        r0 = null;
        goto L6
    }

    private static final x inputText$lambda$17(String r2, boolean r3, boolean r4, AssistantComputerControlSession r5) {
        AssistantComputerControlSession r6 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r5, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r6, "it");
        r6.insertText(r2, r3, r4);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult inputText(CCSessionAccessor r3, final String r4, final boolean r5, final boolean r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, SensitiveType.SESSION);
        o.e(r4, "text");
        return withRawSession(r7, new $$Lambda$ComputerControlSdkApiImpl$u75HV4PFlcoFaQsXmkzpGH0BUoI(r4, r5, r6));
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult key(CCSessionAccessor r9, int r10) {
        CCSessionAccessor r11 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r9, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r11, SensitiveType.SESSION);
        if (r10 == 4) goto L5;
        long r6 = System.nanoTime();
        CCActionResult r0 = sendKeyEvent(r11, r10, 0, r6);
        if (ZeusTransformUtils.instanceOf(r0, CCActionResult.Failed.class) == false) goto L10;
        return r0;
    L10:
        return sendKeyEvent(r11, r10, 1, r6);
    L5:
        return performAction(r11, 1);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult performAction(CCSessionAccessor r3, final int r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return withRawSession(r5, new $$Lambda$ComputerControlSdkApiImpl$NH6xsLVhFcZCTfhYS5SyTlrAep4(r4));
    }

    private static final x performAction$lambda$18(int r2, AssistantComputerControlSession r3) {
        AssistantComputerControlSession r4 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r4, "raw");
        r4.performAction(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult sendKeyEvent(CCSessionAccessor r8, final int r9, final int r10, final long r11) {
        CCSessionAccessor r12 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r12, SensitiveType.SESSION);
        return withAssistantSession(r12, new $$Lambda$ComputerControlSdkApiImpl$DqfbDujJqHXqoGdr1FCffD0dFuo(this, r9, r10, r11));
    }

    private static final x sendKeyEvent$lambda$19(ComputerControlSdkApiImpl r2, int r3, int r4, long r5, AssistantComputerControlSession r7) {
        AssistantComputerControlSession r8 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r7, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r8, "raw");
        r8.sendKeyEvent(r2.buildKeyEvent(r3, r4, r5));
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult startActivity(CCSessionAccessor r5, Context r6, Intent r7) {
        CCSessionAccessor r8 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r5, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, SensitiveType.SESSION);
        o.e(r9, "context");
        o.e(r7, MemorySourceLinkType.INTENT);
        final Intent r0 = new Intent(r7);
        if (ZeusTransformUtils.instanceOf(r9, Activity.class) == false) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L10;
        r0.addFlags(268435456);
    L10:
        Loog.INSTANCE.i(TAG, "startActivity: component=" + r0.getComponent() + ", addedNewTask=" + r10 + ", flags=" + r0.getFlags());
        return withAssistantSession(r8, new $$Lambda$ComputerControlSdkApiImpl$yp5T27oK3wpENO0VC8MaJGc1w7U(r9, r0));
    L5:
        if ((r0.getFlags() & 268435456) != 0) goto L7;
        r10 = true;
        goto L8
    }

    private static final x startActivity$lambda$20(Context r2, Intent r3, AssistantComputerControlSession r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AssistantComputerControlSession r6 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r6, "it");
        r6.startActivity(r5, r3);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult tryToMute(CCSessionAccessor r3, final boolean r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        return withAssistantSession(r5, new $$Lambda$ComputerControlSdkApiImpl$wdn43jy0TR4TyBWSOFIHebaZUJg(r4));
    }

    private static final x tryToMute$lambda$21(boolean r2, AssistantComputerControlSession r3) {
        AssistantComputerControlSession r4 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.tryToMute(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<CCApplicationAccessResult> requestApplicationAccess(CCSessionAccessor r3, final String r4) {
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r5, SensitiveType.SESSION);
        o.e(r4, "packageName");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.InvalidArgument, null, 2, null), CCDataResult.class, "com.obric.aiagent.plugin");
    L7:
        return withAssistantSessionData(r5, new $$Lambda$ComputerControlSdkApiImpl$YCkQf_i9bSsC7mgUEA5I2aPQM14(r4, this));
    }

    private static final CCApplicationAccessResult requestApplicationAccess$lambda$22(String r3, ComputerControlSdkApiImpl r4, AssistantComputerControlSession r5) {
        AssistantComputerControlSession r6 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r5, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r6, "raw");
        int r7 = r6.requestApplicationAccess(r3);
        CCApplicationAccessResult r8 = r4.toApplicationAccessResult(r7);
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=framework_access_result packageName=" + r3 + " state=" + r8.getState() + " rawValue=" + r7);
        return r8;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult launchApplicationAccessConsent(Context r3, IntentSender r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        o.e(r4, "intentSender");
        if (ComputerControlApplicationAccessActivity.Companion.a(r2, r4) == false) goto L6;
        return (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");
    L6:
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.ApiError, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult launchApplication(CCSessionAccessor r4, final String r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        o.e(r5, "packageName");
        Loog.INSTANCE.i(TAG, "launchApplication: packageName=" + r5);
        return withRawSession(r6, new $$Lambda$ComputerControlSdkApiImpl$LtFM_9HeZFXSL51txduikp6GxL8(r5));
    }

    private static final x launchApplication$lambda$23(String r2, AssistantComputerControlSession r3) {
        AssistantComputerControlSession r4 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.launchApplication(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult handOverApplications(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        dismissApplicationAccessTask(r4, "hand_over_applications");
        return withRawSession(r4, $$Lambda$ComputerControlSdkApiImpl$nVRygv0Udc0kPOKtCny2CLZySM.INSTANCE);
    }

    private static final x handOverApplications$lambda$24(AssistantComputerControlSession r2) {
        AssistantComputerControlSession r3 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r2, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        r3.handOverApplications();
        return x.f38692a;
    }

    private static final x notifyBlocked$lambda$25(AssistantComputerControlSession r2) {
        AssistantComputerControlSession r3 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r2, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        r3.notifyBlocked();
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult notifyBlocked(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return withRawSession(r4, $$Lambda$ComputerControlSdkApiImpl$mfCBLUYTe4oCe813AIFuasadv4.INSTANCE);
    }

    private static final x requestUnblock$lambda$26(AssistantComputerControlSession r2) {
        AssistantComputerControlSession r3 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r2, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        r3.requestUnblock();
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult requestUnblock(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return withRawSession(r4, $$Lambda$ComputerControlSdkApiImpl$WLZKbQ1PHIJqyUeQAY6BsfkGOZk.INSTANCE);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setLifecycleListener(CCSessionAccessor r4, CCLifecycleListener r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        final CCLifecycleListener r7 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r5, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        if (ZeusTransformUtils.instanceOf(r6, StandardCCSessionAccessor.class) == false) goto L5;
        final StandardCCSessionAccessor r8 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r6, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L6:
        if (r8 != null) goto L10;
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidSession, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L10:
        return withRawSession((CCSessionAccessor) ZeusTransformUtils.preCheckCast(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin"), new $$Lambda$ComputerControlSdkApiImpl$L3ERtSLOTvHlkHumrfW4nYtoFBU(r7, this, r8));
    L5:
        r8 = null;
        goto L6
    }

    private static final x setLifecycleListener$lambda$27(CCLifecycleListener r2, ComputerControlSdkApiImpl r3, StandardCCSessionAccessor r4, AssistantComputerControlSession r5) {
        CCLifecycleListener r6 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r2, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        AssistantComputerControlSession r7 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r5, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r7, "raw");
        if (r6 != null) goto L5;
        r7.clearLifecycleCallback();
        r3.clearApplicationAccessCallback(r7, r4);
    L7:
        return x.f38692a;
    L5:
        r3.installLifecycleCallback(r7, r4, r6);
        r3.installApplicationAccessCallback(r7, r4, r6);
        goto L7
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult clearLifecycleListener(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return setLifecycleListener(r4, null);
    }

    private static final List getAccessibilityWindows$lambda$28(AssistantComputerControlSession r2) {
        AssistantComputerControlSession r3 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r2, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r3, "raw");
        return r3.getAccessibilityWindows();
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCDataResult<List<AccessibilityWindowInfo>> getAccessibilityWindows(CCSessionAccessor r3) {
        CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.SESSION);
        return withRawSessionData(r4, $$Lambda$ComputerControlSdkApiImpl$ArviGDl_MSQvo0XzSnYsGp_Q2FI.INSTANCE);
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public Object dumpViewHierarchy(CCSessionAccessor r6, boolean r7, d.c.d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r8) {
        CCSessionAccessor r9 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r6, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.Z$0;
        d.o.a(r11);
    L28:
        com.obric.autogui.common.d r5 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        if (r5.g() == false) goto L31;
        AssistStructure r12 = (AssistStructure) ZeusTransformUtils.preCheckCast(r5.a(), AssistStructure.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L45;
        Loog.INSTANCE.e(TAG, "dumpViewHierarchy: dump is null");
        return com.obric.autogui.common.d.f29012a.a("nulled_dump");
    L45:
        com.obric.autogui.common.d.a r13 = com.obric.autogui.common.d.f29012a;     // Catch: Throwable -> L42
        com.obric.autogui.platforms.tools.internal.viewhierarchy.b r1 = com.obric.autogui.platforms.tools.internal.viewhierarchy.b.f30401a;     // Catch: Throwable -> L42
        if (r7 == true) goto L40;
        r4 = false;
    L40:
        return r13.a(r1.a(r12, r4));
    L42:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "dumpViewHierarchy: parse failed.", th);
        return com.obric.autogui.common.d.f29012a.a("parse_failed");
    L31:
        return com.obric.autogui.common.d.f29012a.a((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        if (ZeusTransformUtils.instanceOf(r9, StandardCCSessionAccessor.class) == false) goto L17;
        StandardCCSessionAccessor r14 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r9, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L18:
        if (r14 != null) goto L22;
        return com.obric.autogui.common.d.f29012a.a("invalid_session");
    L22:
        if (r14.isClosed() == true) goto L24;
        ComputerControlViewHierarchyDumpAsync r15 = this.viewHierarchyDump;
        AssistantComputerControlSession r16 = r14.getRawSession$base_release();
        r0.Z$0 = r7;
        r0.label = 1;
        r11 = r15.dumpTopWindow(r16, r0);
        if (r11 != r2) goto L28;
        return r2;
    L24:
        return com.obric.autogui.common.d.f29012a.a("session_closed");
    L17:
        r14 = null;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult setStabilityListener(CCSessionAccessor r4, CCStabilityListener r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        final CCStabilityListener r7 = (CCStabilityListener) ZeusTransformUtils.wrapperContextForParams(r5, CCStabilityListener.class, "com.obric.aiagent.plugin");
        o.e(r6, SensitiveType.SESSION);
        if (ZeusTransformUtils.instanceOf(r6, StandardCCSessionAccessor.class) == false) goto L5;
        final StandardCCSessionAccessor r8 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r6, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L6:
        if (r8 != null) goto L10;
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidSession, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L10:
        return withRawSession((CCSessionAccessor) ZeusTransformUtils.preCheckCast(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin"), new $$Lambda$ComputerControlSdkApiImpl$PPuWPeAUW5b_9QHwFzm3iI_UrsM(r7, r8));
    L5:
        r8 = null;
        goto L6
    }

    private static final x setStabilityListener$lambda$29(CCStabilityListener r2, StandardCCSessionAccessor r3, AssistantComputerControlSession r4) {
        final CCStabilityListener r5 = (CCStabilityListener) ZeusTransformUtils.wrapperContextForParams(r2, CCStabilityListener.class, "com.obric.aiagent.plugin");
        AssistantComputerControlSession r6 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r6, "raw");
        if (r5 != null) goto L5;
        r3.getStabilityListenerRef$base_release().set(null);
        r6.clearStabilityListener();
    L7:
        return x.f38692a;
    L5:
        ComputerControlSession.StabilityListener r0 = new ComputerControlSdkApiImpl$setStabilityListener$1$sdkListener$1(r5);
        r3.getStabilityListenerRef$base_release().set(r0);
        r6.setStabilityListener(DIRECT_EXECUTOR, (ComputerControlSession.StabilityListener) ZeusTransformUtils.preCheckCast(r0, ComputerControlSession.StabilityListener.class, "com.obric.aiagent.plugin"));
        goto L7
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public ScreenshotResult screenshot(CCSessionAccessor r22, ScreenshotConfig r23) {
        CCSessionAccessor r0 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r22, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r0, SensitiveType.SESSION);
        Bitmap r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, StandardCCSessionAccessor.class) == false) goto L5;
        StandardCCSessionAccessor r1 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r0, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L10;
        return new ScreenshotResult(ScreenshotResult.Status.ApiError, null, null, 0, null, null, 62, null);
    L10:
        if (r1.isClosed() == true) goto L12;
        boolean r3 = true;
        if (r23 == null) goto L24;
        Float r4 = Float.valueOf(r23.getScale());
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue() <= 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L24;
        float r6 = r4.floatValue();
    L25:
        float r10 = r6;
        AssistantComputerControlSession r7 = r1.getRawSession$base_release();     // Catch: Throwable -> L47
        if (r23 == null) goto L29;
        List<String> r8 = r23.getExcludingPackages();     // Catch: Throwable -> L47
    L30:
        AssistantScreenshotResult r9 = r7.getScreenshot(r8, r10);     // Catch: Throwable -> L47
        if (r9 != null) goto L33;
    L35:
        r3 = false;
    L36:
        if (r3 == false) goto L39;
        Loog.INSTANCE.w(TAG, "screenshot: Secure layers detected, returning ContainsSecure.");     // Catch: Throwable -> L47
        return new ScreenshotResult(ScreenshotResult.Status.ContainsSecure, null, null, 0, null, null, 62, null);
    L39:
        if (r9 == null) goto L41;
        r2 = r9.asBitmap();     // Catch: Throwable -> L47
    L41:
        Bitmap r11 = r2;
        if (r11 != null) goto L45;
        Loog.INSTANCE.w(TAG, "screenshot: Final bitmap is null, returning NoScreenFound.");     // Catch: Throwable -> L47
        return new ScreenshotResult(ScreenshotResult.Status.NoScreenFound, null, null, 0, null, null, 62, null);
    L45:
        HeifScreenshotAttachment r15 = captureHeifScreenshotOrNull(r1, r7, r23, r10, r11.getWidth(), r11.getHeight());     // Catch: Throwable -> L47
        Loog.INSTANCE.w("heif_size_cc", "outputWidth: " + r11.getWidth() + ", outputHeight: " + r11.getHeight());     // Catch: Throwable -> L47
        return new ScreenshotResult(ScreenshotResult.Status.Ok, (IScreenshot) ZeusTransformUtils.preCheckCast(new BitmapScreenshot(r11, r10, AOOperatingSpace.SpaceType.ComputerControl), IScreenshot.class, "com.obric.aiagent.plugin"), r15, 0, null, null, 56, null);
    L33:
        if (r9.containsSecureLayers() != true) goto L35;
    L29:
        r8 = null;
    L47:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "screenshot failed.", th);
        return new ScreenshotResult(ScreenshotResult.Status.ApiError, null, null, 0, null, null, 62, null);
    L18:
        r5 = false;
    L24:
        r6 = 1.0f;
        goto L25
    L12:
        return new ScreenshotResult(ScreenshotResult.Status.ScreenClosed, null, null, 0, null, null, 62, null);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi
    public CCActionResult close(CCSessionAccessor r6) {
        CCSessionAccessor r7 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r6, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, SensitiveType.SESSION);
        if (ZeusTransformUtils.instanceOf(r7, StandardCCSessionAccessor.class) == false) goto L5;
        StandardCCSessionAccessor r8 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r7, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L6:
        if (r8 == null) goto L8;
        dismissApplicationAccessTask((CCSessionAccessor) ZeusTransformUtils.preCheckCast(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin"), "session_close");
        if (r8.isClosed() == false) goto L13;
        cleanupSessionCallbacks(r8);
        r8.releaseLocalResources();
        return (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");
    L13:
        CCActionResult r0 = closeSafely(r8.getRawSession$base_release());
        if (o.a(r0, CCActionResult.Success.INSTANCE) == true) goto L16;
    L18:
        cleanupSessionCallbacks(r8);
        r8.releaseLocalResources();
        return r0;
    L16:
        if (r8.isClosed() == true) goto L18;
        r8.updateState((CCSessionState) ZeusTransformUtils.preCheckCast(new CCSessionState.Closed(null, 1, null), CCSessionState.class, "com.obric.aiagent.plugin"));
        goto L18
    L8:
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidSession, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L5:
        r8 = null;
        goto L6
    }

    private final ComputerControlSession.Params buildParams(Context r3, CCSessionConfig r4) {
        ComputerControlSession.Params.Builder r2 = new ComputerControlSession.Params.Builder((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).setName(r4.getName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.getTargetPackageNames(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
        r2.setTargetPackageNames(r4.getTargetPackageNames());
    L5:
        ComputerControlSession.Params r5 = r2.build();
        o.c(r5, "build(...)");
        return r5;
    }

    private final StandardCCSessionAccessor buildAccessorOrNull(Context r8, AssistantComputerControlSession r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AssistantComputerControlSession r11 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r9, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        Size r2 = r11.getDisplaySize();     // Catch: Throwable -> L17
        int r3 = -1;
        if (r2 == null) goto L6;
        int r4 = r2.getWidth();     // Catch: Throwable -> L17
    L7:
        if (r2 == null) goto L9;
        r3 = r2.getHeight();     // Catch: Throwable -> L17
    L9:
        int r5 = r11.getDisplayId();     // Catch: Throwable -> L17
        if (r5 < 0) goto L15;
        if (r4 <= 0) goto L15;
        if (r3 <= 0) goto L15;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        o.c(r12, "getApplicationContext(...)");     // Catch: Throwable -> L17
        return new StandardCCSessionAccessor(r12, r11, r5, s.a(Integer.valueOf(r4), Integer.valueOf(r3)));
    L15:
        Loog.INSTANCE.e(TAG, "Computer Control display info unavailable: displayId=" + r5 + ", width=" + r4 + ", height=" + r3);     // Catch: Throwable -> L17
        return null;
    L6:
        r4 = -1;
    L17:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to read Computer Control display info.", th);
        return null;
    }

    private final HeifScreenshotAttachment captureHeifScreenshotOrNull(StandardCCSessionAccessor r18, AssistantComputerControlSession r19, ScreenshotConfig r20, float r21, int r22, int r23) {
        AssistantComputerControlSession r5 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r19, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L66;
        ScreenshotConfig.HeifConfig r6 = r20.getHeifConfig();
        if (r6 == null) goto L69;
        File r7 = HeifScreenshotAttachment.Companion.cacheDir((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext$base_release(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L49
        r7.mkdirs();     // Catch: Throwable -> L49
        File r8 = File.createTempFile("cc_screenshot_", ".heif", r7);     // Catch: Throwable -> L49
        o.a(r8);     // Catch: Throwable -> L49
        HeifScreenshotAttachment r13 = new HeifScreenshotAttachment(r8);     // Catch: Throwable -> L49
        int r15 = d.l.n.a(r6.getQp(), 1, 51);     // Catch: Throwable -> L47
        int r11 = d.l.n.a(r6.getDownscalePreference(), 0, 1);     // Catch: Throwable -> L47
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(ParcelFileDescriptor.open(r8, 1006632960), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        ParcelFileDescriptor r9 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r10, ParcelFileDescriptor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
        List<String> r4 = r20.getExcludingPackages();     // Catch: Throwable -> L39
        if (r4 != null) goto L16;
        r4 = p.b();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Throwable r1 = th;
        Closeable r14 = r10;
    L62:
        throw r1;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        c.a(r14, r1);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L16:
        r14 = r10;
        AssistantScreenshotResult r12 = r5.getScreenshotHeif(r9, r4, r21, d.l.n.c(r22, 1), d.l.n.c(r23, 1), r15, r11);     // Catch: Throwable -> L37
        c.a(r14, null);     // Catch: Throwable -> L47
        if (r12 == null) goto L24;
        boolean r16 = true;
        if (r12.containsSecureLayers() != true) goto L25;
        boolean r17 = true;
    L26:
        if (r12 == null) goto L29;
        if (r17 == true) goto L29;
        boolean r110 = r16;
    L30:
        if (r110 == true) goto L32;
    L35:
        Loog.INSTANCE.w(TAG, "captureHeifScreenshot failed: succeeded=" + r110 + ", containsSecureLayers=" + r17 + ", valid=" + r13.isValid());     // Catch: Throwable -> L47
        r13.delete();     // Catch: Throwable -> L47
        return null;
    L32:
        if (r13.isValid() == false) goto L35;
        Loog.INSTANCE.i(TAG, "captureHeifScreenshot success: outputWidth=" + r22 + ", outputHeight=" + r23 + ", qp=" + r15 + ", downscalePreference=" + r11);     // Catch: Throwable -> L47
        return r13;
    L29:
        r110 = false;
    L25:
        r17 = false;
        goto L26
    L24:
        r16 = true;
    L37:
        th = th;
    L41:
        r1 = th;
    L39:
        th = th;
        r14 = r10;
    L47:
        th = th;
    L51:
        Loog.INSTANCE.e(TAG, "captureHeifScreenshot failed.", th);
        if (r13 == null) goto L68;
        r13.delete();
        return null;
    L68:
        return null;
    L49:
        th = th;
        r13 = null;
        goto L51
    L69:
        return null;
    L66:
        return null;
    }

    private final void installLifecycleCallback(AssistantComputerControlSession r4, final StandardCCSessionAccessor r5, CCLifecycleListener r6) {
        AssistantComputerControlSession r7 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        final CCLifecycleListener r8 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r6, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        r7.setLifecycleCallback(DIRECT_EXECUTOR, (ComputerControlSession.LifecycleCallback) ZeusTransformUtils.preCheckCast(new C11591(r5, this, r8), ComputerControlSession.LifecycleCallback.class, "com.obric.aiagent.plugin"));
    }

    private final void notifyLifecycle(CCLifecycleListener r2, CCSessionAccessor r3, CCSessionState r4) {
        CCLifecycleListener r1 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r2, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.onStateChanged(r5, r4);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Computer Control lifecycle listener failed: " + r4, th);
        return;
    }

    private final void notifyApplicationAccessPending(CCLifecycleListener r2, CCSessionAccessor r3, IntentSender r4) {
        CCLifecycleListener r1 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r2, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.onApplicationAccessPending(r5, r4);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Computer Control access-pending listener failed.", th);
        return;
    }

    private final void dismissApplicationAccessTask(CCSessionAccessor r8, String r9) {
        CCSessionAccessor r10 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r8, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        Object r4 = null;
        if (ZeusTransformUtils.instanceOf(r10, StandardCCSessionAccessor.class) == false) goto L5;
        StandardCCSessionAccessor r11 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r10, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 == null) goto L29;
        int r12 = r11.getDisplayId();
        if (Build.VERSION.SDK_INT >= 29) goto L24;
        return;
    L24:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(a.b.f30316a.a(10, false, false, r12), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L21
    L12:
        if (r2.hasNext() == false) goto L16;
        Object r5 = r2.next();     // Catch: Throwable -> L21
        if (isApplicationAccessTask((TaskInfo) ZeusTransformUtils.preCheckCast(r5, TaskInfo.class, "com.obric.aiagent.plugin")) == false) goto L12;
        r4 = r5;
    L16:
        TaskInfo r7 = (TaskInfo) ZeusTransformUtils.preCheckCast(r4, TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r7 != null) goto L19;
        return;
    L19:
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_ui_task_removed reason=" + r9 + " displayId=" + r12 + " taskId=" + r7.taskId + " removed=" + a.b.f30316a.a(r7.taskId));     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        Loog.INSTANCE.e(ACCESS_LOG_TAG, "event=access_ui_task_remove_failed reason=" + r9 + " displayId=" + r12, th);
        return;
    L29:
        return;
    L5:
        r11 = null;
        goto L6
    }

    private final boolean isApplicationAccessTask(TaskInfo r2) {
        if (r2.isRunning == true) goto L5;
    L17:
        return false;
    L5:
        if (r2.numActivities <= 0) goto L17;
        ComponentName r1 = r2.topActivity;
        ComponentName r0 = APPLICATION_ACCESS_COMPONENT;
        if (o.a(r1, r0) == false) goto L17;
        if (o.a(r2.baseActivity, r0) == false) goto L17;
        Intent r3 = r2.baseIntent;
        if (r3 == null) goto L13;
        String r4 = r3.getAction();
    L15:
        if (o.a(r4, APPLICATION_ACCESS_ACTION) == false) goto L17;
        return true;
    L13:
        r4 = null;
        goto L15
    }

    private final void installApplicationAccessCallback(AssistantComputerControlSession r4, final StandardCCSessionAccessor r5, CCLifecycleListener r6) {
        AssistantComputerControlSession r7 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        final CCLifecycleListener r8 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r6, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        clearApplicationAccessCallback(r7, r5);
        if (r8 != null) goto L5;
        return;
    L5:
        AssistantComputerControlSession.AccessCallback r1 = new ComputerControlSdkApiImpl$installApplicationAccessCallback$callback$1(this, r8, r5);
        r7.registerAccessCallback(DIRECT_EXECUTOR, (AssistantComputerControlSession.AccessCallback) ZeusTransformUtils.preCheckCast(r1, AssistantComputerControlSession.AccessCallback.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        r5.getAccessCallbackRef$base_release().set(r1);     // Catch: Throwable -> L8
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_callback_registered ccDisplayId=" + r5.getDisplayId());     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Loog.INSTANCE.e(ACCESS_LOG_TAG, "event=access_callback_register_failed reason=ApiError", th);
    }

    private final void clearApplicationAccessCallback(AssistantComputerControlSession r3, StandardCCSessionAccessor r4) {
        AssistantComputerControlSession r2 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        AssistantComputerControlSession.AccessCallback r5 = (AssistantComputerControlSession.AccessCallback) ZeusTransformUtils.preCheckCast(r4.getAccessCallbackRef$base_release().getAndSet(null), AssistantComputerControlSession.AccessCallback.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        r2.unregisterAccessCallback(r5);
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_callback_unregistered ccDisplayId=" + r4.getDisplayId());
    }

    private final CCApplicationAccessResult toApplicationAccessResult(int r2) {
        if (r2 != 0) goto L4;
        CCApplicationAccessState r1 = CCApplicationAccessState.Denied;
    L15:
        return new CCApplicationAccessResult(r1, r2);
    L4:
        if (r2 != 1) goto L6;
        r1 = CCApplicationAccessState.Granted;
        goto L15
    L6:
        if (r2 != 2) goto L8;
        r1 = CCApplicationAccessState.Pending;
        goto L15
    L8:
        if (r2 == 3) goto L10;
        r1 = CCApplicationAccessState.Unknown;
        goto L15
    L10:
        r1 = CCApplicationAccessState.DeniedBlacklist;
        goto L15
    }

    private final void cleanupSessionCallbacks(final StandardCCSessionAccessor r4) {
        if (r4.getCallbacksCleaned$base_release().compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        final AssistantComputerControlSession r0 = r4.getRawSession$base_release();
        if (r4.getStabilityListenerRef$base_release().getAndSet(null) == null) goto L8;
        cleanupSessionCallbacks$runCleanup("clearStabilityListener", new $$Lambda$ComputerControlSdkApiImpl$chNGDPd9EN8wgioSzxFvhcP7dWE(r0));
    L8:
        cleanupSessionCallbacks$runCleanup("clearTouchListener", new $$Lambda$ComputerControlSdkApiImpl$CBaxzQ04EC5t4trQ9GXEkHiNx04(r0));
        cleanupSessionCallbacks$runCleanup("clearApplicationAccessCallback", new $$Lambda$ComputerControlSdkApiImpl$OkK0vWgH2XXLJVqw9nYEZqPUVYk(this, r0, r4));
        cleanupSessionCallbacks$runCleanup("clearLifecycleCallback", new $$Lambda$ComputerControlSdkApiImpl$rkpjjuXlTVfUO47MYSBc1XLtHGk(r0));
    }

    private static final void cleanupSessionCallbacks$runCleanup(String r3, d.h.a.a<x> r4) {
        ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "cleanup Computer Control session callback failed: " + r3, th);
    }

    private static final x cleanupSessionCallbacks$lambda$33(AssistantComputerControlSession r2) {
        ((AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r2, AssistantComputerControlSession.class, "com.obric.aiagent.plugin")).clearStabilityListener();
        return x.f38692a;
    }

    private static final x cleanupSessionCallbacks$lambda$34(AssistantComputerControlSession r2) {
        ((AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r2, AssistantComputerControlSession.class, "com.obric.aiagent.plugin")).setTouchListener(null);
        return x.f38692a;
    }

    private static final x cleanupSessionCallbacks$lambda$35(ComputerControlSdkApiImpl r2, AssistantComputerControlSession r3, StandardCCSessionAccessor r4) {
        r2.clearApplicationAccessCallback((AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r3, AssistantComputerControlSession.class, "com.obric.aiagent.plugin"), r4);
        return x.f38692a;
    }

    private static final x cleanupSessionCallbacks$lambda$36(AssistantComputerControlSession r2) {
        ((AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r2, AssistantComputerControlSession.class, "com.obric.aiagent.plugin")).clearLifecycleCallback();
        return x.f38692a;
    }

    private final void disposeUnclaimedSession(StandardCCSessionAccessor r3) {
        cleanupSessionCallbacks(r3);
        closeSafely(r3.getRawSession$base_release());
        r3.releaseLocalResources();
        r3.updateState((CCSessionState) ZeusTransformUtils.preCheckCast(new CCSessionState.Closed(null, 1, null), CCSessionState.class, "com.obric.aiagent.plugin"));
    }

    private final KeyEvent buildKeyEvent(int r1, int r2, long r3) {
        KeyEvent r0 = new KeyEvent.Builder().setKeyCode(r1).setAction(r2).setEventTimeNanos(r3).build();
        o.c(r0, "build(...)");
        return r0;
    }

    private final TouchEvent toSdkTouchEvent(CCTouchEvent r3) {
        TouchEvent r2 = new TouchEvent.Builder().setPointerId(r3.getPointerId()).setToolType(r3.getToolType()).setAction(r3.getAction()).setX(r3.getX()).setY(r3.getY()).setPressure(r3.getPressure()).setMajorAxisSize(r3.getMajorAxisSize()).setEventTimeNanos(r3.getEventTimeNanos()).build();
        o.c(r2, "build(...)");
        return r2;
    }

    private final CCTouchEvent toCcTouchEvent(TouchEvent r11) {
        TouchEvent r10 = (TouchEvent) ZeusTransformUtils.wrapperContextForParams(r11, TouchEvent.class, "com.obric.aiagent.plugin");
        return new CCTouchEvent(r10.getPointerId(), r10.getToolType(), r10.getAction(), r10.getX(), r10.getY(), r10.getPressure(), r10.getMajorAxisSize(), r10.getEventTimeNanos());
    }

    private final CCActionResult withRawSession(CCSessionAccessor r4, d.h.a.b<? super AssistantComputerControlSession, x> r5) {
        CCSessionAccessor r3 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, StandardCCSessionAccessor.class) == false) goto L5;
        StandardCCSessionAccessor r7 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r3, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L7:
        if (r7 != null) goto L11;
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidSession, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L11:
        if (r7.isClosed() == true) goto L13;
        r6.invoke(r7.getRawSession$base_release());     // Catch: Throwable -> L16
        return (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Computer Control action failed.", th);
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.ApiError, th), CCActionResult.class, "com.obric.aiagent.plugin");
    L13:
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.SessionClosed, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L5:
        r7 = null;
        goto L7
    }

    private final <T> CCDataResult<T> withRawSessionData(CCSessionAccessor r4, d.h.a.b<? super AssistantComputerControlSession, ? extends T> r5) {
        CCSessionAccessor r3 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, StandardCCSessionAccessor.class) == false) goto L5;
        StandardCCSessionAccessor r7 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r3, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L7:
        if (r7 != null) goto L11;
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.InvalidSession, null, 2, null), CCDataResult.class, "com.obric.aiagent.plugin");
    L11:
        if (r7.isClosed() == true) goto L13;
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Success(r6.invoke(r7.getRawSession$base_release())), CCDataResult.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Computer Control data action failed.", th);
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.ApiError, th), CCDataResult.class, "com.obric.aiagent.plugin");
    L13:
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.SessionClosed, null, 2, null), CCDataResult.class, "com.obric.aiagent.plugin");
    L5:
        r7 = null;
        goto L7
    }

    private final CCActionResult withAssistantSession(CCSessionAccessor r4, d.h.a.b<? super AssistantComputerControlSession, x> r5) {
        CCSessionAccessor r3 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, StandardCCSessionAccessor.class) == false) goto L5;
        StandardCCSessionAccessor r7 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r3, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L7:
        if (r7 != null) goto L11;
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.InvalidSession, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L11:
        if (r7.isClosed() == true) goto L13;
        r6.invoke(r7.getRawSession$base_release());     // Catch: Throwable -> L16
        return (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Computer Control Assistant action failed.", th);
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.ApiError, th), CCActionResult.class, "com.obric.aiagent.plugin");
    L13:
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.SessionClosed, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");
    L5:
        r7 = null;
        goto L7
    }

    private final <T> CCDataResult<T> withAssistantSessionData(CCSessionAccessor r4, d.h.a.b<? super AssistantComputerControlSession, ? extends T> r5) {
        CCSessionAccessor r3 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r4, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, StandardCCSessionAccessor.class) == false) goto L5;
        StandardCCSessionAccessor r7 = (StandardCCSessionAccessor) ZeusTransformUtils.preCheckCast(r3, StandardCCSessionAccessor.class, "com.obric.aiagent.plugin");
    L7:
        if (r7 != null) goto L11;
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.InvalidSession, null, 2, null), CCDataResult.class, "com.obric.aiagent.plugin");
    L11:
        if (r7.isClosed() == true) goto L13;
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Success(r6.invoke(r7.getRawSession$base_release())), CCDataResult.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Computer Control Assistant data action failed.", th);
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.ApiError, th), CCDataResult.class, "com.obric.aiagent.plugin");
    L13:
        return (CCDataResult) ZeusTransformUtils.preCheckCast(new CCDataResult.Failed(CCActionFailureReason.SessionClosed, null, 2, null), CCDataResult.class, "com.obric.aiagent.plugin");
    L5:
        r7 = null;
        goto L7
    }

    private final boolean resumeRequest(AtomicBoolean r3, n<? super CCSessionRequestResult> r4, CCSessionRequestResult r5) {
        n r2 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        if (r2.a() == true) goto L6;
        return false;
    L6:
        if (r3.compareAndSet(false, true) == true) goto L8;
        return false;
    L8:
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r7 = d.n.f38560a;
        r6.resumeWith(d.n.f(r5));
        return true;
    }

    private final CCActionResult closeSafely(AssistantComputerControlSession r4) {
        ((AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin")).close();     // Catch: Throwable -> L5
        return (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "close Computer Control session failed.", th);
        return (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.ApiError, th), CCActionResult.class, "com.obric.aiagent.plugin");
    }

    private final boolean shouldCreateSurfaceMirrorDisplay() {
        return !com.obric.autogui.common.a.c.f28972a.a().e();
    }

    private final VirtualDisplay setupVirtualDisplay(Context r8, CCSessionConfig r9, int r10) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        Integer r11 = r9.getDisplayWidthPx();
        Integer r1 = r9.getDisplayHeightPx();
        Integer r12 = r9.getDisplayDpi();
        if (r11 == null) goto L21;
        if (r1 == null) goto L21;
        if (r12 == null) goto L21;
        Object r13 = r7.getSystemService("display");
        o.a(r13, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager r14 = (DisplayManager) ZeusTransformUtils.preCheckCast(r13, DisplayManager.class, "com.obric.aiagent.plugin");
        VirtualDisplayConfig.Builder r15 = new VirtualDisplayConfig.Builder("ComputerControlSession", r11.intValue(), r1.intValue(), r12.intValue()).setFlags(17);
        o.c(r15, "setFlags(...)");
        r15.getClass().getMethod("setDisplayIdToMirror", new Class[]{Integer.TYPE}).invoke(r15, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L18
        VirtualDisplay r16 = r14.createVirtualDisplay(r15.build());     // Catch: Throwable -> L15
        if (r16 != null) goto L13;
        Loog.INSTANCE.e(TAG, "create Surface mirror virtual display returned null.");     // Catch: Throwable -> L15
        return null;
    L13:
        Loog.INSTANCE.i(TAG, "setupVirtualDisplay: mirrorDisplayId=" + r16.getDisplay().getDisplayId());     // Catch: Throwable -> L15
        return r16;
    L15:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "create Surface mirror virtual display failed.", th);
        return null;
    L18:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "setDisplayIdToMirror failed via reflection.", th);
        return null;
    L21:
        Loog.INSTANCE.e(TAG, "setupVirtualDisplay failed: missing display config, width=" + r11 + ", height=" + r1 + ", dpi=" + r12);
        return null;
    }

    static {
        Companion = new Companion(null);
        APPLICATION_ACCESS_COMPONENT = new ComponentName("com.android.virtualdevicemanager", "com.android.virtualdevicemanager.RequestComputerControlAccessActivity");
        DIRECT_EXECUTOR = $$Lambda$ComputerControlSdkApiImpl$QQZ_NB6kXFD4j8UTPgcGCw0vkpI.INSTANCE;
    }

    private static final void DIRECT_EXECUTOR$lambda$37(Runnable r2) {
        ((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin")).run();
    }
}
