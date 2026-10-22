package com.bytedance.android.ui.ec.widget.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ui.base.widget.icon.IconImageView;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.bytedance.android.ui.ec.widget.tools.ViewExtensionsKt;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 :2\u00020\u0001:\u0001:B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0014J\u0010\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010,\u001a\u00020%2\b\b\u0003\u0010-\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0011J\u000e\u00100\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u00101\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00102\u001a\u00020%2\b\b\u0003\u0010-\u001a\u00020\u0007J\u0010\u00103\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00104\u001a\u00020%2\b\b\u0003\u0010-\u001a\u00020\u0007J\u000e\u00105\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0011J\u000e\u00106\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u00107\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00108\u001a\u00020%2\b\b\u0003\u0010-\u001a\u00020\u0007J\u000e\u00109\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0013R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/titlebar/ECTitleBar;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_$_findViewCache", "", "Landroid/view/View;", "hideDividerLine", "", "leftIconColorStateList", "Landroid/content/res/ColorStateList;", "leftIconDrawable", "Landroid/graphics/drawable/Drawable;", "leftText", "", "leftTextColorStateList", "leftTextSize", "", "rightIconColorStateList", "rightIconDrawable", "rightText", "rightTextColorStateList", "rightTextSize", "showLeftIcon", "showLeftText", "showRightIcon", "showRightText", "titleText", "titleTextSize", "_$_findCachedViewById", "id", "applyIconState", "", "applyState", "applyTextState", "onAttachedToWindow", "setLeftIconClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setLeftIconColor", "color", "setLeftIconDrawable", "drawable", "setLeftText", "setLeftTextClickListener", "setLeftTextColor", "setRightIconClickListener", "setRightIconColor", "setRightIconDrawable", "setRightText", "setRightTextClickListener", "setRightTextColor", "setTitleText", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTitleBar extends RoundConstraintLayout {
    public static final Companion Companion = null;
    private static final float DEFAULT_BUTTON_TEXT_SIZE = 15.0f;
    private static final float DEFAULT_TITLE_TEXT_SIZE = 17.0f;
    private Map<Integer, View> _$_findViewCache;
    private boolean hideDividerLine;
    private ColorStateList leftIconColorStateList;
    private Drawable leftIconDrawable;
    private CharSequence leftText;
    private ColorStateList leftTextColorStateList;
    private float leftTextSize;
    private ColorStateList rightIconColorStateList;
    private Drawable rightIconDrawable;
    private CharSequence rightText;
    private ColorStateList rightTextColorStateList;
    private float rightTextSize;
    private boolean showLeftIcon;
    private boolean showLeftText;
    private boolean showRightIcon;
    private boolean showRightText;
    private CharSequence titleText;
    private float titleTextSize;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/titlebar/ECTitleBar$Companion;", "", "()V", "DEFAULT_BUTTON_TEXT_SIZE", "", "DEFAULT_TITLE_TEXT_SIZE", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ECTitleBar(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final void applyIconState() {
        if (this.showLeftIcon == false) goto L13;
        ColorStateList r100 = this.leftIconColorStateList;
        if (r100 == null) goto L9;
        IconImageView r101 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r101 == null) goto L13;
        r101.setIconColor(r100);
        goto L13
    L9:
        IconImageView r102 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r102 == null) goto L13;
        IconImageView.setIconColor$default(r102, R.color.ec_dux_black_161823, 0, 2, null);
    L13:
        if (this.showRightIcon == false) goto L23;
        ColorStateList r103 = this.rightIconColorStateList;
        if (r103 == null) goto L19;
        IconImageView r104 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r104 == null) goto L24;
        r104.setIconColor(r103);
        return;
    L24:
        return;
    L19:
        IconImageView r105 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r105 == null) goto L26;
        IconImageView.setIconColor$default(r105, R.color.ec_dux_black_161823, 0, 2, null);
        return;
    L26:
        return;
    }

    private final void applyTextState() {
        ColorStateList r100 = this.leftTextColorStateList;
        if (r100 == null) goto L7;
        TextView r101 = (TextView) _$_findCachedViewById(R.id.tv_left);
        if (r101 == null) goto L7;
        r101.setTextColor(r100);
    L7:
        ColorStateList r102 = this.rightTextColorStateList;
        if (r102 == null) goto L13;
        TextView r103 = (TextView) _$_findCachedViewById(R.id.tv_right);
        if (r103 == null) goto L14;
        r103.setTextColor(r102);
        return;
    L14:
        return;
    }

    private final void applyState() {
        TextView r100 = (TextView) _$_findCachedViewById(R.id.tv_title);
        if (r100 == null) goto L6;
        r100.setText(this.titleText);
        r100.setTextSize(0, this.titleTextSize);
    L6:
        if (this.showLeftText == false) goto L14;
        IconImageView r101 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r101 == null) goto L10;
        r101.setVisibility(8);
    L10:
        TextView r102 = (TextView) _$_findCachedViewById(R.id.tv_left);
        if (r102 == null) goto L28;
        r102.setVisibility(0);
        r102.setText(this.leftText);
        r102.setTextSize(0, this.leftTextSize);
    L28:
        if (this.showRightText == false) goto L36;
        IconImageView r103 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r103 == null) goto L32;
        r103.setVisibility(8);
    L32:
        TextView r104 = (TextView) _$_findCachedViewById(R.id.tv_right);
        if (r104 == null) goto L50;
        r104.setVisibility(0);
        r104.setText(this.rightText);
        r104.setTextSize(0, this.rightTextSize);
    L50:
        if (this.hideDividerLine == false) goto L54;
        View r105 = _$_findCachedViewById(R.id.divider_line);
        if (r105 == null) goto L58;
        r105.setVisibility(8);
    L58:
        if (this.leftIconDrawable == null) goto L63;
        IconImageView r106 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r106 == null) goto L63;
        r106.setImageDrawable(this.leftIconDrawable);
    L63:
        if (this.rightIconDrawable == null) goto L67;
        IconImageView r107 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r107 == null) goto L67;
        r107.setImageDrawable(this.rightIconDrawable);
    L67:
        applyIconState();
        applyTextState();
        return;
    L54:
        View r108 = _$_findCachedViewById(R.id.divider_line);
        if (r108 == null) goto L58;
        r108.setVisibility(0);
        goto L58
    L36:
        if (this.showRightIcon == false) goto L43;
        IconImageView r109 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r109 == null) goto L40;
        r109.setVisibility(0);
    L40:
        TextView r110 = (TextView) _$_findCachedViewById(R.id.tv_right);
        if (r110 == null) goto L50;
        r110.setVisibility(8);
        goto L50
    L43:
        IconImageView r111 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r111 == null) goto L46;
        r111.setVisibility(8);
    L46:
        TextView r112 = (TextView) _$_findCachedViewById(R.id.tv_right);
        if (r112 == null) goto L50;
        r112.setVisibility(8);
        goto L50
    L14:
        if (this.showLeftIcon == false) goto L21;
        IconImageView r113 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r113 == null) goto L18;
        r113.setVisibility(0);
    L18:
        TextView r114 = (TextView) _$_findCachedViewById(R.id.tv_left);
        if (r114 == null) goto L28;
        r114.setVisibility(8);
        goto L28
    L21:
        IconImageView r115 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r115 == null) goto L24;
        r115.setVisibility(8);
    L24:
        TextView r116 = (TextView) _$_findCachedViewById(R.id.tv_left);
        if (r116 == null) goto L28;
        r116.setVisibility(8);
        goto L28
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ArrayList r100 = new ArrayList();
        IconImageView r101 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        TextView r102 = null;
        boolean r103 = true;
        if (r101 != null) goto L5;
    L13:
        TextView r104 = (TextView) _$_findCachedViewById(R.id.tv_left);
        if (r104 != null) goto L16;
    L24:
        IconImageView r105 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r105 != null) goto L27;
    L35:
        TextView r106 = (TextView) _$_findCachedViewById(R.id.tv_right);
        if (r106 != null) goto L38;
    L45:
        ViewExtensionsKt.increaseHitAreaForViews$default(this, r100, 0, 0, 6, null);
        return;
    L38:
        if (r106.getVisibility() == 0) goto L41;
        r103 = false;
    L41:
        if (r103 == false) goto L43;
        r102 = r106;
    L43:
        if (r102 == null) goto L45;
        r100.add(r102);
        goto L45
    L27:
        if (r105.getVisibility() != 0) goto L29;
        boolean r107 = true;
    L30:
        if (r107 == true) goto L33;
        r105 = null;
    L33:
        if (r105 == null) goto L35;
        r100.add(r105);
        goto L35
    L29:
        r107 = false;
        goto L30
    L16:
        if (r104.getVisibility() != 0) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == true) goto L22;
        r104 = null;
    L22:
        if (r104 == null) goto L24;
        r100.add(r104);
        goto L24
    L18:
        r108 = false;
        goto L19
    L5:
        if (r101.getVisibility() != 0) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L13;
        r100.add(r101);
        goto L13
    L7:
        r109 = false;
        goto L8
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_titlebar_ECTitleBar_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public View _$_findCachedViewById(int r100) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new LinkedHashMap();
    L5:
        View r101 = this._$_findViewCache.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this._$_findViewCache.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setLeftIconClickListener(View.OnClickListener r100) {
        IconImageView r101 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void setLeftIconColor(int r100) {
        if (r100 == 0) goto L4;
        this.leftIconColorStateList = ColorStateList.valueOf(r100);
    L4:
        ColorStateList r101 = this.leftIconColorStateList;
        if (r101 == null) goto L10;
        IconImageView r102 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r102 == null) goto L11;
        r102.setIconColor(r101);
        return;
    L11:
        return;
    }

    public final void setLeftIconDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.leftIconDrawable = r100;
        IconImageView r101 = (IconImageView) _$_findCachedViewById(R.id.iv_left);
        if (r101 == null) goto L5;
        r101.setImageDrawable(r100);
    L5:
        applyIconState();
    }

    public final void setLeftText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "leftText");
        this.leftText = r100;
        TextView r101 = (TextView) _$_findCachedViewById(R.id.tv_left);
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setLeftTextClickListener(View.OnClickListener r100) {
        TextView r101 = (TextView) _$_findCachedViewById(R.id.tv_left);
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void setLeftTextColor(int r100) {
        if (r100 == 0) goto L4;
        this.leftTextColorStateList = ColorStateList.valueOf(r100);
    L4:
        ColorStateList r101 = this.leftTextColorStateList;
        if (r101 == null) goto L10;
        TextView r102 = (TextView) _$_findCachedViewById(R.id.tv_left);
        if (r102 == null) goto L11;
        r102.setTextColor(r101);
        return;
    L11:
        return;
    }

    public final void setRightIconClickListener(View.OnClickListener r100) {
        IconImageView r101 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void setRightIconColor(int r100) {
        if (r100 == 0) goto L4;
        this.rightIconColorStateList = ColorStateList.valueOf(r100);
    L4:
        ColorStateList r101 = this.rightIconColorStateList;
        if (r101 == null) goto L10;
        IconImageView r102 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r102 == null) goto L11;
        r102.setIconColor(r101);
        return;
    L11:
        return;
    }

    public final void setRightIconDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.rightIconDrawable = r100;
        IconImageView r101 = (IconImageView) _$_findCachedViewById(R.id.iv_right);
        if (r101 == null) goto L5;
        r101.setImageDrawable(r100);
    L5:
        applyIconState();
    }

    public final void setRightText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "rightText");
        this.rightText = r100;
        TextView r101 = (TextView) _$_findCachedViewById(R.id.tv_right);
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setRightTextClickListener(View.OnClickListener r100) {
        TextView r101 = (TextView) _$_findCachedViewById(R.id.tv_right);
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void setRightTextColor(int r100) {
        if (r100 == 0) goto L4;
        this.rightTextColorStateList = ColorStateList.valueOf(r100);
    L4:
        ColorStateList r101 = this.rightTextColorStateList;
        if (r101 == null) goto L10;
        TextView r102 = (TextView) _$_findCachedViewById(R.id.tv_right);
        if (r102 == null) goto L11;
        r102.setTextColor(r101);
        return;
    L11:
        return;
    }

    public final void setTitleText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "titleText");
        this.titleText = r100;
        TextView r101 = (TextView) _$_findCachedViewById(R.id.tv_title);
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public ECTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this._$_findViewCache = new LinkedHashMap();
        String r103 = "";
        this.titleText = "";
        this.rightText = "";
        this.leftText = "";
        this.showLeftIcon = true;
        LayoutInflater.from(r100).inflate(R.layout.ec_dux_title_bar_layout, this, true);
        if (r101 == null) goto L17;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.hideDividerLine, R.attr.leftIconColor, R.attr.leftIconRes, R.attr.leftText, R.attr.leftTextColor, R.attr.leftTextSize, R.attr.rightIconColor, R.attr.rightIconRes, R.attr.rightText, R.attr.rightTextColor, R.attr.rightTextSize, R.attr.showLeftIcon, R.attr.showLeftText, R.attr.showRightIcon, R.attr.showRightText, R.attr.title, R.attr.titleTextSize});
        String r105 = r104.getString(15);
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        this.titleText = r105;
        this.titleTextSize = r104.getDimension(16, TypedValue.applyDimension(1, 17.0f, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_titlebar_ECTitleBar_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.leftTextSize = r104.getDimension(5, TypedValue.applyDimension(1, DEFAULT_BUTTON_TEXT_SIZE, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_titlebar_ECTitleBar_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.rightTextSize = r104.getDimension(10, TypedValue.applyDimension(1, DEFAULT_BUTTON_TEXT_SIZE, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_titlebar_ECTitleBar_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        String r106 = r104.getString(3);
        if (r106 != null) goto L12;
        r106 = "";
    L12:
        this.leftText = r106;
        String r107 = r104.getString(8);
        if (r107 == null) goto L15;
        r103 = r107;
    L15:
        this.rightText = r103;
        this.showLeftText = r104.getBoolean(12, this.showLeftText);
        this.showLeftIcon = r104.getBoolean(11, this.showLeftIcon);
        this.showRightText = r104.getBoolean(14, this.showRightText);
        this.showRightIcon = r104.getBoolean(13, this.showRightIcon);
        this.hideDividerLine = r104.getBoolean(0, this.hideDividerLine);
        this.leftIconColorStateList = r104.getColorStateList(1);
        this.rightIconColorStateList = r104.getColorStateList(6);
        this.leftTextColorStateList = r104.getColorStateList(4);
        this.rightTextColorStateList = r104.getColorStateList(9);
        this.leftIconDrawable = r104.getDrawable(2);
        this.rightIconDrawable = r104.getDrawable(7);
        r104.recycle();
        applyState();
        return;
    }

    public static /* synthetic */ void setLeftIconColor$default(ECTitleBar r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 0;
    L5:
        r100.setLeftIconColor(r101);
    }

    public static /* synthetic */ void setLeftTextColor$default(ECTitleBar r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 0;
    L5:
        r100.setLeftTextColor(r101);
    }

    public static /* synthetic */ void setRightIconColor$default(ECTitleBar r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 0;
    L5:
        r100.setRightIconColor(r101);
    }

    public static /* synthetic */ void setRightTextColor$default(ECTitleBar r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 0;
    L5:
        r100.setRightTextColor(r101);
    }

    public /* synthetic */ ECTitleBar(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
