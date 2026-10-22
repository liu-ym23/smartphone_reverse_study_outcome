package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.d.c;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OActionSheetButton.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OActionSheetButton extends OUIFrameLayout {
    public static final a Companion = null;
    private static final String TAG = "OActionSheetButton";
    public OTextView tvTitle;

    /* JADX INFO: compiled from: OActionSheetButton.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void getTvTitle$annotations() {
    }

    public /* synthetic */ OActionSheetButton(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OActionSheetButton(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        super(r3, r4, 0, null, 12, null);
        init();
    }

    public final OTextView getTvTitle() {
        OTextView r0 = this.tvTitle;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("tvTitle");
        return null;
    }

    public final void setTvTitle(OTextView r2) {
        o.e(r2, "<set-?>");
        this.tvTitle = r2;
    }

    private final void init() {
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_button, "layout", "o_listitem_button"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.ll_root, DbHelper.COL_ID, "ll_root")), ViewGroup.class, "com.obric.aiagent.plugin");
        c r3 = c.f35012a;
        if (r0 != null) goto L6;
    L4:
        r0 = null;
    L7:
        com.obric.oui.common.style.a r1 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.setChangeAlphaWhenPress(false);
    L11:
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_content_title, DbHelper.COL_ID, "tv_content_title"));
        o.c(r2, "findViewById(R.id.tv_content_title)");
        setTvTitle((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin"));
        setRadius((int) ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3_rect, "dimen", "oui_r_l3_rect")));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.common.style.a.class) == false) goto L4;
        goto L4
    }

    public final void setText(String r3) {
        o.e(r3, "str");
        getTvTitle().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void setTextColor(int r1) {
        getTvTitle().setTextColor(r1);
    }
}
