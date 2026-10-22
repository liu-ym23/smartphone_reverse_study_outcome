package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionKnowledgePageLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class aa implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f22701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCardListItem f22702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OBottomActionBarFloating f22703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f22704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OTextView f22705e;
    public final OCardListItem f;
    public final OFloatingTitleBar g;
    private final ConstraintLayout h;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private aa(ConstraintLayout r1, OTextView r2, OCardListItem r3, OBottomActionBarFloating r4, LinearLayout r5, OTextView r6, OCardListItem r7, OFloatingTitleBar r8) {
        this.h = r1;
        this.f22701a = r2;
        this.f22702b = r3;
        this.f22703c = r4;
        this.f22704d = r5;
        this.f22705e = r6;
        this.f = r7;
        this.g = r8;
    }

    public ConstraintLayout b() {
        return this.h;
    }

    public static aa a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_knowledge_page_layout, "layout", "autoaction_knowledge_page_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static aa a(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.auto_learn_desc, DbHelper.COL_ID, "auto_learn_desc");
        OTextView r7 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.auto_learn_item, DbHelper.COL_ID, "auto_learn_item");
        OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.knowledge_bottom_button_group, DbHelper.COL_ID, "knowledge_bottom_button_group");
        OBottomActionBarFloating r9 = (OBottomActionBarFloating) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OBottomActionBarFloating.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.knowledge_content, DbHelper.COL_ID, "knowledge_content");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.knowledge_detail_title, DbHelper.COL_ID, "knowledge_detail_title");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.knowledge_input_card, DbHelper.COL_ID, "knowledge_input_card");
        OCardListItem r12 = (OCardListItem) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OCardListItem.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.title_bar, DbHelper.COL_ID, "title_bar");
        OFloatingTitleBar r13 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L19;
        return new aa((ConstraintLayout) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.class, "com.obric.aiagent.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
