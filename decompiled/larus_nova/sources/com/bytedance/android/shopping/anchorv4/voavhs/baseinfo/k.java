package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f167967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f167968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextView f167969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GroupInfo f167970d;

    public k(ViewGroup r100, ViewGroup r101, TextView r102, GroupInfo r103) {
        this.f167967a = r100;
        this.f167968b = r101;
        this.f167969c = r102;
        this.f167970d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Disposable r111 = (Disposable) r110;
        ViewGroup r112 = this.f167967a;
        ViewGroup r100 = this.f167968b;
        TextView r101 = this.f167969c;
        GroupInfo r102 = this.f167970d;
        r101.setVisibility(0);
        SpannableStringBuilder r103 = new SpannableStringBuilder();
        int r104 = r102.getGroupSize();
        int r105 = r102.getJoined();
        if (r105 != 0) goto L5;
        SpannableString r113 = new SpannableString(ag4.a.a(R.string.shopping_pdp_group_none_desc, CollectionsKt.listOf(Integer.valueOf(r104))));
        r113.setSpan(new ForegroundColorSpan(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED)), 0, String.valueOf(r104).length() + 1, 17);
        r103.append(r113);
    L8:
        r101.setText(r103);
        Intrinsics.checkNotNullParameter(r102, "groupInfo");
        if (r102.getJoined() > 0) goto L11;
    L13:
        Drawable r106 = com.bytedance.commerce.base.drawable.a.a(DoExpandGroupAnimKt$generateGroupDescriptionBg$2.INSTANCE);
    L14:
        Intrinsics.checkNotNullParameter(r101, "$this$setBackgroundCompat");
        r101.setBackground(r106);
        Intrinsics.checkNotNullParameter(r112, "parent");
        Intrinsics.checkNotNullParameter(r100, "sibling");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        int r114 = r112.getMeasuredWidth();
        int r107 = r100.getMeasuredWidth();
        float r108 = r101.getPaint().measureText(r101.getText().toString());
        int r115 = (r114 - r107) - (r101.getPaddingRight() * 2);
    L16:
        if (r115 >= r108) goto L24;
        float r109 = r101.getTextSize() - UIUtils.sp2px(r101.getContext(), 1.0f);
        if (r109 < 0) goto L19;
        r101.setTextSize(0, r109);
        r108 = r101.getPaint().measureText(r101.getText().toString());
        goto L16
    L19:
        r101.setVisibility(8);
        return;
    L24:
        return;
    L11:
        if (r102.getJoined() < r102.getGroupSize()) goto L13;
        r106 = com.bytedance.commerce.base.drawable.a.a(DoExpandGroupAnimKt$generateGroupDescriptionBg$1.INSTANCE);
        goto L14
    L5:
        if (r105 >= r104) goto L7;
        int r116 = r104 - r105;
        SpannableString r117 = new SpannableString(ag4.a.a(R.string.shopping_pdp_group_incomplete_desc, CollectionsKt.listOf(Integer.valueOf(r116))));
        r117.setSpan(new ForegroundColorSpan(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED)), 2, (String.valueOf(r116).length() + 2) + 1, 17);
        r103.append(r117);
        goto L8
    L7:
        SpannableString r118 = new SpannableString(ag4.a.d(R.string.shopping_pdp_group_complete_desc));
        r118.setSpan(new ForegroundColorSpan(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED)), 0, r118.length(), 17);
        r103.append(r118);
        goto L8
    }
}
