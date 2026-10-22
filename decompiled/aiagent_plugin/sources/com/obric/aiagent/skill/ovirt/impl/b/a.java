package com.obric.aiagent.skill.ovirt.impl.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActivityOVirtSettingsBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f21111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f21112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSectionTitleBar f21113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OCardListItem f21114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OSectionTitleBar f21115e;
    public final OCardListItem f;
    public final FrameLayout g;
    public final OFloatingTitleBar h;
    public final FrameLayout i;
    public final OTextView j;
    private final FrameLayout k;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private a(FrameLayout r1, LinearLayout r2, OCardListItem r3, OSectionTitleBar r4, OCardListItem r5, OSectionTitleBar r6, OCardListItem r7, FrameLayout r8, OFloatingTitleBar r9, FrameLayout r10, OTextView r11) {
        this.k = r1;
        this.f21111a = r2;
        this.f21112b = r3;
        this.f21113c = r4;
        this.f21114d = r5;
        this.f21115e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    public FrameLayout b() {
        return this.k;
    }

    public static a a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static a a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_o_virt_settings, "layout", "activity_o_virt_settings"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static a a(View r18) {
        int r1 = ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.open_app_management_item, DbHelper.COL_ID, "open_app_management_item");
        OCardListItem r9 = (OCardListItem) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.open_app_management_title, DbHelper.COL_ID, "open_app_management_title");
        OSectionTitleBar r10 = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), OSectionTitleBar.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.shell_management_item, DbHelper.COL_ID, "shell_management_item");
        OCardListItem r11 = (OCardListItem) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.shell_management_title, DbHelper.COL_ID, "shell_management_title");
        OSectionTitleBar r12 = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), OSectionTitleBar.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.skill_extension_item, DbHelper.COL_ID, "skill_extension_item");
        OCardListItem r13 = (OCardListItem) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L23;
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r18, FrameLayout.class, "com.obric.aiagent.plugin");
        r1 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r15 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.unavailable_state_container, DbHelper.COL_ID, "unavailable_state_container");
        FrameLayout r16 = (FrameLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.unavailable_state_text, DbHelper.COL_ID, "unavailable_state_text");
        OTextView r17 = (OTextView) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L23;
        return new a((FrameLayout) ZeusTransformUtils.preCheckCast(r18, FrameLayout.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r18, "com.obric.aiagent.plugin").getResourceName(r1)));
    }
}
