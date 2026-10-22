package com.obric.autogui.platforms.tools.display.vd;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.TaskInfo;
import android.app.TaskStackListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.ArrayMap;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.platform.api.app.ObricTaskStackListener;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatform;
import com.obric.autogui.common.api.platform.annotation.CallingBiz;
import com.obric.autogui.common.api.platform.annotation.CallingPlatform;
import com.obric.autogui.common.api.platform.annotation.FakeApi;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.vd.VDSpace;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDListener;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.b.h;
import d.m;
import d.n;
import d.o;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: VDTaskStackObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
@CallingBiz
@CallingPlatform
public final class VDTaskStackObserver {
    private static final String TAG = "VD-TSO";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VDTaskStackObserver f30162a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper f30163b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f30164c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f30165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d f30166e = null;
    private static boolean f;
    private static final Map<Integer, DisplayedAppInfo> g = null;
    private static ArrayMap<Integer, Integer> h;
    private static final TasksStackListener i = null;
    private static final a j = null;

    /* JADX INFO: compiled from: VDTaskStackObserver.kt */
    @FakeApi
    private static final class TasksStackListener extends TaskStackListener {

        /* JADX INFO: compiled from: VDTaskStackObserver.kt */
        @d.c.b.a.f(b = "VDTaskStackObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver$TasksStackListener$onTaskMovedToFront$1")
        static final class a extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30167a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f30168b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ActivityManager.RunningTaskInfo f30169c;

            a(String r3, ActivityManager.RunningTaskInfo r4, d.c.d<? super a> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30168b = r3;
                this.f30169c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f30168b, this.f30169c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r11) {
                d.c.a.b.a();
                if (this.f30167a != 0) goto L28;
                o.a(r11);
                String r1 = null;
                Boolean r12 = d.c.b.a.b.a(true);     // Catch: Throwable -> L11
                IAutoActionVDListener r2 = VDTaskStackObserver.a(VDTaskStackObserver.f30162a);     // Catch: Throwable -> L11
                if (r2 == null) goto L8;
                String r3 = r2.captureOperationOwnerToken();     // Catch: Throwable -> L11
            L9:
                m r13 = s.a(r12, r3);     // Catch: Throwable -> L11
            L13:
                boolean r4 = com.obric.autogui.platforms.tools.display.vd.d.a(this.f30168b, (String) ZeusTransformUtils.preCheckCast(r13.b(), String.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r13.a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
                if (r4 == true) goto L16;
                Loog.INSTANCE.w(VDTaskStackObserver.TAG, "[TSL][TaskMovedToFront] skip stale operation notification task=" + this.f30169c.taskId + ", capturedOwner=" + this.f30168b + ", currentOwner=" + ((String) ZeusTransformUtils.preCheckCast(r13.b(), String.class, "com.obric.aiagent.plugin")));
            L16:
                int r14 = com.obric.autogui.platforms.tools.internal.a.f.f30329a.a((TaskInfo) ZeusTransformUtils.preCheckCast(this.f30169c, TaskInfo.class, "com.obric.aiagent.plugin"));
                Loog.INSTANCE.i(VDTaskStackObserver.TAG, "[TSL][TaskMovedToFront]: " + this.f30169c.taskId + ", top=" + this.f30169c.topActivity + ", disp=" + r14);
                VDTaskStackObserver r5 = VDTaskStackObserver.f30162a;
                TaskInfo r6 = (TaskInfo) ZeusTransformUtils.preCheckCast(this.f30169c, TaskInfo.class, "com.obric.aiagent.plugin");
                String r7 = this.f30168b;
                if (r4 == false) goto L19;
                r1 = r7;
            L19:
                DisplayedAppInfo r8 = VDTaskStackObserver.a(r5, r6, r14, r1);
                Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[TSL][TaskMovedToFront] after front flow task=" + r8.getTaskId() + ", callbackTask=" + this.f30169c.taskId + ", display=" + r14 + ", tracking=" + VDTaskStackObserver.b(VDTaskStackObserver.f30162a));
                AOOperatingSpace r9 = OperatingSpaceManager.INSTANCE.getActiveSpace();
                if (ZeusTransformUtils.instanceOf(r9, DisplayOperatingSpace.class) == true) goto L22;
            L24:
                Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[TSL][TaskMovedToFront] skip robots policy task=" + this.f30169c.taskId + ", display=" + r14 + ", activeSpace=" + VDTaskStackObserver.a(VDTaskStackObserver.f30162a, r9));
            L26:
                return x.f38692a;
            L22:
                if (((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r9, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId() != r14) goto L24;
                Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[TSL][TaskMovedToFront] update robots policy task=" + r8.getTaskId() + ", callbackTask=" + this.f30169c.taskId + ", display=" + r14 + ", top=" + r8.getTopActivity());
                ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r9, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).updateRobotsPolicyCache(r8.getTopActivity());
                goto L26
            L8:
                r3 = null;
            L11:
                th = move-exception;
                Loog.INSTANCE.e(VDTaskStackObserver.TAG, "[TSL][TaskMovedToFront] failed to revalidate operation owner", th);
                r13 = s.a(d.c.b.a.b.a(false), null);
                goto L13
            L28:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: VDTaskStackObserver.kt */
        @d.c.b.a.f(b = "VDTaskStackObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver$TasksStackListener$onTaskRemoved$1")
        static final class b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30170a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f30171b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f30172c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ DisplayedAppInfo f30173d;

            b(int r3, boolean r4, DisplayedAppInfo r5, d.c.d<? super b> r6) {
                DisplayedAppInfo r7 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r5, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30171b = r3;
                this.f30172c = r4;
                this.f30173d = r7;
                super(1, r8);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f30171b, this.f30172c, this.f30173d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f30170a != 0) goto L21;
                o.a(r4);
                Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[TSL] dispatch taskClosed taskId=" + this.f30171b + ", isTracking=" + this.f30172c + ", tracking=" + VDTaskStackObserver.b(VDTaskStackObserver.f30162a));
                IAutoActionVDListener r5 = VDTaskStackObserver.a(VDTaskStackObserver.f30162a);
                if (r5 == null) goto L8;
                r5.taskClosed(this.f30171b, this.f30172c);
            L8:
                if (this.f30172c == false) goto L19;
                Loog.INSTANCE.i(VDTaskStackObserver.TAG, "[TSL] dispatch trackingAppTerminated taskId=" + this.f30171b + ", appInfo=" + this.f30173d);
                IAutoActionVDListener r6 = VDTaskStackObserver.a(VDTaskStackObserver.f30162a);
                if (r6 == null) goto L19;
                int r1 = this.f30171b;
                DisplayedAppInfo r3 = this.f30173d;
                if (r3 == null) goto L16;
                ComponentName r7 = r3.getTopActivity();
                if (r7 == null) goto L16;
                String r8 = r7.getPackageName();
            L17:
                r6.trackingAppTerminated(new VDTrackingApp(r1, r8));
            L16:
                r8 = null;
            L19:
                return x.f38692a;
            L21:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public TasksStackListener() {
        }

        public void onTaskMovedToFront(ActivityManager.RunningTaskInfo r5) {
            if (r5 != null) goto L16;
            Loog.INSTANCE.e(VDTaskStackObserver.TAG, "[TSL] onTaskMovedToFront: null taskInfo");
            return;
        L16:
            IAutoActionVDListener r1 = VDTaskStackObserver.a(VDTaskStackObserver.f30162a);     // Catch: Throwable -> L11
            if (r1 == null) goto L13;
            String r4 = r1.captureOperationOwnerToken();     // Catch: Throwable -> L11
        L14:
            VDTaskStackObserver.d().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r4, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
            return;
        L13:
            r4 = null;
        L11:
            th = move-exception;
            Loog.INSTANCE.e(VDTaskStackObserver.TAG, "[TSL][TaskMovedToFront] failed to capture operation owner", th);
            goto L13
        }

        public void onTaskMovedToBack(ActivityManager.RunningTaskInfo r5) {
            Loog.INSTANCE.i(VDTaskStackObserver.TAG, "[TSL] onTaskMovedToBack: " + VDTaskStackObserver.a(VDTaskStackObserver.f30162a, (TaskInfo) ZeusTransformUtils.preCheckCast(r5, TaskInfo.class, "com.obric.aiagent.plugin")) + ", tracking=" + VDTaskStackObserver.b(VDTaskStackObserver.f30162a));
        }

        public void onTaskRemoved(int r8) {
            c r7 = VDTaskStackObserver.e();
            boolean r0 = false;
            if (r7 == null) goto L9;
            DisplayedAppInfo r9 = r7.b();
            if (r9 == null) goto L9;
            if (r8 != r9.getTaskId()) goto L9;
            r0 = true;
        L9:
            DisplayedAppInfo r10 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(VDTaskStackObserver.f().get(Integer.valueOf(r8)), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
            if (r10 != null) goto L12;
            Loog.INSTANCE.w(VDTaskStackObserver.TAG, "[TSL] onTaskRemoved: unknown taskId=" + r8 + ", isTracking=" + r0);
        L13:
            VDTaskStackObserver.d().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r8, r0, r10, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
            return;
        L12:
            Loog.INSTANCE.i(VDTaskStackObserver.TAG, "[TSL] onTaskRemoved: " + r8 + ", isTracking=" + r0 + ", appInfo=" + r10);
            goto L13
        }
    }

    /* JADX INFO: compiled from: VDTaskStackObserver.kt */
    private static final class a extends ObricTaskStackListener {

        /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VDTaskStackObserver.kt */
        @d.c.b.a.f(b = "VDTaskStackObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver$ExtendedTasksStackListener$onDisplaySecureChanged$1")
        static final class C0804a extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30174a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f30175b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f30176c;

            C0804a(int r3, boolean r4, d.c.d<? super C0804a> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30175b = r3;
                this.f30176c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((C0804a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), C0804a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0804a(this.f30175b, this.f30176c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f30174a != 0) goto L12;
                o.a(r4);
                AOOperatingSpace r5 = OperatingSpaceManager.INSTANCE.getActiveSpace();
                if (ZeusTransformUtils.instanceOf(r5, DisplayOperatingSpace.class) == false) goto L10;
                if (((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId() != this.f30175b) goto L10;
                ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).onDisplaySecureStatusChanged(this.f30176c);
            L10:
                return x.f38692a;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: VDTaskStackObserver.kt */
        @d.c.b.a.f(b = "VDTaskStackObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver$ExtendedTasksStackListener$onDisplayStatusBarChanged$1")
        static final class b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30177a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f30178b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f30179c;

            b(int r3, int r4, d.c.d<? super b> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30178b = r3;
                this.f30179c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f30178b, this.f30179c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f30177a != 0) goto L12;
                o.a(r4);
                AOOperatingSpace r5 = OperatingSpaceManager.INSTANCE.getActiveSpace();
                if (ZeusTransformUtils.instanceOf(r5, DisplayOperatingSpace.class) == false) goto L10;
                if (((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId() != this.f30178b) goto L10;
                ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).onDisplayStatusBarAppearanceChanged(this.f30179c);
            L10:
                return x.f38692a;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: VDTaskStackObserver.kt */
        @d.c.b.a.f(b = "VDTaskStackObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver$ExtendedTasksStackListener$onTaskToBackground$1")
        static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30180a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ActivityManager.RunningTaskInfo f30181b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f30182c;

            c(ActivityManager.RunningTaskInfo r3, int r4, d.c.d<? super c> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30181b = r3;
                this.f30182c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f30181b, this.f30182c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r11) {
                d.c.a.b.a();
                if (this.f30180a != 0) goto L53;
                o.a(r11);
                ComponentName r12 = this.f30181b.topActivity;
                if (r12 == null) goto L8;
                String r13 = r12.getPackageName();
                if (r13 == null) goto L8;
            L9:
                IAutoActionVDListener r0 = VDTaskStackObserver.a(VDTaskStackObserver.f30162a);
                if (r0 == null) goto L12;
                r0.appMovedToMdBackground(r13);
            L12:
                int r1 = this.f30181b.taskId;
                c r2 = VDTaskStackObserver.e();
                Integer r3 = null;
                if (r2 == null) goto L15;
                DisplayedAppInfo r4 = r2.b();
            L16:
                AOOperatingSpace r5 = OperatingSpaceManager.INSTANCE.getActiveSpace();
                Loog.INSTANCE.i(VDTaskStackObserver.TAG, "[ETSL][TaskToBg] taskId=" + r1 + ", pkg=" + r13 + ", display=" + this.f30182c + ", main=" + AOSystemTools.INSTANCE.getMainDisplayId() + ", active=" + VDTaskStackObserver.a(VDTaskStackObserver.f30162a, r5) + ", tracking=" + VDTaskStackObserver.b(VDTaskStackObserver.f30162a));
                if (r1 > 0) goto L20;
                Loog.INSTANCE.w(VDTaskStackObserver.TAG, "[ETSL][TaskToBg] ignored invalid taskId=" + r1);
                return x.f38692a;
            L20:
                boolean r6 = true;
                if (r4 != null) goto L23;
            L25:
                boolean r7 = false;
            L27:
                if (r7 == true) goto L29;
            L33:
                Loog r14 = Loog.INSTANCE;
                StringBuilder r8 = new StringBuilder().append("[ETSL][TaskToBg] no move taskId=").append(r1).append(", isTracking=");
                if (r4 != null) goto L36;
            L38:
                boolean r9 = false;
            L39:
                StringBuilder r10 = r8.append(r9).append(", isMainDisplay=");
                if (this.f30182c == AOSystemTools.INSTANCE.getMainDisplayId()) goto L43;
                r6 = false;
            L43:
                StringBuilder r15 = r10.append(r6).append(", activeDisplay=");
                if (ZeusTransformUtils.instanceOf(r5, DisplayOperatingSpace.class) == false) goto L46;
                DisplayOperatingSpace r16 = (DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
            L47:
                if (r16 == null) goto L49;
                r3 = d.c.b.a.b.a(r16.getDisplayId());
            L49:
                r14.d(VDTaskStackObserver.TAG, r15.append(r3).toString());
            L51:
                return x.f38692a;
            L46:
                r16 = null;
                goto L47
            L36:
                if (r4.getTaskId() != r1) goto L38;
                r9 = true;
                goto L39
            L29:
                if (this.f30182c != AOSystemTools.INSTANCE.getMainDisplayId()) goto L33;
                if (ZeusTransformUtils.instanceOf(r5, DisplayOperatingSpace.class) == false) goto L33;
                Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[ETSL][TaskToBg] move tracking MD --> VD taskId=" + r1 + ", targetDisplay=" + ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId());
                VDTaskStackObserver.a(VDTaskStackObserver.f30162a, r1, r13, ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId());
                goto L51
            L23:
                if (r4.getTaskId() != r1) goto L25;
                r7 = true;
                goto L27
            L15:
                r4 = null;
            L8:
                r13 = "";
                goto L9
            L53:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public a() {
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricTaskStackListener
        public void onDisplaySecureChanged(int r3, boolean r4) {
            Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[ETSL] onDisplaySecureChanged: " + r3 + " -> " + r4);
            VDTaskStackObserver.d().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0804a(r3, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricTaskStackListener
        public void onDisplayStatusBarChanged(int r3, int r4) {
            Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[ETSL] onDisplayStatusBarChanged: " + r3 + " -> " + r4);
            VDTaskStackObserver.d().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r3, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricTaskStackListener
        @CallingBiz
        @CallingPlatform
        public void onTaskToBackground(ActivityManager.RunningTaskInfo r5) {
            Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[ETSL] onTaskToBackground: " + r5);
            if (r5 != null) goto L5;
            return;
        L5:
            ComponentName r4 = r5.topActivity;
            if (r4 == null) goto L11;
            AOHostAppTools r0 = AOHostAppTools.INSTANCE;
            String r2 = r4.getPackageName();
            d.h.b.o.c(r2, "getPackageName(...)");
            String r6 = r4.getClassName();
            d.h.b.o.c(r6, "getClassName(...)");
            if (r0.isSelf(r2, r6) == false) goto L11;
            Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[VD/TSO-BG] AppInfo: " + r5 + " --> AutoAction's. Ignored.");
            return;
        L11:
            VDTaskStackObserver.d().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r5, com.obric.autogui.platforms.tools.internal.a.f.f30329a.a((TaskInfo) ZeusTransformUtils.preCheckCast(r5, TaskInfo.class, "com.obric.aiagent.plugin")), null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricTaskStackListener
        public void onTaskRemovedBeforeFocusChanged(ActivityManager.RunningTaskInfo r1) {
            super.onTaskRemovedBeforeFocusChanged(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricTaskStackListener
        public void onReportError(int r4, int r5) {
            super.onReportError(r4, r5);
            DisplayedAppInfo r3 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(VDTaskStackObserver.f().get(Integer.valueOf(r4)), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
            ComponentName r0 = null;
            if (r3 == null) goto L8;
            ComponentName r1 = r3.getTopActivity();
            if (r1 == null) goto L8;
        L7:
            r0 = r1;
        L14:
            Loog.INSTANCE.w(VDTaskStackObserver.TAG, "[ETSL] onReportError: taskId=" + r4 + ", err=" + r5 + ", act=" + r0);
            return;
        L8:
            if (r3 == null) goto L10;
            r1 = r3.getRealActivity();
        L11:
            if (r1 != null) goto L7;
            if (r3 == null) goto L14;
            r0 = r3.getBaseActivity();
            goto L14
        L10:
            r1 = null;
            goto L11
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricTaskStackListener
        public void onBlacklistAppOpen(String r10) {
            super.onBlacklistAppOpen(r10);
            if (r10 == null) goto L5;
            String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        L7:
            if (r11 != null) goto L10;
            r11 = "";
        L10:
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L12;
            return;
        L12:
            IAutoActionVDListener r1 = VDTaskStackObserver.a(VDTaskStackObserver.f30162a);
            if (r1 == null) goto L16;
            Loog.INSTANCE.i(VDTaskStackObserver.TAG, "[BlackList] onBlacklistAppOpen: pkg=" + r11 + " (delegating)");
            r1.vdBlacklistAppOpen(r11);
            return;
        L16:
            Loog.INSTANCE.d(VDTaskStackObserver.TAG, "[BlackList] opener ---> " + r11 + " (no listener; terminating)");
            AppInfoEntry r12 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11);
            if (r12 == null) goto L21;
            CharSequence r13 = r12.getAppLabel();
            if (r13 == null) goto L21;
        L22:
            IAutoActionAgentApi r2 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            String r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.platform_app_blacklist, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_app_blacklist"), new Object[]{r13});
            d.h.b.o.c(r3, "getString(...)");
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default(r2, null, r3, 106001, null, null, 24, null);
            return;
        L21:
            r13 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
            goto L22
        L5:
            r11 = null;
            goto L7
        }
    }

    /* JADX INFO: compiled from: VDTaskStackObserver.kt */
    private static abstract class b {

        /* JADX INFO: compiled from: VDTaskStackObserver.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final DisplayedAppInfo f30183a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final f f30184b;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f30183a, r6.f30183a) == true) goto L12;
                return false;
            L12:
                if (d.h.b.o.a(this.f30184b, r6.f30184b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = this.f30183a.hashCode() * 31;
                f r1 = this.f30184b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "Accepted(appInfo=" + this.f30183a + ", trackingTargets=" + this.f30184b + ')';
            }

            public /* synthetic */ a(DisplayedAppInfo r2, f r3, int r4, h r5) {
                DisplayedAppInfo r6 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r2, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
                if ((r4 & 2) == 0) goto L5;
                r3 = null;
            L5:
                this(r6, r3);
            }

            public final DisplayedAppInfo a() {
                return this.f30183a;
            }

            public final f b() {
                return this.f30184b;
            }

            public a(DisplayedAppInfo r3, f r4) {
                DisplayedAppInfo r5 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r3, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "appInfo");
                super(null);
                this.f30183a = r5;
                this.f30184b = r4;
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VDTaskStackObserver.kt */
        public static final class C0805b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0805b f30185a = null;

            static {
                f30185a = new C0805b();
            }

            private C0805b() {
                super(null);
            }
        }

        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: VDTaskStackObserver.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f30186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private DisplayedAppInfo f30187b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f30186a == r6.f30186a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f30187b, r6.f30187b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f30186a) * 31) + this.f30187b.hashCode();
        }

        public String toString() {
            return "TrackingAppHolder(displayId=" + this.f30186a + ", appInfo=" + this.f30187b + ')';
        }

        public c(int r3, DisplayedAppInfo r4) {
            DisplayedAppInfo r5 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r4, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "appInfo");
            this.f30186a = r3;
            this.f30187b = r5;
        }

        public final int a() {
            return this.f30186a;
        }

        public final DisplayedAppInfo b() {
            return this.f30187b;
        }
    }

    /* JADX INFO: compiled from: VDTaskStackObserver.kt */
    public static final class d extends PluginBroadcastReceiver {

        /* JADX INFO: compiled from: VDTaskStackObserver.kt */
        @d.c.b.a.f(b = "VDTaskStackObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver$mScreenOffReceiver$1$onReceive$1")
        static final class a extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30188a;

            a(d.c.d<? super a> r3) {
                super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r1) {
                d.c.a.b.a();
                if (this.f30188a != 0) goto L7;
                o.a(r1);
                VDTaskStackObserver.c(VDTaskStackObserver.f30162a);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        d() {
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L5;
            String r4 = r3.getAction();
        L7:
            if (d.h.b.o.a(r4, "android.intent.action.SCREEN_OFF") == false) goto L10;
            VDTaskStackObserver.d().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    private VDTaskStackObserver() {
    }

    public static final /* synthetic */ DisplayedAppInfo a(VDTaskStackObserver r0, TaskInfo r1, int r2, String r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ IAutoActionVDListener a(VDTaskStackObserver r0) {
        return r0.h();
    }

    public static final /* synthetic */ String a(VDTaskStackObserver r0, TaskInfo r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ String a(VDTaskStackObserver r0, Object r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ void a(VDTaskStackObserver r0, int r1, String r2, int r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ String b(VDTaskStackObserver r0) {
        return r0.g();
    }

    public static final /* synthetic */ void c(VDTaskStackObserver r0) {
        r0.k();
    }

    public static final /* synthetic */ AOThreadingTools.SingleThreadCoroutineScopeWrapper d() {
        return f30163b;
    }

    public static final /* synthetic */ c e() {
        return f30165d;
    }

    public static final /* synthetic */ Map f() {
        return g;
    }

    static {
        f30162a = new VDTaskStackObserver();
        f30163b = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "VD-TaskStackObserver", false, 2, null);
        f30164c = new AtomicBoolean(false);
        f30166e = new d();
        g = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        h = new ArrayMap();
        i = new TasksStackListener();
        j = new a();
    }

    public final boolean a() {
        return f30164c.get();
    }

    public final synchronized void b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f30164c.compareAndSet(false, true) == true) goto L9;
        Loog.INSTANCE.w(TAG, "StartVDTaskStackObserver: already started.");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        f30165d = null;     // Catch: Throwable -> L12
        g.clear();     // Catch: Throwable -> L12
        h.clear();     // Catch: Throwable -> L12
        Loog.INSTANCE.i(TAG, "Start VDTaskStackObserver.");     // Catch: Throwable -> L12
        ActivityTaskManager.getInstance().registerTaskStackListener((TaskStackListener) ZeusTransformUtils.preCheckCast(i, TaskStackListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a((ObricTaskStackListener) ZeusTransformUtils.preCheckCast(j, ObricTaskStackListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        i();     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final synchronized void c() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f30164c.compareAndSet(true, false) == true) goto L9;
        Loog.INSTANCE.w(TAG, "StopVDTaskStackObserver: not started.");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        f30165d = null;     // Catch: Throwable -> L12
        g.clear();     // Catch: Throwable -> L12
        h.clear();     // Catch: Throwable -> L12
        Loog.INSTANCE.i(TAG, "Stop VDTaskStackObserver.");     // Catch: Throwable -> L12
        j();     // Catch: Throwable -> L12
        ActivityTaskManager.getInstance().unregisterTaskStackListener((TaskStackListener) ZeusTransformUtils.preCheckCast(i, TaskStackListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.b((ObricTaskStackListener) ZeusTransformUtils.preCheckCast(j, ObricTaskStackListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final DisplayedAppInfo a(int r2) {
        return (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(g.get(Integer.valueOf(r2)), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
    }

    private final void a(int r3, int r4) {
        Integer r2 = Integer.valueOf(r3);
        Integer r5 = Integer.valueOf(r4);
        ((Map) ZeusTransformUtils.preCheckCast(h, Map.class, "com.obric.aiagent.plugin")).put(r2, r5);
    }

    public final Integer b(int r2) {
        return (Integer) ZeusTransformUtils.preCheckCast(h.get(Integer.valueOf(r2)), Integer.class, "com.obric.aiagent.plugin");
    }

    private final Integer c(int r2) {
        int r1 = h.indexOfValue(Integer.valueOf(r2));
        if (r1 >= 0) goto L7;
        return null;
    L7:
        return (Integer) ZeusTransformUtils.preCheckCast(h.keyAt(r1), Integer.class, "com.obric.aiagent.plugin");
    }

    private final String a(TaskInfo r2) {
        if (r2 != null) goto L6;
        return "null";
    L6:
        return "task=" + r2.taskId + ", top=" + r2.topActivity + ", base=" + r2.baseActivity;
    }

    private final String g() {
        c r2 = f30165d;
        if (r2 != null) goto L7;
        return "null";
    L7:
        return "task=" + r2.b().getTaskId() + ", display=" + r2.a() + ", top=" + r2.b().getTopActivity();
    }

    private final String a(Object r3) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        Integer r0 = null;
        if (ZeusTransformUtils.instanceOf(r3, DisplayOperatingSpace.class) == false) goto L8;
        DisplayOperatingSpace r2 = (DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
    L9:
        if (r2 == null) goto L12;
        r0 = Integer.valueOf(r2.getDisplayId());
    L12:
        return r3.getClass().getSimpleName() + "(display=" + r0 + ')';
    L8:
        r2 = null;
        goto L9
    }

    private final DisplayedAppInfo a(TaskInfo r13, int r14, String r15) {
        Integer r0 = c(r13.taskId);
        com.obric.autogui.platforms.tools.display.c r1 = new com.obric.autogui.platforms.tools.display.c(r13);
        ComponentName r2 = r13.topActivity;
        if (r2 == null) goto L8;
        AOHostAppTools r6 = AOHostAppTools.INSTANCE;
        String r7 = r2.getPackageName();
        d.h.b.o.c(r7, "getPackageName(...)");
        String r3 = r2.getClassName();
        d.h.b.o.c(r3, "getClassName(...)");
        if (r6.isSelf(r7, r3) == false) goto L8;
        Loog.INSTANCE.d(TAG, "[TSL][FrontFlow] self app policy-only " + a(r13) + ", display=" + r14);
        return (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r1, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
    L8:
        Loog.INSTANCE.d(TAG, "[TSL][FrontFlow] resolve tracking for task=" + r13.taskId + ", display=" + r14);
        b r4 = a((DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r1, DisplayedAppInfo.class, "com.obric.aiagent.plugin"), r14, r15);
        if (ZeusTransformUtils.instanceOf(r4, b.a.class) == false) goto L11;
        b.a r8 = (b.a) ZeusTransformUtils.preCheckCast(r4, b.a.class, "com.obric.aiagent.plugin");
    L12:
        if (r8 == null) goto L15;
        DisplayedAppInfo r9 = r8.a();
        if (r9 == null) goto L15;
    L16:
        int r5 = r9.getTaskId();
        g.put(Integer.valueOf(r5), r9);
        Loog.INSTANCE.i(TAG, "[TSL][FrontFlow] cache appInfo task=" + r5 + ", callbackTask=" + r13.taskId + ", display=" + r14 + ", knownDisplay=" + r0 + ", tracking=" + g());
        if (ZeusTransformUtils.instanceOf(r4, b.C0805b.class) == true) goto L22;
        if (r8 == null) goto L20;
        f r10 = r8.b();
    L21:
        if (r10 != null) goto L22;
    L29:
        Loog.INSTANCE.d(TAG, "[TSL][FrontFlow] check display move for task=" + r5 + ", callbackTask=" + r13.taskId + ", display=" + r14);
        b(r5, r14);
        return r9;
    L20:
        r10 = null;
    L22:
        if (r8 == null) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == true) goto L28;
        r15 = null;
    L28:
        b(r9, r14, r15);
        goto L29
    L24:
        r11 = false;
    L15:
        r9 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r1, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        goto L16
    L11:
        r8 = null;
        goto L12
    }

    private final void b(int r11, int r12) {
        DisplayedAppInfo r0 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(g.get(Integer.valueOf(r11)), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        Loog.INSTANCE.e(TAG, "maybeMovedApp: unknown taskId=" + r11);
        return;
    L6:
        Integer r3 = c(r11);
        if (r3 != null) goto L10;
        a(r12, r11);
        Loog.INSTANCE.i(TAG, "[TSL][MoveApp] new task mapping taskId=" + r11 + ", display=" + r12 + ", appInfo=" + r0);
        return;
    L10:
        AOOperatingSpace r5 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (ZeusTransformUtils.instanceOf(r5, DisplayOperatingSpace.class) == true) goto L14;
        Loog.INSTANCE.w(TAG, "[TSL][MoveApp] ignored, activeSpace=" + a(r5) + ", taskId=" + r11 + ", knownDisplay=" + r3 + ", display=" + r12);
        return;
    L14:
        a(r12, r11);
        Loog.INSTANCE.i(TAG, "[TSL][MoveApp] taskId=" + r11 + ": " + r3 + " --> " + r12 + ", activeSpace=" + ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId() + ", tracking=" + g());
        boolean r7 = true;
        if (r3.intValue() == r12) goto L50;
        c r6 = f30165d;
        if (r6 == null) goto L23;
        DisplayedAppInfo r8 = r6.b();
        if (r8 == null) goto L23;
        if (r8.getTaskId() != r11) goto L23;
        boolean r9 = true;
    L24:
        if (r9 == false) goto L50;
        int r4 = AOSystemTools.INSTANCE.getMainDisplayId();
        String r10 = null;
        if (r12 != r4) goto L38;
        ComponentName r2 = r0.getTopActivity();
        if (r2 == null) goto L30;
        String r13 = r2.getPackageName();
    L31:
        VDTrackingApp r14 = new VDTrackingApp(r11, r13);
        Loog r15 = Loog.INSTANCE;
        StringBuilder r16 = new StringBuilder().append("[TSL][MoveApp] notify trackingAppMovedToMd taskId=").append(r11).append(", pkg=");
        ComponentName r1 = r0.getTopActivity();
        if (r1 == null) goto L34;
        r10 = r1.getPackageName();
    L34:
        r15.i(TAG, r16.append(r10).toString());
        IAutoActionVDListener r17 = h();
        if (r17 == null) goto L56;
        r17.trackingAppMovedToMd(r14);
        return;
    L56:
        return;
    L30:
        r13 = null;
        goto L31
    L38:
        if (r12 != ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId()) goto L49;
        Loog r18 = Loog.INSTANCE;
        StringBuilder r19 = new StringBuilder().append("[TSL][MoveApp] notify trackingAppMovedToVd taskId=").append(r11).append(", pkg=");
        ComponentName r20 = r0.getTopActivity();
        if (r20 == null) goto L42;
        String r21 = r20.getPackageName();
    L43:
        r18.i(TAG, r19.append(r21).toString());
        IAutoActionVDListener r110 = h();
        if (r110 == null) goto L58;
        ComponentName r22 = r0.getTopActivity();
        if (r22 == null) goto L48;
        r10 = r22.getPackageName();
    L48:
        r110.trackingAppMovedToVd(new VDTrackingApp(r11, r10));
        return;
    L58:
        return;
    L42:
        r21 = null;
        goto L43
    L49:
        Loog.INSTANCE.d(TAG, "[TSL][MoveApp] tracking moved to non-target display taskId=" + r11 + ", display=" + r12 + ", mainDisplay=" + r4 + ", active=" + ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId());
        return;
    L23:
        r9 = false;
    L50:
        Loog r23 = Loog.INSTANCE;
        StringBuilder r111 = new StringBuilder().append("[TSL][MoveApp] no tracking callback taskId=").append(r11).append(", changed=");
        if (r3.intValue() != r12) goto L54;
        r7 = false;
    L54:
        r23.d(TAG, r111.append(r7).append(", tracking=").append(g()).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final b a(DisplayedAppInfo r11, int r12, String r13) {
        DisplayedAppInfo r14 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r11, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        int r3 = 2;
        ComponentName r5 = null;
        Object[] r6 = 0;
        Object[] r7 = 0;
        Object[] r8 = 0;
        Object[] r9 = 0;
        if (ZeusTransformUtils.instanceOf(r0, DisplayOperatingSpace.class) == true) goto L7;
        Loog.INSTANCE.e(TAG, "resolveMovedToFrontTask: unknown operatingSpace=" + r0);
        return (b) ZeusTransformUtils.preCheckCast(new b.a(r14, r9 == true ? 1 : 0, r3, r8 == true ? 1 : 0), b.class, "com.obric.aiagent.plugin");
    L7:
        if (r12 == ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r0, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId()) goto L38;
        Loog.INSTANCE.d(TAG, "[TSL][TrackingApp] not update, taskId=" + r14.getTaskId() + ", display=" + r12 + ", active=" + ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r0, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayId() + ", tracking=" + g());
        return (b) ZeusTransformUtils.preCheckCast(new b.a(r14, r7 == true ? 1 : 0, r3, r6 == true ? 1 : 0), b.class, "com.obric.aiagent.plugin");
    L38:
        DisplayedAppInfo r1 = ((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r0, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).fetchTopDisplayed();     // Catch: Throwable -> L10
    L12:
        com.obric.autogui.platforms.tools.display.vd.b r2 = a(r14);
        if (r1 == null) goto L15;
        com.obric.autogui.platforms.tools.display.vd.b r10 = a(r1);
    L16:
        e r15 = com.obric.autogui.platforms.tools.display.vd.d.b(r2, r10);
        if (ZeusTransformUtils.instanceOf(r15, e.b.class) == false) goto L27;
        Loog r4 = Loog.INSTANCE;
        StringBuilder r16 = new StringBuilder().append("[TSL][TrackingApp] skip operation notification taskId=").append(r14.getTaskId()).append(", top=").append(r14.getTopActivity()).append(", display=").append(r12).append(", currentTask=");
        if (r1 == null) goto L21;
        Integer r17 = Integer.valueOf(r1.getTaskId());
    L22:
        StringBuilder r18 = r16.append(r17).append(", currentTop=");
        if (r1 == null) goto L25;
        r5 = r1.getTopActivity();
    L25:
        r4.w(TAG, r18.append(r5).append(", decision=").append(((e.b) ZeusTransformUtils.preCheckCast(r15, e.b.class, "com.obric.aiagent.plugin")).a()).append(", owner=").append(r13).toString());
        return (b) ZeusTransformUtils.preCheckCast(b.C0805b.f30185a, b.class, "com.obric.aiagent.plugin");
    L21:
        r17 = null;
        goto L22
    L27:
        d.h.b.o.a(r15, "null cannot be cast to non-null type com.obric.autogui.platforms.tools.display.vd.TaskFrontLiveTopResolution.Accepted");
        e.a r19 = (e.a) ZeusTransformUtils.preCheckCast(r15, e.a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L32;
        return (b) ZeusTransformUtils.preCheckCast(b.C0805b.f30185a, b.class, "com.obric.aiagent.plugin");
    L32:
        if (((e.a) ZeusTransformUtils.preCheckCast(r15, e.a.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.platforms.tools.display.vd.c.f30195b) goto L35;
        Loog.INSTANCE.i(TAG, "[TSL][TrackingApp] canonicalize equivalent component callbackTask=" + r14.getTaskId() + ", liveTask=" + r1.getTaskId() + ", top=" + r1.getTopActivity() + ", display=" + r12 + ", owner=" + r13);
    L35:
        return (b) ZeusTransformUtils.preCheckCast(new b.a(r1, ((e.a) ZeusTransformUtils.preCheckCast(r15, e.a.class, "com.obric.aiagent.plugin")).b()), b.class, "com.obric.aiagent.plugin");
    L15:
        r10 = null;
    L10:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[TSL][TrackingApp] failed to verify current top taskId=" + r14.getTaskId() + ", display=" + r12, th);
        r1 = null;
        goto L12
    }

    private final void b(DisplayedAppInfo r4, int r5, String r6) {
        DisplayedAppInfo r7 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r4, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "[TSL][TrackingApp] update taskId=" + r7.getTaskId() + ", display=" + r5 + ", old=" + g() + ", new=" + r7);
        f30165d = new c(r5, r7);
        Loog.INSTANCE.d(TAG, "[TSL][TrackingApp] --> " + f30165d);
        IAutoActionVDListener r3 = h();
        if (r3 == null) goto L5;
        r3.vdTaskIdChanged(r7.getTaskId());
    L5:
        if (r3 == null) goto L12;
        int r0 = r7.getTaskId();
        ComponentName r8 = r7.getTopActivity();
        if (r8 == null) goto L9;
        String r9 = r8.getPackageName();
    L10:
        r3.vdOperatingAppChanged(new VDTrackingApp(r0, r9), r6);
        return;
    L9:
        r9 = null;
        goto L10
    }

    private final com.obric.autogui.platforms.tools.display.vd.b a(DisplayedAppInfo r4) {
        DisplayedAppInfo r3 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r4, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        int r0 = r3.getTaskId();
        ComponentName r1 = r3.getTopActivity();
        String r2 = null;
        if (r1 == null) goto L5;
        String r5 = r1.getPackageName();
    L6:
        ComponentName r6 = r3.getTopActivity();
        if (r6 == null) goto L10;
        r2 = r6.getClassName();
    L10:
        return new com.obric.autogui.platforms.tools.display.vd.b(r0, r5, r2);
    L5:
        r5 = null;
        goto L6
    }

    private final void a(int r5, String r6, int r7) {
        boolean r0 = com.obric.autogui.platforms.tools.internal.a.C0812a.f30315a.a(r5, r7, true);
        Loog.INSTANCE.i(TAG, "[ETSL][MoveTask] result=" + r0 + ", taskId=" + r5 + ", pkg=" + r6 + ", targetDisplay=" + r7);
        if (r0 == false) goto L8;
        IAutoActionVDListener r4 = h();
        if (r4 == null) goto L9;
        r4.trackingAppMovedToVd(new VDTrackingApp(r5, r6));
        return;
    L9:
        return;
    }

    private final void i() {
        if (f == false) goto L29;
        return;
    L29:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L7
        VDTaskStackObserver r7 = (VDTaskStackObserver) ZeusTransformUtils.preCheckCast(this, VDTaskStackObserver.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r8 = n.f(AOPlatform.INSTANCE.getPlatform().getInformation().getRomVersion());     // Catch: Throwable -> L7
    L9:
        Throwable r2 = n.c(r8);
        if (r2 == null) goto L13;
        Loog.INSTANCE.e(TAG, "failed to get ROM version for screen-off task migration", r2);
    L13:
        if (n.b(r8) == false) goto L15;
        r8 = "";
    L15:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        if (com.obric.aiagent.product.a.c.f18771a.d(r9) >= com.obric.aiagent.product.a.c.f18771a.d("2.6.0")) goto L19;
        Loog.INSTANCE.i(TAG, "skip screen-off receiver: ROM " + r9 + " is below 2.6.0");
        return;
    L19:
        IntentFilter r10 = new IntentFilter("android.intent.action.SCREEN_OFF");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L26
        if (Build.VERSION.SDK_INT < 33) goto L23;
        ZeusTransformUtils.registerReceiver(r3, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f30166e, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r10, 4, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L26
    L24:
        f = true;     // Catch: RuntimeException -> L26
        return;
    L23:
        ZeusTransformUtils.registerReceiver(r3, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f30166e, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r10, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L26
    L26:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to register screen-off receiver", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        th = move-exception;
        n.a r4 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L9
    }

    private final void j() {
        if (f == true) goto L16;
        return;
    L16:
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(f30166e, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L8 RuntimeException -> L10
    L12:
        f = false;
        return;
    L8:
        th = move-exception;
        f = false;
        throw th;
    L10:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to unregister screen-off receiver", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        goto L12
    }

    private final TaskInfo d(int r6) {
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.autogui.platforms.tools.internal.a.b.f30316a.a(100, false, false, AOSystemTools.INSTANCE.getMainDisplayId()), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: RuntimeException -> L15
    L5:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();     // Catch: RuntimeException -> L15
        if (((TaskInfo) ZeusTransformUtils.preCheckCast(r2, TaskInfo.class, "com.obric.aiagent.plugin")).taskId != r6) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L5;
    L13:
        return (TaskInfo) ZeusTransformUtils.preCheckCast(r2, TaskInfo.class, "com.obric.aiagent.plugin");
    L9:
        r3 = false;
        goto L10
    L12:
        r2 = null;
    L15:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to query task=" + r6 + " on main display", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final boolean a(VDTrackingApp r7) {
        c r0 = f30165d;
        if (r0 == null) goto L34;
        DisplayedAppInfo r1 = r0.b();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.getTaskId() == r7.getTaskId()) goto L10;
        return false;
    L10:
        TaskInfo r2 = d(r7.getTaskId());
        if (r2 != null) goto L13;
        return false;
    L13:
        ComponentName r3 = r2.topActivity;
        if (r3 != null) goto L16;
        return false;
    L16:
        AOHostAppTools r4 = AOHostAppTools.INSTANCE;
        String r5 = r3.getPackageName();
        d.h.b.o.c(r5, "getPackageName(...)");
        String r6 = r3.getClassName();
        d.h.b.o.c(r6, "getClassName(...)");
        if (r4.isSelf(r5, r6) == false) goto L19;
        return false;
    L19:
        String r8 = r3.getPackageName();
        d.h.b.o.a(r8);
        String r9 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r8 = null;
    L23:
        if (r8 != null) goto L26;
        return false;
    L26:
        if (d.h.b.o.a(r8, r7.getPackageName()) == false) goto L35;
        IAutoActionVDListener r10 = h();
        if (r10 == null) goto L31;
        r9 = r10.getTrackingAppPkgName();
    L31:
        if (d.h.b.o.a(r8, r9) == true) goto L33;
        return false;
    L33:
        return true;
    L35:
        return false;
    L34:
        return false;
    }

    private final void k() {
        IAutoActionVDListener r0 = h();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        c r2 = f30165d;
        if (r2 == null) goto L36;
        DisplayedAppInfo r3 = r2.b();
        if (r3 == null) goto L39;
        int r4 = r3.getTaskId();
        ComponentName r5 = r3.getTopActivity();
        VDSpace r6 = null;
        if (r5 == null) goto L18;
        String r7 = r5.getPackageName();
    L19:
        VDTrackingApp r8 = new VDTrackingApp(r4, r7);
        if (f30164c.get() == true) goto L22;
        return;
    L22:
        if (a(r8) == false) goto L40;
        AOOperatingSpace r9 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (ZeusTransformUtils.instanceOf(r9, VDSpace.class) == false) goto L27;
        r6 = (VDSpace) ZeusTransformUtils.preCheckCast(r9, VDSpace.class, "com.obric.aiagent.plugin");
    L27:
        if (r6 != null) goto L29;
        return;
    L29:
        if (r6.getDisplayAccessor().isDestroyed() == true) goto L41;
        int r10 = r8.getTaskId();
        String r11 = r8.getPackageName();
        if (r11 != null) goto L34;
        r11 = "";
    L34:
        a(r10, r11, r6.getDisplayId());
        return;
    L41:
        return;
    L40:
        return;
    L18:
        r7 = null;
        goto L19
    L39:
        return;
    L36:
        return;
    L5:
        if (r0.canMoveTrackingAppToVdOnScreenOff() != true) goto L7;
        goto L7
    }

    private final IAutoActionVDListener h() {
        return (IAutoActionVDListener) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionVDListener.class), IAutoActionVDListener.class, "com.obric.aiagent.plugin");
    }
}
