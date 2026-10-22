package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.a2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/FollowGiftBubbleView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ec/store/common/bubble/d;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowGiftBubbleView extends AppCompatTextView implements com.bytedance.android.ec.store.common.bubble.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f184620d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f184621e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f184622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f184623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f184624c;

    public static final class a {
    }

    public FollowGiftBubbleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FollowGiftBubbleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        f184620d = com.bytedance.android.shopping.extensions.b.b(10);
        f184621e = com.bytedance.android.shopping.extensions.b.b(14);
    }

    @Override // com.bytedance.android.ec.store.common.bubble.d
    public final void b() {
        if (this.f184622a != null) goto L5;
        return;
    L5:
        if (this.f184623b != null) goto L7;
        return;
    L7:
        if (this.f184624c == null) goto L38;
        setVisibility(0);
        ViewGroup.LayoutParams r100 = getLayoutParams();
        String r101 = null;
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r100 = null;
    L12:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r100;
        if (r102 == null) goto L15;
        r102.topMargin = com.bytedance.android.shopping.extensions.b.b(-13);
        r102.setMarginEnd(r102.rightMargin);
        requestLayout();
    L15:
        setText(this.f184622a);
        String r103 = this.f184623b;
        if (r103 != null) goto L18;
    L23:
        String r104 = this.f184624c;
        if (r104 != null) goto L26;
        return;
    L26:
        if (a2.b(r104) == false) goto L28;
        r101 = r104;
    L28:
        if (r101 == null) goto L36;
        Drawable r105 = getBackground();
        if (r105 == null) goto L37;
        r105.setColorFilter(com.bytedance.android.ec.core.utils.s.a(r101, 16711760), PorterDuff.Mode.SRC_ATOP);
        return;
    L37:
        return;
    L36:
        return;
    L18:
        if (a2.b(r103) == true) goto L21;
        r103 = null;
    L21:
        if (r103 == null) goto L23;
        setTextColor(com.bytedance.android.ec.core.utils.s.a(r103, 16777215));
        goto L23
    }

    public final void y() {
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L9;
        r101.removeView(this);
        return;
    }

    public FollowGiftBubbleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public final void x(String r100, String r101, String r102) {
        this.f184622a = r100;
        this.f184623b = r101;
        this.f184624c = r102;
        setBackground(th.a.b(getContext(), R.drawable.ec_store_bg_follow_gift_bubble_pink_new));
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(17);
        setIncludeFontPadding(false);
        setMaxLines(1);
        setPadding(com.bytedance.android.shopping.extensions.b.b(6), 0, com.bytedance.android.shopping.extensions.b.b(6), 0);
        setTextSize(1, 10.0f);
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextColor(th.a.a(getContext(), R.color.shopping_color_161823));
    }

    public /* synthetic */ FollowGiftBubbleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
