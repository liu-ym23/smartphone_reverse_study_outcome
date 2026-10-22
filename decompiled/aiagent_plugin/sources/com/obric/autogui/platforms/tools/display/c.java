package com.obric.autogui.platforms.tools.display;

import android.app.ActivityManager;
import android.app.TaskInfo;
import android.content.ComponentName;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StandardDisplayedAppInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements DisplayedAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f30157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f30158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComponentName f30159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ComponentName f30160e;
    private final String f;
    private final CharSequence g;

    public c(TaskInfo r3) {
        o.e(r3, "taskInfo");
        this.f30156a = r3.taskId;
        this.f30157b = r3.isVisible();
        this.f30158c = r3.topActivity;
        this.f30159d = r3.baseActivity;
        this.f30160e = com.obric.autogui.platforms.tools.internal.a.e.f30325a.a(r3);
        this.f = r3.baseIntent.getDataString();
        ActivityManager.TaskDescription r4 = r3.taskDescription;
        if (r4 == null) goto L5;
        String r5 = r4.getLabel();
    L6:
        this.g = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayedAppInfo
    public int getTaskId() {
        return this.f30156a;
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayedAppInfo
    public boolean isVisible() {
        return this.f30157b;
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayedAppInfo
    public ComponentName getTopActivity() {
        return this.f30158c;
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayedAppInfo
    public ComponentName getBaseActivity() {
        return this.f30159d;
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayedAppInfo
    public ComponentName getRealActivity() {
        return this.f30160e;
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayedAppInfo
    public String getData() {
        return this.f;
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayedAppInfo
    public CharSequence getTaskLabel() {
        return this.g;
    }

    public String toString() {
        return "DispApp[" + getTaskId() + "](v=" + isVisible() + ", t=" + getTopActivity() + ", b=" + getBaseActivity() + ", dat=" + getData() + ", lbl=" + getTaskLabel() + ']';
    }
}
