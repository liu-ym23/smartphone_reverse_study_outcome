package com.bytedance.android.shopping.anchorv3.activities.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import e53.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/activities/view/ActivityBarBackgroundLayout;", "Landroid/widget/RelativeLayout;", "Landroid/widget/ImageView;", "getIcon", "", "borderRadius", "", "setBorderRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityBarBackgroundLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f164425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f164426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f164427c;

    public ActivityBarBackgroundLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ActivityBarBackgroundLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ImageView getIcon() {
        return this.f164425a;
    }

    public final void a(int r100) {
        setBorderRadius(0);
        if (this.f164425a != null) goto L6;
        if (r100 == 0) goto L6;
        setClipChildren(false);
        setClipToPadding(false);
        ImageView r101 = new ImageView(getContext());
        r101.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams r102 = new RelativeLayout.LayoutParams(-2, -1);
        r102.getRules()[11] = 1;
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        r101.setAdjustViewBounds(true);
        this.f164425a = r101;
        r101.setTranslationX(getPaddingRight());
        addView(this.f164425a, 0);
    L6:
        if (r100 == 0) goto L13;
        ImageView r104 = this.f164425a;
        if (r104 == null) goto L10;
        r104.setImageResource(r100);
    L10:
        ImageView r105 = this.f164425a;
        if (r105 == null) goto L17;
        r105.setVisibility(0);
        return;
    L17:
        return;
    L13:
        ImageView r106 = this.f164425a;
        if (r106 == null) goto L19;
        r106.setVisibility(8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = this.f164426b;
        super.dispatchDraw(r100);
    }

    public final void setBorderRadius(int r100) {
        b(getWidth(), getHeight());
        this.f164426b = r100;
        invalidate();
    }

    public final void b(int r100, int r101) {
        if (this.f164426b > 0) goto L5;
        return;
    L5:
        if (this.f164427c != null) goto L7;
        this.f164427c = new b();
    L7:
        setClipToOutline(true);
        b r102 = this.f164427c;
        if (r102 == null) goto L10;
        r102.update(this.f164426b, r100, r101);
    L10:
        setOutlineProvider(this.f164427c);
    }

    public ActivityBarBackgroundLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ActivityBarBackgroundLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = this.f164426b;
        b(r100, r101);
    }
}
