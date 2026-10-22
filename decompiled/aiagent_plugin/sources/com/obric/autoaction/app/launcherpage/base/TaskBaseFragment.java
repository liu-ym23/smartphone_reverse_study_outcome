package com.obric.autoaction.app.launcherpage.base;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.p;
import com.obric.autoaction.common.base.BaseFragment;
import com.obric.event.task.base.report.ActionReportSession;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: TaskBaseFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class TaskBaseFragment extends BaseFragment {
    private ActionReportSession pageEnterSession;

    /* JADX INFO: compiled from: View.kt */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f22908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskBaseFragment f22909b;

        public a(View r1, TaskBaseFragment r2) {
            this.f22908a = r1;
            this.f22909b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionReportSession r0 = TaskBaseFragment.access$getPageEnterSession$p(this.f22909b);
            if (r0 == null) goto L5;
            ActionReportSession.a(r0, null, 1, null);
        L5:
            TaskBaseFragment.access$setPageEnterSession$p(this.f22909b, null);
        }
    }

    public String getPageEnterFrom() {
        return DownloadSettingKeys.BugFix.DEFAULT;
    }

    public String getPageEnterPageName() {
        return null;
    }

    public TaskBaseFragment() {
    }

    public static final /* synthetic */ ActionReportSession access$getPageEnterSession$p(TaskBaseFragment r0) {
        return r0.pageEnterSession;
    }

    public static final /* synthetic */ void access$setPageEnterSession$p(TaskBaseFragment r0, ActionReportSession r1) {
        r0.pageEnterSession = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        startPageEnterSessionIfNeeded(r1);
    }

    private final void startPageEnterSessionIfNeeded(Bundle r9) {
        JSONObject r0 = buildPageEnterParams();
        if (r9 != null) goto L8;
        if (r0 == null) goto L9;
        ActionReportSession r10 = new ActionReportSession("obric_tech_event_task_page_enter", r0);
        ActionReportSession.a(r10, (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin"), 0, null, 6, null);
        this.pageEnterSession = r10;
        return;
    L9:
        return;
    }

    public static /* synthetic */ void reportPageEnterFail$default(TaskBaseFragment r0, String r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        r0.reportPageEnterFail(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportPageEnterFail");
    }

    public final void reportPageEnterFail(String r8, int r9) {
        o.e(r8, "errorMessage");
        ActionReportSession r1 = this.pageEnterSession;
        if (r1 == null) goto L5;
        ActionReportSession.a(r1, r9, r8, null, 4, null);
    L5:
        this.pageEnterSession = null;
    }

    private final JSONObject buildPageEnterParams() {
        String r0 = getPageEnterPageName();
        if (r0 == null) goto L5;
        JSONObject r1 = new JSONObject();
        r1.put("page_name", r0);
        r1.put("enter_from", getPageEnterFrom());
        return r1;
    L5:
        return null;
    }

    public final void reportPageEnterSuccessOnPreDraw(View r3) {
        if (r3 == null) goto L5;
        OneShotPreDrawListener.add(r3, (Runnable) ZeusTransformUtils.preCheckCast(new a(r3, this), Runnable.class, "com.obric.aiagent.plugin"));
        return;
    }
}
