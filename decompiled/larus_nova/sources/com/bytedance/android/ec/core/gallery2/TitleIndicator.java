package com.bytedance.android.ec.core.gallery2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vf4.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0004\u001a\u00020\u0003R:\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/TitleIndicator;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "", "update", "", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "", "b", "I", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "currentPos", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleIndicator extends AppCompatTextView implements IIndicatorView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f44062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44063b;

    public TitleIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TitleIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
    }

    public final void update() {
        List<String> r100 = this.f44062a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        setVisibility(8);
        return;
    L11:
        setVisibility(0);
        List<String> r102 = this.f44062a;
        if (r102 == null) goto L14;
        String r103 = (String) CollectionsKt.getOrNull(r102, this.f44063b);
    L15:
        setText(r103);
        return;
    L14:
        r103 = null;
        goto L15
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final int getCurrentPos() {
        return this.f44063b;
    }

    public final List<String> getData() {
        return this.f44062a;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onPageSelected(int r100) {
        setCurrentPos(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
        if (r100 != 0) goto L4;
    L5:
        setVisibility(8);
        return;
    L4:
        if (r100 == 3) goto L5;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        boolean r101 = true;
        if (r100 == 0) goto L5;
        if (r100 == 1) goto L5;
        return;
    L5:
        List<String> r102 = this.f44062a;
        if (r102 != null) goto L8;
    L11:
        if (r101 == true) goto L15;
        setVisibility(0);
        return;
    L15:
        return;
    L8:
        if (r102.isEmpty() == true) goto L11;
        r101 = false;
        goto L11
    }

    public final void setCurrentPos(int r100) {
        this.f44063b = r100;
        update();
    }

    public final void setData(List<String> r100) {
        this.f44062a = r100;
        update();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onAttach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r100, r101);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDetach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r100, r101);
    }

    public TitleIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setTextSize(17.0f);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        setPadding(a.b(10), 0, a.b(10), 0);
        r103.bottomMargin = a.b(16);
        r103.leftMargin = a.b(60);
        r103.rightMargin = a.b(60);
        r103.gravity = 81;
        Unit r104 = Unit.INSTANCE;
        setLayoutParams(r103);
        setMaxHeight(a.b(106));
        setEllipsize(TextUtils.TruncateAt.END);
        setTextColor(-1);
        setBackgroundResource(R.drawable.shopping_bg_gallery_indicator);
    }

    public /* synthetic */ TitleIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
