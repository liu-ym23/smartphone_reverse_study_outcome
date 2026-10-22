package com.obric.aiagent.skill.ovirt.impl.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActivitySkillOpenAppManagementBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f21121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f21122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f21123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OCardListItem f21124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OCardListItem f21125e;
    public final OCardListItem f;
    public final OButton g;
    public final FrameLayout h;
    public final OFloatingTitleBar i;
    private final FrameLayout j;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private c(FrameLayout r1, LinearLayout r2, LinearLayout r3, LinearLayout r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OButton r8, FrameLayout r9, OFloatingTitleBar r10) {
        this.j = r1;
        this.f21121a = r2;
        this.f21122b = r3;
        this.f21123c = r4;
        this.f21124d = r5;
        this.f21125e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public FrameLayout b() {
        return this.j;
    }

    public static c a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static c a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_skill_open_app_management, "layout", "activity_skill_open_app_management"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static c a(View r17) {
        int r1 = ZeusTransformUtils.mapRes(R.id.account_info_container, DbHelper.COL_ID, "account_info_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.debug_entry_container, DbHelper.COL_ID, "debug_entry_container");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.feishu_account_item, DbHelper.COL_ID, "feishu_account_item");
        OCardListItem r11 = (OCardListItem) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.feishu_app_id_item, DbHelper.COL_ID, "feishu_app_id_item");
        OCardListItem r12 = (OCardListItem) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.feishu_config_item, DbHelper.COL_ID, "feishu_config_item");
        OCardListItem r13 = (OCardListItem) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L21;
        r1 = ZeusTransformUtils.mapRes(R.id.feishu_logout_button, DbHelper.COL_ID, "feishu_logout_button");
        OButton r14 = (OButton) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L21;
        FrameLayout r15 = (FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.aiagent.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r16 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L21;
        return new c((FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.aiagent.plugin").getResourceName(r1)));
    }
}
