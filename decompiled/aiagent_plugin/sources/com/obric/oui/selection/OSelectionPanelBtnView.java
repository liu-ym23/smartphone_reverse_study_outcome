package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OSelectionPanelBtnView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSelectionPanelBtnView extends ConstraintLayout {
    private final OButton btnNegative;
    private final OButton btnPositive;
    private final View horizontal_space;

    /* JADX WARN: Multi-variable type inference failed */
    public OSelectionPanelBtnView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OSelectionPanelBtnView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OSelectionPanelBtnView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_widget_selection_panel_btns, "layout", "o_widget_selection_panel_btns"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_negative, DbHelper.COL_ID, "btn_negative"));
        o.c(r8, "findViewById(R.id.btn_negative)");
        this.btnNegative = (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_positive, DbHelper.COL_ID, "btn_positive"));
        o.c(r9, "findViewById(R.id.btn_positive)");
        this.btnPositive = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.horizontal_space, DbHelper.COL_ID, "horizontal_space"));
        o.c(r10, "findViewById(R.id.horizontal_space)");
        this.horizontal_space = r10;
    }

    public final OButton getBtnNegative() {
        return this.btnNegative;
    }

    public final OButton getBtnPositive() {
        return this.btnPositive;
    }

    public final View getHorizontal_space() {
        return this.horizontal_space;
    }
}
