package com.bytedanceos.common.ui.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.obric.oui.button.OButton;
import com.tmall.wireless.tangram.dataparser.concrete.Style;

/* JADX INFO: loaded from: classes2.dex */
public class StateView {
    public static final int TYPE_VIEW_EMPTY = 11;
    public static final int TYPE_VIEW_LOGIN = 12;
    public static final int TYPE_VIEW_RETRY = 10;

    public StateView() {
    }

    public static ViewGroup getStateView(ViewGroup r10) {
        ViewGroup r11 = (ViewGroup) View.inflate(r10.getContext(), R$layout.state_main, null);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r10.addView(r11, 0);
        r11.setVisibility(8);
        return r11;
    }

    private static View getStatueViewByViewStub(ViewGroup r10, int r11) {
        switch(r11) {
            case 10: goto L13;
            case 11: goto L9;
            case 12: goto L5;
            default: goto L3;
        };
    L3:
        j.a("unkwon type:" + r11);
        return null;
    L5:
        int r12 = R$id.state_login;
        View r13 = r10.findViewById(r12);
        if (r13 != null) goto L17;
        ((ViewStub) r10.findViewById(R$id.viewstub_login)).inflate();
        return r10.findViewById(r12);
    L17:
        return r13;
    L9:
        int r14 = R$id.state_empty;
        View r15 = r10.findViewById(r14);
        if (r15 != null) goto L18;
        ((ViewStub) r10.findViewById(R$id.viewstub_empty)).inflate();
        return r10.findViewById(r14);
    L18:
        return r15;
    L13:
        int r16 = R$id.state_retry;
        View r17 = r10.findViewById(r16);
        if (r17 != null) goto L19;
        ((ViewStub) r10.findViewById(R$id.viewstub_retry)).inflate();
        return r10.findViewById(r16);
    L19:
        return r17;
    }

    public static void hideStateView(ViewGroup r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getVisibility() != 0) goto L8;
        r10.setVisibility(8);
        return;
    }

    private static void setStateViewAllInvisible(ViewGroup r10) {
        View r11 = r10.findViewById(R$id.state_loading);
        if (r11.getVisibility() == 8) goto L5;
        r11.setVisibility(8);
    L5:
        View r12 = getStatueViewByViewStub(r10, 10);
        if (r12.getVisibility() == 8) goto L8;
        r12.setVisibility(8);
    L8:
        View r13 = getStatueViewByViewStub(r10, 11);
        if (r13.getVisibility() == 8) goto L11;
        r13.setVisibility(8);
    L11:
        View r14 = getStatueViewByViewStub(r10, 12);
        if (r14.getVisibility() == 8) goto L15;
        r14.setVisibility(8);
        return;
    }

    private static void showEmptyView(ViewGroup r10, String r11, String r12, String r13, View.OnClickListener r14, int... r15) {
    }

    public static void showEmptyViewForJump(ViewGroup r10, String r11, String r12, View.OnClickListener r13, int r14) {
        showEmptyView(r10, r11, null, r12, r13, new int[]{r14});
    }

    public static ViewGroup showLoadingView(ViewGroup r10) {
        setStateViewAllInvisible(r10);
        r10.findViewById(R$id.state_loading).setVisibility(0);
        if (r10.getVisibility() == 0) goto L5;
        r10.setVisibility(0);
    L5:
        return r10;
    }

    public static ViewGroup showLoginView(ViewGroup r10, String r11, View.OnClickListener r12, int r13) {
        setStateViewAllInvisible(r10);
        getStatueViewByViewStub(r10, 12).setVisibility(0);
        View r14 = r10.findViewById(R$id.state_login);
        r14.setVisibility(0);
        if (r13 == (-1)) goto L7;
        ImageView r15 = (ImageView) r14.findViewById(R$id.icon);
        if (r15 == null) goto L7;
        r15.setVisibility(0);
        r15.setImageResource(r13);
    L7:
        ((TextView) r14.findViewById(R$id.message)).setText(r11);
        int r16 = R$id.empty_login_btn;
        OButton r17 = (OButton) r14.findViewById(r16);
        r17.setId(r16);
        r17.setText(R$string.login_ok);
        r17.setOnClickListener(r12);
        if (r10.getVisibility() == 0) goto L10;
        r10.setVisibility(0);
    L10:
        return r10;
    }

    public static ViewGroup showRefreshView(ViewGroup r10, View.OnClickListener r11) {
        setStateViewAllInvisible(r10);
        getStatueViewByViewStub(r10, 10).setVisibility(0);
        r10.findViewById(R$id.refresh_btn).setOnClickListener(r11);
        View r12 = r10.findViewById(R$id.retry_connection);
        if ((r12 instanceof TextView) == false) goto L9;
        if (e.A0(r10.getContext()) == true) goto L7;
        ((TextView) r12).setText(R$string.retry_connection);
        goto L9
    L7:
        ((TextView) r12).setText(R$string.data_error_pls_try_later);
    L9:
        if (r10.getVisibility() == 0) goto L11;
        r10.setVisibility(0);
    L11:
        return r10;
    }

    private static void updateActionButtonLayoutParams(TextView r10) {
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10.getLayoutParams();
        r11.width = Style.dp2px(163.3d);
        r11.height = Style.dp2px(43.0d);
        r11.topMargin = Style.dp2px(45.0d);
        int r12 = Style.dp2px(54.0d);
        r11.rightMargin = r12;
        r11.leftMargin = r12;
        r10.setLayoutParams(r11);
    }

    public static void showEmptyView(ViewGroup r10, String r11, String r12, int... r13) {
        showEmptyView(r10, r11, r12, null, null, r13);
    }
}
