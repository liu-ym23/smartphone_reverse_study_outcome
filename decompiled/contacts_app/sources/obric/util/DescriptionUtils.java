package obric.util;

import android.view.View;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class DescriptionUtils {
    public DescriptionUtils() {
    }

    public static boolean applyDescriptionIfNeed(View target, int resId) {
        boolean r1 = false;
        if (resId != R.drawable.standard_icon_back_selector) goto L5;
    L87:
        String r4 = target.getResources().getString(R.string.smt_back);
    L88:
        if (target == null) goto L91;
        if (r4 == null) goto L91;
        target.setContentDescription(r4);
    L91:
        return r1;
    L5:
        if (resId == R.drawable.standard_icon_back_reverse_selector) goto L87;
        if (resId != R.drawable.standard_icon_cancel_selector) goto L10;
    L86:
        r4 = target.getResources().getString(R.string.smt_cancel);
        goto L88
    L10:
        if (resId == R.drawable.standard_icon_cancel_reverse_selector) goto L86;
        if (resId != R.drawable.standard_icon_complete_selector) goto L15;
    L85:
        r4 = target.getResources().getString(R.string.smt_done);
        goto L88
    L15:
        if (resId == R.drawable.standard_icon_complete_reverse_selector) goto L85;
        if (resId != R.drawable.standard_icon_hignlight_confirm_selector) goto L20;
    L83:
        r4 = target.getResources().getString(R.string.smt_done);
    L84:
        r1 = true;
        goto L88
    L20:
        if (resId == R.drawable.standard_icon_hignlight_confirm_reverse_selector) goto L83;
        if (resId != R.drawable.standard_icon_common_add_selector) goto L25;
    L82:
        r4 = target.getResources().getString(R.string.smt_add);
        goto L88
    L25:
        if (resId == R.drawable.standard_icon_common_add_reverse_selector) goto L82;
        if (resId != R.drawable.standard_icon_settings_selector) goto L30;
    L81:
        r4 = target.getResources().getString(R.string.smt_settings);
        goto L88
    L30:
        if (resId == R.drawable.standard_icon_settings_reverse_selector) goto L81;
        if (resId != R.drawable.standard_icon_edit_selector) goto L35;
    L80:
        r4 = target.getResources().getString(R.string.smt_modify);
        goto L88
    L35:
        if (resId == R.drawable.standard_icon_edit_reverse_selector) goto L80;
        if (resId != R.drawable.standard_icon_hignlight_edit_selector) goto L40;
    L79:
        r4 = target.getResources().getString(R.string.smt_modify);
        goto L84
    L40:
        if (resId == R.drawable.standard_icon_hignlight_edit_reverse_selector) goto L79;
        if (resId != R.drawable.standard_icon_multi_select_selector) goto L45;
    L78:
        r4 = target.getResources().getString(R.string.smt_edit);
        goto L88
    L45:
        if (resId == R.drawable.standard_icon_multi_select_reverse_selector) goto L78;
        if (resId != R.drawable.standard_icon_hignlight_multi_select_selector) goto L50;
    L77:
        r4 = target.getResources().getString(R.string.smt_edit);
        goto L84
    L50:
        if (resId == R.drawable.standard_icon_hignlight_multi_select_reverse_selector) goto L77;
        if (resId != R.drawable.standard_icon_hignlight_delete_selector) goto L55;
    L76:
        r4 = target.getResources().getString(R.string.smt_delete);
        goto L84
    L55:
        if (resId == R.drawable.standard_icon_hignlight_delete_reverse_selector) goto L76;
        if (resId != R.drawable.standard_icon_sorting_selector) goto L60;
    L75:
        r4 = target.getResources().getString(R.string.smt_sorting);
        goto L88
    L60:
        if (resId == R.drawable.standard_icon_sorting_reverse_selector) goto L75;
        if (resId != R.drawable.standard_icon_filter_selector) goto L65;
    L74:
        r4 = target.getResources().getString(R.string.smt_filter);
        goto L88
    L65:
        if (resId == R.drawable.standard_icon_filter_reverse_selector) goto L74;
        if (resId != R.drawable.standard_icon_share_selector) goto L70;
    L73:
        r4 = target.getResources().getString(R.string.smt_share);
        goto L88
    L70:
        if (resId == R.drawable.standard_icon_share_reverse_selector) goto L73;
        r4 = null;
        goto L88
    }
}
