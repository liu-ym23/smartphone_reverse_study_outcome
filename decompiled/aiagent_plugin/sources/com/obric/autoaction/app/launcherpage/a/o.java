package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.discovery.view.InstructionAddButton;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionDiscoveryInstructionCellBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InstructionAddButton f22842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f22843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f22844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f22845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OTextView f22846e;
    private final OUIConstraintLayout f;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private o(OUIConstraintLayout r1, InstructionAddButton r2, ImageView r3, FrameLayout r4, OTextView r5, OTextView r6) {
        this.f = r1;
        this.f22842a = r2;
        this.f22843b = r3;
        this.f22844c = r4;
        this.f22845d = r5;
        this.f22846e = r6;
    }

    public OUIConstraintLayout b() {
        return this.f;
    }

    public static o a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_discovery_instruction_cell, "layout", "autoaction_discovery_instruction_cell"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static o a(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_add, DbHelper.COL_ID, "btn_add");
        InstructionAddButton r7 = (InstructionAddButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), InstructionAddButton.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.discovery_task_icon, DbHelper.COL_ID, "discovery_task_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.discovery_top_container, DbHelper.COL_ID, "discovery_top_container");
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.sub_title, DbHelper.COL_ID, "sub_title");
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE);
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L15;
        return new o((OUIConstraintLayout) ZeusTransformUtils.preCheckCast(r12, OUIConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
