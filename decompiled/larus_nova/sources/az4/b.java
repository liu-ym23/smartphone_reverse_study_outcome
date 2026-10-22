package az4;

import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.document.onboarding.c;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends com.bytedance.ee.bear.document.onboarding.b {
    @Override // tk5.d
    public final String getBiz() {
        return "doc";
    }

    @Override // tk5.d
    public final String getId() {
        return "mobile_doc_todocenter_intro";
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final c r100, OnBoardingData r101) {
        tt5.a.h("OnBoardingManager", "show DocTodoCenterMission");
        if (r100.f220706h.findViewWithTag(ToolbarPrimaryItemId.mention.name()) == null) goto L6;
        j.d(new a(this, r100), 200);
        return true;
    L6:
        com.bytedance.ee.bear.document.onboarding.a.C3144a.f220702a.a(this);
        return false;
    }
}
