package com.bytedance.android.ui.ec.widget.photodraweeview.simpletools;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u00162\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0006\u0010\"\u001a\u00020\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/simpletools/IndexIndicator;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "STR_NUM_FORMAT", "", "value", "count", "getCount", "()I", "setCount", "(I)V", "currentPos", "getCurrentPos", "setCurrentPos", "onAttach", "", "position", "adapter", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "onDataChanged", "onPageSelected", "onTransitionBegin", "state", "onTransitionChanged", "factor", "", "onTransitionEnd", "updateUI", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IndexIndicator extends AppCompatTextView implements IIndicatorView {
    private final String STR_NUM_FORMAT;
    private int count;
    private int currentPos;

    public IndexIndicator(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public IndexIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionChanged(int r100, float r101) {
    }

    public final void updateUI() {
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        setText(String.format(Locale.getDefault(), this.STR_NUM_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(this.currentPos + 1), Integer.valueOf(this.count)}, 2)));
    }

    public final int getCount() {
        return this.count;
    }

    public final int getCurrentPos() {
        return this.currentPos;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        setCount(r100.getItemCount());
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public void onPageSelected(int r100) {
        setCurrentPos(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionBegin(int r100) {
        if (r100 != 0) goto L4;
    L5:
        ExtensionsKt.gone(this);
        return;
    L4:
        if (r100 == 3) goto L5;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionEnd(int r100) {
        if (r100 != 0) goto L4;
    L5:
        ExtensionsKt.visible(this);
        return;
    L4:
        if (r100 == 1) goto L5;
    }

    public final void setCount(int r100) {
        this.count = r100;
        updateUI();
    }

    public final void setCurrentPos(int r100) {
        this.currentPos = r100;
        updateUI();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public void onAttach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        setCurrentPos(r100);
        setCount(r101.getItemCount());
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public void onDetach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r100, r101);
    }

    public IndexIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.STR_NUM_FORMAT = "%s/%s";
        setTextSize(14.0f);
        setTextColor(-1);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        setPadding(ExtensionsKt.getDp(5), 0, ExtensionsKt.getDp(5), 0);
        r103.bottomMargin = ExtensionsKt.getDp(16);
        r103.rightMargin = ExtensionsKt.getDp(16);
        r103.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        Unit r104 = Unit.INSTANCE;
        setLayoutParams(r103);
    }

    public /* synthetic */ IndexIndicator(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
