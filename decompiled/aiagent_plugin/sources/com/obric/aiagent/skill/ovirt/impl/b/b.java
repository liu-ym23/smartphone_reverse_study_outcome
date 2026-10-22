package com.obric.aiagent.skill.ovirt.impl.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActivityShellManagementBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f21116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f21117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OCardListItem f21118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f21119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f21120e;
    public final OCardListItem f;
    public final OFloatingTitleBar g;
    private final FrameLayout h;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private b(FrameLayout r1, LinearLayout r2, LinearLayout r3, OCardListItem r4, FrameLayout r5, LinearLayout r6, OCardListItem r7, OFloatingTitleBar r8) {
        this.h = r1;
        this.f21116a = r2;
        this.f21117b = r3;
        this.f21118c = r4;
        this.f21119d = r5;
        this.f21120e = r6;
        this.f = r7;
        this.g = r8;
    }

    public FrameLayout b() {
        return this.h;
    }

    public static b a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static b a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_shell_management, "layout", "activity_shell_management"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static b a(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.shell_clear_container, DbHelper.COL_ID, "shell_clear_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.shell_clear_item, DbHelper.COL_ID, "shell_clear_item");
        OCardListItem r9 = (OCardListItem) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        FrameLayout r10 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14, FrameLayout.class, "com.obric.aiagent.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.shell_usage_container, DbHelper.COL_ID, "shell_usage_container");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.shell_usage_item, DbHelper.COL_ID, "shell_usage_item");
        OCardListItem r12 = (OCardListItem) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r13 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L17;
        return new b((FrameLayout) ZeusTransformUtils.preCheckCast(r14, FrameLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
