package com.obric.oui.tab.optimize;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
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
import com.obric.oui.d.a.b;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OBottomTabItem.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomTabItem extends RelativeLayout {
    public static final a Companion = null;
    private static final String TAG = "optimize.OBottomTabItem";
    private final int defaultSelectTextColor;
    private final int defaultTextColor;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private int selectBgColor;
    private Drawable selectedBg;
    private Drawable selectedIconDrawable;
    private final TextView title;
    private Drawable unselectedIconDrawable;

    /* JADX INFO: compiled from: OBottomTabItem.kt */
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

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomTabItem(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public final void setImageAndTextTintColor() {
        setImageAndTextTintColor$default(this, 0, 0, 0, 7, null);
    }

    public final void setImageAndTextTintColor(int r7) {
        setImageAndTextTintColor$default(this, r7, 0, 0, 6, null);
    }

    public final void setImageAndTextTintColor(int r7, int r8) {
        setImageAndTextTintColor$default(this, r7, r8, 0, 4, null);
    }

    public /* synthetic */ OBottomTabItem(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OBottomTabItem(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setClickable(false);
        setFocusable(false);
        ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.o_tab_bottom_item, "layout", "o_tab_bottom_item"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.icon_container, DbHelper.COL_ID, "icon_container"));
        o.c(r9, "findViewById(R.id.icon_container)");
        this.iconContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r9, FrameLayout.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon"));
        o.c(r10, "findViewById(R.id.icon)");
        this.icon = (ImageView) ZeusTransformUtils.preCheckCast(r10, ImageView.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE));
        o.c(r11, "findViewById(R.id.title)");
        this.title = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.aiagent.plugin");
        int r12 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_fg, "color", "oui_accent_fg"));
        this.defaultSelectTextColor = r12;
        int r13 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_3b, "color", "oui_text_3b"));
        this.defaultTextColor = r13;
        int r0 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_bg_low_contrast, "color", "oui_accent_bg_low_contrast"));
        this.selectBgColor = r0;
        setImageAndTextTintColor(r12, r13, r0);
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final TextView getTitle() {
        return this.title;
    }

    public static /* synthetic */ void setImageAndTextTintColor$default(OBottomTabItem r3, int r4, int r5, int r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r4 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_fg, "color", "oui_accent_fg"));
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_3b, "color", "oui_text_3b"));
    L9:
        if ((r7 & 4) == 0) goto L11;
        r6 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_bg_low_contrast, "color", "oui_accent_bg_low_contrast"));
    L11:
        r3.setImageAndTextTintColor(r4, r5, r6);
    }

    public final void setImageAndTextTintColor(int r8, int r9, int r10) {
        ColorStateList r0 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{r8, r9});
        this.selectedBg = null;
        this.selectBgColor = r10;
        this.icon.setImageTintList(r0);
        this.title.setTextColor(r0);
    }

    @Override // android.view.View
    public void setSelected(boolean r3) {
        super.setSelected(r3);
        refreshIconDrawableOnSelect(r3);
        if (r3 == false) goto L5;
        this.title.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Label_S_Thick, "style", "Label_S_Thick"));
        return;
    L5:
        this.title.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Label_S, "style", "Label_S"));
    }

    public final Drawable getSelectedIconDrawable() {
        return this.selectedIconDrawable;
    }

    public final void setSelectedIconDrawable(Drawable r1) {
        this.selectedIconDrawable = r1;
    }

    public final Drawable getUnselectedIconDrawable() {
        return this.unselectedIconDrawable;
    }

    public final void setUnselectedIconDrawable(Drawable r1) {
        this.unselectedIconDrawable = r1;
    }

    private final void refreshIconDrawableOnSelect(boolean r3) {
        Drawable r0 = this.selectedIconDrawable;
        if (r0 == null) goto L11;
        Drawable r1 = this.unselectedIconDrawable;
        if (r1 == null) goto L11;
        if (r3 == false) goto L9;
        this.icon.setImageDrawable(r0);
        return;
    L9:
        this.icon.setImageDrawable(r1);
        return;
    L11:
        b.d(TAG, "please set selectedIconDrawable and unselectedIconDrawable");
    }
}
