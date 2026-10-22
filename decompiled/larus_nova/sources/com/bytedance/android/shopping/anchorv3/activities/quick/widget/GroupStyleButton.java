package com.bytedance.android.shopping.anchorv3.activities.quick.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.AutoResizePriceContainer;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.widget.PriceView;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import d53.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/activities/quick/widget/GroupStyleButton;", "Landroid/widget/FrameLayout;", "", "maxWidth", "", "setPriceViewMaxWidth", "", "buyText", "setBuyText", "Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "activityVO", "setSimpleBuyPrice", "setGroupBuyPrice", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupStyleButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f164416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AutoResizePriceContainer f164417b;

    public GroupStyleButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GroupStyleButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setBuyText(String r100) {
        this.f164416a.setText(r100);
    }

    public final void setGroupBuyPrice(ActivityVO r100) {
        Intrinsics.checkNotNullParameter(r100, "activityVO");
        a.C5637a r101 = new a.C5637a();
        TextView r102 = (TextView) findViewById(R.id.tv_discount);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        r101.f466980a = r102;
        PriceView r103 = (PriceView) findViewById(R.id.price_view);
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        r101.f466981b = r103;
        r101.f466983d = r100;
        r101.f466982c = true;
        new a(r101).c();
    }

    public final void setPriceViewMaxWidth(int r100) {
        this.f164417b.setIsMeasureChildFullWidth(true);
        this.f164417b.setMaxWidth(r100);
    }

    public final void setSimpleBuyPrice(ActivityVO r100) {
        Intrinsics.checkNotNullParameter(r100, "activityVO");
        a.C5637a r101 = new a.C5637a();
        TextView r102 = (TextView) findViewById(R.id.tv_discount);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        r101.f466980a = r102;
        PriceView r103 = (PriceView) findViewById(R.id.price_view);
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        r101.f466981b = r103;
        r101.f466983d = r100;
        r101.f466982c = false;
        new a(r101).c();
    }

    public GroupStyleButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.ec_commerce_group_style_button, this);
        TextView r103 = (TextView) findViewById(R.id.tv_discount);
        PriceView r104 = (PriceView) findViewById(R.id.price_view);
        this.f164416a = (TextView) findViewById(R.id.tv_title);
        this.f164417b = (AutoResizePriceContainer) findViewById(R.id.group_discount_price_container);
    }

    public /* synthetic */ GroupStyleButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
