package com.obric.autogui.vdplayer.a;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.legacy.components.panel.PrivacyBadgeView;
import com.obric.autoaction.view.legacy.DraggableFloatingLayout;
import com.obric.oui.layout.OUIConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VdLegacyComponentPanelContainerBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DraggableFloatingLayout f31624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f31625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f31626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f31627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PrivacyBadgeView f31628e;
    public final OUIConstraintLayout f;
    private final DraggableFloatingLayout g;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private j(DraggableFloatingLayout r1, DraggableFloatingLayout r2, FrameLayout r3, FrameLayout r4, FrameLayout r5, PrivacyBadgeView r6, OUIConstraintLayout r7) {
        this.g = r1;
        this.f31624a = r2;
        this.f31625b = r3;
        this.f31626c = r4;
        this.f31627d = r5;
        this.f31628e = r6;
        this.f = r7;
    }

    public DraggableFloatingLayout b() {
        return this.g;
    }

    public static j a(View r10) {
        DraggableFloatingLayout r4 = (DraggableFloatingLayout) ZeusTransformUtils.preCheckCast(r10, DraggableFloatingLayout.class, "com.obric.aiagent.plugin");
        int r0 = ZeusTransformUtils.mapRes(R.id.panel_expanded_auto_exit_slot, DbHelper.COL_ID, "panel_expanded_auto_exit_slot");
        FrameLayout r5 = (FrameLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.panel_expanded_slot, DbHelper.COL_ID, "panel_expanded_slot");
        FrameLayout r6 = (FrameLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.panel_fab_slot, DbHelper.COL_ID, "panel_fab_slot");
        FrameLayout r7 = (FrameLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.panel_privacy_badge, DbHelper.COL_ID, "panel_privacy_badge");
        PrivacyBadgeView r8 = (PrivacyBadgeView) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), PrivacyBadgeView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.panel_slots_wrapper, DbHelper.COL_ID, "panel_slots_wrapper");
        OUIConstraintLayout r9 = (OUIConstraintLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(r0), OUIConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        return new j((DraggableFloatingLayout) ZeusTransformUtils.preCheckCast(r10, DraggableFloatingLayout.class, "com.obric.aiagent.plugin"), r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
