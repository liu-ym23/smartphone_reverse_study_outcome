package com.obric.autoaction.app.launcherpage.detail.condition;

import androidx.fragment.app.Fragment;
import com.obric.autoaction.app.launcherpage.detail.base.BaseDetailActivity;
import com.obric.autoaction.app.launcherpage.detail.condition.fragment.ConditionCreateFragmentV2;
import com.obric.autoaction.app.launcherpage.detail.condition.fragment.ConditionEventDetailFragmentV2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ConditionEventDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConditionEventDetailActivity extends BaseDetailActivity {
    public static final a Companion = null;
    private static final String DETAIL_PAGE_NAME = "condition_task_detail";

    /* JADX INFO: compiled from: ConditionEventDetailActivity.kt */
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

    public static /* synthetic */ x lambda$DOkhKuvrzHADbT0eIcc6wY1A5tc(com.obric.autoaction.common.base.a r0) {
        return configExtension$lambda$0(r0);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return $$Lambda$ConditionEventDetailActivity$DOkhKuvrzHADbT0eIcc6wY1A5tc.INSTANCE;
    }

    public ConditionEventDetailActivity() {
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseDetailActivity
    public Fragment createFragment() {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(getIntent().getStringExtra("key_task_id"), CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        return (Fragment) ZeusTransformUtils.preCheckCast(new ConditionCreateFragmentV2(), Fragment.class, "com.obric.aiagent.plugin");
    L12:
        return (Fragment) ZeusTransformUtils.preCheckCast(new ConditionEventDetailFragmentV2(), Fragment.class, "com.obric.aiagent.plugin");
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private static final x configExtension$lambda$0(com.obric.autoaction.common.base.a r5) {
        o.e(r5, "<this>");
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b(DETAIL_PAGE_NAME, false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }
}
