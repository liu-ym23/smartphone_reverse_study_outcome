package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionTaskListItemEventTaskManagementBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ah implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSwitch f22734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f22735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f22736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f22737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f22738e;
    public final OTextView f;
    public final OTextView g;
    private final OUICardConstraintLayout h;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ah(OUICardConstraintLayout r1, OSwitch r2, FrameLayout r3, View r4, OTextView r5, ImageView r6, OTextView r7, OTextView r8) {
        this.h = r1;
        this.f22734a = r2;
        this.f22735b = r3;
        this.f22736c = r4;
        this.f22737d = r5;
        this.f22738e = r6;
        this.f = r7;
        this.g = r8;
    }

    public OUICardConstraintLayout b() {
        return this.h;
    }

    public static ah a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_task_list_item_event_task_management, "layout", "autoaction_task_list_item_event_task_management"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ah a(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_switch, DbHelper.COL_ID, "btn_switch");
        OSwitch r7 = (OSwitch) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OSwitch.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.btn_switch_container, DbHelper.COL_ID, "btn_switch_container");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_divider, DbHelper.COL_ID, "condition_divider");
        View r9 = r14.findViewById(r0);
        if (r9 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.condition_text, DbHelper.COL_ID, "condition_text");
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.semantic_icon, DbHelper.COL_ID, "semantic_icon");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.tag, DbHelper.COL_ID, "tag");
        OTextView r12 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.txt_tli_task_query, DbHelper.COL_ID, "txt_tli_task_query");
        OTextView r13 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L19;
        return new ah((OUICardConstraintLayout) ZeusTransformUtils.preCheckCast(r14, OUICardConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
