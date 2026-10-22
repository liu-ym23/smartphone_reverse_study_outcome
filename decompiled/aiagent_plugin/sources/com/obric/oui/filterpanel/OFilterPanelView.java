package com.obric.oui.filterpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: OFilterPanelView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OFilterPanelView extends ConstraintLayout {
    private final OButton btnConfirm;
    private final LinearLayout btnContainer;
    private final OButton btnReset;
    private final LinearLayout filterGroupContainer;
    private final Set<OFilterGroupView> filterGroupViewList;
    private int filterStyle;
    private int maxSelectCount;

    /* JADX WARN: Multi-variable type inference failed */
    public OFilterPanelView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OFilterPanelView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OFilterPanelView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        this.filterGroupViewList = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        this.maxSelectCount = 1;
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_layout_filter_panel_view, "layout", "o_layout_filter_panel_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setLayoutParams(new ViewGroup.LayoutParams(-1, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 400)));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.filter_group_container, DbHelper.COL_ID, "filter_group_container"));
        o.c(r8, "findViewById(R.id.filter_group_container)");
        this.filterGroupContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r8, LinearLayout.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_container, DbHelper.COL_ID, "btn_container"));
        o.c(r9, "findViewById(R.id.btn_container)");
        this.btnContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_reset, DbHelper.COL_ID, "btn_reset"));
        o.c(r10, "findViewById(R.id.btn_reset)");
        this.btnReset = (OButton) ZeusTransformUtils.preCheckCast(r10, OButton.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_confirm, DbHelper.COL_ID, "btn_confirm"));
        o.c(r11, "findViewById(R.id.btn_confirm)");
        this.btnConfirm = (OButton) ZeusTransformUtils.preCheckCast(r11, OButton.class, "com.obric.aiagent.plugin");
    }

    public final void addFilterGroup(OFilterGroupView r4) {
        o.e(r4, "view");
        this.filterGroupContainer.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        this.filterGroupViewList.add(r4);
    }

    public final OFilterGroupView addFilterGroup(OFilterGroupView.a r7) {
        o.e(r7, "config");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        OFilterGroupView r0 = new OFilterGroupView(r1, null, 2, null);
        Integer r2 = r7.b();
        if (r2 != null) goto L5;
        int r3 = this.filterStyle;
    L6:
        OFilterGroupView.setFilterStyle$default(r0, r3, false, 2, null);
        r0.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.aiagent.plugin"));
        Integer r4 = r7.c();
        if (r4 != null) goto L9;
        int r5 = this.maxSelectCount;
    L10:
        r0.setMaxSelectCount(r5);
        List<String> r6 = r7.f();
        if (r6 != null) goto L13;
        r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L13:
        r0.setFilterItems(r6, r7.d(), r7.g());
        if (r7.e() == null) goto L16;
        Integer r8 = r7.e();
        o.a(r8);
        r0.select(r8.intValue());
    L16:
        r0.setEnableClickWhenSelected(r7.h());
        addFilterGroup(r0);
        return r0;
    L9:
        r5 = r4.intValue();
        goto L10
    L5:
        r3 = r2.intValue();
        goto L6
    }

    public static /* synthetic */ void setFilterStyle$default(OFilterPanelView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setFilterStyle(r1, r2);
    }

    public final void setFilterStyle(int r4, boolean r5) {
        this.filterStyle = r4;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filterGroupViewList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((OFilterGroupView) ZeusTransformUtils.preCheckCast(r3.next(), OFilterGroupView.class, "com.obric.aiagent.plugin")).setFilterStyle(r4, r5);
        goto L4
    }

    public final void setMaxSelectCount(int r1) {
        this.maxSelectCount = r1;
    }

    public final OButton getResetBtn() {
        return this.btnReset;
    }

    public final OButton getConfirmBtn() {
        return this.btnConfirm;
    }

    public final Set<OFilterGroupView> getFilterGroupViewSet() {
        return this.filterGroupViewList;
    }

    public final LinearLayout getFilterGroupContainer() {
        return this.filterGroupContainer;
    }
}
