package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OListItemCheck.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OListItemCheck extends OListItemGeneral {
    public final void setCheckedIconLight(boolean r1) {
    }

    public /* synthetic */ OListItemCheck(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OListItemCheck(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
        setTrailingImageView(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_ic_radio_tick_checked, "drawable", "o_ic_radio_tick_checked")));
        getMTrailingElement().setVisibility(8);
    }

    public final void setChecked(boolean r1) {
        FrameLayout r0 = getMTrailingElement();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public final boolean isChecked() {
        if (getMTrailingElement().getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final ImageView getIcon() {
        View r2 = getMTrailingElement().getChildAt(0);
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.widget.ImageView");
        return (ImageView) ZeusTransformUtils.preCheckCast(r2, ImageView.class, "com.obric.aiagent.plugin");
    }

    public final void setTitle(String r3) {
        o.e(r3, "str");
        setTitleString((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }
}
