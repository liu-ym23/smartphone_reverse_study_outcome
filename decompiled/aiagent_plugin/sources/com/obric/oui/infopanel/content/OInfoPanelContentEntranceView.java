package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OInfoPanelContentEntranceView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OInfoPanelContentEntranceView extends ConstraintLayout {
    private final ViewGroup entranceContainer;
    private final ImageView ivJump;
    private final TextView tvEntrance;

    /* JADX WARN: Multi-variable type inference failed */
    public OInfoPanelContentEntranceView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void lambda$s9JNiBKgUHBCRYrwYKA70RgyFxk(OInfoPanelContentEntranceView r0) {
        m1099onAttachedToWindow$lambda1(r0);
    }

    public /* synthetic */ OInfoPanelContentEntranceView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OInfoPanelContentEntranceView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_info_panel_content_entrance_view, "layout", "o_info_panel_content_entrance_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        ViewGroup.MarginLayoutParams r8 = new ViewGroup.MarginLayoutParams(-1, -2);
        r8.setMargins(0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8), 0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title"));
        o.c(r9, "findViewById(R.id.tv_title)");
        this.tvEntrance = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_arrow, DbHelper.COL_ID, "iv_arrow"));
        o.c(r10, "findViewById(R.id.iv_arrow)");
        this.ivJump = (ImageView) ZeusTransformUtils.preCheckCast(r10, ImageView.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.entrance_container, DbHelper.COL_ID, "entrance_container"));
        o.c(r11, "findViewById(R.id.entrance_container)");
        this.entranceContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r11, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new $$Lambda$OInfoPanelContentEntranceView$s9JNiBKgUHBCRYrwYKA70RgyFxk(this));
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-1, reason: not valid java name */
    private static final void m1099onAttachedToWindow$lambda1(OInfoPanelContentEntranceView r6) {
        o.e(r6, "this$0");
        k.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), r6.entranceContainer.getWidth(), g.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), 44), true);
        k.a((View) ZeusTransformUtils.preCheckCast(r6.entranceContainer, View.class, "com.obric.aiagent.plugin"), r6.entranceContainer.getWidth(), g.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), 44), true);
    }

    public final void onClick(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.entranceContainer.setOnClickListener(r4);
    }

    public final void setEntranceText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "text");
        this.tvEntrance.setText(r4);
    }
}
