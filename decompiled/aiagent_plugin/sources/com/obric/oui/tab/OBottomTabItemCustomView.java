package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OBottomTabItemCustomView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomTabItemCustomView extends RelativeLayout {
    private final int defaultSelectTextColor;
    private final int defaultTextColor;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private Drawable selectedBg;
    private Integer selectedBgColor;
    private ColorStateList textColor;
    private final TextView title;

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomTabItemCustomView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    public /* synthetic */ OBottomTabItemCustomView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OBottomTabItemCustomView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        ZeusTransformUtils.inflate(LayoutInflater.from(r6), ZeusTransformUtils.mapRes(R.layout.o_tab_bottom_item, "layout", "o_tab_bottom_item"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.icon_container, DbHelper.COL_ID, "icon_container"));
        o.c(r8, "findViewById(R.id.icon_container)");
        this.iconContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r8, FrameLayout.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon"));
        o.c(r9, "findViewById(R.id.icon)");
        this.icon = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE));
        o.c(r10, "findViewById(R.id.title)");
        this.title = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
        this.defaultTextColor = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_3, "color", "oui_text_3"));
        this.defaultSelectTextColor = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_fg, "color", "oui_accent_fg"));
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final TextView getTitle() {
        return this.title;
    }

    public final ColorStateList getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(ColorStateList r3) {
        this.textColor = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        this.title.setTextColor(r3.getDefaultColor());
        if (this.icon.getDrawable() == null) goto L9;
        ImageView r2 = this.icon;
        Drawable r0 = androidx.core.graphics.drawable.a.g(r2.getDrawable());
        r0.setTint(r3.getDefaultColor());
        r2.setImageDrawable(r0);
        return;
    }

    public final Integer getSelectedBgColor() {
        return this.selectedBgColor;
    }

    public final void setSelectedBgColor(Integer r7) {
        this.selectedBgColor = r7;
        if (r7 != null) goto L5;
        return;
    L5:
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_m1, "dimen", "oui_r_m1")));
        r0.setColor(r7.intValue());
        this.selectedBg = (Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View
    public void setSelected(boolean r3) {
        super.setSelected(r3);
        Integer r0 = null;
        if (r3 == false) goto L14;
        ColorStateList r4 = this.textColor;
        if (r4 == null) goto L8;
        r0 = Integer.valueOf(r4.getColorForState(RelativeLayout.SELECTED_STATE_SET, this.defaultSelectTextColor));
    L8:
        if (r0 != null) goto L10;
        int r5 = this.defaultSelectTextColor;
    L11:
        this.title.setTextColor(r5);
        if (this.icon.getDrawable() == null) goto L25;
        ImageView r2 = this.icon;
        Drawable r1 = androidx.core.graphics.drawable.a.g(r2.getDrawable());
        r1.setTint(r5);
        r2.setImageDrawable(r1);
        return;
    L25:
        return;
    L10:
        r5 = r0.intValue();
        goto L11
    L14:
        ColorStateList r6 = this.textColor;
        if (r6 == null) goto L18;
        r0 = Integer.valueOf(r6.getDefaultColor());
    L18:
        if (r0 != null) goto L20;
        int r7 = this.defaultTextColor;
    L21:
        this.title.setTextColor(r7);
        if (this.icon.getDrawable() == null) goto L27;
        ImageView r8 = this.icon;
        Drawable r9 = androidx.core.graphics.drawable.a.g(r8.getDrawable());
        r9.setTint(r7);
        r8.setImageDrawable(r9);
        return;
    L27:
        return;
    L20:
        r7 = r0.intValue();
        goto L21
    }
}
