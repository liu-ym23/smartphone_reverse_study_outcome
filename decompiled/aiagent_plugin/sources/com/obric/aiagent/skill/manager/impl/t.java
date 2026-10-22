package com.obric.aiagent.skill.manager.impl;

import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.TrackingReportTarget;
import org.json.JSONObject;

/* JADX INFO: compiled from: SkillTrackingReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f20166a = null;

    static {
        f20166a = new t();
    }

    private t() {
    }

    @Override // com.obric.aiagent.skill.manager.impl.he
    public void a(String r7, JSONObject r8) {
        d.h.b.o.e(r7, "event");
        d.h.b.o.e(r8, "params");
        AOBizTracking.INSTANCE.reportEvent(r7, r8, false, false, TrackingReportTarget.DEFAULT);
    }
}
