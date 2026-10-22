package com.obric.autogui.vdplayer.a;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.components.panel.PrivacyBadgeView;
import com.obric.autoaction.view.DraggableFloatingLayout;
import com.obric.oui.layout.OUIConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdComponentPanelContainerBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DraggableFloatingLayout f31604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f31605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f31606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f31607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f31608e;
    public final PrivacyBadgeView f;
    public final OUIConstraintLayout g;
    private final FrameLayout h;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private e(FrameLayout r1, DraggableFloatingLayout r2, FrameLayout r3, FrameLayout r4, FrameLayout r5, FrameLayout r6, PrivacyBadgeView r7, OUIConstraintLayout r8) {
        this.h = r1;
        this.f31604a = r2;
        this.f31605b = r3;
        this.f31606c = r4;
        this.f31607d = r5;
        this.f31608e = r6;
        this.f = r7;
        this.g = r8;
    }

    public FrameLayout b() {
        return this.h;
    }

    public static e a(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.panel_container, DbHelper.COL_ID, "panel_container");
        DraggableFloatingLayout r7 = (DraggableFloatingLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), DraggableFloatingLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.panel_expanded_auto_exit_slot, DbHelper.COL_ID, "panel_expanded_auto_exit_slot");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.panel_expanded_slot, DbHelper.COL_ID, "panel_expanded_slot");
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.panel_fab_slot, DbHelper.COL_ID, "panel_fab_slot");
        FrameLayout r10 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L17;
        FrameLayout r11 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14, FrameLayout.class, "com.obric.aiagent.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.panel_privacy_badge, DbHelper.COL_ID, "panel_privacy_badge");
        PrivacyBadgeView r12 = (PrivacyBadgeView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), PrivacyBadgeView.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.panel_slots_wrapper, DbHelper.COL_ID, "panel_slots_wrapper");
        OUIConstraintLayout r13 = (OUIConstraintLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OUIConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L17;
        return new e((FrameLayout) ZeusTransformUtils.preCheckCast(r14, FrameLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
