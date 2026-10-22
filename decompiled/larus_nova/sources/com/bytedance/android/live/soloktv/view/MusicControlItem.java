package com.bytedance.android.live.soloktv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/MusicControlItem;", "Landroid/widget/LinearLayout;", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "", "setIconDrawable", "Landroid/view/View;", "c", "Landroid/view/View;", "getIconView", "()Landroid/view/View;", "setIconView", "(Landroid/view/View;)V", "iconView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "titleView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MusicControlItem extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f101709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f101710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f101711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f101712d;

    public final View getIconView() {
        return this.f101711c;
    }

    public final TextView getTitleView() {
        return this.f101712d;
    }

    public final void setIconDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "iconDrawable");
        View r101 = this.f101709a;
        if (r101 == null) goto L6;
        r101.setBackground(r100);
        return;
    }

    public final void setIconView(View r100) {
        this.f101711c = r100;
    }

    public final void setTitleView(TextView r100) {
        this.f101712d = r100;
    }

    public MusicControlItem(Context r100, AttributeSet r101) {
        super(r100, r101);
        boolean r102 = false;
        if (r100 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.item_enable_font_scale});
    L6:
        if (r103 == null) goto L8;
        r102 = r103.getBoolean(0, false);
    L8:
        this.f101710b = r102;
        if (r103 == null) goto L11;
        r103.recycle();
    L11:
        setOrientation(1);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void a(Drawable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "iconDrawable");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r100, "iconDrawable");
        if (this.f101711c != null) goto L9;
        View r102 = new View(getContext());
        this.f101711c = r102;
        this.f101709a = r102;
        if (this.f101710b == false) goto L7;
        r102.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(34), UtilityKotlinExtentionsKt.i(34)));
        KtvUtilsKt.a(r102, UtilityKotlinExtentionsKt.i(34));
    L8:
        Unit r103 = Unit.INSTANCE;
        addView(r102);
        goto L9
    L7:
        r102.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(32), UtilityKotlinExtentionsKt.i(32)));
    L9:
        View r104 = this.f101711c;
        if (r104 == null) goto L12;
        r104.setBackground(r100);
    L12:
        Intrinsics.checkNotNullParameter(r101, "title");
        if (this.f101712d != null) goto L19;
        TextView r105 = new TextView(getContext());
        this.f101712d = r105;
        r105.setLines(1);
        r105.setMaxLines(1);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.gravity = 1;
        r106.topMargin = UtilityKotlinExtentionsKt.i(4);
        Unit r107 = Unit.INSTANCE;
        r105.setLayoutParams(r106);
        if (this.f101710b == false) goto L17;
        r105.setTextSize(2, 12.0f);
    L18:
        r105.setGravity(17);
        r105.setTextColor(ColorProtector.parseColor("#5dffffff"));
        addView(r105);
        goto L19
    L17:
        r105.setTextSize(1, 12.0f);
    L19:
        TextView r108 = this.f101712d;
        if (r108 == null) goto L23;
        r108.setText(r101);
        return;
    }
}
