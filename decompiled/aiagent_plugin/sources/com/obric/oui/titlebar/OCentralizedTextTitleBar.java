package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.sheet.OActionSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OCentralizedTextTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OCentralizedTextTitleBar extends OTitleBar {
    private FrameLayout mLeadingElement;
    private View mLine;
    private FrameLayout mTrailingElement;

    public OCentralizedTextTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCentralizedTextTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OCentralizedTextTitleBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OCentralizedTextTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        OTitleBar.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_centralized_title_bar, "layout", "o_centralized_title_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        this.mLeadingElement = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.fl_leading_element, DbHelper.COL_ID, "fl_leading_element")), FrameLayout.class, "com.obric.aiagent.plugin");
        this.mTrailingElement = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.fl_trailing_element, DbHelper.COL_ID, "fl_trailing_element")), FrameLayout.class, "com.obric.aiagent.plugin");
        this.mTitleView = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_content_title, DbHelper.COL_ID, "tv_content_title")), TextView.class, "com.obric.aiagent.plugin");
        this.mLine = findViewById(ZeusTransformUtils.mapRes(R.id.divider_view, DbHelper.COL_ID, OActionSheet.DIVIDER_VIEW));
    }

    public final FrameLayout getLeadingElement() {
        return this.mLeadingElement;
    }

    public final FrameLayout getTrailingElement() {
        return this.mTrailingElement;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void showDividerLine(boolean r1) {
        View r0 = this.mLine;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        View r0 = this.mLine;
        if (r0 == null) goto L7;
        r0.setBackgroundColor(r1);
        return;
    }
}
