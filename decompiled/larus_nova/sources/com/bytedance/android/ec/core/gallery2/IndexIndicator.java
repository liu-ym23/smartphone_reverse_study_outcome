package com.bytedance.android.ec.core.gallery2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import vf4.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eR*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/IndexIndicator;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getCount", "()I", "setCount", "(I)V", "count", "b", "getCurrentPos", "setCurrentPos", "currentPos", "", "c", "Z", "getDisableUpdateVisibilityInternal", "()Z", "setDisableUpdateVisibilityInternal", "(Z)V", "disableUpdateVisibilityInternal", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IndexIndicator extends AppCompatTextView implements IIndicatorView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44058c;

    public IndexIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IndexIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
    }

    public final void updateUI() {
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        setText(String.format(Locale.getDefault(), "%s/%s", Arrays.copyOf(new Object[]{Integer.valueOf(this.f44057b + 1), Integer.valueOf(this.f44056a)}, 2)));
    }

    public final int getCount() {
        return this.f44056a;
    }

    public final int getCurrentPos() {
        return this.f44057b;
    }

    public final boolean getDisableUpdateVisibilityInternal() {
        return this.f44058c;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onPageSelected(int r100) {
        setCurrentPos(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
        if (this.f44058c == false) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
    L8:
        setVisibility(8);
        return;
    L7:
        if (r100 == 3) goto L8;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (this.f44058c == false) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
    L8:
        setVisibility(0);
        return;
    L7:
        if (r100 == 1) goto L8;
    }

    public final void setCount(int r100) {
        this.f44056a = r100;
        updateUI();
    }

    public final void setCurrentPos(int r100) {
        this.f44057b = r100;
        updateUI();
    }

    public final void setDisableUpdateVisibilityInternal(boolean r100) {
        this.f44058c = r100;
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

    public IndexIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setTextSize(14.0f);
        setTextColor(-1);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        setPadding(a.b(5), 0, a.b(5), 0);
        r103.topMargin = a.b(36);
        r103.rightMargin = a.b(16);
        r103.gravity = 8388661;
        Unit r104 = Unit.INSTANCE;
        setLayoutParams(r103);
        setBackgroundResource(R.drawable.shopping_bg_gallery_indicator);
    }

    public /* synthetic */ IndexIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
