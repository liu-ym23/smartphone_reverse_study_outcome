package com.obric.autogui.session;

import android.content.ComponentName;
import android.content.Context;
import com.obric.autoaction.BuildConfig;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import d.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StartInPlaceTaskCandidateResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "StartInPlaceTaskRes";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f30963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f30964b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, Set<String>> f30965c = null;

    private e() {
    }

    static {
        f30963a = new e();
        f30964b = ax.a(new String[]{"com.larus.mcp", BuildConfig.LIBRARY_PACKAGE_NAME, "com.android.launcher3", "com.miui.home"});
        f30965c = ao.a(s.a("com.larus.nova", ax.a("com.obric.miniapp.view.CalendarMiniAppActivity")));
    }

    public final DisplayedAppInfo a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        boolean r8 = AssistantAbilityHelper.INSTANCE.queryChatPageState(r7).isFullScreen();
        Collection<? extends DisplayedAppInfo> r0 = IAutoActionVDApi.DefaultImpls.fetchMdTopAppInfo$default((IAutoActionVDApi) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE, IAutoActionVDApi.class, "com.obric.aiagent.plugin"), 2, false, 2, null);
        if (r0 != null) goto L6;
        Loog.INSTANCE.i(TAG, " - [BringTask] failed to fetch top task - not fetched.");
        return null;
    L6:
        Loog.INSTANCE.i(TAG, " - [BringTask] resolving candidate, assistantFullScreen=" + r8 + ", topTasks=" + r0);
        return a(r0, r8);
    }

    public final DisplayedAppInfo a(Collection<? extends DisplayedAppInfo> r9, boolean r10) {
        Collection r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.aiagent.plugin");
        o.e(r11, "topTasks");
        Iterator r12 = r11.iterator();
        DisplayedAppInfo r1 = null;
    L4:
        if (r12.hasNext() == false) goto L31;
        DisplayedAppInfo r2 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r12.next(), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        ComponentName r4 = r2.getRealActivity();
        if (r4 == null) goto L9;
        String r5 = r4.getPackageName();
        if (r5 == null) goto L9;
    L13:
        ComponentName r6 = r2.getTopActivity();
        if (r6 == null) goto L16;
        String r7 = r6.getPackageName();
    L18:
        if (o.a(r5, r7) == true) goto L25;
        Loog r8 = Loog.INSTANCE;
        StringBuilder r13 = new StringBuilder().append(" - [BringTask] warning: task-package=").append(r5).append(" != top-package=");
        ComponentName r14 = r2.getTopActivity();
        if (r14 == null) goto L22;
        String r15 = r14.getPackageName();
    L23:
        r8.d(TAG, r13.append(r15).toString());
        goto L25
    L22:
        r15 = null;
    L25:
        if (a(r2) == true) goto L4;
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(f30964b, Iterable.class, "com.obric.aiagent.plugin"), r5) == true) goto L29;
        r1 = r2;
        goto L4
    L29:
        Loog.INSTANCE.d(TAG, " - [BringTask] filtered-out task=" + r2);
        goto L31
    L16:
        r7 = null;
    L9:
        ComponentName r16 = r2.getTopActivity();
        if (r16 == null) goto L12;
        r5 = r16.getPackageName();
        goto L13
    L12:
        r5 = null;
    L31:
        if (r1 == null) goto L33;
        Loog.INSTANCE.i(TAG, " - [BringTask] remembered topTask=" + r1);
    L33:
        return r1;
    }

    private final boolean a(DisplayedAppInfo r5) {
        ComponentName r4 = ((DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r5, DisplayedAppInfo.class, "com.obric.aiagent.plugin")).getTopActivity();
        if (r4 == null) goto L14;
        Map<String, Set<String>> r1 = f30965c;
        if (r1.containsKey(r4.getPackageName()) == false) goto L14;
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(r1.get(r4.getPackageName()), Set.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L12:
        Loog.INSTANCE.d(TAG, " - [BringTask] JumpingPkg(" + r4.getPackageName() + ").");
        return true;
    L9:
        if (r0.contains(r4.getClassName()) == false) goto L12;
        Loog.INSTANCE.d(TAG, " - [BringTask] JumpingPkg(" + r4.getPackageName() + ") with exemptedPkg=" + r4.getClassName() + '.');
        return false;
    L14:
        return false;
    }
}
