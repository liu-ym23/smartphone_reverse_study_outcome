package com.bytedance.android.livesdk.livecommerce.userinfo.title.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/views/ECIntroductionRotationView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECIntroductionRotationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECIntroductionRotationView$bindData$1 f153015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f153016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f153017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f153018d;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ECIntroductionRotationView$bindData$1 r100 = this.f153015a;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f153015a = null;
    }

    public ECIntroductionRotationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        int r101 = ECIntroductionLayout.f153010g;
        TextView r102 = ECIntroductionLayout.a.a(getContext());
        this.f153016b = r102;
        TextView r103 = ECIntroductionLayout.a.a(getContext());
        this.f153017c = r103;
        this.f153018d = -1;
        addView(r102);
        addView(r103);
    }

    public ECIntroductionRotationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        int r102 = ECIntroductionLayout.f153010g;
        TextView r103 = ECIntroductionLayout.a.a(getContext());
        this.f153016b = r103;
        TextView r104 = ECIntroductionLayout.a.a(getContext());
        this.f153017c = r104;
        this.f153018d = -1;
        addView(r103);
        addView(r104);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f153018d <= 0) goto L10;
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = (this.f153018d + getPaddingLeft()) + getPaddingRight();
        if (r102 == Integer.MIN_VALUE) goto L8;
        if (r102 == 1073741824) goto L9;
        r103 = r104;
    L9:
        r100 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
        goto L10
    L8:
        r103 = Math.min(r104, r103);
    L10:
        super.onMeasure(r100, r101);
    }

    public ECIntroductionRotationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = ECIntroductionLayout.f153010g;
        TextView r104 = ECIntroductionLayout.a.a(getContext());
        this.f153016b = r104;
        TextView r105 = ECIntroductionLayout.a.a(getContext());
        this.f153017c = r105;
        this.f153018d = -1;
        addView(r104);
        addView(r105);
    }
}
