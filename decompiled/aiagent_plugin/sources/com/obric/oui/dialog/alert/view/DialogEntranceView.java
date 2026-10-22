package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DialogEntranceView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DialogEntranceView extends ConstraintLayout {
    private final ImageView ivIcon;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public DialogEntranceView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DialogEntranceView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public DialogEntranceView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_layout_dialog_entrance, "layout", "o_layout_dialog_entrance"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_normal, DbHelper.COL_ID, "tv_normal"));
        o.c(r8, "findViewById(R.id.tv_normal)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon"));
        o.c(r9, "findViewById(R.id.icon)");
        this.ivIcon = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.aiagent.plugin");
    }

    public final TextView getTextView() {
        return this.tvTitle;
    }

    public final ImageView getImageView() {
        return this.ivIcon;
    }
}
