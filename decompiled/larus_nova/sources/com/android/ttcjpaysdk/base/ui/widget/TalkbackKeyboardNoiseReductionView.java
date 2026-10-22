package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.settings.bean.InsuranceConfiguration;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayFontUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.larus.nova.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/TalkbackKeyboardNoiseReductionView;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTalkbackKeyboardView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getKeyboard", "", "insuranceConfiguration", "Lcom/android/ttcjpaysdk/base/settings/bean/InsuranceConfiguration;", "getLayoutId", "showDone", "", "showInsurance", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TalkbackKeyboardNoiseReductionView extends CJPayTalkbackKeyboardView {
    private final Context mContext;

    public TalkbackKeyboardNoiseReductionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, null, 0, 6, null);
    }

    public TalkbackKeyboardNoiseReductionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, r101, 0, 4, null);
    }

    @Override // com.android.ttcjpaysdk.base.ui.widget.CJPayTalkbackKeyboardView
    public int getLayoutId() {
        return R.layout.cj_pay_view_keyboard_noise_reduction;
    }

    @Override // com.android.ttcjpaysdk.base.ui.widget.CJPayTalkbackKeyboardView
    public void showDone() {
        super.showDone();
        RelativeLayout r100 = getMKeyboardTitleLayout();
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
    L6:
        if (r101 == null) goto L9;
        r101.height = CJPayBasicUtils.dipToPX(getContext(), 26.0f);
    L9:
        ImageView r102 = getInsuranceImage();
        if (r102 == null) goto L12;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        int r104 = CJPayBasicUtils.dipToPX(getContext(), 6.0f);
        ((RelativeLayout.LayoutParams) r103).topMargin = r104;
    L12:
        LinearLayout r105 = getMFirstLayout();
        if (r105 == null) goto L15;
        r105.setPadding(0, CJPayBasicUtils.dipToPX(getContext(), 6.0f), 0, 0);
    L15:
        TextView r106 = getDoneTextView();
        if (r106 == null) goto L18;
        r106.setPadding(r106.getPaddingLeft(), CJPayBasicUtils.dipToPX(getContext(), 2.0f), r106.getPaddingRight(), r106.getPaddingBottom());
        CJPayFakeBoldUtils.fakeBold(r106);
    L18:
        postInvalidate();
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.ui.widget.CJPayTalkbackKeyboardView
    public void showInsurance() {
        super.showInsurance();
        InsuranceConfiguration r100 = getInsuranceConfiguration();
        if (r100 != null) goto L5;
    L27:
        RelativeLayout r101 = getMKeyboardTitleLayout();
        if (r101 == null) goto L31;
        r101.setVisibility(8);
    L31:
        postInvalidate();
        return;
    L5:
        if (r100.show == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        ViewGroup.LayoutParams r103 = null;
        if (r102 == true) goto L14;
        r100 = null;
    L14:
        if (r100 == null) goto L27;
        RelativeLayout r104 = getMKeyboardTitleLayout();
        if (r104 == null) goto L18;
        r103 = r104.getLayoutParams();
    L18:
        if (r103 == null) goto L21;
        r103.height = CJPayBasicUtils.dipToPX(getContext(), 24.0f);
    L21:
        ImageView r105 = getInsuranceImage();
        if (r105 == null) goto L24;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r106).topMargin = CJPayBasicUtils.dipToPX(getContext(), 4.0f);
    L24:
        LinearLayout r107 = getMFirstLayout();
        if (r107 == null) goto L31;
        r107.setPadding(0, CJPayBasicUtils.dipToPX(getContext(), 4.0f), 0, 0);
        goto L31
    L7:
        if (TextUtils.isEmpty(getKeyboard(r100)) == true) goto L9;
        r102 = true;
        goto L10
    }

    @Override // com.android.ttcjpaysdk.base.ui.widget.CJPayTalkbackKeyboardView
    public String getKeyboard(InsuranceConfiguration r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.unified_keyboard_icon;
    }

    public TalkbackKeyboardNoiseReductionView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
        this.mContext = r100;
        Iterator r103 = CollectionsKt.listOf(new TextView[]{getMLable1(), getMLable2(), getMLable3(), getMLable4(), getMLable5(), getMLable6(), getMLable7(), getMLable8(), getMLable9(), getMLable0(), getMLableX()}).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        CJPayFontUtils.setDouYinMediumTypeface(getContext(), (TextView) r103.next());
        goto L4
    L6:
        TextView r104 = getMLableX();
        if (r104 == null) goto L9;
        r104.setTextSize(1, 21.0f);
    L9:
        CJPayFakeBoldUtils.fakeBold(getMLableX());
        setCanVibrate(true);
    }

    public /* synthetic */ TalkbackKeyboardNoiseReductionView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
