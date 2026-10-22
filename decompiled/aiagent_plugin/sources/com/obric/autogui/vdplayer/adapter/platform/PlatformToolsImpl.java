package com.obric.autogui.vdplayer.adapter.platform;

import android.app.TaskInfo;
import android.content.Context;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.e;
import com.obric.autogui.session.c.b;
import com.obric.autogui.vdplayer.api.fws.IPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlatformToolsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformToolsImpl implements IPlatformTools {
    public static final a Companion = null;
    private static final String TAG = "PlatformToolsImpl";

    /* JADX INFO: compiled from: PlatformToolsImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public PlatformToolsImpl() {
    }

    @Override // com.obric.autogui.vdplayer.api.fws.IPlatformTools
    public void startAppOnMainDisplay(Context r9, IAutoActionAgentEventListener.OperatingAppInfo r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        if (r10 != null) goto L7;
        Loog.INSTANCE.d(TAG, "startAppOnMainDisplay, executingApp is null");
        return;
    L7:
        if (r10.getTaskId() > 0) goto L9;
    L14:
        Loog.INSTANCE.e(TAG, "startAppOnMainDisplay, task unavailable; opening (" + r10.getPackageName() + ')');
        AOPackagesTools.INSTANCE.openAppOnMainDisplay(r11, r10.getPackageName());
        return;
    L9:
        if (bringTaskToMainDisplay(r10.getTaskId()).g() == false) goto L14;
        if (isTaskOnMainDisplay(r10.getTaskId()) == false) goto L14;
        Loog.INSTANCE.d(TAG, "startAppOnMainDisplay, brought (" + r10.getTaskId() + "), isTaskIdChanged=" + r10.isTaskIdChanged());
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("case_type", "bring_to_md_front");
        r2.put("string_value", "pkg=" + r10.getPackageName() + "; isTaskIdChanged=" + r10.isTaskIdChanged());
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "technical_recorded_case", r2, false, false, null, 28, null);
    }

    @Override // com.obric.autogui.vdplayer.api.fws.IPlatformTools
    public void putSessionInfo(JSONObject r1, IAutoActionAgentEventListener.SessionInfo r2) {
        o.e(r1, "jsonObject");
        o.e(r2, "sessionInfo");
        b.a(r1, r2);
    }

    private final e bringTaskToMainDisplay(int r3) {
        Loog.INSTANCE.d(TAG, " - bringing lastTask: " + r3);
        return AutoActionVirtualDisplay.INSTANCE.bringTaskToMdFront(r3);
    }

    private final boolean isTaskOnMainDisplay(int r6) {
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(AOPlatformTools.INSTANCE.special().getTasks(100, false, false, 0), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L6;
    L8:
        Iterator r2 = r1.iterator();     // Catch: Exception -> L19
    L9:
        if (r2.hasNext() == false) goto L31;
        TaskInfo r3 = (TaskInfo) ZeusTransformUtils.preCheckCast(r2.next(), TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        if (r3.taskId == r6) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L9;
        return true;
    L14:
        if (r3.isRunning == false) goto L16;
        r4 = true;
        goto L17
    L31:
        return false;
    L6:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L8;
        return false;
    L19:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "Failed to find task " + r6 + " on MainDisplay", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }
}
