package com.obric.autoaction.app.launcherpage.base;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.p;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.event.task.base.report.ActionReportSession;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseTaskHistoryActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public class BaseTaskHistoryActivity extends BaseActivity {
    private ActionReportSession pageEnterSession;

    /* JADX INFO: compiled from: View.kt */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f22906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseTaskHistoryActivity f22907b;

        public a(View r3, BaseTaskHistoryActivity r4) {
            BaseTaskHistoryActivity r5 = (BaseTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r4, BaseTaskHistoryActivity.class, "com.obric.aiagent.plugin");
            this.f22906a = r3;
            this.f22907b = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionReportSession r0 = BaseTaskHistoryActivity.access$getPageEnterSession$p(this.f22907b);
            if (r0 == null) goto L5;
            ActionReportSession.a(r0, null, 1, null);
        L5:
            BaseTaskHistoryActivity.access$setPageEnterSession$p(this.f22907b, null);
        }
    }

    public String getPageEnterFrom() {
        return DownloadSettingKeys.BugFix.DEFAULT;
    }

    public String getPageEnterPageName() {
        return null;
    }

    public BaseTaskHistoryActivity() {
    }

    public static final /* synthetic */ ActionReportSession access$getPageEnterSession$p(BaseTaskHistoryActivity r2) {
        return ((BaseTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseTaskHistoryActivity.class, "com.obric.aiagent.plugin")).pageEnterSession;
    }

    public static final /* synthetic */ void access$setPageEnterSession$p(BaseTaskHistoryActivity r2, ActionReportSession r3) {
        ((BaseTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseTaskHistoryActivity.class, "com.obric.aiagent.plugin")).pageEnterSession = r3;
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        startPageEnterSessionIfNeeded(r1);
    }

    public static /* synthetic */ void reportPageEnterFail$default(BaseTaskHistoryActivity r2, String r3, int r4, int r5, Object r6) {
        BaseTaskHistoryActivity r7 = (BaseTaskHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseTaskHistoryActivity.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = 1;
    L7:
        r7.reportPageEnterFail(r3, r4);
        return;
    L10:
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
