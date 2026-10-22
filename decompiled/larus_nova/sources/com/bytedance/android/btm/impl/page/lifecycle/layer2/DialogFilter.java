package com.bytedance.android.btm.impl.page.lifecycle.layer2;

import android.app.Dialog;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;

/* JADX INFO: loaded from: classes43.dex */
public final class DialogFilter extends BaseFilter<Dialog> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f42292h = "DialogFilter_onCreated";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f42293i = "DialogFilter_buildPageTree";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f42294j = "DialogFilter_isResumeFiltered";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DialogFilter f42295k = null;

    static {
        f42295k = new DialogFilter();
        f42292h = "DialogFilter_onCreated";
        f42293i = "DialogFilter_buildPageTree";
        f42294j = "DialogFilter_isResumeFiltered";
    }

    public DialogFilter() {
    }

    @Override // com.bytedance.android.btm.impl.page.lifecycle.layer2.BaseFilter
    public final /* bridge */ /* synthetic */ ResumeFilterReason b(Dialog r100, ResumeFuncOrigin r101) {
        return g(r100, r101);
    }

    public final ResumeFilterReason g(Dialog r100, final ResumeFuncOrigin r101) {
        final String r102 = r100.getClass().getName();
        ALogger r103 = ALogger.f41996d;
        String r104 = f42294j;
        ALogger.f(r103, r104, new DialogFilter$isResumeFiltered$1(r102, r101));
        ResumeFilterReason r105 = super.b(r100, r101);
        if (r105 == null) goto L7;
        ALogger.f(r103, r104, new DialogFilter$isResumeFiltered$2(r102));
        return r105;
    L7:
        if (r100.isShowing() == true) goto L10;
        ALogger.f(r103, r104, new DialogFilter$isResumeFiltered$3(r102));
        return ResumeFilterReason.DialogNotShowing;
    L10:
        return null;
    }
}
