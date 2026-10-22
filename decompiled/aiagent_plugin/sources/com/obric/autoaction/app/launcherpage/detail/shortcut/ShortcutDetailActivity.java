package com.obric.autoaction.app.launcherpage.detail.shortcut;

import androidx.fragment.app.Fragment;
import com.obric.autoaction.app.launcherpage.detail.base.BaseDetailActivity;
import com.obric.autoaction.app.launcherpage.detail.shortcut.fragment.ShortcutCreateFragmentV2;
import com.obric.autoaction.app.launcherpage.detail.shortcut.fragment.ShortcutDetailFragmentV2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ShortcutDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutDetailActivity extends BaseDetailActivity {
    public static final a Companion = null;
    private static final String DETAIL_PAGE_NAME = "shortcut_task_detail";

    /* JADX INFO: compiled from: ShortcutDetailActivity.kt */
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

    public static /* synthetic */ x lambda$dea3FhRey3vlivHN3KDM41quYhU(com.obric.autoaction.common.base.a r0) {
        return configExtension$lambda$0(r0);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public b<com.obric.autoaction.common.base.a, x> configExtension() {
        return $$Lambda$ShortcutDetailActivity$dea3FhRey3vlivHN3KDM41quYhU.INSTANCE;
    }

    public ShortcutDetailActivity() {
    }

    private static final x configExtension$lambda$0(com.obric.autoaction.common.base.a r5) {
        o.e(r5, "<this>");
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b(DETAIL_PAGE_NAME, false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseDetailActivity
    public Fragment createFragment() {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(getIntent().getStringExtra("key_task_id"), CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        return (Fragment) ZeusTransformUtils.preCheckCast(new ShortcutCreateFragmentV2(), Fragment.class, "com.obric.aiagent.plugin");
    L12:
        return (Fragment) ZeusTransformUtils.preCheckCast(new ShortcutDetailFragmentV2(), Fragment.class, "com.obric.aiagent.plugin");
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
