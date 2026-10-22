package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageIndicator;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "Lkotlin/Function0;", "", "closeListener", "setCloseListener", "", "isVisible", "setIndexVisible", "", "value", "e", "I", "getCount", "()I", "setCount", "(I)V", "count", "f", "getCurrentPos", "setCurrentPos", "currentPos", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageIndicator extends ConstraintLayout implements IIndicatorView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f168268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f168269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f168270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f168271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f168272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f168273f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4DetailImageIndicator f168274a;

        public a(AnchorV4DetailImageIndicator r100) {
            this.f168274a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f168274a.f168269b;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke();
            return;
        }
    }

    public AnchorV4DetailImageIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4DetailImageIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
    }

    public final void R5() {
        TextView r100 = this.f168268a;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        r100.setText(String.format(Locale.getDefault(), this.f168271d, Arrays.copyOf(new Object[]{Integer.valueOf(this.f168273f + 1), Integer.valueOf(this.f168272e)}, 2)));
    }

    public final int getCount() {
        return this.f168272e;
    }

    public final int getCurrentPos() {
        return this.f168273f;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onPageSelected(int r100) {
        setCurrentPos(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
        if (r100 != 0) goto L4;
    L5:
        this.f168268a.setVisibility(8);
        return;
    L4:
        if (r100 == 3) goto L5;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (r100 == 0) goto L6;
        if (r100 == 1) goto L6;
        return;
    L6:
        if (this.f168270c == false) goto L10;
        this.f168268a.setVisibility(0);
        return;
    }

    public final void setCloseListener(Function0<Unit> r100) {
        this.f168269b = r100;
    }

    public final void setCount(int r100) {
        this.f168272e = r100;
        R5();
    }

    public final void setCurrentPos(int r100) {
        this.f168273f = r100;
        R5();
    }

    public final void setIndexVisible(boolean r100) {
        if (r100 == false) goto L4;
        this.f168268a.setVisibility(0);
    L5:
        this.f168270c = r100;
        return;
    L4:
        this.f168268a.setVisibility(8);
        goto L5
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

    public AnchorV4DetailImageIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168271d = "%s/%s";
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_layout_detail_image_indicator, this, true);
        ImageView r103 = (ImageView) findViewById(R.id.iv_close);
        this.f168268a = (TextView) findViewById(R.id.tv_index);
        r103.setOnClickListener(new a(this));
    }

    public /* synthetic */ AnchorV4DetailImageIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
