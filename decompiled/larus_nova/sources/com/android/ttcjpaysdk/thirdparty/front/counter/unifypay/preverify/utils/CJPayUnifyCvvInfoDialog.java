package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/utils/CJPayUnifyCvvInfoDialog;", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayFadeAnimationDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "themeResId", "", "enableStdThemePatch", "", "(Landroid/content/Context;IZ)V", "contentTextView", "Landroid/widget/TextView;", "dividerView", "Landroid/view/View;", "singleBtn", "titleTextView", "applyStdThemePatchIfNeeded", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayUnifyCvvInfoDialog extends CJPayFadeAnimationDialog {
    private final TextView contentTextView;
    private final View dividerView;
    private final boolean enableStdThemePatch;
    private final TextView singleBtn;
    private final TextView titleTextView;

    public CJPayUnifyCvvInfoDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, 0, false, 6, null);
    }

    public CJPayUnifyCvvInfoDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, false, 4, null);
    }

    private final void applyStdThemePatchIfNeeded() {
        if (this.enableStdThemePatch == true) goto L5;
        return;
    L5:
        this.titleTextView.setTextColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_primary, R.color.cj_pay_color_black_161823));
        this.contentTextView.setTextColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_secondary, R.color.cj_pay_color_gray_161823_opacity_75));
        this.dividerView.setBackgroundColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_border_divider_grey_color, R.color.cj_pay_color_cashdesk_divider));
        this.singleBtn.setTextColor(CJPayThemeUtils.getColor(getContext(), R.attr.cj_pay_text_primary, R.color.cj_pay_color_black_161823));
    }

    public CJPayUnifyCvvInfoDialog(Context r100, int r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false, 4, null);
        this.enableStdThemePatch = r110;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_cvv_info_dialog_layout, null);
        setContentView(r102);
        Window r111 = getWindow();
        if (r111 == null) goto L5;
        r111.setLayout(CJPayBasicExtensionKt.dp(280), -2);
    L5:
        setCancelable(false);
        TextView r112 = (TextView) r102.findViewById(R.id.cj_pay_cvv_dialog_title);
        this.titleTextView = r112;
        TextView r103 = (TextView) r102.findViewById(R.id.cj_pay_cvv_dialog_content);
        this.contentTextView = r103;
        this.dividerView = r102.findViewById(R.id.cj_pay_cvv_dialog_divider);
        TextView r104 = (TextView) r102.findViewById(R.id.cj_pay_cvv_dialog_btn_view);
        this.singleBtn = r104;
        r112.setText(r100.getResources().getString(R.string.cj_pay_verify_cvv_info));
        r103.setText(r100.getResources().getString(R.string.cj_pay_cvv_example_page_tips));
        r104.setText(r100.getResources().getString(R.string.cj_pay_unify_i_know));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r104, new AnonymousClass1(this));
        CJPayFakeBoldUtils.fakeBold(r112);
        CJPayFakeBoldUtils.fakeBold(r104);
        applyStdThemePatchIfNeeded();
    }

    public /* synthetic */ CJPayUnifyCvvInfoDialog(Context r100, int r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = R.style.CJ_Pay_Dialog_With_Layer;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        this(r100, r101, r102);
    }
}
