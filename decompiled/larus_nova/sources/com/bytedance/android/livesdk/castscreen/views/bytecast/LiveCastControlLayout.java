package com.bytedance.android.livesdk.castscreen.views.bytecast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0013¢\u0006\u0004\b$\u0010%R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR*\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/bytecast/LiveCastControlLayout;", "Landroid/widget/FrameLayout;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getEnable", "()Z", "setEnable", "(Z)V", "enable", "b", "getFillParentPadding", "setFillParentPadding", "fillParentPadding", "c", "getFillParentMargin", "setFillParentMargin", "fillParentMargin", "", "d", "I", "getLeftExtra", "()I", "setLeftExtra", "(I)V", "leftExtra", "e", "getRightExtra", "setRightExtra", "rightExtra", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastControlLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f104839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f104840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f104841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f104842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f104843e;

    public LiveCastControlLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveCastControlLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getEnable() {
        return this.f104839a;
    }

    public final boolean getFillParentMargin() {
        return this.f104841c;
    }

    public final boolean getFillParentPadding() {
        return this.f104840b;
    }

    public final int getLeftExtra() {
        return this.f104842d;
    }

    public final int getRightExtra() {
        return this.f104843e;
    }

    public final void setEnable(boolean r100) {
        if (this.f104839a == r100) goto L5;
        requestLayout();
    L5:
        this.f104839a = r100;
    }

    public final void setFillParentMargin(boolean r100) {
        this.f104841c = r100;
        ViewParent r101 = getParent();
        ViewParent r102 = null;
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 == null) goto L8;
        r103.setClipToPadding(false);
    L8:
        ViewParent r104 = getParent();
        if (r104 == null) goto L11;
        ViewParent r105 = r104.getParent();
    L13:
        if ((r105 instanceof ViewGroup) == false) goto L16;
        r102 = r105;
    L16:
        ViewGroup r106 = (ViewGroup) r102;
        if (r106 == null) goto L20;
        r106.setClipToPadding(false);
        return;
    L20:
        return;
    L11:
        r105 = null;
        goto L13
    }

    public final void setFillParentPadding(boolean r100) {
        this.f104840b = r100;
        ViewParent r101 = getParent();
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L9;
        r102.setClipToPadding(false);
        return;
    }

    public final void setLeftExtra(int r100) {
        this.f104842d = r100;
    }

    public final void setRightExtra(int r100) {
        this.f104843e = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        ViewParent r102 = getParent();
        ViewGroup.LayoutParams r103 = null;
        if ((r102 instanceof ViewGroup) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup r104 = (ViewGroup) r102;
        if (r104 != null) goto L8;
    L46:
        super.onMeasure(r100, r101);
        return;
    L8:
        if (this.f104839a == false) goto L46;
        int r105 = r104.getMeasuredWidth();
        int r106 = 0;
        if (r105 != 0) goto L17;
        View r107 = r104.getRootView();
        if (r107 == null) goto L15;
        r105 = r107.getMeasuredWidth();
        goto L17
    L15:
        r105 = 0;
    L17:
        if (r105 != 0) goto L19;
        r105 = s1.y();
    L19:
        if (r105 != 0) goto L23;
        super.onMeasure(r100, r101);
        return;
    L23:
        if (this.f104841c == false) goto L30;
        ViewGroup.LayoutParams r108 = r104.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L27;
        r108 = null;
    L27:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        if (r109 == null) goto L30;
        r106 = r109.leftMargin;
        int r110 = r109.rightMargin;
    L31:
        int r111 = r105 + (this.f104842d + this.f104843e);
        if (r106 != 0) goto L37;
        if (r110 != 0) goto L37;
        super.onMeasure(r100, r101);
        return;
    L37:
        int r112 = r111 + (r110 + r106);
        ViewGroup.LayoutParams r113 = getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L41;
        r103 = r113;
    L41:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r103;
        if (r114 == null) goto L44;
        r114.leftMargin = -(r106 + this.f104842d);
    L44:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r112, 1073741824), r101);
        return;
    L30:
        r110 = 0;
        goto L31
    }

    public LiveCastControlLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f104840b = true;
        this.f104841c = true;
    }

    public /* synthetic */ LiveCastControlLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
