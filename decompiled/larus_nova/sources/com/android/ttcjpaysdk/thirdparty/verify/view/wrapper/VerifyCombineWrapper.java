package com.android.ttcjpaysdk.thirdparty.verify.view.wrapper;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.widget.FakeBoldColorSpan;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J4\u0010\u0015\u001a\u00020\u00132\u001a\u0010\u0016\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/VerifyCombineWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "payInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "(Landroid/view/View;Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;)V", "combineLayout", "Landroid/widget/LinearLayout;", "combineLayoutRoot", "itemTextSize", "", "lineSpacing", "", "marginBottom", "marginTop", "getPayInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "hideWrapper", "", "initData", "setCombineViews", "combineList", "", "Lkotlin/Pair;", "", "textColor", "setMarginBottom", "top", "setMarginTop", "setTextSize", "size", "showWrapper", "updateWithExpandedCombineData", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyCombineWrapper extends BaseWrapper {
    private final LinearLayout combineLayout;
    private final View combineLayoutRoot;
    private float itemTextSize;
    private int lineSpacing;
    private int marginBottom;
    private int marginTop;
    private final CJPayPayInfo payInfo;

    public final void hideWrapper() {
        View r100 = this.combineLayoutRoot;
        if (r100 == null) goto L7;
        r100.setVisibility(8);
        return;
    }

    public final void initData() {
        LinearLayout r100 = this.combineLayout;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        CJPayPayInfo r101 = this.payInfo;
        if (r101 == null) goto L13;
        ArrayList<CJPayPayInfo.CombineShowInfo> r102 = r101.combine_show_info;
        if (r102 == null) goto L13;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L11:
        if (r104.hasNext() == false) goto L14;
        CJPayPayInfo.CombineShowInfo r105 = (CJPayPayInfo.CombineShowInfo) r104.next();
        r103.add(TuplesKt.to(r105.combine_type, r105.combine_msg));
    L14:
        setCombineViews$default(this, r103, getContext().getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_90), 0.0f, 4, null);
        return;
    L13:
        r103 = null;
        goto L14
    }

    public final void showWrapper() {
        View r100 = this.combineLayoutRoot;
        if (r100 == null) goto L7;
        r100.setVisibility(0);
        return;
    }

    public final void updateWithExpandedCombineData() {
        LinearLayout r100 = this.combineLayout;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        CJPayPayInfo r101 = this.payInfo;
        if (r101 == null) goto L24;
        ArrayList<CJPayPayInfo.CombineShowInfo> r102 = r101.combine_show_info;
        if (r102 == null) goto L24;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L11:
        if (r104.hasNext() == false) goto L25;
        CJPayPayInfo.CombineShowInfo r105 = (CJPayPayInfo.CombineShowInfo) r104.next();
        String r106 = r105.combine_type;
        String r107 = r105.expand_combine_msg;
        boolean r108 = false;
        if (r107 != null) goto L15;
    L20:
        if (r108 == false) goto L22;
        String r109 = r105.expand_combine_msg;
    L23:
        r103.add(TuplesKt.to(r106, r109));
        goto L11
    L22:
        r109 = r105.combine_msg;
        goto L23
    L15:
        if (r107.length() <= 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 != true) goto L20;
        r108 = true;
        goto L20
    L17:
        r110 = false;
    L25:
        setCombineViews(r103, getContext().getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_50), 13.0f);
        return;
    L24:
        r103 = null;
        goto L25
    }

    public final CJPayPayInfo getPayInfo() {
        return this.payInfo;
    }

    public final void setMarginBottom(int r100) {
        this.marginBottom = r100;
    }

    public final void setMarginTop(int r100) {
        this.marginTop = r100;
    }

    public final void setTextSize(float r100) {
        this.itemTextSize = r100;
    }

    public VerifyCombineWrapper(View r100, CJPayPayInfo r101) {
        super(r100);
        this.payInfo = r101;
        LinearLayout r102 = null;
        if (r100 == null) goto L5;
        View r103 = r100.findViewById(R.id.cj_pay_view_verify_combine_info_layout);
    L6:
        this.combineLayoutRoot = r103;
        if (r100 == null) goto L9;
        r102 = (LinearLayout) r100.findViewById(R.id.verify_combine_layout);
    L9:
        this.combineLayout = r102;
        this.lineSpacing = CJPayBasicExtensionKt.dip2px(4.0f, getContext());
        this.itemTextSize = 12.0f;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setCombineViews(List<Pair<String, String>> r110, int r111, float r210) {
        if (r110 == null) goto L60;
        Iterator<T> r100 = r110.iterator();
        int r101 = 0;
    L6:
        if (r100.hasNext() == false) goto L71;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Pair r104 = (Pair) r102;
        View r105 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_view_verify_combine_item_layout, null);
        TextView r106 = (TextView) r105.findViewById(R.id.verify_combine_item_type);
        if (r106 == null) goto L13;
        r106.setText((CharSequence) r104.getFirst());
        r106.setTextColor(r111);
        r106.setTextSize(2, r210);
    L13:
        TextView r107 = (TextView) r105.findViewById(R.id.verify_combine_item_msg);
        r107.setTextColor(r111);
        r107.setTextSize(2, r210);
        CharSequence r108 = (String) r104.getSecond();
        r107.setText(r108);
        r108.length();
        int r112 = r108.length();
        int r113 = 0;
    L15:
        if (r113 >= r112) goto L23;
        if (r108.charAt(r113) != '$') goto L19;
        boolean r109 = true;
    L20:
        if (r109 == true) goto L24;
        r113 = r113 + 1;
    L24:
        int r114 = r108.length() - 1;
        if (r114 < 0) goto L35;
    L26:
        int r115 = r114 - 1;
        if (r108.charAt(r114) != '$') goto L29;
        boolean r116 = true;
    L30:
        if (r116 == true) goto L36;
        if (r115 < 0) goto L35;
        r114 = r115;
    L36:
        if (r113 == (-1)) goto L48;
        if (r113 == r114) goto L48;
        StringBuilder r117 = new StringBuilder();
        int r118 = r108.length();
        int r119 = 0;
    L39:
        if (r119 >= r118) goto L47;
        char r120 = r108.charAt(r119);
        if (r120 == '$') goto L43;
        boolean r121 = true;
    L44:
        if (r121 == false) goto L46;
        r117.append(r120);
    L46:
        r119 = r119 + 1;
        goto L39
    L43:
        r121 = false;
        goto L44
    L47:
        SpannableString r122 = new SpannableString(r117.toString());
        r122.setSpan(new FakeBoldColorSpan(0.0f, r107.getContext().getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_60), 1, null), r113, r114 - 1, 33);
        r108 = r122;
    L48:
        r107.setText(r108);
        if (r101 != 0) goto L51;
        int r123 = this.marginTop;
    L53:
        if (r101 != (r110.size() - 1)) goto L55;
        int r124 = this.marginBottom;
    L56:
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(-1, -2);
        r125.setMargins(0, r123, 0, r124);
        r105.setLayoutParams(r125);
        LinearLayout r126 = this.combineLayout;
        if (r126 == null) goto L59;
        r126.addView(r105);
    L59:
        r101 = r103;
        goto L6
    L55:
        r124 = 0;
        goto L56
    L51:
        r123 = this.lineSpacing;
        goto L53
    L29:
        r116 = false;
    L35:
        r114 = -1;
        goto L36
    L19:
        r109 = false;
        goto L20
    L23:
        r113 = -1;
        goto L24
    L71:
        return;
    }

    public static /* synthetic */ void setCombineViews$default(VerifyCombineWrapper r100, List r101, int r102, float r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = 12.0f;
    L5:
        r100.setCombineViews(r101, r102, r103);
    }
}
