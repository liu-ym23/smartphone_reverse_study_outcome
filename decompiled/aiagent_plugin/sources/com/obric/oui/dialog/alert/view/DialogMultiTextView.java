package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DialogMultiTextView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DialogMultiTextView extends ConstraintLayout {
    private final OTextView tvContent;

    /* JADX WARN: Multi-variable type inference failed */
    public DialogMultiTextView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DialogMultiTextView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public DialogMultiTextView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_layout_dialog_multi_text, "layout", "o_layout_dialog_multi_text"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_content, DbHelper.COL_ID, "tv_content"));
        o.c(r8, "findViewById(R.id.tv_content)");
        OTextView r9 = (OTextView) ZeusTransformUtils.preCheckCast(r8, OTextView.class, "com.obric.aiagent.plugin");
        this.tvContent = r9;
        r9.setLineHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20));
    }

    public final OTextView getContentTextView() {
        return this.tvContent;
    }
}
