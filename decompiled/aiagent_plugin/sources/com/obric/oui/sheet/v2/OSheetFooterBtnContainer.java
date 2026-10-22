package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.obric.oui.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OSheetFooterBtnContainer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSheetFooterBtnContainer extends LinearLayout {
    private OButton btnNegative;
    private OButton btnPositive;
    private View horizontal_space;

    /* JADX WARN: Multi-variable type inference failed */
    public OSheetFooterBtnContainer(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OSheetFooterBtnContainer(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OSheetFooterBtnContainer(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        int r9 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_large_1, "dimen", "oui_p_container_large_1"));
        setPadding(r9, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8), r9, 0);
    }

    public final OButton getBtnNegative() {
        return this.btnNegative;
    }

    public final void setBtnNegative(OButton r1) {
        this.btnNegative = r1;
    }

    public final OButton getBtnPositive() {
        return this.btnPositive;
    }

    public final void setBtnPositive(OButton r1) {
        this.btnPositive = r1;
    }

    public final View getHorizontal_space() {
        return this.horizontal_space;
    }

    public final void setHorizontal_space(View r1) {
        this.horizontal_space = r1;
    }

    public static /* synthetic */ void setButtons$default(OSheetFooterBtnContainer r9, Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15, int r16, Object r17) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r16 & 2) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r7 = true;
    L10:
        r9.setButtons(r10, r4, r5, r13, r7, r8);
        return;
    L9:
        r7 = r14;
        goto L10
    L5:
        r4 = r11;
        goto L7
    }

    public final void setButtons(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L5;
        String r3 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r10.intValue());
    L6:
        if (r13 == null) goto L8;
        String r6 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r13.intValue());
    L9:
        setButtons(r3, r11, r5, r6, r14, r8);
        return;
    L8:
        r6 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public static /* synthetic */ void setButtons$default(OSheetFooterBtnContainer r9, String r10, boolean r11, View.OnClickListener r12, String r13, boolean r14, View.OnClickListener r15, int r16, Object r17) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r16 & 2) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r7 = true;
    L10:
        r9.setButtons(r10, r4, r5, r13, r7, r8);
        return;
    L9:
        r7 = r14;
        goto L10
    L5:
        r4 = r11;
        goto L7
    }

    public final void setButtons(String r6, boolean r7, View.OnClickListener r8, String r9, boolean r10, View.OnClickListener r11) {
        View.OnClickListener r12 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r13 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r11, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        char r14 = 0;
    L18:
        if (r14 <= 0) goto L27;
        View r15 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.horizontal_space = r15;
        addView(r15);
        View r16 = this.horizontal_space;
        if (r16 == null) goto L23;
        i.a(r16, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12));
    L23:
        View r17 = this.horizontal_space;
        if (r17 == null) goto L27;
        i.b(r17, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 1));
    L27:
        if (r9 == null) goto L42;
        setBtnPositive(createButton(r10));
        OButton r18 = getBtnPositive();
        if (r18 == null) goto L33;
        r18.setId(ZeusTransformUtils.mapRes(R.id.btn_positive, DbHelper.COL_ID, "btn_positive"));
    L33:
        OButton r19 = getBtnPositive();
        if (r19 == null) goto L37;
        r19.setOnClickListener(r13);
    L37:
        OButton r5 = getBtnPositive();
        if (r5 == null) goto L43;
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L43:
        return;
    L42:
        return;
    L5:
        setBtnNegative(createButton(r7));
        OButton r20 = getBtnNegative();
        if (r20 == null) goto L9;
        r20.setId(ZeusTransformUtils.mapRes(R.id.btn_negative, DbHelper.COL_ID, "btn_negative"));
    L9:
        OButton r21 = getBtnNegative();
        if (r21 == null) goto L13;
        r21.setOnClickListener(r12);
    L13:
        OButton r22 = getBtnNegative();
        if (r22 == null) goto L17;
        r22.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
    L17:
        r14 = 1;
        goto L18
    }

    public final OButton createButton(boolean r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r5 == false) goto L5;
        int r6 = R.layout.oui_widget_panel_primary_btn;
        String r3 = "oui_widget_panel_primary_btn";
    L6:
        View r4 = LinearLayout.inflate(r0, ZeusTransformUtils.mapRes(r6, "layout", r3), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
        View r8 = r7.getChildAt(r7.getChildCount() - 1);
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        return (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.aiagent.plugin");
    L5:
        r6 = R.layout.oui_widget_panel_netural_btn;
        r3 = "oui_widget_panel_netural_btn";
        goto L6
    }
}
